
import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainUI {

    private static Node[][] nodes;
    private static Node destinationNode;

    // draw the N-by-N boolean matrix to standard draw
    public void show(boolean[][] matrix, boolean notBlocked) {
        int matrixSize = matrix.length;
        nodes = new Node[matrixSize][matrixSize];

        StdDraw.setXscale(-1, matrixSize);
        StdDraw.setYscale(-1, matrixSize);
        StdDraw.setPenColor(StdDraw.BLACK);

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (i == 13 && j == 11 || i == 13 && j == 19 || i == 14 && j == 11
                        || i == 14 && j == 12 || i == 14 && j == 19 || i == 15 && j == 12
                        || i == 15 && j == 13 || i == 15 && j == 14 || i == 15 && j == 17
                        || i == 15 && j == 18 || i == 15 && j == 19 || i == 16 && j == 13
                        || i == 16 && j == 14 || i == 16 && j == 15 || i == 16 && j == 16 || i == 16 && j == 17
                        || i == 16 && j == 18 || i == 16 && j == 19 || i == 17 && j == 13
                        || i == 17 && j == 14 || i == 17 && j == 15 || i == 17 && j == 16
                        || i == 17 && j == 17 || i == 17 && j == 18 || i == 17 && j == 19
                        || i == 18 && j == 11 || i == 18 && j == 12 || i == 18 && j == 13
                        || i == 18 && j == 14 || i == 18 && j == 15 || i == 18 && j == 16
                        || i == 18 && j == 17 || i == 18 && j == 18 || i == 18 && j == 19
                        || i == 19 && j == 11 || i == 19 && j == 12 || i == 19 && j == 13
                        || i == 19 && j == 14 || i == 19 && j == 15 || i == 19 && j == 16
                        || i == 19 && j == 17 || i == 19 && j == 18 || i == 19 && j == 19) {
                    StdDraw.filledSquare(j, matrixSize - i - 1, .5);
                    nodes[i][j] = new Node(i, j, false, 0);
                } else if (i == 0 & j == 10 || i == 0 && j == 12 || i == 1 && j == 7
                        || i == 1 && j == 8 || i == 1 && j == 9 || i == 1 && j == 10
                        || i == 1 && j == 11 || i == 1 && j == 12 || i == 2 && j == 8
                        || i == 2 && j == 12 || i == 3 && j == 8 || i == 3 && j == 13
                        || i == 4 && j == 8 || i == 4 && j == 9 || i == 4 && j == 13
                        || i == 4 && j == 16 || i == 4 && j == 17 || i == 5 && j == 4
                        || i == 5 && j == 5 || i == 5 && j == 9 || i == 5 && j == 10
                        || i == 5 && j == 11 || i == 5 && j == 12 || i == 5 && j == 13
                        || i == 5 && j == 15 || i == 5 && j == 16 || i == 5 && j == 17
                        || i == 6 && j == 1 || i == 6 && j == 4 || i == 6 && j == 5
                        || i == 6 && j == 15 || i == 6 && j == 16 || i == 7 && j == 1
                        || i == 7 && j == 3 || i == 8 && j == 2 || i == 8 && j == 5
                        || i == 8 && j == 6 || i == 9 && j == 1 || i == 9 && j == 6
                        || i == 9 && j == 7 || i == 10 && j == 1 || i == 10 && j == 3
                        || i == 10 && j == 4 || i == 10 && j == 5 || i == 10 && j == 7
                        || i == 10 && j == 16 || i == 11 && j == 1 || i == 11 && j == 2
                        || i == 14 && j == 9 || i == 14 && j == 10 || i == 15 && j == 10
                        || i == 16 && j == 1 || i == 16 && j == 2 || i == 16 && j == 3
                        || i == 16 && j == 4 || i == 16 && j == 5 || i == 16 && j == 9
                        || i == 17 && j == 0 || i == 17 && j == 1) {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    StdDraw.filledSquare(j, matrixSize - i - 1, .5);
                    nodes[i][j] = new Node(i, j, true, 2);
                    StdDraw.setPenColor(StdDraw.BLACK);

                } else if (i == 1 & j == 0 || i == 1 && j == 1 || i == 1 && j == 3
                        || i == 2 && j == 0 || i == 2 && j == 1 || i == 2 && j == 2
                        || i == 2 && j == 3 || i == 2 && j == 4 || i == 2 && j == 5
                        || i == 3 && j == 0 || i == 3 && j == 1 || i == 3 && j == 2
                        || i == 3 && j == 3 || i == 3 && j == 4 || i == 3 && j == 5
                        || i == 4 && j == 2 || i == 5 && j == 1 || i == 5 && j == 2
                        || i == 6 && j == 0 || i == 7 && j == 18 || i == 7 && j == 19
                        || i == 8 && j == 17 || i == 8 && j == 18 || i == 8 && j == 19
                        || i == 9 && j == 12 || i == 9 && j == 13 || i == 9 && j == 14
                        || i == 9 && j == 15 || i == 9 && j == 16 || i == 9 && j == 17
                        || i == 9 && j == 18 || i == 10 && j == 8 || i == 10 && j == 12
                        || i == 10 && j == 13 || i == 10 && j == 14 || i == 10 && j == 15
                        || i == 11 && j == 6 || i == 11 && j == 7 || i == 11 && j == 8
                        || i == 11 && j == 9 || i == 11 && j == 12 || i == 11 && j == 13
                        || i == 11 && j == 14 || i == 12 && j == 2 || i == 12 && j == 3
                        || i == 12 && j == 4 || i == 12 && j == 5 || i == 12 && j == 6
                        || i == 12 && j == 7 || i == 12 && j == 8 || i == 13 && j == 0
                        || i == 13 && j == 1 || i == 13 && j == 2 || i == 13 && j == 3
                        || i == 13 && j == 4 || i == 13 && j == 5 || i == 13 && j == 6
                        || i == 13 && j == 7 || i == 13 && j == 8 || i == 14 && j == 2
                        || i == 14 && j == 3 || i == 14 && j == 4 || i == 14 && j == 5
                        || i == 14 && j == 6) {
                    StdDraw.setPenColor(StdDraw.DARK_GRAY);
                    StdDraw.filledSquare(j, matrixSize - i - 1, .5);
                    nodes[i][j] = new Node(i, j, true, 4);
                    StdDraw.setPenColor(StdDraw.BLACK);

                } else if (i == 2 & j == 9 || i == 2 & j == 10 || i == 2 && j == 11
                        || i == 3 && j == 9 || i == 3 && j == 10 || i == 3 && j == 11
                        || i == 3 && j == 12 || i == 4 && j == 10 || i == 4 && j == 11
                        || i == 4 && j == 12 || i == 8 && j == 3 || i == 8 && j == 4
                        || i == 9 && j == 2 || i == 9 && j == 3 || i == 9 && j == 4
                        || i == 9 && j == 5 || i == 10 && j == 2 || i == 10 && j == 6) {
                    StdDraw.setPenColor(StdDraw.GRAY);
                    StdDraw.filledSquare(j, matrixSize - i - 1, .5);
                    nodes[i][j] = new Node(i, j, true, 3);
                    StdDraw.setPenColor(StdDraw.BLACK);
                } else {
                    StdDraw.square(j, matrixSize - i - 1, .5);
                    nodes[i][j] = new Node(i, j, true, 1);
                }
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.setFont(new Font("TimesRoman", Font.PLAIN, 8));
                StdDraw.text(j, matrixSize - i - 1, ("(" + i + "," + j + ")"));
            }
        }

    }

    // draw the N-by-N boolean matrix to standard draw, including the points A (x1, y1) and B (x2,y2) to be marked by a circle
    public void show(boolean[][] matrix, boolean notBlocked, int x1, int y1, int x2, int y2) {
        int matrixSize = matrix.length;
        StdDraw.setXscale(-1, matrixSize);
        StdDraw.setYscale(-1, matrixSize);

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (i == 13 && j == 11 || i == 13 && j == 19 || i == 14 && j == 11
                        || i == 14 && j == 12 || i == 14 && j == 19 || i == 15 && j == 12
                        || i == 15 && j == 13 || i == 15 && j == 14 || i == 15 && j == 17
                        || i == 15 && j == 18 || i == 15 && j == 19 || i == 16 && j == 13
                        || i == 16 && j == 14 || i == 16 && j == 15 || i == 16 && j == 16 || i == 16 && j == 17
                        || i == 16 && j == 18 || i == 16 && j == 19 || i == 17 && j == 13
                        || i == 17 && j == 14 || i == 17 && j == 15 || i == 17 && j == 16
                        || i == 17 && j == 17 || i == 17 && j == 18 || i == 17 && j == 19
                        || i == 18 && j == 11 || i == 18 && j == 12 || i == 18 && j == 13
                        || i == 18 && j == 14 || i == 18 && j == 15 || i == 18 && j == 16
                        || i == 18 && j == 17 || i == 18 && j == 18 || i == 18 && j == 19
                        || i == 19 && j == 11 || i == 19 && j == 12 || i == 19 && j == 13
                        || i == 19 && j == 14 || i == 19 && j == 15 || i == 19 && j == 16
                        || i == 19 && j == 17 || i == 19 && j == 18 || i == 19 && j == 19) {
                    StdDraw.filledSquare(j, matrixSize - i - 1, .5);
                } else {
                    if (i == x1 && j == y1) {
                        StdDraw.setPenColor(StdDraw.RED);
                        StdDraw.filledCircle(j, matrixSize - i - 1, .5);
                        StdDraw.setPenColor(StdDraw.BLACK);

                    } else if (i == x2 && j == y2) {
                        StdDraw.setPenColor(StdDraw.GREEN);
                        StdDraw.filledCircle(j, matrixSize - i - 1, .5);
                        StdDraw.setPenColor(StdDraw.BLACK);
                    } else {
                        StdDraw.square(j, matrixSize - i - 1, .5);
                    }
                }
            }
        }
    }

    // return a N-by-N boolean matrix, where each entry is true with probability p
    public static boolean[][] generateMatrix(int coordinate, int blocked) {
        double unblocked = 0;
        boolean[][] matrix = new boolean[coordinate][coordinate];
        for (int i = 0; i < coordinate; i++) {
            for (int j = 0; j < coordinate; j++) {
                if (i == 13 && j == 11 || i == 13 && j == 19 || i == 14 && j == 11
                        || i == 14 && j == 12 || i == 14 && j == 19 || i == 15 && j == 12
                        || i == 15 && j == 13 || i == 15 && j == 14 || i == 15 && j == 17
                        || i == 15 && j == 18 || i == 15 && j == 19 || i == 16 && j == 13
                        || i == 16 && j == 14 || i == 16 && j == 15 || i == 16 && j == 16 || i == 16 && j == 17
                        || i == 16 && j == 18 || i == 16 && j == 19 || i == 17 && j == 13
                        || i == 17 && j == 14 || i == 17 && j == 15 || i == 17 && j == 16
                        || i == 17 && j == 17 || i == 17 && j == 18 || i == 17 && j == 19
                        || i == 18 && j == 11 || i == 18 && j == 12 || i == 18 && j == 13
                        || i == 18 && j == 14 || i == 18 && j == 15 || i == 18 && j == 16
                        || i == 18 && j == 17 || i == 18 && j == 18 || i == 18 && j == 19
                        || i == 19 && j == 11 || i == 19 && j == 12 || i == 19 && j == 13
                        || i == 19 && j == 14 || i == 19 && j == 15 || i == 19 && j == 16
                        || i == 19 && j == 17 || i == 19 && j == 18 || i == 19 && j == 19) {
                    matrix[i][j] = StdRandom.bernoulli(blocked);
                } else {
                    matrix[i][j] = StdRandom.bernoulli(unblocked);
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int matrixSize = 20;
        int obstacleRatio = 1; //this reveals how many blocked cells will be displayed

        // The following will generate a NxN squared grid with relatively few obstacles in it
        // The lower the second parameter, the more obstacles (black cells) are generated
        boolean[][] matrix = generateMatrix(matrixSize, obstacleRatio);

        //printing the boolean array on the console
        //StdArrayIO.print(matrix);
        //drawing the matrix
        new MainUI().show(matrix, true);
        System.out.println("The start node (A) will be shown in RED and the end node (B) will be shown in GREEN");
        int Ai = 0, Aj = 0, Bi = 0, Bj = 0;
        try {
            do {
                System.out.println("\nEnter i for A (Row number) > ");
                Ai = in.nextInt();
                System.out.println("Enter j for A (Column number) > ");
                Aj = in.nextInt();
                System.out.println("Enter i for B (Row number) > ");
                Bi = in.nextInt();
                System.out.println("Enter j for B (Column number) > ");
                Bj = in.nextInt();
                if (!nodes[Ai][Aj].getIsNotBlocked() || !nodes[Bi][Bj].getIsNotBlocked()) {
                    System.out.println("Sorry! You cant have the starting or the end node inside a blocked cell. Please select different co-ordinates");
                }
            } while (!nodes[Ai][Aj].getIsNotBlocked() || !nodes[Bi][Bj].getIsNotBlocked());
        } catch (java.lang.ArrayIndexOutOfBoundsException e1) {
            System.out.println("Wrong co-ordinates. Please enter again!");
            new MainUI().main(args);
        } catch (InputMismatchException e2) {
            System.out.println("Invalid co-ordinates. Please enter again!");
            new MainUI().main(args);
        }

        for (Node[] node : nodes) {
            for (int i = 0; i < nodes.length; i++) {
                if (node[i].getICoordinate() == Bi && node[i].getJCoordinate() == Bj) {
                    //setting the goal node
                    destinationNode = node[i];
                }
            }
        }

        //plots the two circles on the grid
        new MainUI().show(matrix, true, Ai, Aj, Bi, Bj);

        int option;
        Stopwatch timerFlow;
        do {
            System.out.println("Please select a preferred distance metric:");
            System.out.println("1. Manhattan Distance");
            System.out.println("2. Euclidean Distance");
            System.out.println("3. Chebyshev Distance");
            System.out.println("0. To Exit");

            String metricType;
            option = in.nextInt();
            switch (option) {
                case 1: {

                    timerFlow = new Stopwatch();

                    new MainUI().show(matrix, true, Ai, Aj, Bi, Bj);

                    metricType = "Manhattan";

                    //stores the list of nodes returned by the find path method
                    List<Node> finalPath = new PathFinder(matrixSize, nodes, metricType).findPath(Ai, Aj, Bi, Bj);
                    System.out.println("");

                    if (finalPath.size() > 0) {
                        System.out.println("A Path exists!");
                        System.out.println("Total cost of the shortest path: " + new MainUI().totalCostCalculation(finalPath));
                    } else {
                        System.out.println("Sorry! A Path doesn't exist!");
                    }
                    StdOut.println("Algorithm running time: " + timerFlow.elapsedTime());

                    //draws the shortest path on the grid
                    new MainUI().drawPathLine(matrixSize, finalPath, Color.YELLOW);
                    break;
                }

                case 2: {
                    timerFlow = new Stopwatch();

                    //new MainUI().show(randomMatrix, true);
                    new MainUI().show(matrix, true, Ai, Aj, Bi, Bj);

                    metricType = "Euclidean";

                    //stores the list of nodes returned by the find path method
                    List<Node> finalPath = new PathFinder(matrixSize, nodes, metricType).findPath(Ai, Aj, Bi, Bj);

                    System.out.println("");

                    if (finalPath.size() > 0) {
                        System.out.println("A Path exists! ");
                        System.out.println("Total cost of the shortest path: " + new MainUI().totalCostCalculation(finalPath));
                    } else {
                        System.out.println("Sorry! A Path doesn't exist!");
                    }
                    StdOut.println("Algorithm running time: " + timerFlow.elapsedTime());

                    //draws the shortest path on the grid
                    new MainUI().drawPathLine(matrixSize, finalPath, Color.BLUE);
                    break;
                }

                case 3: {
                    timerFlow = new Stopwatch();

                    //new MainUI().show(randomMatrix, true);
                    new MainUI().show(matrix, true, Ai, Aj, Bi, Bj);

                    metricType = "Chebyshev";

                    //stores the list of nodes returned by the find path method
                    List<Node> finalPath = new PathFinder(matrixSize, nodes, metricType).findPath(Ai, Aj, Bi, Bj);

                    System.out.println("");

                    if (finalPath.size() > 0) {
                        System.out.println("A Path exists!  ");
                        System.out.println("Total cost of the shortest path: " + new MainUI().totalCostCalculation(finalPath));
                    } else {
                        System.out.println("Sorry! A Path doesn't exist!");
                    }
                    StdOut.println("Algorithm running time: " + timerFlow.elapsedTime());

                    //draws the shortest path on the grid
                    new MainUI().drawPathLine(matrixSize, finalPath, Color.MAGENTA);
                    break;
                }
                case 0: {
                    System.exit(0);
                    break;
                }
            }
        } while (option != 0);
    }

    public void drawPathLine(int matrixSize, List<Node> nodes, Color color) {

        StdDraw.setXscale(-1, matrixSize);
        StdDraw.setYscale(-1, matrixSize);

        for (Node node : nodes) {
            if (color == color.YELLOW) {
                StdDraw.setPenRadius(0.03);
            } else if (color == color.BLUE) {
                StdDraw.setPenRadius(0.02);
            } else {
                StdDraw.setPenRadius(0.01);
            }
            StdDraw.setPenColor(color);
            StdDraw.line(node.getParent().getJCoordinate(), matrixSize - node.getParent().getICoordinate() - 1,
                    node.getJCoordinate(), matrixSize - node.getICoordinate() - 1);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.show(150);
            StdDraw.setPenRadius();
        }
    }

    public double totalCostCalculation(List<Node> path) {
        double totalCost = 0.0;
        for (Node node : path) {
            totalCost = totalCost + node.getG();
        }
        totalCost = path.get(path.size() - 1).getG();
        return totalCost;
    }
}
