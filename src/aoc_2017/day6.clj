(ns aoc-2017.day6
  (:require [clojure.string :refer [split]]
            [clojure.tools.trace :refer [trace]]))

(defn cycle? [a c] (not-any? #(= a %) c))

(defn disperse [b]
  (let [max-val (apply max b)
        pos (reduce #(if (= %2 max-val) (reduced %1) (inc %1)) 0 b)
        zero (assoc b pos 0)
        d (reduce #(update %1 (mod %2 (count zero)) inc) zero (range max-val))]
   d))

(defn socialize 
  ([b] (socialize b [] 0))
  ([b c n] 
    (if (cycle? b (trace c))
        (recur (disperse b) (conj c b) (inc n))
        n)))
