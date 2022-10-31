(ns main.stories.utils
  #_(:require ["@storybook/addon-docs" :refer [Title]]))

(defmacro ->storybook
  [params & variants]
  (let [{:keys [title args name argTypes reactified]} params
        doc-symbol (symbol (str name "-docs"))
        arguments (gensym)
        variants (map #(let [{:keys [variant-name component]} %
                             symbol-name (vary-meta
                                           (symbol
                                             (str name
                                               (when variant-name (str "-" variant-name))))
                                           assoc :export true)
                             arguments (gensym)
                             converted-args (gensym)]                         
                         `(defn ~symbol-name
                            [~arguments]
                            (let [~converted-args (cljs.core/js->clj ~arguments :keywordize-keys true)]
                              (reagent.core/as-element
                                [~component ~converted-args]))))
                   variants)]
    `(do
       (defn ~doc-symbol []
         [:<>
          [:> :a]])
       (def ~(vary-meta 'default assoc :export true)
         (cljs.core/clj->js
           {:title ~title
            :args ~args
            :argTypes ~argTypes
            :component ~reactified}))       
       ~@variants)))
