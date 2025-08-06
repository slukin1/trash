package com.hbg.module.content.ui.fragment;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.module.content.ui.fragment.NewsChildFragment;
import com.hbg.module.libkt.base.ui.BaseFragment;
import d10.p;
import he.a;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsHomeFragment$sendRequest$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ a $adapter;
    public final /* synthetic */ NewsHomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsHomeFragment$sendRequest$2(NewsHomeFragment newsHomeFragment, a aVar) {
        super(2);
        this.this$0 = newsHomeFragment;
        this.$adapter = aVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        BaseFragment baseFragment;
        this.this$0.sh();
        NewsHomeFragment.Vh(this.this$0).I.setAdapter(this.$adapter);
        this.this$0.f18799q.clear();
        ArrayList Uh = this.this$0.f18799q;
        if (this.this$0.f18801s == 1) {
            baseFragment = NewsChildFragment.a.b(NewsChildFragment.H, -1, "7*24", (String) null, 0, 12, (Object) null);
            this.this$0.ei(baseFragment);
        } else {
            baseFragment = DeepNewsChildFragment.f18731x.a(-1);
            this.this$0.ei(baseFragment);
        }
        Uh.add(baseFragment);
        this.$adapter.a(this.this$0.f18799q);
        NewsHomeFragment.Vh(this.this$0).G.finishRefresh();
    }
}
