package org.ascending;

import org.junit.Test;

import static junit.framework.Assert.*;
import static org.junit.Assert.assertArrayEquals;

public class AssertionsTest {
    @Test
    public void testAssertions() {
        String str1 = new String("abc");
        String str2 = new String("abc");
        String str3 = null;
        String str4 = "abc";
        String str5 = "abc";
        int val1 = 50;
        int val2 = 50;
        String[] expectedArray = {"one", "two", "three"};
        String[] resultArray = {"one", "two", "three"};

        //check two objects are equal
        assertEquals(str1, str2);

        //check a condition is true
        assertTrue(val1 <= val2);

        //check a condition is false
        assertFalse(val1 > val2);

        //check and object is not null
        assertNotNull(str1);

        //check an object is null
        assertNull(str3);

        //check if two object references point to the same object
        assertSame(str4, str5);

        assertArrayEquals(expectedArray, resultArray);
    }
}
