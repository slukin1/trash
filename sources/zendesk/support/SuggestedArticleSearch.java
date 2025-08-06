package zendesk.support;

import java.util.Locale;
import mz.f;

public class SuggestedArticleSearch {
    /* access modifiers changed from: private */
    public Long categoryId;
    /* access modifiers changed from: private */
    public String labelNames;
    /* access modifiers changed from: private */
    public Locale locale;
    /* access modifiers changed from: private */
    public String query;
    /* access modifiers changed from: private */
    public Long sectionId;

    public static class Builder {
        private Long categoryId;
        private String[] labelNames;
        private Locale locale;
        private String query;
        private Long sectionId;

        public SuggestedArticleSearch build() {
            SuggestedArticleSearch suggestedArticleSearch = new SuggestedArticleSearch();
            String unused = suggestedArticleSearch.query = this.query;
            Locale unused2 = suggestedArticleSearch.locale = this.locale;
            String unused3 = suggestedArticleSearch.labelNames = f.h(this.labelNames);
            Long unused4 = suggestedArticleSearch.categoryId = this.categoryId;
            Long unused5 = suggestedArticleSearch.sectionId = this.sectionId;
            return suggestedArticleSearch;
        }

        public Builder forLocale(Locale locale2) {
            this.locale = locale2;
            return this;
        }

        public Builder withCategoryId(Long l11) {
            this.categoryId = l11;
            return this;
        }

        public Builder withLabelNames(String... strArr) {
            this.labelNames = strArr;
            return this;
        }

        public Builder withQuery(String str) {
            this.query = str;
            return this;
        }

        public Builder withSectionId(Long l11) {
            this.sectionId = l11;
            return this;
        }
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public String getLabelNames() {
        return this.labelNames;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public String getQuery() {
        return this.query;
    }

    public Long getSectionId() {
        return this.sectionId;
    }

    private SuggestedArticleSearch() {
    }
}
