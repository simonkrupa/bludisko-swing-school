package sk.stuba.fei.uim.oop;

public class Maze {
    public int[][] maze = new int[11][11];
    public Maze() {
        for(int i=0; i<maze.length; i++){
            for(int j = 0; j<maze[0].length; j++){
                System.out.print("#");
            }
            System.out.print("\n");
        }
    }
}
