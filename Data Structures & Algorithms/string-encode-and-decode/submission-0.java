class Solution {

    final char control = 0;
    public String encode(List<String> strs) {
        char breakerc = control;

        String res = "";

        for(int i=0;i<strs.size();i++) {
            res = res + breakerc + strs.get(i);
        }

        System.out.println(res);
        System.out.println(res.length());
        return res;

    }

    public List<String> decode(String str) {
        if(str.length() > 0) {
            str = str.substring(1);
            String tempstr = "";
            StringBuffer sb = new StringBuffer();
            List<String> res = new ArrayList<>();
            for(char c : str.toCharArray()) {
                if(c != control) {
                    sb.append(c);
                } else {
                    res.add(new String(sb.toString()));
                    sb.setLength(0);
                }
            }
            res.add(sb.toString());
            return res;
        } else {
            return new ArrayList<>();
         }
    }
}
