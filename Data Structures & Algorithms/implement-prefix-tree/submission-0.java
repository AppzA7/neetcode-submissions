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
        node.setTerminal();
    }

    public boolean search(String word) {
        PrefixTree node = this;
        for(int i=0;i<word.length();i++) {
            if(node.children == null) return false;
            int searchPoint = word.charAt(i) - 'a';
            if(node.children[searchPoint] == null) return false;
            node = node.children[searchPoint];
        }
        return node.isTerminal();
    }

    public boolean startsWith(String prefix) {
        PrefixTree node = this;
        for(int i=0;i<prefix.length();i++) {
            if(node.children == null) return false;
            int searchPoint = prefix.charAt(i) - 'a';
            if(node.children[searchPoint] == null) return false;
            node = node.children[searchPoint];
        }
        return node != null;
    }

    public void setTerminal() {
        this.isTerminal = true;
    }

    public boolean isTerminal() {
        return this.isTerminal;
    }
}
