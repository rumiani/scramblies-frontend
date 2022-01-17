(ns app.components.scramble.scramble
  (:require
   [app.components.scramble.inputStr1.inputStr1  :refer [inputStr1]]
   [app.components.scramble.inputStr2.inputStr2 :refer [inputStr2]]
   [app.components.scramble.button.button :refer [button]]
   [app.components.scramble.result.result :refer [result]]
   [app.components.scramble.loader.loader :refer [loader]]
   [app.components.scramble.errorhandling.errorhandling :refer [errorhandling]]
   [app.state :as  state]
   )
)

(defn scramble
  []
  [:div.form
   [inputStr1]
   [inputStr2]
   [button]
  (and  @state/loading?  [loader])
   (and  (and @state/fetch_data? @state/first_input_valid? @state/second_input_valid?)  [result])
   (and @state/fetch_error? [errorhandling])
   ]
  )