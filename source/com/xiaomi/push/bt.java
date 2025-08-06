package com.xiaomi.push;

import com.xiaomi.push.bx;

public class bt extends bx.d {

    /* renamed from: a  reason: collision with root package name */
    public String f51460a = "MessageDeleteJob";

    public bt(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr);
        this.f51460a = str3;
    }

    public static bt a(String str) {
        return new bt(str, "status = ?", new String[]{String.valueOf(2)}, "a job build to delete uploaded job");
    }
}
