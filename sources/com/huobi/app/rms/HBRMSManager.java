package com.huobi.app.rms;

import android.content.SharedPreferences;
import androidx.annotation.Keep;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.FileUtil;
import com.hbg.lib.network.hbg.core.bean.AppResConfigBean;
import com.hbg.lib.network.hbg.core.bean.RMSConfig;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.huobi.app.rms.bean.HBRMSResourceDownloadMode;
import com.huobi.app.rms.bean.HBRMSResourceInfoModel;
import com.huobi.app.rms.bean.HBRMSResourceType;
import com.huobi.lifecycle.OnBackgroundStatusChangedEvent;
import d10.p;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantLock;
import k20.h;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;

public final class HBRMSManager {

    /* renamed from: q  reason: collision with root package name */
    public static final a f42145q = new a((r) null);

    /* renamed from: r  reason: collision with root package name */
    public static HBRMSManager f42146r;

    /* renamed from: a  reason: collision with root package name */
    public RMSConfig f42147a;

    /* renamed from: b  reason: collision with root package name */
    public final List<HBRMSResourceInfoModel> f42148b;

    /* renamed from: c  reason: collision with root package name */
    public final List<HBRMSResourceInfoModel> f42149c;

    /* renamed from: d  reason: collision with root package name */
    public final List<HBRMSResourceInfoModel> f42150d;

    /* renamed from: e  reason: collision with root package name */
    public final List<HBRMSResourceInfoModel> f42151e;

    /* renamed from: f  reason: collision with root package name */
    public final List<HBRMSResourceInfoModel> f42152f;

    /* renamed from: g  reason: collision with root package name */
    public final List<HBRMSResourceInfoModel> f42153g;

    /* renamed from: h  reason: collision with root package name */
    public final List<HBRMSResourceInfoModel> f42154h;

    /* renamed from: i  reason: collision with root package name */
    public final List<HBRMSResourceInfoModel> f42155i;

    /* renamed from: j  reason: collision with root package name */
    public List<HBRMSResourceInfoModel> f42156j;

    /* renamed from: k  reason: collision with root package name */
    public long f42157k;

    /* renamed from: l  reason: collision with root package name */
    public HBRMSResourceDownloadMode f42158l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f42159m;

    /* renamed from: n  reason: collision with root package name */
    public List<HBRMSResourceDownloadMode> f42160n;

    /* renamed from: o  reason: collision with root package name */
    public Timer f42161o;

