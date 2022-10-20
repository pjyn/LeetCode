class Solution {
    public String intToRoman(int num) {
        
        TreeMap<Integer, String> tp = new TreeMap<>();
        
        tp.put(1, "I");
        tp.put(4, "IV");
        tp.put(5, "V");
        tp.put(9, "IX");
        tp.put(10, "X");
        tp.put(40, "XL");
        tp.put(50, "L");
        tp.put(90, "XC");
        tp.put(100, "C");
        tp.put(400, "CD");
        tp.put(500, "D");
        tp.put(900, "CM");
        tp.put(1000, "M");
        
        String ans = "";
        while(num > 0){
            Integer closetKey = tp.floorKey(num);
            ans += tp.get(closetKey);
            num = num - closetKey;
        }
        return ans;
    }
}