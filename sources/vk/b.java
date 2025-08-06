package vk;

import com.hbg.lib.network.hbg.core.bean.MiningItem;
import com.huobi.finance.viewhandler.ActiveMiningViewHandler;
import java.util.ArrayList;
import java.util.List;
import s9.a;

public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public MiningItem f47977b;

    public b(MiningItem miningItem) {
        this.f47977b = miningItem;
    }

    public static List<b> a(List<MiningItem> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MiningItem bVar : list) {
            arrayList.add(new b(bVar));
        }
        return arrayList;
    }

    public MiningItem c() {
        return this.f47977b;
    }

    public String getViewHandlerName() {
        return ActiveMiningViewHandler.class.getName();
    }
}
