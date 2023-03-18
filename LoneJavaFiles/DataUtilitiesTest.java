package org.jfree.data;

import static org.junit.Assert.*;

//import org.jfree.data.Keyedvalues;
//import org.jfree.data.values2D;
import org.jmock.*;
import org.junit.*;
import org.junit.rules.ExpectedException;

//import org.jfree.data.DataUtilities;
//import org.jfree.data.Values2D;


public class DataUtilitiesTest extends DataUtilities {	
	/*
	 * Testing empty values for calculatingColumntotal
	 * 
	 */
	
	@Test 
	public void calculateEmptyColumn() {
		// takes in 2D Array and a column index
		
		Mockery mock = new Mockery();
		//testing 2D Array Value
		final Values2D array = mock.mock(Values2D.class);
		
		mock.checking(new Expectations() {
			{
				one(array);
				will(returnValue(0));
			}
		});
				
				
		int columnIndex =  0;
		double answer = calculateColumnTotal(array, columnIndex);
		assertEquals("Answer should be zero", 0, answer, 0.001);
		
		
		
		
	}
	
	
	/*
	 * Testing empty values for null values
	 * 
	 */
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	
	@Test
	public void calculateColumnWithNull() throws Exception {
	
		
		thrown.expect(Exception.class);
		
		int columnIndex =  0;
		double answer =  DataUtilities.calculateColumnTotal(null, columnIndex);
	}
	
	/*
	 * Testing random set of data for 2DArray
	 *   { 1, 3, 6,
	 *     1, 3, 6,
	 *     1, 3, 6,
	 *    
	 *    
	 *   }
	 *   
	 *   column number 3
	 *   answr 18
	 * 
	 */
	


	
	@Test
	public void calculateColumnRandomValues() 	 {
	
				
		// takes in 2D Array and a column index
		
		Mockery mock = new Mockery();
		//testing 2D Array Value
		final Values2D array = mock.mock(Values2D.class);
		
		mock.checking(new Expectations() {
			{
				one(array).getRowCount();
				will(returnValue(3));
				
				one(array).getValue(0, 3);
				will(returnValue(6));

				one(array).getValue(1, 3);
				will(returnValue(6));

				one(array).getValue(2, 3);
				will(returnValue(6));
				
				
				
				
				
			}
		});
				
				
		int columnIndex =  3;
		double answer = calculateColumnTotal(array, columnIndex);
		assertEquals("Answer should be 18", 18, answer, 0.001);
		
		
		
	}
	
	/*
	 * Testing random set of data for 2DArray but with  negative values
	 *   { 1, -12, 6,
	 *     1, -2, 6,
	 *     1, 9, 6,
	 *    
	 *    
	 *   }
	 *   
	 *   column number -1
	 *   answr  = -5 
	 * 
	 */
	
	


	
	@Test
	public void calculateColumnTotalWithNegitiveIntegers() throws Exception
	 {
	
	
		
				
		// takes in 2D Array and a column index
		
		Mockery mock = new Mockery();
		//testing 2D Array Value
		final Values2D array = mock.mock(Values2D.class);
		
		mock.checking(new Expectations() {
			{
				one(array).getRowCount();
				will(returnValue(3));
				
				one(array).getValue(0, 1);
				will(returnValue(-12));

				one(array).getValue(1, 1);
				will(returnValue(-2));

				one(array).getValue(2, 1);
				will(returnValue(9));
				
				
				
				
				
			}
		});
		
		
			int columnIndex =  1;
			double answer = calculateColumnTotal(array, columnIndex);
			assertEquals("total should be -5", -5, answer, .001);
		
		
		
		
	}
	
	
	
	/**
	 * 
	 * Start of testing calculateRowTotal 
	 *
	 */
	
	
	/*
	 * Testing empty values for calculatingRowValues
	 * 
	 */
	
	@Test 
	public void calculateEmptyRow() {
		// takes in 2D Array and a column index
		
		Mockery mock = new Mockery();
		//testing 2D Array Value
		final Values2D array = mock.mock(Values2D.class);
		
		mock.checking(new Expectations() {
			{
				one(array);
				will(returnValue(0));
			}
		});
				
				
		int columnIndex =  0;
		double answer = calculateRowTotal(array, columnIndex);
		assertEquals("Answer should be zero", 0, answer, 0.001);
		
		
		
		
	}
	
	
	/*
	 * Testing empty values for null values
	 * 
	 */
	


	
	@Test
	public void calculateRowWithNull() throws Exception {
	
		
		thrown.expect(Exception.class);
		
		int columnIndex =  0;
		double answer =  DataUtilities.calculateRowTotal(null, columnIndex);
		
		
		
	}
	
