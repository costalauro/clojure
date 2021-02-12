(ns hospital.aula2
  (:use clojure.pprint))

;(defrecord Paciente [id, nome, nascimento])

; Paciente Plano de Saude ===> + plano de saude
; Paciente Particular ===> + 0

;caminho horripilante com provaveis problemas horriveis e tipos 2^n
;(defrecord PacientePlanoDeSaude HERDA Paciente [plano])

; digitacao nao eh o maior probvlema da nossa vida
(defrecord PacienteParticular [id, nome, nascimento])
(defrecord PacientePlanoDeSaude [id, nome, nascimento, plano])







