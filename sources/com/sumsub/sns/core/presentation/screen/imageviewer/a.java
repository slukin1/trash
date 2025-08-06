package com.sumsub.sns.core.presentation.screen.imageviewer;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.sumsub.sns.R;
import com.sumsub.sns.core.widget.SNSRotationZoomableImageView;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.z;
import com.sumsub.sns.internal.core.presentation.screen.imageviewer.a;
import java.io.File;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.reflect.l;

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 72\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b5\u00106J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\u0011\u001a\u00020\bH\u0016J\u0019\u0010\u0010\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0013R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00148BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00198BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010 \u001a\u0004\u0018\u00010\u00198BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u001cR\u001b\u0010%\u001a\u00020\u00038TX\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010+\u001a\u00020&8\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010-R\u0014\u00104\u001a\u0002018TX\u0004¢\u0006\u0006\u001a\u0004\b2\u00103¨\u00068"}, d2 = {"Lcom/sumsub/sns/core/presentation/screen/imageviewer/a;", "Lcom/sumsub/sns/core/presentation/b;", "Lcom/sumsub/sns/internal/core/presentation/screen/imageviewer/a$b;", "Lcom/sumsub/sns/internal/core/presentation/screen/imageviewer/a;", "", "getLayoutId", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "outState", "onSaveInstanceState", "Landroid/view/View;", "view", "onViewCreated", "state", "a", "onDestroyView", "rotation", "(Ljava/lang/Integer;)V", "Lcom/sumsub/sns/core/widget/SNSRotationZoomableImageView;", "Lcom/sumsub/sns/internal/core/common/z;", "k", "()Lcom/sumsub/sns/core/widget/SNSRotationZoomableImageView;", "imageView", "Landroid/widget/ImageButton;", "b", "m", "()Landroid/widget/ImageButton;", "rotateCw", "c", "l", "rotateCcw", "d", "Lkotlin/i;", "n", "()Lcom/sumsub/sns/internal/core/presentation/screen/imageviewer/a;", "viewModel", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "e", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "getScreen", "()Lcom/sumsub/sns/internal/core/analytics/Screen;", "screen", "f", "I", "navigationBarColor", "g", "statusBarColor", "", "getIdDocSetType", "()Ljava/lang/String;", "idDocSetType", "<init>", "()V", "h", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class a extends com.sumsub.sns.core.presentation.b<a.b, com.sumsub.sns.internal.core.presentation.screen.imageviewer.a> {

    /* renamed from: h  reason: collision with root package name */
    public static final C0295a f31099h = new C0295a((r) null);

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ l<Object>[] f31100i = {Reflection.j(new PropertyReference1Impl(a.class, "imageView", "getImageView()Lcom/sumsub/sns/core/widget/SNSRotationZoomableImageView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "rotateCw", "getRotateCw()Landroid/widget/ImageButton;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "rotateCcw", "getRotateCcw()Landroid/widget/ImageButton;", 0))};

    /* renamed from: j  reason: collision with root package name */
    public static final String f31101j = "SNSImageViewerFragment";

    /* renamed from: k  reason: collision with root package name */
    public static final String f31102k = "rotation";

    /* renamed from: l  reason: collision with root package name */
    public static final String f31103l = "file";

    /* renamed from: m  reason: collision with root package name */
    public static final String f31104m = "nav_bar_color";

    /* renamed from: n  reason: collision with root package name */
    public static final String f31105n = "status_bar_color";

    /* renamed from: a  reason: collision with root package name */
    public final z f31106a = a0.a(this, R.id.image_view);

    /* renamed from: b  reason: collision with root package name */
    public final z f31107b = a0.a(this, R.id.sns_rotate_cw);

    /* renamed from: c  reason: collision with root package name */
    public final z f31108c = a0.a(this, R.id.sns_rotate_ccw);

    /* renamed from: d  reason: collision with root package name */
    public final i f31109d;

    /* renamed from: e  reason: collision with root package name */
    public final Screen f31110e;

    /* renamed from: f  reason: collision with root package name */
    public int f31111f;

    /* renamed from: g  reason: collision with root package name */
    public int f31112g;

    /* renamed from: com.sumsub.sns.core.presentation.screen.imageviewer.a$a  reason: collision with other inner class name */
    public static final class C0295a {
        public /* synthetic */ C0295a(r rVar) {
            this();
        }

        public final a a(File file, int i11, String str) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putSerializable("file", file);
            bundle.putInt("rotation", i11);
            bundle.putString("arg_iddocsettype", str);
            aVar.setArguments(bundle);
            return aVar;
        }

        public C0295a() {
        }
    }

    public static final class b extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f31113a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.f31113a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f31113a;
        }
    }

    public static final class c extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f31114a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(d10.a aVar) {
            super(0);
            this.f31114a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f31114a.invoke();
        }
    }

    public static final class d extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f31115a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(i iVar) {
            super(0);
            this.f31115a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f31115a).getViewModelStore();
        }
    }

    public static final class e extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f31116a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f31117b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d10.a aVar, i iVar) {
            super(0);
            this.f31116a = aVar;
            this.f31117b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f31116a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f31117b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class f extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f31118a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f31119b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment, i iVar) {
            super(0);
            this.f31118a = fragment;
            this.f31119b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f31119b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f31118a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class g extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31120a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(a aVar) {
            super(0);
            this.f31120a = aVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            a aVar = this.f31120a;
            return new com.sumsub.sns.internal.core.presentation.screen.imageviewer.b(aVar, aVar.getArguments(), this.f31120a.getServiceLocator());
        }
    }

    public a() {
        g gVar = new g(this);
        i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new c(new b(this)));
        this.f31109d = FragmentViewModelLazyKt.c(this, Reflection.b(com.sumsub.sns.internal.core.presentation.screen.imageviewer.a.class), new d(b11), new e((d10.a) null, b11), gVar);
        this.f31110e = Screen.ImageViewer;
    }

    public static final void b(a aVar, View view) {
        SNSRotationZoomableImageView k11 = aVar.k();
        if (k11 != null) {
            k11.rotateCCW();
        }
        SNSRotationZoomableImageView k12 = aVar.k();
        aVar.a(k12 != null ? Integer.valueOf(k12.getRotation()) : null);
    }

    public String getIdDocSetType() {
        return getViewModel().r();
    }

    public int getLayoutId() {
        return R.layout.sns_layout_image_viewer;
    }

    public Screen getScreen() {
        return this.f31110e;
    }

    public final SNSRotationZoomableImageView k() {
        return (SNSRotationZoomableImageView) this.f31106a.a(this, f31100i[0]);
    }

    public final ImageButton l() {
        return (ImageButton) this.f31108c.a(this, f31100i[2]);
    }

    public final ImageButton m() {
        return (ImageButton) this.f31107b.a(this, f31100i[1]);
    }

    /* renamed from: n */
    public com.sumsub.sns.internal.core.presentation.screen.imageviewer.a getViewModel() {
        return (com.sumsub.sns.internal.core.presentation.screen.imageviewer.a) this.f31109d.getValue();
    }

    public void onCreate(Bundle bundle) {
        Window window;
        super.onCreate(bundle);
        if (bundle == null) {
            FragmentActivity activity = getActivity();
            if (activity != null && (window = activity.getWindow()) != null) {
                this.f31112g = window.getStatusBarColor();
                this.f31111f = window.getNavigationBarColor();
                return;
            }
            return;
        }
        this.f31111f = bundle.getInt(f31104m);
        this.f31112g = bundle.getInt(f31105n);
    }

    public void onDestroyView() {
        Window window;
        super.onDestroyView();
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setStatusBarColor(this.f31112g);
            window.setNavigationBarColor(this.f31111f);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(f31104m, this.f31111f);
        bundle.putInt(f31105n, this.f31112g);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setBackgroundColor(this.f31112g);
        ImageButton m11 = m();
        if (m11 != null) {
            m11.setOnClickListener(new b(this));
        }
        ImageButton l11 = l();
        if (l11 != null) {
            l11.setOnClickListener(new c(this));
        }
        com.sumsub.sns.core.presentation.b.setResult$default(this, getViewModel().s(), (Bundle) null, 2, (Object) null);
    }

    public static final void a(a aVar, View view) {
        SNSRotationZoomableImageView k11 = aVar.k();
        if (k11 != null) {
            k11.rotateCW();
        }
        SNSRotationZoomableImageView k12 = aVar.k();
        aVar.a(k12 != null ? Integer.valueOf(k12.getRotation()) : null);
    }

    /* renamed from: a */
    public void handleState(a.b bVar, Bundle bundle) {
        SNSRotationZoomableImageView k11 = k();
        if (k11 != null) {
            k11.setImageBitmapWithRotation(bVar.d(), bVar.f());
        }
    }

    public final void a(Integer num) {
        if (num != null) {
            num.intValue();
            Bundle bundle = new Bundle();
            bundle.putInt("rotation", num.intValue());
            bundle.putSerializable("file", getViewModel().p());
            Unit unit = Unit.f56620a;
            com.sumsub.sns.core.presentation.b.setResult$default(this, 0, bundle, 1, (Object) null);
        }
    }
}
