(ns main.main
  (:require [reagent.dom :as rdom]
            [reagent.core :as r]
            [re-frame.core :as re-frame]
            [main.kenshiro :as kenshiro]
            [main.jojo :as jojo]))

(defn main-component
  []
  (let [kenshiro-mode? (re-frame/subscribe [::get-mode])
        jojo-data (re-frame/subscribe [::get-jojo])]
    (fn []
      [:div [:h1 "My Awesome JoJo/Hokuto no Ken Fansite"]
       [:input {:type :button :value "Change mode" :on-click #(re-frame/dispatch [::change-mode])}]
       (if @kenshiro-mode?
         [kenshiro/kenshiro]
         [:<>
          [jojo/star-platinum]
          [jojo/star-platinum-world {:text "TOKI WO TOMARE!"}]
          [jojo/star-platinum-insight {:show-image true :show-stats true :stats {:power "A" :speed "A"} :color "#FFAA55"}]])])))

(defn change-mode-event
  [coeffects event]
  (println "change mode" event coeffects (update-in coeffects [:db :kenshiro-mode?] not))
  (update-in coeffects [:db :kenshiro-mode?] not))

(defn get-mode-sub [db v]
  (println "sub" db)
  (:kenshiro-mode? db))

(defn get-jojo-sub [db v]
  (println "JOJOOOO!")
  (:jojo db))

(re-frame/reg-event-db ::initialize (fn [_ _]
                                      (println "initial fukaroo")
                                      {:kenshiro-mode? true                                       
                                       :jojo {:show-image true
                                              :ora-count 0
                                              :show-stats true
                                              :stats {:power "A" :speed "A"}
                                              :color "#FFAA55"}}))
(re-frame/reg-event-fx ::change-mode change-mode-event)
(re-frame/reg-sub ::get-mode get-mode-sub)
(re-frame/reg-sub ::get-jojo get-jojo-sub)

(defn entrypoint
  []  
  (println "initializing")
  (re-frame/dispatch-sync [::initialize])
  (rdom/render [main-component]
    (-> js/document (.getElementById "root"))))
