(ns aoc-2015.day1-test
  (:require [clojure.test :refer :all]
            [aoc-2015.day1 :refer :all]
            [clojure.test.check.generators :as gen]
            [clojure.test.check :as tc]
            [clojure.test.check.properties :as prop]
            [clojure.tools.trace :refer [trace]]))

(def intstream (-> "input/2015/day1.txt" slurp))

(deftest test-floor-level
    (testing "three"
      (is (= 3 (floor "))(((((")))))

(def test-with-generators 
  (testing "generators"
    (prop/for-all [input (gen/vector (gen/elements "()"))]
    (let [floor-commands (apply str input)
          command-count (count floor-commands)
          floor-ups (count (filter #(= % \() floor-commands))
          expected (- floor-ups (- command-count floor-ups))]
      (is (=  expected (floor floor-commands)))))))

(tc/quick-check 100 test-with-generators)
