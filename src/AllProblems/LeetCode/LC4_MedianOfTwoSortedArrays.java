package AllProblems.LeetCode;

import java.util.*;

public class LC4_MedianOfTwoSortedArrays {
//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int total = nums1.length + nums2.length;
//        if((total) % 2 == 0){
//            int a = getKth(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, (total/2));
//            int b = getKth(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, (total/2)+1);
//            return (a+b) / 2;
//        }else{
//            return getKth(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, total/2);
//        }
//    }
//
//    public static int getKth(int[] a, int al, int ar, int[] b, int bl, int br, int k){
//
//        if(a.length == 0){
//            return b[k];
//        }
//        if(b.length == 0){
//            return a[k];
//        }
//        if(k == 1){
//            return Math.min(a[al], b[bl]);
//        }
//        int aMid = al + (ar-al) / 2;
//        int bMid = bl + (br-bl) / 2;
//
//        if(aMid + bMid > k){
//            if(a[aMid] < b[bMid]){
//                return getKth(a, aMid + 1, ar, b, bl, br, k - aMid - 1);
//            } else{
//                return getKth(a, al, ar, b, bMid + 1, br, k - bMid - 1);
//            }
//        } else{
//            if(a[aMid] > b[bMid]){
//                return getKth(a, al, aMid - 1, b, bl, br, k);
//            } else{
//                return getKth(a, al, ar, b, bl, bMid-1, k);
//            }
//        }
//    }

   static class Median{
        Queue<Double> low, high;

        public Median(){
            low = new PriorityQueue<>(Collections.reverseOrder());
            high = new PriorityQueue<>();
        }

        public void add(int d){
            double num = Double.valueOf(d);
            if(high.isEmpty()){
                high.add(num);
                return;
            }

            if(low.size() == high.size()){
                if(low.peek() > num){
                    high.add(low.remove());
                    low.add(num);
                } else{
                    high.add(num);
                }
            } else{
                if(num < high.peek()){
                    low.add(num);
                } else{
                    low.add(high.remove());
                    high.add(num);
                }
            }
        }

        public Double getMid(){
            if(low.size() == high.size()){
                return (low.peek() + high.peek())/2;
            }
            return high.peek();
        }


    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        Median m = new Median();
        int l1 = 0, l2 = 0;
        int total = nums1.length + nums2.length;
        while(l1 < nums1.length && l2 < nums2.length){
            if(nums1[l1] < nums2[l2]){
                m.add(nums1[l1]);
                l1++;
            } else{
                m.add(nums2[l2]);
                l2++;
            }
        }

        for(int i = l1 ; i < nums1.length; i++){
            m.add(nums1[i]);
        }

        for(int i = l2 ; i < nums2.length; i++){
            m.add(nums2[i]);
        }

        return m.getMid();

    }


    public static int maxScore(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = length - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        int maxProduct = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                maxProduct = Math.max(maxProduct, dp[i][j] * dp[j + 1][length - 1]);
            }
        }
        return maxProduct;
    }


    public static int getMaxium(List<Integer> arr) {
        int available_sink = 0;
        int current_max = arr.get(0);

        for(int i =1; i < arr.size(); i++) {
            int a = arr.get(i);
            if(a<current_max) {
                available_sink += current_max - a;
            } else {
                int diff = a - current_max;
                if (diff <= available_sink) {
                    available_sink -= diff;
                } else {
                    int remain = diff - available_sink;
                    int count = i + 1;
                    current_max += Math.ceil(Double.valueOf(remain)/Double.valueOf(count));
                    if(remain%count == 0)
                        available_sink = 0;
                    else
                        available_sink = count - remain % count;
                    System.out.println("ELSE "+remain +","+count);
                }


            }
            System.out.println(i + " " + current_max +" "+available_sink);
        }
        return current_max;
    }

    public static void main(String[] args) {
//        System.out.println(findMedianSortedArrays(new int[0], new int[]{2,3}));
//        System.out.println(maxScore("axbawbaseksqke"));
        List<Integer> l = new ArrayList<>();

        l.add(3);
        l.add(8);
        l.add(11);
        l.add(7);

        System.out.println(getMaxium(l));
    }
}
