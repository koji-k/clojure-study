(ns clojure-study.collection)
(println "aaa")

(println
  (let [
        my-vector [1 2 3 4]
        my-map {:fred "ethel"}
        my-list (list 4 3 2 1)
   ]
        (list
          (conj my-vector 5) ; Vectorの場合、最後に5を追加する。
          (assoc my-map :ricky "lucy")
          (conj my-list 5) ; Listの場合、先頭に5を追加する。
          my-vector
          my-map
          my-list)))

(println (map #(+ % 3) [2 4 7]))

(println 
  (let [my-vector [1 2 3 4]
        my-map {:fred "ethel" :ricky "lucy"}
        my-list (list 4 3 2 1)]

  [(first my-vector)
   (rest my-vector)
   (keys my-map)
   (vals my-map)
   (first my-list)
   (rest my-list)
   ]))

; リスト
'(1 2 3 4) ; こんな感じで定義。最初にシングルクオーテーションがあるのは関数じゃないよ！ということを示すため

; Groovyでいうheadとtail(LISPではcarとcdrというらしい)
(first '(1 2 3 4)) ;-> 1
(rest '(1 2 3 4)) ;-> (2 3 4)

; リストに要素を連結して新しいリストを返す
(cons 1 '(2 3 4)) ;-> (1 2 3 4)
