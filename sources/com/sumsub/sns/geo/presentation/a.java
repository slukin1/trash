package com.sumsub.sns.geo.presentation;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.v;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.core.widget.SNSImageView;
import com.sumsub.sns.core.widget.SNSStepViewExtensionsKt;
import com.sumsub.sns.internal.core.analytics.Control;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.common.z;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.widget.SNSStepState;
import com.sumsub.sns.internal.geo.presentation.e;
import d10.p;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.k;
import kotlin.reflect.l;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;

@Metadata(bv = {}, d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ^2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u000fB\u0007¢\u0006\u0004\bj\u0010kJ\u001c\u0010\n\u001a\u00020\t2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0003J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0003J\b\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u001aH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0014J\u001a\u0010#\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010$\u001a\u00020\tH\u0016J\u0010\u0010&\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020%H\u0014J\u001a\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010!H\u0014R\u001d\u0010+\u001a\u0004\u0018\u00010'8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010(\u001a\u0004\b)\u0010*R\u001d\u00100\u001a\u0004\u0018\u00010,8BX\u0002¢\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b.\u0010/R\u001d\u00103\u001a\u0004\u0018\u00010,8BX\u0002¢\u0006\f\n\u0004\b1\u0010(\u001a\u0004\b2\u0010/R\u001d\u00108\u001a\u0004\u0018\u0001048BX\u0002¢\u0006\f\n\u0004\b5\u0010(\u001a\u0004\b6\u00107R\u001d\u0010;\u001a\u0004\u0018\u00010,8BX\u0002¢\u0006\f\n\u0004\b9\u0010(\u001a\u0004\b:\u0010/R\u001d\u0010@\u001a\u0004\u0018\u00010<8BX\u0002¢\u0006\f\n\u0004\b=\u0010(\u001a\u0004\b>\u0010?R\u001d\u0010C\u001a\u0004\u0018\u00010<8BX\u0002¢\u0006\f\n\u0004\bA\u0010(\u001a\u0004\bB\u0010?R\u001d\u0010F\u001a\u0004\u0018\u00010'8BX\u0002¢\u0006\f\n\u0004\bD\u0010(\u001a\u0004\bE\u0010*R$\u0010K\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060H\u0018\u00010G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010PR\u0014\u0010T\u001a\u00020R8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010SR\u0014\u0010U\u001a\u00020R8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010SR\u001b\u0010Y\u001a\u00020\u00038TX\u0002¢\u0006\f\n\u0004\b)\u0010V\u001a\u0004\bW\u0010XR\u0016\u0010\\\u001a\u00020Z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010[R\u0016\u0010`\u001a\u0004\u0018\u00010]8BX\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_R\u0014\u0010c\u001a\u00020Z8VX\u0004¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0014\u0010f\u001a\u00020\u00068TX\u0004¢\u0006\u0006\u001a\u0004\bd\u0010eR\u0014\u0010i\u001a\u00020g8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010h¨\u0006l"}, d2 = {"Lcom/sumsub/sns/geo/presentation/a;", "Lcom/sumsub/sns/core/presentation/b;", "Lcom/sumsub/sns/internal/geo/presentation/e;", "Lcom/sumsub/sns/internal/geo/presentation/c;", "Lcom/sumsub/sns/internal/core/presentation/form/a;", "", "", "", "grantResults", "", "handlePermissionResults", "y", "s", "Landroid/location/Location;", "location", "a", "l", "k", "Lcom/sumsub/sns/internal/geo/presentation/e$b;", "state", "Lcom/sumsub/sns/internal/geo/presentation/e$f;", "Lcom/sumsub/sns/core/presentation/base/a$n;", "event", "A", "x", "z", "Lcom/sumsub/sns/internal/geo/presentation/e$d;", "Lcom/sumsub/sns/internal/geo/presentation/e$g;", "m", "", "getLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "onStop", "Lcom/sumsub/sns/core/presentation/base/a$j;", "handleEvent", "Landroid/view/ViewGroup;", "Lcom/sumsub/sns/internal/core/common/z;", "n", "()Landroid/view/ViewGroup;", "content", "Landroid/widget/TextView;", "b", "getTitle", "()Landroid/widget/TextView;", "title", "c", "v", "subtitle", "Landroid/widget/ImageView;", "d", "r", "()Landroid/widget/ImageView;", "icon", "e", "q", "hint", "Landroid/widget/Button;", "f", "t", "()Landroid/widget/Button;", "primaryButton", "g", "u", "secondaryButton", "h", "o", "formContainer", "Landroidx/activity/result/ActivityResultLauncher;", "", "i", "Landroidx/activity/result/ActivityResultLauncher;", "permissionLauncher", "j", "Z", "locationSent", "Lkotlinx/coroutines/n1;", "Lkotlinx/coroutines/n1;", "locationTimeOut", "Landroid/location/LocationListener;", "Landroid/location/LocationListener;", "gpslocationListener", "networklocationListener", "Lkotlin/i;", "w", "()Lcom/sumsub/sns/internal/geo/presentation/c;", "viewModel", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "screenInternal", "Lcom/sumsub/sns/core/presentation/form/d;", "p", "()Lcom/sumsub/sns/core/presentation/form/d;", "formFragment", "getScreen", "()Lcom/sumsub/sns/internal/core/analytics/Screen;", "screen", "getIdDocSetType", "()Ljava/lang/String;", "idDocSetType", "Lcom/sumsub/sns/internal/core/presentation/form/b;", "()Lcom/sumsub/sns/internal/core/presentation/form/b;", "hostViewModel", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class a extends com.sumsub.sns.core.presentation.b<com.sumsub.sns.internal.geo.presentation.e, com.sumsub.sns.internal.geo.presentation.c> implements com.sumsub.sns.internal.core.presentation.form.a {

    /* renamed from: p  reason: collision with root package name */
    public static final C0300a f31272p = new C0300a((r) null);

    /* renamed from: q  reason: collision with root package name */
    public static final /* synthetic */ l<Object>[] f31273q = {Reflection.j(new PropertyReference1Impl(a.class, "content", "getContent()Landroid/view/ViewGroup;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "title", "getTitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, MessengerShareContentUtility.SUBTITLE, "getSubtitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "icon", "getIcon()Landroid/widget/ImageView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "hint", "getHint()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "primaryButton", "getPrimaryButton()Landroid/widget/Button;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "secondaryButton", "getSecondaryButton()Landroid/widget/Button;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "formContainer", "getFormContainer()Landroid/view/ViewGroup;", 0))};

    /* renamed from: r  reason: collision with root package name */
    public static final String f31274r = "SNSGeoFragment";

    /* renamed from: s  reason: collision with root package name */
    public static final String f31275s = "geo_request_fallback";

    /* renamed from: t  reason: collision with root package name */
    public static final String f31276t = "geo_fallback_document";

    /* renamed from: u  reason: collision with root package name */
    public static final long f31277u = TimeUnit.MINUTES.toNanos(10);

    /* renamed from: a  reason: collision with root package name */
    public final z f31278a = a0.a(this, R.id.sns_fragment_content);

    /* renamed from: b  reason: collision with root package name */
    public final z f31279b = a0.a(this, R.id.sns_title);

    /* renamed from: c  reason: collision with root package name */
    public final z f31280c = a0.a(this, R.id.sns_subtitle);

    /* renamed from: d  reason: collision with root package name */
    public final z f31281d = a0.a(this, R.id.sns_icon);

    /* renamed from: e  reason: collision with root package name */
    public final z f31282e = a0.a(this, R.id.sns_hint);

    /* renamed from: f  reason: collision with root package name */
    public final z f31283f = a0.a(this, R.id.sns_primary_button);

    /* renamed from: g  reason: collision with root package name */
    public final z f31284g = a0.a(this, R.id.sns_secondary_button);

    /* renamed from: h  reason: collision with root package name */
    public final z f31285h = a0.a(this, R.id.sns_form_placeholder);

    /* renamed from: i  reason: collision with root package name */
    public ActivityResultLauncher<String[]> f31286i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f31287j;

    /* renamed from: k  reason: collision with root package name */
    public n1 f31288k;

    /* renamed from: l  reason: collision with root package name */
    public final LocationListener f31289l = new b(this);

    /* renamed from: m  reason: collision with root package name */
    public final LocationListener f31290m = new c(this);

    /* renamed from: n  reason: collision with root package name */
    public final kotlin.i f31291n;

    /* renamed from: o  reason: collision with root package name */
    public Screen f31292o;

    /* renamed from: com.sumsub.sns.geo.presentation.a$a  reason: collision with other inner class name */
    public static final class C0300a {
        public /* synthetic */ C0300a(r rVar) {
            this();
        }

        public final Fragment a(Document document) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARGS_DOCUMENT", document);
            aVar.setArguments(bundle);
            return aVar;
        }

        public C0300a() {
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.geo.presentation.SNSGeoFragment$enableLocationUpdates$1", f = "SNSGeoFragment.kt", l = {210}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31293a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f31294b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar, kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
            this.f31294b = aVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new b(this.f31294b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31293a;
            if (i11 == 0) {
                k.b(obj);
                this.f31293a = 1;
                if (DelayKt.b(30000, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f31294b.k();
            this.f31294b.getViewModel().u();
            return Unit.f56620a;
        }
    }

    public static final class c extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31295a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar) {
            super(0);
            this.f31295a = aVar;
        }

        public final void a() {
            com.sumsub.sns.core.presentation.b.finish$default(this.f31295a, (q) null, (Object) null, (Long) null, 7, (Object) null);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class d extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31296a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.n f31297b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar, a.n nVar) {
            super(0);
            this.f31296a = aVar;
            this.f31297b = nVar;
        }

        public final void a() {
            this.f31296a.getViewModel().a(this.f31297b.e());
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class e extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f31298a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
            super(0);
            this.f31298a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f31298a;
        }
    }

    public static final class f extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f31299a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(d10.a aVar) {
            super(0);
            this.f31299a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f31299a.invoke();
        }
    }

    public static final class g extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f31300a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(kotlin.i iVar) {
            super(0);
            this.f31300a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f31300a).getViewModelStore();
        }
    }

    public static final class h extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f31301a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f31302b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(d10.a aVar, kotlin.i iVar) {
            super(0);
            this.f31301a = aVar;
            this.f31302b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f31301a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f31302b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class i extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f31303a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f31304b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(Fragment fragment, kotlin.i iVar) {
            super(0);
            this.f31303a = fragment;
            this.f31304b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f31304b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f31303a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class j extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31305a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(a aVar) {
            super(0);
            this.f31305a = aVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            a aVar = this.f31305a;
            return new com.sumsub.sns.internal.geo.presentation.d(aVar, aVar.getServiceLocator(), this.f31305a.getArguments());
        }
    }

    public a() {
        j jVar = new j(this);
        kotlin.i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new f(new e(this)));
        this.f31291n = FragmentViewModelLazyKt.c(this, Reflection.b(com.sumsub.sns.internal.geo.presentation.c.class), new g(b11), new h((d10.a) null, b11), jVar);
        this.f31292o = Screen.GeolocationDetectionScreen;
    }

    @SensorsDataInstrumented
    public static final void c(a aVar, View view) {
        aVar.getViewModel().v();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void d(a aVar, View view) {
        aVar.m();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void e(a aVar, View view) {
        com.sumsub.sns.internal.core.analytics.c.b(aVar.getAnalyticsDelegate(), aVar.getScreen(), aVar.getIdDocSetType(), Control.ContinueButton, (Map) null, 8, (Object) null);
        aVar.getViewModel().w();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void f(a aVar, View view) {
        aVar.s();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void g(a aVar, View view) {
        aVar.m();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void A() {
        TextView title = getTitle();
        if (title != null) {
            title.setVisibility(4);
        }
        TextView v11 = v();
        if (v11 != null) {
            v11.setVisibility(4);
        }
        ImageView r11 = r();
        if (r11 != null) {
            r11.setVisibility(4);
        }
        TextView q11 = q();
        if (q11 != null) {
            q11.setVisibility(4);
        }
        Button t11 = t();
        if (t11 != null) {
            t11.setVisibility(8);
        }
        Button u11 = u();
        if (u11 != null) {
            u11.setVisibility(8);
        }
        ViewGroup o11 = o();
        if (o11 != null) {
            o11.setVisibility(4);
        }
        getViewModel().b(true);
    }

    public String getIdDocSetType() {
        return getViewModel().r().getType().c();
    }

    public int getLayoutId() {
        return R.layout.sns_fragment_geo;
    }

    public Screen getScreen() {
        return this.f31292o;
    }

    public final TextView getTitle() {
        return (TextView) this.f31279b.a(this, f31273q[1]);
    }

    public void handleEvent(a.j jVar) {
        super.handleEvent(jVar);
        if (jVar instanceof a.n) {
            a((a.n) jVar);
        }
    }

    public final void handlePermissionResults(Map<String, Boolean> map) {
        getViewModel().a(map);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: android.location.LocationManager} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void k() {
        /*
            r6 = this;
            com.sumsub.sns.internal.geo.a r0 = com.sumsub.sns.internal.geo.a.f34682a
            java.lang.String r1 = "SumSubGeo"
            java.lang.String r2 = "disableLocationUpdates"
            r3 = 0
            r4 = 4
            r5 = 0
            com.sumsub.sns.internal.geo.a.a(r0, r1, r2, r3, r4, r5)
            kotlinx.coroutines.n1 r0 = r6.f31288k
            r1 = 0
            if (r0 == 0) goto L_0x0015
            r2 = 1
            kotlinx.coroutines.n1.a.a(r0, r1, r2, r1)
        L_0x0015:
            r6.f31288k = r1
            androidx.fragment.app.FragmentActivity r0 = r6.requireActivity()
            java.lang.String r2 = "location"
            java.lang.Object r0 = r0.getSystemService(r2)
            boolean r2 = r0 instanceof android.location.LocationManager
            if (r2 == 0) goto L_0x0028
            r1 = r0
            android.location.LocationManager r1 = (android.location.LocationManager) r1
        L_0x0028:
            if (r1 != 0) goto L_0x002b
            return
        L_0x002b:
            android.location.LocationListener r0 = r6.f31289l
            r1.removeUpdates(r0)
            android.location.LocationListener r0 = r6.f31290m
            r1.removeUpdates(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.geo.presentation.a.k():void");
    }

    @SuppressLint({"MissingPermission"})
    public final void l() {
        com.sumsub.sns.internal.geo.a.a(com.sumsub.sns.internal.geo.a.f34682a, com.sumsub.sns.internal.geo.a.f34683b, "enableLocationUpdates", (Throwable) null, 4, (Object) null);
        Object systemService = requireActivity().getSystemService("location");
        LocationManager locationManager = systemService instanceof LocationManager ? (LocationManager) systemService : null;
        if (locationManager != null) {
            this.f31287j = false;
            boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
            if (isProviderEnabled) {
                locationManager.requestLocationUpdates("gps", TimeUnit.SECONDS.toMillis(5), 0.0f, this.f31289l);
            }
            boolean isProviderEnabled2 = locationManager.isProviderEnabled(OptionsBridge.NETWORK_KEY);
            if (isProviderEnabled2) {
                locationManager.requestLocationUpdates(OptionsBridge.NETWORK_KEY, TimeUnit.SECONDS.toMillis(5), 0.0f, this.f31290m);
            }
            if (isProviderEnabled || isProviderEnabled2) {
                this.f31288k = kotlinx.coroutines.i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new b(this, (kotlin.coroutines.c<? super b>) null), 3, (Object) null);
            } else {
                getViewModel().u();
            }
        }
    }

    public final void m() {
        com.sumsub.sns.internal.core.analytics.c.b(getAnalyticsDelegate(), getScreen(), getIdDocSetType(), Control.SkipButton, (Map) null, 8, (Object) null);
        Bundle bundle = new Bundle();
        bundle.putParcelable(f31276t, getViewModel().r());
        Unit unit = Unit.f56620a;
        androidx.fragment.app.p.a(this, f31275s, bundle);
    }

    public final ViewGroup n() {
        return (ViewGroup) this.f31278a.a(this, f31273q[0]);
    }

    public final ViewGroup o() {
        return (ViewGroup) this.f31285h.a(this, f31273q[7]);
    }

    public void onStop() {
        k();
        super.onStop();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f31286i = registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new k(this));
        ImageView r11 = r();
        if (r11 != null) {
            com.sumsub.sns.core.presentation.helper.a.a(com.sumsub.sns.core.presentation.helper.a.f31095a, (View) r11, (Integer) null, (ColorStateList) null, 3, (Object) null);
        }
    }

    public final com.sumsub.sns.core.presentation.form.d p() {
        Fragment l02 = getChildFragmentManager().l0(R.id.sns_form_placeholder);
        if (l02 instanceof com.sumsub.sns.core.presentation.form.d) {
            return (com.sumsub.sns.core.presentation.form.d) l02;
        }
        return null;
    }

    public final TextView q() {
        return (TextView) this.f31282e.a(this, f31273q[4]);
    }

    public final ImageView r() {
        return (ImageView) this.f31281d.a(this, f31273q[3]);
    }

    @SuppressLint({"MissingPermission"})
    public final void s() {
        this.f31292o = Screen.GeolocationDetectionScreen;
        this.f31287j = false;
        A();
        Object systemService = requireActivity().getSystemService("location");
        LocationManager locationManager = systemService instanceof LocationManager ? (LocationManager) systemService : null;
        if (locationManager != null) {
            Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
            if (lastKnownLocation == null) {
                lastKnownLocation = locationManager.getLastKnownLocation(OptionsBridge.NETWORK_KEY);
            }
            if (lastKnownLocation == null || SystemClock.elapsedRealtimeNanos() - lastKnownLocation.getElapsedRealtimeNanos() >= f31277u) {
                l();
                return;
            }
            com.sumsub.sns.internal.geo.a aVar = com.sumsub.sns.internal.geo.a.f34682a;
            com.sumsub.sns.internal.geo.a.a(aVar, com.sumsub.sns.internal.geo.a.f34683b, "Using last known location: " + lastKnownLocation, (Throwable) null, 4, (Object) null);
            a(lastKnownLocation);
        }
    }

    public final Button t() {
        return (Button) this.f31283f.a(this, f31273q[5]);
    }

    public final Button u() {
        return (Button) this.f31284g.a(this, f31273q[6]);
    }

    public final TextView v() {
        return (TextView) this.f31280c.a(this, f31273q[2]);
    }

    /* renamed from: w */
    public com.sumsub.sns.internal.geo.presentation.c getViewModel() {
        return (com.sumsub.sns.internal.geo.presentation.c) this.f31291n.getValue();
    }

    public final void x() {
        getViewModel().b(false);
    }

    public final void y() {
        com.sumsub.sns.internal.geo.a.a(com.sumsub.sns.internal.geo.a.f34682a, com.sumsub.sns.internal.geo.a.f34683b, "Requesting permissions", (Throwable) null, 4, (Object) null);
        ActivityResultLauncher<String[]> activityResultLauncher = this.f31286i;
        if (activityResultLauncher != null) {
            activityResultLauncher.a(getViewModel().s());
        }
    }

    public final void z() {
        this.f31292o = Screen.GeolocationFormScreen;
        ViewGroup n11 = n();
        if (n11 != null) {
            n11.setVisibility(4);
        }
        com.sumsub.sns.core.presentation.b.finish$default(this, new q.b(false, 1, (r) null), (Object) null, (Long) null, 6, (Object) null);
    }

    public static final void a(a aVar, Location location) {
        com.sumsub.sns.internal.geo.a aVar2 = com.sumsub.sns.internal.geo.a.f34682a;
        com.sumsub.sns.internal.geo.a.a(aVar2, com.sumsub.sns.internal.geo.a.f34683b, "onLocationChanged: location=" + location, (Throwable) null, 4, (Object) null);
        aVar.a(location);
    }

    public static final void b(a aVar, Location location) {
        com.sumsub.sns.internal.geo.a aVar2 = com.sumsub.sns.internal.geo.a.f34682a;
        com.sumsub.sns.internal.geo.a.a(aVar2, com.sumsub.sns.internal.geo.a.f34683b, "onLocationChanged: location=" + location, (Throwable) null, 4, (Object) null);
        aVar.a(location);
    }

    @SensorsDataInstrumented
    public static final void b(a aVar, View view) {
        aVar.m();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public com.sumsub.sns.internal.core.presentation.form.b a() {
        return getViewModel();
    }

    public static final void a(a aVar, Map map) {
        aVar.handlePermissionResults(map);
    }

    /* renamed from: a */
    public void handleState(com.sumsub.sns.internal.geo.presentation.e eVar, Bundle bundle) {
        com.sumsub.sns.internal.geo.a aVar = com.sumsub.sns.internal.geo.a.f34682a;
        com.sumsub.sns.internal.geo.a.a(aVar, com.sumsub.sns.internal.geo.a.f34683b, "handleViewStateChange: " + eVar, (Throwable) null, 4, (Object) null);
        x();
        if (eVar instanceof e.c) {
            A();
        } else if (eVar instanceof e.b) {
            a((e.b) eVar);
        } else if (eVar instanceof e.f) {
            a((e.f) eVar);
        } else if (eVar instanceof e.d) {
            a((e.d) eVar);
        } else if (eVar instanceof e.C0400e) {
            s();
        } else if (eVar instanceof e.a) {
            z();
        } else if (eVar instanceof e.g) {
            a((e.g) eVar);
        }
    }

    public final void a(Location location) {
        com.sumsub.sns.internal.geo.a aVar = com.sumsub.sns.internal.geo.a.f34682a;
        com.sumsub.sns.internal.geo.a.a(aVar, com.sumsub.sns.internal.geo.a.f34683b, "Send location: " + location, (Throwable) null, 4, (Object) null);
        if (!this.f31287j) {
            getViewModel().a(location);
            this.f31287j = true;
            k();
        }
    }

    public final void a(e.b bVar) {
        this.f31292o = Screen.GeolocationDetectionScreen;
        getAnalyticsDelegate().c();
        TextView title = getTitle();
        if (title != null) {
            title.setText(bVar.d());
        }
        TextView title2 = getTitle();
        if (title2 != null) {
            title2.setVisibility(0);
        }
        TextView v11 = v();
        if (v11 != null) {
            v11.setText(bVar.c());
        }
        TextView v12 = v();
        if (v12 != null) {
            v12.setVisibility(0);
        }
        ViewGroup o11 = o();
        if (o11 != null) {
            o11.setVisibility(8);
        }
        ImageView r11 = r();
        if (r11 != null) {
            r11.setVisibility(0);
        }
        ImageView r12 = r();
        SNSImageView sNSImageView = r12 instanceof SNSImageView ? (SNSImageView) r12 : null;
        if (sNSImageView != null) {
            SNSStepViewExtensionsKt.setSnsStepState(sNSImageView, SNSStepState.INIT);
        }
        ImageView r13 = r();
        if (r13 != null) {
            r13.setImageDrawable(e0.f32018a.getIconHandler().onResolveIcon(requireContext(), bVar.f()));
        }
        TextView q11 = q();
        if (q11 != null) {
            q11.setText(bVar.e());
        }
        TextView q12 = q();
        if (q12 != null) {
            q12.setVisibility(0);
        }
        Button t11 = t();
        if (t11 != null) {
            t11.setText(bVar.a());
        }
        Button t12 = t();
        if (t12 != null) {
            t12.setVisibility(0);
        }
        Button t13 = t();
        if (t13 != null) {
            t13.setOnClickListener(new d(this));
        }
        Button u11 = u();
        if (u11 != null) {
            u11.setText(bVar.b());
        }
        Button u12 = u();
        if (u12 != null) {
            u12.setVisibility(0);
        }
        Button u13 = u();
        if (u13 != null) {
            u13.setOnClickListener(new e(this));
        }
    }

    @SensorsDataInstrumented
    public static final void a(a aVar, View view) {
        LocationManager locationManager = (LocationManager) ContextCompat.getSystemService(aVar.requireContext(), LocationManager.class);
        boolean a11 = locationManager != null ? w0.a.a(locationManager) : true;
        aVar.getAnalyticsDelegate().b(aVar.getScreen(), aVar.getIdDocSetType(), Control.StartButton, MapsKt__MapsJVMKt.e(kotlin.l.a("IS_LOCATION_ENABLED", String.valueOf(a11))));
        if (a11) {
            aVar.y();
        } else {
            com.sumsub.sns.internal.geo.a.a(com.sumsub.sns.internal.geo.a.f34682a, com.sumsub.sns.internal.geo.a.f34683b, "Asking the user to enable location in settings", (Throwable) null, 4, (Object) null);
            aVar.getViewModel().t();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void a(e.f fVar) {
        this.f31292o = Screen.GeolocationDetectionScreen;
        TextView title = getTitle();
        if (title != null) {
            title.setText(fVar.d());
        }
        TextView title2 = getTitle();
        if (title2 != null) {
            title2.setVisibility(0);
        }
        TextView v11 = v();
        if (v11 != null) {
            v11.setText(fVar.c());
        }
        TextView v12 = v();
        if (v12 != null) {
            v12.setVisibility(0);
        }
        ViewGroup o11 = o();
        if (o11 != null) {
            o11.setVisibility(8);
        }
        ImageView r11 = r();
        if (r11 != null) {
            r11.setVisibility(0);
        }
        ImageView r12 = r();
        SNSImageView sNSImageView = r12 instanceof SNSImageView ? (SNSImageView) r12 : null;
        if (sNSImageView != null) {
            SNSStepViewExtensionsKt.setSnsStepState(sNSImageView, SNSStepState.INIT);
        }
        ImageView r13 = r();
        if (r13 != null) {
            r13.setImageDrawable(e0.f32018a.getIconHandler().onResolveIcon(requireContext(), fVar.f()));
        }
        TextView q11 = q();
        if (q11 != null) {
            q11.setText(fVar.e());
        }
        TextView q12 = q();
        if (q12 != null) {
            q12.setVisibility(0);
        }
        Button t11 = t();
        if (t11 != null) {
            t11.setText(fVar.a());
        }
        Button t12 = t();
        if (t12 != null) {
            t12.setVisibility(0);
        }
        Button t13 = t();
        if (t13 != null) {
            t13.setOnClickListener(new f(this));
        }
        Button u11 = u();
        if (u11 != null) {
            u11.setText(fVar.b());
        }
        Button u12 = u();
        if (u12 != null) {
            u12.setVisibility(0);
        }
        Button u13 = u();
        if (u13 != null) {
            u13.setOnClickListener(new g(this));
        }
    }

    public final void a(a.n nVar) {
        com.sumsub.sns.internal.core.android.c.f31946a.a(requireActivity(), nVar.f(), nVar.h(), nVar.g(), new c(this), new d(this, nVar)).show();
    }

    public final void a(e.d dVar) {
        this.f31292o = Screen.GeolocationFormScreen;
        getAnalyticsDelegate().e();
        TextView title = getTitle();
        if (title != null) {
            title.setVisibility(8);
        }
        TextView v11 = v();
        if (v11 != null) {
            v11.setVisibility(8);
        }
        ImageView r11 = r();
        if (r11 != null) {
            r11.setVisibility(8);
        }
        TextView q11 = q();
        if (q11 != null) {
            q11.setVisibility(8);
        }
        Button u11 = u();
        if (u11 != null) {
            u11.setVisibility(8);
        }
        ViewGroup o11 = o();
        if (o11 != null) {
            o11.setVisibility(0);
        }
        if (p() == null) {
            FragmentTransaction q12 = getChildFragmentManager().q();
            q12.t(R.id.sns_form_placeholder, com.sumsub.sns.core.presentation.form.d.f30929p.a(com.sumsub.sns.internal.geo.a.f34683b));
            q12.l();
        }
        View currentFocus = requireActivity().getCurrentFocus();
        if (currentFocus != null) {
            com.sumsub.sns.internal.core.common.i.g(currentFocus);
        }
        Button t11 = t();
        if (t11 != null) {
            t11.setText(dVar.a());
        }
        Button t12 = t();
        if (t12 != null) {
            t12.setVisibility(0);
        }
        Button t13 = t();
        if (t13 != null) {
            t13.setOnClickListener(new h(this));
        }
    }

    public final void a(e.g gVar) {
        this.f31292o = Screen.GeolocationUnknownScreen;
        getAnalyticsDelegate().c();
        TextView title = getTitle();
        if (title != null) {
            title.setText(gVar.d());
        }
        TextView title2 = getTitle();
        if (title2 != null) {
            title2.setVisibility(0);
        }
        TextView v11 = v();
        if (v11 != null) {
            v11.setText(gVar.c());
        }
        TextView v12 = v();
        if (v12 != null) {
            v12.setVisibility(0);
        }
        ViewGroup o11 = o();
        if (o11 != null) {
            o11.setVisibility(8);
        }
        ImageView r11 = r();
        if (r11 != null) {
            r11.setVisibility(0);
        }
        ImageView r12 = r();
        SNSImageView sNSImageView = r12 instanceof SNSImageView ? (SNSImageView) r12 : null;
        if (sNSImageView != null) {
            SNSStepViewExtensionsKt.setSnsStepState(sNSImageView, SNSStepState.INIT);
        }
        ImageView r13 = r();
        if (r13 != null) {
            r13.setImageDrawable(e0.f32018a.getIconHandler().onResolveIcon(requireContext(), gVar.e()));
        }
        TextView q11 = q();
        if (q11 != null) {
            q11.setVisibility(8);
        }
        Button t11 = t();
        if (t11 != null) {
            t11.setText(gVar.a());
        }
        Button t12 = t();
        if (t12 != null) {
            t12.setVisibility(0);
        }
        Button t13 = t();
        if (t13 != null) {
            t13.setOnClickListener(new i(this));
        }
        Button u11 = u();
        if (u11 != null) {
            u11.setText(gVar.b());
        }
        Button u12 = u();
        if (u12 != null) {
            u12.setVisibility(0);
        }
        Button u13 = u();
        if (u13 != null) {
            u13.setOnClickListener(new j(this));
        }
    }
}
