package questionnaire;

/**
 * Create a YesNo class which only take Yes No as the answer.
 */
public class YesNo extends AbstractQuestion implements Question {

  /**
   * Create the constructor for the Question.
   */
  public YesNo(String question, boolean required) throws IllegalArgumentException {
    super(question, required);
  }

  @Override
  public Question copy() {
    Question yesNoQuestion = new YesNo(getPrompt(), isRequired());
    if (!getAnswer().equals("")) {
      yesNoQuestion.answer(getAnswer());
    }
    return yesNoQuestion;
  }
}
