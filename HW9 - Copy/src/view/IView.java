package view;

/**
 * Create all the functionality that we need when viewing the snapshot.
 */
public interface IView {

   /**
    * This function is used in the graphicalView to set the visible to true.
    */
   void makeVisible();

   /**
    * This method is used in the graphical view to create panel.
    */
   GraphicalBuilder getPanel();

   /**
    * This will be used in htmlView to output the html file. It take 2 arguments,
    * the outputFile name and string content. The string in this case would be the
    * getView().
    */
   void output(String outputFile, String string);

   /**
    * This will be used in both htmlView and graphicalView to set it string to htmlView
    * if it is html and graphical if it is graphicalView. This will be used as a switch
    * between html and graphical in the main function PhotoAlbumMain.
    */
   String getViewType();

   /**
    * Get view is used to loop through the snapshotList in IPhotoAlbum to create
    * a string in html format.
    */
   String getView();
}
