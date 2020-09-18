package assignment1;

public class Drive {
    public static void main(String[] args){
        Player player1 = new Player("Tom");
        Player player2 = new Player("Jerry");
        TTTGame TG = new TTTGame(player1.getName(),player2.getName());    
    }
}