	/*
	 * Testing random set of data for 2DArray
	 *   { 1, 3, 6,
	 *     8, 3, 1,
	 *     7, 3, 4,
	 *    
	 *    
	 *   }
	 *   
	 *   row number 2 which is 1 (0 , 1, 2)
	 *   expected answer 12
	 * 
	 */
	


	
	@Test
	public void calculaterowRandomValues() 	 {
	
				
		// takes in 2D Array and a column index
		
		Mockery mock = new Mockery();
		//testing 2D Array Value
		final Values2D array = mock.mock(Values2D.class);
		
		mock.checking(new Expectations() {
			{
				one(array).getColumnCount();
				will(returnValue(3));
				
				one(array).getValue(1, 0);
				will(returnValue(8));

				one(array).getValue(1, 1);
				will(returnValue(2));

				one(array).getValue(1, 2);
				will(returnValue(1));
				
				
			//bruh broken when 3rd row is used the system is off by 1
				
			}
		});
				
				
		int rowIndex =  1;
		double answer = calculateRowTotal(array, rowIndex);
		assertEquals("Answer should be 10", 11, answer, 0.001);
		
		
		
	}
	
	/*
	 * Testing random set of data for 2DArray but with  negative values
	 *   { 1, -12, 6,
	 *     -3, -2, 6,
	 *     1, 9, 6,
	 *    
	 *    
	 *   }
	 *   
	 *   column number -1
	 *   answr  = 1 
	 * 
	 */
	
	


	
	@Test
	public void calculateRowTotalWithNegitiveIntegers() throws Exception
	 {
	
	
		
				
		// takes in 2D Array and a column index
		
		Mockery mock = new Mockery();
		//testing 2D Array Value
		final Values2D array = mock.mock(Values2D.class);
		
		mock.checking(new Expectations() {
			{
				one(array).getColumnCount();
				will(returnValue(3));
				
				one(array).getValue(1, 0);
				will(returnValue(-3));

				one(array).getValue(1, 1);
				will(returnValue(-2));

				one(array).getValue(1, 2);
				will(returnValue(6));
				
				//same thing the 3rd row doesnt work the values are not being used
				
				
				
				
				
			}
		});
		
		
			int columnIndex =  1;
			double answer = calculateRowTotal(array, columnIndex);
			assertEquals("total should be -5", -5, answer, .001);
		
		
		
		
	}
	
	// -------------------------------------------------------------------------------------------
	//								createNumberArray Tests
	// -------------------------------------------------------------------------------------------
	
	//create an array with value of zero and pass into function
	//should return same array of zero
	@Test
	public void createNumberArrayZero() {
		//expected output
		Number[] expectedArray = {0};
		//test array input into function
		double[] testArray = {0};
		//actual array
		Number[] actualArray = DataUtilities.createNumberArray(testArray);
		
		assertArrayEquals("Expected array should be [0]", expectedArray, actualArray);
	}
	
	//create an array of one element and pass into function
	//should return same one element array
	@Test
	public void createNumberArrayOneElement() {
		//expected output
		Number[] expectedArray = {0.5};
		//test array input into function
		double[] testArray = {0.5};
		//actual array
		Number[] actualArray = DataUtilities.createNumberArray(testArray);
		
		assertArrayEquals("Expected array should be [0.5]", expectedArray, actualArray);
	}
	
	//create an array of two element and pass into function
	//should return same two element array
	@Test
	public void createNumberArrayTwoElements() {
		//expected output
		Number[] expectedArray = {0.5,-1.5};
		//test array input into function
		double[] testArray = {0.5,-1.5};
		//actual array
		Number[] actualArray = DataUtilities.createNumberArray(testArray);
		
		assertArrayEquals("Expected array should be [0.5, -1.5]", expectedArray, actualArray);
	}
	
	//create an array of three element and pass into function
	//should return same three element array
	@Test
	public void createNumberArrayThreeElements() {
		//expected output
		Number[] expectedArray = {0.5,-1.5,2.5};
		//test array input into function
		double[] testArray = {0.5,-1.5,2.5};
		//actual array
		Number[] actualArray = DataUtilities.createNumberArray(testArray);
		
		assertArrayEquals("Expected array should be [0.5, -1.5, 2.5]", expectedArray, actualArray);
	}
	
