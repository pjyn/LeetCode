public class Codec {

    Map<String, String> map = new HashMap<>();
    
    public String encode(String longUrl) {
        String key = "http://LC/"+map.size();
        map.put(key, longUrl);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));