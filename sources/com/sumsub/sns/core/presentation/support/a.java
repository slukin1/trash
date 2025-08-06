package com.sumsub.sns.core.presentation.support;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.support.b;
import com.sumsub.sns.core.widget.SNSStepViewExtensionsKt;
import com.sumsub.sns.core.widget.SNSSupportItemView;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\nB\u0007¢\u0006\u0004\b%\u0010&J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014R\u001b\u0010\u000e\u001a\u00020\u00038TX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000f8\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u00158\u0014XD¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u0004\u0018\u00010\u001b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0016\u0010$\u001a\u0004\u0018\u00010!8BX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/sumsub/sns/core/presentation/support/a;", "Lcom/sumsub/sns/core/presentation/b;", "Lcom/sumsub/sns/core/presentation/support/b$b;", "Lcom/sumsub/sns/core/presentation/support/b;", "", "getLayoutId", "state", "Landroid/os/Bundle;", "savedInstanceState", "", "a", "Lkotlin/i;", "n", "()Lcom/sumsub/sns/core/presentation/support/b;", "viewModel", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "b", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "getScreen", "()Lcom/sumsub/sns/internal/core/analytics/Screen;", "screen", "", "c", "Ljava/lang/String;", "getIdDocSetType", "()Ljava/lang/String;", "idDocSetType", "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "tvTitle", "k", "tvSubtitle", "Landroid/view/ViewGroup;", "m", "()Landroid/view/ViewGroup;", "vgItems", "<init>", "()V", "d", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class a extends com.sumsub.sns.core.presentation.b<b.C0298b, b> {

    /* renamed from: d  reason: collision with root package name */
    public static final C0297a f31170d = new C0297a((r) null);

    /* renamed from: e  reason: collision with root package name */
    public static final String f31171e = "SNSSupportFragment";

    /* renamed from: a  reason: collision with root package name */
    public final i f31172a;

    /* renamed from: b  reason: collision with root package name */
    public final Screen f31173b = Screen.SupportScreen;

    /* renamed from: c  reason: collision with root package name */
    public final String f31174c = DocumentType.f32355j;

    /* renamed from: com.sumsub.sns.core.presentation.support.a$a  reason: collision with other inner class name */
    public static final class C0297a {
        public /* synthetic */ C0297a(r rVar) {
            this();
        }

        public final Fragment a() {
            return new a();
        }

        public C0297a() {
        }
    }

    public static final class b extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f31175a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.f31175a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f31175a;
        }
    }

    public static final class c extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f31176a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(d10.a aVar) {
            super(0);
            this.f31176a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f31176a.invoke();
        }
    }

    public static final class d extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f31177a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(i iVar) {
            super(0);
            this.f31177a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f31177a).getViewModelStore();
        }
    }

    public static final class e extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f31178a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f31179b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d10.a aVar, i iVar) {
            super(0);
            this.f31178a = aVar;
            this.f31179b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f31178a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f31179b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class f extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f31180a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f31181b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment, i iVar) {
            super(0);
            this.f31180a = fragment;
            this.f31181b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f31181b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f31180a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class g extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31182a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(a aVar) {
            super(0);
            this.f31182a = aVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            return new c(this.f31182a.getServiceLocator());
        }
    }

    public a() {
        g gVar = new g(this);
        i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new c(new b(this)));
        this.f31172a = FragmentViewModelLazyKt.c(this, Reflection.b(b.class), new d(b11), new e((d10.a) null, b11), gVar);
    }

    public String getIdDocSetType() {
        return this.f31174c;
    }

    public int getLayoutId() {
        return R.layout.sns_bottom_sheet_support;
    }

    public Screen getScreen() {
        return this.f31173b;
    }

    public final TextView k() {
        View view = getView();
        if (view != null) {
            return (TextView) view.findViewById(R.id.sns_subtitle);
        }
        return null;
    }

    public final TextView l() {
        View view = getView();
        if (view != null) {
            return (TextView) view.findViewById(R.id.sns_title);
        }
        return null;
    }

    public final ViewGroup m() {
        View view = getView();
        if (view != null) {
            return (ViewGroup) view.findViewById(R.id.sns_list);
        }
        return null;
    }

    /* renamed from: n */
    public b getViewModel() {
        return (b) this.f31172a.getValue();
    }

    /* renamed from: a */
    public void handleState(b.C0298b bVar, Bundle bundle) {
        TextView l11 = l();
        if (l11 != null) {
            com.sumsub.sns.internal.core.common.i.a(l11, bVar.f());
        }
        TextView k11 = k();
        if (k11 != null) {
            com.sumsub.sns.internal.core.common.i.a(k11, bVar.d());
        }
        ViewGroup m11 = m();
        if (m11 != null) {
            m11.removeAllViews();
        }
        for (b.a aVar : bVar.e()) {
            SNSSupportItemView sNSSupportItemView = new SNSSupportItemView(requireContext(), (AttributeSet) null, 0, 0, 14, (r) null);
            SNSStepViewExtensionsKt.setSnsStepState(sNSSupportItemView, aVar.h());
            Drawable f11 = aVar.f();
            if (f11 == null) {
                String iconName = aVar.g().getIconName();
                f11 = iconName != null ? e0.f32018a.getIconHandler().onResolveIcon(requireContext(), iconName) : null;
            }
            sNSSupportItemView.setIconStart(f11);
            sNSSupportItemView.setTitle(aVar.j());
            sNSSupportItemView.setSubtitle(aVar.i());
            sNSSupportItemView.setOnClickListener(new d(aVar, this));
            ViewGroup m12 = m();
            if (m12 != null) {
                m12.addView(sNSSupportItemView);
            }
        }
    }

    public static final void a(b.a aVar, a aVar2, View view) {
        if (!com.sumsub.sns.core.common.b.a(aVar.g(), aVar2.requireContext())) {
            com.sumsub.sns.internal.log.a aVar3 = com.sumsub.sns.internal.log.a.f34862a;
            com.sumsub.log.logger.a.b(aVar3, f31171e, "The SDK is not possible to resolve a click on support item (" + aVar + ')', (Throwable) null, 4, (Object) null);
        }
    }
}