	//create an empty array and pass it into the function
	//should return empty array
	@Test
	public void createNumberArrayEmpty() {
		//expected output
		Number[] expectedArray = {};
		//test array input into function
		double[] testArray = {};
		//actual array
		Number[] actualArray = DataUtilities.createNumberArray(testArray);
		
		assertArrayEquals("Expected array should be []", expectedArray, actualArray);
	}
	
	//create a null array and pass into the function
	//should throw an exception
	@Test
	public void createNumberArrayNull() {
		try {
			//test array input into function
			double[] testArray = null;
			//actual array
			DataUtilities.createNumberArray(testArray);
		}
		catch (Exception e) {
			assertEquals("Should throw IllegalArgumentException", IllegalArgumentException.class,
					e.getClass());
		}	
	}
	
	//create a two element array with one min and one max value for double to determine 
	//if it can handle all double valuesPos
	//should return same array
	@Test
	public void createNumberArrayMinMax() {
		//expected output
		Number[] expectedArray = {Double.MAX_VALUE, Double.MIN_VALUE};
		//test array input into function
		double[] testArray = {Double.MAX_VALUE, Double.MIN_VALUE};
		//actual array
		Number[] actualArray = DataUtilities.createNumberArray(testArray);
		
		assertArrayEquals("Expected array should be one max value and one min value", 
				expectedArray, actualArray);
	}
	
	
	// -------------------------------------------------------------------------------------------
	//								createNumberArray2D Tests
	// -------------------------------------------------------------------------------------------
	
	//create a double array of value zeros and pass to function
	//should return same array
	@Test
	public void create2DNumberArrayZero() {
		//expected output
		Number[][] expectedArray = {{0},{0}};
		//test array to pass to function
		double[][] testArray = {{0},{0}};
		//actual array
		Number[][] actualArray = DataUtilities.createNumberArray2D(testArray);
		
		assertArrayEquals("Expected array should be [0][0]", expectedArray, actualArray);
	}
	
	//create a double array of one element and pass to function
	//should return same array
	@Test
	public void create2DNumberArrayOneElement() {
		//expected output
		Number[][] expectedArray = {{0.5},{0.5}};
		//test array to pass to function
		double[][] testArray = {{0.5},{0.5}};
		//actual array
		Number[][] actualArray = DataUtilities.createNumberArray2D(testArray);
		
		assertArrayEquals("Expected array should be [0.5][0.5]", expectedArray, actualArray);
	}
	
	//create a double array of two elements and pass to function
	//should return same array
	@Test
	public void create2DNumberArrayTwoElement() {
		//expected output
		Number[][] expectedArray = {{0.5,-1.5},{0.5,-1.5}};
		//test array to pass to function
		double[][] testArray = {{0.5,-1.5},{0.5,-1.5}};
		//actual array
		Number[][] actualArray = DataUtilities.createNumberArray2D(testArray);
		
		assertArrayEquals("Expected array should be [0.5, -1.5][0.5, -1.5]", expectedArray, actualArray);
	}
	
	//create empty array and pass to function
	//should return empty array
	@Test
	public void create2DNumberArrayEmpty() {
		//expected output
		Number[][] expectedArray = {{},{}};
		//test array to pass to function
		double[][] testArray = {{},{}};
		//actual array
		Number[][] actualArray = DataUtilities.createNumberArray2D(testArray);
		
		assertArrayEquals("Expected array should be [][]", expectedArray, actualArray);
	}
	
	//create a double array where first part is empty and pass to function
	//should return same array
	@Test
	public void create2DNumberArrayEmptyFirst() {
		//expected output
		Number[][] expectedArray = {{},{0.5}};
		//test array to pass to function
		double[][] testArray = {{},{0.5}};
		//actual array
		Number[][] actualArray = DataUtilities.createNumberArray2D(testArray);
		
		assertArrayEquals("Expected array should be [][0.5]", expectedArray, actualArray);
	}
	
	//create a double array where second part is empty to function
	//should return same array
	@Test
	public void create2DNumberArrayEmptySecond() {
		//expected output
		Number[][] expectedArray = {{0.5},{}};
		//test array to pass to function
		double[][] testArray = {{0.5},{}};
		//actual array
		Number[][] actualArray = DataUtilities.createNumberArray2D(testArray);
		
		assertArrayEquals("Expected array should be [0.5][]", expectedArray, actualArray);
	}
	
