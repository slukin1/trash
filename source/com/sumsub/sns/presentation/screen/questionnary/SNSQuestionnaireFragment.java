package com.sumsub.sns.presentation.screen.questionnary;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.analytics.Control;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.common.z;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.source.applicant.remote.w;
import com.sumsub.sns.internal.core.data.source.applicant.remote.y;
import com.sumsub.sns.internal.presentation.screen.questionnary.model.d;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.reflect.l;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 E2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001FB\u0007¢\u0006\u0004\bC\u0010DJ\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u001a\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u001e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002R\u001b\u0010\u001b\u001a\u00020\u00038TX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010!\u001a\u0004\u0018\u00010\u001c8TX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010&\u001a\u0004\u0018\u00010\"8BX\u0002¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010%R\u001d\u0010)\u001a\u0004\u0018\u00010\u001c8BX\u0002¢\u0006\f\n\u0004\b'\u0010\u001e\u001a\u0004\b(\u0010 R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8TX\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00104\u001a\u0002028VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u00103R\u0014\u00106\u001a\u00020.8VX\u0004¢\u0006\u0006\u001a\u0004\b5\u00100R \u0010;\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u000208078VX\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0016\u0010?\u001a\u0004\u0018\u00010<8BX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010B\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006G"}, d2 = {"Lcom/sumsub/sns/presentation/screen/questionnary/SNSQuestionnaireFragment;", "Lcom/sumsub/sns/core/presentation/b;", "Lcom/sumsub/sns/internal/presentation/screen/questionnary/model/d$d;", "Lcom/sumsub/sns/internal/presentation/screen/questionnary/model/d;", "Lcom/sumsub/sns/internal/core/presentation/form/a;", "", "getLayoutId", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewModelPrepared", "Lcom/sumsub/sns/core/presentation/base/a$j;", "event", "handleEvent", "state", "a", "Lcom/sumsub/sns/internal/core/common/q;", "finishReason", "", "onFinishCalled", "currentPageNumber", "", "Lcom/sumsub/sns/internal/core/presentation/form/b$b;", "pages", "Lkotlin/i;", "o", "()Lcom/sumsub/sns/internal/presentation/screen/questionnary/model/d;", "viewModel", "Landroid/widget/TextView;", "b", "Lcom/sumsub/sns/internal/core/common/z;", "getPoweredByText", "()Landroid/widget/TextView;", "poweredByText", "Landroid/view/ViewGroup;", "c", "m", "()Landroid/view/ViewGroup;", "content", "d", "l", "btContinue", "Lcom/sumsub/sns/internal/presentation/screen/questionnary/model/d$c;", "e", "Lcom/sumsub/sns/internal/presentation/screen/questionnary/model/d$c;", "page", "", "getIdDocSetType", "()Ljava/lang/String;", "idDocSetType", "Lcom/sumsub/sns/internal/core/presentation/form/b;", "()Lcom/sumsub/sns/internal/core/presentation/form/b;", "hostViewModel", "getLogTag", "logTag", "", "", "getOpenPayload", "()Ljava/util/Map;", "openPayload", "Lcom/sumsub/sns/core/presentation/form/d;", "n", "()Lcom/sumsub/sns/core/presentation/form/d;", "formFragment", "k", "()I", "analyticsPageIndex", "<init>", "()V", "f", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSQuestionnaireFragment extends com.sumsub.sns.core.presentation.b<d.C0485d, com.sumsub.sns.internal.presentation.screen.questionnary.model.d> implements com.sumsub.sns.internal.core.presentation.form.a {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f40102f = new Companion((r) null);

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ l<Object>[] f40103g = {Reflection.j(new PropertyReference1Impl(SNSQuestionnaireFragment.class, "poweredByText", "getPoweredByText()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(SNSQuestionnaireFragment.class, "content", "getContent()Landroid/view/ViewGroup;", 0)), Reflection.j(new PropertyReference1Impl(SNSQuestionnaireFragment.class, "btContinue", "getBtContinue()Landroid/widget/TextView;", 0))};

    /* renamed from: h  reason: collision with root package name */
    public static final String f40104h = "SNSQuestionnaireFragment";

    /* renamed from: i  reason: collision with root package name */
    public static final String f40105i = "pageIndex";

    /* renamed from: j  reason: collision with root package name */
    public static final String f40106j = "isDataValid";

    /* renamed from: a  reason: collision with root package name */
    public final i f40107a;

    /* renamed from: b  reason: collision with root package name */
    public final z f40108b = a0.a(this, R.id.sns_powered);

    /* renamed from: c  reason: collision with root package name */
    public final z f40109c = a0.a(this, R.id.sns_content);

    /* renamed from: d  reason: collision with root package name */
    public final z f40110d = a0.a(this, R.id.sns_continue);

    /* renamed from: e  reason: collision with root package name */
    public d.c f40111e;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J2\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bR\u0014\u0010\f\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/presentation/screen/questionnary/SNSQuestionnaireFragment$Companion;", "", "", "idDocSetType", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/w;", "questionnaire", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/y;", "questionnaireSummary", "Lcom/sumsub/sns/internal/core/presentation/form/model/d;", "countriesData", "Landroidx/fragment/app/Fragment;", "newInstance", "PAYLOAD_CURRENT_PAGE_INDEX", "Ljava/lang/String;", "PAYLOAD_IS_DATA_VALID", "TAG", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public static /* synthetic */ Fragment newInstance$default(Companion companion, String str, w wVar, y yVar, com.sumsub.sns.internal.core.presentation.form.model.d dVar, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                wVar = null;
            }
            if ((i11 & 4) != 0) {
                yVar = null;
            }
            if ((i11 & 8) != 0) {
                dVar = null;
            }
            return companion.newInstance(str, wVar, yVar, dVar);
        }

        public final Fragment newInstance(String str, w wVar, y yVar, com.sumsub.sns.internal.core.presentation.form.model.d dVar) {
            SNSQuestionnaireFragment sNSQuestionnaireFragment = new SNSQuestionnaireFragment();
            Bundle bundle = new Bundle();
            bundle.putString(com.sumsub.sns.internal.presentation.screen.questionnary.model.d.R, str);
            bundle.putParcelable("QUESTIONNAIRE", wVar);
            bundle.putParcelable(com.sumsub.sns.internal.presentation.screen.questionnary.model.d.P, yVar);
            bundle.putParcelable(com.sumsub.sns.internal.presentation.screen.questionnary.model.d.Q, dVar);
            sNSQuestionnaireFragment.setArguments(bundle);
            return sNSQuestionnaireFragment;
        }

        private Companion() {
        }
    }

    public static final class a extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f40112a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Fragment fragment) {
            super(0);
            this.f40112a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f40112a;
        }
    }

    public static final class b extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f40113a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(d10.a aVar) {
            super(0);
            this.f40113a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f40113a.invoke();
        }
    }

    public static final class c extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f40114a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(i iVar) {
            super(0);
            this.f40114a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f40114a).getViewModelStore();
        }
    }

    public static final class d extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f40115a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f40116b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(d10.a aVar, i iVar) {
            super(0);
            this.f40115a = aVar;
            this.f40116b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f40115a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f40116b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class e extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f40117a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f40118b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment, i iVar) {
            super(0);
            this.f40117a = fragment;
            this.f40118b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f40118b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f40117a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class f extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SNSQuestionnaireFragment f40119a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(SNSQuestionnaireFragment sNSQuestionnaireFragment) {
            super(0);
            this.f40119a = sNSQuestionnaireFragment;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            SNSQuestionnaireFragment sNSQuestionnaireFragment = this.f40119a;
            return new com.sumsub.sns.internal.presentation.screen.questionnary.model.e(sNSQuestionnaireFragment, sNSQuestionnaireFragment.getServiceLocator(), this.f40119a.getArguments());
        }
    }

    public SNSQuestionnaireFragment() {
        f fVar = new f(this);
        i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new b(new a(this)));
        this.f40107a = FragmentViewModelLazyKt.c(this, Reflection.b(com.sumsub.sns.internal.presentation.screen.questionnary.model.d.class), new c(b11), new d((d10.a) null, b11), fVar);
    }

    public String getIdDocSetType() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(com.sumsub.sns.internal.presentation.screen.questionnary.model.d.R) : null;
        return string == null ? DocumentType.f32355j : string;
    }

    public int getLayoutId() {
        return R.layout.sns_fragment_questionnarie;
    }

    public String getLogTag() {
        return f40104h;
    }

    public Map<String, Object> getOpenPayload() {
        return MapsKt__MapsJVMKt.e(kotlin.l.a(f40105i, Integer.valueOf(k())));
    }

    public TextView getPoweredByText() {
        return (TextView) this.f40108b.a(this, f40103g[0]);
    }

    public void handleEvent(a.j jVar) {
        TextView l11;
        if ((jVar instanceof a.d) && (l11 = l()) != null) {
            l11.setVisibility(0);
        }
        super.handleEvent(jVar);
    }

    public final int k() {
        d.c cVar = this.f40111e;
        if (cVar != null) {
            return RangesKt___RangesKt.d(cVar.e() - 1, 0);
        }
        return 0;
    }

    public final TextView l() {
        return (TextView) this.f40110d.a(this, f40103g[2]);
    }

    public final ViewGroup m() {
        return (ViewGroup) this.f40109c.a(this, f40103g[1]);
    }

    public final com.sumsub.sns.core.presentation.form.d n() {
        ViewGroup m11 = m();
        if (m11 != null) {
            Fragment l02 = getChildFragmentManager().l0(m11.getId());
            if (l02 instanceof com.sumsub.sns.core.presentation.form.d) {
                return (com.sumsub.sns.core.presentation.form.d) l02;
            }
        }
        return null;
    }

    /* renamed from: o */
    public com.sumsub.sns.internal.presentation.screen.questionnary.model.d getViewModel() {
        return (com.sumsub.sns.internal.presentation.screen.questionnary.model.d) this.f40107a.getValue();
    }

    public boolean onFinishCalled(q qVar) {
        if (!x.b(qVar, q.c.f32251b) || !getViewModel().x()) {
            return super.onFinishCalled(qVar);
        }
        return false;
    }

    public void onViewModelPrepared(Bundle bundle) {
        super.onViewModelPrepared(bundle);
        TextView l11 = l();
        if (l11 != null) {
            l11.setOnClickListener(new a(this));
        }
    }

    public com.sumsub.sns.internal.core.presentation.form.b a() {
        return getViewModel();
    }

    public static final void a(SNSQuestionnaireFragment sNSQuestionnaireFragment, View view) {
        com.sumsub.sns.core.presentation.form.d n11 = sNSQuestionnaireFragment.n();
        boolean k11 = n11 != null ? n11.k() : false;
        sNSQuestionnaireFragment.getAnalyticsDelegate().b(sNSQuestionnaireFragment.getScreen(), sNSQuestionnaireFragment.getIdDocSetType(), Control.ContinueButton, MapsKt__MapsKt.l(kotlin.l.a(f40105i, Integer.valueOf(sNSQuestionnaireFragment.k())), kotlin.l.a(f40106j, String.valueOf(k11))));
        if (k11) {
            TextView l11 = sNSQuestionnaireFragment.l();
            if (l11 != null) {
                l11.setVisibility(4);
            }
            TextView l12 = sNSQuestionnaireFragment.l();
            if (l12 != null) {
                com.sumsub.sns.internal.core.common.i.b((View) l12);
            }
            sNSQuestionnaireFragment.getViewModel().A();
        }
    }

    /* renamed from: a */
    public void handleState(d.C0485d dVar, Bundle bundle) {
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        com.sumsub.log.logger.a.d(aVar, com.sumsub.sns.internal.presentation.screen.questionnary.model.a.f36239b, "handleState: " + com.sumsub.sns.internal.core.common.i.a((Object) dVar), (Throwable) null, 4, (Object) null);
        a(dVar.f(), dVar.h());
        TextView l11 = l();
        if (l11 != null) {
            d.C0485d.a e11 = dVar.e();
            com.sumsub.sns.internal.core.common.i.a(l11, e11 != null ? e11.d() : null);
        }
        TextView l12 = l();
        if (l12 != null) {
            d.C0485d.a e12 = dVar.e();
            l12.setEnabled(e12 != null ? e12.c() : true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001c, code lost:
        r8 = r0.f();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r8, java.util.List<com.sumsub.sns.internal.core.presentation.form.b.C0375b> r9) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.d0(r9, r8)
            com.sumsub.sns.internal.core.presentation.form.b$b r0 = (com.sumsub.sns.internal.core.presentation.form.b.C0375b) r0
            com.sumsub.sns.internal.log.a r1 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "showPage: "
            r2.append(r3)
            r2.append(r8)
            java.lang.String r8 = " has "
            r2.append(r8)
            if (r0 == 0) goto L_0x002b
            java.util.List r8 = r0.f()
            if (r8 == 0) goto L_0x002b
            int r8 = r8.size()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x002c
        L_0x002b:
            r8 = 0
        L_0x002c:
            r2.append(r8)
            java.lang.String r8 = " items"
            r2.append(r8)
            java.lang.String r3 = r2.toString()
            r4 = 0
            r5 = 4
            r6 = 0
            java.lang.String r2 = "Questionnaire"
            com.sumsub.log.logger.a.d(r1, r2, r3, r4, r5, r6)
            boolean r8 = r9.isEmpty()
            if (r8 != 0) goto L_0x0070
            if (r0 != 0) goto L_0x0049
            goto L_0x0070
        L_0x0049:
            android.view.ViewGroup r8 = r7.m()
            if (r8 != 0) goto L_0x0050
            return
        L_0x0050:
            com.sumsub.sns.core.presentation.form.d r9 = r7.n()
            if (r9 != 0) goto L_0x0070
            androidx.fragment.app.FragmentManager r9 = r7.getChildFragmentManager()
            androidx.fragment.app.FragmentTransaction r9 = r9.q()
            int r8 = r8.getId()
            com.sumsub.sns.core.presentation.form.d$a r0 = com.sumsub.sns.core.presentation.form.d.f30929p
            java.lang.String r1 = "Questionnaire"
            androidx.fragment.app.Fragment r0 = r0.a(r1)
            r9.t(r8, r0)
            r9.m()
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.questionnary.SNSQuestionnaireFragment.a(int, java.util.List):void");
    }
}
