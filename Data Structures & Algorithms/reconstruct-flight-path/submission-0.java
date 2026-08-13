class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, Queue<String>> graph = new HashMap<>();

        tickets.forEach(
            ticket -> 
                graph.computeIfAbsent(
                    ticket.get(0),
                    k-> new PriorityQueue<>()
                ).offer(ticket.get(1))
        );

        Deque<String> nodes = new ArrayDeque<String>();
        nodes.push("JFK");

        List<String> circuit = new ArrayList<>();
        while(!nodes.isEmpty()) {
            String airport = nodes.peek();
            if(graph.getOrDefault(airport, new PriorityQueue<>()).isEmpty()) {
                circuit.add(airport);
                graph.remove(airport);
                nodes.pop();
            } else {
                nodes.push(graph.get(airport).poll());
            }
        }

        /*
            BUF -> HOU
            HOU -> SEA
            JFK -> BUF
        */
        return circuit.reversed();
    }
}
