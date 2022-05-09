package questionnaire;

/**
 * Create Likert class which only take agree, strongly agree, disagree, strongly disagree & neither.
 */
public class Likert extends AbstractQuestion implements Question {
  private String answer;

  /**
   * Create the constructor for the Question.
   */
  public Likert(String question, boolean required) throws IllegalArgumentException {
    super(question, required);
    this.answer = "";
  }

  @Override
  public void answer(String answer) throws IllegalArgumentException {
    if (answer != null && !answer.equals("")) {
      if (answer.equalsIgnoreCase("Strongly Disagree")
              || answer.equalsIgnoreCase("Disagree")
              || answer.equalsIgnoreCase("Neither Agree Nor Disagree")
              || answer.equalsIgnoreCase("Agree")
              || answer.equalsIgnoreCase("Strongly Agree")) {
        this.answer = answer;
      }
      else {
        this.answer = "";
        throw new IllegalArgumentException("This is not likert answer type.");
      }
    }
    else if (answer == null) {
      throw new IllegalArgumentException("Short answer is null");
    }
  }

  @Override
  public String getAnswer() {
    return this.answer;
  }

  @Override
  public Question copy() {
    Question likertAnswerQuestion = new Likert(getPrompt(), isRequired());
    if (!getAnswer().equals("")) {
      likertAnswerQuestion.answer(getAnswer());
    }
    return likertAnswerQuestion;
  }
}
