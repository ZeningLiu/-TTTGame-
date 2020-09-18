
package assignment1;

import javax.swing.JButton;

public class Button {
    JButton b[][];
    int count;
    public Button(){
        count = 1;
        b = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                b[i][j] = new JButton();
                b[i][j].setVisible(false);
                b[i][j].setBounds(i == 0? 50:i==1? 200:350,j==0? 125:j==1?275:425, 100, 100);
            }
        }
    }
    public JButton[][] getButtons(){
        return b;
    }
    public void setCount(){
        count++;
    }
    public int getCount(){
        return count;
    }
}
