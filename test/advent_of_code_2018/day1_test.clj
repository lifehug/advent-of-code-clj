(ns advent-of-code-2018.day1-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2018.day1 :refer :all]))
(def intstream (-> "input/day1.txt" slurp))

(deftest first-test
    (testing "three"
      (is (= 3 (captcha "1122")))))

(deftest second-test
    (testing "four"
      (is (= 4 (captcha "1111")))))

(deftest third-test
    (testing "zero"
      (is (= 0 (captcha "1234")))))

(deftest ninth-test
  (testing "nine"
    (is (= 9 (captcha "91212129")))))

(deftest aoc-dave
  (testing "aoc"
    (is (= 1171 (captcha-amir intstream)))))