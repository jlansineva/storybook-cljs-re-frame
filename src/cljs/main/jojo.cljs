(ns main.jojo
  (:require [reagent.core :as r]
            [re-frame.core :as re-frame]))

(re-frame/reg-sub ::get-ora (fn [db _]
                              (get-in db [:jojo :ora-count])))

(re-frame/reg-event-fx ::ora! (fn [cfx e]
                                (update-in cfx [:db :jojo :ora-count] inc)))

(defn star-platinum
  []
  [:div
   [:input {:type :button
            :on-click #(re-frame/dispatch [::ora!])
            :value (reduce #(str %1 "ORA") "" (range @(re-frame/subscribe [::get-ora])))}]
   "Click to ora!"])

(defn star-platinum-world
  [{:keys [text] :as params}]
  [:div
   [:input {:type :button
            :value text}]
   "Click to ZA WARUDO!"])

(defn star-platinum-insight
  [{{:keys [power speed]} :stats
    :keys [show-image show-stats color]}]
  [:div
   [:h1 {:style {:color color}}
    "STAR PLATINUM"]
   (when show-stats
     [:<>
      [:div (str "Destructive Power: --- " power)]
      [:div (str "Speed: --- " speed)]])
   (when show-image
     [:img {:src 
            "https://static.jojowiki.com/images/thumb/c/c1/latest/20211204230516/Star_Platinum_SO_Infobox_Anime.png/400px-Star_Platinum_SO_Infobox_Anime.png"}])])

