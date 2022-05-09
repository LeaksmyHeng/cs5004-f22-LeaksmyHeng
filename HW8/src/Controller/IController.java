package Controller;

/**
 * Interface class for our snapshot.*/
public interface IController {

  /**
   * This is the method to preview the previous snapshot if it is existed.
   */
  void pageBackward();

  /**
   * This is the method to preview the next snapshot if it is existed.
   */
  void pageForward();

  /**
   * Method to show the snapshot information (uniqe ID and description).
   */
  void select();


  /**
   * Method to quite the program.
   */
  void quit();
}
