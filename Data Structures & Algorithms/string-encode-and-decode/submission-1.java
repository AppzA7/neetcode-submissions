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

        while(str.length() > 0) {
            int offset = str.indexOf('#');
            int length = Integer.valueOf(str.substring(0, offset));
            String extracted = str.substring(offset+1, offset+1+length);
            strings.add(extracted);
            str = str.substring(offset + 1 + length);
        }

        return strings;
    }
}
