import jdk.jfr.Unsigned;

import java.nio.file.Path;
import java.util.*;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Medi2_81 {
    public static void main(String[] args) {
        solution solutions = new solution();
//        01/12/2024
//        solutions.runaddTwoNumbers();
//        solutions.runlongestPalindrome();
//        solutions.runShortestPalindrome();
//        02/12/2024
//        solutions.runConvert();
//        solutions.runReverse(-123);
//        solutions.runmyAtoi();
//        solutions.runmaxArea();
//        03/12/2024
//        solutions.runinToRoman();
//        solutions.runthreeSum();
//        04/12/2024
//        solutions.runthreeSumClosest();
//        solutions.runletterCombinations();
//        solutions.runletterCombinationsWithbacktracking();
//        06/12/2024
//        solutions.runfourSum();
//        07/12/2024
//        solutions.runremoveNthFromEnd();
//        08/12/2024
//        solutions.rungenerateParenthesis();
//        solutions.runswapPairs();
//        solutions.rundivide();
//        09/12/2024
//        solutions.runnextPermutation();
//        solutions.runsearch();
//        solutions.run34();
//        solutions.run36();
//        10/12/2024
//        solutions.run38();
//        solutions.run39();
//        solutions.run40();
//        solutions.run43();
//        11/12/2024
//        solutions.run45();
//        solutions.run46();
//        16/12/2024
//        solutions.run47();
//        solutions.run48();
//        solutions.run49();
//        solutions.run50();
//        solutions.run53();
//        17/12/2024
//        solutions.run54(); //*****
//        27/12/2024
//        solutions.run55();
//        solutions.run56();//***
//        29/12/2024
//        solutions.run57();
//        solutions.run61();
//        solutions.run62();
//        solutions.run63();
//        30/12/2024
//        solutions.run64();
//        solutions.run71();
//        solutions.run72();
//        31/12/2024
//        solutions.run73();
//        solutions.run74();
//        solutions.run75();
//        01/01/2025
//        solutions.run77();
//        solutions.run78();
//        solutions.run79();
//        02/01/2025
//        solutions.run80();
//        solutions.run81();
    }

}

class solution{
//2. Add Two Numbers
//    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit.
//    Add the two numbers and return the sum as a linked list.
//    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    void runaddTwoNumbers(){
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(5);
        h1.insert(h1,3);
        h1.insert(h1,4);
        h2.insert(h2,4);
        h2.insert(h2,6);
        addTwoNumbers(h1, h2).print(addTwoNumbers(h1, h2));
    }
    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode head = res;
        int carry = 0;
        while(l1 != null || l2 != null){
            int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = val/10;
            int digit = val % 10;
            res.val = digit;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
            if((l1 != null || l2 != null)|| carry>0){
                res.next = new ListNode(carry);
                res = res.next;
            }
        }
        return head;
    }
    //    Example 1:
//
//    Input: s = "abcabcbb"
//    Output: 3
//    Explanation: The answer is "abc", with the length of 3.
//    Example 2:
//
//    Input: s = "bbbbb"
//    Output: 1
//    Explanation: The answer is "b", with the length of 1.
//    Example 3:
//
//    Input: s = "pwwkew"
//    Output: 3
//    Explanation: The answer is "wke", with the length of 3.
//    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
    void runlengthOfLongestSubstring(){
        System.out.println(lengthOfLongestSubstring("aab"));
    }
    int lengthOfLongestSubstring(String s) {
        HashSet<Character> memo = new HashSet<>();
        int max = 0;
        int head = 0;
        for (int rear = 0; rear < s.length(); rear++) {

            if(!memo.contains(s.charAt(rear))){
                memo.add(s.charAt(rear));

            }
            else{
                while(memo.contains(s.charAt(rear))&& rear > head){
                    memo.remove(s.charAt(head++));
                }
                memo.add(s.charAt(rear));
            }
            max =(Math.max(max, memo.size()));
        }
        return max;
    }
    //    Given a string s, return the longest
//    Example 1:
//
//    Input: s = "babad"
//    Output: "bab"
//    Explanation: "aba" is also a valid answer.
//            Example 2:
//
//    Input: s = "cbbd"
//    Output: "bb"
    void runlongestPalindrome(){
        System.out.println(longestPalindrome("a"));
    }
    String longestPalindrome(String s) {
        String res = "";
        for(int i = 0; i < s.length(); i++){
            int l =i, r = i;
            while(r < s.length() && l >= 0&&s.charAt(l) == s.charAt(r) ){
                if(res.length() < (r-l+1) || res.isEmpty()){
                    res = s.substring(l,r) + s.charAt(r);
                }
                -- l;
                ++ r;
            }
            int L = i,R = i+1;
            while(R < s.length() && L >= 0&&s.charAt(L) == s.charAt(R) ){
                if(res.length() < (R-L+1)){
                    res = s.substring(L,R) + s.charAt(R);
                }
                -- L;
                ++ R;
            }
        }
        return res;
    }
//    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
    void runConvert(){
        System.out.println(convert("ABCDE",4));
    }
    String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int reminder = s.length()%(2*numRows-2);
        int numCols =(s.length()/(2*numRows-2)) *(numRows-1) + (reminder/numRows + reminder%numRows);
        char [][] set = new char[numRows][numCols];
        int column = 0;
        int index = 0;
        label :
        while(column < numCols){
            for(int i = 0; i < numRows; i++){
                set[i][column] = s.charAt(index);
                index++;
                if(index == s.length()){
                    break label;
                }
            }
            column++;
            for(int i = numRows-2 ;i>0;i--){
                if(index == s.length()){
                    break label;
                }
                set[i][column] = s.charAt(index);
                index++;
                column++;
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                if(set[i][j]== '\u0000'){
                    set[i][j]=' ';
                }
                res.append(set[i][j]);
            }
            res.append('\n');
        }
        return res.toString();
    }
