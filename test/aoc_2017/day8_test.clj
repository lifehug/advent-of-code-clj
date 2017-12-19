(ns aoc-2017.day8-test
  (:require [clojure.test :refer :all]
            [aoc-2017.day8 :refer :all]
            [clojure.string :refer [split-lines]]
            [clojure.tools.trace :refer [trace]]
            [blancas.kern.core :refer :all]
            [blancas.kern.lexer.basic :refer :all]))

(defn str->op
  [s]
  (condp = s
    "==" = 
    "!=" not=
    ">" >
    "<" <
    ">=" >=
    "<=" <=))

(defn str->inst
  [s]
  (condp = s
    "inc" +
    "dec" -))

(def register (<$> #(->> % (apply str) keyword) (many1 letter)))
(def instruction (<$> #(->> % (apply str) str->inst) (many1 letter)))
(def numbers (<$> #(->> % (apply str) read-string) (many1 (<|> (sym \-) digit))))
(def evaluation (<$> str->op (<|> (token "<=") (token ">=") (token ">") (token "<") (token "==") (token "!="))))

(def instruction-parser
 (bind [ r register 
         o (>> space instruction)
         d (>> space numbers)
         r2 (>> space (token "if") register)
         e (>> space evaluation)
         d2 numbers]
       (return [r o d r2 e d2])))

(def instructions 
  (->> 
    "input/day8.txt" 
    slurp 
    split-lines 
    (map #(value instruction-parser %))))

(def registers 
  (assoc 
    (apply hash-map 
         (interleave
           (->> instructions 
                (map #(first %))
                distinct) 
          (repeat 0))) :max 0))

(deftest test-instruction
  (is (= 0 (:t (execute {:t 0 :xq 0 :max 0} (value instruction-parser "t inc 245 if xq != 0"))))))

(deftest test-instriction-2
  (is (= 245 (:t (execute {:t 0 :xq 0 :max 0} (value instruction-parser "t inc 245 if xq == 0"))))))

(defn remove-max [r] (dissoc r :max))

(deftest test-all-data
  (is (= 6343 (->> (top-rv instructions registers) remove-max seq (map second) (apply max)))))

(deftest test-all-data-max
  (is (= 7184 (-> (top-rv instructions registers) :max))))
