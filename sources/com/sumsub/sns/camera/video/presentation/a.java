package com.sumsub.sns.camera.video.presentation;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Size;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.appcompat.app.AlertDialog;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageProxy;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.widget.SNSAlertDialogBuilder;
import com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel;
import com.sumsub.sns.internal.core.analytics.Control;
import com.sumsub.sns.internal.core.analytics.PermissionPayload;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.j;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.common.z;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.domain.camera.CameraX;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.reflect.l;

@Metadata(bv = {}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\u0018\u0000 >2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\tB\u0007¢\u0006\u0004\bl\u0010mJ\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\t\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\u0007H\u0002J\u0012\u0010\r\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u0007H\u0002J\u001c\u0010\u0012\u001a\u00020\u000b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0002J\u001d\u0010\t\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013H\u0002¢\u0006\u0004\b\t\u0010\u0015J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0014J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u001a\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010 \u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010!\u001a\u00020\u000bH\u0016J\b\u0010\"\u001a\u00020\u000bH\u0016J\u001a\u0010\t\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$H\u0014J\b\u0010'\u001a\u00020\u000bH\u0016R\u001b\u0010+\u001a\u00020\u00038TX\u0002¢\u0006\f\n\u0004\b\t\u0010(\u001a\u0004\b)\u0010*R\u001a\u00100\u001a\u00020,8\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010-\u001a\u0004\b.\u0010/R\u001d\u00106\u001a\u0004\u0018\u0001018BX\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001d\u0010;\u001a\u0004\u0018\u0001078BX\u0002¢\u0006\f\n\u0004\b8\u00103\u001a\u0004\b9\u0010:R\u001d\u0010@\u001a\u0004\u0018\u00010<8BX\u0002¢\u0006\f\n\u0004\b=\u00103\u001a\u0004\b>\u0010?R\u001d\u0010D\u001a\u0004\u0018\u00010\u001b8BX\u0002¢\u0006\f\n\u0004\bA\u00103\u001a\u0004\bB\u0010CR\u001d\u0010G\u001a\u0004\u0018\u00010\u001b8BX\u0002¢\u0006\f\n\u0004\bE\u00103\u001a\u0004\bF\u0010CR\u001d\u0010J\u001a\u0004\u0018\u00010<8BX\u0002¢\u0006\f\n\u0004\bH\u00103\u001a\u0004\bI\u0010?R\u001d\u0010M\u001a\u0004\u0018\u00010<8BX\u0002¢\u0006\f\n\u0004\bK\u00103\u001a\u0004\bL\u0010?R\u001d\u0010P\u001a\u0004\u0018\u00010<8BX\u0002¢\u0006\f\n\u0004\bN\u00103\u001a\u0004\bO\u0010?R\u0018\u0010S\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010UR\u0014\u0010Y\u001a\u00020W8\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010XR$\u0010\\\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0013\u0018\u00010Z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010[R \u0010`\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020]0\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_R\u0014\u0010c\u001a\u00020\u000f8TX\u0004¢\u0006\u0006\u001a\u0004\ba\u0010bR \u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020]0\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\bd\u0010_R \u0010g\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020]0\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\bf\u0010_R \u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020]0\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\bh\u0010_R \u0010k\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020]0\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\bj\u0010_¨\u0006n"}, d2 = {"Lcom/sumsub/sns/camera/video/presentation/a;", "Lcom/sumsub/sns/core/presentation/b;", "Lcom/sumsub/sns/internal/camera/video/presentation/SNSVideoSelfieViewModel$d;", "Lcom/sumsub/sns/internal/camera/video/presentation/SNSVideoSelfieViewModel;", "Lcom/sumsub/sns/internal/core/domain/camera/a;", "Landroid/content/Context;", "context", "", "colorAttr", "a", "drawableRes", "", "color", "b", "", "", "", "grantResults", "handlePermissionResults", "", "permissions", "([Ljava/lang/String;)Z", "u", "t", "getLayoutId", "Ljava/io/File;", "file", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "onViewModelPrepared", "onStart", "onDestroyView", "state", "Lcom/sumsub/sns/core/presentation/base/a$j;", "event", "handleEvent", "onStop", "Lkotlin/i;", "s", "()Lcom/sumsub/sns/internal/camera/video/presentation/SNSVideoSelfieViewModel;", "viewModel", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "getScreen", "()Lcom/sumsub/sns/internal/core/analytics/Screen;", "screen", "Landroidx/camera/view/PreviewView;", "c", "Lcom/sumsub/sns/internal/core/common/z;", "m", "()Landroidx/camera/view/PreviewView;", "previewView", "Landroid/widget/ProgressBar;", "d", "k", "()Landroid/widget/ProgressBar;", "circleProgressView", "Landroid/widget/TextView;", "e", "o", "()Landroid/widget/TextView;", "tvCounter", "f", "n", "()Landroid/view/View;", "stopView", "g", "l", "doneView", "h", "r", "tvText", "i", "p", "tvDescription1", "j", "q", "tvDescription2", "Landroidx/appcompat/app/AlertDialog;", "Landroidx/appcompat/app/AlertDialog;", "lackOfCameraDialog", "Lcom/sumsub/sns/internal/camera/video/presentation/SNSVideoSelfieViewModel$State;", "Lcom/sumsub/sns/internal/camera/video/presentation/SNSVideoSelfieViewModel$State;", "lastState", "Lcom/sumsub/sns/internal/core/domain/camera/CameraX;", "Lcom/sumsub/sns/internal/core/domain/camera/CameraX;", "cameraX", "Landroidx/activity/result/ActivityResultLauncher;", "Landroidx/activity/result/ActivityResultLauncher;", "permissionLauncher", "", "getPermissionsPayload", "()Ljava/util/Map;", "permissionsPayload", "getIdDocSetType", "()Ljava/lang/String;", "idDocSetType", "getOpenPayload", "openPayload", "getCancelPayload", "cancelPayload", "getClosePayload", "closePayload", "getAppearPayload", "appearPayload", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class a extends com.sumsub.sns.core.presentation.b<SNSVideoSelfieViewModel.d, SNSVideoSelfieViewModel> implements com.sumsub.sns.internal.core.domain.camera.a {

    /* renamed from: o  reason: collision with root package name */
    public static final C0277a f30714o = new C0277a((r) null);

    /* renamed from: p  reason: collision with root package name */
    public static final /* synthetic */ l<Object>[] f30715p = {Reflection.j(new PropertyReference1Impl(a.class, "previewView", "getPreviewView()Landroidx/camera/view/PreviewView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "circleProgressView", "getCircleProgressView()Landroid/widget/ProgressBar;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "tvCounter", "getTvCounter()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "stopView", "getStopView()Landroid/view/View;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "doneView", "getDoneView()Landroid/view/View;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "tvText", "getTvText()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "tvDescription1", "getTvDescription1()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "tvDescription2", "getTvDescription2()Landroid/widget/TextView;", 0))};

    /* renamed from: q  reason: collision with root package name */
    public static final String f30716q = "EXTRA_FILE";

    /* renamed from: r  reason: collision with root package name */
    public static final String f30717r = "EXTRA_PHRASE";

    /* renamed from: s  reason: collision with root package name */
    public static final String[] f30718s = {"android.permission.CAMERA", "android.permission.RECORD_AUDIO"};

    /* renamed from: a  reason: collision with root package name */
    public final i f30719a;

    /* renamed from: b  reason: collision with root package name */
    public final Screen f30720b = com.sumsub.sns.core.presentation.c.f30925a.a((Fragment) this);

    /* renamed from: c  reason: collision with root package name */
    public final z f30721c = a0.a(this, R.id.sns_camera);

    /* renamed from: d  reason: collision with root package name */
    public final z f30722d = a0.a(this, R.id.sns_video_circle_progress);

    /* renamed from: e  reason: collision with root package name */
    public final z f30723e = a0.a(this, R.id.sns_counter);

    /* renamed from: f  reason: collision with root package name */
    public final z f30724f = a0.a(this, R.id.sns_stop);

    /* renamed from: g  reason: collision with root package name */
    public final z f30725g = a0.a(this, R.id.sns_done);

    /* renamed from: h  reason: collision with root package name */
    public final z f30726h = a0.a(this, R.id.sns_text);

    /* renamed from: i  reason: collision with root package name */
    public final z f30727i = a0.a(this, R.id.sns_description_1);

    /* renamed from: j  reason: collision with root package name */
    public final z f30728j = a0.a(this, R.id.sns_description_2);

    /* renamed from: k  reason: collision with root package name */
    public AlertDialog f30729k;

    /* renamed from: l  reason: collision with root package name */
    public SNSVideoSelfieViewModel.State f30730l;

    /* renamed from: m  reason: collision with root package name */
    public final CameraX f30731m = new CameraX(CameraX.Mode.VIDEO, (Size) null, (CameraX.b) null, CameraSelector.DEFAULT_FRONT_CAMERA, this, 6, (r) null);

    /* renamed from: n  reason: collision with root package name */
    public ActivityResultLauncher<String[]> f30732n;

    /* renamed from: com.sumsub.sns.camera.video.presentation.a$a  reason: collision with other inner class name */
    public static final class C0277a {
        public /* synthetic */ C0277a(r rVar) {
            this();
        }

        public final a a(String str, String str2) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putString("EXTRA_ID_DOC_SET_TYPE", str);
            bundle.putString(SNSVideoSelfieViewModel.E, str2);
            aVar.setArguments(bundle);
            return aVar;
        }

        public C0277a() {
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30733a;

        static {
            int[] iArr = new int[SNSVideoSelfieViewModel.State.values().length];
            iArr[SNSVideoSelfieViewModel.State.Countdown.ordinal()] = 1;
            iArr[SNSVideoSelfieViewModel.State.Recording.ordinal()] = 2;
            iArr[SNSVideoSelfieViewModel.State.Done.ordinal()] = 3;
            f30733a = iArr;
        }
    }

    public static final class c extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f30734a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
            super(0);
            this.f30734a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f30734a;
        }
    }

    public static final class d extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f30735a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(d10.a aVar) {
            super(0);
            this.f30735a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f30735a.invoke();
        }
    }

    public static final class e extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f30736a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(i iVar) {
            super(0);
            this.f30736a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f30736a).getViewModelStore();
        }
    }

    public static final class f extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f30737a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f30738b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(d10.a aVar, i iVar) {
            super(0);
            this.f30737a = aVar;
            this.f30738b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f30737a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f30738b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class g extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f30739a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f30740b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(Fragment fragment, i iVar) {
            super(0);
            this.f30739a = fragment;
            this.f30740b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f30740b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f30739a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class h extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30741a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(a aVar) {
            super(0);
            this.f30741a = aVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            a aVar = this.f30741a;
            return new com.sumsub.sns.internal.camera.video.presentation.a(aVar, aVar.getServiceLocator(), this.f30741a.getArguments());
        }
    }

    public a() {
        h hVar = new h(this);
        i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new d(new c(this)));
        this.f30719a = FragmentViewModelLazyKt.c(this, Reflection.b(SNSVideoSelfieViewModel.class), new e(b11), new f((d10.a) null, b11), hVar);
    }

    public /* synthetic */ Object a(ImageProxy imageProxy, com.sumsub.sns.internal.core.domain.camera.c cVar, kotlin.coroutines.c cVar2) {
        return com.sumsub.sns.internal.core.domain.camera.h.a(this, imageProxy, cVar, cVar2);
    }

    public /* synthetic */ void a(CameraX.c cVar) {
        com.sumsub.sns.internal.core.domain.camera.h.b(this, cVar);
    }

    public /* synthetic */ void a(File file) {
        com.sumsub.sns.internal.core.domain.camera.h.c(this, file);
    }

    public void b(File file) {
        getViewModel().a(file);
    }

    public /* synthetic */ void c() {
        com.sumsub.sns.internal.core.domain.camera.h.e(this);
    }

    public Map<String, Object> getAppearPayload() {
        return getPermissionsPayload();
    }

    public Map<String, Object> getCancelPayload() {
        return getPermissionsPayload();
    }

    public Map<String, Object> getClosePayload() {
        return getPermissionsPayload();
    }

    public String getIdDocSetType() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("EXTRA_ID_DOC_SET_TYPE") : null;
        return string == null ? DocumentType.f32355j : string;
    }

    public int getLayoutId() {
        return R.layout.sns_fragment_video_selfie;
    }

    public Map<String, Object> getOpenPayload() {
        return getPermissionsPayload();
    }

    public final Map<String, Object> getPermissionsPayload() {
        Context context = getContext();
        if (context == null) {
            return MapsKt__MapsKt.h();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(PermissionPayload.MICROPHONE_PERMISSION.toString(), Boolean.valueOf(j.a(context, "android.permission.RECORD_AUDIO")));
        linkedHashMap.put(PermissionPayload.CAMERA_PERMISSION.toString(), Boolean.valueOf(j.a(context, "android.permission.CAMERA")));
        return linkedHashMap;
    }

    public Screen getScreen() {
        return this.f30720b;
    }

    public void handleEvent(a.j jVar) {
        ProgressBar k11;
        if (jVar instanceof SNSVideoSelfieViewModel.b.C0312b) {
            this.f30731m.a(((SNSVideoSelfieViewModel.b.C0312b) jVar).b());
        } else if (jVar instanceof SNSVideoSelfieViewModel.b.c) {
            this.f30731m.h();
        } else if (jVar instanceof SNSVideoSelfieViewModel.b.a) {
            Bundle bundle = new Bundle();
            SNSVideoSelfieViewModel.b.a aVar = (SNSVideoSelfieViewModel.b.a) jVar;
            bundle.putString(f30716q, aVar.b().c().getAbsolutePath());
            bundle.putString(f30717r, aVar.b().d());
            Unit unit = Unit.f56620a;
            com.sumsub.sns.core.presentation.b.finishWithResult$default(this, 0, bundle, 1, (Object) null);
        } else if (jVar instanceof SNSVideoSelfieViewModel.b.d.C0313b) {
            SNSVideoSelfieViewModel.b.d.C0313b bVar = (SNSVideoSelfieViewModel.b.d.C0313b) jVar;
            int i11 = b.f30733a[bVar.a().ordinal()];
            if (i11 == 1) {
                long b11 = ((3000 - bVar.b()) * ((long) 100)) / 3000;
                ProgressBar k12 = k();
                if (k12 != null) {
                    k12.setProgress((int) b11);
                }
                TextView o11 = o();
                if (o11 != null) {
                    d0 d0Var = d0.f56774a;
                    o11.setText(String.format(TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf((bVar.b() / TimeUnit.SECONDS.toMillis(1)) + 1)}, 1)));
                }
            } else if (i11 == 2 && (k11 = k()) != null) {
                k11.setProgress((int) (((SNSVideoSelfieViewModel.f31759z - bVar.b()) * ((long) 100)) / SNSVideoSelfieViewModel.f31759z));
            }
        } else if (jVar instanceof SNSVideoSelfieViewModel.b.d.a) {
            if (b.f30733a[((SNSVideoSelfieViewModel.b.d.a) jVar).a().ordinal()] == 2) {
                getViewModel().t();
                ProgressBar k13 = k();
                if (k13 != null) {
                    k13.setProgress(0);
                }
            }
        } else {
            super.handleEvent(jVar);
        }
    }

    public final void handlePermissionResults(Map<String, Boolean> map) {
        String[] strArr = f30718s;
        int length = strArr.length;
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                z11 = true;
                break;
            } else if (!x.b(map.get(strArr[i11]), Boolean.TRUE)) {
                break;
            } else {
                i11++;
            }
        }
        if (z11) {
            getViewModel().u();
        } else {
            u();
        }
    }

    public final ProgressBar k() {
        return (ProgressBar) this.f30722d.a(this, f30715p[1]);
    }

    public final View l() {
        return this.f30725g.a(this, f30715p[4]);
    }

    public final PreviewView m() {
        return (PreviewView) this.f30721c.a(this, f30715p[0]);
    }

    public final View n() {
        return this.f30724f.a(this, f30715p[3]);
    }

    public final TextView o() {
        return (TextView) this.f30723e.a(this, f30715p[2]);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f30731m.g();
    }

    public /* synthetic */ void onError(Exception exc) {
        com.sumsub.sns.internal.core.domain.camera.h.f(this, exc);
    }

    public void onStart() {
        super.onStart();
        String[] strArr = f30718s;
        if (!a(strArr)) {
            ActivityResultLauncher<String[]> activityResultLauncher = this.f30732n;
            if (activityResultLauncher != null) {
                activityResultLauncher.a(strArr);
                return;
            }
            return;
        }
        getViewModel().u();
    }

    public void onStop() {
        AlertDialog alertDialog = this.f30729k;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.f30729k = null;
        getViewModel().p();
        this.f30731m.h();
        super.onStop();
    }

    public void onViewCreated(View view, Bundle bundle) {
        int i11;
        Drawable background;
        Integer a11;
        super.onViewCreated(view, bundle);
        this.f30732n = registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new f(this));
        com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
        com.sumsub.sns.internal.core.theme.d a12 = aVar.a();
        if (a12 == null || (a11 = aVar.a(a12, SNSColorElement.CONTENT_CRITICAL, aVar.a(view))) == null) {
            i11 = a(requireContext(), R.attr.sns_colorOnRejected);
        } else {
            i11 = a11.intValue();
        }
        View n11 = n();
        if (n11 != null && (background = n11.getBackground()) != null) {
            background.setTint(i11);
        }
    }

    public void onViewModelPrepared(Bundle bundle) {
        super.onViewModelPrepared(bundle);
        t();
    }

    public final TextView p() {
        return (TextView) this.f30727i.a(this, f30715p[6]);
    }

    public final TextView q() {
        return (TextView) this.f30728j.a(this, f30715p[7]);
    }

    public final TextView r() {
        return (TextView) this.f30726h.a(this, f30715p[5]);
    }

    /* renamed from: s */
    public SNSVideoSelfieViewModel getViewModel() {
        return (SNSVideoSelfieViewModel) this.f30719a.getValue();
    }

    public final void t() {
        this.f30731m.a(getViewLifecycleOwner(), m());
        this.f30731m.a(this.f30731m.f().e());
    }

    public final void u() {
        if (this.f30729k == null && isPrepared()) {
            SNSVideoSelfieViewModel.e d11 = ((SNSVideoSelfieViewModel.d) getViewModel().c()).d();
            AlertDialog create = new SNSAlertDialogBuilder(requireContext()).setMessage(d11.i()).setPositiveButton(d11.k(), (DialogInterface.OnClickListener) new d(this)).setOnCancelListener((DialogInterface.OnCancelListener) new b(this)).setNeutralButton(d11.j(), (DialogInterface.OnClickListener) new c(this)).create();
            this.f30729k = create;
            if (create != null) {
                create.show();
            }
        }
    }

    public static final void a(a aVar, Map map) {
        aVar.handlePermissionResults(map);
    }

    public final void b(int i11) {
        ProgressBar k11 = k();
        Drawable indeterminateDrawable = k11 != null ? k11.getIndeterminateDrawable() : null;
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setColorFilter(new PorterDuffColorFilter(i11, PorterDuff.Mode.SRC_IN));
        }
    }

    @SensorsDataInstrumented
    public static final void b(a aVar, DialogInterface dialogInterface, int i11) {
        dialogInterface.dismiss();
        aVar.f30729k = null;
        com.sumsub.sns.core.presentation.b.finish$default(aVar, (q) null, (Object) null, (Long) null, 7, (Object) null);
        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
    }

    /* renamed from: a */
    public void handleState(SNSVideoSelfieViewModel.d dVar, Bundle bundle) {
        TextView r11 = r();
        if (r11 != null) {
            com.sumsub.sns.internal.core.common.i.a(r11, dVar.d().l());
        }
        TextView p11 = p();
        if (p11 != null) {
            com.sumsub.sns.internal.core.common.i.a(p11, dVar.d().g());
        }
        TextView q11 = q();
        if (q11 != null) {
            com.sumsub.sns.internal.core.common.i.a(q11, dVar.d().h());
        }
        if (this.f30730l != dVar.c()) {
            this.f30730l = dVar.c();
            SNSVideoSelfieViewModel.State c11 = dVar.c();
            int i11 = c11 == null ? -1 : b.f30733a[c11.ordinal()];
            Drawable drawable = null;
            boolean z11 = false;
            if (i11 == 1) {
                TextView o11 = o();
                if (o11 != null) {
                    o11.setVisibility(0);
                }
                View n11 = n();
                if (n11 != null) {
                    n11.setVisibility(8);
                }
                View l11 = l();
                if (l11 != null) {
                    l11.setVisibility(8);
                }
                a(R.drawable.circular_progress_bar_countdown);
                com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
                com.sumsub.sns.internal.core.theme.d a11 = aVar.a();
                if (a11 != null) {
                    SNSColorElement sNSColorElement = SNSColorElement.CONTENT_WEAK;
                    View view = getView();
                    if (view != null) {
                        z11 = aVar.a(view);
                    }
                    Integer a12 = aVar.a(a11, sNSColorElement, z11);
                    if (a12 != null) {
                        int intValue = a12.intValue();
                        ProgressBar k11 = k();
                        if (k11 != null) {
                            drawable = k11.getProgressDrawable();
                        }
                        if (drawable != null) {
                            drawable.setColorFilter(new PorterDuffColorFilter(intValue, PorterDuff.Mode.SRC_IN));
                        }
                    }
                }
                b(a(requireContext(), R.attr.sns_colorOnProcessing));
            } else if (i11 == 2) {
                TextView o12 = o();
                if (o12 != null) {
                    o12.setVisibility(8);
                }
                View n12 = n();
                if (n12 != null) {
                    n12.setVisibility(0);
                }
                View l12 = l();
                if (l12 != null) {
                    l12.setVisibility(8);
                }
                a(R.drawable.circular_progress_bar_recording);
                com.sumsub.sns.core.presentation.helper.a aVar2 = com.sumsub.sns.core.presentation.helper.a.f31095a;
                com.sumsub.sns.internal.core.theme.d a13 = aVar2.a();
                if (a13 != null) {
                    SNSColorElement sNSColorElement2 = SNSColorElement.CONTENT_CRITICAL;
                    View view2 = getView();
                    if (view2 != null) {
                        z11 = aVar2.a(view2);
                    }
                    Integer a14 = aVar2.a(a13, sNSColorElement2, z11);
                    if (a14 != null) {
                        int intValue2 = a14.intValue();
                        ProgressBar k12 = k();
                        if (k12 != null) {
                            drawable = k12.getProgressDrawable();
                        }
                        if (drawable != null) {
                            drawable.setColorFilter(new PorterDuffColorFilter(intValue2, PorterDuff.Mode.SRC_IN));
                        }
                    }
                }
                b(a(requireContext(), R.attr.sns_colorOnRejected));
                View n13 = n();
                if (n13 != null) {
                    n13.setOnClickListener(new e(this));
                }
            } else if (i11 == 3) {
                ProgressBar k13 = k();
                if (k13 != null) {
                    k13.setProgress(0);
                }
                TextView o13 = o();
                if (o13 != null) {
                    o13.setVisibility(8);
                }
                View n14 = n();
                if (n14 != null) {
                    n14.setVisibility(8);
                }
                View l13 = l();
                if (l13 != null) {
                    l13.setVisibility(0);
                }
            }
        }
    }

    public static final void a(a aVar, View view) {
        com.sumsub.sns.internal.core.analytics.c.b(aVar.getAnalyticsDelegate(), aVar.getScreen(), aVar.getIdDocSetType(), Control.DoneButton, (Map) null, 8, (Object) null);
        aVar.getViewModel().t();
        ProgressBar k11 = aVar.k();
        if (k11 != null) {
            k11.setProgress(0);
        }
    }

    public final int a(Context context, int i11) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().data, new int[]{i11});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        return color;
    }

    public final void a(int i11) {
        ProgressBar k11 = k();
        if (k11 != null) {
            Resources resources = getResources();
            FragmentActivity activity = getActivity();
            k11.setProgressDrawable(ResourcesCompat.f(resources, i11, activity != null ? activity.getTheme() : null));
        }
    }

    public static final void a(a aVar, DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        aVar.f30729k = null;
        com.sumsub.sns.core.presentation.b.finish$default(aVar, (q) null, (Object) null, (Long) null, 7, (Object) null);
    }

    @SensorsDataInstrumented
    public static final void a(a aVar, DialogInterface dialogInterface, int i11) {
        dialogInterface.dismiss();
        aVar.f30729k = null;
        com.sumsub.sns.internal.core.common.i.a((Activity) aVar.requireActivity());
        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
    }

    public final boolean a(String[] strArr) {
        int length = strArr.length;
        int i11 = 0;
        while (true) {
            boolean z11 = true;
            if (i11 >= length) {
                return true;
            }
            if (ContextCompat.checkSelfPermission(requireContext(), strArr[i11]) != 0) {
                z11 = false;
            }
            if (!z11) {
                return false;
            }
            i11++;
        }
    }
}
