package sk.stuba.fei.uim.oop;


import java.util.ArrayList;
import java.util.Random;

public class Maze {
    public ArrayList<MazePart> maze;
    public int mazeWidthHeight = 13;
    public int mazeLength = mazeWidthHeight*mazeWidthHeight;

    public Maze() {
        maze = new ArrayList<>();
        for(int i = 0; i < mazeWidthHeight; i++){
            for(int j = 0; j < mazeWidthHeight; j++){
                if(i==0 || i==12){
                    maze.add(new MazePart((mazeWidthHeight)*i+j, i, j));
                    maze.get((mazeWidthHeight)*i+j).pis = 'X';
                }
                else if(j==0 || j==12){
                    maze.add(new MazePart((mazeWidthHeight)*i+j, i, j));
                    maze.get((mazeWidthHeight)*i+j).pis = 'X';
                }
                else{
                    maze.add(new MazePart((mazeWidthHeight)*i+j, i, j));
                }
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
            if(i == j*13){
                System.out.println();
                j++;
            }
            System.out.print(maze.get(i).pis);
        }
        System.out.println();
    }

    private void generateMaze(){
        MazePart startMazePart = maze.get(14);
        randomizedDFS(startMazePart);
    }

    private void randomizedDFS(MazePart mazePart){
        printMaze();
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
        if(maze.get(currentMazePartPos-1).pis!='X' && !maze.get(currentMazePartPos - 1).isVisited()){
            unvisitedNeighbours.add(maze.get(currentMazePartPos-1));
        }
        if(maze.get(currentMazePartPos + 1).pis!='X' && !maze.get(currentMazePartPos + 1).isVisited()){
            unvisitedNeighbours.add(maze.get(currentMazePartPos + 1));
        }
        if(maze.get(currentMazePartPos - mazeWidthHeight).pis!='X' && !maze.get(currentMazePartPos - mazeWidthHeight).isVisited()){
            unvisitedNeighbours.add(maze.get(currentMazePartPos - mazeWidthHeight));
        }
        if(maze.get(currentMazePartPos + mazeWidthHeight).pis!='X' && !maze.get(currentMazePartPos + mazeWidthHeight).isVisited()){
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
