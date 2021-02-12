(ns hospital.core
  (:use [clojure pprint])
  (:require [hospital.model :as h.model]))
;espera FILA DE ESPERA

; lab1 3
; lab2 2
; lab3


(let [hospital-do-lauro (h.model/novo-hospital)]
  (pprint hospital-do-lauro))
