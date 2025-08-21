package com.leda;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MergeArr {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        System.out.println(merge(intervals));

        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    }


    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int len = intervals.length;
        int index = 0;
        for (int i = 1; i < len; i++) {
            int[] left = res.get(i-1);
            int[] right = intervals[i];
            if(left[1] >= right[0]){
                int[] arr = new int[]{left[0],right[1]};
                res.remove(index++);
                res.add(arr);
            }else {
                res.add(right);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
