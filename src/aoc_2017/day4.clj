(ns aoc-2017.day4
  (:require [clojure.string :refer [split]]
            [clojure.tools.trace :refer [trace]]))

(defn anagram' [p] (map (comp #(apply str %) sort) p))

(defn split' [p] (split p #"\s+"))

(def anagram (comp anagram' split'))

(defn valid-pass [p]
  (let [passes (split' p)]
    (-> passes 
        distinct
        count
        (= (count passes)))))

(defn valid-pass-anagram [p]
  (let [passes (anagram p)]
    (-> passes 
        distinct
        count
        (= (count passes)))))

(defn valid-passes-count [p]
  (->> p
       (filter valid-pass)
       count))

(defn valid-passes-count-anagram [p]
  (->> p
       (filter valid-pass-anagram)
       count))
