(ns src.injection)

(use '[clojure.java.shell :only [sh]])

(defn run-cluster [config-files]
  ;Colocar o comando direto para evitar parametrizações a+
  (sh "/bin/kafka" config-files))

(run-cluster "server.properties")
