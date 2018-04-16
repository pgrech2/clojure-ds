(defproject clojure-ds "0.1.0-SNAPSHOT"
  :description "TODO"
  :url "TODO"
  :license {:name "TODO: Choose a license"
            :url  "http://choosealicense.com/"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha16"]
                 [org.clojure/data.csv "0.1.4"]

                 [com.taoensso/timbre "4.10.0"]
                 [com.stuartsierra/component "0.3.2"]

                 ;; Utilities
                 [cheshire "5.7.0"]
                 [clj-time "0.14.2"]
                 [clj-http "3.7.0"]

                 ;; Random Sampling
                 [bigml/sampling "3.2"]

                 ;; Matrix
                 [net.mikera/core.matrix "0.62.0"]
                 [net.mikera/vectorz-clj "0.47.0"]
                 [clatrix "0.5.0"]
                 ;; Requires further installation
                 ;; [uncomplicate/neanderthal "0.18.0"]

                 ;; Visualization
                 [metasoarous/oz "1.3.1"]

                 ;; MACHINE LEARNING Libraries
                 [incanter/incanter "1.5.7"]
                 [lambda-ml "0.1.1"]
                 ;; Forward chaining rule
                 [com.cerner/clara-rules "0.17.0"]

                 ;; Neural networks
                 [thinktopic/cortex "0.9.22"]
                 ;; Not yet released
                 ;; Tensorflow
                 ;; https://github.com/bpiel/guildsman
                 ;; Statistical Library
                 ]
  :resource-paths ["resources"]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.11"]
                                  [com.stuartsierra/component.repl "0.2.0"]]
                   :source-paths ["dev"]}})