    /* renamed from: p  reason: collision with root package name */
    public final CoroutineDispatcher f42162p;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final synchronized HBRMSManager a() {
            if (HBRMSManager.f42146r == null) {
                HBRMSManager.f42146r = new HBRMSManager((r) null);
                HBRMSManager.f42146r.E();
            }
            return HBRMSManager.f42146r;
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f42163a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f42164b;

        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|27) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|27) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004c */
        static {
            /*
                com.huobi.app.rms.bean.HBRMSResourceType[] r0 = com.huobi.app.rms.bean.HBRMSResourceType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.huobi.app.rms.bean.HBRMSResourceType r2 = com.huobi.app.rms.bean.HBRMSResourceType.Skin     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.huobi.app.rms.bean.HBRMSResourceType r3 = com.huobi.app.rms.bean.HBRMSResourceType.H5     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.huobi.app.rms.bean.HBRMSResourceType r4 = com.huobi.app.rms.bean.HBRMSResourceType.EdgeEngine     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                com.huobi.app.rms.bean.HBRMSResourceType r5 = com.huobi.app.rms.bean.HBRMSResourceType.LanguageAndColor     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f42163a = r0
                com.huobi.app.rms.bean.HBRMSResourceDownloadMode[] r0 = com.huobi.app.rms.bean.HBRMSResourceDownloadMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.huobi.app.rms.bean.HBRMSResourceDownloadMode r5 = com.huobi.app.rms.bean.HBRMSResourceDownloadMode.Force     // Catch:{ NoSuchFieldError -> 0x003c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                com.huobi.app.rms.bean.HBRMSResourceDownloadMode r1 = com.huobi.app.rms.bean.HBRMSResourceDownloadMode.Async     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                com.huobi.app.rms.bean.HBRMSResourceDownloadMode r1 = com.huobi.app.rms.bean.HBRMSResourceDownloadMode.Idle     // Catch:{ NoSuchFieldError -> 0x004c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                com.huobi.app.rms.bean.HBRMSResourceDownloadMode r1 = com.huobi.app.rms.bean.HBRMSResourceDownloadMode.Background     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                f42164b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.app.rms.HBRMSManager.b.<clinit>():void");
        }
    }

    public static final class c extends TypeToken<List<? extends HBRMSResourceInfoModel>> {
    }

    public static final class d extends TimerTask {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HBRMSManager f42165b;

        public d(HBRMSManager hBRMSManager) {
            this.f42165b = hBRMSManager;
        }

        public void run() {
            if (this.f42165b.f42159m) {
                for (HBRMSResourceDownloadMode Q : this.f42165b.f42160n) {
                    this.f42165b.Q(Q);
                }
                Timer h11 = this.f42165b.f42161o;
                if (h11 == null) {
                    h11 = null;
                }
                h11.cancel();
            }
        }
    }

    public HBRMSManager() {
        this.f42148b = new ArrayList();
        this.f42149c = new ArrayList();
        this.f42150d = new ArrayList();
        this.f42151e = new ArrayList();
        this.f42152f = new ArrayList();
        this.f42153g = new ArrayList();
        this.f42154h = new ArrayList();
        this.f42155i = new ArrayList();
        this.f42156j = new ArrayList();
        this.f42158l = HBRMSResourceDownloadMode.Force;
        this.f42160n = new ArrayList();
        this.f42162p = v0.a();
    }

    public /* synthetic */ HBRMSManager(r rVar) {
        this();
    }

    public static /* synthetic */ Object y(HBRMSManager hBRMSManager, HBRMSResourceInfoModel hBRMSResourceInfoModel, p pVar, p pVar2, kotlin.coroutines.c cVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            pVar = null;
        }
        if ((i11 & 4) != 0) {
            pVar2 = null;
        }
        return hBRMSManager.x(hBRMSResourceInfoModel, pVar, pVar2, cVar);
    }

    public static final synchronized HBRMSManager z() {
        HBRMSManager a11;
        synchronized (HBRMSManager.class) {
            a11 = f42145q.a();
        }
        return a11;
    }

    public final synchronized String A(String str) {
        return O().getString(str, (String) null);
    }

    public final void B(List<HBRMSResourceInfoModel> list) {
        for (HBRMSResourceInfoModel next : list) {
            if (next != null) {
                next.setResourceExist(D(next));
            }
        }
    }

    public final void C() {
        n1 unused = i.d(g1.f57277b, this.f42162p, (CoroutineStart) null, new HBRMSManager$initRequest$1(this, (kotlin.coroutines.c<? super HBRMSManager$initRequest$1>) null), 2, (Object) null);
    }

    public final boolean D(HBRMSResourceInfoModel hBRMSResourceInfoModel) {
        return new File(hBRMSResourceInfoModel.getResourcePath()).exists();
    }

    public final void E() {
        EventBus.d().p(this);
        F();
        G();
    }

    public final void F() {
        String A = A("timeStamp");
        if (A != null) {
            this.f42157k = Long.parseLong(A);
        }
        RMSConfig rMSConfig = (RMSConfig) new Gson().fromJson(A("configCache"), RMSConfig.class);
        this.f42147a = rMSConfig;
        if (rMSConfig != null) {
            t();
        }
    }

    public final void G() {
        String A = A("downloadSuccessList");
        if (A != null) {
            this.f42156j = (List) new Gson().fromJson(A, new c().getType());
        }
    }

    public final void H(List<? extends AppResConfigBean> list, List<HBRMSResourceInfoModel> list2) {
        if (list != null) {
            for (AppResConfigBean appResConfigBean : list) {
                long j11 = appResConfigBean.endDate;
                if (j11 == 0 || j11 > System.currentTimeMillis()) {
                    HBRMSResourceInfoModel v11 = v(appResConfigBean);
                    if (v11.getDownloadOpp() != HBRMSResourceDownloadMode.Ineffective) {
                        list2.add(v11);
                        if (v11.getDownloadOpp() != HBRMSResourceDownloadMode.UnNeedLoad) {
                            r(v11, v11.getDownloadOpp());
                        }
                    }
                }
            }
        }
    }

    public final void I(d10.a<Unit> aVar) {
        this.f42159m = false;
        HBRMSManager$requestConfig$action$1 hBRMSManager$requestConfig$action$1 = new HBRMSManager$requestConfig$action$1(new ReentrantLock(), new Ref$BooleanRef(), this, aVar);
        RequestExtKt.d(v7.b.a().getRmsConfig(), new HBRMSManager$requestConfig$1(this, hBRMSManager$requestConfig$action$1), new HBRMSManager$requestConfig$2(hBRMSManager$requestConfig$action$1), (MutableLiveData) null, 4, (Object) null);
    }

    public final String J(HBRMSResourceInfoModel hBRMSResourceInfoModel) {
        HBRMSResourceType resourceType = hBRMSResourceInfoModel.getResourceType();
        String str = null;
        String L = resourceType != null ? L(resourceType) : null;
        String md5 = hBRMSResourceInfoModel.getMd5();
        if (md5 != null) {
            str = new File(L, md5).getPath();
        }
        return str == null ? "" : str;
    }

    public final List<HBRMSResourceInfoModel> K(HBRMSResourceType hBRMSResourceType) {
        ArrayList arrayList = new ArrayList();
        int i11 = b.f42163a[hBRMSResourceType.ordinal()];
        if (i11 == 1) {
            arrayList.addAll(CollectionsKt___CollectionsKt.X(CollectionsKt___CollectionsKt.I0(this.f42149c)));
        } else if (i11 == 2) {
            arrayList.addAll(CollectionsKt___CollectionsKt.X(CollectionsKt___CollectionsKt.I0(this.f42150d)));
        } else if (i11 == 3) {
            arrayList.addAll(CollectionsKt___CollectionsKt.X(CollectionsKt___CollectionsKt.I0(this.f42148b)));
        } else if (i11 == 4) {
            arrayList.addAll(CollectionsKt___CollectionsKt.X(CollectionsKt___CollectionsKt.I0(this.f42151e)));
        }
        return arrayList;
    }

    public final String L(HBRMSResourceType hBRMSResourceType) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(M());
        sb2.append(File.separator);
        sb2.append(hBRMSResourceType != null ? hBRMSResourceType.name() : null);
        return sb2.toString();
    }

    public final String M() {
        return BaseApplication.b().getFilesDir().getPath() + File.separator + "rms";
    }

    public final void N() {
        synchronized (this.f42156j) {
            R("downloadSuccessList", new Gson().toJson((Object) this.f42156j));
            Unit unit = Unit.f56620a;
        }
    }

    public final SharedPreferences O() {
        return BaseApplication.b().getSharedPreferences("HBRMS_PREFERENCES", 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object P(com.huobi.app.rms.bean.HBRMSResourceDownloadMode r12, kotlin.coroutines.c<? super kotlin.Unit> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.huobi.app.rms.HBRMSManager$startDownload$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.huobi.app.rms.HBRMSManager$startDownload$1 r0 = (com.huobi.app.rms.HBRMSManager$startDownload$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.huobi.app.rms.HBRMSManager$startDownload$1 r0 = new com.huobi.app.rms.HBRMSManager$startDownload$1
            r0.<init>(r11, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r12 = r0.L$2
            java.util.Iterator r12 = (java.util.Iterator) r12
            java.lang.Object r2 = r0.L$1
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r4 = r0.L$0
            com.huobi.app.rms.HBRMSManager r4 = (com.huobi.app.rms.HBRMSManager) r4
            kotlin.k.b(r13)
            r13 = r4
            goto L_0x00dc
        L_0x0037:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x003f:
            kotlin.k.b(r13)
            int[] r13 = com.huobi.app.rms.HBRMSManager.b.f42164b
            int r2 = r12.ordinal()
            r13 = r13[r2]
            if (r13 == r3) goto L_0x00cd
            r2 = 2
            if (r13 == r2) goto L_0x00b2
            r2 = 3
            if (r13 == r2) goto L_0x0085
            r2 = 4
            if (r13 == r2) goto L_0x0058
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        L_0x0058:
            com.huobi.app.rms.bean.HBRMSResourceDownloadMode r13 = r11.f42158l
            com.huobi.app.rms.bean.HBRMSResourceDownloadMode r2 = com.huobi.app.rms.bean.HBRMSResourceDownloadMode.Force
            if (r13 != r2) goto L_0x006a
            java.util.List<com.huobi.app.rms.bean.HBRMSResourceInfoModel> r13 = r11.f42152f
            boolean r13 = r13.isEmpty()
            r13 = r13 ^ r3
            if (r13 == 0) goto L_0x006a
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        L_0x006a:
            com.huobi.app.rms.bean.HBRMSResourceDownloadMode r13 = r11.f42158l
            com.huobi.app.rms.bean.HBRMSResourceDownloadMode r2 = com.huobi.app.rms.bean.HBRMSResourceDownloadMode.Async
            if (r13 != r2) goto L_0x007c
            java.util.List<com.huobi.app.rms.bean.HBRMSResourceInfoModel> r13 = r11.f42153g
            boolean r13 = r13.isEmpty()
            r13 = r13 ^ r3
            if (r13 == 0) goto L_0x007c
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        L_0x007c:
            java.util.List<com.huobi.app.rms.bean.HBRMSResourceInfoModel> r13 = r11.f42155i
            java.util.List r13 = kotlin.collections.CollectionsKt___CollectionsKt.I0(r13)
            java.util.List<com.huobi.app.rms.bean.HBRMSResourceInfoModel> r2 = r11.f42155i
            goto L_0x00d5
        L_0x0085:
            com.huobi.app.rms.bean.HBRMSResourceDownloadMode r13 = r11.f42158l
            com.huobi.app.rms.bean.HBRMSResourceDownloadMode r2 = com.huobi.app.rms.bean.HBRMSResourceDownloadMode.Force
            if (r13 != r2) goto L_0x0097
            java.util.List<com.huobi.app.rms.bean.HBRMSResourceInfoModel> r13 = r11.f42152f
            boolean r13 = r13.isEmpty()
            r13 = r13 ^ r3
            if (r13 == 0) goto L_0x0097
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        L_0x0097:
            com.huobi.app.rms.bean.HBRMSResourceDownloadMode r13 = r11.f42158l
            com.huobi.app.rms.bean.HBRMSResourceDownloadMode r2 = com.huobi.app.rms.bean.HBRMSResourceDownloadMode.Async
            if (r13 != r2) goto L_0x00a9
            java.util.List<com.huobi.app.rms.bean.HBRMSResourceInfoModel> r13 = r11.f42153g
            boolean r13 = r13.isEmpty()
            r13 = r13 ^ r3
            if (r13 == 0) goto L_0x00a9
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        L_0x00a9:
            java.util.List<com.huobi.app.rms.bean.HBRMSResourceInfoModel> r13 = r11.f42154h
            java.util.List r13 = kotlin.collections.CollectionsKt___CollectionsKt.I0(r13)
            java.util.List<com.huobi.app.rms.bean.HBRMSResourceInfoModel> r2 = r11.f42154h
            goto L_0x00d5
        L_0x00b2:
            com.huobi.app.rms.bean.HBRMSResourceDownloadMode r13 = r11.f42158l
            com.huobi.app.rms.bean.HBRMSResourceDownloadMode r2 = com.huobi.app.rms.bean.HBRMSResourceDownloadMode.Force
            if (r13 != r2) goto L_0x00c4
            java.util.List<com.huobi.app.rms.bean.HBRMSResourceInfoModel> r13 = r11.f42152f
            boolean r13 = r13.isEmpty()
            r13 = r13 ^ r3
            if (r13 == 0) goto L_0x00c4
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        L_0x00c4:
            java.util.List<com.huobi.app.rms.bean.HBRMSResourceInfoModel> r13 = r11.f42153g
            java.util.List r13 = kotlin.collections.CollectionsKt___CollectionsKt.I0(r13)
            java.util.List<com.huobi.app.rms.bean.HBRMSResourceInfoModel> r2 = r11.f42153g
            goto L_0x00d5
        L_0x00cd:
            java.util.List<com.huobi.app.rms.bean.HBRMSResourceInfoModel> r13 = r11.f42152f
            java.util.List r13 = kotlin.collections.CollectionsKt___CollectionsKt.I0(r13)
            java.util.List<com.huobi.app.rms.bean.HBRMSResourceInfoModel> r2 = r11.f42152f
        L_0x00d5:
            r11.f42158l = r12
            java.util.Iterator r12 = r13.iterator()
            r13 = r11
        L_0x00dc:
            boolean r4 = r12.hasNext()
            if (r4 == 0) goto L_0x0102
            java.lang.Object r4 = r12.next()
            r5 = r4
            com.huobi.app.rms.bean.HBRMSResourceInfoModel r5 = (com.huobi.app.rms.bean.HBRMSResourceInfoModel) r5
            r6 = 0
            com.huobi.app.rms.HBRMSManager$startDownload$2$1 r7 = new com.huobi.app.rms.HBRMSManager$startDownload$2$1
            r7.<init>(r2, r5)
            r9 = 2
            r10 = 0
            r0.L$0 = r13
            r0.L$1 = r2
            r0.L$2 = r12
            r0.label = r3
            r4 = r13
            r8 = r0
            java.lang.Object r4 = y(r4, r5, r6, r7, r8, r9, r10)
            if (r4 != r1) goto L_0x00dc
            return r1
        L_0x0102:
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.app.rms.HBRMSManager.P(com.huobi.app.rms.bean.HBRMSResourceDownloadMode, kotlin.coroutines.c):java.lang.Object");
    }

    public final void Q(HBRMSResourceDownloadMode hBRMSResourceDownloadMode) {
        n1 unused = i.d(g1.f57277b, this.f42162p, (CoroutineStart) null, new HBRMSManager$startDownloadInMode$1(this, hBRMSResourceDownloadMode, (kotlin.coroutines.c<? super HBRMSManager$startDownloadInMode$1>) null), 2, (Object) null);
    }

    public final synchronized void R(String str, String str2) {
        SharedPreferences.Editor edit = O().edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public final void S() {
        Timer a11 = z00.a.a("", false);
        a11.scheduleAtFixedRate(new d(this), 0, 500);
        this.f42161o = a11;
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public final void onBackgroundStatusChanged(OnBackgroundStatusChangedEvent onBackgroundStatusChangedEvent) {
        if (onBackgroundStatusChangedEvent.a() == OnBackgroundStatusChangedEvent.STATUS.FOREGROUND) {
            i6.d.b("后台切前台");
        } else if (onBackgroundStatusChangedEvent.a() == OnBackgroundStatusChangedEvent.STATUS.BACKGROUND) {
            i6.d.b("切后台");
            Q(HBRMSResourceDownloadMode.Background);
            u();
        }
    }

    public final void r(HBRMSResourceInfoModel hBRMSResourceInfoModel, HBRMSResourceDownloadMode hBRMSResourceDownloadMode) {
        int i11 = b.f42164b[hBRMSResourceDownloadMode.ordinal()];
        if (i11 == 1) {
            this.f42152f.add(hBRMSResourceInfoModel);
        } else if (i11 == 2) {
            this.f42153g.add(hBRMSResourceInfoModel);
        } else if (i11 == 3) {
            this.f42154h.add(hBRMSResourceInfoModel);
        } else if (i11 == 4) {
            this.f42155i.add(hBRMSResourceInfoModel);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object s(com.huobi.app.rms.bean.HBRMSResourceInfoModel r6, kotlin.coroutines.c<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.huobi.app.rms.HBRMSManager$addSuccessModel$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.huobi.app.rms.HBRMSManager$addSuccessModel$1 r0 = (com.huobi.app.rms.HBRMSManager$addSuccessModel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.huobi.app.rms.HBRMSManager$addSuccessModel$1 r0 = new com.huobi.app.rms.HBRMSManager$addSuccessModel$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r6 = r0.L$0
            com.huobi.app.rms.HBRMSManager r6 = (com.huobi.app.rms.HBRMSManager) r6
            kotlin.k.b(r7)
            goto L_0x0061
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            kotlin.k.b(r7)
            java.util.List<com.huobi.app.rms.bean.HBRMSResourceInfoModel> r7 = r5.f42156j
            monitor-enter(r7)
            java.util.List<com.huobi.app.rms.bean.HBRMSResourceInfoModel> r2 = r5.f42156j     // Catch:{ all -> 0x0067 }
            com.huobi.app.rms.HBRMSManager$addSuccessModel$2$1 r4 = new com.huobi.app.rms.HBRMSManager$addSuccessModel$2$1     // Catch:{ all -> 0x0067 }
            r4.<init>(r6)     // Catch:{ all -> 0x0067 }
            boolean unused = kotlin.collections.CollectionsKt__MutableCollectionsKt.G(r2, r4)     // Catch:{ all -> 0x0067 }
            java.util.List<com.huobi.app.rms.bean.HBRMSResourceInfoModel> r2 = r5.f42156j     // Catch:{ all -> 0x0067 }
            r2.add(r6)     // Catch:{ all -> 0x0067 }
            monitor-exit(r7)
            kotlinx.coroutines.MainCoroutineDispatcher r6 = kotlinx.coroutines.v0.c()
            com.huobi.app.rms.HBRMSManager$addSuccessModel$3 r7 = new com.huobi.app.rms.HBRMSManager$addSuccessModel$3
            r2 = 0
            r7.<init>(r2)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.g.g(r6, r7, r0)
            if (r6 != r1) goto L_0x0060
            return r1
        L_0x0060:
            r6 = r5
        L_0x0061:
            r6.N()
            kotlin.Unit r6 = kotlin.Unit.f56620a
            return r6
        L_0x0067:
            r6 = move-exception
            monitor-exit(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.app.rms.HBRMSManager.s(com.huobi.app.rms.bean.HBRMSResourceInfoModel, kotlin.coroutines.c):java.lang.Object");
    }

    public final void t() {
        this.f42149c.clear();
        this.f42151e.clear();
        this.f42150d.clear();
        this.f42148b.clear();
        this.f42152f.clear();
        this.f42155i.clear();
        this.f42154h.clear();
        this.f42153g.clear();
        RMSConfig rMSConfig = this.f42147a;
        if (rMSConfig != null) {
            H(rMSConfig.skinResource, this.f42149c);
            H(rMSConfig.h5Resource, this.f42150d);
            H(rMSConfig.appResources, this.f42151e);
            H(rMSConfig.edgeEngineResource, this.f42148b);
        }
    }

    public final void u() {
        if (this.f42159m) {
            ArrayList arrayList = new ArrayList();
            ArrayList<HBRMSResourceInfoModel> arrayList2 = new ArrayList<>();
            List<HBRMSResourceInfoModel> L0 = CollectionsKt___CollectionsKt.L0(this.f42156j);
            ArrayList<HBRMSResourceInfoModel> arrayList3 = new ArrayList<>();
            arrayList3.addAll(this.f42149c);
            arrayList3.addAll(this.f42148b);
            arrayList3.addAll(this.f42151e);
            arrayList3.addAll(this.f42150d);
            for (HBRMSResourceInfoModel hBRMSResourceInfoModel : L0) {
                boolean z11 = true;
                boolean z12 = false;
                for (HBRMSResourceInfoModel hBRMSResourceInfoModel2 : arrayList3) {
                    if (hBRMSResourceInfoModel2 != null) {
                        if (x.b(hBRMSResourceInfoModel2.getConfigId(), hBRMSResourceInfoModel.getConfigId())) {
                            z12 = true;
                        }
                        if (x.b(hBRMSResourceInfoModel2.getMd5(), hBRMSResourceInfoModel.getMd5())) {
                            z11 = false;
                        }
                    }
                }
                if (!z12) {
                    arrayList.add(hBRMSResourceInfoModel);
                }
                if (z11) {
                    arrayList2.add(hBRMSResourceInfoModel);
                }
            }
            if (!arrayList.isEmpty()) {
                synchronized (L0) {
                    L0.removeAll(arrayList);
                }
                N();
            }
            for (HBRMSResourceInfoModel hBRMSResourceInfoModel3 : arrayList2) {
                String resourcePath = hBRMSResourceInfoModel3.getResourcePath();
                FileUtil.c(new File(hBRMSResourceInfoModel3.getResourcePath()));
                new File(resourcePath).delete();
                new File(hBRMSResourceInfoModel3.getResourceDownloadFilePath()).delete();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.m(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.huobi.app.rms.bean.HBRMSResourceInfoModel v(com.hbg.lib.network.hbg.core.bean.AppResConfigBean r8) {
        /*
            r7 = this;
            com.huobi.app.rms.bean.HBRMSResourceInfoModel r0 = new com.huobi.app.rms.bean.HBRMSResourceInfoModel
            r0.<init>(r8)
            com.huobi.app.rms.bean.HBRMSResourceDownloadMode r8 = r0.getDownloadOpp()
            com.huobi.app.rms.bean.HBRMSResourceDownloadMode r1 = com.huobi.app.rms.bean.HBRMSResourceDownloadMode.Force
            if (r8 != r1) goto L_0x0012
            com.huobi.app.rms.bean.HBRMSResourceDownloadMode r8 = com.huobi.app.rms.bean.HBRMSResourceDownloadMode.Async
            r0.setDownloadOpp(r8)
        L_0x0012:
            r8 = 105400(0x19bb8, float:1.47697E-40)
            java.lang.String r1 = r0.getMinVersion()
            if (r1 == 0) goto L_0x0026
            java.lang.Integer r1 = kotlin.text.StringsKt__StringNumberConversionsKt.m(r1)
            if (r1 == 0) goto L_0x0026
            int r1 = r1.intValue()
            goto L_0x0027
        L_0x0026:
            r1 = r8
        L_0x0027:
            java.lang.String r2 = r0.getMaxVersion()
            if (r2 == 0) goto L_0x0038
            java.lang.Integer r2 = kotlin.text.StringsKt__StringNumberConversionsKt.m(r2)
            if (r2 == 0) goto L_0x0038
            int r2 = r2.intValue()
            goto L_0x0039
        L_0x0038:
            r2 = r8
        L_0x0039:
            if (r8 < r1) goto L_0x0096
            if (r8 <= r2) goto L_0x003e
            goto L_0x0096
        L_0x003e:
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = r7.f42157k
            long r1 = r1 + r3
            float r8 = r0.getBeginDate()
            r3 = 0
            int r8 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            r4 = 1
            r5 = 0
            if (r8 != 0) goto L_0x0052
            r8 = r4
            goto L_0x0053
        L_0x0052:
            r8 = r5
        L_0x0053:
            r6 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x005c
            float r8 = (float) r1
            float r8 = r8 * r6
            r0.setBeginDate(r8)
        L_0x005c:
            float r8 = r0.getEndDate()
            int r8 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r4 = r5
        L_0x0066:
            if (r4 == 0) goto L_0x006d
            float r8 = (float) r1
            float r8 = r8 * r6
            r0.setEndDate(r8)
        L_0x006d:
            float r8 = (float) r1
            float r1 = r0.getEndDate()
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x007c
            com.huobi.app.rms.bean.HBRMSResourceDownloadMode r8 = com.huobi.app.rms.bean.HBRMSResourceDownloadMode.Ineffective
            r0.setDownloadOpp(r8)
            goto L_0x0095
        L_0x007c:
            boolean r1 = r7.D(r0)
            if (r1 == 0) goto L_0x0088
            com.huobi.app.rms.bean.HBRMSResourceDownloadMode r8 = com.huobi.app.rms.bean.HBRMSResourceDownloadMode.UnNeedLoad
            r0.setDownloadOpp(r8)
            goto L_0x0095
        L_0x0088:
            float r1 = r0.getBeginDate()
            int r8 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r8 >= 0) goto L_0x0095
            com.huobi.app.rms.bean.HBRMSResourceDownloadMode r8 = com.huobi.app.rms.bean.HBRMSResourceDownloadMode.Idle
            r0.setDownloadOpp(r8)
        L_0x0095:
            return r0
        L_0x0096:
            com.huobi.app.rms.bean.HBRMSResourceDownloadMode r8 = com.huobi.app.rms.bean.HBRMSResourceDownloadMode.Ineffective
            r0.setDownloadOpp(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.app.rms.HBRMSManager.v(com.hbg.lib.network.hbg.core.bean.AppResConfigBean):com.huobi.app.rms.bean.HBRMSResourceInfoModel");
    }

    public final String w() {
        JSONObject jSONObject = new JSONObject();
        Gson gson = new Gson();
        B(this.f42148b);
        B(this.f42151e);
        B(this.f42149c);
        B(this.f42150d);
        jSONObject.put("currentEdgeEngine", JSON.parse(gson.toJson((Object) this.f42148b)));
        jSONObject.put("currentAppResources", JSON.parse(gson.toJson((Object) this.f42151e)));
        jSONObject.put("currentSkin", JSON.parse(gson.toJson((Object) this.f42149c)));
        jSONObject.put("currentH5", JSON.parse(gson.toJson((Object) this.f42150d)));
        return jSONObject.toJSONString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: d10.p<? super java.lang.Exception, ? super java.lang.String, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object x(com.huobi.app.rms.bean.HBRMSResourceInfoModel r5, d10.p<? super java.lang.Long, ? super java.lang.Long, kotlin.Unit> r6, d10.p<? super java.lang.Exception, ? super java.lang.String, kotlin.Unit> r7, kotlin.coroutines.c<? super kotlin.Unit> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.huobi.app.rms.HBRMSManager$downloadResourceWithModel$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.huobi.app.rms.HBRMSManager$downloadResourceWithModel$1 r0 = (com.huobi.app.rms.HBRMSManager$downloadResourceWithModel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.huobi.app.rms.HBRMSManager$downloadResourceWithModel$1 r0 = new com.huobi.app.rms.HBRMSManager$downloadResourceWithModel$1
            r0.<init>(r4, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r5 = r0.L$1
            r7 = r5
            d10.p r7 = (d10.p) r7
            java.lang.Object r5 = r0.L$0
            com.huobi.app.rms.bean.HBRMSResourceInfoModel r5 = (com.huobi.app.rms.bean.HBRMSResourceInfoModel) r5
            kotlin.k.b(r8)
            goto L_0x0050
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            kotlin.k.b(r8)
            boolean r8 = r4.D(r5)
            if (r8 == 0) goto L_0x005d
            r0.L$0 = r5
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r6 = r4.s(r5, r0)
            if (r6 != r1) goto L_0x0050
            return r1
        L_0x0050:
            if (r7 == 0) goto L_0x005a
            r6 = 0
            java.lang.String r5 = r5.getResourcePath()
            r7.invoke(r6, r5)
        L_0x005a:
            kotlin.Unit r5 = kotlin.Unit.f56620a
            return r5
        L_0x005d:
            com.huobi.app.rms.HBResourceDownloadManager$a r8 = com.huobi.app.rms.HBResourceDownloadManager.f42166c
            com.huobi.app.rms.HBResourceDownloadManager r8 = r8.a()
            com.huobi.app.rms.HBRMSManager$downloadResourceWithModel$2 r0 = new com.huobi.app.rms.HBRMSManager$downloadResourceWithModel$2
            r0.<init>(r6)
            com.huobi.app.rms.HBRMSManager$downloadResourceWithModel$3 r6 = new com.huobi.app.rms.HBRMSManager$downloadResourceWithModel$3
            r6.<init>(r7, r4, r5)
            r8.e(r5, r0, r6)
            kotlin.Unit r5 = kotlin.Unit.f56620a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.app.rms.HBRMSManager.x(com.huobi.app.rms.bean.HBRMSResourceInfoModel, d10.p, d10.p, kotlin.coroutines.c):java.lang.Object");
    }
}
