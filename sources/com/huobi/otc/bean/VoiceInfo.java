package com.huobi.otc.bean;

import java.io.Serializable;

public class VoiceInfo implements Serializable {
    private boolean isVoice;
    private String receiveTxUserid;
    private int singleVoiceTime;
    private int totalVoiceCount;

    public boolean canEqual(Object obj) {
        return obj instanceof VoiceInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VoiceInfo)) {
            return false;
        }
        VoiceInfo voiceInfo = (VoiceInfo) obj;
        if (!voiceInfo.canEqual(this) || isVoice() != voiceInfo.isVoice() || getTotalVoiceCount() != voiceInfo.getTotalVoiceCount() || getSingleVoiceTime() != voiceInfo.getSingleVoiceTime()) {
            return false;
        }
        String receiveTxUserid2 = getReceiveTxUserid();
        String receiveTxUserid3 = voiceInfo.getReceiveTxUserid();
        return receiveTxUserid2 != null ? receiveTxUserid2.equals(receiveTxUserid3) : receiveTxUserid3 == null;
    }

    public String getReceiveTxUserid() {
        return this.receiveTxUserid;
    }

    public int getSingleVoiceTime() {
        return this.singleVoiceTime;
    }

    public int getTotalVoiceCount() {
        return this.totalVoiceCount;
    }

    public int hashCode() {
        int totalVoiceCount2 = (((((isVoice() ? 79 : 97) + 59) * 59) + getTotalVoiceCount()) * 59) + getSingleVoiceTime();
        String receiveTxUserid2 = getReceiveTxUserid();
        return (totalVoiceCount2 * 59) + (receiveTxUserid2 == null ? 43 : receiveTxUserid2.hashCode());
    }

    public boolean isVoice() {
        return this.isVoice;
    }

    public void setReceiveTxUserid(String str) {
        this.receiveTxUserid = str;
    }

    public void setSingleVoiceTime(int i11) {
        this.singleVoiceTime = i11;
    }

    public void setTotalVoiceCount(int i11) {
        this.totalVoiceCount = i11;
    }

    public void setVoice(boolean z11) {
        this.isVoice = z11;
    }

    public String toString() {
        return "VoiceInfo(isVoice=" + isVoice() + ", totalVoiceCount=" + getTotalVoiceCount() + ", singleVoiceTime=" + getSingleVoiceTime() + ", receiveTxUserid=" + getReceiveTxUserid() + ")";
    }
}
