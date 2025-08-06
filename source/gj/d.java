package gj;

import android.text.TextUtils;
import android.util.Log;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.screenshot.ScreenShotActivityMonitor;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.control.api.ControlConfigService;
import com.huobi.control.bean.BizControlConfig;
import com.huobi.control.bean.BizControlConfigItem;
import i6.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;
import u6.g;

public final class d {

    /* renamed from: j  reason: collision with root package name */
    public static final d f47544j = new d();

    /* renamed from: a  reason: collision with root package name */
    public BizControlConfig f47545a;

    /* renamed from: b  reason: collision with root package name */
    public BizControlConfig f47546b;

    /* renamed from: c  reason: collision with root package name */
    public BizControlConfigItem f47547c;

    /* renamed from: d  reason: collision with root package name */
    public BizControlConfigItem f47548d;

    /* renamed from: e  reason: collision with root package name */
    public BizControlConfigItem f47549e;

    /* renamed from: f  reason: collision with root package name */
    public BizControlConfigItem f47550f;

    /* renamed from: g  reason: collision with root package name */
    public BizControlConfigItem f47551g;

    /* renamed from: h  reason: collision with root package name */
    public long f47552h;

    /* renamed from: i  reason: collision with root package name */
    public Map<Integer, BizControlConfigItem> f47553i = new HashMap();

    public class a implements Func1<BizControlConfig, Boolean> {
        public a() {
        }

        /* renamed from: a */
        public Boolean call(BizControlConfig bizControlConfig) {
            return Boolean.valueOf(bizControlConfig != null);
        }
    }

