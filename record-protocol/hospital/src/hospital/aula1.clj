(ns hospital.aula1
  (:use clojure.pprint))

(defn adiciona-paciente
  "Os pacientes são um mapa da seguinte forma { 15 {paciente}, 23 {paciente 23}}
  O paciente { :15 ....}"
  [pacientes paciente]
  (if-let [id (:id paciente)]
    (assoc pacientes id paciente)
    (throw (ex-info "Paciente não possui id" {:paciente paciente}))))

(defn testa-uso-de-pacientes []
  (let [pacientes {}
        lauro {:id 15 :nome "lauro" :nascimento "11/03/1996"}
        amanda {:id 20 :nome "amanda" :nascimento "22/06/1998"}
        matheus {:nome "matheus" :nascimento "20/03/2000"}]
    (pprint (adiciona-paciente pacientes lauro))
    (pprint (adiciona-paciente pacientes amanda))
    (pprint (adiciona-paciente pacientes matheus))))

;(testa-uso-de-pacientes)

(defrecord Paciente [id nome nascimento])


(println (->Paciente 15 "Lauro" "11/03/1996"))
(pprint (->Paciente 15 "Lauro" "11/03/1996"))
(pprint (Paciente. 15 "Lauro" "11/03/1996"))
(pprint (map->Paciente {:id 15, :nome "Lauro", :nascimento "11/03/1996"}))



(let [lauro (->Paciente 15 "lauro" "11/03/1996")]
  (println (:id lauro))
  (println (vals lauro))
  (println (class lauro))
  (println (record? lauro))
  (println (.nome lauro)))

(pprint (map->Paciente {:id 15, :nome "Lauro", :nascimento "11/03/1996" :rg "2222222222"}))
;(pprint (Paciente.  "Lauro" "11/03/1996"))
(pprint (Paciente. nil "Lauro" "11/03/1996"))
(pprint (map->Paciente {:nome "Lauro", :nascimento "11/03/1996" :rg "2222222222"}))

(pprint (assoc (Paciente. nil "Lauro" "11/03/1996") :id 38))
(pprint (class (assoc (Paciente. nil "Lauro" "11/03/1996") :id 38)))

; Thread/sleep já havia utilizado interoperabilidade
(pprint (= (->Paciente 15 "Lauro" "11/03/1996") (->Paciente 15 "Lauro" "11/03/1996")))
(pprint (= (->Paciente 13 "Lauro" "11/03/1996") (->Paciente 15 "Lauro" "11/03/1996")))











