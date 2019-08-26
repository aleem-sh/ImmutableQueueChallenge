package com.paypay.challenge;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableQueueTest {

    @Test
    public void test_queue_is_empty(){
        ImmutableQueue<Integer> emptyQueue = new ImmutableQueue<>();
        Assert.assertTrue(emptyQueue.isEmpty());
    }

    @Test
    public void test_queue_returns_item_at_head(){
        Queue<Integer> queue = new ImmutableQueue<Integer>();
        queue = queue.enQueue(1).enQueue(2).enQueue(3);
        Integer item = queue.head();
        Assert.assertEquals(Integer.valueOf(3), item);
    }

    @Test
    public void test_queue_with_single_element(){
        Queue<Integer> queue = new ImmutableQueue<Integer>().enQueue(1);
        Integer item = queue.head();
        Assert.assertEquals(Integer.valueOf(1), item);
        queue = queue.deQueue();
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void test_queue_with_multiple_enqueues_are_copies(){
        Queue<Integer> queue1 = new ImmutableQueue<Integer>().enQueue(1);
        Queue<Integer> queue2 = queue1.enQueue(2);

        // Queue1 should only have 1 element
        Assert.assertEquals(Integer.valueOf(1), queue1.head());
        Assert.assertTrue(queue1.deQueue().isEmpty());

        // Queue2 should have 2 elements
        Assert.assertEquals(Integer.valueOf(2), queue2.head());
        Assert.assertFalse(queue2.deQueue().isEmpty());
        queue2 = queue2.deQueue();
        Assert.assertEquals(Integer.valueOf(1), queue2.head());
        Assert.assertTrue(queue2.deQueue().isEmpty());

        // Now lets add one more element to Queue1
        Queue<Integer> queue3 = queue1.enQueue(3);
        // Queue1 should still have only 1 element
        Assert.assertEquals(Integer.valueOf(1), queue1.head());
        Assert.assertTrue(queue1.deQueue().isEmpty());

        // Queue3 should have 2 elements
        Assert.assertEquals(Integer.valueOf(3), queue3.head());
        Assert.assertFalse(queue3.deQueue().isEmpty());
        queue3 = queue3.deQueue();
        Assert.assertEquals(Integer.valueOf(1), queue3.head());
        Assert.assertTrue(queue3.deQueue().isEmpty());
    }
}