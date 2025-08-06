package com.huawei.face.antispoofing.sdk;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Environment;
import cg.b;
import cg.c;
import com.facebook.internal.NativeProtocol;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.huawei.face.antispoofing.exception.ValidateException;
import com.huawei.face.antispoofing.helper.ResourceMatcher;
import com.huawei.face.antispoofing.http.ValidateCodeEnum;
import com.huawei.face.antispoofing.jni.ErrorCodeEnum;
import com.huawei.face.antispoofing.jni.FaceAntispoofingWrapper;
import com.huawei.face.antispoofing.listener.FaceAntispoofingResultListener;
import com.huawei.face.antispoofing.meta.DetectErrorEnum;
import com.huawei.face.antispoofing.meta.DetectResult;
import com.huawei.face.antispoofing.meta.DetectTypeEnum;
import com.huawei.face.antispoofing.service.DetectorSession;
import com.huawei.face.antispoofing.service.NoCacheTaskExecutor;
import com.huawei.face.antispoofing.utils.HttpUtil;
import com.huawei.face.antispoofing.utils.ImageProcessUtils;
import com.huawei.face.antispoofing.utils.LogFace;
import com.huawei.face.antispoofing.utils.ModelFileUtils;
import com.huawei.face.antispoofing.utils.ThreadUtils;
import com.huochat.community.network.domain.DomainTool;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Response;
import org.json.JSONObject;
import org.opencv.core.Mat;

public class FaceAntispoofingSdk {
    public static final String LOCALE = "zh";
    public static boolean LOG = true;

    /* renamed from: l  reason: collision with root package name */
    private static final FaceAntispoofingSdk f37572l = new FaceAntispoofingSdk();

    /* renamed from: a  reason: collision with root package name */
    public boolean f37573a;

    /* renamed from: b  reason: collision with root package name */
    public InputData f37574b;

    /* renamed from: c  reason: collision with root package name */
    public FaceAntispoofingResultListener f37575c;

    /* renamed from: d  reason: collision with root package name */
    private volatile DetectorSession f37576d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f37577e = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public FaceAntispoofingWrapper f37578f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public volatile Mat f37579g;

    /* renamed from: h  reason: collision with root package name */
    private ErrorCodeEnum f37580h = ErrorCodeEnum.NO_ERROR;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ImageProcessUtils f37581i;

    /* renamed from: j  reason: collision with root package name */
    private final NoCacheTaskExecutor f37582j = new NoCacheTaskExecutor();

    /* renamed from: k  reason: collision with root package name */
    private Activity f37583k;

    public static class InputData implements Serializable {
        public String apiEndpoint = "";
        public String apiVersion = "";
        public float confidenceThred = 0.5f;
        public int detectTimes = 2;
        public List<DetectTypeEnum> detectTypeList = Collections.emptyList();
        @Deprecated
        public String orderId = "";
        public String projectId = "";
        public String sdkLicence = "";
        public String sdkToken = "";
        public int timeoutMs = DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS;
        @Deprecated
        public String token = "";
    }

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bitmap f37584b;

        public a(Bitmap bitmap) {
            this.f37584b = bitmap;
        }

