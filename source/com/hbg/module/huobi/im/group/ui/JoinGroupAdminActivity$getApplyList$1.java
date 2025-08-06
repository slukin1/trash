package com.hbg.module.huobi.im.group.ui;

import com.hbg.lib.network.hbg.core.bean.ApplyListBean;
import com.hbg.module.huobi.im.group.ui.adapter.ApplyUserAdapter;
import com.hbg.module.libkt.base.ext.b;
import d10.l;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class JoinGroupAdminActivity$getApplyList$1 extends Lambda implements l<ApplyListBean, Unit> {
    public final /* synthetic */ JoinGroupAdminActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JoinGroupAdminActivity$getApplyList$1(JoinGroupAdminActivity joinGroupAdminActivity) {
        super(1);
        this.this$0 = joinGroupAdminActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ApplyListBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(ApplyListBean applyListBean) {
        JoinGroupAdminActivity.zh(this.this$0).E.finishRefresh();
        JoinGroupAdminActivity.zh(this.this$0).E.w();
        ArrayList<ApplyListBean.ApplyUser> arrayList = null;
        if (b.w(applyListBean != null ? applyListBean.listData : null)) {
            if (this.this$0.f20039i == 1) {
                JoinGroupAdminActivity.zh(this.this$0).E.setVisibility(8);
                JoinGroupAdminActivity.zh(this.this$0).D.setVisibility(0);
                return;
            }
            JoinGroupAdminActivity.zh(this.this$0).E.e();
        } else if (this.this$0.f20039i == 1) {
            ApplyUserAdapter yh2 = this.this$0.f20041k;
            if (yh2 != null) {
                if (applyListBean != null) {
                    arrayList = applyListBean.listData;
                }
                yh2.a(0, arrayList);
            }
        } else {
            ApplyUserAdapter yh3 = this.this$0.f20041k;
            if (yh3 != null) {
                if (applyListBean != null) {
                    arrayList = applyListBean.listData;
                }
                yh3.a(1, arrayList);
            }
            JoinGroupAdminActivity joinGroupAdminActivity = this.this$0;
            joinGroupAdminActivity.f20039i = joinGroupAdminActivity.f20039i + 1;
        }
    }
}
