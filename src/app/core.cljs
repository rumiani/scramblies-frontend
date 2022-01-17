(ns app.core
  (:require [reagent.core :as r]
           [app.components.header.header :refer [header]]
            [app.components.footer.footer :refer [footer]]
            [app.components.scramble.scramble :refer [scramble]]

            ))

(defn app
  []
  [:div.container 
   [header]
   [scramble]
   [footer]
   ])

(defn ^:export main
  []
  (r/render
    [app]
    (.getElementById js/document "app")))
