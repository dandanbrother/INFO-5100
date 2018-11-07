package test.com.info; 

import com.info.MyIndexOutOfBoundException;
import com.info.Tool;
import com.info.Tool.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/** 
* MyIndexOutOfBoundException Tester. 
* 
* @author <Authors name> 
* @since <pre>Nov 7, 2018</pre> 
* @version 1.0 
*/ 
public class MyIndexOutOfBoundExceptionTest {

/** 
* 
* Method: merge(List<Interval> intervals) 
* 
*/ 
@Test
public void testMerge() throws Exception { 
//TODO: Test goes here...
    List<MyIndexOutOfBoundException.Interval> l = null;
    assertEquals(0, MyIndexOutOfBoundException.merge(l).size());
    l = new ArrayList<>();
    assertEquals(0, MyIndexOutOfBoundException.merge(l).size());
    l.add(new MyIndexOutOfBoundException.Interval(1, 2));
    assertEquals(1, MyIndexOutOfBoundException.merge(l).size());
    l.add(new MyIndexOutOfBoundException.Interval(2, 3));
    assertEquals(1, MyIndexOutOfBoundException.merge(l).size());
    l.add(new MyIndexOutOfBoundException.Interval(2, 4));
    assertEquals(1, MyIndexOutOfBoundException.merge(l).size());
    l.add(new MyIndexOutOfBoundException.Interval(5, 6));
    assertEquals(2, MyIndexOutOfBoundException.merge(l).size());
    l.add(new MyIndexOutOfBoundException.Interval(4, 5));
    assertEquals(1, MyIndexOutOfBoundException.merge(l).size());
} 

/** 
* 
* Method: findMedianSortedArrays(int[] nums1, int[] nums2) 
* 
*/ 
@Test
public void testFindMedianSortedArrays() throws Exception { 
//TODO: Test goes here...
    int[] nums1 = new int[] {1, 2, 3};
    int[] nums2 = new int[0];
    assertEquals(2, MyIndexOutOfBoundException.findMedianSortedArrays(nums1, nums2), 0.01);
    nums2 = new int[] {2, 4, 6, 8};
    assertEquals(3, MyIndexOutOfBoundException.findMedianSortedArrays(nums1, nums2), 0.01);
    nums1 = new int[] {1, 2, 3, 4};
    assertEquals(3.5, MyIndexOutOfBoundException.findMedianSortedArrays(nums1, nums2), 0.01);
}

private Tool t = new Tool(0, '*');
private Scissors s = t.new Scissors(5);
private Paper p = t.new Paper(7);
private Rock r = t.new Rock(15);

@Test
public void setStrength() {
	assertEquals(5, s.getStrength());
	s.setStrength(4);
	assertEquals(4, s.getStrength());
}

@Test
public void fight() {
	assertEquals(true, s.fight(p));
	assertEquals(false, p.fight(s));
	assertEquals(false, p.fight(r));
	assertEquals(true, r.fight(p));
	assertEquals(true, r.fight(s));
	assertEquals(false, s.fight(r));
}

} 
