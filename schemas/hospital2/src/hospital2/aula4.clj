(ns hospital2.aula4
  (:use clojure.pprint)
  (:require [schema.core :as s]))

(s/set-fn-validation! true)

(def PosInt (s/pred pos-int? 'inteiro-positivo))
(def Plano [s/Keyword])
(def Paciente
  {:id                          PosInt,
   :nome                        s/Str,
   :plano                       Plano
   (s/optional-key :nascimento) s/Str})

(pprint (s/validate Paciente {:id 15, :nome "lauro", :plano [:raio-x, :ultrasom]}))
(pprint (s/validate Paciente {:id 15, :nome "lauro", :plano [:raio-x]}))
(pprint (s/validate Paciente {:id 15, :nome "lauro", :plano []}))
(pprint (s/validate Paciente {:id 15, :nome "lauro", :plano nil}))
(pprint (s/validate Paciente {:id 15, :nome "lauro", :plano [], :nascimento "11/03/1996"}))

; esse é um outro tipo de uso de mapas no mundo real
; Pacientes
; { 15 {paciente} 23 {paciente}}
(def Pacientes
  {PosInt Paciente})

(pprint (s/validate Pacientes {}))

(let [lauro {:id 15, :nome "lauro", :plano [:raio-x, :ultrasom]}
      amanda {:id 20, :nome "amanda", :plano []}]
  (pprint (s/validate Pacientes {15 lauro}))
  (pprint (s/validate Pacientes {15 lauro, 20 amanda}))
  ;(pprint (s/validate Pacientes {-15 lauro}))
  ;(pprint (s/validate Pacientes {15 15}))
  ;(pprint (s/validate Pacientes {15 {:id 15, :nome "Lauro"}}))
  )

(def Visitas
  {PosInt [s/Str]})