	//create a null array and pass into the function
	//should throw an exception
	@Test
	public void create2DNumberArrayNull() {
		try {
			//test array input into function
			double[][] testArray = null;
			//actual array
			DataUtilities.createNumberArray2D(testArray);
		}
		catch (Exception e) {
			assertEquals("Should throw IllegalArgumentException", IllegalArgumentException.class,
					e.getClass());
		}	
	}
	
	//create a two element array with one min and one max value for double to determine 
	//if it can handle all double valuesPos
	//should return same array
	@Test
	public void create2DNumberArrayMinMax() {
		//expected output
		Number[][] expectedArray = {{Double.MAX_VALUE, Double.MIN_VALUE},{Double.MAX_VALUE, Double.MIN_VALUE}};
		//test array input into function
		double[][] testArray = {{Double.MAX_VALUE, Double.MIN_VALUE},{Double.MAX_VALUE, Double.MIN_VALUE}};
		//actual array
		Number[][] actualArray = DataUtilities.createNumberArray2D(testArray);
		
		assertArrayEquals("Expected array should be two arrays each with one max value and one min value", 
				expectedArray, actualArray);
	}
	
	// -------------------------------------------------------------------------------------------
	//								getCumulativePercentages Tests
	// -------------------------------------------------------------------------------------------
	
	//-----------------------------------------------------------------------------------------
    //positive values
	KeyedValues valuesPos;
    @Before
    public void setUpPos() throws Exception { 
        Mockery mock1 = new Mockery();
        valuesPos = mock1.mock(KeyedValues.class);
        mock1.checking(new Expectations() {
            { 
                one(valuesPos).getIndex(0);
                will(returnValue(0));
                one(valuesPos).getIndex(1);
                will(returnValue(1));
                one(valuesPos).getIndex(2);
                will(returnValue(2)); 

                one(valuesPos).getKey(0);
                will(returnValue(0));
                one(valuesPos).getKey(1);
                will(returnValue(1));
                one(valuesPos).getKey(2);
                will(returnValue(2));
                
                atLeast(1).of(valuesPos).getValue(0);
                will(returnValue(5));
                atLeast(1).of(valuesPos).getValue(1);
                will(returnValue(9));
                atLeast(1).of(valuesPos).getValue(2);
                will(returnValue(2));

                atLeast(1).of(valuesPos).getItemCount();
                will(returnValue(3));
            }
        });
    }

    //should return the total number of items
    @Test
    public void getCumulativePercentagesItemCountPos(){
    	KeyedValues result =  DataUtilities.getCumulativePercentages(valuesPos);
        //
        assertEquals("Total item count should be 3", 3, result.getItemCount());
    }

    //should return the total for all valuesPos
    @Test
    public void getCumulativePercentagesTotalPos(){
        double total = 0.0;
        for (int i = 0; i < valuesPos.getItemCount(); i++){ 
            total += valuesPos.getValue(i).doubleValue();
        }
        assertEquals("Total for all valuesPos should be 16", 16.0, total, .000000001d);
    }

    //test the data value for each index
    @Test
    public void getCumulativePercentagesValuesWithKeyPos(){
    	//value at index zero should be five
        assertEquals("Index one value should be 5", 
        		5.0, valuesPos.getValue(0).doubleValue(), .000000001d);
        //value at index one should be nine
        assertEquals("index two value should be 9", 
        		9.0, valuesPos.getValue(1).doubleValue(), .000000001d);
        //value at index two should two
        assertEquals("Index three value should be 2", 
        		2.0, valuesPos.getValue(2).doubleValue(), .000000001d);
    }

    //test the index number for each key value of the data
    @Test
    public void getCumulativePercentagesIndexWithKeyPos(){
    	//index value at for key 0
        assertEquals("Index for key 0 should be 0",
        		0, valuesPos.getIndex(0));
        //index value for key 1
        assertEquals("Index for key 1 should be 1",
        		1, valuesPos.getIndex(1));
        //index value for key 2
        assertEquals("index for key 2 should be 2",
        		2, valuesPos.getIndex(2));
    }
    
    //test the key value for each index of the data
    @Test
    public void getCumulativePercentagesKeyWithIndexPos(){
    	//key value at index 0
        assertEquals("Key value for index 0 should be 0",
        		0, valuesPos.getKey(0));
        //key value at index 1
        assertEquals("Key value for index 1 should be 1",
        		1, valuesPos.getKey(1));
        //key value at index 2
        assertEquals("Key value for index 2 should be 2",
        		2, valuesPos.getKey(2));
    }

