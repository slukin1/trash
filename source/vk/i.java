package vk;

import com.hbg.lib.core.util.CollectionsUtils;
import com.huobi.asset.AssetAccountType;
import com.huobi.finance.bean.AssetPositionEarnTimingHeaderData;
import com.huobi.finance.bean.BaseAssetPositionAccountData;
import com.huobi.finance.bean.BasePositionSortAccountItem;
import com.huobi.finance.viewhandler.AssetPositionRecyclerItemViewHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import uh.e;

public class i extends BaseAssetPositionAccountData {

    /* renamed from: b  reason: collision with root package name */
    public List<BasePositionSortAccountItem> f47986b;

    /* renamed from: c  reason: collision with root package name */
    public List<BasePositionSortAccountItem> f47987c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public boolean f47988d = false;

    /* renamed from: e  reason: collision with root package name */
    public AssetAccountType f47989e;

    public i(AssetAccountType assetAccountType, List<BasePositionSortAccountItem> list) {
        this.f47986b = list;
        this.f47989e = assetAccountType;
        j();
    }

    public static /* synthetic */ int m(boolean z11, int i11, BasePositionSortAccountItem basePositionSortAccountItem, BasePositionSortAccountItem basePositionSortAccountItem2) {
        if (z11) {
            return basePositionSortAccountItem.a(i11, basePositionSortAccountItem2);
        }
        return basePositionSortAccountItem2.a(i11, basePositionSortAccountItem);
    }

    public static /* synthetic */ int n(boolean z11, int i11, BasePositionSortAccountItem basePositionSortAccountItem, BasePositionSortAccountItem basePositionSortAccountItem2) {
        if (z11) {
            return basePositionSortAccountItem.a(i11, basePositionSortAccountItem2);
        }
        return basePositionSortAccountItem2.a(i11, basePositionSortAccountItem);
    }

    public AssetAccountType a() {
        return this.f47989e;
    }

    public void c(int i11, boolean z11) {
        j();
        if (g(i11, z11)) {
            Collections.sort(this.f47987c, new h(z11, i11));
        }
    }

    public void f() {
        this.f47988d = !this.f47988d;
    }

    public final boolean g(int i11, boolean z11) {
        if (this.f47989e != AssetAccountType.HUOBI_EARN) {
            return !CollectionsUtils.b(this.f47987c);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        BasePositionSortAccountItem basePositionSortAccountItem = null;
        Iterator<BasePositionSortAccountItem> it2 = this.f47987c.iterator();
        while (true) {
            boolean z12 = false;
            if (!it2.hasNext()) {
                break;
            }
            BasePositionSortAccountItem next = it2.next();
            if (next instanceof e) {
                if (((e) next).j().getProjectType() == 0) {
                    z12 = true;
                }
                if (z12) {
                    arrayList.add(next);
                } else {
                    arrayList2.add(next);
                }
            } else if (next instanceof AssetPositionEarnTimingHeaderData) {
                basePositionSortAccountItem = next;
            }
        }
        p(i11, z11, arrayList2);
        this.f47987c.clear();
        if (!CollectionsUtils.b(arrayList)) {
            this.f47987c.addAll(p(i11, z11, arrayList));
        }
        if (basePositionSortAccountItem != null) {
            this.f47987c.add(basePositionSortAccountItem);
        }
        if (!CollectionsUtils.b(arrayList2)) {
            this.f47987c.addAll(p(i11, z11, arrayList2));
        }
        return false;
    }

    public String getViewHandlerName() {
        return AssetPositionRecyclerItemViewHandler.class.getName();
    }

    public List<BasePositionSortAccountItem> h() {
        ArrayList arrayList = new ArrayList();
        if (k() || this.f47988d) {
            arrayList.addAll(this.f47987c);
        } else {
            arrayList.addAll(this.f47987c.subList(0, 5));
        }
        return arrayList;
    }

    public List<BasePositionSortAccountItem> i() {
        return this.f47986b;
    }

    public void j() {
        if (this.f47986b != null) {
            this.f47987c.clear();
            boolean b11 = e.a().b();
            for (BasePositionSortAccountItem next : this.f47986b) {
                if (!b11 || !next.c()) {
                    this.f47987c.add(next);
                }
            }
        }
    }

    public boolean k() {
        List<BasePositionSortAccountItem> list = this.f47987c;
        return list == null || list.size() <= 5;
    }

    public boolean l() {
        return this.f47988d;
    }

    public void o(List<BasePositionSortAccountItem> list) {
        this.f47986b = list;
        j();
    }

    public final List<BasePositionSortAccountItem> p(int i11, boolean z11, List<BasePositionSortAccountItem> list) {
        Collections.sort(list, new g(z11, i11));
        return list;
    }
}
