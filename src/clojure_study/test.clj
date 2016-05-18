(ns clojure_study.test)
(+ (+ 1 (* 2 3)) (* 4 5))

(defn f [x] (+ x 1))
(f 2)
((fn [x] (+ x 1)) 1)