    public class b extends BaseSubscriber<BizControlConfig> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(BizControlConfig bizControlConfig) {
            super.onNext(bizControlConfig);
            k.o("HbControl", "loadControlConfig success");
            k.o("HbControl", bizControlConfig.toString());
            BizControlConfig unused = d.this.f47545a = bizControlConfig;
            d.this.M(bizControlConfig);
            d.this.O(bizControlConfig);
            d.this.P(bizControlConfig);
            d.this.L(bizControlConfig);
            d.this.N(bizControlConfig);
            d.this.K(bizControlConfig);
            BaseModuleConfig.a().c0();
            ScreenShotActivityMonitor.b().d();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            k.f("HbControl", "loadControlConfig has error");
            k.j("HbControl", th2);
            d.this.M((BizControlConfig) null);
            d.this.O((BizControlConfig) null);
            d.this.P((BizControlConfig) null);
            d.this.L((BizControlConfig) null);
            d.this.N((BizControlConfig) null);
        }
    }

    public static /* synthetic */ HbgIntCodeResponse H(Throwable th2) {
        return null;
    }

    public static d n() {
        return f47544j;
    }

    public static int o(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.contains("[17]")) {
            return 17;
        }
        if (str.contains("[16]")) {
            return 16;
        }
        if (str.contains("[15]")) {
            return 15;
        }
        if (str.contains("[14]")) {
            return 14;
        }
        if (str.contains("[13]")) {
            return 13;
        }
        if (str.contains("[12]")) {
            return 12;
        }
        if (str.contains("[31]")) {
            return 31;
        }
        return 0;
    }

    public boolean A() {
        boolean r11 = r(21);
        k.o("HbControl", "isOnlineServiceOpen = " + r11);
        return r11;
    }

    public boolean B() {
        return "open".equals(k().getState());
    }

    public boolean C() {
        return r(37);
    }

    public boolean D() {
        if (!AppLanguageHelper.getInstance().isChineseLanguage()) {
            return true;
        }
        BizControlConfigItem bizControlConfigItem = this.f47553i.get(18);
        if (bizControlConfigItem != null) {
            return "open".equals(bizControlConfigItem.getState());
        }
        BizControlConfigItem bizControlConfigItem2 = null;
        Iterator<BizControlConfigItem> it2 = l().getControlList().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            BizControlConfigItem next = it2.next();
            if (next.getCode() == 18) {
                bizControlConfigItem2 = next;
                break;
            }
        }
        if (bizControlConfigItem2 == null) {
            return false;
        }
        return "open".equals(bizControlConfigItem2.getState());
    }

    public boolean E() {
        return u(19);
    }

    public boolean F(int i11) {
        BizControlConfigItem bizControlConfigItem = this.f47553i.get(Integer.valueOf(i11));
        if (bizControlConfigItem != null) {
            return "open".equals(bizControlConfigItem.getState());
        }
        BizControlConfigItem bizControlConfigItem2 = null;
        Iterator<BizControlConfigItem> it2 = l().getControlList().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            BizControlConfigItem next = it2.next();
            if (next.getCode() == i11) {
                bizControlConfigItem2 = next;
                break;
            }
        }
        if (bizControlConfigItem2 == null) {
            return true;
        }
        return "open".equals(bizControlConfigItem2.getState());
    }

    public boolean G() {
        return u(20);
    }

    public void I() {
        i().subscribe(new b());
    }

    public final void J() {
        BizControlConfigItem bizControlConfigItem = new BizControlConfigItem();
        this.f47551g = bizControlConfigItem;
        bizControlConfigItem.setCode(10);
        String d11 = ConfigPreferences.d("user_config", "HB_CONTROL_CONFIG_PUSH_FILTER_MODULE");
        if (!TextUtils.isEmpty(d11)) {
            this.f47551g.setState(d11);
            Log.i("HbControl", "load cache " + this.f47551g);
            return;
        }
        this.f47551g.setState("open");
        Log.i("HbControl", "load default " + this.f47551g);
    }

    public final void K(BizControlConfig bizControlConfig) {
        if (!(bizControlConfig == null || bizControlConfig.getControlList() == null || bizControlConfig.getControlList().isEmpty())) {
            for (BizControlConfigItem next : bizControlConfig.getControlList()) {
                this.f47553i.put(Integer.valueOf(next.getCode()), next);
                ConfigPreferences.m("user_config", "HB_CONTROL_CONFIG_MODULE_" + next.getCode(), next.getState());
            }
        }
        Log.i("HbControl", "controlConfigItemMap = " + this.f47553i);
        k.o("HbControl", "controlConfigItemMap = " + this.f47553i);
    }

    public final void L(BizControlConfig bizControlConfig) {
        if (bizControlConfig == null || bizControlConfig.getControlList() == null || bizControlConfig.getControlList().isEmpty()) {
            BizControlConfigItem bizControlConfigItem = new BizControlConfigItem();
            this.f47549e = bizControlConfigItem;
            bizControlConfigItem.setCode(8);
            String d11 = ConfigPreferences.d("user_config", "HB_CONTROL_CONFIG_INVITE_MODULE");
            if (!TextUtils.isEmpty(d11)) {
                this.f47549e.setState(d11);
                Log.i("HbControl", "load cache " + this.f47549e);
                return;
            }
            this.f47549e.setState("close");
            Log.i("HbControl", "load default " + this.f47549e);
            return;
        }
        for (BizControlConfigItem next : bizControlConfig.getControlList()) {
            if (8 == next.getCode()) {
                ConfigPreferences.m("user_config", "HB_CONTROL_CONFIG_INVITE_MODULE", next.getState());
                this.f47549e = next;
                Log.i("HbControl", "load remote " + this.f47549e);
                return;
            }
        }
    }

    public final void M(BizControlConfig bizControlConfig) {
        if (bizControlConfig == null || bizControlConfig.getControlList() == null || bizControlConfig.getControlList().isEmpty()) {
            BizControlConfigItem bizControlConfigItem = new BizControlConfigItem();
            this.f47547c = bizControlConfigItem;
            bizControlConfigItem.setCode(1);
            String d11 = ConfigPreferences.d("user_config", "HB_CONTROL_CONFIG_LITE_MODULE");
            if (!TextUtils.isEmpty(d11)) {
                this.f47547c.setState(d11);
                Log.i("HbControl", "load cache " + this.f47547c);
                return;
            }
            this.f47547c.setState("open");
            Log.i("HbControl", "load default " + this.f47547c);
            return;
        }
        for (BizControlConfigItem next : bizControlConfig.getControlList()) {
            if (1 == next.getCode()) {
                ConfigPreferences.m("user_config", "HB_CONTROL_CONFIG_LITE_MODULE", next.getState());
                this.f47547c = next;
                Log.i("HbControl", "load remote " + this.f47547c);
                return;
            }
        }
    }

    public final void N(BizControlConfig bizControlConfig) {
        if (bizControlConfig == null || bizControlConfig.getControlList() == null || bizControlConfig.getControlList().isEmpty()) {
            J();
            return;
        }
        for (BizControlConfigItem next : bizControlConfig.getControlList()) {
            if (10 == next.getCode()) {
                ConfigPreferences.m("user_config", "HB_CONTROL_CONFIG_PUSH_FILTER_MODULE", next.getState());
                this.f47551g = next;
                Log.i("HbControl", "load remote " + this.f47551g);
                return;
            }
        }
    }

    public final void O(BizControlConfig bizControlConfig) {
        if (bizControlConfig == null || bizControlConfig.getControlList() == null || bizControlConfig.getControlList().isEmpty()) {
            BizControlConfigItem bizControlConfigItem = new BizControlConfigItem();
            this.f47548d = bizControlConfigItem;
            bizControlConfigItem.setCode(7);
            String d11 = ConfigPreferences.d("user_config", "HB_CONTROL_CONFIG_REMIND_MODULE");
            if (!TextUtils.isEmpty(d11)) {
                this.f47548d.setState(d11);
                Log.i("HbControl", "load cache " + this.f47548d);
                return;
            }
            this.f47548d.setState("open");
            Log.i("HbControl", "load default " + this.f47548d);
            return;
        }
        for (BizControlConfigItem next : bizControlConfig.getControlList()) {
            if (7 == next.getCode()) {
                ConfigPreferences.m("user_config", "HB_CONTROL_CONFIG_REMIND_MODULE", next.getState());
                this.f47548d = next;
                Log.i("HbControl", "load remote " + this.f47548d);
                return;
            }
        }
    }

    public final void P(BizControlConfig bizControlConfig) {
        if (bizControlConfig == null || bizControlConfig.getControlList() == null || bizControlConfig.getControlList().isEmpty()) {
            BizControlConfigItem bizControlConfigItem = new BizControlConfigItem();
            this.f47550f = bizControlConfigItem;
            bizControlConfigItem.setCode(9);
            String d11 = ConfigPreferences.d("user_config", "HB_CONTROL_CONFIG_SHARE_MODULE");
            if (!TextUtils.isEmpty(d11)) {
                this.f47550f.setState(d11);
                Log.i("HbControl", "load cache " + this.f47550f);
                return;
            }
            this.f47550f.setState("close");
            Log.i("HbControl", "load default " + this.f47550f);
            return;
        }
        for (BizControlConfigItem next : bizControlConfig.getControlList()) {
            if (9 == next.getCode()) {
                ConfigPreferences.m("user_config", "HB_CONTROL_CONFIG_SHARE_MODULE", next.getState());
                this.f47550f = next;
                Log.i("HbControl", "load remote " + this.f47550f);
                return;
            }
        }
    }

    public void Q(long j11) {
        this.f47552h = j11;
    }

    public final Observable<BizControlConfig> i() {
        return Observable.concat(Observable.just(this.f47545a), ((ControlConfigService) HbgRetrofit.request(ControlConfigService.class)).getBizControlConfig().compose(RxJavaHelper.t((g) null)).timeout(2, TimeUnit.SECONDS).onErrorReturn(c.f54821b).compose(HbgRetrofit.e()), m()).takeFirst(new a());
    }

    public BizControlConfigItem j() {
        if (this.f47549e == null) {
            BizControlConfigItem bizControlConfigItem = new BizControlConfigItem();
            this.f47549e = bizControlConfigItem;
            bizControlConfigItem.setCode(8);
            String d11 = ConfigPreferences.d("user_config", "HB_CONTROL_CONFIG_INVITE_MODULE");
            if (!TextUtils.isEmpty(d11)) {
                this.f47549e.setState(d11);
                Log.i("HbControl", "use cache " + this.f47549e);
            } else {
                this.f47549e.setState("open");
                Log.i("HbControl", "use default " + this.f47549e);
            }
        }
        return this.f47549e;
    }

    public BizControlConfigItem k() {
        if (this.f47548d == null) {
            BizControlConfigItem bizControlConfigItem = new BizControlConfigItem();
            this.f47548d = bizControlConfigItem;
            bizControlConfigItem.setCode(7);
            String d11 = ConfigPreferences.d("user_config", "HB_CONTROL_CONFIG_LITE_MODULE");
            if (!TextUtils.isEmpty(d11)) {
                this.f47548d.setState(d11);
                Log.i("HbControl", "use cache " + this.f47548d);
            } else {
                this.f47548d.setState("open");
                Log.i("HbControl", "use default " + this.f47548d);
            }
        }
        return this.f47548d;
    }

    public final BizControlConfig l() {
        if (this.f47546b == null) {
            BizControlConfig bizControlConfig = new BizControlConfig();
            ArrayList arrayList = new ArrayList();
            BizControlConfigItem bizControlConfigItem = new BizControlConfigItem();
            bizControlConfigItem.setCode(1);
            bizControlConfigItem.setState("open");
            BizControlConfigItem bizControlConfigItem2 = new BizControlConfigItem();
            bizControlConfigItem2.setCode(7);
            bizControlConfigItem2.setState("open");
            BizControlConfigItem bizControlConfigItem3 = new BizControlConfigItem();
            bizControlConfigItem3.setCode(9);
            bizControlConfigItem3.setState("close");
            BizControlConfigItem bizControlConfigItem4 = new BizControlConfigItem();
            bizControlConfigItem4.setCode(8);
            bizControlConfigItem4.setState("close");
            BizControlConfigItem bizControlConfigItem5 = new BizControlConfigItem();
            bizControlConfigItem5.setCode(10);
            bizControlConfigItem5.setState("open");
            arrayList.add(bizControlConfigItem);
            arrayList.add(bizControlConfigItem2);
            arrayList.add(bizControlConfigItem3);
            arrayList.add(bizControlConfigItem4);
            arrayList.add(bizControlConfigItem5);
            arrayList.add(new BizControlConfigItem(11, "open"));
            arrayList.add(new BizControlConfigItem(12, "close"));
            arrayList.add(new BizControlConfigItem(13, "close"));
            arrayList.add(new BizControlConfigItem(14, "close"));
            arrayList.add(new BizControlConfigItem(15, "close"));
            arrayList.add(new BizControlConfigItem(16, "close"));
            arrayList.add(new BizControlConfigItem(17, "close"));
            arrayList.add(new BizControlConfigItem(18, "close"));
            arrayList.add(new BizControlConfigItem(19, "open"));
            arrayList.add(new BizControlConfigItem(20, "open"));
            arrayList.add(new BizControlConfigItem(21, "close"));
            arrayList.add(new BizControlConfigItem(22, "close"));
            arrayList.add(new BizControlConfigItem(23, "open"));
            arrayList.add(new BizControlConfigItem(24, "close"));
            arrayList.add(new BizControlConfigItem(26, "close"));
            arrayList.add(new BizControlConfigItem(27, "close"));
            arrayList.add(new BizControlConfigItem(28, "close"));
            arrayList.add(new BizControlConfigItem(30, "close"));
            arrayList.add(new BizControlConfigItem(37, "open"));
            bizControlConfig.setControlList(arrayList);
            this.f47546b = bizControlConfig;
        }
        return this.f47546b;
    }

    public final Observable<BizControlConfig> m() {
        return Observable.just(l());
    }

    public boolean p() {
        boolean s11 = s(22);
        k.o("HbControl", "isChineseC2COpen = " + s11);
        return s11;
    }

    public boolean q() {
        return true;
    }

    public boolean r(int i11) {
        BizControlConfigItem bizControlConfigItem = this.f47553i.get(Integer.valueOf(i11));
        if (bizControlConfigItem != null) {
            return "open".equals(bizControlConfigItem.getState());
        }
        String d11 = ConfigPreferences.d("user_config", "HB_CONTROL_CONFIG_MODULE_" + i11);
        if (!TextUtils.isEmpty(d11)) {
            return "open".equals(d11);
        }
        BizControlConfigItem bizControlConfigItem2 = null;
        Iterator<BizControlConfigItem> it2 = l().getControlList().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            BizControlConfigItem next = it2.next();
            if (next.getCode() == i11) {
                bizControlConfigItem2 = next;
                break;
            }
        }
        if (bizControlConfigItem2 == null) {
            return false;
        }
        return "open".equals(bizControlConfigItem2.getState());
    }

    public boolean s(int i11) {
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            return r(i11);
        }
        return true;
    }

    public boolean t(int i11, boolean z11) {
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            return v(i11, z11);
        }
        return true;
    }

    public boolean u(int i11) {
        if (AppLanguageHelper.getInstance().isTurkeyLanguage()) {
            return F(i11);
        }
        return true;
    }

    public boolean v(int i11, boolean z11) {
        BizControlConfigItem bizControlConfigItem = this.f47553i.get(Integer.valueOf(i11));
        return bizControlConfigItem != null ? "open".equals(bizControlConfigItem.getState()) : z11;
    }

    public boolean w() {
        boolean r11 = r(27);
        k.o("HbControl", "isInviteFloatWidgetOpen = " + r11);
        return r11;
    }

    public boolean x() {
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            return "open".equals(j().getState());
        }
        return true;
    }

    public boolean y() {
        boolean r11 = r(40);
        k.o("HbControl", "isNewYearOpen = " + r11);
        return r11;
    }

    public boolean z() {
        boolean r11 = r(29);
        k.o("HbControl", "isOnChainOpen = " + r11);
        return r11;
    }
}
