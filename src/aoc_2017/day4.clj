(ns aoc-2017.day4
  (:require [clojure.string :refer [split]]
            [clojure.tools.trace :refer [trace]]))

(defn anagram [p] (map (comp #(apply str %) sort) p))

(defn valid-pass [p]
  (let [passes (anagram (split p #"\s+"))]
    (-> passes 
        distinct
        count
        (= (count passes)))))

(defn valid-passes-count [p]
  (->> p
       (filter valid-pass)
       count))
