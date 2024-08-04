// Network.java
package network;

import java.util.List;

public class Network {

    private Algorithm algorithm;

    public Network(List<String> networkDescription) {
        this.algorithm = new Algorithm(networkDescription);
    }

    public void performNextIteration() {
        algorithm.nextIteration();
    }

    public String getRoutingTable(String index) {
        return algorithm.getRoutingTable(index);
    }

    public void removeLink(String link) {
        algorithm.removeLink(link);
    }

    public void reachConvergence() {
        algorithm.reachConvergence();
    }

    public void splitHorizonUpdate(boolean selected) {
        algorithm.splitHorizonUpdate(selected);
    }

    public static void main(String[] args) {
        // Example usage
        List<String> networkDescription = List.of(
            "1,2,3",
            "1,3,1",
            "2,3,2"
        );

        Network network = new Network(networkDescription);

        network.performNextIteration();
        System.out.println(network.getRoutingTable("1"));
        network.removeLink("1,2,3");
        network.reachConvergence();
        network.splitHorizonUpdate(true);
    }
}
