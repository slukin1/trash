package com.sumsub.sns.presentation.screen;

import android.content.Intent;
import android.net.Uri;
import android.nfc.tech.IsoDep;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.n0;
import androidx.lifecycle.v;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.sumsub.sns.R;
import com.sumsub.sns.core.SNSMobileSDK;
import com.sumsub.sns.core.data.listener.SNSUrlHandler;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.data.model.SNSLivenessReason;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.core.widget.SNSProgressView;
import com.sumsub.sns.internal.core.common.NetworkManager;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.k0;
import com.sumsub.sns.internal.core.common.l0;
import com.sumsub.sns.internal.core.common.m1;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.common.t0;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.o;
import com.sumsub.sns.internal.core.data.model.s;
import com.sumsub.sns.internal.core.data.source.applicant.remote.w;
import com.sumsub.sns.internal.core.data.source.applicant.remote.y;
import com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType;
import com.sumsub.sns.presentation.screen.b;
import com.sumsub.sns.presentation.screen.d;
import com.sumsub.sns.presentation.screen.questionnary.SNSQuestionnaireFragment;
import com.sumsub.sns.prooface.presentation.SNSLiveness3dFaceFragment;
import com.sumsub.sns.videoident.presentation.SNSVideoIdentFragment;
import d10.l;
import d10.p;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

