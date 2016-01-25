package pos;

import edu.stanford.nlp.trees.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class responsible for parsing Penn Tree annotated text files into word objects.
 *
 * @author hvy
 * @version 1.0
 */
public class PosFileParser {

  /**
   * Constructor.
   */
  public PosFileParser() {
  }

  /**
   * Parse the given Penn Tree annotated file and return a list of words with their corresponding tags.
   *
   * @param file The Penn Tree annotated file.
   * @return A list of words with their corresponding tags.
   */
  public List<PosWord> parsePennTree(File file) {

    List<PosWord> words = new ArrayList<>();

    Treebank treebank = new DiskTreebank(in -> {
      return new PennTreeReader(in, new LabeledScoredTreeFactory(),
          new NPTmpRetainingTreeNormalizer());
    });

    treebank.loadPath(file);

    // Convert the Stanford CoreNLP TaggedWord objects into PosWords and add all of them to the returning array.
    for (Tree tree : treebank) {
      words.addAll(tree.taggedYield()
          .stream()
          .map(taggedWord -> new PosWord(taggedWord.word(), taggedWord.tag()))
          .collect(Collectors.toList())
      );
    }

    return words;
  }
}

