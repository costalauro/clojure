(ns hospital2.aula4
  (:use clojure.pprint)
  (:require [schema.core :as s]))

(s/set-fn-validation! true)

(def PosInt (s/pred pos-int? 'inteiro-positivo))
(def Plano [s/Keyword])
(def Paciente
  {:id PosInt, :nome s/Str, :plano Plano})

(pprint (s/validate Paciente {:id 15, :nome "lauro", :plano [:raio-x, :ultrasom]}))
(pprint (s/validate Paciente {:id 15, :nome "lauro", :plano [:raio-x]}))
(pprint (s/validate Paciente {:id 15, :nome "lauro", :plano []}))
(pprint (s/validate Paciente {:id 15, :nome "lauro", :plano nil}))







