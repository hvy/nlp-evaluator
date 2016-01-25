# Stanford CoreNLP POS Tagging Evaluation

## About


## Installation
### Prerequisites
* [Java SE 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Apache Maven](https://maven.apache.org) *Tested with Maven 3.3.9*

### Installation
Run the following commands to clone the repository and install the evaluator in the current working directory.

```
git clone https://github.com/hvy/nlp-evaluator.git
cd nlp-evaluator
mvn install
```

### Run
Assuming that the installation was successful, run the following commands to start the evaluation.

```
mvn exec:java -Dexec.mainClass="Main"
```

