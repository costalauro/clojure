(ns curso.aula3)

(defn valor-descontado
  "Retorna o valor desconto de 10% se o valor bruto for estritamento maior que 100."
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (println "Calculando desconto de" desconto)
      (- valor-bruto desconto))
    valor-bruto))

; PREDICATE
(defn deve-aplicar-desconto?
  [valor-bruto]
  (if (> valor-bruto 100)
    true
    false))

(println (deve-aplicar-desconto? 1000))
(println (deve-aplicar-desconto? 100))

; PREDICATE
(defn aplica-desconto?
  [valor-bruto]
  (if (> valor-bruto 100)
    true
    false))

(println (aplica-desconto? 1000))
(println (aplica-desconto? 100))

(defn valor-descontado
  "Retorna o valor desconto de 10% se o valor bruto for estritamento maior que 100."
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (println "Calculando desconto de" desconto)
      (- valor-bruto desconto))
    valor-bruto))

(defn aplica-desconto?
  [valor-bruto]
  (if (> valor-bruto 100)
    true))

(println (aplica-desconto? 1000))
(println (aplica-desconto? 100))

(defn aplica-desconto?
  [valor-bruto]
  (println "Chamando a versão when")
  (when (> valor-bruto 100)
    true))

(println (aplica-desconto? 1000))
(println (aplica-desconto? 100))

(println (valor-descontado 99))
(println (valor-descontado 500))

(defn aplica-desconto?
  [valor-bruto]
  (println "Chamando a versão direta")
  (> valor-bruto 10))

(println (aplica-desconto? 1000))
(println (aplica-desconto? 100))



(defn mais-caro-que-100?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o valor desconto de 10% se deve aplicar desconto."
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (println "Calculando desconto de" desconto)
      (- valor-bruto desconto))
    valor-bruto))

(println "função como parametro")
(println (valor-descontado mais-caro-que-100? 1000))
(println (valor-descontado mais-caro-que-100? 100))

;Higher order functions
;imutabilidade

(println "função sem nome ")
(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 1000))
(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 100))
(println (valor-descontado (fn [v] (> v 100)) 1000))
(println (valor-descontado (fn [v] (> v 100)) 100))
(println (valor-descontado #(> %1 100) 1000))
(println (valor-descontado #(> %1 100) 100))
(println (valor-descontado #(> % 100) 1000))
(println (valor-descontado #(> % 100) 100))

(defn mais-caro-que-100? (fn [valor-bruto] (> valor-bruto 100)))
(defn mais-caro-que-100? #(> % 100))