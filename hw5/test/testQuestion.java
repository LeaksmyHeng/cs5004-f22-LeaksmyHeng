import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

import org.junit.Before;
import org.junit.Test;
import questionnaire.Likert;
import questionnaire.Question;
import questionnaire.Questionnaire;
import questionnaire.QuestionnaireImpl;
import questionnaire.ShortAnswer;
import questionnaire.YesNo;

/**
 * Create a test for Question (YesNo, ShortAnswer, and Likert).
 */
public class testQuestion {
  private YesNo yes;
  private YesNo no;
  private YesNo yesNo;
  private ShortAnswer shortAnswer1;
  private ShortAnswer shortAnswer2;
  private Likert likert1;
  private Likert likert2;

  /**
   * Setting up the Questions test along with add it to Questionnaire list.
   */
  @Before
  public void setUp() {
    yes = new YesNo("Are you Leaksmy?", true);
    no = new YesNo("Are you an immortal?", true);
    yesNo = new YesNo("Is your IQ over 150?", false);
    shortAnswer1 = new ShortAnswer("Tell me about yourself.", true);
    shortAnswer2 = new ShortAnswer("Tell me about your daily job.", false);
    likert1 = new Likert("Do you believe in ghost?", true);
    likert2 = new Likert("Do you believe that Alient exist", false);
  }

  /**
   * Create test for getPrompt method.
   */
  @Test
  public void testGetPrompt() {
    assertEquals("Are you Leaksmy?Are you an immortal?Is your IQ over 150?",
            yes.getPrompt() + no.getPrompt() + yesNo.getPrompt());
    assertEquals("Tell me about yourself.", shortAnswer1.getPrompt());
    assertEquals("Do you believe in ghost?", likert1.getPrompt());
  }

  /**
   * Create test for getAnswer method.
   */
  @Test
  public void testIsRequired() {
    assertTrue(yes.isRequired() && no.isRequired() && shortAnswer1.isRequired());
    assertTrue(!yesNo.isRequired() && !shortAnswer2.isRequired());
    assertFalse(likert2.isRequired());
  }

  /**
   * Create a test to answer Yes No question.
   */
  @Test
  public void testGetAnswer() {
    yes.answer("Yes");
    no.answer("nO");
    yesNo.answer("yES");
    assertEquals("Yes", yes.getAnswer());
    assertEquals("nO", no.getAnswer());
    // Answer for short answer.
    shortAnswer1.answer("Hello my name is leaksmy Heng. I am from Cambodia.");
    assertEquals("Hello my name is leaksmy Heng. I am from Cambodia.",
            shortAnswer1.getAnswer());
    assertEquals("", shortAnswer2.getAnswer());
    // Answer for Likert.
    likert1.answer("disAGREE");
    assertEquals("disAGREE", likert1.getAnswer());
    assertEquals("", likert2.getAnswer());
  }

  /**
   * Test copy function for every questions type.
   */
  @Test
  public void testCopy() {
    // Yes no questions testing
    assertEquals(yes.getPrompt() + yes.getAnswer(),
            yes.copy().getPrompt() + yes.copy().getAnswer());
    assertEquals(no.getPrompt() + no.getAnswer(),
            no.copy().getPrompt() + no.copy().getAnswer());
    assertEquals(yesNo.getPrompt() + yesNo.getAnswer(),
            yesNo.copy().getPrompt() + yesNo.copy().getAnswer());
    assertEquals("", yesNo.copy().getAnswer());
    // short answer testing
    assertEquals(shortAnswer1.getAnswer() + shortAnswer1.getAnswer(),
            shortAnswer1.copy().getAnswer() + shortAnswer1.copy().getAnswer());
    assertEquals("", shortAnswer1.copy().getAnswer());
    // Likert copy answer testing
    assertEquals(likert1.getAnswer() + likert1.getAnswer(),
            likert1.copy().getAnswer() + likert1.copy().getAnswer());
    assertEquals("", likert2.copy().getAnswer());
  }

