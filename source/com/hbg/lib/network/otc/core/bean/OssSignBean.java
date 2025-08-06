package com.hbg.lib.network.otc.core.bean;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lombok.NonNull;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class OssSignBean implements Serializable {
    private String bucketType = "";
    private Map<String, String> fields;
    private String mediaFileKey = "";
    private String previewUrl = "";
    private String url = "";

    private void putMap(@NonNull HashMap<String, RequestBody> hashMap, @NonNull String str, String str2) {
        Objects.requireNonNull(hashMap, "map is marked @NonNull but is null");
        Objects.requireNonNull(str, "key is marked @NonNull but is null");
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(str, RequestBody.create(MediaType.parse("text/plain"), str2));
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OssSignBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OssSignBean)) {
            return false;
        }
        OssSignBean ossSignBean = (OssSignBean) obj;
        if (!ossSignBean.canEqual(this)) {
            return false;
        }
        String url2 = getUrl();
        String url3 = ossSignBean.getUrl();
        if (url2 != null ? !url2.equals(url3) : url3 != null) {
            return false;
        }
        Map<String, String> fields2 = getFields();
        Map<String, String> fields3 = ossSignBean.getFields();
        if (fields2 != null ? !fields2.equals(fields3) : fields3 != null) {
            return false;
        }
        String previewUrl2 = getPreviewUrl();
        String previewUrl3 = ossSignBean.getPreviewUrl();
        if (previewUrl2 != null ? !previewUrl2.equals(previewUrl3) : previewUrl3 != null) {
            return false;
        }
        String bucketType2 = getBucketType();
        String bucketType3 = ossSignBean.getBucketType();
        if (bucketType2 != null ? !bucketType2.equals(bucketType3) : bucketType3 != null) {
            return false;
        }
        String mediaFileKey2 = getMediaFileKey();
        String mediaFileKey3 = ossSignBean.getMediaFileKey();
        return mediaFileKey2 != null ? mediaFileKey2.equals(mediaFileKey3) : mediaFileKey3 == null;
    }

    public String getBucketType() {
        return this.bucketType;
    }

    public Map<String, String> getFields() {
        return this.fields;
    }

    public String getMediaFileKey() {
        return this.mediaFileKey;
    }

    public String getPreviewUrl() {
        return this.previewUrl;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String url2 = getUrl();
        int i11 = 43;
        int hashCode = url2 == null ? 43 : url2.hashCode();
        Map<String, String> fields2 = getFields();
        int hashCode2 = ((hashCode + 59) * 59) + (fields2 == null ? 43 : fields2.hashCode());
        String previewUrl2 = getPreviewUrl();
        int hashCode3 = (hashCode2 * 59) + (previewUrl2 == null ? 43 : previewUrl2.hashCode());
        String bucketType2 = getBucketType();
        int hashCode4 = (hashCode3 * 59) + (bucketType2 == null ? 43 : bucketType2.hashCode());
        String mediaFileKey2 = getMediaFileKey();
        int i12 = hashCode4 * 59;
        if (mediaFileKey2 != null) {
            i11 = mediaFileKey2.hashCode();
        }
        return i12 + i11;
    }

    public void setBucketType(String str) {
        this.bucketType = str;
    }

    public void setFields(Map<String, String> map) {
        this.fields = map;
    }

    public void setMediaFileKey(String str) {
        this.mediaFileKey = str;
    }

    public void setPreviewUrl(String str) {
        this.previewUrl = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public HashMap<String, RequestBody> toPartMap(OssSignBean ossSignBean) {
        HashMap<String, RequestBody> hashMap = new HashMap<>(8);
        Map<String, String> map = ossSignBean.fields;
        if (map != null) {
            for (String next : map.keySet()) {
                putMap(hashMap, next, ossSignBean.fields.get(next));
            }
        }
        return hashMap;
    }

    public String toString() {
        return "OssSignBean(url=" + getUrl() + ", fields=" + getFields() + ", previewUrl=" + getPreviewUrl() + ", bucketType=" + getBucketType() + ", mediaFileKey=" + getMediaFileKey() + ")";
    }
}
