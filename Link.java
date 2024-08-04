// Link.java
package network;

public class Link {
    private int cost;
    private Node start;
    private Node end;

    public Link(int cost, Node start, Node end) {
        this.cost = cost;
        this.start = start;
        this.end = end;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Node getOtherNode(Node node) {
        if (node.equals(start)) {
            return end;
        } else {
            return start;
        }
    }
}
