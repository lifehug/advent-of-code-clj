(ns aoc-2017.day6
  (:require [clojure.string :refer [split]]
            [clojure.tools.trace :refer [trace]]))

(defn cycle? [b c] (reduce #(if (= b (:b %2)) (reduced %2) false) false c))

(defn disperse [b]
  (let [max-val (apply max b)
        pos (reduce #(if (= %2 max-val) (reduced %1) (inc %1)) 0 b)
        zero (assoc b pos 0)
        d (reduce #(update %1 (mod (inc (+ pos %2)) (count zero)) inc) zero (range max-val))]
   d))

(defn socialize 
  [{b :b c :c n :n}] 
  (let [v (cycle? b c)]
    (if v
        [n (- (inc n) (:n v))] 
        (recur {:b (disperse b) :c (conj c {:b b :n (inc n)}) :n (inc n)}))))
