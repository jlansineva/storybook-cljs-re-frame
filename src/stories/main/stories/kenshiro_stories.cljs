(ns main.stories.kenshiro-stories
  (:require
   [reagent.core :as r]
   [main.kenshiro :as kenshiro]
   [main.stories.utils :as u :refer-macros [->storybook]]))

(->storybook
  {:name "kenshiro"
   :title "Kenshiron kosketus :O"
   :reactified (u/->reactify kenshiro/kenshiro)}
  {:component kenshiro/kenshiro})


