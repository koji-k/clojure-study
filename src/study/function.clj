(ns study.function)

(println "defで関数定義")
; fn は無名関数
(def hello (fn [] (println "Hello Clojure on def")))
(hello)
(println "")

(println "defnで関数定義")
(defn hello2 [] (println "Hello Clojure on defn") )
(hello2)
(println "")

(println "defnを使って関数のオーバロード")
(defn hello3
  ([] 0)
  ([x] 1)
  ([x, y] 2)
  ([x y & more] (+ (hello3 x y)(count more))))
(println (hello3))
(println (hello3 1))
(println (hello3 1 2))
(println (hello3 1 2 3))
(println (hello3 1 2 3 4))
(println "")

(println "letを使ってローカル束縛（ローカル変数みたいなもの）を定義する。")
(defn make-adder [x]
  (let [y x] (fn [z] (+ y z)))) ; yというローカル変数に、xという値（今回はxは変数）を割り当てるという意味）
(def add2 (make-adder 2))
(println (add2 4))
(println "")


(println "無名関数（fn）のシンタックスシュガー")
(def shortFn1 #(+ %1 %2))
(println (shortFn1 100 200)) ; = 300
(println (#(+ %1 %2) 200 400)) ;= 600
(println (#(* % 2) 10)) ; = 2. 引数が一個の場合は%という指定だけでいい。
(println (#(println "引数なしのシンタックスシュガー！")))
