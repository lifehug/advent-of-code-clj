(ns aoc-2017.day7
  (:require [clojure.string :refer [split]]
            [clojure.tools.trace :refer [trace]]))

(defn child? 
  [e coll]
  (reduce 
    (fn [acc [n s l]]
      (if (some #(= e %) l) 
          (reduced true) 
          false)) 
       false 
      coll))

(defn bottom 
  [coll]
  (-> #(child? (first %) coll)
      (drop-while coll)
      first)) 
