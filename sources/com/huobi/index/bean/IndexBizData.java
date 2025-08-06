package com.huobi.index.bean;

import androidx.annotation.Keep;
import com.hbg.lib.network.hbg.core.bean.HomePageBizData;
import com.huobi.index.viewhandler.IndexBizItemHandler;
import java.io.Serializable;
import s9.a;

@Keep
public class IndexBizData implements a, Serializable {
    private HomePageBizData data;

    public IndexBizData() {
    }

    public boolean canEqual(Object obj) {
        return obj instanceof IndexBizData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IndexBizData)) {
            return false;
        }
        IndexBizData indexBizData = (IndexBizData) obj;
        if (!indexBizData.canEqual(this)) {
            return false;
        }
        HomePageBizData data2 = getData();
        HomePageBizData data3 = indexBizData.getData();
        return data2 != null ? data2.equals(data3) : data3 == null;
    }

    public HomePageBizData getData() {
        return this.data;
    }

    public long getTimeData() {
        return this.data.getEndTime() - this.data.getBeginTime();
    }

    public String getViewHandlerName() {
        return IndexBizItemHandler.class.getName();
    }

    public int hashCode() {
        HomePageBizData data2 = getData();
        return 59 + (data2 == null ? 43 : data2.hashCode());
    }

    public boolean isDownTime() {
        return this.data.getFocusType() == 2;
    }

    public void setData(HomePageBizData homePageBizData) {
        this.data = homePageBizData;
    }

    public String toString() {
        return "IndexBizData(data=" + getData() + ")";
    }

    public IndexBizData(HomePageBizData homePageBizData) {
        this.data = homePageBizData;
    }
}
