package com.huobi.main.bean;

import androidx.annotation.Keep;
import java.io.Serializable;

@Keep
public class RemoteSkinConfigBean implements Serializable {
    private long end_timestamp;
    private long maxAppVersion;
    private String md5_android;
    private String md5_ios;
    private long minAppVersion;
    private String source_android;
    private String source_ios;
    private long start_timestamp;

    public boolean canEqual(Object obj) {
        return obj instanceof RemoteSkinConfigBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RemoteSkinConfigBean)) {
            return false;
        }
        RemoteSkinConfigBean remoteSkinConfigBean = (RemoteSkinConfigBean) obj;
        if (!remoteSkinConfigBean.canEqual(this) || getMinAppVersion() != remoteSkinConfigBean.getMinAppVersion() || getMaxAppVersion() != remoteSkinConfigBean.getMaxAppVersion() || getStart_timestamp() != remoteSkinConfigBean.getStart_timestamp() || getEnd_timestamp() != remoteSkinConfigBean.getEnd_timestamp()) {
            return false;
        }
        String source_android2 = getSource_android();
        String source_android3 = remoteSkinConfigBean.getSource_android();
        if (source_android2 != null ? !source_android2.equals(source_android3) : source_android3 != null) {
            return false;
        }
        String source_ios2 = getSource_ios();
        String source_ios3 = remoteSkinConfigBean.getSource_ios();
        if (source_ios2 != null ? !source_ios2.equals(source_ios3) : source_ios3 != null) {
            return false;
        }
        String md5_android2 = getMd5_android();
        String md5_android3 = remoteSkinConfigBean.getMd5_android();
        if (md5_android2 != null ? !md5_android2.equals(md5_android3) : md5_android3 != null) {
            return false;
        }
        String md5_ios2 = getMd5_ios();
        String md5_ios3 = remoteSkinConfigBean.getMd5_ios();
        return md5_ios2 != null ? md5_ios2.equals(md5_ios3) : md5_ios3 == null;
    }

    public long getEnd_timestamp() {
        return this.end_timestamp;
    }

    public long getMaxAppVersion() {
        return this.maxAppVersion;
    }

    public String getMd5_android() {
        return this.md5_android;
    }

    public String getMd5_ios() {
        return this.md5_ios;
    }

    public long getMinAppVersion() {
        return this.minAppVersion;
    }

    public String getSource_android() {
        return this.source_android;
    }

    public String getSource_ios() {
        return this.source_ios;
    }

    public long getStart_timestamp() {
        return this.start_timestamp;
    }

    public int hashCode() {
        long minAppVersion2 = getMinAppVersion();
        long maxAppVersion2 = getMaxAppVersion();
        int i11 = ((((int) (minAppVersion2 ^ (minAppVersion2 >>> 32))) + 59) * 59) + ((int) (maxAppVersion2 ^ (maxAppVersion2 >>> 32)));
        long start_timestamp2 = getStart_timestamp();
        int i12 = (i11 * 59) + ((int) (start_timestamp2 ^ (start_timestamp2 >>> 32)));
        long end_timestamp2 = getEnd_timestamp();
        String source_android2 = getSource_android();
        int i13 = ((i12 * 59) + ((int) ((end_timestamp2 >>> 32) ^ end_timestamp2))) * 59;
        int i14 = 43;
        int hashCode = i13 + (source_android2 == null ? 43 : source_android2.hashCode());
        String source_ios2 = getSource_ios();
        int hashCode2 = (hashCode * 59) + (source_ios2 == null ? 43 : source_ios2.hashCode());
        String md5_android2 = getMd5_android();
        int hashCode3 = (hashCode2 * 59) + (md5_android2 == null ? 43 : md5_android2.hashCode());
        String md5_ios2 = getMd5_ios();
        int i15 = hashCode3 * 59;
        if (md5_ios2 != null) {
            i14 = md5_ios2.hashCode();
        }
        return i15 + i14;
    }

    public void setEnd_timestamp(long j11) {
        this.end_timestamp = j11;
    }

    public void setMaxAppVersion(long j11) {
        this.maxAppVersion = j11;
    }

    public void setMd5_android(String str) {
        this.md5_android = str;
    }

    public void setMd5_ios(String str) {
        this.md5_ios = str;
    }

    public void setMinAppVersion(long j11) {
        this.minAppVersion = j11;
    }

    public void setSource_android(String str) {
        this.source_android = str;
    }

    public void setSource_ios(String str) {
        this.source_ios = str;
    }

    public void setStart_timestamp(long j11) {
        this.start_timestamp = j11;
    }

    public String toString() {
        return "RemoteSkinConfigBean(minAppVersion=" + getMinAppVersion() + ", maxAppVersion=" + getMaxAppVersion() + ", start_timestamp=" + getStart_timestamp() + ", end_timestamp=" + getEnd_timestamp() + ", source_android=" + getSource_android() + ", source_ios=" + getSource_ios() + ", md5_android=" + getMd5_android() + ", md5_ios=" + getMd5_ios() + ")";
    }
}
