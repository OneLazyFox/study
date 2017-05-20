package com.neco;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/5/12.
 *
 * @author 张小虎
 * @version 1.0
 */
public class DistinctCharacter {
    public static void main(String[] args) {
        String s = "sdf sdjnsdbngvhjdbsreur";

        Map<String,Integer> map = new HashMap<String,Integer>();
        for (int i=0;i<s.length();i++){
            String key = String.valueOf(s.charAt(i));
            if(!map.containsKey(key)){
                map.put(key,1);
            }else {
                map.put(key,map.get(key) + 1);
            }

        }

        System.out.println(map);
        //getDistinct(s);
    }

    /*private static void getDistinct(String s) {
        int a = s.length();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < a; i++) {
            Integer m = map.get(s.charAt(i));
            if (m != null) {
                map.put(s.charAt(i),m+1);
            } else {
                map.put(s.charAt(i),1);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry: entries){
            Character key = entry.getKey();
            System.out.println(key + " : " + map.get(key));
        }
    }*/
}
