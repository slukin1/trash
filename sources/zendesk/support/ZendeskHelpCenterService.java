package zendesk.support;

import com.zendesk.logger.Logger;
import com.zendesk.service.ErrorResponseAdapter;
import com.zendesk.service.ZendeskCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import lz.c;
import mz.a;
import zendesk.core.User;
import zendesk.core.ZendeskLocaleConverter;

class ZendeskHelpCenterService {
    private static final String LOG_TAG = "ZendeskHelpCenterService";
    private static final int NUMBER_PER_PAGE = 1000;
    private final HelpCenterService helpCenterService;
    private final ZendeskLocaleConverter localeConverter;

    public ZendeskHelpCenterService(HelpCenterService helpCenterService2, ZendeskLocaleConverter zendeskLocaleConverter) {
        this.helpCenterService = helpCenterService2;
        this.localeConverter = zendeskLocaleConverter;
    }

    public void deleteVote(Long l11, ZendeskCallback<Void> zendeskCallback) {
        if (l11 == null) {
            Logger.d(LOG_TAG, "The vote id was null, can not delete the vote", new Object[0]);
            if (zendeskCallback != null) {
                zendeskCallback.onError(new ErrorResponseAdapter("The vote id was null, can not delete the vote"));
                return;
            }
            return;
        }
        this.helpCenterService.deleteVote(l11).enqueue(new c(zendeskCallback));
    }

    public void downvoteArticle(Long l11, String str, ZendeskCallback<ArticleVoteResponse> zendeskCallback) {
        if (l11 == null) {
            Logger.d(LOG_TAG, "The article id was null, can not create down vote", new Object[0]);
            if (zendeskCallback != null) {
                zendeskCallback.onError(new ErrorResponseAdapter("The article id was null, can not create down vote"));
                return;
            }
            return;
        }
        this.helpCenterService.downvoteArticle(l11, str).enqueue(new c(zendeskCallback));
    }

    public void getArticle(Long l11, Locale locale, String str, ZendeskCallback<Article> zendeskCallback) {
        String helpCenterLocaleString = this.localeConverter.toHelpCenterLocaleString(locale);
        this.helpCenterService.getArticle(helpCenterLocaleString, l11, str).enqueue(new c(zendeskCallback, new c.b<ArticleResponse, Article>() {
            public Article extract(ArticleResponse articleResponse) {
                return ZendeskHelpCenterService.this.matchArticleWithUsers(articleResponse.getArticle(), a.e(articleResponse.getUsers()));
            }
        }));
    }

    public void getArticlesForSection(Long l11, Locale locale, String str, String str2, ZendeskCallback<List<Article>> zendeskCallback) {
        this.helpCenterService.getArticles(this.localeConverter.toHelpCenterLocaleString(locale), l11, str2, str, 1000).enqueue(new c(zendeskCallback, new c.b<ArticlesListResponse, List<Article>>() {
            public List<Article> extract(ArticlesListResponse articlesListResponse) {
                return ZendeskHelpCenterService.this.matchArticlesWithUsers(articlesListResponse.getUsers(), articlesListResponse.getArticles());
            }
        }));
    }

    public void getAttachments(Locale locale, Long l11, AttachmentType attachmentType, ZendeskCallback<List<HelpCenterAttachment>> zendeskCallback) {
        if (attachmentType == null) {
            Logger.d(LOG_TAG, "getAttachments() was called with null attachment type", new Object[0]);
            if (zendeskCallback != null) {
                zendeskCallback.onError(new ErrorResponseAdapter("getAttachments() was called with null attachment type"));
                return;
            }
            return;
        }
        this.helpCenterService.getAttachments(this.localeConverter.toHelpCenterLocaleString(locale), l11, attachmentType.getAttachmentType()).enqueue(new c(zendeskCallback, new c.b<AttachmentResponse, List<HelpCenterAttachment>>() {
            public List<HelpCenterAttachment> extract(AttachmentResponse attachmentResponse) {
                return attachmentResponse.getArticleAttachments();
            }
        }));
    }

    public void getCategories(Locale locale, ZendeskCallback<List<Category>> zendeskCallback) {
        this.helpCenterService.getCategories(this.localeConverter.toHelpCenterLocaleString(locale)).enqueue(new c(zendeskCallback, new c.b<CategoriesResponse, List<Category>>() {
            public List<Category> extract(CategoriesResponse categoriesResponse) {
                return categoriesResponse.getCategories();
            }
        }));
    }

