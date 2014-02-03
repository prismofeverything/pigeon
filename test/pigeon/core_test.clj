(ns pigeon.core-test
  (:require [clojure.test :refer :all]
            [pigeon.core :refer :all])
  (:import [pigeon Classifier]))

(deftest a-test
  (let [pigeon (pigeon.Classifier.)]
    (.add pigeon "yellow" [(processing.core.PVector. 1 1 1) (processing.core.PVector. 2 2 2)])
    (.add pigeon "green" [(processing.core.PVector. -1 -1 -1) (processing.core.PVector. -2 -2 -2)])
    (is (= "green" (.match pigeon [(processing.core.PVector. -1 -0 -1) (processing.core.PVector. -2 -0 -2)])))))
