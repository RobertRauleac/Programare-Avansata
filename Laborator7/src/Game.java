import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Game {
    public final Board board;
    List<Player> players = new ArrayList<Player>();
    int maxProg;
    boolean over = false;

    public Game(Board board, int k, Player... players) {
        this.board = board;
        this.maxProg = k;
        this.players = Arrays.asList(players);
        for (Player player : players) {
            player.setGame(this);
        }
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public boolean isOver() {
        return over;
    }

    //aici se vor crea Threadurile
    public void start() {
        List<Thread> threads = new ArrayList<Thread>();
        for (Player player : players) {
            Thread thread = new Thread(player);
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for(Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean allFinished(){
        for(Player player: players)
            if(!player.isFinished())
                return false;
        return true;
    }

    //functie ce ne indica faptul ca jucatorul a atins progresia maxima deci castigatoare
    public void maxProgEnd(Player player){
        for(Player player2: players)
            player2.setPoints(0);
        player.setPoints(board.n);
    }
    public void showStats() {
        Player winner = players.get(0);
        int maxPoints=0;
        for(Player player: players)
            if(player.getPoints()>maxPoints){
                maxPoints = player.getPoints();
                winner = player;
            }
        System.out.println("Final Points : ");
        for(Player player: players)
            System.out.println(player.getNume()+": "+player.getPoints()+" points");
        System.out.println("The Winner is : "+winner.getNume());
    }
}
