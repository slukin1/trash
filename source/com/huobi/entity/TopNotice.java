package com.huobi.entity;

import java.util.List;

public class TopNotice extends BaseTopNotice {
    private static final long serialVersionUID = -1119380690926946682L;
    private String content;
    private long created;
    private String source;
    private List<TopNotice> top_notice_list;

    public boolean canEqual(Object obj) {
        return obj instanceof TopNotice;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TopNotice)) {
            return false;
        }
        TopNotice topNotice = (TopNotice) obj;
        if (!topNotice.canEqual(this) || !super.equals(obj) || getCreated() != topNotice.getCreated()) {
            return false;
        }
        String source2 = getSource();
        String source3 = topNotice.getSource();
        if (source2 != null ? !source2.equals(source3) : source3 != null) {
            return false;
        }
        String content2 = getContent();
        String content3 = topNotice.getContent();
        if (content2 != null ? !content2.equals(content3) : content3 != null) {
            return false;
        }
        List<TopNotice> top_notice_list2 = getTop_notice_list();
        List<TopNotice> top_notice_list3 = topNotice.getTop_notice_list();
        return top_notice_list2 != null ? top_notice_list2.equals(top_notice_list3) : top_notice_list3 == null;
    }

    public String getContent() {
        return this.content;
    }

    public long getCreated() {
        return this.created;
    }

    public String getSource() {
        return this.source;
    }

    public List<TopNotice> getTop_notice_list() {
        return this.top_notice_list;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        long created2 = getCreated();
        int i11 = (hashCode * 59) + ((int) (created2 ^ (created2 >>> 32)));
        String source2 = getSource();
        int i12 = 43;
        int hashCode2 = (i11 * 59) + (source2 == null ? 43 : source2.hashCode());
        String content2 = getContent();
        int hashCode3 = (hashCode2 * 59) + (content2 == null ? 43 : content2.hashCode());
        List<TopNotice> top_notice_list2 = getTop_notice_list();
        int i13 = hashCode3 * 59;
        if (top_notice_list2 != null) {
            i12 = top_notice_list2.hashCode();
        }
        return i13 + i12;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreated(long j11) {
        this.created = j11;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setTop_notice_list(List<TopNotice> list) {
        this.top_notice_list = list;
    }

    public String toString() {
        return "TopNotice(created=" + getCreated() + ", source=" + getSource() + ", content=" + getContent() + ", top_notice_list=" + getTop_notice_list() + ")";
    }
}
