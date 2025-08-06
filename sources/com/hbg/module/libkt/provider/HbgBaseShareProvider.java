package com.hbg.module.libkt.provider;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.android.arouter.facade.template.IProvider;
import d10.l;
import kotlin.Unit;

public interface HbgBaseShareProvider extends IProvider {
    void b(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, String str5, String str6, int i11, l<? super Integer, Unit> lVar);

    void f(FragmentActivity fragmentActivity, View view, String str, String str2, String str3);

    void h(FragmentActivity fragmentActivity, View view, String str, String str2, String str3, String str4, String str5, int i11, int i12);

    void k(FragmentActivity fragmentActivity, View view, int i11, int i12, String str, String str2, String str3);

    void m(FragmentActivity fragmentActivity, View view, String str, String str2, String str3);

    View q(FragmentActivity fragmentActivity, View view);

    void r(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, String str5, String str6, int i11);
}
