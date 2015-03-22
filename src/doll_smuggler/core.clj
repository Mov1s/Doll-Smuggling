(ns doll-smuggler.core
  (:gen-class))
(use 'clojure.pprint)

(declare mm)

(defn m
  "The max value attained with weight less than or equal to w using items up to i
   This expects dolls to be formatted and it will return a list of the following format:
   (399 [1 2 3 4 10]) Where the first item is the total weight of the chosen dolls and the
   second item is the indexes of the dolls chosen to get that weight."
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

;Neat little trick I found online for cacheing the results of a method when the same arguments are used
;brought this recursive function from unbearably slow to pretty quick
(def mm (memoize m))

(defn format-dolls
  "Turns a list of doll info into a list of dictionaries of dolls"
  [dolls]
  (map (fn [[name weight value]] {:name name :weight weight :value value}) (partition 3 dolls))
)

(defn filter-by-index
  "Takes a list and creates a new list using only the given indexes"
  [items indexes]
  (map (partial nth items) indexes))

(defn print-problem
  "Takes a formatted list of dolls, a formatted solution, and a max weight and prints the entire problem
   in an easily readable format."
  [maxWeight dolls solution]
  (println (str "\nMax weight: " maxWeight))
  (println "\nAvailable dolls:")
  (print-table dolls)
  (println "\n\nPacked dolls:")
  (print-table solution)
)

(defn knapsack
  "Takes a formatted list of dolls and the max weight the old lady can carry and
   finds the best combination of dolls to give the most value for that weight.
   Prints out the entire problem including the solution. Returns a formatted list of dolls."
  [maxWeight dolls]
  (let [dollcount (dec (count dolls)) solution (m dollcount maxWeight dolls) solutionDolls (filter-by-index dolls (nth solution 1))]
    (print-problem maxWeight dolls solutionDolls)
    solutionDolls
  )
)

(defn knapsack-unformatted
  "Takes an unformatted list of dolls and the max weight the old lady can carry and
   finds the best combination of dolls to give the most value for that weight.
   Prints out the entire problem including the solution. Returns a formatted list of dolls."
   [maxWeight dolls]
   (knapsack maxWeight (format-dolls dolls))
)

(defn -main
  "Shortcut for using knapsack-unformatted"
  [maxWeight dolls]
  (knapsack-unformatted maxWeight dolls)
)