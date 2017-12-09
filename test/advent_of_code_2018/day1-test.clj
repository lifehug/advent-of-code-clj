(ns advent-of-code-2018.day1-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2018.day1 :refer :all]))

(deftest first-test
    (testing "three"
      (is (= 3 (captcha "1122")))))
