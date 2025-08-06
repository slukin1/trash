package com.sumsub.sns.core.presentation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.core.presentation.base.a.l;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.internal.core.common.SNSSession;
import com.sumsub.sns.internal.core.common.b0;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.data.model.o;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.i;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlinx.coroutines.flow.f;

public abstract class a<S extends a.l, VM extends com.sumsub.sns.core.presentation.base.a<S>> extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    public final i f30757a = LazyKt__LazyJVMKt.a(new e(this));

    /* renamed from: b  reason: collision with root package name */
    public boolean f30758b;

    /* renamed from: c  reason: collision with root package name */
    public final C0279a f30759c = new C0279a(this);

    /* renamed from: com.sumsub.sns.core.presentation.a$a  reason: collision with other inner class name */
    public static final class C0279a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a<S, VM> f30760a;

        public C0279a(a<S, VM> aVar) {
            this.f30760a = aVar;
        }

        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (x.b(intent != null ? intent.getAction() : null, n0.f.f32173d)) {
                com.sumsub.log.logger.a.a(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(this), "ACTION_CLOSE received. Finishing...", (Throwable) null, 4, (Object) null);
                this.f30760a.j();
            }
        }
    }

    public /* synthetic */ class b extends AdaptedFunctionReference implements p<a.j, kotlin.coroutines.c<? super Unit>, Object> {
        public b(Object obj) {
            super(2, obj, a.class, "handleEvent", "handleEvent(Lcom/sumsub/sns/core/presentation/base/SNSViewModel$SNSViewModelEvent;)V", 4);
        }

        /* renamed from: a */
        public final Object invoke(a.j jVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((a) this.receiver).a(jVar);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.BaseActivity$onCreate$4", f = "BaseActivity.kt", l = {}, m = "invokeSuspend")
    public static final class c extends SuspendLambda implements p<a.k, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f30761a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f30762b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a<S, VM> f30763c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TextView f30764d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bundle f30765e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a<S, VM> aVar, TextView textView, Bundle bundle, kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
            this.f30763c = aVar;
            this.f30764d = textView;
            this.f30765e = bundle;
        }

        /* renamed from: a */
        public final Object invoke(a.k kVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((c) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            c cVar2 = new c(this.f30763c, this.f30764d, this.f30765e, cVar);
            cVar2.f30762b = obj;
            return cVar2;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f30761a == 0) {
                k.b(obj);
                a.k kVar = (a.k) this.f30762b;
                this.f30763c.b(kVar.g());
                TextView e11 = this.f30763c.e();
                if (e11 != null) {
                    com.sumsub.sns.internal.core.common.i.a(e11, kVar.h());
                }
                TextView textView = this.f30764d;
                if (textView != null) {
                    com.sumsub.sns.internal.core.common.i.a(textView, kVar.i());
                }
                if (this.f30763c.i() != kVar.j()) {
                    this.f30763c.f30758b = kVar.j();
                    this.f30763c.a(this.f30765e);
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public /* synthetic */ class d extends AdaptedFunctionReference implements p<S, kotlin.coroutines.c<? super Unit>, Object> {
        public d(Object obj) {
            super(2, obj, a.class, "handleState", "handleState(Lcom/sumsub/sns/core/presentation/base/SNSViewModel$SNSViewModelState;)V", 4);
        }

        /* renamed from: a */
        public final Object invoke(S s11, kotlin.coroutines.c<? super Unit> cVar) {
            return ((a) this.receiver).a(s11);
        }
    }

    public static final class e extends Lambda implements d10.a<com.sumsub.sns.internal.core.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a<S, VM> f30766a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(a<S, VM> aVar) {
            super(0);
            this.f30766a = aVar;
        }

        /* renamed from: a */
        public final com.sumsub.sns.internal.core.a invoke() {
            return com.sumsub.sns.internal.core.a.f31823z.a(this.f30766a.getApplicationContext(), this.f30766a.g());
        }
    }

    public void a(Bundle bundle) {
    }

    public void a(S s11) {
    }

    public void a(o oVar, String str, CharSequence charSequence) {
    }

    public abstract int d();

    public TextView e() {
        return (TextView) findViewById(R.id.sns_powered);
    }

    public final com.sumsub.sns.internal.core.a f() {
        return (com.sumsub.sns.internal.core.a) this.f30757a.getValue();
    }

    public final SNSSession g() {
        return (SNSSession) getIntent().getParcelableExtra("sns_extra_session");
    }

    public abstract VM h();

    public final boolean i() {
        return this.f30758b;
    }

    public abstract void j();

    public void onCreate(Bundle bundle) {
        Integer a11;
        if (e0.f32018a.isDebug()) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String a12 = com.sumsub.sns.internal.log.c.a(this);
            com.sumsub.log.logger.a.d(aVar, a12, getClass().getSimpleName() + ".onCreate", (Throwable) null, 4, (Object) null);
        }
        if (bundle != null && bundle.containsKey("sns_extra_session")) {
            Parcelable parcelable = bundle.getParcelable("sns_extra_session");
            SNSSession sNSSession = parcelable instanceof SNSSession ? (SNSSession) parcelable : null;
            if (sNSSession != null) {
                getIntent().putExtra("sns_extra_session", sNSSession);
            }
        }
        f().F().a(g().getSessionId());
        Integer theme = f().E().getTheme();
        setTheme(theme != null ? theme.intValue() : R.style.Theme_SNSCore);
        super.onCreate(bundle);
        setContentView(d());
        com.sumsub.sns.core.presentation.helper.a aVar2 = com.sumsub.sns.core.presentation.helper.a.f31095a;
        com.sumsub.sns.internal.core.theme.d a13 = aVar2.a();
        if (!(a13 == null || (a11 = aVar2.a(a13, SNSColorElement.STATUS_BAR_COLOR, com.sumsub.sns.internal.core.common.i.a(getResources().getConfiguration()))) == null)) {
            int intValue = a11.intValue();
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(intValue);
        }
        b0.a(h().g(), (LifecycleOwner) this, new b(this));
        b0.b(h().i(), (LifecycleOwner) this, new c(this, (TextView) findViewById(R.id.sns_progress_text), bundle, (kotlin.coroutines.c<? super c>) null));
        b0.b(f.y(h().j()), (LifecycleOwner) this, new d(this));
    }

    public void onDestroy() {
        if (e0.f32018a.isDebug()) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String a11 = com.sumsub.sns.internal.log.c.a(this);
            com.sumsub.log.logger.a.d(aVar, a11, getClass().getSimpleName() + ".onDestroy", (Throwable) null, 4, (Object) null);
        }
        super.onDestroy();
    }

    public void onPause() {
        unregisterReceiver(this.f30759c);
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        ContextCompat.registerReceiver(this, this.f30759c, new IntentFilter(n0.f.f32173d), 4);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("sns_extra_session", f().E());
    }

    public void b(boolean z11) {
        TextView textView = (TextView) findViewById(R.id.sns_powered);
        if (textView != null) {
            com.sumsub.sns.internal.core.common.i.a((View) textView, z11);
        }
    }

    public void a(a.j jVar) {
        if (jVar instanceof a.d) {
            a.d dVar = (a.d) jVar;
            a(dVar.e(), dVar.f(), dVar.d());
        }
    }
}