//    Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
    void runReverse(int x){
        System.out.println(reverse(x));
    }
    int reverse(int x){
        long res = 0;
        while(x != 0){
            res = res * 10 + x % 10;
            x = x / 10;
            if(res < Integer.MIN_VALUE || res > Integer.MAX_VALUE){
                return 0;
            }
        }
        return (int)res;
    }
//    Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
//
//    The algorithm for myAtoi(string s) is as follows:
//
//    Whitespace: Ignore any leading whitespace (" ").
//    Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
//    Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
//    Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
    void runmyAtoi(){
        System.out.println(myAtoi("18446744073709551617"));
    }
    int myAtoi(String s){
        long res = 0;
        int sign = 1;
        int start = 0;
        if(s.length() == 0){
            return (int)res;
        }
        while(start<s.length() &&s.charAt(start) == ' '){
            start++;
        }
        if(start<s.length() && s.charAt(start) == '-'){
            sign = -1;
        }
        else if(start<s.length() &&s.charAt(start) != '+'){
            s = "+" + s;
        }
        for(int i = start+1; i < s.length(); i++){
            if((int)s.charAt(i)>=48 &&(int)s.charAt(i)<=57 ){
                res = res*10 + (int)s.charAt(i)-48;
                if(res <= Integer.MIN_VALUE || res >= Integer.MAX_VALUE ){
                    break;
                }
            }
            else{
                break;
            }
        }
        res *= sign;
        if(res <= Integer.MIN_VALUE || res >= Integer.MAX_VALUE ){
            if(sign == -1){
                res =  Integer.MIN_VALUE;
            }
            else{
                res = Integer.MAX_VALUE;
            }
        }
        return (int)res ;
    }
//    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//
//    Find two lines that together with the x-axis form a container, such that the container contains the most water.
//
//    Return the maximum amount of water a container can store.
//
//    Notice that you may not slant the container.
    void runmaxArea(){
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    int maxArea(int[] height){
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while(left<right){
            int edge = height[left];
            if(height[left]>height[right]){
                edge = height[right];
            }
            int area = edge*(right-left);
            if(area > max){
                max = area;
            }
            if(height[left]<=height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }
    void runinToRoman(){
        System.out.println(inToRoman(1994));
    }
    String inToRoman(int num){
        String res = "";
        int digit = num;
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");
        for(int i = 1000; i>=1 ;i/=10){
            digit = (num/i)*i;
            if(digit >= 5*i && digit < 10*i){
                if(digit == 9*i){
                    res+=map.get(digit);
                    num -= 9*i;
                }
                else{
                    res+=map.get(5*i);
                    digit -= 5*i;
                    num -= 5*i;
                    for(int j = digit;j>0;j-=i){
                        res+=map.get(i);
                        num -= i;
                    }
                }
            }
            else if(digit < 5*i && digit >= i){
                if(digit == 4*i){
                    res+=map.get(4*i);
                    num -= 4*i;
                }
                else{
                    for(int j = digit;j>0;j-=i){
                        res+=map.get(i);
                        num -= i;
                    }
                }
            }
        }
        return res;
    }
//    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//    Notice that the solution set must not contain duplicate triplets.
    void runthreeSum(){
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
    List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            if(nums[i]>0 || nums[nums.length-1]<0){
                break;
            }
            if(i==0||nums[i]!=nums[i-1]){
                int l = i+1,r = nums.length-1;
                while(l<r){
                    if(nums[l]+nums[r]+nums[i]==0){
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while(l<r && nums[l]==nums[l+1]){
                            l++;
                        }
                        while(l<r && nums[r]==nums[r-1]){
                            r--;
                        }
                        l++;
                        r--;
                    }
                    else if(nums[l]+nums[r]+nums[i]<0){
                        l++;
                    }
                    else{
                        r--;
                    }
                }
            }
        }
        return res;
    }
//    Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
//
//    Return the sum of the three integers.
//
//    You may assume that each input would have exactly one solution.
    void runthreeSumClosest(){
        System.out.println(thressSumClosest(new int[]{-4,2,2,3,3,3},0));
    }
    int thressSumClosest(int[] nums,int target) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0;i < nums.length-2;i++){
            if(i ==0 || nums[i]!=nums[i-1]){
                int l = i+1,r = nums.length-1;
                while(l<r){
                    int distance = target- (nums[l]+nums[r]+nums[i]) ;
                    if(Math.abs(distance)<Math.abs(target-res)){
                        res =nums[l]+nums[r]+nums[i];
                    }
                    if(distance >=0 ){
                        l++;
                        while(l<r && nums[l]==nums[l-1]){
                            l++;
                        }
                    }
                    else if(distance < 0){
                        r--;
                        while(l<r && nums[r]==nums[r+1]){
                            r--;
                        }
                    }

                }
            }
        }
        return res;
    }
//    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
//
//    A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
    void runletterCombinations(){
        System.out.println(letterCombinations("89"));
    }
    List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        List<String> subres ;
        String[] kb =  {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(digits.isEmpty()){
            return res;
        }
        if(digits.length()==1){
            String le= kb[Integer.parseInt(digits)];
            for(int i =0 ;i < le.length();i++){
                res.add(le.charAt(i)+"");
            }
        }
        else{
            subres = letterCombinations(digits.substring(1));
            String[] subString = subres.toArray(new String[subres.size()]);
            String digitsS = kb[Integer.parseInt(digits.charAt(0)+"")];
            if(subString.length>=digitsS.length()){
                for(int i = 0; i < digitsS.length();i++){
                    for(int j = 0; j < subString.length;j++){
                        String tmp = digitsS.charAt(i) +subString[j];
                        res.add(tmp);
                    }
                }
            }
            else{
                for(int i = 0; i < subString.length;i++){
                    for(int j = 0; j < digitsS.length();j++){
                        String tmp = digitsS.charAt(j) +subString[i];
                        res.add(tmp);
                    }
                }
            }
        }
        return res;
    }
    void runletterCombinationsWithbacktracking(){
        System.out.println(letterCombinationsWithbacktracking("23"));
    }
    void BT4letterCombinations(List<String> res, String Path,String Digits){
        HashMap<Integer,String> kb=new HashMap<>();
        kb.put(2,"abc");
        kb.put(3,"def");
        kb.put(4,"ghi");
        kb.put(5,"jkl");
        kb.put(6,"mno");
        kb.put(7,"pqrs");
        kb.put(8,"tuv");
        kb.put(9,"wxyz");
        if(Path.length()==Digits.length()){
            res.add(Path);
        }
        else{
            String letters = kb.get((int)Digits.charAt(Path.length())-48);
            for(int i = 0; i< letters.length();i++){
                Path += letters.charAt(i);
                BT4letterCombinations(res,Path,Digits);
                Path = Path.substring(0, Path.length() - 1);
            }
        }
    }
    List<String> letterCombinationsWithbacktracking(String digits) {
        List<String> result=new ArrayList<>();
        if(digits.length()==0) return result;
        String Path="";
        BT4letterCombinations(result,Path,digits);
        return result;
    }
