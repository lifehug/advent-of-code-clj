(ns aoc-2017.day3-test
  (:require [clojure.test :refer :all]
            [aoc-2017.day3 :refer :all]))

(deftest first-test
    (testing "distance"
      (let [ expected [[0 0 0 0 0] [0 5 4 2 0] [0 0 1 1 0] [0 0 0 0 0][0 0 0 0 0]]
             given [[0 0 0 0 0] [0 0 4 2 0] [0 0 1 1 0] [0 0 0 0 0][0 0 0 0 0]]]
            (is (= expected (update-square given [1 1]))))))

(deftest next-step-test-down
    (testing "go down"
      (let [ given [[0 0 0 0 0] 
                    [0 5 4 2 0] 
                    [0 0 1 1 0]
                    [0 0 0 0 0] 
                    [0 0 0 0 0]]]
            (is (= [1 2] (next-position given [1 1]))))))

(deftest next-step-test-down-2
    (testing "go down"
      (let [ given [[0 0 0 0 0] 
                    [0 5 4 2 0] 
                    [0 6 1 1 0]
                    [0 0 0 0 0] 
                    [0 0 0 0 0]]]
            (is (= [1 3] (next-position given [1 2]))))))

(deftest next-step-test-right
    (testing "go right"
      (let [ given [[0 0 0 0 0] 
                    [0 5 4 2 0] 
                    [0 6 1 1 0] 
                    [0 7 0 0 0] 
                    [0 0 0 0 0]]]
            (is (= [2 3] (next-position given [1 3]))))))

(deftest next-step-test-right-2
    (testing "go right"
      (let [ given [[0 0 0 0 0] 
                    [0 5 4 2 0] 
                    [0 6 1 1 0] 
                    [0 7 8 0 0] 
                    [0 0 0 0 0]]]
            (is (= [3 3] (next-position given [2 3]))))))

(deftest next-step-test-right-3
    (testing "go right"
      (let [ given [[0 0 0 0 0] 
                    [0 0 0 0 0] 
                    [0 0 1 0 0] 
                    [0 0 0 0 0] 
                    [0 0 0 0 0]]]
            (is (= [3 2] (next-position given [2 2]))))))

(deftest next-step-test-left-1
    (testing "go left"
      (let [ given [[0 0 0 0 0] 
                    [0 0 0 2 0] 
                    [0 0 1 1 0] 
                    [0 0 0 0 0] 
                    [0 0 0 0 0]]]
            (is (= [2 1] (next-position given [3 1]))))))

(deftest next-step-test-left-2
    (testing "go left"
      (let [ given [[0 0 0 0 0] 
                    [0 0 4 2 0] 
                    [0 0 1 1 0] 
                    [0 0 0 0 0] 
                    [0 0 0 0 0]]]
            (is (= [1 1] (next-position given [2 1]))))))

(deftest next-step-test-up
    (testing "go up"
      (let [ given [[0 0 0 0 0] 
                    [0 0 0 0 0] 
                    [0 0 1 1 0] 
                    [0 0 0 0 0] 
                    [0 0 0 0 0]]]
            (is (= [3 1] (next-position given [3 2]))))))

(deftest next-step-test-up-2
    (testing "go up"
      (let [ given [[0 0 0 0 0] 
                    [0 5 4 2 0] 
                    [0 10 1 1 0] 
                    [0 11 23 25 26] 
                    [0 0 0 0 0]]]
            (is (= [4 2] (next-position given [4 3]))))))

(deftest update-square-test
    (testing "update square"
      (let [ expected [[0 0 0 0 0] 
                       [0 0 0 0 0] 
                       [0 0 1 0 0] 
                       [0 0 0 0 0] 
                       [0 0 0 0 0]]]
            (is (= expected (-> 25 create-square (update-square [2 2])))))))

(deftest aoc-test-25
    (testing "test 25"
      (let [ given [[0 0 0 0 0] 
                    [0 5 4 2 0] 
                    [0 10 1 1 0] 
                    [0 11 23 25 26] 
                    [0 0 0 0 0]]]
            (is (= [26 given] (finish-him 25))))))

(deftest aoc-test
    (testing "test 347991"
            (is (= 349975 (first (finish-him 347991))))))
