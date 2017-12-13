(ns aoc-2017.day3-test
  (:require [clojure.test :refer :all]
            [aoc-2017.day3 :refer :all]))

(deftest first-test
    (testing "distance"
      (let [ expected [[0 0 0 0 0] [0 5 4 2 0] [0 0 1 1 0] [0 0 0 0 0][0 0 0 0 0]]
             given [[0 0 0 0 0] [0 0 4 2 0] [0 0 1 1 0] [0 0 0 0 0][0 0 0 0 0]]]
            (is (= expected (sum-neighbors given [1 1]))))))

(deftest next-step-test
    (testing "go down"
      (let [ given [[0 0 0 0 0] 
                    [0 5 4 2 0] 
                    [0 0 1 1 0] 
                    [0 0 0 0 0] 
                    [0 0 0 0 0]]]
            (is (= [1 2] (next-position given [1 1]))))))
