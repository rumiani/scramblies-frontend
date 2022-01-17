(ns app.components.scramble.result.result
  (:require [app.state :as  state]))

(defn result
  []
  [:div.result  {:style {:color (if @state/result? "green" "red")}}
   (if @state/result? "Yes, it is." "No, it is not.") 
   ])