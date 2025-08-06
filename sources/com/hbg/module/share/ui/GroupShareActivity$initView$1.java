package com.hbg.module.share.ui;

import android.os.Handler;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.hbg.lib.network.hbg.core.bean.ShareGroupList;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.share.R$string;
import d10.l;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import xf.c;

public final class GroupShareActivity$initView$1 extends Lambda implements l<ShareGroupList, Unit> {
    public final /* synthetic */ GroupShareActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GroupShareActivity$initView$1(GroupShareActivity groupShareActivity) {
        super(1);
        this.this$0 = groupShareActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ShareGroupList) obj);
        return Unit.f56620a;
    }

    public final void invoke(ShareGroupList shareGroupList) {
        if (b.w(shareGroupList != null ? shareGroupList.getShared() : null)) {
            HuobiToastUtil.g(R$string.n_im_no_group_chat);
            return;
        }
        GroupShareActivity.yh(this.this$0).E.setLayoutManager(b.t(this.this$0));
        GroupShareActivity groupShareActivity = this.this$0;
        groupShareActivity.Hh(new c(groupShareActivity));
        GroupShareActivity.yh(this.this$0).E.setAdapter(this.this$0.Eh());
        c Eh = this.this$0.Eh();
        if (Eh != null) {
            Eh.a(0, shareGroupList.getShared());
        }
        c Eh2 = this.this$0.Eh();
        if (Eh2 != null) {
            final GroupShareActivity groupShareActivity2 = this.this$0;
            Eh2.s(new p<Boolean, Integer, Unit>() {
                /* access modifiers changed from: private */
                public static final void invoke$lambda$0(GroupShareActivity groupShareActivity, int i11) {
                    int findFirstVisibleItemPosition = ((LinearLayoutManager) GroupShareActivity.yh(groupShareActivity).E.getLayoutManager()).findFirstVisibleItemPosition();
                    int findLastVisibleItemPosition = ((LinearLayoutManager) GroupShareActivity.yh(groupShareActivity).E.getLayoutManager()).findLastVisibleItemPosition();
                    if (i11 < findFirstVisibleItemPosition || i11 > findLastVisibleItemPosition) {
                        GroupShareActivity.yh(groupShareActivity).E.scrollToPosition(i11);
                    }
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke(((Boolean) obj).booleanValue(), ((Number) obj2).intValue());
                    return Unit.f56620a;
                }

                public final void invoke(boolean z11, int i11) {
                    GroupShareActivity.yh(groupShareActivity2).B.setVisibility(z11 ? 0 : 8);
                    Handler zh2 = groupShareActivity2.Zf();
                    if (zh2 != null) {
                        zh2.postDelayed(new a(groupShareActivity2, i11), 200);
                    }
                }
            });
        }
    }
}
