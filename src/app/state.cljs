(ns app.state
  (:require [reagent.core :as r]))
 
(def first_input (r/atom ""))
(def first_input_valid? (r/atom nil))
(def second_input (r/atom ""))
(def second_input_valid? (r/atom nil))
(def loading? (r/atom false))
(def result? (r/atom nil))
(def fetch_data? (r/atom false))
(def fetch_error? (r/atom false))
(def help? (r/atom false))
(def url (r/atom "https://infinite-river-12370.herokuapp.com/scramble/"))
;; (def url (r/atom "https://http://localhost:8000//scramble/"))