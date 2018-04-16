(ns dev
  (:require [clojure.java.io :as io]
            [clojure.tools.namespace.repl :refer [refresh refresh-all clear]]
            [com.stuartsierra.component :as component]
            [clojure-ds :as cds]
            [clojure-ds.data :as data]
            [clojure-ds.helpers :as help]))

(defonce system nil)

(defn dev-system
  "Constructs a system map suitable for interactive development."
  []
  (component/system-map
   :data (data/data-source {:resources [["football_results.csv" true]]})))

(defn init
  "Constructs the current development system."
  []
  (alter-var-root #'system
                  (constantly (dev-system))))

(defn start
  "Starts the current development system."
  []
  (alter-var-root #'system component/start))

(defn stop
  "Shuts down and destroys the current development system."
  []
  (alter-var-root #'system
                  (fn [s] (when s (component/stop s)))))

(defmacro vars
  []
  '(do
     (def data (:data system))))

(defn go
  "Initializes and starts the system running."
  []
  (init)
  (start)
  (vars)
  :ready)

(defn reset
  "Stops the system, reloads modified source files, and restarts it."
  []
  (stop)
  (refresh :after `go))
