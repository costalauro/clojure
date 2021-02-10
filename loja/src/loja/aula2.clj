(ns loja.aula2)

; ["daniella" "guilherme" "carlos" "paulo" "lucia" "ana"]

(defn conta
  [total-ate-agora elementos]
  (recur (inc total-ate-agora) (rest elementos)))

;(println (conta 0 ["daniella" "guilherme" "carlos" "paulo" "lucia" "ana"]))

(defn conta
  [total-ate-agora elementos]
  (if (next elementos)
    (recur (inc total-ate-agora) (rest elementos))))

;(println (conta 0 ["daniella" "guilherme" "carlos" "paulo" "lucia" "ana"]))

(defn conta
  [total-ate-agora elementos]
  (println elementos)
  (if (next elementos)
    (recur (inc total-ate-agora) (rest elementos))
    (inc total-ate-agora)))

;(println (conta 0 ["daniella" "guilherme" "carlos" "paulo" "lucia" "ana"]))
;(println (conta 0 []))

;(defn conta
;  [total-ate-agora elementos]
;  (if (seq elementos)
;    (recur (inc total-ate-agora) (rest elementos))
;    total-ate-agora))

;(println (conta 0 ["daniella" "guilherme" "carlos" "paulo" "lucia" "ana"]))
;(println (conta 0 []))


;(defn minha-funcao
;  ([parametro1] (println "p1" parametro1))
;  ([parametro1 parametro2] (println "p2" parametro1 parametro2)))
;
;(minha-funcao 1)
;(minha-funcao 1 2)

;(defn conta
;
;  ([elementos]
;   (conta 0 elementos))
;
;  ([total-ate-agora elementos]
;  (if (seq elementos)
;    (recur (inc total-ate-agora) (rest elementos))
;    total-ate-agora)))
;
;(println (conta ["daniella" "guilherme" "carlos" "paulo" "lucia" "ana"]))
;(println (conta []))

; for total-ate-agora 0, elementos-restantes elementos      ;;1 next

(defn conta
  [elementos]
  (loop [total-ate-agora 0
         elementos-restantes elementos]
    (if (seq elementos-restantes)
      (recur (inc total-ate-agora) (next elementos-restantes))
      total-ate-agora
      )
    ))

(println (conta ["daniella" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (conta []))

