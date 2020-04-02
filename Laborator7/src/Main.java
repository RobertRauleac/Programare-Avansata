import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    	
        Player player1 = new Player("Gelu din Onesti");
        Player player2 = new Player("Ioan mana de om");
        Player player3 = new Player("Nela Taximetrista");
        
        Board board = new Board(10);
        Board board2 = new Board(Arrays.asList(1,2,3,4,-1,6,7));
        
        Game game = new Game(board,10,player1,player2,player3);
        game.start();
        game.showStats();
        
        System.out.println("Game Over!");
    }
}
