package com.hbg.lib.network.php.core.bean;

import com.hbg.lib.network.retrofit.response.IResponse;
import java.util.List;

public class ZendeskTopNotice implements IResponse {
    private static final long serialVersionUID = -1119380690926946686L;
    private List<ArticlesBean> articles;
    private int count;
    private String sort_by;
    private String sort_order;

    public static class ArticlesBean extends BaseTopNotice {
        private long author_id;
        private String body;
        private boolean comments_disabled;
        private String created_at;
        private boolean draft;
        private String edited_at;
        private String html_url;
        private List<?> label_names;
        private String locale;
        private String name;
        private boolean outdated;
        private List<?> outdated_locales;
        private int position;
        private boolean promoted;
        private long section_id;
        private String source_locale;
        private String updated_at;
        private int vote_count;
        private int vote_sum;

        public boolean canEqual(Object obj) {
            return obj instanceof ArticlesBean;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ArticlesBean)) {
                return false;
            }
            ArticlesBean articlesBean = (ArticlesBean) obj;
            if (!articlesBean.canEqual(this) || !super.equals(obj)) {
                return false;
            }
            String html_url2 = getHtml_url();
            String html_url3 = articlesBean.getHtml_url();
            if (html_url2 != null ? !html_url2.equals(html_url3) : html_url3 != null) {
                return false;
            }
            if (getAuthor_id() != articlesBean.getAuthor_id() || isComments_disabled() != articlesBean.isComments_disabled() || isDraft() != articlesBean.isDraft() || isPromoted() != articlesBean.isPromoted() || getPosition() != articlesBean.getPosition() || getVote_sum() != articlesBean.getVote_sum() || getVote_count() != articlesBean.getVote_count() || getSection_id() != articlesBean.getSection_id()) {
                return false;
            }
            String created_at2 = getCreated_at();
            String created_at3 = articlesBean.getCreated_at();
            if (created_at2 != null ? !created_at2.equals(created_at3) : created_at3 != null) {
                return false;
            }
            String updated_at2 = getUpdated_at();
            String updated_at3 = articlesBean.getUpdated_at();
            if (updated_at2 != null ? !updated_at2.equals(updated_at3) : updated_at3 != null) {
                return false;
            }
            String name2 = getName();
            String name3 = articlesBean.getName();
            if (name2 != null ? !name2.equals(name3) : name3 != null) {
                return false;
            }
            String body2 = getBody();
            String body3 = articlesBean.getBody();
            if (body2 != null ? !body2.equals(body3) : body3 != null) {
                return false;
            }
            String source_locale2 = getSource_locale();
            String source_locale3 = articlesBean.getSource_locale();
            if (source_locale2 != null ? !source_locale2.equals(source_locale3) : source_locale3 != null) {
                return false;
            }
            String locale2 = getLocale();
            String locale3 = articlesBean.getLocale();
            if (locale2 != null ? !locale2.equals(locale3) : locale3 != null) {
                return false;
            }
            if (isOutdated() != articlesBean.isOutdated()) {
                return false;
            }
            String edited_at2 = getEdited_at();
            String edited_at3 = articlesBean.getEdited_at();
            if (edited_at2 != null ? !edited_at2.equals(edited_at3) : edited_at3 != null) {
                return false;
            }
            List<?> outdated_locales2 = getOutdated_locales();
            List<?> outdated_locales3 = articlesBean.getOutdated_locales();
            if (outdated_locales2 != null ? !outdated_locales2.equals(outdated_locales3) : outdated_locales3 != null) {
                return false;
            }
            List<?> label_names2 = getLabel_names();
            List<?> label_names3 = articlesBean.getLabel_names();
            return label_names2 != null ? label_names2.equals(label_names3) : label_names3 == null;
        }

        public long getAuthor_id() {
            return this.author_id;
        }

        public String getBody() {
            return this.body;
        }

        public String getCreated_at() {
            return this.created_at;
        }

        public String getEdited_at() {
            return this.edited_at;
        }

        public String getHtml_url() {
            return this.html_url;
        }

        public List<?> getLabel_names() {
            return this.label_names;
        }

        public String getLocale() {
            return this.locale;
        }

        public String getName() {
            return this.name;
        }

        public List<?> getOutdated_locales() {
            return this.outdated_locales;
        }

        public int getPosition() {
            return this.position;
        }

        public long getSection_id() {
            return this.section_id;
        }

        public String getSource_locale() {
            return this.source_locale;
        }

        public String getUpdated_at() {
            return this.updated_at;
        }

        public int getVote_count() {
            return this.vote_count;
        }

        public int getVote_sum() {
            return this.vote_sum;
        }

        public String getWebUrl() {
            return this.html_url;
        }

        public int hashCode() {
            int hashCode = super.hashCode();
            String html_url2 = getHtml_url();
            int i11 = hashCode * 59;
            int i12 = 43;
            int hashCode2 = html_url2 == null ? 43 : html_url2.hashCode();
            long author_id2 = getAuthor_id();
            int i13 = 79;
            int i14 = (((((((i11 + hashCode2) * 59) + ((int) (author_id2 ^ (author_id2 >>> 32)))) * 59) + (isComments_disabled() ? 79 : 97)) * 59) + (isDraft() ? 79 : 97)) * 59;
            int i15 = isPromoted() ? 79 : 97;
            long section_id2 = getSection_id();
            int position2 = ((((((((i14 + i15) * 59) + getPosition()) * 59) + getVote_sum()) * 59) + getVote_count()) * 59) + ((int) (section_id2 ^ (section_id2 >>> 32)));
            String created_at2 = getCreated_at();
            int hashCode3 = (position2 * 59) + (created_at2 == null ? 43 : created_at2.hashCode());
            String updated_at2 = getUpdated_at();
            int hashCode4 = (hashCode3 * 59) + (updated_at2 == null ? 43 : updated_at2.hashCode());
            String name2 = getName();
            int hashCode5 = (hashCode4 * 59) + (name2 == null ? 43 : name2.hashCode());
            String body2 = getBody();
            int hashCode6 = (hashCode5 * 59) + (body2 == null ? 43 : body2.hashCode());
            String source_locale2 = getSource_locale();
            int hashCode7 = (hashCode6 * 59) + (source_locale2 == null ? 43 : source_locale2.hashCode());
            String locale2 = getLocale();
            int hashCode8 = ((hashCode7 * 59) + (locale2 == null ? 43 : locale2.hashCode())) * 59;
            if (!isOutdated()) {
                i13 = 97;
            }
            String edited_at2 = getEdited_at();
            int hashCode9 = ((hashCode8 + i13) * 59) + (edited_at2 == null ? 43 : edited_at2.hashCode());
            List<?> outdated_locales2 = getOutdated_locales();
            int hashCode10 = (hashCode9 * 59) + (outdated_locales2 == null ? 43 : outdated_locales2.hashCode());
            List<?> label_names2 = getLabel_names();
            int i16 = hashCode10 * 59;
            if (label_names2 != null) {
                i12 = label_names2.hashCode();
            }
            return i16 + i12;
        }

        public boolean isComments_disabled() {
            return this.comments_disabled;
        }

        public boolean isDraft() {
            return this.draft;
        }

        public boolean isOutdated() {
            return this.outdated;
        }

        public boolean isPromoted() {
            return this.promoted;
        }

        public void setAuthor_id(long j11) {
            this.author_id = j11;
        }

        public void setBody(String str) {
            this.body = str;
        }

        public void setComments_disabled(boolean z11) {
            this.comments_disabled = z11;
        }

        public void setCreated_at(String str) {
            this.created_at = str;
        }

        public void setDraft(boolean z11) {
            this.draft = z11;
        }

        public void setEdited_at(String str) {
            this.edited_at = str;
        }

        public void setHtml_url(String str) {
            this.html_url = str;
        }

        public void setLabel_names(List<?> list) {
            this.label_names = list;
        }

        public void setLocale(String str) {
            this.locale = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setOutdated(boolean z11) {
            this.outdated = z11;
        }

        public void setOutdated_locales(List<?> list) {
            this.outdated_locales = list;
        }

        public void setPosition(int i11) {
            this.position = i11;
        }

        public void setPromoted(boolean z11) {
            this.promoted = z11;
        }

        public void setSection_id(long j11) {
            this.section_id = j11;
        }

        public void setSource_locale(String str) {
            this.source_locale = str;
        }

        public void setUpdated_at(String str) {
            this.updated_at = str;
        }

        public void setVote_count(int i11) {
            this.vote_count = i11;
        }

        public void setVote_sum(int i11) {
            this.vote_sum = i11;
        }

        public String toString() {
            return "ZendeskTopNotice.ArticlesBean(html_url=" + getHtml_url() + ", author_id=" + getAuthor_id() + ", comments_disabled=" + isComments_disabled() + ", draft=" + isDraft() + ", promoted=" + isPromoted() + ", position=" + getPosition() + ", vote_sum=" + getVote_sum() + ", vote_count=" + getVote_count() + ", section_id=" + getSection_id() + ", created_at=" + getCreated_at() + ", updated_at=" + getUpdated_at() + ", name=" + getName() + ", body=" + getBody() + ", source_locale=" + getSource_locale() + ", locale=" + getLocale() + ", outdated=" + isOutdated() + ", edited_at=" + getEdited_at() + ", outdated_locales=" + getOutdated_locales() + ", label_names=" + getLabel_names() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ZendeskTopNotice;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ZendeskTopNotice)) {
            return false;
        }
        ZendeskTopNotice zendeskTopNotice = (ZendeskTopNotice) obj;
        if (!zendeskTopNotice.canEqual(this) || getCount() != zendeskTopNotice.getCount()) {
            return false;
        }
        String sort_by2 = getSort_by();
        String sort_by3 = zendeskTopNotice.getSort_by();
        if (sort_by2 != null ? !sort_by2.equals(sort_by3) : sort_by3 != null) {
            return false;
        }
        String sort_order2 = getSort_order();
        String sort_order3 = zendeskTopNotice.getSort_order();
        if (sort_order2 != null ? !sort_order2.equals(sort_order3) : sort_order3 != null) {
            return false;
        }
        List<ArticlesBean> articles2 = getArticles();
        List<ArticlesBean> articles3 = zendeskTopNotice.getArticles();
        return articles2 != null ? articles2.equals(articles3) : articles3 == null;
    }

    public List<ArticlesBean> getArticles() {
        return this.articles;
    }

    public int getCount() {
        return this.count;
    }

    public String getSort_by() {
        return this.sort_by;
    }

    public String getSort_order() {
        return this.sort_order;
    }

    public int hashCode() {
        String sort_by2 = getSort_by();
        int i11 = 43;
        int count2 = ((getCount() + 59) * 59) + (sort_by2 == null ? 43 : sort_by2.hashCode());
        String sort_order2 = getSort_order();
        int hashCode = (count2 * 59) + (sort_order2 == null ? 43 : sort_order2.hashCode());
        List<ArticlesBean> articles2 = getArticles();
        int i12 = hashCode * 59;
        if (articles2 != null) {
            i11 = articles2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isSuccess() {
        return this.articles != null;
    }

    public void setArticles(List<ArticlesBean> list) {
        this.articles = list;
    }

    public void setCount(int i11) {
        this.count = i11;
    }

    public void setSort_by(String str) {
        this.sort_by = str;
    }

    public void setSort_order(String str) {
        this.sort_order = str;
    }

    public String toString() {
        return "ZendeskTopNotice(count=" + getCount() + ", sort_by=" + getSort_by() + ", sort_order=" + getSort_order() + ", articles=" + getArticles() + ")";
    }
}
