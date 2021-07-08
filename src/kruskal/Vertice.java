/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal;

/**
 *
 * @author juhaszkornel
 */
public class Vertice {
    private static int counter;
    private double x;
    private double y;
    private int id;
    
    public Vertice(float x, float y) {
        this.id = counter++;
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public int getID() {
        return id;
    }
    
    public double distance(Vertice v) {
        return Math.sqrt(Math.pow(v.x-this.x, 2) + Math.pow(v.y-this.y, 2));
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vertice))
            return false;
        Vertice other = (Vertice)o;
        return other.id == this.id;
    }
    
    @Override
    public int hashCode() {
        return id;
    }
    
    @Override
    public String toString() {
        return "["+id+"](" + this.x + "," + this.y + ") \t";
    }
}
