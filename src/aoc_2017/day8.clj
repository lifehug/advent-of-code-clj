(ns aoc-2017.day8
  (:require [clojure.string :refer [split]]
            [clojure.tools.trace :refer [trace]]))

(defn max-record [r u] (if (> u (:max r)) (assoc r :max u) r))

(defn execute
  [r [r1 o d r2 e d2]]
  (let [v1 (r1 r) v2 (r2 r) u (o v1 d)]
    (if (e v2 d2) 
      (max-record (assoc r r1 u) u)
      r)))

(defn top-rv [is r] (reduce (fn [r i] (execute r i)) r is))
