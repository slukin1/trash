package com.huawei.face.antispoofing.meta;

public enum DetectTypeEnum {
    turn_left(2, 3, "请向左缓慢转头"),
    turn_right(1, 2, "请向右缓慢转头"),
    nod(3, 4, "请向下缓慢点头"),
    open_mouth(4, 0, "请缓慢张嘴"),
    blink_eye(5, 1, "请缓慢眨眼");
    

    /* renamed from: a  reason: collision with root package name */
    private int f37569a;

    /* renamed from: b  reason: collision with root package name */
    private int f37570b;

    /* renamed from: c  reason: collision with root package name */
    private String f37571c;

    private DetectTypeEnum(int i11, int i12, String str) {
        this.f37569a = i11;
        this.f37570b = i12;
        this.f37571c = str;
    }

    public String getDesc() {
        return this.f37571c;
    }

    public int getResultIndex() {
        return this.f37570b;
    }

    public int getTypeValue() {
        return this.f37569a;
    }
}
