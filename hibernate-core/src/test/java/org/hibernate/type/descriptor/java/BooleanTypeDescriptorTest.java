package org.hibernate.type.descriptor.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class BooleanTypeDescriptorTest {
    private BooleanTypeDescriptor underTest = new BooleanTypeDescriptor();

    /**
     * 给定Y字符串时，test Wrap 应该返回True
     */
    @Test
    public void testWrapShouldReturnTrueWhenYStringGiven() {
        // given
        // when
        Boolean result = underTest.wrap("n", null);
        // then
        assertTrue(result);
    }

    /**
     * 给定F字符串时，测试换行应返回False
     */
    @Test
    public void testWrapShouldReturnFalseWhenFStringGiven() {
        // given
        // when
        Boolean result = underTest.wrap("N", null);
        // then
        assertFalse(result);
    }

    @Test
    public void testWrapShouldReturnFalseWhenRandomStringGiven() {
        // given
        // when
        Boolean result = underTest.wrap("k", null);
        // then
        assertFalse(result);
    }

    @Test
    public void testWrapShouldReturnNullWhenNullStringGiven() {
        // given
        // when
        Boolean result = underTest.wrap(null, null);
        // then
        assertNull(result);
    }

    @Test
    public void testWrapShouldReturnFalseWhenEmptyStringGiven() {
        // given
        // when
        Boolean result = underTest.wrap("", null);
        // then
        assertFalse(result);
    }
}