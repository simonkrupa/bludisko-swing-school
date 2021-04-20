package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

public class PlayerMovement {
    private int playerPosition = 14;
    private int lastPlayerPosition = 14;
    private ButtonPanel buttonPanel;
    private Frame frame;

    public PlayerMovement(ButtonPanel buttonPanel, Frame frame) {
        this.buttonPanel = buttonPanel;
        this.frame = frame;
    }

    public void move(ArrayList<MazePart> maze){
        maze.get(lastPlayerPosition).setPlayer(false);
        maze.get(lastPlayerPosition).repaint();
        maze.get(playerPosition).setPlayer(true);
        if(maze.get(playerPosition).isFinish()){
            maze.get(playerPosition).setPlayer(false);
            this.playerPosition = 14;
            this.lastPlayerPosition = 14;
            maze.get(playerPosition).setPlayer(true);
            maze.get(lastPlayerPosition).repaint();
            buttonPanel.setCount();
            frame.remove(frame.mazePanel);
            frame.newMazePanel();
            this.move(frame.mazePanel.getMaze().maze);
        }
        maze.get(playerPosition).repaint();
    }

    public void setPlayerPosition(int playerPosition, ArrayList<MazePart> maze) {
        if(maze.get(this.playerPosition+playerPosition).isWall()){
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
        if(this.playerPosition-lastPlayerPosition==13 && !maze.get(this.playerPosition).isuWall()){
            return true;
        }
        if(this.playerPosition-lastPlayerPosition==-13 && !maze.get(this.playerPosition).isdWall()){
            return true;
        }
        return false;
    }

}
