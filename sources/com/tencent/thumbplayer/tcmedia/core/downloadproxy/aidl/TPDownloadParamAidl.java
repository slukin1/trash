package com.tencent.thumbplayer.tcmedia.core.downloadproxy.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TPDownloadParamAidl implements Parcelable {
    public static final Parcelable.Creator<TPDownloadParamAidl> CREATOR = new Parcelable.Creator<TPDownloadParamAidl>() {
        public final TPDownloadParamAidl createFromParcel(Parcel parcel) {
            return new TPDownloadParamAidl(parcel);
        }

        public final TPDownloadParamAidl[] newArray(int i11) {
            return new TPDownloadParamAidl[i11];
        }
    };
    private int dlType;
    private Map<String, Object> extInfoMap;
    private ArrayList<String> urlList;

    public TPDownloadParamAidl(ArrayList<String> arrayList, int i11, Map<String, Object> map) {
        this.urlList = arrayList;
        this.dlType = i11;
        this.extInfoMap = map;
    }

    public int describeContents() {
        return 0;
    }

    public int getDlType() {
        return this.dlType;
    }

    public Map<String, Object> getExtInfoMap() {
        return this.extInfoMap;
    }

    public ArrayList<String> getUrlList() {
        return this.urlList;
    }

    public void setDlType(int i11) {
        this.dlType = i11;
    }

    public void setExtInfoMap(Map<String, Object> map) {
        this.extInfoMap = map;
    }

    public void setUrlList(ArrayList<String> arrayList) {
        this.urlList = arrayList;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeStringList(this.urlList);
        parcel.writeInt(this.dlType);
        parcel.writeMap(this.extInfoMap);
    }

    public TPDownloadParamAidl(Parcel parcel) {
        try {
            this.urlList = parcel.createStringArrayList();
            this.dlType = parcel.readInt();
            this.extInfoMap = parcel.readHashMap(TPDownloadParamAidl.class.getClassLoader());
        } catch (Throwable th2) {
            TPDLProxyLog.e("TPDownloadParamAidl", 0, ITPDLProxyLogListener.COMMON_TAG, th2.toString());
            this.urlList = new ArrayList<>();
            this.dlType = 0;
            this.extInfoMap = new HashMap();
        }
    }
}
