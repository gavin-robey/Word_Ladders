# Word Ladders

## Project Information

Given two words, this program will morph the first given word into the second given word, one letter at a time. For example, below is the output when "hello" and "world" are input: 


```commandline
Enter the first word: hello 
Enter the second word: world 

[hello hells heals weals weald woald world]
```

This project achieves this result using two different algorithms. The first being an exhaustive algorithm. The program will search all one-away words for matches. If there is no match, it will then seach all the one-away words' one-away words until a match is found. The second algorithm used is an A* search algorithm. This algorithm adds a priority to each word, taking into account how different the current word is from the end word. It then adds these words (with the assigned priority) to a priority queue. When searching for new words, only the words with the highest priority are pulled off the queue to form the word ladder. The difference in performance is demonstrated below: 


```commandline
Enter the first word: hello 
Enter the second word: world 

Seeking exhaustive solution from hello -> world
[hello hells heals weals weald woald world] total enqueues 2525
 
Seeking A* solution from hello -> world
[hello hells wells weals weald woald world] total enqueues 127
```

*Using the A\* search algorithm in this case, was almost 20 times faster* 



## Build Instructions

1. Build file by running the following command:
```commandline
gradle build
```
2. Then run the program using: 
```commandline
java -jar build/libs/*.jar
```
