(ns app.components.scramble.inputStr2.inputStr2
    (:require [app.state :as  state]
              [goog.string :as gstring]
))

(defn inputCheck 
  [input_string]
  (reset! state/fetch_data? false)
 (if (and (= (re-find #"[a-z]+" input_string) (gstring/trim input_string))
          (not (= @state/second_input ""))) 
   (reset! state/second_input_valid? true)
   (reset! state/second_input_valid? false)
   )
  )

(defn inputStr2
  []
  [:div.input_div 
   [:input#second_input {:placeholder "Enter the second str"  
                      :on-change (fn[e]  
                                          (reset!  state/second_input (gstring/trim (-> e .-target .-value))) 
                                                 (inputCheck (-> e .-target .-value))
                                         )

           }]
  (when (= @state/second_input_valid? false) [:p.char_limit_error "Lowecase letters only (a-z)"])] )