//    Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
//
//            0 <= a, b, c, d < n
//    a, b, c, and d are distinct.
//    nums[a] + nums[b] + nums[c] + nums[d] == target
//    You may return the answer in any order.
    void runfourSum(){
        System.out.println(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000},-294967296));
    }
    List<List<Integer>> fourSum(int[] nums,int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length-3;i++){
            for(int j = i+1;j < nums.length-2;j++){
                int l = j+1;
                int r = nums.length-1;
                while(l<r ){
                    if ((long)nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target ||
                            (long)nums[i] + nums[nums.length-1] + nums[nums.length-2] + nums[nums.length-3] < target) {
                        break;
                    }
                    if(l<r && (nums[l]+nums[r]+nums[i]+nums[j])== target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        res.add(list);
                        while(l<r &&nums[l] == nums[l+1]){
                            l++;
                        }
                        while(l<r &&nums[r] == nums[r-1]){
                            r--;
                        }
                        r--;
                        l++;
                    }
                    else if(l<r && nums[l]+nums[r]+nums[i]+nums[j]<target){
                        l++;
                    }
                    else{
                        r--;
                    }

                }
                while(j<nums.length-2&&nums[j]==nums[j+1]){
                    j++;
                }
            }
            while(i<nums.length-3&&nums[i]==nums[i+1]){
                i++;
            }
        }
        return res;
    }
//    Remove Nth Node From End of List
//    Input: head = [1,2,3,4,5], n = 2
//    Output: [1,2,3,5]
    void runremoveNthFromEnd(){
        ListNode head = new ListNode(1);
        head.insert(head,5);
        head.insert(head,4);
        head.insert(head,3);
        head.insert(head,2);
        head = removeNthFromEnd(head, 5);
        head.print(head);
    }
    ListNode removeNthFromEnd(ListNode head, int n){
        ListNode r ;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l = dummy;
        ListNode res = dummy;
        for(int i = 0;i<n;i++){
            dummy = dummy.next;
        }
        r = dummy;
        while(r.next!=null){
            r = r.next;
            l = l.next;
        }
        l.next = l.next.next;
        return res.next;
    }
//    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses
//    Input: n = 3
//    Output: ["((()))","(()())","(())()","()(())","()()()"]
    void rungenerateParenthesis(){
        System.out.println(generateParenthesis(3) );
    }
    void BT4generateParenthesis(List<String> res, int n,String Path,int l,int r){
        if(Path.length()==n*2 ){
            if(r == l){
                res.add(Path);
            }
            return;
        }
        if(l < r){
            return;
        }
        if(l > r){
            BT4generateParenthesis(res,n,Path + ')',l,r+1);
        }
        if(l < n){
            BT4generateParenthesis(res,n,Path + '(',l+1,r);
        }
    }
    List<String> generateParenthesis(int n){
        List<String> res = new ArrayList<>();
        String Path = "";
        int l = 0,r= 0;
        BT4generateParenthesis(res,n,Path,l,r);
        return res;
    }
//    Given a linked list, swap every two adjacent nodes and return its head.
//    You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
//    Input: head = [1,2,3,4]
//
//    Output: [2,1,4,3]
    void runswapPairs(){
        ListNode head = new ListNode(1);
        head.insert(head,5);
        head.insert(head,4);
        head.insert(head,3);
        head.insert(head,2);
        ListNode res1 = swapPairs(head);
        res1.print(res1);
        System.out.println('\n');
        ListNode res2 = swapPairswithRecursion(head);
        res2.print(res2);
    }
    ListNode swapPairs(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode dummy1 = dummy;
        while(true){
            ListNode f = dummy;
            if(f==null || dummy.next==null || dummy.next.next==null){
                break;
            }
            ListNode l = dummy.next;
            ListNode r = l.next;
            ListNode temp = l;
            f.next = r;
            temp.next = r.next;
            r.next = temp;
            dummy = dummy.next.next;
        }
        return dummy1.next;
    }
    ListNode swapPairswithRecursion(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairswithRecursion(newHead.next);
        newHead.next = head;
        return newHead;
    }
//    Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
//
//    The integer division should truncate toward zero, which means losing its fractional part.
//    For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
//
//    Return the quotient after dividing dividend by divisor.
//
//    Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1].
//    For this problem,
//    if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
    void rundivide(){
        System.out.println(divide(7,-3));
    }
    int divide(int dividend, int divisor){
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int sign = ((dividend < 0) ^  (divisor < 0)) ? -1 : 1;
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if ((dvd >> i) >= dvs) {
                result += 1 << i;
                dvd -= dvs << i;
            }
        }
        return sign * result;
    }
