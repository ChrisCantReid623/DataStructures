import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TESTING_Graphs {
    public static void main(String[] args) {
        undirectedGraphTEST();
        directedGraphTEST();
    }
    public static void undirectedGraphTEST() {
        Graphs.undirectedGraph ug = new Graphs.undirectedGraph(4);
        ug.addEdge(0, 1);
        ug.addEdge(0, 3);
        ug.addEdge(1, 2);
        ug.addEdge(1, 0);
        ug.addEdge(1, 3);
        ug.addEdge(3, 1);
        ug.breadthFirstSearch(0);
        System.out.println();
        ug.breadthFirstSearch(2);
        ug.depthFirstSearch_ITERATIVE(0);
    }
    public static void directedGraphTEST() {
        Graphs.directedGraph dg = new Graphs.directedGraph(3);
        dg.addEdge(0, 1, 1.0);
        dg.addEdge(1, 0, 2.0);
        dg.addEdge(0, 2, 3.0);
        dg.addEdge(2, 0, 4.0);
        dg.addEdge(1, 2, 5.0);
        dg.addEdge(2, 1, 6.0);
        dg.breadthFirstSearch(0);
        dg.depthFirstSearch_ITERATIVE(0);
    }
}

class Graphs {
    static class directedGraph {
        private ArrayList<LinkedList<Edge>> adjacencyList = new ArrayList<>();
        private int numVertices;

        /**
         * Represents the cost of traversing between adjacent edges.
         */
        private class Edge {
            int label;
            double weight;

            /**
             * Constructor
             */
            Edge(int inbound, double inboundWeight) {
                label = inbound;
                weight = inboundWeight;
            }
        }

        /**
         * Constructor
         *
         * @param numVertices the number of vertices.
         */
        directedGraph(int numVertices) {
            this.numVertices = numVertices;
            adjacencyList.add(null);
            for (int i = 1; i < (numVertices + 1); i++)
                adjacencyList.add(new LinkedList<Edge>());
        }

        /**
         * Adds an edge between outbound and inbound vertex destinations.
         *
         * @param outbound outbound vertex
         * @param inbound  inbound vertex
         * @param weight   edge weight
         */
        void addEdge(int outbound, int inbound, double weight) {
            adjacencyList.get(outbound).add(new Edge(inbound, weight));
        }

        /**
         * Breadth-First search algorithm.
         *
         * @param start staring vertex
         */
        void breadthFirstSearch(int start) {
            boolean[] visited = new boolean[numVertices];
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(start);
            visited[start] = true;
            while (queue.size() != 0) {
                int curVertex = queue.pollFirst();
                System.out.println(curVertex + " ");
                for (int i = 0; i < adjacencyList.get(curVertex).size(); i++) {
                    int nextVertex = adjacencyList.get(curVertex).get(i).label;
                    if (!visited[nextVertex]) {
                        visited[nextVertex] = true;
                        queue.add(nextVertex);
                    }
                }
            }
        }

        /**
         * Depth-First search algorithm
         *
         * @param start starting vertex
         */
        void depthFirstSearch_ITERATIVE(int start) {
            boolean[] visited = new boolean[numVertices];
            LinkedList<Integer> stack = new LinkedList<>();
            stack.add(start);
            visited[start] = true;
            while (stack.size() != 0) {
                int curVertex = stack.pollLast();
                System.out.print(curVertex + " ");
                for (int i = 0; i < adjacencyList.get(curVertex).size(); i++) {
                    int nextVertex = adjacencyList.get(curVertex).get(i).label;
                    if (!visited[nextVertex]) {
                        visited[nextVertex] = true;
                        stack.add(nextVertex);
                    }
                }
            }
        }

        /**
         * Depth-First search algorithm (Recursive)
         *
         * @param start starting vertex
         */
        void depthFirstSearch(int start) {
            boolean[] visited = new boolean[numVertices];
            depthFirstSearch_RECURSIVE(start, visited);
        }

        /**
         * Depth-First search algorithm (Recursive)
         *
         * @param start starting vertex
         */
        void depthFirstSearch_RECURSIVE(int start, boolean[] visited) {
            visited[start] = true;
            System.out.print(start + " ");
            for (int i = 0; i < adjacencyList.get(start).size(); i++) {
                int nextVertex = adjacencyList.get(start).get(i).label;
                if (!visited[nextVertex])
                    depthFirstSearch_RECURSIVE(nextVertex, visited);
            }
        }

