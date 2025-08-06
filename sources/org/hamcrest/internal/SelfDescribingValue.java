package org.hamcrest.internal;

import org.hamcrest.Description;
import org.hamcrest.SelfDescribing;

public class SelfDescribingValue<T> implements SelfDescribing {
    private T value;

    public SelfDescribingValue(T t11) {
        this.value = t11;
    }

    public void describeTo(Description description) {
        description.appendValue(this.value);
    }
}
