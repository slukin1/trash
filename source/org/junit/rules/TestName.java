package org.junit.rules;

import org.junit.runner.Description;

public class TestName extends TestWatcher {

    /* renamed from: a  reason: collision with root package name */
    public String f25451a;

    public void n(Description description) {
        this.f25451a = description.getMethodName();
    }
}
