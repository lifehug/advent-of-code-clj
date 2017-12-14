(ns aoc-2017.day7-test
  (:require [clojure.test :refer :all]
            [aoc-2017.day7 :refer :all]
            [clojure.string :refer [split-lines]]
            [clojure.tools.trace :refer [trace]]
            [blancas.kern.core :refer :all]
            [blancas.kern.lexer.basic :refer :all]))

(def program (<$> #(->> % (apply str) keyword) (many letter)))

(def program-parser
 (bind [ n program 
         v (>> space (parens dec-num))
         l (optional (>> (token "->") (comma-sep program)))]
       (return [n v l])))

(def programs 
  (->> 
    "input/day7.txt" 
    slurp 
    split-lines 
    (map #(value program-parser %))))

(deftest test-parsec
  (let [result (-> programs first)]
          (is (= [:yvpwz 50 nil] result))))

(deftest test-parsec-2
  (let [entry (-> programs second)]
          (is (= [:vfosh 261 [:aziwd :tubze :dhjrv]] entry))))

(deftest test-parse-list 
  (is (= 1193 (count programs))))

(deftest bottom-test
  (is (= true (child? :vfosh programs))))

(deftest bottom-test-2
  (is (= :mwzaxaj (first (bottom programs)))))

;;(deftest bottom-test-2
;;  (is (= :nope (bottom programs))))
