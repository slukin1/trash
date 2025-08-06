package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.az;
import com.xiaomi.push.service.ba;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dt {

    /* renamed from: a  reason: collision with root package name */
    private static a f51660a;

    /* renamed from: a  reason: collision with other field name */
    private static Map<String, gq> f2747a;

    public interface a {
        void uploader(Context context, gk gkVar);
    }

    public static int a(int i11) {
        if (i11 > 0) {
            return i11 + 1000;
        }
        return -1;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m2610a(int i11) {
        return i11 == 1000 ? "E100000" : i11 == 3000 ? "E100002" : i11 == 2000 ? "E100001" : i11 == 6000 ? "E100003" : "";
    }

    public static void a(a aVar) {
        f51660a = aVar;
    }

    private static void a(Context context, gk gkVar) {
        if (a(context.getApplicationContext())) {
            ba.a(context.getApplicationContext(), gkVar);
            return;
        }
        a aVar = f51660a;
        if (aVar != null) {
            aVar.uploader(context, gkVar);
        }
    }

    public static EventClientReport a(String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = str;
        return eventClientReport;
    }

    public static PerfClientReport a() {
        PerfClientReport perfClientReport = new PerfClientReport();
        perfClientReport.production = 1000;
        perfClientReport.reportType = 1000;
        perfClientReport.clientInterfaceId = "P100000";
        return perfClientReport;
    }

    public static EventClientReport a(Context context, String str, String str2, int i11, long j11, String str3) {
        EventClientReport a11 = a(str);
        a11.eventId = str2;
        a11.eventType = i11;
        a11.eventTime = j11;
        a11.eventContent = str3;
        return a11;
    }

    public static PerfClientReport a(Context context, int i11, long j11, long j12) {
        PerfClientReport a11 = a();
        a11.code = i11;
        a11.perfCounts = j11;
        a11.perfLatencies = j12;
        return a11;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2612a(Context context) {
        return context != null && !TextUtils.isEmpty(context.getPackageName()) && "com.xiaomi.xmsf".equals(context.getPackageName());
    }

    public static void a(Context context, List<String> list) {
        if (list != null) {
            try {
                for (String a11 : list) {
                    gk a12 = a(context, a11);
                    if (!az.a(a12, false)) {
                        a(context, a12);
                    }
                }
            } catch (Throwable th2) {
                b.d(th2.getMessage());
            }
        }
    }

    public static gk a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        gk gkVar = new gk();
        gkVar.d("category_client_report_data");
        gkVar.a("push_sdk_channel");
        gkVar.a(1);
        gkVar.b(str);
        gkVar.a(true);
        gkVar.b(System.currentTimeMillis());
        gkVar.g(context.getPackageName());
        gkVar.e("com.xiaomi.xmsf");
        gkVar.f(az.a());
        gkVar.c("quality_support");
        return gkVar;
    }

    public static void a(Context context, Config config) {
        ClientReportClient.init(context, config, new dr(context), new ds(context));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m2611a(Context context) {
        ClientReportClient.updateConfig(context, a(context));
    }

    public static Config a(Context context) {
        boolean a11 = ah.a(context).a(gl.PerfUploadSwitch.a(), false);
        boolean a12 = ah.a(context).a(gl.EventUploadNewSwitch.a(), false);
        int a13 = ah.a(context).a(gl.PerfUploadFrequency.a(), 86400);
        return Config.getBuilder().setEventUploadSwitchOpen(a12).setEventUploadFrequency((long) ah.a(context).a(gl.EventUploadFrequency.a(), 86400)).setPerfUploadSwitchOpen(a11).setPerfUploadFrequency((long) a13).build(context);
    }

    public static int a(Enum enumR) {
        if (enumR != null) {
            if (enumR instanceof gg) {
                return enumR.ordinal() + 1001;
            }
            if (enumR instanceof gq) {
                return enumR.ordinal() + 2001;
            }
            if (enumR instanceof ee) {
                return enumR.ordinal() + 3001;
            }
        }
        return -1;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gq m2609a(String str) {
        if (f2747a == null) {
            synchronized (gq.class) {
                if (f2747a == null) {
                    f2747a = new HashMap();
                    for (gq gqVar : gq.values()) {
                        f2747a.put(gqVar.f2942a.toLowerCase(), gqVar);
                    }
                }
            }
        }
        gq gqVar2 = f2747a.get(str.toLowerCase());
        return gqVar2 != null ? gqVar2 : gq.Invalid;
    }
}
