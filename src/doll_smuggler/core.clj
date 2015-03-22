(ns doll-smuggler.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (println "Test")
)

(defn m
  "The max value attained with weight less than or equal to w using items up to i"
  [i w weight v chosenIndexes]
  (if (= i 0)
    0
    (if (> (nth w (dec i)) weight)
      (m (dec i) w weight v chosenIndexes)
      (let [ notThis (m (dec i) w weight v chosenIndexes)
             this (+ (m (dec i) w (- weight (nth w (dec i))) v chosenIndexes) (nth v (dec i))) ]
        (if (>= notThis this) notThis
	   (do (conj chosenIndexes (dec i)) this))
      )
    )
  )
)

(defn formatdolls
  "Turns a list of doll info into a list of dictionaries of dolls"
  [dolls]
  (map (fn [[name weight value]] {:name name :weight weight :value value}) (partition 3 dolls))
)

(defn knapsack
  "Finds the best combination of dolls to give the most value for a max weight"
  [maxWeight dolls]
  (let [dollcount (count dolls)
        weights (map (fn [doll] (doll :weight)) dolls)
        values (map (fn [doll] (doll :value)) dolls)]
    ;(m dollcount weights maxWeight values)
    '(test 4 10)
  )
)

