package com.sumsub.sns.presentation.consent;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.data.listener.SNSDefaultCountryPickerKt;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.core.widget.SNSCardRadioButton;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.common.z;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.presentation.consent.a;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.reflect.l;

@Metadata(bv = {}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 B2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b@\u0010AJ\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u001a\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0015\u001a\u00020\fH\u0016R\u001b\u0010\u0019\u001a\u00020\u00038TX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001f\u001a\u00020\u001a8\u0014XD¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010%\u001a\u0004\u0018\u00010 8BX\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010*\u001a\u0004\u0018\u00010&8BX\u0002¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010)R\u001d\u0010-\u001a\u0004\u0018\u00010&8BX\u0002¢\u0006\f\n\u0004\b+\u0010\"\u001a\u0004\b,\u0010)R\u001d\u00100\u001a\u0004\u0018\u00010&8BX\u0002¢\u0006\f\n\u0004\b.\u0010\"\u001a\u0004\b/\u0010)R\u001d\u00105\u001a\u0004\u0018\u0001018BX\u0002¢\u0006\f\n\u0004\b2\u0010\"\u001a\u0004\b3\u00104R\u001d\u0010:\u001a\u0004\u0018\u0001068BX\u0002¢\u0006\f\n\u0004\b7\u0010\"\u001a\u0004\b8\u00109R\u001e\u0010?\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006C"}, d2 = {"Lcom/sumsub/sns/presentation/consent/a;", "Lcom/sumsub/sns/core/presentation/b;", "Lcom/sumsub/sns/internal/presentation/consent/a$d;", "Lcom/sumsub/sns/internal/presentation/consent/a;", "", "getLayoutId", "Lcom/sumsub/sns/internal/core/common/q;", "finishReason", "", "onFinishCalled", "Lcom/sumsub/sns/core/presentation/base/a$j;", "event", "", "handleEvent", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "state", "a", "onDestroyView", "Lkotlin/i;", "p", "()Lcom/sumsub/sns/internal/presentation/consent/a;", "viewModel", "", "b", "Ljava/lang/String;", "getIdDocSetType", "()Ljava/lang/String;", "idDocSetType", "Landroid/widget/Button;", "c", "Lcom/sumsub/sns/internal/core/common/z;", "k", "()Landroid/widget/Button;", "button", "Landroid/widget/TextView;", "d", "getTitle", "()Landroid/widget/TextView;", "title", "e", "o", "subtitle", "f", "l", "footer", "Landroid/widget/RadioGroup;", "g", "n", "()Landroid/widget/RadioGroup;", "radioGroup", "Landroid/widget/ImageView;", "h", "m", "()Landroid/widget/ImageView;", "image", "", "Lcom/sumsub/sns/internal/presentation/consent/a$b;", "i", "Ljava/util/List;", "countries", "<init>", "()V", "j", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class a extends com.sumsub.sns.core.presentation.b<a.d, com.sumsub.sns.internal.presentation.consent.a> {

    /* renamed from: j  reason: collision with root package name */
    public static final C0518a f39523j = new C0518a((r) null);

    /* renamed from: k  reason: collision with root package name */
    public static final /* synthetic */ l<Object>[] f39524k = {Reflection.j(new PropertyReference1Impl(a.class, "button", "getButton()Landroid/widget/Button;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "title", "getTitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, MessengerShareContentUtility.SUBTITLE, "getSubtitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "footer", "getFooter()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "radioGroup", "getRadioGroup()Landroid/widget/RadioGroup;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "image", "getImage()Landroid/widget/ImageView;", 0))};

    /* renamed from: l  reason: collision with root package name */
    public static final String f39525l = "SNSConsentFragment";

    /* renamed from: m  reason: collision with root package name */
    public static final String f39526m = "REQUEST_KEY_CONSENT";

    /* renamed from: a  reason: collision with root package name */
    public final kotlin.i f39527a;

    /* renamed from: b  reason: collision with root package name */
    public final String f39528b = DocumentType.f32355j;

    /* renamed from: c  reason: collision with root package name */
    public final z f39529c = a0.a(this, R.id.sns_primary_button);

    /* renamed from: d  reason: collision with root package name */
    public final z f39530d = a0.a(this, R.id.sns_title);

    /* renamed from: e  reason: collision with root package name */
    public final z f39531e = a0.a(this, R.id.sns_subtitle);

    /* renamed from: f  reason: collision with root package name */
    public final z f39532f = a0.a(this, R.id.sns_footer);

    /* renamed from: g  reason: collision with root package name */
    public final z f39533g = a0.a(this, R.id.sns_radiogroup);

    /* renamed from: h  reason: collision with root package name */
    public final z f39534h = a0.a(this, R.id.sns_icon);

    /* renamed from: i  reason: collision with root package name */
    public List<a.b> f39535i;

    /* renamed from: com.sumsub.sns.presentation.consent.a$a  reason: collision with other inner class name */
    public static final class C0518a {
        public /* synthetic */ C0518a(r rVar) {
            this();
        }

        public final a a() {
            return new a();
        }

        public C0518a() {
        }
    }

    public static final class b extends Lambda implements d10.l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39536a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar) {
            super(1);
            this.f39536a = aVar;
        }

        public final void a(String str) {
            this.f39536a.getViewModel().b(str);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    public static final class c extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39537a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar) {
            super(0);
            this.f39537a = aVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
            if (r0 == null) goto L_0x0029;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a() {
            /*
                r10 = this;
                com.sumsub.sns.presentation.consent.a r0 = r10.f39537a
                com.sumsub.sns.internal.presentation.consent.a r0 = r0.getViewModel()
                com.sumsub.sns.internal.presentation.consent.a$b r0 = r0.p()
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L_0x0029
                com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r0 = r0.c()
                if (r0 == 0) goto L_0x0029
                java.lang.String r0 = r0.getCode()
                if (r0 == 0) goto L_0x0029
                int r3 = r0.length()
                if (r3 <= 0) goto L_0x0022
                r3 = r1
                goto L_0x0023
            L_0x0022:
                r3 = r2
            L_0x0023:
                if (r3 == 0) goto L_0x0026
                goto L_0x0027
            L_0x0026:
                r0 = 0
            L_0x0027:
                if (r0 != 0) goto L_0x002b
            L_0x0029:
                java.lang.String r0 = "Other"
            L_0x002b:
                com.sumsub.sns.presentation.consent.a r3 = r10.f39537a
                com.sumsub.sns.internal.presentation.consent.a r3 = r3.getViewModel()
                com.sumsub.sns.internal.core.data.model.b r3 = r3.q()
                if (r3 == 0) goto L_0x003d
                java.lang.String r3 = r3.q()
                if (r3 != 0) goto L_0x003f
            L_0x003d:
                java.lang.String r3 = ""
            L_0x003f:
                com.sumsub.sns.presentation.consent.a r4 = r10.f39537a
                com.sumsub.sns.internal.core.analytics.c r4 = r4.getAnalyticsDelegate()
                com.sumsub.sns.presentation.consent.a r5 = r10.f39537a
                com.sumsub.sns.internal.core.analytics.Screen r5 = r5.getScreen()
                com.sumsub.sns.presentation.consent.a r6 = r10.f39537a
                java.lang.String r6 = r6.getIdDocSetType()
                com.sumsub.sns.internal.core.analytics.Control r7 = com.sumsub.sns.internal.core.analytics.Control.AcceptButton
                r8 = 2
                kotlin.Pair[] r8 = new kotlin.Pair[r8]
                java.lang.String r9 = "agreementCountry"
                kotlin.Pair r0 = kotlin.l.a(r9, r0)
                r8[r2] = r0
                java.lang.String r0 = "agreementTitleKey"
                kotlin.Pair r0 = kotlin.l.a(r0, r3)
                r8[r1] = r0
                java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.l(r8)
                r4.b(r5, r6, r7, r0)
                com.sumsub.sns.presentation.consent.a r0 = r10.f39537a
                com.sumsub.sns.internal.presentation.consent.a r0 = r0.getViewModel()
                r0.t()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.consent.a.c.a():void");
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class d extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f39538a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
            super(0);
            this.f39538a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f39538a;
        }
    }

    public static final class e extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f39539a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d10.a aVar) {
            super(0);
            this.f39539a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f39539a.invoke();
        }
    }

    public static final class f extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f39540a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(kotlin.i iVar) {
            super(0);
            this.f39540a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f39540a).getViewModelStore();
        }
    }

    public static final class g extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f39541a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f39542b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(d10.a aVar, kotlin.i iVar) {
            super(0);
            this.f39541a = aVar;
            this.f39542b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f39541a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f39542b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class h extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f39543a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f39544b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(Fragment fragment, kotlin.i iVar) {
            super(0);
            this.f39543a = fragment;
            this.f39544b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f39544b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f39543a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class i extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39545a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(a aVar) {
            super(0);
            this.f39545a = aVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            a aVar = this.f39545a;
            return new com.sumsub.sns.internal.presentation.consent.b(aVar, aVar.getServiceLocator(), this.f39545a.getArguments());
        }
    }

    public a() {
        i iVar = new i(this);
        kotlin.i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new e(new d(this)));
        this.f39527a = FragmentViewModelLazyKt.c(this, Reflection.b(com.sumsub.sns.internal.presentation.consent.a.class), new f(b11), new g((d10.a) null, b11), iVar);
    }

    public String getIdDocSetType() {
        return this.f39528b;
    }

    public int getLayoutId() {
        return R.layout.sns_fragment_agreement_selector;
    }

    public final TextView getTitle() {
        return (TextView) this.f39530d.a(this, f39524k[1]);
    }

    public void handleEvent(a.j jVar) {
        if (jVar instanceof a.c) {
            com.sumsub.sns.core.presentation.b.navigateTo$default(this, com.sumsub.sns.presentation.dialogs.bottomsheet.a.f39548c.a(((a.c) jVar).b()).forResult(f39526m), (String) null, 2, (Object) null);
        } else {
            super.handleEvent(jVar);
        }
    }

    public final Button k() {
        return (Button) this.f39529c.a(this, f39524k[0]);
    }

    public final TextView l() {
        return (TextView) this.f39532f.a(this, f39524k[3]);
    }

    public final ImageView m() {
        return (ImageView) this.f39534h.a(this, f39524k[5]);
    }

    public final RadioGroup n() {
        return (RadioGroup) this.f39533g.a(this, f39524k[4]);
    }

    public final TextView o() {
        return (TextView) this.f39531e.a(this, f39524k[2]);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f39535i = null;
    }

    public boolean onFinishCalled(q qVar) {
        if (!(qVar instanceof q.c)) {
            return super.onFinishCalled(qVar);
        }
        com.sumsub.sns.core.presentation.b.finish$default(this, new q.d((SNSCompletionResult) null, 1, (r) null), (Object) null, (Long) null, 6, (Object) null);
        return false;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Button k11 = k();
        if (k11 != null) {
            com.sumsub.sns.internal.core.common.l.a((View) k11, (d10.a<Unit>) new c(this));
        }
        ImageView m11 = m();
        if (m11 != null) {
            m11.setImageDrawable(e0.f32018a.getIconHandler().onResolveIcon(requireContext(), SNSIconHandler.SNSCommonIcons.PICTURE_AGREEMENT.getImageName()));
        }
    }

    /* renamed from: p */
    public com.sumsub.sns.internal.presentation.consent.a getViewModel() {
        return (com.sumsub.sns.internal.presentation.consent.a) this.f39527a.getValue();
    }

    /* renamed from: a */
    public void handleState(a.d dVar, Bundle bundle) {
        Drawable drawable;
        Button k11 = k();
        if (k11 != null) {
            k11.setText(dVar.g());
        }
        TextView l11 = l();
        if (l11 != null) {
            l11.setText(dVar.i());
        }
        TextView title = getTitle();
        if (title != null) {
            title.setText(dVar.l());
        }
        TextView o11 = o();
        if (o11 != null) {
            com.sumsub.sns.internal.core.common.i.a(o11, dVar.k());
        }
        TextView l12 = l();
        if (l12 != null) {
            com.sumsub.sns.core.common.b.a(l12, (d10.l<? super String, Unit>) new b(this));
        }
        Button k12 = k();
        if (k12 != null) {
            k12.setEnabled(dVar.j() != null);
        }
        TextView l13 = l();
        if (l13 != null) {
            l13.setVisibility(dVar.j() == null ? 4 : 0);
        }
        if (!x.b(this.f39535i, dVar.h())) {
            if (dVar.h().size() > 1) {
                RadioGroup n11 = n();
                if (n11 != null) {
                    n11.removeAllViews();
                }
                int i11 = 0;
                for (T next : dVar.h()) {
                    int i12 = i11 + 1;
                    if (i11 < 0) {
                        CollectionsKt__CollectionsKt.t();
                    }
                    a.b bVar = (a.b) next;
                    SNSCountryPicker.CountryItem c11 = bVar.c();
                    SNSCardRadioButton sNSCardRadioButton = new SNSCardRadioButton(requireContext(), (AttributeSet) null, 0, 0, 14, (r) null);
                    sNSCardRadioButton.setText(c11.getName());
                    sNSCardRadioButton.setTag(Integer.valueOf(bVar.d()));
                    if (c11.getCode().length() == 0) {
                        drawable = e0.f32018a.getIconHandler().onResolveIcon(requireContext(), SNSIconHandler.SNSCommonIcons.COUNTRY_OTHER.getImageName());
                    } else {
                        drawable = SNSDefaultCountryPickerKt.getFlagDrawable(c11, requireContext());
                    }
                    sNSCardRadioButton.setStartDrawable(drawable);
                    sNSCardRadioButton.setOnCheckedChangeListener(new b(this, bVar));
                    RadioGroup n12 = n();
                    if (n12 != null) {
                        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
                        layoutParams.setMargins(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.sns_margin_small_tiny));
                        Unit unit = Unit.f56620a;
                        n12.addView(sNSCardRadioButton, layoutParams);
                    }
                    i11 = i12;
                }
                RadioGroup n13 = n();
                if (n13 != null) {
                    int childCount = n13.getChildCount();
                    for (int i13 = 0; i13 < childCount; i13++) {
                        View childAt = n13.getChildAt(i13);
                        SNSCardRadioButton sNSCardRadioButton2 = childAt instanceof SNSCardRadioButton ? (SNSCardRadioButton) childAt : null;
                        if (sNSCardRadioButton2 != null) {
                            sNSCardRadioButton2.setChecked(x.b(sNSCardRadioButton2.getTag(), dVar.j()));
                        }
                    }
                }
                RadioGroup n14 = n();
                if (n14 != null) {
                    n14.setVisibility(0);
                }
            } else {
                RadioGroup n15 = n();
                if (n15 != null) {
                    n15.setVisibility(8);
                }
            }
            this.f39535i = dVar.h();
        }
    }

    public static final void a(a aVar, a.b bVar, CompoundButton compoundButton, boolean z11) {
        if (z11) {
            aVar.getViewModel().a(bVar.d());
        }
    }
}
