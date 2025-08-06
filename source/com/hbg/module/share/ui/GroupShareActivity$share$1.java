package com.hbg.module.share.ui;

import android.os.Handler;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.share.R$string;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import wf.a;
import wf.b;

public final class GroupShareActivity$share$1 extends Lambda implements l<Object, Unit> {
    public final /* synthetic */ GroupShareActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GroupShareActivity$share$1(GroupShareActivity groupShareActivity) {
        super(1);
        this.this$0 = groupShareActivity;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(GroupShareActivity groupShareActivity) {
        b g11 = a.f40622a.g();
        if (g11 != null) {
            g11.a(0, "");
        }
        groupShareActivity.finish();
    }

    public final void invoke(Object obj) {
        this.this$0.Df();
        HuobiToastUtil.g(R$string.n_content_share_sent);
        Handler zh2 = this.this$0.Zf();
        if (zh2 != null) {
            zh2.postDelayed(new b(this.this$0), 1000);
        }
    }
}
