class TimeMap {

    Map<String, TreeMap<Integer, String>> keyMaps;

    public TimeMap() {
        // nkey = key + timestamp
        // finding key value over timestamp is o(n) ,n => size of map
        // findings keys stores at timestamp is also o(n)
        
        // maintain a map to map timestamp -> key -> value
        // finding key change over time is still O(n), n => size of timestamp space
        

        // get requires us to find all values of the key for ts < timestamp
        // we can use key -> timestamp -> value and use headmap function of treemap to get values

        keyMaps = new HashMap<>();

    }
    
    public void set(String key, String value, int timestamp) {
        keyMaps.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        // TreeMap<Integer, String> timestampMap = keyMaps.getOrDefault(key, null);
        // if(null == timestampMap) return "";
        // SortedMap<Integer, String> sortedMap = timestampMap.subMap(0, timestamp+1);
        // return sortedMap.lastEntry().getValue();

        NavigableMap<Integer, String> timestampMap = keyMaps.get(key);
        if( timestampMap == null) return "";
        Map.Entry<Integer, String> entry = timestampMap.floorEntry(timestamp);
        return (entry == null) ? "" : entry.getValue();
    }
}
