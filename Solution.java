package decodeWays;

public class Solution {
    public int numDecodings(String s) {
    	if (s.length() == 0) return 0;
    	
        char[] c = s.toCharArray();
        int[] dp = new int[c.length+1]; //from second node, relate to char in c
        dp[0] = 1; //first is a dummy node
        if (c[0] != '0') 
        	dp[1] = 1; //first real node in char[] c, if not 0, means has one decode way
        else
        	dp[1] = 0;
        
        for (int i = 2; i <= c.length; i++) {
        	if (c[i-1] != '0') 
        		dp[i] = dp[i-1]; //cur node is not 0, num of ways = ways of prev node
        	//check if prev two nodes are valid together
        	if (c[i-2] == '1' || (c[i-2] == '2' && c[i-1] <= '6')) 
        		dp[i] += dp[i-2];
        } 
        return dp[c.length];
    }
}