package com.xiaomi.mipush.sdk;

import android.text.TextUtils;

class n {

    /* renamed from: a  reason: collision with root package name */
    public int f51325a = 0;

    /* renamed from: a  reason: collision with other field name */
    public String f2472a = "";

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return !TextUtils.isEmpty(nVar.f2472a) && nVar.f2472a.equals(this.f2472a);
    }
}
