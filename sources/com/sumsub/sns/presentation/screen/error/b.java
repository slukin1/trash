package com.sumsub.sns.presentation.screen.error;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.data.model.SNSGeneralException;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.core.widget.SNSImageView;
import com.sumsub.sns.core.widget.SNSStepViewExtensionsKt;
import com.sumsub.sns.internal.core.analytics.Control;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.b0;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.k0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.common.z;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.o;
import com.sumsub.sns.internal.core.widget.SNSStepState;
import com.sumsub.sns.internal.presentation.screen.error.a;
import d10.p;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlin.reflect.l;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 N2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0007¢\u0006\u0004\bL\u0010MJ\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J+\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J4\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00042\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010$\u001a\u00020\u001bH\u0002R\u001b\u0010(\u001a\u00020\u00038TX\u0002¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010.\u001a\u0004\u0018\u00010)8BX\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001d\u00103\u001a\u0004\u0018\u00010/8BX\u0002¢\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u00102R\u001d\u00108\u001a\u0004\u0018\u0001048BX\u0002¢\u0006\f\n\u0004\b5\u0010+\u001a\u0004\b6\u00107R\u001d\u0010;\u001a\u0004\u0018\u0001048BX\u0002¢\u0006\f\n\u0004\b9\u0010+\u001a\u0004\b:\u00107R\u001d\u0010?\u001a\u0004\u0018\u00010\n8BX\u0002¢\u0006\f\n\u0004\b<\u0010+\u001a\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001a\u0010H\u001a\u00020C8\u0016X\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0014\u0010K\u001a\u00020\u001e8TX\u0004¢\u0006\u0006\u001a\u0004\bI\u0010J¨\u0006O"}, d2 = {"Lcom/sumsub/sns/presentation/screen/error/b;", "Lcom/sumsub/sns/core/presentation/b;", "Lcom/sumsub/sns/internal/presentation/screen/error/a$b;", "Lcom/sumsub/sns/internal/presentation/screen/error/a;", "", "getLayoutId", "Lcom/sumsub/sns/internal/core/common/q;", "finishReason", "", "onFinishCalled", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "state", "a", "reason", "", "payload", "", "delay", "finish", "(Lcom/sumsub/sns/internal/core/common/q;Ljava/lang/Object;Ljava/lang/Long;)V", "Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", "onCancelResult", "Lcom/sumsub/sns/internal/core/data/model/o;", "error", "layout", "", "icon", "Lcom/sumsub/sns/internal/core/widget/SNSStepState;", "iconState", "Lcom/sumsub/sns/internal/core/analytics/Control;", "clickControl", "l", "Lkotlin/i;", "q", "()Lcom/sumsub/sns/internal/presentation/screen/error/a;", "viewModel", "Landroid/view/ViewGroup;", "b", "Lcom/sumsub/sns/internal/core/common/z;", "n", "()Landroid/view/ViewGroup;", "stub", "Lcom/sumsub/sns/core/widget/SNSImageView;", "c", "m", "()Lcom/sumsub/sns/core/widget/SNSImageView;", "ivIcon", "Landroid/widget/TextView;", "d", "p", "()Landroid/widget/TextView;", "tvTitle", "e", "o", "tvSubTitle", "f", "k", "()Landroid/view/View;", "btn", "g", "Z", "callCancelledCallbackOnBackPress", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "h", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "getScreen", "()Lcom/sumsub/sns/internal/core/analytics/Screen;", "screen", "getIdDocSetType", "()Ljava/lang/String;", "idDocSetType", "<init>", "()V", "i", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class b extends com.sumsub.sns.core.presentation.b<a.b, com.sumsub.sns.internal.presentation.screen.error.a> {

    /* renamed from: i  reason: collision with root package name */
    public static final a f39773i = new a((r) null);

    /* renamed from: j  reason: collision with root package name */
    public static final /* synthetic */ l<Object>[] f39774j = {Reflection.j(new PropertyReference1Impl(b.class, "stub", "getStub()Landroid/view/ViewGroup;", 0)), Reflection.j(new PropertyReference1Impl(b.class, "ivIcon", "getIvIcon()Lcom/sumsub/sns/core/widget/SNSImageView;", 0)), Reflection.j(new PropertyReference1Impl(b.class, "tvTitle", "getTvTitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(b.class, "tvSubTitle", "getTvSubTitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(b.class, "btn", "getBtn()Landroid/view/View;", 0))};

    /* renamed from: k  reason: collision with root package name */
    public static final String f39775k = "ErrorFragment";

    /* renamed from: a  reason: collision with root package name */
    public final kotlin.i f39776a;

    /* renamed from: b  reason: collision with root package name */
    public final z f39777b = a0.a(this, R.id.sns_view_stub);

    /* renamed from: c  reason: collision with root package name */
    public final z f39778c = a0.a(this, R.id.sns_error_icon);

    /* renamed from: d  reason: collision with root package name */
    public final z f39779d = a0.a(this, R.id.sns_error_title);

    /* renamed from: e  reason: collision with root package name */
    public final z f39780e = a0.a(this, R.id.sns_error_subtitle);

    /* renamed from: f  reason: collision with root package name */
    public final z f39781f = a0.a(this, R.id.sns_primary_button);

    /* renamed from: g  reason: collision with root package name */
    public boolean f39782g = true;

    /* renamed from: h  reason: collision with root package name */
    public final Screen f39783h;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final Fragment a(o oVar, String str) {
            b bVar = new b();
            Bundle bundle = new Bundle();
            bundle.putSerializable(com.sumsub.sns.internal.presentation.screen.error.a.f35246u, oVar);
            if (str != null) {
                bundle.putString("arg_iddocsettype", str);
            }
            bVar.setArguments(bundle);
            return bVar;
        }

        public a() {
        }
    }

    /* renamed from: com.sumsub.sns.presentation.screen.error.b$b  reason: collision with other inner class name */
    public static final class C0529b extends Lambda implements d10.l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f39784a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0529b(b bVar) {
            super(1);
            this.f39784a = bVar;
        }

        public final void a(String str) {
            this.f39784a.getViewModel().a(str);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.error.SNSErrorFragment$initUi$4", f = "SNSErrorFragment.kt", l = {}, m = "invokeSuspend")
    public static final class c extends SuspendLambda implements p<a.k, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39785a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f39786b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f39787c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b bVar, kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
            this.f39787c = bVar;
        }

        /* renamed from: a */
        public final Object invoke(a.k kVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((c) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            c cVar2 = new c(this.f39787c, cVar);
            cVar2.f39786b = obj;
            return cVar2;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f39785a == 0) {
                k.b(obj);
                this.f39787c.updateCommonUiState((a.k) this.f39786b);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class d extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f39788a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
            super(0);
            this.f39788a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f39788a;
        }
    }

    public static final class e extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f39789a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d10.a aVar) {
            super(0);
            this.f39789a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f39789a.invoke();
        }
    }

    public static final class f extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f39790a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(kotlin.i iVar) {
            super(0);
            this.f39790a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f39790a).getViewModelStore();
        }
    }

    public static final class g extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f39791a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f39792b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(d10.a aVar, kotlin.i iVar) {
            super(0);
            this.f39791a = aVar;
            this.f39792b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f39791a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f39792b);
            androidx.lifecycle.o oVar = b11 instanceof androidx.lifecycle.o ? (androidx.lifecycle.o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class h extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f39793a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f39794b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(Fragment fragment, kotlin.i iVar) {
            super(0);
            this.f39793a = fragment;
            this.f39794b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f39794b);
            androidx.lifecycle.o oVar = b11 instanceof androidx.lifecycle.o ? (androidx.lifecycle.o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f39793a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class i extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f39795a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(b bVar) {
            super(0);
            this.f39795a = bVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            b bVar = this.f39795a;
            return new com.sumsub.sns.internal.presentation.screen.error.b(bVar, bVar.getServiceLocator(), this.f39795a.getArguments());
        }
    }

    public b() {
        Screen screen;
        i iVar = new i(this);
        kotlin.i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new e(new d(this)));
        this.f39776a = FragmentViewModelLazyKt.c(this, Reflection.b(com.sumsub.sns.internal.presentation.screen.error.a.class), new f(b11), new g((d10.a) null, b11), iVar);
        o l11 = l();
        if (l11 instanceof o.c) {
            screen = Screen.OopsFatalScreen;
        } else if (l11 instanceof o.e) {
            screen = Screen.OopsNetworkScreen;
        } else if (l11 instanceof o.d) {
            screen = Screen.OopsActionScreen;
        } else {
            screen = Screen.Other;
        }
        this.f39783h = screen;
    }

    public void finish(q qVar, Object obj, Long l11) {
        this.f39782g = false;
        super.finish(qVar, obj, l11);
    }

    public String getIdDocSetType() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("arg_iddocsettype") : null;
        return string == null ? DocumentType.f32355j : string;
    }

    public int getLayoutId() {
        return R.layout.sns_fragment_error;
    }

    public Screen getScreen() {
        return this.f39783h;
    }

    public final View k() {
        return this.f39781f.a(this, f39774j[4]);
    }

    public final o l() {
        Bundle arguments = getArguments();
        o oVar = null;
        Object serializable = arguments != null ? arguments.getSerializable(com.sumsub.sns.internal.presentation.screen.error.a.f35246u) : null;
        if (serializable instanceof o) {
            oVar = (o) serializable;
        }
        return oVar == null ? new o.c((Throwable) null, (Object) null, (o.a) null, 7, (r) null) : oVar;
    }

    public final SNSImageView m() {
        return (SNSImageView) this.f39778c.a(this, f39774j[1]);
    }

    public final ViewGroup n() {
        return (ViewGroup) this.f39777b.a(this, f39774j[0]);
    }

    public final TextView o() {
        return (TextView) this.f39780e.a(this, f39774j[3]);
    }

    public SNSCompletionResult onCancelResult() {
        return new SNSCompletionResult.AbnormalTermination(l().b());
    }

    public boolean onFinishCalled(q qVar) {
        boolean z11;
        o l11 = l();
        if (l11 instanceof o.e) {
            z11 = true;
        } else {
            z11 = l11 instanceof o.d;
        }
        if (z11) {
            if (!this.f39782g || !x.b(qVar, q.c.f32251b)) {
                k0 appListener = getAppListener();
                if (appListener != null) {
                    appListener.a(l());
                }
            } else {
                k0 appListener2 = getAppListener();
                if (appListener2 != null) {
                    appListener2.b(l());
                }
            }
        } else if ((l11 instanceof o.c) && x.b(qVar, q.c.f32251b)) {
            k0 appListener3 = getAppListener();
            if (appListener3 == null) {
                return false;
            }
            appListener3.a(l());
            return false;
        }
        return super.onFinishCalled(qVar);
    }

    public void onViewCreated(View view, Bundle bundle) {
        String str;
        super.onViewCreated(view, bundle);
        o l11 = l();
        Pair[] pairArr = new Pair[1];
        Throwable b11 = l11.b();
        if (b11 == null || (str = b11.getMessage()) == null) {
            str = "unknown";
        }
        pairArr[0] = kotlin.l.a("error", str);
        Map m11 = MapsKt__MapsKt.m(pairArr);
        if ((l11.b() instanceof SNSGeneralException) && ((SNSGeneralException) l11.b()).getReason() != null) {
            m11.put(Constants.REASON, ((SNSGeneralException) l11.b()).getReason());
        }
        getAnalyticsDelegate().d(getScreen(), getIdDocSetType(), m11);
    }

    public final TextView p() {
        return (TextView) this.f39779d.a(this, f39774j[2]);
    }

    /* renamed from: q */
    public com.sumsub.sns.internal.presentation.screen.error.a getViewModel() {
        return (com.sumsub.sns.internal.presentation.screen.error.a) this.f39776a.getValue();
    }

    public final void a(o oVar, a.b bVar) {
        ViewGroup n11 = n();
        if ((n11 != null ? n11.getChildCount() : 0) <= 0 && !x.b(bVar, a.b.C0422a.f35251a)) {
            if (x.b(bVar, a.b.c.f35255a)) {
                a(R.layout.sns_fragment_init_error, (String) null, (SNSStepState) null, Control.CancelButton);
            } else if (oVar instanceof o.d) {
                a(R.layout.sns_fragment_common_error, SNSIconHandler.SNSResultIcons.FAILURE.getImageName(), SNSStepState.REJECTED, Control.RetryButton);
            } else if (oVar instanceof o.e) {
                a(R.layout.sns_fragment_network_error, SNSIconHandler.SNSResultIcons.WARNING.getImageName(), SNSStepState.PENDING, Control.RetryButton);
            } else if (oVar instanceof o.c) {
                a(R.layout.sns_fragment_common_error, SNSIconHandler.SNSResultIcons.FAILURE.getImageName(), SNSStepState.REJECTED, Control.GoBackButton);
                TextView o11 = o();
                if (o11 != null) {
                    com.sumsub.sns.core.common.b.a(o11, (d10.l<? super String, Unit>) new C0529b(this));
                }
            }
        }
    }

    public static /* synthetic */ void a(b bVar, int i11, String str, SNSStepState sNSStepState, Control control, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            str = null;
        }
        if ((i12 & 4) != 0) {
            sNSStepState = null;
        }
        if ((i12 & 8) != 0) {
            control = null;
        }
        bVar.a(i11, str, sNSStepState, control);
    }

    public final void a(int i11, String str, SNSStepState sNSStepState, Control control) {
        SNSImageView m11;
        LayoutInflater.from(requireContext()).inflate(i11, n());
        if (!(sNSStepState == null || (m11 = m()) == null)) {
            SNSStepViewExtensionsKt.setSnsStepState(m11, sNSStepState);
        }
        if (str != null) {
            Drawable onResolveIcon = e0.f32018a.getIconHandler().onResolveIcon(requireContext(), str);
            SNSImageView m12 = m();
            if (m12 != null) {
                m12.setImageDrawable(onResolveIcon);
            }
        }
        View k11 = k();
        if (k11 != null) {
            k11.setOnClickListener(new d(control, this));
        }
        initCommonUI();
        b0.b(getViewModel().i(), getViewLifecycleOwner(), new c(this, (kotlin.coroutines.c<? super c>) null));
    }

    public static final void a(Control control, b bVar, View view) {
        if (control != null) {
            com.sumsub.sns.internal.core.analytics.c.b(bVar.getAnalyticsDelegate(), bVar.getScreen(), bVar.getIdDocSetType(), control, (Map) null, 8, (Object) null);
        }
        com.sumsub.sns.core.presentation.b.finish$default(bVar, (q) null, (Object) null, (Long) null, 7, (Object) null);
    }

    /* renamed from: a */
    public void handleState(a.b bVar, Bundle bundle) {
        a(l(), bVar);
        if (bVar instanceof a.b.C0423b) {
            TextView p11 = p();
            if (p11 != null) {
                p11.setText(((a.b.C0423b) bVar).f());
            }
            TextView o11 = o();
            if (o11 != null) {
                o11.setText(((a.b.C0423b) bVar).e());
            }
            View k11 = k();
            TextView textView = k11 instanceof TextView ? (TextView) k11 : null;
            if (textView != null) {
                textView.setText(((a.b.C0423b) bVar).d());
            }
        }
    }
}
