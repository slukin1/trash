package com.sumsub.sns.presentation.dialogs.bottomsheet;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.o;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.core.theme.SNSMetricElement;
import com.sumsub.sns.internal.core.common.u;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import d10.l;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0019\u0010\u0017J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u001a\u0010\u0011\u001a\u00020\f8\u0014XD¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0018\u001a\u00020\u00038TX\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/sumsub/sns/presentation/dialogs/bottomsheet/a;", "Lcom/sumsub/sns/core/presentation/b;", "Lcom/sumsub/sns/core/presentation/base/a$l;", "Lcom/sumsub/sns/internal/presentation/dialogs/bottomsheet/a;", "", "getLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "", "a", "Ljava/lang/String;", "getIdDocSetType", "()Ljava/lang/String;", "idDocSetType", "b", "Lkotlin/i;", "k", "()Lcom/sumsub/sns/internal/presentation/dialogs/bottomsheet/a;", "getViewModel$annotations", "()V", "viewModel", "<init>", "c", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class a extends com.sumsub.sns.core.presentation.b<a.l, com.sumsub.sns.internal.presentation.dialogs.bottomsheet.a> {

    /* renamed from: c  reason: collision with root package name */
    public static final C0519a f39548c = new C0519a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static final String f39549d = "TermsAndConditionsBottomSheet";

    /* renamed from: e  reason: collision with root package name */
    public static final String f39550e = "ARGS_DATA";

    /* renamed from: a  reason: collision with root package name */
    public final String f39551a = DocumentType.f32355j;

    /* renamed from: b  reason: collision with root package name */
    public final i f39552b;

    /* renamed from: com.sumsub.sns.presentation.dialogs.bottomsheet.a$a  reason: collision with other inner class name */
    public static final class C0519a {
        public /* synthetic */ C0519a(r rVar) {
            this();
        }

        public final a a(String str) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putString(a.f39550e, str);
            aVar.setArguments(bundle);
            return aVar;
        }

        public C0519a() {
        }
    }

    public static final class b extends Lambda implements l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39553a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar) {
            super(1);
            this.f39553a = aVar;
        }

        public final void a(String str) {
            this.f39553a.getViewModel().a(str);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    public static final class c extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f39554a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
            super(0);
            this.f39554a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f39554a;
        }
    }

    public static final class d extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f39555a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(d10.a aVar) {
            super(0);
            this.f39555a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f39555a.invoke();
        }
    }

    public static final class e extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f39556a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(i iVar) {
            super(0);
            this.f39556a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f39556a).getViewModelStore();
        }
    }

    public static final class f extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f39557a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f39558b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(d10.a aVar, i iVar) {
            super(0);
            this.f39557a = aVar;
            this.f39558b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f39557a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f39558b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class g extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f39559a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f39560b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(Fragment fragment, i iVar) {
            super(0);
            this.f39559a = fragment;
            this.f39560b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f39560b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f39559a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class h extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39561a;

        /* renamed from: com.sumsub.sns.presentation.dialogs.bottomsheet.a$h$a  reason: collision with other inner class name */
        public static final class C0520a implements ViewModelProvider.Factory {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f39562a;

            public C0520a(a aVar) {
                this.f39562a = aVar;
            }

            public <T extends ViewModel> T create(Class<T> cls) {
                return new com.sumsub.sns.internal.presentation.dialogs.bottomsheet.a(this.f39562a.getServiceLocator().n(), this.f39562a.getServiceLocator().p());
            }

            public /* bridge */ /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                return o0.b(this, cls, creationExtras);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(a aVar) {
            super(0);
            this.f39561a = aVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            return new C0520a(this.f39561a);
        }
    }

    public a() {
        h hVar = new h(this);
        i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new d(new c(this)));
        this.f39552b = FragmentViewModelLazyKt.c(this, Reflection.b(com.sumsub.sns.internal.presentation.dialogs.bottomsheet.a.class), new e(b11), new f((d10.a) null, b11), hVar);
    }

    public static /* synthetic */ void l() {
    }

    public String getIdDocSetType() {
        return this.f39551a;
    }

    public int getLayoutId() {
        return R.layout.sns_fragment_terms_and_conditions;
    }

    /* renamed from: k */
    public com.sumsub.sns.internal.presentation.dialogs.bottomsheet.a getViewModel() {
        return (com.sumsub.sns.internal.presentation.dialogs.bottomsheet.a) this.f39552b.getValue();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Float a11;
        String string;
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.sns_text);
        WebView webView = (WebView) view.findViewById(R.id.sns_webview);
        NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.sns_content);
        NestedScrollView nestedScrollView2 = (NestedScrollView) view.findViewById(R.id.sns_web_content);
        Bundle arguments = getArguments();
        if (!(arguments == null || (string = arguments.getString(f39550e)) == null)) {
            if (u.a(string)) {
                nestedScrollView.setVisibility(8);
                WebView webView2 = webView;
                String str = string;
                String str2 = "text/html";
                String str3 = "UTF-8";
                webView2.loadDataWithBaseURL((String) null, str, str2, str3, (String) null);
                SensorsDataAutoTrackHelper.loadDataWithBaseURL2(webView2, (String) null, str, str2, str3, (String) null);
            } else {
                nestedScrollView2.setVisibility(8);
                textView.setText(com.sumsub.sns.internal.core.common.i.a((CharSequence) string, requireContext()));
                com.sumsub.sns.core.common.b.a(textView, (l<? super String, Unit>) new b(this));
            }
        }
        com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
        com.sumsub.sns.internal.core.theme.d a12 = aVar.a();
        if (a12 != null && (a11 = aVar.a(a12, SNSMetricElement.SCREEN_HORIZONTAL_MARGIN)) != null) {
            int floatValue = (int) a11.floatValue();
            nestedScrollView2.setPadding(floatValue, nestedScrollView2.getPaddingTop(), floatValue, nestedScrollView2.getPaddingBottom());
        }
    }
}
