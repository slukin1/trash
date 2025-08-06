package uh;

import com.hbg.lib.data.future.bean.FutureUserInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapUserInfo;
import com.hbg.lib.network.swap.core.bean.SwapUserInfo;
import com.hbg.module.asset.AssetModuleConfig;
import com.huobi.contract.entity.ContractHeartBeat;
import com.huobi.contract.entity.ContractUserInfo;
import java.util.HashMap;
import java.util.Map;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, ContractUserInfo.UserBean> f47910a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, SwapUserInfo.UserBean> f47911b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, LinearSwapUserInfo> f47912c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, FutureUserInfo> f47913d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, ContractHeartBeat> f47914e;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final c f47915a = new c();
    }

    public static c b() {
        return b.f47915a;
    }

    public ContractHeartBeat a() {
        return this.f47914e.get(c());
    }

    public final String c() {
        return AssetModuleConfig.a().getUid();
    }

    public boolean d() {
        if (this.f47910a.get(c()) == null || this.f47910a.get(c()).getActiveState() != 1) {
            return false;
        }
        return true;
    }

    public boolean e() {
        ContractHeartBeat a11 = a();
        return a11 != null && a11.isSysSafeguard();
    }

    public boolean f() {
        if (this.f47913d.get(c()) == null || this.f47913d.get(c()).getActiveState() != 1) {
            return false;
        }
        return true;
    }

    public boolean g() {
        ContractHeartBeat a11 = a();
        return a11 != null && a11.isLinearSwapSafeguard();
    }

    public boolean h() {
        if (this.f47912c.get(c()) == null || this.f47912c.get(c()).getActiveState() != 1) {
            return false;
        }
        return true;
    }

    public boolean i() {
        ContractHeartBeat a11 = a();
        return a11 != null && a11.isOptionSafeguard();
    }

    public boolean j() {
        ContractHeartBeat a11 = a();
        return a11 != null && a11.isSwapSafeguard();
    }

    public boolean k() {
        if (this.f47911b.get(c()) == null || this.f47911b.get(c()).getActiveState() != 1) {
            return false;
        }
        return true;
    }

    public void l(ContractHeartBeat contractHeartBeat) {
        this.f47914e.put(c(), contractHeartBeat);
    }

    public void m(ContractUserInfo.UserBean userBean) {
        this.f47910a.put(c(), userBean);
    }

    public void n(FutureUserInfo futureUserInfo) {
        this.f47913d.put(c(), futureUserInfo);
    }

    public void o(LinearSwapUserInfo linearSwapUserInfo) {
        this.f47912c.put(c(), linearSwapUserInfo);
    }

    public void p(SwapUserInfo.UserBean userBean) {
        this.f47911b.put(c(), userBean);
    }

    public c() {
        this.f47910a = new HashMap();
        this.f47911b = new HashMap();
        this.f47912c = new HashMap();
        this.f47913d = new HashMap();
        this.f47914e = new HashMap();
    }
}