        /**
         * Optimized traveling salesman search algorithm
         *
         * @param start    starting vertex
         * @param currPath empty array object tracking traversal
         */
        public double tspHeuristic(int start, List<Integer> currPath) {
            boolean[] visited = new boolean[numVertices];
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(start);
            visited[start] = true;
            double tspCost = 0;
            while (queue.size() != 0) {
                int curVertex = queue.pollFirst();
                double minEdgeWeight = Double.MAX_VALUE;
                int minVertex = -1;
                for (int i = 0; i < adjacencyList.get(curVertex).size(); i++) {
                    if (adjacencyList.get(curVertex).get(i).weight < minEdgeWeight && !currPath.contains(adjacencyList.get(curVertex).get(i).label)) {
                        minEdgeWeight = adjacencyList.get(curVertex).get(i).weight;
                        minVertex = adjacencyList.get(curVertex).get(i).label;
                    }
                    if (currPath.size() == numVertices && adjacencyList.get(curVertex).get(i).label == 1) {
                        tspCost += adjacencyList.get(curVertex).get(i).weight;
                    }
                }
                if (minVertex != 1) {
                    tspCost += minEdgeWeight;
                    queue.add(minVertex);
                }
            }
            return tspCost;
        }

        /**
         * Backtracking traveling salesman search algorithm (Recursive).
         *
         * @param start    starting vertex
         * @param currPath empty array object tracking traversal
         */
        public double tspBacktrack(int start, List<Integer> currPath) {
            //boolean[] visited = new boolean[numVertices];
            currPath.add(start);
            List<Integer> minPath = new ArrayList<>();
            double minPathCost = tspBacktrack(start, currPath, 0.0, minPath, Integer.MAX_VALUE);
            currPath.clear();
            currPath.addAll(minPath);
            return minPathCost;
        }

        /**
         * Backtracking traveling salesman search algorithm (Recursive).
         *
         * @param start    starting vertex
         * @param currPath worker variable for testing hamiltonian cycles
         * @param currCost worker variable for testing the cost of a hamiltonian cycle
         * @param minPath  maintains track of the last achieved hamiltonian cycle
         * @param minCost  maintains track of the cost of the last achieve hamiltonian cycle
         */
        double tspBacktrack(int start,
                            List<Integer> currPath, double currCost, List<Integer> minPath, double minCost) {
            if (!currPath.contains(start)) {
                currPath.add(start);
            }

            // Check for Remaining Unvisited Vertices
            if (currPath.size() == numVertices) {
                for (int n = 0; n < adjacencyList.get(start).size(); n++) {
                    if (adjacencyList.get(start).get(n).label == 1) {
                        currCost += adjacencyList.get(start).get(n).weight;
                        break;
                    }
                }
                if (currCost < minCost) {
                    minCost = currCost;
                    minPath.clear();
                    minPath.addAll(currPath);
                    return minCost;
                }
            }

            // Explore Unvisited Vertices
            else {
                for (int i = 0; i < adjacencyList.get(start).size(); i++) {

                    int endVertex = adjacencyList.get(start).get(i).label;
                    double weight = adjacencyList.get(start).get(i).weight;

                    if (!currPath.contains(endVertex)) {

                        currPath.add(endVertex);
                        currCost += weight;
                        minCost = tspBacktrack(endVertex, currPath, currCost, minPath, minCost);

                        // Backtrack
                        currPath.remove(currPath.size() - 1);
                        currCost -= weight;
                    }
                }
            }
            return minCost;
        }

        /**
         * Optimizes the Heuristic traveling salesman method.
         *
         * @param start    starting vertex
         * @param currPath empty array object tracking traversal
         */
        public double tspMine(int start, List<Integer> currPath) {
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(start);
            double tspCost = 0.0;
            while (queue.size() != 0) {
                int curVertex = queue.pollFirst();
                currPath.add(curVertex);
                double minEdgeWeight = Double.MAX_VALUE;
                int minVertex = -1;
                for (int i = 0; i < adjacencyList.get(curVertex).size(); i++) {
                    if (adjacencyList.get(curVertex).get(i).weight < minEdgeWeight && !currPath.contains(adjacencyList.get(curVertex).get(i).label)) {
                        minEdgeWeight = adjacencyList.get(curVertex).get(i).weight;
                        minVertex = adjacencyList.get(curVertex).get(i).label;
                    }
                    if (currPath.size() == numVertices && adjacencyList.get(curVertex).get(i).label == 1) {
                        tspCost += adjacencyList.get(curVertex).get(i).weight;
                    }
                }
                if (minVertex != -1) {
                    tspCost += minEdgeWeight;
                    queue.add(minVertex);
                }
            }
            return tspCost;
        }

