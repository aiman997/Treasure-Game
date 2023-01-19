import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Driver {
  public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
          JFrame frame = new JFrame("Treasure Hunt");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setSize(new Dimension(300, 400));
          frame.setLocationRelativeTo(null);
          TreasureHunt game = new TreasureHunt();
          game.init();
          MyPanel panel = new MyPanel(game);
          frame.add(panel, BorderLayout.CENTER);
          frame.setVisible(true);
      });
  }
}
