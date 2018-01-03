(ns aoc-2015.day1-test
  (:require [clojure.test :refer :all]
            [aoc-2015.day1 :refer :all]))
(def intstream (-> "input/2015/day1.txt" slurp))

(deftest test-floor-level
    (testing "three"
      (is (= 3 (floor "))(((((")))))

