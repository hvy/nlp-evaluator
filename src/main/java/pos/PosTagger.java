package pos;

import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.util.List;

/**
 * A class that is responsible for the POS tagging.
 *
 * @author hvy
 * @version 1.0
 */
public class PosTagger {

  private PosTaggerModel mModel;
  private MaxentTagger mTagger;

  /**
   * Constructor.
   *
   * @param taggerModel The model tagger model.
   */
  public PosTagger(PosTaggerModel taggerModel) {
    mModel = taggerModel;
    mTagger = new MaxentTagger(taggerModel.getModelFilePath());
  }

  /**
   * @return The current model.
   */
  public PosTaggerModel getTaggerModel() {
    return mModel;
  }

  /**
   * Tag the given words by modifying their property values.
   *
   * @param untaggedWords The untagged words that are to be modified and tagger.
   */
  public void tagWords(List<PosWord> untaggedWords) {

    List<TaggedWord> taggedPosWords = mTagger.apply(untaggedWords);

    for (int i = 0; i < taggedPosWords.size(); i++) {
      TaggedWord taggedPosWord = taggedPosWords.get(i);
      untaggedWords.get(i).setTag(taggedPosWord.tag());
    }
  }
}

