import java.util.*;

class MouseAI {
    private int x, y;
    private int prevX, prevY;
    private Stack<Direction> path;
    private Random random;

    public MouseAI(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.prevX = x;
        this.prevY = y;
        this.path = new Stack<>();
        this.random = new Random();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int[][] maze) {
        if (path.isEmpty()) {
            // Calculate a new path if the current path is empty
            calculatePath(maze);
        }

        if (!path.isEmpty()) {
            Direction nextMove = path.pop();
            prevX = x;
            prevY = y;

            // Apply the move if it's valid
            int nextX = x + nextMove.dx;
            int nextY = y + nextMove.dy;

            if (isValidMove(nextX, nextY, maze)) {
                x = nextX;
                y = nextY;
            }
        }
    }

    private void calculatePath(int[][] maze) {
        List<Direction> validMoves = new ArrayList<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        // Check valid moves (limited to 1 tile ahead)
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (isValidMove(nextX, nextY, maze)) {
                validMoves.add(new Direction(dx[i], dy[i]));
            }
        }

        if (!validMoves.isEmpty()) {
            // Randomly select a valid move
            Direction nextMove = validMoves.get(random.nextInt(validMoves.size()));
            path.push(nextMove);
        }
    }

    private boolean isValidMove(int nextX, int nextY, int[][] maze) {
        return nextX >= 0 && nextX < maze.length &&
               nextY >= 0 && nextY < maze[0].length &&
               maze[nextX][nextY] == 0 &&
               (nextX != prevX || nextY != prevY);
    }
}

class Direction {
    int dx, dy;

    public Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
}
