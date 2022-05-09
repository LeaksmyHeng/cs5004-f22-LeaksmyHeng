package questionnaire;

/**
 * Create an abstract class for all three types of questions.
 */
public abstract class AbstractQuestion implements Question {
  private String question;
  private boolean required;
  private String answer;

  /**
   * Create the constructor for the Question.
   */
  public AbstractQuestion(String question, boolean required) throws IllegalArgumentException {
    if (question == null || question.equals("")) {
      throw new IllegalArgumentException("Question cannot be null or empty");
    }
    this.question = question;
    this.required = required;
    this.answer = "";
  }

  @Override
  public String getPrompt() {
    return this.question;
  }

  /**
   * Create a getter method to get the boolean value to identify whether question is required.
   */
  public boolean isRequired() {
    return this.required;
  }

  @Override
  public void answer(String answer) throws IllegalArgumentException {
    if (answer != null) {
      if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("No")) {
        this.answer = answer;
        return;
      }
      throw new IllegalArgumentException("Yes and No question required yes and no answer");
    }
    throw new IllegalArgumentException("YesNo answer is null");
  }

  @Override
  public String getAnswer() {
    return this.answer;
  }

  @Override
  public Question copy() {
    return null;
  }
}
