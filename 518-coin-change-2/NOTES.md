HashMap<String, Integer> hm = new HashMap<>();
return rec(amount, coins, 0, hm);
​
​
if(amount == 0)
return 1;
if(amount < 0 || index == coins.length)
return 0;
String key = amount + "p" + index;    // 5 + "" + 0
if(hm.containsKey(key))
return hm.get(krey);
int result = 0;
for(int i=index; i<coins; i++){
}