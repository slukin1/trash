package com.sumsub.sns.presentation.screen.preview.photo.mrtd;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.nfc.tech.IsoDep;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.view.y;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.facebook.places.model.PlaceFields;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.data.listener.SNSInstructionsViewHandler;
import com.sumsub.sns.core.theme.SNSMetricElement;
import com.sumsub.sns.core.widget.SNSDotsProgressView;
import com.sumsub.sns.core.widget.SNSStepViewExtensionsKt;
import com.sumsub.sns.internal.core.analytics.Control;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.k0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.common.z;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.q;
import com.sumsub.sns.internal.core.presentation.intro.IntroScene;
import com.sumsub.sns.internal.core.widget.SNSStepState;
import com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.reflect.l;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 42\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0007B\u0007¢\u0006\u0004\bT\u0010UJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\fH\u0014J\u001a\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0018\u001a\u00020\u0006H\u0016R\u001b\u0010\u001c\u001a\u00020\u00038TX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\u0004\u0018\u00010\u001d8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010%\u001a\u0004\u0018\u00010\u001d8BX\u0002¢\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010!R\u001d\u0010(\u001a\u0004\u0018\u00010\u001d8BX\u0002¢\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!R\u001d\u0010-\u001a\u0004\u0018\u00010)8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u001f\u001a\u0004\b+\u0010,R\u001d\u00102\u001a\u0004\u0018\u00010.8BX\u0002¢\u0006\f\n\u0004\b/\u0010\u001f\u001a\u0004\b0\u00101R\u001d\u00105\u001a\u0004\u0018\u00010.8BX\u0002¢\u0006\f\n\u0004\b3\u0010\u001f\u001a\u0004\b4\u00101R\u001d\u00108\u001a\u0004\u0018\u00010.8BX\u0002¢\u0006\f\n\u0004\b6\u0010\u001f\u001a\u0004\b7\u00101R\u001d\u0010;\u001a\u0004\u0018\u00010.8BX\u0002¢\u0006\f\n\u0004\b9\u0010\u001f\u001a\u0004\b:\u00101R\u001d\u0010@\u001a\u0004\u0018\u00010<8BX\u0002¢\u0006\f\n\u0004\b=\u0010\u001f\u001a\u0004\b>\u0010?R\u001d\u0010E\u001a\u0004\u0018\u00010A8BX\u0002¢\u0006\f\n\u0004\bB\u0010\u001f\u001a\u0004\bC\u0010DR\u001d\u0010G\u001a\u0004\u0018\u00010A8BX\u0002¢\u0006\f\n\u0004\b:\u0010\u001f\u001a\u0004\bF\u0010DR\u001d\u0010J\u001a\u0004\u0018\u00010H8BX\u0002¢\u0006\f\n\u0004\b>\u0010\u001f\u001a\u0004\bB\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010LR\u0018\u0010O\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010NR\u0014\u0010S\u001a\u00020P8TX\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010R¨\u0006V"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/photo/mrtd/a;", "Lcom/sumsub/sns/core/presentation/b;", "Lcom/sumsub/sns/internal/presentation/screen/preview/photo/mrtd/b$a$a;", "Lcom/sumsub/sns/internal/presentation/screen/preview/photo/mrtd/b;", "Lcom/sumsub/sns/internal/presentation/screen/preview/photo/mrtd/b$a$a$d;", "state", "", "a", "Lcom/sumsub/sns/internal/presentation/screen/preview/photo/mrtd/b$a$a$e;", "Lcom/sumsub/sns/internal/presentation/screen/preview/photo/mrtd/b$a$a$a;", "Lcom/sumsub/sns/internal/presentation/screen/preview/photo/mrtd/b$a$a$b;", "w", "", "getLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "onStop", "Lcom/sumsub/sns/internal/core/common/q;", "finishReason", "", "onFinishCalled", "onDestroy", "Lkotlin/i;", "v", "()Lcom/sumsub/sns/internal/presentation/screen/preview/photo/mrtd/b;", "viewModel", "Landroid/widget/TextView;", "b", "Lcom/sumsub/sns/internal/core/common/z;", "getTitle", "()Landroid/widget/TextView;", "title", "c", "u", "subtitle", "d", "n", "hint", "Landroidx/constraintlayout/widget/Group;", "e", "o", "()Landroidx/constraintlayout/widget/Group;", "instructions", "Landroid/widget/ImageView;", "f", "t", "()Landroid/widget/ImageView;", "status", "g", "p", "nfcIcon", "h", "q", "phone", "i", "l", "document", "Lcom/sumsub/sns/core/widget/SNSDotsProgressView;", "j", "m", "()Lcom/sumsub/sns/core/widget/SNSDotsProgressView;", "dotProgress", "Landroid/widget/Button;", "k", "r", "()Landroid/widget/Button;", "primaryButton", "s", "secondaryButton", "Landroid/widget/FrameLayout;", "()Landroid/widget/FrameLayout;", "customViewContainer", "Landroid/animation/Animator;", "Landroid/animation/Animator;", "instructionAnimation", "Lcom/sumsub/sns/internal/presentation/screen/preview/photo/mrtd/b$a$a;", "lastState", "", "getIdDocSetType", "()Ljava/lang/String;", "idDocSetType", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class a extends com.sumsub.sns.core.presentation.b<b.a.C0478a, com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b> {

    /* renamed from: p  reason: collision with root package name */
    public static final C0538a f40025p = new C0538a((r) null);

    /* renamed from: q  reason: collision with root package name */
    public static final /* synthetic */ l<Object>[] f40026q = {Reflection.j(new PropertyReference1Impl(a.class, "title", "getTitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, MessengerShareContentUtility.SUBTITLE, "getSubtitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "hint", "getHint()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.N, "getInstructions()Landroidx/constraintlayout/widget/Group;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "status", "getStatus()Landroid/widget/ImageView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "nfcIcon", "getNfcIcon()Landroid/widget/ImageView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, PlaceFields.PHONE, "getPhone()Landroid/widget/ImageView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "document", "getDocument()Landroid/widget/ImageView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "dotProgress", "getDotProgress()Lcom/sumsub/sns/core/widget/SNSDotsProgressView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "primaryButton", "getPrimaryButton()Landroid/widget/Button;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "secondaryButton", "getSecondaryButton()Landroid/widget/Button;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "customViewContainer", "getCustomViewContainer()Landroid/widget/FrameLayout;", 0))};

    /* renamed from: r  reason: collision with root package name */
    public static final long f40027r = 2000;

    /* renamed from: s  reason: collision with root package name */
    public static final String f40028s = "SNSMRTDReadFragment";

    /* renamed from: a  reason: collision with root package name */
    public final kotlin.i f40029a;

    /* renamed from: b  reason: collision with root package name */
    public final z f40030b = a0.a(this, R.id.sns_title);

    /* renamed from: c  reason: collision with root package name */
    public final z f40031c = a0.a(this, R.id.sns_subtitle);

    /* renamed from: d  reason: collision with root package name */
    public final z f40032d = a0.a(this, R.id.sns_hint);

    /* renamed from: e  reason: collision with root package name */
    public final z f40033e = a0.a(this, R.id.sns_instructions);

    /* renamed from: f  reason: collision with root package name */
    public final z f40034f = a0.a(this, R.id.sns_status);

    /* renamed from: g  reason: collision with root package name */
    public final z f40035g = a0.a(this, R.id.sns_nfc_icon);

    /* renamed from: h  reason: collision with root package name */
    public final z f40036h = a0.a(this, R.id.sns_phone);

    /* renamed from: i  reason: collision with root package name */
    public final z f40037i = a0.a(this, R.id.sns_document);

    /* renamed from: j  reason: collision with root package name */
    public final z f40038j = a0.a(this, R.id.sns_reading_progress);

    /* renamed from: k  reason: collision with root package name */
    public final z f40039k = a0.a(this, R.id.sns_primary_button);

    /* renamed from: l  reason: collision with root package name */
    public final z f40040l = a0.a(this, R.id.sns_secondary_button);

    /* renamed from: m  reason: collision with root package name */
    public final z f40041m = a0.a(this, R.id.sns_custom_view);

    /* renamed from: n  reason: collision with root package name */
    public Animator f40042n;

    /* renamed from: o  reason: collision with root package name */
    public b.a.C0478a f40043o;

    /* renamed from: com.sumsub.sns.presentation.screen.preview.photo.mrtd.a$a  reason: collision with other inner class name */
    public static final class C0538a {
        public /* synthetic */ C0538a(r rVar) {
            this();
        }

        public final Fragment a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putString(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.a.f36140f, str5);
            bundle.putString(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.a.f36138d, str2);
            bundle.putString(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.a.f36141g, str6);
            bundle.putString(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.a.f36136b, str);
            bundle.putString(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.a.f36137c, str3);
            bundle.putString(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.a.f36139e, str4);
            bundle.putString(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.a.f36142h, str7);
            aVar.setArguments(bundle);
            return aVar;
        }

        public C0538a() {
        }
    }

    public static final class b extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f40044a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.f40044a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f40044a;
        }
    }

    public static final class c extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f40045a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(d10.a aVar) {
            super(0);
            this.f40045a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f40045a.invoke();
        }
    }

    public static final class d extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f40046a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(kotlin.i iVar) {
            super(0);
            this.f40046a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f40046a).getViewModelStore();
        }
    }

    public static final class e extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f40047a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f40048b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d10.a aVar, kotlin.i iVar) {
            super(0);
            this.f40047a = aVar;
            this.f40048b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f40047a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f40048b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class f extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f40049a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f40050b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment, kotlin.i iVar) {
            super(0);
            this.f40049a = fragment;
            this.f40050b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f40050b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f40049a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f40051a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f40052b;

        public g(View view, a aVar) {
            this.f40051a = view;
            this.f40052b = aVar;
        }

        public final void run() {
            this.f40052b.w();
        }
    }

    public static final class h extends Lambda implements d10.l<IsoDep, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f40053a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f40054b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f40055c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(a aVar, String str, String str2) {
            super(1);
            this.f40053a = aVar;
            this.f40054b = str;
            this.f40055c = str2;
        }

        public final void a(IsoDep isoDep) {
            String string;
            Bundle arguments;
            String string2;
            String string3;
            Bundle arguments2 = this.f40053a.getArguments();
            if (arguments2 != null && (string = arguments2.getString(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.a.f36136b)) != null && (arguments = this.f40053a.getArguments()) != null && (string2 = arguments.getString(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.a.f36140f)) != null) {
                Bundle arguments3 = this.f40053a.getArguments();
                String string4 = arguments3 != null ? arguments3.getString(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.a.f36141g) : null;
                Bundle arguments4 = this.f40053a.getArguments();
                if (arguments4 != null && (string3 = arguments4.getString(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.a.f36142h)) != null) {
                    this.f40053a.getViewModel().a(string, this.f40054b, this.f40055c, isoDep, string2, string4, string3);
                }
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((IsoDep) obj);
            return Unit.f56620a;
        }
    }

    public static final class i extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f40056a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(a aVar) {
            super(0);
            this.f40056a = aVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            a aVar = this.f40056a;
            return new com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.c(aVar, aVar.getServiceLocator(), this.f40056a.getArguments());
        }
    }

    public a() {
        i iVar = new i(this);
        kotlin.i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new c(new b(this)));
        this.f40029a = FragmentViewModelLazyKt.c(this, Reflection.b(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b.class), new d(b11), new e((d10.a) null, b11), iVar);
    }

    @SensorsDataInstrumented
    public static final void c(a aVar, View view) {
        k0 appListener = aVar.getAppListener();
        if (appListener != null) {
            appListener.c();
        }
        com.sumsub.sns.core.presentation.b.finish$default(aVar, new q.b(false, 1, (r) null), (Object) null, (Long) null, 6, (Object) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void d(a aVar, View view) {
        com.sumsub.sns.internal.core.analytics.c.b(aVar.getAnalyticsDelegate(), aVar.getScreen(), aVar.getIdDocSetType(), Control.SkipButton, (Map) null, 8, (Object) null);
        k0 appListener = aVar.getAppListener();
        if (appListener != null) {
            appListener.c();
        }
        com.sumsub.sns.core.presentation.b.finish$default(aVar, new q.b(false, 1, (r) null), (Object) null, (Long) null, 6, (Object) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public String getIdDocSetType() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.a.f36138d) : null;
        return string == null ? DocumentType.f32355j : string;
    }

    public int getLayoutId() {
        return R.layout.sns_fragment_mrtd_read;
    }

    public final TextView getTitle() {
        return (TextView) this.f40030b.a(this, f40026q[0]);
    }

    public final FrameLayout k() {
        return (FrameLayout) this.f40041m.a(this, f40026q[11]);
    }

    public final ImageView l() {
        return (ImageView) this.f40037i.a(this, f40026q[7]);
    }

    public final SNSDotsProgressView m() {
        return (SNSDotsProgressView) this.f40038j.a(this, f40026q[8]);
    }

    public final TextView n() {
        return (TextView) this.f40032d.a(this, f40026q[2]);
    }

    public final Group o() {
        return (Group) this.f40033e.a(this, f40026q[3]);
    }

    public void onDestroy() {
        super.onDestroy();
        Animator animator = this.f40042n;
        if (animator != null) {
            animator.cancel();
        }
        this.f40042n = null;
    }

    public boolean onFinishCalled(q qVar) {
        if (!x.b(qVar, q.c.f32251b)) {
            return super.onFinishCalled(qVar);
        }
        k0 appListener = getAppListener();
        if (appListener != null) {
            appListener.c();
        }
        com.sumsub.sns.core.presentation.b.finish$default(this, new q.b(false, 1, (r) null), (Object) null, (Long) null, 6, (Object) null);
        return false;
    }

    public void onStop() {
        k0 appListener = getAppListener();
        if (appListener != null) {
            appListener.c();
        }
        this.f40043o = null;
        super.onStop();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Float a11;
        super.onViewCreated(view, bundle);
        com.sumsub.sns.internal.core.analytics.c.d(getAnalyticsDelegate(), getScreen(), getIdDocSetType(), (Map) null, 4, (Object) null);
        com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
        com.sumsub.sns.internal.core.theme.d a12 = aVar.a();
        if (a12 != null && (a11 = aVar.a(a12, SNSMetricElement.SCREEN_HORIZONTAL_MARGIN)) != null) {
            int floatValue = (int) a11.floatValue();
            com.sumsub.sns.internal.core.common.i.a(Integer.valueOf(floatValue), Integer.valueOf(floatValue), (Integer) null, (Integer) null, getTitle(), u(), r(), s());
        }
    }

    public final ImageView p() {
        return (ImageView) this.f40035g.a(this, f40026q[5]);
    }

    public final ImageView q() {
        return (ImageView) this.f40036h.a(this, f40026q[6]);
    }

    public final Button r() {
        return (Button) this.f40039k.a(this, f40026q[9]);
    }

    public final Button s() {
        return (Button) this.f40040l.a(this, f40026q[10]);
    }

    public final ImageView t() {
        return (ImageView) this.f40034f.a(this, f40026q[4]);
    }

    public final TextView u() {
        return (TextView) this.f40031c.a(this, f40026q[1]);
    }

    /* renamed from: v */
    public com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b getViewModel() {
        return (com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b) this.f40029a.getValue();
    }

    public final void w() {
        ImageView q11 = q();
        float[] fArr = new float[2];
        int i11 = 0;
        fArr[0] = 0.0f;
        ImageView q12 = q();
        fArr[1] = ((float) (q12 != null ? q12.getWidth() : 0)) / 3.0f;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(q11, "translationX", fArr);
        ofFloat.setDuration(2000);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ofFloat.addUpdateListener(new b(this));
        ImageView q13 = q();
        float[] fArr2 = new float[2];
        fArr2[0] = 0.0f;
        ImageView q14 = q();
        if (q14 != null) {
            i11 = q14.getHeight();
        }
        fArr2[1] = ((float) i11) / 7.0f;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(q13, "translationY", fArr2);
        ofFloat2.setDuration(2000);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(q(), "rotation", new float[]{0.0f, 27.0f});
        ofFloat3.setDuration(2000);
        ofFloat3.setRepeatCount(-1);
        ofFloat3.setRepeatMode(2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.start();
        this.f40042n = animatorSet;
    }

    @SensorsDataInstrumented
    public static final void b(a aVar, View view) {
        k0 appListener = aVar.getAppListener();
        if (appListener != null) {
            appListener.c();
            aVar.getAnalyticsDelegate().d();
        }
        com.sumsub.sns.core.presentation.b.finish$default(aVar, new q.b(false, 1, (r) null), (Object) null, (Long) null, 6, (Object) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: a */
    public void handleState(b.a.C0478a aVar, Bundle bundle) {
        com.sumsub.sns.internal.log.a aVar2 = com.sumsub.sns.internal.log.a.f34862a;
        com.sumsub.log.logger.a.a(aVar2, f40028s, "MRTD screen: state=" + aVar, (Throwable) null, 4, (Object) null);
        if (x.b(this.f40043o, aVar)) {
            com.sumsub.log.logger.a.a(aVar2, f40028s, "MRTD screen: drop duplicate state=" + aVar, (Throwable) null, 4, (Object) null);
            return;
        }
        Animator animator = this.f40042n;
        if (animator != null) {
            animator.cancel();
        }
        if (!(aVar instanceof b.a.C0478a.c)) {
            if (aVar instanceof b.a.C0478a.d) {
                a((b.a.C0478a.d) aVar);
            } else if (aVar instanceof b.a.C0478a.e) {
                a((b.a.C0478a.e) aVar);
            } else if (aVar instanceof b.a.C0478a.C0479a) {
                a((b.a.C0478a.C0479a) aVar);
            } else if (aVar instanceof b.a.C0478a.C0480b) {
                a((b.a.C0478a.C0480b) aVar);
            }
        }
        this.f40043o = aVar;
    }

    public static final void c(a aVar) {
        com.sumsub.sns.core.presentation.b.finish$default(aVar, new q.b(false, 1, (r) null), (Object) null, (Long) null, 6, (Object) null);
    }

    public final void a(b.a.C0478a.d dVar) {
        String str;
        String str2;
        String string;
        TextView title = getTitle();
        if (title != null) {
            title.setVisibility(0);
        }
        TextView title2 = getTitle();
        if (title2 != null) {
            title2.setText(dVar.j());
        }
        TextView u11 = u();
        if (u11 != null) {
            u11.setVisibility(0);
        }
        TextView u12 = u();
        if (u12 != null) {
            u12.setText(dVar.i());
        }
        TextView n11 = n();
        if (n11 != null) {
            n11.setVisibility(0);
        }
        TextView n12 = n();
        if (n12 != null) {
            n12.setText(dVar.f());
        }
        Button r11 = r();
        if (r11 != null) {
            r11.setVisibility(4);
        }
        Button s11 = s();
        if (s11 != null) {
            s11.setVisibility(com.sumsub.sns.internal.ff.a.f34215a.t().g() ? 8 : 0);
        }
        Button s12 = s();
        if (s12 != null) {
            s12.setText(dVar.h());
        }
        Button s13 = s();
        if (s13 != null) {
            s13.setOnClickListener(new f(this));
        }
        Bundle arguments = getArguments();
        String str3 = "";
        if (arguments == null || (str = arguments.getString(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.a.f36137c)) == null) {
            str = str3;
        }
        Bundle arguments2 = getArguments();
        if (!(arguments2 == null || (string = arguments2.getString(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.a.f36139e)) == null)) {
            str3 = string;
        }
        e0 e0Var = e0.f32018a;
        SNSInstructionsViewHandler instructionsViewHandler = e0Var.getInstructionsViewHandler();
        String str4 = null;
        View onVerificationStep = instructionsViewHandler != null ? instructionsViewHandler.onVerificationStep(requireContext(), DocumentType.f32347b, str, IntroScene.MRTD_PREPARING.getSceneName(), SNSInstructionsViewHandler.Position.FULLSCREEN.getValue(), str3) : null;
        if (onVerificationStep != null) {
            FrameLayout k11 = k();
            if (k11 != null) {
                k11.removeAllViews();
            }
            FrameLayout k12 = k();
            if (k12 != null) {
                k12.addView(onVerificationStep, new FrameLayout.LayoutParams(-1, -1));
            }
            FrameLayout k13 = k();
            if (k13 != null) {
                k13.setVisibility(0);
            }
            Group o11 = o();
            if (o11 != null) {
                o11.setVisibility(4);
            }
        } else {
            Bundle arguments3 = getArguments();
            if (arguments3 != null) {
                str4 = arguments3.getString(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.a.f36137c);
            }
            if (x.b(str4, q.c.f32689f.b())) {
                str2 = SNSIconHandler.SNSCommonIcons.MRTD_IDCARD.getImageName();
            } else if (x.b(str4, q.f.f32692f.b())) {
                str2 = SNSIconHandler.SNSCommonIcons.MRTD_IDCARD.getImageName();
            } else {
                str2 = SNSIconHandler.SNSCommonIcons.MRTD_PASSPORT.getImageName();
            }
            FrameLayout k14 = k();
            if (k14 != null) {
                k14.setVisibility(4);
            }
            ImageView l11 = l();
            if (l11 != null) {
                l11.setImageDrawable(e0Var.getIconHandler().onResolveIcon(requireContext(), str2));
            }
            ImageView q11 = q();
            if (q11 != null) {
                q11.setImageDrawable(e0Var.getIconHandler().onResolveIcon(requireContext(), SNSIconHandler.SNSCommonIcons.MRTD_PHONE.getImageName()));
            }
            Group o12 = o();
            if (o12 != null) {
                o12.setVisibility(0);
            }
            ImageView q12 = q();
            if (q12 != null) {
                y.a(q12, new g(q12, this));
            }
        }
        ImageView t11 = t();
        if (t11 != null) {
            t11.setVisibility(4);
        }
        ImageView p11 = p();
        if (p11 != null) {
            p11.setVisibility(4);
        }
        SNSDotsProgressView m11 = m();
        if (m11 != null) {
            m11.setVisibility(4);
        }
        k0 appListener = getAppListener();
        if (appListener != null) {
            appListener.a((d10.l<? super IsoDep, Unit>) new h(this, str3, str));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0096, code lost:
        r0 = r0.getString(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.a.f36137c);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b.a.C0478a.e r12) {
        /*
            r11 = this;
            android.widget.TextView r0 = r11.getTitle()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            goto L_0x000b
        L_0x0008:
            r0.setVisibility(r1)
        L_0x000b:
            android.widget.TextView r0 = r11.getTitle()
            if (r0 != 0) goto L_0x0012
            goto L_0x0019
        L_0x0012:
            java.lang.CharSequence r2 = r12.l()
            r0.setText(r2)
        L_0x0019:
            android.widget.TextView r0 = r11.u()
            if (r0 != 0) goto L_0x0020
            goto L_0x0023
        L_0x0020:
            r0.setVisibility(r1)
        L_0x0023:
            android.widget.TextView r0 = r11.u()
            if (r0 != 0) goto L_0x002a
            goto L_0x0031
        L_0x002a:
            java.lang.CharSequence r2 = r12.k()
            r0.setText(r2)
        L_0x0031:
            android.widget.TextView r0 = r11.n()
            if (r0 != 0) goto L_0x0038
            goto L_0x003b
        L_0x0038:
            r0.setVisibility(r1)
        L_0x003b:
            android.widget.TextView r0 = r11.n()
            if (r0 != 0) goto L_0x0042
            goto L_0x0049
        L_0x0042:
            java.lang.CharSequence r2 = r12.g()
            r0.setText(r2)
        L_0x0049:
            android.widget.Button r0 = r11.r()
            r2 = 4
            if (r0 != 0) goto L_0x0051
            goto L_0x0054
        L_0x0051:
            r0.setVisibility(r2)
        L_0x0054:
            android.widget.Button r0 = r11.s()
            if (r0 != 0) goto L_0x005b
            goto L_0x005e
        L_0x005b:
            r0.setVisibility(r1)
        L_0x005e:
            android.widget.Button r0 = r11.s()
            if (r0 != 0) goto L_0x0065
            goto L_0x006c
        L_0x0065:
            java.lang.CharSequence r3 = r12.j()
            r0.setText(r3)
        L_0x006c:
            android.widget.Button r0 = r11.s()
            if (r0 == 0) goto L_0x007a
            com.sumsub.sns.presentation.screen.preview.photo.mrtd.e r3 = new com.sumsub.sns.presentation.screen.preview.photo.mrtd.e
            r3.<init>(r11)
            r0.setOnClickListener(r3)
        L_0x007a:
            androidx.constraintlayout.widget.Group r0 = r11.o()
            if (r0 != 0) goto L_0x0081
            goto L_0x0084
        L_0x0081:
            r0.setVisibility(r2)
        L_0x0084:
            android.widget.ImageView r0 = r11.t()
            if (r0 != 0) goto L_0x008b
            goto L_0x008e
        L_0x008b:
            r0.setVisibility(r2)
        L_0x008e:
            android.os.Bundle r0 = r11.getArguments()
            java.lang.String r3 = ""
            if (r0 == 0) goto L_0x00a1
            java.lang.String r4 = "ARGS_IDDOCTYPE"
            java.lang.String r0 = r0.getString(r4)
            if (r0 != 0) goto L_0x009f
            goto L_0x00a1
        L_0x009f:
            r7 = r0
            goto L_0x00a2
        L_0x00a1:
            r7 = r3
        L_0x00a2:
            android.os.Bundle r0 = r11.getArguments()
            if (r0 == 0) goto L_0x00b3
            java.lang.String r4 = "ARGS_COUNTRY"
            java.lang.String r0 = r0.getString(r4)
            if (r0 != 0) goto L_0x00b1
            goto L_0x00b3
        L_0x00b1:
            r10 = r0
            goto L_0x00b4
        L_0x00b3:
            r10 = r3
        L_0x00b4:
            com.sumsub.sns.internal.core.common.e0 r0 = com.sumsub.sns.internal.core.common.e0.f32018a
            com.sumsub.sns.core.data.listener.SNSInstructionsViewHandler r4 = r0.getInstructionsViewHandler()
            if (r4 == 0) goto L_0x00d3
            android.content.Context r5 = r11.requireContext()
            com.sumsub.sns.internal.core.presentation.intro.IntroScene r3 = com.sumsub.sns.internal.core.presentation.intro.IntroScene.MRTD_SCANNING
            java.lang.String r8 = r3.getSceneName()
            com.sumsub.sns.core.data.listener.SNSInstructionsViewHandler$Position r3 = com.sumsub.sns.core.data.listener.SNSInstructionsViewHandler.Position.FULLSCREEN
            java.lang.String r9 = r3.getValue()
            java.lang.String r6 = "IDENTITY"
            android.view.View r3 = r4.onVerificationStep(r5, r6, r7, r8, r9, r10)
            goto L_0x00d4
        L_0x00d3:
            r3 = 0
        L_0x00d4:
            if (r3 == 0) goto L_0x010d
            android.widget.FrameLayout r12 = r11.k()
            if (r12 == 0) goto L_0x00df
            r12.removeAllViews()
        L_0x00df:
            android.widget.FrameLayout r12 = r11.k()
            if (r12 == 0) goto L_0x00ee
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r4 = -1
            r0.<init>(r4, r4)
            r12.addView(r3, r0)
        L_0x00ee:
            android.widget.FrameLayout r12 = r11.k()
            if (r12 != 0) goto L_0x00f5
            goto L_0x00f8
        L_0x00f5:
            r12.setVisibility(r1)
        L_0x00f8:
            android.widget.ImageView r12 = r11.p()
            if (r12 != 0) goto L_0x00ff
            goto L_0x0102
        L_0x00ff:
            r12.setVisibility(r2)
        L_0x0102:
            com.sumsub.sns.core.widget.SNSDotsProgressView r12 = r11.m()
            if (r12 != 0) goto L_0x0109
            goto L_0x014a
        L_0x0109:
            r12.setVisibility(r2)
            goto L_0x014a
        L_0x010d:
            android.widget.ImageView r2 = r11.p()
            if (r2 != 0) goto L_0x0114
            goto L_0x0117
        L_0x0114:
            r2.setVisibility(r1)
        L_0x0117:
            android.widget.ImageView r2 = r11.p()
            if (r2 == 0) goto L_0x0132
            com.sumsub.sns.core.data.listener.SNSIconHandler r0 = r0.getIconHandler()
            android.content.Context r3 = r11.requireContext()
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSCommonIcons r4 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSCommonIcons.NFC
            java.lang.String r4 = r4.getImageName()
            android.graphics.drawable.Drawable r0 = r0.onResolveIcon(r3, r4)
            r2.setImageDrawable(r0)
        L_0x0132:
            com.sumsub.sns.core.widget.SNSDotsProgressView r0 = r11.m()
            if (r0 != 0) goto L_0x0139
            goto L_0x013c
        L_0x0139:
            r0.setVisibility(r1)
        L_0x013c:
            com.sumsub.sns.core.widget.SNSDotsProgressView r0 = r11.m()
            if (r0 != 0) goto L_0x0143
            goto L_0x014a
        L_0x0143:
            int r12 = r12.i()
            r0.setProgress(r12)
        L_0x014a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.preview.photo.mrtd.a.a(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b$a$a$e):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0071, code lost:
        r11 = r11.getString(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.a.f36137c);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b.a.C0478a.C0479a r11) {
        /*
            r10 = this;
            com.sumsub.sns.internal.core.common.k0 r0 = r10.getAppListener()
            if (r0 == 0) goto L_0x0009
            r0.c()
        L_0x0009:
            android.widget.TextView r0 = r10.getTitle()
            r1 = 4
            if (r0 != 0) goto L_0x0011
            goto L_0x0014
        L_0x0011:
            r0.setVisibility(r1)
        L_0x0014:
            android.widget.TextView r0 = r10.u()
            if (r0 != 0) goto L_0x001b
            goto L_0x001e
        L_0x001b:
            r0.setVisibility(r1)
        L_0x001e:
            android.widget.TextView r0 = r10.n()
            r2 = 0
            if (r0 != 0) goto L_0x0026
            goto L_0x0029
        L_0x0026:
            r0.setVisibility(r2)
        L_0x0029:
            android.widget.TextView r0 = r10.n()
            if (r0 != 0) goto L_0x0030
            goto L_0x0037
        L_0x0030:
            java.lang.CharSequence r11 = r11.b()
            r0.setText(r11)
        L_0x0037:
            android.widget.Button r11 = r10.r()
            if (r11 != 0) goto L_0x003e
            goto L_0x0041
        L_0x003e:
            r11.setVisibility(r1)
        L_0x0041:
            android.widget.Button r11 = r10.s()
            if (r11 != 0) goto L_0x0048
            goto L_0x004b
        L_0x0048:
            r11.setVisibility(r1)
        L_0x004b:
            androidx.constraintlayout.widget.Group r11 = r10.o()
            if (r11 != 0) goto L_0x0052
            goto L_0x0055
        L_0x0052:
            r11.setVisibility(r1)
        L_0x0055:
            android.widget.ImageView r11 = r10.p()
            if (r11 != 0) goto L_0x005c
            goto L_0x005f
        L_0x005c:
            r11.setVisibility(r1)
        L_0x005f:
            com.sumsub.sns.core.widget.SNSDotsProgressView r11 = r10.m()
            if (r11 != 0) goto L_0x0066
            goto L_0x0069
        L_0x0066:
            r11.setVisibility(r1)
        L_0x0069:
            android.os.Bundle r11 = r10.getArguments()
            java.lang.String r0 = ""
            if (r11 == 0) goto L_0x007c
            java.lang.String r3 = "ARGS_IDDOCTYPE"
            java.lang.String r11 = r11.getString(r3)
            if (r11 != 0) goto L_0x007a
            goto L_0x007c
        L_0x007a:
            r6 = r11
            goto L_0x007d
        L_0x007c:
            r6 = r0
        L_0x007d:
            android.os.Bundle r11 = r10.getArguments()
            if (r11 == 0) goto L_0x008e
            java.lang.String r3 = "ARGS_COUNTRY"
            java.lang.String r11 = r11.getString(r3)
            if (r11 != 0) goto L_0x008c
            goto L_0x008e
        L_0x008c:
            r9 = r11
            goto L_0x008f
        L_0x008e:
            r9 = r0
        L_0x008f:
            com.sumsub.sns.internal.core.common.e0 r11 = com.sumsub.sns.internal.core.common.e0.f32018a
            com.sumsub.sns.core.data.listener.SNSInstructionsViewHandler r3 = r11.getInstructionsViewHandler()
            if (r3 == 0) goto L_0x00ae
            android.content.Context r4 = r10.requireContext()
            com.sumsub.sns.internal.core.presentation.intro.IntroScene r0 = com.sumsub.sns.internal.core.presentation.intro.IntroScene.MRTD_SCANNED
            java.lang.String r7 = r0.getSceneName()
            com.sumsub.sns.core.data.listener.SNSInstructionsViewHandler$Position r0 = com.sumsub.sns.core.data.listener.SNSInstructionsViewHandler.Position.FULLSCREEN
            java.lang.String r8 = r0.getValue()
            java.lang.String r5 = "IDENTITY"
            android.view.View r0 = r3.onVerificationStep(r4, r5, r6, r7, r8, r9)
            goto L_0x00af
        L_0x00ae:
            r0 = 0
        L_0x00af:
            if (r0 == 0) goto L_0x00de
            android.widget.FrameLayout r11 = r10.k()
            if (r11 == 0) goto L_0x00ba
            r11.removeAllViews()
        L_0x00ba:
            android.widget.FrameLayout r11 = r10.k()
            if (r11 == 0) goto L_0x00c9
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams
            r4 = -1
            r3.<init>(r4, r4)
            r11.addView(r0, r3)
        L_0x00c9:
            android.widget.FrameLayout r11 = r10.k()
            if (r11 != 0) goto L_0x00d0
            goto L_0x00d3
        L_0x00d0:
            r11.setVisibility(r2)
        L_0x00d3:
            android.widget.ImageView r11 = r10.t()
            if (r11 != 0) goto L_0x00da
            goto L_0x010f
        L_0x00da:
            r11.setVisibility(r1)
            goto L_0x010f
        L_0x00de:
            android.widget.ImageView r0 = r10.t()
            if (r0 != 0) goto L_0x00e5
            goto L_0x00e8
        L_0x00e5:
            r0.setVisibility(r2)
        L_0x00e8:
            android.widget.ImageView r0 = r10.t()
            if (r0 != 0) goto L_0x00ef
            goto L_0x00f4
        L_0x00ef:
            com.sumsub.sns.internal.core.widget.SNSStepState r1 = com.sumsub.sns.internal.core.widget.SNSStepState.APPROVED
            com.sumsub.sns.core.widget.SNSStepViewExtensionsKt.setSnsStepState(r0, r1)
        L_0x00f4:
            android.widget.ImageView r0 = r10.t()
            if (r0 == 0) goto L_0x010f
            com.sumsub.sns.core.data.listener.SNSIconHandler r11 = r11.getIconHandler()
            android.content.Context r1 = r10.requireContext()
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSResultIcons r2 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSResultIcons.SUCCESS
            java.lang.String r2 = r2.getImageName()
            android.graphics.drawable.Drawable r11 = r11.onResolveIcon(r1, r2)
            r0.setImageDrawable(r11)
        L_0x010f:
            android.view.View r11 = r10.getView()
            if (r11 == 0) goto L_0x0125
            com.sumsub.sns.presentation.screen.preview.photo.mrtd.g r0 = new com.sumsub.sns.presentation.screen.preview.photo.mrtd.g
            r0.<init>(r10)
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS
            r2 = 2
            long r1 = r1.toMillis(r2)
            r11.postDelayed(r0, r1)
        L_0x0125:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.preview.photo.mrtd.a.a(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b$a$a$a):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00dc, code lost:
        r11 = r11.getString(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.a.f36137c);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b.a.C0478a.C0480b r11) {
        /*
            r10 = this;
            com.sumsub.sns.internal.core.common.k0 r0 = r10.getAppListener()
            if (r0 == 0) goto L_0x0009
            r0.c()
        L_0x0009:
            android.widget.TextView r0 = r10.getTitle()
            r1 = 4
            if (r0 != 0) goto L_0x0011
            goto L_0x0014
        L_0x0011:
            r0.setVisibility(r1)
        L_0x0014:
            android.widget.TextView r0 = r10.u()
            if (r0 != 0) goto L_0x001b
            goto L_0x001e
        L_0x001b:
            r0.setVisibility(r1)
        L_0x001e:
            android.widget.TextView r0 = r10.n()
            r2 = 0
            if (r0 != 0) goto L_0x0026
            goto L_0x0029
        L_0x0026:
            r0.setVisibility(r2)
        L_0x0029:
            android.widget.TextView r0 = r10.n()
            if (r0 != 0) goto L_0x0030
            goto L_0x0037
        L_0x0030:
            java.lang.CharSequence r3 = r11.d()
            r0.setText(r3)
        L_0x0037:
            android.widget.Button r0 = r10.r()
            if (r0 != 0) goto L_0x003e
            goto L_0x0041
        L_0x003e:
            r0.setVisibility(r2)
        L_0x0041:
            android.widget.Button r0 = r10.r()
            if (r0 != 0) goto L_0x0048
            goto L_0x004f
        L_0x0048:
            java.lang.CharSequence r3 = r11.e()
            r0.setText(r3)
        L_0x004f:
            android.widget.Button r0 = r10.r()
            if (r0 == 0) goto L_0x005d
            com.sumsub.sns.presentation.screen.preview.photo.mrtd.c r3 = new com.sumsub.sns.presentation.screen.preview.photo.mrtd.c
            r3.<init>(r10)
            r0.setOnClickListener(r3)
        L_0x005d:
            android.widget.Button r0 = r10.s()
            if (r0 != 0) goto L_0x0064
            goto L_0x0067
        L_0x0064:
            r0.setVisibility(r2)
        L_0x0067:
            android.widget.Button r0 = r10.s()
            if (r0 != 0) goto L_0x006e
            goto L_0x0075
        L_0x006e:
            java.lang.CharSequence r11 = r11.f()
            r0.setText(r11)
        L_0x0075:
            android.widget.Button r11 = r10.s()
            if (r11 == 0) goto L_0x0083
            com.sumsub.sns.presentation.screen.preview.photo.mrtd.d r0 = new com.sumsub.sns.presentation.screen.preview.photo.mrtd.d
            r0.<init>(r10)
            r11.setOnClickListener(r0)
        L_0x0083:
            androidx.constraintlayout.widget.Group r11 = r10.o()
            if (r11 != 0) goto L_0x008a
            goto L_0x008d
        L_0x008a:
            r11.setVisibility(r1)
        L_0x008d:
            android.widget.ImageView r11 = r10.p()
            if (r11 != 0) goto L_0x0094
            goto L_0x0097
        L_0x0094:
            r11.setVisibility(r1)
        L_0x0097:
            com.sumsub.sns.core.widget.SNSDotsProgressView r11 = r10.m()
            if (r11 != 0) goto L_0x009e
            goto L_0x00a1
        L_0x009e:
            r11.setVisibility(r1)
        L_0x00a1:
            android.widget.ImageView r11 = r10.t()
            if (r11 != 0) goto L_0x00a8
            goto L_0x00ab
        L_0x00a8:
            r11.setVisibility(r2)
        L_0x00ab:
            android.widget.ImageView r11 = r10.t()
            if (r11 != 0) goto L_0x00b2
            goto L_0x00b7
        L_0x00b2:
            com.sumsub.sns.internal.core.widget.SNSStepState r0 = com.sumsub.sns.internal.core.widget.SNSStepState.REJECTED
            com.sumsub.sns.core.widget.SNSStepViewExtensionsKt.setSnsStepState(r11, r0)
        L_0x00b7:
            android.widget.ImageView r11 = r10.t()
            if (r11 == 0) goto L_0x00d4
            com.sumsub.sns.internal.core.common.e0 r0 = com.sumsub.sns.internal.core.common.e0.f32018a
            com.sumsub.sns.core.data.listener.SNSIconHandler r0 = r0.getIconHandler()
            android.content.Context r3 = r10.requireContext()
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSResultIcons r4 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSResultIcons.FAILURE
            java.lang.String r4 = r4.getImageName()
            android.graphics.drawable.Drawable r0 = r0.onResolveIcon(r3, r4)
            r11.setImageDrawable(r0)
        L_0x00d4:
            android.os.Bundle r11 = r10.getArguments()
            java.lang.String r0 = ""
            if (r11 == 0) goto L_0x00e7
            java.lang.String r3 = "ARGS_IDDOCTYPE"
            java.lang.String r11 = r11.getString(r3)
            if (r11 != 0) goto L_0x00e5
            goto L_0x00e7
        L_0x00e5:
            r6 = r11
            goto L_0x00e8
        L_0x00e7:
            r6 = r0
        L_0x00e8:
            android.os.Bundle r11 = r10.getArguments()
            if (r11 == 0) goto L_0x00f9
            java.lang.String r3 = "ARGS_COUNTRY"
            java.lang.String r11 = r11.getString(r3)
            if (r11 != 0) goto L_0x00f7
            goto L_0x00f9
        L_0x00f7:
            r9 = r11
            goto L_0x00fa
        L_0x00f9:
            r9 = r0
        L_0x00fa:
            com.sumsub.sns.internal.core.common.e0 r11 = com.sumsub.sns.internal.core.common.e0.f32018a
            com.sumsub.sns.core.data.listener.SNSInstructionsViewHandler r3 = r11.getInstructionsViewHandler()
            if (r3 == 0) goto L_0x0119
            android.content.Context r4 = r10.requireContext()
            com.sumsub.sns.internal.core.presentation.intro.IntroScene r0 = com.sumsub.sns.internal.core.presentation.intro.IntroScene.MRTD_FAILED
            java.lang.String r7 = r0.getSceneName()
            com.sumsub.sns.core.data.listener.SNSInstructionsViewHandler$Position r0 = com.sumsub.sns.core.data.listener.SNSInstructionsViewHandler.Position.FULLSCREEN
            java.lang.String r8 = r0.getValue()
            java.lang.String r5 = "IDENTITY"
            android.view.View r0 = r3.onVerificationStep(r4, r5, r6, r7, r8, r9)
            goto L_0x011a
        L_0x0119:
            r0 = 0
        L_0x011a:
            r3 = -1
            if (r0 == 0) goto L_0x0149
            android.widget.FrameLayout r4 = r10.k()
            if (r4 == 0) goto L_0x0126
            r4.removeAllViews()
        L_0x0126:
            android.widget.FrameLayout r4 = r10.k()
            if (r4 == 0) goto L_0x0134
            android.widget.FrameLayout$LayoutParams r5 = new android.widget.FrameLayout$LayoutParams
            r5.<init>(r3, r3)
            r4.addView(r0, r5)
        L_0x0134:
            android.widget.FrameLayout r4 = r10.k()
            if (r4 != 0) goto L_0x013b
            goto L_0x013e
        L_0x013b:
            r4.setVisibility(r2)
        L_0x013e:
            android.widget.ImageView r4 = r10.t()
            if (r4 != 0) goto L_0x0145
            goto L_0x017a
        L_0x0145:
            r4.setVisibility(r1)
            goto L_0x017a
        L_0x0149:
            android.widget.ImageView r4 = r10.t()
            if (r4 != 0) goto L_0x0150
            goto L_0x0153
        L_0x0150:
            r4.setVisibility(r2)
        L_0x0153:
            android.widget.ImageView r4 = r10.t()
            if (r4 != 0) goto L_0x015a
            goto L_0x015f
        L_0x015a:
            com.sumsub.sns.internal.core.widget.SNSStepState r5 = com.sumsub.sns.internal.core.widget.SNSStepState.REJECTED
            com.sumsub.sns.core.widget.SNSStepViewExtensionsKt.setSnsStepState(r4, r5)
        L_0x015f:
            android.widget.ImageView r4 = r10.t()
            if (r4 == 0) goto L_0x017a
            com.sumsub.sns.core.data.listener.SNSIconHandler r5 = r11.getIconHandler()
            android.content.Context r6 = r10.requireContext()
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSResultIcons r7 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSResultIcons.FAILURE
            java.lang.String r7 = r7.getImageName()
            android.graphics.drawable.Drawable r5 = r5.onResolveIcon(r6, r7)
            r4.setImageDrawable(r5)
        L_0x017a:
            if (r0 == 0) goto L_0x01a8
            android.widget.FrameLayout r11 = r10.k()
            if (r11 == 0) goto L_0x0185
            r11.removeAllViews()
        L_0x0185:
            android.widget.FrameLayout r11 = r10.k()
            if (r11 == 0) goto L_0x0193
            android.widget.FrameLayout$LayoutParams r4 = new android.widget.FrameLayout$LayoutParams
            r4.<init>(r3, r3)
            r11.addView(r0, r4)
        L_0x0193:
            android.widget.FrameLayout r11 = r10.k()
            if (r11 != 0) goto L_0x019a
            goto L_0x019d
        L_0x019a:
            r11.setVisibility(r2)
        L_0x019d:
            android.widget.ImageView r11 = r10.t()
            if (r11 != 0) goto L_0x01a4
            goto L_0x01d9
        L_0x01a4:
            r11.setVisibility(r1)
            goto L_0x01d9
        L_0x01a8:
            android.widget.ImageView r0 = r10.t()
            if (r0 != 0) goto L_0x01af
            goto L_0x01b2
        L_0x01af:
            r0.setVisibility(r2)
        L_0x01b2:
            android.widget.ImageView r0 = r10.t()
            if (r0 != 0) goto L_0x01b9
            goto L_0x01be
        L_0x01b9:
            com.sumsub.sns.internal.core.widget.SNSStepState r1 = com.sumsub.sns.internal.core.widget.SNSStepState.REJECTED
            com.sumsub.sns.core.widget.SNSStepViewExtensionsKt.setSnsStepState(r0, r1)
        L_0x01be:
            android.widget.ImageView r0 = r10.t()
            if (r0 == 0) goto L_0x01d9
            com.sumsub.sns.core.data.listener.SNSIconHandler r11 = r11.getIconHandler()
            android.content.Context r1 = r10.requireContext()
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSResultIcons r2 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSResultIcons.FAILURE
            java.lang.String r2 = r2.getImageName()
            android.graphics.drawable.Drawable r11 = r11.onResolveIcon(r1, r2)
            r0.setImageDrawable(r11)
        L_0x01d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.preview.photo.mrtd.a.a(com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b$a$a$b):void");
    }

    @SensorsDataInstrumented
    public static final void a(a aVar, View view) {
        com.sumsub.sns.internal.core.analytics.c.b(aVar.getAnalyticsDelegate(), aVar.getScreen(), aVar.getIdDocSetType(), Control.RetryButton, (Map) null, 8, (Object) null);
        aVar.getViewModel().s();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void a(a aVar, ValueAnimator valueAnimator) {
        ImageView q11 = aVar.q();
        if (q11 != null) {
            SNSStepViewExtensionsKt.setSnsStepState(q11, ((double) valueAnimator.getAnimatedFraction()) < 0.2d ? SNSStepState.PROCESSING : SNSStepState.INIT);
        }
    }
}
