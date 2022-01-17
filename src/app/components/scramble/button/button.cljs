(ns app.components.scramble.button.button
  (:require [app.state :as  state]
            [app.fetch_function.fetch_function :refer [fetch_function]]))

(defn scramble?
  [str1 str2]
  (reset! state/fetch_data? nil)
  (cond
    (= @state/first_input "")
    (-> js/document
        (.getElementById "first_input")
        (.focus))
    
    (= @state/second_input "")
    (-> js/document
        (.getElementById "second_input")
        (.focus))

    (and @state/first_input_valid? @state/second_input_valid?)
    (do (reset! state/loading? true)
    (fetch_function str1 str2))
    )  
)

(defn button
  []
  [:button {:title "Source code" 
            :on-click (fn [] (scramble? @state/first_input @state/second_input))}
    "Scramble?" ])