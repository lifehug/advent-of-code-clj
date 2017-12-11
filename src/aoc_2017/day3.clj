(ns aoc-2017.day3
  (:require [clojure.string :refer [split]]
            [clojure.tools.trace :refer [trace]]))

(defn next-odd [n] (if (even? n) (+ 1 n) n))

 (defn distance [n]
  (let [s (-> n Math/sqrt int) 
        over (trace (rem (- (* s s) n) s))
        h (trace (-> s (/ 2) Math/ceil))
        dc (trace (if (> over h) (- over h) (- h over)))]
        (+ dc h)))
