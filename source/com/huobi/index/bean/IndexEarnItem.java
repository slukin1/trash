package com.huobi.index.bean;

import androidx.annotation.Keep;
import com.hbg.lib.network.hbg.core.bean.HomePageEarnData;
import com.huobi.index.viewhandler.IndexEarnItemHandler;
import java.io.Serializable;
import s9.a;

@Keep
public class IndexEarnItem implements a, Serializable {
    public HomePageEarnData.IndexAreaContentItemVo data;

    public IndexEarnItem(HomePageEarnData.IndexAreaContentItemVo indexAreaContentItemVo) {
        this.data = indexAreaContentItemVo;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof IndexEarnItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IndexEarnItem)) {
            return false;
        }
        IndexEarnItem indexEarnItem = (IndexEarnItem) obj;
        if (!indexEarnItem.canEqual(this)) {
            return false;
        }
        HomePageEarnData.IndexAreaContentItemVo data2 = getData();
        HomePageEarnData.IndexAreaContentItemVo data3 = indexEarnItem.getData();
        return data2 != null ? data2.equals(data3) : data3 == null;
    }

    public HomePageEarnData.IndexAreaContentItemVo getData() {
        return this.data;
    }

    public String getIconUrl() {
        return this.data.iconUrl;
    }

    public String getRefer() {
        return String.valueOf(this.data.rate);
    }

    public int getTerm() {
        return this.data.term;
    }

    public String getTitle() {
        return this.data.currency;
    }

    public String getViewHandlerName() {
        return IndexEarnItemHandler.class.getName();
    }

    public int hashCode() {
        HomePageEarnData.IndexAreaContentItemVo data2 = getData();
        return 59 + (data2 == null ? 43 : data2.hashCode());
    }

    public boolean isShowItemTopIconView() {
        return this.data.coupon != null;
    }

    public void setData(HomePageEarnData.IndexAreaContentItemVo indexAreaContentItemVo) {
        this.data = indexAreaContentItemVo;
    }

    public String toString() {
        return "IndexEarnItem(data=" + getData() + ")";
    }
}
