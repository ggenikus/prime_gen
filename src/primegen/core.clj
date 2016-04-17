(ns primegen.core
  (:require [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

(defn- is-prime? [n nums]
  (and
    (not (contains? nums n))
    (every? #(not= (mod n %) 0) nums)))


(defn- gen-primes [nums acc num_to_gen]

  (if (and (seq nums) (<= (count acc) num_to_gen))

    (let [[n & rest_nums] nums]
      (if (is-prime? n acc)
        (recur rest_nums (conj acc n) num_to_gen)
        (recur rest_nums acc num_to_gen)))
    acc))

(defn- primes-interanl [n]
  (if (< n 1)
    []
    (let [primes_num (sorted-set 2)
          num_to_gen (dec n)
          odds (filter odd? (iterate inc 3))]
      (gen-primes odds primes_num num_to_gen))))

(def primes (memoize primes-interanl))


(defn multiplication-table [numbers]
  (map (fn [n] (map #(* n %) numbers)) numbers))

(defn cell-size [table]
  (->>
    (flatten table)
    (map str)
    (map count)
    (apply max)))

(defn gen-table-view [& {:keys [heading table cell-size spaces]}]
  {:pre [(pos? spaces) (pos? cell-size) (every? #(= (count heading) (count %)) table)]}
  (let [gen-spaces (fn [n] (apply str (take n (iterate str " "))))
        cell-size-spaced (+ cell-size spaces)
        gen-spaces-for (fn [number] (gen-spaces (- cell-size-spaced (count (str number)))))

        allign-row (fn [row] (apply str (map #(str % (gen-spaces-for %)) row)))

        header (str (gen-spaces cell-size-spaced)
                    (allign-row heading))

        rows (map #(cons %1 %2) heading table)

        alliigned-rows (map allign-row rows)]

    (clojure.string/join "\n" (cons header alliigned-rows))))


(defn- gen-table [n s]
  (let [prime_nums (primes n)
        multiplications (multiplication-table prime_nums)
        cell-len (cell-size multiplications)

        alligned-table (gen-table-view
                         :heading prime_nums
                         :table multiplications
                         :cell-size cell-len
                         :spaces s)]
    alligned-table))

(defn -main [& args]
  (let [{:keys [options summary]} (parse-opts args [["-h" "--help"]
                                                    ["-n" "--numbers NUMBERS" "Table of first n primes"
                                                     :default 10
                                                     :parse-fn #(Integer/parseInt %)
                                                     :validate [pos? "Must be positive number"]]

                                                    ["-s" "--spaces SPACES" "Spaces between cells"
                                                     :default 1
                                                     :parse-fn #(Integer/parseInt %)
                                                     :validate [pos? "Must be positive number"]]
                                                    ])
        {:keys [help numbers spaces]} options]
    (if help
      (println (str "This programm prints out a multiplication table of the first 10 prime numbers."
                    "\n"
                    "Options:"
                    "\n"
                    summary))
      (println (gen-table numbers spaces)))))










