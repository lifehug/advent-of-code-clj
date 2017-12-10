(ns aoc-2017.day2-test
  (:require [clojure.test :refer :all]
            [aoc-2017.day2 :refer :all]
            [clojure.string :refer [split-lines]]))

(def spreadsheet (-> "input/day2.txt" slurp split-lines))

(deftest min-and-max-test
  (testing "get the min and max"
   (is (= 8 (min-and-max "5 1 9 5" )))))

(deftest checksum-test
  (testing "checksum test"
   (is (= 18 (checksum  min-and-max ["5 1 9 5" "7 5 3" "2 4 6 8"])))))

(deftest checksum-aoc
  (testing "checksum aoc"
   (is (= 46402 (checksum min-and-max spreadsheet)))))

(deftest divisible-test
  (testing "test divisibility"
   (is (= 4 (divisible  "5 9 2 8" )))))

(deftest checksum'-test
  (testing "checksum' test"
   (is (= 9 (checksum divisible ["5 9 2 8" "9 4 7 3" "3 8 6 5"])))))

(deftest checksum'-aoc
  (testing "checksum' aoc"
   (is (= 265 (checksum divisible spreadsheet)))))
