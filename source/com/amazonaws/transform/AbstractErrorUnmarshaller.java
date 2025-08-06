package com.amazonaws.transform;

import com.amazonaws.AmazonServiceException;

public abstract class AbstractErrorUnmarshaller<T> implements Unmarshaller<AmazonServiceException, T> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<? extends AmazonServiceException> f15506a;

    public AbstractErrorUnmarshaller() {
        this(AmazonServiceException.class);
    }

    public AmazonServiceException b(String str) throws Exception {
        return (AmazonServiceException) this.f15506a.getConstructor(new Class[]{String.class}).newInstance(new Object[]{str});
    }

    public AbstractErrorUnmarshaller(Class<? extends AmazonServiceException> cls) {
        this.f15506a = cls;
    }
}
