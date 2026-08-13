record Tweet(int tweetId, int time) implements Comparable<Tweet>{
    @Override
    public int compareTo(Tweet other) {
        return Integer.compare(time, other.time);
    }
}

class Twitter {

    int time;
    Map<Integer, User> userIdUserMap;

    public Twitter() {
        time = 0;
        userIdUserMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        Tweet tweet = new Tweet(tweetId, time);
        User poster = userIdUserMap.computeIfAbsent(userId, k -> new User(k));
        poster.post(tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        return userIdUserMap.get(userId).getNewsFeed();
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        User followee = userIdUserMap.computeIfAbsent(followeeId, k -> new User(k));
        User follower = userIdUserMap.computeIfAbsent(followerId, k -> new User(k));
        follower.follow(followee);
    }
    
    public void unfollow(int followerId, int followeeId) {
        User followee = userIdUserMap.get(followeeId);
        userIdUserMap.get(followerId).unfollow(followee);
    }
}

// Users
class User {
    int userId;
    NodeList<Tweet> posts;
    Set<User> followers;

    public User(int userId) {
        this.userId = userId;
        posts = new NodeList<>();
        followers = new HashSet<>();
    };
    
    // Users.follow(User) -> O(1) -> add to user follower list
    public void follow(User followee) {
        followers.add(followee);
    }
    
    // Users.unfollow(User) -> O(1) -> remove from user follower list
    public void unfollow(User followee) {
        followers.remove(followee);
    }

    // User.post() -> O(1) -> add to linked list of user posts
    public void post(Tweet tweet) {
        posts.add(tweet);
    }

    public NodeList<Tweet> getPosts() {
        return posts;
    }

    // User.getNewsFeed() -> o(nlogn) -> make min heap with linked list heads & fetch 10 latest (nlogn)
    public List<Integer> getNewsFeed() {
        PriorityQueue<Node<Tweet>> minHeap = new PriorityQueue<>();
        
        if(posts.getHead() != null)
            minHeap.offer(posts.getHead());

        for(User follower : followers) {
            if(follower.posts.getHead() != null)
            minHeap.offer(follower.posts.getHead());
        }

        // System.out.println(minHeap.peek());
        List<Integer> retList = new ArrayList<>();
        int count = 0;
        while(!minHeap.isEmpty() && count < 10) {
            Node<Tweet> tweet = minHeap.poll();
            retList.add(tweet.getTweet().tweetId());

            Node<Tweet> next = tweet.getNext();
            if(next != null) minHeap.offer(next);
            count++;
        }
        return retList;
    }
}

class NodeList<T extends Comparable<T>> {
    Node<T> preHead;

    public NodeList() {
        preHead = new Node<>(null);
    }

    public void add(T nodeValue) {
        Node<T> node = new Node<>(nodeValue);
        // System.out.println("Created new node " + node);
        Node<T> next = preHead.next;
        preHead.next = node;
        node.next = next;
    }

    public Node<T> getHead() {
        return preHead.next;
    }
}

class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
    T tweet;
    Node<T> next;

    public Node(T value) {
        this.tweet = value;
    }

    public T getTweet() {
        return tweet;
    }

    public Node<T> getNext() {
        return next;
    }

    @Override
    public int compareTo(Node<T> other) {
        return other.tweet.compareTo(tweet);
    }
}

