package com.sumsub.sns.presentation.screen.preview.selfie;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.sumsub.sns.R;
import com.sumsub.sns.camera.video.presentation.a;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.analytics.Control;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.z;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.presentation.screen.preview.selfie.a;
import java.io.File;
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

@Metadata(bv = {}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 42\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0007¢\u0006\u0004\bI\u0010\u001eJ\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\b\u0010\u0015\u001a\u00020\bH\u0016J\u0012\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002R!\u0010\u001f\u001a\u00020\u00038TX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u001a\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010%\u001a\u0004\u0018\u00010 8BX\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010)\u001a\u0004\u0018\u00010&8BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\"\u001a\u0004\b'\u0010(R\u001d\u0010.\u001a\u0004\u0018\u00010*8BX\u0002¢\u0006\f\n\u0004\b+\u0010\"\u001a\u0004\b,\u0010-R\u001d\u00101\u001a\u0004\u0018\u00010*8BX\u0002¢\u0006\f\n\u0004\b/\u0010\"\u001a\u0004\b0\u0010-R\u001d\u00106\u001a\u0004\u0018\u0001028BX\u0002¢\u0006\f\n\u0004\b3\u0010\"\u001a\u0004\b4\u00105R\u001d\u00109\u001a\u0004\u0018\u0001028BX\u0002¢\u0006\f\n\u0004\b7\u0010\"\u001a\u0004\b8\u00105R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8TX\u0004¢\u0006\u0006\u001a\u0004\bF\u0010G¨\u0006J"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/selfie/a;", "Lcom/sumsub/sns/presentation/screen/preview/a;", "Lcom/sumsub/sns/internal/presentation/screen/preview/selfie/a$d;", "Lcom/sumsub/sns/internal/presentation/screen/preview/selfie/a;", "", "getLayoutId", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "Landroid/view/View;", "view", "onViewCreated", "state", "a", "Lcom/sumsub/sns/core/presentation/base/a$j;", "event", "handleEvent", "", "hideLogo", "updatePoweredByVisibility", "onStop", "Ljava/io/File;", "file", "c", "s", "Lkotlin/i;", "q", "()Lcom/sumsub/sns/internal/presentation/screen/preview/selfie/a;", "getViewModel$annotations", "()V", "viewModel", "Landroidx/constraintlayout/widget/Group;", "b", "Lcom/sumsub/sns/internal/core/common/z;", "m", "()Landroidx/constraintlayout/widget/Group;", "gContent", "Landroid/widget/VideoView;", "n", "()Landroid/widget/VideoView;", "playerView", "Landroid/widget/TextView;", "d", "p", "()Landroid/widget/TextView;", "tvTitle", "e", "o", "tvSubtitle", "Landroid/widget/Button;", "f", "k", "()Landroid/widget/Button;", "btnReadableVideo", "g", "l", "btnTakeAnotherVideo", "Landroid/widget/MediaController;", "h", "Landroid/widget/MediaController;", "mediaController", "i", "Ljava/io/File;", "videoFile", "Ljava/lang/Runnable;", "j", "Ljava/lang/Runnable;", "showControlsCallback", "", "getIdDocSetType", "()Ljava/lang/String;", "idDocSetType", "<init>", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class a extends com.sumsub.sns.presentation.screen.preview.a<a.d, com.sumsub.sns.internal.presentation.screen.preview.selfie.a> {

    /* renamed from: k  reason: collision with root package name */
    public static final C0539a f40071k = new C0539a((r) null);

    /* renamed from: l  reason: collision with root package name */
    public static final /* synthetic */ l<Object>[] f40072l = {Reflection.j(new PropertyReference1Impl(a.class, "gContent", "getGContent()Landroidx/constraintlayout/widget/Group;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "playerView", "getPlayerView()Landroid/widget/VideoView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "tvTitle", "getTvTitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "tvSubtitle", "getTvSubtitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "btnReadableVideo", "getBtnReadableVideo()Landroid/widget/Button;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "btnTakeAnotherVideo", "getBtnTakeAnotherVideo()Landroid/widget/Button;", 0))};

    /* renamed from: m  reason: collision with root package name */
    public static final String f40073m = "video_selfie";

    /* renamed from: n  reason: collision with root package name */
    public static final String f40074n = "ARGS_DOCUMENT";

    /* renamed from: o  reason: collision with root package name */
    public static final String f40075o = "PreviewSelfieFragment";

    /* renamed from: p  reason: collision with root package name */
    public static final int f40076p = 2000;

    /* renamed from: a  reason: collision with root package name */
    public final i f40077a;

    /* renamed from: b  reason: collision with root package name */
    public final z f40078b = a0.a(this, R.id.sns_content);

    /* renamed from: c  reason: collision with root package name */
    public final z f40079c = a0.a(this, R.id.sns_player);

    /* renamed from: d  reason: collision with root package name */
    public final z f40080d = a0.a(this, R.id.sns_title);

    /* renamed from: e  reason: collision with root package name */
    public final z f40081e = a0.a(this, R.id.sns_subtitle);

    /* renamed from: f  reason: collision with root package name */
    public final z f40082f = a0.a(this, R.id.sns_primary_button);

    /* renamed from: g  reason: collision with root package name */
    public final z f40083g = a0.a(this, R.id.sns_secondary_button);

    /* renamed from: h  reason: collision with root package name */
    public MediaController f40084h;

    /* renamed from: i  reason: collision with root package name */
    public File f40085i;

    /* renamed from: j  reason: collision with root package name */
    public final Runnable f40086j = new h(this);

    /* renamed from: com.sumsub.sns.presentation.screen.preview.selfie.a$a  reason: collision with other inner class name */
    public static final class C0539a {
        public /* synthetic */ C0539a(r rVar) {
            this();
        }

        public final Fragment a(Document document) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARGS_DOCUMENT", document);
            aVar.setArguments(bundle);
            return aVar;
        }

        public C0539a() {
        }
    }

    public static final class b extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f40087a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.f40087a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f40087a;
        }
    }

    public static final class c extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f40088a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(d10.a aVar) {
            super(0);
            this.f40088a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f40088a.invoke();
        }
    }

    public static final class d extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f40089a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(i iVar) {
            super(0);
            this.f40089a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f40089a).getViewModelStore();
        }
    }

    public static final class e extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f40090a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f40091b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d10.a aVar, i iVar) {
            super(0);
            this.f40090a = aVar;
            this.f40091b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f40090a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f40091b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class f extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f40092a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f40093b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment, i iVar) {
            super(0);
            this.f40092a = fragment;
            this.f40093b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f40093b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f40092a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class g extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f40094a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(a aVar) {
            super(0);
            this.f40094a = aVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            Bundle arguments = this.f40094a.getArguments();
            Document document = arguments != null ? (Document) arguments.getParcelable("ARGS_DOCUMENT") : null;
            a aVar = this.f40094a;
            return new com.sumsub.sns.internal.presentation.screen.preview.selfie.b(document, aVar, aVar.getServiceLocator(), this.f40094a.getArguments());
        }
    }

    public a() {
        g gVar = new g(this);
        i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new c(new b(this)));
        this.f40077a = FragmentViewModelLazyKt.c(this, Reflection.b(com.sumsub.sns.internal.presentation.screen.preview.selfie.a.class), new d(b11), new e((d10.a) null, b11), gVar);
    }

    public static final void b(a aVar) {
        MediaController mediaController = aVar.f40084h;
        if (mediaController != null) {
            mediaController.show(2000);
        }
    }

    public static /* synthetic */ void r() {
    }

    public final void c(File file) {
        if (file != null) {
            s();
        }
        if (!x.b(this.f40085i, file) && file != null) {
            this.f40085i = file;
            VideoView n11 = n();
            if (n11 != null) {
                n11.setVideoPath(file.getAbsolutePath());
                n11.requestFocus();
            }
        }
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

    public int getLayoutId() {
        return R.layout.sns_fragment_preview_selfie;
    }

    public void handleEvent(a.j jVar) {
        com.sumsub.sns.internal.presentation.screen.preview.selfie.c.a(com.sumsub.sns.internal.presentation.screen.preview.selfie.c.f36237b, "handleEvent: " + jVar, (Throwable) null, 4, (Object) null);
        super.handleEvent(jVar);
        if (jVar instanceof a.b) {
            a.C0277a aVar = com.sumsub.sns.camera.video.presentation.a.f30714o;
            a.b bVar = (a.b) jVar;
            String c11 = bVar.b().c();
            String d11 = bVar.b().d();
            if (d11 == null) {
                d11 = "";
            }
            navigateTo(aVar.a(c11, d11).forResult(f40073m), com.sumsub.sns.internal.log.c.a(aVar));
        }
    }

    public final Button k() {
        return (Button) this.f40082f.a(this, f40072l[4]);
    }

    public final Button l() {
        return (Button) this.f40083g.a(this, f40072l[5]);
    }

    public final Group m() {
        return (Group) this.f40078b.a(this, f40072l[0]);
    }

    public final VideoView n() {
        return (VideoView) this.f40079c.a(this, f40072l[1]);
    }

    public final TextView o() {
        return (TextView) this.f40081e.a(this, f40072l[3]);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requireActivity().getSupportFragmentManager().H1(f40073m, this, new g(this));
    }

    public void onStop() {
        com.sumsub.sns.internal.presentation.screen.preview.selfie.c.a(com.sumsub.sns.internal.presentation.screen.preview.selfie.c.f36237b, "onStop", (Throwable) null, 4, (Object) null);
        s();
        VideoView n11 = n();
        if (n11 != null) {
            n11.removeCallbacks(this.f40086j);
        }
        super.onStop();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Button k11 = k();
        if (k11 != null) {
            k11.setOnClickListener(new e(this));
        }
        Button l11 = l();
        if (l11 != null) {
            l11.setOnClickListener(new f(this));
        }
        VideoView n11 = n();
        if (n11 != null) {
            MediaController mediaController = new MediaController(requireContext());
            this.f40084h = mediaController;
            n11.setMediaController(mediaController);
            n11.setOnCompletionListener(b.f40095b);
            n11.setOnPreparedListener(d.f40097b);
            n11.setOnErrorListener(c.f40096b);
            n11.post(this.f40086j);
        }
    }

    public final TextView p() {
        return (TextView) this.f40080d.a(this, f40072l[2]);
    }

    /* renamed from: q */
    public com.sumsub.sns.internal.presentation.screen.preview.selfie.a getViewModel() {
        return (com.sumsub.sns.internal.presentation.screen.preview.selfie.a) this.f40077a.getValue();
    }

    public final void s() {
        VideoView n11 = n();
        if (n11 != null) {
            if (n11.isPlaying() || this.f40085i != null) {
                com.sumsub.sns.internal.presentation.screen.preview.selfie.c.a(com.sumsub.sns.internal.presentation.screen.preview.selfie.c.f36237b, "stopPlayback", (Throwable) null, 4, (Object) null);
                this.f40085i = null;
                n11.stopPlayback();
            }
        }
    }

    public void updatePoweredByVisibility(boolean z11) {
        View findViewById = requireView().findViewById(R.id.sns_powered);
        if (findViewById != null) {
            com.sumsub.sns.internal.core.common.i.a(findViewById, z11);
        }
    }

    public static final void a(a aVar, String str, Bundle bundle) {
        String string = bundle.getString(com.sumsub.sns.camera.video.presentation.a.f30716q);
        aVar.getViewModel().a(string == null || string.length() == 0 ? null : new File(string), bundle.getString(com.sumsub.sns.camera.video.presentation.a.f30717r));
    }

    public static final void b(a aVar, View view) {
        com.sumsub.sns.internal.core.analytics.c.b(aVar.getAnalyticsDelegate(), aVar.getScreen(), aVar.getIdDocSetType(), Control.RetakeButton, (Map) null, 8, (Object) null);
        aVar.s();
        aVar.getViewModel().z();
    }

    public static final void a(a aVar, View view) {
        com.sumsub.sns.internal.core.analytics.c.b(aVar.getAnalyticsDelegate(), aVar.getScreen(), aVar.getIdDocSetType(), Control.AcceptButton, (Map) null, 8, (Object) null);
        aVar.s();
        aVar.getViewModel().y();
    }

    public static final void b(MediaPlayer mediaPlayer) {
        com.sumsub.sns.internal.presentation.screen.preview.selfie.c.a(com.sumsub.sns.internal.presentation.screen.preview.selfie.c.f36237b, "player prepared: " + mediaPlayer, (Throwable) null, 4, (Object) null);
        mediaPlayer.setLooping(true);
    }

    public static final void a(MediaPlayer mediaPlayer) {
        com.sumsub.sns.internal.presentation.screen.preview.selfie.c.a(com.sumsub.sns.internal.presentation.screen.preview.selfie.c.f36237b, "playback completed: " + mediaPlayer, (Throwable) null, 4, (Object) null);
    }

    public static final boolean a(MediaPlayer mediaPlayer, int i11, int i12) {
        com.sumsub.sns.internal.presentation.screen.preview.selfie.c.a(com.sumsub.sns.internal.presentation.screen.preview.selfie.c.f36237b, "player error: " + mediaPlayer + ", what=" + i11 + ", extra=" + i12, (Throwable) null, 4, (Object) null);
        return true;
    }

    /* renamed from: a */
    public void handleState(a.d dVar, Bundle bundle) {
        com.sumsub.sns.internal.presentation.screen.preview.selfie.c.a(com.sumsub.sns.internal.presentation.screen.preview.selfie.c.f36237b, "handleState: " + dVar, (Throwable) null, 4, (Object) null);
        TextView p11 = p();
        if (p11 != null) {
            com.sumsub.sns.internal.core.common.i.a(p11, dVar.k());
        }
        TextView o11 = o();
        if (o11 != null) {
            com.sumsub.sns.internal.core.common.i.a(o11, dVar.j());
        }
        Button k11 = k();
        if (k11 != null) {
            com.sumsub.sns.internal.core.common.i.a((TextView) k11, dVar.h());
        }
        Button l11 = l();
        if (l11 != null) {
            com.sumsub.sns.internal.core.common.i.a((TextView) l11, dVar.g());
        }
        Group m11 = m();
        if (m11 != null) {
            m11.setVisibility(dVar.i() ? 0 : 8);
        }
        updatePoweredByVisibility(getViewModel().o());
        if (!dVar.i() || dVar.l() == null) {
            s();
        }
        c(dVar.l());
    }
}
