package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.WatchFansBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.community.adapter.WatchFansAdapter;
import com.hbg.module.libkt.base.ext.VmState;
import com.hbg.module.libkt.base.ext.b;
import d10.l;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class FollowListActivity$initView$2 extends Lambda implements l<VmState<? extends List<? extends WatchFansBean>>, Unit> {
    public final /* synthetic */ FollowListActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FollowListActivity$initView$2(FollowListActivity followListActivity) {
        super(1);
        this.this$0 = followListActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VmState<? extends List<? extends WatchFansBean>>) (VmState) obj);
        return Unit.f56620a;
    }

    public final void invoke(VmState<? extends List<? extends WatchFansBean>> vmState) {
        FollowListActivity.Ah(this.this$0).C.finishRefresh();
        FollowListActivity.Ah(this.this$0).C.w();
        if (vmState instanceof VmState.b) {
            VmState.b bVar = (VmState.b) vmState;
            if (!b.w((Collection) bVar.a())) {
                FollowListActivity.Ah(this.this$0).B.g();
                WatchFansAdapter zh2 = this.this$0.f17429o;
                if (zh2 != null) {
                    zh2.a(this.this$0.f17430p == 1 ? 0 : 1, (List) bVar.a());
                }
                this.this$0.f17426l = ((WatchFansBean) CollectionsKt___CollectionsKt.m0((List) bVar.a())).getFocusTime();
                FollowListActivity followListActivity = this.this$0;
                followListActivity.f17430p = followListActivity.f17430p + 1;
            } else if (this.this$0.f17430p == 1) {
                FollowListActivity.Ah(this.this$0).B.i();
            } else {
                FollowListActivity.Ah(this.this$0).C.e();
            }
        } else if (vmState instanceof VmState.a) {
            APIStatusErrorException a11 = ((VmState.a) vmState).a();
            if (a11 != null) {
                HuobiToastUtil.i(a11.getErrMsg());
            }
            if (this.this$0.f17430p == 1) {
                FollowListActivity.Ah(this.this$0).B.k();
            }
        } else if (this.this$0.f17430p == 1) {
            FollowListActivity.Ah(this.this$0).B.i();
        } else {
            FollowListActivity.Ah(this.this$0).C.e();
        }
    }
}
