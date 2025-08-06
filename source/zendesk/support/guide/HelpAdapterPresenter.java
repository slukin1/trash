package zendesk.support.guide;

import com.zendesk.logger.Logger;
import com.zendesk.service.ZendeskCallback;
import java.util.ArrayList;
import java.util.List;
import lz.a;
import zendesk.core.NetworkInfoProvider;
import zendesk.core.RetryAction;
import zendesk.support.ArticleItem;
import zendesk.support.CategoryItem;
import zendesk.support.HelpItem;
import zendesk.support.SectionItem;
import zendesk.support.SeeAllArticlesItem;

class HelpAdapterPresenter implements HelpMvp$Presenter {
    private static final Integer RETRY_ACTION_ID = 5;
    private ZendeskCallback<List<HelpItem>> callback = new ZendeskCallback<List<HelpItem>>() {
        public void onError(a aVar) {
            HelpCenterMvp$ErrorType helpCenterMvp$ErrorType;
            if (mz.a.i(HelpAdapterPresenter.this.helpCenterUiConfig.getCategoryIds())) {
                helpCenterMvp$ErrorType = HelpCenterMvp$ErrorType.CATEGORY_LOAD;
            } else if (mz.a.i(HelpAdapterPresenter.this.helpCenterUiConfig.getSectionIds())) {
                helpCenterMvp$ErrorType = HelpCenterMvp$ErrorType.SECTION_LOAD;
            } else {
                helpCenterMvp$ErrorType = HelpCenterMvp$ErrorType.ARTICLES_LOAD;
            }
            HelpAdapterPresenter.this.contentPresenter.onErrorWithRetry(helpCenterMvp$ErrorType, new RetryAction() {
                public void onRetry() {
                    boolean unused = HelpAdapterPresenter.this.hasError = false;
                    HelpAdapterPresenter.this.view.showItems(HelpAdapterPresenter.this.filteredItems);
                    HelpAdapterPresenter.this.requestHelpContent();
                }
            });
            boolean unused = HelpAdapterPresenter.this.hasError = true;
            HelpAdapterPresenter.this.view.showItems(HelpAdapterPresenter.this.filteredItems);
        }

        public void onSuccess(List<HelpItem> list) {
            boolean unused = HelpAdapterPresenter.this.hasError = false;
            List unused2 = HelpAdapterPresenter.this.helpItems = mz.a.c(list);
            if (HelpAdapterPresenter.this.helpCenterUiConfig.isCollapseCategories()) {
                HelpAdapterPresenter helpAdapterPresenter = HelpAdapterPresenter.this;
                List unused3 = helpAdapterPresenter.filteredItems = helpAdapterPresenter.getCollapsedCategories(helpAdapterPresenter.helpItems);
            } else {
                HelpAdapterPresenter helpAdapterPresenter2 = HelpAdapterPresenter.this;
                List unused4 = helpAdapterPresenter2.filteredItems = mz.a.c(helpAdapterPresenter2.helpItems);
            }
            HelpAdapterPresenter helpAdapterPresenter3 = HelpAdapterPresenter.this;
            boolean unused5 = helpAdapterPresenter3.noResults = mz.a.g(helpAdapterPresenter3.filteredItems);
            HelpAdapterPresenter.this.view.showItems(HelpAdapterPresenter.this.filteredItems);
            HelpAdapterPresenter.this.contentPresenter.onLoad();
        }
    };
    /* access modifiers changed from: private */
    public HelpCenterMvp$Presenter contentPresenter;
    /* access modifiers changed from: private */
    public List<HelpItem> filteredItems = new ArrayList();
    /* access modifiers changed from: private */
    public boolean hasError;
    /* access modifiers changed from: private */
    public HelpCenterConfiguration helpCenterUiConfig;
    /* access modifiers changed from: private */
    public List<HelpItem> helpItems = new ArrayList();
    private HelpMvp$Model model;
    private NetworkInfoProvider networkInfoProvider;
    /* access modifiers changed from: private */
    public boolean noResults;
    private RetryAction retryAction;
    /* access modifiers changed from: private */
    public HelpMvp$View view;

    public HelpAdapterPresenter(HelpMvp$View helpMvp$View, HelpMvp$Model helpMvp$Model, NetworkInfoProvider networkInfoProvider2, HelpCenterConfiguration helpCenterConfiguration) {
        this.view = helpMvp$View;
        this.model = helpMvp$Model;
        this.networkInfoProvider = networkInfoProvider2;
        this.helpCenterUiConfig = helpCenterConfiguration;
    }

    private void addItem(int i11, HelpItem helpItem) {
        this.filteredItems.add(i11, helpItem);
        this.view.addItem(i11, helpItem);
    }

    private void collapseItem(int i11) {
        if (i11 < getItemCount() - 1) {
            int i12 = i11 + 1;
            while (i12 < this.filteredItems.size() && 1 != this.filteredItems.get(i12).getViewType()) {
                removeItem(i12);
            }
        }
    }

    private void expandItem(CategoryItem categoryItem, int i11) {
        int i12 = i11 + 1;
        for (HelpItem next : categoryItem.getSections()) {
            addItem(i12, next);
            i12++;
            try {
                for (HelpItem addItem : ((SectionItem) next).getChildren()) {
                    addItem(i12, addItem);
                    i12++;
                }
            } catch (ClassCastException e11) {
                Logger.c(HelpCenterActivity.LOG_TAG, "Error expanding item", e11, new Object[0]);
            }
        }
    }

