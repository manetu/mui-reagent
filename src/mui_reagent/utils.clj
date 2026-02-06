(ns mui-reagent.utils)

(defmacro adapt [c]
  (let [n (-> c first str)]
    `(if-let [i# ~c]
       (-adapt i#)
       (throw (js/Error. (str "import " ~n " not found"))))))