//    A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
//
//    For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
//    Input: nums = [1,2,3]
//    Output: [1,3,2]
    void runnextPermutation() {
        System.out.println(Arrays.toString(nextPermutation(new int[]{2,3,1})));;
    }
    int [] nextPermutation(int[] nums) {
        int rear = nums.length - 2;
        int front =rear + 1;
        for(rear = nums.length-2; rear>=0; rear--,front--){
            if(nums[front]>nums[rear] ){
                break;
            }
        }
        if(front == 0){
            int h = nums.length-1;
            int r = 0;
            while(r < h){
                int temp = nums[r];
                nums[r] = nums[h];
                nums[h] = temp;
                r++;
                h--;
            }
        }
        else{
            Arrays.sort(nums,rear+1,nums.length);
            for(int i = front ; i < nums.length ; i++){
                if(nums[i]>nums[rear]){
                    int temp = nums[i];
                    nums[i] = nums[rear];
                    nums[rear] = temp;
                    break;
                }
            }
        }
        return nums;
    }
//    There is an integer array nums sorted in ascending order (with distinct values).
//
//    Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ...,
//    nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
//
//    Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
//    Input: nums = [4,5,6,7,0,1,2], target = 0
//    Output: 4
    void runsearch(){
        System.out.println(search(new int[]{4,5,6,7,0,1,2},0));
    }
    int BSforsearch(int[] nums,int target, int l,int r){
        int res ;
        int mid =l + (r-l)/2;
        if(nums[mid] == target ){
            return mid;
        }
        if (r <= l) {
            return -1;
        }
        if(nums[mid] >= nums[l]){
            if (nums[mid] > target && nums[l] <= target){
                res =BSforsearch(nums,target,l,mid -1);
            }
            else{
                res =BSforsearch(nums,target,mid + 1,r);
            }
        }
        else{
            if (nums[mid] < target && nums[r] >= target){
                res =BSforsearch(nums,target,mid+1,r);
            }
            else{
                res =BSforsearch(nums,target,l,mid-1);
            }
        }
        return res;
    }

    int search(int[] nums, int target){
        return BSforsearch(nums,target,0,nums.length-1);
    }
//    Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//
//    If target is not found in the array, return [-1, -1].
//
//    You must write an algorithm with O(log n) runtime complexity.
    void run34(){
//        System.out.println(Arrays.toString(searchRange(new int[]{1}, 19)));
//        System.out.println('\n');
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
    }
    int [] searchRange1(int[] nums, int target){
        int [] res = {-1,-1};
        int head = 0;
        int rear = nums.length-1;
        if(nums.length==0){
            return res;
        }
        while(head <= rear && !(nums[rear] == target && nums[head] == target)  ){
            if(nums[head] != target){
                head++;
            }
            if(nums[rear] != target){
                rear--;
            }
        }
        if(head <= rear){
            res[0] = head;
            res[1] = rear;
        }
        return res;
    }
    int [] searchRange(int[] nums, int target){
        int [] res = {-1,-1};
        int l = 0;
        int r = nums.length-1;
        while(nums.length > 0){
            if(l > r){
                break;
            }
            int mid = (r+l)/2;
            if(nums[mid] == target){
                int l1 = mid,r1=mid;
                while(l1 >= 0&&nums[l1] == target ){
                    l1--;
                }
                while(r1 <= nums.length-1 && nums[r1] == target ){
                    r1++;
                }
                res[0] = l1+1;
                res[1] = r1-1;
                break;
            }
            else if(nums[mid] < target){
                l = mid+1;
            }
            else{
                r = mid -1;
            }
        }
        return res;
    }
//    Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
//
//    Each row must contain the digits 1-9 without repetition.
//    Each column must contain the digits 1-9 without repetition.
//    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
    void run36(){
        char[][] board ={
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(isValidSudoku(board));
    }
    boolean isValidSudoku(char[][] board){
        boolean res = true;
        Set<Character> temp= new HashSet<>();
        Set<Character>[] rows = new Set[9];
        Set<Character>[] cols = new Set[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }
        outer :
        if(res){
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    for(int k = i*3; k < i*3+3; k++){
                        for(int f = j*3; f < j*3+3; f++){
                            if(!temp.contains(board[k][f]) &&!rows[k].contains(board[k][f]) && !cols[f].contains(board[k][f])){
                                if(board[k][f] != '.'){
                                    temp.add(board[k][f]);
                                    rows[k].add(board[k][f]);
                                    cols[f].add(board[k][f]);
                                }
                            }
                            else{
                                res = false;
                                break outer;
                            }
                        }
                    }
                    temp.clear();
                }
            }
        }
        return res;
    }
//    Input: n = 4
//
//    Output: "1211"
//
//    Explanation:
//
//    countAndSay(1) = "1"
//    countAndSay(2) = RLE of "1" = "11"
//    countAndSay(3) = RLE of "11" = "21"
//    countAndSay(4) = RLE of "21" = "1211"
    void run38(){
        System.out.println(countAndSay(4));
    }
    String buildstr (String s){
        String res = "";
        int counter = 1;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < s.length()){
            while(i+1<s.length() && s.charAt(i) == s.charAt(i+1)){
                counter++;
                i++;
            }
            sb.append(counter);
            sb.append(s.charAt(i));
            counter = 1;
            i++;
        }
        return sb.toString();
    }
    String countAndSay(int n){
        if(n == 1){
            return "1";
        }
        else{
            return buildstr(countAndSay(n-1));
        }
    }
//    Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target.
//    You may return the combinations in any order.
//
//    The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
//            frequency
//    of at least one of the chosen numbers is different.
//
//    The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
    void run39(){
        List<List<Integer>> res = combinationSum(new int[]{1,2},3);
        res.forEach(combination ->
                System.out.println(combination.toString())
        );
    }
    void BT4leetcode39(List<Integer> Path,List<List<Integer>> res, int target, int[] candidates, int CurSum, int start){
        if(CurSum == target){
            res.add(new ArrayList<>(Path));
        }
        else if(CurSum < target ){
            for(int i = start;i<candidates.length;i++){
                if(CurSum + candidates[i] > target){
                    break;
                }
                Path.add(candidates[i]);
                BT4leetcode39(Path,res,target,candidates,CurSum+candidates[i],i);
                Path.remove(Path.size()-1);
            }
        }
    }
    List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        BT4leetcode39(path,res,target,candidates,0,0);
        return res;
    }