  /**
   * Test Illegal Answer for Yes No.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalAnswertoYesNo() {
    yes.answer("I am Leaksmy.");
  }

  /**
   * Test Illegal Answer for Yes No.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalAnswertoYesNo1() {
    no.answer(null);
  }

  /**
   * Test short answer out of bound.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testAnswerOutOfBound() {
    shortAnswer1.answer("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
            + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
            + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
            + "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
            + "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"
            + "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
            + "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
            + "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
            + "gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");
  }

  /**
   * Test short answer null.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testShortAnswerNull() {
    shortAnswer1.answer(null);
  }

  /**
   * Test likert null answer.*/
  @Test (expected = IllegalArgumentException.class)
  public void testLikertNull() {
    likert2.answer(null);
  }

  /**
   * Test Likert answer not in likert.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testLikertAnswerNotInEnum() {
    likert2.answer("I believe in that");
  }

  /**
   * Test yesNo Likert and shortAnswer.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testAllEmptyStringAnswer() {
    shortAnswer1.answer("");
    yes.answer("");
    likert2.answer("");
  }

  // Initialize Questionnaire
  private QuestionnaireImpl questionList;

  /**
   * Setup the questionnaire test.
   */
  @Before
  public void setUpQuestionnaire() {
    // get all the YesNo, shortAnswer and Likert to the Questionnaire
    questionList = new QuestionnaireImpl();
    questionList.addQuestion("01", yes);
    questionList.addQuestion("02", yesNo);
    questionList.addQuestion("03", shortAnswer1);
    questionList.addQuestion("04", shortAnswer2);
    questionList.addQuestion("05", likert1);
    questionList.addQuestion("06", likert2);
  }

  /**
   * Test to see all 6 questions are added successfully.
   */
  @Test
  public void testAddQuestion() {
    // test get size of the list
    assertEquals(3, questionList.getRequiredQuestions().size());
    assertEquals(3, questionList.getOptionalQuestions().size());
  }

  /**
   * Create a test for getIdentifier.
   */
  @Test
  public void testGetIdentifier() {
    assertEquals("01", questionList.getIdentifier(yes));
    assertNotEquals("02", questionList.getIdentifier(shortAnswer2));
  }

  /**
   * Test remove question by identifier.
   */
  @Test
  public void testRemoveQuestion() {
    questionList.removeQuestion("01");
    questionList.removeQuestion("06");
    assertEquals(2, questionList.getRequiredQuestions().size());
    assertEquals(2, questionList.getOptionalQuestions().size());
  }

  /**
   * Test when there is no identifier for the questions.
   */
  @Test (expected = NoSuchElementException.class)
  public void testRemoveQuestionOutOfBound() {
    questionList.removeQuestion("100");
  }

  /**
   * Test getQuestion from the questionaire.
   */
  @Test
  public void testGetQuestionCorrect() {
    Question question1 = questionList.getQuestion(1);
    assertEquals(question1.getPrompt(), "Are you Leaksmy?");
    assertTrue(question1.isRequired());
  }

  /**
   * Test getQuestion out of bound.
   */
  @Test (expected = IndexOutOfBoundsException.class)
  public void testGetQuestionOutOfBound() {
    questionList.getQuestion(100);
    questionList.getQuestion(0);
  }

  /**
   * Test getQuestion with Identifier as the argument.
   */
  @Test
  public void testGetQuesetionThroughIdentifier() {
    Question question2 = questionList.getQuestion("02");
    assertEquals("Is your IQ over 150?", question2.getPrompt());
    assertFalse(question2.isRequired());
    question2.answer("Yes");
    assertTrue(question2.getAnswer().equalsIgnoreCase("Yes"));
  }

  /**
   * Test Illegal argument for GetQuestion Identifier.
   */
  @Test (expected = NoSuchElementException.class)
  public void testGetQuestionThroughIdentifierIllegal() {
    questionList.getQuestion("A0");
  }

