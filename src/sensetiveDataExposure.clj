(ns src.sensetiveDataExposure)

(defn continue [chain patch parameters] 
  (if chain
    (let [next-one (first chain)]
      (next-one (rest chain) patch parameters))))

(defn log-layer [chain patch parameters]
  ; Esse log é perigoso pelo fato de quem for implementando a cadeia, não exatamente sabe todas as funções atribuidas
  (println patch parameters)
  (continue chain patch parameters))

(defn do-upload [parameters]
  (println "dealing with upload"))

(defn upload-layer [chain patch parameters]
  (if (:upload-file parameters)
    (do-upload parameters))
  (continue chain patch parameters))

(defn execution-layer [chain patch parameters]
  (println "Executing for patch " patch))



(defn service [patch parameters]
  (let [chain [log-layer upload-layer execution-layer]]
    (continue chain patch parameters)))

(service "/upload" {:uploaded-file "hi.txt"})
(service "/login" {:password "password"})