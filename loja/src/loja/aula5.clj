(ns loja.aula5
  (:require [loja.db :as l.db]
            [loja.logic :as l.logic]))

(defn gastou-batante? [info-do-usuario]
  (> (:preco-total info-do-usuario)500))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuarios pedidos)]
      (println "keep" (keep gastou-batante? resumo))
      (println "filter" (filter gastou-batante? resumo)))

(println "tentando entender dentro do keep e do filter")

(defn gastou-batante? [info-do-usuario]
  (println "gastou bastante?" (:usuario-id info-do-usuario))
  (> (:preco-total info-do-usuario)500))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuarios pedidos)]
  (println "keep" (keep gastou-batante? resumo))
  ;(println "filter" (filter gastou-batante? resumo)
           )

(println "vamos isolar ...")


(println (range 10))
(println (take 2 (range 10000000000)))
; a sequencia nao esta sendo "gulosa" (eager)
(let [sequencia (range 10000000)]
  (println (take 2 sequencia))
  (println (take 2 sequencia)))                             ;imutalibidade, sequencia e a mesma
;esta sendo LAZY (preguiçoso)





(defn filtro1 [x]
  (println "filtro1" x)
  x)

(println (map filtro1 (range 10)))

(defn filtro2 [x]
  (println "filtro2" x)
  x)

(println (map filtro2(map filtro1 (range 10))))

(->> (range 10)
     (map filtro1)
     (map filtro2)
     println)







; CHUNKS de 32
(->> (range 50)
     (map filtro1)
     (map filtro2)
     println)


(->> (range 50)
     (mapv filtro1)
     (mapv filtro2)
     println)

(->> [0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49]
     (mapv filtro1)
     (mapv filtro2)
     println)

;lista ligada foi 100% lazy nesse cenario
(->> '(0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49)
     (map filtro1)
     (map filtro2)
     println)

