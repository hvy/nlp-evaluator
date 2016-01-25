package pos;

import edu.stanford.nlp.ling.HasWord;

/**
 * A class that stores a POS word and its optional tag.
 *
 * It implements the Stanford CoreNLP HasWord interface to be able to act as an interface between the evaluator and
 * the Stanford NLP service.
 *
 * @author hvy
 * @version 1.0
 */
public class PosWord implements HasWord {

  private String mWord;
  private String mTag;

  /**
   * Constructor. No tag is specified when using this constructor.
   *
   * @param word The word.
   */
  public PosWord(String word) {
    this(word, null);
  }

  /**
   * Constructor.
   *
   * @param word The word.
   * @param tag The tag of this word.
   */
  public PosWord(String word, String tag) {
    mWord = word;
    mTag = tag;
  }

  /**
   * Implements the interface.
   *
   * @return The word.
   */
  public String word() {
    return mWord;
  }

  /**
   * Implements the interface.
   *
   * @param word The word.
   */
  public void setWord(String word) {
    mWord = word;
  }

  /**
   * @return The tag of this word.
   */
  public String tag() {
    return mTag;
  }

  /**
   * @param tag The tag of this word.
   */
  public void setTag(String tag) {
    mTag = tag;
  }
}

