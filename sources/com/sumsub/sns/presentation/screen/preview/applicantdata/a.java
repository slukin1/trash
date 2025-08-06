package com.sumsub.sns.presentation.screen.preview.applicantdata;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.core.theme.SNSMetricElement;
import com.sumsub.sns.core.widget.SNSAlertDialogBuilder;
import com.sumsub.sns.internal.core.analytics.Control;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.z;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.reflect.l;

@Metadata(bv = {}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0011B\u0007¢\u0006\u0004\b;\u0010\u0017J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0014J\u001a\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\u0012\u001a\u00020\u000bH\u0002R!\u0010\u0018\u001a\u00020\u00038TX\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0013\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u00198BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\u0004\u0018\u00010\u001f8BX\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"R\u001d\u0010&\u001a\u0004\u0018\u00010\u001f8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\"R\u001d\u0010+\u001a\u0004\u0018\u00010'8BX\u0002¢\u0006\f\n\u0004\b(\u0010\u001b\u001a\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008TX\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00106\u001a\u0002048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u00105R\u0016\u0010:\u001a\u0004\u0018\u0001078BX\u0004¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006="}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/applicantdata/a;", "Lcom/sumsub/sns/presentation/screen/preview/a;", "Lcom/sumsub/sns/internal/presentation/screen/preview/applicantdata/b$d;", "Lcom/sumsub/sns/internal/presentation/screen/preview/applicantdata/b;", "Lcom/sumsub/sns/internal/core/presentation/form/a;", "", "getLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "Lcom/sumsub/sns/core/presentation/base/a$j;", "event", "handleEvent", "state", "a", "r", "Lkotlin/i;", "p", "()Lcom/sumsub/sns/internal/presentation/screen/preview/applicantdata/b;", "getViewModel$annotations", "()V", "viewModel", "Landroid/widget/Button;", "b", "Lcom/sumsub/sns/internal/core/common/z;", "k", "()Landroid/widget/Button;", "btnContinue", "Landroid/widget/TextView;", "c", "n", "()Landroid/widget/TextView;", "tvTitle", "d", "m", "tvSubtitle", "Landroid/view/ViewGroup;", "e", "o", "()Landroid/view/ViewGroup;", "vgContent", "Lcom/sumsub/sns/internal/domain/c;", "f", "Lcom/sumsub/sns/internal/domain/c;", "resources", "", "getIdDocSetType", "()Ljava/lang/String;", "idDocSetType", "Lcom/sumsub/sns/internal/core/presentation/form/b;", "()Lcom/sumsub/sns/internal/core/presentation/form/b;", "hostViewModel", "Lcom/sumsub/sns/core/presentation/form/d;", "l", "()Lcom/sumsub/sns/core/presentation/form/d;", "formFragment", "<init>", "g", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class a extends com.sumsub.sns.presentation.screen.preview.a<b.d, com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b> implements com.sumsub.sns.internal.core.presentation.form.a {

    /* renamed from: g  reason: collision with root package name */
    public static final C0531a f39816g = new C0531a((r) null);

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ l<Object>[] f39817h = {Reflection.j(new PropertyReference1Impl(a.class, "btnContinue", "getBtnContinue()Landroid/widget/Button;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "tvTitle", "getTvTitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "tvSubtitle", "getTvSubtitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "vgContent", "getVgContent()Landroid/view/ViewGroup;", 0))};

    /* renamed from: i  reason: collision with root package name */
    public static final String f39818i = "ARGS_DOCUMENT";

    /* renamed from: j  reason: collision with root package name */
    public static final String f39819j = "SNSApplicantDataDocumentFragment";

    /* renamed from: a  reason: collision with root package name */
    public final i f39820a;

    /* renamed from: b  reason: collision with root package name */
    public final z f39821b = a0.a(this, R.id.sns_primary_button);

    /* renamed from: c  reason: collision with root package name */
    public final z f39822c = a0.a(this, R.id.sns_title);

    /* renamed from: d  reason: collision with root package name */
    public final z f39823d = a0.a(this, R.id.sns_subtitle);

    /* renamed from: e  reason: collision with root package name */
    public final z f39824e = a0.a(this, R.id.sns_content);

    /* renamed from: f  reason: collision with root package name */
    public com.sumsub.sns.internal.domain.c f39825f;

    /* renamed from: com.sumsub.sns.presentation.screen.preview.applicantdata.a$a  reason: collision with other inner class name */
    public static final class C0531a {
        public /* synthetic */ C0531a(r rVar) {
            this();
        }

        public final Fragment a(Document document) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARGS_DOCUMENT", document);
            aVar.setArguments(bundle);
            return aVar;
        }

        public C0531a() {
        }
    }

    public static final class b extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f39826a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.f39826a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f39826a;
        }
    }

    public static final class c extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f39827a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(d10.a aVar) {
            super(0);
            this.f39827a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f39827a.invoke();
        }
    }

    public static final class d extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f39828a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(i iVar) {
            super(0);
            this.f39828a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f39828a).getViewModelStore();
        }
    }

    public static final class e extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f39829a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f39830b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d10.a aVar, i iVar) {
            super(0);
            this.f39829a = aVar;
            this.f39830b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f39829a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f39830b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class f extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f39831a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f39832b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment, i iVar) {
            super(0);
            this.f39831a = fragment;
            this.f39832b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f39832b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f39831a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class g extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39833a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(a aVar) {
            super(0);
            this.f39833a = aVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            Bundle arguments = this.f39833a.getArguments();
            Document document = arguments != null ? (Document) arguments.getParcelable("ARGS_DOCUMENT") : null;
            a aVar = this.f39833a;
            return new com.sumsub.sns.internal.presentation.screen.preview.applicantdata.c(document, aVar, aVar.getServiceLocator(), this.f39833a.getArguments());
        }
    }

    public a() {
        g gVar = new g(this);
        i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new c(new b(this)));
        this.f39820a = FragmentViewModelLazyKt.c(this, Reflection.b(com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b.class), new d(b11), new e((d10.a) null, b11), gVar);
    }

    public static /* synthetic */ void q() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        r0 = (r0 = (r0 = (com.sumsub.sns.internal.core.data.model.Document) androidx.core.os.d.b(r0, "ARGS_DOCUMENT", com.sumsub.sns.internal.core.data.model.Document.class)).getType()).c();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getIdDocSetType() {
        /*
            r3 = this;
            android.os.Bundle r0 = r3.getArguments()
            if (r0 == 0) goto L_0x001e
            java.lang.Class<com.sumsub.sns.internal.core.data.model.Document> r1 = com.sumsub.sns.internal.core.data.model.Document.class
            java.lang.String r2 = "ARGS_DOCUMENT"
            java.lang.Object r0 = androidx.core.os.d.b(r0, r2, r1)
            com.sumsub.sns.internal.core.data.model.Document r0 = (com.sumsub.sns.internal.core.data.model.Document) r0
            if (r0 == 0) goto L_0x001e
            com.sumsub.sns.internal.core.data.model.DocumentType r0 = r0.getType()
            if (r0 == 0) goto L_0x001e
            java.lang.String r0 = r0.c()
            if (r0 != 0) goto L_0x0020
        L_0x001e:
            java.lang.String r0 = "TYPE_UNKNOWN"
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.preview.applicantdata.a.getIdDocSetType():java.lang.String");
    }

    public int getLayoutId() {
        return R.layout.sns_fragment_applicant_data_document;
    }

    public void handleEvent(a.j jVar) {
        super.handleEvent(jVar);
        if (jVar instanceof b.C0426b) {
            b.C0426b bVar = (b.C0426b) jVar;
            new SNSAlertDialogBuilder(requireContext()).setMessage(bVar.c()).setPositiveButton(bVar.d(), (DialogInterface.OnClickListener) b.f39834b).create().show();
        }
    }

    public final Button k() {
        return (Button) this.f39821b.a(this, f39817h[0]);
    }

    public final com.sumsub.sns.core.presentation.form.d l() {
        ViewGroup o11 = o();
        if (o11 != null) {
            Fragment l02 = getChildFragmentManager().l0(o11.getId());
            if (l02 instanceof com.sumsub.sns.core.presentation.form.d) {
                return (com.sumsub.sns.core.presentation.form.d) l02;
            }
        }
        return null;
    }

    public final TextView m() {
        return (TextView) this.f39823d.a(this, f39817h[2]);
    }

    public final TextView n() {
        return (TextView) this.f39822c.a(this, f39817h[1]);
    }

    public final ViewGroup o() {
        return (ViewGroup) this.f39824e.a(this, f39817h[3]);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Float a11;
        super.onViewCreated(view, bundle);
        Button k11 = k();
        if (k11 != null) {
            k11.setOnClickListener(new c(this));
        }
        com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
        com.sumsub.sns.internal.core.theme.d a12 = aVar.a();
        if (a12 != null && (a11 = aVar.a(a12, SNSMetricElement.SCREEN_HORIZONTAL_MARGIN)) != null) {
            int floatValue = (int) a11.floatValue();
            com.sumsub.sns.internal.core.common.i.a(Integer.valueOf(floatValue), Integer.valueOf(floatValue), (Integer) null, (Integer) null, k(), n(), m());
        }
    }

    /* renamed from: p */
    public com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b getViewModel() {
        return (com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b) this.f39820a.getValue();
    }

    public final void r() {
        ViewGroup o11 = o();
        if (o11 != null && l() == null) {
            FragmentTransaction q11 = getChildFragmentManager().q();
            q11.t(o11.getId(), com.sumsub.sns.core.presentation.form.d.f30929p.a(com.sumsub.sns.internal.presentation.screen.preview.applicantdata.a.f35303b));
            q11.m();
        }
    }

    public com.sumsub.sns.internal.core.presentation.form.b a() {
        return getViewModel();
    }

    public static final void a(a aVar, View view) {
        com.sumsub.sns.internal.core.analytics.c.b(aVar.getAnalyticsDelegate(), aVar.getScreen(), aVar.getIdDocSetType(), Control.ContinueButton, (Map) null, 8, (Object) null);
        com.sumsub.sns.internal.core.common.i.b(view);
        aVar.getViewModel().E();
    }

    public static final void a(DialogInterface dialogInterface, int i11) {
        dialogInterface.dismiss();
    }

    /* renamed from: a */
    public void handleState(b.d dVar, Bundle bundle) {
        this.f39825f = dVar.m();
        r();
        TextView n11 = n();
        if (n11 != null) {
            com.sumsub.sns.internal.core.common.i.a(n11, dVar.p());
        }
        TextView m11 = m();
        if (m11 != null) {
            com.sumsub.sns.internal.core.common.i.a(m11, dVar.o());
        }
        Button k11 = k();
        if (k11 != null) {
            com.sumsub.sns.internal.core.common.i.a((TextView) k11, dVar.i());
        }
        ViewGroup o11 = o();
        if (o11 != null) {
            o11.setVisibility(dVar.n() ^ true ? 4 : 0);
        }
    }
}
