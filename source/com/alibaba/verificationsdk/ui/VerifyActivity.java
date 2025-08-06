package com.alibaba.verificationsdk.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.verificationsdk.BuildConfig;
import com.alibaba.verificationsdk.bean.ResConfig;
import com.alibaba.verificationsdk.utils.DownLoaderTask;
import com.alibaba.verificationsdk.utils.DownloadListener;
import com.alibaba.verificationsdk.utils.FileUtil;
import com.alibaba.verificationsdk.utils.Log;
import com.alibaba.verificationsdk.utils.VersionUtil;
import com.alibaba.verificationsdk.utils.ZIPExtracListener;
import com.alibaba.verificationsdk.utils.ZipExtractorTask;
import com.alibaba.verificationsdk.widgets.ALiLoadingView;
import com.alibaba.verificationsdk.widgets.BallView;
import com.alibaba.verificationsdk.widgets.DrawView;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent;
import com.alibaba.wireless.security.open.umid.IUMIDInitListenerEx;
import com.hbg.lib.network.hbg.socket.response.BaseHbgResponse;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huochat.community.util.FileTool;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.tencent.ugc.videoprocessor.watermark.data.AnimatedPasterJsonConfig;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class VerifyActivity extends Activity {
    public static final int ALIAUTH_CLIENT_ERROR_GENERIC = 50000;
    public static final int ALIAUTH_SERVICE_ERROR_MAXTRY = 60000;
    public static final String APP_DATA = "app_data";
    /* access modifiers changed from: private */
    public static String AUTHCODE = null;
    /* access modifiers changed from: private */
    public static String CAPTCHA_TYPE = "captcha_type";
    public static String DAILY = "DAILY";
    /* access modifiers changed from: private */
    public static String DEVICE_TYPE = "device_type";
    /* access modifiers changed from: private */
    public static String DPI = "dpi";
    /* access modifiers changed from: private */
    public static String EXTEND_DATA = "extend_data";
    private static final String HOSTENV = "HOSTENV";
    private static final String INFO_TOKEN = "info_token";
    private static final int INIT_START = 10000;
    /* access modifiers changed from: private */
    public static String LANG = "lang";
    private static final String LOG_TAG = "VerifyActivity";
    public static String ONLINE = "";
    private static final String PHONE = "phone";
    /* access modifiers changed from: private */
    public static String PHONE_NUMBER = "phone_number";
    public static String PREONLINE = "PREONLINE";
    private static final int RES_REQUEST_END = 100026;
    private static final int RES_REQUEST_FAILED = 100025;
    private static final int RES_REQUEST_START = 100023;
    private static final int RES_REQUEST_SUCC = 100024;
    /* access modifiers changed from: private */
    public static String RES_ROOT_PATH = null;
    private static final int RETRY_COUNT = 3;
    /* access modifiers changed from: private */
    public static String SESSION_ID = "session_id";
    private static final int SMS_CALL_REQUEST_FAILED = 100015;
    private static final int SMS_CALL_REQUEST_START = 100013;
    private static final int SMS_CALL_REQUEST_SUCC = 100014;
    private static final int SMS_CALL_VERIFY_FAILED = 100005;
    private static final int SMS_CALL_VERIFY_START = 100003;
    private static final int SMS_CALL_VERIFY_SUCC = 100004;
    /* access modifiers changed from: private */
    public static String USERINPUTCAPTCHA = "userInputCaptcha";
    private static final int VERIFY_ANIMATION_END = 10002;
    private static final int VERIFY_ANIMATION_START = 10001;
    public static final int VERIFY_FAILED = 0;
    private static final int VERIFY_IN_BOUND = 100001;
    private static final int VERIFY_OUT_BOUND = 100002;
    private static final int VERIFY_START = 10003;
    public static final int VERIFY_SUCC = 1;
    public static String VERSION = "1.3.3.-3ND-SMS-NC";
    private static String appkey = null;
    /* access modifiers changed from: private */
    public static String asfKey = null;
    /* access modifiers changed from: private */
    public static IActivityCallback callback = null;
    /* access modifiers changed from: private */
    public static String hostenv = null;
    /* access modifiers changed from: private */
    public static String info_token = null;
    /* access modifiers changed from: private */
    public static int mScreenHeight = 0;
    /* access modifiers changed from: private */
    public static int mScreenWidth = 0;
    /* access modifiers changed from: private */
    public static String number = null;
    private static int retryCount = 3;
    public static boolean sgInited = false;
    private static Activity verifyActivity;
    /* access modifiers changed from: private */
    public static VerifyType verifyType;
    /* access modifiers changed from: private */
    public ALiLoadingView aLiLoadingView;
    private View back = null;
    /* access modifiers changed from: private */
    public View btnCall = null;
    /* access modifiers changed from: private */
    public View btnSubmit = null;
    /* access modifiers changed from: private */
    public LinearLayout content;
    /* access modifiers changed from: private */
    public BallView draw = null;
    /* access modifiers changed from: private */
    public EditText etCode = null;
    private EditText etNumber = null;
    public Runnable finishTask = new Runnable() {
        public void run() {
            VerifyActivity.this.finish();
        }
    };
    /* access modifiers changed from: private */
    public DrawView frame = null;
    public Handler handler = new Handler() {
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0245  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x024b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r24) {
            /*
                r23 = this;
                r1 = r23
                android.os.Bundle r0 = r24.getData()
                java.util.HashMap r2 = new java.util.HashMap
                r2.<init>()
                java.lang.String r3 = "status"
                int r3 = r0.getInt(r3)
                java.lang.String r4 = "errorCode"
                int r5 = r0.getInt(r4)
                java.lang.String r6 = "x1"
                float r6 = r0.getFloat(r6)
                java.lang.String r7 = "y1"
                float r7 = r0.getFloat(r7)
                java.lang.String r8 = "x2"
                float r8 = r0.getFloat(r8)
                java.lang.String r9 = "y2"
                float r9 = r0.getFloat(r9)
                java.lang.String r10 = "token"
                java.lang.String r10 = r0.getString(r10)
                java.lang.String r11 = "sig"
                java.lang.String r11 = r0.getString(r11)
                java.lang.String r12 = "sessionId"
                java.lang.String r0 = r0.getString(r12)
                r12 = 4
                java.lang.Object[] r13 = new java.lang.Object[r12]
                r14 = 0
                r13[r14] = r10
                r15 = 1
                r13[r15] = r11
                r12 = 2
                r13[r12] = r0
                java.lang.String r16 = com.alibaba.verificationsdk.ui.VerifyActivity.asfKey
                r14 = 3
                r13[r14] = r16
                java.lang.String r14 = "nc1-%s-nc2-%s-nc3-%s-nc4-%s"
                java.lang.String r13 = java.lang.String.format(r14, r13)
                r14 = r24
                int r14 = r14.what
                java.lang.String r12 = "ali_vsdk_network_error"
                java.lang.String r15 = "NC_VERI_RETRY"
                r17 = r9
                java.lang.String r9 = "string"
                r18 = r8
                java.lang.String r8 = "sessionID"
                r19 = r7
                java.lang.String r7 = "drawable"
                r20 = r6
                java.lang.String r6 = "VerifyActivity"
                r21 = r15
                r15 = 1
                if (r14 == r15) goto L_0x04a6
                r15 = r10
                r22 = r11
                r10 = 2
                if (r14 == r10) goto L_0x0290
                switch(r14) {
                    case 10000: goto L_0x015c;
                    case 10001: goto L_0x0110;
                    case 10002: goto L_0x00c4;
                    case 10003: goto L_0x00af;
                    default: goto L_0x0080;
                }
            L_0x0080:
                switch(r14) {
                    case 100001: goto L_0x009a;
                    case 100002: goto L_0x0085;
                    default: goto L_0x0083;
                }
            L_0x0083:
                goto L_0x0686
            L_0x0085:
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.DrawView r0 = r0.frame
                r2 = 0
                r0.setStatus(r2)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.DrawView r0 = r0.frame
                r0.invalidate()
                goto L_0x0686
            L_0x009a:
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.DrawView r0 = r0.frame
                r2 = 1
                r0.setStatus(r2)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.DrawView r0 = r0.frame
                r0.invalidate()
                goto L_0x0686
            L_0x00af:
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this     // Catch:{ Exception -> 0x00be }
                com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent r0 = r0.ncComponent     // Catch:{ Exception -> 0x00be }
                java.lang.String r2 = com.alibaba.verificationsdk.ui.VerifyActivity.asfKey     // Catch:{ Exception -> 0x00be }
                r0.noCaptchaVerification(r2)     // Catch:{ Exception -> 0x00be }
                goto L_0x0686
            L_0x00be:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0686
            L_0x00c4:
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.DrawView r0 = r0.frame
                r2 = 3
                r0.setStatus(r2)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.DrawView r0 = r0.frame
                r0.invalidate()
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.BallView r0 = r0.draw
                r2 = 2
                r0.setStatus(r2)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.BallView r0 = r0.draw
                com.alibaba.verificationsdk.ui.VerifyActivity r2 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.DrawView r2 = r2.frame
                float r2 = r2.getCenterX1()
                com.alibaba.verificationsdk.ui.VerifyActivity r3 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.DrawView r3 = r3.frame
                float r3 = r3.getCenterY1()
                r0.setPositionEnd(r2, r3)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.BallView r0 = r0.draw
                r0.invalidate()
                r0 = 10003(0x2713, float:1.4017E-41)
                r2 = 300(0x12c, double:1.48E-321)
                r1.sendEmptyMessageDelayed(r0, r2)
                goto L_0x0686
            L_0x0110:
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.DrawView r0 = r0.frame
                r2 = 2
                r0.setStatus(r2)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.DrawView r0 = r0.frame
                r0.invalidate()
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.BallView r0 = r0.draw
                r2 = 1
                r0.setStatus(r2)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.BallView r0 = r0.draw
                com.alibaba.verificationsdk.ui.VerifyActivity r2 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.DrawView r2 = r2.frame
                float r2 = r2.getCenterX()
                com.alibaba.verificationsdk.ui.VerifyActivity r3 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.DrawView r3 = r3.frame
                float r3 = r3.getCenterY()
                r0.setPositionFinish(r2, r3)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.BallView r0 = r0.draw
                r0.invalidate()
                r0 = 10002(0x2712, float:1.4016E-41)
                r2 = 200(0xc8, double:9.9E-322)
                r1.sendEmptyMessageDelayed(r0, r2)
                goto L_0x0686
            L_0x015c:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "INIT_START root.getTop(): "
                r0.append(r2)
                com.alibaba.verificationsdk.ui.VerifyActivity r2 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.widget.FrameLayout r2 = r2.root
                int r2 = r2.getTop()
                r0.append(r2)
                java.lang.String r2 = " root.getBottom(): "
                r0.append(r2)
                com.alibaba.verificationsdk.ui.VerifyActivity r2 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.widget.FrameLayout r2 = r2.root
                int r2 = r2.getBottom()
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                com.alibaba.verificationsdk.utils.Log.i(r6, r0)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.content.res.Resources r0 = r0.getResources()
                com.alibaba.verificationsdk.ui.VerifyActivity r2 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.content.res.Resources r2 = r2.getResources()
                com.alibaba.verificationsdk.ui.VerifyActivity r3 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                java.lang.String r3 = r3.getPackageName()
                java.lang.String r4 = "ali_vsdk_frame"
                int r2 = r2.getIdentifier(r4, r7, r3)
                android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeResource(r0, r2)
                r2 = 290(0x122, float:4.06E-43)
                if (r0 == 0) goto L_0x01b0
                int r2 = r0.getWidth()
            L_0x01b0:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r3 = "INIT_START radius: "
                r0.append(r3)
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                com.alibaba.verificationsdk.utils.Log.i(r6, r0)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.widget.FrameLayout r0 = r0.root
                int r0 = r0.getBottom()
                if (r0 > 0) goto L_0x01fb
                int r0 = com.alibaba.verificationsdk.ui.VerifyActivity.mScreenHeight
                com.alibaba.verificationsdk.ui.VerifyActivity r3 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                int r3 = r3.getStatusBarHeight()
                int r0 = r0 - r3
                int r0 = r0 + -112
                if (r0 <= r2) goto L_0x01ed
                int r0 = com.alibaba.verificationsdk.ui.VerifyActivity.mScreenHeight
                com.alibaba.verificationsdk.ui.VerifyActivity r3 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                int r3 = r3.getStatusBarHeight()
                int r0 = r0 - r3
                int r0 = r0 + -112
                goto L_0x0227
            L_0x01ed:
                int r0 = com.alibaba.verificationsdk.ui.VerifyActivity.mScreenHeight
                com.alibaba.verificationsdk.ui.VerifyActivity r3 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                int r3 = r3.getStatusBarHeight()
                int r0 = r0 - r3
                int r0 = r0 + -112
                goto L_0x023e
            L_0x01fb:
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.widget.FrameLayout r0 = r0.root
                int r0 = r0.getBottom()
                com.alibaba.verificationsdk.ui.VerifyActivity r3 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.widget.FrameLayout r3 = r3.root
                int r3 = r3.getTop()
                int r0 = r0 - r3
                if (r0 <= r2) goto L_0x0229
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.widget.FrameLayout r0 = r0.root
                int r0 = r0.getBottom()
                com.alibaba.verificationsdk.ui.VerifyActivity r3 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.widget.FrameLayout r3 = r3.root
                int r3 = r3.getTop()
                int r0 = r0 - r3
            L_0x0227:
                int r0 = r0 - r2
                goto L_0x023e
            L_0x0229:
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.widget.FrameLayout r0 = r0.root
                int r0 = r0.getBottom()
                com.alibaba.verificationsdk.ui.VerifyActivity r3 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.widget.FrameLayout r3 = r3.root
                int r3 = r3.getTop()
                int r0 = r0 - r3
            L_0x023e:
                r11 = r0
                int r0 = com.alibaba.verificationsdk.ui.VerifyActivity.mScreenWidth
                if (r0 <= r2) goto L_0x024b
                int r0 = com.alibaba.verificationsdk.ui.VerifyActivity.mScreenWidth
                int r0 = r0 - r2
                goto L_0x024f
            L_0x024b:
                int r0 = com.alibaba.verificationsdk.ui.VerifyActivity.mScreenWidth
            L_0x024f:
                r10 = r0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "INIT_START width: "
                r0.append(r2)
                r0.append(r10)
                java.lang.String r2 = " height: "
                r0.append(r2)
                r0.append(r11)
                java.lang.String r0 = r0.toString()
                com.alibaba.verificationsdk.utils.Log.i(r6, r0)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this     // Catch:{ Exception -> 0x028a }
                com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent r7 = r0.ncComponent     // Catch:{ Exception -> 0x028a }
                java.lang.String r8 = com.alibaba.verificationsdk.ui.VerifyActivity.asfKey     // Catch:{ Exception -> 0x028a }
                java.lang.Class<com.alibaba.verificationsdk.ui.VerifyActivity> r0 = com.alibaba.verificationsdk.ui.VerifyActivity.class
                java.lang.String r9 = r0.getSimpleName()     // Catch:{ Exception -> 0x028a }
                r12 = 5
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this     // Catch:{ Exception -> 0x028a }
                android.os.Handler r13 = r0.handler     // Catch:{ Exception -> 0x028a }
                java.lang.String r14 = com.alibaba.verificationsdk.ui.VerifyActivity.AUTHCODE     // Catch:{ Exception -> 0x028a }
                r7.initNoCaptcha(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x028a }
                goto L_0x0686
            L_0x028a:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0686
            L_0x0290:
                switch(r3) {
                    case 100: goto L_0x049f;
                    case 101: goto L_0x0293;
                    case 102: goto L_0x03ec;
                    case 103: goto L_0x0340;
                    case 104: goto L_0x02fc;
                    case 105: goto L_0x0295;
                    default: goto L_0x0293;
                }
            L_0x0293:
                goto L_0x0686
            L_0x0295:
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.ui.VerifyActivity$RefreshCountDownTimer r0 = r0.refreshCountDownTimer
                r0.cancel()
                com.alibaba.verificationsdk.ui.IActivityCallback r0 = com.alibaba.verificationsdk.ui.VerifyActivity.callback
                if (r0 == 0) goto L_0x02ba
                java.lang.String r0 = java.lang.String.valueOf(r5)
                r2.put(r4, r0)
                com.alibaba.verificationsdk.ui.IActivityCallback r0 = com.alibaba.verificationsdk.ui.VerifyActivity.callback
                com.alibaba.verificationsdk.ui.VerifyActivity r4 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                r7 = 105(0x69, float:1.47E-43)
                int r4 = r4.map2GenericCode(r7)
                r0.onResult(r4, r2)
            L_0x02ba:
                r0 = 1207(0x4b7, float:1.691E-42)
                if (r0 != r5) goto L_0x02db
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.content.res.Resources r2 = r0.getResources()
                com.alibaba.verificationsdk.ui.VerifyActivity r4 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                java.lang.String r4 = r4.getPackageName()
                int r2 = r2.getIdentifier(r12, r9, r4)
                java.lang.String r2 = r0.getString(r2)
                r4 = 1
                android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r4)
                r0.show()
                goto L_0x02dc
            L_0x02db:
                r4 = 1
            L_0x02dc:
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                r0.finish()
                r0 = 2
                java.lang.Object[] r0 = new java.lang.Object[r0]
                java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
                r3 = 0
                r0[r3] = r2
                java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
                r0[r4] = r2
                java.lang.String r2 = "Verify stage:SG_NC_FAILED: status=%d,errorCode=%d"
                java.lang.String r0 = java.lang.String.format(r2, r0)
                com.alibaba.verificationsdk.utils.Log.i(r6, r0)
                goto L_0x0686
            L_0x02fc:
                r4 = 1
                com.alibaba.verificationsdk.ui.VerifyActivity r5 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.ui.VerifyActivity$RefreshCountDownTimer r5 = r5.refreshCountDownTimer
                r5.cancel()
                r5 = 4
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                r7 = 0
                r5[r7] = r3
                r5[r4] = r15
                r3 = 2
                r5[r3] = r22
                r3 = 3
                r5[r3] = r0
                java.lang.String r0 = "SG_NC_SERVER_FAULT: status=%d,token =%s,sig=%s,seesionId=%s"
                java.lang.String r0 = java.lang.String.format(r0, r5)
                com.alibaba.verificationsdk.utils.Log.i(r6, r0)
                com.alibaba.verificationsdk.ui.IActivityCallback r0 = com.alibaba.verificationsdk.ui.VerifyActivity.callback
                if (r0 == 0) goto L_0x0339
                r2.put(r8, r13)
                com.alibaba.verificationsdk.ui.IActivityCallback r0 = com.alibaba.verificationsdk.ui.VerifyActivity.callback
                com.alibaba.verificationsdk.ui.VerifyActivity r3 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                r4 = 104(0x68, float:1.46E-43)
                int r3 = r3.map2GenericCode(r4)
                r0.onResult(r3, r2)
            L_0x0339:
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                r0.finish()
                goto L_0x0686
            L_0x0340:
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.ui.VerifyActivity$RefreshCountDownTimer r0 = r0.refreshCountDownTimer
                r0.cancel()
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.ui.VerifyActivity$RefreshCountDownTimer r0 = r0.refreshCountDownTimer
                r0.start()
                r10 = r21
                com.alibaba.verificationsdk.utils.Log.i(r6, r10)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.ALiLoadingView r0 = r0.aLiLoadingView
                r2 = 4
                r0.setVisibility(r2)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.ALiLoadingView r0 = r0.aLiLoadingView
                r0.stopRotationAnimation()
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.widget.LinearLayout r0 = r0.content
                r3 = 0
                r0.setVisibility(r3)
                java.lang.Object[] r0 = new java.lang.Object[r2]
                java.lang.Float r2 = java.lang.Float.valueOf(r20)
                r0[r3] = r2
                java.lang.Float r2 = java.lang.Float.valueOf(r19)
                r3 = 1
                r0[r3] = r2
                java.lang.Float r2 = java.lang.Float.valueOf(r18)
                r3 = 2
                r0[r3] = r2
                java.lang.Float r2 = java.lang.Float.valueOf(r17)
                r3 = 3
                r0[r3] = r2
                java.lang.String r2 = "SG_NC_RETRY:x1=%f,y1=%f,x2=%f,y2=%f"
                java.lang.String r0 = java.lang.String.format(r2, r0)
                com.alibaba.verificationsdk.utils.Log.i(r6, r0)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.widget.FrameLayout r0 = r0.root
                com.alibaba.verificationsdk.ui.VerifyActivity r2 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.DrawView r2 = r2.frame
                r0.removeView(r2)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.widget.FrameLayout r0 = r0.root
                com.alibaba.verificationsdk.ui.VerifyActivity r2 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.BallView r2 = r2.draw
                r0.removeView(r2)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.BallView r0 = r0.draw
                r14 = r19
                r11 = r20
                r0.initPostion(r11, r14)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.DrawView r0 = r0.frame
                r3 = r17
                r2 = r18
                r0.initPostion(r2, r3)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.DrawView r2 = r0.frame
                r0.addroot(r2)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.BallView r2 = r0.draw
                com.alibaba.verificationsdk.ui.VerifyActivity r3 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.widget.FrameLayout$LayoutParams r3 = r3.f14756lp
                r0.addroot(r2, r3)
                goto L_0x0686
            L_0x03ec:
                com.alibaba.verificationsdk.ui.VerifyActivity r4 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.ui.VerifyActivity$RefreshCountDownTimer r4 = r4.refreshCountDownTimer
                r4.cancel()
                r4 = 4
                java.lang.Object[] r5 = new java.lang.Object[r4]
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                r4 = 0
                r5[r4] = r3
                r3 = 1
                r5[r3] = r15
                r3 = 2
                r5[r3] = r22
                r3 = 3
                r5[r3] = r0
                java.lang.String r0 = "SG_NC_VERI_SUCCEED: status=%d,token =%s,sig=%s,seesionId=%s"
                java.lang.String r0 = java.lang.String.format(r0, r5)
                com.alibaba.verificationsdk.utils.Log.i(r6, r0)
                com.alibaba.verificationsdk.ui.IActivityCallback r0 = com.alibaba.verificationsdk.ui.VerifyActivity.callback
                if (r0 == 0) goto L_0x0429
                r2.put(r8, r13)
                com.alibaba.verificationsdk.ui.IActivityCallback r0 = com.alibaba.verificationsdk.ui.VerifyActivity.callback
                com.alibaba.verificationsdk.ui.VerifyActivity r3 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                r4 = 102(0x66, float:1.43E-43)
                int r3 = r3.map2GenericCode(r4)
                r0.onResult(r3, r2)
            L_0x0429:
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.ALiLoadingView r0 = r0.aLiLoadingView
                r2 = 4
                r0.setVisibility(r2)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.ALiLoadingView r0 = r0.aLiLoadingView
                r0.stopRotationAnimation()
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.widget.TextView r0 = r0.tipsTV
                com.alibaba.verificationsdk.ui.VerifyActivity r2 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.content.res.Resources r2 = r2.getResources()
                com.alibaba.verificationsdk.ui.VerifyActivity r3 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                java.lang.String r3 = r3.getPackageName()
                java.lang.String r4 = "ali_vsdk_tips_finish"
                int r2 = r2.getIdentifier(r4, r9, r3)
                r0.setText(r2)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.content.res.Resources r0 = r0.getResources()
                com.alibaba.verificationsdk.ui.VerifyActivity r2 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.content.res.Resources r2 = r2.getResources()
                com.alibaba.verificationsdk.ui.VerifyActivity r3 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                java.lang.String r3 = r3.getPackageName()
                java.lang.String r4 = "ali_vsdk_lock_success"
                int r2 = r2.getIdentifier(r4, r7, r3)
                android.graphics.drawable.Drawable r0 = r0.getDrawable(r2)
                int r2 = r0.getMinimumWidth()
                int r3 = r0.getMinimumHeight()
                r4 = 0
                r0.setBounds(r4, r4, r2, r3)
                com.alibaba.verificationsdk.ui.VerifyActivity r2 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.widget.TextView r2 = r2.tipsTV
                r3 = 0
                r2.setCompoundDrawables(r3, r3, r3, r0)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.widget.LinearLayout r0 = r0.content
                r0.setVisibility(r4)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.os.Handler r2 = r0.handler
                java.lang.Runnable r0 = r0.finishTask
                r3 = 300(0x12c, double:1.48E-321)
                r2.postDelayed(r0, r3)
                goto L_0x0686
            L_0x049f:
                java.lang.String r0 = "SG_NC_VERIFY_START"
                com.alibaba.verificationsdk.utils.Log.i(r6, r0)
                goto L_0x0686
            L_0x04a6:
                r15 = r10
                r22 = r11
                r14 = r19
                r11 = r20
                r10 = r21
                r19 = r7
                r7 = 100
                if (r3 == r7) goto L_0x0681
                r7 = 101(0x65, float:1.42E-43)
                if (r3 == r7) goto L_0x0571
                r7 = 104(0x68, float:1.46E-43)
                if (r3 == r7) goto L_0x0528
                r7 = 105(0x69, float:1.47E-43)
                if (r3 == r7) goto L_0x04c3
                goto L_0x0686
            L_0x04c3:
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.ui.VerifyActivity$RefreshCountDownTimer r0 = r0.refreshCountDownTimer
                r0.cancel()
                com.alibaba.verificationsdk.ui.IActivityCallback r0 = com.alibaba.verificationsdk.ui.VerifyActivity.callback
                if (r0 == 0) goto L_0x04e6
                java.lang.String r0 = java.lang.String.valueOf(r5)
                r2.put(r4, r0)
                com.alibaba.verificationsdk.ui.IActivityCallback r0 = com.alibaba.verificationsdk.ui.VerifyActivity.callback
                com.alibaba.verificationsdk.ui.VerifyActivity r4 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                int r4 = r4.map2GenericCode(r7)
                r0.onResult(r4, r2)
            L_0x04e6:
                r0 = 1207(0x4b7, float:1.691E-42)
                if (r0 != r5) goto L_0x0507
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.content.res.Resources r2 = r0.getResources()
                com.alibaba.verificationsdk.ui.VerifyActivity r4 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                java.lang.String r4 = r4.getPackageName()
                int r2 = r2.getIdentifier(r12, r9, r4)
                java.lang.String r2 = r0.getString(r2)
                r4 = 1
                android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r4)
                r0.show()
                goto L_0x0508
            L_0x0507:
                r4 = 1
            L_0x0508:
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                r0.finish()
                r0 = 2
                java.lang.Object[] r0 = new java.lang.Object[r0]
                java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
                r3 = 0
                r0[r3] = r2
                java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
                r0[r4] = r2
                java.lang.String r2 = "Init stage:SG_NC_FAILED: status=%d,errorCode=%d"
                java.lang.String r0 = java.lang.String.format(r2, r0)
                com.alibaba.verificationsdk.utils.Log.i(r6, r0)
                goto L_0x0686
            L_0x0528:
                com.alibaba.verificationsdk.ui.VerifyActivity r4 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.ui.VerifyActivity$RefreshCountDownTimer r4 = r4.refreshCountDownTimer
                r4.cancel()
                java.lang.String r4 = "NC_INIT_SERVER_FAULT"
                com.alibaba.verificationsdk.utils.Log.i(r6, r4)
                com.alibaba.verificationsdk.ui.IActivityCallback r4 = com.alibaba.verificationsdk.ui.VerifyActivity.callback
                if (r4 == 0) goto L_0x054e
                r2.put(r8, r13)
                com.alibaba.verificationsdk.ui.IActivityCallback r4 = com.alibaba.verificationsdk.ui.VerifyActivity.callback
                com.alibaba.verificationsdk.ui.VerifyActivity r5 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                r7 = 104(0x68, float:1.46E-43)
                int r5 = r5.map2GenericCode(r7)
                r4.onResult(r5, r2)
            L_0x054e:
                com.alibaba.verificationsdk.ui.VerifyActivity r2 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                r2.finish()
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                r4 = 0
                r2[r4] = r3
                r3 = 1
                r2[r3] = r15
                r3 = 2
                r2[r3] = r22
                r3 = 3
                r2[r3] = r0
                java.lang.String r0 = "SG_NC_INIT_SERVER_FAULT: status=%d,token =%s,sig=%s,seesionId=%s"
                java.lang.String r0 = java.lang.String.format(r0, r2)
                com.alibaba.verificationsdk.utils.Log.i(r6, r0)
                goto L_0x0686
            L_0x0571:
                com.alibaba.verificationsdk.utils.Log.i(r6, r10)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.ALiLoadingView r0 = r0.aLiLoadingView
                r2 = 4
                r0.setVisibility(r2)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.ALiLoadingView r0 = r0.aLiLoadingView
                r0.stopRotationAnimation()
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.widget.LinearLayout r0 = r0.content
                r3 = 0
                r0.setVisibility(r3)
                java.lang.Object[] r0 = new java.lang.Object[r2]
                java.lang.Float r2 = java.lang.Float.valueOf(r11)
                r0[r3] = r2
                java.lang.Float r2 = java.lang.Float.valueOf(r14)
                r3 = 1
                r0[r3] = r2
                java.lang.Float r2 = java.lang.Float.valueOf(r18)
                r3 = 2
                r0[r3] = r2
                java.lang.Float r2 = java.lang.Float.valueOf(r17)
                r3 = 3
                r0[r3] = r2
                java.lang.String r2 = "x1=%f,y1=%f,x2=%f,y2=%f"
                java.lang.String r0 = java.lang.String.format(r2, r0)
                com.alibaba.verificationsdk.utils.Log.i(r6, r0)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.BallView r0 = r0.draw
                com.alibaba.verificationsdk.ui.VerifyActivity r2 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.bean.ResConfig r2 = r2.resConfig
                com.alibaba.verificationsdk.ui.VerifyActivity r3 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.content.res.Resources r3 = r3.getResources()
                com.alibaba.verificationsdk.ui.VerifyActivity r4 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                java.lang.String r4 = r4.getPackageName()
                java.lang.String r5 = "ali_vsdk_ball"
                r6 = r19
                int r3 = r3.getIdentifier(r5, r6, r4)
                java.lang.String r4 = "MSA_slide_icon_default"
                android.graphics.Bitmap r2 = r2.getBitmap(r4, r3)
                com.alibaba.verificationsdk.ui.VerifyActivity r3 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.content.res.Resources r3 = r3.getResources()
                com.alibaba.verificationsdk.ui.VerifyActivity r4 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.content.res.Resources r4 = r4.getResources()
                com.alibaba.verificationsdk.ui.VerifyActivity r5 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                java.lang.String r5 = r5.getPackageName()
                java.lang.String r7 = "ali_vsdk_frame1"
                int r4 = r4.getIdentifier(r7, r6, r5)
                android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeResource(r3, r4)
                r0.init(r2, r3)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.BallView r0 = r0.draw
                r0.initPostion(r11, r14)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.DrawView r0 = r0.frame
                r3 = r17
                r2 = r18
                r0.initPostion(r2, r3)
                android.view.animation.ScaleAnimation r0 = new android.view.animation.ScaleAnimation
                r5 = 1065353216(0x3f800000, float:1.0)
                r6 = 1066192077(0x3f8ccccd, float:1.1)
                r7 = 1065353216(0x3f800000, float:1.0)
                r8 = 1066192077(0x3f8ccccd, float:1.1)
                r9 = 0
                com.alibaba.verificationsdk.ui.VerifyActivity r4 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.DrawView r4 = r4.frame
                float r4 = r4.getRadius()
                float r10 = r2 + r4
                r11 = 0
                com.alibaba.verificationsdk.ui.VerifyActivity r2 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.DrawView r2 = r2.frame
                float r2 = r2.getRadius()
                float r12 = r3 + r2
                r4 = r0
                r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
                r2 = 500(0x1f4, double:2.47E-321)
                r0.setDuration(r2)
                r2 = 1
                r0.setFillAfter(r2)
                r2 = -1
                r0.setRepeatCount(r2)
                r2 = 2
                r0.setRepeatMode(r2)
                com.alibaba.verificationsdk.ui.VerifyActivity r2 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.DrawView r2 = r2.frame
                r2.setAnimation(r0)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.DrawView r2 = r0.frame
                r0.addroot(r2)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.widgets.BallView r2 = r0.draw
                com.alibaba.verificationsdk.ui.VerifyActivity r3 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                android.widget.FrameLayout$LayoutParams r3 = r3.f14756lp
                r0.addroot(r2, r3)
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.ui.VerifyActivity$RefreshCountDownTimer r0 = r0.refreshCountDownTimer
                r0.cancel()
                com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                com.alibaba.verificationsdk.ui.VerifyActivity$RefreshCountDownTimer r0 = r0.refreshCountDownTimer
                r0.start()
                goto L_0x0686
            L_0x0681:
                java.lang.String r0 = "SG_NC_INIT_START"
                com.alibaba.verificationsdk.utils.Log.i(r6, r0)
            L_0x0686:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.verificationsdk.ui.VerifyActivity.AnonymousClass18.handleMessage(android.os.Message):void");
        }
    };
    public Handler handlerResRequest = new Handler() {
        public void handleMessage(Message message) {
            switch (message.what) {
                case VerifyActivity.RES_REQUEST_START /*100023*/:
                    new Thread(VerifyActivity.this.requestResRunnable).start();
                    return;
                case VerifyActivity.RES_REQUEST_SUCC /*100024*/:
                    JSONObject jSONObject = (JSONObject) message.obj;
                    final String optString = jSONObject.optString("md5");
                    final String optString2 = jSONObject.optString("version");
                    String string = VerifyActivity.this.sharedPreferences.getString("version", "0.0.0.0");
                    if (TextUtils.isEmpty(optString2) || !VersionUtil.isVersionUpdate(string, optString2)) {
                        VerifyActivity.this.handlerResRequest.sendEmptyMessage(VerifyActivity.RES_REQUEST_END);
                        return;
                    }
                    Log.i(VerifyActivity.LOG_TAG, "new resource version is coming, upgrading now!");
                    new DownLoaderTask(jSONObject.optString("url"), VerifyActivity.this.getFilesDir().getAbsolutePath(), (Context) null, new DownloadListener() {
                        public void downloadFinished(File file) {
                            if (file == null || !file.exists()) {
                                VerifyActivity.this.handlerResRequest.sendEmptyMessage(VerifyActivity.RES_REQUEST_END);
                                return;
                            }
                            try {
                                MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
                                FileInputStream fileInputStream = new FileInputStream(file);
                                byte[] bArr = new byte[8192];
                                while (true) {
                                    int read = fileInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    } else if (instance != null) {
                                        instance.update(bArr, 0, read);
                                    }
                                }
                                if (TextUtils.isEmpty(optString) || instance == null) {
                                    VerifyActivity.this.handlerResRequest.sendEmptyMessage(VerifyActivity.RES_REQUEST_END);
                                } else if (optString.equals(VerifyActivity.this.toHexString(instance.digest()).toLowerCase())) {
                                    new ZipExtractorTask(file.getAbsolutePath(), VerifyActivity.RES_ROOT_PATH, (Context) null, true, new ZIPExtracListener() {
                                        public void unzipFinished(File file, File file2) {
                                            Log.i(VerifyActivity.LOG_TAG, "update resources finished! " + file2.getAbsolutePath());
                                            VerifyActivity.this.sharedPreferences.edit().putString("version", optString2).apply();
                                            if (file != null && file.exists()) {
                                                file.delete();
                                            }
                                            VerifyActivity.this.handlerResRequest.sendEmptyMessage(VerifyActivity.RES_REQUEST_END);
                                        }

                                        public void unzipStart() {
                                        }
                                    }).execute(new Void[0]);
                                } else {
                                    VerifyActivity.this.handlerResRequest.sendEmptyMessage(VerifyActivity.RES_REQUEST_END);
                                }
                            } catch (Exception e11) {
                                e11.printStackTrace();
                                VerifyActivity.this.handlerResRequest.sendEmptyMessage(VerifyActivity.RES_REQUEST_END);
                            }
                        }

                        public void downloadStart() {
                        }
                    }).execute(new Void[0]);
                    return;
                case VerifyActivity.RES_REQUEST_FAILED /*100025*/:
                    int i11 = AnonymousClass25.$SwitchMap$com$alibaba$verificationsdk$ui$VerifyActivity$ERROR_TYPE[ERROR_TYPE.values()[message.arg1].ordinal()];
                    if (i11 == 1) {
                        JSONObject jSONObject2 = (JSONObject) message.obj;
                        Log.e(VerifyActivity.LOG_TAG, jSONObject2.optString(RemoteMessageConst.MessageBody.MSG));
                        Log.e(VerifyActivity.LOG_TAG, jSONObject2.optString("sub_msg"));
                    } else if (i11 == 2) {
                        Object obj = message.obj;
                        if (obj == null) {
                            obj = "";
                        }
                        Log.e(VerifyActivity.LOG_TAG, (String) obj);
                    }
                    VerifyActivity.this.handlerResRequest.sendEmptyMessage(VerifyActivity.RES_REQUEST_END);
                    return;
                case VerifyActivity.RES_REQUEST_END /*100026*/:
                    VerifyActivity.this.readResConfig();
                    VerifyActivity.this.aLiLoadingView.setVisibility(4);
                    VerifyActivity.this.aLiLoadingView.stopRotationAnimation();
                    VerifyActivity.this.initUI(VerifyActivity.verifyType);
                    return;
                default:
                    return;
            }
        }
    };
    public Handler handlerSMSorCallRequest = new Handler() {
        public void handleMessage(Message message) {
            HashMap hashMap = new HashMap();
            switch (message.what) {
                case VerifyActivity.SMS_CALL_REQUEST_START /*100013*/:
                    new Thread(VerifyActivity.this.requestRunnable).start();
                    return;
                case VerifyActivity.SMS_CALL_REQUEST_SUCC /*100014*/:
                    String unused = VerifyActivity.this.sessionId = ((JSONObject) message.obj).optString("session_id");
                    return;
                case VerifyActivity.SMS_CALL_REQUEST_FAILED /*100015*/:
                    String unused2 = VerifyActivity.this.sessionId = null;
                    hashMap.put("code", String.valueOf(message.arg2));
                    ERROR_TYPE error_type = ERROR_TYPE.values()[message.arg1];
                    hashMap.put("errorCode", error_type.name());
                    int i11 = AnonymousClass25.$SwitchMap$com$alibaba$verificationsdk$ui$VerifyActivity$ERROR_TYPE[error_type.ordinal()];
                    if (i11 == 1) {
                        JSONObject jSONObject = (JSONObject) message.obj;
                        Log.e(VerifyActivity.LOG_TAG, jSONObject.optString(RemoteMessageConst.MessageBody.MSG));
                        Log.e(VerifyActivity.LOG_TAG, jSONObject.optString("sub_msg"));
                        hashMap.put("errorMsg", jSONObject.optString(RemoteMessageConst.MessageBody.MSG) + l.f34627b + jSONObject.optString("sub_msg"));
                        return;
                    } else if (i11 == 2) {
                        Log.e(VerifyActivity.LOG_TAG, (String) message.obj);
                        hashMap.put("errorMsg", (String) message.obj);
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    };
    public Handler handlerSMSorCallVerification = new Handler() {
        public void handleMessage(Message message) {
            HashMap hashMap = new HashMap();
            switch (message.what) {
                case VerifyActivity.SMS_CALL_VERIFY_START /*100003*/:
                    VerifyActivity.this.txSubmit.setText(VerifyActivity.this.resConfig.getString("MSA_submit_button_waiting", VerifyActivity.this.getResources().getIdentifier("ali_vsdk_verify_in_progress", "string", VerifyActivity.this.getPackageName())));
                    VerifyActivity.this.submitLoading.setVisibility(0);
                    VerifyActivity.this.submitLoading.startRotationAnimation();
                    new Thread(VerifyActivity.this.verificationRunnable).start();
                    return;
                case VerifyActivity.SMS_CALL_VERIFY_SUCC /*100004*/:
                    VerifyActivity.this.txSubmit.setText(VerifyActivity.this.getResources().getIdentifier("ali_vsdk_verify_submit", "string", VerifyActivity.this.getPackageName()));
                    VerifyActivity.this.submitLoading.setVisibility(4);
                    VerifyActivity.this.submitLoading.stopRotationAnimation();
                    if (VerifyActivity.callback != null) {
                        hashMap.put("sessionID", VerifyActivity.this.sessionId);
                        VerifyActivity.callback.onResult(1, hashMap);
                    }
                    VerifyActivity.this.finish();
                    return;
                case VerifyActivity.SMS_CALL_VERIFY_FAILED /*100005*/:
                    if (VerifyActivity.this.btnCall != null) {
                        VerifyActivity.this.btnCall.setVisibility(0);
                    }
                    VerifyActivity.this.txSubmit.setText(VerifyActivity.this.getResources().getIdentifier("ali_vsdk_verify_submit", "string", VerifyActivity.this.getPackageName()));
                    VerifyActivity.this.submitLoading.setVisibility(4);
                    VerifyActivity.this.submitLoading.stopRotationAnimation();
                    VerifyActivity.this.btnSubmit.setClickable(true);
                    if (VerifyActivity.this.txRequest != null) {
                        VerifyActivity.this.txRequest.setClickable(true);
                    }
                    if (VerifyActivity.verifyType == VerifyType.SMS) {
                        VerifyActivity verifyActivity = VerifyActivity.this;
                        Toast.makeText(verifyActivity, verifyActivity.getResources().getIdentifier("ali_vsdk_verify_error", "string", VerifyActivity.this.getPackageName()), 1).show();
                    } else if (VerifyActivity.verifyType == VerifyType.CALL) {
                        VerifyActivity verifyActivity2 = VerifyActivity.this;
                        Toast.makeText(verifyActivity2, verifyActivity2.getResources().getIdentifier("ali_vsdk_verify_error_call", "string", VerifyActivity.this.getPackageName()), 1).show();
                    }
                    ERROR_TYPE error_type = ERROR_TYPE.values()[message.arg1];
                    int i11 = AnonymousClass25.$SwitchMap$com$alibaba$verificationsdk$ui$VerifyActivity$ERROR_TYPE[error_type.ordinal()];
                    if (i11 == 1) {
                        JSONObject jSONObject = (JSONObject) message.obj;
                        Log.e(VerifyActivity.LOG_TAG, jSONObject.optString(RemoteMessageConst.MessageBody.MSG));
                        Log.e(VerifyActivity.LOG_TAG, jSONObject.optString("sub_msg"));
                        hashMap.put("errorMsg", jSONObject.optString(RemoteMessageConst.MessageBody.MSG) + l.f34627b + jSONObject.optString("sub_msg"));
                    } else if (i11 == 2) {
                        Object obj = message.obj;
                        if (obj == null) {
                            obj = "";
                        }
                        Log.e(VerifyActivity.LOG_TAG, (String) obj);
                        hashMap.put("errorMsg", (String) message.obj);
                    } else if (i11 == 3) {
                        VerifyActivity verifyActivity3 = VerifyActivity.this;
                        Log.e(VerifyActivity.LOG_TAG, verifyActivity3.getString(verifyActivity3.getResources().getIdentifier("ali_vsdk_verify_error", "string", VerifyActivity.this.getPackageName())));
                        VerifyActivity verifyActivity4 = VerifyActivity.this;
                        hashMap.put("errorMsg", verifyActivity4.getString(verifyActivity4.getResources().getIdentifier("ali_vsdk_verify_error", "string", VerifyActivity.this.getPackageName())));
                    }
                    if (VerifyActivity.callback != null && VerifyActivity.access$3406() <= 0) {
                        hashMap.put("code", String.valueOf(message.arg2));
                        hashMap.put("sessionID", VerifyActivity.this.sessionId);
                        hashMap.put("errorCode", error_type.name());
                        VerifyActivity.callback.onResult(0, hashMap);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    public Runnable initTask = new Runnable() {
        public void run() {
            VerifyActivity.this.handler.sendEmptyMessage(10000);
        }
    };
    /* access modifiers changed from: private */
    public boolean isFingerValid = false;
    /* access modifiers changed from: private */
    public boolean isInBoundary = false;
    private ImageView logo = null;
    /* access modifiers changed from: private */

    /* renamed from: lp  reason: collision with root package name */
    public FrameLayout.LayoutParams f14756lp;
    /* access modifiers changed from: private */
    public INoCaptchaComponent ncComponent;
    private Button refresh = null;
    /* access modifiers changed from: private */
    public FrameLayout refreshBg = null;
    /* access modifiers changed from: private */
    public RefreshCountDownTimer refreshCountDownTimer = null;
    /* access modifiers changed from: private */
    public RequestCountDownTimer requestCountDownTimer = null;
    public Runnable requestResRunnable = new Runnable() {
        public void run() {
            Message message = new Message();
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(VerifyActivity.DEVICE_TYPE, "android");
                int i11 = VerifyActivity.this.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
                String str = "xhdpi";
                if (i11 == 120) {
                    str = "ldpi";
                } else if (i11 == 160) {
                    str = "mdpi";
                } else if (i11 == 213) {
                    str = "tv";
                } else if (i11 == 240) {
                    str = "hdpi";
                } else if (i11 != 320) {
                    if (i11 == 480) {
                        str = "xxhdpi";
                    } else if (i11 == 640) {
                        str = "xxxhdpi";
                    }
                }
                hashMap.put(VerifyActivity.DPI, str);
                hashMap.put(VerifyActivity.LANG, Locale.getDefault().toString());
                hashMap.put(VerifyActivity.INFO_TOKEN, VerifyActivity.info_token);
                if (!TextUtils.isEmpty(VerifyActivity.hostenv)) {
                    hashMap.put(VerifyActivity.HOSTENV, VerifyActivity.hostenv);
                }
                String noCaptchaForwardAuth = VerifyActivity.this.ncComponent.noCaptchaForwardAuth("alibaba.security.jaq.resource.fetch", hashMap, VerifyActivity.AUTHCODE, 12);
                Log.i(VerifyActivity.LOG_TAG, "get resource result: " + noCaptchaForwardAuth);
                JSONObject jSONObject = new JSONObject(noCaptchaForwardAuth);
                if (jSONObject.optBoolean("error", true)) {
                    message.what = VerifyActivity.RES_REQUEST_FAILED;
                    message.arg1 = ERROR_TYPE.ERROR_FROM_SERVER.ordinal();
                } else {
                    message.what = VerifyActivity.RES_REQUEST_SUCC;
                }
                message.obj = jSONObject;
            } catch (Exception e11) {
                e11.printStackTrace();
                message.what = VerifyActivity.RES_REQUEST_FAILED;
                message.arg1 = ERROR_TYPE.ERROR_FROM_CLIENT.ordinal();
                message.obj = e11.getMessage();
            } catch (Throwable th2) {
                VerifyActivity.this.handlerResRequest.sendMessage(message);
                throw th2;
            }
            VerifyActivity.this.handlerResRequest.sendMessage(message);
        }
    };
    public Runnable requestRunnable = new Runnable() {
        public void run() {
            Message message = new Message();
            String str = null;
            try {
                int i11 = AnonymousClass25.$SwitchMap$com$alibaba$verificationsdk$ui$VerifyType[VerifyActivity.verifyType.ordinal()];
                if (i11 == 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(VerifyActivity.CAPTCHA_TYPE, "1");
                    hashMap.put(VerifyActivity.PHONE_NUMBER, VerifyActivity.number);
                    hashMap.put(VerifyActivity.INFO_TOKEN, VerifyActivity.info_token);
                    if (!TextUtils.isEmpty(VerifyActivity.hostenv)) {
                        hashMap.put(VerifyActivity.HOSTENV, VerifyActivity.hostenv);
                    }
                    str = VerifyActivity.this.ncComponent.noCaptchaForwardAuth("alibaba.security.jaq.captcha.send", hashMap, VerifyActivity.AUTHCODE, 12);
                } else if (i11 == 3) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(VerifyActivity.PHONE_NUMBER, VerifyActivity.number);
                    hashMap2.put(VerifyActivity.INFO_TOKEN, VerifyActivity.info_token);
                    if (!TextUtils.isEmpty(VerifyActivity.hostenv)) {
                        hashMap2.put(VerifyActivity.HOSTENV, VerifyActivity.hostenv);
                    }
                    str = VerifyActivity.this.ncComponent.noCaptchaForwardAuth("alibaba.security.jaq.captcha.audio.send", hashMap2, VerifyActivity.AUTHCODE, 12);
                }
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optBoolean("error", true)) {
                    message.what = VerifyActivity.SMS_CALL_REQUEST_FAILED;
                    message.arg1 = ERROR_TYPE.ERROR_FROM_SERVER.ordinal();
                    message.arg2 = jSONObject.optInt("code");
                } else {
                    int optInt = jSONObject.optInt("send_status");
                    if (optInt > 0) {
                        message.what = VerifyActivity.SMS_CALL_REQUEST_SUCC;
                    } else {
                        message.what = VerifyActivity.SMS_CALL_REQUEST_FAILED;
                        message.arg1 = ERROR_TYPE.ERROR_FROM_BUSSINESS.ordinal();
                        message.arg2 = optInt;
                    }
                }
                message.obj = jSONObject;
            } catch (Exception e11) {
                e11.printStackTrace();
                message.what = VerifyActivity.SMS_CALL_REQUEST_FAILED;
                message.arg1 = ERROR_TYPE.ERROR_FROM_CLIENT.ordinal();
                message.arg2 = 50000;
                message.obj = e11.getMessage();
            } catch (Throwable th2) {
                VerifyActivity.this.handlerSMSorCallRequest.sendMessage(message);
                throw th2;
            }
            VerifyActivity.this.handlerSMSorCallRequest.sendMessage(message);
        }
    };
    /* access modifiers changed from: private */
    public ResConfig resConfig;
    /* access modifiers changed from: private */
    public FrameLayout root;
    /* access modifiers changed from: private */
    public String sessionId = null;
    /* access modifiers changed from: private */
    public SharedPreferences sharedPreferences = null;
    /* access modifiers changed from: private */
    public ALiLoadingView submitLoading;
    private TextView tipsSubTV = null;
    /* access modifiers changed from: private */
    public TextView tipsTV = null;
    /* access modifiers changed from: private */
    public TextView txRequest = null;
    /* access modifiers changed from: private */
    public TextView txSubmit = null;
    public Runnable verificationRunnable = new Runnable() {
        public void run() {
            Message message = new Message();
            try {
                HashMap hashMap = new HashMap();
                int i11 = AnonymousClass25.$SwitchMap$com$alibaba$verificationsdk$ui$VerifyType[VerifyActivity.verifyType.ordinal()];
                String str = "1";
                if (i11 != 2 && i11 == 3) {
                    str = "2";
                }
                hashMap.put(VerifyActivity.CAPTCHA_TYPE, str);
                hashMap.put(VerifyActivity.PHONE_NUMBER, VerifyActivity.number);
                hashMap.put(VerifyActivity.SESSION_ID, VerifyActivity.this.sessionId);
                String str2 = null;
                if (VerifyActivity.this.etCode != null && !TextUtils.isEmpty(VerifyActivity.this.etCode.getText().toString())) {
                    str2 = VerifyActivity.this.etCode.getText().toString();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(VerifyActivity.USERINPUTCAPTCHA, str2);
                hashMap.put(VerifyActivity.EXTEND_DATA, jSONObject.toString());
                hashMap.put(VerifyActivity.INFO_TOKEN, VerifyActivity.info_token);
                if (!TextUtils.isEmpty(VerifyActivity.hostenv)) {
                    hashMap.put(VerifyActivity.HOSTENV, VerifyActivity.hostenv);
                }
                JSONObject jSONObject2 = new JSONObject(VerifyActivity.this.ncComponent.noCaptchaForwardAuth("alibaba.security.jaq.captcha.verify", hashMap, VerifyActivity.AUTHCODE, 12));
                if (jSONObject2.optBoolean("error", true)) {
                    message.what = VerifyActivity.SMS_CALL_VERIFY_FAILED;
                    message.arg1 = ERROR_TYPE.ERROR_FROM_SERVER.ordinal();
                    message.arg2 = jSONObject2.optInt("code");
                } else {
                    int optInt = jSONObject2.optInt("verify_status");
                    if (optInt > 0) {
                        message.what = VerifyActivity.SMS_CALL_VERIFY_SUCC;
                    } else {
                        message.what = VerifyActivity.SMS_CALL_VERIFY_FAILED;
                        message.arg1 = ERROR_TYPE.ERROR_FROM_BUSSINESS.ordinal();
                        message.arg2 = optInt;
                    }
                }
                message.obj = jSONObject2;
            } catch (Exception e11) {
                e11.printStackTrace();
                message.what = VerifyActivity.SMS_CALL_VERIFY_FAILED;
                message.arg1 = ERROR_TYPE.ERROR_FROM_CLIENT.ordinal();
                message.arg2 = 50000;
                message.obj = e11.getMessage();
            } catch (Throwable th2) {
                VerifyActivity.this.handlerSMSorCallVerification.sendMessage(message);
                throw th2;
            }
            VerifyActivity.this.handlerSMSorCallVerification.sendMessage(message);
        }
    };

    /* renamed from: com.alibaba.verificationsdk.ui.VerifyActivity$25  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass25 {
        public static final /* synthetic */ int[] $SwitchMap$com$alibaba$verificationsdk$ui$VerifyActivity$ERROR_TYPE;
        public static final /* synthetic */ int[] $SwitchMap$com$alibaba$verificationsdk$ui$VerifyType;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            /*
                com.alibaba.verificationsdk.ui.VerifyActivity$ERROR_TYPE[] r0 = com.alibaba.verificationsdk.ui.VerifyActivity.ERROR_TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$alibaba$verificationsdk$ui$VerifyActivity$ERROR_TYPE = r0
                r1 = 1
                com.alibaba.verificationsdk.ui.VerifyActivity$ERROR_TYPE r2 = com.alibaba.verificationsdk.ui.VerifyActivity.ERROR_TYPE.ERROR_FROM_SERVER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$alibaba$verificationsdk$ui$VerifyActivity$ERROR_TYPE     // Catch:{ NoSuchFieldError -> 0x001d }
                com.alibaba.verificationsdk.ui.VerifyActivity$ERROR_TYPE r3 = com.alibaba.verificationsdk.ui.VerifyActivity.ERROR_TYPE.ERROR_FROM_CLIENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$alibaba$verificationsdk$ui$VerifyActivity$ERROR_TYPE     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.alibaba.verificationsdk.ui.VerifyActivity$ERROR_TYPE r4 = com.alibaba.verificationsdk.ui.VerifyActivity.ERROR_TYPE.ERROR_FROM_BUSSINESS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.alibaba.verificationsdk.ui.VerifyType[] r3 = com.alibaba.verificationsdk.ui.VerifyType.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$alibaba$verificationsdk$ui$VerifyType = r3
                com.alibaba.verificationsdk.ui.VerifyType r4 = com.alibaba.verificationsdk.ui.VerifyType.NOCAPTCHA     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = $SwitchMap$com$alibaba$verificationsdk$ui$VerifyType     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.alibaba.verificationsdk.ui.VerifyType r3 = com.alibaba.verificationsdk.ui.VerifyType.SMS     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$com$alibaba$verificationsdk$ui$VerifyType     // Catch:{ NoSuchFieldError -> 0x004d }
                com.alibaba.verificationsdk.ui.VerifyType r1 = com.alibaba.verificationsdk.ui.VerifyType.CALL     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.verificationsdk.ui.VerifyActivity.AnonymousClass25.<clinit>():void");
        }
    }

    public class AsteriskPasswordTransformationMethod extends PasswordTransformationMethod {

        public class PasswordCharSequence implements CharSequence {
            private CharSequence mSource;

            public PasswordCharSequence(CharSequence charSequence) {
                this.mSource = charSequence;
            }

            public char charAt(int i11) {
                if (i11 <= 2 || i11 >= 9) {
                    return this.mSource.charAt(i11);
                }
                return '*';
            }

            public int length() {
                return this.mSource.length();
            }

            public CharSequence subSequence(int i11, int i12) {
                return this.mSource.subSequence(i11, i12);
            }
        }

        public AsteriskPasswordTransformationMethod() {
        }

        public CharSequence getTransformation(CharSequence charSequence, View view) {
            return new PasswordCharSequence(charSequence);
        }
    }

    public enum ERROR_TYPE {
        ERROR_FROM_SERVER,
        ERROR_FROM_CLIENT,
        ERROR_FROM_BUSSINESS
    }

    public class OnInitFinishListener implements IUMIDInitListenerEx {
        public OnInitFinishListener() {
        }

        public void onUMIDInitFinishedEx(String str, final int i11) {
            VerifyActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    if (i11 != 200) {
                        VerifyActivity.sgInited = false;
                        HashMap hashMap = new HashMap();
                        hashMap.put("errorCode", "SecurityGuardManagerInit");
                        hashMap.put("errorCode", String.valueOf(i11));
                        VerifyActivity.callback.onResult(0, hashMap);
                        return;
                    }
                    VerifyActivity.sgInited = true;
                    VerifyActivity.this.initAfterSGInit();
                }
            });
        }
    }

    public class RefreshCountDownTimer extends CountDownTimer {
        public RefreshCountDownTimer(long j11, long j12) {
            super(j11, j12);
        }

        public void onFinish() {
            if (VerifyActivity.this.refreshBg != null && VerifyActivity.this.root != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                VerifyActivity verifyActivity = VerifyActivity.this;
                verifyActivity.addroot(verifyActivity.refreshBg, layoutParams);
                VerifyActivity.this.removeBall();
            }
        }

        public void onTick(long j11) {
        }
    }

    public class RequestCountDownTimer extends CountDownTimer {
        public RequestCountDownTimer(long j11, long j12) {
            super(j11, j12);
        }

        public void onFinish() {
            if (VerifyActivity.this.txRequest != null) {
                VerifyActivity.this.txRequest.setClickable(true);
                VerifyActivity.this.txRequest.setText(VerifyActivity.this.getResources().getIdentifier("ali_vsdk_verify_sms_send_code", "string", VerifyActivity.this.getPackageName()));
                VerifyActivity.this.txRequest.setTextColor(Color.parseColor("#1475ea"));
            }
            if (VerifyActivity.this.btnCall != null) {
                VerifyActivity.this.btnCall.setVisibility(0);
            }
            VerifyActivity.access$3406();
        }

        public void onTick(long j11) {
            if (VerifyActivity.this.txRequest != null) {
                TextView access$3300 = VerifyActivity.this.txRequest;
                VerifyActivity verifyActivity = VerifyActivity.this;
                access$3300.setText(verifyActivity.getString(verifyActivity.getResources().getIdentifier("ali_vsdk_verify_sms_timeout", "string", VerifyActivity.this.getPackageName()), new Object[]{Long.valueOf(j11 / 1000)}));
                VerifyActivity.this.txRequest.setTextColor(Color.parseColor("#adadad"));
            }
        }
    }

    public static /* synthetic */ int access$3406() {
        int i11 = retryCount - 1;
        retryCount = i11;
        return i11;
    }

    public static void finishVerifyUI() {
        Activity activity = verifyActivity;
        if (activity != null) {
            activity.finish();
        }
        verifyActivity = null;
    }

    /* access modifiers changed from: private */
    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager.isActive() && getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
    }

    public static void initWithWsg(Context context, IActivityCallback iActivityCallback, String str, String str2) {
        try {
            SecurityGuardManager instance = SecurityGuardManager.getInstance(context);
            String sDKVerison = instance.getSDKVerison();
            if (TextUtils.isEmpty(sDKVerison) || !VersionUtil.isVersionUpdate(sDKVerison, BuildConfig.DEP)) {
                throw new RuntimeException("SecurityGuardxxx.jar/aar with wrong version, now is5.3.38,at least should be:" + sDKVerison);
            }
            IStaticDataStoreComponent staticDataStoreComp = instance.getStaticDataStoreComp();
            if (staticDataStoreComp != null) {
                appkey = str2;
                AUTHCODE = str;
                try {
                    String extraData = staticDataStoreComp.getExtraData("asfkey", str);
                    if (!TextUtils.isEmpty(extraData)) {
                        asfKey = extraData;
                        callback = iActivityCallback;
                        return;
                    }
                    throw new RuntimeException("Please check yw_" + str + ".jpg errorcode 002");
                } catch (SecException e11) {
                    throw new RuntimeException("Please check yw_" + str + ".jpg getErrorCode:" + e11.getErrorCode());
                }
            } else {
                throw new RuntimeException("Please check yw_" + str + ".jpg errorcode 001");
            }
        } catch (SecException e12) {
            throw new RuntimeException("SecurityGuard with excpetion code:" + e12.getErrorCode());
        }
    }

    /* access modifiers changed from: private */
    public void readResConfig() {
        String readStringFromFile = FileUtil.readStringFromFile(new File(RES_ROOT_PATH + File.separator + AnimatedPasterJsonConfig.FILE_NAME));
        if (!TextUtils.isEmpty(readStringFromFile)) {
            this.resConfig.fromJson(readStringFromFile);
        }
    }

    /* access modifiers changed from: private */
    public void requestCallVerification() {
        this.btnSubmit.setAlpha(1.0f);
        this.btnSubmit.setClickable(true);
        this.btnSubmit.setEnabled(true);
        this.txSubmit.setTextColor(-1);
        TextView textView = (TextView) findViewById(getResources().getIdentifier("tips_sub", "id", getPackageName()));
        this.tipsSubTV = textView;
        textView.setVisibility(0);
        this.txRequest.setClickable(false);
        this.txRequest.setText(getString(getResources().getIdentifier("ali_vsdk_verify_sms_timeout", "string", getPackageName()), new Object[]{60}));
        this.txRequest.setTextColor(Color.parseColor("#adadad"));
        this.requestCountDownTimer.cancel();
        this.requestCountDownTimer.start();
        this.handlerSMSorCallRequest.sendEmptyMessage(SMS_CALL_REQUEST_START);
    }

    private void requestForResources() {
        this.handlerResRequest.sendEmptyMessage(RES_REQUEST_START);
    }

    /* access modifiers changed from: private */
    public void requestForSMSorCallVerification() {
        this.handlerSMSorCallVerification.sendEmptyMessage(SMS_CALL_VERIFY_START);
    }

    /* access modifiers changed from: private */
    public void requestForVerification() {
        this.handler.sendEmptyMessage(10001);
    }

    /* access modifiers changed from: private */
    public void requestSMSVerification() {
        this.txRequest.setClickable(false);
        this.txRequest.setText(getString(getResources().getIdentifier("ali_vsdk_verify_sms_timeout", "string", getPackageName()), new Object[]{60}));
        this.txRequest.setTextColor(Color.parseColor("#adadad"));
        this.requestCountDownTimer.cancel();
        this.requestCountDownTimer.start();
        this.handlerSMSorCallRequest.sendEmptyMessage(SMS_CALL_REQUEST_START);
    }

    public static void setEnv(String str) {
        hostenv = str;
    }

    public static void startSimpleVerifyUI(Context context, VerifyType verifyType2, String str, String str2, IActivityCallback iActivityCallback) {
        try {
            startSimpleVerifyUIInternal(context, verifyType2, iActivityCallback, str, str2);
        } catch (Exception e11) {
            HashMap hashMap = new HashMap();
            hashMap.put("errorMsg", e11.toString());
            hashMap.put("errorCode", "1");
            iActivityCallback.onResult(0, hashMap);
        }
    }

    public static void startSimpleVerifyUIInternal(Context context, VerifyType verifyType2, IActivityCallback iActivityCallback, String str, String str2) throws Exception {
        initWithWsg(context, iActivityCallback, str, str2);
        if (verifyType2 == null) {
            verifyType2 = VerifyType.NOCAPTCHA;
        }
        try {
            context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
        }
        verifyType = verifyType2;
        context.startActivity(new Intent(context, VerifyActivity.class));
    }

    public static void startVerifyUI(Context context, Map<String, String> map, VerifyType verifyType2, String str, String str2, IActivityCallback iActivityCallback) {
        try {
            startVerifyUI_internal(context, map, verifyType2, iActivityCallback, str, str2);
        } catch (Exception e11) {
            HashMap hashMap = new HashMap();
            hashMap.put("errorMsg", e11.toString());
            hashMap.put("errorCode", "1");
            iActivityCallback.onResult(0, hashMap);
        }
    }

    public static void startVerifyUI_internal(Context context, Map<String, String> map, VerifyType verifyType2, IActivityCallback iActivityCallback, String str, String str2) throws Exception {
        initWithWsg(context, iActivityCallback, str, str2);
        if (map == null || map.size() == 0) {
            throw new RuntimeException("Please set parameter!!!");
        } else if (!TextUtils.isEmpty(map.get(APP_DATA))) {
            JSONObject jSONObject = new JSONObject(map.get(APP_DATA));
            String optString = jSONObject.optString(INFO_TOKEN);
            info_token = optString;
            if (!TextUtils.isEmpty(optString)) {
                number = jSONObject.optString("phone");
                callback = iActivityCallback;
                if (verifyType2 == null) {
                    verifyType2 = VerifyType.NOCAPTCHA;
                }
                try {
                    context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
                } catch (PackageManager.NameNotFoundException e11) {
                    e11.printStackTrace();
                }
                verifyType = verifyType2;
                context.startActivity(new Intent(context, VerifyActivity.class));
                return;
            }
            throw new RuntimeException("Please set Map<String, String> parameters with jsondata, !!!");
        } else {
            throw new RuntimeException("Please set app data!!!");
        }
    }

    /* access modifiers changed from: private */
    public void targetInBoundary() {
        this.handler.sendEmptyMessage(100001);
    }

    /* access modifiers changed from: private */
    public void targetOutBoundary() {
        this.handler.sendEmptyMessage(100002);
    }

    /* access modifiers changed from: private */
    public String toHexString(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (int i11 = 0; i11 < bArr.length; i11++) {
            sb2.append(cArr[(bArr[i11] & 240) >>> 4]);
            sb2.append(cArr[bArr[i11] & 15]);
        }
        return sb2.toString();
    }

    private void toggerKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager.isActive()) {
            inputMethodManager.toggleSoftInput(1, 2);
        }
    }

    public void addroot(View view) {
        try {
            this.root.addView(view);
        } catch (Exception unused) {
        }
    }

    public int getStatusBarHeight() {
        int dimensionPixelSize = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
        Log.i(LOG_TAG, "get status bar height : " + dimensionPixelSize);
        return dimensionPixelSize;
    }

    public void initAfterSGInit() {
        String str = getFilesDir().getAbsolutePath() + File.separator + "res";
        RES_ROOT_PATH = str;
        this.resConfig = new ResConfig(this, str);
        this.sharedPreferences = getPreferences(0);
        requestForResources();
        try {
            this.ncComponent = SecurityGuardManager.getInstance(getApplicationContext()).getNoCaptchaComp();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        this.refreshCountDownTimer = new RefreshCountDownTimer(60000, 1000);
    }

    public void initCallUI() {
        retryCount = 3;
        setContentView(getResources().getIdentifier("ali_vsdk_activity_verify_call", TtmlNode.TAG_LAYOUT, getPackageName()));
        EditText editText = (EditText) findViewById(getResources().getIdentifier("number_et", "id", getPackageName()));
        this.etNumber = editText;
        editText.setText(number);
        this.etNumber.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        this.etCode = (EditText) findViewById(getResources().getIdentifier("code_et", "id", getPackageName()));
        View findViewById = findViewById(getResources().getIdentifier("left_top_layout", "id", getPackageName()));
        this.back = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (VerifyActivity.callback != null) {
                    VerifyActivity.callback.onNotifyBackPressed();
                }
                VerifyActivity.this.finish();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        View findViewById2 = findViewById(getResources().getIdentifier("btn_submit", "id", getPackageName()));
        this.btnSubmit = findViewById2;
        findViewById2.setEnabled(false);
        this.btnSubmit.setClickable(false);
        this.txSubmit = (TextView) findViewById(getResources().getIdentifier("submit_tx", "id", getPackageName()));
        this.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                VerifyActivity.this.hideKeyboard();
                if (TextUtils.isEmpty(VerifyActivity.this.etCode.getText().toString())) {
                    VerifyActivity verifyActivity = VerifyActivity.this;
                    Toast.makeText(verifyActivity, verifyActivity.getResources().getIdentifier("ali_vsdk_verify_no_code", "string", VerifyActivity.this.getPackageName()), 1).show();
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
                VerifyActivity.this.btnSubmit.setClickable(false);
                VerifyActivity.this.requestForSMSorCallVerification();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.etCode.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                VerifyActivity.this.hideKeyboard();
                if (i11 != VerifyActivity.this.getResources().getIdentifier("submit", "id", VerifyActivity.this.getPackageName()) && i11 != 0) {
                    return false;
                }
                if (TextUtils.isEmpty(VerifyActivity.this.etCode.getText().toString())) {
                    VerifyActivity verifyActivity = VerifyActivity.this;
                    Toast.makeText(verifyActivity, verifyActivity.getResources().getIdentifier("ali_vsdk_verify_no_code", "string", VerifyActivity.this.getPackageName()), 1).show();
                    return true;
                }
                VerifyActivity.this.btnSubmit.setClickable(false);
                VerifyActivity.this.requestForSMSorCallVerification();
                return true;
            }
        });
        this.submitLoading = (ALiLoadingView) findViewById(getResources().getIdentifier("submit_loading", "id", getPackageName()));
        this.txRequest = (TextView) findViewById(getResources().getIdentifier("verify_send_code", "id", getPackageName()));
        this.requestCountDownTimer = new RequestCountDownTimer(60000, 1000);
        this.txRequest.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                VerifyActivity.this.requestCallVerification();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        final AlertDialog create = new AlertDialog.Builder(this).create();
        create.show();
        create.getWindow().setContentView(getResources().getIdentifier("ali_vsdk_call_tips", TtmlNode.TAG_LAYOUT, getPackageName()));
        ((TextView) create.getWindow().findViewById(getResources().getIdentifier("message", "id", getPackageName()))).setText(getResources().getIdentifier("ali_vsdk_verify_call_goto_tips", "string", getPackageName()));
        create.getWindow().findViewById(getResources().getIdentifier(BaseHbgResponse.STATUS_OK, "id", getPackageName())).setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                VerifyActivity.this.requestCallVerification();
                create.dismiss();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        create.getWindow().findViewById(getResources().getIdentifier("cancel", "id", getPackageName())).setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                create.dismiss();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        ImageView imageView = (ImageView) findViewById(getResources().getIdentifier(OptionsBridge.LOGO_KEY, "id", getPackageName()));
        this.logo = imageView;
        this.resConfig.setImageDrawable(imageView, "MSA_logo_power_by", getResources().getIdentifier("ali_vsdk_logo", "drawable", getPackageName()));
    }

    public void initNoCaptchaUI() {
        setContentView(getResources().getIdentifier("ali_vsdk_activity_verify_nocaptcha", TtmlNode.TAG_LAYOUT, getPackageName()));
        ALiLoadingView aLiLoadingView2 = (ALiLoadingView) findViewById(getResources().getIdentifier("check_login_loading", "id", getPackageName()));
        this.aLiLoadingView = aLiLoadingView2;
        aLiLoadingView2.startRotationAnimation();
        this.root = (FrameLayout) findViewById(getResources().getIdentifier("root", "id", getPackageName()));
        View findViewById = findViewById(getResources().getIdentifier("left_top_layout", "id", getPackageName()));
        this.back = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (VerifyActivity.callback != null) {
                    VerifyActivity.callback.onNotifyBackPressed();
                }
                VerifyActivity.this.finish();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.tipsTV = (TextView) findViewById(getResources().getIdentifier("tips", "id", getPackageName()));
        this.tipsSubTV = (TextView) findViewById(getResources().getIdentifier("tips_sub", "id", getPackageName()));
        LinearLayout linearLayout = (LinearLayout) findViewById(getResources().getIdentifier("content", "id", getPackageName()));
        this.content = linearLayout;
        linearLayout.setVisibility(4);
        this.draw = new BallView(this);
        this.f14756lp = new FrameLayout.LayoutParams(-2, -2);
        DisplayMetrics displayMetrics = getApplicationContext().getResources().getDisplayMetrics();
        mScreenWidth = displayMetrics.widthPixels;
        mScreenHeight = displayMetrics.heightPixels;
        Log.i(LOG_TAG, "displayMetrics.widthPixels: " + displayMetrics.widthPixels + " displayMetrics.heightPixels: " + displayMetrics.heightPixels);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        Log.i(LOG_TAG, "displayMetrics.widthPixels: " + displayMetrics2.widthPixels + " displayMetrics.heightPixels: " + displayMetrics2.heightPixels);
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(defaultDisplay, new Object[]{displayMetrics2});
            Log.i(LOG_TAG, "displayMetrics.widthPixels: " + displayMetrics2.widthPixels + " displayMetrics.heightPixels: " + displayMetrics2.heightPixels);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        Log.i(LOG_TAG, "displayMetrics.densityDpi: " + displayMetrics2.densityDpi);
        Log.i(LOG_TAG, "onCreate root.getTop(): " + this.root.getTop() + " root.getBottom(): " + this.root.getBottom());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onCreate orientation: ");
        sb2.append(getResources().getConfiguration().orientation == 2 ? "landscape" : "portrait");
        Log.i(LOG_TAG, sb2.toString());
        int i11 = mScreenWidth;
        int i12 = mScreenHeight;
        if (i11 > i12) {
            mScreenHeight = i11;
            mScreenWidth = i12;
        }
        ImageView imageView = (ImageView) findViewById(getResources().getIdentifier(OptionsBridge.LOGO_KEY, "id", getPackageName()));
        this.logo = imageView;
        this.resConfig.setImageDrawable(imageView, "MSA_logo_power_by", getResources().getIdentifier("ali_vsdk_logo", "drawable", getPackageName()));
        this.frame = new DrawView(this);
        this.draw.setOnTouchListener(new View.OnTouchListener() {
            /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
                if (r6 != 3) goto L_0x0211;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
                /*
                    r5 = this;
                    int r6 = r7.getAction()
                    r0 = 0
                    r1 = 1
                    if (r6 == 0) goto L_0x018a
                    if (r6 == r1) goto L_0x011e
                    r2 = 2
                    if (r6 == r2) goto L_0x0012
                    r0 = 3
                    if (r6 == r0) goto L_0x011e
                    goto L_0x0211
                L_0x0012:
                    float r6 = r7.getX()
                    com.alibaba.verificationsdk.ui.VerifyActivity r2 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    com.alibaba.verificationsdk.widgets.BallView r2 = r2.draw
                    float r2 = r2.getRadiusTouch()
                    int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                    if (r6 < 0) goto L_0x011d
                    float r6 = r7.getX()
                    int r2 = com.alibaba.verificationsdk.ui.VerifyActivity.mScreenWidth
                    float r2 = (float) r2
                    com.alibaba.verificationsdk.ui.VerifyActivity r3 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    com.alibaba.verificationsdk.widgets.BallView r3 = r3.draw
                    float r3 = r3.getRadiusTouch()
                    float r2 = r2 - r3
                    int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                    if (r6 <= 0) goto L_0x003e
                    goto L_0x011d
                L_0x003e:
                    float r6 = r7.getY()
                    com.alibaba.verificationsdk.ui.VerifyActivity r2 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    com.alibaba.verificationsdk.widgets.BallView r2 = r2.draw
                    float r2 = r2.getRadiusTouch()
                    int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                    if (r6 < 0) goto L_0x011d
                    float r6 = r7.getY()
                    com.alibaba.verificationsdk.ui.VerifyActivity r2 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    android.widget.FrameLayout r2 = r2.root
                    int r2 = r2.getBottom()
                    com.alibaba.verificationsdk.ui.VerifyActivity r3 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    android.widget.FrameLayout r3 = r3.root
                    int r3 = r3.getTop()
                    int r2 = r2 - r3
                    float r2 = (float) r2
                    com.alibaba.verificationsdk.ui.VerifyActivity r3 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    com.alibaba.verificationsdk.widgets.BallView r3 = r3.draw
                    float r3 = r3.getRadiusTouch()
                    float r2 = r2 - r3
                    int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                    if (r6 <= 0) goto L_0x007b
                    goto L_0x011d
                L_0x007b:
                    com.alibaba.verificationsdk.ui.VerifyActivity r6 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    boolean r6 = r6.isFingerValid
                    if (r6 != 0) goto L_0x0084
                    return r1
                L_0x0084:
                    com.alibaba.verificationsdk.ui.VerifyActivity r6 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    com.alibaba.verificationsdk.widgets.BallView r6 = r6.draw
                    float r2 = r7.getX()
                    float r3 = r7.getY()
                    r6.setPosition(r2, r3)
                    com.alibaba.verificationsdk.ui.VerifyActivity r6 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    com.alibaba.verificationsdk.widgets.BallView r6 = r6.draw
                    r6.invalidate()
                    com.alibaba.verificationsdk.ui.VerifyActivity r6 = com.alibaba.verificationsdk.ui.VerifyActivity.this     // Catch:{ Exception -> 0x00a8 }
                    com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent r6 = r6.ncComponent     // Catch:{ Exception -> 0x00a8 }
                    r6.putNoCaptchaTraceRecord(r7)     // Catch:{ Exception -> 0x00a8 }
                    goto L_0x00ac
                L_0x00a8:
                    r6 = move-exception
                    r6.printStackTrace()
                L_0x00ac:
                    float r6 = r7.getX()
                    com.alibaba.verificationsdk.ui.VerifyActivity r2 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    com.alibaba.verificationsdk.widgets.DrawView r2 = r2.frame
                    float r2 = r2.getBoundaryLeft()
                    int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                    if (r6 < 0) goto L_0x0109
                    float r6 = r7.getX()
                    com.alibaba.verificationsdk.ui.VerifyActivity r2 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    com.alibaba.verificationsdk.widgets.DrawView r2 = r2.frame
                    float r2 = r2.getBoundaryRight()
                    int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                    if (r6 > 0) goto L_0x0109
                    float r6 = r7.getY()
                    com.alibaba.verificationsdk.ui.VerifyActivity r2 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    com.alibaba.verificationsdk.widgets.DrawView r2 = r2.frame
                    float r2 = r2.getBoundaryTop()
                    int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                    if (r6 < 0) goto L_0x0109
                    float r6 = r7.getY()
                    com.alibaba.verificationsdk.ui.VerifyActivity r7 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    com.alibaba.verificationsdk.widgets.DrawView r7 = r7.frame
                    float r7 = r7.getBoundaryBottom()
                    int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
                    if (r6 > 0) goto L_0x0109
                    com.alibaba.verificationsdk.ui.VerifyActivity r6 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    boolean r6 = r6.isFingerValid
                    if (r6 != 0) goto L_0x00fd
                    return r1
                L_0x00fd:
                    com.alibaba.verificationsdk.ui.VerifyActivity r6 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    r6.targetInBoundary()
                    com.alibaba.verificationsdk.ui.VerifyActivity r6 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    boolean unused = r6.isInBoundary = r1
                    goto L_0x0211
                L_0x0109:
                    com.alibaba.verificationsdk.ui.VerifyActivity r6 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    boolean r6 = r6.isInBoundary
                    if (r6 == 0) goto L_0x0211
                    com.alibaba.verificationsdk.ui.VerifyActivity r6 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    boolean unused = r6.isInBoundary = r0
                    com.alibaba.verificationsdk.ui.VerifyActivity r6 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    r6.targetOutBoundary()
                    goto L_0x0211
                L_0x011d:
                    return r1
                L_0x011e:
                    float r6 = r7.getX()
                    com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    com.alibaba.verificationsdk.widgets.DrawView r0 = r0.frame
                    float r0 = r0.getBoundaryLeft()
                    int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
                    if (r6 < 0) goto L_0x0176
                    float r6 = r7.getX()
                    com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    com.alibaba.verificationsdk.widgets.DrawView r0 = r0.frame
                    float r0 = r0.getBoundaryRight()
                    int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
                    if (r6 > 0) goto L_0x0176
                    float r6 = r7.getY()
                    com.alibaba.verificationsdk.ui.VerifyActivity r0 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    com.alibaba.verificationsdk.widgets.DrawView r0 = r0.frame
                    float r0 = r0.getBoundaryTop()
                    int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
                    if (r6 < 0) goto L_0x0176
                    float r6 = r7.getY()
                    com.alibaba.verificationsdk.ui.VerifyActivity r7 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    com.alibaba.verificationsdk.widgets.DrawView r7 = r7.frame
                    float r7 = r7.getBoundaryBottom()
                    int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
                    if (r6 > 0) goto L_0x0176
                    com.alibaba.verificationsdk.ui.VerifyActivity r6 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    boolean r6 = r6.isFingerValid
                    if (r6 != 0) goto L_0x016f
                    return r1
                L_0x016f:
                    com.alibaba.verificationsdk.ui.VerifyActivity r6 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    r6.requestForVerification()
                    goto L_0x0211
                L_0x0176:
                    com.alibaba.verificationsdk.ui.VerifyActivity r6 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    com.alibaba.verificationsdk.widgets.BallView r6 = r6.draw
                    r6.resetPostion()
                    com.alibaba.verificationsdk.ui.VerifyActivity r6 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    com.alibaba.verificationsdk.widgets.BallView r6 = r6.draw
                    r6.invalidate()
                    goto L_0x0211
                L_0x018a:
                    float r6 = r7.getX()
                    com.alibaba.verificationsdk.ui.VerifyActivity r2 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    com.alibaba.verificationsdk.widgets.BallView r2 = r2.draw
                    float r2 = r2.getInitLeft()
                    int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                    java.lang.String r2 = "isFingerValid = "
                    java.lang.String r3 = "VerifyActivity"
                    if (r6 < 0) goto L_0x01f4
                    float r6 = r7.getX()
                    com.alibaba.verificationsdk.ui.VerifyActivity r4 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    com.alibaba.verificationsdk.widgets.BallView r4 = r4.draw
                    float r4 = r4.getInitRight()
                    int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                    if (r6 > 0) goto L_0x01f4
                    float r6 = r7.getY()
                    com.alibaba.verificationsdk.ui.VerifyActivity r4 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    com.alibaba.verificationsdk.widgets.BallView r4 = r4.draw
                    float r4 = r4.getInitTop()
                    int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                    if (r6 < 0) goto L_0x01f4
                    float r6 = r7.getY()
                    com.alibaba.verificationsdk.ui.VerifyActivity r7 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    com.alibaba.verificationsdk.widgets.BallView r7 = r7.draw
                    float r7 = r7.getInitBottom()
                    int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
                    if (r6 > 0) goto L_0x01f4
                    com.alibaba.verificationsdk.ui.VerifyActivity r6 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    boolean unused = r6.isFingerValid = r1
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    r6.append(r2)
                    com.alibaba.verificationsdk.ui.VerifyActivity r7 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    boolean r7 = r7.isFingerValid
                    r6.append(r7)
                    java.lang.String r6 = r6.toString()
                    com.alibaba.verificationsdk.utils.Log.i(r3, r6)
                    goto L_0x0211
                L_0x01f4:
                    com.alibaba.verificationsdk.ui.VerifyActivity r6 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    boolean unused = r6.isFingerValid = r0
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    r6.append(r2)
                    com.alibaba.verificationsdk.ui.VerifyActivity r7 = com.alibaba.verificationsdk.ui.VerifyActivity.this
                    boolean r7 = r7.isFingerValid
                    r6.append(r7)
                    java.lang.String r6 = r6.toString()
                    com.alibaba.verificationsdk.utils.Log.i(r3, r6)
                L_0x0211:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.alibaba.verificationsdk.ui.VerifyActivity.AnonymousClass4.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
        FrameLayout frameLayout = new FrameLayout(this);
        this.refreshBg = frameLayout;
        frameLayout.setBackgroundColor(-1);
        this.refreshBg.setAlpha(0.94f);
        Button button = new Button(this);
        this.refresh = button;
        button.setTextColor(Color.parseColor("#56adff"));
        this.refresh.setTextSize(19.0f);
        this.refresh.setText(getResources().getIdentifier("ali_vsdk_refresh", "string", getPackageName()));
        this.refresh.setSingleLine(true);
        this.refresh.setBackgroundResource(getResources().getIdentifier("ali_vsdk_rect_blue", "drawable", getPackageName()));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.refresh.setPadding(60, 20, 60, 20);
        this.refreshBg.addView(this.refresh, layoutParams);
        this.refreshBg.setClickable(true);
        this.refreshBg.setEnabled(true);
        this.refresh.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (VerifyActivity.this.root != null) {
                    VerifyActivity.this.root.removeView(VerifyActivity.this.refreshBg);
                    VerifyActivity.this.root.invalidate();
                    VerifyActivity.this.initUI(VerifyActivity.verifyType);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        getWindow().getDecorView().post(new Runnable() {
            public void run() {
                VerifyActivity verifyActivity = VerifyActivity.this;
                verifyActivity.handler.post(verifyActivity.initTask);
            }
        });
    }

    public void initSMSUI() {
        retryCount = 3;
        setContentView(getResources().getIdentifier("ali_vsdk_activity_verify_sms", TtmlNode.TAG_LAYOUT, getPackageName()));
        EditText editText = (EditText) findViewById(getResources().getIdentifier("number_et", "id", getPackageName()));
        this.etNumber = editText;
        editText.setText(number);
        this.etNumber.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        this.etCode = (EditText) findViewById(getResources().getIdentifier("code_et", "id", getPackageName()));
        View findViewById = findViewById(getResources().getIdentifier("left_top_layout", "id", getPackageName()));
        this.back = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (VerifyActivity.callback != null) {
                    VerifyActivity.callback.onNotifyBackPressed();
                }
                VerifyActivity.this.finish();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.btnSubmit = findViewById(getResources().getIdentifier("btn_submit", "id", getPackageName()));
        this.txSubmit = (TextView) findViewById(getResources().getIdentifier("submit_tx", "id", getPackageName()));
        this.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                VerifyActivity.this.hideKeyboard();
                if (TextUtils.isEmpty(VerifyActivity.this.etCode.getText().toString())) {
                    VerifyActivity verifyActivity = VerifyActivity.this;
                    Toast.makeText(verifyActivity, verifyActivity.getResources().getIdentifier("ali_vsdk_verify_no_code", "string", VerifyActivity.this.getPackageName()), 1).show();
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
                VerifyActivity.this.btnSubmit.setClickable(false);
                VerifyActivity.this.requestForSMSorCallVerification();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.etCode.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                VerifyActivity.this.hideKeyboard();
                if (i11 != VerifyActivity.this.getResources().getIdentifier("submit", "id", VerifyActivity.this.getPackageName()) && i11 != 0) {
                    return false;
                }
                if (TextUtils.isEmpty(VerifyActivity.this.etCode.getText().toString())) {
                    VerifyActivity verifyActivity = VerifyActivity.this;
                    Toast.makeText(verifyActivity, verifyActivity.getResources().getIdentifier("ali_vsdk_verify_no_code", "string", VerifyActivity.this.getPackageName()), 1).show();
                    return true;
                }
                VerifyActivity.this.btnSubmit.setClickable(false);
                VerifyActivity.this.requestForSMSorCallVerification();
                return true;
            }
        });
        this.submitLoading = (ALiLoadingView) findViewById(getResources().getIdentifier("submit_loading", "id", getPackageName()));
        View findViewById2 = findViewById(getResources().getIdentifier("btn_call", "id", getPackageName()));
        this.btnCall = findViewById2;
        findViewById2.setVisibility(4);
        this.btnCall.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (VerifyActivity.this.requestCountDownTimer != null) {
                    VerifyActivity.this.requestCountDownTimer.cancel();
                }
                VerifyActivity.this.initUI(VerifyType.CALL);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.txRequest = (TextView) findViewById(getResources().getIdentifier("verify_send_code", "id", getPackageName()));
        this.requestCountDownTimer = new RequestCountDownTimer(60000, 1000);
        this.txRequest.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                VerifyActivity.this.requestSMSVerification();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        ImageView imageView = (ImageView) findViewById(getResources().getIdentifier(OptionsBridge.LOGO_KEY, "id", getPackageName()));
        this.logo = imageView;
        this.resConfig.setImageDrawable(imageView, "MSA_logo_power_by", getResources().getIdentifier("ali_vsdk_logo", "drawable", getPackageName()));
        requestSMSVerification();
    }

    public void initUI(VerifyType verifyType2) {
        verifyType = verifyType2;
        int i11 = AnonymousClass25.$SwitchMap$com$alibaba$verificationsdk$ui$VerifyType[verifyType.ordinal()];
        if (i11 == 1) {
            initNoCaptchaUI();
        } else if (i11 == 2) {
            initSMSUI();
        } else if (i11 == 3) {
            initCallUI();
        }
    }

    public int map2GenericCode(int i11) {
        return (i11 == 104 || i11 == 105) ? 0 : 1;
    }

    public void onBackPressed() {
        IActivityCallback iActivityCallback = callback;
        if (iActivityCallback != null) {
            iActivityCallback.onNotifyBackPressed();
        }
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        verifyActivity = this;
        setContentView(getResources().getIdentifier("ali_vsdk_activity_verify", TtmlNode.TAG_LAYOUT, getPackageName()));
        ALiLoadingView aLiLoadingView2 = (ALiLoadingView) findViewById(getResources().getIdentifier("check_login_loading", "id", getPackageName()));
        this.aLiLoadingView = aLiLoadingView2;
        aLiLoadingView2.startRotationAnimation();
        statSGInit(getApplicationContext());
    }

    public void onDestroy() {
        super.onDestroy();
        RequestCountDownTimer requestCountDownTimer2 = this.requestCountDownTimer;
        if (requestCountDownTimer2 != null) {
            requestCountDownTimer2.cancel();
        }
        RefreshCountDownTimer refreshCountDownTimer2 = this.refreshCountDownTimer;
        if (refreshCountDownTimer2 != null) {
            refreshCountDownTimer2.cancel();
        }
    }

    @SensorsDataInstrumented
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PushAutoTrackHelper.onNewIntent(this, intent);
    }

    public void onResume() {
        super.onResume();
        if (this.root != null) {
            Log.i(LOG_TAG, "onResume root.getTop(): " + this.root.getTop() + " root.getBottom(): " + this.root.getBottom());
        }
    }

    public void onStart() {
        super.onStart();
        if (this.root != null) {
            Log.i(LOG_TAG, "onStart root.getTop(): " + this.root.getTop() + " root.getBottom(): " + this.root.getBottom());
        }
    }

    public void onStop() {
        super.onStop();
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacks(this.initTask);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void removeBall() {
        this.root.removeView(this.draw);
        this.frame.clearAnimation();
        this.root.removeView(this.frame);
    }

    public void statSGInit(Context context) {
        if (sgInited) {
            initAfterSGInit();
            return;
        }
        try {
            SecurityGuardManager.getInstance(context).getUMIDComp().initUMID(0, new OnInitFinishListener());
        } catch (SecException e11) {
            HashMap hashMap = new HashMap();
            hashMap.put("errorCode", String.valueOf(e11.getErrorCode()));
            callback.onResult(0, hashMap);
        }
    }

    public void addroot(View view, FrameLayout.LayoutParams layoutParams) {
        try {
            this.root.addView(view, layoutParams);
        } catch (Exception unused) {
        }
    }
}
