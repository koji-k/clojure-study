(ns study.if)

(defn if-test1
  [n]
  (if (= 1 n)
  "True!"
  "False!"))

(println (if-test1 1))
(println (if-test1 2))

; 最後に評価結果が返るので、その以前に処理を入れたい場合はdoを使う
(defn if-test2
  [n]
  (if (= n 1)
  (do (print "Hello if ------> ") "True")
  "False"))

(println (if-test2 1))
(println (if-test2 9))

; if-letで評価した値がTrueになるような値ならそのまま変数に束縛できる
; ちょっとだけGroovyのエルビス演算子（?:）に似てるかも。
(defn if-test3
  [coll]
  (if-let [c (seq (filter even? coll))]
    c
    "Cond is false"))
(println (if-test3 [1 2 3 4]))
(println (if-test3 [1 3 5 7]))


; when --------------------------------------------------------------
(defn when-test1
  [n]
  (when (= n 1)
    (print "When")
    (print " is ")
    (print "True!")
    (print " ---->  ")
    n))
(println (when-test1 1)) ; whenの中が全て実行される
(println (when-test1 2)) ; whenの条件に合致しないのでnilが返る

; case --------------------------------------------------------------
; whenと違い、該当する条件の部分のみ実行される
; もしデフォルトケースを指定していなくて、さらに該当する条件（値）がない場合、IllegalArgumentExceptionがスローされる 
(defn case-test1
  [n]
  (case n
    1 "n is 1"
    2 "n is 2"
    "n is other")) ; 条件がない場合はswitchで言うところのdefaultと同じ。

(println (case-test1 1))
(println (case-test1 2))
(println (case-test1 3))

; cond --------------------------------------------------------------
; caseの条件が値じゃなくて式のパターン。defaultが:elseで指定するという点も異なる。
; caseと違い、デフォルトケース（:else)が指定されていなくて街頭する条件が無くても例外はスローされず、nilが返る
(defn cond-test1
  [n]
  (cond
    (= n 1) "n is 1"
    (= n 2) "n is 2"
    (and (> n 3) (< n 10)) "n is over 3 and under 10" 
    :else "n is other"))
(println (cond-test1 1))
(println (cond-test1 2))
(println (cond-test1 5))
(println (cond-test1 15))


; condp --------------------------------------------------------------
; デフォルトケースの指定はcaseと同じ。
; もしデフォルトケースを指定していなくて、さらに該当する条件（値）がない場合、IllegalArgumentExceptionがスローされる 
(defn fizzbuzz
  [x]
  (condp #(= (mod %2 %1) 0) x ; %1はココで最初に渡しているxが、%2は継続する条件の値が自動的に格納される。値が同じかどうかだけチェックする場合は(condp = x .....)となる
    15 "FizzBuzz"
    3 "Fizz"
    5 "Buzz"
    x))
(println (map fizzbuzz (range 100)))

; condpの各条件で、:>>を使うと、condpで指定した関数の実行結果を渡してくれて、その実行結果を使った関数が指定できる。
(println (condp some [1 2 3 4]
  #{0 6 7} :>> inc
  #{4 5 9} :>> dec
  #{1 2 3} :>> #(+ % 3)
  ))







