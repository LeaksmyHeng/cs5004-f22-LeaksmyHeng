package trees;
import domain.Person;

// Using the Java DefaultMutableTree (from swing) for data. Can also display graphically
// DRY (Don't Repeat Yourself)

import java.awt.*;
import java.util.Enumeration;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeDemo {
  public static void main(String args[]) {
    JFrame frame = new JFrame("The 'C-Suite'");

    DefaultMutableTreeNode root = new DefaultMutableTreeNode(new Person("CEO Lauryn", 29));
    DefaultMutableTreeNode coo = new DefaultMutableTreeNode(new Person("COO J.R.", 23));
    root.add(coo);
    DefaultMutableTreeNode cto = new DefaultMutableTreeNode(new Person("CTO Omar", 25));
    DefaultMutableTreeNode director = new DefaultMutableTreeNode(new Person("Director Annie", 24));
    cto.add(director);
    coo.add(new DefaultMutableTreeNode(new Person("CIO Shriya", 24)));

    root.add(cto);

    root.add(new DefaultMutableTreeNode(new Person("Hanger-on/Roadie Keith", 58)));


    // Example of BREADTH first traversal. Built-in to the TreeNode so we don't need to worry
    // about implementing it

    Enumeration enumeration = root.breadthFirstEnumeration(); //breadth first traversal
    Object element = null;
    while(enumeration.hasMoreElements()) {
      element = enumeration.nextElement();
      int level = ((DefaultMutableTreeNode)element).getLevel();
      String s = " ";
      s = s.repeat(level);
      System.out.println(s + element);
    }


    JTree tree = new JTree(root);
    JScrollPane scrollPane = new JScrollPane(tree);
    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
    frame.setSize(300, 150);
    frame.setVisible(true);

  }
}