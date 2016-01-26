# Stanford CoreNLP POS Tagging Evaluation

## About
This is a small program that evaluates the [Stanford CoreNLP](http://stanfordnlp.github.io/CoreNLP/index.html) POS tagging models. The accuracy and the running time is measured.

## Installation
### Prerequisites
* [Java SE 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Apache Maven](https://maven.apache.org) *Tested with Maven 3.3.9*

You need to download the POS tagger models to evaluate and prepare the Penn Tree annotated test data to run the evaluator. Please refer to the README files in the resource subdirectories.

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

