(ns aoc-2017.day3
  (:require [clojure.string :refer [split]]
            [clojure.tools.trace :refer [trace]]))

(defn squarebors [v] (map #(+ v %) (range -1 2)))

(defn neighbor-coords [[x y] s] 
  (-> 
    (for [xs (squarebors x) ys (squarebors y) 
          :when (and (< -1 xs) (> s xs) (< -1 ys) (> s ys) (or (not= y ys) (not= x xs)))] 
      [xs ys])))

(defn get-neighbor-value
  [c m]
  (map (fn [[x y]] (get (get m y) x)) c))

(defn add-neighbors [c m] 
  (->>
    (get-neighbor-value c m) 
    (reduce +)))

(defn sum-neighbors [m [x y]]
  (let [s (count m)
        c (neighbor-coords [x y] s)
        pv (add-neighbors c m)]
    (assoc-in m [y x] pv)))

(defn square-up [n] (if (even? n) (inc n) n))

(defn create-square [n]
  (let [d (-> n Math/sqrt Math/ceil int square-up)
        r (->> 0 (repeat d) vec)
        m (->> r (repeat d) vec)]
    m))

(defn down? [m [x y]]
  (and (> (get-neighbor-value [[(inc x) y]] m) 0)
       (= 0 (get-neighbor-value [[x (dec y)]] m))))

(defn next-position [m [x y]]
  (cond
    (down? m [x y]) [x (dec y)]
    :else [-1 -1]))
