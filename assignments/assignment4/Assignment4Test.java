package test.INFO5100; 

import INFO5100.Assignment4;
import org.junit.Assert;
import org.junit.Test;

/** 
* Assignment4 Tester. 
* 
* @author <Authors name> 
* @since <pre>Oct 12, 2018</pre> 
* @version 1.0 
*/ 
public class Assignment4Test {

/** 
* 
* Method: firstUniqChar(String s) 
* 
*/ 
@Test
public void testFirstUniqChar() throws Exception {
    Assignment4 assignment4 = new Assignment4();
//TODO: Test goes here...
    int res = assignment4.firstUniqChar("leetcode");
    Assert.assertEquals(0, res);
    int res2 = assignment4.firstUniqChar("loveleetcode");
    Assert.assertNotEquals(2, res);

} 

/** 
* 
* Method: addDigits(int n) 
* 
*/ 
@Test
public void testAddDigits() throws Exception { 
//TODO: Test goes here...
    Assignment4 assignment4 = new Assignment4();
    int res = assignment4.addDigits(38);
    assert res == 2;
} 

/** 
* 
* Method: moveZeroes(int[] nums) 
* 
*/ 
@Test
public void testMoveZeroes() throws Exception { 
//TODO: Test goes here...
    Assignment4 assignment4 = new Assignment4();
    int[] num = {1,0,3,0,12};
    assignment4.moveZeroes(num);
    int[] res = {1,3,12,0,0};
    Assert.assertArrayEquals(res, num);
} 

/** 
* 
* Method: longestPalindrome(String s) 
* 
*/ 
@Test
public void testLongestPalindrome() throws Exception { 
//TODO: Test goes here...
    Assignment4 assignment4 = new Assignment4();
    String res = assignment4.longestPalindrome("babad");
//    assert res.equals("aba");
    Assert.assertEquals("bab", res);
}

/** 
* 
* Method: rotate(int[][] matrix) 
* 
*/ 
@Test
public void testRotate() throws Exception { 
//TODO: Test goes here...
    Assignment4 assignment4 = new Assignment4();
    int[][] num = {{1,2,3}, {4,5,6},{7,8,9}};
    int[][] res = {{7,4,1}, {8,5,2},{9,6,3}};
    num = assignment4.rotate(num);
    Assert.assertArrayEquals(res, num);
}


} 
