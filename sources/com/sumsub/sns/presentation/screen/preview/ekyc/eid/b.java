package com.sumsub.sns.presentation.screen.preview.ekyc.eid;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.v;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.core.widget.pincode.SNSPinView;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.common.z;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel;
import d10.p;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlin.reflect.l;
import kotlinx.coroutines.h0;

@Metadata(bv = {}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0010\u0018\u0000 B2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\nB\u0007¢\u0006\u0004\b@\u0010AJ\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u001a\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014R\u001b\u0010\u0014\u001a\u00020\u00038TX\u0002¢\u0006\f\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u00158\u0014XD¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010 \u001a\u0004\u0018\u00010\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010#\u001a\u0004\u0018\u00010\u001b8BX\u0002¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u001d\u0010(\u001a\u0004\u0018\u00010$8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010'R\u001d\u0010+\u001a\u0004\u0018\u00010\u001b8BX\u0002¢\u0006\f\n\u0004\b)\u0010\u001d\u001a\u0004\b*\u0010\u001fR\u001a\u00101\u001a\u00020,8\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R$\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u000203\u0018\u0001028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R \u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u000203028VX\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R \u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u000203028VX\u0004¢\u0006\u0006\u001a\u0004\b:\u00108R \u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u000203028VX\u0004¢\u0006\u0006\u001a\u0004\b<\u00108R \u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u000203028VX\u0004¢\u0006\u0006\u001a\u0004\b>\u00108¨\u0006C"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/ekyc/eid/b;", "Lcom/sumsub/sns/core/presentation/b;", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/pin/SNSEidPinViewModel$e;", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/pin/SNSEidPinViewModel;", "", "getLayoutId", "state", "Landroid/os/Bundle;", "savedInstanceState", "", "a", "Landroid/view/View;", "view", "onViewCreated", "Lcom/sumsub/sns/core/presentation/base/a$j;", "event", "handleEvent", "Lkotlin/i;", "n", "()Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/pin/SNSEidPinViewModel;", "viewModel", "", "b", "Ljava/lang/String;", "getIdDocSetType", "()Ljava/lang/String;", "idDocSetType", "Landroid/widget/TextView;", "c", "Lcom/sumsub/sns/internal/core/common/z;", "getTitle", "()Landroid/widget/TextView;", "title", "d", "m", "subtitle", "Lcom/sumsub/sns/core/widget/pincode/SNSPinView;", "e", "l", "()Lcom/sumsub/sns/core/widget/pincode/SNSPinView;", "pinView", "f", "k", "errorText", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "g", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "getScreen", "()Lcom/sumsub/sns/internal/core/analytics/Screen;", "screen", "", "", "h", "Ljava/util/Map;", "analPayload", "getOpenPayload", "()Ljava/util/Map;", "openPayload", "getCancelPayload", "cancelPayload", "getClosePayload", "closePayload", "getAppearPayload", "appearPayload", "<init>", "()V", "i", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class b extends com.sumsub.sns.core.presentation.b<SNSEidPinViewModel.e, SNSEidPinViewModel> {

    /* renamed from: i  reason: collision with root package name */
    public static final a f39919i = new a((r) null);

    /* renamed from: j  reason: collision with root package name */
    public static final /* synthetic */ l<Object>[] f39920j = {Reflection.j(new PropertyReference1Impl(b.class, "title", "getTitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(b.class, MessengerShareContentUtility.SUBTITLE, "getSubtitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(b.class, "pinView", "getPinView()Lcom/sumsub/sns/core/widget/pincode/SNSPinView;", 0)), Reflection.j(new PropertyReference1Impl(b.class, "errorText", "getErrorText()Landroid/widget/TextView;", 0))};

    /* renamed from: k  reason: collision with root package name */
    public static final String f39921k = "SNSEidPinFragment";

    /* renamed from: a  reason: collision with root package name */
    public final kotlin.i f39922a;

    /* renamed from: b  reason: collision with root package name */
    public final String f39923b = DocumentType.f32357l;

    /* renamed from: c  reason: collision with root package name */
    public final z f39924c = a0.a(this, R.id.sns_title);

    /* renamed from: d  reason: collision with root package name */
    public final z f39925d = a0.a(this, R.id.sns_subtitle);

    /* renamed from: e  reason: collision with root package name */
    public final z f39926e = a0.a(this, R.id.sns_pin_code);

    /* renamed from: f  reason: collision with root package name */
    public final z f39927f = a0.a(this, R.id.sns_error);

    /* renamed from: g  reason: collision with root package name */
    public final Screen f39928g = Screen.EidPinPad;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, ? extends Object> f39929h;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final b a(com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.a aVar) {
            b bVar = new b();
            Bundle bundle = new Bundle();
            bundle.putParcelable(SNSEidPinViewModel.J, aVar);
            bVar.setArguments(bundle);
            return bVar;
        }

        public a() {
        }
    }

    /* renamed from: com.sumsub.sns.presentation.screen.preview.ekyc.eid.b$b  reason: collision with other inner class name */
    public static final class C0534b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f39930a;

        public C0534b(b bVar) {
            this.f39930a = bVar;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            if (charSequence != null) {
                this.f39930a.getViewModel().b(charSequence.toString());
                TextView a11 = this.f39930a.k();
                if (a11 != null) {
                    a11.setVisibility(8);
                }
                SNSPinView b11 = this.f39930a.l();
                if (b11 != null) {
                    b11.setError(false);
                }
            }
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.preview.ekyc.eid.SNSEidPinFragment$onViewCreated$2", f = "SNSEidPinFragment.kt", l = {}, m = "invokeSuspend")
    public static final class c extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39931a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f39932b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b bVar, kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
            this.f39932b = bVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((c) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new c(this.f39932b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f39931a == 0) {
                k.b(obj);
                SNSPinView b11 = this.f39932b.l();
                if (b11 != null) {
                    kotlin.coroutines.jvm.internal.a.a(com.sumsub.sns.internal.core.common.i.g(b11));
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class d extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f39933a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
            super(0);
            this.f39933a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f39933a;
        }
    }

    public static final class e extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f39934a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d10.a aVar) {
            super(0);
            this.f39934a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f39934a.invoke();
        }
    }

    public static final class f extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f39935a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(kotlin.i iVar) {
            super(0);
            this.f39935a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f39935a).getViewModelStore();
        }
    }

    public static final class g extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f39936a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f39937b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(d10.a aVar, kotlin.i iVar) {
            super(0);
            this.f39936a = aVar;
            this.f39937b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f39936a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f39937b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class h extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f39938a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f39939b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(Fragment fragment, kotlin.i iVar) {
            super(0);
            this.f39938a = fragment;
            this.f39939b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f39939b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f39938a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class i extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f39940a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(b bVar) {
            super(0);
            this.f39940a = bVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            b bVar = this.f39940a;
            return new SNSEidPinViewModel.d(bVar, bVar.getServiceLocator(), this.f39940a.getArguments());
        }
    }

    public b() {
        i iVar = new i(this);
        kotlin.i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new e(new d(this)));
        this.f39922a = FragmentViewModelLazyKt.c(this, Reflection.b(SNSEidPinViewModel.class), new f(b11), new g((d10.a) null, b11), iVar);
    }

    public Map<String, Object> getAppearPayload() {
        return SNSEidPinViewModel.a(getViewModel(), (SNSEidPinViewModel.Step) null, 1, (Object) null);
    }

    public Map<String, Object> getCancelPayload() {
        return SNSEidPinViewModel.a(getViewModel(), (SNSEidPinViewModel.Step) null, 1, (Object) null);
    }

    public Map<String, Object> getClosePayload() {
        return SNSEidPinViewModel.a(getViewModel(), (SNSEidPinViewModel.Step) null, 1, (Object) null);
    }

    public String getIdDocSetType() {
        return this.f39923b;
    }

    public int getLayoutId() {
        return R.layout.sns_fragment_eid_pin;
    }

    public Map<String, Object> getOpenPayload() {
        return SNSEidPinViewModel.a(getViewModel(), (SNSEidPinViewModel.Step) null, 1, (Object) null);
    }

    public Screen getScreen() {
        return this.f39928g;
    }

    public final TextView getTitle() {
        return (TextView) this.f39924c.a(this, f39920j[0]);
    }

    public void handleEvent(a.j jVar) {
        if (jVar instanceof SNSEidPinViewModel.b) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(n0.d.f32148b, ((SNSEidPinViewModel.b) jVar).b());
            bundle.putParcelable(SNSEidPinViewModel.J, getViewModel().u());
            Unit unit = Unit.f56620a;
            com.sumsub.sns.core.presentation.b.finishWithResult$default(this, 0, bundle, 1, (Object) null);
        } else if (jVar instanceof SNSEidPinViewModel.c) {
            SNSPinView l11 = l();
            if (l11 != null) {
                l11.setError(true);
            }
            TextView k11 = k();
            if (k11 != null) {
                k11.setVisibility(0);
            }
            TextView k12 = k();
            if (k12 != null) {
                k12.setText(((SNSEidPinViewModel.c) jVar).b());
            }
        } else {
            super.handleEvent(jVar);
        }
    }

    public final TextView k() {
        return (TextView) this.f39927f.a(this, f39920j[3]);
    }

    public final SNSPinView l() {
        return (SNSPinView) this.f39926e.a(this, f39920j[2]);
    }

    public final TextView m() {
        return (TextView) this.f39925d.a(this, f39920j[1]);
    }

    /* renamed from: n */
    public SNSEidPinViewModel getViewModel() {
        return (SNSEidPinViewModel) this.f39922a.getValue();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        SNSPinView l11 = l();
        if (l11 != null) {
            l11.addTextChangedListener(new C0534b(this));
        }
        SNSPinView l12 = l();
        if (l12 != null) {
            l12.setPassword(true);
        }
        ViewGroup viewGroup = null;
        v.a(getViewLifecycleOwner()).c(new c(this, (kotlin.coroutines.c<? super c>) null));
        if (view instanceof ViewGroup) {
            viewGroup = (ViewGroup) view;
        }
        if (viewGroup != null) {
            com.sumsub.sns.internal.core.common.i.a(viewGroup);
        }
    }

    /* renamed from: a */
    public void handleState(SNSEidPinViewModel.e eVar, Bundle bundle) {
        Editable text;
        TextView title = getTitle();
        if (title != null) {
            title.setText(eVar.d());
        }
        TextView m11 = m();
        if (m11 != null) {
            m11.setText(eVar.c());
        }
        SNSPinView l11 = l();
        if (l11 != null) {
            l11.setItemCount(eVar.b());
        }
        SNSPinView l12 = l();
        if (!(l12 == null || (text = l12.getText()) == null)) {
            text.clear();
        }
        if (!x.b(this.f39929h, eVar.a()) && (!eVar.a().isEmpty())) {
            Map<String, ? extends Object> map = this.f39929h;
            if (map != null) {
                getAnalyticsDelegate().c(getScreen(), getIdDocSetType(), map);
                getAnalyticsDelegate().d(getScreen(), getIdDocSetType(), eVar.a());
            }
            this.f39929h = eVar.a();
        }
    }
}
