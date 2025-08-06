package com.huobi.finance.bean;

import com.hbg.lib.network.pro.core.bean.WalletItem;
import com.huobi.finance.viewhandler.PocketItemViewHandler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import s9.a;

public class PocketListItem implements Serializable, a {
    private WalletItem data;

    public PocketListItem(WalletItem walletItem) {
        this.data = walletItem;
    }

    public static List<PocketListItem> buildList(List<WalletItem> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (WalletItem next : list) {
            if (arrayList.size() < 200) {
                arrayList.add(new PocketListItem(next));
            }
        }
        return arrayList;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof PocketListItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PocketListItem)) {
            return false;
        }
        PocketListItem pocketListItem = (PocketListItem) obj;
        if (!pocketListItem.canEqual(this)) {
            return false;
        }
        WalletItem data2 = getData();
        WalletItem data3 = pocketListItem.getData();
        return data2 != null ? data2.equals(data3) : data3 == null;
    }

    public WalletItem getData() {
        return this.data;
    }

    public String getViewHandlerName() {
        return PocketItemViewHandler.class.getName();
    }

    public int hashCode() {
        WalletItem data2 = getData();
        return 59 + (data2 == null ? 43 : data2.hashCode());
    }

    public void setData(WalletItem walletItem) {
        this.data = walletItem;
    }

    public String toString() {
        return "PocketListItem(data=" + getData() + ")";
    }
}
