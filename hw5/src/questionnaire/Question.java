package questionnaire;

/**
 * Create a question interface that will be used in all 3 questions classes.
 */
public interface Question {

  /**
   * Create a getPrompt method.
   */
  String getPrompt();

  /**
   * Create a boolean method that verify whether the question is required.
   */
  boolean isRequired();

  /**
   * A method that allows user to answer the question.
   */
  void answer(String answer);

  /**
   * A getter method to get the answer.
   */
  String getAnswer();

  /**
   * A method to copy all the questions to the data.
   */
  Question copy();
}
