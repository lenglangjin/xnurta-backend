package com.leda.test;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串数组words。words中每个元素都是一个包含 两个小写英文字母的单词。
 * 请你从 words中选择一些元素并按 任意顺序连接它们，并得到一个 尽可能长的回文串。每个元素 至多只能使用一次。
 * 请你返回你能得到的最长回文串的 长度。如果没办法得到任何一个回文串，请你返回 0。
 * 回文串指的是从前往后和从后往前读一样的字符串。
 *
 * 示例 1：
 * 输入：words = ["lc","cl","gg"]
 * 输出：6
 * 解释：一个最长的回文串为 "lc" + "gg" + "cl" = "lcggcl" ，长度为 6 。
 * "clgglc" 是另一个可以得到的最长回文串。
 *
 * 示例 2：
 * 输入：words = ["ab","ty","yt","lc","cl","ab"]
 * 输出：8
 * 解释：最长回文串是 "ty" + "lc" + "cl" + "yt" = "tylcclyt" ，长度为 8 。
 * "lcyttycl" 是另一个可以得到的最长回文串。
 *
 * 示例 3：
 * 输入：words = ["cc","ll","xx"]
 * 输出：2
 * 解释：最长回文串是 "cc" ，长度为 2 。
 * "ll" 是另一个可以得到的最长回文串。"xx" 也是。
 *
 * 提示：
 * 1 <= words.length <= 100000
 * words[i].length == 2
 * words[i]仅包含小写英文字母
 */
public class Test3 {
    public static void main(String[] args) {

        String[] str = new String[]{"lc","cl","gg"};
//        String[] str = new String[]{"ab","ty","yt","lc","cl","ab"};
//        String[] str = new String[]{"cc","ll","xx"};
        //aa  cc  cl bb bb bb bb lc
        //aa bb bb bb cc  cl lc
        int size = 0;
        int max = 0;
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            char[] element = s.toCharArray();
            if(element[0] == element[1]){
                if(map.containsKey(s)){
                    int count = map.get(s) + 1;
                    if(count > max){
                        max = count;
                    }
                    map.put(s,count);
                }else{
                    map.put(s,1);
                }
            }else {

                if(list.contains(resvere(s))){
                    size ++;
                    list.remove(resvere(s));
                    list.remove(s);
                }
                list.add(s);
            }
        }
        System.out.println(max*2+size*4);

    }

    public static String resvere(String s){
        String res = "";
        for (int i = s.length()-1; i >=0 ; i--) {
            res += s.charAt(i);
        }
        return res;
    }
}
