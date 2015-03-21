(ns doll-smuggler.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn m
  "The max value attained with weight less than or equal to w using items up to i"
  [i w weight v]
  (if (= i 0)
    0
    (if (> (nth w (dec i)) weight) (m (dec i) w weight v)
      (max (m (dec i) w weight v) (+ (m (dec i) w (- weight (nth w (dec i))) v) (nth v (dec i))))
    )
  )
)

(defn knapsack
  "Finds the best combination of dolls to give the most value for a max weight"
  [maxWeight dolls]
  (let [dollcount (count dolls)
        weights (map (fn [doll] (doll :weight)) dolls)
        values (map (fn [doll] (doll :value)) dolls)]
    (m dollcount weights maxWeight values)
  )
)

