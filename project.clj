(defproject clojure-owasp "0.1.0"
  :description "Resolvendo problemas de OWASP com a lingaugem clojure"
  :dependencies [
                 [org.clojure/clojure "1.10.0"]
                 [crypto-password "0.2.1"]
  ]
  :repl-options {:init-ns src.core})