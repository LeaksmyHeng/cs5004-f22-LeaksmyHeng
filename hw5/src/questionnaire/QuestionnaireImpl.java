package questionnaire;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * Questionnaire implementation class.
 */
public class QuestionnaireImpl implements Questionnaire {

  /**
   * Create a construct questionList for the Questionnaire implementation.
   */
  private List<QuestionAndID> questionList;

  /**
   * Create an ArrayList.
   */
  public QuestionnaireImpl() {
    this.questionList = new ArrayList<>();
  }

  private static class QuestionAndID {
    private String identifier;
    private Question q;

    private QuestionAndID(String identifier, Question q) throws IllegalArgumentException {
      if (identifier == null || identifier.equals("") || q == null) {
        throw new IllegalArgumentException("ID cannot be blank / null");
      }
      this.identifier = identifier;
      this.q = q;
    }
  }

  @Override
  public String getIdentifier(Question q) throws NoSuchElementException {
    if (q == null) {
      throw new IllegalArgumentException("question is null.");
    }
    for (int i = 1; i <= questionList.size(); i++) {
      if (questionList.get(i - 1).q.equals(q)) {
        return questionList.get(i - 1).identifier;
      }
    }
    throw new NoSuchElementException("No identifier for given question");
  }

  @Override
  public void addQuestion(String identifier, Question q) throws IllegalArgumentException {
    if (identifier == null || q == null) {
      throw new IllegalArgumentException("Question cannot be null.");
    }
    if (identifier.equals("")) {
      throw new IllegalArgumentException("Question cannot be null.");
    }
    this.questionList.add(new QuestionAndID(identifier, q));
  }

  @Override
  public void removeQuestion(String identifier) throws IllegalArgumentException,
          NoSuchElementException {
    if (identifier == null || identifier.equals("")) {
      throw new IllegalArgumentException("Identifier cannot be null or empty.");
    }
    for (int i = 1; i <= questionList.size(); i++) {
      if (getIdentifier(getQuestion(i)).equals(identifier)) {
        questionList.remove(i - 1);
        return;
      }
    }
    throw new NoSuchElementException("Id not in the list.");
  }

  @Override
  public Question getQuestion(int num) throws IndexOutOfBoundsException {
    if (num <= 0) {
      throw new IndexOutOfBoundsException("Number cannot be negative.");
    }
    return (questionList.get(num - 1).q);
  }

  @Override
  public Question getQuestion(String identifier) throws NoSuchElementException {
    if (identifier == null || identifier.equals("")) {
      throw new IllegalArgumentException("Identifier cannot be null or empty.");
    }
    for (int i = 1; i <= questionList.size(); i++) {
      if (getIdentifier(getQuestion(i)).equalsIgnoreCase(identifier)) {
        return getQuestion(i);
      }
    }
    throw new NoSuchElementException("No question with that identifier");
  }

  @Override
  public List<Question> getRequiredQuestions() {
    List<Question> requiredQuestions = new ArrayList<>();
    for (int i = 1; i <= questionList.size(); i++) {
      if (getQuestion(i).isRequired()) {
        requiredQuestions.add(getQuestion(i));
      }
    }
    return requiredQuestions;
  }

  @Override
  public List<Question> getOptionalQuestions() {
    List<Question> optionalQuestions = new ArrayList<>();
    for (int i = 1; i <= questionList.size(); i++) {
      if (!getQuestion(i).isRequired()) {
        optionalQuestions.add(getQuestion(i));
      }
    }
    return optionalQuestions;
  }

  @Override
  public boolean isComplete() {
    for (Question question: getRequiredQuestions()) {
      if (question.getAnswer().equals("") || question.getAnswer() == null) {
        return false;
      }
    }
    return true;
  }

  @Override
  public List<String> getResponses() {
    List<String> responses = new ArrayList<>();
    for (int i = 1; i <= questionList.size(); i++) {
      if (getQuestion(i).getAnswer() != null) {
        responses.add(getQuestion(i).getAnswer());
      } else {
        responses.add("");
      }
    }
    return responses;
  }

  @Override
  public Questionnaire filter(Predicate<Question> pq) throws IllegalArgumentException {
    if (pq == null) {
      throw new IllegalArgumentException("pq is null");
    }
    Questionnaire FilteredQuestionairre = new QuestionnaireImpl();
    for (int i = 1; i <= questionList.size(); i++) {
      if (pq.test(getQuestion(i))) {
        FilteredQuestionairre.addQuestion(getIdentifier(getQuestion(i)), getQuestion(i).copy());
      }
    }
    return FilteredQuestionairre;

  }

  @Override
  public void sort(Comparator<Question> comp) throws IllegalArgumentException {
    if (comp == null) {
      throw new IllegalArgumentException("Comparator is null");
    }
    questionList.sort((o1, o2) -> comp.compare(o1.q, o2.q));
  }

  @Override
  public <R> R fold(BiFunction<Question, R, R> bf, R seed) throws IllegalArgumentException {
    if (bf == null || seed == null) {
      throw new IllegalArgumentException("bf / seed are null");
    }

    for (int i = 1; i <= questionList.size(); i++) {
      seed = bf.apply(getQuestion(i), seed);
    }
    return seed;

  }


  @Override
  public String toString() {
    if (this.questionList == null || this.questionList.isEmpty()) {
      return "";
    }
    StringBuilder printable = new StringBuilder();
    int questionSpot = 1;
    for (int i = 1; i <= questionList.size(); i++) {
      if (questionSpot < questionList.size()) {
        printable.append("Question: ").append(getQuestion(i).getPrompt());
        printable.append("\n\n");
        printable.append("Answer: ").append(getQuestion(i).getAnswer());
        printable.append("\n\n");
        questionSpot++;
      } else {
        printable.append("Question: ").append(getQuestion(i).getPrompt());
        printable.append("\n\n");
        printable.append("Answer: ").append(getQuestion(i).getAnswer());
      }
    }
    return printable.toString();
  }
}