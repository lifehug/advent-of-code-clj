(ns aoc-2017.day6
  (:require [clojure.string :refer [split]]
            [clojure.tools.trace :refer [trace]]))

(defn cycle? [a c] (not-any? #(= a %) c))
