(ns study.test)
(+ (+ 1 (* 2 3)) (* 4 5))

; 関数定義
; REPLから読み込む際は(require 'study.test)を実行して、(study.test/f)で実行できる。
; ソースを修正したら、(require 'study.test :reload)で再読込する必要がある。
(defn f [x] (+ x 1))
(f 2)
((fn [x] (+ x 1)) 1)


; 条件分岐
(if true 1 2) ;-> 1
(if false 1 2) ;-> 2
(if (= 1 2) 10 20) ;-> 20
(if (= (mod 100 2) 0) "even" "odd") ;->even
(if (= (mod 101 2) 0) "even" "odd") ;->odd


; リスト周り
(first '(1 ,2 3 4)) ;-> 1. car on Lisp
(rest '(1 2 3 4)) ;-> (2,3,4). cdr on Lisp
(cons 1 '(2 3 4)) ; -> (1,2,3,4)
(cons 1(cons 2(cons 3 (cons 4 '())))) ;-> (1,2,3,4)
(nth '(10 20 30 40) 2) ;-> 30
(second '(10 20 30 40) ) ;-> 20 何故か2番めの値を取得する命令がある。

(map (fn [x] (* 2 x)) '(1 2 3))  ;-> (2 4 6)
(filter (fn [x] (>= x 5)) (range 10)) ;->(5 6 7 8 9)
(filter (fn [x] (= (mod x 2) 0)) (range 10)) ;-> (0 2 4 5 8)
(reduce + 0 '(1 2 3) ) ;-> 6
(reduce (fn [x y] (+(* x 10) y)) 0 '(1 2 3)) ;-> 123

; 無限リスト
(take 5 (repeat 1)) ;-> (1 1 1 1 1)
(take 10 (cycle '(3 2 1))) ;-> (3 2 1 3 2 1 3 2 1 3)
(take 2 '(1 2 3)) ;-> (1 2) takeは普通のリストにも使える

; 集合（Set）Setは順序を保証しない、そして重複を許さない
#{1 2 3} ;-> #{1 2 3}
(set '(1 2 3)) ;-> #{1 2 3}
(conj #{1 2 3} 4) ;-> #{1 2 3 4}
(conj #{1 2 3} 1) ;-> #{1 2 3}

; 文字列 strという関数で文字列を作成出来る
"abc" ;-> 一番シンプルな文字列
(str "Hello" " " "World") ;-> Hello World
(str 1) ;-> 1という文字を作成
