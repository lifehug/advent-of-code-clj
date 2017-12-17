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

(defn calculate-weight
  [n pm]
  (let [c (-> pm n :children)
        w (-> pm n :weight)]
  (if (nil? c)
      w 
      (->> c
        (map #(calculate-weight % pm))
        (cons w)
        (reduce +)))))

(defn balanced? 
  [n pm] 
  (let [c (-> pm n :children)]
  (if (nil? c)
      true
      (apply = (map #(calculate-weight % pm) c)))))

(defn get-bad 
  [n pm]
  (if (= (calculate-weight (first n) pm) (calculate-weight (second n) pm))
      (last n)
      (first n)))

(defn find-bad-path [n pm] 
  (get-bad 
    (sort-by #(calculate-weight % pm) (-> pm n :children))
    pm))

(defn bad-program
  [n pm v]
  (if (balanced? n pm)
      (cons n v)
      (bad-program (find-bad-path n pm) pm (cons n v))))

