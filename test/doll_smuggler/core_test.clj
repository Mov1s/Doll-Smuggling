(ns doll-smuggler.core-test
  (:require [clojure.test :refer :all]
            [doll-smuggler.core :refer :all]))



(deftest formatdolls-test
  (testing "Format doll info into doll list."
    (def dolls '( luke 9 150
                  anthony 13 35))
    (def formatted '( {:name luke :weight 9 :value 150}
                      {:name anthony :weight 13 :value 35}))
    (is (= (format-dolls dolls) formatted))))



(deftest solution-test
  (testing "Finds the optimal doll combination for a given weight"
    (def dolls (format-dolls '( luke 9 150
                	  	          anthony 13 35
              		              candice 153 200
                                dorothy 50 160
                                puppy 15 60
                                thomas 68 45
                                randal 27 60
                                april 39 40
                                nancy 23 30
                                bonnie 52 10
                                marc 11 70
                                kate 32 30
                                tbone 24 15
                                tranny 48 10
                                uma 73 40
                                grumpkin 42 70
                                dusty 43 75
                                grumpy 22 80
                                eddie 7 20
                                tory 18 12
                                sally 4 50
                                babe 30 10)))

    (def solution (format-dolls '( luke 9 150
                                   anthony 13 35
                                   candice 153 200
                                   dorothy 50 160
                                   puppy 15 60
                                   randal 27 60
                                   marc 11 70
                                   grumpkin 42 70
                                   dusty 43 75
                                   grumpy 22 80
                                   eddie 7 20
                                   sally 4 50)))

    (is (= (knapsack 400 dolls) solution))))



  (deftest zeroitems-test
  (testing "Makes sure no items doesn't bomb"
    (def dolls (format-dolls '( )))

    (def solution (format-dolls '( )))

    (is (= (knapsack 400 dolls) solution))))



  (deftest zeroweight-test
  (testing "Makes sure no weight doesn't bomb"
    (def dolls (format-dolls '( luke 9 150
                                anthony 13 35
                                candice 153 200
                                dorothy 50 160
                                puppy 15 60
                                thomas 68 45
                                randal 27 60
                                april 39 40
                                nancy 23 30
                                bonnie 52 10
                                marc 11 70
                                kate 32 30
                                tbone 24 15
                                tranny 48 10
                                uma 73 40
                                grumpkin 42 70
                                dusty 43 75
                                grumpy 22 80
                                eddie 7 20
                                tory 18 12
                                sally 4 50
                                babe 30 10)))

    (def solution (format-dolls '( )))

    (is (= (knapsack 0 dolls) solution))))



  (deftest solution1-test
    (testing "Finds the optimal doll combination for a given weight"
      (def dolls (format-dolls '( luke 1 1
                                  anthony 2 2
                                  candice 2 3
                                  dorothy 2 4
                                  puppy 2 5)))

    (def solution (format-dolls '( luke 1 1 )))

    (is (= (knapsack 1 dolls) solution))))



  (deftest solution2-test
    (testing "Finds the optimal doll combination for a given weight"
      (def dolls (format-dolls '( luke 1 1
                                  anthony 2 2
                                  candice 2 3
                                  dorothy 2 4
                                  puppy 2 5)))

    (def solution (format-dolls '( puppy 2 5 )))

    (is (= (knapsack 2 dolls) solution))))



  (deftest solution3-test
    (testing "Finds the optimal doll combination for a given weight"
      (def dolls (format-dolls '( luke 1 1
                                  anthony 2 2
                                  candice 2 3
                                  dorothy 2 4
                                  puppy 2 5)))

    (def solution (format-dolls '( luke 1 1
                                   puppy 2 5)))

    (is (= (knapsack 3 dolls) solution))))



  (deftest solution4-test
    (testing "Finds the optimal doll combination for a given weight"
      (def dolls (format-dolls '( luke 1 1
                                  anthony 2 2
                                  candice 2 3
                                  dorothy 2 4
                                  puppy 2 5)))

    (def solution (format-dolls '( dorothy 2 4
                                   puppy 2 5)))

    (is (= (knapsack 4 dolls) solution))))



  (deftest solution5-test
    (testing "Finds the optimal doll combination for a given weight"
      (def dolls (format-dolls '( luke 1 1
                                  anthony 2 2
                                  candice 2 3
                                  dorothy 2 4
                                  puppy 2 5)))

    (def solution (format-dolls '( luke 1 1
                                   dorothy 2 4
                                   puppy 2 5)))

    (is (= (knapsack 5 dolls) solution))))



  (deftest solution6-test
    (testing "Finds the optimal doll combination for a given weight"
      (def dolls (format-dolls '( luke 1 1
                                  anthony 2 2
                                  candice 2 3
                                  dorothy 2 4
                                  puppy 2 5)))

    (def solution (format-dolls '( candice 2 3
                                   dorothy 2 4
                                   puppy 2 5)))

    (is (= (knapsack 6 dolls) solution))))



  (deftest solution7-test
    (testing "Finds the optimal doll combination for a given weight"
      (def dolls (format-dolls '( luke 1 1
                                  anthony 2 2
                                  candice 2 3
                                  dorothy 2 4
                                  puppy 2 5)))

    (def solution (format-dolls '( luke 1 1
                                   candice 2 3
                                   dorothy 2 4
                                   puppy 2 5)))

    (is (= (knapsack 7 dolls) solution))))



  (deftest solution8-test
    (testing "Finds the optimal doll combination for a given weight"
      (def dolls (format-dolls '( luke 1 1
                                  anthony 2 2
                                  candice 2 3
                                  dorothy 2 4
                                  puppy 2 5)))

    (def solution (format-dolls '( anthony 2 2
                                   candice 2 3
                                   dorothy 2 4
                                   puppy 2 5)))

    (is (= (knapsack 8 dolls) solution))))



  (deftest solution9-test
    (testing "Finds the optimal doll combination for a given weight"
      (def dolls (format-dolls '( luke 1 1
                                  anthony 2 2
                                  candice 2 3
                                  dorothy 2 4
                                  puppy 2 5)))

    (def solution (format-dolls '( luke 1 1
                                  anthony 2 2
                                  candice 2 3
                                  dorothy 2 4
                                  puppy 2 5)))

    (is (= (knapsack 9 dolls) solution))))