    public void getCategoryById(Long l11, Locale locale, ZendeskCallback<Category> zendeskCallback) {
        this.helpCenterService.getCategoryById(this.localeConverter.toHelpCenterLocaleString(locale), l11).enqueue(new c(zendeskCallback, new c.b<CategoryResponse, Category>() {
            public Category extract(CategoryResponse categoryResponse) {
                return categoryResponse.getCategory();
            }
        }));
    }

    public void getHelp(Locale locale, String str, String str2, String str3, int i11, String str4, ZendeskCallback<HelpResponse> zendeskCallback) {
        Locale locale2 = locale;
        this.helpCenterService.getHelp(this.localeConverter.toHelpCenterLocaleString(locale), str, str2, str3, i11, str4, 1000, SortBy.CREATED_AT.getApiValue(), SortOrder.DESCENDING.getApiValue()).enqueue(new c(zendeskCallback));
    }

    public void getSectionById(Long l11, Locale locale, ZendeskCallback<Section> zendeskCallback) {
        this.helpCenterService.getSectionById(this.localeConverter.toHelpCenterLocaleString(locale), l11).enqueue(new c(zendeskCallback, new c.b<SectionResponse, Section>() {
            public Section extract(SectionResponse sectionResponse) {
                return sectionResponse.getSection();
            }
        }));
    }

    public void getSectionsForCategory(Long l11, Locale locale, ZendeskCallback<List<Section>> zendeskCallback) {
        this.helpCenterService.getSections(this.localeConverter.toHelpCenterLocaleString(locale), l11, 1000).enqueue(new c(zendeskCallback, new c.b<SectionsResponse, List<Section>>() {
            public List<Section> extract(SectionsResponse sectionsResponse) {
                return sectionsResponse.getSections();
            }
        }));
    }

    public void getSuggestedArticles(String str, Locale locale, String str2, Long l11, Long l12, ZendeskCallback<SuggestedArticleResponse> zendeskCallback) {
        String helpCenterLocaleString = this.localeConverter.toHelpCenterLocaleString(locale);
        this.helpCenterService.getSuggestedArticles(str, helpCenterLocaleString, str2, l11, l12).enqueue(new c(zendeskCallback));
    }

    public void listArticles(String str, Locale locale, String str2, String str3, String str4, Integer num, Integer num2, ZendeskCallback<ArticlesListResponse> zendeskCallback) {
        Locale locale2 = locale;
        this.helpCenterService.listArticles(this.localeConverter.toHelpCenterLocaleString(locale), str, str2, str3, str4, num, num2).enqueue(new c(zendeskCallback));
    }

    public Article matchArticleWithUsers(Article article, List<User> list) {
        if (article == null) {
            return new Article();
        }
        Iterator<User> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            User next = it2.next();
            if (next.getId() != null && next.getId().equals(article.getAuthorId())) {
                article.setAuthor(next);
                break;
            }
        }
        return article;
    }

    public List<Article> matchArticlesWithUsers(List<User> list, List<Article> list2) {
        HashMap hashMap = new HashMap();
        for (User next : list) {
            hashMap.put(next.getId(), next);
        }
        ArrayList arrayList = new ArrayList();
        for (Article next2 : list2) {
            User user = (User) hashMap.get(next2.getAuthorId());
            if (user != null) {
                next2.setAuthor(user);
            }
            arrayList.add(next2);
        }
        return arrayList;
    }

    public void searchArticles(String str, Locale locale, String str2, String str3, String str4, String str5, Integer num, Integer num2, ZendeskCallback<ArticlesSearchResponse> zendeskCallback) {
        Locale locale2 = locale;
        this.helpCenterService.searchArticles(str, this.localeConverter.toHelpCenterLocaleString(locale), str2, str3, str4, str5, num, num2).enqueue(new c(zendeskCallback));
    }

    public void submitRecordArticleView(Long l11, Locale locale, RecordArticleViewRequest recordArticleViewRequest, ZendeskCallback<Void> zendeskCallback) {
        this.helpCenterService.submitRecordArticleView(l11, this.localeConverter.toHelpCenterLocaleString(locale), recordArticleViewRequest).enqueue(new c(zendeskCallback));
    }

    public void upvoteArticle(Long l11, String str, ZendeskCallback<ArticleVoteResponse> zendeskCallback) {
        if (l11 == null) {
            Logger.d(LOG_TAG, "The article id was null, can not create up vote", new Object[0]);
            if (zendeskCallback != null) {
                zendeskCallback.onError(new ErrorResponseAdapter("The article id was null, can not create up vote"));
                return;
            }
            return;
        }
        this.helpCenterService.upvoteArticle(l11, str).enqueue(new c(zendeskCallback));
    }
}
