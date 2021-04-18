package sk.stuba.fei.uim.oop;


import java.util.ArrayList;
import java.util.Random;

public class Maze {
    public ArrayList<MazePart> maze;
    public int mazeWidthHeight = 11;
    public int mazeLength = mazeWidthHeight*mazeWidthHeight;

    public Maze() {
        maze = new ArrayList<>();
        for(int i = 0; i < mazeWidthHeight; i++){
            for(int j = 0; j < mazeWidthHeight; j++){
                maze.add(new MazePart(mazeWidthHeight*i+j, i, j));
            }
        }
        /*
        for(int position = 0; position < mazeLength; position++){
            maze.add(new MazePart(position));
        }
        */
        generateMaze();
        printMaze();
    }

    private void printMaze(){
        int j = 0;
        for(int i = 0; i < mazeLength; i++) {
            if(i == j*11){
                System.out.println();
                j++;
            }
            System.out.print(maze.get(i).pis);
        }
    }

    private void generateMaze(){
        MazePart startMazePart = maze.get(12);
        randomizedDFS(startMazePart);
    }

    private void randomizedDFS(MazePart mazePart){
        mazePart.setVisited(true);
        MazePart nextMazePart = randomUnvisitedNeighbour(mazePart);
        while(nextMazePart!=null){
            //connectCells
            nextMazePart.setVisited(true);
            randomizedDFS(nextMazePart);
            nextMazePart = randomUnvisitedNeighbour(mazePart);
        }
    }

    private MazePart randomUnvisitedNeighbour(MazePart mazePart){
        ArrayList<MazePart> unvisitedNeighbours = new ArrayList<>();
        int currentMazePartPos = mazePart.getPosition();




        if(maze.get(currentMazePartPos-1)!=null && !maze.get(currentMazePartPos - 1).isVisited()){
            unvisitedNeighbours.add(maze.get(currentMazePartPos-1));
        }
        if(maze.get(currentMazePartPos + 1)!=null && !maze.get(currentMazePartPos + 1).isVisited()){
            unvisitedNeighbours.add(maze.get(currentMazePartPos + 1));
        }
        if(maze.get(currentMazePartPos - mazeWidthHeight)!=null && !maze.get(currentMazePartPos - mazeWidthHeight).isVisited()){
            unvisitedNeighbours.add(maze.get(currentMazePartPos - mazeWidthHeight));
        }
        if(maze.get(currentMazePartPos + mazeWidthHeight)!=null && !maze.get(currentMazePartPos + mazeWidthHeight).isVisited()){
            unvisitedNeighbours.add(maze.get(currentMazePartPos + mazeWidthHeight));
        }
        if(unvisitedNeighbours.isEmpty()){
            return null;
        }
        Random rand = new Random();
        int pos = rand.nextInt(unvisitedNeighbours.size());
        return unvisitedNeighbours.get(pos);
    }

    private int findingNeighbours(MazePart mazePart){
        int currentMazePartI = mazePart.getI();
        int currentMazePartJ = mazePart.getJ();
        if(currentMazePartI==0){

        }
        return 2;
    }
}
