(ns main.stories.jojo-stories
  (:require
   [reagent.core :as r]
   [main.jojo :as jojo]
   [main.stories.utils :as u :refer-macros [->storybook]]))

(->storybook
  {:reactified (u/->reactify jojo/star-platinum)
   :title "Star Platinum"
   :name "jojo"
   :argTypes {:color {:control "color"}}
   :args {:text "Hello"
          :show-image false          
          :show-stats false
          :stats {:power "F"
                  :speed "F"}}}
  {:component jojo/star-platinum}
  {:variant-name "za-warudo"
   :component jojo/star-platinum-world}
  {:variant-name "insight"
   :component jojo/star-platinum-insight})
