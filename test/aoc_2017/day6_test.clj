(ns aoc-2017.day6-test
  (:require [clojure.test :refer :all]
   [aoc-2017.day6 :refer :all]
   [clojure.string :refer [split split-lines]]))

(defn mold [b] (->> b (map #(Integer. %))))

(def banks (-> "input/day6.txt" slurp (split #"\s+") mold vec))

(deftest banks-test
   (is (= 5 5)))

