package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeIntersectionTest {

	private Range exampleRange;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("The test of the function 'intersection' of the class Range has been started.");
	}

	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(-2, 1);
	}

	@Test
	public void rangeLowerBoundIntersectionShouldBeTrue() {		
		//                (####*****)
		//      (*********####)
		//<-----2----1----0----1----2------>
		assertTrue("The lower bound of new range intersects with example range, hence value should be true",
				exampleRange.intersects(0, 2));
	}

	@Test
	public void rangeUpperBoundIntersectionShouldBeTrue() {
		//  (*****#########)
		//       (#########*****)
		//<-3----2----1----0----1----2------>
		assertTrue("The upper bound of new range intersects with example range, hence value should be true",
				exampleRange.intersects(-3, 0));
	}

	@Test
	public void rangeIntersectionShouldBeFalse() {
		//  							  (*****)
		//       (**************)
		//<-3----2----1----0----1----2----3----4>
		assertFalse("The ranges do not intersect, hence value should be false", exampleRange.intersects(3, 4));
	}

	@Test
	public void rangeIntersectionShouldBeTrue() {
		assertTrue("The new range completely intersects with example range, hence value should be true",
				exampleRange.intersects(-1, 0));
	}

	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
