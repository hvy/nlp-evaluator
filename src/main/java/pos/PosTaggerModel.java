package pos;

/**
 * Created by hiroyuki on 25/01/2016.
 */
public enum PosTaggerModel {

  Bidirectional("models/english-bidirectional-distsim.tagger"),
  Left3Words("models/english-left3words-distsim.tagger");

  private final String modelFilePath;

  PosTaggerModel(String modelFilePath) {
    this.modelFilePath = modelFilePath;
  }

  public String getModelFilePath() {
    return modelFilePath;
  }

  @Override
  public String toString() {
    return "Model: " + this.name();
  }
}

