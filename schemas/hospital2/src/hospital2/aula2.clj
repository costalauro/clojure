(ns hospital2.aula2
  (:use clojure.pprint)
  (:require [schema.core :as s]))

(s/set-fn-validation! true)

;(s/defrecord Paciente
;  [id :- Long, nome :- s/Str])

;(pprint (map->Paciente {15 "Lauro"}))
;(pprint (map->Paciente {"15" "Lauro"}))

(def Paciente
  "Schema de um paciente"
  {:id s/Num, :nome s/Str})

(pprint (s/explain Paciente))
(pprint (s/validate Paciente {:id 15, :nome "lauro"}))

;typo é pego pelo schema. mas poderiamos argumentar que esse
;tipo de erro seria pego em tester automatizados com cobertura boa
;(pprint (s/validate Paciente {:id 15, :name "lauro"}))


;mas entra a questão de querer ser forward compatible OU NÕa
;entender esse trade-off
;sistemas externos não me quebrarão ao adicionar campos novos (forward compatible)
;no nosso validate não estamos sendo forward compatible (pode ser interessante quando quero analisar mudanças)
;(pprint (s/validate Paciente {:id 15, :nome "lauro", :plano [:raio-x]}))

;chaves que são keyword em schemas são por padrão obrigatórias
;(pprint (s/validate Paciente {:id 15}))

; tipo de retorno com schema
; força a validação na saída da função
;(s/defn novo-paciente :- Paciente
;  [id :- s/Num, nome :- s/Str]
;  { :id id, :nome nome, :plano [] })

(s/defn novo-paciente :- Paciente
  [id :- s/Num, nome :- s/Str]
  {:id id, :nome nome})

(pprint (novo-paciente 15 "lauro"))



; função pura, simples, facil de testar
(defn estritamente-positivo? [x]
  (> x 0))

;(def EstritamentePositivo (s/pred estritamente-positivo?))
(def EstritamentePositivo (s/pred estritamente-positivo? 'estritamente-positivo))

(pprint (s/validate EstritamentePositivo 15))
;(pprint (s/validate EstritamentePositivo 0))
;(pprint (s/validate EstritamentePositivo -15))




(def Paciente
  "Schema de um paciente"
  {:id (s/constrained s/Int pos?), :nome s/Str})
; é por isso que é importante  debulhar documentação
; já existe pos? e já existe pos-int?
; dica é sempre olhar documentação

(pprint (s/validate Paciente {:id 15, :nome "lauro"}))
;(pprint (s/validate Paciente {:id -15, :nome "lauro"}))
;(pprint (s/validate Paciente {:id 0, :nome "lauro"}))

; um caminho que eu não sequiria: lambdas dentro dos schemas
; os nomes ficam confusos ou legibilidade do schema se perde
; além de que você perdeu a facilidade de testar aquele lambda isoladamente
;(def Paciente
;  "Schema de um paciente"
;  {:id (s/constrained s/Int #(> % 0) 'inteiro-estritamente-positivo),
;   :nome s/Str})
;
;(pprint (s/validate Paciente {:id 15, :nome "lauro"}))
;(pprint (s/validate Paciente {:id -15, :nome "lauro"}))
;(pprint (s/validate Paciente {:id 0, :nome "lauro"}))
