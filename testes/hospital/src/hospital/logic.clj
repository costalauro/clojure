(ns hospital.logic)

; Test Driven Development
; Test Driven Design

;(defn cabe-na-fila?
;  [hospital departamento]
;  (when-let [fila (get hospital departamento)]
;    (-> fila
;        count
;        (< 5)))
;  )


;funciona para o caso de não ter um apartamento
;(defn cabe-na-fila?
;  [hospital departamento]
;  (when-let [fila (get hospital departamento)]
;    (-> fila
;        count
;        (< 5))))

;também funciona mas usa o some->
;desvantagem/vantamente "menos explicito"
;desvantagem qq um que der nil, devolve nil
(defn cabe-na-fila?
  [hospital departamento]
  (some-> hospital
      departamento
      count
      (< 5)))