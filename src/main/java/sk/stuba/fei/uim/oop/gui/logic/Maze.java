package sk.stuba.fei.uim.oop.gui.logic;


import sk.stuba.fei.uim.oop.gui.mazes.*;

import java.util.ArrayList;
import java.util.Random;

public class Maze {
    public ArrayList<MazePart> maze;
    private int mazeWidthHeight;

    public Maze(int mazeWidthHeight) {
        maze = new ArrayList<>();
        this.mazeWidthHeight = mazeWidthHeight;
        for(int i = 0; i < mazeWidthHeight; i++){
            for(int j = 0; j < mazeWidthHeight; j++){
                if(i==0 || i==mazeWidthHeight-1){
                    maze.add(new MazeWall((mazeWidthHeight)*i+j));
                }
                else if(j==0 || j==mazeWidthHeight-1){
                    maze.add(new MazeWall((mazeWidthHeight)*i+j));
                }
                else if(i==1 && j==1){
                    maze.add(new MazeStart((mazeWidthHeight)*i+j));
                }
                else if(i==mazeWidthHeight-2 && j==mazeWidthHeight-2){
                    maze.add(new MazeFinish((mazeWidthHeight)*i+j));
                }
                else{
                    maze.add(new MazeCell((mazeWidthHeight)*i+j));
                }
            }
        }
        generateMaze();
    }

    private void generateMaze(){
        MazePart startMazePart = maze.get(mazeWidthHeight +1);
        randomizedDFS(startMazePart);
    }

    private void randomizedDFS(MazePart mazePart){
        mazePart.setVisited(true);
        MazePart nextMazePart = randomUnvisitedNeighbour(mazePart);
        while(nextMazePart!=null){
            connectCells(mazePart, nextMazePart);
            nextMazePart.setVisited(true);
            randomizedDFS(nextMazePart);
            nextMazePart = randomUnvisitedNeighbour(mazePart);
        }
    }

    private MazePart randomUnvisitedNeighbour(MazePart mazePart){
        ArrayList<MazePart> unvisitedNeighbours = new ArrayList<>();
        int currentMazePartPos = mazePart.getPosition();
        if(maze.get(currentMazePartPos-1) instanceof MazeCell && !maze.get(currentMazePartPos - 1).isVisited()){
            unvisitedNeighbours.add(maze.get(currentMazePartPos-1));
        }
        if(maze.get(currentMazePartPos + 1) instanceof MazeCell && !maze.get(currentMazePartPos + 1).isVisited()){
            unvisitedNeighbours.add(maze.get(currentMazePartPos + 1));
        }
        if(maze.get(currentMazePartPos - mazeWidthHeight) instanceof MazeCell && !maze.get(currentMazePartPos - mazeWidthHeight).isVisited()){
            unvisitedNeighbours.add(maze.get(currentMazePartPos - mazeWidthHeight));
        }
        if((maze.get(currentMazePartPos + mazeWidthHeight) instanceof MazeCell) && !maze.get(currentMazePartPos + mazeWidthHeight).isVisited()){
            unvisitedNeighbours.add(maze.get(currentMazePartPos + mazeWidthHeight));
        }
        if(unvisitedNeighbours.isEmpty()){
            return null;
        }
        Random rand = new Random();
        int pos = rand.nextInt(unvisitedNeighbours.size());
        return unvisitedNeighbours.get(pos);
    }


    private void connectCells(MazePart mazePart, MazePart nextMazePart){
        if(mazePart.getPosition()-nextMazePart.getPosition()==1){
            mazePart.setlWall(false);
            nextMazePart.setrWall(false);
        }else if(nextMazePart.getPosition() - mazePart.getPosition()==1){
            mazePart.setrWall(false);
            nextMazePart.setlWall(false);
        }else if(mazePart.getPosition()-nextMazePart.getPosition()==mazeWidthHeight){
            mazePart.setuWall(false);
            nextMazePart.setdWall(false);
        }else if(nextMazePart.getPosition()-mazePart.getPosition()==mazeWidthHeight){
            mazePart.setdWall(false);
            nextMazePart.setuWall(false);
        }
    }
}
