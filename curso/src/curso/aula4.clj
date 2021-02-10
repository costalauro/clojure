(ns curso.aula4)

(def precos [30 700 1000])

(println (precos 0))
(println (get precos 1))
(println (get precos 2))
;(println (precos 17)) da erro, o certo eh utilizar a funcao get
(println "valor padrao nil" (get precos 17))
(println "valor padrao 0" (get precos 17 0))
(println "valor padrao 0, mas existe" (get precos 2 0))


(println (conj precos 5))

(println precos)

;(println (conj 5 precos)) da erro

(println(update precos 0 inc))
(println(update precos 1 dec))

(defn soma-1
  [valor]
  (println "estou somando um em " valor)
  (+ valor 1))

(println (update precos 0 soma-1))


(defn soma-3
  [valor]
  (println "estou somando um três " valor)
  (+ valor 3))

(println (update precos 1 soma-3))

; codigo da aula anterior
(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 10))

(defn valor-descontado
  "Retorna o valor desconto de 10% se o valor bruto for estritamento maior que 100."
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println precos)
(println "map, aplica a funcao para todos os precos, e retorna os valores transformados" (map valor-descontado precos ))
(println "range, " (range 10 ))
(println "filter, filtra os pares " (filter even? ( range 10) ))
(println "vetor" precos)
(println "filter, filtra os precos da lista onde se aplica desconto e os retorna" (filter aplica-desconto? precos ))

(println "map apos o filter " (map valor-descontado (filter aplica-desconto? precos)))

(println "soma os valores de um vetor" (reduce + precos))

(defn minha-soma
  [valor-1, valor-2]
  (println "somando" valor-1 valor-2)
  (+ valor-1 valor-2))

(println "soma os dois primeiros valores e depois e resultado da soma com o terceiro" (reduce minha-soma precos))
(println "soma os dois primeiros valores e depois e resultado da soma com o terceiro,
 agora com o zero como primeiro valor" (reduce minha-soma 0 precos))
(println (reduce minha-soma (range 10)))
(println (reduce minha-soma [15]))
