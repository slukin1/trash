package com.xiaomi.clientreport.manager;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.clientreport.processor.c;
import com.xiaomi.push.af;
import com.xiaomi.push.bc;
import com.xiaomi.push.bj;
import com.xiaomi.push.bk;
import com.xiaomi.push.bl;
import com.xiaomi.push.bm;
import com.xiaomi.push.bn;
import com.xiaomi.push.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f51263a = (j.a() ? 30 : 10);

    /* renamed from: a  reason: collision with other field name */
    private static volatile a f2412a;

    /* renamed from: a  reason: collision with other field name */
    private Context f2413a;

    /* renamed from: a  reason: collision with other field name */
    private Config f2414a;

    /* renamed from: a  reason: collision with other field name */
    private IEventProcessor f2415a;

    /* renamed from: a  reason: collision with other field name */
    private IPerfProcessor f2416a;

    /* renamed from: a  reason: collision with other field name */
    private String f2417a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f2418a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private ExecutorService f2419a = Executors.newSingleThreadExecutor();

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f51264b = new HashMap<>();

    private a(Context context) {
        this.f2413a = context;
    }

    private void d() {
        try {
            this.f2415a.b();
        } catch (Exception e11) {
            b.d("we: " + e11.getMessage());
        }
    }

    private void e() {
        try {
            this.f2416a.b();
        } catch (Exception e11) {
            b.d("wp: " + e11.getMessage());
        }
    }

    private void f() {
        if (a(this.f2413a).a().isEventUploadSwitchOpen()) {
            final bj bjVar = new bj(this.f2413a);
            int eventUploadFrequency = (int) a(this.f2413a).a().getEventUploadFrequency();
            if (eventUploadFrequency < 1800) {
                eventUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - bn.a(this.f2413a).a("sp_client_report_status", "event_last_upload_time", 0) > ((long) (eventUploadFrequency * 1000))) {
                af.a(this.f2413a).a((Runnable) new Runnable() {
                    public void run() {
                        bjVar.run();
                    }
                }, 10);
            }
            synchronized (a.class) {
                if (!af.a(this.f2413a).a((af.a) bjVar, eventUploadFrequency)) {
                    af.a(this.f2413a).a("100886");
                    af.a(this.f2413a).a((af.a) bjVar, eventUploadFrequency);
                }
            }
        }
    }

    private void g() {
        if (a(this.f2413a).a().isPerfUploadSwitchOpen()) {
            final bk bkVar = new bk(this.f2413a);
            int perfUploadFrequency = (int) a(this.f2413a).a().getPerfUploadFrequency();
            if (perfUploadFrequency < 1800) {
                perfUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - bn.a(this.f2413a).a("sp_client_report_status", "perf_last_upload_time", 0) > ((long) (perfUploadFrequency * 1000))) {
                af.a(this.f2413a).a((Runnable) new Runnable() {
                    public void run() {
                        bkVar.run();
                    }
                }, 15);
            }
            synchronized (a.class) {
                if (!af.a(this.f2413a).a((af.a) bkVar, perfUploadFrequency)) {
                    af.a(this.f2413a).a("100887");
                    af.a(this.f2413a).a((af.a) bkVar, perfUploadFrequency);
                }
            }
        }
    }

    public void c() {
        if (a().isPerfUploadSwitchOpen()) {
            bl blVar = new bl();
            blVar.a((c) this.f2416a);
            blVar.a(this.f2413a);
            this.f2419a.execute(blVar);
        }
    }

    /* access modifiers changed from: private */
    public void b(EventClientReport eventClientReport) {
        IEventProcessor iEventProcessor = this.f2415a;
        if (iEventProcessor != null) {
            iEventProcessor.a(eventClientReport);
            if (a() >= 10) {
                d();
                af.a(this.f2413a).a("100888");
                return;
            }
            a((af.a) new af.a() {
                public String a() {
                    return "100888";
                }

                public void run() {
                    if (a.a(a.this) > 0) {
                        a.a(a.this).execute(new Runnable() {
                            public void run() {
                                a.a(a.this);
                            }
                        });
                    }
                }
            }, f51263a);
        }
    }

    public static a a(Context context) {
        if (f2412a == null) {
            synchronized (a.class) {
                if (f2412a == null) {
                    f2412a = new a(context);
                }
            }
        }
        return f2412a;
    }

    /* access modifiers changed from: private */
    public void b(PerfClientReport perfClientReport) {
        IPerfProcessor iPerfProcessor = this.f2416a;
        if (iPerfProcessor != null) {
            iPerfProcessor.a(perfClientReport);
            if (b() >= 10) {
                e();
                af.a(this.f2413a).a("100889");
                return;
            }
            a((af.a) new af.a() {
                public String a() {
                    return "100889";
                }

                public void run() {
                    if (a.b(a.this) > 0) {
                        a.a(a.this).execute(new Runnable() {
                            public void run() {
                                a.b(a.this);
                            }
                        });
                    }
                }
            }, f51263a);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Config m2318a() {
        if (this.f2414a == null) {
            this.f2414a = Config.defaultConfig(this.f2413a);
        }
        return this.f2414a;
    }

    private int b() {
        HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap = this.f2418a;
        int i11 = 0;
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                HashMap hashMap2 = this.f2418a.get(str);
                if (hashMap2 != null) {
                    for (String str2 : hashMap2.keySet()) {
                        com.xiaomi.clientreport.data.a aVar = (com.xiaomi.clientreport.data.a) hashMap2.get(str2);
                        if (aVar instanceof PerfClientReport) {
                            i11 = (int) (((long) i11) + ((PerfClientReport) aVar).perfCounts);
                        }
                    }
                }
            }
        }
        return i11;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2319a() {
        a(this.f2413a).f();
        a(this.f2413a).g();
    }

    public void a(String str) {
        this.f2417a = str;
    }

    public void a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f2414a = config;
        this.f2415a = iEventProcessor;
        this.f2416a = iPerfProcessor;
        iEventProcessor.setEventMap(this.f51264b);
        this.f2416a.setPerfMap(this.f2418a);
    }

    public void a(boolean z11, boolean z12, long j11, long j12) {
        Config config = this.f2414a;
        if (config == null) {
            return;
        }
        if (z11 != config.isEventUploadSwitchOpen() || z12 != this.f2414a.isPerfUploadSwitchOpen() || j11 != this.f2414a.getEventUploadFrequency() || j12 != this.f2414a.getPerfUploadFrequency()) {
            long eventUploadFrequency = this.f2414a.getEventUploadFrequency();
            long perfUploadFrequency = this.f2414a.getPerfUploadFrequency();
            Config build = Config.getBuilder().setAESKey(bm.a(this.f2413a)).setEventEncrypted(this.f2414a.isEventEncrypted()).setEventUploadSwitchOpen(z11).setEventUploadFrequency(j11).setPerfUploadSwitchOpen(z12).setPerfUploadFrequency(j12).build(this.f2413a);
            this.f2414a = build;
            if (!build.isEventUploadSwitchOpen()) {
                af.a(this.f2413a).a("100886");
            } else if (eventUploadFrequency != build.getEventUploadFrequency()) {
                b.c(this.f2413a.getPackageName() + "reset event job " + build.getEventUploadFrequency());
                f();
            }
            if (!this.f2414a.isPerfUploadSwitchOpen()) {
                af.a(this.f2413a).a("100887");
            } else if (perfUploadFrequency != build.getPerfUploadFrequency()) {
                b.c(this.f2413a.getPackageName() + " reset perf job " + build.getPerfUploadFrequency());
                g();
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m2320b() {
        if (a().isEventUploadSwitchOpen()) {
            bl blVar = new bl();
            blVar.a(this.f2413a);
            blVar.a((c) this.f2415a);
            this.f2419a.execute(blVar);
        }
    }

    private void a(af.a aVar, int i11) {
        af.a(this.f2413a).b(aVar, i11);
    }

    public void a(final EventClientReport eventClientReport) {
        if (a().isEventUploadSwitchOpen()) {
            this.f2419a.execute(new Runnable() {
                public void run() {
                    a.this.b(eventClientReport);
                }
            });
        }
    }

    public void a(final PerfClientReport perfClientReport) {
        if (a().isPerfUploadSwitchOpen()) {
            this.f2419a.execute(new Runnable() {
                public void run() {
                    a.this.b(perfClientReport);
                }
            });
        }
    }

    private int a() {
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap = this.f51264b;
        if (hashMap == null) {
            return 0;
        }
        int i11 = 0;
        for (String str : hashMap.keySet()) {
            ArrayList arrayList = this.f51264b.get(str);
            i11 += arrayList != null ? arrayList.size() : 0;
        }
        return i11;
    }

    public EventClientReport a(int i11, String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.eventContent = str;
        eventClientReport.eventTime = System.currentTimeMillis();
        eventClientReport.eventType = i11;
        eventClientReport.eventId = bc.a(6);
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = "E100004";
        eventClientReport.setAppPackageName(this.f2413a.getPackageName());
        eventClientReport.setSdkVersion(this.f2417a);
        return eventClientReport;
    }
}
