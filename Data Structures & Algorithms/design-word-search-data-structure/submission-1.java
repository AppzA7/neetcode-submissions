class WordDictionary {

    private WordDictionary[] letters;
    private boolean isWord;
    
    public WordDictionary() {
        isWord = false;
    }

    public void addWord(String word) {
        if(word.isEmpty()) return;
        WordDictionary node = this;
        
        int index = 0;
        while(index < word.length()) {
            int charIndex = word.charAt(index) - 'a';
            if(node.letters == null) {
                node.letters = new WordDictionary[26];
            }
            if(node.letters[charIndex] == null) {
                node.letters[charIndex] = new WordDictionary();
            }

            node = node.letters[charIndex];
            // System.out.println("Adding letter " + (char)(charIndex + 'a'));
            index++;
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        // System.out.println("Searching for word " + word);
        return searchFromIndexAndNode(word, 0, this);
    }

    public boolean searchFromIndexAndNode(String word, int index, WordDictionary node) {
        if(node == null) return false;
        while(index < word.length()) {
            // System.out.println("Searching for letter " + word.charAt(index));
            if(word.charAt(index) == '.') {
                if(node.letters == null) return false;
                for(int i=0;i<26;i++) {
                    if(searchFromIndexAndNode(word, index+1, node.letters[i])) {
                        return true;
                    }
                }
                return false;
            }

            int charIndex = word.charAt(index) - 'a';
            if(node.letters == null) return false;
            if(node.letters[charIndex] == null) return false;
            // System.out.println("Found");
            node = node.letters[charIndex];
            index++;
        }

        return node.isWord;
    }
}
