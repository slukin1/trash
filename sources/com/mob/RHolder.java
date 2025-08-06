package com.mob;

import com.mob.tools.proguard.PublicMemberKeeper;

@Deprecated
public class RHolder implements PublicMemberKeeper {

    /* renamed from: a  reason: collision with root package name */
    private static RHolder f26843a;

    /* renamed from: b  reason: collision with root package name */
    private int f26844b;

    /* renamed from: c  reason: collision with root package name */
    private int f26845c;

    /* renamed from: d  reason: collision with root package name */
    private int f26846d;

    private RHolder() {
    }

    public static RHolder getInstance() {
        if (f26843a == null) {
            synchronized (RHolder.class) {
                if (f26843a == null) {
                    f26843a = new RHolder();
                }
            }
        }
        return f26843a;
    }

    public int getActivityThemeId() {
        return this.f26844b;
    }

    public int getDialogLayoutId() {
        return this.f26845c;
    }

    public int getDialogThemeId() {
        return this.f26846d;
    }

    public RHolder setActivityThemeId(int i11) {
        this.f26844b = i11;
        return f26843a;
    }

    public RHolder setDialogLayoutId(int i11) {
        this.f26845c = i11;
        return f26843a;
    }

    public RHolder setDialogThemeId(int i11) {
        this.f26846d = i11;
        return f26843a;
    }
}
