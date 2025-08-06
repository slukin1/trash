package com.hbg.module.content.ui.activity.live;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import cf.b;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "com.hbg.module.content.ui.activity.live.LiveDetailActivity$shareLive$1$1", f = "LiveDetailActivity.kt", l = {}, m = "invokeSuspend")
public final class LiveDetailActivity$shareLive$1$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ LiveDetailBean $this_run;
    public int label;
    public final /* synthetic */ LiveDetailActivity this$0;

    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailActivity f18586a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18587b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f18588c;

        public a(LiveDetailActivity liveDetailActivity, View view, LiveDetailBean liveDetailBean) {
            this.f18586a = liveDetailActivity;
            this.f18587b = view;
            this.f18588c = liveDetailBean;
        }

        public void a(boolean z11) {
            this.f18586a.Uk(this.f18587b, this.f18588c);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveDetailActivity$shareLive$1$1(LiveDetailActivity liveDetailActivity, LiveDetailBean liveDetailBean, c<? super LiveDetailActivity$shareLive$1$1> cVar) {
        super(2, cVar);
        this.this$0 = liveDetailActivity;
        this.$this_run = liveDetailBean;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new LiveDetailActivity$shareLive$1$1(this.this$0, this.$this_run, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((LiveDetailActivity$shareLive$1$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            String str = null;
            View inflate = LayoutInflater.from(this.this$0).inflate(R$layout.live_share_view, (ViewGroup) null);
            cf.a aVar = cf.a.f26395a;
            ImageView imageView = (ImageView) inflate.findViewById(R$id.ivAvatar);
            LiveSpeaker Ri = this.this$0.f18455f0;
            if (Ri != null) {
                str = Ri.avatar;
            }
            aVar.b(imageView, str, new a(this.this$0, inflate, this.$this_run), true);
            return Unit.f56620a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
