package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class SelfRangeTest {
    private Range exampleRange1;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { exampleRange1 = new Range(-1, 1);
    
    }

    
    @Test(expected = IllegalArgumentException.class)
    public void testRangeInvalid() {
        Range range1 = new Range(35, 32);
    }
    
    /**
     * Test cases for combine method. There are 13 test cases for this method
     * We tested this method by using Null values for a Range,
     * and then determining the output.
     * We also tested using valid and invalid test values, to ensure that we covered
     * the method thoroughly using the branches. Therefore, this resulted in 13 test cases.
     */
    
    @Test
    public void testCombineRange2Null() {
        Range range1 = new Range(10, 15);
        Range range2 = null;
        Range testResult = Range.combine(range1, range2);
        assertTrue(testResult == range1);
    }
    
    @Test
    public void testCombineRange1Null() {
        Range range1 = null;
        Range range2 = new Range(15, 20);
        Range testResult = Range.combine(range1, range2);
        assertTrue(testResult == range2);
    }
    
    @Test
    public void testCombineRangeNull() {
        Range range1 = null;
        Range range2 = null;
        Range testResult = Range.combine(range1, range2);
        assertNull(testResult);
    }
    
    @Test
    public void testCombineRange() {
        Range range1 = new Range(10, 15);
        Range range2 = new Range(15, 20);
        Range testResult = Range.combine(range1, range2);
        assertTrue((testResult.getLowerBound() == 10) && (testResult.getUpperBound() == 20));
    }
    
    @Test
    public void testCombineIgnoringNaNRange2Null() {
        Range range1 = new Range(10, 15);
        Range range2 = null;
        Range testResult = Range.combineIgnoringNaN(range1, range2);
        assertTrue(testResult == range1);
    }
    
    @Test
    public void testCombineIgnoringNaNRange1Null() {
        Range range1 = null;
        Range range2 = new Range(15, 20);
        Range testResult = Range.combineIgnoringNaN(range1, range2);
        assertTrue(testResult == range2);
    }
    
    @Test
    public void testCombineIgnoringNaNRange1NaN() {
        Range range1 = new Range(Double.NaN, Double.NaN);
        Range range2 = new Range(15, 20);
        Range testResult = Range.combineIgnoringNaN(range1, range2);
        assertTrue(testResult.getLowerBound() == 15);
    }
    
    @Test
    public void testCombineIgnoringNaNRange2NaN() {
        Range range1 = new Range(10, 15);
        Range range2 = new Range(Double.NaN, Double.NaN);
        Range testResult = Range.combineIgnoringNaN(range1, range2);
        assertTrue(testResult.getLowerBound() == 10);
    }
    
    @Test
    public void testCombineIgnoringRange1NullandRange2NaN() {
        Range range1 = null;
        Range range2 = new Range(Double.NaN, Double.NaN);
        Range testResult = Range.combineIgnoringNaN(range1, range2);
        assertNull(testResult);
    }
    
    @Test
    public void testCombineIgnoringRange2NullandRange1NaN() {
        Range range1 = new Range(Double.NaN, Double.NaN);
        Range range2 = null;
        Range testResult = Range.combineIgnoringNaN(range1, range2);
        assertNull(testResult);
    }
    
    @Test
    public void testCombineIgnoringRange2NaNandRange1NaN() {
        Range range1 = new Range(Double.NaN, Double.NaN);
        Range range2 = new Range(Double.NaN, Double.NaN);
        Range testResult = Range.combineIgnoringNaN(range1, range2);
        assertNull(testResult);
    }
    
    @Test
    public void testCombineIgnoringRange2NaNandRange1NaNLower() {
        Range range1 = new Range(Double.NaN, 10);
        Range range2 = new Range(Double.NaN, 15);
        Range testResult = Range.combineIgnoringNaN(range1, range2);
        assertTrue(testResult.getUpperBound() == 15);
    }
    
    @Test
    public void testCombineIgnoringRangeNaN() {
        Range range1 = new Range(10, 15);
        Range range2 = new Range(15, 20);
        Range testResult = Range.combineIgnoringNaN(range1, range2);
        assertTrue((testResult.getLowerBound() == 10) && (testResult.getUpperBound() == 20));
    }
    
    
    /**
     * Test cases for expand method. There are 3 test cases for this method. We tested
     * this method by using Null input values for Range, and then testing the upper
     * and lower bounds in order to ensure we cover the different branches and
     * boundaries.
     */
    
    @Test
    public void testExpandLower() {
        Range range1 = new Range(5, 10);
        Range testResult = Range.expand(range1, 0, 0);
        assertTrue(testResult.getLowerBound() == 5);
    }
    
    @Test
    public void testExpandUpper() {
        Range range1 = new Range(5, 10);
        Range testResult = Range.expand(range1, 10, 1);
        assertTrue(testResult.getLowerBound() == -45.0);
    }
    
    @Test
    public void testExpandUpperBound() {
        Range range1 = new Range(5, 10);
        Range testResult = Range.expand(range1, 5, 5);
        assertTrue(testResult.getUpperBound() == 35.0);
    }
    
    @Test
    public void testExpandExactSameBound() {
        Range range1 = new Range(10, 10);
        Range testResult = Range.expand(range1, 5, 5);
        assertTrue(testResult.getUpperBound() == 10.0);
    }
    
    @Test
    public void testExpandLowerBoundAboveUpper() {
        Range range1 = new Range(9, 10);
        Range testResult = Range.expand(range1, 5, -7);
        assertTrue(testResult.getLowerBound() == 3.5);
    }
    /**
     * Test cases for shift method. There are 4 test cases for this method. We tested
     * this method by using negative and positive input values for Range to ensure that
     * we cover the branches and outputs for this method, and cover the boundaries.
     */
    
    @Test
    public void testShiftBelowZero() {
        Range range1 = new Range(5, 10);
        Range testResult = Range.shift(range1, -10, true);
        assertTrue(testResult.getLowerBound() == -5);
    }
    
    @Test
    public void testShiftAboveZero() {
        Range range1 = new Range(5, 10);
        Range testResult = Range.shift(range1, 1);
        assertTrue(testResult.getLowerBound() == 6);
    }
    
    @Test
    public void testShiftWithZero() {
        Range range1 = new Range(5, 10);
        Range testResult = Range.shift(range1, 0);
        assertTrue(testResult.getLowerBound() == 5);
    }
    
    @Test
    public void testShiftWithBelowZeroNoCrossing() {
        Range range1 = new Range(5, 10);
        Range testResult = Range.shift(range1, -0.5, false);
        assertTrue(testResult.getLowerBound() == 4.5);
    }
    
    @Test
    public void testShiftSlightlyBelowZero() {
        Range range1 = new Range(5, 10);
        Range testResult = Range.shift(range1, -1);
        assertTrue(testResult.getLowerBound() == 4);
    }
    
    @Test
    public void testShiftFalseZero() {
        Range range1 = new Range(5, 10);
        Range testResult = Range.shift(range1, -10);
        assertTrue(testResult.getLowerBound() == 0);
    }
    
    @Test
    public void testShiftRangeBelowFalseZero() {
        Range range1 = new Range(-5, 10);
        Range testResult = Range.shift(range1, 10);
        assertTrue(testResult.getLowerBound() == 0);
    }
    
    @Test
    public void testShiftRangeZeroFalseZero() {
        Range range1 = new Range(0, 10);
        Range testResult = Range.shift(range1, -10);
        assertTrue(testResult.getLowerBound() == -10);
    }
    
    
    /**
     * Test case for intersect method. There is one test case for this method.
     * Our plan to test this method is to test the boundary for intersection of coordinates
     */
    @Test
    public void testintersectsBoundaryValueTouching() {
        Range range1 = new Range(32, 35);
        boolean testResult = range1.intersects(35, 37);
        assertFalse(testResult);
    }
    
    /**
     * Test cases for scale method. There are 2 test cases for this method, which cover
     * the boundary for Scale, as well as for illegal arguments.
     */
    @Test
    public void testScale() {
        Range range1 = new Range(5, 10);
        Range testResult = Range.scale(range1, 10);
        assertTrue(testResult.getLowerBound() == 50);
    }
    
    @Test
    public void testScaleWithZero() {
        Range range1 = new Range(5, 10);
        Range testResult = Range.scale(range1, 0);
        assertTrue(testResult.getLowerBound() == 0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testScaleWithBelowZero() {
        Range range1 = new Range(5, 10);
        Range testResult = Range.scale(range1, -0.5);
    }
 
    @Test
    public void testScaleWithAboveZero() {
        Range range1 = new Range(5, 10);
        Range testResult = Range.scale(range1, 0.5);
        assertTrue(testResult.getLowerBound() == 2.5);
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void testScaleIllegal() {
        Range range1 = new Range(5, 10);
        Range testResult = Range.scale(range1, -10);
    }
    
    /**
     * Test cases for Central Value method. There is 1 test case for this method. It tests
     * to see if the output accurately shows the central value between the input Range value,
     * which in this case is Range (4,10).
     */
    @Test
    public void testCentralValue() {
        Range range1 = new Range(5, 11);
        double testResult = range1.getCentralValue();
        assertTrue(testResult == 8);
    }

/**
 * Test cases for contains method. There are 3 test cases for this method.
 * Our plan to test this method is to test the boundary between equivalence partitions
 * that are clearly contained and not contained with a value just at the range boundary.
 */
    
    @Test
    public void testcontainsBoundaryValueUpperTouching() {
        Range range1 = new Range(21, 25);
        boolean testResult = range1.contains(25);
        assertTrue(testResult);
    }

    @Test
    public void testcontainsBoundaryValueLowerTouching() {
        Range range1 = new Range(21, 25);
        boolean testResult = range1.contains(21);
        assertTrue(testResult);
    }
    
    @Test
    public void testcontainsValue() {
        Range range1 = new Range(21, 23);
        boolean testResult = range1.contains(22);
        assertTrue(testResult);
    }
    
    /**
     * Test cases for intersects method. There are 9 test cases for this method. We tested
     * this method by using different inputs range values to ensure that 
     * the method coverage and branch coverage metrics were sufficiently covered. Therefore,
     * it was necessary to create 9 test cases.
     */
    @Test
    public void intersects() {
        Range range1 = new Range(21, 25);
        boolean testResult = range1.contains(21);
        assertTrue(testResult);
    }
    
    @Test
    public void testIntersectLowerFalse() {
        Range range1 = new Range(21, 25);
        boolean testResult = range1.intersects(1,20);
        assertFalse(testResult);
    }
    
    @Test
    public void testIntersectLowerEqual() {
        Range range1 = new Range(21, 25);
        boolean testResult = range1.intersects(1,21);
        assertFalse(testResult);
    }
    
    @Test
    public void testIntersectHigherLower() {
        Range range1 = new Range(21, 25);
        boolean testResult = range1.intersects(23,21);
        assertFalse(testResult);
    }
    
    @Test
    public void testIntersectEqual() {
        Range range1 = new Range(21, 25);
        Range range2 = new Range(21, 21);
        boolean testResult = range1.intersects(range2);
        assertFalse(testResult);
    }
    
    @Test
    public void testIntersectHigherEqual() {
        Range range1 = new Range(21, 25);
        boolean testResult = range1.intersects(25,30);
        assertFalse(testResult);
    }
    
    @Test
    public void testIntersectHigherFalse() {
        Range range1 = new Range(21, 25);
        boolean testResult = range1.intersects(26,30);
        assertFalse(testResult);
    }
    
    @Test
    public void testIntersectLowerTrue() {
        Range range1 = new Range(21, 25);
        boolean testResult = range1.intersects(1,23);
        assertTrue(testResult);
    }
    
    @Test
    public void testIntersectHigherTrue() {
        Range range1 = new Range(21, 25);
        boolean testResult = range1.intersects(23,30);
        assertTrue(testResult);
    }

/**
 * Test cases for equals method. There are 6 test cases for this method.
 * Equals: We chose the equivalence partitioning analysis for the equals method
 * because the equals method contains 4 equivalence classes: 
 * True: Lower boundary = lower boundary, and upper boundary = upper boundary
 * False: Lower boundary != lower boundary, and upper boundary = upper boundary
 * False: Lower boundary = lower boundary, and upper boundary != upper boundary
 * False: Lower boundary != lower boundary, and upper boundary != upper boundary
 * Through this method, we made sure to cover all possible boundary cases to catch
 * all branches, hence why there were 6 test cases for this method.
 */

    @Test
    public void testequalsExactRange() {
        Range range1 = new Range(11, 15);
        Range range2 = new Range(11, 15);
        boolean testResult = range1.equals(range2);
        assertTrue(testResult);
    }
    
    @Test
    public void testequalNonRange() {
    	Range range1 = new Range(11, 15);
        Object range2 = null;
        boolean testResult = range1.equals(range2);
        assertFalse(testResult);
    }
        
    @Test
    public void testequalsUpperNotEqual() {
        Range range1 = new Range(11, 15);
        Range range2 = new Range(11, 16);
        boolean testResult = range1.equals(range2);
        assertFalse(testResult);
    }
    
    @Test
    public void testequalsUpperEqual() {
        Range range1 = new Range(11, 15);
        Range range3 = new Range(12, 15);
        boolean testResult2 = range1.equals(range3);
        assertFalse(testResult2);
    }

    @Test
    public void testequalsLowerNotEqual() {
        Range range1 = new Range(11, 15);
        Range range2 = new Range(10, 15);
        boolean testResult = range1.equals(range2);
        assertFalse(testResult);
    }

    @Test
    public void testequalsRangeNotEqual() {
        Range range1 = new Range(11, 15);
        Range range2 = new Range(10, 16);
        boolean testResult = range1.equals(range2);
        assertFalse(testResult);
    }
   
/**
 * Test cases for constrain method. There are 5 test cases for this method.
 * We tested this method by checking for upper and lower boundary values for the method,
 * and seeing if the method returned accurate results. Due to the range of inputs and branches,
 * it was necessary to create 5 test cases for this method.
 */
    @Test
    public void testconstrainOutsideLower() {
        Range range1 = new Range(11, 15);
        double testResult = range1.constrain(10);
        assertTrue(testResult == 11);
    }
    
    @Test
    public void testconstrainLower() {
        Range range1 = new Range(11, 15);
        double testResult = range1.constrain(11);
        assertTrue(testResult > 10);
    }
    
    @Test
    public void testconstrainUpper() {
        Range range1 = new Range(11, 15);
        double testResult = range1.constrain(15);
        assertTrue(testResult == 15);
    }

    @Test
    public void testconstrainTrueValue() {
        Range range1 = new Range(11, 15);
        double testResult = range1.constrain(13);
        assertTrue(testResult==13);
    }

    @Test
    public void testconstrainOutsideUpper() {
        Range range1 = new Range(11, 15);
        double testResult = range1.constrain(17);
        assertTrue(testResult==15);
    }
    
  /**
   * Test cases for expand method. There are 6 test cases for this method.
   * ExpandToInclude: We tested the boundary between the equivalence partitions
   * that are clearly outside of range from lower and upper bound and inside the range. 
   * We tested this method by covering the output branches, to test all possible paths.  
   */
    @Test
    public void expandToIncludeLowerBound() {
        Range range1 = new Range(10, 15);
        Range testResult = Range.expandToInclude(range1, 5);
        assertTrue(testResult.getLowerBound() == 5);
    }
    
    @Test
    public void expandToIncludeNull() {
        Range range1 = null;
        Range testResult = Range.expandToInclude(range1, 5);
        assertTrue(testResult.getLowerBound() == 5 && testResult.getUpperBound() == 5);
    }
    
    @Test
    public void expandToIncludeUpperBound() {
        Range range1 = new Range(10, 15);
        Range testResult = Range.expandToInclude(range1, 20);
        assertTrue(testResult.getUpperBound() == 20);
    }
    
    @Test
    public void expandToIncludeDontChangeUpper() {
        Range range1 = new Range(10, 15);
        Range testResult = Range.expandToInclude(range1, 13);
        assertTrue((testResult.getUpperBound() < 16) && (testResult.getLowerBound() > 9));
    }
    
    
    @Test
    public void expandToIncludeUpperBoundDontChange() {
        Range range1 = new Range(10, 15);
        Range testResult = Range.expandToInclude(range1, 15);
        assertTrue(testResult.getUpperBound() == 15);
    }
    
    @Test
    public void expandToIncludeDontBound() {
        Range range1 = new Range(10, 15);
        Range testResult = Range.expandToInclude(range1, 10);
        assertTrue(testResult.getLowerBound() == 10);
    }
    
    /**
     * Test cases for hashCode method. There is 1 test case for this method.
     * This method was tested by using the Range values Range (5,10), and then determining
     * the validity of the output.
     */
    @Test
    public void testHashcode() { //test to ensure hashcode is correct
        int result;
        long temp;
        Range range1 = new Range(5,10);
        temp = Double.doubleToLongBits(5);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(10);
        result = 29 * result + (int) (temp ^ (temp >>> 32));
        assertTrue(-2107113472 == range1.hashCode());
    }
    
    /**
     * Test cases for toString method. There is 1 test case for this method.
     */
    @Test
    public void testToString() {
    	Range range1 = new Range(5,10);
    	range1.toString();
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}