        /**
         * Outputs time completion results for HEURISTIC method.
         */
        public void tspHeuristicTime() {
            List<Integer> tspCycle = new ArrayList<>();
            long startTime = System.nanoTime();
            double tspCost = this.tspHeuristic(1, tspCycle);
            long endTime = System.nanoTime();
            System.out.println("heuristic: cost = " + String.format("%.1f", tspCost) + ", " +
                    (endTime - startTime) / 1000000.0f + " milliseconds");
        }

        /**
         * Outputs time completion results for BACKTRACK method.
         */
        public void tspBacktrackTime() {
            List<Integer> tspCycle = new ArrayList<>();
            long startTime = System.nanoTime();
            double tspCost = this.tspBacktrack(1, tspCycle);
            long endTime = System.nanoTime();
            System.out.println("backtrack: cost = " + String.format("%.1f", tspCost) + ", " +
                    (endTime - startTime) / 1000000.0f + " milliseconds");
        }

        /**
         * Outputs time completion results for MINE method.
         */
        public void tspMineTime() {
            List<Integer> tspCycle = new ArrayList<>();
            long startTime = System.nanoTime();
            double tspCost = this.tspMine(1, tspCycle);
            long endTime = System.nanoTime();
            System.out.println("mine: cost = " + String.format("%.1f", tspCost) + ", " +
                    (endTime - startTime) / 1000000.0f + " milliseconds");
        }
    }
    static class undirectedGraph {
        int numVertices;
        private ArrayList<LinkedList<Integer>> adjacencyList = new ArrayList<>();

        undirectedGraph(int numVertices) {
            this.numVertices = numVertices;
            for (int i = 0; i < numVertices; i++) {
                adjacencyList.add(new LinkedList<Integer>());
            }
        }

        void addEdge(int outBound, int inBound) {
            adjacencyList.get(outBound).add(inBound);
            adjacencyList.get(inBound).add(outBound);
        }

        void breadthFirstSearch(int start) {
            boolean[] visited = new boolean[numVertices];
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(start);
            visited[start] = true;
            while (queue.size() != 0) {
                int currVertex = queue.pollFirst();
                System.out.println(currVertex + " ");
                for (int i = 0; i < adjacencyList.get(currVertex).size(); i++) {
                    int nextVertex = adjacencyList.get(currVertex).get(i);
                    if (!visited[nextVertex]) {
                        visited[nextVertex] = true;
                        queue.add(nextVertex);
                    }
                }
            }
        }

        void depthFirstSearch_ITERATIVE(int start) {
            boolean[] visited = new boolean[numVertices];
            LinkedList<Integer> stack = new LinkedList<>();
            stack.add(start);
            visited[start] = true;
            while (stack.size() != 0) {
                int curVertex = stack.pollLast();
                System.out.println(curVertex + " ");
                for (int i = 0; i < adjacencyList.get(curVertex).size(); i++) {
                    int nextVertex = adjacencyList.get(curVertex).get(i);
                    if (!visited[nextVertex]) {
                        visited[nextVertex] = true;
                        stack.add(nextVertex);
                    }
                }
            }

        }

        void depthFirstSearch(int start) {
            boolean[] visited = new boolean[numVertices];
            depthFirstSearch_RECURSIVE(start, visited);
        }

        void depthFirstSearch_RECURSIVE(int start, boolean[] visited) {
            visited[start] = true;
            System.out.println(start + " ");
            for (int i = 0; i < adjacencyList.get(start).size(); i++) {
                int nextVertex = adjacencyList.get(start).get(i);
                if (!visited[nextVertex]) {
                    depthFirstSearch_RECURSIVE(nextVertex, visited);
                }
            }
        }

        public String toString() {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < numVertices; i++)
            {
                str.append(i).append(": [");
                LinkedList<Integer> list = adjacencyList.get(i);
                for (Integer integer : list) str.append(integer).append(", ");
                str.append("]\n");
            }
            return str.toString();
        }
    }
}