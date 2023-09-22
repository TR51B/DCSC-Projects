import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MazePlatform extends JPanel implements ActionListener {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final int CELL_SIZE = 20;
    private static final int MAZE_SIZE = WIDTH / CELL_SIZE;
    private static final int DELAY = 100; // Delay in milliseconds

    private int[][] maze;
    private int startX, startY, goalX, goalY;
    private Timer timer;
    private MouseAI mouseAI;

    public MazePlatform() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        generateMaze();
        mouseAI = new MouseAI(startX, startY);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void generateMaze() {
        maze = new int[MAZE_SIZE][MAZE_SIZE];
        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++) {
                maze[i][j] = 1; // Initialize all cells as walls
            }
        }

        Random random = new Random();
        startX = 1;
        startY = 1;
        goalX = MAZE_SIZE - 2;
        goalY = MAZE_SIZE - 2;
        maze[startX][startY] = 0; // Start
        maze[goalX][goalY] = 0; // Goal

        generateMazeRecursive(startX, startY, random);

        // Ensure the start position is reachable
        maze[0][1] = 0;
    }

    private void generateMazeRecursive(int x, int y, Random random) {
        int[] directions = {0, 1, 2, 3};
        shuffleArray(directions, random);

        for (int dir : directions) {
            int dx = 0, dy = 0;

            if (dir == 0) {
                dx = 2;
            } else if (dir == 1) {
                dy = 2;
            } else if (dir == 2) {
                dx = -2;
            } else if (dir == 3) {
                dy = -2;
            }

            int nx = x + dx;
            int ny = y + dy;

            if (nx > 0 && nx < MAZE_SIZE && ny > 0 && ny < MAZE_SIZE && maze[nx][ny] == 1) {
                maze[nx][ny] = 0;
                maze[x + dx / 2][y + dy / 2] = 0;
                generateMazeRecursive(nx, ny, random);
            }
        }
    }

    private void shuffleArray(int[] array, Random random) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++) {
                if (maze[i][j] == 1) {
                    g.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }
        g.setColor(Color.GREEN);
        g.fillRect(startX * CELL_SIZE, startY * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        g.setColor(Color.RED);
        g.fillRect(goalX * CELL_SIZE, goalY * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    
        // Draw the mouse AI after the maze and goal
        g.setColor(Color.BLUE);
        int mouseX = mouseAI.getX();
        int mouseY = mouseAI.getY();
        g.fillRect(mouseX * CELL_SIZE, mouseY * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Perform AI movements
        mouseAI.move(maze);
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Maze Platform");
        MazePlatform mazePlatform = new MazePlatform();
        frame.add(mazePlatform);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}