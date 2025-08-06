package com.hbg.module.huobi.im.gift.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.jvm.internal.x;

public final class LiveGiftRewardBean implements Parcelable {
    public static final Parcelable.Creator<LiveGiftRewardBean> CREATOR = new Creator();
    private ArrayList<String> accounts;
    private String avator;
    private String gifUrl;
    private String giftName;
    private Integer giftNum;
    private String groupId;
    private String nickname;
    private String pngUrl;
    private Integer type;
    private String urlJson;

    public static final class Creator implements Parcelable.Creator<LiveGiftRewardBean> {
        /* renamed from: a */
        public final LiveGiftRewardBean createFromParcel(Parcel parcel) {
            return new LiveGiftRewardBean(parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString());
        }

        /* renamed from: b */
        public final LiveGiftRewardBean[] newArray(int i11) {
            return new LiveGiftRewardBean[i11];
        }
    }

    public LiveGiftRewardBean(String str, ArrayList<String> arrayList, String str2, String str3, Integer num, String str4, String str5, String str6, Integer num2, String str7) {
        this.nickname = str;
        this.accounts = arrayList;
        this.avator = str2;
        this.giftName = str3;
        this.giftNum = num;
        this.pngUrl = str4;
        this.gifUrl = str5;
        this.groupId = str6;
        this.type = num2;
        this.urlJson = str7;
    }

    public static /* synthetic */ LiveGiftRewardBean copy$default(LiveGiftRewardBean liveGiftRewardBean, String str, ArrayList arrayList, String str2, String str3, Integer num, String str4, String str5, String str6, Integer num2, String str7, int i11, Object obj) {
        LiveGiftRewardBean liveGiftRewardBean2 = liveGiftRewardBean;
        int i12 = i11;
        return liveGiftRewardBean.copy((i12 & 1) != 0 ? liveGiftRewardBean2.nickname : str, (i12 & 2) != 0 ? liveGiftRewardBean2.accounts : arrayList, (i12 & 4) != 0 ? liveGiftRewardBean2.avator : str2, (i12 & 8) != 0 ? liveGiftRewardBean2.giftName : str3, (i12 & 16) != 0 ? liveGiftRewardBean2.giftNum : num, (i12 & 32) != 0 ? liveGiftRewardBean2.pngUrl : str4, (i12 & 64) != 0 ? liveGiftRewardBean2.gifUrl : str5, (i12 & 128) != 0 ? liveGiftRewardBean2.groupId : str6, (i12 & 256) != 0 ? liveGiftRewardBean2.type : num2, (i12 & 512) != 0 ? liveGiftRewardBean2.urlJson : str7);
    }

    public final String component1() {
        return this.nickname;
    }

    public final String component10() {
        return this.urlJson;
    }

    public final ArrayList<String> component2() {
        return this.accounts;
    }

    public final String component3() {
        return this.avator;
    }

    public final String component4() {
        return this.giftName;
    }

    public final Integer component5() {
        return this.giftNum;
    }

    public final String component6() {
        return this.pngUrl;
    }

    public final String component7() {
        return this.gifUrl;
    }

    public final String component8() {
        return this.groupId;
    }

    public final Integer component9() {
        return this.type;
    }

    public final LiveGiftRewardBean copy(String str, ArrayList<String> arrayList, String str2, String str3, Integer num, String str4, String str5, String str6, Integer num2, String str7) {
        return new LiveGiftRewardBean(str, arrayList, str2, str3, num, str4, str5, str6, num2, str7);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveGiftRewardBean)) {
            return false;
        }
        LiveGiftRewardBean liveGiftRewardBean = (LiveGiftRewardBean) obj;
        return x.b(this.nickname, liveGiftRewardBean.nickname) && x.b(this.accounts, liveGiftRewardBean.accounts) && x.b(this.avator, liveGiftRewardBean.avator) && x.b(this.giftName, liveGiftRewardBean.giftName) && x.b(this.giftNum, liveGiftRewardBean.giftNum) && x.b(this.pngUrl, liveGiftRewardBean.pngUrl) && x.b(this.gifUrl, liveGiftRewardBean.gifUrl) && x.b(this.groupId, liveGiftRewardBean.groupId) && x.b(this.type, liveGiftRewardBean.type) && x.b(this.urlJson, liveGiftRewardBean.urlJson);
    }

    public final ArrayList<String> getAccounts() {
        return this.accounts;
    }

    public final String getAvator() {
        return this.avator;
    }

    public final String getGifUrl() {
        return this.gifUrl;
    }

    public final String getGiftName() {
        return this.giftName;
    }

    public final Integer getGiftNum() {
        return this.giftNum;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getPngUrl() {
        return this.pngUrl;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getUrlJson() {
        return this.urlJson;
    }

    public int hashCode() {
        String str = this.nickname;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ArrayList<String> arrayList = this.accounts;
        int hashCode2 = (hashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        String str2 = this.avator;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.giftName;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.giftNum;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.pngUrl;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.gifUrl;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.groupId;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num2 = this.type;
        int hashCode9 = (hashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str7 = this.urlJson;
        if (str7 != null) {
            i11 = str7.hashCode();
        }
        return hashCode9 + i11;
    }

    public final void setAccounts(ArrayList<String> arrayList) {
        this.accounts = arrayList;
    }

    public final void setAvator(String str) {
        this.avator = str;
    }

    public final void setGifUrl(String str) {
        this.gifUrl = str;
    }

    public final void setGiftName(String str) {
        this.giftName = str;
    }

    public final void setGiftNum(Integer num) {
        this.giftNum = num;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setNickname(String str) {
        this.nickname = str;
    }

    public final void setPngUrl(String str) {
        this.pngUrl = str;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public final void setUrlJson(String str) {
        this.urlJson = str;
    }

    public String toString() {
        return "LiveGiftRewardBean(nickname=" + this.nickname + ", accounts=" + this.accounts + ", avator=" + this.avator + ", giftName=" + this.giftName + ", giftNum=" + this.giftNum + ", pngUrl=" + this.pngUrl + ", gifUrl=" + this.gifUrl + ", groupId=" + this.groupId + ", type=" + this.type + ", urlJson=" + this.urlJson + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.nickname);
        parcel.writeStringList(this.accounts);
        parcel.writeString(this.avator);
        parcel.writeString(this.giftName);
        Integer num = this.giftNum;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.pngUrl);
        parcel.writeString(this.gifUrl);
        parcel.writeString(this.groupId);
        Integer num2 = this.type;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeString(this.urlJson);
    }
}
