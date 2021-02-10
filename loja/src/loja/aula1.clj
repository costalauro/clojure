(ns loja.aula1)

;["daniella" "guilherme" "carlos" "paulo" "lucia" "ana"]
;{ "guilherme" 37, "paulo" 39}
;'(1 2 3 4 5)
;[[0 1 ]]
;#{}
;
;map
;filter
;reduce

;loop
;for

(map println ["daniella" "guilherme" "carlos" "paulo" "lucia" "ana"])
(map println (first ["daniella" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (first ["daniella" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (rest []))
(println (rest ["daniella" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (next []))
(println (next ["daniella" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (seq []))
(println (seq [1 2 3 4 5]))

(println "\n\n\n\n\n Meu mapa")

(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (funcao primeiro)
    (meu-mapa funcao (rest sequencia))
    ))

;(meu-mapa println ["daniella" "guilherme" "carlos" "paulo" "lucia" "ana"])

(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
       (do
         (funcao primeiro)
         (meu-mapa funcao (rest sequencia))))))


(meu-mapa println ["daniella" false "guilherme" "carlos" "paulo" "lucia" "ana"])
(meu-mapa println ["daniella" "guilherme" "carlos" "paulo" "lucia" "ana"])
(meu-mapa println [])
(meu-mapa println nil)

;(meu-mapa println (range 100000))                              ; da erro de stackoverflow

;tail recursion
;utilizar recur para não dar erro de stackoverflow, é mais otimizado que um for tradicional
;o recur deve tem que ser o retorno da função, nao eh tail nao pode
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (recur funcao (rest sequencia))))))

; NAO PODE FAZER ASSIM
;(defn meu-mapa
;  [funcao sequencia]
;  (let [primeiro (first sequencia)]
;    (if (not (nil? primeiro))
;      (do
;        (recur funcao (rest sequencia))
;        (funcao primeiro)
;        ))))