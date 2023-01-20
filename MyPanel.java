import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

static class MyPanel extends JPanel {
        TreasureHunt game;
        JButton[][] buttons = new JButton[3][3];
        JLabel pointsLabel, livesLabel;

        public MyPanel(TreasureHunt game) {
            this.game = game;
            setPreferredSize(new Dimension(300, 300));
            setLayout(new GridLayout(3, 3));
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    buttons[i][j] = new JButton("?");
                    final int row = i;
                    final int column = j;
                    buttons[i][j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            game.checkTreasure(row, column);
                            if (game.board[row][column] && game.treasure[row][column]) {
                                buttons[row][column].setText("X");
                            } else if (game.board[row][column] && !game.treasure[row][column]) {
                                buttons[row][column].setText("O");
                            }
                            if (game.gameOver) {
                                for (int k = 0; k < 3; k++) {
                                    for (int l = 0; l < 3; l++) {
                                        buttons[k][l].setEnabled(false);
                                    }
                                }
                            }
                            pointsLabel.setText("Points: " + game.userPoints);
                            livesLabel.setText("Lives Left: " + game.userLives);
                        }
                    });
                    add(buttons[i][j]);
                }
            }
            pointsLabel = new JLabel("Points: " + game.userPoints);
            livesLabel = new JLabel("Lives Left: " + game.userLives);
            add(pointsLabel, BorderLayout.NORTH);
            add(livesLabel, BorderLayout.SOUTH);
        }
    }
}
