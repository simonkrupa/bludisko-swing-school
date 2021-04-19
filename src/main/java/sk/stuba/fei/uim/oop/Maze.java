package sk.stuba.fei.uim.oop;


import java.util.ArrayList;
import java.util.Random;

public class Maze {
    public ArrayList<MazePart> maze;
    private int mazeWidthHeight = 13;
    private int mazeLength = mazeWidthHeight*mazeWidthHeight;

    public Maze() {
        maze = new ArrayList<>();
        for(int i = 0; i < mazeWidthHeight; i++){
            for(int j = 0; j < mazeWidthHeight; j++){
                if(i==0 || i==mazeWidthHeight-1){
                    maze.add(new MazePart((mazeWidthHeight)*i+j, i, j));
                    maze.get((mazeWidthHeight)*i+j).setWall(true);
                }
                else if(j==0 || j==mazeWidthHeight-1){
                    maze.add(new MazePart((mazeWidthHeight)*i+j, i, j));
                    maze.get((mazeWidthHeight)*i+j).setWall(true);
                }
                else{
                    maze.add(new MazePart((mazeWidthHeight)*i+j, i, j));
                }
            }
        }
        generateMaze();
        //printMaze();
    }

    private void printMaze(){
        int j = 0;
        for(int i = 0; i < mazeLength; i++) {
            if(i == j*13){
                System.out.println();
                j++;
            }
            //System.out.print(maze.get(i).pis);
        }
        System.out.println();
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
        if(!maze.get(currentMazePartPos-1).isWall() && !maze.get(currentMazePartPos - 1).isVisited()){
            unvisitedNeighbours.add(maze.get(currentMazePartPos-1));
        }
        if(!maze.get(currentMazePartPos + 1).isWall() && !maze.get(currentMazePartPos + 1).isVisited()){
            unvisitedNeighbours.add(maze.get(currentMazePartPos + 1));
        }
        if(!maze.get(currentMazePartPos - mazeWidthHeight).isWall() && !maze.get(currentMazePartPos - mazeWidthHeight).isVisited()){
            unvisitedNeighbours.add(maze.get(currentMazePartPos - mazeWidthHeight));
        }
        if(!maze.get(currentMazePartPos + mazeWidthHeight).isWall() && !maze.get(currentMazePartPos + mazeWidthHeight).isVisited()){
            unvisitedNeighbours.add(maze.get(currentMazePartPos + mazeWidthHeight));
        }
        if(unvisitedNeighbours.isEmpty()){
            return null;
        }
        Random rand = new Random();
        int pos = rand.nextInt(unvisitedNeighbours.size());
        return unvisitedNeighbours.get(pos);
    }

    public int getMazeWidthHeight() {
        return mazeWidthHeight;
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
