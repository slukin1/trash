package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class HomePageNoticeData implements Serializable {
    public static final String TAG_Announcement = "Announcement";
    public static final String TAG_NEW_COIN = "New_Coin";
    public static final String TAG_Promotions = "Promotions";
    private List<Notice> normal;
    private List<Notice> top;

    public static class Notice implements Serializable {
        private String absolute_url;
        private int order_no;
        private long procla_id;
        private String relative_url;
        private long show_time;
        private String tag;
        private String title;

        public boolean canEqual(Object obj) {
            return obj instanceof Notice;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Notice)) {
                return false;
            }
            Notice notice = (Notice) obj;
            if (!notice.canEqual(this) || getProcla_id() != notice.getProcla_id()) {
                return false;
            }
            String title2 = getTitle();
            String title3 = notice.getTitle();
            if (title2 != null ? !title2.equals(title3) : title3 != null) {
                return false;
            }
            String relative_url2 = getRelative_url();
            String relative_url3 = notice.getRelative_url();
            if (relative_url2 != null ? !relative_url2.equals(relative_url3) : relative_url3 != null) {
                return false;
            }
            String absolute_url2 = getAbsolute_url();
            String absolute_url3 = notice.getAbsolute_url();
            if (absolute_url2 != null ? !absolute_url2.equals(absolute_url3) : absolute_url3 != null) {
                return false;
            }
            if (getOrder_no() != notice.getOrder_no()) {
                return false;
            }
            String tag2 = getTag();
            String tag3 = notice.getTag();
            if (tag2 != null ? tag2.equals(tag3) : tag3 == null) {
                return getShow_time() == notice.getShow_time();
            }
            return false;
        }

        public String getAbsolute_url() {
            return this.absolute_url;
        }

        public int getOrder_no() {
            return this.order_no;
        }

        public long getProcla_id() {
            return this.procla_id;
        }

        public String getRelative_url() {
            return this.relative_url;
        }

        public long getShow_time() {
            return this.show_time;
        }

        public String getTag() {
            return this.tag;
        }

        public String getTitle() {
            return this.title;
        }

        public int hashCode() {
            long procla_id2 = getProcla_id();
            String title2 = getTitle();
            int i11 = 43;
            int hashCode = ((((int) (procla_id2 ^ (procla_id2 >>> 32))) + 59) * 59) + (title2 == null ? 43 : title2.hashCode());
            String relative_url2 = getRelative_url();
            int hashCode2 = (hashCode * 59) + (relative_url2 == null ? 43 : relative_url2.hashCode());
            String absolute_url2 = getAbsolute_url();
            int hashCode3 = (((hashCode2 * 59) + (absolute_url2 == null ? 43 : absolute_url2.hashCode())) * 59) + getOrder_no();
            String tag2 = getTag();
            int i12 = hashCode3 * 59;
            if (tag2 != null) {
                i11 = tag2.hashCode();
            }
            long show_time2 = getShow_time();
            return ((i12 + i11) * 59) + ((int) ((show_time2 >>> 32) ^ show_time2));
        }

        public void setAbsolute_url(String str) {
            this.absolute_url = str;
        }

        public void setOrder_no(int i11) {
            this.order_no = i11;
        }

        public void setProcla_id(long j11) {
            this.procla_id = j11;
        }

        public void setRelative_url(String str) {
            this.relative_url = str;
        }

        public void setShow_time(long j11) {
            this.show_time = j11;
        }

        public void setTag(String str) {
            this.tag = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String toString() {
            return "HomePageNoticeData.Notice(procla_id=" + getProcla_id() + ", title=" + getTitle() + ", relative_url=" + getRelative_url() + ", absolute_url=" + getAbsolute_url() + ", order_no=" + getOrder_no() + ", tag=" + getTag() + ", show_time=" + getShow_time() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof HomePageNoticeData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HomePageNoticeData)) {
            return false;
        }
        HomePageNoticeData homePageNoticeData = (HomePageNoticeData) obj;
        if (!homePageNoticeData.canEqual(this)) {
            return false;
        }
        List<Notice> normal2 = getNormal();
        List<Notice> normal3 = homePageNoticeData.getNormal();
        if (normal2 != null ? !normal2.equals(normal3) : normal3 != null) {
            return false;
        }
        List<Notice> top2 = getTop();
        List<Notice> top3 = homePageNoticeData.getTop();
        return top2 != null ? top2.equals(top3) : top3 == null;
    }

    public List<Notice> getNormal() {
        return this.normal;
    }

    public List<Notice> getTop() {
        return this.top;
    }

    public int hashCode() {
        List<Notice> normal2 = getNormal();
        int i11 = 43;
        int hashCode = normal2 == null ? 43 : normal2.hashCode();
        List<Notice> top2 = getTop();
        int i12 = (hashCode + 59) * 59;
        if (top2 != null) {
            i11 = top2.hashCode();
        }
        return i12 + i11;
    }

    public void setNormal(List<Notice> list) {
        this.normal = list;
    }

    public void setTop(List<Notice> list) {
        this.top = list;
    }

    public String toString() {
        return "HomePageNoticeData(normal=" + getNormal() + ", top=" + getTop() + ")";
    }
}