@Metadata(bv = {}, d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0001\rB\u0007¢\u0006\u0004\bd\u0010eJ\"\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\bH\u0002J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\bH\u0002J\b\u0010\u001d\u001a\u00020\fH\u0002J\b\u0010\u001e\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020\bH\u0002J\u001a\u0010#\u001a\u00020\b2\u0006\u0010!\u001a\u00020 2\b\u0010\u0012\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010&\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010$H\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u0002H\u0014J$\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010(\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010+\u001a\u00020 H\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020,H\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010.\u001a\u00020-H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u00100\u001a\u00020/H\u0016J\b\u00101\u001a\u00020\fH\u0014J\b\u00102\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u00104\u001a\u000203H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u00105\u001a\u00020\bH\u0016J\b\u00106\u001a\u00020\fH\u0014J!\u0010\r\u001a\u00020\f2\u0006\u00108\u001a\u0002072\b\u0010:\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0004\b\r\u0010;J\b\u0010<\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010=\u001a\u00020\n2\u0006\u0010.\u001a\u00020\nH\u0016J\u0012\u0010@\u001a\u00020\f2\b\u0010?\u001a\u0004\u0018\u00010>H\u0014J\u001c\u0010\r\u001a\u00020\f2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\f0AH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0016J*\u0010\r\u001a\u00020\f2\u0006\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020 2\u0006\u0010(\u001a\u00020\n2\b\u0010=\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010H\u001a\u00020G2\b\u0010J\u001a\u0004\u0018\u00010IH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010K\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016R\u001b\u0010O\u001a\u00020\u00038TX\u0002¢\u0006\f\n\u0004\b+\u0010L\u001a\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010W\u001a\u00020T8\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010[\u001a\u00020X8\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u001e\u0010_\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\\8BX\u0004¢\u0006\u0006\u001a\u0004\b]\u0010^R\u0014\u0010c\u001a\u00020`8BX\u0004¢\u0006\u0006\u001a\u0004\ba\u0010b¨\u0006g"}, d2 = {"Lcom/sumsub/sns/presentation/screen/SNSAppActivity;", "Lcom/sumsub/sns/core/presentation/a;", "Lcom/sumsub/sns/presentation/screen/d$d;", "Lcom/sumsub/sns/presentation/screen/d;", "Lcom/sumsub/sns/internal/core/common/k0;", "Lcom/sumsub/sns/internal/core/common/l0;", "Lcom/sumsub/sns/internal/core/presentation/intro/f;", "stepInfo", "", "cancelOnBackPressed", "", "countryCode", "", "a", "Lcom/sumsub/sns/internal/core/data/model/o;", "error", "c", "Lcom/sumsub/sns/presentation/screen/b$d;", "event", "r", "s", "Landroidx/fragment/app/Fragment;", "fragment", "tag", "allowStateLoss", "addToBackStack", "b", "q", "isCancelled", "k", "l", "p", "", "keyCode", "Landroid/view/KeyEvent;", "onKeyDown", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "state", "idDocSetType", "", "buttonText", "d", "Lcom/sumsub/sns/core/presentation/base/a$j;", "Lcom/sumsub/sns/internal/core/data/model/DocumentType;", "documentType", "Lcom/sumsub/sns/internal/core/data/model/s;", "mrtd", "onResume", "onPause", "Lcom/sumsub/sns/internal/core/data/model/Document;", "document", "show", "j", "Lcom/sumsub/sns/internal/core/common/q;", "reason", "", "delay", "(Lcom/sumsub/sns/internal/core/common/q;Ljava/lang/Long;)V", "onBackPressed", "requestKey", "Landroid/content/Intent;", "intent", "onNewIntent", "Lkotlin/Function1;", "Landroid/nfc/tech/IsoDep;", "callback", "Ljava/io/File;", "file", "rotation", "Lcom/sumsub/sns/internal/core/domain/model/c;", "introParams", "Landroid/os/Parcelable;", "payload", "url", "Lkotlin/i;", "o", "()Lcom/sumsub/sns/presentation/screen/d;", "viewModel", "Lcom/sumsub/sns/core/widget/SNSProgressView;", "e", "Lcom/sumsub/sns/core/widget/SNSProgressView;", "vgProgress", "Lcom/sumsub/sns/internal/nfc/d;", "f", "Lcom/sumsub/sns/internal/nfc/d;", "nfcManager", "Lcom/sumsub/sns/internal/core/common/NetworkManager;", "g", "Lcom/sumsub/sns/internal/core/common/NetworkManager;", "networkManager", "Lcom/sumsub/sns/core/presentation/b;", "m", "()Lcom/sumsub/sns/core/presentation/b;", "currentFragment", "Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", "n", "()Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", "currentFragmentCompletionResult", "<init>", "()V", "h", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSAppActivity extends com.sumsub.sns.core.presentation.a<d.C0526d, d> implements k0, l0 {

    /* renamed from: h  reason: collision with root package name */
    public static final a f39563h = new a((r) null);

    /* renamed from: i  reason: collision with root package name */
    public static final String f39564i = "instructions_request_key_internal";

    /* renamed from: d  reason: collision with root package name */
    public final i f39565d = new n0(Reflection.b(d.class), new d(this), new g(this), new e((d10.a) null, this));

    /* renamed from: e  reason: collision with root package name */
    public SNSProgressView f39566e;

    /* renamed from: f  reason: collision with root package name */
    public final com.sumsub.sns.internal.nfc.d f39567f = new com.sumsub.sns.internal.nfc.d();

    /* renamed from: g  reason: collision with root package name */
    public final NetworkManager f39568g = new NetworkManager();

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppActivity$showFragment$1", f = "SNSAppActivity.kt", l = {}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39569a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSAppActivity f39570b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f39571c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Fragment f39572d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SNSAppActivity sNSAppActivity, String str, Fragment fragment, kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
            this.f39570b = sNSAppActivity;
            this.f39571c = str;
            this.f39572d = fragment;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new b(this.f39570b, this.f39571c, this.f39572d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f39569a == 0) {
                k.b(obj);
                try {
                    this.f39570b.getSupportFragmentManager().i0();
                } catch (IllegalStateException e11) {
                    com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
                    com.sumsub.sns.core.c.a(cVar, d.P, "Fragment with tag = " + this.f39571c + " is already added", (Throwable) null, 4, (Object) null);
                    if (e0.f32018a.isDebug()) {
                        throw e11;
                    }
                }
                Fragment m02 = this.f39570b.getSupportFragmentManager().m0(this.f39571c);
                boolean z11 = true;
                if (m02 == null || !m02.isAdded()) {
                    z11 = false;
                }
                if (z11) {
                    com.sumsub.sns.core.c cVar2 = com.sumsub.sns.core.c.f30748a;
                    com.sumsub.sns.core.c.b(cVar2, d.P, "Fragment with tag = " + this.f39571c + " is already added", (Throwable) null, 4, (Object) null);
                    return Unit.f56620a;
                }
                FragmentManager supportFragmentManager = this.f39570b.getSupportFragmentManager();
                Fragment fragment = this.f39572d;
                String str = this.f39571c;
                FragmentTransaction q11 = supportFragmentManager.q();
                q11.c(R.id.sns_container, fragment, str);
                q11.h(str);
                q11.j();
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class c extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ComponentActivity f39573a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ComponentActivity componentActivity) {
            super(0);
            this.f39573a = componentActivity;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            return this.f39573a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class d extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ComponentActivity f39574a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
            super(0);
            this.f39574a = componentActivity;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return this.f39574a.getViewModelStore();
        }
    }

    public static final class e extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f39575a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ComponentActivity f39576b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d10.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f39575a = aVar;
            this.f39576b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d10.a r0 = r1.f39575a
                if (r0 == 0) goto L_0x000c
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x0012
            L_0x000c:
                androidx.activity.ComponentActivity r0 = r1.f39576b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
            L_0x0012:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.SNSAppActivity.e.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    public static final class f extends Lambda implements l<NetworkManager.NetworkType, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SNSAppActivity f39577a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(SNSAppActivity sNSAppActivity) {
            super(1);
            this.f39577a = sNSAppActivity;
        }

        public final void a(NetworkManager.NetworkType networkType) {
            this.f39577a.h().c(networkType.getType());
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((NetworkManager.NetworkType) obj);
            return Unit.f56620a;
        }
    }

    public static final class g extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SNSAppActivity f39578a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(SNSAppActivity sNSAppActivity) {
            super(0);
            this.f39578a = sNSAppActivity;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            SNSAppActivity sNSAppActivity = this.f39578a;
            return new e(sNSAppActivity, sNSAppActivity.f(), (Bundle) null, 4, (r) null);
        }
    }

    public static final void b(SNSAppActivity sNSAppActivity, String str, Bundle bundle) {
        if (com.sumsub.sns.core.presentation.b.Companion.b(bundle)) {
            if ((sNSAppActivity.m() instanceof com.sumsub.sns.presentation.screen.intro.a) && !sNSAppActivity.p()) {
                sNSAppActivity.getSupportFragmentManager().j1();
            }
            sNSAppActivity.h().c(true);
            return;
        }
        sNSAppActivity.h().c(false);
    }

    public final void c(o oVar) {
        for (Fragment fragment : getSupportFragmentManager().B0()) {
            com.sumsub.sns.core.presentation.b bVar = fragment instanceof com.sumsub.sns.core.presentation.b ? (com.sumsub.sns.core.presentation.b) fragment : null;
            if (bVar != null) {
                bVar.onHandleError(oVar);
            }
        }
    }

    public int d() {
        return R.layout.sns_activity_app;
    }

    public void j() {
        h().a(n(), true);
    }

    public final void k() {
        if (getSupportFragmentManager().u0() == 1) {
            h().a(true, false);
        }
    }

    public final void l() {
        if (!p()) {
            getSupportFragmentManager().l1((String) null, 1);
        }
    }

    public final com.sumsub.sns.core.presentation.b<?, ?> m() {
        Fragment l02 = getSupportFragmentManager().l0(R.id.sns_container);
        if (l02 instanceof com.sumsub.sns.core.presentation.b) {
            return (com.sumsub.sns.core.presentation.b) l02;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.onCancelResult();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.sumsub.sns.core.data.model.SNSCompletionResult n() {
        /*
            r3 = this;
            com.sumsub.sns.core.presentation.b r0 = r3.m()
            if (r0 == 0) goto L_0x000c
            com.sumsub.sns.core.data.model.SNSCompletionResult r0 = r0.onCancelResult()
            if (r0 != 0) goto L_0x0013
        L_0x000c:
            com.sumsub.sns.core.data.model.SNSCompletionResult$SuccessTermination r0 = new com.sumsub.sns.core.data.model.SNSCompletionResult$SuccessTermination
            r1 = 1
            r2 = 0
            r0.<init>(r2, r1, r2)
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.SNSAppActivity.n():com.sumsub.sns.core.data.model.SNSCompletionResult");
    }

    /* renamed from: o */
    public d h() {
        return (d) this.f39565d.getValue();
    }

    public void onBackPressed() {
        com.sumsub.sns.core.c.b(com.sumsub.sns.core.c.f30748a, c.f39604a, "onBackPressed()", (Throwable) null, 4, (Object) null);
        com.sumsub.sns.core.presentation.b<?, ?> m11 = m();
        if (m11 == null) {
            h().a(n(), false);
        } else if (m11.onFinishCalled(q.c.f32251b)) {
            k();
            a(false);
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.sumsub.sns.core.c.b(com.sumsub.sns.core.c.f30748a, d.P, SNSMobileSDK.INSTANCE.toString(), (Throwable) null, 4, (Object) null);
        this.f39566e = (SNSProgressView) findViewById(R.id.sns_progress);
        getSupportFragmentManager().H1(com.sumsub.sns.geo.presentation.a.f31275s, this, new i(this));
        getSupportFragmentManager().H1(f39564i, this, new j(this));
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        Boolean onKeyDown;
        com.sumsub.sns.core.presentation.b<?, ?> m11 = m();
        t0 t0Var = m11 instanceof t0 ? (t0) m11 : null;
        if (t0Var == null || (onKeyDown = t0Var.onKeyDown(i11, keyEvent)) == null) {
            return super.onKeyDown(i11, keyEvent);
        }
        return onKeyDown.booleanValue();
    }

    public void onNewIntent(Intent intent) {
        com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
        com.sumsub.sns.core.c.b(cVar, d.P, "onNewIntent = " + intent, (Throwable) null, 4, (Object) null);
        super.onNewIntent(intent);
        this.f39567f.a(intent);
    }

    public void onPause() {
        super.onPause();
        s();
    }

    public void onResume() {
        super.onResume();
        r();
    }

    public final boolean p() {
        return isFinishing() || isDestroyed() || getSupportFragmentManager().W0();
    }

    public final void q() {
        l();
        d.a(h(), false, 1, (Object) null);
    }

    public final void r() {
        this.f39568g.a(getApplicationContext(), (l<? super NetworkManager.NetworkType, Unit>) new f(this));
    }

    public final void s() {
        this.f39568g.c();
    }

    public void a(d.C0526d dVar) {
        SNSProgressView sNSProgressView;
        if (dVar.j() && (sNSProgressView = this.f39566e) != null) {
            sNSProgressView.setText(dVar.h());
        }
        if (dVar.f()) {
            SNSProgressView sNSProgressView2 = this.f39566e;
            if (sNSProgressView2 != null) {
                sNSProgressView2.setText(dVar.g());
            }
        } else if (dVar.i() == null) {
        } else {
            if (dVar.i().booleanValue()) {
                SNSProgressView sNSProgressView3 = this.f39566e;
                if (sNSProgressView3 != null) {
                    com.sumsub.sns.internal.core.common.i.e((View) sNSProgressView3);
                    return;
                }
                return;
            }
            SNSProgressView sNSProgressView4 = this.f39566e;
            if (sNSProgressView4 != null) {
                sNSProgressView4.setText(dVar.h());
            }
            SNSProgressView sNSProgressView5 = this.f39566e;
            if (sNSProgressView5 != null) {
                com.sumsub.sns.internal.core.common.i.c((View) sNSProgressView5);
            }
        }
    }

    public final void c(boolean z11) {
        h().r();
        l();
        d.a(h(), z11, false, 2, (Object) null);
    }

    public final void b(Fragment fragment, String str) {
        com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
        com.sumsub.sns.core.c.b(cVar, d.P, "ShowFragment, tag = " + str, (Throwable) null, 4, (Object) null);
        a(false);
        n1 unused = kotlinx.coroutines.i.d(v.a(this), v0.c().G(), (CoroutineStart) null, new b(this, str, fragment, (kotlin.coroutines.c<? super b>) null), 2, (Object) null);
    }

    public void c() {
        com.sumsub.sns.core.c.b(com.sumsub.sns.core.c.f30748a, d.P, "Stop listening NFC", (Throwable) null, 4, (Object) null);
        this.f39567f.a();
    }

    public void b(o oVar) {
        for (Fragment fragment : getSupportFragmentManager().B0()) {
            com.sumsub.sns.core.presentation.b bVar = fragment instanceof com.sumsub.sns.core.presentation.b ? (com.sumsub.sns.core.presentation.b) fragment : null;
            if (bVar != null) {
                bVar.onErrorCancelled(oVar);
            }
        }
    }

    public final void a(com.sumsub.sns.internal.core.presentation.intro.f fVar, boolean z11, String str) {
        com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
        com.sumsub.sns.core.c.b(cVar, d.P, "showInstructions: " + fVar, (Throwable) null, 4, (Object) null);
        a(this, com.sumsub.sns.presentation.screen.intro.a.f39800c.a(fVar.c(), fVar.b(), fVar.a(), z11, str).forResult(f39564i), com.sumsub.sns.presentation.screen.intro.a.f39802e, false, false, 12, (Object) null);
    }

    public void b() {
        h().a((SNSCompletionResult) new SNSCompletionResult.SuccessTermination((SNSLivenessReason) null, 1, (r) null), false);
    }

    public void a(o oVar, String str, CharSequence charSequence) {
        c();
        if (oVar == null) {
            return;
        }
        if (oVar instanceof o.f) {
            com.sumsub.sns.presentation.screen.error.a.f39769a.a(((o.f) oVar).d(), charSequence).show(getSupportFragmentManager(), com.sumsub.sns.presentation.screen.error.a.f39770b);
        } else {
            b(com.sumsub.sns.presentation.screen.error.b.f39773i.a(oVar, str), com.sumsub.sns.presentation.screen.error.b.f39775k);
        }
    }

    public final void a(b.d dVar) {
        b.d dVar2 = dVar;
        com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
        com.sumsub.sns.core.c.b(cVar, d.P, "Navigate to: " + dVar2, (Throwable) null, 4, (Object) null);
        if (dVar2 instanceof b.d.o) {
            a(this, SNSVideoIdentFragment.Companion.create(((b.d.o) dVar2).e()), SNSVideoIdentFragment.TAG, false, false, 12, (Object) null);
        } else if (dVar2 instanceof b.d.i) {
            a(this, com.sumsub.sns.presentation.screen.preview.photo.identity.a.A.a(((b.d.i) dVar2).e()), com.sumsub.sns.presentation.screen.preview.photo.identity.a.D, false, false, 12, (Object) null);
        } else if (dVar2 instanceof b.d.l) {
            a(this, com.sumsub.sns.presentation.screen.preview.selfie.a.f40071k.a(((b.d.l) dVar2).e()), com.sumsub.sns.presentation.screen.preview.selfie.a.f40075o, false, false, 12, (Object) null);
        } else if (dVar2 instanceof b.d.C0523b) {
            a(this, com.sumsub.sns.presentation.screen.preview.applicantdata.a.f39816g.a(((b.d.C0523b) dVar2).e()), com.sumsub.sns.presentation.screen.preview.applicantdata.a.f39819j, false, false, 12, (Object) null);
        } else if (dVar2 instanceof b.d.k) {
            a(this, com.sumsub.sns.presentation.screen.preview.photo.common.a.f39952z.a(((b.d.k) dVar2).e()), com.sumsub.sns.presentation.screen.preview.photo.common.a.B, false, false, 12, (Object) null);
        } else if (dVar2 instanceof b.d.j) {
            a(this, com.sumsub.sns.presentation.screen.preview.photo.common.a.f39952z.a(((b.d.j) dVar2).e()), com.sumsub.sns.presentation.screen.preview.photo.common.a.B, false, false, 12, (Object) null);
        } else if (dVar2 instanceof b.d.m) {
            a(this, com.sumsub.sns.presentation.screen.preview.photo.common.a.f39952z.a(((b.d.m) dVar2).e()), com.sumsub.sns.presentation.screen.preview.photo.common.a.B, false, false, 12, (Object) null);
        } else if (dVar2 instanceof b.d.g) {
            a(this, com.sumsub.sns.geo.presentation.a.f31272p.a(((b.d.g) dVar2).e()), com.sumsub.sns.geo.presentation.a.f31274r, false, false, 12, (Object) null);
        } else if (dVar2 instanceof b.d.C0524d) {
            a(this, com.sumsub.sns.core.presentation.screen.verification.a.f31123p.a(ValidationIdentifierType.EMAIL), com.sumsub.sns.core.presentation.screen.verification.a.f31125r, true, false, 8, (Object) null);
        } else if (dVar2 instanceof b.d.e) {
            a(this, com.sumsub.sns.core.presentation.screen.verification.a.f31123p.a(ValidationIdentifierType.PHONE), com.sumsub.sns.core.presentation.screen.verification.a.f31125r, true, false, 8, (Object) null);
        } else if (dVar2 instanceof b.d.n) {
            a(this, SNSQuestionnaireFragment.Companion.newInstance$default(SNSQuestionnaireFragment.f40102f, ((b.d.n) dVar2).e().getType().c(), (w) null, (y) null, (com.sumsub.sns.internal.core.presentation.form.model.d) null, 14, (Object) null), SNSQuestionnaireFragment.f40104h, true, false, 8, (Object) null);
        } else if (dVar2 instanceof b.d.c) {
            if (getSupportFragmentManager().m0(com.sumsub.sns.presentation.screen.verification.a.f40123k) != null) {
                l();
                return;
            }
            a(this, com.sumsub.sns.presentation.screen.verification.a.f40121i.a(), com.sumsub.sns.presentation.screen.verification.a.f40123k, false, false, 4, (Object) null);
        } else if (dVar2 instanceof b.d.h) {
            a(this, SNSLiveness3dFaceFragment.f40279a.newInstance(((b.d.h) dVar2).e().getType()), (String) null, false, false, 14, (Object) null);
        } else if (dVar2 instanceof b.d.f) {
            a(this, com.sumsub.sns.presentation.screen.preview.ekyc.a.f39836u.a(((b.d.f) dVar2).e()), com.sumsub.sns.presentation.screen.preview.ekyc.a.f39840y, false, false, 12, (Object) null);
        } else if (dVar2 instanceof b.d.a) {
            a(this, com.sumsub.sns.presentation.consent.a.f39523j.a(), com.sumsub.sns.presentation.consent.a.f39525l, false, false, 12, (Object) null);
        }
    }

    public static /* synthetic */ void a(SNSAppActivity sNSAppActivity, Fragment fragment, String str, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        if ((i11 & 8) != 0) {
            z12 = true;
        }
        sNSAppActivity.a(fragment, str, z11, z12);
    }

    public final void a(Fragment fragment, String str, boolean z11, boolean z12) {
        com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
        com.sumsub.sns.core.c.b(cVar, d.P, "ReplaceFragment, tag = " + str, (Throwable) null, 4, (Object) null);
        FragmentTransaction q11 = getSupportFragmentManager().q();
        q11.u(R.id.sns_container, fragment, str);
        if (z12) {
            q11.h(str);
        }
        if (z11) {
            q11.k();
        } else {
            q11.j();
        }
    }

    public void a() {
        h().e(true);
    }

    public void a(a.j jVar) {
        com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
        com.sumsub.sns.core.c.b(cVar, d.P, "event: " + jVar, (Throwable) null, 4, (Object) null);
        super.a(jVar);
        if (jVar instanceof b.d) {
            a((b.d) jVar);
        } else if (jVar instanceof b.c) {
            c(((b.c) jVar).b());
        } else if (jVar instanceof b.C0521b) {
            f().b();
            finish();
        } else if (jVar instanceof b.e) {
            b.e eVar = (b.e) jVar;
            a(eVar.f(), eVar.d(), eVar.e());
        } else if (jVar instanceof a.e) {
            m1.b(this, ((a.e) jVar).f(), (Long) null, 2, (Object) null);
        } else if (jVar instanceof b.a) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Bundle bundle = new Bundle();
            b.a aVar = (b.a) jVar;
            bundle.putInt(com.sumsub.sns.core.presentation.b.FRAGMENT_RESULT_KEY, aVar.d() ? -1 : 0);
            bundle.putParcelable("payload", aVar.c());
            Unit unit = Unit.f56620a;
            supportFragmentManager.G1(com.sumsub.sns.internal.core.common.n0.f32116d, bundle);
        }
    }

    public void a(DocumentType documentType) {
        h().b(documentType);
        q();
    }

    public void a(s sVar) {
        com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
        com.sumsub.sns.core.c.b(cVar, d.P, "NFC is enabled. Show MRTD reading screen " + sVar, (Throwable) null, 4, (Object) null);
        String k11 = sVar.k();
        String i11 = sVar.i();
        String n11 = sVar.n();
        if (k11 != null && i11 != null && n11 != null) {
            a(this, com.sumsub.sns.presentation.screen.preview.photo.mrtd.a.f40025p.a(sVar.h(), sVar.j().getType().c(), k11, i11, n11, sVar.m(), sVar.l()), com.sumsub.sns.presentation.screen.preview.photo.mrtd.a.f40028s, false, false, 12, (Object) null);
        }
    }

    public void a(Document document) {
        h().b(document);
    }

    public void a(o oVar) {
        h().b(oVar);
    }

    public void a(boolean z11) {
        h().g(z11);
    }

    public void a(q qVar, Long l11) {
        if (l11 != null) {
            h().a(qVar, l11.longValue());
        } else if (qVar instanceof q.c) {
            if (getSupportFragmentManager().u0() <= 0 || p()) {
                h().a(n(), false);
                return;
            }
            k();
            a(false);
            getSupportFragmentManager().j1();
        } else if (qVar instanceof q.a) {
            c(true);
        } else if (qVar instanceof q.b) {
            if (((q.b) qVar).b()) {
                q();
            } else {
                c(false);
            }
        } else if (qVar instanceof q.d) {
            d o11 = h();
            SNSCompletionResult b11 = ((q.d) qVar).b();
            if (b11 == null) {
                b11 = n();
            }
            o11.a(b11, false);
        }
    }

    public void a(String str, String str2) {
        a(this, com.sumsub.sns.camera.photo.presentation.a.f30593k.a(str2).forResult(str), com.sumsub.sns.camera.photo.presentation.a.f30595m, false, false, 12, (Object) null);
    }

    public void a(l<? super IsoDep, Unit> lVar) {
        com.sumsub.sns.core.c.b(com.sumsub.sns.core.c.f30748a, d.P, "Start listening NFC", (Throwable) null, 4, (Object) null);
        this.f39567f.a(this, lVar);
    }

    public void a(Fragment fragment, String str) {
        a(this, fragment, str, false, false, 12, (Object) null);
    }

    public void a(File file, int i11, String str, String str2) {
        com.sumsub.sns.core.presentation.b forResult = com.sumsub.sns.core.presentation.screen.imageviewer.a.f31099h.a(file, i11, str).forResult(str2);
        FragmentTransaction q11 = getSupportFragmentManager().q();
        q11.u(R.id.sns_container, forResult, com.sumsub.sns.core.presentation.screen.imageviewer.a.f31101j);
        q11.h(com.sumsub.sns.core.presentation.screen.imageviewer.a.f31101j);
        q11.j();
    }

    public void a(com.sumsub.sns.internal.core.domain.model.c cVar, Parcelable parcelable) {
        getSupportFragmentManager().v(com.sumsub.sns.internal.core.common.n0.f32116d);
        h().a(cVar, parcelable);
    }

    public void a(String str) {
        try {
            SNSUrlHandler urlHandler = SNSMobileSDK.INSTANCE.getUrlHandler();
            boolean z11 = true;
            if (urlHandler == null || !urlHandler.onUrl(this, str)) {
                z11 = false;
            }
            if (z11) {
                com.sumsub.sns.core.c.b(com.sumsub.sns.core.c.f30748a, d.P, "handled by host application", (Throwable) null, 4, (Object) null);
                return;
            }
            com.sumsub.sns.core.c.b(com.sumsub.sns.core.c.f30748a, d.P, "handle url using system default behaviour", (Throwable) null, 4, (Object) null);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            startActivity(intent);
        } catch (Exception e11) {
            com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
            cVar.b(d.P, "Can't open deep link " + str, e11);
        }
    }

    public static final void a(SNSAppActivity sNSAppActivity, String str, Bundle bundle) {
        Unit unit;
        Document document = (Document) androidx.core.os.d.b(bundle, com.sumsub.sns.geo.presentation.a.f31276t, Document.class);
        if (document != null) {
            a(sNSAppActivity, com.sumsub.sns.presentation.screen.preview.photo.common.a.f39952z.a(document), com.sumsub.sns.presentation.screen.preview.photo.common.a.B, false, false, 12, (Object) null);
            unit = Unit.f56620a;
        } else {
            unit = null;
        }
        if (unit == null) {
            sNSAppActivity.c(true);
        }
    }
}
