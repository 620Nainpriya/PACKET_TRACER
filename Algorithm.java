package network;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {

    private Boolean nodesGenerated = false;
    List<Node> nodeList = new ArrayList<>();
    private List<Link> linkList = new ArrayList<>();
    int convergenceLimiter = 20;
    int count = 0;

    public Algorithm(List<String> networkDescription) {
        for (String s : networkDescription) {
            if (!nodesGenerated) {
                createNodes(s);
                nodesGenerated = true;
            } else {
                createLink(s);
            }
        }

        for (Node node : nodeList) {
            node.createTables(nodeList);
        }
    }

    private void createNodes(String nodes) {
        for (String s : nodes.split(",")) {
            nodeList.add(new Node(s));
        }
    }

    private void createLink(String s) {
        String[] split = s.split(",");
        try {
            Node start = nodeList.get(Integer.parseInt(split[0]) - 1);
            Node end = nodeList.get(Integer.parseInt(split[1]) - 1);
            int cost = Integer.parseInt(split[2]);
            Link link = new Link(cost, start, end);
            start.addLink(link);
            end.addLink(link);
            linkList.add(link);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Unknown node used in links that isn't specified");
        }
    }

    void nextIteration() {
        for (Node n : nodeList) {
            List<Node> neighbours = n.getNeighbours();
            for (Node neighbour : neighbours) {
                n.updateTable(neighbour);
            }
        }
    }

    String getRoutingTable(String index) {
        StringBuilder table = new StringBuilder();
        String path;
        Node node = nodeList.get(Integer.parseInt(index) - 1);
        for (int i = 0; i < nodeList.size(); i++) {
            try {
                path = "- via Node " + (node.getRoutingTable().size() > i && node.getRoutingTable().get(i).getPath() != null ? node.getRoutingTable().get(i).getPath().toString() : "");
            } catch (NullPointerException e) {
                path = "";
            }
            table.append(String.format("%s to %d costs: %s  %s \n", node.toString(), i + 1,
                    (node.getRoutingTable().size() > i ? node.getRoutingTable().get(i).getCost() : "Unknown"), path));
        }

        return table.toString();
    }

    public void removeLink(String link) {
        String[] split = link.split(",");
        try {
            Node startNode = nodeList.get(Integer.parseInt(split[0]) - 1);
            Node endNode = nodeList.get(Integer.parseInt(split[1]) - 1);
            int cost = Integer.parseInt(split[2]);

            startNode.updateCost(endNode, cost);
            endNode.updateCost(startNode, cost);

            List<Node> neighbours = startNode.getNeighbours();
            for (Node neighbour : neighbours) {
                startNode.updateTable(neighbour);
            }

            List<Node> neighbours2 = endNode.getNeighbours();
            for (Node neighbour : neighbours2) {
                endNode.updateTable(neighbour);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Link you're trying to remove doesn't exist");
        }
    }

    public void reachConvergence() {
        int currentCheckSum = getCheckSum();
        nextIteration();
        int newCheckSum = getCheckSum();
        if (newCheckSum != currentCheckSum && count != convergenceLimiter) {
            count++;
            reachConvergence();
        } else {
            count = 0;
        }
    }

    public int getCheckSum() {
        int checkSum = 0;
        for (Node n : nodeList) {
            for (Entry e : n.getRoutingTable()) {
                checkSum += e.getCost();
            }
        }
        return checkSum;
    }

    public void splitHorizonUpdate(boolean selected) {
        for (Node n : nodeList) {
            n.setSplitHorizon(selected);
        }
    }

    void SplitHorizonUpdate(boolean selected) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
