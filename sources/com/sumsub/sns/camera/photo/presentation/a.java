package com.sumsub.sns.camera.photo.presentation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.method.LinkMovementMethod;
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
import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.data.listener.SNSDefaultCountryPickerKt;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.theme.SNSMetricElement;
import com.sumsub.sns.core.widget.SNSCountrySelectorView;
import com.sumsub.sns.core.widget.autocompletePhone.bottomsheet.SNSPickerDialog;
import com.sumsub.sns.internal.camera.photo.presentation.a;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.z;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.reflect.l;

@Metadata(bv = {}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 52\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0007¢\u0006\u0004\bD\u0010EJ\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0002J \u0010\r\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002R\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u001b8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010#\u001a\u0004\u0018\u00010 8BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b!\u0010\"R\u001d\u0010&\u001a\u0004\u0018\u00010\u001b8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u001eR\u001d\u0010)\u001a\u0004\u0018\u00010\u001b8BX\u0002¢\u0006\f\n\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010\u001eR\u001d\u0010.\u001a\u0004\u0018\u00010*8BX\u0002¢\u0006\f\n\u0004\b+\u0010\u001c\u001a\u0004\b,\u0010-R\u001d\u00101\u001a\u0004\u0018\u00010\u001b8BX\u0002¢\u0006\f\n\u0004\b/\u0010\u001c\u001a\u0004\b0\u0010\u001eR\u001b\u00107\u001a\u0002028BX\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001b\u0010;\u001a\u00020\u00038TX\u0002¢\u0006\f\n\u0004\b8\u00104\u001a\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010C\u001a\u0002028TX\u0004¢\u0006\u0006\u001a\u0004\bB\u00106¨\u0006F"}, d2 = {"Lcom/sumsub/sns/camera/photo/presentation/a;", "Lcom/sumsub/sns/core/presentation/b;", "Lcom/sumsub/sns/internal/camera/photo/presentation/a$e;", "Lcom/sumsub/sns/internal/camera/photo/presentation/a;", "", "getLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "state", "a", "Lcom/sumsub/sns/core/presentation/base/a$j;", "event", "handleEvent", "onDestroyView", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;", "item", "country", "b", "Lcom/sumsub/sns/internal/camera/photo/presentation/a$f;", "viewText", "", "Lcom/sumsub/sns/internal/camera/photo/presentation/a$b;", "documents", "Landroid/widget/TextView;", "Lcom/sumsub/sns/internal/core/common/z;", "m", "()Landroid/widget/TextView;", "tvCountryTitle", "Lcom/sumsub/sns/core/widget/SNSCountrySelectorView;", "l", "()Lcom/sumsub/sns/core/widget/SNSCountrySelectorView;", "snsCountrySelector", "c", "o", "tvDocumentsTitle", "d", "n", "tvDocumentsEmpty", "Landroid/view/ViewGroup;", "e", "q", "()Landroid/view/ViewGroup;", "vgDocuments", "f", "p", "tvFooter", "", "g", "Lkotlin/i;", "k", "()Ljava/lang/String;", "documentType", "h", "r", "()Lcom/sumsub/sns/internal/camera/photo/presentation/a;", "viewModel", "", "i", "Z", "isPickerShowing", "j", "Ljava/util/List;", "getIdDocSetType", "idDocSetType", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class a extends com.sumsub.sns.core.presentation.b<a.e, com.sumsub.sns.internal.camera.photo.presentation.a> {

    /* renamed from: k  reason: collision with root package name */
    public static final C0273a f30593k = new C0273a((r) null);

    /* renamed from: l  reason: collision with root package name */
    public static final /* synthetic */ l<Object>[] f30594l = {Reflection.j(new PropertyReference1Impl(a.class, "tvCountryTitle", "getTvCountryTitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "snsCountrySelector", "getSnsCountrySelector()Lcom/sumsub/sns/core/widget/SNSCountrySelectorView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "tvDocumentsTitle", "getTvDocumentsTitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "tvDocumentsEmpty", "getTvDocumentsEmpty()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "vgDocuments", "getVgDocuments()Landroid/view/ViewGroup;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "tvFooter", "getTvFooter()Landroid/widget/TextView;", 0))};

    /* renamed from: m  reason: collision with root package name */
    public static final String f30595m = "SNSDocumentSelectorFragment";

    /* renamed from: n  reason: collision with root package name */
    public static final String f30596n = "result_selected_country";

    /* renamed from: o  reason: collision with root package name */
    public static final String f30597o = "result_selected_id_doc_type";

    /* renamed from: p  reason: collision with root package name */
    public static final String f30598p = "country_selector_request_key";

    /* renamed from: q  reason: collision with root package name */
    public static final String f30599q = "country_selector_result_key";

    /* renamed from: a  reason: collision with root package name */
    public final z f30600a = a0.a(this, R.id.sns_country_title);

    /* renamed from: b  reason: collision with root package name */
    public final z f30601b = a0.a(this, R.id.sns_country_selector);

    /* renamed from: c  reason: collision with root package name */
    public final z f30602c = a0.a(this, R.id.sns_documents_title);

    /* renamed from: d  reason: collision with root package name */
    public final z f30603d = a0.a(this, R.id.sns_documents_empty);

    /* renamed from: e  reason: collision with root package name */
    public final z f30604e = a0.a(this, R.id.sns_list);

    /* renamed from: f  reason: collision with root package name */
    public final z f30605f = a0.a(this, R.id.sns_footer);

    /* renamed from: g  reason: collision with root package name */
    public final kotlin.i f30606g = LazyKt__LazyJVMKt.a(new b(this));

    /* renamed from: h  reason: collision with root package name */
    public final kotlin.i f30607h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f30608i;

    /* renamed from: j  reason: collision with root package name */
    public List<a.b> f30609j;

    /* renamed from: com.sumsub.sns.camera.photo.presentation.a$a  reason: collision with other inner class name */
    public static final class C0273a {
        public /* synthetic */ C0273a(r rVar) {
            this();
        }

        public final a a(String str) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putString(com.sumsub.sns.internal.camera.photo.presentation.a.C, str);
            aVar.setArguments(bundle);
            return aVar;
        }

        public C0273a() {
        }
    }

    public static final class b extends Lambda implements d10.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30610a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar) {
            super(0);
            this.f30610a = aVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
            r0 = r0.getString(com.sumsub.sns.internal.camera.photo.presentation.a.C);
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String invoke() {
            /*
                r2 = this;
                com.sumsub.sns.camera.photo.presentation.a r0 = r2.f30610a
                android.os.Bundle r0 = r0.getArguments()
                if (r0 == 0) goto L_0x0010
                java.lang.String r1 = "extra_document_type"
                java.lang.String r0 = r0.getString(r1)
                if (r0 != 0) goto L_0x0012
            L_0x0010:
                java.lang.String r0 = ""
            L_0x0012:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.camera.photo.presentation.a.b.invoke():java.lang.String");
        }
    }

    public static final class c implements SNSCountryPicker.SNSCountryPickerCallBack {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30611a;

        public c(a aVar) {
            this.f30611a = aVar;
        }

        public void onDismiss() {
            this.f30611a.getViewModel().t();
        }

        public void onItemSelected(SNSCountryPicker.CountryItem countryItem) {
            this.f30611a.a(countryItem);
        }
    }

    public static final class d extends Lambda implements d10.l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30612a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar) {
            super(1);
            this.f30612a = aVar;
        }

        public final void a(String str) {
            this.f30612a.getViewModel().a(str);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    public static final class e extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f30613a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
            super(0);
            this.f30613a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f30613a;
        }
    }

    public static final class f extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f30614a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(d10.a aVar) {
            super(0);
            this.f30614a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f30614a.invoke();
        }
    }

    public static final class g extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f30615a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(kotlin.i iVar) {
            super(0);
            this.f30615a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f30615a).getViewModelStore();
        }
    }

    public static final class h extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f30616a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f30617b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(d10.a aVar, kotlin.i iVar) {
            super(0);
            this.f30616a = aVar;
            this.f30617b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f30616a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f30617b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class i extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f30618a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f30619b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(Fragment fragment, kotlin.i iVar) {
            super(0);
            this.f30618a = fragment;
            this.f30619b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f30619b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f30618a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class j extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30620a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(a aVar) {
            super(0);
            this.f30620a = aVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            a aVar = this.f30620a;
            return new com.sumsub.sns.internal.camera.photo.presentation.b(aVar, aVar.k(), this.f30620a.getServiceLocator(), this.f30620a.getArguments());
        }
    }

    public a() {
        j jVar = new j(this);
        kotlin.i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new f(new e(this)));
        this.f30607h = FragmentViewModelLazyKt.c(this, Reflection.b(com.sumsub.sns.internal.camera.photo.presentation.a.class), new g(b11), new h((d10.a) null, b11), jVar);
    }

    public String getIdDocSetType() {
        return k();
    }

    public int getLayoutId() {
        return R.layout.sns_fragment_document_selector;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r4 = (com.sumsub.sns.internal.camera.photo.presentation.a.d) r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleEvent(com.sumsub.sns.core.presentation.base.a.j r4) {
        /*
            r3 = this;
            super.handleEvent(r4)
            boolean r0 = r4 instanceof com.sumsub.sns.internal.camera.photo.presentation.a.d
            if (r0 == 0) goto L_0x002e
            com.sumsub.sns.internal.camera.photo.presentation.a$d r4 = (com.sumsub.sns.internal.camera.photo.presentation.a.d) r4
            com.sumsub.sns.internal.core.data.model.q r0 = r4.d()
            if (r0 == 0) goto L_0x002e
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r4 = r4.c()
            java.lang.String r2 = "result_selected_country"
            r1.putString(r2, r4)
            java.lang.String r4 = r0.b()
            java.lang.String r0 = "result_selected_id_doc_type"
            r1.putString(r0, r4)
            kotlin.Unit r4 = kotlin.Unit.f56620a
            r4 = 0
            r0 = 1
            r2 = 0
            com.sumsub.sns.core.presentation.b.finishWithResult$default(r3, r4, r1, r0, r2)
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.camera.photo.presentation.a.handleEvent(com.sumsub.sns.core.presentation.base.a$j):void");
    }

    public final String k() {
        return (String) this.f30606g.getValue();
    }

    public final SNSCountrySelectorView l() {
        return (SNSCountrySelectorView) this.f30601b.a(this, f30594l[1]);
    }

    public final TextView m() {
        return (TextView) this.f30600a.a(this, f30594l[0]);
    }

    public final TextView n() {
        return (TextView) this.f30603d.a(this, f30594l[3]);
    }

    public final TextView o() {
        return (TextView) this.f30602c.a(this, f30594l[2]);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f30609j = null;
    }

    public void onViewCreated(View view, Bundle bundle) {
        String c11;
        super.onViewCreated(view, bundle);
        SNSCountrySelectorView l11 = l();
        if (l11 != null) {
            Context requireContext = requireContext();
            com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
            Drawable a11 = aVar.a(requireContext, SNSIconHandler.SNSCommonIcons.MORE.getImageName());
            if (a11 == null) {
                a11 = aVar.a(requireContext, SNSIconHandler.SNSCommonIcons.DISCLOSURE.getImageName());
            }
            l11.setIconEnd(a11);
        }
        SNSCountrySelectorView l12 = l();
        if (l12 != null) {
            l12.setOnClickListener(new b(this));
        }
        requireActivity().getSupportFragmentManager().H1(f30598p, this, new d(this));
        com.sumsub.sns.core.presentation.helper.a aVar2 = com.sumsub.sns.core.presentation.helper.a.f31095a;
        com.sumsub.sns.internal.core.theme.d a12 = aVar2.a();
        if (a12 != null && (c11 = aVar2.c(a12, SNSMetricElement.SECTION_HEADER_ALIGNMENT)) != null) {
            TextView m11 = m();
            if (m11 != null) {
                aVar2.a(m11, c11);
            }
            TextView o11 = o();
            if (o11 != null) {
                aVar2.a(o11, c11);
            }
        }
    }

    public final TextView p() {
        return (TextView) this.f30605f.a(this, f30594l[5]);
    }

    public final ViewGroup q() {
        return (ViewGroup) this.f30604e.a(this, f30594l[4]);
    }

    /* renamed from: r */
    public com.sumsub.sns.internal.camera.photo.presentation.a getViewModel() {
        return (com.sumsub.sns.internal.camera.photo.presentation.a) this.f30607h.getValue();
    }

    public final void b(SNSCountryPicker.CountryItem countryItem) {
        SNSCountrySelectorView l11 = l();
        String str = null;
        if (l11 != null) {
            l11.setIconStart(countryItem != null ? SNSDefaultCountryPickerKt.getFlagDrawable(countryItem, requireContext()) : null);
        }
        SNSCountrySelectorView l12 = l();
        if (l12 != null) {
            if (countryItem != null) {
                str = countryItem.getName();
            }
            l12.setTitle(str);
        }
    }

    public static final void a(a aVar, View view) {
        aVar.getViewModel().u();
    }

    public static final void a(a aVar, String str, Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable(f30599q);
        SNSPickerDialog.Item item = parcelable instanceof SNSPickerDialog.Item ? (SNSPickerDialog.Item) parcelable : null;
        if (item != null) {
            aVar.a(new SNSCountryPicker.CountryItem(item.getId(), item.getTitle()));
        }
    }

    /* renamed from: a */
    public void handleState(a.e eVar, Bundle bundle) {
        b(eVar.m());
        a(eVar.n(), eVar.l().d());
        a(eVar);
        TextView m11 = m();
        CharSequence charSequence = null;
        if (m11 != null) {
            a.f n11 = eVar.n();
            m11.setText(n11 != null ? n11.g() : null);
        }
        SNSCountrySelectorView l11 = l();
        if (l11 != null) {
            a.f n12 = eVar.n();
            l11.setPlaceholder(n12 != null ? n12.f() : null);
        }
        TextView p11 = p();
        if (p11 != null) {
            a.f n13 = eVar.n();
            if (n13 != null) {
                charSequence = n13.i();
            }
            com.sumsub.sns.internal.core.common.i.a(p11, charSequence);
        }
        TextView p12 = p();
        if (p12 != null) {
            com.sumsub.sns.core.common.b.a(p12, (d10.l<? super String, Unit>) new d(this));
            p12.setMovementMethod(new LinkMovementMethod());
        }
    }

    public final void a(a.e eVar) {
        List<SNSCountryPicker.CountryItem> j11 = eVar.j();
        if (j11 != null) {
            if (!eVar.k() || this.f30608i) {
                this.f30608i = false;
                return;
            }
            this.f30608i = true;
            e0.f32018a.getCountryPicker().pickCountry(requireContext(), j11, new c(this), f30598p, f30599q);
        }
    }

    public final void a(SNSCountryPicker.CountryItem countryItem) {
        getViewModel().a(countryItem);
        b(countryItem);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0103, code lost:
        if ((r13.length() > 0) == true) goto L_0x0107;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.sumsub.sns.internal.camera.photo.presentation.a.f r12, java.util.List<com.sumsub.sns.internal.camera.photo.presentation.a.b> r13) {
        /*
            r11 = this;
            java.util.List<com.sumsub.sns.internal.camera.photo.presentation.a$b> r0 = r11.f30609j
            boolean r0 = kotlin.jvm.internal.x.b(r0, r13)
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            r11.f30609j = r13
            android.widget.TextView r0 = r11.n()
            if (r0 != 0) goto L_0x0012
            goto L_0x0017
        L_0x0012:
            r1 = 8
            r0.setVisibility(r1)
        L_0x0017:
            boolean r0 = r13.isEmpty()
            r1 = 1
            r0 = r0 ^ r1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x00d3
            android.widget.TextView r0 = r11.o()
            if (r0 == 0) goto L_0x0030
            if (r12 == 0) goto L_0x002d
            java.lang.CharSequence r2 = r12.h()
        L_0x002d:
            com.sumsub.sns.internal.core.common.i.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x0030:
            android.view.ViewGroup r12 = r11.q()
            if (r12 == 0) goto L_0x0039
            androidx.transition.TransitionManager.a(r12)
        L_0x0039:
            android.view.ViewGroup r12 = r11.q()
            if (r12 == 0) goto L_0x0042
            r12.removeAllViews()
        L_0x0042:
            java.util.Iterator r12 = r13.iterator()
        L_0x0046:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x00c8
            java.lang.Object r13 = r12.next()
            com.sumsub.sns.internal.camera.photo.presentation.a$b r13 = (com.sumsub.sns.internal.camera.photo.presentation.a.b) r13
            com.sumsub.sns.core.widget.SNSSelectorItemView r0 = new com.sumsub.sns.core.widget.SNSSelectorItemView
            android.content.Context r5 = r11.requireContext()
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 14
            r10 = 0
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r0.setTag(r13)
            java.lang.CharSequence r1 = r13.d()
            r0.setTitle(r1)
            com.sumsub.sns.internal.core.common.e0 r1 = com.sumsub.sns.internal.core.common.e0.f32018a
            com.sumsub.sns.core.data.listener.SNSIconHandler r1 = r1.getIconHandler()
            android.content.Context r2 = r11.requireContext()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "IdentityType/"
            r4.append(r5)
            com.sumsub.sns.internal.core.data.model.q r5 = r13.c()
            java.lang.String r5 = r5.a()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            android.graphics.drawable.Drawable r1 = r1.onResolveIcon(r2, r4)
            r0.setIconStart(r1)
            android.content.Context r1 = r11.requireContext()
            com.sumsub.sns.core.presentation.helper.a r2 = com.sumsub.sns.core.presentation.helper.a.f31095a
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSCommonIcons r4 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSCommonIcons.MORE
            java.lang.String r4 = r4.getImageName()
            android.graphics.drawable.Drawable r4 = r2.a((android.content.Context) r1, (java.lang.String) r4)
            if (r4 != 0) goto L_0x00b2
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSCommonIcons r4 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSCommonIcons.DISCLOSURE
            java.lang.String r4 = r4.getImageName()
            android.graphics.drawable.Drawable r4 = r2.a((android.content.Context) r1, (java.lang.String) r4)
        L_0x00b2:
            r0.setIconEnd(r4)
            com.sumsub.sns.camera.photo.presentation.c r1 = new com.sumsub.sns.camera.photo.presentation.c
            r1.<init>(r11, r13)
            r0.setOnClickListener(r1)
            android.view.ViewGroup r13 = r11.q()
            if (r13 == 0) goto L_0x0046
            r13.addView(r0)
            goto L_0x0046
        L_0x00c8:
            android.view.ViewGroup r12 = r11.q()
            if (r12 != 0) goto L_0x00cf
            goto L_0x0118
        L_0x00cf:
            r12.setVisibility(r3)
            goto L_0x0118
        L_0x00d3:
            android.view.ViewGroup r13 = r11.q()
            if (r13 == 0) goto L_0x00dc
            r13.removeAllViews()
        L_0x00dc:
            r13 = 2
            android.view.View[] r13 = new android.view.View[r13]
            android.widget.TextView r0 = r11.o()
            r13[r3] = r0
            android.view.ViewGroup r0 = r11.q()
            r13[r1] = r0
            com.sumsub.sns.internal.core.common.i.a((android.view.View[]) r13)
            com.sumsub.sns.core.widget.SNSCountrySelectorView r13 = r11.l()
            if (r13 == 0) goto L_0x0106
            java.lang.CharSequence r13 = r13.getTitle()
            if (r13 == 0) goto L_0x0106
            int r13 = r13.length()
            if (r13 <= 0) goto L_0x0102
            r13 = r1
            goto L_0x0103
        L_0x0102:
            r13 = r3
        L_0x0103:
            if (r13 != r1) goto L_0x0106
            goto L_0x0107
        L_0x0106:
            r1 = r3
        L_0x0107:
            if (r1 == 0) goto L_0x0118
            android.widget.TextView r13 = r11.n()
            if (r13 == 0) goto L_0x0118
            if (r12 == 0) goto L_0x0115
            java.lang.CharSequence r2 = r12.j()
        L_0x0115:
            com.sumsub.sns.internal.core.common.i.a((android.widget.TextView) r13, (java.lang.CharSequence) r2)
        L_0x0118:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.camera.photo.presentation.a.a(com.sumsub.sns.internal.camera.photo.presentation.a$f, java.util.List):void");
    }

    public static final void a(a aVar, a.b bVar, View view) {
        aVar.getViewModel().a(bVar.c());
    }
}