    //should return an array of percentages for each key
    @Test
    public void getCumulativePercentagesWithValuePos(){
    	KeyedValues result = DataUtilities.getCumulativePercentages(valuesPos);
        //array of expected percentages
        double [] expected = {5.0/16.0, 14.0/16.0, 16.0/16.0};
        //array of actual percentages
        double [] actual = {result.getValue(0).doubleValue(), result.getValue(1).doubleValue(), 
        		result.getValue(2).doubleValue()};

        assertArrayEquals(expected, actual, .000000001d);
    }
    
    //-----------------------------------------------------------------------------------------
    //negative values
    KeyedValues valuesNeg;
    @Before
    public void setUpNeg() throws Exception { 
        Mockery mock1 = new Mockery();
        valuesNeg = mock1.mock(KeyedValues.class);
        mock1.checking(new Expectations() {
            { 
                one(valuesNeg).getIndex(0);
                will(returnValue(0));
                one(valuesNeg).getIndex(1);
                will(returnValue(1));
                one(valuesNeg).getIndex(2);
                will(returnValue(2)); 

                one(valuesNeg).getKey(0);
                will(returnValue(0));
                one(valuesNeg).getKey(1);
                will(returnValue(1));
                one(valuesNeg).getKey(2);
                will(returnValue(2));
                
                atLeast(1).of(valuesNeg).getValue(0);
                will(returnValue(-5));
                atLeast(1).of(valuesNeg).getValue(1);
                will(returnValue(-9));
                atLeast(1).of(valuesNeg).getValue(2);
                will(returnValue(-2));

                atLeast(1).of(valuesNeg).getItemCount();
                will(returnValue(3));
            }
        });
    }

    //should return the total number of items
    @Test
    public void getCumulativePercentagesItemCountNeg(){
        KeyedValues result =  DataUtilities.getCumulativePercentages(valuesNeg);
        //
        assertEquals("Total item count should be 3", 3, result.getItemCount());
    }

    //should return the total for all valuesNeg
    @Test
    public void getCumulativePercentagesTotalNeg(){
        double total = 0.0;
        for (int i = 0; i < valuesNeg.getItemCount(); i++){ 
            total += valuesNeg.getValue(i).doubleValue();
        }
        assertEquals("Total for all values should be 16", -16.0, total, .000000001d);
    }

    //test the data value for each index
    @Test
    public void getCumulativePercentagesvaluesWithKeyNeg(){
    	//value at index zero should be five
        assertEquals("Index one value should be 5", 
        		-5.0, valuesNeg.getValue(0).doubleValue(), .000000001d);
        //value at index one should be nine
        assertEquals("index two value should be 9", 
        		-9.0, valuesNeg.getValue(1).doubleValue(), .000000001d);
        //value at index two should two
        assertEquals("Index three value should be 2", 
        		-2.0, valuesNeg.getValue(2).doubleValue(), .000000001d);
    }

    //test the index number for each key value of the data
    @Test
    public void getCumulativePercentagesIndexWithKeyNeg(){
    	//index value at for key 0
        assertEquals("Index for key 0 should be 0",
        		0, valuesNeg.getIndex(0));
        //index value for key 1
        assertEquals("Index for key 1 should be 1",
        		1, valuesNeg.getIndex(1));
        //index value for key 2
        assertEquals("index for key 2 should be 2",
        		2, valuesNeg.getIndex(2));
    }
    
    //test the key value for each index of the data
    @Test
    public void getCumulativePercentagesKeyWithIndexNeg(){
    	//key value at index 0
        assertEquals("Key value for index 0 should be 0",
        		0, valuesNeg.getKey(0));
        //key value at index 1
        assertEquals("Key value for index 1 should be 1",
        		1, valuesNeg.getKey(1));
        //key value at index 2
        assertEquals("Key value for index 2 should be 2",
        		2, valuesNeg.getKey(2));
    }

    //should return an array of percentages for each key
    @Test
    public void getCumulativePercentagesWithValueNeg(){
        KeyedValues result = DataUtilities.getCumulativePercentages(valuesNeg);
        //array of expected percentages
        double [] expected = {-5.0/-16.0, -14.0/-16.0, -16.0/-16.0};
        //array of actual percentages
        double [] actual = {result.getValue(0).doubleValue(), result.getValue(1).doubleValue(), 
        		result.getValue(2).doubleValue()};

        assertArrayEquals(expected, actual, .000000001d);
    }
    