    /* access modifiers changed from: private */
    public List<HelpItem> getCollapsedCategories(List<HelpItem> list) {
        ArrayList arrayList = new ArrayList();
        if (!(list == null || list.size() == 0)) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                if (1 == list.get(i11).getViewType()) {
                    arrayList.add(list.get(i11));
                    ((CategoryItem) list.get(i11)).setExpanded(false);
                }
            }
        }
        return arrayList;
    }

    private int getPaddingItemCount() {
        return this.helpCenterUiConfig.isContactUsButtonVisible() ? 1 : 0;
    }

    /* access modifiers changed from: private */
    public void loadMoreArticles(final SeeAllArticlesItem seeAllArticlesItem) {
        final SectionItem section = seeAllArticlesItem.getSection();
        final AnonymousClass3 r12 = new RetryAction() {
            public void onRetry() {
                HelpAdapterPresenter.this.loadMoreArticles(seeAllArticlesItem);
            }
        };
        if (this.networkInfoProvider.isNetworkAvailable()) {
            this.model.getArticlesForSection(section, this.helpCenterUiConfig.getLabelNames(), new ZendeskCallback<List<ArticleItem>>() {
                public void onError(a aVar) {
                    HelpAdapterPresenter.this.helpItems.remove(seeAllArticlesItem);
                    Logger.d(HelpCenterActivity.LOG_TAG, "Failed to load more articles", aVar);
                    HelpAdapterPresenter.this.contentPresenter.onErrorWithRetry(HelpCenterMvp$ErrorType.ARTICLES_LOAD, r12);
                }

                public void onSuccess(List<ArticleItem> list) {
                    int indexOf = HelpAdapterPresenter.this.helpItems.indexOf(seeAllArticlesItem);
                    int indexOf2 = HelpAdapterPresenter.this.filteredItems.indexOf(seeAllArticlesItem);
                    for (ArticleItem next : list) {
                        if (!HelpAdapterPresenter.this.helpItems.contains(next)) {
                            int i11 = indexOf + 1;
                            HelpAdapterPresenter.this.helpItems.add(indexOf, next);
                            section.addArticle(next);
                            if (indexOf2 != -1) {
                                HelpAdapterPresenter.this.filteredItems.add(indexOf2, next);
                                HelpAdapterPresenter.this.view.addItem(indexOf2, next);
                                indexOf2++;
                            }
                            indexOf = i11;
                        }
                    }
                    HelpAdapterPresenter.this.helpItems.remove(seeAllArticlesItem);
                    int indexOf3 = HelpAdapterPresenter.this.filteredItems.indexOf(seeAllArticlesItem);
                    HelpAdapterPresenter.this.filteredItems.remove(seeAllArticlesItem);
                    HelpAdapterPresenter.this.view.removeItem(indexOf3);
                }
            });
            return;
        }
        this.retryAction = r12;
        this.networkInfoProvider.addRetryAction(RETRY_ACTION_ID, r12);
    }

    private void removeItem(int i11) {
        this.filteredItems.remove(i11);
        this.view.removeItem(i11);
    }

    /* access modifiers changed from: private */
    public void requestHelpContent() {
        if (!this.networkInfoProvider.isNetworkAvailable()) {
            AnonymousClass1 r02 = new RetryAction() {
                public void onRetry() {
                    HelpAdapterPresenter.this.requestHelpContent();
                }
            };
            this.retryAction = r02;
            this.networkInfoProvider.addRetryAction(RETRY_ACTION_ID, r02);
        }
        this.model.getArticles(this.helpCenterUiConfig.getCategoryIds(), this.helpCenterUiConfig.getSectionIds(), this.helpCenterUiConfig.getLabelNames(), this.callback);
    }

    public HelpItem getItem(int i11) {
        return this.filteredItems.get(i11);
    }

    public int getItemCount() {
        if (this.hasError) {
            return 0;
        }
        return Math.max(this.filteredItems.size() + getPaddingItemCount(), 1);
    }

    public HelpItem getItemForBinding(int i11) {
        if (this.filteredItems.size() <= 0 || i11 >= this.filteredItems.size()) {
            return null;
        }
        return this.filteredItems.get(i11);
    }

    public int getItemViewType(int i11) {
        if (this.noResults) {
            return 7;
        }
        if (this.filteredItems.size() <= 0) {
            return 5;
        }
        if (i11 == this.filteredItems.size()) {
            return 8;
        }
        return this.filteredItems.get(i11).getViewType();
    }

    public void onAttached() {
        this.networkInfoProvider.register();
        if (mz.a.g(this.helpItems)) {
            requestHelpContent();
        }
    }

    public boolean onCategoryClick(CategoryItem categoryItem, int i11) {
        if (categoryItem == null) {
            return false;
        }
        boolean expanded = categoryItem.setExpanded(!categoryItem.isExpanded());
        if (expanded) {
            expandItem(categoryItem, this.filteredItems.indexOf(categoryItem));
        } else {
            collapseItem(this.filteredItems.indexOf(categoryItem));
        }
        return expanded;
    }

    public void onDetached() {
        this.networkInfoProvider.removeRetryAction(RETRY_ACTION_ID);
        this.networkInfoProvider.unregister();
    }

    public void onSeeAllClick(SeeAllArticlesItem seeAllArticlesItem) {
        loadMoreArticles(seeAllArticlesItem);
    }

    public void setContentPresenter(HelpCenterMvp$Presenter helpCenterMvp$Presenter) {
        this.contentPresenter = helpCenterMvp$Presenter;
    }
}
