package ku;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huobi.vulcan.core.Scene;
import com.huobi.vulcan.core.WorkHandler;
import com.huobi.vulcan.model.Config;
import com.huobi.vulcan.model.VulcanInfo;
import com.huobi.vulcan.utils.HexUtil;
import com.huobi.vulcan.utils.MD5Util;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class c implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, Config> f22863b;

    /* renamed from: c  reason: collision with root package name */
    public nu.a f22864c;

    /* renamed from: d  reason: collision with root package name */
    public final Config f22865d;

    /* renamed from: e  reason: collision with root package name */
    public long f22866e;

    public class a implements aq.a<List<Config>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ aq.a f22867a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f22868b;

        public a(aq.a aVar, int i11) {
            this.f22867a = aVar;
            this.f22868b = i11;
        }

        /* renamed from: b */
        public void a(List<Config> list) {
            if (list != null && this.f22867a != null) {
                for (Config next : list) {
                    if (next.getScenes() == this.f22868b) {
                        this.f22867a.a(next);
                        return;
                    }
                }
            }
        }
    }

    public class b implements aq.a<List<Config>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f22870a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ aq.a f22871b;

        public b(int i11, aq.a aVar) {
            this.f22870a = i11;
            this.f22871b = aVar;
        }

        /* renamed from: b */
        public void a(List<Config> list) {
            if (this.f22870a == 2 && list != null) {
                c.this.t();
            }
            c.this.B(list);
            aq.a aVar = this.f22871b;
            if (aVar != null) {
                aVar.a(list);
            }
        }
    }

    /* renamed from: ku.c$c  reason: collision with other inner class name */
    public class C0195c implements aq.a<Config> {
        public C0195c() {
        }

        /* renamed from: b */
        public void a(Config config) {
            c.this.y(config);
        }
    }

    public class d implements aq.a<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Config f22874a;

        public d(Config config) {
            this.f22874a = config;
        }

        /* renamed from: b */
        public void a(Boolean bool) {
            boolean z11 = false;
            int i11 = (bool == null || !bool.booleanValue()) ? 0 : 1;
            c.this.o().e(this.f22874a.getcHash(), i11);
            b e11 = b.e();
            if (i11 == 1) {
                z11 = true;
            }
            e11.p(z11);
        }
    }

    public class e implements aq.a<List<Config>> {
        public e() {
        }

        /* renamed from: b */
        public void a(List<Config> list) {
            c.this.j();
        }
    }

    public class f implements aq.a<List<Config>> {
        public f() {
        }

        /* renamed from: b */
        public void a(List<Config> list) {
            c.this.j();
        }
    }

    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public static final c f22878a = new c((a) null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c q() {
        return g.f22878a;
    }

    public void A(long j11) {
        lu.a.b("VulcanConfigManager", "updateAllConfigDelay(" + j11 + ").");
        if (j11 >= 0) {
            WorkHandler.d().j(2002, j11);
        }
    }

    public final void B(List<Config> list) {
        if (list != null && !list.isEmpty()) {
            for (Config next : list) {
                if (next.isInit()) {
                    int c11 = o().c(next.getcHash(), 0);
                    if (c11 == -1) {
                        if (next.isNeedUpload()) {
                            o().e(next.getcHash(), 0);
                        }
                    } else if (c11 == 0) {
                        Config n11 = n(Scene.Init.val);
                        if (n11 != null && !n11.getcHash().equals(next.getcHash()) && !this.f22865d.getcHash().equalsIgnoreCase(n11.getcHash())) {
                            o().a(n11.getcHash());
                        }
                        o().e(next.getcHash(), 0);
                    }
                }
                this.f22863b.put(Integer.valueOf(next.getScenes()), next);
            }
        }
    }

    public final void a() {
        lu.a.b("VulcanConfigManager", "WorkHandler异步检查初始化配置, 判断是否需要上报数据.");
        Config n11 = n(Scene.Init.val);
        if (n11 != null) {
            int c11 = o().c(n11.getcHash(), 0);
            lu.a.b("VulcanConfigManager", "checkInitReportDataAndReUpload status=>" + c11 + ", config=>" + n11.toString());
            if (c11 == 0 && n11.isNeedUpload()) {
                y(n11);
            }
        }
    }

    public final void b() {
        long p11 = p();
        long k11 = k();
        lu.a.b("VulcanConfigManager", "WorkHandler异步checkLocalAndUpdateConfig> latestOverdue=" + k11 + ", current=" + p11);
        if (k11 > p11) {
            long j11 = k11 - p11;
            long random = (long) ((int) (((Math.random() * 55.0d) + 5.0d) * 1000.0d));
            A(Math.max(j11 - random, random));
        } else if (k11 > 0) {
            A(0);
        }
    }

    public final void c() {
        lu.a.b("VulcanConfigManager", "WorkHandler拉取初始化配置");
        v(0, Scene.Init.val, new e());
    }

    public final void d() {
        lu.a.b("VulcanConfigManager", "WorkHandler开始拉取初始化配置");
        u(new f());
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 2001:
                b();
                return true;
            case 2002:
                d();
                return true;
            case 2003:
                a();
                return true;
            case 2004:
                c();
                return true;
            default:
                return false;
        }
    }

    public void i() {
        WorkHandler.d().h(2002);
    }

    public void j() {
        WorkHandler.d().i(2003);
    }

    public final long k() {
        Collection<Config> values = this.f22863b.values();
        if (values == null || values.isEmpty()) {
            this.f22866e = -1;
        } else {
            long j11 = Long.MAX_VALUE;
            for (Config next : values) {
                if (next != null) {
                    j11 = Math.min(j11, next.getOverdue());
                }
            }
            if (j11 != Long.MAX_VALUE) {
                this.f22866e = j11;
            } else {
                this.f22866e = -1;
            }
        }
        return this.f22866e;
    }

    public void l() {
        i();
        WorkHandler.d().i(2001);
    }

    public final int m() {
        return iu.a.f().e();
    }

    public final Config n(int i11) {
        return this.f22863b.get(Integer.valueOf(i11));
    }

    public final nu.a o() {
        if (this.f22864c == null) {
            this.f22864c = nu.a.b(a.b(), "huobi_vulcan_config_store");
        }
        return this.f22864c;
    }

    public final long p() {
        return Calendar.getInstance(TimeZone.getTimeZone("GMT-0")).getTimeInMillis();
    }

    public Map<String, String> r(int i11) {
        String h11 = b.e().h(a.b());
        if (TextUtils.isEmpty(h11)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(VulcanInfo.V_HASH, HexUtil.b(MD5Util.b(h11)));
        return hashMap;
    }

    public Map<String, String> s(int i11) {
        Config n11 = n(i11);
        if (n11 != null) {
            return mu.a.b(n11);
        }
        l();
        return null;
    }

    public final void t() {
        this.f22863b.clear();
        this.f22863b.put(0, this.f22865d);
    }

    public final void u(aq.a<List<Config>> aVar) {
        v(2, Scene.None.val, aVar);
    }

    public void v(int i11, int i12, aq.a<List<Config>> aVar) {
        mu.a.e(i11, m(), i12, new b(i11, aVar));
    }

    @Deprecated
    public final void w(int i11, aq.a<Config> aVar) {
        v(1, i11, new a(aVar, i11));
    }

    @Deprecated
    public void x(int i11) {
        Config n11 = n(i11);
        if (n11 == null || n11.isOverdue()) {
            w(i11, new C0195c());
        } else {
            y(n11);
        }
    }

    public final void y(Config config) {
        mu.a.j(config, new d(config));
    }

    public void z(int i11) {
        Config n11 = n(i11);
        if (n11 != null && n11.isInit()) {
            o().e(n11.getcHash(), -1);
        }
    }

    public c() {
        this.f22863b = new HashMap();
        this.f22864c = null;
        this.f22865d = Config.getDefaultConfig();
        this.f22866e = -1;
        t();
        WorkHandler.d().g(this);
    }
}
