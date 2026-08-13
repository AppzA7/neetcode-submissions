class PrefixTree {
    
    PrefixTree[] children;
    boolean isTerminal;


    public PrefixTree() {
         isTerminal = false;
    }

    public void insert(String word) {
        PrefixTree node = this;
        for(int i=0;i<word.length(); i++) {
            int insertionIndex = word.charAt(i) - 'a';
            if(node.children == null) node.children = new PrefixTree[26];
            if(node.children[insertionIndex] == null) {
                node.children[insertionIndex] = new PrefixTree();
            }
            node = node.children[insertionIndex];
        }
        node.isTerminal = true;
    }

    public boolean search(String word) {
        PrefixTree node = findNode(word);
        return node != null && node.isTerminal;
    }

    public boolean startsWith(String prefix) {
        PrefixTree node = findNode(prefix);
        return node != null;
    }

    public PrefixTree findNode(String text) {
        PrefixTree node = this;
        for(int i=0;i<text.length();i++) {
            if(node.children == null) return null;
            int searchPoint = text.charAt(i) - 'a';
            if(node.children[searchPoint] == null) return null;
            node = node.children[searchPoint];
        }
        return node;
    }
}
