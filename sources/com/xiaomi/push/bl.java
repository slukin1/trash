package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.clientreport.processor.c;

public class bl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Context f51446a;

    /* renamed from: a  reason: collision with other field name */
    private c f2560a;

    public void a(c cVar) {
        this.f2560a = cVar;
    }

    public void run() {
        try {
            c cVar = this.f2560a;
            if (cVar != null) {
                cVar.a();
            }
            b.c("begin read and send perf / event");
            c cVar2 = this.f2560a;
            if (cVar2 instanceof IEventProcessor) {
                bn.a(this.f51446a).a("sp_client_report_status", "event_last_upload_time", System.currentTimeMillis());
            } else if (cVar2 instanceof IPerfProcessor) {
                bn.a(this.f51446a).a("sp_client_report_status", "perf_last_upload_time", System.currentTimeMillis());
            }
        } catch (Exception e11) {
            b.a((Throwable) e11);
        }
    }

    public void a(Context context) {
        this.f51446a = context;
    }
}
