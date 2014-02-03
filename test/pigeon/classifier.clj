(ns pigeon.Classifier
  (:require [pigeon.core :as core])
  (:gen-class
   :prefix classifier-
   :init init
   :state state
   :methods [[add [String java.util.Collection] void]
             [match [java.util.Collection] String]]))

(defn classifier-init
  []
  [[] (atom {})])

(defn classifier-add
  [this id archetype]
  (swap! (.state this) core/add-archetype id archetype))

(defn classifier-match
  [this unidentified]
  (core/match-archetype @(.state this) unidentified))
