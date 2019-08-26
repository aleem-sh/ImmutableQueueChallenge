package com.paypay.challenge;

public final class ImmutableQueue<T> implements Queue<T> {
    private final T item;
    private final ImmutableQueue rear;

    public ImmutableQueue() {
        this.item = null;
        this.rear = null;
    }

    private ImmutableQueue(T item, ImmutableQueue rear) {
        this.item = item;
        this.rear = rear;
    }

    public Queue enQueue(T item) {
        return new ImmutableQueue<>(item, this);
    }

    public Queue deQueue() {
        return rear;
    }

    public T head() {
        return item;
    }

    public boolean isEmpty() {
        return (item == null && rear == null);
    }

}
