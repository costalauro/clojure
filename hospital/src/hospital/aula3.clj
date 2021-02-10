(ns hospital.aula3
  (:use [clojure pprint])
  (:require [hospital.model :as h.model]
            [hospital.logic :as h.logic]))

;;simbolo que qq thread que esse namespace pode alterar
;(def nome "lauro")
;
;;redefinir simbolo (refiz o binding)
;(def nome 32423423)
;
;(let nome ["lauro"]
;     ; coisa 1
;     ; coisa 2
;     (pprint nome)
;     ; nao estou refazendo o binding do simbolo local
;     ; criando um novo simbolo locao a este bloco e escondendo o anterior
;     ; SHADOWING
;     (let [nome "amanda"]
;       ;coisa 3
;       ;coisa 4
;       (pprint nome))
;     (pprint nome))

(defn testa-atomao []
  (let [hospital-silveira (atom {:espera h.model/fila_vazia})]
    (pprint hospital-silveira)
    (pprint (deref hospital-silveira))
    (pprint @hospital-silveira)

    ;não é assim que eu altero o conteúdo dentro de um atomo
    (pprint (assoc @hospital-silveira :laboratorio1 h.model/fila_vazia))
    (pprint @hospital-silveira)

    ;essa eh (uma das) a maneira de alterar conteudo dentro de um atomo
    (swap! hospital-silveira assoc :laboratorio1 h.model/fila_vazia)
    (pprint @hospital-silveira)

    (swap! hospital-silveira assoc :laboratorio2 h.model/fila_vazia)
    (pprint @hospital-silveira)

    ; update tradicional imutavel, com dereferencia, que nao trata efeito
    (update @hospital-silveira :laboratorio1 conj "111")

    ;indo pra swap
    (swap! hospital-silveira update :laboratorio1 conj "111")
    (pprint hospital-silveira)

    ))

;(testa-atomao)

(defn chega-em-malvado! [hospital pessoa]
  (swap! hospital h.logic/chega-em-pausado-logando :espera pessoa)
  (println "apos inserir" pessoa))


(defn simula-um-dia-em-paralelo
  []
  (let [hospital (atom (h.model/novo-hospital))]
    (.start (Thread. (fn [] (chega-em-malvado! hospital "111"))))
    (.start (Thread. (fn [] (chega-em-malvado! hospital "222"))))
    (.start (Thread. (fn [] (chega-em-malvado! hospital "333"))))
    (.start (Thread. (fn [] (chega-em-malvado! hospital "444"))))
    (.start (Thread. (fn [] (chega-em-malvado! hospital "555"))))
    (.start (Thread. (fn [] (chega-em-malvado! hospital "666"))))
    (.start (Thread. (fn [] (Thread/sleep 8000)
                       (pprint hospital))))))

;forçando situalcoes de retry
;(simula-um-dia-em-paralelo)

(defn chega-em-bonzinho! [hospital pessoa]
  (swap! hospital h.logic/chega-em :espera pessoa)
  (println "apos inserir" pessoa))


(defn simula-um-dia-em-paralelo
  []
  (let [hospital (atom (h.model/novo-hospital))]
    (.start (Thread. (fn [] (chega-em-bonzinho! hospital "111"))))
    (.start (Thread. (fn [] (chega-em-bonzinho! hospital "222"))))
    (.start (Thread. (fn [] (chega-em-bonzinho! hospital "333"))))
    (.start (Thread. (fn [] (chega-em-bonzinho! hospital "444"))))
    (.start (Thread. (fn [] (chega-em-bonzinho! hospital "555"))))
    (.start (Thread. (fn [] (chega-em-bonzinho! hospital "666"))))
    (.start (Thread. (fn [] (Thread/sleep 8000)
                       (pprint hospital))))))

; sem forçar situalcoes de retry (busy retry), pode acontecer, mas pode nao acontecer 
(simula-um-dia-em-paralelo)