    //-----------------------------------------------------------------------------------------
    //null values
    KeyedValues valuesNull;
    @Before
    public void setUpNull() throws Exception { 
        Mockery mock1 = new Mockery();
        valuesNull = mock1.mock(KeyedValues.class);
        mock1.checking(new Expectations() {
            { 
                one(valuesNull).getIndex(0);
                will(returnValue(0));
                one(valuesNull).getIndex(1);
                will(returnValue(1));
                one(valuesNull).getIndex(2);
                will(returnValue(2)); 

                one(valuesNull).getKey(0);
                will(returnValue(0));
                one(valuesNull).getKey(1);
                will(returnValue(1));
                one(valuesNull).getKey(2);
                will(returnValue(2));
                
                atLeast(1).of(valuesNull).getValue(0);
                will(returnValue(null));
                atLeast(1).of(valuesNull).getValue(1);
                will(returnValue(null));
                atLeast(1).of(valuesNull).getValue(2);
                will(returnValue(null));

                atLeast(1).of(valuesNull).getItemCount();
                will(returnValue(3));
            }
        });
    }

    //should return the total number of items
    @Test
    public void getCumulativePercentagesItemCountNull(){
        KeyedValues result =  DataUtilities.getCumulativePercentages(valuesNull);
        //
        assertEquals("Total item count should be 3", 3, result.getItemCount());
    }


    //test the index number for each key value of the data
    @Test
    public void getCumulativePercentagesIndexWithKeyNull(){
    	//index value at for key 0
        assertEquals("Index for key 0 should be 0",
        		0, valuesNull.getIndex(0));
        //index value for key 1
        assertEquals("Index for key 1 should be 1",
        		1, valuesNull.getIndex(1));
        //index value for key 2
        assertEquals("index for key 2 should be 2",
        		2, valuesNull.getIndex(2));
    }
    
    //test the key value for each index of the data
    @Test
    public void getCumulativePercentagesKeyWithIndexNull(){
    	//key value at index 0
        assertEquals("Key value for index 0 should be 0",
        		0, valuesNull.getKey(0));
        //key value at index 1
        assertEquals("Key value for index 1 should be 1",
        		1, valuesNull.getKey(1));
        //key value at index 2
        assertEquals("Key value for index 2 should be 2",
        		2, valuesNull.getKey(2));
    }
   
    
    
    //should return the total for all valuesNull
    @Test
    public void getCumulativePercentagesTotalNull(){
    	try {
    		double total = 0.0;
            for (int i = 0; i < valuesNull.getItemCount(); i++){ 
                total += valuesNull.getValue(i).doubleValue();
            }
//            System.out.print(total);
    	}
    	catch(Exception e) {
    		assertEquals("Should throw NullPointerException", NullPointerException.class,
					e.getClass());
    	}
    }

    //should return an array of percentages for each key
    @Test
    public void getCumulativePercentagesWithValueNull(){
    	try {
    		 KeyedValues result = DataUtilities.getCumulativePercentages(valuesNull);
	        //array of expected percentages
	        double [] expected = {(Double) null, (Double) null, (Double) null};
	        //array of actual percentages
	        double [] actual = {result.getValue(0).doubleValue(), result.getValue(1).doubleValue(), 
	        		result.getValue(2).doubleValue()};
	
	        assertArrayEquals(expected, actual, .000000001d);
    	}
    	catch(Exception e) {
    		assertEquals("Should throw NullPointerException", NullPointerException.class,
					e.getClass());
    	}
       
    }
   
  //test the data value for each index
    @Test
    public void getCumulativePercentagesvaluesWithKeyNull(){
    	try {
    		//value at index zero should be five
            assertEquals("Index one value should be 5", 
            		-5.0, valuesNull.getValue(0).doubleValue(), .000000001d);
            //value at index one should be nine
            assertEquals("index two value should be 9", 
            		-9.0, valuesNull.getValue(1).doubleValue(), .000000001d);
            //value at index two should two
            assertEquals("Index three value should be 2", 
            		-2.0, valuesNull.getValue(2).doubleValue(), .000000001d);
    	}
    	catch(Exception e){
    		assertEquals("Should throw NullPointerException", NullPointerException.class,
					e.getClass());
    	}
    	
    }
}
