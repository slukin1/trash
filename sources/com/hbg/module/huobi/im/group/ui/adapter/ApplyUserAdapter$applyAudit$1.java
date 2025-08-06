package com.hbg.module.huobi.im.group.ui.adapter;

import com.hbg.lib.network.hbg.core.bean.ApplyListBean;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.huobi.im.R$drawable;
import com.hbg.module.huobi.im.R$string;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class ApplyUserAdapter$applyAudit$1 extends Lambda implements l<String, Unit> {
    public final /* synthetic */ int $pos;
    public final /* synthetic */ int $status;
    public final /* synthetic */ ApplyUserAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyUserAdapter$applyAudit$1(ApplyUserAdapter applyUserAdapter, int i11, int i12) {
        super(1);
        this.this$0 = applyUserAdapter;
        this.$pos = i11;
        this.$status = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.f56620a;
    }

    public final void invoke(String str) {
        String str2;
        int i11 = this.$status;
        ((ApplyListBean.ApplyUser) this.this$0.g().get(this.$pos)).status = i11;
        int i12 = R$drawable.icon_check_circle;
        if (i11 == 2) {
            str2 = this.this$0.f().getResources().getString(R$string.n_live_group_already_agree);
        } else {
            str2 = this.this$0.f().getResources().getString(R$string.n_live_group_already_reject);
        }
        HuobiToastUtil.h(i12, str2);
        this.this$0.notifyItemChanged(this.$pos);
    }
}
