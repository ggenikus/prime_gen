(ns primegen.core-test
  (:require [clojure.test :refer :all]
            [primegen.core :refer :all]))


(deftest primes-generateor-test

  (testing "Should be able to generate first n primes"
    (is (= #{2} (primes 1)))
    (is (= #{2 3 5 7 11} (primes 5)))
    (is (= #{2 3 5 7 11 13 17 19 23 29 31 37 41
             43 47 53 59 61 67 71 73 79 83 89 97
             101 103 107 109 113 127 131 137 139 149
             151 157 163 167 173 179 181 191 193 197
             199 211 223 227 229 233 239 241 251 257 263
             269 271 277 281 283 293 307 311 313 317 331
             337 347 349 353 359 367 373 379 383 389 397
             401 409 419 421 431 433 439 443 449 457 461
             463 467 479 487 491 499 503 509 521 523 541}

           (primes 100))))


  (testing "Should return empty when n < 1"
    (is (empty? (primes 0)))
    (is (empty? (primes -1)))))


(deftest multiplication-table-generator-test
  (testing "Should generate NxN matrinx of multiplications"
    (is (= [[0 0 0]
            [0 1 2]
            [0 2 4]] (multiplication-table (range 3))))))


(deftest cell-space-test
  (testing "Size of cell should be eq to size of biggest number"
    (is (= 4 (cell-size [[-1] [2 1111]])))
    (is (= 2 (cell-size [[-1 2] [2]])))))

(deftest table-view-test
  (testing "Should throw excpetion when params invalid"
    (is (thrown-with-msg? AssertionError #"pos\? spaces" (gen-table-view
                                                           :heading [1 1]
                                                           :table [[1 1] [1 1]]
                                                           :cell-size 1
                                                           :spaces -1
                                                           )))

    (is (thrown-with-msg? AssertionError #"pos\? cell-size" (gen-table-view
                                                              :heading [1 1]
                                                              :table [[1 1] [1 1]]
                                                              :cell-size 0
                                                              :spaces 1
                                                              )))

    (is (thrown-with-msg? AssertionError #"every\?" (gen-table-view
                                                      :heading [1 1 1]
                                                      :table [[1 1] [1 1]]
                                                      :cell-size 1
                                                      :spaces 1
                                                      )) "Rows should have the same size as heading"))


  (testing "Should generate prperly alligned table view"
    (is (= (str "    1   11  2   \n"
                "1   1   11  2   \n"
                "11  11  121 22  \n"
                "2   1   22  4   ")
           (gen-table-view :heading [1 11 2]
                           :table [[1 11 2]
                                   [11 121 22]
                                   [1 22 4]]
                           :cell-size 3
                           :spaces 1)))))



