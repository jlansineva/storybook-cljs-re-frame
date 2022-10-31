(ns main.stories.utils
  (:require [reagent.core :as r]))

(defn ->reactify
  [component]
  (r/reactify-component component))