//    Given a collection of candidate numbers (candidates) and a target number (target),
//    find all unique combinations in candidates where the candidate numbers sum to target.
//
//    Each number in candidates may only be used once in the combination.
    void run40(){
        List<List<Integer>> res = combinationSum2(new int[]{1,2},3);
        res.forEach(combination ->
                System.out.println(combination.toString())
        );
    }
    void BT4leetcode40(List<Integer> Path,List<List<Integer>> res, int target, int[] candidates, int CurSum, int start){
        if(CurSum == target){
            res.add(new ArrayList<>(Path));
        }
        else if(CurSum < target ){
            for(int i = start;i<candidates.length;i++){
                if(CurSum + candidates[i] > target){
                    break;
                }
                Path.add(candidates[i]);
                BT4leetcode40(Path,res,target,candidates,CurSum+candidates[i],i+1);
                Path.remove(Path.size()-1);
                while(i+1<candidates.length && candidates[i] == candidates[i+1]){
                    i++;
                }
            }
        }
    }
    List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        BT4leetcode40(path,res,target,candidates,0,0);
        return res;
    }
//    Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//
//    Note: You must not use any built-in BigInteger library or convert the inputs to integer directly
    void run43(){
        System.out.println(multiply("99999999999999999999","9999999999999999999999999"));
    }

    String addition(String a, String b){
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int p1 = a.length()-1;
        int p2 = b.length()-1;
        while(p2 >= 0 || p1 >= 0){
            int v1 = (p1>=0 ? a.charAt(p1) - '0':0);
            int v2 = (p2>=0 ? b.charAt(p2) - '0':0);
            int sum = v1+v2+carry;
            carry = sum/10;
            res.append(sum%10);
            p1--;
            p2--;
        }
        if(carry != 0){
            res.append(carry);
        }
        res.reverse();
        return res.toString();
    }
    String multiply(String num1, String num2){
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String longer = num1;
        String shorter =num2;
        int carry = 0;
        StringBuilder subres = new StringBuilder();
        String res = "";
        if(num1.length() < num2.length()){
            longer = num2;
            shorter = num1;
        }
        for(int o1 = shorter.length()-1; o1 >=0; o1--){
            if(shorter.charAt(o1) - '0' == 0){
                continue;
            }
            for(int o2 = longer.length()-1; o2 >= 0; o2--){
                int op2 = longer.charAt(o2) - '0';
                int op1 = shorter.charAt(o1) - '0';
                int temp = op1 * op2 + carry;
                carry = temp / 10;
                subres.append(temp % 10);
            }
            if(carry != 0){
                subres.append(carry);
                carry = 0;
            }
            subres.reverse();
            int count = shorter.length()-1 - o1;
            while(count > 0){
                subres.append(0);
                count --;
            }
            res = addition(res,subres.toString());
            subres = new StringBuilder();
        }
        return res;
    }
//    You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
//
//    Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
//    Input: nums = [2,3,1,1,4]
//    Output: 2
//    Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
    void run45(){
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }
    int jump(int[] nums){
        int des = nums.length-1;
        int [] steps = new int[des+1];
        steps[0] = 0;
        for(int i = 1;i<=des;i++){
            steps[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < des; i++){
            if(i >= steps[des]){
                break;
            }
            for(int j = 1; j <= nums[i]; j++){
                int newstep = steps[i] + 1;
                if(j+i <= des && steps[j+i] > newstep ){
                    steps[j+i] = newstep;
                }
            }
        }
        return steps[des];
    }
//    Input: nums = [1,2,3]
//    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    void run46(){
        List<List<Integer>> res = permute(new int[]{1,1,2});
        res.forEach(combination ->
                System.out.println(combination.toString())
        );
    }
    List<List<Integer>> permute(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length ==1){
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            res.add(list);
            return res;
        }
        outer:
        while(true){
            List<Integer> list = new ArrayList<>();
            for(int i =0 ; i < nums.length ; i++){
                list.add(nums[i]);
            }
            res.add(list);
            int l = nums.length-2;
            int r = nums.length-1;
            while(nums[l] > nums[r]){
                r--;
                l--;
                if(l == -1){
                    break outer;
                }
            }
            Arrays.sort(nums,r,nums.length);
            for(int i = r ; i < nums.length ; i++){
                if(nums[i]>nums[l]){
                    int temp = nums[i];
                    nums[i] = nums[l];
                    nums[l] = temp;
                    break;
                }
            }
        }
        return res;
    }
//    Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
//    Input: nums = [1,1,2]
//    Output:
//            [[1,1,2],
//            [1,2,1],
//            [2,1,1]]
    void run47(){
        List<List<Integer>> res = permuteUnique(new int[]{1,1,2});
        res.forEach(combination ->
                System.out.println(combination.toString())
        );
    }
    List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        int[] used = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            used[i] = 0;
        }
        BT4leetcode47(res,nums,path,used);
        return res;
    }
    void BT4leetcode47(List<List<Integer>> res,int[] nums,List<Integer> path , int[] used){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
        }
        else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] == 0){
                    if(i-1 >= 0 &&  (nums[i] == nums[i-1] && used[i-1] == 1)){
                        continue;
                    }
                    used[i] = 1;
                    path.add(nums[i]);
                    BT4leetcode47(res,nums,path,used);
                    path.remove(path.size()-1);
                    used[i] = 0;
                }
            }
        }
    }
//    You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
//
//    You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
    void run48(){
        int[][]matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    void rotate(int[][] matrix){
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i < n; i++){
            int r = 0;
            int h = n-1;
            while(r<h){
                int temp = matrix[i][r];
                matrix[i][r] = matrix[i][h];
                matrix[i][h] = temp;
                r++;
                h--;
            }
        }
    }
