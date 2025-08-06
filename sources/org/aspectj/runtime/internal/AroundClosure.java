package org.aspectj.runtime.internal;

import org.aspectj.lang.ProceedingJoinPoint;

public abstract class AroundClosure {
    public int bitflags = 1048576;
    public Object[] preInitializationState;
    public Object[] state;

    public AroundClosure() {
    }

    public int getFlags() {
        return this.bitflags;
    }

    public Object[] getPreInitializationState() {
        return this.preInitializationState;
    }

    public Object[] getState() {
        return this.state;
    }

    public ProceedingJoinPoint linkClosureAndJoinPoint() {
        Object[] objArr = this.state;
        ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) objArr[objArr.length - 1];
        proceedingJoinPoint.d(this);
        return proceedingJoinPoint;
    }

    public ProceedingJoinPoint linkStackClosureAndJoinPoint(int i11) {
        Object[] objArr = this.state;
        ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) objArr[objArr.length - 1];
        proceedingJoinPoint.f(this);
        this.bitflags = i11;
        return proceedingJoinPoint;
    }

    public abstract Object run(Object[] objArr) throws Throwable;

    public void unlink() {
        Object[] objArr = this.state;
        ((ProceedingJoinPoint) objArr[objArr.length - 1]).f((AroundClosure) null);
    }

    public AroundClosure(Object[] objArr) {
        this.state = objArr;
    }

    public ProceedingJoinPoint linkClosureAndJoinPoint(int i11) {
        Object[] objArr = this.state;
        ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) objArr[objArr.length - 1];
        proceedingJoinPoint.d(this);
        this.bitflags = i11;
        return proceedingJoinPoint;
    }
}
