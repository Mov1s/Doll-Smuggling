(ns doll-smuggler.core-test
  (:require [clojure.test :refer :all]
            [doll-smuggler.core :refer :all]))

(deftest formatdolls-test
  (testing "Format doll info into doll list."
    (def dolls '( luke 9 150
    		  anthony 13 35))
    (def formatted '( {:name luke :weight 9 :value 150}
                      {:name anthony :weight 13 :value 35}))
    (is (= (formatdolls dolls) formatted))))

(deftest a-test
  (testing "FIXME, I fail."
    (def dolls '( luke 9 150
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
                  babe 30 10))

    (def solution '( sally 4 50
                     eddie 7 20
 		     luke 9 150
                     marc 11 70
                     anthony 13 35
                     puppy 15 60
		     grumpy 22 80
		     randal 27 60
 		     grumpkin 42 70
		     dusty 43 75
 		     dorothy 50 160
		     candice 153 200))
                    
    (is (= (knapsack 400 dolls) solution))))
