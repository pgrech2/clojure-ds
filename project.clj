(defproject clojure-ds "0.1.0-SNAPSHOT"
  :description "TODO"
  :url "TODO"
  :license {:name "TODO: Choose a license"
            :url  "http://choosealicense.com/"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha16"]
                 [org.clojure/data.csv "0.1.4"]

                 [com.taoensso/timbre "4.10.0"]
                 [com.stuartsierra/component "0.3.2"]

                 [clj-time "0.14.2"]
                 [clj-http "3.7.0"]

                 ;; R Like statistical library
                 [incanter "1.5.7"]

                 ;; Data visualization
                 [metasoarous/oz "1.2.1"]

                 ;; Matrix libraries
                 [net.mikera/core.matrix "0.62.0"]
                 [net.mikera/vectorz-clj "0.47.0"]
                 [clatrix "0.5.0"]
                 ;; Requires further installation
                 ;; [uncomplicate/neanderthal "0.18.0"]

                 ;; Neural Network toolkit
                 [thinktopic/cortex "0.9.22"]

                 ;; NLP
                 [org.clojurenlp/core "3.7.0"]

                 ;; Machine Learning
                 [lambda-ml "0.1.1"]]
  :resource-paths ["resources"]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.11"]
                                  [com.stuartsierra/component.repl "0.2.0"]]
                   :source-paths ["dev"]}})
