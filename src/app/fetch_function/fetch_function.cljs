(ns app.fetch_function.fetch_function
  (:require    [app.state :as  state]))

(defn fetch_function [str1 str2]
  (-> (.fetch js/window (str @state/url str1 "/" str2))
      (.then #(.json %))
      (.then #(do
                (reset! state/loading? false)
                (reset! state/fetch_data? true)
                (reset! state/result? %)))
      (.catch #(do
                 (reset! state/fetch_data? false)
                 (reset! state/loading? false)
                 (reset! state/fetch_error? true)))))