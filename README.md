# prime_gen

Program that prints out a multiplication table of the first N prime numbers.

# Build

    lein uberjar

To check tests

    lein tests

#Usage

Print multiplication table of the first 10 prime numbers:

    java -jar target/prime_gen-0.1-standalone.jar

        2   3   5   7   11  13  17  19  23  29
    2   4   6   10  14  22  26  34  38  46  58
    3   6   9   15  21  33  39  51  57  69  87
    5   10  15  25  35  55  65  85  95  115 145
    7   14  21  35  49  77  91  119 133 161 203
    11  22  33  55  77  121 143 187 209 253 319
    13  26  39  65  91  143 169 221 247 299 377
    17  34  51  85  119 187 221 289 323 391 493
    19  38  57  95  133 209 247 323 361 437 551
    23  46  69  115 161 253 299 391 437 529 667
    29  58  87  145 203 319 377 493 551 667 841


Same thing for first 11 primes:

    java -jar target/prime_gen-0.1-standalone.jar -n11

        2   3   5   7   11  13  17  19  23  29  31
    2   4   6   10  14  22  26  34  38  46  58  62
    3   6   9   15  21  33  39  51  57  69  87  93
    5   10  15  25  35  55  65  85  95  115 145 155
    7   14  21  35  49  77  91  119 133 161 203 217
    11  22  33  55  77  121 143 187 209 253 319 341
    13  26  39  65  91  143 169 221 247 299 377 403
    17  34  51  85  119 187 221 289 323 391 493 527
    19  38  57  95  133 209 247 323 361 437 551 589
    23  46  69  115 161 253 299 391 437 529 667 713
    29  58  87  145 203 319 377 493 551 667 841 899
    31  62  93  155 217 341 403 527 589 713 899 961

Also, it is possible to configure spaces between cells:

    java -jar target/prime_gen-0.1-standalone.jar -s 2

         2    3    5    7    11   13   17   19   23   29
    2    4    6    10   14   22   26   34   38   46   58
    3    6    9    15   21   33   39   51   57   69   87
    5    10   15   25   35   55   65   85   95   115  145
    7    14   21   35   49   77   91   119  133  161  203
    11   22   33   55   77   121  143  187  209  253  319
    13   26   39   65   91   143  169  221  247  299  377
    17   34   51   85   119  187  221  289  323  391  493
    19   38   57   95   133  209  247  323  361  437  551
    23   46   69   115  161  253  299  391  437  529  667
    29   58   87   145  203  319  377  493  551  667  841

    java -jar target/prime_gen-0.1-standalone.jar -s 3

          2     3     5     7     11    13    17    19    23    29
    2     4     6     10    14    22    26    34    38    46    58
    3     6     9     15    21    33    39    51    57    69    87
    5     10    15    25    35    55    65    85    95    115   145
    7     14    21    35    49    77    91    119   133   161   203
    11    22    33    55    77    121   143   187   209   253   319
    13    26    39    65    91    143   169   221   247   299   377
    17    34    51    85    119   187   221   289   323   391   493
    19    38    57    95    133   209   247   323   361   437   551
    23    46    69    115   161   253   299   391   437   529   667
    29    58    87    145   203   319   377   493   551   667   841


For help:

    java -jar target/prime_gen-0.1-standalone.jar -h

    This programm prints out a multiplication table of the first 10 prime numbers.
    Options:
      -h, --help
      -n, --numbers NUMBERS  10  Table of first n primes
      -s, --spaces SPACES    1   Spaces between cells


