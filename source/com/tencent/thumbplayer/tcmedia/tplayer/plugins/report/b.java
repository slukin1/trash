package com.tencent.thumbplayer.tcmedia.tplayer.plugins.report;

import android.app.UiModeManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.InnerShareParams;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.huawei.hms.framework.common.ContainerUtils;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.thumbplayer.tcmedia.api.TPErrorCode;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerMgr;
import com.tencent.thumbplayer.tcmedia.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.tcmedia.api.report.TPDefaultReportInfo;
import com.tencent.thumbplayer.tcmedia.api.report.TPLiveReportInfo;
import com.tencent.thumbplayer.tcmedia.api.report.TPVodReportInfo;
import com.tencent.thumbplayer.tcmedia.config.TPPlayerConfig;
import com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyHelper;
import com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.TPReportParams;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import com.tencent.thumbplayer.tcmedia.utils.f;
import com.tencent.thumbplayer.tcmedia.utils.l;
import com.tencent.thumbplayer.tcmedia.utils.o;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import org.json.JSONObject;

public class b implements ITPBusinessReportManager, com.tencent.thumbplayer.tcmedia.tplayer.plugins.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f49623a = String.format("Android %s", new Object[]{TPSystemInfo.getOsVersion()});

    /* renamed from: b  reason: collision with root package name */
    private static String f49624b = "";

    /* renamed from: c  reason: collision with root package name */
    private static boolean f49625c = false;

    /* renamed from: h  reason: collision with root package name */
    private static com.tencent.thumbplayer.tcmedia.utils.c f49626h = null;
    private String A = "";
    private String B = "";
    private String C = "";
    private int D = 0;
    private int E = 0;
    private String F = "";
    private int G = 0;
    private long H = 0;
    private Context I;
    private int J = -1;
    private c K = new a();
    private double L = 1.0d;
    private boolean M = true;
    private TPReportParams.BufferingOnceParams N = null;
    private TPReportParams.UserSeekOnceParams O = null;
    private final e P = new e();
    private f.a Q = new f.a() {
        public void a(int i11, int i12, int i13, Object obj) {
            int i14;
            TPLogUtil.i("TPReportManager", "OnGlobalEventChangeListener eventId: ".concat(String.valueOf(i11)));
            switch (i11) {
                case TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND:
                    i14 = 2100;
                    break;
                case TPPlayerMgr.EVENT_ID_APP_ENTER_FOREGROUND:
                    i14 = 2101;
                    break;
                default:
                    return;
            }
            b.this.f49628e.obtainMessage(i14, (Object) null).sendToTarget();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private HandlerThread f49627d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public C0628b f49628e;

    /* renamed from: f  reason: collision with root package name */
    private final Object f49629f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private boolean f49630g = false;

    /* renamed from: i  reason: collision with root package name */
    private TPDefaultReportInfo f49631i = null;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public TPReportParams f49632j = null;

    /* renamed from: k  reason: collision with root package name */
    private int f49633k = 1;

    /* renamed from: l  reason: collision with root package name */
    private int f49634l = 0;

    /* renamed from: m  reason: collision with root package name */
    private boolean f49635m = true;

    /* renamed from: n  reason: collision with root package name */
    private boolean f49636n = true;

    /* renamed from: o  reason: collision with root package name */
    private boolean f49637o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f49638p = false;

    /* renamed from: q  reason: collision with root package name */
    private long f49639q = 0;

    /* renamed from: r  reason: collision with root package name */
    private long f49640r = 0;

    /* renamed from: s  reason: collision with root package name */
    private int f49641s = 81;

    /* renamed from: t  reason: collision with root package name */
    private int f49642t = 0;

    /* renamed from: u  reason: collision with root package name */
    private int f49643u = 0;

    /* renamed from: v  reason: collision with root package name */
    private int f49644v = 0;

    /* renamed from: w  reason: collision with root package name */
    private boolean f49645w = false;

    /* renamed from: x  reason: collision with root package name */
    private boolean f49646x = false;

    /* renamed from: y  reason: collision with root package name */
    private boolean f49647y = false;

    /* renamed from: z  reason: collision with root package name */
    private String f49648z = "0";

    public class a implements c {
        public a() {
        }

        public void a(int i11, com.tencent.thumbplayer.tcmedia.common.a.a aVar) {
            b.this.a(aVar, i11, i11 <= 30);
            b.this.a(aVar);
        }
    }

    /* renamed from: com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.b$b  reason: collision with other inner class name */
    public class C0628b extends Handler {
        public C0628b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            Object obj = message.obj;
            Map map = obj instanceof Map ? (Map) obj : null;
            int i11 = message.what;
            if (i11 == 100) {
                b.this.l();
            } else if (i11 == 3000) {
                b.this.f();
            } else if (i11 == 4000) {
                b.this.j();
            } else if (i11 == 2100) {
                b.this.i();
            } else if (i11 != 2101) {
                switch (i11) {
                    case 999:
                        b.this.a((Map<String, Object>) map);
                        return;
                    case 1000:
                        b.this.b((Map<String, Object>) map);
                        return;
                    case 1001:
                        b.this.c((Map<String, Object>) map);
                        return;
                    case 1002:
                        b.this.d((Map<String, Object>) map);
                        return;
                    case 1003:
                        b.this.e((Map<String, Object>) map);
                        return;
                    case 1004:
                        b.this.g((Map<String, Object>) map);
                        return;
                    case 1005:
                        b.this.h(map);
                        return;
                    case 1006:
                        b.this.i(map);
                        return;
                    case 1007:
                        b.this.j(map);
                        return;
                    case 1008:
                        b.this.k(map);
                        return;
                    case 1009:
                        b.this.n(map);
                        return;
                    case 1010:
                        b.this.p(map);
                        return;
                    case 1011:
                        b.this.o(map);
                        return;
                    case 1012:
                        b.this.f((Map<String, Object>) map);
                        return;
                    case 1013:
                        b.this.l(map);
                        return;
                    case 1014:
                        b.this.m(map);
                        return;
                    case 1015:
                        b.this.r(map);
                        return;
                    case 1016:
                        if (obj instanceof String) {
                            b.this.a((String) obj);
                            return;
                        }
                        return;
                    case 1017:
                        b.this.C(map);
                        return;
                    case 1018:
                        b.this.D(map);
                        return;
                    case 1019:
                        b.this.A(map);
                        return;
                    case 1020:
                        b.this.y(map);
                        return;
                    case 1021:
                        b.this.z(map);
                        return;
                    case 1022:
                        b.this.B(map);
                        return;
                    case 1023:
                        b.this.E(map);
                        return;
                    default:
                        switch (i11) {
                            case 2000:
                                b.this.s(map);
                                return;
                            case 2001:
                                b.this.t(map);
                                return;
                            case 2002:
                                b.this.v(map);
                                return;
                            case 2003:
                                b.this.u(map);
                                return;
                            case 2004:
                                b.this.w(map);
                                return;
                            case 2005:
                                b.this.x(map);
                                return;
                            default:
                                return;
                        }
                }
            } else {
                b.this.g();
            }
        }
    }

    public interface c {
        void a(int i11, com.tencent.thumbplayer.tcmedia.common.a.a aVar);
    }

    public class d implements c {
        public d() {
        }

        public void a(int i11, com.tencent.thumbplayer.tcmedia.common.a.a aVar) {
            l lVar = new l();
            boolean z11 = i11 <= 30 || i11 == 263;
            if (i11 == 30) {
                i11 = 205;
            } else if (i11 == 50) {
                b.this.f49628e.removeMessages(3000);
                i11 = 263;
            } else if (i11 == 150) {
                b.this.f49628e.removeMessages(3000);
            } else if (i11 == 263) {
                b.this.f49628e.removeMessages(3000);
                b.this.f49628e.sendEmptyMessageDelayed(3000, 60000);
            } else {
                return;
            }
            b.this.a((com.tencent.thumbplayer.tcmedia.common.a.a) lVar, i11, z11);
            b.this.b((com.tencent.thumbplayer.tcmedia.common.a.a) lVar, z11);
            if (i11 != 205) {
                lVar.a("loadingtime", 0);
            }
            TPLogUtil.i("TPReportManager", "liveExParam.prePlayLengthInt: " + b.this.f49632j.getLiveExParam().prePlayLengthInt);
            b.this.a((com.tencent.thumbplayer.tcmedia.common.a.a) lVar);
        }
    }

    public class e {

        /* renamed from: a  reason: collision with root package name */
        public long f49653a;

        /* renamed from: b  reason: collision with root package name */
        public int f49654b;

        /* renamed from: c  reason: collision with root package name */
        public long f49655c;

        /* renamed from: d  reason: collision with root package name */
        public long f49656d;

        /* renamed from: e  reason: collision with root package name */
        public int f49657e;

        /* renamed from: f  reason: collision with root package name */
        public int f49658f;

        /* renamed from: g  reason: collision with root package name */
        public long f49659g;

        /* renamed from: h  reason: collision with root package name */
        public long f49660h;

        /* renamed from: i  reason: collision with root package name */
        public int f49661i;

        /* renamed from: j  reason: collision with root package name */
        public int f49662j;

        /* renamed from: k  reason: collision with root package name */
        public int f49663k;

        /* renamed from: l  reason: collision with root package name */
        public int f49664l;

        /* renamed from: m  reason: collision with root package name */
        public boolean f49665m;

        /* renamed from: n  reason: collision with root package name */
        public boolean f49666n;

        /* renamed from: o  reason: collision with root package name */
        public boolean f49667o;

        /* renamed from: p  reason: collision with root package name */
        public int f49668p;

        /* renamed from: q  reason: collision with root package name */
        public String f49669q;

        /* renamed from: r  reason: collision with root package name */
        public String f49670r;

        /* renamed from: s  reason: collision with root package name */
        public String f49671s;

        /* renamed from: t  reason: collision with root package name */
        public String f49672t;

        /* renamed from: u  reason: collision with root package name */
        public String f49673u;

        /* renamed from: v  reason: collision with root package name */
        public String f49674v;

        /* renamed from: w  reason: collision with root package name */
        public ArrayList<f> f49675w;

        private e() {
            this.f49653a = 0;
            this.f49654b = 0;
            this.f49655c = 0;
            this.f49656d = 0;
            this.f49657e = 0;
            this.f49658f = 0;
            this.f49659g = 0;
            this.f49660h = 0;
            this.f49661i = 0;
            this.f49662j = 0;
            this.f49663k = 0;
            this.f49664l = 0;
            this.f49665m = false;
            this.f49666n = false;
            this.f49667o = false;
            this.f49668p = -1;
            this.f49669q = "";
            this.f49670r = "";
            this.f49671s = "";
            this.f49672t = "";
            this.f49673u = "";
            this.f49674v = "";
            this.f49675w = new ArrayList<>();
        }

        public void a() {
            this.f49653a = 0;
            this.f49654b = 0;
            this.f49655c = 0;
            this.f49656d = 0;
            this.f49657e = 0;
            this.f49658f = 0;
            this.f49659g = 0;
            this.f49660h = 0;
            this.f49661i = 0;
            this.f49662j = 0;
            this.f49663k = 0;
            this.f49664l = 0;
            this.f49665m = false;
            this.f49666n = false;
            this.f49667o = false;
            this.f49668p = -1;
            this.f49669q = "";
            this.f49670r = "";
            this.f49671s = "";
            this.f49672t = "";
            this.f49673u = "";
            this.f49674v = "";
            this.f49675w.clear();
        }
    }

    public class f {

        /* renamed from: a  reason: collision with root package name */
        public String f49677a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f49678b = "";

        /* renamed from: c  reason: collision with root package name */
        public long f49679c = -1;

        public f(String str, String str2) {
            this.f49677a = str;
            this.f49678b = str2;
        }
    }

    public class g implements c {
        public g() {
        }

        public void a(int i11, com.tencent.thumbplayer.tcmedia.common.a.a aVar) {
            boolean z11 = i11 <= 30;
            b.this.a(aVar, i11, z11);
            b.this.a(aVar, z11);
            b.this.a(aVar);
        }
    }

    public b(Context context) {
        this.I = context.getApplicationContext();
    }

    /* access modifiers changed from: private */
    public void A(Map<String, Object> map) {
        if (map != null) {
            TPReportParams.LiveExParam liveExParam = this.f49632j.getLiveExParam();
            long a11 = a(map, "stime", System.currentTimeMillis());
            liveExParam.getSyncFrameDurationInt = (int) (a11 - this.P.f49655c);
            this.f49632j.getFirstLoadParams().firstPacketReadTimeUnix = a11;
        }
    }

    /* access modifiers changed from: private */
    public void B(Map<String, Object> map) {
        if (map != null) {
            this.f49632j.getFirstLoadParams().firstOpenTimeUnix = a(map, "stime", System.currentTimeMillis());
        }
    }

    /* access modifiers changed from: private */
    public void C(Map<String, Object> map) {
        if (map != null) {
            int a11 = a(map, "speed", 0);
            this.f49642t = a11;
            e eVar = this.P;
            eVar.f49663k += a11;
            eVar.f49664l++;
            if (a11 > eVar.f49662j) {
                eVar.f49662j = a11;
            }
            String a12 = a(map, "spanId", "");
            if (!TextUtils.isEmpty(a12)) {
                try {
                    JSONObject jSONObject = new JSONObject(a12);
                    if (jSONObject.has("spanId")) {
                        this.P.f49673u = jSONObject.getString("spanId");
                    }
                } catch (Exception e11) {
                    TPLogUtil.e("TPReportManager", (Throwable) e11);
                }
                b(a12);
            }
        }
    }

    /* access modifiers changed from: private */
    public void D(Map<String, Object> map) {
        if (map != null) {
            this.P.f49670r = a(map, "url", "");
            this.P.f49671s = a(map, "cdnip", "");
            this.P.f49672t = a(map, "cdnuip", "");
            if (!TextUtils.isEmpty(this.P.f49670r) && this.P.f49670r.contains("sid=")) {
                int indexOf = this.P.f49670r.indexOf("sid=");
                int indexOf2 = this.P.f49670r.indexOf(ContainerUtils.FIELD_DELIMITER, indexOf);
                e eVar = this.P;
                eVar.f49674v = indexOf2 >= 0 ? eVar.f49670r.substring(indexOf + 4, indexOf2) : eVar.f49670r.substring(indexOf + 4);
            }
        }
    }

    /* access modifiers changed from: private */
    public void E(Map<String, Object> map) {
        this.A = a(map, "proto", "");
        this.B = a(map, "protover", "");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r1.get(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private float a(java.util.Map<java.lang.String, java.lang.Object> r1, java.lang.String r2, float r3) {
        /*
            r0 = this;
            if (r1 != 0) goto L_0x0003
            return r3
        L_0x0003:
            java.lang.Object r1 = r1.get(r2)
            if (r1 == 0) goto L_0x0010
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            return r1
        L_0x0010:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.b.a(java.util.Map, java.lang.String, float):float");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r1.get(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(java.util.Map<java.lang.String, java.lang.Object> r1, java.lang.String r2, int r3) {
        /*
            r0 = this;
            if (r1 != 0) goto L_0x0003
            return r3
        L_0x0003:
            java.lang.Object r1 = r1.get(r2)
            if (r1 == 0) goto L_0x0010
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            return r1
        L_0x0010:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.b.a(java.util.Map, java.lang.String, int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r1.get(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long a(java.util.Map<java.lang.String, java.lang.Object> r1, java.lang.String r2, long r3) {
        /*
            r0 = this;
            if (r1 != 0) goto L_0x0003
            return r3
        L_0x0003:
            java.lang.Object r1 = r1.get(r2)
            if (r1 == 0) goto L_0x0010
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            return r1
        L_0x0010:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.b.a(java.util.Map, java.lang.String, long):long");
    }

    private static String a(int i11) {
        if (i11 == 5) {
            return "init_player";
        }
        if (i11 == 15) {
            return "get_cdn_url";
        }
        if (i11 == 30) {
            return "first_load";
        }
        if (i11 == 40) {
            return "user_seek";
        }
        if (i11 == 50) {
            return "play_done";
        }
        if (i11 == 150) {
            return "live_error";
        }
        if (i11 == 205) {
            return "live_loading";
        }
        if (i11 == 263) {
            return "live_period";
        }
        switch (i11) {
            case 32:
                return "first_rendering";
            case 33:
                return "load_subtitle";
            case 34:
                return "302_redirect";
            case 35:
                return "second_buffering";
            default:
                return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r1.get(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.util.Map<java.lang.String, java.lang.Object> r1, java.lang.String r2, java.lang.String r3) {
        /*
            r0 = this;
            if (r1 != 0) goto L_0x0003
            return r3
        L_0x0003:
            java.lang.Object r1 = r1.get(r2)
            if (r1 == 0) goto L_0x000c
            java.lang.String r1 = (java.lang.String) r1
            return r1
        L_0x000c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.b.a(java.util.Map, java.lang.String, java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: private */
    public void a(com.tencent.thumbplayer.tcmedia.common.a.a aVar) {
        String str;
        if (this.M) {
            HashMap hashMap = new HashMap();
            aVar.a(hashMap);
            if (hashMap.containsKey("step") && (str = (String) hashMap.get("step")) != null) {
                String a11 = a(Integer.parseInt(str));
                if (!TextUtils.isEmpty(a11)) {
                    com.tencent.thumbplayer.tcmedia.common.a.b.a(a11, hashMap);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(com.tencent.thumbplayer.tcmedia.common.a.a aVar, int i11, boolean z11) {
        TPReportParams.CommonParams commonParams = this.f49632j.getCommonParams();
        commonParams.stepInt = i11;
        commonParams.seqInt++;
        String str = this.C;
        commonParams.flowIdString = str;
        commonParams.playNoString = str;
        commonParams.signalStrengthInt = this.f49641s;
        commonParams.networkSpeedInt = this.f49642t;
        commonParams.networkTypeInt = n();
        commonParams.deviceNameString = TPSystemInfo.getDeviceName();
        commonParams.deviceResolutionString = m();
        commonParams.osVersionString = f49623a;
        commonParams.p2pVersionString = TPDownloadProxyHelper.getNativeLibVersion();
        commonParams.playerVersionString = TPPlayerConfig.VERSION;
        commonParams.playerTypeInt = this.D;
        commonParams.p2pInt = this.f49647y ? 1 : 0;
        commonParams.proto = this.A;
        commonParams.protover = this.B;
        commonParams.playTypeInt = this.J;
        TPDefaultReportInfo tPDefaultReportInfo = this.f49631i;
        if (tPDefaultReportInfo != null && z11) {
            commonParams.testIdInt = tPDefaultReportInfo.testId;
            commonParams.cdnIdInt = tPDefaultReportInfo.cdnId;
            commonParams.downloadTypeInt = tPDefaultReportInfo.dlType;
            commonParams.loginTypeInt = tPDefaultReportInfo.loginType;
            commonParams.mediaFormatInt = tPDefaultReportInfo.mediaFormat;
            commonParams.mediaRateInt = tPDefaultReportInfo.mediaRate;
            commonParams.platformLong = tPDefaultReportInfo.platform;
            commonParams.onlineInt = tPDefaultReportInfo.isOnline ? 1 : 0;
            commonParams.mediaDurationFloat = tPDefaultReportInfo.mediaDuration;
            commonParams.uinString = tPDefaultReportInfo.uin;
            commonParams.qqOpenIdString = tPDefaultReportInfo.qqOpenId;
            commonParams.wxOpenIdString = tPDefaultReportInfo.wxOpenId;
            commonParams.guidString = tPDefaultReportInfo.guid;
            commonParams.uipString = tPDefaultReportInfo.uip;
            commonParams.cdnUipString = tPDefaultReportInfo.cdnUip;
            commonParams.cdnIpString = tPDefaultReportInfo.cdnIp;
            commonParams.appVersionString = tPDefaultReportInfo.appVersion;
            commonParams.vidString = tPDefaultReportInfo.vid;
            commonParams.mediaResolutionString = tPDefaultReportInfo.mediaResolution;
            commonParams.scenesId = tPDefaultReportInfo.scenesId;
            Properties properties = tPDefaultReportInfo.reportInfoProperties;
            if (properties != null) {
                for (Map.Entry entry : properties.entrySet()) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if (value == null) {
                        aVar.a(key.toString(), "");
                    } else {
                        aVar.a(key.toString(), value.toString());
                    }
                }
            }
            this.J = this.f49631i.getPlayType();
        }
        if (commonParams.platformLong <= 0) {
            commonParams.platformLong = (long) TPPlayerConfig.getPlatform();
        }
        if (TextUtils.isEmpty(commonParams.uinString)) {
            commonParams.uinString = TPPlayerConfig.getUserUin();
        }
        if (TextUtils.isEmpty(commonParams.guidString)) {
            commonParams.guidString = TPPlayerConfig.getGuid();
        }
        if (TextUtils.isEmpty(commonParams.appVersionString)) {
            commonParams.appVersionString = TPPlayerConfig.getAppVersionName(this.I);
        }
        if (TextUtils.isEmpty(commonParams.uipString)) {
            commonParams.uipString = this.P.f49672t;
        }
        if (TextUtils.isEmpty(commonParams.cdnUipString)) {
            commonParams.cdnUipString = this.P.f49672t;
        }
        if (TextUtils.isEmpty(commonParams.cdnIpString)) {
            commonParams.cdnIpString = this.P.f49671s;
        }
        if (commonParams.downloadTypeInt <= 0) {
            commonParams.downloadTypeInt = this.E;
        }
        if (TextUtils.isEmpty(commonParams.mediaResolutionString)) {
            commonParams.mediaResolutionString = this.F;
        }
        if (commonParams.mediaDurationFloat <= 0.0f) {
            commonParams.mediaDurationFloat = ((float) this.H) / 1000.0f;
        }
        if (commonParams.mediaRateInt <= 0) {
            commonParams.mediaRateInt = this.G;
        }
        commonParams.paramsToProperties(aVar);
    }

    /* access modifiers changed from: private */
    public void a(com.tencent.thumbplayer.tcmedia.common.a.a aVar, boolean z11) {
        TPReportParams.VodExParam vodExParam = this.f49632j.getVodExParam();
        if (vodExParam != null) {
            TPDefaultReportInfo tPDefaultReportInfo = this.f49631i;
            if (tPDefaultReportInfo != null && (tPDefaultReportInfo instanceof TPVodReportInfo) && z11) {
                vodExParam.currentPlayInt = ((TPVodReportInfo) tPDefaultReportInfo).currentPlayState;
                vodExParam.optimizedPlayInt = ((TPVodReportInfo) tPDefaultReportInfo).optimizedPlay;
                vodExParam.hasSubtitleInt = ((TPVodReportInfo) tPDefaultReportInfo).hasSubtitles ? 1 : 0;
                vodExParam.bizIdInt = ((TPVodReportInfo) tPDefaultReportInfo).bizId;
                vodExParam.clipInt = ((TPVodReportInfo) tPDefaultReportInfo).clipCount;
                vodExParam.statusInt = ((TPVodReportInfo) tPDefaultReportInfo).videoStatus;
                vodExParam.freeTypeInt = tPDefaultReportInfo.freeType;
            }
            e eVar = this.P;
            vodExParam.multiTrackInt = eVar.f49666n ? 1 : 0;
            vodExParam.isSelectedSubtitleInt = eVar.f49665m ? 1 : 0;
            vodExParam.hevcLcInt = 0;
            vodExParam.hitDownloaded = eVar.f49668p;
            vodExParam.paramsToProperties(aVar);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            TPLogUtil.i("TPReportManager", "onHandleHlsTag, tag is null");
        } else if (!str.startsWith("#EXT-X-PROGRAM-DATE-TIME:")) {
            TPLogUtil.i("TPReportManager", "onHandleHlsTag, tag is not start with #EXT-X-PROGRAM-DATE-TIME:");
        } else {
            try {
                String substring = str.substring(25);
                int indexOf = substring.indexOf(43);
                if (indexOf != -1) {
                    substring = substring.substring(0, indexOf);
                } else {
                    TPLogUtil.i("TPReportManager", "handleOnPlayerPrivaterHlsM3u8Tag , player_m3u8_tag , tag do not contains time zone");
                }
                str2 = substring.replace('T', ' ');
            } catch (Exception e11) {
                TPLogUtil.e("TPReportManager", (Throwable) e11);
                str2 = "";
            }
            if (TextUtils.isEmpty(str2)) {
                TPLogUtil.i("TPReportManager", "onHandleHlsTag , player_m3u8_tag , dataTime is null ");
                return;
            }
            long j11 = 0;
            try {
                Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str2);
                if (parse != null) {
                    j11 = parse.getTime();
                }
            } catch (Exception e12) {
                TPLogUtil.e("TPReportManager", (Throwable) e12);
            }
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb2 = new StringBuilder("onHandleHlsTag , player_m3u8_tag , sysCurTime: ");
            sb2.append(currentTimeMillis);
            sb2.append(", time:");
            sb2.append(j11);
            sb2.append(", delay:");
            long j12 = currentTimeMillis - j11;
            sb2.append(j12);
            TPLogUtil.i("TPReportManager", sb2.toString());
            this.P.f49661i = (int) j12;
        }
    }

    /* access modifiers changed from: private */
    public void a(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onPlayerCreateStart");
        if (map != null) {
            this.f49632j.getInitParams().playStarTimeUnix = a(map, "stime", System.currentTimeMillis());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r1.get(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.util.Map<java.lang.String, java.lang.Object> r1, java.lang.String r2, boolean r3) {
        /*
            r0 = this;
            if (r1 != 0) goto L_0x0003
            return r3
        L_0x0003:
            java.lang.Object r1 = r1.get(r2)
            if (r1 == 0) goto L_0x0010
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            return r1
        L_0x0010:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.b.a(java.util.Map, java.lang.String, boolean):boolean");
    }

    private int b(int i11) {
        switch (i11) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return 0;
        }
    }

    /* access modifiers changed from: private */
    public void b(com.tencent.thumbplayer.tcmedia.common.a.a aVar, boolean z11) {
        TPReportParams.LiveExParam liveExParam = this.f49632j.getLiveExParam();
        if (liveExParam != null) {
            TPDefaultReportInfo tPDefaultReportInfo = this.f49631i;
            if (tPDefaultReportInfo != null && (tPDefaultReportInfo instanceof TPLiveReportInfo) && z11) {
                liveExParam.adPlayLengthInt = ((TPLiveReportInfo) tPDefaultReportInfo).adPlayLength;
                liveExParam.liveProgramIdInt = ((TPLiveReportInfo) tPDefaultReportInfo).programId;
                liveExParam.streamIdInt = ((TPLiveReportInfo) tPDefaultReportInfo).streamId;
                liveExParam.contentIdInt = ((TPLiveReportInfo) tPDefaultReportInfo).contentId;
                liveExParam.playTimeInt = ((TPLiveReportInfo) tPDefaultReportInfo).playTime;
                liveExParam.liveTypeInt = ((TPLiveReportInfo) tPDefaultReportInfo).liveType;
                liveExParam.isUserPayInt = ((TPLiveReportInfo) tPDefaultReportInfo).isUserPay ? 1 : 0;
                liveExParam.isLookBackInt = ((TPLiveReportInfo) tPDefaultReportInfo).isLookBack ? 1 : 0;
                liveExParam.cdnServerString = ((TPLiveReportInfo) tPDefaultReportInfo).cdnServer;
                liveExParam.freeTypeInt = tPDefaultReportInfo.freeType;
                liveExParam.userQQString = tPDefaultReportInfo.uin;
                liveExParam.userIpString = tPDefaultReportInfo.uip;
                liveExParam.isStreamP2PInt = tPDefaultReportInfo.enableP2p ? 1 : 0;
            }
            if (tPDefaultReportInfo != null && (tPDefaultReportInfo instanceof TPLiveReportInfo)) {
                liveExParam.liveDelayInt = ((TPLiveReportInfo) tPDefaultReportInfo).liveDelay;
            }
            liveExParam.isUseP2PInt = this.f49647y ? 1 : 0;
            String str = this.P.f49670r;
            liveExParam.downloadUrl = str;
            if (TextUtils.isEmpty(str)) {
                liveExParam.downloadUrl = this.f49632j.getFirstLoadParams().cdnUrlString;
            }
            liveExParam.downloadServerIpString = this.P.f49671s;
            liveExParam.reportTimeLong = System.currentTimeMillis();
            e eVar = this.P;
            if (eVar.f49653a > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                e eVar2 = this.P;
                eVar.f49654b = (int) (((long) eVar.f49654b) + (currentTimeMillis - eVar2.f49653a));
                if (this.f49635m || this.f49646x || eVar2.f49667o) {
                    eVar2.f49653a = 0;
                } else {
                    eVar2.f49653a = System.currentTimeMillis();
                }
            }
            e eVar3 = this.P;
            liveExParam.prePlayLengthInt = eVar3.f49654b;
            eVar3.f49654b = 0;
            liveExParam.playerVersionString = TPPlayerConfig.VERSION;
            liveExParam.deviceTypeInt = o();
            liveExParam.networkTypeInt = n();
            e eVar4 = this.P;
            liveExParam.maxSpeedInt = eVar4.f49662j;
            eVar4.f49662j = 0;
            liveExParam.testSpeedInt = this.f49642t;
            int i11 = eVar4.f49664l;
            if (i11 > 0) {
                liveExParam.downSpeedInt = eVar4.f49663k / i11;
                eVar4.f49663k = 0;
                eVar4.f49664l = 0;
            }
            liveExParam.liveTagInt = 0;
            liveExParam.extraInfoString = "";
            liveExParam.reconnectCntInt = 0;
            liveExParam.connectTimeInt = 0;
            liveExParam.getUrlTimeInt = 0;
            liveExParam.defSwitchString = eVar4.f49669q;
            liveExParam.loadingTimeLong = eVar4.f49656d - eVar4.f49655c;
            liveExParam.blockTimeInt = eVar4.f49658f;
            liveExParam.blockCountInt = eVar4.f49657e;
            eVar4.f49657e = 0;
            eVar4.f49658f = 0;
            liveExParam.errCodeInt = 0;
            liveExParam.fullErrCodeString = this.f49648z;
            liveExParam.spanId = eVar4.f49673u;
            liveExParam.tuid = eVar4.f49674v;
            liveExParam.paramsToProperties(aVar);
        }
    }

    private void b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("hitDownloaded")) {
                e eVar = this.P;
                if (eVar.f49668p == -1) {
                    eVar.f49668p = jSONObject.getInt("hitDownloaded");
                }
            }
        } catch (Exception e11) {
            TPLogUtil.e("TPReportManager", (Throwable) e11);
        }
    }

    /* access modifiers changed from: private */
    public void b(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onPlayerCreateDone");
        if (map != null) {
            l lVar = new l();
            TPReportParams.PlayerInitParams initParams = this.f49632j.getInitParams();
            initParams.playEndTimeUnix = a(map, "etime", System.currentTimeMillis());
            initParams.errCodeString = this.f49648z;
            initParams.paramsToProperties(lVar);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(java.util.Map<java.lang.String, java.lang.Object> r9) {
        /*
            r8 = this;
            boolean r0 = r8.f49637o
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.String r0 = "TPReportManager"
            java.lang.String r1 = "onStartPrepare"
            com.tencent.thumbplayer.tcmedia.utils.TPLogUtil.i(r0, r1)
            r0 = 0
            r8.f49635m = r0
            java.lang.String r1 = "flowid"
            java.lang.String r2 = ""
            java.lang.String r1 = r8.a((java.util.Map<java.lang.String, java.lang.Object>) r9, (java.lang.String) r1, (java.lang.String) r2)
            r8.C = r1
            java.lang.String r1 = "p2p"
            boolean r1 = r8.a((java.util.Map<java.lang.String, java.lang.Object>) r9, (java.lang.String) r1, (boolean) r0)
            r8.f49647y = r1
            com.tencent.thumbplayer.tcmedia.api.report.TPDefaultReportInfo r1 = r8.f49631i
            if (r1 == 0) goto L_0x002b
            int r1 = r1.getPlayType()
            r8.J = r1
        L_0x002b:
            int r1 = r8.J
            r3 = 1
            if (r1 != r3) goto L_0x0038
            com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.b$d r1 = new com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.b$d
            r1.<init>()
        L_0x0035:
            r8.K = r1
            goto L_0x0040
        L_0x0038:
            if (r1 != 0) goto L_0x0040
            com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.b$g r1 = new com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.b$g
            r1.<init>()
            goto L_0x0035
        L_0x0040:
            com.tencent.thumbplayer.tcmedia.utils.l r1 = new com.tencent.thumbplayer.tcmedia.utils.l
            r1.<init>()
            com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.TPReportParams r4 = r8.f49632j
            com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.TPReportParams$PlayerInitParams r4 = r4.getInitParams()
            r4.paramsToProperties(r1)
            com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.b$c r4 = r8.K
            r5 = 5
            r4.a(r5, r1)
            com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.b$e r1 = r8.P
            long r4 = java.lang.System.currentTimeMillis()
            r1.f49655c = r4
            com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.TPReportParams r1 = r8.f49632j
            com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.TPReportParams$FirstLoadParams r1 = r1.getFirstLoadParams()
            com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.b$e r4 = r8.P
            java.lang.String r4 = r4.f49670r
            r1.cdnUrlString = r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0076
            java.lang.String r4 = "url"
            java.lang.String r2 = r8.a((java.util.Map<java.lang.String, java.lang.Object>) r9, (java.lang.String) r4, (java.lang.String) r2)
            r1.cdnUrlString = r2
        L_0x0076:
            com.tencent.thumbplayer.tcmedia.api.report.TPDefaultReportInfo r2 = r8.f49631i
            if (r2 == 0) goto L_0x007e
            int r2 = r2.cdnUrlIndex
            r1.cgiUrlIndex = r2
        L_0x007e:
            java.lang.String r2 = "urlindex"
            int r0 = r8.a((java.util.Map<java.lang.String, java.lang.Object>) r9, (java.lang.String) r2, (int) r0)
            r1.cgiUrlIndex = r0
            java.lang.String r0 = "stime"
            r4 = 0
            long r6 = r8.a((java.util.Map<java.lang.String, java.lang.Object>) r9, (java.lang.String) r0, (long) r4)
            r1.starTimeUnix = r6
            com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.TPReportParams r1 = r8.f49632j
            com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.TPReportParams$FirstRenderParams r1 = r1.getFirstRenderParams()
            long r4 = r8.a((java.util.Map<java.lang.String, java.lang.Object>) r9, (java.lang.String) r0, (long) r4)
            r1.starTimeUnix = r4
            r8.f49637o = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.b.c(java.util.Map):void");
    }

    private void d() {
        this.f49627d = o.a().a("TP-ReportThread");
        this.f49628e = new C0628b(this.f49627d.getLooper());
        this.f49632j = new TPReportParams();
        com.tencent.thumbplayer.tcmedia.utils.f.a(this.Q);
        synchronized (b.class) {
            if (f49626h == null) {
                f49626h = new com.tencent.thumbplayer.tcmedia.utils.c(this.I, "TPReportCache");
            }
            if (!f49625c) {
                this.f49628e.obtainMessage(TPErrorCode.TP_ERROR_TYPE_DOWNLOAD_PROXY).sendToTarget();
            }
            f49625c = true;
        }
    }

    /* access modifiers changed from: private */
    public void d(Map<String, Object> map) {
        if (this.f49637o) {
            this.f49637o = false;
            TPLogUtil.i("TPReportManager", "onPrepareDone");
            if (map != null) {
                this.P.f49656d = System.currentTimeMillis();
                this.P.f49666n = a(map, "multitrack", false);
                l lVar = new l();
                if (a(map, "playertype", 0) == 1) {
                    this.D = 0;
                } else {
                    this.D = 1;
                }
                this.F = a(map, "definition", "");
                this.H = a(map, IBridgeMediaLoader.COLUMN_DURATION, 0);
                this.G = (int) a(map, "rate", 0);
                String a11 = a(map, "fmt", "");
                if (a11 == null || !a11.contains("hls")) {
                    this.E = 1;
                } else {
                    this.E = 3;
                }
                TPReportParams.FirstLoadParams firstLoadParams = this.f49632j.getFirstLoadParams();
                firstLoadParams.endTimeUnix = a(map, "etime", 0);
                firstLoadParams.errCodeString = this.f49648z;
                firstLoadParams.paramsToProperties(lVar);
                this.K.a(30, lVar);
                this.f49632j.getFirstLoadParams().reset();
            }
        }
    }

    private void e() {
        TPLogUtil.i("TPReportManager", "release: ");
        com.tencent.thumbplayer.tcmedia.utils.f.b(this.Q);
        HandlerThread handlerThread = this.f49627d;
        if (handlerThread != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                handlerThread.quitSafely();
            } else {
                synchronized (this.f49629f) {
                    this.f49630g = false;
                    this.f49628e.sendEmptyMessage(100);
                    while (!this.f49630g) {
                        try {
                            this.f49629f.wait(5000, 0);
                        } catch (InterruptedException e11) {
                            TPLogUtil.e("TPReportManager", (Throwable) e11);
                        }
                    }
                }
                o.a().a(this.f49627d, (Handler) null);
            }
            this.f49627d = null;
        }
        TPLogUtil.i("TPReportManager", "release: end!");
    }

    /* access modifiers changed from: private */
    public void e(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onStartPlayer");
        this.f49635m = false;
        if (map != null) {
            this.P.f49653a = System.currentTimeMillis();
            long a11 = a(map, "stime", 0);
            if (this.f49639q > 0) {
                this.f49640r += System.currentTimeMillis() - a11;
            }
            this.f49639q = a11;
            if (this.J == 1) {
                this.f49628e.removeMessages(3000);
                this.f49628e.sendEmptyMessageDelayed(3000, 60000);
            }
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        TPLogUtil.i("TPReportManager", "onLivePeriodReport");
        this.K.a(263, new l());
    }

    /* access modifiers changed from: private */
    public void f(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onRenderingStart");
        if (map != null) {
            l lVar = new l();
            TPReportParams.FirstRenderParams firstRenderParams = this.f49632j.getFirstRenderParams();
            firstRenderParams.endTimeUnix = a(map, "etime", 0);
            firstRenderParams.errCodeString = this.f49648z;
            firstRenderParams.paramsToProperties(lVar);
            this.K.a(32, lVar);
            this.f49632j.getFirstRenderParams().reset();
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        TPLogUtil.i("TPReportManager", "onAppForeground");
        if (!this.f49636n) {
            this.f49636n = true;
            h();
        }
    }

    /* access modifiers changed from: private */
    public void g(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onPlayerPause");
        if (map != null) {
            if (this.f49639q > 0) {
                this.f49640r += a(map, "stime", System.currentTimeMillis()) - this.f49639q;
                this.f49639q = 0;
            }
            e eVar = this.P;
            if (eVar.f49653a > 0) {
                int i11 = eVar.f49654b;
                long currentTimeMillis = System.currentTimeMillis();
                e eVar2 = this.P;
                eVar.f49654b = i11 + ((int) (currentTimeMillis - eVar2.f49653a));
                eVar2.f49653a = 0;
            }
        }
    }

    private void h() {
        TPLogUtil.i("TPReportManager", "removeCacheEvent: mFlowId: " + this.C);
        if (f49626h != null && !TextUtils.isEmpty(this.C)) {
            f49626h.a(this.C);
        }
    }

    /* access modifiers changed from: private */
    public void h(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onPlayerStop");
        if (map != null) {
            if (this.f49639q > 0) {
                this.f49640r += a(map, "etime", System.currentTimeMillis()) - this.f49639q;
                this.f49639q = 0;
            }
            e eVar = this.P;
            if (eVar.f49653a > 0) {
                int i11 = eVar.f49654b;
                long currentTimeMillis = System.currentTimeMillis();
                e eVar2 = this.P;
                eVar.f49654b = i11 + ((int) (currentTimeMillis - eVar2.f49653a));
                eVar2.f49653a = 0;
            }
            map.put(Constants.REASON, 1);
            q(map);
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        TPLogUtil.i("TPReportManager", "onAppBackground");
        if (!this.f49635m && this.J != 1 && this.f49636n) {
            this.f49636n = false;
            l lVar = new l();
            this.f49632j.getBufferingTotalParams().paramsToProperties(lVar);
            this.f49632j.getUserSeekTotalParams().paramsToProperties(lVar);
            TPReportParams.PlayDoneParams playDoneParams = this.f49632j.getPlayDoneParams();
            playDoneParams.endTimeUnix = System.currentTimeMillis();
            playDoneParams.reasonInt = 2;
            playDoneParams.errCodeString = this.f49648z;
            e eVar = this.P;
            if (eVar.f49653a > 0) {
                int i11 = eVar.f49654b;
                long currentTimeMillis = System.currentTimeMillis();
                e eVar2 = this.P;
                eVar.f49654b = i11 + ((int) (currentTimeMillis - eVar2.f49653a));
                eVar2.f49653a = 0;
            }
            long j11 = this.f49639q;
            if (j11 > 0) {
                this.f49640r += playDoneParams.endTimeUnix - j11;
                this.f49639q = 0;
            }
            playDoneParams.playDurationFloat = ((float) this.f49640r) / 1000.0f;
            playDoneParams.paramsToProperties(lVar);
            TPReportParams.CommonParams commonParams = this.f49632j.getCommonParams();
            commonParams.stepInt = 50;
            commonParams.paramsToProperties(lVar);
            int i12 = this.J;
            if (i12 == 0) {
                a((com.tencent.thumbplayer.tcmedia.common.a.a) lVar, false);
            } else if (i12 == 1) {
                b((com.tencent.thumbplayer.tcmedia.common.a.a) lVar, false);
            }
            if (f49626h != null && !TextUtils.isEmpty(this.C) && this.M) {
                TPLogUtil.i("TPReportManager", "Cache report event. mFlowId: " + this.C);
                f49626h.a(this.C, lVar.a());
            }
        }
    }

    /* access modifiers changed from: private */
    public void i(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onPlayerError");
        if (map != null) {
            e eVar = this.P;
            if (eVar.f49653a > 0) {
                int i11 = eVar.f49654b;
                long currentTimeMillis = System.currentTimeMillis();
                e eVar2 = this.P;
                eVar.f49654b = i11 + ((int) (currentTimeMillis - eVar2.f49653a));
                eVar2.f49653a = 0;
            }
            this.f49648z = a(map, "code", "0");
            if (this.J == 1) {
                this.K.a(150, new l());
                return;
            }
            map.put(Constants.REASON, 3);
            q(map);
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        TPLogUtil.i("TPReportManager", "onReportLastEvent");
        com.tencent.thumbplayer.tcmedia.utils.c cVar = f49626h;
        if (cVar != null) {
            try {
                ArrayList arrayList = (ArrayList) cVar.a();
                if (arrayList != null) {
                    for (int i11 = 0; i11 < arrayList.size(); i11++) {
                        try {
                            Properties properties = (Properties) arrayList.get(i11);
                            if (properties != null) {
                                a((com.tencent.thumbplayer.tcmedia.common.a.a) new l(properties));
                            }
                        } catch (Exception e11) {
                            TPLogUtil.e("TPReportManager", (Throwable) e11);
                        }
                    }
                }
            } catch (Exception e12) {
                TPLogUtil.e("TPReportManager", (Throwable) e12);
            }
        }
    }

    /* access modifiers changed from: private */
    public void j(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onStartSeek");
        if (map != null) {
            if (this.f49646x) {
                m(new com.tencent.thumbplayer.tcmedia.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a());
            }
            if (this.f49645w) {
                k(new com.tencent.thumbplayer.tcmedia.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a("petime", Long.valueOf(a(map, "pstime", 0) / 1000)).a());
            }
            this.f49645w = true;
            this.f49634l = 1;
            TPReportParams.UserSeekOnceParams createUserSeekOnceParams = this.f49632j.createUserSeekOnceParams();
            this.O = createUserSeekOnceParams;
            createUserSeekOnceParams.seekStartTimeUnix = a(map, "stime", System.currentTimeMillis());
            TPReportParams.CommonParams commonParams = this.f49632j.getCommonParams();
            TPReportParams.UserSeekOnceParams userSeekOnceParams = this.O;
            userSeekOnceParams.formatInt = commonParams.mediaFormatInt;
            userSeekOnceParams.startPresentTimeLong = a(map, "pstime", 0) / 1000;
        }
    }

    private void k() {
        this.f49639q = 0;
        this.f49640r = 0;
        this.f49644v = 0;
        this.f49643u = 0;
        this.f49645w = false;
        this.f49646x = false;
        this.f49637o = false;
        this.f49638p = false;
        this.C = "";
        this.D = 0;
        this.E = 0;
        this.G = 0;
        this.H = 0;
        this.f49642t = 0;
        this.f49647y = false;
        this.A = "";
        this.B = "";
        this.F = "";
        this.J = -1;
        this.f49648z = "0";
        this.P.a();
    }

    /* access modifiers changed from: private */
    public void k(Map<String, Object> map) {
        TPReportParams.UserSeekOnceParams userSeekOnceParams;
        TPLogUtil.i("TPReportManager", "onSeekComplete");
        this.f49645w = false;
        if (map != null && (userSeekOnceParams = this.O) != null) {
            userSeekOnceParams.seekEndTimeUnix = a(map, "etime", System.currentTimeMillis());
            this.O.endPresentTimeLong = a(map, "petime", 0) / 1000;
            TPReportParams.UserSeekOnceParams userSeekOnceParams2 = this.O;
            userSeekOnceParams2.errCodeString = this.f49648z;
            long j11 = userSeekOnceParams2.seekEndTimeUnix - userSeekOnceParams2.seekStartTimeUnix;
            if (j11 > 1200) {
                this.f49644v++;
                this.f49643u = (int) (((long) this.f49643u) + j11);
            }
            TPReportParams.UserSeekTotalParams userSeekTotalParams = this.f49632j.getUserSeekTotalParams();
            userSeekTotalParams.seekTotalCountInt++;
            userSeekTotalParams.seekBufferingDurationInt = this.f49643u;
            userSeekTotalParams.seekBufferingCountInt = this.f49644v;
            if (userSeekTotalParams.seekOnceParamsList.size() < 20) {
                userSeekTotalParams.seekOnceParamsList.add(this.O);
                l lVar = new l();
                this.O.paramsToProperties(lVar);
                this.K.a(40, lVar);
            }
            this.O = null;
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        TPLogUtil.d("TPReportManager", "handleReportThreadExit");
        synchronized (this.f49629f) {
            this.f49630g = true;
            this.f49629f.notify();
        }
    }

    /* access modifiers changed from: private */
    public void l(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onBufferingStart");
        if (map != null) {
            this.f49646x = true;
            if (!this.f49645w) {
                e eVar = this.P;
                if (eVar.f49653a > 0) {
                    int i11 = eVar.f49654b;
                    long currentTimeMillis = System.currentTimeMillis();
                    e eVar2 = this.P;
                    eVar.f49654b = i11 + ((int) (currentTimeMillis - eVar2.f49653a));
                    eVar2.f49653a = 0;
                }
                this.P.f49659g = a(map, "stime", System.currentTimeMillis());
                TPReportParams.BufferingOnceParams createBufferingOnceParams = this.f49632j.createBufferingOnceParams();
                this.N = createBufferingOnceParams;
                createBufferingOnceParams.starTimeUnix = this.P.f49659g;
                createBufferingOnceParams.formatInt = a(map, TUIConstants.TUIGroupNote.PLUGIN_GROUP_NOTE_FORMAT, 0);
                TPReportParams.CommonParams commonParams = this.f49632j.getCommonParams();
                TPReportParams.BufferingOnceParams bufferingOnceParams = this.N;
                bufferingOnceParams.formatInt = commonParams.mediaFormatInt;
                bufferingOnceParams.reasonInt = a(map, Constants.REASON, 0);
                TPReportParams.BufferingOnceParams bufferingOnceParams2 = this.N;
                bufferingOnceParams2.lastEventInt = this.f49634l;
                bufferingOnceParams2.sceneInt = this.f49633k;
                bufferingOnceParams2.bufferingPresentTimeLong = a(map, "ptime", 0) / 1000;
                this.N.urlString = a(map, "url", "");
            }
        }
    }

    private String m() {
        if (this.I == null) {
            return "0";
        }
        if (!TextUtils.isEmpty(f49624b)) {
            return f49624b;
        }
        int i11 = this.I.getResources().getDisplayMetrics().widthPixels;
        String str = this.I.getResources().getDisplayMetrics().heightPixels + "*" + i11;
        f49624b = str;
        return str;
    }

    /* access modifiers changed from: private */
    public void m(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onBufferingEnd");
        this.f49646x = false;
        e eVar = this.P;
        if (!eVar.f49667o) {
            eVar.f49653a = System.currentTimeMillis();
        }
        if (map != null) {
            long a11 = a(map, "etime", System.currentTimeMillis());
            e eVar2 = this.P;
            long j11 = eVar2.f49659g;
            int i11 = (int) (a11 - j11);
            if (i11 > 1200 && !this.f49645w) {
                eVar2.f49657e++;
                eVar2.f49660h = a11;
                eVar2.f49658f += (int) (a11 - j11);
                TPReportParams.BufferingOnceParams bufferingOnceParams = this.N;
                if (bufferingOnceParams != null) {
                    bufferingOnceParams.endTimeUnix = a(map, "etime", 0);
                    this.N.errCodeString = this.f49648z;
                    TPReportParams.BufferingTotalParams bufferingTotalParams = this.f49632j.getBufferingTotalParams();
                    bufferingTotalParams.bufferingCountInt++;
                    bufferingTotalParams.bufferingDurationInt += i11;
                    if (bufferingTotalParams.bufferingOnceParamsList.size() < 20) {
                        bufferingTotalParams.bufferingOnceParamsList.add(this.N);
                        l lVar = new l();
                        this.N.paramsToProperties(lVar);
                        this.K.a(35, lVar);
                    }
                    this.N = null;
                }
            }
        }
    }

    private int n() {
        NetworkInfo activeNetworkInfo;
        Context context = this.I;
        if (context == null) {
            return 0;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
                return 0;
            }
            int type = activeNetworkInfo.getType();
            if (type == 0) {
                return b(activeNetworkInfo.getSubtype());
            }
            if (type != 1) {
                return type != 9 ? 0 : 10;
            }
            return 1;
        } catch (Exception e11) {
            TPLogUtil.e("TPReportManager", (Throwable) e11);
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public void n(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onPlayComplete");
        if (map != null) {
            map.put(Constants.REASON, 0);
            q(map);
        }
    }

    private int o() {
        UiModeManager uiModeManager = (UiModeManager) this.I.getSystemService("uimode");
        if (uiModeManager == null) {
            return 2;
        }
        if (uiModeManager.getCurrentModeType() == 4) {
            return 9;
        }
        return (this.I.getResources().getConfiguration().screenLayout & 15) >= 3 ? 5 : 2;
    }

    /* access modifiers changed from: private */
    public void o(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onPlayerReset");
        if (map != null) {
            map.put(Constants.REASON, 1);
            q(map);
        }
    }

    /* access modifiers changed from: private */
    public void p(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onPlayerRelease");
        if (map != null) {
            map.put(Constants.REASON, 1);
            q(map);
        }
    }

    private void q(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onPlayEnd");
        if (map != null && !this.f49635m) {
            this.f49635m = true;
            if (this.J != 1 && this.f49637o) {
                d((Map<String, Object>) new com.tencent.thumbplayer.tcmedia.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a());
            }
            if (this.f49646x) {
                m(new com.tencent.thumbplayer.tcmedia.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a());
            }
            if (this.f49645w) {
                k(new com.tencent.thumbplayer.tcmedia.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a());
            }
            e eVar = this.P;
            if (eVar.f49653a > 0) {
                int i11 = eVar.f49654b;
                long currentTimeMillis = System.currentTimeMillis();
                e eVar2 = this.P;
                eVar.f49654b = i11 + ((int) (currentTimeMillis - eVar2.f49653a));
                eVar2.f49653a = 0;
            }
            this.f49645w = false;
            l lVar = new l();
            this.f49632j.getBufferingTotalParams().paramsToProperties(lVar);
            this.f49632j.getBufferingTotalParams().reset();
            this.f49632j.getUserSeekTotalParams().paramsToProperties(lVar);
            this.f49632j.getUserSeekTotalParams().reset();
            TPReportParams.PlayDoneParams playDoneParams = this.f49632j.getPlayDoneParams();
            playDoneParams.endTimeUnix = a(map, "etime", System.currentTimeMillis());
            playDoneParams.reasonInt = a(map, Constants.REASON, 0);
            playDoneParams.errCodeString = this.f49648z;
            long j11 = this.f49639q;
            if (j11 > 0) {
                this.f49640r += playDoneParams.endTimeUnix - j11;
                this.f49639q = 0;
            }
            playDoneParams.playDurationFloat = ((float) this.f49640r) / 1000.0f;
            playDoneParams.paramsToProperties(lVar);
            this.K.a(50, lVar);
            this.f49648z = "0";
            this.f49632j.resetAllParam();
            h();
            k();
        }
    }

    /* access modifiers changed from: private */
    public void r(Map<String, Object> map) {
        if (map != null) {
            this.f49633k = a(map, InnerShareParams.SCENCE, 1.0f) != 1.0f ? 2 : 1;
        }
    }

    /* access modifiers changed from: private */
    public void s(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onGetCdn");
        if (map != null) {
            l lVar = new l();
            TPReportParams.GetCdnUrlParams getCdnParams = this.f49632j.getGetCdnParams();
            getCdnParams.proxyIpString = a(map, "ip", "");
            getCdnParams.starTimeUnix = a(map, "stime", 0);
            getCdnParams.endTimeUnix = a(map, "etime", 0);
            getCdnParams.errCodeString = a(map, "code", "0");
            getCdnParams.paramsToProperties(lVar);
            this.K.a(15, lVar);
            if (!TextUtils.isEmpty(getCdnParams.errCodeString) && !getCdnParams.errCodeString.equals("0") && !getCdnParams.errCodeString.equals(IdManager.DEFAULT_VERSION_NAME)) {
                this.f49648z = getCdnParams.errCodeString;
            }
        }
    }

    /* access modifiers changed from: private */
    public void t(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "on302Redirect");
        if (map != null) {
            l lVar = new l();
            TPReportParams.RedirectParams redirectParams = this.f49632j.getRedirectParams();
            redirectParams.cdnTypeInt = a(map, "vt", 0);
            redirectParams.redirectCountInt = a(map, "t302", 0);
            redirectParams.redirectedUrlString = a(map, "url", "");
            redirectParams.starTimeUnix = a(map, "stime", 0);
            redirectParams.endTimeUnix = a(map, "etime", 0);
            redirectParams.errCodeString = a(map, "code", "0");
            redirectParams.paramsToProperties(lVar);
            this.K.a(34, lVar);
        }
    }

    /* access modifiers changed from: private */
    public void u(Map<String, Object> map) {
        if (map != null) {
            this.C = UUID.randomUUID().toString() + System.nanoTime() + "_" + TPPlayerConfig.getPlatform();
            this.f49648z = a(map, "code", "0");
            TPDefaultReportInfo tPDefaultReportInfo = this.f49631i;
            if (tPDefaultReportInfo != null) {
                this.J = tPDefaultReportInfo.getPlayType();
            }
            if (this.J == 1) {
                this.K.a(150, new l());
                return;
            }
            map.put(Constants.REASON, 3);
            this.f49635m = false;
            q(map);
        }
    }

    /* access modifiers changed from: private */
    public void v(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onLoadSubtitle");
        if (map != null) {
            this.P.f49675w.add(new f(a(map, "name", ""), a(map, "url", "")));
        }
    }

    /* access modifiers changed from: private */
    public void w(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onSelectTrack");
        if (map != null && this.P.f49675w.size() != 0 && a(map, "tracktype", 0) == 3) {
            this.f49638p = true;
            this.P.f49665m = true;
            TPReportParams.LoadSubtitleParams loadSubtitleParams = this.f49632j.getLoadSubtitleParams();
            loadSubtitleParams.starTimeUnix = a(map, "stime", 0);
            TPDefaultReportInfo tPDefaultReportInfo = this.f49631i;
            if (tPDefaultReportInfo != null) {
                loadSubtitleParams.cdnTypeInt = tPDefaultReportInfo.subtitleCdnType;
                loadSubtitleParams.cgiUrlIndex = tPDefaultReportInfo.subtitleUrlIndex;
            }
            long a11 = a(map, "opaque", -1);
            String a12 = a(map, "name", "");
            Iterator<f> it2 = this.P.f49675w.iterator();
            while (it2.hasNext()) {
                f next = it2.next();
                if (!TextUtils.isEmpty(a12) && next.f49677a.equals(a12)) {
                    loadSubtitleParams.subtitleUrlString = next.f49678b;
                    next.f49679c = a11;
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void x(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onSelectTrackDone");
        if (this.f49638p && map != null && this.P.f49675w.size() != 0) {
            long a11 = a(map, "opaque", -1);
            if (a11 != -1) {
                Iterator<f> it2 = this.P.f49675w.iterator();
                while (it2.hasNext()) {
                    if (it2.next().f49679c == a11) {
                        TPReportParams.LoadSubtitleParams loadSubtitleParams = this.f49632j.getLoadSubtitleParams();
                        loadSubtitleParams.endTimeUnix = a(map, "etime", 0);
                        loadSubtitleParams.errCodeString = a(map, "code", "0");
                        loadSubtitleParams.bufferingDurationInt = (int) (loadSubtitleParams.endTimeUnix - loadSubtitleParams.starTimeUnix);
                        l lVar = new l();
                        loadSubtitleParams.paramsToProperties(lVar);
                        this.K.a(33, lVar);
                        this.f49638p = false;
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void y(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onSwitchDef");
        if (map != null) {
            this.P.f49669q = a(map, "switch", "");
            this.P.f49667o = true;
            if (this.J == 1) {
                this.f49628e.removeMessages(3000);
                f();
                e eVar = this.P;
                eVar.f49655c = 0;
                eVar.f49656d = 0;
            }
        }
    }

    /* access modifiers changed from: private */
    public void z(Map<String, Object> map) {
        TPLogUtil.i("TPReportManager", "onSwitchDefEnd");
        if (map != null) {
            this.P.f49669q = a(map, "switch", "");
            this.P.f49667o = false;
            if (this.J == 1) {
                this.K.a(30, new l());
                this.f49628e.removeMessages(3000);
                this.f49628e.sendEmptyMessageDelayed(3000, 60000);
                this.P.f49653a = System.currentTimeMillis();
            }
        }
    }

    public void a() {
        d();
    }

    public void a(int i11, int i12, int i13, String str, Object obj) {
        int i14;
        switch (i11) {
            case 100:
                i14 = 999;
                break;
            case 101:
                i14 = 1000;
                break;
            case 102:
                i14 = 1001;
                break;
            case 103:
                i14 = 1002;
                break;
            case 104:
                i14 = 1003;
                break;
            case 105:
                i14 = 1012;
                break;
            case 106:
                i14 = 1004;
                break;
            case 107:
                i14 = 1005;
                break;
            case 108:
                i14 = 1006;
                break;
            case 109:
                i14 = 1007;
                break;
            case 110:
                i14 = 1008;
                break;
            case 111:
                i14 = 1009;
                break;
            case 112:
                i14 = 1010;
                break;
            case 113:
                i14 = 1011;
                break;
            case 114:
                i14 = 1013;
                break;
            case 115:
                i14 = 1014;
                break;
            case 116:
                i14 = 1015;
                break;
            case 117:
                i14 = 1016;
                break;
            case 118:
                i14 = 2002;
                break;
            case 119:
                i14 = 1019;
                break;
            case 120:
                i14 = 1020;
                break;
            case 121:
                i14 = 1021;
                break;
            case 122:
                i14 = 2004;
                break;
            case 123:
                i14 = 2005;
                break;
            case 124:
                i14 = 1022;
                break;
            default:
                switch (i11) {
                    case 200:
                        i14 = 1017;
                        break;
                    case 201:
                        i14 = 1018;
                        break;
                    case 202:
                        i14 = 1023;
                        break;
                    default:
                        return;
                }
        }
        this.f49628e.obtainMessage(i14, obj).sendToTarget();
    }

    public void b() {
        e();
    }

    public boolean c() {
        boolean z11;
        if (Math.random() < this.L) {
            TPLogUtil.i("TPReportManager", "reports are sampled");
            z11 = true;
        } else {
            TPLogUtil.i("TPReportManager", "reports are not sampled");
            z11 = false;
        }
        this.M = z11;
        return this.M;
    }

    public void reportEvent(int i11, Map<String, Object> map) {
    }

    public void setReportInfoGetter(TPDefaultReportInfo tPDefaultReportInfo) {
        this.f49631i = tPDefaultReportInfo;
    }

    public void setReportSamplingRate(double d11) {
        if (d11 < 0.0d) {
            d11 = 0.0d;
        }
        if (d11 > 1.0d) {
            d11 = 1.0d;
        }
        this.L = d11;
    }
}
