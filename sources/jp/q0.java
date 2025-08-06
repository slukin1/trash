package jp;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.huobi.otc.ui.OtcTradeActivity;
import com.huobi.otc.ui.P2PTradeContainerFragment;
import io.flutter.embedding.android.FlutterFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import uf.d;

public class q0 {

    /* renamed from: a  reason: collision with root package name */
    public d f84365a;

    /* renamed from: b  reason: collision with root package name */
    public e f84366b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f84367c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public OtcTradeActivity f84368d;

    /* renamed from: e  reason: collision with root package name */
    public OtcTradeAreaEnum f84369e;

    /* renamed from: f  reason: collision with root package name */
    public OtcTradeAreaEnum f84370f;

    /* renamed from: g  reason: collision with root package name */
    public Fragment f84371g;

    /* renamed from: h  reason: collision with root package name */
    public Fragment f84372h;

    /* renamed from: i  reason: collision with root package name */
    public OtcTradeAreaEnum f84373i;

    /* renamed from: j  reason: collision with root package name */
    public OtcTradeAreaEnum f84374j;

    /* renamed from: k  reason: collision with root package name */
    public Fragment f84375k;

    /* renamed from: l  reason: collision with root package name */
    public Fragment f84376l;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f84377a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huobi.otc.enums.OtcTradeAreaEnum[] r0 = com.huobi.otc.enums.OtcTradeAreaEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f84377a = r0
                com.huobi.otc.enums.OtcTradeAreaEnum r1 = com.huobi.otc.enums.OtcTradeAreaEnum.DEPOSIT_AREA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f84377a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.otc.enums.OtcTradeAreaEnum r1 = com.huobi.otc.enums.OtcTradeAreaEnum.FAST_AREA     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f84377a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.otc.enums.OtcTradeAreaEnum r1 = com.huobi.otc.enums.OtcTradeAreaEnum.ORDER_AREA     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f84377a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.otc.enums.OtcTradeAreaEnum r1 = com.huobi.otc.enums.OtcTradeAreaEnum.AD_AREA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f84377a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huobi.otc.enums.OtcTradeAreaEnum r1 = com.huobi.otc.enums.OtcTradeAreaEnum.MINE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.q0.a.<clinit>():void");
        }
    }

    public interface b {
        void D5(OtcTradeAreaEnum otcTradeAreaEnum);

        void Ua(OtcTradeAreaEnum otcTradeAreaEnum);

        void rb(OtcTradeAreaEnum otcTradeAreaEnum);

        void sc(OtcTradeAreaEnum otcTradeAreaEnum);
    }

    public interface c {
        ViewGroup Fc();

        FragmentManager Vd();

        void fh(OtcTradeAreaEnum otcTradeAreaEnum, OtcTradeAreaEnum otcTradeAreaEnum2, Fragment fragment, Fragment fragment2);

        void tf(OtcTradeAreaEnum otcTradeAreaEnum, OtcTradeAreaEnum otcTradeAreaEnum2);
    }

    public interface d extends c {
    }

    public interface e extends c {
    }

    public q0(OtcTradeActivity otcTradeActivity, d dVar) {
        this.f84368d = otcTradeActivity;
        this.f84365a = dVar;
    }

    public void a(b bVar) {
        if (!this.f84367c.contains(bVar)) {
            this.f84367c.add(bVar);
        }
    }

    public final Bundle b(OtcTradeAreaEnum otcTradeAreaEnum, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        int i11 = a.f84377a[otcTradeAreaEnum.ordinal()];
        if (i11 == 1 || i11 == 2) {
            bundle.putString(FlutterFragment.ARG_FLUTTERVIEW_RENDER_MODE, "texture");
        } else if (i11 == 3 || i11 == 4 || i11 == 5) {
            bundle.putBoolean("extra_hide_titleBar", true);
            bundle.putString(FlutterFragment.ARG_FLUTTERVIEW_RENDER_MODE, "texture");
        }
        return bundle;
    }

    public final Class c(OtcTradeAreaEnum otcTradeAreaEnum) {
        if (otcTradeAreaEnum == OtcTradeAreaEnum.FAST_AREA) {
            return OtcModuleConfig.a().o();
        }
        if (otcTradeAreaEnum == OtcTradeAreaEnum.FREE_AREA) {
            return P2PTradeContainerFragment.class;
        }
        if (otcTradeAreaEnum == OtcTradeAreaEnum.DEPOSIT_AREA) {
            return OtcModuleConfig.a().r();
        }
        if (otcTradeAreaEnum == OtcTradeAreaEnum.ORDER_AREA) {
            return OtcModuleConfig.b().j();
        }
        if (otcTradeAreaEnum == OtcTradeAreaEnum.AD_AREA) {
            return OtcModuleConfig.a().U();
        }
        if (otcTradeAreaEnum == OtcTradeAreaEnum.P2P_TRAD_AREA) {
            return OtcModuleConfig.a().y();
        }
        if (otcTradeAreaEnum == OtcTradeAreaEnum.MINE) {
            return OtcModuleConfig.a().k();
        }
        return null;
    }

    public OtcTradeAreaEnum d() {
        return this.f84369e;
    }

    public OtcTradeAreaEnum e() {
        return this.f84373i;
    }

    public Fragment f(OtcTradeAreaEnum otcTradeAreaEnum) {
        FragmentManager Vd;
        for (Fragment next : this.f84365a.Vd().B0()) {
            if (next.getClass() == c(otcTradeAreaEnum)) {
                return next;
            }
        }
        e eVar = this.f84366b;
        if (eVar == null || (Vd = eVar.Vd()) == null) {
            return null;
        }
        for (Fragment next2 : Vd.B0()) {
            if (next2.getClass() == c(otcTradeAreaEnum)) {
                return next2;
            }
        }
        return null;
    }

    public void g(d.a aVar) {
        Fragment f11 = f(OtcTradeAreaEnum.FAST_AREA);
        if (f11 != null) {
            ((uf.d) f11).bb(aVar);
        }
    }

    public Fragment h(FragmentManager fragmentManager, String str, Bundle bundle, String str2) {
        Fragment m02 = fragmentManager.m0(str2);
        if (m02 != null) {
            if (!(m02.getArguments() == null || bundle == null)) {
                m02.getArguments().putAll(bundle);
            }
            return m02;
        }
        for (Fragment next : fragmentManager.B0()) {
            if (next != null && next.getClass().getName().equals(str) && str2.equals(next.getTag())) {
                if (!(next.getArguments() == null || bundle == null)) {
                    next.getArguments().putAll(bundle);
                }
                return next;
            }
        }
        Fragment a11 = fragmentManager.z0().a(this.f84368d.getClassLoader(), str);
        a11.setArguments(bundle);
        return a11;
    }

    public final void i() {
        for (b next : this.f84367c) {
            if (next != null) {
                next.D5(this.f84369e);
            }
        }
    }

    public final void j() {
        for (b next : this.f84367c) {
            if (next != null) {
                next.sc(this.f84373i);
            }
        }
    }

    public final void k() {
        for (b next : this.f84367c) {
            if (next != null) {
                next.Ua(this.f84369e);
            }
        }
    }

    public final void l() {
        for (b next : this.f84367c) {
            if (next != null) {
                next.rb(this.f84373i);
            }
        }
    }

    public final void m(OtcTradeAreaEnum otcTradeAreaEnum) {
        if (otcTradeAreaEnum == OtcTradeAreaEnum.FAST_AREA) {
            uf.c.b().q("switch_to_express", (String) null);
            uf.c.b().n("view", "otc.fast.page.view", (HashMap) null);
        } else if (otcTradeAreaEnum == OtcTradeAreaEnum.FREE_AREA) {
            uf.c.b().q("switch_to_p2p", (String) null);
            uf.c.b().r("view", "otc.adlist.page.view", (HashMap) null);
        } else if (otcTradeAreaEnum == OtcTradeAreaEnum.DEPOSIT_AREA) {
            uf.c.b().q("switch_to_deposit", (String) null);
            HashMap hashMap = new HashMap();
            hashMap.put("otc_step", "view");
            uf.c.b().h("deposit_landing", hashMap);
        } else if (otcTradeAreaEnum != OtcTradeAreaEnum.ORDER_AREA) {
            OtcTradeAreaEnum otcTradeAreaEnum2 = OtcTradeAreaEnum.AD_AREA;
        }
    }

    public void n(e eVar) {
        this.f84366b = eVar;
    }

    public void o(OtcTradeAreaEnum otcTradeAreaEnum, Bundle bundle) {
        Class c11;
        if (this.f84369e != otcTradeAreaEnum && (c11 = c(otcTradeAreaEnum)) != null) {
            i();
            this.f84365a.tf(this.f84369e, otcTradeAreaEnum);
            this.f84372h = this.f84371g;
            this.f84371g = q(this.f84365a.Vd(), c11, b(otcTradeAreaEnum, bundle), this.f84365a.Fc());
            this.f84370f = this.f84369e;
            this.f84369e = otcTradeAreaEnum;
            if (otcTradeAreaEnum == OtcTradeAreaEnum.DEPOSIT_AREA) {
                this.f84368d.gg(false);
                k0.q(OtcTradeAreaEnum.FAST_AREA.getCode());
            } else {
                this.f84368d.gg(true);
                this.f84368d.fg(true);
                k0.q(this.f84369e.getCode());
            }
            k();
            this.f84365a.fh(this.f84369e, this.f84370f, this.f84371g, this.f84372h);
            m(otcTradeAreaEnum);
            this.f84368d.ni(this.f84369e);
        }
    }

    public void p(OtcTradeAreaEnum otcTradeAreaEnum, Bundle bundle, OtcTradeAreaEnum otcTradeAreaEnum2, Bundle bundle2) {
        o(otcTradeAreaEnum, bundle);
        r(otcTradeAreaEnum2, bundle2);
    }

    public final Fragment q(FragmentManager fragmentManager, Class cls, Bundle bundle, ViewGroup viewGroup) {
        NightHelper.e().d(this.f84368d);
        FragmentTransaction q11 = fragmentManager.q();
        for (Fragment next : fragmentManager.B0()) {
            if (next != null && !(next instanceof DialogFragment)) {
                q11.q(next);
            }
        }
        String name = cls.getName();
        Fragment h11 = h(fragmentManager, cls.getName(), bundle, cls.getName());
        if (!h11.isAdded()) {
            q11.c(viewGroup.getId(), h11, name);
        }
        q11.A(h11).k();
        return h11;
    }

    public void r(OtcTradeAreaEnum otcTradeAreaEnum, Bundle bundle) {
        Class c11;
        if (this.f84373i != otcTradeAreaEnum && this.f84366b != null && (c11 = c(otcTradeAreaEnum)) != null) {
            l();
            this.f84366b.tf(this.f84373i, otcTradeAreaEnum);
            this.f84376l = this.f84375k;
            this.f84375k = q(this.f84366b.Vd(), c11, b(otcTradeAreaEnum, bundle), this.f84366b.Fc());
            this.f84374j = this.f84373i;
            this.f84373i = otcTradeAreaEnum;
            j();
            this.f84366b.fh(this.f84373i, this.f84374j, this.f84375k, this.f84376l);
            m(otcTradeAreaEnum);
            this.f84368d.ni(this.f84373i);
            if (this.f84373i == OtcTradeAreaEnum.P2P_TRAD_AREA) {
                this.f84368d.fg(true);
            } else {
                this.f84368d.fg(false);
            }
        }
    }
}