//    Given an array of strings strs, group the
//            anagrams
//    together. You can return the answer in any order.
//    Input: strs = ["eat","tea","tan","ate","nat","bat"]
//
//    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    void run49(){
        String[] str = {
                "eat", "tea", "tan", "ate", "nat", "bat", "bat", "bat", "bat", "bat"
        };
        List<List<String>> res = groupAnagrams(str);
        res.forEach(combination ->
                System.out.println(combination.toString())
        );
    }
    List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0;i<len;i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String sorted=new String(temp);
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
//    Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
//    Input: x = 2.00000, n = 10
//    Output: 1024.00000
    void run50(){
        System.out.println(myPow(2,-2));
    }
    double myPow(double x, int n) {
        // 处理特殊情况
        if (n == 0 || x == 1.0) return 1.0;
        if (x == 0.0) return 0.0;

        long N = n; // 使用 long 类型防止 n = Integer.MIN_VALUE 时取反溢出
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;
        double currentProduct = x;

        while (N > 0) {
            if (N % 2 == 1) {
                result *= currentProduct;
            }
            currentProduct *= currentProduct;
            N /= 2;
        }

        return result;
    }
//    Given an integer array nums, find the
//    subarray
//    with the largest sum, and return its sum.
    void run53(){
//        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSub_greedy(new int[]{-2,-1}));
    }
    int maxsub(int l, int r, int[] nums){
        if(l == r){
            return nums[l];
        }
        else{
            int middle = (l+r)/2;
            int maxleft = Math.max(maxsub(l,middle,nums),Integer.MIN_VALUE);
            int maxright = Math.max(maxsub(middle+1,r,nums),Integer.MIN_VALUE);
            int tempSum = 0,CrossL = Integer.MIN_VALUE, CrossR = Integer.MIN_VALUE;
            for(int i = middle+1 ; i <= r ; i++){
                tempSum += nums[i];
                if(tempSum > CrossR){
                    CrossR = tempSum;
                }
            }
            tempSum = 0;
            for(int i = middle ; i >= l ; i--){
                tempSum += nums[i];
                if(tempSum > CrossL){
                    CrossL = tempSum;
                }
            }
            return Math.max(Math.max(maxleft,maxright),CrossR+CrossL) ;
        }
    }
    int maxSubArray(int[] nums) {
        int res = 0;
        res = maxsub(0, nums.length-1, nums);
        return res;
    }
    int maxSub_greedy(int[] nums){
        int res = Integer.MIN_VALUE;
        int temp = 0;
        for(int i = 0 ; i < nums.length ; i++){
            temp += nums[i];
            if(temp > res){
                res = temp;
            }
            if(temp < 0){
                temp = 0;
            }
        }
        return res;
    }
    void run54(){
        int [][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        List<Integer> res = spiralOrder(matrix);
        res.forEach(combination ->
                System.out.println(combination.toString())
        );
    }
    List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return result;
            }

            int rows = matrix.length, columns = matrix[0].length;
            int left = 0, right = columns - 1, top = 0, bottom = rows - 1;

            while (left <= right && top <= bottom) {
                for (int column = left; column <= right; column++) {
                    result.add(matrix[top][column]);
                }
                for (int row = top + 1; row <= bottom; row++) {
                    result.add(matrix[row][right]);
                }
                if (left < right && top < bottom) {
                    for (int column = right - 1; column > left; column--) {
                        result.add(matrix[bottom][column]);
                    }
                    for (int row = bottom; row > top; row--) {
                        result.add(matrix[row][left]);
                    }
                }
                left++;
                right--;
                top++;
                bottom--;
            }

            return result;
        }
    void run55(){
        System.out.println(canJump(new int[]{0}));
    }
    boolean canJump(int[] nums) {
        boolean result = false;
        int end = nums.length - 1;
        int range = 0;
        for(int i=0;i<=end;i++){
            range = Math.max(range, i + nums[i]);
            if(range >= end){
                result = true;
                break;
            }
            if(nums[i] == 0 && range <= i){
                break;
            }
        }
        return result;
    }
    void run56(){
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {0, 2},
                {1, 4},
                {3, 5},
                {4,10},
                {15, 18}
        })));
    }
    int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int index = 0;
        int [] temp ;
        while(index < intervals.length){
            temp=intervals[index];
            int max = intervals[index][1];
            if(index+1 >= intervals.length||intervals[index+1][0] > intervals[index][1]){
                temp=intervals[index];
            }
            else{
                while(index+1 < intervals.length && temp[1] >= intervals[index+1][0]){
                    if(max < intervals[index+1][1] ){
                        max=intervals[index+1][1];
                    }
                    temp[1]=max;
                    index++;
                }
            }
            res.add(temp);
            index++;
        }
        return res.toArray(new int[res.size()][]);
    }
    void run57(){
        int[][] intervals = {
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
        };
//        int[][] intervals = {
//                {1, 2},
////                {5, 7},
//        };
        int [] newIntervals = {0,0};
        System.out.println(Arrays.deepToString(insert(intervals, newIntervals)));
    }

    int[][] insert(int[][] intervals, int[] newInterval){
        List<int[]> res = new ArrayList<>();
        int[][] resarray ;
        int index = 0;
        int isInserted = 0;
        while(index < intervals.length){
            if(intervals[index][1] < newInterval[0] || newInterval[1] < intervals[index][0]){
                res.add(intervals[index++]);
            }
            else{
                isInserted=1;
                int[] temp = new int[2];
                temp[0] = Math.min(intervals[index][0], newInterval[0]);
                while (index < intervals.length && newInterval[0] <= intervals[index][1] && newInterval[1] >= intervals[index][0]) {
                    index++;
                }
                temp[1] =  Math.max(intervals[index-1][1], newInterval[1]);
                res.add(temp);
            }
        }
        resarray = res.toArray(new int[res.size()][]);
        if(isInserted == 0){
            res.add(newInterval);
            resarray = res.toArray(new int[res.size()][]);
            Arrays.sort(resarray, Comparator.comparingInt(a -> a[0]));
        }
        return resarray;
    }
    void run61(){
        ListNode head = new ListNode(1);
        head.insert(head,5);
        head.insert(head,4);
        head.insert(head,3);
        head.insert(head,2);
        ListNode dhead = rotateRight(head,101);
        dhead.print(dhead);
    }
    ListNode rotateRight(ListNode head, int k) {
        ListNode newHead = head;
        ListNode r = head;
        ListNode l = head;
        int len = 0;
        if(head == null){
            return head;
        }
        while(head != null ){
            len++;
            head = head.next;
        }
        int dist = ((k < len||k == 0)? k : k % len);
        if(dist == 0 || len == 0){
            return newHead;
        }
        for(int i=0; i<dist; i++){
            r = r.next;
        }
        while(r.next!=null){
            r = r.next;
            l = l.next;
        }
        ListNode temp = l.next;
        l.next = null;
        r.next = newHead;
        return temp;
    }
    void run62(){
        System.out.println(uniquePaths(3,7));
    }
    int uniquePaths(int m, int n){
        int[][] matrix = new int[m][n];
        for(int i=0; i<m; i++){
            matrix[i][0] = 1;
        }
        for(int i=0; i<n; i++){
            matrix[0][i] = 1;
        }
        for(int i=1; i<m; i++){
            for(int j =1; j<n; j++){
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
            }
        }
        return matrix[m-1][n-1];
    }
    void run63(){
        System.out.println(uniquePathsWithObstacles(new int[][] {
                {0, 1, 0},
                {0, 1, 0},
                {0, 0, 0}
        }));
    }
    int uniquePathsWithObstacles(int[][] obstacleGrid){
        int[][]matix = new int[obstacleGrid.length][obstacleGrid[0].length];
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int i = 0, j = 0;
        if(obstacleGrid[i][j] == 1){
            return 0;
        }
        for(i=1; i<m; i++){
            for(j=1; j<n; j++){
                if(obstacleGrid[i][j] == 1){
                    matix[i][j] = 0;
                }
                else{
                    matix[i][j] = 1;
                }
            }
        }
        i = 0;
        j =0;
        while(i < m){
            if(obstacleGrid[i][0] == 1){
                while(i<m){
                    matix[i++][0] = 0;
                }
            }
            else{
                matix[i][0]=1;
            }
            i++;
        }
        while(j < n){
            if(obstacleGrid[0][j] == 1){
                while(j < n){
                    matix[0][j++] = 0;
                }
            }
            else{
                matix[0][j]=1;
            }
            j++;
        }
        for(i=1; i<m; i++){
            for(j=1; j<n; j++){
                if(matix[i][j] == 0){
                    continue;
                }
                matix[i][j] = matix[i-1][j] + matix[i][j-1];
            }
        }
        return matix[m-1][n-1];
    }
    void run64(){
        int[][] grid = new int[][] {
                {1,2,3},
                {4,5,6},
//                {4,2,1}
        };
        System.out.println(minPathSum(grid));
    }
    int minPathSum(int[][] grid){
        int[][] map = grid.clone();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=1; i<m ; i++){
            map[i][0] += map[i-1][0];
        }
        for(int i=1; i<n; i++){
            map[0][i] += map[0][i-1];
        }
        for(int i = 1; i<m ; i++){
            for(int j =1; j<n; j++){
                map[i][j] += Math.min(map[i-1][j], map[i][j-1]);
            }
        }
        return map[m -1][n-1];
    }
    void run71(){
        System.out.println(simplifyPath("/../"));
    }
    String simplifyPath(String path){
        StringBuilder res = new StringBuilder();
        Stack<String> q2 = new Stack();
        for(int i=0; i<path.length(); i++){
            if(path.charAt(i) != '/'){
                int index = i;
                StringBuilder temp = new StringBuilder();
                while(index <path.length() && path.charAt(index) != '/'){
                    temp.append(path.charAt(index++));
                }
                String ss = temp.toString();
                if(ss.equals("..")){
                    if(!q2.isEmpty()){
                        q2.pop();
                    }
                }
                else if(!ss.equals(".")){
                    q2.add(ss);
                }
                i = index;
            }
        }
        Stack<String> reversedStack = new Stack<>();
        while (!q2.isEmpty()) {
            reversedStack.push(q2.pop());
        }
        while (!reversedStack.isEmpty()) {
            res.append('/').append(reversedStack.pop());
        }

        if(res.length() == 0){
            return "/";
        }
        return res.toString();
    }
    void run72(){
        System.out.println(minDistance("zoologicoarchaeologist","zoogeologist"));
    }
    int minDistance(String word1, String word2){
        int m = word1.length();
        int n = word2.length();
        int [][] matrix = new int[m+1][n+1];
        if(m==0 || n==0){
            return Math.max(m, n);
        }
        for(int i=0; i<=m; i++){
            matrix[i][0] = i;
        }
        for(int i=0; i<=n; i++){
            matrix[0][i] = i;
        }
        for(int i = 1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    matrix[i][j] = matrix[i-1][j-1];
                }
                else{
                    int mini = Math.min(matrix[i-1][j], matrix[i][j-1]);
                    mini = Math.min(mini, matrix[i-1][j-1]);
                    matrix[i][j] = mini+1;
                }
            }
        }
        return matrix[m][n];
    }
    void run73(){
        int[][] matrix = new int[][] {
                {1,2,3},
                {4,0,6},
                {7,8,9},
        };
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    void setZeroes(int[][] matrix){
        Stack<Integer> m = new Stack<>();
        Stack<Integer> n = new Stack<>();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    m.push(i);
                    n.push(j);
                }
            }
        }
        while(!m.empty()){
            int a = m.pop();
            for(int i = 0; i<matrix[0].length; i++){
                matrix[a][i] = 0;
            }
        }
        while(!n.empty()){
            int a = n.pop();
            for(int i = 0; i<matrix.length; i++){
                matrix[i][a] = 0;
            }
        }
    }
    void run74(){
        int[][] matrix = new int[][] {
                {1},
//                {10,11,16,20},
//                {23,30,34,60}
        };
        System.out.println(searchMatrix(matrix, 1));
    }
    boolean searchMatrix(int[][] matrix, int target){
        int index = 0;
        while(index <matrix.length && matrix[index][0] <=target){
            index++;
        }
        if(index == 0){
            return false;
        }
        else{
            return binarySearch(matrix[index-1],target,0,matrix[0].length-1);
        }
    }
    boolean binarySearch(int[]row, int target, int start, int end){
        boolean flag = false;
        int mid = (end+start)/2;
        if(row[mid] == target){
            flag = true;
        }
        else{
            if(start < end && row[mid] < target){
                flag = binarySearch(row, target, mid+1, end);
            }
            if(start < end && row[mid] > target){
                flag = binarySearch(row, target, start, mid-1);
            }
        }
        return flag;
    }
    void run75(){
        int[] nums = {1,2,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    void sortColors(int[] nums){
        int p0 = 0,p2 = nums.length-1;
        for(int i = 0 ; i <= p2; i++){
            if(nums[i] == 0){
                int temp = nums[p0];
                nums[p0] = nums[i];
                nums[i] = temp;
                p0++;
            }
            if(nums[i] == 2){
                int temp = nums[p2];
                nums[p2] = nums[i];
                nums[i] = temp;
                p2--;
                i-- ;
            }
        }
    }
    void run77(){
        List<List<Integer>> res = combine(5,3);
        res.forEach(combination ->
                System.out.println(combination.toString())
        );
    }
    List<List<Integer>> combine(int n, int k){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = i+1;
        }
        BT4leetcode77_78(res, path,k,nums,0);
        return res;
    }
    void BT4leetcode77_78(List<List<Integer>> res, List<Integer> path, int size, int[] nums,int start){
        if(path.size() == size){
            res.add(new ArrayList<>(path));
        }
        else{
            for(int i = start; i< nums.length; i++){
                path.add(nums[i]);
                BT4leetcode77_78(res, path,size,nums,i+1);
                path.remove(path.size()-1);
            }
        }
    }
    void run78(){
        List<List<Integer>> res = subsets(new int[]{1,2,3});
        res.forEach(combination ->
                System.out.println(combination.toString())
        );
    }
    List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        for(int i = 0; i<=nums.length; i++){
            BT4leetcode77_78(res,path,i,nums,0);
        }
        return res;
    }
    void run79(){
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board,"BC"));
    }
    boolean exist(char[][] board, String word){
        boolean flag = false;
        outbreak :
        for(int i =0; i< board.length; i++){
            for(int j = 0; j< board[0].length; j++){
                flag = DFS4leetcode79(board,word,1,i,j, new StringBuilder());
                if(flag){
                    break outbreak;
                }
            }
        }
        return flag;
    }
    boolean DFS4leetcode79(char[][] board, String word, int index,int x, int y, StringBuilder sb){
        int[] xs = {-1,0,1,0};
        int [] ys = {0,-1,0,1};
        if(word.charAt(index-1) != board[x][y]){
            return false;
        }
        if(word.length() == index){
            return true;
        }
        char temp = board[x][y];
        board[x][y] = '.';
        sb.append(temp);
        for(int i =0 ; i< 4; i++){
            int nx = x + xs[i];
            int ny = y + ys[i];
            if(nx<0 || nx>=board.length || ny<0 || ny>=board[0].length|| board[nx][ny] == '.'){
                continue;
            }
            else{
                if(DFS4leetcode79(board,word,index+1,nx,ny,sb)){
                    return true;
                }
            }
        }
        sb.deleteCharAt(sb.length()-1);
        board[x][y] = temp;
        return false;
    }
    void run80(){
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
    int removeDuplicates(int[] nums) {
        int l = 0, r = 1, len = nums.length,index = 1;
        while(r < len){
            if(r<len && nums[l] != nums[r]){
                r++;
                l++;
            }
            while(index<2 && r<len && nums[l] == nums[r] ){
                r++;
                l++;
                index++;
            }
            if(index>=2 ){
                while(r< len && nums[l] == nums[r]){
                    for(int i = r; i<len-1;i++){
                        nums[i] = nums[i+1];
                    }
                    len--;
                }
            }
            index = 1;
        }
        return len;
    }
    int removeDuplicates1(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int writeIndex = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[writeIndex - 2]) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }
        return writeIndex;
    }
    void run81(){
        System.out.println(search81(new int[]{1,0,1,1,1},0));
    }
    boolean search81(int[] nums, int target){
        boolean flag = BS4leetcode81(nums,target,0,nums.length-1);
        return flag;
    }
    boolean BS4leetcode81(int[] nums, int target,int l,int r){
        int mid = (r+l)/2;
        if(l>r){
            return false;
        }
        if(nums[mid]==target){
            return true;
        }
        else{
            if(nums[mid]>nums[r]){
                if(target<=nums[mid] && target>=nums[l]){
                    return BS4leetcode81(nums,target,l,mid-1);
                }
                else{
                    return BS4leetcode81(nums,target,mid+1,r);
                }
            }
            else if(nums[mid]<nums[r]){
                if(target>=nums[mid] && target<=nums[r]){
                    return BS4leetcode81(nums,target,mid+1,r);
                }
                else{
                    return BS4leetcode81(nums,target,l,mid-1);
                }
            }
            else{
                boolean flag = BS4leetcode81(nums,target,l,mid-1);
                if(!flag){
                    return BS4leetcode81(nums,target,mid+1,r);
                }
                return flag;
            }
        }
    }
}


