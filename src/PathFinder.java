
import java.util.LinkedList;
import java.util.List;

public class PathFinder {

    private int N; //size of the matrix
    private String metric; //stores the distance measurement type
    private Node[][] nodes; //2D array to store the nodes on the grid
    private double horizontalVerticalCost;
    private double diagonalCost;
    private int adjacentWeight;

    public PathFinder(int N, Node[][] nodes, String metric) {
        this.N = N;
        this.nodes = nodes;
        this.metric = metric;
        switch (metric) {
            case "Manhattan":
                horizontalVerticalCost = 1.0;
                diagonalCost = 2.0;
                break;
            case "Euclidean":
                horizontalVerticalCost = 1.0;
                diagonalCost = 2.0;
                break;
            case "Chebyshev":
                horizontalVerticalCost = 1.0;
                diagonalCost = 1.0;
                break;
            default:
                break;
        }

    }

    public final List<Node> findPath(int startI, int startJ, int goalI, int goalJ) {
        // If our start position is the same as our goal position returns an empty list
        // Return an empty path. No need to move
        if (startI == goalI && startJ == goalJ) {
            return new LinkedList<Node>();
        }
        List<Node> nodesVisited = new LinkedList<Node>();   // The set of nodes visited.
        List<Node> nodesNotVisited = new LinkedList<Node>(); // The set of nodes yet to be visited.
        Node current = null;
        nodesVisited.add(nodes[startI][startJ]);
        // This loop will be broken as soon as the current node position is
        // equal to the goal position.
        while (true) {
            current = cheapestFValueInList(nodesVisited); // Gets node with the lowest weight from nodesVisited list.
            nodesVisited.remove(current);          // Remove current node from nodesVisited list.
            nodesNotVisited.add(current);           // Add current node to nodesNotVisited list.

            if ((current.getICoordinate() == goalI) && (current.getJCoordinate() == goalJ)) {
                return calculatePath(nodes[startI][startJ], current); // Return a LinkedList containing all of the visited nodes.
            }

            List<Node> adjacentNodes = getAdjacent(current, nodesNotVisited);
            for (Node adjacent : adjacentNodes) {
                if (!nodesVisited.contains(adjacent)) {
                    adjacent.setParent(current);    // Set current node as parent for this node.
                    adjacent.setH(nodes[goalI][goalJ], metric); // Set H cost of this node.
                    nodesVisited.add(adjacent); // Add node to nodesVisited.

                } else if (adjacent.getG() > adjacent.calculateG(current)) {
                    adjacent.setParent(current); // Set current node as parent for this node.
                }
            }
            // If no path exists ...
            if (nodesVisited.isEmpty()) {
                return new LinkedList<Node>(); // Return an empty list.
            }
        }
    }

    private List<Node> calculatePath(Node start, Node goal) {
        LinkedList<Node> path = new LinkedList<Node>();

        Node node = goal;
        boolean done = false;
        while (!done) {
            path.addFirst(node);
            node = node.getParent();
            if (node.equals(start)) {
                done = true;
            }
        }
        return path;
    }

    private Node cheapestFValueInList(List<Node> list) {
        Node cheapest = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getF() < cheapest.getF()) {
                cheapest = list.get(i);
            }
        }
        return cheapest;
    }

    private List<Node> getAdjacent(Node node, List<Node> nodesNotVisited) {
        List<Node> adjacentNodes = new LinkedList<Node>();
        int i = node.getICoordinate();
        int j = node.getJCoordinate();

        Node adjacent;
        // Check top nodes
        if (i > 0) {
            //Top node
            adjacent = getNode(i - 1, j);
            if (adjacent != null) {
                adjacentWeight = adjacent.getWeight();
            }
            if (adjacent != null && adjacent.getIsNotBlocked() && !nodesNotVisited.contains(adjacent)) {
                adjacent.setG(node, horizontalVerticalCost * adjacentWeight);
                adjacentNodes.add(adjacent);
            }

            if (!metric.equals("Manhattan")) {
                // Top Left
                if (j - 1 >= 0) {
                    adjacent = getNode(i - 1, j - 1);
                    if (adjacent != null) {
                        adjacentWeight = adjacent.getWeight();
                    }
                    if (adjacent != null && adjacent.getIsNotBlocked() && !nodesNotVisited.contains(adjacent)) {
                        adjacent.setG(node, diagonalCost * adjacentWeight);
                        adjacentNodes.add(adjacent);
                    }
                }

                // Top Right
                if (j + 1 < N) {
                    adjacent = getNode(i - 1, j + 1);
                    if (adjacent != null) {
                        adjacentWeight = adjacent.getWeight();
                    }
                    if (adjacent != null && adjacent.getIsNotBlocked() && !nodesNotVisited.contains(adjacent)) {
                        adjacent.setG(node, diagonalCost * adjacentWeight);
                        adjacentNodes.add(adjacent);
                    }
                }
            }
        }

        // Check bottom nodes
        if (i < N) {
            //bottom node
            adjacent = getNode(i + 1, j);
            if (adjacent != null) {
                adjacentWeight = adjacent.getWeight();
            }
            if (adjacent != null && adjacent.getIsNotBlocked() && !nodesNotVisited.contains(adjacent)) {
                adjacent.setG(node, horizontalVerticalCost * adjacentWeight);
                adjacentNodes.add(adjacent);
            }

            if (!metric.equals("Manhattan")) {
                //bottom left node
                if (j - 1 >= 0) {
                    adjacent = getNode(i + 1, j - 1);
                    if (adjacent != null) {
                        adjacentWeight = adjacent.getWeight();
                    }
                    if (adjacent != null && adjacent.getIsNotBlocked() && !nodesNotVisited.contains(adjacent)) {
                        adjacent.setG(node, diagonalCost * adjacentWeight);
                        adjacentNodes.add(adjacent);
                    }
                }

                //bottom right node
                if (j + 1 > N) {
                    adjacent = getNode(i + 1, j + 1);
                    if (adjacent != null) {
                        adjacentWeight = adjacent.getWeight();
                    }
                    if (adjacent != null && adjacent.getIsNotBlocked() && !nodesNotVisited.contains(adjacent)) {
                        adjacent.setG(node, diagonalCost * adjacentWeight);
                        adjacentNodes.add(adjacent);
                    }
                }
            }

        }

        // Check left node
        if (j > 0) {
            adjacent = getNode(i, j - 1);
            if (adjacent != null) {
                adjacentWeight = adjacent.getWeight();
            }
            if (adjacent != null && adjacent.getIsNotBlocked() && !nodesNotVisited.contains(adjacent)) {
                adjacent.setG(node, horizontalVerticalCost * adjacentWeight);
                adjacentNodes.add(adjacent);
            }

        }

        // Check right node
        if (j < N) {
            adjacent = getNode(i, j + 1);
            if (adjacent != null) {
                adjacentWeight = adjacent.getWeight();
            }
            if (adjacent != null && adjacent.getIsNotBlocked() && !nodesNotVisited.contains(adjacent)) {
                adjacent.setG(node, horizontalVerticalCost * adjacentWeight);
                adjacentNodes.add(adjacent);
            }
        }
        return adjacentNodes;
    }

    public Node getNode(int i, int j) {
        if (i >= 0 && i < N && j >= 0 && j < N) {
            return nodes[i][j];
        } else {
            return null;
        }
    }
}
