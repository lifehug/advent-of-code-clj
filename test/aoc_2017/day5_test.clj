(ns aoc-2017.day5-test
  (:require [clojure.test :refer :all]
   [aoc-2017.day5 :refer :all]
   [clojure.string :refer [split-lines]]))

(def steps (-> "input/day5.txt" slurp split-lines))

(deftest steps-test
   (is (= 5 (step' {:p 0 :c 0 :s [0 3 0 1 -3]}))))

(deftest steps-test-aoc
   (is (= 343467 (step steps))))

(deftest steps-test-aoc-with-dec
   (is (= 24774780 (step-dec steps))))

