package assignment1;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class TTTGame implements Observer {
    ImageIcon x;
    ImageIcon o;
    DataCell dc;
    JLabel l1;
    JButton b[][];
    String name1;
    String name2;
    Button button;
    public TTTGame(String name1,String name2){
        this.name1 = name1;
        this.name2 = name2;
        dc = new DataCell();
        dc.addObserver(this);
        x = new ImageIcon("X.png");
        o = new ImageIcon("O.png");
        button = new Button();
        b = button.getButtons();
        start();
    }

    public void start() {
        JFrame frame = new JFrame("test");
        frame.setSize(500, 625);
        Container conn = frame.getContentPane();
        conn.setLayout(null);
        
        l1 = new JLabel("The game hasn't started yet", JLabel.CENTER);
        l1.setBounds(50, 10, 400, 90);
        l1.setOpaque(true); 
        l1.setBackground(Color.LIGHT_GRAY);
        JLabel l2 = new JLabel("1");

        JButton b10 = new JButton("Start Game");
        b10.setBackground(Color.white);
        b10.setBounds(50, 535, 400, 40);
        b10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 9; i++) {
                    JButton newB = new JButton();
                    newB = b[i/3][i%3];
                    setImage(newB, i/3, i%3);
                    conn.add(newB);
                    newB.setVisible(true);
                }
                l1.setText(name1+"'s turn");
            }
        });
        
        conn.add(l1);
        conn.add(b10);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public void setImage(JButton b, int indexI, int indexJ) {
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = button.getCount();
                if (b.getIcon() == x || b.getIcon() == o) {
                    return;
                } else {
                    if (index % 2 == 1) {
                        b.setIcon(x);
                        button.setCount();
                        l1.setText(name2+"'s turn");
                        dc.setIndex(indexI, indexJ, 1);
                    } else {
                        b.setIcon(o);
                        button.setCount();
                        l1.setText(name1+"'s turn");
                        dc.setIndex(indexI, indexJ, 0);
                    }
                }
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        DataCell dc2 = (DataCell) o;
        if (dc2.getWin() == true) {
            l1.setText(dc2.getTurn(name1,name2) + " win!");
            JOptionPane.showMessageDialog(null, dc2.getTurn(name1,name2) + " win!");
        } else if (dc2.isDraw()) {
            l1.setText("Draw");
            JOptionPane.showMessageDialog(null, "draw");
        }
    }
}
