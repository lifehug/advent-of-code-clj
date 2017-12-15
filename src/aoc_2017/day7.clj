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

(defn sum-of-parent-and-child 
  [n pm] 
  (reduce + 
    (cons 
      (-> pm n :weight) 
      (map #(-> pm % :weight ) (->> pm n :children)))))

(defn calculate-weight
  [n pm]
  (let [c (-> pm n :children)]
  (if (nil? c)
      0
      (apply + (cons (-> pm n :weight) (map #(calculate-weight % pm) c))))))

(defn balanced? 
  [n pm] 
  (let [c (-> pm n :children)]
  (if (nil? c)
      true
      (apply = (map #(calculate-weight % pm) c)))))

(defn bad-programs 
  [p pm]
  (-> #(balanced? (first %) pm)
      (remove p)
      (->> 
        (map last))))



(defn parent-and-child-weight
  [n pm]
  [(calculate-weight n pm) (apply + (map #(calculate-weight % pm) (-> pm n :children)))])

(defn delta-weight 
  [p pm]
  (map #(parent-and-child-weight % pm) (bad-programs p pm)))


