package pos;

import utils.StopWatch;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A class that stores the evaluations results.
 *
 * @author hvy
 * @version 1.0
 */
public class PosEvaluator {

  /**
   * Constructor.
   */
  public PosEvaluator() {
  }

  /**
   * Run a POS tagger evaluation.
   *
   * @param tagger The POS tagger that is to be evaluated.
   * @param taggedDocumentWords The list of tagged document words.
   * @return The evaluation results.
   */
  public PosEvaluation evaluateTaggerWith(PosTagger tagger, List<PosWord>[] taggedDocumentWords) {

    float totalTimeMs = 0;
    int numTotalWords = 0;
    int numCorrectWords = 0;

    StopWatch stopWatch = new StopWatch();

    // For each document, get their lists of words.
    for (List<PosWord> targetWords : taggedDocumentWords) {

      // Create a copy but without the target tags.
      List<PosWord> taggingWords = targetWords
          .stream()
          .map(taggedWord -> new PosWord(taggedWord.word()))
          .collect(Collectors.toList());

      // Start the time measurer and do the POS tagging.
      stopWatch.start();
      tagger.tagWords(taggingWords);
      totalTimeMs += stopWatch.stop();

      for (int i = 0; i < targetWords.size(); i++) {

        assert(targetWords.get(i).word().equals(taggingWords.get(i).word()));

        String targetWordTag = targetWords.get(i).tag();
        String taggedWordTag = taggingWords.get(i).tag();
        if (targetWordTag.equals(taggedWordTag)) {
          numCorrectWords++;
        }
      }
      numTotalWords += targetWords.size();
    }

    float accuracy = (float) numCorrectWords / (float) numTotalWords;
    return new PosEvaluation(accuracy, totalTimeMs);
  }
}

