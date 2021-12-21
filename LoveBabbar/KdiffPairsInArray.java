package LoveBabbar;

import java.util.*;

public class KdiffPairsInArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 5, 4};
        System.out.println(findPairs(arr, 0));
    }

    static int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums){
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        for (int num : hashMap.keySet()) {
            if(k>0 && hashMap.containsKey(num+k) || k==0 && hashMap.get(num)>1) count+=1;
        }
        return count;
    }
}
