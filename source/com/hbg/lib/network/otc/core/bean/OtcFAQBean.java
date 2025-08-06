package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.util.List;

public class OtcFAQBean implements Serializable {
    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_LIKE = 1;
    public static final int TYPE_UN_LIKE = 2;
    private OtcActionBean action;
    private String code;
    private String content;
    private boolean isLast;
    private boolean isLocalAll;
    private int like;
    private int pageSize;
    private List<OtcFAQBean> subset;
    private String title;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcFAQBean;
    }

    public void changePageSize() {
        int i11;
        this.pageSize++;
        int size = this.subset.size();
        if (size % 10 == 0) {
            i11 = size / 10;
        } else {
            i11 = (size / 10) + 1;
        }
        int i12 = this.pageSize;
        if (i12 > i11) {
            i12 = 0;
        }
        this.pageSize = i12;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcFAQBean)) {
            return false;
        }
        OtcFAQBean otcFAQBean = (OtcFAQBean) obj;
        if (!otcFAQBean.canEqual(this)) {
            return false;
        }
        String code2 = getCode();
        String code3 = otcFAQBean.getCode();
        if (code2 != null ? !code2.equals(code3) : code3 != null) {
            return false;
        }
        String title2 = getTitle();
        String title3 = otcFAQBean.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String content2 = getContent();
        String content3 = otcFAQBean.getContent();
        if (content2 != null ? !content2.equals(content3) : content3 != null) {
            return false;
        }
        if (getLike() != otcFAQBean.getLike()) {
            return false;
        }
        List<OtcFAQBean> subset2 = getSubset();
        List<OtcFAQBean> subset3 = otcFAQBean.getSubset();
        if (subset2 != null ? !subset2.equals(subset3) : subset3 != null) {
            return false;
        }
        OtcActionBean action2 = getAction();
        OtcActionBean action3 = otcFAQBean.getAction();
        if (action2 != null ? action2.equals(action3) : action3 == null) {
            return isLast() == otcFAQBean.isLast() && isLocalAll() == otcFAQBean.isLocalAll() && getPageSize() == otcFAQBean.getPageSize();
        }
        return false;
    }

    public OtcActionBean getAction() {
        return this.action;
    }

    public String getCode() {
        return this.code;
    }

    public String getContent() {
        return this.content;
    }

    public int getLike() {
        return this.like;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public List<OtcFAQBean> getSubset() {
        return this.subset;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean hasSubset() {
        return getSubset() != null && !getSubset().isEmpty();
    }

    public int hashCode() {
        String code2 = getCode();
        int i11 = 43;
        int hashCode = code2 == null ? 43 : code2.hashCode();
        String title2 = getTitle();
        int hashCode2 = ((hashCode + 59) * 59) + (title2 == null ? 43 : title2.hashCode());
        String content2 = getContent();
        int hashCode3 = (((hashCode2 * 59) + (content2 == null ? 43 : content2.hashCode())) * 59) + getLike();
        List<OtcFAQBean> subset2 = getSubset();
        int hashCode4 = (hashCode3 * 59) + (subset2 == null ? 43 : subset2.hashCode());
        OtcActionBean action2 = getAction();
        int i12 = hashCode4 * 59;
        if (action2 != null) {
            i11 = action2.hashCode();
        }
        int i13 = 79;
        int i14 = (((i12 + i11) * 59) + (isLast() ? 79 : 97)) * 59;
        if (!isLocalAll()) {
            i13 = 97;
        }
        return ((i14 + i13) * 59) + getPageSize();
    }

    public boolean isLast() {
        return this.isLast;
    }

    public boolean isLocalAll() {
        return this.isLocalAll;
    }

    public void setAction(OtcActionBean otcActionBean) {
        this.action = otcActionBean;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setLast(boolean z11) {
        this.isLast = z11;
    }

    public void setLike(int i11) {
        this.like = i11;
    }

    public void setLocalAll(boolean z11) {
        this.isLocalAll = z11;
    }

    public void setPageSize(int i11) {
        this.pageSize = i11;
    }

    public void setSubset(List<OtcFAQBean> list) {
        this.subset = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "OtcFAQBean(code=" + getCode() + ", title=" + getTitle() + ", content=" + getContent() + ", like=" + getLike() + ", subset=" + getSubset() + ", action=" + getAction() + ", isLast=" + isLast() + ", isLocalAll=" + isLocalAll() + ", pageSize=" + getPageSize() + ")";
    }
}
