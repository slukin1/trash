package com.sumsub.sns.presentation.screen.preview.photo.identity;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.common.k0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0014J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00028TX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00138TX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/photo/identity/a;", "Lcom/sumsub/sns/presentation/screen/preview/photo/f;", "Lcom/sumsub/sns/internal/presentation/screen/preview/photo/identity/SNSPreviewIdentityDocumentViewModel;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "", "success", "Landroid/os/Parcelable;", "payload", "a", "Lcom/sumsub/sns/internal/core/common/q;", "finishReason", "onFinishCalled", "y", "Lcom/sumsub/sns/core/presentation/base/a$j;", "event", "handleEvent", "", "Ljava/lang/String;", "idDocType", "z", "Lkotlin/i;", "A", "()Lcom/sumsub/sns/internal/presentation/screen/preview/photo/identity/SNSPreviewIdentityDocumentViewModel;", "viewModel", "getIdDocSetType", "()Ljava/lang/String;", "idDocSetType", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class a extends com.sumsub.sns.presentation.screen.preview.photo.f<SNSPreviewIdentityDocumentViewModel> {
    public static final C0537a A = new C0537a((r) null);
    public static final String B = "pick_document";
    public static final String C = "ARGS_DOCUMENT";
    public static final String D = "SNSPreviewIdentityDocumentFragment";

    /* renamed from: y  reason: collision with root package name */
    public String f40009y;

    /* renamed from: z  reason: collision with root package name */
    public final i f40010z;

    /* renamed from: com.sumsub.sns.presentation.screen.preview.photo.identity.a$a  reason: collision with other inner class name */
    public static final class C0537a {
        public /* synthetic */ C0537a(r rVar) {
            this();
        }

        public final Fragment a(Document document) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARGS_DOCUMENT", document);
            aVar.setArguments(bundle);
            return aVar;
        }

        public C0537a() {
        }
    }

    public static final class b extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f40011a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.f40011a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f40011a;
        }
    }

    public static final class c extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f40012a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(d10.a aVar) {
            super(0);
            this.f40012a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f40012a.invoke();
        }
    }

    public static final class d extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f40013a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(i iVar) {
            super(0);
            this.f40013a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f40013a).getViewModelStore();
        }
    }

    public static final class e extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f40014a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f40015b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d10.a aVar, i iVar) {
            super(0);
            this.f40014a = aVar;
            this.f40015b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f40014a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f40015b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class f extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f40016a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f40017b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment, i iVar) {
            super(0);
            this.f40016a = fragment;
            this.f40017b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f40017b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f40016a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class g extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f40018a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(a aVar) {
            super(0);
            this.f40018a = aVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            Bundle arguments = this.f40018a.getArguments();
            Document document = arguments != null ? (Document) arguments.getParcelable("ARGS_DOCUMENT") : null;
            a aVar = this.f40018a;
            return new com.sumsub.sns.internal.presentation.screen.preview.photo.identity.a(document, aVar, aVar.getServiceLocator(), this.f40018a.getArguments());
        }
    }

    public a() {
        g gVar = new g(this);
        i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new c(new b(this)));
        this.f40010z = FragmentViewModelLazyKt.c(this, Reflection.b(SNSPreviewIdentityDocumentViewModel.class), new d(b11), new e((d10.a) null, b11), gVar);
    }

    /* renamed from: A */
    public SNSPreviewIdentityDocumentViewModel getViewModel() {
        return (SNSPreviewIdentityDocumentViewModel) this.f40010z.getValue();
    }

    public String getIdDocSetType() {
        DocumentType type;
        String c11;
        Bundle arguments = getArguments();
        Document document = null;
        Document document2 = arguments != null ? (Document) arguments.getParcelable("ARGS_DOCUMENT") : null;
        if (document2 instanceof Document) {
            document = document2;
        }
        return (document == null || (type = document.getType()) == null || (c11 = type.c()) == null) ? DocumentType.f32355j : c11;
    }

    public void handleEvent(a.j jVar) {
        if (jVar instanceof SNSPreviewIdentityDocumentViewModel.a) {
            k0 appListener = getAppListener();
            if (appListener != null) {
                appListener.a(B, ((SNSPreviewIdentityDocumentViewModel.a) jVar).b());
                return;
            }
            return;
        }
        super.handleEvent(jVar);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requireActivity().getSupportFragmentManager().H1(B, this, new b(this));
    }

    public boolean onFinishCalled(q qVar) {
        super.onFinishCalled(qVar);
        if (!getViewModel().V()) {
            return true;
        }
        getViewModel().X();
        return false;
    }

    public void y() {
        getViewModel().W();
    }

    public static final void a(a aVar, String str, Bundle bundle) {
        if (com.sumsub.sns.core.presentation.b.Companion.b(bundle)) {
            String string = bundle.getString(com.sumsub.sns.camera.photo.presentation.a.f30596n);
            String string2 = bundle.getString(com.sumsub.sns.camera.photo.presentation.a.f30597o);
            com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
            String a11 = com.sumsub.sns.internal.log.c.a(bVar);
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, a11, "Document selected: " + string + ' ' + string2, (Throwable) null, 4, (Object) null);
            if (string == null || string2 == null) {
                com.sumsub.sns.core.presentation.b.finish$default(aVar, (q) null, (Object) null, (Long) null, 7, (Object) null);
                return;
            }
            aVar.f40009y = string2;
            aVar.getViewModel().b(string, string2);
            return;
        }
        com.sumsub.sns.core.presentation.b.finish$default(aVar, (q) null, (Object) null, (Long) null, 7, (Object) null);
    }

    public void a(boolean z11, Parcelable parcelable) {
        if (z11 || getViewModel().V()) {
            super.a(z11, parcelable);
            return;
        }
        com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, com.sumsub.sns.internal.log.c.a(bVar), "On instructions showed, is not success and viewModel.hasPhoto()==false", (Throwable) null, 4, (Object) null);
        if (getViewModel().H() || getViewModel().T()) {
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, com.sumsub.sns.internal.log.c.a(bVar), "On instructions showed, finish", (Throwable) null, 4, (Object) null);
            com.sumsub.sns.core.presentation.b.finish$default(this, (q) null, (Object) null, (Long) null, 7, (Object) null);
            return;
        }
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, com.sumsub.sns.internal.log.c.a(bVar), "On instructions showed, restart step", (Throwable) null, 4, (Object) null);
        getViewModel().Y();
    }
}
