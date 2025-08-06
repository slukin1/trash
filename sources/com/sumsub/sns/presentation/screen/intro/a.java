package com.sumsub.sns.presentation.screen.intro;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.data.model.SNSLivenessReason;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.common.z;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.reflect.l;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00038TX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8TX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/sumsub/sns/presentation/screen/intro/a;", "Lcom/sumsub/sns/core/presentation/b;", "Lcom/sumsub/sns/core/presentation/base/a$l;", "Lcom/sumsub/sns/internal/presentation/screen/intro/a;", "", "getLayoutId", "state", "Landroid/os/Bundle;", "savedInstanceState", "", "handleState", "Lcom/sumsub/sns/internal/core/common/q;", "finishReason", "", "onFinishCalled", "Landroid/view/ViewGroup;", "a", "Lcom/sumsub/sns/internal/core/common/z;", "k", "()Landroid/view/ViewGroup;", "content", "b", "Lkotlin/i;", "l", "()Lcom/sumsub/sns/internal/presentation/screen/intro/a;", "viewModel", "", "getIdDocSetType", "()Ljava/lang/String;", "idDocSetType", "<init>", "()V", "c", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class a extends com.sumsub.sns.core.presentation.b<a.l, com.sumsub.sns.internal.presentation.screen.intro.a> {

    /* renamed from: c  reason: collision with root package name */
    public static final C0530a f39800c = new C0530a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ l<Object>[] f39801d = {Reflection.j(new PropertyReference1Impl(a.class, "content", "getContent()Landroid/view/ViewGroup;", 0))};

    /* renamed from: e  reason: collision with root package name */
    public static final String f39802e = "SNSIntroScreenFragment";

    /* renamed from: a  reason: collision with root package name */
    public final z f39803a = a0.a(this, R.id.sns_container);

    /* renamed from: b  reason: collision with root package name */
    public final i f39804b;

    /* renamed from: com.sumsub.sns.presentation.screen.intro.a$a  reason: collision with other inner class name */
    public static final class C0530a {
        public /* synthetic */ C0530a(r rVar) {
            this();
        }

        public static /* synthetic */ a a(C0530a aVar, String str, String str2, String str3, boolean z11, String str4, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                z11 = false;
            }
            boolean z12 = z11;
            if ((i11 & 16) != 0) {
                str4 = null;
            }
            return aVar.a(str, str2, str3, z12, str4);
        }

        public C0530a() {
        }

        public final a a(String str, String str2, String str3, boolean z11, String str4) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putString(com.sumsub.sns.internal.presentation.screen.intro.a.f35264w, str);
            bundle.putString(com.sumsub.sns.internal.presentation.screen.intro.a.f35265x, str3);
            bundle.putString(com.sumsub.sns.internal.presentation.screen.intro.a.f35266y, str2);
            bundle.putString(com.sumsub.sns.internal.presentation.screen.intro.a.f35267z, str4);
            bundle.putBoolean(com.sumsub.sns.internal.presentation.screen.intro.a.A, z11);
            aVar.setArguments(bundle);
            return aVar;
        }
    }

    public static final class b extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f39805a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.f39805a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f39805a;
        }
    }

    public static final class c extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f39806a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(d10.a aVar) {
            super(0);
            this.f39806a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f39806a.invoke();
        }
    }

    public static final class d extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f39807a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(i iVar) {
            super(0);
            this.f39807a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f39807a).getViewModelStore();
        }
    }

    public static final class e extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f39808a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f39809b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d10.a aVar, i iVar) {
            super(0);
            this.f39808a = aVar;
            this.f39809b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f39808a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f39809b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class f extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f39810a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f39811b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment, i iVar) {
            super(0);
            this.f39810a = fragment;
            this.f39811b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f39811b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f39810a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class g extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39812a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(a aVar) {
            super(0);
            this.f39812a = aVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            a aVar = this.f39812a;
            return new com.sumsub.sns.internal.presentation.screen.intro.b(aVar, aVar.getServiceLocator(), this.f39812a.getArguments());
        }
    }

    public a() {
        g gVar = new g(this);
        i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new c(new b(this)));
        this.f39804b = FragmentViewModelLazyKt.c(this, Reflection.b(com.sumsub.sns.internal.presentation.screen.intro.a.class), new d(b11), new e((d10.a) null, b11), gVar);
    }

    public static final a a(String str, String str2, String str3, boolean z11, String str4) {
        return f39800c.a(str, str2, str3, z11, str4);
    }

    public String getIdDocSetType() {
        return getViewModel().r();
    }

    public int getLayoutId() {
        return R.layout.sns_fragment_intro;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleState(com.sumsub.sns.core.presentation.base.a.l r8, android.os.Bundle r9) {
        /*
            r7 = this;
            boolean r9 = r8 instanceof com.sumsub.sns.internal.presentation.screen.intro.a.c
            if (r9 == 0) goto L_0x00b7
            com.sumsub.sns.internal.presentation.screen.intro.a$c r8 = (com.sumsub.sns.internal.presentation.screen.intro.a.c) r8
            java.util.Map r9 = r8.c()
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x0012
            goto L_0x00b7
        L_0x0012:
            com.sumsub.sns.internal.core.common.e0 r9 = com.sumsub.sns.internal.core.common.e0.f32018a
            com.sumsub.sns.core.data.listener.SNSInstructionsViewHandler r0 = r9.getInstructionsViewHandler()
            r9 = 0
            if (r0 == 0) goto L_0x0067
            android.content.Context r1 = r7.requireContext()
            com.sumsub.sns.internal.core.presentation.intro.f r2 = r8.d()
            java.lang.String r2 = r2.c()
            com.sumsub.sns.internal.core.presentation.intro.f r3 = r8.d()
            java.lang.String r3 = r3.a()
            com.sumsub.sns.internal.core.presentation.intro.f r4 = r8.d()
            java.lang.String r4 = r4.b()
            com.sumsub.sns.core.data.listener.SNSInstructionsViewHandler$Position r5 = com.sumsub.sns.core.data.listener.SNSInstructionsViewHandler.Position.FULLSCREEN
            java.lang.String r5 = r5.getValue()
            com.sumsub.sns.internal.presentation.screen.intro.a r6 = r7.getViewModel()
            java.lang.String r6 = r6.p()
            android.view.View r0 = r0.onVerificationStep(r1, r2, r3, r4, r5, r6)
            if (r0 == 0) goto L_0x0067
            android.view.ViewGroup r1 = r7.k()
            if (r1 == 0) goto L_0x0054
            r1.removeAllViews()
        L_0x0054:
            android.view.ViewGroup r1 = r7.k()
            if (r1 == 0) goto L_0x0067
            android.view.ViewGroup$MarginLayoutParams r2 = new android.view.ViewGroup$MarginLayoutParams
            r3 = -1
            r4 = -2
            r2.<init>(r3, r4)
            r1.addView(r0, r2)
            kotlin.Unit r0 = kotlin.Unit.f56620a
            goto L_0x0068
        L_0x0067:
            r0 = r9
        L_0x0068:
            if (r0 != 0) goto L_0x008b
            com.sumsub.sns.core.presentation.intro.b r0 = new com.sumsub.sns.core.presentation.intro.b
            com.sumsub.sns.internal.core.a r1 = r7.getServiceLocator()
            com.sumsub.sns.internal.core.data.source.extensions.a r1 = r1.q()
            r2 = 0
            r3 = 2
            r0.<init>(r1, r2, r3, r9)
            android.view.View r1 = r7.getView()
            if (r1 != 0) goto L_0x0080
            goto L_0x008b
        L_0x0080:
            java.util.Map r2 = r8.c()
            int r3 = com.sumsub.sns.R.id.sns_container
            int r4 = com.sumsub.sns.R.id.sns_primary_button
            r0.a(r1, r2, r3, r4)
        L_0x008b:
            android.view.View r0 = r7.getView()
            if (r0 == 0) goto L_0x00b7
            int r1 = com.sumsub.sns.R.id.sns_primary_button
            android.view.View r0 = r0.findViewById(r1)
            android.widget.Button r0 = (android.widget.Button) r0
            if (r0 == 0) goto L_0x00b7
            java.util.Map r8 = r8.c()
            java.lang.String r1 = "actionTitle"
            java.lang.Object r8 = r8.get(r1)
            boolean r1 = r8 instanceof java.lang.String
            if (r1 == 0) goto L_0x00ac
            r9 = r8
            java.lang.String r9 = (java.lang.String) r9
        L_0x00ac:
            r0.setText(r9)
            com.sumsub.sns.presentation.screen.intro.b r8 = new com.sumsub.sns.presentation.screen.intro.b
            r8.<init>(r7)
            r0.setOnClickListener(r8)
        L_0x00b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.intro.a.handleState(com.sumsub.sns.core.presentation.base.a$l, android.os.Bundle):void");
    }

    public final ViewGroup k() {
        return (ViewGroup) this.f39803a.a(this, f39801d[0]);
    }

    /* renamed from: l */
    public com.sumsub.sns.internal.presentation.screen.intro.a getViewModel() {
        return (com.sumsub.sns.internal.presentation.screen.intro.a) this.f39804b.getValue();
    }

    public boolean onFinishCalled(q qVar) {
        if (!(qVar instanceof q.c) || !getViewModel().s()) {
            return super.onFinishCalled(qVar);
        }
        com.sumsub.sns.core.presentation.b.finish$default(this, new q.d(new SNSCompletionResult.SuccessTermination((SNSLivenessReason) null, 1, (r) null)), (Object) null, (Long) null, 6, (Object) null);
        return false;
    }

    public static final void a(a aVar, View view) {
        com.sumsub.sns.core.presentation.b.setResult$default(aVar, 0, new Bundle(), 1, (Object) null);
    }
}
