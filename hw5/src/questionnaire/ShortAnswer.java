package questionnaire;

/**
 * Create a short answer class which take answer at most 280 characters.
 */
public class ShortAnswer extends AbstractQuestion implements Question {
  private String answer;

  /**
   * Create the constructor for the Question.
   */
  public ShortAnswer(String question, boolean required) throws IllegalArgumentException {
    super(question, required);
    this.answer = "";
  }

  @Override
  public void answer(String answer) throws IllegalArgumentException {
    if (answer != null && !answer.equals("")) {
      if (answer.length() > 280) {
        this.answer = "";
        throw new IllegalArgumentException("Length of the answer is less than or equal to 280");
      }
      else {
        this.answer = answer;
      }
    }
    else if (answer == null) {
      throw new IllegalArgumentException("Short answer is null");
    };
  }

  @Override
  public String getAnswer() {
    return this.answer;
  }

  @Override
  public Question copy() {
    Question shortAnswerQuestion = new ShortAnswer(getPrompt(), isRequired());
    if (!getAnswer().equals("")) {
      shortAnswerQuestion.answer(getAnswer());
    }
    return shortAnswerQuestion;
  }
}
