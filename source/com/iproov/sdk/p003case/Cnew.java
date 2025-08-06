package com.iproov.sdk.p003case;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.huobi.vulcan.model.VulcanInfo;
import com.iproov.sdk.R;
import com.iproov.sdk.core.Cfor;
import com.iproov.sdk.p017implements.Cimport;
import com.jumio.core.environment.Environment;
import com.sumsub.sentry.a;
import com.sumsub.sentry.q;
import com.sumsub.sns.internal.core.common.n0;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyEnum;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.d0;

/* renamed from: com.iproov.sdk.case.new  reason: invalid class name and invalid package */
public final class Cnew {

    /* renamed from: do  reason: not valid java name */
    public static final Cnew f170do = new Cnew();

    /* renamed from: com.iproov.sdk.case.new$do  reason: invalid class name */
    public /* synthetic */ class Cdo {

        /* renamed from: do  reason: not valid java name */
        public static final /* synthetic */ int[] f171do;

        static {
            int[] iArr = new int[Cdo.values().length];
            iArr[Cdo.LIVENESS.ordinal()] = 1;
            iArr[Cdo.GENUINE_PRESENCE_ASSURANCE.ordinal()] = 2;
            f171do = iArr;
        }
    }

    private Cnew() {
    }

    /* renamed from: do  reason: not valid java name */
    public final String m242do(Context context, Cfor forR, double d11, Cdo doVar) {
        int i11;
        if (d11 < 0.75d) {
            return context.getResources().getString(R.string.iproov__progress_streaming);
        }
        if (d11 < 0.875d) {
            if (forR == Cfor.ENROL) {
                return context.getResources().getString(R.string.iproov__progress_finding_face);
            }
            return context.getResources().getString(R.string.iproov__progress_identifying_face);
        } else if (d11 < 0.94d) {
            if (forR == Cfor.ENROL) {
                return context.getResources().getString(R.string.iproov__progress_creating_identity);
            }
            return context.getResources().getString(R.string.iproov__progress_confirming_identity);
        } else if (d11 >= 0.975d) {
            return context.getResources().getString(R.string.iproov__progress_loading);
        } else {
            if (doVar == null) {
                i11 = -1;
            } else {
                i11 = Cdo.f171do[doVar.ordinal()];
            }
            if (i11 == 1) {
                return context.getResources().getString(R.string.iproov__progress_assessing_liveness);
            }
            if (i11 != 2) {
                return context.getResources().getString(R.string.iproov__progress_assessing_genuine_presence);
            }
            return context.getResources().getString(R.string.iproov__progress_assessing_genuine_presence);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public final int m241do(char c11) {
        if (c11 == '1') {
            return R.color.iproov__white;
        }
        if (c11 == '0') {
            return R.color.iproov__black;
        }
        if (c11 == 'b') {
            return R.color.iproov__blue;
        }
        if (c11 == 'c') {
            return R.color.iproov__cyan;
        }
        if (c11 == 'g') {
            return R.color.iproov__green;
        }
        if (c11 == 'm') {
            return R.color.iproov__magenta;
        }
        if (c11 == 'r') {
            return R.color.iproov__red;
        }
        if (c11 == 'y') {
            return R.color.iproov__yellow;
        }
        return R.color.iproov__black;
    }

    /* renamed from: do  reason: not valid java name */
    public final Map<String, String> m243do(Context context, String str, Cfor forR) {
        Point point = m240do(context);
        HashMap hashMap = new HashMap();
        hashMap.put("platform", n0.f32119g);
        hashMap.put("dt", com.iproov.sdk.p009do.Cdo.m566do(context) ? "dyn" : a.f30241h);
        hashMap.put("name", Build.MODEL);
        hashMap.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.BRAND);
        hashMap.put("language", Locale.getDefault().getLanguage());
        hashMap.put("language_file", context.getResources().getString(R.string.iproov__language_file));
        hashMap.put("manufacturer", Build.MANUFACTURER);
        hashMap.put(q.f30469g, Build.DISPLAY);
        hashMap.put("type", Build.DEVICE);
        hashMap.put(VulcanInfo.DPI, context.getResources().getDisplayMetrics().toString());
        hashMap.put("width", String.valueOf(point.x));
        hashMap.put("height", String.valueOf(point.y));
        hashMap.put("version", Build.VERSION.RELEASE);
        hashMap.put("details", Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "android_id"));
        hashMap.put(Constants.IDENTIFIER, Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "android_id"));
        hashMap.put("app_id", context.getPackageName());
        d0 d0Var = d0.f56774a;
        hashMap.put(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_APP_VERSION, String.format(TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(Cimport.m1014do(context))}, 1)));
        hashMap.put(TPDownloadProxyEnum.USER_APP_VERSION, Cimport.m1019if(context));
        hashMap.put(HianalyticsBaseData.SDK_VERSION, Environment.IPROOV_VERSION);
        hashMap.put("token", str);
        hashMap.put("language_version", "0.9.25");
        hashMap.put("gaze_x_buffer", "0.045");
        hashMap.put("transport", "websockets");
        hashMap.put("device_id", com.iproov.sdk.p019interface.Cdo.m1095do(context));
        hashMap.put("variant", forR.f304do.f308do);
        return hashMap;
    }

    /* renamed from: do  reason: not valid java name */
    private final Point m240do(Context context) {
        Object systemService = context.getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }
}
