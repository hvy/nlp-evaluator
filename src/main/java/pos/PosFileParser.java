package pos;

import edu.stanford.nlp.trees.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hiroyuki on 26/01/2016.
 */
public class PosFileParser {

  public PosFileParser() {
  }

  public List<PosWord> parse(File file) {
    Treebank treebank = new DiskTreebank(in -> {
      return new PennTreeReader(in, new LabeledScoredTreeFactory(),
          new NPTmpRetainingTreeNormalizer());
    });

    treebank.loadPath(file);

    List<PosWord> words = new ArrayList<>();
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
