import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

static class TreasureHunt {
        boolean[][] treasure = new boolean[3][3];
        boolean[][] board = new boolean[3][3];
        boolean gameOver = false;
        int userLives = 3;
        int userPoints = 0;

        public TreasureHunt() {
        }

        public void init() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    treasure[i][j] = false;
                    board[i][j] = false;
                }
            }
            treasure[0][0] = true;
            treasure[1][1] = true;
            treasure[2][2] = true;
        }

        public void checkTreasure(int row, int column) {
            board[row][column] = true;
            if (treasure[row][column]) {
                userPoints += 1;
            } else {
                userLives -= 1;
            }
            if (userPoints == 3) {
                JOptionPane.showMessageDialog(null, "All treasure found!!!");
                gameOver = true;
            }
            if (userLives == 0) {
                JOptionPane.showMessageDialog(null, "Game Over Out Of Lives");
                gameOver = true;
            }
        }
    }
