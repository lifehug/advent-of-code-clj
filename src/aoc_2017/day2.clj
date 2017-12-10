(ns aoc-2017.day2
  (:require [clojure.string :refer [split]]
            [clojure.tools.trace :refer [trace]]))

(defn min-and-max' [c] [(apply max c) (apply min c)])

(defn dif [[x n]] (- x n))

(defn str->ints [s] (->> (-> s (split #"\s+")) (map #(Integer. %))))

(defn min-and-max [s] (-> s str->ints  min-and-max' dif))

(defn checksum [f l] (->> l (map f) (reduce +)))

(defn divisible' [v] (for [x v y v :let [r (rem x y)] :when (and (not= x y) (= r 0))] (/ x y)))

(defn divisible [s] (->> s str->ints divisible' first))

