package com.sumsub.sns.camera.photo.presentation.selfie;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.camera.view.PreviewView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.sumsub.sns.R;
import com.sumsub.sns.core.widget.SNSToolbarView;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.z;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.reflect.l;

@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 F2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001GB\u0007¢\u0006\u0004\bD\u0010EJ\b\u0010\u0004\u001a\u00020\u0003H\u0014R\u001b\u0010\t\u001a\u00020\u00028TX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8TX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\n8TX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001d\u0010\u0015\u001a\u0004\u0018\u00010\n8TX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u001d\u0010\u0018\u001a\u0004\u0018\u00010\n8TX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000eR\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00198TX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010 \u001a\u0004\u0018\u00010\n8TX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001f\u0010\u000eR\u001d\u0010%\u001a\u0004\u0018\u00010!8TX\u0002¢\u0006\f\n\u0004\b\"\u0010\f\u001a\u0004\b#\u0010$R\u001d\u0010(\u001a\u0004\u0018\u00010&8TX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\f\u001a\u0004\b\u0013\u0010'R\u001d\u0010)\u001a\u0004\u0018\u00010&8TX\u0002¢\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u0005\u0010'R\u001d\u0010+\u001a\u0004\u0018\u00010&8TX\u0002¢\u0006\f\n\u0004\b*\u0010\f\u001a\u0004\b\u000b\u0010'R\u001d\u0010,\u001a\u0004\u0018\u00010!8TX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0010\u0010$R\u001d\u0010/\u001a\u0004\u0018\u00010\n8TX\u0002¢\u0006\f\n\u0004\b-\u0010\f\u001a\u0004\b.\u0010\u000eR\u001d\u00102\u001a\u0004\u0018\u0001008TX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\"\u00101R\u001a\u00107\u001a\u0002038\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u00104\u001a\u0004\b5\u00106R\u001a\u0010<\u001a\u0002088\u0016XD¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b*\u0010;R\u001a\u0010>\u001a\u0002088\u0016XD¢\u0006\f\n\u0004\b=\u0010:\u001a\u0004\b=\u0010;R\u0016\u0010?\u001a\u0004\u0018\u00010\n8TX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u000eR\u0014\u0010C\u001a\u00020@8TX\u0004¢\u0006\u0006\u001a\u0004\bA\u0010B¨\u0006H"}, d2 = {"Lcom/sumsub/sns/camera/photo/presentation/selfie/a;", "Lcom/sumsub/sns/camera/b;", "Lcom/sumsub/sns/internal/camera/photo/presentation/selfie/a;", "", "getLayoutId", "o", "Lkotlin/i;", "N", "()Lcom/sumsub/sns/internal/camera/photo/presentation/selfie/a;", "viewModel", "Landroid/view/View;", "p", "Lcom/sumsub/sns/internal/core/common/z;", "x", "()Landroid/view/View;", "rootView", "q", "z", "takePictureProgressView", "r", "B", "takePictureViewContainer", "s", "J", "takeGalleryView", "Lcom/sumsub/sns/core/widget/SNSToolbarView;", "t", "C", "()Lcom/sumsub/sns/core/widget/SNSToolbarView;", "toolbar", "u", "w", "progressBar", "Landroid/view/ViewGroup;", "v", "M", "()Landroid/view/ViewGroup;", "helperView", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "helperTitle", "helperBrief", "y", "helperDetails", "helperDetailsFrame", "A", "m", "darkOverlay", "Landroidx/camera/view/PreviewView;", "()Landroidx/camera/view/PreviewView;", "previewView", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "getScreen", "()Lcom/sumsub/sns/internal/core/analytics/Screen;", "screen", "", "D", "Z", "()Z", "shouldShowFlash", "E", "isFrontFacingCamera", "takePictureView", "", "getIdDocSetType", "()Ljava/lang/String;", "idDocSetType", "<init>", "()V", "F", "a", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class a extends com.sumsub.sns.camera.b<com.sumsub.sns.internal.camera.photo.presentation.selfie.a> {
    public static final C0276a F = new C0276a((r) null);
    public static final /* synthetic */ l<Object>[] G = {Reflection.j(new PropertyReference1Impl(a.class, "rootView", "getRootView()Landroid/view/View;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "takePictureProgressView", "getTakePictureProgressView()Landroid/view/View;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "takePictureViewContainer", "getTakePictureViewContainer()Landroid/view/View;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "takeGalleryView", "getTakeGalleryView()Landroid/view/View;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "toolbar", "getToolbar()Lcom/sumsub/sns/core/widget/SNSToolbarView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "progressBar", "getProgressBar()Landroid/view/View;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "helperView", "getHelperView()Landroid/view/ViewGroup;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "helperTitle", "getHelperTitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "helperBrief", "getHelperBrief()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "helperDetails", "getHelperDetails()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "helperDetailsFrame", "getHelperDetailsFrame()Landroid/view/ViewGroup;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "darkOverlay", "getDarkOverlay()Landroid/view/View;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "previewView", "getPreviewView()Landroidx/camera/view/PreviewView;", 0))};
    public final z A;
    public final z B;
    public final Screen C;
    public final boolean D;
    public final boolean E;

    /* renamed from: o  reason: collision with root package name */
    public final i f30694o;

    /* renamed from: p  reason: collision with root package name */
    public final z f30695p;

    /* renamed from: q  reason: collision with root package name */
    public final z f30696q = a0.a(this, R.id.sns_primary_button_progress);

    /* renamed from: r  reason: collision with root package name */
    public final z f30697r = a0.a(this, R.id.sns_primary_button);

    /* renamed from: s  reason: collision with root package name */
    public final z f30698s = a0.a(this, R.id.sns_gallery);

    /* renamed from: t  reason: collision with root package name */
    public final z f30699t = a0.a(this, R.id.sns_toolbar);

    /* renamed from: u  reason: collision with root package name */
    public final z f30700u;

    /* renamed from: v  reason: collision with root package name */
    public final z f30701v;

    /* renamed from: w  reason: collision with root package name */
    public final z f30702w;

    /* renamed from: x  reason: collision with root package name */
    public final z f30703x;

    /* renamed from: y  reason: collision with root package name */
    public final z f30704y;

    /* renamed from: z  reason: collision with root package name */
    public final z f30705z;

    /* renamed from: com.sumsub.sns.camera.photo.presentation.selfie.a$a  reason: collision with other inner class name */
    public static final class C0276a {
        public /* synthetic */ C0276a(r rVar) {
            this();
        }

        public static /* synthetic */ a a(C0276a aVar, DocumentType documentType, boolean z11, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            return aVar.a(documentType, z11);
        }

        public C0276a() {
        }

        public final a a(DocumentType documentType, boolean z11) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putString(com.sumsub.sns.internal.camera.a.f31319c, documentType.c());
            bundle.putBoolean(com.sumsub.sns.internal.camera.a.f31323g, z11);
            aVar.setArguments(bundle);
            return aVar;
        }
    }

    public static final class b extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f30706a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.f30706a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f30706a;
        }
    }

    public static final class c extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f30707a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(d10.a aVar) {
            super(0);
            this.f30707a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f30707a.invoke();
        }
    }

    public static final class d extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f30708a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(i iVar) {
            super(0);
            this.f30708a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f30708a).getViewModelStore();
        }
    }

    public static final class e extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f30709a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f30710b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d10.a aVar, i iVar) {
            super(0);
            this.f30709a = aVar;
            this.f30710b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f30709a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f30710b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class f extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f30711a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f30712b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment, i iVar) {
            super(0);
            this.f30711a = fragment;
            this.f30712b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f30712b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f30711a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class g extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30713a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(a aVar) {
            super(0);
            this.f30713a = aVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            a aVar = this.f30713a;
            return new com.sumsub.sns.internal.camera.photo.presentation.selfie.b(aVar, aVar.getServiceLocator(), this.f30713a.getArguments());
        }
    }

    public a() {
        g gVar = new g(this);
        i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new c(new b(this)));
        this.f30694o = FragmentViewModelLazyKt.c(this, Reflection.b(com.sumsub.sns.internal.camera.photo.presentation.selfie.a.class), new d(b11), new e((d10.a) null, b11), gVar);
        int i11 = R.id.sns_picker_progress;
        this.f30695p = a0.a(this, i11);
        this.f30700u = a0.a(this, i11);
        this.f30701v = a0.a(this, R.id.sns_helper);
        this.f30702w = a0.a(this, R.id.sns_helper_title);
        this.f30703x = a0.a(this, R.id.sns_helper_brief);
        this.f30704y = a0.a(this, R.id.sns_helper_details);
        this.f30705z = a0.a(this, R.id.sns_helper_details_frame);
        this.A = a0.a(this, R.id.sns_dark_overlay);
        this.B = a0.a(this, R.id.sns_camera_preview);
        this.C = com.sumsub.sns.core.presentation.c.f30925a.a((Fragment) this);
        this.E = true;
    }

    public View A() {
        View B2 = B();
        if (B2 != null) {
            return B2.findViewById(R.id.sns_button);
        }
        return null;
    }

    public View B() {
        return this.f30697r.a(this, G[2]);
    }

    public SNSToolbarView C() {
        return (SNSToolbarView) this.f30699t.a(this, G[4]);
    }

    public boolean E() {
        return this.E;
    }

    public View J() {
        return this.f30698s.a(this, G[3]);
    }

    /* renamed from: M */
    public ViewGroup s() {
        return (ViewGroup) this.f30701v.a(this, G[6]);
    }

    /* renamed from: N */
    public com.sumsub.sns.internal.camera.photo.presentation.selfie.a getViewModel() {
        return (com.sumsub.sns.internal.camera.photo.presentation.selfie.a) this.f30694o.getValue();
    }

    public String getIdDocSetType() {
        return getViewModel().u().c();
    }

    public int getLayoutId() {
        return R.layout.sns_fragment_document_picker;
    }

    public Screen getScreen() {
        return this.C;
    }

    public View m() {
        return this.A.a(this, G[11]);
    }

    public TextView o() {
        return (TextView) this.f30703x.a(this, G[8]);
    }

    public TextView p() {
        return (TextView) this.f30704y.a(this, G[9]);
    }

    public ViewGroup q() {
        return (ViewGroup) this.f30705z.a(this, G[10]);
    }

    public TextView r() {
        return (TextView) this.f30702w.a(this, G[7]);
    }

    public PreviewView v() {
        return (PreviewView) this.B.a(this, G[12]);
    }

    public View w() {
        return this.f30700u.a(this, G[5]);
    }

    public View x() {
        return this.f30695p.a(this, G[0]);
    }

    public boolean y() {
        return this.D;
    }

    public View z() {
        return this.f30696q.a(this, G[1]);
    }
}