  /**
   * Test GetRequiredQuestion, GetOptionalQuestion, isComplete and getResponses.
   */
  @Test
  public void testRequiredOptionalAndIsComplete() {
    assertEquals(3, questionList.getRequiredQuestions().size());
    assertEquals(3, questionList.getOptionalQuestions().size());
    assertEquals("Are you Leaksmy?",
            questionList.getRequiredQuestions().get(0).getPrompt());
    assertEquals("Is your IQ over 150?",
            questionList.getOptionalQuestions().get(0).getPrompt());
    assertEquals("Tell me about yourself.",
            questionList.getRequiredQuestions().get(1).getPrompt());
    assertEquals("Tell me about your daily job.",
            questionList.getOptionalQuestions().get(1).getPrompt());
    assertEquals("Do you believe in ghost?",
            questionList.getQuestion(5).getPrompt());
    assertEquals("Do you believe that Alient exist",
            questionList.getQuestion(6).getPrompt());
    questionList.getRequiredQuestions().get(0).answer("Yes");
    questionList.getRequiredQuestions().get(1).answer("I am always happy.");
    questionList.getOptionalQuestions().get(1).answer("It has been busy.");
    questionList.getQuestion(5).answer("neither agree nor disagree");
    assertTrue(questionList.isComplete());
    assertEquals("Yes", questionList.getResponses().get(0));
    assertEquals("", questionList.getResponses().get(1));
    assertEquals("I am always happy.", questionList.getResponses().get(2));
    assertEquals("neither agree nor disagree", questionList.getResponses().get(4));
  }

  /**
   * Test the Questionnaire filter.
   */
  @Test
  public void testQuestionnaire() {
    Questionnaire q = questionList.filter(Question::isRequired);
    Questionnaire o = questionList.filter(questionList -> !questionList.isRequired());
    assertEquals("Are you Leaksmy?", q.getQuestion(1).getPrompt());
    assertEquals("Tell me about yourself.", q.getQuestion(2).getPrompt());
    assertEquals("Is your IQ over 150?", o.getQuestion(1).getPrompt());
  }

  /**
   * Test the Fold method.
   */
  @Test
  public void testFold() {
    BiFunction<Question, String, String> bf = (a, b) -> b + "Question: " + a.getPrompt()
            + "\n\nAnswer: " + a.getAnswer() + "\n\n";
    assertEquals(questionList.fold(bf, ""), questionList.toString() + "\n\n");
  }

  /**
   * Test to String method.
   */
  @Test
  public void testToString() {
    yes.answer("Yes");
    yesNo.answer("No");
    likert1.answer("Neither Agree Nor Disagree");
    shortAnswer2.answer("it's alright.");
    questionList.removeQuestion("03");
    questionList.removeQuestion("06");
    assertEquals("Question: Are you Leaksmy?" + "\n\n" + "Answer: Yes" + "\n\n"
                    + "Question: Is your IQ over 150?" + "\n\n" + "Answer: No" + "\n\n"
                    + "Question: Tell me about your daily job." + "\n\n" + "Answer: it's alright."
                    + "\n\n" + "Question: Do you believe in ghost?" + "\n\n"
                    + "Answer: Neither Agree Nor Disagree", questionList.toString());
    assertEquals("[Yes, No, it's alright., Neither Agree Nor Disagree]",
            questionList.getResponses().toString());
  }

  /**
   * Create a test for Illegal Sort method.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalSort() {
    Comparator<Question> comp = null;
    questionList.sort(comp);
  }

  /**
   * Create a test for Illegal fold method.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalFold() {
    BiFunction<Question, String, String> bf = (a, b) -> b + "Question: " + a.getPrompt()
            + "\n\nAnswer: " + a.getAnswer() + "\n\n";
    questionList.fold(bf, null);
  }

  /**
   * Create a test for Illegal fold method.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalFold2() {
    questionList.fold(null, "Hi");
  }

  /**
   * Create a Fold test.
   */
  @Test
  public void testSort() {
    Comparator<Question> comp = (a, b)->a.getPrompt().length();
    questionList.sort(comp);
    System.out.println(questionList.getRequiredQuestions());
  }
}
