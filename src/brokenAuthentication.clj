(ns src.brokenAuthentication
  (:require [crypto-password.bcrypt :as password]))

(defn read-file [filename]
  (-> filename
      slurp
      clojure.string/split-lines))

(def common-passwords (read-file "src/common-passwords.txt"))

(defn iscommon? [password]
  (some #(= password %) common-passwords))

(def database (atom {}) 
  (defn add [table document]
    (swap! database update-in [table] conj document)))

(defn register-new-user! [username password]
  (if (iscommon? password)
    (throw Exception. "Senha muito simples"))
  (let [encrypted (password/encrypt password)])
  (add :users {:username username, :password encrypted}))

(register-new-user! "kayan-silva" "bala")