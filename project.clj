(defproject io.github.manetu/mui-reagent "7.0.0-SNAPSHOT"
  :description "Reagent component wrappers for Material UI (MUI)"
  :url "https://github.com/manetu/mui-reagent"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.11.3" :scope "provided"]
                 [org.clojure/clojurescript "1.11.121" :scope "provided"]
                 [reagent "1.2.0" :scope "provided"]]
  :deploy-repositories [["clojars" {:url "https://repo.clojars.org"
                                    :username :env/CLOJARS_USERNAME
                                    :password :env/CLOJARS_PASSWORD}]]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "1.5.0"]]}})
