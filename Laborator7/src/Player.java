import java.util.ArrayList;
import java.util.List;


public class Player implements Runnable {
    private String nume;
    private Game game;
    private int points = 0;
    int ratia = -1;
    private boolean finished = false;
    List<Token> progresie = new ArrayList<Token>();

    public Player(String nume) {
        this.nume = nume;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public String getNume() {
        return nume;
    }

    @Override
    public void run() {
        while (!this.finished) {
            synchronized (game.board) {
                if (game.isOver()) {
                    return;
                }
                boolean madeMove = false;
                for (Token token : game.board.tokens) {
                    if (!madeMove) {
                        if (!token.isUsed()) {
                            if (progresie.size() < 2) {
                                if(token.getContent()<0)
                                    continue;
                                progresie.add(token);
                                points += 1;
                                token.setUsed(true);
                                System.out.println(nume + ": added token " + token.getContent());
                                if (progresie.size() == 2)
                                    ratia = progresie.get(1).getContent() - progresie.get(0).getContent();
                                if (game.board.getNumberOfAvailableTokens() == 0)
                                    game.setOver(true);
                                madeMove = true;
                                break;
                            } else {
                                if (token.getContent() == progresie.get(progresie.size() - 1).getContent() + ratia ||token.getContent()<0) {
                                    if(token.getContent()<0)
                                        token.setContent(progresie.get(progresie.size() - 1).getContent() + ratia);
                                    progresie.add(token);
                                    points += 1;
                                    token.setUsed(true);
                                    System.out.println(nume + ":  " + token.getContent());
                                    if (game.board.getNumberOfAvailableTokens() == 0)
                                        game.setOver(true);
                                    madeMove = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (!madeMove) {
                    System.out.println(nume + " is not allowed to choose anoter piece :(");
                    finished = true;
                }
                if (progresie.size() == game.maxProg) {
                    game.maxProgEnd(this);
                    game.setOver(true);
                }
                if (game.allFinished())
                    game.setOver(true);
            }
            try {
                Thread.sleep(1050);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
