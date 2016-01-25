import pos.*;
import utils.ResourceManager;

import java.io.*;
import java.util.List;

/**
 * The main class responsible for starting the evaluation.
 *
 * @author hvy
 * @version 1.0
 */
public class Main {

  /**
   * Main method.
   *
   * @param args System arguments.
   */
  public static void main(String[] args) {

    PosEvaluator evaluator = new PosEvaluator();
    PosTagger[] posTaggers = selectTaggers();

    for (PosTagger posTagger : posTaggers) {
      List[] taggedDocuments = selectTaggedDocuments();
      PosEvaluation posEvaluation = evaluator.evaluateTaggerWith(posTagger, taggedDocuments);

      System.out.println(posTagger.getTaggerModel());
      System.out.println(posEvaluation);
      System.out.println();
    }
  }

  /**
   * Should be implemented such that it returns the POS taggers with their corresponding models that are to be evaluated.
   *
   * @return The POS taggers to evaluate.
   */
  private static PosTagger[] selectTaggers() {

    PosTagger left3WordsTagger = new PosTagger(PosTaggerModel.Left3Words);
    PosTagger bidirectionalTagger = new PosTagger(PosTaggerModel.Bidirectional);
    PosTagger[] posTaggers = { left3WordsTagger, bidirectionalTagger };

    return posTaggers;
  }

  /**
   * Should be implemented such that it returns a List of PosWords per document that is to be used for the evaluation.
   *
   * @return A List of PosWords per documents.
   */
  private static List<PosWord>[] selectTaggedDocuments() {

    PosFileParser posFileParser = new PosFileParser();
    File[] taggedPennTreeFiles = ResourceManager.getResourceFiles("documents/tagged");
    List<PosWord>[] taggedDocuments = new List[taggedPennTreeFiles.length];

    for (int i = 0; i < taggedPennTreeFiles.length; i++) {
      taggedDocuments[i] = posFileParser.parsePennTree(taggedPennTreeFiles[i]);
    }

    return taggedDocuments;
  }
}

