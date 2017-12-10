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

(deftest aoc
  (testing "aoc"
    (is (= 1171 (captcha intstream)))))

(deftest part-two-one
  (testing "two one"
    (is (= 6 (captcha' "1212")))))

(deftest part-two-two
  (testing "two two"
    (is (= 0 (captcha' "1221")))))

(deftest part-two-three
  (testing "two three"
    (is (= 4 (captcha' "123425")))))

(deftest part-two-four
  (testing "two four"
    (is (= 12 (captcha' "123123")))))

(deftest part-two-five
  (testing "two five"
    (is (= 4 (captcha' "12131415")))))

(deftest part-aoc-two
  (testing "aoc two"
    (is (= 1024 (captcha' intstream)))))
