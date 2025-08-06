package com.jumio.defaultui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.n0;
import androidx.lifecycle.v;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.z;
import androidx.navigation.AnimBuilder;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.fragment.NavHostFragment;
import com.jumio.commons.enums.Rotation;
import com.jumio.commons.log.Log;
import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.core.enums.ErrorCase;
import com.jumio.core.util.DataDogHelper;
import com.jumio.core.util.DeviceUtilKt;
import com.jumio.core.util.QAKt;
import com.jumio.core.util.SplitUtil;
import com.jumio.defaultui.view.JumioFragmentCallback;
import com.jumio.defaultui.view.LoadingView;
import com.jumio.sdk.JumioSDK;
import com.jumio.sdk.controller.JumioController;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.credentials.JumioDataCredential;
import com.jumio.sdk.credentials.JumioDocumentCredential;
import com.jumio.sdk.credentials.JumioFaceCredential;
import com.jumio.sdk.credentials.JumioIDCredential;
import com.jumio.sdk.document.JumioDigitalDocument;
import com.jumio.sdk.document.JumioDocument;
import com.jumio.sdk.document.JumioPhysicalDocument;
import com.jumio.sdk.enums.JumioDataCenter;
import com.jumio.sdk.enums.JumioScanMode;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.error.JumioError;
import com.jumio.sdk.exceptions.SDKNotConfiguredException;
import com.jumio.sdk.result.JumioResult;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.jumio.sdk.util.JumioDeepLinkHandler;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.p;
import jumio.dui.b;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;

