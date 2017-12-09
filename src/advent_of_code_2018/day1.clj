(ns advent-of-code-2018.day1
  (:require [clojure.string :refer [split]]
            [clojure.tools.trace :refer [trace]]))

(defn tupleize [l] (->> (butlast l) 
                        (cons (last l)) 
                        (map (fn [x y] [x y]) l)))

(defn captcha [s]
  (->> s
       (partition 2 1)
       (cons (list (first s) (last s)))
       (filter #(= (first %) (second %)))
       (map first)
       (map #(Character/digit % 10))
       (reduce +)))

(defn to-digit [c] (- (int c) 48))

(defn captcha-amir
    [input]
      (->> input
           (cons (last input))
           (partition 2 1)
           (filter #(apply = %))
           (map (comp to-digit first))
           (apply +)))

(defn count-it
  "I don't do a whole lot."
  [coll]
  (->>
    coll
    (partition 2 1 coll)
    (reduce
      (fn [s [a b]]
        (if (= a b)
          (+ s (Character/digit a 10))
          s))
      0)))