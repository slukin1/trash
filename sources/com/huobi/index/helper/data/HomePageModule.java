package com.huobi.index.helper.data;

import android.text.TextUtils;
import com.hbg.lib.common.utils.SP;
import gj.d;
import yl.i;

public abstract class HomePageModule<T> {

    /* renamed from: a  reason: collision with root package name */
    public final String f73290a = "IndexTAGModule";

    /* renamed from: b  reason: collision with root package name */
    public T f73291b;

    public void a() {
        this.f73291b = null;
    }

    public abstract String b(T t11);

    public abstract T c(String str);

    public T d() {
        return this.f73291b;
    }

    public abstract String e();

    public boolean f(int i11) {
        return d.n().r(i11);
    }

    public boolean g() {
        return true;
    }

    public void h() {
        String c11 = i.c(e());
        if (!e().equals("SP_TAG_BIZ_211201") || c11 == null || c11.endsWith("_biz_version1")) {
            String i11 = SP.i(c11, "");
            if (!TextUtils.isEmpty(i11)) {
                try {
                    T c12 = c(i11);
                    if (c12 != null) {
                        this.f73291b = c12;
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public T i(T t11) {
        return t11;
    }

    public void j(T t11) {
        String str;
        this.f73291b = i(t11);
        String c11 = i.c(e());
        T t12 = this.f73291b;
        if (t12 != null) {
            try {
                str = b(t12);
            } catch (Exception e11) {
                e11.printStackTrace();
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                SP.s(c11, str);
            }
        }
    }
}
