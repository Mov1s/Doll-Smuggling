# doll_smuggler

My adventure in Clojure with the knapsack problem

## Problem Background
You are a drug trafficker. Every day you meet with a different nice older lady (the mule) and find out how much weight she can carry in her handbag. You then meet with your supplier who has packed various drugs into a myriad of collectible porcelain dolls. Once packed with drugs, each of the precious dolls has a unique combination of weight and street value. Sometimes your supplier has more dolls than the nice lady can carry, though space in her handbag is never an issue. Your job is to choose which dolls the kind soul will carry, maximizing street value, while not going over her weight restriction.

## Usage

To verify its behavior, multiple high-level test cases have been provided. To run the tests simply run the following command from the project root directory.
```
$ lein test
```

If you would like to run it manually against various inputs it is easiest to do from the REPL. From the project root directory type:
```
$ lein repl
```

Once in the REPL you can run my solution against various inputs in a few different ways.

The easiest way is just to use the `knapsack-unformatted` function. The first argument is the max weight the old lady can carry, the second argument is a flat list of values in the form of name, weight, value. The function will print out the parameters of the problem as well as the final selction of dolls it has chosen to maximize the value of the old lady's load. The very last line of the output is the actual solution the function generates, it is the same thing as the more human readble table version printed right above it.
```
doll-smuggler.core=> (knapsack-unformatted 40 ["Ryan" 10 34 "Kevin" 23 11 "Sara" 2 4 "Jim" 38 100 "Kelly" 5 12])

Max weight: 40

Available dolls:

| :name | :weight | :value |
|-------+---------+--------|
|  Ryan |      10 |     34 |
| Kevin |      23 |     11 |
|  Sara |       2 |      4 |
|   Jim |      38 |    100 |
| Kelly |       5 |     12 |


Packed dolls:

| :name | :weight | :value |
|-------+---------+--------|
|  Sara |       2 |      4 |
|   Jim |      38 |    100 |
({:name "Sara", :weight 2, :value 4} {:name "Jim", :weight 38, :value 100})
doll-smuggler.core=> 
```

You can also run it against a doll list with a little more formatting like so.
```
doll-smuggler.core=> (knapsack 40 [{:name "Ryan" :weight 10 :value 34}
                #_=> {:name "Kevin" :weight 23 :value 11}
                #_=> {:name "Sara" :weight 2 :value 4}
                #_=> {:name "Jim" :weight 38 :value 100}
                #_=> {:name "Kelly" :weight 5 :value 12}])

Max weight: 40

Available dolls:

| :name | :value | :weight |
|-------+--------+---------|
|  Ryan |     34 |      10 |
| Kevin |     11 |      23 |
|  Sara |      4 |       2 |
|   Jim |    100 |      38 |
| Kelly |     12 |       5 |


Packed dolls:

| :name | :value | :weight |
|-------+--------+---------|
|  Sara |      4 |       2 |
|   Jim |    100 |      38 |
({:name "Sara", :value 4, :weight 2} {:name "Jim", :value 100, :weight 38})
doll-smuggler.core=> 
```

## My Adventure
I first started reading a few articles and tutorials on Clojure. Chiefly these two:
https://aphyr.com/posts/302-clojure-from-the-ground-up-basic-types
http://www.braveclojure.com/do-things/

I then went to wikipedia, which showed me the algorithm I used to solve the problem.
http://en.wikipedia.org/wiki/Knapsack_problem#0.2F1_knapsack_problem

Feeling like I had a good grasp of the syntax I wrote my first version of this solution. It returned the max value of the dolls as an integer but not the names of the dolls it chose. As I tried to modify my solution to keep track of the chosen dolls I started to struggle with Clojure and my object-oriented thought process. I sought some guidance and found this example showing a possible solution to the problem in Clojure.
http://rosettacode.org/wiki/Knapsack_problem/0-1#Clojure

It's use of `let` instead of the `max` solution I had been using turned out to be the missing piece I needed to keep track of the dolls chosen by the algorithm instead of just the values. Also its use of `memoize` contributed to the speed of my solution.

After everything was working and I had written some tests to prove it, I refactored the functions and added the table printing behavior you see above to allow easy interpretation of the results.

This was an interesting challenge and I came out of it with two major take-a-ways:
  1. Clojure is frustrating for the first 8 hours
  2. I should continue to solve problems with it until it is not...
