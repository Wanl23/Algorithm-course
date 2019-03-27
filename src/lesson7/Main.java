package lesson7;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addEdge(0, 1);
        g.addEdge(1, 3);
        g.addEdge(3, 6);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(5, 7);
        g.addEdge(6, 7);
        g.addEdge(5, 9);
        g.addEdge(9, 8);

        BreadthFirstPaths bfp = new BreadthFirstPaths(g, 0);
        System.out.println(bfp.hasPathTo(8));
        System.out.println(bfp.pathTo(8));
        System.out.println(bfp.distTo(8));
    }
}
