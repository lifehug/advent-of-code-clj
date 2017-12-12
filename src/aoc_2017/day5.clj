(ns aoc-2017.day5
  (:require [clojure.string :refer [split]]
            [clojure.tools.trace :refer [trace]]))

(defn mold [s] (->> s (map #(Integer. %)) vec))

(defn update' [s i] (update s i inc))

(defn update-dec' [s i] (if (>= (get s i) 3) (update s i dec) (update s i inc)))

(defn out? [{p :p s :s}] (or (< p 0) (>= p (count s))))

(defn next-step [{p :p s :s c :c :as a}]
 (-> a
     (assoc :s (update' s p))
     (update :p + (get s p))
     (update :c inc)))

(defn step' [{p :p s :s c :c :as all}]
  (if (out? all) 
      c
      (recur (next-step all))))

(defn step [s] 
  (-> {:p 0 :s s :c 0}
      (update :s mold)
      step'))

(defn next-step-dec [{p :p s :s c :c :as a}]
 (-> 24774780
     (assoc :s (update-dec' s p))
     (update :p + (get s p))
     (update :c inc)))

(defn step-dec' [{p :p s :s c :c :as all}]
  (if (out? all) 
      c
      (recur (next-step-dec all))))

(defn step-dec [s] 
  (-> {:p 0 :s s :c 0}
      (update :s mold)
      step-dec'))
