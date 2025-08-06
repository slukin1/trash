package com.sumsub.sns.presentation.screen.preview.photo.common;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0004\u001a\u00020\u0003H\u0014R\u001b\u0010\b\u001a\u00020\u00028TX\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8TX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/photo/common/a;", "Lcom/sumsub/sns/presentation/screen/preview/photo/f;", "Lcom/sumsub/sns/internal/presentation/screen/preview/photo/common/a;", "", "y", "Lkotlin/i;", "A", "()Lcom/sumsub/sns/internal/presentation/screen/preview/photo/common/a;", "viewModel", "", "getIdDocSetType", "()Ljava/lang/String;", "idDocSetType", "<init>", "()V", "z", "a", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class a extends com.sumsub.sns.presentation.screen.preview.photo.f<com.sumsub.sns.internal.presentation.screen.preview.photo.common.a> {
    public static final String A = "ARGS_DOCUMENT";
    public static final String B = "SNSPreviewCommonDocumentFragment";

    /* renamed from: z  reason: collision with root package name */
    public static final C0535a f39952z = new C0535a((r) null);

    /* renamed from: y  reason: collision with root package name */
    public final i f39953y;

    /* renamed from: com.sumsub.sns.presentation.screen.preview.photo.common.a$a  reason: collision with other inner class name */
    public static final class C0535a {
        public /* synthetic */ C0535a(r rVar) {
            this();
        }

        public final Fragment a(Document document) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARGS_DOCUMENT", document);
            aVar.setArguments(bundle);
            return aVar;
        }

        public C0535a() {
        }
    }

    public static final class b extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f39954a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.f39954a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f39954a;
        }
    }

    public static final class c extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f39955a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(d10.a aVar) {
            super(0);
            this.f39955a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f39955a.invoke();
        }
    }

    public static final class d extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f39956a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(i iVar) {
            super(0);
            this.f39956a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f39956a).getViewModelStore();
        }
    }

    public static final class e extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f39957a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f39958b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d10.a aVar, i iVar) {
            super(0);
            this.f39957a = aVar;
            this.f39958b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f39957a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f39958b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class f extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f39959a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f39960b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment, i iVar) {
            super(0);
            this.f39959a = fragment;
            this.f39960b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f39960b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f39959a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class g extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39961a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(a aVar) {
            super(0);
            this.f39961a = aVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            Bundle arguments = this.f39961a.getArguments();
            Document document = arguments != null ? (Document) arguments.getParcelable("ARGS_DOCUMENT") : null;
            a aVar = this.f39961a;
            return new com.sumsub.sns.internal.presentation.screen.preview.photo.common.b(document, aVar, aVar.getServiceLocator(), this.f39961a.getArguments());
        }
    }

    public a() {
        g gVar = new g(this);
        i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new c(new b(this)));
        this.f39953y = FragmentViewModelLazyKt.c(this, Reflection.b(com.sumsub.sns.internal.presentation.screen.preview.photo.common.a.class), new d(b11), new e((d10.a) null, b11), gVar);
    }

    /* renamed from: A */
    public com.sumsub.sns.internal.presentation.screen.preview.photo.common.a getViewModel() {
        return (com.sumsub.sns.internal.presentation.screen.preview.photo.common.a) this.f39953y.getValue();
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

    public void y() {
        com.sumsub.sns.core.presentation.b.finish$default(this, (q) null, (Object) null, (Long) null, 7, (Object) null);
    }
}
