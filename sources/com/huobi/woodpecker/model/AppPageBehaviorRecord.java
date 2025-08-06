package com.huobi.woodpecker.model;

import com.facebook.appevents.UserDataStore;
import com.facebook.places.model.PlaceFields;
import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.model.base.BaseRecord;
import com.huobi.woodpecker.model.base.IRecord;
import com.huobi.woodpecker.utils.NumberUtil;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppPageBehaviorRecord extends BaseRecord<AppPageBehaviorRecordData> {

    public static class AppPageBehaviorRecordData implements IRecord {
        private List<DataBehavior> bhvr = new ArrayList();
        private long blockNonaTime;

        /* renamed from: cb  reason: collision with root package name */
        private boolean f21137cb;

        /* renamed from: et  reason: collision with root package name */
        private long f21138et;

        /* renamed from: st  reason: collision with root package name */
        private long f21139st;

        public void addBlockDelta(long j11) {
            this.blockNonaTime += j11;
        }

        public boolean canEqual(Object obj) {
            return obj instanceof AppPageBehaviorRecordData;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AppPageBehaviorRecordData)) {
                return false;
            }
            AppPageBehaviorRecordData appPageBehaviorRecordData = (AppPageBehaviorRecordData) obj;
            if (!appPageBehaviorRecordData.canEqual(this) || isCb() != appPageBehaviorRecordData.isCb() || getSt() != appPageBehaviorRecordData.getSt() || getEt() != appPageBehaviorRecordData.getEt() || getBlockNonaTime() != appPageBehaviorRecordData.getBlockNonaTime()) {
                return false;
            }
            List<DataBehavior> bhvr2 = getBhvr();
            List<DataBehavior> bhvr3 = appPageBehaviorRecordData.getBhvr();
            return bhvr2 != null ? bhvr2.equals(bhvr3) : bhvr3 == null;
        }

        public List<DataBehavior> getBhvr() {
            return this.bhvr;
        }

        public long getBlockNonaTime() {
            return this.blockNonaTime;
        }

        public long getEt() {
            return this.f21138et;
        }

        public long getSt() {
            return this.f21139st;
        }

        public int hashCode() {
            int i11 = isCb() ? 79 : 97;
            long st2 = getSt();
            int i12 = ((i11 + 59) * 59) + ((int) (st2 ^ (st2 >>> 32)));
            long et2 = getEt();
            int i13 = (i12 * 59) + ((int) (et2 ^ (et2 >>> 32)));
            long blockNonaTime2 = getBlockNonaTime();
            int i14 = (i13 * 59) + ((int) (blockNonaTime2 ^ (blockNonaTime2 >>> 32)));
            List<DataBehavior> bhvr2 = getBhvr();
            return (i14 * 59) + (bhvr2 == null ? 43 : bhvr2.hashCode());
        }

        public boolean isCb() {
            return this.f21137cb;
        }

        public void setBhvr(List<DataBehavior> list) {
            this.bhvr = list;
        }

        public void setBlockNonaTime(long j11) {
            this.blockNonaTime = j11;
        }

        public void setCb(boolean z11) {
            this.f21137cb = z11;
        }

        public void setEt(long j11) {
            this.f21138et = j11;
        }

        public void setSt(long j11) {
            this.f21139st = j11;
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cb", this.f21137cb ? 1 : 0);
                jSONObject.put(UserDataStore.STATE, this.f21139st);
                jSONObject.put("et", this.f21138et);
                long j11 = this.f21138et;
                long j12 = this.f21139st;
                long j13 = j11 > j12 ? j11 - j12 : 0;
                jSONObject.put(IBridgeMediaLoader.COLUMN_DURATION, j13);
                jSONObject.put("blockRate", NumberUtil.c((((float) this.blockNonaTime) / 1000000.0f) / ((float) j13), 4));
                if (this.bhvr.size() != 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (DataBehavior next : this.bhvr) {
                        if (next.getSt() > 0 && next.getEt() > 0 && next.getEt() > next.getSt()) {
                            jSONArray.put(next.toJsonObject());
                        }
                    }
                    jSONObject.put("bhvr", jSONArray.toString());
                }
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            return jSONObject;
        }

        public String toJsonString() {
            return toJsonObject().toString();
        }

        public String toString() {
            return "AppPageBehaviorRecord.AppPageBehaviorRecordData(cb=" + isCb() + ", st=" + getSt() + ", et=" + getEt() + ", blockNonaTime=" + getBlockNonaTime() + ", bhvr=" + getBhvr() + ")";
        }
    }

    public static class DataBehavior implements IRecord {

        /* renamed from: et  reason: collision with root package name */
        private long f21140et;
        private int hashCode;
        private String pageName;

        /* renamed from: st  reason: collision with root package name */
        private long f21141st;

        public boolean canEqual(Object obj) {
            return obj instanceof DataBehavior;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DataBehavior)) {
                return false;
            }
            DataBehavior dataBehavior = (DataBehavior) obj;
            if (!dataBehavior.canEqual(this)) {
                return false;
            }
            String pageName2 = getPageName();
            String pageName3 = dataBehavior.getPageName();
            if (pageName2 != null ? pageName2.equals(pageName3) : pageName3 == null) {
                return getHashCode() == dataBehavior.getHashCode() && getSt() == dataBehavior.getSt() && getEt() == dataBehavior.getEt();
            }
            return false;
        }

        public long getEt() {
            return this.f21140et;
        }

        public int getHashCode() {
            return this.hashCode;
        }

        public String getPageName() {
            return this.pageName;
        }

        public long getSt() {
            return this.f21141st;
        }

        public int hashCode() {
            String pageName2 = getPageName();
            int hashCode2 = (((pageName2 == null ? 43 : pageName2.hashCode()) + 59) * 59) + getHashCode();
            long st2 = getSt();
            int i11 = (hashCode2 * 59) + ((int) (st2 ^ (st2 >>> 32)));
            long et2 = getEt();
            return (i11 * 59) + ((int) ((et2 >>> 32) ^ et2));
        }

        public void setEt(long j11) {
            this.f21140et = j11;
        }

        public void setHashCode(int i11) {
            this.hashCode = i11;
        }

        public void setPageName(String str) {
            this.pageName = str;
        }

        public void setSt(long j11) {
            this.f21141st = j11;
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PlaceFields.PAGE, this.pageName);
                jSONObject.put(IBridgeMediaLoader.COLUMN_DURATION, this.f21140et - this.f21141st);
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            return jSONObject;
        }

        public String toJsonString() {
            return toJsonObject().toString();
        }

        public String toString() {
            return "AppPageBehaviorRecord.DataBehavior(pageName=" + getPageName() + ", hashCode=" + getHashCode() + ", st=" + getSt() + ", et=" + getEt() + ")";
        }
    }

    public AppPageBehaviorRecord() {
        setAction(ActionType.APP_USER_BEHAVIOUR);
        setData(new AppPageBehaviorRecordData());
    }
}
