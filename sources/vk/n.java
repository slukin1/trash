package vk;

import com.hbg.lib.network.hbg.core.bean.MiningItem;
import com.huobi.finance.viewhandler.FixedMiningViewHandler;
import java.util.ArrayList;
import java.util.List;
import s9.a;

public class n implements a {

    /* renamed from: b  reason: collision with root package name */
    public MiningItem f47999b;

    public n(MiningItem miningItem) {
        this.f47999b = miningItem;
    }

    public static List<n> a(List<MiningItem> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MiningItem nVar : list) {
            arrayList.add(new n(nVar));
        }
        return arrayList;
    }

    public MiningItem c() {
        return this.f47999b;
    }

    public String getViewHandlerName() {
        return FixedMiningViewHandler.class.getName();
    }
}
