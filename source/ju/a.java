package ju;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build;
import android.os.SystemClock;
import com.huobi.vulcan.core.Scene;
import com.huobi.vulcan.core.WorkHandler;
import com.huobi.vulcan.model.VulcanInfo;
import com.huobi.vulcan.utils.HexUtil;
import com.huobi.vulcan.utils.MD5Util;
import com.huobi.vulcan.utils.NetworkUtils;
import com.huobi.vulcan.utils.RootUtil;
import com.huobi.vulcan.utils.StringUtils;
import com.huobi.vulcan.utils.SystemUtils;
import com.huobi.vulcan.utils.a;
import com.huobi.vulcan.utils.riskinfo.DeviceInfoUtils;
import com.sumsub.sns.internal.core.common.n0;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class a implements SensorEventListener {

    /* renamed from: i  reason: collision with root package name */
    public static final List<String> f22842i = Arrays.asList(new String[]{VulcanInfo.PARAM_RISKINFO, "ssid", "bssid", "ip", VulcanInfo.BA_STATUS, VulcanInfo.BA_CAPACITY});

    /* renamed from: j  reason: collision with root package name */
    public static final List<String> f22843j = Arrays.asList(new String[]{VulcanInfo.APPLIST, VulcanInfo.MEMINFO, VulcanInfo.DISKINFO, VulcanInfo.UPTIME, VulcanInfo.WIFI_LIST, VulcanInfo.ARP_INFO});
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public VulcanInfo f22844b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f22845c;

    /* renamed from: d  reason: collision with root package name */
    public int f22846d;

    /* renamed from: e  reason: collision with root package name */
    public a.C0157a f22847e;

    /* renamed from: f  reason: collision with root package name */
    public a.C0157a f22848f;

    /* renamed from: g  reason: collision with root package name */
    public a.C0157a f22849g;

    /* renamed from: h  reason: collision with root package name */
    public a.C0157a f22850h;

    /* renamed from: ju.a$a  reason: collision with other inner class name */
    public class C0193a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f22851b;

        public C0193a(Context context) {
            this.f22851b = context;
        }

        public void run() {
            a.this.s(this.f22851b);
            a.this.w(this.f22851b);
            a.this.u();
            a.this.z(this.f22851b);
            lu.a.b("VulcanInfoCollector", "WorkHandler初始化采集数据完成 >>>");
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f22853a = new a((C0193a) null);
    }

    public /* synthetic */ a(C0193a aVar) {
        this();
    }

    public static a o() {
        return b.f22853a;
    }

    public Map<String, String> e(int i11, List<String> list) {
        if (i11 != Scene.Init.getVal()) {
            return f(list);
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        List<String> list2 = f22842i;
        ArrayList arrayList = new ArrayList(list2);
        arrayList.retainAll(list);
        ArrayList arrayList2 = new ArrayList(list2);
        arrayList2.removeAll(arrayList);
        x(ku.a.b(), arrayList2);
        List<String> list3 = f22843j;
        ArrayList arrayList3 = new ArrayList(list3);
        arrayList3.retainAll(list);
        ArrayList arrayList4 = new ArrayList(list3);
        arrayList4.removeAll(arrayList3);
        v(arrayList4);
        return y(list);
    }

    public Map<String, String> f(List<String> list) {
        x(ku.a.b(), list);
        v(list);
        HashMap hashMap = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (String next : list) {
                String h11 = h(next);
                if (StringUtils.f(h11)) {
                    hashMap.put(next, h11);
                }
            }
        }
        return hashMap;
    }

    public void g(Context context) {
        if (this.f22844b == null) {
            this.f22844b = new VulcanInfo();
        }
        lu.a.b("VulcanInfoCollector", "初始化设备指纹");
        ku.b.e().b(context);
        String h11 = ku.b.e().h(context);
        t(VulcanInfo.V_HASH, HexUtil.b(MD5Util.b(h11)));
        t(VulcanInfo.VTOKEN, h11);
    }

    public final String h(String str) {
        return this.f22845c.get(str);
    }

    public final a.C0157a i() {
        if (this.f22848f == null) {
            this.f22848f = com.huobi.vulcan.utils.a.a("pm list packages -3", false);
        }
        return this.f22848f;
    }

    public final String j(Context context) {
        return context != null ? context.getPackageName() : "";
    }

    public final a.C0157a k() {
        if (this.f22850h == null) {
            this.f22850h = com.huobi.vulcan.utils.a.a("cat /proc/net/arp", false);
        }
        return this.f22850h;
    }

    public HashMap<String, String> l() {
        return this.f22845c;
    }

    public final a.C0157a m() {
        if (this.f22847e == null) {
            this.f22847e = com.huobi.vulcan.utils.a.a("cat /proc/cpuinfo", false);
        }
        return this.f22847e;
    }

    public final String n() {
        a.C0157a m11 = m();
        if (m11.f20618a != 0) {
            return "";
        }
        int indexOf = m11.f20619b.indexOf(10);
        return m11.f20619b.substring(m11.f20619b.indexOf(58) + 1, indexOf);
    }

    public void onAccuracyChanged(Sensor sensor, int i11) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        sensorEvent.sensor.getType();
    }

    public final a.C0157a p() {
        return com.huobi.vulcan.utils.a.a("cat /proc/meminfo", false);
    }

    public final a.C0157a q() {
        if (this.f22849g == null) {
            this.f22849g = com.huobi.vulcan.utils.a.a("cat /proc/partitions", false);
        }
        return this.f22849g;
    }

    public void r(Context context) {
        WorkHandler.d().f(new C0193a(context));
    }

    public final void s(Context context) {
        String str;
        if (this.f22844b == null) {
            this.f22844b = new VulcanInfo();
        }
        t(VulcanInfo.PLATFORM_TYPE, String.valueOf(2));
        t(VulcanInfo.PRODUCT_TYPE, String.valueOf(iu.a.f().e()));
        t(VulcanInfo.WM, String.valueOf(iu.a.f().h()));
        t(VulcanInfo.SYS, n0.f32119g);
        t(VulcanInfo.SYS_VER, Build.VERSION.RELEASE);
        t("brand", Build.BRAND);
        t(VulcanInfo.P_TYPE, Build.MODEL);
        t(VulcanInfo.SERIAL, SystemUtils.p());
        t(VulcanInfo.APP_V, SystemUtils.x(context));
        t(VulcanInfo.SDK_V, "1.3.1");
        t("network_type", NetworkUtils.d(context).toString());
        t(VulcanInfo.DISPLAY_RESOLUTION, SystemUtils.h(context));
        t(VulcanInfo.JAILBREAK, RootUtil.d() ? "1" : "0");
        t(VulcanInfo.IMEI, SystemUtils.j(context));
        t("mac", SystemUtils.l(context));
        t(VulcanInfo.ANDR_ID, SystemUtils.b(context));
        t(VulcanInfo.SIM_ID, SystemUtils.s(context));
        t(VulcanInfo.IMSI, SystemUtils.k(context));
        t(VulcanInfo.SIM_COUNTRY, SystemUtils.q(context));
        t(VulcanInfo.SIM_OPERATOR, SystemUtils.r(context));
        t(VulcanInfo.BOARD, Build.BOARD);
        t(VulcanInfo.BOOTLOADER, Build.BOOTLOADER);
        t(VulcanInfo.CPU_ABI, String.valueOf(SystemUtils.a()));
        t(VulcanInfo.DENSITY, String.valueOf(SystemUtils.g(context)));
        t(VulcanInfo.XDPI, String.valueOf(SystemUtils.y(context)));
        t(VulcanInfo.YDPI, String.valueOf(SystemUtils.z(context)));
        t(VulcanInfo.TOTAL_MEMORY, String.valueOf(SystemUtils.v(context)));
        t(VulcanInfo.FREE_MEMORY, String.valueOf(SystemUtils.i(context)));
        t(VulcanInfo.CPU_V, n());
        t("display", Build.DISPLAY);
        t(VulcanInfo.FP, Build.FINGERPRINT);
        t(VulcanInfo.HOST, Build.HOST);
        t(VulcanInfo.HARDWARE, Build.HARDWARE);
        t(VulcanInfo.B_TIME, String.valueOf(Build.TIME));
        t(VulcanInfo.INCREMENTAL, Build.VERSION.INCREMENTAL);
        t(VulcanInfo.AID, SystemUtils.w(context));
        t(VulcanInfo.CPUINFO, m().toString());
        t(VulcanInfo.APPLIST, j(context));
        t(VulcanInfo.TIME_ZONE, TimeZone.getDefault().getID());
        t(VulcanInfo.PARAM_VTENC, ku.b.e().i());
        t(VulcanInfo.PARAM_UUID, ku.b.e().g());
        t(VulcanInfo.PARAM_HWID, DeviceInfoUtils.e());
        String d11 = DeviceInfoUtils.d();
        String str2 = "";
        if (StringUtils.d(d11) || d11.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length <= 1) {
            str = str2;
        } else {
            str2 = d11.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[0];
            str = d11.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1];
        }
        t(VulcanInfo.PARAM_WVLEVEL, str2);
        t(VulcanInfo.PARAM_WVID, str);
        String f11 = ku.b.e().f();
        String d12 = ku.b.e().d();
        if (!StringUtils.d(f11) && !f11.equals(d12)) {
            t(VulcanInfo.PARAM_RELATE_VTOKEN, f11);
        }
    }

    public final void t(String str, String str2) {
        this.f22845c.put(str, str2);
    }

    public final void u() {
        v((List<String>) null);
    }

    public final void v(List<String> list) {
        long j11;
        long j12;
        ArrayList<String> arrayList = new ArrayList<>(f22843j);
        if (list != null && !list.isEmpty()) {
            arrayList.retainAll(list);
        }
        for (String str : arrayList) {
            str.hashCode();
            char c11 = 65535;
            switch (str.hashCode()) {
                case -1352448370:
                    if (str.equals(VulcanInfo.ARP_INFO)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -838362136:
                    if (str.equals(VulcanInfo.UPTIME)) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -793234881:
                    if (str.equals(VulcanInfo.APPLIST)) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 280386507:
                    if (str.equals(VulcanInfo.DISKINFO)) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 949098499:
                    if (str.equals(VulcanInfo.MEMINFO)) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 1400954760:
                    if (str.equals(VulcanInfo.WIFI_LIST)) {
                        c11 = 5;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    t(VulcanInfo.ARP_INFO, k().toString());
                    break;
                case 1:
                    if (Build.VERSION.SDK_INT >= 17) {
                        j12 = System.currentTimeMillis();
                        j11 = SystemClock.elapsedRealtimeNanos();
                    } else {
                        j12 = System.currentTimeMillis();
                        j11 = SystemClock.elapsedRealtime();
                    }
                    t(VulcanInfo.UPTIME, String.valueOf(j12 - (j11 / 1000000)));
                    break;
                case 2:
                    t(VulcanInfo.APPLIST, i().toString());
                    break;
                case 3:
                    t(VulcanInfo.DISKINFO, q().toString());
                    break;
                case 4:
                    t(VulcanInfo.MEMINFO, p().toString());
                    break;
                case 5:
                    t(VulcanInfo.WIFI_LIST, "");
                    break;
            }
        }
    }

    public final void w(Context context) {
        x(context, (List<String>) null);
    }

    public final void x(Context context, List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>(f22842i);
        if (list != null && !list.isEmpty()) {
            arrayList.retainAll(list);
        }
        for (String str : arrayList) {
            str.hashCode();
            char c11 = 65535;
            switch (str.hashCode()) {
                case -1966978062:
                    if (str.equals(VulcanInfo.BA_STATUS)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1866821446:
                    if (str.equals(VulcanInfo.BA_CAPACITY)) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -1090072579:
                    if (str.equals(VulcanInfo.PARAM_RISKINFO)) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 3367:
                    if (str.equals("ip")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 3539835:
                    if (str.equals("ssid")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 94044893:
                    if (str.equals("bssid")) {
                        c11 = 5;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    t(VulcanInfo.BA_STATUS, String.valueOf(SystemUtils.d(context)));
                    break;
                case 1:
                    t(VulcanInfo.BA_CAPACITY, String.valueOf(SystemUtils.c(context)));
                    break;
                case 2:
                    t(VulcanInfo.PARAM_RISKINFO, ou.a.d().f());
                    break;
                case 3:
                    t("ip", NetworkUtils.c(true));
                    break;
                case 4:
                    t("ssid", NetworkUtils.e(context));
                    break;
                case 5:
                    t("bssid", NetworkUtils.b(context));
                    break;
            }
        }
    }

    public final Map<String, String> y(List<String> list) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f22845c.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            if (StringUtils.f(str2) && !list.contains(str)) {
                hashMap.put(str, str2);
            }
        }
        return hashMap;
    }

    public final void z(Context context) {
        this.f22844b.setS_acce_value("");
        this.f22844b.setS_gyro_value("");
        this.f22844b.setS_grad_value("");
        this.f22844b.setS_magn_value("");
        this.f22844b.setS_orie_value("");
        this.f22844b.setS_light_value("");
        this.f22844b.setS_press_value("");
        this.f22844b.setS_temp_value("");
        this.f22844b.setS_grav_value("");
        this.f22844b.setLat("");
        this.f22844b.setLng("");
    }

    public a() {
        this.f22846d = 1000000;
        this.f22844b = new VulcanInfo();
        this.f22845c = new LinkedHashMap();
    }
}
