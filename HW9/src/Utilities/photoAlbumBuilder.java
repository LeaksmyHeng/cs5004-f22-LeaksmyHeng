package Utilities;

import model.IPhotoAlbum;

/**
 * This interface is implemented by photoAlbumImp and it will get called when we read the file
 * in photoAlbumReader.
 */
public interface photoAlbumBuilder<T> {

  /**
   * If we found the command shape, we add shape to the photoAlbum.
   */
  photoAlbumBuilder<IPhotoAlbum> addShape(String name, String type, int lx, int ly, int width, int height, int red, int green, int blue);

  /**
   * If we found the command snapshot, we call the snapshot function.
   */
  void snapshot(String description);

  /**
   * Invoke changePosition function if we saw the keyword move.
   */
  void changePosition(String shapeID, int toX, int toY);

  /**
   * Invoke changeShapeSize function if we saw the keyword resize.
   */
  void changeShapeSize(String shapeID, int toWidth, int toHeight);

  /**
   * Invoke the changeColor method if we saw the color command keyword.
   */
  void changeColor(String shapeID, int toR, int toG, int toB);

  /**
   * Invoke the remove function if we saw keyword remove.
   */
  void remove(String shapeId);

  /**
   * Build the document accordingly based on the keyword we found.
   */
  T build();
}
