package pos;

/**
 * An enum class storing information about available POS tagger models.
 *
 * @author hvy
 * @version 1.0
 */
public enum PosTaggerModel {

  // Generally, slow but accurate.
  Bidirectional("models/english-bidirectional-distsim.tagger"),

  // Generally, fast and accurate, but less accurate than the bidirectional model.
  Left3Words("models/english-left3words-distsim.tagger");

  private final String modelFilePath;

  /**
   * Private constructor.
   *
   * @param modelFilePath The file path to the model file.
   */
  PosTaggerModel(String modelFilePath) {
    this.modelFilePath = modelFilePath;
  }

  /**
   * @return The model file path.
   */
  public String getModelFilePath() {
    return modelFilePath;
  }

  /**
   * @return A formatted String.
   */
  @Override
  public String toString() {
    return "Model: " + this.name();
  }
}

