/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author juhaszkornel
 */
public class Graph {
    private final ArrayList<Edge> edges;
    private final ArrayList<Vertice> vertices;
    private final ArrayList<Edge> forest;
    private final String fileName; 
    
    public Graph(String fileName) {
       this.fileName = fileName;
       
       this.edges = new ArrayList<>(); 
       this.vertices = new ArrayList<>();
       this.forest = new ArrayList<>();   
    }
    
    public ArrayList<Edge> getEdges() {
        return edges;
    }
    
    public void addEdge(Edge edge) {
        edges.add(edge);
    }
    
    public void sortEdges() {
        Collections.sort(edges);
    }
    
    public void generateEdges() {
        for(int i = 0; i < vertices.size(); i++) {
            for(int j = 0; j < vertices.size(); j++) {
                Edge tmp = new Edge(vertices.get(i), vertices.get(j));
                if(!edges.contains(tmp) && i != j) edges.add(tmp);
            }
        }
    }
    
    public void readVertices() {
        InputStream is = ResourceLoader.loadResource(fileName + ".txt");
        try (Scanner sc = new Scanner(is)){
            int count = Integer.parseInt(sc.nextLine());
  
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(",");
                int x = Integer.parseInt(line[0]);
                int y = Integer.parseInt(line[1]);
                vertices.add(new Vertice(x,y));
            }
            
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    public ArrayList<Edge> run() {
        readVertices();
        generateEdges();
        ArrayList<ArrayList<Vertice>> H = new ArrayList<>();
        
        for(Vertice vert : vertices) {
            ArrayList<Vertice> v = new ArrayList<>();
            v.add(vert);
            H.add(v);
        }
        sortEdges();
        
        for(Edge edge : edges) {
            Vertice vert1 = edge.getV1();
            Vertice vert2 = edge.getV2();
            for(int i = 0; i < H.size(); i++) {
                ArrayList<Vertice>  first = new ArrayList<>();
                ArrayList<Vertice>  second = new ArrayList<>();
                if(H.get(i).contains(edge.getV1()) && H.get(i).contains(edge.getV2())); 
                else if(!H.get(i).contains(edge.getV1()) && !H.get(i).contains(edge.getV2())); 
                else {
                    first = H.get(i);
                    for(int j = 0; j < H.size(); j++) { 
                        if(H.get(j).contains(edge.getV1()) && H.get(j).contains(edge.getV2())); 
                        else if(!H.get(j).contains(edge.getV1()) && !H.get(j).contains(edge.getV2())); 
                        else {
                        second = H.get(j);
                        }
                    }
                    forest.add(edge);
                    first.addAll(second);
                    H.add(first);
                    H.remove(first);
                    H.remove(second);
                }       
            }
        }

        return forest;
    }
}
