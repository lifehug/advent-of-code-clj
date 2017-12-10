(ns advent-of-code-2018.day1
  (:require [clojure.string :refer [split]]
            [clojure.tools.trace :refer [trace]]))

(defn captcha [s]
  (->> s
       (partition 2 1)
       (cons (list (first s) (last s)))
       (filter #(= (first %) (second %)))
       (map first)
       (map #(Character/digit % 10))
       (reduce +)))

(defn captcha' [s] 
  (->> (-> s count (/ 2) (drop s)) 
       (apply str)
       (map list s)
       (filter (fn [[a b]] (= a b)))
       (map (comp #(* 2 %) #(Character/digit % 10) first))
       (reduce +)))

