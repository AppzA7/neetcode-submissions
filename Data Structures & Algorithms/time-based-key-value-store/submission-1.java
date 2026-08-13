class TimeMap {

    private static class Record {
        int timestamp;
        String value;

        Record(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private final Map<String, List<Record>> records;

    public TimeMap() {
        records = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        records.computeIfAbsent(key, k -> new ArrayList<>())
        .add(new Record(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        // find latest value using binary search
        List<Record> list = records.get(key);
        if(list == null) return "";
        int l = 0, r = list.size() - 1;

        int answer = -1;
        while(l <= r) {
            int mid = l + (r - l)/2;

            if(list.get(mid).timestamp <= timestamp) {
                answer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if(answer == -1) return "";
        return list.get(answer).value;
    }
}
