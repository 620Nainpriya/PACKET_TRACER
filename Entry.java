// Entry.java
package network;

public class Entry {
    private Node node;
    private int cost;
    private Node path;

    public Entry(Node node, int cost, Node path) {
        this.node = node;
        this.cost = cost;
        this.path = path;
    }

    public Node getNode() {
        return this.node;
    }

    public int getCost() {
        return this.cost;
    }

    public Node getPath() {
        return this.path;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setPath(Node path) {
        this.path = path;
    }
}
