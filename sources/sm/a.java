package sm;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.hbg.lib.common.utils.AppUtil;
import com.huawei.face.antispoofing.meta.DetectTypeEnum;
import com.huawei.face.antispoofing.sdk.FaceAntispoofingSdk;
import com.huobi.kyc.huaweiliveness.activity.FaceAntispoofingActivity;
import i6.k;
import java.util.Arrays;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static C0821a f76542a;

    /* renamed from: sm.a$a  reason: collision with other inner class name */
    public interface C0821a {
        void a(boolean z11, String str, String str2);
    }

    public static C0821a a() {
        return f76542a;
    }

    public static FaceAntispoofingSdk.InputData b(String str, String str2) {
        FaceAntispoofingSdk.InputData inputData = new FaceAntispoofingSdk.InputData();
        inputData.sdkLicence = "I+RTF8uYZGPJsYeUq8KRK/vguxS6bEK/OIacJWkx7Pr2vzkShyWoKbfp3qDcvIK7WbTUY4nuoysS2wmWz0rq7uJP2NennAbx2YH9R4yum6dOxCL9Z5ku+k0joj+ZOI9CtXy3kbIYVZE/xo8Jiv4jxY7psuh9sFXLnsEgKOnAbZcWCtq3fmtEcIEFapxLQbi9k2U2XyiFgOVBqzZdK3nRUwPvcXxoqY9MiZd6WnaJ6tGYiou0jc78JDgUGiSRufgW3F5JfWgRX39vbT7yc9LiCB0H/6ajoy5Bo/+deCUqhraFoD9/lrIDRX9zuRFPwgAdvDzXTNtXb9TAOetxabjYeQ==";
        inputData.token = null;
        inputData.projectId = "9d2f814b4db449ab9c5829db84f17923";
        inputData.orderId = String.valueOf(System.currentTimeMillis());
        inputData.apiVersion = "v2";
        inputData.apiEndpoint = str;
        inputData.timeoutMs = DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS;
        inputData.detectTimes = 5;
        inputData.detectTypeList = Arrays.asList(new DetectTypeEnum[]{DetectTypeEnum.blink_eye, DetectTypeEnum.open_mouth});
        try {
            inputData.confidenceThred = TextUtils.isEmpty(str2) ? 0.5f : Float.parseFloat(str2);
        } catch (Exception unused) {
            inputData.confidenceThred = 0.5f;
        }
        return inputData;
    }

    public static void c(C0821a aVar) {
        f76542a = aVar;
    }

    public static void d(String str, String str2, String str3, Activity activity) {
        FaceAntispoofingSdk.InputData b11 = b(str2, str3);
        FaceAntispoofingSdk.LOG = false;
        String g11 = m6.a.g();
        k.o("huawei_liveness", AppUtil.b("start:", g11));
        if (FaceAntispoofingSdk.getInstance().initSdk(activity, b11, g11)) {
            FaceAntispoofingSdk.getInstance().getInputData().sdkToken = str;
            Intent intent = new Intent(activity, FaceAntispoofingActivity.class);
            intent.setFlags(1073741824);
            activity.startActivity(intent);
        }
    }
}
