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

; REGRAS DIFERENTES PARA TIPOS DIFERENTES
; deve-assinar-pre-autorizacao?
;  Particular ==> => 50
;  PlanoDeSaude ==> procdimento NAO esta no plano


; VANTAGEM: tudo no mesmo lugar
; DESVANTAGEM: TUDO NO MESMO LUGAR, FICA DIFICIL DE MANTER
;(def deve-assinar-pre-autorizacao? [paciente procedimento valor ]
;  (if (= PacienteParticular(type paciente))
;    (>= valor 50)
;    ; assumindo que existe os dois tipos
;    (if (= PacientePlanoDeSaude (type paciente))
;      (let [plano (get paciente :plano)]
;        (not (some #(= % procedimento) plano)))
;      true)))

(defprotocol Cobravel
              (deve-assinar-pre-autorizacao? [paciente procedimento valor]))

(extend-type PacienteParticular
  Cobravel
  (deve-assinar-pre-autorizacao? [paciente, procedimento, valor]
    (>= valor 50)))

(extend-type PacientePlanoDeSaude
  Cobravel
  (deve-assinar-pre-autorizacao? [paciente, procedimento, valor]
    (let [plano (:plano paciente)]
      (not (some #(= % procedimento) plano)))))
; contains? => verifica o indice... e indice voce fica dependendo da estrutura de dados... vetor é numérico


; alternativa seria implementar diretamente

;(defrecord PacientePlanoDeSaude
; [id, nome, nascimento, plano]
;  Cobravel
;  (deve-assinar-pre-autorizacao? [paciente, procedimento, valor]
;    (let [plano (:plano paciente)]
;      (not (some #(= % procedimento) plano)))))

(let [particular (->PacienteParticular 15, "Lauro", "11/03/1996")
      plano (->PacientePlanoDeSaude 15, "Amanda", "22/06/1998",[:raio-x, :ultrasom])]
  (pprint (deve-assinar-pre-autorizacao? particular, :raio-x, 500))
  (pprint (deve-assinar-pre-autorizacao? particular, :raio-x, 40))
  (pprint (deve-assinar-pre-autorizacao? plano, :raio-x, 499990))
  (pprint (deve-assinar-pre-autorizacao? plano, :coleta-de-sangue, 499990)))











