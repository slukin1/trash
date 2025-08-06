package com.huobi.kyc.huaweiliveness.activity;

import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.utils.AppUtil;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huawei.face.antispoofing.exception.ValidateException;
import com.huawei.face.antispoofing.listener.FaceAntispoofingResultListener;
import com.huawei.face.antispoofing.meta.DetectErrorEnum;
import com.huawei.face.antispoofing.meta.DetectResult;
import com.huawei.face.antispoofing.meta.DetectTypeEnum;
import com.huawei.face.antispoofing.sdk.FaceAntispoofingSdk;
import com.huawei.face.antispoofing.utils.ThreadUtils;
import com.huobi.kyc.huaweiliveness.camera.CameraSurfaceView;
import com.huobi.kyc.huaweiliveness.camera.a;
import com.huobi.kyc.huaweiliveness.meta.ValidateResult;
import com.huobi.kyc.huaweiliveness.view.ProgressView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.k;
import java.util.concurrent.atomic.AtomicBoolean;
import pro.huobi.R;
import sm.a;

public class FaceAntispoofingActivity extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f74780b;

    /* renamed from: c  reason: collision with root package name */
    public tm.a f74781c;

    /* renamed from: d  reason: collision with root package name */
    public CameraSurfaceView f74782d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f74783e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f74784f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    public ProgressView f74785g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicBoolean f74786h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f74787i = false;

    /* renamed from: j  reason: collision with root package name */
    public FaceAntispoofingResultListener f74788j = new b();

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f74789a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huawei.face.antispoofing.meta.DetectTypeEnum[] r0 = com.huawei.face.antispoofing.meta.DetectTypeEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f74789a = r0
                com.huawei.face.antispoofing.meta.DetectTypeEnum r1 = com.huawei.face.antispoofing.meta.DetectTypeEnum.turn_left     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f74789a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huawei.face.antispoofing.meta.DetectTypeEnum r1 = com.huawei.face.antispoofing.meta.DetectTypeEnum.turn_right     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f74789a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huawei.face.antispoofing.meta.DetectTypeEnum r1 = com.huawei.face.antispoofing.meta.DetectTypeEnum.nod     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f74789a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huawei.face.antispoofing.meta.DetectTypeEnum r1 = com.huawei.face.antispoofing.meta.DetectTypeEnum.open_mouth     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f74789a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huawei.face.antispoofing.meta.DetectTypeEnum r1 = com.huawei.face.antispoofing.meta.DetectTypeEnum.blink_eye     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.kyc.huaweiliveness.activity.FaceAntispoofingActivity.a.<clinit>():void");
        }
    }

    public class b implements FaceAntispoofingResultListener {
        public b() {
        }

        public void onDetectChange(DetectTypeEnum detectTypeEnum) {
            k.o("huawei_liveness", AppUtil.b("faceAntispoofingResultListener onDetectChange=", detectTypeEnum.getDesc()));
            if (FaceAntispoofingActivity.this.f74783e != null) {
                int i11 = a.f74789a[detectTypeEnum.ordinal()];
                if (i11 == 1) {
                    FaceAntispoofingActivity.this.f74783e.setText("Please turn your head slowly to the left");
                } else if (i11 == 2) {
                    FaceAntispoofingActivity.this.f74783e.setText("Please turn your head slowly to the right");
                } else if (i11 == 3) {
                    FaceAntispoofingActivity.this.f74783e.setText("Please nod slowly");
                } else if (i11 == 4) {
                    FaceAntispoofingActivity.this.f74783e.setText(FaceAntispoofingActivity.this.getString(R.string.n_kyc_huawei_liveness_open_mouth));
                } else if (i11 == 5) {
                    FaceAntispoofingActivity.this.f74783e.setText(FaceAntispoofingActivity.this.getString(R.string.n_kyc_huawei_liveness_blink));
                }
            }
        }

        public void onDetectFinish(DetectResult detectResult) {
            FaceAntispoofingActivity.this.Ah(false);
            k.o("huawei_liveness", AppUtil.b("faceAntispoofingResultListener onDetectFinish start:", Boolean.valueOf(detectResult.isDetected()), " errorMsg:", detectResult.getErrorMsg(), " detectError:", detectResult.getDetectError()));
            if (detectResult.isDetected()) {
                FaceAntispoofingActivity.this.wh(DetectResult.success(detectResult.getData()));
            } else {
                FaceAntispoofingActivity.this.xh(detectResult.getErrorMsg());
            }
        }

        public void onDetectLocalFinish(DetectResult detectResult) {
            k.o("huawei_liveness", "faceAntispoofingResultListener onDetectLocalFinish start.");
            FaceAntispoofingActivity.this.Ah(true);
        }

        public void onDetectTimeOut() {
            k.o("huawei_liveness", "faceAntispoofingResultListener onDetectTimeOut start.");
            FaceAntispoofingActivity.this.yh();
        }

        public void onDetecting(int i11, String str) {
            k.o("huawei_liveness", AppUtil.b("faceAntispoofingResultListener errorCode=", Integer.valueOf(i11)));
            FaceAntispoofingActivity.this.Bh(str);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            FaceAntispoofingActivity.this.finish();
            FaceAntispoofingActivity.this.onBackPressed();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public d() {
        }

        public void onGlobalLayout() {
            int width = FaceAntispoofingActivity.this.f74782d.getWidth();
            int height = FaceAntispoofingActivity.this.f74782d.getHeight();
            int width2 = FaceAntispoofingActivity.this.f74780b.getWidth();
            int height2 = FaceAntispoofingActivity.this.f74780b.getHeight();
            if (width2 != width || height2 != height) {
                FaceAntispoofingActivity.this.f74780b.setLayoutParams(new FrameLayout.LayoutParams(width, height));
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrameLayout f74793b;

        public e(FrameLayout frameLayout) {
            this.f74793b = frameLayout;
        }

        public void run() {
            DisplayMetrics displayMetrics = FaceAntispoofingActivity.this.getResources().getDisplayMetrics();
            int i11 = ((int) (((double) displayMetrics.widthPixels) * 0.7d)) / 2;
            int i12 = i11 + 200;
            ColorDrawable colorDrawable = new ColorDrawable(-1);
            colorDrawable.setBounds(new Rect(this.f74793b.getLeft(), this.f74793b.getTop(), this.f74793b.getRight(), this.f74793b.getBottom()));
            tm.a unused = FaceAntispoofingActivity.this.f74781c = new tm.a(colorDrawable, FaceAntispoofingActivity.this, displayMetrics.widthPixels / 2, i12, i11);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) FaceAntispoofingActivity.this.f74783e.getLayoutParams();
            layoutParams.topMargin = (i11 * 2) + 200 + 200;
            FaceAntispoofingActivity.this.f74783e.setLayoutParams(layoutParams);
            this.f74793b.setBackground(FaceAntispoofingActivity.this.f74781c);
            ProgressView unused2 = FaceAntispoofingActivity.this.f74785g = new ProgressView(FaceAntispoofingActivity.this);
            this.f74793b.addView(FaceAntispoofingActivity.this.f74785g, new FrameLayout.LayoutParams(-1, -1));
            FaceAntispoofingActivity.this.f74785g.g(displayMetrics.widthPixels / 2, i12, i11);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void run() {
            FaceAntispoofingActivity.this.wh(DetectResult.failed(DetectErrorEnum.VerifyErrorSDKInitError, "sdk init error"));
        }
    }

    public class g implements a.c {
        public g() {
        }

        public void a(byte[] bArr, int i11, int i12) {
            if (!FaceAntispoofingActivity.this.f74786h.get()) {
                FaceAntispoofingSdk.getInstance().onDetect(bArr, i11, i12);
            }
        }
    }

    public class h implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f74797b;

        public h(boolean z11) {
            this.f74797b = z11;
        }

        public void run() {
            if (this.f74797b) {
                FaceAntispoofingActivity.this.f74785g.setVisibility(0);
            } else {
                FaceAntispoofingActivity.this.f74785g.setVisibility(8);
            }
        }
    }

    public class i implements Runnable {
        public i() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            FaceAntispoofingActivity.this.wh(DetectResult.failed(DetectErrorEnum.VerifyErrorCancel));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            FaceAntispoofingSdk.getInstance().restartSession();
            FaceAntispoofingActivity.this.zh(false);
        }

        public void run() {
            FaceAntispoofingActivity faceAntispoofingActivity = FaceAntispoofingActivity.this;
            DialogUtils.c0(faceAntispoofingActivity, faceAntispoofingActivity.getString(R.string.n_kyc_huawei_liveness_fail), "", FaceAntispoofingActivity.this.getString(R.string.n_cancel), FaceAntispoofingActivity.this.getString(R.string.n_otc_go_try_again), new rm.a(this), new rm.b(this));
        }
    }

    public class j implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f74800b;

        public j(String str) {
            this.f74800b = str;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(String str, HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            FaceAntispoofingActivity.this.wh(DetectResult.failed(DetectErrorEnum.VerifyErrorServerError, str));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            FaceAntispoofingActivity.this.zh(false);
            FaceAntispoofingSdk.getInstance().restartSession();
            FaceAntispoofingActivity.this.f74780b.setVisibility(4);
        }

        public void run() {
            FaceAntispoofingActivity faceAntispoofingActivity = FaceAntispoofingActivity.this;
            DialogUtils.c0(faceAntispoofingActivity, faceAntispoofingActivity.getString(R.string.n_kyc_huawei_liveness_fail), "", FaceAntispoofingActivity.this.getString(R.string.n_cancel), FaceAntispoofingActivity.this.getString(R.string.n_otc_go_try_again), new rm.d(this, this.f74800b), new rm.c(this));
        }
    }

    public void Ah(boolean z11) {
        if (this.f74785g != null) {
            ThreadUtils.getInstance().runOnUiThread(new h(z11));
        }
    }

    public void Bh(String str) {
        tm.a aVar = this.f74781c;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public int getContentView() {
        getWindow().addFlags(128);
        return R.layout.activity_face_antispoofing_detect;
    }

    public int getStatusBarColor() {
        return getResources().getColor(R.color.white);
    }

    public final void init() {
        this.f74782d = (CameraSurfaceView) findViewById(R.id.face_view);
        this.f74783e = (TextView) findViewById(R.id.detection_type);
        this.f74780b = (ImageView) findViewById(R.id.fixed_face_view);
        this.f74782d.getViewTreeObserver().addOnGlobalLayoutListener(new d());
        this.f74783e.post(new e((FrameLayout) findViewById(R.id.head_cover)));
        th();
    }

    public boolean isLightStatusBar() {
        return false;
    }

    public void onBackPressed() {
        super.onBackPressed();
        vh();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (sm.b.a(this)) {
            init();
        }
        findViewById(R.id.rl_close).setOnClickListener(new c());
    }

    public void onDestroy() {
        super.onDestroy();
        sh();
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i11, strArr, iArr);
        if (iArr.length > 0) {
            for (int i12 : iArr) {
                if (i12 == -1) {
                    HuobiToastUtil.g(R.string.n_kyc_huawei_liveness_permission_hint);
                    wh(DetectResult.failed(DetectErrorEnum.VerifyErrorCancel));
                    return;
                }
            }
            init();
        }
    }

    public void onResume() {
        super.onResume();
        if (!FaceAntispoofingSdk.getInstance().isInitializedSucceed()) {
            ThreadUtils.getInstance().runOnUiPostDelayed(new f(), 1000);
        }
    }

    public final void sh() {
        if (!this.f74787i) {
            FaceAntispoofingSdk.getInstance().stopSession();
            this.f74787i = true;
        }
    }

    public final synchronized void th() {
        if (!this.f74784f.get()) {
            this.f74782d.setPreviewDataCallback(new g());
            try {
                FaceAntispoofingSdk.getInstance().startNewSession(this.f74788j);
            } catch (ValidateException e11) {
                wh(ValidateResult.validate(e11.getCode()));
            }
            this.f74786h = new AtomicBoolean(false);
            this.f74784f.set(true);
        }
    }

    public final boolean uh() {
        return this.f74786h.get();
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public void vh() {
        wh(DetectResult.failed(DetectErrorEnum.VerifyErrorCancel));
    }

    public final void wh(DetectResult detectResult) {
        finish();
        a.C0821a a11 = sm.a.a();
        if (a11 != null) {
            if (detectResult instanceof ValidateResult) {
                a11.a(false, (String) null, ((ValidateResult) detectResult).getValidateResult().getMessage());
            } else if (!detectResult.isDetected() || TextUtils.isEmpty(detectResult.getData())) {
                a11.a(false, (String) null, detectResult.getErrorMsg());
            } else {
                a11.a(true, detectResult.getData(), (String) null);
            }
        }
    }

    public final void xh(String str) {
        if (!uh()) {
            zh(true);
            ThreadUtils.getInstance().runOnUiThread(new j(str));
        }
    }

    public final void yh() {
        if (!uh()) {
            zh(true);
            ThreadUtils.getInstance().runOnUiThread(new i());
        }
    }

    public final void zh(boolean z11) {
        this.f74786h.set(z11);
    }
}
