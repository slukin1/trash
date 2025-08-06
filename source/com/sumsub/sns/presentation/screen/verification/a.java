package com.sumsub.sns.presentation.screen.verification;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.core.presentation.base.adapter.c;
import com.sumsub.sns.core.widget.SNSAlertDialogBuilder;
import com.sumsub.sns.internal.core.analytics.Control;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.k0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.common.z;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.presentation.screen.verification.b;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.reflect.l;

@Metadata(bv = {}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 :2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0007¢\u0006\u0004\b8\u00109J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002R\u001b\u0010\u0017\u001a\u00020\u00038TX\u0002¢\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00188\u0014XD¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010#\u001a\u0004\u0018\u00010\u001e8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010&\u001a\u0004\u0018\u00010\u001e8BX\u0002¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"R\u001d\u0010)\u001a\u0004\u0018\u00010\u001e8BX\u0002¢\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b(\u0010\"R\u001d\u0010.\u001a\u0004\u0018\u00010*8BX\u0002¢\u0006\f\n\u0004\b+\u0010 \u001a\u0004\b,\u0010-R\u001d\u00103\u001a\u0004\u0018\u00010/8BX\u0002¢\u0006\f\n\u0004\b0\u0010 \u001a\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u0006;"}, d2 = {"Lcom/sumsub/sns/presentation/screen/verification/a;", "Lcom/sumsub/sns/core/presentation/b;", "Lcom/sumsub/sns/internal/presentation/screen/verification/d;", "Lcom/sumsub/sns/internal/presentation/screen/verification/b;", "", "getLayoutId", "Lcom/sumsub/sns/core/presentation/base/a$j;", "event", "", "handleEvent", "state", "Landroid/os/Bundle;", "savedInstanceState", "a", "Lcom/sumsub/sns/internal/core/common/q;", "finishReason", "", "onFinishCalled", "Lcom/sumsub/sns/internal/presentation/screen/verification/a;", "exitDialog", "Lkotlin/i;", "p", "()Lcom/sumsub/sns/internal/presentation/screen/verification/b;", "viewModel", "", "b", "Ljava/lang/String;", "getIdDocSetType", "()Ljava/lang/String;", "idDocSetType", "Landroid/widget/TextView;", "c", "Lcom/sumsub/sns/internal/core/common/z;", "o", "()Landroid/widget/TextView;", "tvTitle", "d", "n", "tvSubtitle", "e", "m", "tvFooter", "Landroid/widget/Button;", "f", "k", "()Landroid/widget/Button;", "btnContinue", "Landroidx/recyclerview/widget/RecyclerView;", "g", "l", "()Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/appcompat/app/AlertDialog;", "h", "Landroidx/appcompat/app/AlertDialog;", "exitConfirmationDialog", "<init>", "()V", "i", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class a extends com.sumsub.sns.core.presentation.b<com.sumsub.sns.internal.presentation.screen.verification.d, com.sumsub.sns.internal.presentation.screen.verification.b> {

    /* renamed from: i  reason: collision with root package name */
    public static final C0540a f40121i = new C0540a((r) null);

    /* renamed from: j  reason: collision with root package name */
    public static final /* synthetic */ l<Object>[] f40122j = {Reflection.j(new PropertyReference1Impl(a.class, "tvTitle", "getTvTitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "tvSubtitle", "getTvSubtitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "tvFooter", "getTvFooter()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "btnContinue", "getBtnContinue()Landroid/widget/Button;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "recycler", "getRecycler()Landroidx/recyclerview/widget/RecyclerView;", 0))};

    /* renamed from: k  reason: collision with root package name */
    public static final String f40123k = "SNSApplicantStatusFragment";

    /* renamed from: a  reason: collision with root package name */
    public final kotlin.i f40124a;

    /* renamed from: b  reason: collision with root package name */
    public final String f40125b = DocumentType.f32355j;

    /* renamed from: c  reason: collision with root package name */
    public final z f40126c = a0.a(this, R.id.sns_title);

    /* renamed from: d  reason: collision with root package name */
    public final z f40127d = a0.a(this, R.id.sns_subtitle);

    /* renamed from: e  reason: collision with root package name */
    public final z f40128e = a0.a(this, R.id.sns_footer);

    /* renamed from: f  reason: collision with root package name */
    public final z f40129f = a0.a(this, R.id.sns_primary_button);

    /* renamed from: g  reason: collision with root package name */
    public final z f40130g = a0.a(this, R.id.sns_list);

    /* renamed from: h  reason: collision with root package name */
    public AlertDialog f40131h;

    /* renamed from: com.sumsub.sns.presentation.screen.verification.a$a  reason: collision with other inner class name */
    public static final class C0540a {
        public /* synthetic */ C0540a(r rVar) {
            this();
        }

        public final Fragment a() {
            return new a();
        }

        public C0540a() {
        }
    }

    public static final class b extends Lambda implements d10.l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f40132a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar) {
            super(1);
            this.f40132a = aVar;
        }

        public final void a(String str) {
            this.f40132a.getViewModel().b(str);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    public static final class c implements c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f40133a;

        public c(a aVar) {
            this.f40133a = aVar;
        }

        public void a(Document document) {
            if (document != null) {
                this.f40133a.getViewModel().a(document);
            }
        }

        public void a(String str) {
            if (str != null) {
                this.f40133a.getViewModel().a(str);
            }
        }
    }

    public static final class d extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f40134a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
            super(0);
            this.f40134a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f40134a;
        }
    }

    public static final class e extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f40135a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d10.a aVar) {
            super(0);
            this.f40135a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f40135a.invoke();
        }
    }

    public static final class f extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f40136a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(kotlin.i iVar) {
            super(0);
            this.f40136a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f40136a).getViewModelStore();
        }
    }

    public static final class g extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f40137a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f40138b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(d10.a aVar, kotlin.i iVar) {
            super(0);
            this.f40137a = aVar;
            this.f40138b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f40137a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f40138b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class h extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f40139a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f40140b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(Fragment fragment, kotlin.i iVar) {
            super(0);
            this.f40139a = fragment;
            this.f40140b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f40140b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f40139a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class i extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f40141a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(a aVar) {
            super(0);
            this.f40141a = aVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            a aVar = this.f40141a;
            return new com.sumsub.sns.internal.presentation.screen.verification.c(aVar, aVar.getServiceLocator(), this.f40141a.getArguments());
        }
    }

    public a() {
        i iVar = new i(this);
        kotlin.i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new e(new d(this)));
        this.f40124a = FragmentViewModelLazyKt.c(this, Reflection.b(com.sumsub.sns.internal.presentation.screen.verification.b.class), new f(b11), new g((d10.a) null, b11), iVar);
    }

    public static final void b(a aVar, View view) {
        com.sumsub.sns.internal.core.analytics.c.b(aVar.getAnalyticsDelegate(), aVar.getScreen(), aVar.getIdDocSetType(), Control.ContinueButton, (Map) null, 8, (Object) null);
        k0 appListener = aVar.getAppListener();
        if (appListener != null) {
            appListener.a();
        }
    }

    public String getIdDocSetType() {
        return this.f40125b;
    }

    public int getLayoutId() {
        return R.layout.sns_fragment_applicant_status;
    }

    public void handleEvent(a.j jVar) {
        if (jVar instanceof b.C0486b) {
            com.sumsub.sns.core.presentation.b.navigateTo$default(this, com.sumsub.sns.presentation.dialogs.bottomsheet.a.f39548c.a(((b.C0486b) jVar).b()), (String) null, 2, (Object) null);
        } else {
            super.handleEvent(jVar);
        }
    }

    public final Button k() {
        return (Button) this.f40129f.a(this, f40122j[3]);
    }

    public final RecyclerView l() {
        return (RecyclerView) this.f40130g.a(this, f40122j[4]);
    }

    public final TextView m() {
        return (TextView) this.f40128e.a(this, f40122j[2]);
    }

    public final TextView n() {
        return (TextView) this.f40127d.a(this, f40122j[1]);
    }

    public final TextView o() {
        return (TextView) this.f40126c.a(this, f40122j[0]);
    }

    public boolean onFinishCalled(q qVar) {
        if (!(qVar instanceof q.c)) {
            return super.onFinishCalled(qVar);
        }
        AlertDialog alertDialog = this.f40131h;
        if (alertDialog != null) {
            alertDialog.show();
        } else {
            com.sumsub.sns.core.presentation.b.finish$default(this, new q.d((SNSCompletionResult) null, 1, (r) null), (Object) null, (Long) null, 6, (Object) null);
        }
        return false;
    }

    /* renamed from: p */
    public com.sumsub.sns.internal.presentation.screen.verification.b getViewModel() {
        return (com.sumsub.sns.internal.presentation.screen.verification.b) this.f40124a.getValue();
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r2v4, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleState(com.sumsub.sns.internal.presentation.screen.verification.d r11, android.os.Bundle r12) {
        /*
            r10 = this;
            android.widget.TextView r12 = r10.o()
            r0 = 1
            r1 = 0
            r2 = 0
            if (r12 == 0) goto L_0x002f
            java.lang.CharSequence r3 = r11.e()
            if (r3 == 0) goto L_0x0018
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r3 = r1
            goto L_0x0019
        L_0x0018:
            r3 = r0
        L_0x0019:
            com.sumsub.sns.internal.core.common.i.a((android.view.View) r12, (boolean) r3)
            java.lang.CharSequence r3 = r11.e()
            if (r3 == 0) goto L_0x002b
            android.content.Context r4 = r12.getContext()
            android.text.Spanned r3 = com.sumsub.sns.internal.core.common.i.a((java.lang.CharSequence) r3, (android.content.Context) r4)
            goto L_0x002c
        L_0x002b:
            r3 = r2
        L_0x002c:
            r12.setText(r3)
        L_0x002f:
            android.widget.TextView r12 = r10.n()
            if (r12 == 0) goto L_0x005b
            java.lang.CharSequence r3 = r11.d()
            if (r3 == 0) goto L_0x0044
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0042
            goto L_0x0044
        L_0x0042:
            r3 = r1
            goto L_0x0045
        L_0x0044:
            r3 = r0
        L_0x0045:
            com.sumsub.sns.internal.core.common.i.a((android.view.View) r12, (boolean) r3)
            java.lang.CharSequence r3 = r11.d()
            if (r3 == 0) goto L_0x0057
            android.content.Context r4 = r12.getContext()
            android.text.Spanned r3 = com.sumsub.sns.internal.core.common.i.a((java.lang.CharSequence) r3, (android.content.Context) r4)
            goto L_0x0058
        L_0x0057:
            r3 = r2
        L_0x0058:
            r12.setText(r3)
        L_0x005b:
            android.widget.TextView r12 = r10.m()
            if (r12 == 0) goto L_0x008f
            java.lang.CharSequence r3 = r11.c()
            if (r3 == 0) goto L_0x0070
            int r3 = r3.length()
            if (r3 != 0) goto L_0x006e
            goto L_0x0070
        L_0x006e:
            r3 = r1
            goto L_0x0071
        L_0x0070:
            r3 = r0
        L_0x0071:
            com.sumsub.sns.internal.core.common.i.a((android.view.View) r12, (boolean) r3)
            java.lang.CharSequence r3 = r11.c()
            if (r3 == 0) goto L_0x0083
            android.content.Context r4 = r12.getContext()
            android.text.Spanned r3 = com.sumsub.sns.internal.core.common.i.a((java.lang.CharSequence) r3, (android.content.Context) r4)
            goto L_0x0084
        L_0x0083:
            r3 = r2
        L_0x0084:
            r12.setText(r3)
            com.sumsub.sns.presentation.screen.verification.a$b r3 = new com.sumsub.sns.presentation.screen.verification.a$b
            r3.<init>(r10)
            com.sumsub.sns.core.common.b.a((android.widget.TextView) r12, (d10.l<? super java.lang.String, kotlin.Unit>) r3)
        L_0x008f:
            android.widget.Button r12 = r10.k()
            if (r12 == 0) goto L_0x00ad
            java.lang.CharSequence r3 = r11.a()
            if (r3 == 0) goto L_0x00a3
            int r3 = r3.length()
            if (r3 != 0) goto L_0x00a2
            goto L_0x00a3
        L_0x00a2:
            r0 = r1
        L_0x00a3:
            com.sumsub.sns.internal.core.common.i.a((android.view.View) r12, (boolean) r0)
            java.lang.CharSequence r0 = r11.a()
            r12.setText(r0)
        L_0x00ad:
            androidx.recyclerview.widget.RecyclerView r12 = r10.l()
            r0 = -2
            if (r12 == 0) goto L_0x011f
            java.util.List r3 = r11.b()
            boolean r3 = r3.isEmpty()
            com.sumsub.sns.internal.core.common.i.a((android.view.View) r12, (boolean) r3)
            java.util.List r3 = r11.b()
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x011f
            androidx.recyclerview.widget.RecyclerView$Adapter r3 = r12.getAdapter()
            if (r3 != 0) goto L_0x00e8
            androidx.recyclerview.widget.LinearLayoutManager r3 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r4 = r12.getContext()
            r3.<init>(r4)
            r12.setLayoutManager(r3)
            com.sumsub.sns.core.presentation.base.adapter.c r3 = new com.sumsub.sns.core.presentation.base.adapter.c
            com.sumsub.sns.presentation.screen.verification.a$c r4 = new com.sumsub.sns.presentation.screen.verification.a$c
            r4.<init>(r10)
            r3.<init>(r4)
            r12.setAdapter(r3)
        L_0x00e8:
            androidx.recyclerview.widget.RecyclerView$Adapter r3 = r12.getAdapter()
            if (r3 == 0) goto L_0x0113
            com.sumsub.sns.core.presentation.base.adapter.c r3 = (com.sumsub.sns.core.presentation.base.adapter.c) r3
            java.util.List r4 = r11.b()
            r3.a(r4)
            android.view.ViewGroup$LayoutParams r12 = r12.getLayoutParams()
            boolean r3 = r12 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r3 == 0) goto L_0x0102
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r12 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r12
            goto L_0x0103
        L_0x0102:
            r12 = r2
        L_0x0103:
            boolean r3 = r11 instanceof com.sumsub.sns.internal.presentation.screen.verification.d.C0487d
            if (r3 == 0) goto L_0x010d
            if (r12 != 0) goto L_0x010a
            goto L_0x011f
        L_0x010a:
            r12.height = r0
            goto L_0x011f
        L_0x010d:
            if (r12 != 0) goto L_0x0110
            goto L_0x011f
        L_0x0110:
            r12.height = r1
            goto L_0x011f
        L_0x0113:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "Required value was null."
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x011f:
            r10.f40131h = r2
            boolean r12 = r11 instanceof com.sumsub.sns.internal.presentation.screen.verification.d.e
            if (r12 == 0) goto L_0x01fb
            android.view.View r12 = r10.getView()
            if (r12 == 0) goto L_0x01e1
            android.view.View r12 = r10.getView()
            if (r12 == 0) goto L_0x0138
            int r3 = com.sumsub.sns.R.id.sns_content
            android.view.View r12 = r12.findViewById(r3)
            goto L_0x0139
        L_0x0138:
            r12 = r2
        L_0x0139:
            if (r12 != 0) goto L_0x013c
            goto L_0x013f
        L_0x013c:
            r12.setVisibility(r1)
        L_0x013f:
            com.sumsub.sns.internal.core.common.e0 r12 = com.sumsub.sns.internal.core.common.e0.f32018a
            com.sumsub.sns.core.data.listener.SNSInstructionsViewHandler r3 = r12.getInstructionsViewHandler()
            if (r3 == 0) goto L_0x0160
            android.content.Context r4 = r10.requireContext()
            com.sumsub.sns.internal.core.presentation.intro.IntroScene r12 = com.sumsub.sns.internal.core.presentation.intro.IntroScene.VIDEO_IDENT
            java.lang.String r7 = r12.getSceneName()
            com.sumsub.sns.core.data.listener.SNSInstructionsViewHandler$Position r12 = com.sumsub.sns.core.data.listener.SNSInstructionsViewHandler.Position.FULLSCREEN
            java.lang.String r8 = r12.getValue()
            r6 = 0
            r9 = 0
            java.lang.String r5 = "VIDEO_IDENT"
            android.view.View r12 = r3.onVerificationStep(r4, r5, r6, r7, r8, r9)
            goto L_0x0161
        L_0x0160:
            r12 = r2
        L_0x0161:
            if (r12 == 0) goto L_0x01c1
            android.view.View r1 = r10.getView()
            if (r1 == 0) goto L_0x0170
            int r3 = com.sumsub.sns.R.id.sns_content
            android.view.View r1 = r1.findViewById(r3)
            goto L_0x0171
        L_0x0170:
            r1 = r2
        L_0x0171:
            boolean r3 = r1 instanceof android.view.ViewGroup
            if (r3 == 0) goto L_0x0178
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            goto L_0x0179
        L_0x0178:
            r1 = r2
        L_0x0179:
            if (r1 == 0) goto L_0x0199
            r1.removeAllViews()
            android.view.ViewGroup$MarginLayoutParams r3 = new android.view.ViewGroup$MarginLayoutParams
            r4 = -1
            r3.<init>(r4, r0)
            android.content.res.Resources r0 = r10.getResources()
            int r4 = com.sumsub.sns.R.dimen.sns_margin_medium
            int r0 = r0.getDimensionPixelSize(r4)
            r3.setMarginStart(r0)
            r3.setMarginEnd(r0)
            kotlin.Unit r0 = kotlin.Unit.f56620a
            r1.addView(r12, r3)
        L_0x0199:
            android.view.View r12 = r10.getView()
            if (r12 == 0) goto L_0x01e1
            int r0 = com.sumsub.sns.R.id.sns_primary_button
            android.view.View r12 = r12.findViewById(r0)
            android.widget.Button r12 = (android.widget.Button) r12
            if (r12 == 0) goto L_0x01e1
            r0 = r11
            com.sumsub.sns.internal.presentation.screen.verification.d$e r0 = (com.sumsub.sns.internal.presentation.screen.verification.d.e) r0
            java.util.Map r0 = r0.f()
            java.lang.String r1 = "actionTitle"
            java.lang.Object r0 = r0.get(r1)
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L_0x01bd
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
        L_0x01bd:
            r12.setText(r2)
            goto L_0x01e1
        L_0x01c1:
            com.sumsub.sns.core.presentation.intro.b r12 = new com.sumsub.sns.core.presentation.intro.b
            com.sumsub.sns.internal.core.a r0 = r10.getServiceLocator()
            com.sumsub.sns.internal.core.data.source.extensions.a r0 = r0.q()
            r3 = 2
            r12.<init>(r0, r1, r3, r2)
            android.view.View r0 = r10.requireView()
            r1 = r11
            com.sumsub.sns.internal.presentation.screen.verification.d$e r1 = (com.sumsub.sns.internal.presentation.screen.verification.d.e) r1
            java.util.Map r1 = r1.f()
            int r2 = com.sumsub.sns.R.id.sns_content
            int r3 = com.sumsub.sns.R.id.sns_primary_button
            r12.a(r0, r1, r2, r3)
        L_0x01e1:
            android.widget.Button r12 = r10.k()
            if (r12 == 0) goto L_0x01ef
            com.sumsub.sns.presentation.screen.verification.h r0 = new com.sumsub.sns.presentation.screen.verification.h
            r0.<init>(r10)
            r12.setOnClickListener(r0)
        L_0x01ef:
            com.sumsub.sns.internal.presentation.screen.verification.d$e r11 = (com.sumsub.sns.internal.presentation.screen.verification.d.e) r11
            com.sumsub.sns.internal.presentation.screen.verification.a r11 = r11.g()
            if (r11 == 0) goto L_0x021d
            r10.a((com.sumsub.sns.internal.presentation.screen.verification.a) r11)
            goto L_0x021d
        L_0x01fb:
            android.view.View r11 = r10.getView()
            if (r11 == 0) goto L_0x0207
            int r12 = com.sumsub.sns.R.id.sns_content
            android.view.View r2 = r11.findViewById(r12)
        L_0x0207:
            if (r2 != 0) goto L_0x020a
            goto L_0x020f
        L_0x020a:
            r11 = 8
            r2.setVisibility(r11)
        L_0x020f:
            android.widget.Button r11 = r10.k()
            if (r11 == 0) goto L_0x021d
            com.sumsub.sns.presentation.screen.verification.g r12 = new com.sumsub.sns.presentation.screen.verification.g
            r12.<init>(r10)
            r11.setOnClickListener(r12)
        L_0x021d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.verification.a.handleState(com.sumsub.sns.internal.presentation.screen.verification.d, android.os.Bundle):void");
    }

    public static final void b(a aVar, Map map, DialogInterface dialogInterface, int i11) {
        dialogInterface.dismiss();
        aVar.getAnalyticsDelegate().b(Screen.VerificationExitPopup, aVar.getIdDocSetType(), Control.CancelButton, map);
    }

    public static final void b(a aVar, Map map, DialogInterface dialogInterface) {
        aVar.getAnalyticsDelegate().d(Screen.VerificationExitPopup, aVar.getIdDocSetType(), map);
    }

    public static final void a(a aVar, View view) {
        com.sumsub.sns.internal.core.analytics.c.b(aVar.getAnalyticsDelegate(), aVar.getScreen(), aVar.getIdDocSetType(), Control.ContinueButton, (Map) null, 8, (Object) null);
        aVar.getViewModel().q();
    }

    public final void a(com.sumsub.sns.internal.presentation.screen.verification.a aVar) {
        Map e11 = MapsKt__MapsJVMKt.e(kotlin.l.a("fromScreen", Screen.StatusScreen.getText()));
        AlertDialog create = new SNSAlertDialogBuilder(requireContext()).setMessage(aVar.f()).setPositiveButton(aVar.e(), (DialogInterface.OnClickListener) new c(this, e11)).setNegativeButton(aVar.d(), (DialogInterface.OnClickListener) new d(this, e11)).setOnCancelListener((DialogInterface.OnCancelListener) new b(this)).setOnDismissListener((DialogInterface.OnDismissListener) new e(this, e11)).create();
        create.setOnShowListener(new f(this, e11));
        this.f40131h = create;
    }

    public static final void a(a aVar, Map map, DialogInterface dialogInterface, int i11) {
        dialogInterface.dismiss();
        aVar.getAnalyticsDelegate().b(Screen.VerificationExitPopup, aVar.getIdDocSetType(), Control.ConfirmButton, map);
        k0 appListener = aVar.getAppListener();
        if (appListener != null) {
            appListener.b();
        }
    }

    public static final void a(a aVar, DialogInterface dialogInterface) {
        AlertDialog alertDialog = aVar.f40131h;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public static final void a(a aVar, Map map, DialogInterface dialogInterface) {
        aVar.getAnalyticsDelegate().c(Screen.VerificationExitPopup, aVar.getIdDocSetType(), map);
    }
}
