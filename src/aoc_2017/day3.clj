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
    pv))

(defn update-square [m [x y]] 
  (let [ s (sum-neighbors m [x y])]
    (if (= 0 s)
        (assoc-in m [y x] 1)
        (assoc-in m [y x] s))))

(defn square-up [n] (if (even? n) (inc n) n))

(defn create-square [n]
  (let [d (-> n Math/sqrt Math/ceil int square-up)
        r (->> 0 (repeat d) vec)
        m (->> r (repeat d) vec)]
    m))

(defn down? [m [x y]]
  (if (or (>= (inc x) (count m)) (>= (inc y) (count m)))
    false 
    (and 
      (> (first (get-neighbor-value [[(inc x) y]] m)) 0)
      (= 0 (first (get-neighbor-value [[x (inc y)]] m))))))

(defn up? [m [x y]]
  (if (or (< (dec x) 0) (< (dec  y) 0))
    false 
    (and 
      (> (first (get-neighbor-value [[(dec x) y]] m)) 0)
      (= 0 (first (get-neighbor-value [[x (dec y)]] m))))))

(defn left? [m [x y]]
  (if (or (>= (inc y) (count m)) (< (dec x) 0))
    false 
    (and 
      (> (first (get-neighbor-value [[x (inc y)]] m)) 0)
      (= 0 (first (get-neighbor-value [[(dec x) y]] m))))))

(defn right? [m [x y]]
  (if (or (>= (inc x) (count m)) (< (dec y) 0))
    false 
    (or (= 0 (sum-neighbors m [x y])) 
      (and 
      (> (first (get-neighbor-value [[x (dec y)]] m)) 0)
      (= 0 (first (get-neighbor-value [[(inc x) y]] m)))))))

(defn next-position [m [x y]]
  (cond
    (right? m [x y]) [(inc x) y]
    (down? m [x y]) [x (inc y)]
    (left? m [x y]) [(dec x) y]
    (up? m [x y]) [x (dec y)]
    :else [-1 -1]))

(defn finish-him 
  ([n]
   (let [s (-> n create-square) 
         p (-> n Math/sqrt (/ 2) Math/floor int (->> (repeat 2) vec))
         u (update-square s p)
         np (next-position u p)] 
       (finish-him u np n)))
 ([m p n]
  (let [sn (sum-neighbors m p) 
        u (update-square m p) 
        np (next-position u p)]
  (if (>= n sn)
      (recur u np n)
      [sn u]))))



