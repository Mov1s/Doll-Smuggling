(ns doll-smuggler.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (println "Test")
)

(declare mm)

(defn m
  "The max value attained with weight less than or equal to w using items up to i"
  [i w dolls]
  (
    ;If you try to find the max weight of 0 items it will always be 0, :P
    if (< i 0) [0 []]

    ;Get the weight and value of the doll at the i position
    (let [{wi :weight vi :value} (nth dolls i)]

      ;If the weight of the doll is greater than the max weight, skip it and try the next doll
      (if (> wi w) (mm (dec i) w dolls)

        (let [[vn nindexes] (mm (dec i) w dolls)
              [vy yindexes] (mm (dec i) (- w wi) dolls)]

          ;If the max value acheivable by taking this doll is greater than the max value achievable without taking this doll
	  ;return the max value for this position (i) and add i to the list of taken indexes
          (if (> (+ vy vi) vn) [(+ vy vi) (conj yindexes  i)]

            ;Otherwise take the max value without this doll and continue the recurrsion
            (mm (dec i) w dolls)
          )        
        )
      )
    )
  )
)

(def mm (memoize m))

(defn formatdolls
  "Turns a list of doll info into a list of dictionaries of dolls"
  [dolls]
  (map (fn [[name weight value]] {:name name :weight weight :value value}) (partition 3 dolls))
)

(defn knapsack
  "Finds the best combination of dolls to give the most value for a max weight"
  [maxWeight dolls]
  (let [formatteddolls (formatdolls dolls)
        dollcount (dec (count formatteddolls))]
    (m dollcount maxWeight formatteddolls)
  )
)

