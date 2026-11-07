class Solution {
    public ArrayList<String> generateUsernames(String[] arr) {
        ArrayList<String> res = new ArrayList<>();
        
        Map<String, Integer> usernames = new HashMap<>();
        for (String username: arr) {
            usernames.put(username, 0);
        }
        
        for (String username: arr) {
            int counter = 1;
            
            String newUserName = username;
            while (usernames.containsKey(newUserName)) {
                if (counter == 1 && usernames.get(newUserName) == 0) {
                    break;
                }
                
                newUserName = username + String.valueOf(counter);
                counter++;
            }
            
            usernames.put(newUserName, usernames.getOrDefault(newUserName, 0) + 1);
            res.add(newUserName);
        }
        
        return res;
    }
}
