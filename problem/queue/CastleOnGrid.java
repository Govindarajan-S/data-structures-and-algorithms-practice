package problem.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CastleOnGrid {
    private class Node {
        private int x;
        private int y;
        private int position;
        Node(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.position = x * n + y; 
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }
    List<Node> nodeList = new ArrayList<Node>();
    List<Node> known = new ArrayList<Node>();
    int[] forest;

    public void initializeForest(int n) {
        forest = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            forest[i] = i;
        }
    }

    public void initializeNode(int size) {
        int n = size;
        Node current;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                current = new Node(i, j, size);
                nodeList.add(current);
            }
        }
    } 

    public void breathFirstSearch(String[] grid, int x, int y, List<Node> known, int[] forest) {
        LinkedList<Node> queue = new LinkedList<Node>();
        LinkedList<Node> adjList;
        int size = grid[0].length();
        Node source;
        known.add(nodeList.get(x * size + y));
        queue.addLast(nodeList.get(x * size + y));
        while (!queue.isEmpty()) {
            source = queue.removeFirst();
            adjList = new LinkedList<Node>();
            // if (!known.contains(source)) {
                if (!(source.getX() + 1 >= size)) {
                    adjList.addLast(nodeList.get((source.getX() + 1) * size + source.getY()));
                }
                if (!(source.getX() - 1 < 0)) {
                    adjList.addLast(nodeList.get((source.getX() - 1) * size + source.getY()));
                }
                if (!(source.getY() + 1 >= size)) {
                    adjList.addLast(nodeList.get(source.getX() * size + (source.getY() + 1)));
                }
                if (!(source.getY() - 1 < 0)) {
                    adjList.addLast(nodeList.get(source.getX() * size + (source.getY() - 1)));
                }
            // }
            for (Node node : adjList) {
                if (!known.contains(node)) {
                    if (grid[node.getX()].charAt(node.getY()) == 'x') {
                        continue;
                    }
                    known.add(node);
                    queue.addLast(node);
                    forest[node.getPosition()] = source.getPosition();
                }
            }
        }
    }
    
    public LinkedList<Node> getPath(int x, int y, int goalX, int goalY, int[] forest, int size) {
        LinkedList<Node> path = new LinkedList<Node>();
        int source = new Node(x, y, size).getPosition();
        int goal = new Node(goalX, goalY, size).getPosition();
        if (forest[goal] == forest[source]) {
            path.addLast(nodeList.get(forest[goal]));
            return path;
        }
        path.addLast(nodeList.get(goal));
        while (forest[goal] != forest[source]) {
            path.addLast(nodeList.get(forest[goal]));
            goal = forest[goal];
        }
        path.addLast(nodeList.get(source));
        return path;
    }

    public int minMoves(String[] grid, int x, int y, int goalX, int goalY) {
        int size = grid[0].length();
        initializeForest(size);
        initializeNode(size);
        breathFirstSearch(grid, x, y, known, forest);
        LinkedList<Node> path = getPath(x, y, goalX, goalY, forest, size);
        return getMinMoves(path, size);
    }

    public int getMinMoves(LinkedList<Node> path, int size) {
        int minMoves = -1;
        Node current;
        int prevX = -1, prevY = -1;
        int currentX, currentY;
        int rowCount = 0, colCount = 0;
        if (path.size() == 0) {
            return minMoves;
        }
        if (path.size() == 1) {
            return ++minMoves;
        }
        if (path.size() > 1) {
            while (!path.isEmpty()) {
                current = path.removeFirst();
                currentX = current.getX();
                currentY = current.getY();
                if (prevX != currentX) {
                    if (prevY == currentY && (currentX == 0 || currentX == size - 1)) {
                        minMoves++;
                    }
                    prevX = currentX;
                } else if (prevY != currentY) {
                    if (prevX == currentX && (currentY == 0 || currentY == size - 1)) {
                        minMoves++;
                    }
                    prevY = currentY;
                }
            }
        }
        return ++minMoves;
    }

    public static void main(String[] args) {
        String[] grid = {
            ".....",
            "..x..",
            "...x.",
            "..x..",
            "....."
        };
        CastleOnGrid castleOnGrid = new CastleOnGrid();
        System.out.println(castleOnGrid.minMoves(grid, 2, 2, 0, 4));
    }
}
