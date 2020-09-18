package assignment1;

import java.util.Observable;

public class DataCell extends Observable {

    int index[][] = new int[3][3];
    boolean win = false;
    boolean draw = false;
    int turn;

    public void setIndex(int i, int j, int turn) {
        this.turn = turn;
        if (turn == 1) {
            index[i][j] = 1;
        } else {
            index[i][j] = -1;
        }
        win = isWin(i, j);
        draw = isDraw();
        setChanged();
        notifyObservers();
    }

    public boolean isWin(int i, int j) {
        //System.out.println("i = " + i + ", j = " + j);
        boolean isWin = false;
        if ((i == 0 && (j == 0 || j == 2)) || (i == 2 && (j == 0 || j == 2))) {
            int temp1 = index[0][0] + index[1][1] + index[2][2];
            int temp2 = index[0][2] + index[1][1] + index[2][0];
            if (temp1 == -3 || temp1 == 3 || temp2 == -3 || temp2 == 3) {
                isWin = true;
            }
        }
        int temp1 = index[i][0] + index[i][1] + index[i][2];
        int temp2 = index[0][j] + index[1][j] + index[2][j];
        if (temp1 == -3 || temp1 == 3 || temp2 == -3 || temp2 == 3) {
            isWin = true;
        }
        return isWin;
    }

    public boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (index[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean getWin() {
        return win;
    }

    public boolean getDraw() {
        return draw;
    }

    public String getTurn(String name1,String name2) {
        return turn == 1 ? name1 : name2;
    }
}
