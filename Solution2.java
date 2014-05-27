package decodeWays;

import java.util.ArrayList;
//follow up: print all possible results

public class Solution2 {
    public ArrayList<ArrayList<Character>> decodings(String s) {
    	ArrayList<ArrayList<Character>> res = new ArrayList<ArrayList<Character>>();
    	decodingsHelper(s,0,new ArrayList<Character>(),res);
    	return res;
	}
    
    public void decodingsHelper(String s, int end, ArrayList<Character> tmp, 
    		ArrayList<ArrayList<Character>> res) {
    	if(end >= s.length()) {
    		res.add(new ArrayList<Character>(tmp));
    	} else { 
    		if(s.charAt(end) != '0') { //cur is not 0, can simply add to tmp 
    			tmp.add((char)('A'+ s.charAt(end)-'1')); //calculate the index,then convert to ASCII
    			decodingsHelper(s,end+1,tmp,res);
    			tmp.remove(tmp.size()-1);
    		}
    		//check if cur position and next element can combine
    		if(end+1<s.length() && (s.charAt(end) == '1' || (s.charAt(end) == '2' && s.charAt(end+1) <='6'))) {
    			int index = (s.charAt(end)-'0')*10 + (s.charAt(end+1)-'0');
    			tmp.add((char)('A'+ index-1));
    			decodingsHelper(s,end+2,tmp,res);
    			tmp.remove(tmp.size()-1);
    		}
    	}
    }
}
