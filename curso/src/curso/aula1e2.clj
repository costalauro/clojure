(ns curso.aula1e2)

(defn imprime-mensagem []
  (println "-----------------------")
  (println "Bem vindo(a) ao estoque"))

(imprime-mensagem)



(defn aplica-desconto [valor-bruto]
  (* valor-bruto 0.9))

(aplica-desconto 100)


(defn valor-descontado 
  "Retorna o valor descontado que é 90% do valor bruto"
  [valor-bruto]
  (* valor-bruto 0.9))

(defn valor-descontado 
  "Retorna o valor desconto de 10%."
  [valor-bruto]
  (* valor-bruto (- 1 0.10)))

(defn valor-descontado 
  "Retorna o valor desconto de 10%."
  [valor-bruto]
  (def desconto 0.10)
  (* valor-bruto (- 1 desconto)))

(defn valor-descontado 
  "Retorna o valor desconto de 10%."
  [valor-bruto]
  (def desconto 0.10)
  (* valor-bruto (- 1 desconto)))

(defn valor-descontado 
  "Retorna o valor desconto de 10%."
  [valor-bruto]
  (let [desconto 0.10])
  (* valor-bruto (- 1 desconto)))

(defn valor-descontado 
  "Retorna o valor desconto de 10%."
  [valor-bruto]
  (let [desconto 0.10]
  	(* valor-bruto (- 1 desconto))))

(defn valor-descontado 
  "Retorna o valor desconto de 10%."
  [valor-bruto]
  (let [desconto (/ 10 100)]
  	(* valor-bruto (- 1 desconto))))

(defn valor-descontado 
  "Retorna o valor desconto de 10%."
  [valor-bruto]
  (let [taxa-de-desconto (/ 10 100)
  		desconto         (* valor-bruto taxa-de-desconto)]
  	(println "Calculando desconto de" desconto)
  	(- valor-bruto desconto)))


(valor-descontado 100)

(defn valor-descontado 
  "Retorna o valor desconto de 10% se o valor bruto for estritamento maior que 100."
  [valor-bruto]
  (if (> valor-bruto 100)
	 		(let [taxa-de-desconto (/ 10 100)
									desconto         (* valor-bruto taxa-de-desconto)]
	  			(println "Calculando desconto de" desconto)
	  			(- valor-bruto desconto))
				valor-bruto))

(valor-descontado 99)
(valor-descontado 500)


 (if (> 500 100)
 	(println "maior")
 	(println "menor ou igual"))

 (if (> 50 100)
 	(println "maior")
 	(println "menor ou igual"))