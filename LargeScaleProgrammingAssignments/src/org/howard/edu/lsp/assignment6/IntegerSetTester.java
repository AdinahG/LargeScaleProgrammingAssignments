package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.howard.edu.lsp.assignment5.IntegerSetException;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class IntegerSetTester {
	IntegerSet set1;
	IntegerSet set2;

	/**
	 * creating both the sets before any tests this will run before each test
	 */
	@Before
	public void setUpIntegerListsFirst() {
		set1 = new IntegerSet();
		set2 = new IntegerSet();
	}

	/**
	 * method tests if clear method works fine
	 */
	@Test
	public void testClearMethod() {
		// add 1 element
		set1.add(0);

		set1.clear();// clear set, all elements removed
		assertTrue(set1.length() == 0);
	}

	/**
	 * method checks length method
	 */
	@Test
	public void testLengthMethod() {

		int len = set1.length();
		assertTrue(len == 0, "Set1 is empty");

		// add elements, each time i increases by 20
		for (int i = 200; i < 250; i += 20) {
			set1.add(i);
		}
		// total 3 elements should be there
		assertTrue(set1.length() == len + 3);// 8elements
	}

	/**
	 * method checks if two sets are equal
	 */
	@Test
	public void testEqualsMethod() {

		assertTrue(set1.equals(set2));

		// both sets have length 0
		set1.add(10);
		set1.add(1000);

		set2.add(10);
		set2.add(1000);// now both have same elements
		// fails, since with integer objects == compares reference ids not actual data
		assertTrue(set1.equals(set2));
	}

	/**
	 * method checks if set contains particular element
	 */
	@Test
	public void testContains() {
		assertFalse(set1.contains(100));

		set1.add(100);
		assertTrue(set1.contains(100));
	}

	/**
	 * method test working of largest element finding method
	 * 
	 * @throws IntegerSetException
	 */
	@Test
	public void testLargestMethod() throws IntegerSetException {
		// adding elements
		for (int i = 10; i <= 100; i += 10) {
			set1.add(i);
		}
		assertTrue(set1.largest() == 100);

		set1.remove(9);// remove 100 at 9th index
		assertTrue(set1.largest() == 90);
	}

	/**
	 * method test working of largest element finding method
	 * 
	 * @throws IntegerSetException
	 */
	@Test
	public void testSmallestMethod() throws IntegerSetException {
		// adding elements
		for (int i = 10; i <= 100; i += 10) {
			set1.add(i);
		}
		assertTrue(set1.smallest() == 10);

		set1.remove(0);// remove 10
		assertTrue(set1.smallest() == 20);
	}

	/**
	 * methods tests the add method
	 */
	@Test
	public void testAddMethod() {
		set1.clear();

		// right now set is empty
		for (int i = 0; i < 5; i++) {
			set1.add(i);
		}

		// adding duplicates
		for (int i = 0; i < 5; i++) {
			set1.add(i);
		}
		assertEquals(set1.length(), 5, "IntegerSet should have only 5 elements");

	}

	/**
	 * method tests remove method working
	 * 
	 * @throws IntegerSetException
	 */
	@Test
	public void testRemoveMethod() throws IntegerSetException {
		// right now set is empty
		for (int i = 0; i < 5; i++) {
			set1.add(i);
		}

		set1.remove(0);// index 0 element removed

		// now 4 elements there 0 removed
		assertFalse(set1.contains(0));
	}

	/**
	 * method test union method working
	 */
	@Test
	public void testUnionMethod() {
		// add 5 elements in set1
		for (int i = 0; i < 5; i++) {
			set1.add(i);
		}

		// add 5 elements in set 2 also
		for (int i = 4; i < 8; i++) {
			set2.add(i);
		}

		// possible result
		IntegerSet set = new IntegerSet();
		for (int i = 0; i < 8; i++)
			set.add(i);

		set1.union(set2);
		// check if both are same then works fine
		assertTrue(set.equals(set1));

	}

	/**
	 * method test intersect method working
	 */
	@Test
	public void testIntersectMethod() {
		// add 5 elements in set1
		for (int i = 0; i < 5; i++) {
			set1.add(i);
		}

		// add 5 elements in set 2 also
		for (int i = 4; i < 8; i++) {
			set2.add(i);
		}

		// possible result
		IntegerSet set = new IntegerSet();
		set.add(4);

		set1.intersect(set2);// only 1 element should be there
		// check if both are same then works fine
		assertTrue(set.equals(set1));

	}

	/**
	 * method test intersect method working
	 */
	@Test
	public void testDiffMethod() {
		// add 5 elements in set1
		for (int i = 0; i < 5; i++) {
			set1.add(i);
		}

		// add 5 elements in set 2 also
		for (int i = 4; i < 8; i++) {
			set2.add(i);
		}

		// possible result
		IntegerSet set = new IntegerSet();
		for (int i = 0; i < 4; i++) {
			set.add(i);
		}

		set1.intersect(set2);// only 1 element should be there
		// check if both are same then works fine
		assertTrue(set.equals(set1));

	}

	/**
	 * method tests if set2 is empty or not
	 * 
	 * @param set
	 */
	@Test
	public void testEmpty() {
		// add 1 element
		set2.add(0);

		// method checks is set does not contains elements
		assertFalse(set2.isEmpty());

		set2.clear();
		// method checks if set is empty
		assertTrue(set2.isEmpty());
	}

	@Test
	public void testString() {
		String result = "[]";
		assertTrue(result.equals(set1.toString()));
		
		for (int i = 0; i < 4; i++) {
			set1.add(i);
		}
		result = "[0, 1, 2, 3]";
		assertTrue(result.equals(set1.toString()));
	}
}