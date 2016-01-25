package pos;

import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import edu.stanford.nlp.trees.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hiroyuki on 25/01/2016.
 */
public class PosTagger {

  private PosTaggerModel mModel;
  private MaxentTagger mTagger;

  public PosTagger(PosTaggerModel taggerModel) {
    mModel = taggerModel;
    mTagger = new MaxentTagger(taggerModel.getModelFilePath());
  }

  public PosTaggerModel getTaggerModel() {
    return mModel;
  }

  public void tagWords(List<PosWord> untaggedWords) {

    List<TaggedWord> taggedPosWords = mTagger.apply(untaggedWords);

    for (int i = 0; i < taggedPosWords.size(); i++) {
      TaggedWord taggedPosWord = taggedPosWords.get(i);

      // Add a tag the object that was passed as an argument.
      untaggedWords.get(i).setTag(taggedPosWord.tag());
    }
  }
}

