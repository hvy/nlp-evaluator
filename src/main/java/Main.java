import pos.*;
import utils.ResourceManager;

import java.io.*;
import java.util.List;

/**
 * Created by hiroyuki on 21/01/2016.
 */
public class Main {

  public static void main(String[] args) {

    PosEvaluator evaluator = new PosEvaluator();

    PosTagger[] posTaggers = selectTaggers();
    for (PosTagger posTagger : posTaggers) {

      List[] taggedWords = selectTaggedWords();
      PosEvaluation posEvaluation = evaluator.evaluateTaggerWith(posTagger, taggedWords);

      System.out.println(posTagger.getTaggerModel());
      System.out.println(posEvaluation);
      System.out.println();
    }
  }

  private static PosTagger[] selectTaggers() {

    PosTagger left3WordsTagger = new PosTagger(PosTaggerModel.Left3Words);
    PosTagger bidirectionalTagger = new PosTagger(PosTaggerModel.Bidirectional);

    PosTagger[] posTaggers = { left3WordsTagger, bidirectionalTagger };

    return posTaggers;
  }

  private static List<PosWord>[] selectTaggedWords() {

    PosFileParser posFileParser = new PosFileParser();

    File[] taggedFiles = ResourceManager.getResourceFiles("documents/tagged");
    List<PosWord>[] taggedWords = new List[taggedFiles.length];

    for (int i = 0; i < taggedFiles.length; i++) {
      taggedWords[i] = posFileParser.parse(taggedFiles[i]);
    }

    return taggedWords;
  }
}

