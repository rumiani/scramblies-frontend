(ns app.components.footer.footer
  (:require [app.state :as  state]))


(defn closeHandler
  [e]
  (.log js/console (-> e .-target .-className))
  (when (or (= (-> e .-target .-id) "app") (= (-> e .-target .-className) "fas fa-window-close"))
  (reset! state/help? false))
  ;; 
  )
  (.addEventListener js/window "click" closeHandler)
 
(defn  footer
  []
  [:footer
   [:div.icons
    [:i {:className "fas fa-question-circle" :title "Help?" :on-click (fn [] (reset! state/help? true))}]
    [:a  {:href "https://github.com/rumiani/scrambleies-challenge" :target "_blank"} 
     [:i {:className "fab fa-github" :title "Source code" }]]
    ]
   [:div [:p " Rumiani © 2022"]]
   (and @state/help? [:div.help
                      [:i {:className "fas fa-window-close" :title "Close" :on-click closeHandler}]
                      [:div
                       [:p "This app takes two strings and returns 'Yes' if a portion of str1 characters
                              can be rearranged to match str2, otherwise returns 'NO'."]
                       [:ul [:h2 "Notes"]
                        [:li "Only lower case letters should be used."]
                        ]
                       [:ol [:h2 "Examples:"]
                        [:li "(scramble? “rekqodlw” ”world”)" [:br] "==> " 
                         [:span {:style {:color "green"}} "Yes, it is."]]
                        [:li "(scramble? “cedewaraaossoqqyt” ”codewars”)" [:br] " ==>"
                         [:span {:style {:color "green"}} "Yes, it is."]]
                        [:li "(scramble? “katas”  “steak”)" [:br] " ==>" [:span {:style {:color "red"}} "No, it is not."]]]]
                      ]
        )
   ])