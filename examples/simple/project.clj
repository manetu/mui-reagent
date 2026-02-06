(defproject simple "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure        "1.11.3"]
                 [org.clojure/clojurescript  "1.11.121"
                  :exclusions [com.google.javascript/closure-compiler-unshaded
                               org.clojure/google-closure-library]]
                 [thheller/shadow-cljs "2.28.20"]
                 [reagent  "1.2.0"]
                 [re-frame "1.4.3"]
                 [io.github.manetu/mui-reagent "7.0.0-SNAPSHOT"]]

  :plugins [[lein-shadow "0.4.1"]]

  :clean-targets ^{:protect false} [:target-path
                                    "shadow-cljs.edn"
                                    "package.json"
                                    "package-lock.json"
                                    "resources/public/js"]

  :shadow-cljs {:nrepl  {:port 8777}

                :builds {:client {:target     :browser
                                  :output-dir "resources/public/js"
                                  :modules    {:client {:init-fn simple.core/run}}
                                  :devtools   {:http-root "resources/public"
                                               :http-port 8280}}}}

  :aliases {"dev-auto" ["shadow" "watch" "client"]})
