package pos;

import edu.stanford.nlp.ling.HasWord;

/**
 * Created by hiroyuki on 26/01/2016.
 */
public class PosWord implements HasWord {

  private String mWord;
  private String mTag;

  public PosWord(String word) {
    this(word, null);
  }

  public PosWord(String word, String tag) {
    mWord = word;
    mTag = tag;
  }

  public String word() {
    return mWord;
  }

  public void setWord(String word) {
    mWord = word;
  }

  public String tag() {
    return mTag;
  }

  public void setTag(String tag) {
    mTag = tag;
  }
}

