class Solution {

    public String encode(List<String> strs) {
        StringBuffer buf = new StringBuffer();
        for( String s : strs) {
            buf.append(s.length()).append("#").append(s);
        }
        return buf.toString();
    }

    public List<String> decode(String str) {
        List<String> strings = new ArrayList<String>();

        int mainOffset = 0;
        while(mainOffset < str.length()) {
            int offset = str.indexOf('#', mainOffset);
            int length = Integer.valueOf(str.substring(mainOffset, offset));
            String extracted = str.substring(offset+1, offset+1+length);
            strings.add(extracted);
            mainOffset = offset + length + 1;
        }


        return strings;
    }
}
