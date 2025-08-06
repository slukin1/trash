package com.tencent.liteav.txcvodplayer.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.liteav.LiveSettingJni;
import com.tencent.liteav.base.datareport.Event4XReporter;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.sdk.common.LicenseChecker;
import com.tencent.liteav.txcplayer.common.c;
import com.tencent.ugc.datereport.UGCDataReportDef;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public String A;
    public String B;
    public String C = "";
    public int D = 0;
    public int E = 0;
    private boolean F = false;
    private int G = 0;
    private String H;
    private int I = 0;
    private int J;
    private int K;
    private float L = 1.0f;
    private int M;
    private String N;
    private Map<String, String> O;
    private Event4XReporter P;
    private Event4XReporter Q;

    /* renamed from: a  reason: collision with root package name */
    public Context f21834a;

    /* renamed from: b  reason: collision with root package name */
    public String f21835b = null;

    /* renamed from: c  reason: collision with root package name */
    public long f21836c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f21837d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f21838e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21839f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21840g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21841h = false;

    /* renamed from: i  reason: collision with root package name */
    public int f21842i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int f21843j = 0;

    /* renamed from: k  reason: collision with root package name */
    public long f21844k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f21845l = -1;

    /* renamed from: m  reason: collision with root package name */
    public int f21846m = 0;

    /* renamed from: n  reason: collision with root package name */
    public int f21847n = 0;

    /* renamed from: o  reason: collision with root package name */
    public int f21848o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f21849p = false;

    /* renamed from: q  reason: collision with root package name */
    public boolean f21850q = false;

    /* renamed from: r  reason: collision with root package name */
    public boolean f21851r = false;

    /* renamed from: s  reason: collision with root package name */
    public int f21852s = 0;

    /* renamed from: t  reason: collision with root package name */
    public String f21853t = "0";

    /* renamed from: u  reason: collision with root package name */
    public String f21854u = "";

    /* renamed from: v  reason: collision with root package name */
    public String f21855v = "";

    /* renamed from: w  reason: collision with root package name */
    public int f21856w = -1;

    /* renamed from: x  reason: collision with root package name */
    public int f21857x = 0;

    /* renamed from: y  reason: collision with root package name */
    public int f21858y = 0;

    /* renamed from: z  reason: collision with root package name */
    public int f21859z = 0;

    public a(Context context) {
        this.f21834a = context;
        this.H = LiteavSystemInfo.getAppVersion();
        this.N = k();
        String appId = LicenseChecker.getInstance().getAppId();
        LiteavLog.i("VodLicenseCheck", "getLicenseAppId = ".concat(String.valueOf(appId)));
        this.C = appId;
        this.O = new HashMap();
        this.Q = new Event4XReporter(UGCDataReportDef.COMMAND_ID_DAU, 1004, "", true, 1);
    }

    private void g() {
        this.P.setEventStringValue("str_sdk_name", "liteavSdk");
        this.P.setEventStringValue("str_brand_type", LiteavSystemInfo.getBrand());
        this.P.setEventStringValue("str_device_resolution", a(this.f21834a));
        this.P.setEventStringValue("str_device_type", LiteavSystemInfo.getModel());
        this.P.setEventIntValue("u32_network_type", (long) LiteavSystemInfo.getNetworkType());
        String deviceUuid = LiteavSystemInfo.getDeviceUuid();
        this.P.setEventStringValue(UGCDataReportDef.DR_KEY_DEV_UUID, deviceUuid);
        this.P.setEventStringValue("str_app_version", this.H);
        this.P.setEventStringValue("str_app_name", LiteavSystemInfo.getAppName());
        this.P.setEventStringValue(UGCDataReportDef.DR_KEY_SYS_VER, String.valueOf(LiteavSystemInfo.getSystemOSVersionInt()));
        this.P.setEventStringValue("str_stream_url", this.f21835b);
        this.P.setEventStringValue("bytes_token", this.N);
        String userId = LiveSettingJni.getUserId();
        if (TextUtils.isEmpty(userId)) {
            userId = "_".concat(String.valueOf(deviceUuid));
        }
        this.P.setEventStringValue("str_user_id", userId);
        this.P.setEventStringValue("str_package_name", LiteavSystemInfo.getAppPackageName());
        this.P.setEventStringValue("u32_app_id", this.C);
        this.P.setEventStringValue("custom_data", h());
    }

    private String h() {
        if (this.O.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : this.O.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    jSONObject.put(str, str2);
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
            }
        }
        return jSONObject.toString();
    }

    private void i() {
        this.P = new Event4XReporter(40304, 1011, "", true, 1);
        g();
        this.P.setEventIntValue("u32_timeuse", (long) this.G);
        this.P.setEventIntValue("u32_videotime", (long) this.f21842i);
        Event4XReporter event4XReporter = this.P;
        int i11 = this.f21846m;
        long j11 = 0;
        event4XReporter.setEventIntValue("u32_avg_load", i11 == 0 ? 0 : (long) (this.f21847n / i11));
        this.P.setEventIntValue("u32_load_cnt", (long) this.f21846m);
        this.P.setEventIntValue("u32_max_load", (long) this.f21848o);
        this.P.setEventIntValue("u32_avg_block_time", (long) this.f21847n);
        this.P.setEventIntValue("u32_player_type", (long) this.f21852s);
        Event4XReporter event4XReporter2 = this.P;
        int i12 = this.f21858y;
        event4XReporter2.setEventIntValue("u32_dns_time", i12 > 0 ? (long) i12 : 0);
        Event4XReporter event4XReporter3 = this.P;
        int i13 = this.f21857x;
        event4XReporter3.setEventIntValue("u32_tcp_did_connect", i13 > 0 ? (long) i13 : 0);
        Event4XReporter event4XReporter4 = this.P;
        int i14 = this.f21859z;
        if (i14 > 0) {
            j11 = (long) i14;
        }
        event4XReporter4.setEventIntValue("u32_first_video_packet", j11);
        this.P.setEventIntValue("u32_first_i_frame", (long) this.f21845l);
        this.P.setEventStringValue("u32_server_ip", this.A);
        this.P.setEventStringValue("u32_drm_type", this.B);
        this.P.setEventStringValue("str_fileid", this.f21854u);
        this.P.setEventStringValue("u32_playmode", this.f21853t);
        this.P.setEventIntValue("u64_err_code", (long) this.J);
        this.P.setEventStringValue("str_err_info", this.f21855v);
        this.P.setEventIntValue("u32_video_decode_type", (long) this.f21856w);
        this.P.setEventIntValue("u32_speed", (long) ((int) (this.L * 100.0f)));
        this.P.setEventIntValue("vwidth", (long) this.D);
        this.P.setEventIntValue("vheight", (long) this.E);
        this.P.sendReport();
        StringBuilder sb2 = new StringBuilder("[reportEnd] evt 40304: token=");
        sb2.append(this.N);
        sb2.append(" ,dev_uuid=");
        sb2.append(LiteavSystemInfo.getDeviceUuid());
        sb2.append(" ,str_app_version=");
        sb2.append(this.H);
        sb2.append(" ,sys_version=");
        sb2.append(LiteavSystemInfo.getSystemOSVersionInt());
        sb2.append(" ,str_stream_url=");
        sb2.append(this.f21835b);
        sb2.append(" ,u32_timeuse=");
        sb2.append(this.G);
        sb2.append(" ,u32_videotime=");
        sb2.append(this.f21842i);
        sb2.append(" ,u32_avg_load=");
        int i15 = this.f21846m;
        sb2.append(i15 == 0 ? 0 : this.f21847n / i15);
        sb2.append(" ,u32_load_cnt=");
        sb2.append(this.f21846m);
        sb2.append(" ,u32_max_load=");
        sb2.append(this.f21848o);
        sb2.append(" ,u32_avg_block_time=");
        sb2.append(this.f21847n);
        sb2.append(" ,u32_player_type=");
        sb2.append(this.f21852s);
        sb2.append(" ,u32_dns_time=");
        sb2.append(this.f21858y);
        sb2.append(" ,u32_tcp_did_connect=");
        int i16 = this.f21857x;
        int i17 = -1;
        if (i16 <= 0) {
            i16 = -1;
        }
        sb2.append(i16);
        sb2.append(" ,u32_first_video_packet=");
        int i18 = this.f21859z;
        if (i18 > 0) {
            i17 = i18;
        }
        sb2.append(i17);
        sb2.append(" ,u32_first_i_frame=");
        sb2.append(this.f21845l);
        sb2.append(" ,u32_server_ip=");
        sb2.append(this.A);
        sb2.append(" ,u32_drm_type=");
        sb2.append(this.B);
        sb2.append(" ,str_fileid=");
        sb2.append(this.f21854u);
        sb2.append(" ,u32_playmode=");
        sb2.append(this.f21853t);
        sb2.append(" ,u64_err_code=");
        sb2.append(this.J);
        sb2.append(" ,str_err_info=");
        sb2.append(this.f21855v);
        sb2.append(" ,u32_speed=");
        sb2.append(this.L * 100.0f);
        sb2.append(" ,u32_app_id=");
        sb2.append(this.C);
        sb2.append(" ,u32_video_decode_type=");
        sb2.append(this.f21856w);
        sb2.append(" ,custom_data=");
        sb2.append(h());
        sb2.append(" ,vwidth=");
        sb2.append(this.D);
        sb2.append(" ,vheight=");
        sb2.append(this.E);
        LiteavLog.i("TXCVodPlayCollection", sb2.toString());
    }

    private void j() {
        LiteavLog.i("TXCVodPlayCollection", "onSegmentReport");
        this.P = new Event4XReporter(40305, 1011, "", true, 1);
        g();
        this.P.setEventIntValue("u32_videotime", (long) this.f21842i);
        this.P.setEventIntValue("u32_player_type", (long) this.f21852s);
        this.P.setEventStringValue("u32_server_ip", this.A);
        this.P.setEventStringValue("u32_drm_type", this.B);
        this.P.setEventStringValue("str_fileid", this.f21854u);
        this.P.setEventStringValue("u32_playmode", this.f21853t);
        this.P.setEventIntValue("u32_videoindex", (long) this.f21843j);
        this.P.setEventIntValue("u32_realplaytime", this.f21844k / 1000);
        this.P.setEventIntValue("u64_timestamp", System.currentTimeMillis());
        this.P.setEventIntValue("u32_speed", (long) ((int) (this.L * 100.0f)));
        this.P.setEventIntValue("u32_segment_duration", (long) b.a(this.f21834a).a(this.C));
        this.P.sendReport();
        LiteavLog.i("TXCVodPlayCollection", "report evt 40305: token=" + this.N + " ,dev_uuid=" + LiteavSystemInfo.getDeviceUuid() + " ,str_app_version=" + this.H + " ,sys_version=" + LiteavSystemInfo.getSystemOSVersionInt() + " ,str_stream_url=" + this.f21835b + " ,u32_videotime=" + this.f21842i + " ,u32_player_type=" + this.f21852s + " ,u32_server_ip=" + this.A + " ,u32_drm_type=" + this.B + " ,str_fileid=" + this.f21854u + " ,u32_playmode=" + this.f21853t + " ,u32_videoindex=" + this.f21843j + " ,u32_realplaytime=" + (this.f21844k / 1000) + " ,u32_speed=" + (this.L * 100.0f) + " ,u32_app_id=" + this.C + " ,u64_timestamp=" + System.currentTimeMillis());
    }

    private static String k() {
        long currentTimeMillis = System.currentTimeMillis();
        long uptimeMillis = SystemClock.uptimeMillis();
        String str = "";
        for (int i11 = 5; i11 >= 0; i11--) {
            str = str + String.format("%02x", new Object[]{Byte.valueOf((byte) ((int) (255 & (currentTimeMillis >> (i11 * 8)))))});
        }
        for (int i12 = 3; i12 >= 0; i12--) {
            str = str + String.format("%02x", new Object[]{Byte.valueOf((byte) ((int) ((uptimeMillis >> (i12 * 8)) & 255)))});
        }
        return str + com.tencent.liteav.txcplayer.a.a.b(str + LiteavSystemInfo.getDeviceUuid());
    }

    public final void a(String str, String str2) {
        LiteavLog.i("TXCVodPlayCollection", "[putCustomData]: <" + str + " ," + str2 + ">");
        this.O.put(str, str2);
    }

    public final void b() {
        if (0 == this.f21837d) {
            LiteavLog.i("TXCVodPlayCollection", "calculateSegmentPlayTime mBeginPlayTS == 0");
            return;
        }
        LiteavLog.i("TXCVodPlayCollection", "calculateSegmentPlayTime mCurIndexPlayTime= " + this.f21844k + ", mBeginPlayTS=" + this.f21837d);
        this.f21844k = this.f21844k + ((long) ((int) (System.currentTimeMillis() - this.f21837d)));
        this.f21837d = System.currentTimeMillis();
        if (this.f21853t.equals("1")) {
            boolean b11 = b.a(this.f21834a).b(this.C);
            if (!b11) {
                b.a(this.f21834a).c(this.C);
            }
            if (this.F && b11) {
                j();
            }
            long j11 = this.f21844k;
            this.G = (int) (((long) this.G) + (j11 / 1000));
            this.f21844k = j11 % 1000;
        }
    }

    public final void c() {
        LiteavLog.i("TXCVodPlayCollection", "[stop] mCurIndexPlayTime = " + this.f21844k + " ,mIsPaused = " + this.f21839f + " ,mIsPlaying = " + this.F + " ,mIsPreLoading =" + this.f21840g);
        if (this.f21839f) {
            this.f21837d = System.currentTimeMillis();
        }
        if (this.F && !this.f21840g) {
            b();
            this.G = (int) (((long) this.G) + (this.f21844k / 1000));
            LiteavLog.i("TXCVodPlayCollection", "[stop] mPlayTime = " + this.G + " s");
            this.f21844k = 0;
            i();
            this.N = k();
            this.F = false;
        }
        this.f21849p = false;
        this.f21850q = false;
        this.f21839f = false;
        this.f21840g = false;
        this.f21841h = false;
        this.f21845l = -1;
        this.O.clear();
    }

    public final void d() {
        if (this.f21845l == -1) {
            this.f21845l = (int) (System.currentTimeMillis() - this.f21837d);
        }
    }

    public final void e() {
        LiteavLog.i("TXCVodPlayCollection", "setBitrateRenderStart");
        this.f21841h = false;
    }

    public final void f() {
        this.f21849p = true;
        this.I++;
        this.Q.reportDau(1551, 0, "");
        LiteavLog.d("TXCVodPlayCollection", "mSeekCnt= " + this.I);
    }

    public final void a() {
        this.P = new Event4XReporter(40303, 1011, "", true, 1);
        g();
        this.P.setEventStringValue("str_fileid", this.f21854u);
        LicenseChecker.d a11 = c.a();
        if (a11 != LicenseChecker.d.OK) {
            int i11 = a11.value;
            this.J = i11;
            this.f21855v = "player_license_error";
            this.P.setEventStringValue("u64_err_code", String.valueOf(i11));
            this.P.setEventStringValue("str_err_info", this.f21855v);
        }
        this.P.sendReport();
        LiteavLog.i("TXCVodPlayCollection", "[reportStart], report evt 40303: token=" + this.N + " ,u32_app_id=" + this.C + " ,str_fileid=" + this.f21854u + " ,str_stream_url=" + this.f21835b + " ,u64_err_code=" + this.J + " ,str_err_info=" + this.f21855v);
    }

    public final void b(boolean z11) {
        if (z11) {
            this.K = 1;
            this.Q.reportDau(1553, 0, "");
        } else {
            this.K = 0;
        }
        LiteavLog.i("TXCVodPlayCollection", "mIsMirror= " + this.K);
    }

    private static String a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        Display defaultDisplay = windowManager.getDefaultDisplay();
        try {
            Class<?> cls = Class.forName("android.view.Display");
            if (LiteavSystemInfo.getSystemOSVersionInt() > 8) {
                cls.getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(defaultDisplay, new Object[]{displayMetrics});
            }
            int i11 = displayMetrics.heightPixels;
            int i12 = displayMetrics.widthPixels;
            return i12 + "_" + i11;
        } catch (Throwable unused) {
            return "";
        }
    }

    public final void c(boolean z11) {
        if (!z11) {
            this.f21841h = true;
        }
        this.M++;
        this.Q.reportDau(1554, 0, "");
        LiteavLog.d("TXCVodPlayCollection", "mSetBitrateIndexCnt= " + this.M);
    }

    public final void a(boolean z11) {
        this.F = true;
        long currentTimeMillis = System.currentTimeMillis();
        this.f21837d = currentTimeMillis;
        this.f21836c = currentTimeMillis;
        this.G = 0;
        this.f21844k = 0;
        this.f21843j = 0;
        this.f21838e = 0;
        this.f21846m = 0;
        this.f21847n = 0;
        this.f21848o = 0;
        if (z11) {
            this.f21839f = false;
        } else {
            this.f21840g = true;
        }
        LiteavLog.i("TXCVodPlayCollection", "[start] ,mBeginPlayTS = " + this.f21837d + ", mIsPaused = " + this.f21839f + " mIsPreLoading = " + this.f21840g);
    }

    public final void a(float f11) {
        this.L = f11;
        this.Q.reportDau(1552, 0, "");
        LiteavLog.i("TXCVodPlayCollection", "[changeSpeed], mSpeed = " + this.L);
    }

    public final void a(int i11, String str) {
        LiteavLog.i("TXCVodPlayCollection", "errorCode= " + i11 + " ，errorInfo= " + str);
        if (this.f21845l == -1) {
            this.J = i11;
            if (str == null) {
                str = "";
            }
            this.f21855v = str;
            this.f21845l = 0;
        } else {
            StringBuilder sb2 = new StringBuilder("errorCode=");
            sb2.append(i11);
            sb2.append("_errorInfo=");
            if (str == null) {
                str = "";
            }
            sb2.append(str);
            this.f21855v = sb2.toString();
        }
        if (this.F) {
            c();
        }
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(this.C)) {
            this.C = str;
        }
    }
}
