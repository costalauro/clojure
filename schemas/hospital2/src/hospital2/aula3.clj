(ns hospital2.aula3
  (:use clojure.pprint)
  (:require [schema.core :as s]))

(s/set-fn-validation! true)

(def PosInt (s/pred pos-int? 'inteiro-positivo))

(def Paciente
  {:id PosInt, :nome s/Str})

(s/defn novo-paciente :- Paciente
  [id :- (s/pred pos-int?)
   nome :- s/Str]
  {:id id, :nome nome})

(pprint (novo-paciente 15, "lauro"))
;(pprint (novo-paciente -5, "lauro"))

(defn maior-ou-igual-a-zero? [x] (>= x 0))
(def ValorFinanceiro (s/constrained s/Num maior-ou-igual-a-zero?))

(def Pedido
  {:paciente     Paciente
   :valor        ValorFinanceiro
   :procedimento s/Keyword})

; será que faz sentido "mini-schemas" como aliases
; (def procedimento s/Keyword)

(s/defn novo-pedido :- Pedido
  [paciente     :- Paciente,
   valor        :- ValorFinanceiro,
   procedimento :- s/Keyword]
  {:paciente paciente, :valor valor, :procedimento procedimento})

(pprint (novo-pedido (novo-paciente 15, "lauro"), 15.53, :raio-x))
; (pprint (novo-pedido (novo-paciente 15, "lauro"), -15.53, :raio-x))


(def Numeros [s/Num])
(pprint (s/validate Numeros [15]))
(pprint (s/validate Numeros [15,13]))
(pprint (s/validate Numeros [15,13, 123, 123434,123213,1234324]))
(pprint (s/validate Numeros [0]))
; nil não é número, não faz sentido
;(pprint (s/validate Numeros [nil]))
(pprint (s/validate Numeros []))
(pprint (s/validate Numeros nil))

; nil não é s/Num
; (pprint (s/validate s/Num nil))
; nil é s/Num
(pprint (s/validate [s/Num] nil))


(def Plano [s/Keyword])
(pprint (s/validate Plano [:raio-x]))

(def Paciente
  {:id PosInt, :nome s/Str, :plano Plano})

(pprint (s/validate Paciente {:id 15, :nome "lauro", :plano [:raio-x, :ultrasom]}))
(pprint (s/validate Paciente {:id 15, :nome "lauro", :plano [:raio-x]}))
(pprint (s/validate Paciente {:id 15, :nome "lauro", :plano []}))
(pprint (s/validate Paciente {:id 15, :nome "lauro", :plano nil}))
; plano é uma keyword obrigatória no mapa, mas elas pode ter um valor vazio (nil, [])
; (pprint (s/validate Paciente {:id 15, :nome "lauro"}))



