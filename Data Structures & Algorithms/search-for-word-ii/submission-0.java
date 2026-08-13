class Solution {
    private static final int [][] DIRECTIONS = {
        {-1,0},
        {0,-1},
        {1,0},
        {0,1}
    };
    public List<String> findWords(char[][] board, String[] words) {
        Trie wordTrie = new Trie(words);
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                dfs(wordTrie, board, i, j);
            }
        }

        return results;
    }

    List<String> results = new ArrayList<>();
    
    public void dfs(Trie trienode, char[][] board, int r, int c) {
        // check validity of current position
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length) return;
        if(board[r][c] == '#') return;

        // if trienode has no children, return
        Trie nextNode = trienode.traverse(board[r][c]);
        // System.out.println("NextNode exists " + board[r][c] + " (" +  r + "," + c + ")");
        if(nextNode == null) return;
        if(nextNode.isWord()) {
            results.add(nextNode.getWord());
            nextNode.setVisited();
        }
        char chartemp = board[r][c];
        board[r][c] = '#';
        for(int[] direction : DIRECTIONS) {
            int tr = r+direction[0];
            int tc = c + direction[1];
            if(tr < 0 || tr >= board.length || tc < 0 || tc >= board[0].length) continue;
            dfs(nextNode, board, tr, tc);
        }
        board[r][c] = chartemp;
        // check if the current character exists in trie node, if it does, then explore
    }
}

class Trie {
    Trie[] letters;
    boolean isWord;
    String word;
    public Trie() {
        isWord = false;
    }

    public Trie(String[] words) {
        for(String word : words) {
            addWord(word);
        }
    }

    public void addWord(String word) {
        Trie node = this;
        for(char c : word.toCharArray()) {
            if(node.letters == null) node.letters = new Trie[26];
            if(node.letters[c-'a'] == null) node.letters[c-'a'] = new Trie();
            node = node.letters[c-'a'];
        }
        node.isWord = true;
        node.word = word;
    }

    public void setVisited() {
        this.isWord = false;
    }
    public Trie traverse(char c) {
        if(this.letters == null) return null;
        assert c <= 'z' && c >= 'a';
        if(this.letters[c-'a'] == null) return null;
        return this.letters[c-'a'];
    }

    public boolean isWord() {
        return isWord;
    }

    public boolean isEmpty() {
        return this.letters == null;
    }

    public String getWord() { return word; }
}
