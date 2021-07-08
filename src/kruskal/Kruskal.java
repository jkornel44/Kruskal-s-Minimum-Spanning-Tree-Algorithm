package kruskal;

import java.util.Scanner;

/**
 *
 * @author juhaszkornel
 */
public class Kruskal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a fileName: ");
        Graph graph = new Graph(sc.nextLine());
        
        System.out.println("Minimum Spanning Tree:");
        System.out.println(graph.run());
        
    } 
}
