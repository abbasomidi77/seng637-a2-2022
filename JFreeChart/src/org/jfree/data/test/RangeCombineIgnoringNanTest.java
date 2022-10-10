package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

public class RangeCombineIgnoringNanTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("The test of the function 'combineIgnoringNan' of the class Range has been started.");
	}
	// (-1,0)  (1,2) => (-1,2)

	@Test
	public void shouldIgnoreLowerBoundNaNInRange1() {
		assertEquals("The new range should ignore Nan in lower bound of 1st range and use that of the 2nd range",
				new Range(0, 4), Range.combineIgnoringNaN(new Range(Double.NaN, -1), new Range(0, 4)));
	}

	@Test
	public void shouldIgnoreUpperBoundNaNInRange1() {
		assertEquals("The new range should ignore Nan in upper bound of 1st range and use that of the 2nd range",
				new Range(-1, 4), Range.combineIgnoringNaN(new Range(-1, Double.NaN), new Range(0, 4)));
	}

	@Test
	public void shouldIgnoreLowerBoundNaNInRange2() {
		assertEquals("The new range should ignore Nan in lower bound of 2nd range and use that of the 1st range",
				new Range(-1, 5), Range.combineIgnoringNaN(new Range(-1, 4), new Range(Double.NaN, 5)));
	}

	@Test
	public void shouldIgnoreUpperBoundNaNInRange2() {
		assertEquals("The new range should ignore Nan in upper bound of 2nd range and use that of the 1st range",
				new Range(-2, 4), Range.combineIgnoringNaN(new Range(-1, 4), new Range(-2, Double.NaN)));
	}

	@Test
	public void shouldIgnoreNaNInRange2() {
		assertEquals("The new range should ignore 2nd range completely", new Range(-1, 4),
				Range.combineIgnoringNaN(new Range(-1, 4), new Range(Double.NaN, Double.NaN)));
	}

	@Test
	public void shouldIgnoreNaNInRange1() {
		assertEquals("The new range should ignore 1st range completely", new Range(-1, 4),
				Range.combineIgnoringNaN(new Range(Double.NaN, Double.NaN), new Range(-1, 4)));
	}
	
	@Test
	public void shouldReturnsNullAsResult() {
		assertEquals("The new range has no values, because all bounds are NaN!", null,
				Range.combineIgnoringNaN(new Range(Double.NaN, Double.NaN), new Range(Double.NaN, Double.NaN) ));
	}

	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
