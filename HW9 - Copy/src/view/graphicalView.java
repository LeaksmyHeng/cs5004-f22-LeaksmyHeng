package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.*;

import model.IPhotoAlbum;
import model.IShape;

/**
 * The graphicalView aka interactive view that we implement the IView and ActionListen along with
 * extends the JFrame to create the visualization.
 */
public class graphicalView extends JFrame implements IView, ActionListener {
  private IPhotoAlbum model;
  private Map<String, IShape> shape;
  private GraphicalBuilder graphicalBuilder;
  private int index;

  public graphicalView(IPhotoAlbum model) {
    super();
    this.model = model;
    this.shape = model.getShapeList();
    this.setBackground(new Color(255, 255, 255));
    this.setSize(model.getCanvasWidth(), model.getCanvasHeight());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    // initialize the graphical builder
    graphicalBuilder = new GraphicalBuilder(model);
    graphicalBuilder.setPreferredSize(new Dimension(model.getCanvasWidth(), model.getCanvasHeight()));
    this.add(graphicalBuilder, BorderLayout.CENTER);
    this.pack();

    JSplitPane splitPane = new JSplitPane();
    JPanel topPanel = graphicalBuilder;
    JPanel bottomPanel = new JPanel();

    // create the button
    JButton previousButton = new JButton("<<prev");
    JButton selectButton = new JButton(">>select<<");
    JButton nextButton = new JButton("next>>");
    JButton quitButton = new JButton("xxquitxx");

    // set the action command
    previousButton.setActionCommand("<<prev");
    selectButton.setActionCommand(">>select<<");
    nextButton.setActionCommand("next>>");
    quitButton.setActionCommand("xxquitxx");

    // listen to the action command that we set
    previousButton.addActionListener(this);
    selectButton.addActionListener(this);
    nextButton.addActionListener(this);
    quitButton.addActionListener(this);

    getContentPane().setLayout(new GridLayout());
    getContentPane().add(splitPane);
    splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
    splitPane.setDividerLocation(model.getCanvasWidth() + 5);
    splitPane.setTopComponent(topPanel);
    splitPane.setBottomComponent(bottomPanel);

    // Add the button the bottomPanel
    GridBagConstraints c = new GridBagConstraints();
    bottomPanel.add(previousButton, c);
    bottomPanel.add(selectButton, c);
    bottomPanel.add(nextButton, c);
    bottomPanel.add(quitButton, c);

    this.pack();
  }

  /**
   * Turn the setVisible to true.
   */
  @Override
  public void makeVisible() {
    this.setVisible(true);
  }

  @Override
  public void output(String outputFile, String string) {
    throw new IllegalArgumentException("This is a graphical view! not an HTML output file.");
  }

  @Override
  public String getViewType() {
    return "graphical";
  }

  @Override
  public GraphicalBuilder getPanel() {
    return this.graphicalBuilder;
  }

  @Override
  public String getView() {
    return null;
  }

  /**
   * Listen to see if the button is clicked. If it is click then repaint it.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
      switch (e.getActionCommand()) {
        case "<<prev" -> {
          index = index - 1;
          if (index < 0) {
            JOptionPane.showMessageDialog(graphicalBuilder,
                    "Index out of bound", "Encountered Error ", JOptionPane.ERROR_MESSAGE);
          }
          else {
            graphicalBuilder.setIndex(index);
            graphicalBuilder.repaint();
          }
        }
        case "next>>" -> {
          index = index + 1;
          if (index >= model.getSnapShotListKey().size()) {
            JOptionPane.showMessageDialog(graphicalBuilder,
                    "Index out of bound", "Encountered Error ", JOptionPane.ERROR_MESSAGE);
          }
          else {
            graphicalBuilder.setIndex(index);
            graphicalBuilder.repaint();
          }
        }
        case ">>select<<" -> {
          Object[] option = model.getSnapShotListKey().toArray(new String[0]);
          Object result = (String) JOptionPane.showInputDialog(null,
                  "Please select the snapshot",
                  "snapshot",
                  JOptionPane.PLAIN_MESSAGE,
                  null,
                  option,
                  option[0]
          );
          for (int i = 0; i < option.length; i++) {
            if (option[i].equals(result)) {
              index = i;
              break;
            }
          }
          graphicalBuilder.setIndex(index);
          graphicalBuilder.repaint();
        }
        case "xxquitxx" -> System.exit(0);
      }
  }
}
