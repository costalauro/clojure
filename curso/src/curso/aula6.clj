(ns curso.aula6)

(def pedido {:mochila { :quantidade 2, :preco 80}
             :camiseta { :quantidade 3, :preco 40}})

(defn imprire-e-15 [valor]
  (println "valor" (class valor)valor)
  15)

(println (map imprire-e-15 pedido))

;(defn imprire-e-15 [chave valor]
;  (println chave "e" valor)
;  15)
;
;(println (map imprire-e-15 pedido))

(defn imprire-e-15 [[chave valor]]
  (println chave "<e>" valor)
  15)

;(println (map imprire-e-15 pedido))

(defn imprire-e-15 [[chave valor]]
  valor)

(println (map imprire-e-15 pedido))

(defn preco-dos-produtos [[_ valor]]                        ;utilize _ quando nao for utilizar o parametro
  (*(:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))
(println (reduce + (map preco-dos-produtos pedido)))

(defn total-do-pedido
  [pedido]
  (reduce + (map preco-dos-produtos pedido)))

;(println "total do pedido" (total-do-pedido pedido))

(defn preco-total-do-produto [produto]
  (*(:quantidade produto) (:preco produto)))

(defn total-do-pedido
  [pedido]
  (->> pedido                                               ;thread last para passar o parametro depois da funcao
        vals
       (map preco-total-do-produto)
       (reduce +)))

(println "total do pedido" (total-do-pedido pedido))




(def pedido {:mochila { :quantidade 2, :preco 80}
             :camiseta { :quantidade 3, :preco 40}
             :chaveiro { :quantidade 1}})


(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(println "filtrando gratuitos")
(println (filter gratuito? (vals pedido)))
(println (filter (fn [[chave item]] (gratuito? item)) pedido))
(println (filter #(gratuito? (second %))pedido))

(defn pago?
  [item]
  (not (gratuito? item)))

(println (pago? {:preco 50}))
(println (pago? {:preco 0}))

(println ((comp not gratuito?) {:preco 50}))

(defn pago? (comp not gratuito?))
(println (pago? {:preco 50}))
(println (pago? {:preco 0}))





