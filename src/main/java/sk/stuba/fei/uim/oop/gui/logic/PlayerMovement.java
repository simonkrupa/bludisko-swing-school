package sk.stuba.fei.uim.oop.gui.logic;

import sk.stuba.fei.uim.oop.gui.mazes.MazeFinish;
import sk.stuba.fei.uim.oop.gui.mazes.MazePart;
import sk.stuba.fei.uim.oop.gui.mazes.MazeWall;
import sk.stuba.fei.uim.oop.gui.Frame;

import java.util.ArrayList;

public class PlayerMovement {
    public int playerPosition;
    private int lastPlayerPosition;
    private Frame frame;
    private int mazeWidthHeight;

    public PlayerMovement(Frame frame, int mazeWidthHeight) {
        this.frame = frame;
        this.mazeWidthHeight = mazeWidthHeight;
        this.playerPosition = mazeWidthHeight+1;
        this.lastPlayerPosition = mazeWidthHeight+1;
    }

    public void move(ArrayList<MazePart> maze){
        maze.get(lastPlayerPosition).setPlayer(false);
        maze.get(lastPlayerPosition).repaint();
        maze.get(playerPosition).setPlayer(true);
        finishMove(maze);
        frame.repaint();
        maze.get(playerPosition).repaint();
    }

    public void moveMouse(ArrayList<MazePart> maze, int nextPosition){
        maze.get(playerPosition).setPlayer(false);
        this.playerPosition = nextPosition;
        maze.get(playerPosition).setPlayer(true);
        frame.repaint();
        maze.get(playerPosition).repaint();
        finishMove(maze);
    }

    private void finishMove(ArrayList<MazePart> maze){
        if(maze.get(playerPosition) instanceof MazeFinish) {
            maze.get(playerPosition).setPlayer(false);
            this.playerPosition = mazeWidthHeight + 1;
            this.lastPlayerPosition = mazeWidthHeight + 1;
            maze.get(playerPosition).setPlayer(true);
            maze.get(lastPlayerPosition).repaint();
            frame.finishedGame();
            this.move(frame.mazePanel.getMaze().maze);
        }
    }

    public void setPlayerPosition(int playerPosition, ArrayList<MazePart> maze) {
        if(maze.get(this.playerPosition+playerPosition) instanceof MazeWall){
            return;
        }
        this.lastPlayerPosition = this.playerPosition;
        this.playerPosition = this.playerPosition + playerPosition;
        if(!checkWalls(maze)){
            this.playerPosition = this.lastPlayerPosition;
            return;
        }
        this.move(maze);
    }

    private boolean checkWalls(ArrayList<MazePart> maze){
        if(this.playerPosition-lastPlayerPosition==1 && !maze.get(this.playerPosition).islWall()){
            return true;
        }
        if(this.playerPosition-lastPlayerPosition==-1 && !maze.get(this.playerPosition).isrWall()){
            return true;
        }
        if(this.playerPosition-lastPlayerPosition==mazeWidthHeight && !maze.get(this.playerPosition).isuWall()){
            return true;
        }
        if(this.playerPosition-lastPlayerPosition==-mazeWidthHeight && !maze.get(this.playerPosition).isdWall()){
            return true;
        }
        return false;
    }

}
