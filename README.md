# Matchin
---

Matchin is a java app, which reads lines from a text file and matches each with three different matchers. Every matcher has similar set of patterns, read from a file. The first matcher returns only full line matches, the second returns partial matches as well and the third matcher uses Levenshtein distance algorithm to find matches with a distance less, or equal than 1.

## Usage
### Prepare
Before running you need to set a correct JAVA_HOME variable. It shoulld point to a java8 installation folder. 

```sh
$ export JAVA_HOME=<path_to_java_folder>
$ cd searchin
$ mvn install
```

### Run
```sh
$ mvn exec:java
```