public final class JumioActivity extends AppCompatActivity implements View.OnClickListener, JumioFragmentCallback {
    public static final Companion Companion = new Companion((r) null);
    public static final String EXTRA_CUSTOM_THEME = "com.jumio.defaultui.JumioActivity.EXTRA_CUSTOM_THEME";
    public static final String EXTRA_DATACENTER = "com.jumio.defaultui.JumioActivity.EXTRA_DATACENTER";
    public static final String EXTRA_RESULT = "com.jumio.defaultui.JumioActivity.EXTRA_RESULT";
    public static final String EXTRA_TOKEN = "com.jumio.defaultui.JumioActivity.EXTRA_TOKEN";
    public static final int PERMISSION_REQUEST_CODE = 100;
    private static final String TAG = "JumioActivity";
    private ImageButton btnQuit;
    /* access modifiers changed from: private */
    public int customThemeId;
    /* access modifiers changed from: private */
    public JumioDataCenter datacenter = JumioDataCenter.US;
    /* access modifiers changed from: private */
    public JumioError error;
    private final Object finishLock = new Object();
    private final kotlin.i jumioViewModel$delegate = new n0(Reflection.b(jumio.dui.b.class), new m(this), new h(this), new n(this));
    private final jumio.dui.f<ActivityResult> lastActivityResult = new jumio.dui.f<>();
    private final ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ow.a(this));
    /* access modifiers changed from: private */
    public LoadingView loadingView;
    private NavController navController;
    private ConstraintLayout rootContainer;
    private DeviceRotationManager rotationManager;
    /* access modifiers changed from: private */
    public String token = "";

    @Keep
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public final class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            JumioActivity.this.shutdown();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public final class b implements View.OnClickListener {

        public /* synthetic */ class a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f70801a;

            static {
                int[] iArr = new int[b.C0659b.values().length];
                try {
                    iArr[9] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[1] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[7] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[12] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f70801a = iArr;
            }
        }

        public b() {
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            JumioController jumioController;
            b.C0659b value = JumioActivity.this.getJumioViewModel().f56361i.getValue();
            int i11 = value == null ? -1 : a.f70801a[value.ordinal()];
            if (i11 == 1) {
                LoadingView access$getLoadingView$p = JumioActivity.this.loadingView;
                if (access$getLoadingView$p != null) {
                    access$getLoadingView$p.update(new LoadingView.State(LoadingView.ViewState.PROGRESS, (String) null, (String) null, 0, (View.OnClickListener) null, 30, (r) null));
                }
            } else if (i11 == 2 || i11 == 3) {
                LoadingView access$getLoadingView$p2 = JumioActivity.this.loadingView;
                if (access$getLoadingView$p2 != null) {
                    access$getLoadingView$p2.update(new LoadingView.State(LoadingView.ViewState.PROGRESS, JumioActivity.this.getString(R.string.jumio_loading_title), (String) null, 0, (View.OnClickListener) null, 28, (r) null));
                }
            } else if (i11 != 4) {
                LoadingView access$getLoadingView$p3 = JumioActivity.this.loadingView;
                if (access$getLoadingView$p3 != null) {
                    LoadingView.hide$default(access$getLoadingView$p3, (AnimatorListenerAdapter) null, 0, 0, 7, (Object) null);
                }
            } else {
                LoadingView access$getLoadingView$p4 = JumioActivity.this.loadingView;
                if (access$getLoadingView$p4 != null) {
                    access$getLoadingView$p4.update(new LoadingView.State(LoadingView.ViewState.PROGRESS, JumioActivity.this.getString(R.string.jumio_uploading_title), (String) null, 0, (View.OnClickListener) null, 28, (r) null));
                }
            }
            JumioError access$getError$p = JumioActivity.this.error;
            if (!(access$getError$p == null || (jumioController = JumioActivity.this.getJumioViewModel().f56356d) == null)) {
                jumioController.retry(access$getError$p);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f70802a;

        static {
            int[] iArr = new int[b.C0659b.values().length];
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[7] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[9] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[2] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[10] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[11] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[5] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[12] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f70802a = iArr;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.jumio.defaultui.JumioActivity$finishActivity$1$1", f = "JumioActivity.kt", l = {544}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f70803a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JumioActivity f70804b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(JumioActivity jumioActivity, kotlin.coroutines.c<? super d> cVar) {
            super(2, cVar);
            this.f70804b = jumioActivity;
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new d(this.f70804b, cVar);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((d) create((h0) obj, (kotlin.coroutines.c) obj2)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f70803a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                this.f70803a = 1;
                if (DelayKt.b(2000, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f70804b.finish();
            return Unit.f56620a;
        }
    }

    public static final class e extends Lambda implements d10.l<JumioResult, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JumioActivity f70805a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(JumioActivity jumioActivity) {
            super(1);
            this.f70805a = jumioActivity;
        }

        public final Object invoke(Object obj) {
            LoadingView access$getLoadingView$p;
            JumioResult jumioResult = (JumioResult) obj;
            if (jumioResult.isSuccess()) {
                LoadingView access$getLoadingView$p2 = this.f70805a.loadingView;
                boolean z11 = true;
                if (access$getLoadingView$p2 == null || !access$getLoadingView$p2.isShowing()) {
                    z11 = false;
                }
                if (z11 && (access$getLoadingView$p = this.f70805a.loadingView) != null) {
                    access$getLoadingView$p.update(new LoadingView.State(LoadingView.ViewState.SUCCESS, this.f70805a.getString(R.string.jumio_uploading_success), "", 0, (View.OnClickListener) null, 24, (r) null));
                }
            }
            this.f70805a.finishActivity(jumioResult);
            return Unit.f56620a;
        }
    }

    public static final class f extends Lambda implements d10.l<JumioError, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JumioActivity f70806a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(JumioActivity jumioActivity) {
            super(1);
            this.f70806a = jumioActivity;
        }

        public final Object invoke(Object obj) {
            this.f70806a.setActionBarQuitIcon(R.drawable.jumio_ic_close);
            this.f70806a.showError((JumioError) obj);
            return Unit.f56620a;
        }
    }

    public static final class g extends Lambda implements d10.l<b.C0659b, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JumioActivity f70807a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(JumioActivity jumioActivity) {
            super(1);
            this.f70807a = jumioActivity;
        }

        public final Object invoke(Object obj) {
            LoadingView access$getLoadingView$p;
            b.C0659b bVar = (b.C0659b) obj;
            if (!(bVar == b.C0659b.LOADING || bVar == b.C0659b.UPLOAD)) {
                this.f70807a.hideLoading();
            }
            JumioScanMode jumioScanMode = null;
            switch (bVar.ordinal()) {
                case 0:
                    JumioActivity jumioActivity = this.f70807a;
                    int i11 = R.id.startFragment;
                    JumioActivity.navigateTo$default(jumioActivity, i11, Integer.valueOf(i11), (d10.l) null, 4, (Object) null);
                    break;
                case 1:
                    this.f70807a.showLoading();
                    break;
                case 2:
                    JumioActivity.navigateTo$default(this.f70807a, R.id.documentSelectionFragment, (Integer) null, (d10.l) null, 6, (Object) null);
                    break;
                case 3:
                    JumioActivity.navigateTo$default(this.f70807a, R.id.variantFragment, (Integer) null, (d10.l) null, 6, (Object) null);
                    break;
                case 4:
                    JumioActivity.navigateTo$default(this.f70807a, R.id.diVendorFragment, (Integer) null, (d10.l) null, 6, (Object) null);
                    break;
                case 5:
                    this.f70807a.navigateTo(R.id.countrySelectionFragment, Integer.valueOf(R.id.documentSelectionFragment), a.f70820a);
                    break;
                case 6:
                    JumioActivity.navigateTo$default(this.f70807a, R.id.methodSelectionFragment, (Integer) null, (d10.l) null, 6, (Object) null);
                    break;
                case 7:
                    JumioCredential jumioCredential = this.f70807a.getJumioViewModel().f56358f;
                    if (!(jumioCredential instanceof JumioIDCredential)) {
                        if (!(jumioCredential instanceof JumioFaceCredential)) {
                            if (!(jumioCredential instanceof JumioDocumentCredential)) {
                                if (jumioCredential instanceof JumioDataCredential) {
                                    this.f70807a.showLoading();
                                    break;
                                }
                            } else {
                                JumioScanPart j11 = this.f70807a.getJumioViewModel().j();
                                if (j11 != null) {
                                    jumioScanMode = j11.getScanMode();
                                }
                                if (jumioScanMode != JumioScanMode.FILE) {
                                    JumioActivity.navigateTo$default(this.f70807a, R.id.idScanFragment, (Integer) null, (d10.l) null, 4, (Object) null);
                                    break;
                                } else {
                                    JumioActivity.navigateTo$default(this.f70807a, R.id.uploadDocumentFragment, (Integer) null, (d10.l) null, 4, (Object) null);
                                    break;
                                }
                            }
                        } else {
                            JumioActivity.navigateTo$default(this.f70807a, R.id.livenessScanFragment, (Integer) null, (d10.l) null, 4, (Object) null);
                            break;
                        }
                    } else {
                        JumioDocument g11 = this.f70807a.getJumioViewModel().g();
                        if (g11 != null) {
                            if (!(g11 instanceof JumioDigitalDocument)) {
                                if (g11 instanceof JumioPhysicalDocument) {
                                    JumioActivity.navigateTo$default(this.f70807a, R.id.idScanFragment, (Integer) null, (d10.l) null, 4, (Object) null);
                                    break;
                                }
                            } else {
                                JumioActivity.navigateTo$default(this.f70807a, R.id.digitalIdentityFragment, (Integer) null, (d10.l) null, 4, (Object) null);
                                break;
                            }
                        }
                    }
                    break;
                case 8:
                    JumioActivity.navigateTo$default(this.f70807a, R.id.faceHelpFragment, (Integer) null, (d10.l) null, 4, (Object) null);
                    break;
                case 9:
                    JumioActivity.navigateTo$default(this.f70807a, R.id.nfcScanFragment, (Integer) null, (d10.l) null, 4, (Object) null);
                    break;
                case 10:
                    n1 unused = kotlinx.coroutines.i.d(v.a(this.f70807a), (CoroutineContext) null, (CoroutineStart) null, new b(this.f70807a, (kotlin.coroutines.c<? super b>) null), 3, (Object) null);
                    break;
                case 11:
                    JumioActivity.navigateTo$default(this.f70807a, R.id.rejectFragment, (Integer) null, (d10.l) null, 4, (Object) null);
                    this.f70807a.setActionBarQuitIcon(R.drawable.jumio_ic_close);
                    break;
                case 12:
                    LoadingView access$getLoadingView$p2 = this.f70807a.loadingView;
                    if ((access$getLoadingView$p2 != null && !access$getLoadingView$p2.isShowing()) && (access$getLoadingView$p = this.f70807a.loadingView) != null) {
                        LoadingView.show$default(access$getLoadingView$p, (AnimatorListenerAdapter) null, 100, 0, 5, (Object) null);
                    }
                    this.f70807a.setActionBarQuitIcon(R.drawable.jumio_ic_close);
                    LoadingView access$getLoadingView$p3 = this.f70807a.loadingView;
                    if (access$getLoadingView$p3 != null) {
                        access$getLoadingView$p3.update(new LoadingView.State(LoadingView.ViewState.PROGRESS, this.f70807a.getString(R.string.jumio_uploading_title), (String) null, 0, (View.OnClickListener) null, 28, (r) null));
                        break;
                    }
                    break;
            }
            return Unit.f56620a;
        }
    }

    public static final class h extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JumioActivity f70808a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(JumioActivity jumioActivity) {
            super(0);
            this.f70808a = jumioActivity;
        }

        public final Object invoke() {
            JumioDataCenter jumioDataCenter;
            ActivityInfo activityInfo;
            Bundle extras;
            String string;
            if (!(this.f70808a.getIntent() == null || this.f70808a.getIntent().getExtras() == null)) {
                Bundle extras2 = this.f70808a.getIntent().getExtras();
                JumioActivity jumioActivity = this.f70808a;
                String string2 = extras2 != null ? extras2.getString(JumioActivity.EXTRA_TOKEN) : null;
                if (string2 == null) {
                    string2 = "";
                }
                jumioActivity.token = string2;
                JumioActivity jumioActivity2 = this.f70808a;
                if (extras2 == null || (string = extras2.getString(JumioActivity.EXTRA_DATACENTER)) == null || (jumioDataCenter = JumioDataCenter.valueOf(string)) == null) {
                    jumioDataCenter = JumioDataCenter.US;
                }
                jumioActivity2.datacenter = jumioDataCenter;
                JumioActivity jumioActivity3 = this.f70808a;
                Intent intent = jumioActivity3.getIntent();
                int i11 = 0;
                jumioActivity3.customThemeId = (intent == null || (extras = intent.getExtras()) == null) ? 0 : extras.getInt(JumioActivity.EXTRA_CUSTOM_THEME, 0);
                if (this.f70808a.customThemeId != 0) {
                    JumioActivity jumioActivity4 = this.f70808a;
                    jumioActivity4.setTheme(jumioActivity4.customThemeId);
                } else {
                    JumioActivity jumioActivity5 = this.f70808a;
                    PackageManager packageManager = jumioActivity5.getPackageManager();
                    if (!(packageManager == null || (activityInfo = packageManager.getActivityInfo(this.f70808a.getComponentName(), 0)) == null)) {
                        i11 = activityInfo.getThemeResource();
                    }
                    jumioActivity5.customThemeId = i11;
                }
            }
            JumioActivity jumioActivity6 = this.f70808a;
            return new jumio.dui.c(jumioActivity6, jumioActivity6.token, this.f70808a.datacenter, this.f70808a.customThemeId, this.f70808a.getApplication());
        }
    }

    public static final class i extends Lambda implements d10.l<AnimBuilder, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public static final i f70809a = new i();

        public i() {
            super(1);
        }

        public final Object invoke(Object obj) {
            AnimBuilder animBuilder = (AnimBuilder) obj;
            animBuilder.e(R.animator.jumio_slide_in);
            animBuilder.g(R.animator.jumio_slide_out);
            return Unit.f56620a;
        }
    }

    public static final class j extends Lambda implements d10.l<NavOptionsBuilder, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Integer f70810a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d10.l<AnimBuilder, Unit> f70811b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(Integer num, d10.l<? super AnimBuilder, Unit> lVar) {
            super(1);
            this.f70810a = num;
            this.f70811b = lVar;
        }

        public final Object invoke(Object obj) {
            NavOptionsBuilder navOptionsBuilder = (NavOptionsBuilder) obj;
            Integer num = this.f70810a;
            if (num != null) {
                num.intValue();
                NavOptionsBuilder.d(navOptionsBuilder, num.intValue(), (d10.l) null, 2, (Object) null);
            }
            navOptionsBuilder.a(this.f70811b);
            return Unit.f56620a;
        }
    }

    public static final class k implements z, u {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.l f70812a;

        public k(d10.l lVar) {
            this.f70812a = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(this.f70812a, ((u) obj).getFunctionDelegate());
        }

        public final kotlin.f<?> getFunctionDelegate() {
            return this.f70812a;
        }

        public final int hashCode() {
            return this.f70812a.hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f70812a.invoke(obj);
        }
    }

    public static final class l extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JumioActivity f70813a;

        public l(JumioActivity jumioActivity) {
            this.f70813a = jumioActivity;
        }

        public final void onAnimationEnd(Animator animator) {
            LoadingView access$getLoadingView$p;
            if (this.f70813a.error == null && (access$getLoadingView$p = this.f70813a.loadingView) != null) {
                access$getLoadingView$p.update(new LoadingView.State(LoadingView.ViewState.PROGRESS, this.f70813a.getString(R.string.jumio_loading_title), (String) null, 0, (View.OnClickListener) null, 28, (r) null));
            }
        }
    }

    public static final class m extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ComponentActivity f70814a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(ComponentActivity componentActivity) {
            super(0);
            this.f70814a = componentActivity;
        }

        public final Object invoke() {
            return this.f70814a.getViewModelStore();
        }
    }

    public static final class n extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ComponentActivity f70815a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(ComponentActivity componentActivity) {
            super(0);
            this.f70815a = componentActivity;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            return this.f70815a.getDefaultViewModelCreationExtras();
        }
    }

    private final boolean cancelCredentialReturnToStart() {
        try {
            JumioCredential jumioCredential = getJumioViewModel().f56358f;
            if (jumioCredential != null) {
                jumioCredential.cancel();
            }
            jumio.dui.b jumioViewModel = getJumioViewModel();
            jumioViewModel.getClass();
            Log.i("SdkState: ViewModel set START");
            jumioViewModel.f56362j.setValue(null);
            jumioViewModel.f56361i.setValue(b.C0659b.START);
            return true;
        } catch (SDKNotConfiguredException e11) {
            Log.e(TAG, (Throwable) e11);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void finishActivity(JumioResult jumioResult) {
        String str = TAG;
        Log.d(str, "finishSDK called");
        synchronized (this.finishLock) {
            Intent intent = new Intent();
            intent.putExtra(EXTRA_RESULT, jumioResult);
            setResult(-1, intent);
            Log.d(str, "finishing activity...");
            LoadingView loadingView2 = this.loadingView;
            boolean z11 = true;
            if (loadingView2 == null || !loadingView2.isShowing()) {
                z11 = false;
            }
            if (z11) {
                LoadingView loadingView3 = this.loadingView;
                if ((loadingView3 != null ? loadingView3.getViewState() : null) == LoadingView.ViewState.SUCCESS) {
                    n1 unused = kotlinx.coroutines.i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new d(this, (kotlin.coroutines.c<? super d>) null), 3, (Object) null);
                }
            }
            finish();
            Unit unit = Unit.f56620a;
        }
    }

    /* access modifiers changed from: private */
    public final jumio.dui.b getJumioViewModel() {
        return (jumio.dui.b) this.jumioViewModel$delegate.getValue();
    }

    private final void initObservers() {
        getJumioViewModel().f56366n.observe(this, new k(new e(this)));
        getJumioViewModel().f56367o.observe(this, new k(new f(this)));
        getJumioViewModel().f56361i.observe(this, new k(new g(this)));
    }

    /* access modifiers changed from: private */
    public static final void launcher$lambda$3(JumioActivity jumioActivity, ActivityResult activityResult) {
        jumioActivity.getLastActivityResult().setValue(activityResult);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r2.D();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void navigateIfRequired(androidx.navigation.NavController r2, int r3, android.os.Bundle r4, androidx.navigation.NavOptions r5) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0010
            androidx.navigation.NavDestination r0 = r2.D()
            if (r0 == 0) goto L_0x0010
            int r0 = r0.l()
            if (r0 != r3) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            if (r0 != 0) goto L_0x0019
            if (r2 == 0) goto L_0x0019
            r0 = 0
            r2.R(r3, r4, r5, r0)
        L_0x0019:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.JumioActivity.navigateIfRequired(androidx.navigation.NavController, int, android.os.Bundle, androidx.navigation.NavOptions):void");
    }

    public static /* synthetic */ void navigateIfRequired$default(JumioActivity jumioActivity, NavController navController2, int i11, Bundle bundle, NavOptions navOptions, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            bundle = null;
        }
        if ((i12 & 4) != 0) {
            navOptions = null;
        }
        jumioActivity.navigateIfRequired(navController2, i11, bundle, navOptions);
    }

    /* access modifiers changed from: private */
    public final void navigateTo(int i11, Integer num, d10.l<? super AnimBuilder, Unit> lVar) {
        NavController navController2 = this.navController;
        if (navController2 == null) {
            navController2 = null;
        }
        navigateIfRequired(navController2, i11, (Bundle) null, androidx.navigation.j.a(new j(num, lVar)));
    }

    public static /* synthetic */ void navigateTo$default(JumioActivity jumioActivity, int i11, Integer num, d10.l lVar, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            num = Integer.valueOf(i11);
        }
        if ((i12 & 4) != 0) {
            lVar = i.f70809a;
        }
        jumioActivity.navigateTo(i11, num, lVar);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(JumioActivity jumioActivity, NavController navController2, NavDestination navDestination, Bundle bundle) {
        String str = TAG;
        CharSequence m11 = navDestination.m();
        b.C0659b value = jumioActivity.getJumioViewModel().p().getValue();
        String name = value != null ? value.name() : null;
        Log.i(str, "Current destination: " + m11 + ", State: " + name);
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$2(JumioActivity jumioActivity) {
        LoadingView loadingView2 = jumioActivity.loadingView;
        if (loadingView2 != null) {
            loadingView2.setPause(false);
        }
    }

    /* access modifiers changed from: private */
    public final void showError(JumioError jumioError) {
        this.error = jumioError;
        View.OnClickListener bVar = jumioError.isRetryable() ? new b() : new a();
        LoadingView loadingView2 = this.loadingView;
        if (loadingView2 != null) {
            loadingView2.update(new LoadingView.ErrorState(jumioError, getString(R.string.jumio_error_connection_title), bVar));
            LoadingView.show$default(loadingView2, (AnimatorListenerAdapter) null, 100, 0, 5, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void showLoading() {
        LoadingView loadingView2 = this.loadingView;
        if (loadingView2 != null) {
            LoadingView.show$default(loadingView2, new l(this), 0, 0, 6, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void shutdown() {
        try {
            jumio.dui.b jumioViewModel = getJumioViewModel();
            jumioViewModel.f56354b.removeMessages(1000);
            JumioController jumioController = jumioViewModel.f56356d;
            if (jumioController != null) {
                jumioController.cancel();
            }
        } catch (Exception e11) {
            String str = TAG;
            String message = e11.getMessage();
            if (message == null) {
                message = "No message available";
            }
            Log.d(str, message);
        }
    }

    public void announceAccessibilityFragmentTitle() {
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        SplitUtil splitUtil = SplitUtil.INSTANCE;
        splitUtil.installSplitContext(context);
        splitUtil.installSplitContext(this);
    }

    public void countrySelected() {
        jumio.dui.b jumioViewModel = getJumioViewModel();
        jumioViewModel.getClass();
        Log.i("SdkState: ViewModel set SELECTION_DOCUMENT");
        jumioViewModel.f56362j.setValue(null);
        jumioViewModel.f56361i.setValue(b.C0659b.SELECTION_DOCUMENT);
    }

    public jumio.dui.f<ActivityResult> getLastActivityResult() {
        return this.lastActivityResult;
    }

    public ActivityResultLauncher<Intent> getLauncher() {
        return this.launcher;
    }

    public DeviceRotationManager getRotationManager() {
        return this.rotationManager;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = super.getTheme();
        int i11 = this.customThemeId;
        if (i11 != 0) {
            theme.applyStyle(i11, true);
        }
        return theme;
    }

    public void hideLoading() {
        LoadingView loadingView2 = this.loadingView;
        if (loadingView2 != null) {
            LoadingView.hide$default(loadingView2, (AnimatorListenerAdapter) null, 0, 0, 7, (Object) null);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBackPressed() {
        /*
            r5 = this;
            jumio.dui.b r0 = r5.getJumioViewModel()
            jumio.dui.f<jumio.dui.b$b> r0 = r0.f56361i
            java.lang.Object r0 = r0.getValue()
            jumio.dui.b$b r0 = (jumio.dui.b.C0659b) r0
            if (r0 != 0) goto L_0x0010
            r0 = -1
            goto L_0x0018
        L_0x0010:
            int[] r1 = com.jumio.defaultui.JumioActivity.c.f70802a
            int r0 = r0.ordinal()
            r0 = r1[r0]
        L_0x0018:
            java.lang.String r1 = "currentSelectionSkipped"
            java.lang.String r2 = "SdkState: ViewModel set SELECTION_DOCUMENT"
            r3 = 0
            r4 = 0
            switch(r0) {
                case 1: goto L_0x00ee;
                case 2: goto L_0x00ee;
                case 3: goto L_0x007d;
                case 4: goto L_0x0044;
                case 5: goto L_0x003e;
                case 6: goto L_0x00f1;
                case 7: goto L_0x00f1;
                case 8: goto L_0x0039;
                case 9: goto L_0x0027;
                default: goto L_0x0021;
            }
        L_0x0021:
            boolean r3 = r5.cancelCredentialReturnToStart()
            goto L_0x00f2
        L_0x0027:
            com.jumio.defaultui.view.LoadingView r0 = r5.loadingView
            if (r0 == 0) goto L_0x002f
            com.jumio.defaultui.view.LoadingView$ViewState r4 = r0.getViewState()
        L_0x002f:
            com.jumio.defaultui.view.LoadingView$ViewState r0 = com.jumio.defaultui.view.LoadingView.ViewState.ERROR
            if (r4 != r0) goto L_0x00f2
            boolean r3 = r5.cancelCredentialReturnToStart()
            goto L_0x00f2
        L_0x0039:
            r5.countrySelected()
            goto L_0x00f1
        L_0x003e:
            boolean r3 = r5.cancelCredentialReturnToStart()
            goto L_0x00f2
        L_0x0044:
            jumio.dui.b r0 = r5.getJumioViewModel()
            androidx.lifecycle.SavedStateHandle r0 = r0.f56353a
            java.lang.Object r0 = r0.f(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            if (r0 == 0) goto L_0x0056
            boolean r3 = r0.booleanValue()
        L_0x0056:
            if (r3 == 0) goto L_0x005e
            boolean r3 = r5.cancelCredentialReturnToStart()
            goto L_0x00f2
        L_0x005e:
            jumio.dui.b r0 = r5.getJumioViewModel()
            r0.a()
            jumio.dui.b r0 = r5.getJumioViewModel()
            r0.getClass()
            com.jumio.commons.log.Log.i(r2)
            androidx.lifecycle.MutableLiveData<com.jumio.sdk.enums.JumioScanStep> r1 = r0.f56362j
            r1.setValue(r4)
            jumio.dui.f<jumio.dui.b$b> r0 = r0.f56361i
            jumio.dui.b$b r1 = jumio.dui.b.C0659b.SELECTION_DOCUMENT
            r0.setValue(r1)
            goto L_0x00f1
        L_0x007d:
            jumio.dui.b r0 = r5.getJumioViewModel()
            androidx.lifecycle.SavedStateHandle r0 = r0.f56353a
            java.lang.Object r0 = r0.f(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            if (r0 == 0) goto L_0x008f
            boolean r3 = r0.booleanValue()
        L_0x008f:
            if (r3 == 0) goto L_0x0096
            boolean r3 = r5.cancelCredentialReturnToStart()
            goto L_0x00f2
        L_0x0096:
            jumio.dui.b r0 = r5.getJumioViewModel()
            com.jumio.sdk.credentials.JumioCredential r0 = r0.f56358f
            boolean r1 = r0 instanceof com.jumio.sdk.credentials.JumioIDCredential
            if (r1 == 0) goto L_0x00be
            jumio.dui.b r0 = r5.getJumioViewModel()
            r0.a()
            jumio.dui.b r0 = r5.getJumioViewModel()
            r0.getClass()
            com.jumio.commons.log.Log.i(r2)
            androidx.lifecycle.MutableLiveData<com.jumio.sdk.enums.JumioScanStep> r1 = r0.f56362j
            r1.setValue(r4)
            jumio.dui.f<jumio.dui.b$b> r0 = r0.f56361i
            jumio.dui.b$b r1 = jumio.dui.b.C0659b.SELECTION_DOCUMENT
            r0.setValue(r1)
            goto L_0x00f1
        L_0x00be:
            boolean r1 = r0 instanceof com.jumio.sdk.credentials.JumioFaceCredential
            if (r1 == 0) goto L_0x00c7
            boolean r3 = r5.cancelCredentialReturnToStart()
            goto L_0x00f2
        L_0x00c7:
            boolean r0 = r0 instanceof com.jumio.sdk.credentials.JumioDocumentCredential
            if (r0 == 0) goto L_0x00e9
            jumio.dui.b r0 = r5.getJumioViewModel()
            r0.a()
            jumio.dui.b r0 = r5.getJumioViewModel()
            r0.getClass()
            com.jumio.commons.log.Log.i(r2)
            androidx.lifecycle.MutableLiveData<com.jumio.sdk.enums.JumioScanStep> r1 = r0.f56362j
            r1.setValue(r4)
            jumio.dui.f<jumio.dui.b$b> r0 = r0.f56361i
            jumio.dui.b$b r1 = jumio.dui.b.C0659b.SELECTION_METHOD
            r0.setValue(r1)
            goto L_0x00f1
        L_0x00e9:
            boolean r3 = r5.cancelCredentialReturnToStart()
            goto L_0x00f2
        L_0x00ee:
            r5.shutdown()
        L_0x00f1:
            r3 = 1
        L_0x00f2:
            if (r3 == 0) goto L_0x00fb
            androidx.activity.OnBackPressedDispatcher r0 = r5.getOnBackPressedDispatcher()
            r0.l()
        L_0x00fb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.JumioActivity.onBackPressed():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        if ((r0 != null ? r0.getViewState() : null) == com.jumio.defaultui.view.LoadingView.ViewState.ERROR) goto L_0x0024;
     */
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r3) {
        /*
            r2 = this;
            int r0 = r3.getId()
            int r1 = com.jumio.defaultui.R.id.ib_quit
            if (r0 != r1) goto L_0x0027
            jumio.dui.b r0 = r2.getJumioViewModel()
            jumio.dui.f<jumio.dui.b$b> r0 = r0.f56361i
            java.lang.Object r0 = r0.getValue()
            jumio.dui.b$b r1 = jumio.dui.b.C0659b.UPLOAD
            if (r0 != r1) goto L_0x0024
            com.jumio.defaultui.view.LoadingView r0 = r2.loadingView
            if (r0 == 0) goto L_0x001f
            com.jumio.defaultui.view.LoadingView$ViewState r0 = r0.getViewState()
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            com.jumio.defaultui.view.LoadingView$ViewState r1 = com.jumio.defaultui.view.LoadingView.ViewState.ERROR
            if (r0 != r1) goto L_0x0027
        L_0x0024:
            r2.shutdown()
        L_0x0027:
            com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper.trackViewOnClick(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.JumioActivity.onClick(android.view.View):void");
    }

    public void onConfigurationChanged(Configuration configuration) {
        SplitUtil.INSTANCE.installSplitContext(this);
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i11 = 0;
        setFinishOnTouchOutside(false);
        initObservers();
        DataDogHelper.INSTANCE.attachActivity(this);
        if (!DeviceUtilKt.getDeviceUtil().isDebug(getApplicationContext())) {
            getWindow().addFlags(8192);
        }
        if (bundle == null) {
            getJumioViewModel().f56353a.k("defaultOrientation", Integer.valueOf(getRequestedOrientation()));
        }
        setContentView(R.layout.activity_jumio);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.root_container);
        this.rootContainer = constraintLayout;
        NavController navController2 = null;
        this.loadingView = new LoadingView(this, constraintLayout != null ? (FrameLayout) constraintLayout.findViewById(R.id.jumio_loadingView) : null);
        this.rotationManager = new DeviceRotationManager(this, Rotation.NATIVE);
        NavController uh2 = ((NavHostFragment) getSupportFragmentManager().l0(R.id.nav_host_fragment)).uh();
        this.navController = uh2;
        if (uh2 == null) {
            uh2 = null;
        }
        uh2.r(new ow.b(this));
        if (bundle != null) {
            int i12 = bundle.getInt("lastFragment", 0);
            NavController navController3 = this.navController;
            if (navController3 == null) {
                navController3 = null;
            }
            NavDestination D = navController3.D();
            if (D != null) {
                i11 = D.l();
            }
            if (!(i12 == 0 || i12 == R.id.blankFragment || i11 == i12)) {
                NavController navController4 = this.navController;
                if (navController4 != null) {
                    navController2 = navController4;
                }
                navController2.O(i12);
            }
        }
        ImageButton imageButton = (ImageButton) findViewById(R.id.ib_quit);
        this.btnQuit = imageButton;
        if (imageButton != null) {
            imageButton.setContentDescription(getString(R.string.jumio_accessibility_quit_scan));
        }
        ImageButton imageButton2 = this.btnQuit;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(this);
        }
        QAKt.getQA().getClass();
    }

    public void onDestroy() {
        getJumioViewModel().f56366n.removeObservers(this);
        getJumioViewModel().f56367o.removeObservers(this);
        getJumioViewModel().f56361i.removeObservers(this);
        Log.d("MobileActivity onDestroy");
        super.onDestroy();
    }

    @SuppressLint({"MissingSuperCall"})
    public void onNewIntent(Intent intent) {
        JumioScanPart j11;
        super.onNewIntent(intent);
        Uri data = intent.getData();
        if (data != null && (j11 = getJumioViewModel().j()) != null) {
            JumioDeepLinkHandler.INSTANCE.consumeForScanPart(data, j11);
        }
    }

    public void onPause() {
        super.onPause();
        LoadingView loadingView2 = this.loadingView;
        if (loadingView2 != null) {
            loadingView2.setPause(true);
        }
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        JumioScanStep jumioScanStep;
        LoadingView loadingView2;
        super.onRequestPermissionsResult(i11, strArr, iArr);
        if (i11 == 100) {
            if (!(!(iArr.length == 0)) || iArr[0] != 0) {
                jumio.dui.b jumioViewModel = getJumioViewModel();
                jumioViewModel.getClass();
                ErrorCase errorCase = ErrorCase.NO_CAMERA_CONNECTION;
                jumioViewModel.onError(new JumioError(errorCase.getRetry(), errorCase.getDomain(), "H00000", jumioViewModel.getApplication().getString(errorCase.getMessage())));
                return;
            }
            LoadingView loadingView3 = this.loadingView;
            if ((loadingView3 != null ? loadingView3.getViewState() : null) == LoadingView.ViewState.ERROR && (loadingView2 = this.loadingView) != null) {
                LoadingView.hide$default(loadingView2, (AnimatorListenerAdapter) null, 50, 0, 5, (Object) null);
            }
            if (getJumioViewModel().f56361i.getValue() == b.C0659b.SCAN && getJumioViewModel().f56362j.getValue() == (jumioScanStep = JumioScanStep.SCAN_VIEW)) {
                getJumioViewModel().f56362j.setValue(jumioScanStep);
            }
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        LoadingView.State state = (LoadingView.State) getJumioViewModel().f56353a.f("loadingViewState");
        if (state == null) {
            state = new LoadingView.State(LoadingView.ViewState.STOPPED, (String) null, (String) null, 0, (View.OnClickListener) null, 30, (r) null);
        }
        if (state.getViewState() != LoadingView.ViewState.PROGRESS) {
            return;
        }
        if (getJumioViewModel().f56361i.getValue() == b.C0659b.LOADING || getJumioViewModel().f56361i.getValue() == b.C0659b.UPLOAD) {
            LoadingView.State state2 = (LoadingView.State) getJumioViewModel().f56353a.f("loadingViewState");
            if (state2 == null) {
                state2 = new LoadingView.State(LoadingView.ViewState.STOPPED, (String) null, (String) null, 0, (View.OnClickListener) null, 30, (r) null);
            }
            updateLoadingState(state2);
        }
    }

    public void onResume() {
        super.onResume();
        ConstraintLayout constraintLayout = this.rootContainer;
        if (constraintLayout != null) {
            constraintLayout.post(new ow.c(this));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        LoadingView.State state;
        super.onSaveInstanceState(bundle);
        NavController navController2 = this.navController;
        if (navController2 == null) {
            navController2 = null;
        }
        NavDestination D = navController2.D();
        bundle.putInt("lastFragment", D != null ? D.l() : 0);
        jumio.dui.b jumioViewModel = getJumioViewModel();
        LoadingView loadingView2 = this.loadingView;
        if (loadingView2 == null || (state = loadingView2.getCurrentState$jumio_defaultui_release()) == null) {
            state = new LoadingView.State(LoadingView.ViewState.STOPPED, (String) null, (String) null, 0, (View.OnClickListener) null, 30, (r) null);
        }
        jumioViewModel.getClass();
        jumioViewModel.f56353a.k("loadingViewState", state);
    }

    public void retakeImage() {
        getJumioViewModel().f56361i.setValue(b.C0659b.SCAN);
    }

    public void setActionBarQuitIcon(int i11) {
        ImageButton imageButton = this.btnQuit;
        if (imageButton == null) {
            return;
        }
        if (i11 != 0) {
            imageButton.setImageResource(i11);
            ImageButton imageButton2 = this.btnQuit;
            if (imageButton2 != null) {
                imageButton2.setVisibility(0);
                return;
            }
            return;
        }
        imageButton.setVisibility(8);
    }

    public void setBackgroundColor(int i11) {
        ConstraintLayout constraintLayout = this.rootContainer;
        if (constraintLayout != null) {
            constraintLayout.setBackgroundColor(i11);
        }
    }

    public void setOrientation(Integer num) {
        int i11;
        if (!x.b(num, (Integer) getJumioViewModel().f56353a.f("currentOrientation"))) {
            getJumioViewModel().f56353a.k("currentOrientation", num);
            if (num != null) {
                i11 = num.intValue();
            } else {
                Integer num2 = (Integer) getJumioViewModel().f56353a.f("defaultOrientation");
                i11 = num2 != null ? num2.intValue() : -1;
            }
            setRequestedOrientation(i11);
        }
    }

    public void setUiAutomationString(String str) {
        View findViewById = findViewById(R.id.nav_host_fragment);
        if (findViewById != null) {
            if (!(str == null || str.length() == 0)) {
                findViewById.setContentDescription(str);
            }
        }
    }

    public void skipAddonPart() {
        jumio.dui.b jumioViewModel = getJumioViewModel();
        jumioViewModel.a();
        jumioViewModel.b();
    }

    public void startCountrySelection() {
        getJumioViewModel().f56361i.setValue(b.C0659b.SELECTION_COUNTRY);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.jumio.sdk.enums.JumioCredentialPart} */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r3 = r3.getUnconsentedItems();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startUserJourney() {
        /*
            r8 = this;
            java.lang.String r0 = "currentCredentialInfo"
            java.lang.String r1 = "JumioViewModel"
            jumio.dui.b r2 = r8.getJumioViewModel()
            com.jumio.sdk.controller.JumioController r3 = r2.f56356d
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x001d
            java.util.List r3 = r3.getUnconsentedItems()
            if (r3 == 0) goto L_0x001d
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r5
            if (r3 != r5) goto L_0x001d
            r3 = r5
            goto L_0x001e
        L_0x001d:
            r3 = r4
        L_0x001e:
            if (r3 == 0) goto L_0x0022
            goto L_0x00c1
        L_0x0022:
            r3 = 0
            com.jumio.sdk.credentials.JumioCredential r6 = r2.f56358f     // Catch:{ Exception -> 0x002b }
            if (r6 == 0) goto L_0x0037
            r6.cancel()     // Catch:{ Exception -> 0x002b }
            goto L_0x0037
        L_0x002b:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()     // Catch:{ IllegalArgumentException -> 0x005b }
            if (r6 != 0) goto L_0x0034
            java.lang.String r6 = "credential cancel failed"
        L_0x0034:
            com.jumio.commons.log.Log.w((java.lang.String) r1, (java.lang.String) r6)     // Catch:{ IllegalArgumentException -> 0x005b }
        L_0x0037:
            java.util.List<com.jumio.sdk.credentials.JumioCredentialInfo> r6 = r2.f56357e     // Catch:{ IllegalArgumentException -> 0x005b }
            java.lang.Object r6 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r6)     // Catch:{ IllegalArgumentException -> 0x005b }
            com.jumio.sdk.credentials.JumioCredentialInfo r6 = (com.jumio.sdk.credentials.JumioCredentialInfo) r6     // Catch:{ IllegalArgumentException -> 0x005b }
            androidx.lifecycle.SavedStateHandle r7 = r2.f56353a     // Catch:{ IllegalArgumentException -> 0x005b }
            r7.k(r0, r6)     // Catch:{ IllegalArgumentException -> 0x005b }
            androidx.lifecycle.SavedStateHandle r6 = r2.f56353a     // Catch:{ IllegalArgumentException -> 0x005b }
            java.lang.Object r0 = r6.f(r0)     // Catch:{ IllegalArgumentException -> 0x005b }
            com.jumio.sdk.credentials.JumioCredentialInfo r0 = (com.jumio.sdk.credentials.JumioCredentialInfo) r0     // Catch:{ IllegalArgumentException -> 0x005b }
            if (r0 == 0) goto L_0x0057
            com.jumio.sdk.controller.JumioController r6 = r2.f56356d     // Catch:{ IllegalArgumentException -> 0x005b }
            if (r6 == 0) goto L_0x0057
            com.jumio.sdk.credentials.JumioCredential r0 = r6.start(r0)     // Catch:{ IllegalArgumentException -> 0x005b }
            goto L_0x0058
        L_0x0057:
            r0 = r3
        L_0x0058:
            r2.f56358f = r0     // Catch:{ IllegalArgumentException -> 0x005b }
            goto L_0x005f
        L_0x005b:
            r0 = move-exception
            com.jumio.commons.log.Log.w((java.lang.String) r1, (java.lang.Throwable) r0)
        L_0x005f:
            com.jumio.sdk.credentials.JumioCredential r0 = r2.f56358f
            if (r0 == 0) goto L_0x006a
            boolean r0 = r0.isConfigured()
            if (r0 != r5) goto L_0x006a
            r4 = r5
        L_0x006a:
            if (r4 == 0) goto L_0x00be
            androidx.lifecycle.SavedStateHandle r0 = r2.f56353a
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            java.lang.String r4 = "currentSelectionSkipped"
            r0.k(r4, r1)
            com.jumio.sdk.credentials.JumioCredential r0 = r2.f56358f
            boolean r1 = r0 instanceof com.jumio.sdk.credentials.JumioIDCredential
            if (r1 == 0) goto L_0x007e
            com.jumio.sdk.credentials.JumioIDCredential r0 = (com.jumio.sdk.credentials.JumioIDCredential) r0
            goto L_0x007f
        L_0x007e:
            r0 = r3
        L_0x007f:
            if (r0 == 0) goto L_0x009e
            java.util.List r1 = r0.getSupportedCountries()
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.a0(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.util.List r4 = r0.getPhysicalDocumentsForCountry(r1)
            int r6 = r4.size()
            if (r6 != r5) goto L_0x009e
            java.lang.Object r4 = kotlin.collections.CollectionsKt___CollectionsKt.a0(r4)
            com.jumio.sdk.document.JumioDocument r4 = (com.jumio.sdk.document.JumioDocument) r4
            r2.a(r0, r1, r4)
        L_0x009e:
            com.jumio.sdk.credentials.JumioCredential r0 = r2.f56358f
            if (r0 == 0) goto L_0x00af
            java.util.List r0 = r0.getCredentialParts()
            if (r0 == 0) goto L_0x00af
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.a0(r0)
            r3 = r0
            com.jumio.sdk.enums.JumioCredentialPart r3 = (com.jumio.sdk.enums.JumioCredentialPart) r3
        L_0x00af:
            androidx.lifecycle.SavedStateHandle r0 = r2.f56353a
            java.lang.String r1 = "currentCredentialPart"
            r0.k(r1, r3)
            com.jumio.sdk.enums.JumioCredentialPart r0 = r2.e()
            r2.a((com.jumio.sdk.enums.JumioCredentialPart) r0)
            goto L_0x00c1
        L_0x00be:
            r2.q()
        L_0x00c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.JumioActivity.startUserJourney():void");
    }

    public void updateLoadingState(LoadingView.State state) {
        LoadingView loadingView2 = this.loadingView;
        if (loadingView2 != null) {
            LoadingView.show$default(loadingView2, (AnimatorListenerAdapter) null, 50, 0, 5, (Object) null);
        }
        LoadingView loadingView3 = this.loadingView;
        if (loadingView3 != null) {
            loadingView3.update(state);
        }
    }

    public boolean validatePermissions() {
        JumioSDK.Companion companion = JumioSDK.Companion;
        if (companion.hasAllRequiredPermissions(this)) {
            return true;
        }
        ActivityCompat.requestPermissions(this, companion.getMissingPermissions(this), 100);
        return false;
    }
}
