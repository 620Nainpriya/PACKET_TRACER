// Node.java
package network;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private List<Link> links = new ArrayList<>();
    private List<Entry> routingTable = new ArrayList<>();
    private boolean splitHorizon;

    public Node(String name) {
        this.name = name;
    }

    public void addLink(Link link) {
        links.add(link);
    }

    public List<Node> getNeighbours() {
        List<Node> neighbours = new ArrayList<>();
        for (Link link : links) {
            neighbours.add(link.getOtherNode(this));
        }
        return neighbours;
    }

    public List<Entry> getRoutingTable() {
        return routingTable;
    }

    public void createTables(List<Node> nodeList) {
        for (Node node : nodeList) {
            if (!node.equals(this)) {
                routingTable.add(new Entry(node, Integer.MAX_VALUE, null));
            }
        }
    }

    public void updateTable(Node neighbour) {
        for (Entry entry : neighbour.getRoutingTable()) {
            int newCost = entry.getCost() + getLinkCost(neighbour);
            for (Entry myEntry : routingTable) {
                if (myEntry.getNode().equals(entry.getNode()) && newCost < myEntry.getCost()) {
                    myEntry.setCost(newCost);
                    myEntry.setPath(neighbour);
                }
            }
        }
    }

    public int getLinkCost(Node neighbour) {
        for (Link link : links) {
            if (link.getOtherNode(this).equals(neighbour)) {
                return link.getCost();
            }
        }
        return Integer.MAX_VALUE;
    }

    public void setSplitHorizon(boolean splitHorizon) {
        this.splitHorizon = splitHorizon;
    }

    public void updateCost(Node neighbour, int cost) {
        for (Link link : links) {
            if (link.getOtherNode(this).equals(neighbour)) {
                link.setCost(cost);
            }
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
