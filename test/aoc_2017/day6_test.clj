(ns aoc-2017.day6-test
  (:require [clojure.test :refer :all]
   [aoc-2017.day6 :refer :all]
   [clojure.string :refer [split split-lines]]))

(defn mold [b] (->> b (map #(Integer. %))))

(def banks (-> "input/day6.txt" slurp (split #"\s+") mold vec))

(deftest banks-test (is (= [2 4 2 1] (disperse [0 2 7 0]))))

(deftest banks-test (is (= 5 (first (socialize {:b [0 2 7 0] :c [] :n 0})))))

(deftest banks-test 
  (let [v (socialize {:b banks :c [] :n 0})]
    (is (= 7864 (first v))
    (is (= 1695 (second v))))))
