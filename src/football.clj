(ns football
  (:require [clj-time.core :as time]
            [clj-time.coerce :as coerce]
            [taoensso.timbre :as log]

            [clojure-ds.data :as data]
            [clojure-ds.helpers :as help]))

(def domain "football")

(defn clean [record]
  (-> record
      (update :home-score #(Integer. %))
      (update :away-score #(Integer. %))))

(defn generate-features [record]
  (let [{:keys [date
                home-team
                away-time
                home-score
                away-score
                tournament
                city
                country]} record
        date-time         (coerce/from-string date)]
    (assoc record
           :day-of-week (time/day-of-week date-time)
           :day-of-month (time/day date-time)
           :month-of-year (time/month date-time)
           :year (time/year date-time))))

(defn process [data-set]
  (->> data-set
       (map clean)
       (map generate-features)))


;; Inspect Data
(defn records [data]
  (-> (data/source data domain)
      (process)))

(defn top-of [kw data]
  (->> (records data)
       (help/group-freq kw)
       (sort-by last >)))

(defn features [data]
  (->> data
       (mapcat keys)
       (distinct)))

(defn summary [data]
  (let [records (records data)
        kws     (features records)]
    (reduce (fn [m kw]
              (assoc m kw (help/missing kw records))) {} kws)))
