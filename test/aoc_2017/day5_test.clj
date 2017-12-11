(ns aoc-2017.day4-test
  (:require [clojure.test :refer :all]
            [aoc-2017.day4 :refer :all]
            [clojure.string :refer [split-lines]]))

(def passphrases (-> "input/day4.txt" slurp split-lines))

(deftest test-passphrasses-count
   (is (= 383 (valid-passes-count passphrases))))
