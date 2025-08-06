package com.mob.commons.dialog;

@Deprecated
public class PolicyThrowable extends Throwable {
    private int code;

    public PolicyThrowable() {
        super("Privacy policy is not accepted");
    }

    public int getCode() {
        return this.code;
    }

    public PolicyThrowable(String str) {
        super(str);
    }

    public PolicyThrowable(String str, Throwable th2) {
        super(str, th2);
    }

    public PolicyThrowable(int i11, String str) {
        this(str);
        this.code = i11;
    }

    public PolicyThrowable(int i11, String str, Throwable th2) {
        this(str, th2);
        this.code = i11;
    }

    public PolicyThrowable(Throwable th2) {
        super(th2);
    }
}
