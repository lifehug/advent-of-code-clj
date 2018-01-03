(ns aoc-2015.day1
  (:require [clojure.string :refer [split]]
            [clojure.tools.trace :refer [trace]]))

(defn is-open [c] (if (= c \( ) 1 -1))

(defn floor [s] (reduce (fn [acc v] (+ (is-open v) acc )) 0 s))

