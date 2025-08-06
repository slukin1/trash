package com.hbg.lib.network.otc.core.bean;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.List;

public class OtcCancelReasonBean implements Serializable {
    private OtcCancelActionBean action;
    private String code;
    private String content;
    private boolean isChecked;
    private boolean isLocalHeader;
    private int negotiable;
    private String proofHint;
    private int proofNeed;
    private int proofType;
    private List<OtcCancelReasonBean> subset;
    private String title;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcCancelReasonBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcCancelReasonBean)) {
            return false;
        }
        OtcCancelReasonBean otcCancelReasonBean = (OtcCancelReasonBean) obj;
        if (!otcCancelReasonBean.canEqual(this) || isLocalHeader() != otcCancelReasonBean.isLocalHeader()) {
            return false;
        }
        String code2 = getCode();
        String code3 = otcCancelReasonBean.getCode();
        if (code2 != null ? !code2.equals(code3) : code3 != null) {
            return false;
        }
        String title2 = getTitle();
        String title3 = otcCancelReasonBean.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String content2 = getContent();
        String content3 = otcCancelReasonBean.getContent();
        if (content2 != null ? !content2.equals(content3) : content3 != null) {
            return false;
        }
        if (getProofNeed() != otcCancelReasonBean.getProofNeed() || getProofType() != otcCancelReasonBean.getProofType()) {
            return false;
        }
        String proofHint2 = getProofHint();
        String proofHint3 = otcCancelReasonBean.getProofHint();
        if (proofHint2 != null ? !proofHint2.equals(proofHint3) : proofHint3 != null) {
            return false;
        }
        if (getNegotiable() != otcCancelReasonBean.getNegotiable() || isChecked() != otcCancelReasonBean.isChecked()) {
            return false;
        }
        OtcCancelActionBean action2 = getAction();
        OtcCancelActionBean action3 = otcCancelReasonBean.getAction();
        if (action2 != null ? !action2.equals(action3) : action3 != null) {
            return false;
        }
        List<OtcCancelReasonBean> subset2 = getSubset();
        List<OtcCancelReasonBean> subset3 = otcCancelReasonBean.getSubset();
        return subset2 != null ? subset2.equals(subset3) : subset3 == null;
    }

    public OtcCancelActionBean getAction() {
        return this.action;
    }

    public String getCode() {
        return this.code;
    }

    public String getContent() {
        return this.content;
    }

    public int getNegotiable() {
        return this.negotiable;
    }

    public String getProofHint() {
        return this.proofHint;
    }

    public int getProofNeed() {
        return this.proofNeed;
    }

    public int getProofType() {
        return this.proofType;
    }

    public List<OtcCancelReasonBean> getSubset() {
        return this.subset;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean hasContent() {
        return !TextUtils.isEmpty(this.content);
    }

    public boolean hasSubset() {
        return getSubset() != null && !getSubset().isEmpty();
    }

    public int hashCode() {
        int i11 = 79;
        int i12 = isLocalHeader() ? 79 : 97;
        String code2 = getCode();
        int i13 = 43;
        int hashCode = ((i12 + 59) * 59) + (code2 == null ? 43 : code2.hashCode());
        String title2 = getTitle();
        int hashCode2 = (hashCode * 59) + (title2 == null ? 43 : title2.hashCode());
        String content2 = getContent();
        int hashCode3 = (((((hashCode2 * 59) + (content2 == null ? 43 : content2.hashCode())) * 59) + getProofNeed()) * 59) + getProofType();
        String proofHint2 = getProofHint();
        int hashCode4 = ((((hashCode3 * 59) + (proofHint2 == null ? 43 : proofHint2.hashCode())) * 59) + getNegotiable()) * 59;
        if (!isChecked()) {
            i11 = 97;
        }
        int i14 = hashCode4 + i11;
        OtcCancelActionBean action2 = getAction();
        int hashCode5 = (i14 * 59) + (action2 == null ? 43 : action2.hashCode());
        List<OtcCancelReasonBean> subset2 = getSubset();
        int i15 = hashCode5 * 59;
        if (subset2 != null) {
            i13 = subset2.hashCode();
        }
        return i15 + i13;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public boolean isLocalHeader() {
        return this.isLocalHeader;
    }

    public boolean isOtherType() {
        return this.proofNeed == 1 && this.proofType == 0;
    }

    public void resetSecondReasonChecked() {
        if (hasSubset()) {
            for (OtcCancelReasonBean checked : getSubset()) {
                checked.setChecked(false);
            }
        }
    }

    public void setAction(OtcCancelActionBean otcCancelActionBean) {
        this.action = otcCancelActionBean;
    }

    public void setChecked(boolean z11) {
        this.isChecked = z11;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setLocalHeader(boolean z11) {
        this.isLocalHeader = z11;
    }

    public void setNegotiable(int i11) {
        this.negotiable = i11;
    }

    public void setProofHint(String str) {
        this.proofHint = str;
    }

    public void setProofNeed(int i11) {
        this.proofNeed = i11;
    }

    public void setProofType(int i11) {
        this.proofType = i11;
    }

    public void setSubset(List<OtcCancelReasonBean> list) {
        this.subset = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "OtcCancelReasonBean(isLocalHeader=" + isLocalHeader() + ", code=" + getCode() + ", title=" + getTitle() + ", content=" + getContent() + ", proofNeed=" + getProofNeed() + ", proofType=" + getProofType() + ", proofHint=" + getProofHint() + ", negotiable=" + getNegotiable() + ", isChecked=" + isChecked() + ", action=" + getAction() + ", subset=" + getSubset() + ")";
    }
}
