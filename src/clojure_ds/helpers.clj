(ns clojure-ds.helpers
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as jio]
            [clojure.string :as cstr]))

(defn to-hyphen
  ([s]
   (to-hyphen s false))
  ([s kw?]
   (cond-> (cstr/replace s "_" "-")
     kw? (keyword))))

(defn file-domain [filename]
  (first (cstr/split filename #"[.]")))

(defn read-csv-header [filename]
  (with-open [reader (jio/reader (jio/resource filename))]
    (let [header (->> (first (csv/read-csv reader))
                      (map #(to-hyphen % true)))]
      (-> (csv/read-csv reader)
          (rest)
          (->> (map (partial zipmap header)))
          (doall)))))

(defn read-csv [filename]
  (with-open [reader (jio/reader (jio/resource filename))]
    (-> (csv/read-csv reader)
        (doall))))

(defn group-freq [kw coll]
  (->> coll
       (group-by kw)
       (reduce (fn [m [kw r]]
                 (assoc m kw (count r))) {})))

(defn missing [kw coll]
  (let [{:keys [total exist] :as result}
        {:total   (count coll)
         :exist   (count (filter some? coll))}]
    (assoc result :missing (- total exist))))
