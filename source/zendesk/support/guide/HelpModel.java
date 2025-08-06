package zendesk.support.guide;

import com.zendesk.service.ErrorResponseAdapter;
import com.zendesk.service.ZendeskCallback;
import java.util.ArrayList;
import java.util.List;
import lz.a;
import mz.f;
import zendesk.support.Article;
import zendesk.support.ArticleItem;
import zendesk.support.HelpCenterProvider;
import zendesk.support.HelpItem;
import zendesk.support.HelpRequest;
import zendesk.support.SectionItem;

class HelpModel implements HelpMvp$Model {
    private HelpCenterProvider provider;

    public HelpModel(HelpCenterProvider helpCenterProvider) {
        this.provider = helpCenterProvider;
    }

    /* access modifiers changed from: private */
    public ArticleItem convertArticle(Article article) {
        return new ArticleItem(article.getId(), article.getSectionId(), article.getTitle());
    }

    public void getArticles(List<Long> list, List<Long> list2, String[] strArr, ZendeskCallback<List<HelpItem>> zendeskCallback) {
        this.provider.getHelp(new HelpRequest.Builder().withCategoryIds(list).withSectionIds(list2).withLabelNames(strArr).includeCategories().includeSections().build(), zendeskCallback);
    }

    public void getArticlesForSection(SectionItem sectionItem, String[] strArr, final ZendeskCallback<List<ArticleItem>> zendeskCallback) {
        if (sectionItem == null || sectionItem.getId() == null) {
            zendeskCallback.onError(new ErrorResponseAdapter("SectionItem or its ID was null, cannot load more articles."));
        } else {
            this.provider.getArticles(sectionItem.getId(), f.h(strArr), new ZendeskCallback<List<Article>>() {
                public void onError(a aVar) {
                    ZendeskCallback zendeskCallback = zendeskCallback;
                    if (zendeskCallback != null) {
                        zendeskCallback.onError(aVar);
                    }
                }

                public void onSuccess(List<Article> list) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (Article access$000 : list) {
                        arrayList.add(HelpModel.this.convertArticle(access$000));
                    }
                    ZendeskCallback zendeskCallback = zendeskCallback;
                    if (zendeskCallback != null) {
                        zendeskCallback.onSuccess(arrayList);
                    }
                }
            });
        }
    }
}
