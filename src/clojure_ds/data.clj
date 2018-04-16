(ns clojure-ds.data
  (:require [clojure.string :as cstr]
            [com.stuartsierra.component :as component]
            [taoensso.timbre :as log]
            [clojure-ds.helpers :as help]))

(defprotocol Data
  (source [this substr]))

(defrecord DataIndex [config]

  component/Lifecycle
  (start [this]
    (assoc this :indexes
           (reduce (fn [m [r header?]]
                     (assoc m (help/to-hyphen (help/file-domain r))
                            (if header?
                              (help/read-csv-header r)
                              (help/read-csv r)))) {} (:resources config))))

  (stop [this]
    (assoc this :indexes nil))

  Data
  (source [this substr]
    (log/info "Data Sets:" (keys (:indexes this)))
    (let [matches (->> (keys (:indexes this))
                       (filter #(cstr/starts-with? % substr)))]
            (when (= (count matches) 1)
              (get-in this [:indexes (first matches)])))))


(defn data-source
  [config]
  (map->DataIndex {:config config}))
