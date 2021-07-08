package kruskal;

/**
 *
 * @author juhaszkornel
 */
public class Edge implements Comparable<Edge>{
    private Vertice v1;
    private Vertice v2;
    private double weight;
    
    public Edge(Vertice v1, Vertice v2) {
        this.weight = v1.distance(v2);
        this.v1 = v1;
        this.v2 = v2;
    }
    
    public Vertice getV1() {
        return v1;
    }
    
    public Vertice getV2() {
        return v2;
    }
    
    @Override
    public int compareTo(Edge otherEdge) {
        if(this.weight != otherEdge.weight)
            return this.weight > otherEdge.weight ? 1 : -1;
        else 
            return 0;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Edge)) return false;
        Edge other = (Edge)o;
        if(this.v1.equals(other.v1) && this.v2.equals(other.v2)) return true;
        if(this.v1.equals(other.v2) && this.v2.equals(other.v1)) return true;
        return false;
    }
    
    @Override
        public int hashCode() {
            return (int)weight;
        }
    
    @Override
    public String toString() {
        return "\n"+ v1 + "" + v2 + "\t" + this.weight;
    }
}
