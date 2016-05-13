(ns clojure-study.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn -main
  "I don't do a whole lot."
  [x]
  (println x "welcome to Clojure!"))

(println "aaaa")

(foo "koji")

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; declare function
(defn normalFunction
  [x]
  (reduce (fn[x,y] (+ x y)) x '(1 2 3)))
(normalFunction 9)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; declare function
(defn normalFunction2
  ([] 100)
  ([x] (* x 2)))
(println (normalFunction2))
(println (normalFunction2 10))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(println (map - (range 10)))



;(def globalVariable[^String] 42)
;(println globalVariable)
(defn typeTest
  ([^String v] (println "This is String"))
  ([^Integer v s] (println "This is Integer" v s)))
(typeTest "1")
(typeTest "1" 2)

(def year 10)
(println (* year (* 300 10)))