        public void run() {
            try {
                FaceAntispoofingSdk.this.f37577e.set(true);
                FaceAntispoofingSdk.a(FaceAntispoofingSdk.this, FaceAntispoofingSdk.this.f37581i.bitmapToBgr(this.f37584b), this.f37584b.getWidth(), this.f37584b.getHeight());
            } finally {
                FaceAntispoofingSdk.this.f37577e.set(false);
            }
        }
    }

    public static /* synthetic */ String a() {
        return "FaceAntispoofingSdk";
    }

    public static FaceAntispoofingSdk getInstance() {
        return f37572l;
    }

    public InputData getInputData() {
        return this.f37574b;
    }

    public FaceAntispoofingResultListener getResultListener() {
        return this.f37575c;
    }

    public boolean initSdk(Activity activity, InputData inputData, String str) {
        this.f37580h = ErrorCodeEnum.NO_ERROR;
        ResourceMatcher.readLocale(activity, str);
        this.f37574b = inputData;
        this.f37583k = activity;
        boolean initSdk = FaceAntispoofingWrapper.initSdk(activity, inputData.sdkLicence);
        this.f37573a = initSdk;
        if (!initSdk) {
            return false;
        }
        String str2 = Environment.getDataDirectory().getAbsolutePath() + "/data/" + this.f37583k.getApplication().getPackageName() + "/models/";
        String str3 = str2 + "facedetector_v1.0.0.mnn";
        String str4 = str2 + "headpose_v1.0.0.mnn";
        String str5 = str2 + "landmark_v1.0.0.mnn";
        LogFace.i("FaceAntispoofingSdk", "[initModels] 复制算法模型" + str2);
        ModelFileUtils.syncModels(this.f37583k, str2, str3, str4, str5);
        LogFace.i("FaceAntispoofingSdk", "[initModels] 初始化算法");
        this.f37578f = new FaceAntispoofingWrapper(str5, str4, str3);
        this.f37581i = new ImageProcessUtils(activity);
        return this.f37573a;
    }

    public boolean isInitializedSucceed() {
        return this.f37573a;
    }

    public void onDetect(byte[] bArr, int i11, int i12) {
        if (this.f37574b == null) {
            throw new ValidateException(ValidateCodeEnum.DATA_REQUIRED);
        } else if (!this.f37577e.get()) {
            this.f37582j.post(new a(this.f37581i.preProcess(this.f37581i.convertYuvToRgb(bArr, i11, i12))));
            if (System.currentTimeMillis() - this.f37576d.getDetectTypeStartTimestamp() > ((long) this.f37574b.timeoutMs) && this.f37576d != null) {
                this.f37576d.removeError();
                this.f37575c.onDetectTimeOut();
            }
        }
    }

    public void restartSession() {
        this.f37580h = ErrorCodeEnum.NO_ERROR;
        this.f37576d = new DetectorSession(this.f37574b, this.f37575c);
    }

    public void startNewSession(FaceAntispoofingResultListener faceAntispoofingResultListener) {
        List<DetectTypeEnum> list;
        this.f37575c = faceAntispoofingResultListener;
        InputData inputData = this.f37574b;
        if (inputData != null) {
            String str = inputData.sdkToken;
            if (str == null || "".equals(str)) {
                throw new ValidateException(ValidateCodeEnum.TOKEN_REQUIRED);
            }
            String str2 = inputData.projectId;
            if (str2 == null || "".equals(str2)) {
                throw new ValidateException(ValidateCodeEnum.PROJECT_ID_REQUIRED);
            }
            String str3 = inputData.apiVersion;
            if (str3 == null || "".equals(str3)) {
                throw new ValidateException(ValidateCodeEnum.API_VERSION_REQUIRED);
            }
            String str4 = inputData.apiEndpoint;
            if (str4 == null || "".equals(str4)) {
                throw new ValidateException(ValidateCodeEnum.API_ENDPOINT_REQUIRED);
            }
            String str5 = inputData.sdkLicence;
            if (str5 == null || "".equals(str5)) {
                throw new ValidateException(ValidateCodeEnum.SDK_LICENSE_REQUIRED);
            } else if (inputData.detectTimes <= 0 && ((list = inputData.detectTypeList) == null || list.size() == 0)) {
                throw new ValidateException(ValidateCodeEnum.DETECTTIMES_POSITIVE_AND_DETECTTYPE_NOT_EMPTY);
            } else if (inputData.timeoutMs <= 0) {
                throw new ValidateException(ValidateCodeEnum.TIMEOUT_MS_MUST_POSITIVE);
            } else if (inputData.confidenceThred > 0.0f) {
                this.f37576d = new DetectorSession(this.f37574b, faceAntispoofingResultListener);
                this.f37582j.start();
            } else {
                throw new ValidateException(ValidateCodeEnum.CONFIDENCE_THREAD_MUST_POSITIVE);
            }
        } else {
            throw new ValidateException(ValidateCodeEnum.DATA_REQUIRED);
        }
    }

    public void stopSession() {
        FaceAntispoofingWrapper faceAntispoofingWrapper = this.f37578f;
        if (faceAntispoofingWrapper != null) {
            faceAntispoofingWrapper.deleteFaceAntispoofingDetector();
        }
        this.f37582j.stop();
    }

    public static /* synthetic */ void a(FaceAntispoofingSdk faceAntispoofingSdk, byte[] bArr, int i11, int i12) {
        DetectTypeEnum currDetectType = faceAntispoofingSdk.f37576d.getCurrDetectType();
        if (currDetectType != null) {
            try {
                ErrorCodeEnum runFaceAntispoofingDetector = faceAntispoofingSdk.f37578f.runFaceAntispoofingDetector(bArr, i11, i12, currDetectType);
                if (runFaceAntispoofingDetector == null) {
                    LogFace.e("FaceAntispoofingSdk", "[doDetect] runFaceAntispoofing errorCode is empty");
                    return;
                }
                if (ErrorCodeEnum.NO_ERROR.equals(runFaceAntispoofingDetector)) {
                    ThreadUtils.getInstance().runOnUiThread(new cg.a(faceAntispoofingSdk, runFaceAntispoofingDetector));
                    if (faceAntispoofingSdk.f37578f.getFaceAntispoofingDetectorResult(currDetectType) && faceAntispoofingSdk.f37576d.onTypeDetected()) {
                        ThreadUtils.getInstance().execute(new c(faceAntispoofingSdk, i11, i12));
                    }
                    faceAntispoofingSdk.f37576d.removeError();
                } else {
                    Map<String, String> matchLocaleMap = ResourceMatcher.getMatchLocaleMap();
                    String str = matchLocaleMap.get("HW_SDK_MSG_" + runFaceAntispoofingDetector.name());
                    faceAntispoofingSdk.f37576d.updateError(str);
                    if (faceAntispoofingSdk.f37580h.getCode() != runFaceAntispoofingDetector.getCode()) {
                        ThreadUtils.getInstance().runOnUiThread(new b(faceAntispoofingSdk, runFaceAntispoofingDetector, str));
                    } else {
                        return;
                    }
                }
                faceAntispoofingSdk.f37580h = runFaceAntispoofingDetector;
            } catch (Exception e11) {
                LogFace.e("FaceAntispoofingSdk", "[doDetect] runFaceAntispoofing error", e11);
            }
        }
    }

    public static /* synthetic */ DetectResult a(FaceAntispoofingSdk faceAntispoofingSdk, String str) {
        String str2 = faceAntispoofingSdk.f37574b.sdkToken;
        StringBuilder c11 = a.a.c(DomainTool.DOMAIN_PREFIX);
        c11.append(faceAntispoofingSdk.f37574b.apiEndpoint);
        c11.append("/");
        c11.append(faceAntispoofingSdk.f37574b.apiVersion);
        c11.append("/");
        c11.append(faceAntispoofingSdk.f37574b.projectId);
        c11.append("/face-detect");
        String sb2 = c11.toString();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("image_base64", str);
            jSONObject.put("sdk_tag", "live-sdk");
            Response doPost = HttpUtil.doPost(sb2, jSONObject.toString(), str2, true, HttpUtil.X_AUTH_TOKEN);
            if (!doPost.isSuccessful()) {
                LogFace.e("FaceAntispoofingSdk", "[sendToRemote] response is not successful.");
                DetectErrorEnum detectErrorEnum = DetectErrorEnum.VerifyErrorServerError;
                Map<String, String> matchLocaleMap = ResourceMatcher.getMatchLocaleMap();
                return DetectResult.failed(detectErrorEnum, matchLocaleMap.get(ResourceMatcher.PREFIX + detectErrorEnum));
            }
            JSONObject jSONObject2 = new JSONObject(doPost.body().string());
            if (jSONObject2.has(NativeProtocol.BRIDGE_ARG_ERROR_CODE)) {
                return faceAntispoofingSdk.a(jSONObject2.getString(NativeProtocol.BRIDGE_ARG_ERROR_CODE), jSONObject2.getString("error_msg"));
            }
            if (jSONObject2.has("result")) {
                return DetectResult.success(str);
            }
            LogFace.e("FaceAntispoofingSdk", "[sendToRemote] unexpected error.");
            DetectErrorEnum detectErrorEnum2 = DetectErrorEnum.VerifyErrorServerError;
            Map<String, String> matchLocaleMap2 = ResourceMatcher.getMatchLocaleMap();
            return DetectResult.failed(detectErrorEnum2, matchLocaleMap2.get(ResourceMatcher.PREFIX + detectErrorEnum2));
        } catch (Exception e11) {
            LogFace.e("FaceAntispoofingSdk", "[sendToRemote] exception info:", e11);
            DetectErrorEnum detectErrorEnum3 = DetectErrorEnum.VerifyErrorServerError;
            Map<String, String> matchLocaleMap3 = ResourceMatcher.getMatchLocaleMap();
            StringBuilder c12 = a.a.c(ResourceMatcher.PREFIX);
            c12.append(detectErrorEnum3);
            return DetectResult.failed(detectErrorEnum3, matchLocaleMap3.get(c12.toString()));
        }
    }

    private DetectResult a(String str, String str2) {
        if ("FRS.0707".equals(str) || "FRS.0709".equals(str) || "FRS.0501".equals(str)) {
            return DetectResult.failed(DetectErrorEnum.VerifyErrorNoFaceOrMoreFace, str2);
        }
        if ("FRS.0708".equals(str)) {
            return DetectResult.failed(DetectErrorEnum.VerifyErrorQualityOrFormatError, str2);
        }
        if ("FRS.0852".equals(str)) {
            return DetectResult.failed(DetectErrorEnum.VerifyErrorIdCardCannotRecognize, str2);
        }
        if ("FRS.0853".equals(str)) {
            return DetectResult.failed(DetectErrorEnum.VerifyErrorFaceDetectError, str2);
        }
        if ("FRS.0013".equals(str) || "FRS.0015".equals(str) || "FRS.0017".equals(str) || "FRS.0851".equals(str)) {
            return DetectResult.failed(DetectErrorEnum.VerifyErrorImageCannotUse, str2);
        }
        if ("FRS.0861".equals(str)) {
            return DetectResult.failed(DetectErrorEnum.VerifyErrorOrderIdIsNoneOrExpired, str2);
        }
        if ("FRS.0018".equals(str)) {
            return DetectResult.failed(DetectErrorEnum.VerifyErrorServerError, str2);
        }
        return DetectResult.failed(DetectErrorEnum.VerifyErrorRemoteError, str2);
    }
}
