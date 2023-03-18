package org.jfree.data;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange1;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { exampleRange1 = new Range(-1, 1);
    
    }

/**
 * Test cases for intersect method
 * Our plan to test this method is to test the boundary between
 * an intersection if two ranges just touch each other. Ex. One ranges lower = other ranges
 * upper.  
 */
    @Test
    public void testintersectsBoundaryValueTouching() {
        Range range1 = new Range(32, 35);
        boolean testResult = range1.intersects(35, 37);
        assertFalse(testResult);
    }
    
/**
 * Test cases for contains method
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

/**
 * Test cases for equals method
 * Equals: We chose the equivalence partitioning analysis for the equals method
 * because the equals method contains 4 equivalence classes: 
 * True: Lower boundary = lower boundary, and upper boundary = upper boundary
 * False: Lower boundary != lower boundary, and upper boundary = upper boundary
 * False: Lower boundary = lower boundary, and upper boundary != upper boundary
 * False: Lower boundary != lower boundary, and upper boundary != upper boundary
 */

    @Test
    public void testequalsExactRange() {
        Range range1 = new Range(11, 15);
        Range range2 = new Range(11, 15);
        boolean testResult = range1.equals(range2);
        assertTrue(testResult);
    }

        
    @Test
    public void testequalsUpperNotEqual() {
        Range range1 = new Range(11, 15);
        Range range2 = new Range(11, 16);
        boolean testResult = range1.equals(range2);
        assertFalse(testResult);
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
 * Test cases for constrain method
 * Constrain: We used equivalence partitioning analysis for the constrain method by setting
 * the partitions as follows:
 * Testing return value = lower boundary when value is out of lower range.
 * Testing return value = upper boundary when value is out of upper range.
 * Testing return value = value when value is in range.
 */
    @Test
    public void testconstrainOutsideLower() {
        Range range1 = new Range(11, 15);
        double testResult = range1.constrain(10);
        assertTrue(testResult == 11);
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
   * Test cases for expand method
   * ExpandToInclude: We tested the boundary between the equivalence partitions
   * that are clearly outside of range from lower and upper bound and inside the range.    
   */
    @Test
    public void expandToIncludeLowerBound() {
        Range range1 = new Range(10, 15);
        Range testResult = Range.expandToInclude(range1, 5);
        assertTrue(testResult.getLowerBound() == 5);
    }
    
    @Test
    public void expandToIncludeUpperBound() {
        Range range1 = new Range(10, 15);
        Range testResult = Range.expandToInclude(range1, 20);
        assertTrue(testResult.getUpperBound() == 20);
    }
    
    @Test
    public void expandToIncludeDontChange() {
        Range range1 = new Range(10, 15);
        Range testResult = Range.expandToInclude(range1, 13);
        assertTrue((testResult.getUpperBound() == 15) && (testResult.getLowerBound() == 10));
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
    
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}