package com.huobi.asset2.index.util;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.SP;
import d10.a;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

final class EarnGuideHelper$showEarnGuide$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ FragmentActivity $activity;
    public final /* synthetic */ View $setUp2;
    public final /* synthetic */ String $uid;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EarnGuideHelper$showEarnGuide$1(FragmentActivity fragmentActivity, View view, String str) {
        super(0);
        this.$activity = fragmentActivity;
        this.$setUp2 = view;
        this.$uid = str;
    }

    public final void invoke() {
        d dVar = d.f42776a;
        FragmentActivity fragmentActivity = this.$activity;
        View view = this.$setUp2;
        final String str = this.$uid;
        dVar.d(fragmentActivity, view, new a<Unit>() {
            public final void invoke() {
                SP.y("earn_guide_key" + str, true);
            }
        });
    }
}
