package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.sumsub.sns.prooface.network.Liveness3dFaceRepository;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerMsg;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.data.a;
import com.xiaomi.clientreport.manager.ClientReportClient;

public class du {

    /* renamed from: a  reason: collision with root package name */
    private static volatile du f51661a;

    /* renamed from: a  reason: collision with other field name */
    private Context f2748a;

    private du(Context context) {
        this.f2748a = context;
    }

    public static du a(Context context) {
        if (f51661a == null) {
            synchronized (du.class) {
                if (f51661a == null) {
                    f51661a = new du(context);
                }
            }
        }
        return f51661a;
    }

    public void b(String str, String str2, String str3, String str4) {
        a(str, str2, str3, TPPlayerMsg.TP_PLAYER_INFO_LONG0_PREPARE_TIMEOUT, System.currentTimeMillis(), str4);
    }

    public void c(String str, String str2, String str3, String str4) {
        a(str, str2, str3, Liveness3dFaceRepository.f40234n, System.currentTimeMillis(), str4);
    }

    public void a(String str, String str2, String str3, int i11, long j11, String str4) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            EventClientReport a11 = dt.a(this.f2748a, str2, str3, i11, j11, str4);
            a11.setAppPackageName(str);
            a11.setSdkVersion("6_0_1-C");
            a((a) a11);
        }
    }

    public void a(String str, String str2, String str3, int i11, String str4) {
        a(str, str2, str3, i11, System.currentTimeMillis(), str4);
    }

    public void a(String str, Intent intent, int i11, String str2) {
        if (intent != null) {
            String str3 = str;
            a(str3, dt.a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), i11, System.currentTimeMillis(), str2);
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        a(str, str2, str3, 5002, System.currentTimeMillis(), str4);
    }

    public void a(String str, Intent intent, String str2) {
        if (intent != null) {
            String str3 = str;
            a(str3, dt.a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), TPPlayerMsg.TP_PLAYER_INFO_LONG0_PREPARE_TIMEOUT, System.currentTimeMillis(), str2);
        }
    }

    public void a(String str, int i11, long j11, long j12) {
        if (i11 >= 0 && j12 >= 0 && j11 > 0) {
            PerfClientReport a11 = dt.a(this.f2748a, i11, j11, j12);
            a11.setAppPackageName(str);
            a11.setSdkVersion("6_0_1-C");
            a((a) a11);
        }
    }

    private void a(a aVar) {
        if (aVar instanceof PerfClientReport) {
            ClientReportClient.reportPerf(this.f2748a, (PerfClientReport) aVar);
        } else if (aVar instanceof EventClientReport) {
            ClientReportClient.reportEvent(this.f2748a, (EventClientReport) aVar);
        }
    }
}
