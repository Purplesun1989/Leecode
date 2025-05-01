import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
public class Medi82_166 {
    public static void main(String[] args) {
        solution82_166 solutions = new solution82_166();
//        1/3/2025
//        solutions.run82();
//        solutions.run86();
//        solutions.run89();
//        1/4/2025
//        solutions.run90();
//        solutions.run91();//***
//        solutions.run92();
//        1/5/2025
        solutions.run95();
    }
}
class solution82_166 {
    void run82(){
        ListNode head = new ListNode(1);
        head = head.insertArray(head,new int[]{1,1,1});
        head = deleteDuplicates(head);
        head.print(head);
    }
    ListNode deleteDuplicates(ListNode head){
        ListNode dummy =new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while(cur!=null && cur.next != null){
            if(cur.val == cur.next.val){
                while(cur.val == cur.next.val){
                    cur = cur.next;
                    if(cur.next == null){
                        break;
                    }
                }
                cur = cur.next;
                prev.next = cur;
            }
            else{
                prev = prev.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
    void run86(){
        ListNode head = new ListNode(1);
        head = head.insertArray(head,new int[]{4,3,2,5,2});
        head = partition(head,3);
        head.print(head);
    }
    ListNode partition(ListNode head, int x){
        ListNode target = new ListNode(x);
        ListNode res = new ListNode(0,target);
        ListNode tail = target;
        ListNode front = res;
        while(head!=null){
            if(head.val < x){
                ListNode t = new ListNode(head.val);
                t.next = target;
                front.next = t;
                front = t;
            }
            else {
                ListNode t = new ListNode(head.val);
                tail.next = t;
                tail = t;
            }
            head = head.next;
        }
        front.next = target.next;
        return res.next;
    }
    void run89(){
        System.out.println(grayCode(3).toString());
    }
    List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        BT4leetcode89(0,res,0,n,"");
        return res;
    }
    void BT4leetcode89(int path,List<Integer> res, int val,int n,String s){
        int[] bits = new int[] {0,1};
        if(path == n){
            res.add(val);
        }
        else{
            for(int i = 0; i < bits.length ; i++){
                val = (bits[i] == 1 ? val+(int)Math.pow(2,path) : val + 0);
                s = s + bits[i];
                BT4leetcode89(path+1,  res, val, n,s);
                s = s.substring(0, s.length() - 1);
            }
        }
    }
//    该方法基于一个重要的数学性质：对于给定的二进制位数n，第i个格雷编码可以通过i ^ (i >> 1)得到。
    List<Integer> grayCode1(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }
    void run90(){
        for (List<Integer> row : subsetsWithDup(new int[]{4,4,4,1,4} )) {
            for (Integer element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i <= nums.length;i++){
            BT4leetcode90(res,list,i,0,nums );
        }
        return res;
    }
    void BT4leetcode90(List<List<Integer>> res, List<Integer> path,int n,int start,int[] nums){
        if(path.size() == n){
            res.add(new ArrayList<>(path));
        }
        else{
            for(int i =start; i< nums.length; i++){
                if (i > start && nums[i] == nums[i - 1]) continue;
                path.add(nums[i]);
                BT4leetcode90(res, path, n, i+1, nums);
                path.remove(path.size()-1);
            }
        }
    }
    void run91(){
        System.out.println(numDecodings("1234"));
    }
    int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit >= 1 && oneDigit <= 9) dp[i] += dp[i - 1]; // 单个字符解码
            if (twoDigits >= 10 && twoDigits <= 26) dp[i] += dp[i - 2]; // 两个字符一起解码

        }
        return dp[n];
    }
    void run92(){
        ListNode dummy = new ListNode(1);
        dummy.insertArray(dummy,new int[]{2,3,4,5});
        ListNode head = reverseBetween(dummy,2,4);
        head.print(head);
    }
    ListNode reverseBetween(ListNode head, int left, int right){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode l = dummy;
        ListNode r = l.next;
        int index = 0 ;
        while(index != left-1){
            r = r.next;
            l = l.next;
            index ++;
        }
        ListNode t = r.next;
        while(t != null && index < right-1){
            r.next = t.next;
            t.next = l.next;
            l.next = t;
            t = r.next;
            index++;
        }
        return dummy.next;
    }
    void run95(){

    }
//    List<TreeNode> generateTrees(int n){
//        TreeNode res =
//    }
}
