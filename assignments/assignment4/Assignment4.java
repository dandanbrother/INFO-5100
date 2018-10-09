package INFO5100;

public class Assignment4 {

    /**
     * The deadline of assignment4 is 10/12/2018 23:59 PST.
     * Please feel free to contact Zane and Amanda for any questions.
     */

    /*
     * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
     * s = "leetcode" return 0.
     * s = "loveleetcode" return 2.
     */
    public int firstUniqChar(String s) {
        //TODO
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }

    /*
     *Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
     * Input: 38 Output: 2
     * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     */
    public int addDigits(int n) {                        // 0 - 9: 0, 1,2,3,4,5,6,7,8,9
                                                         // 10-18:    1,2,3,4,5,6,7,8,9
                                                         // except 0, every 9 numbers, the results periodically occur
        //TODO
        return n == 0? 0 : (n % 9 == 0? 9 : n % 9);

    }

    /*
     *  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     *  Input: [0,1,0,3,12] Output: [1,3,12,0,0]
     */
    public void moveZeroes(int[] nums) {
        //TODO
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[index++] = nums[i];
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /*
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     * Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
     */
    public String longestPalindrome(String s) {
        //TODO
        int n=s.length();
        boolean[][] pal=new boolean[n][n];
        int maxLen=0;
        String res = "";
        for (int i=0;i<n;i++){  // start with i
            int j=i;            // end with j
            while (j>=0){
                if (s.charAt(j)==s.charAt(i) && (i-j<2||pal[j+1][i-1])){
                    pal[j][i]=true;
                    if (i - j+1 > maxLen) {
                        maxLen = i - j +1;
                        res = s.substring(j, i+1);
                    }
                }
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Assignment4 assignment4 = new Assignment4();
        int[][] a = {{1,2,3},{5,6,7}, {9, 10, 11}};
        assignment4.rotate(a);
    }
    /*
     * You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
     * Given input matrix = [ [1,2,3],
  			      [4,5,6],
  			      [7,8,9] ],
     * rotate the input matrix in-place such that it becomes: [  [7,4,1],
  								 [8,5,2],
  								  [9,6,3] ],
     */
    public int[][] rotate(int[][] matrix) {
        //TODO
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
        return matrix;
    }

}