package zendesk.support;

import android.annotation.SuppressLint;
import com.zendesk.logger.Logger;
import com.zendesk.service.ErrorResponseAdapter;
import com.zendesk.service.ZendeskCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import lz.a;
import mz.c;
import mz.f;
import zendesk.core.User;

class ZendeskHelpCenterProvider implements HelpCenterProvider {
    private static final String EMPTY_JSON_BODY = "{}";
    private static final String LOG_TAG = "ZendeskHelpCenterProvider";
    /* access modifiers changed from: private */
    public final HelpCenterBlipsProvider blipsProvider;
    /* access modifiers changed from: private */
    public final ZendeskHelpCenterService helpCenterService;
    /* access modifiers changed from: private */
    public final HelpCenterSessionCache helpCenterSessionCache;
    /* access modifiers changed from: private */
    public final HelpCenterTracker helpCenterTracker;
    private final HelpCenterSettingsProvider settingsProvider;

    public static abstract class ZendeskCallbackSuccess<E> extends ZendeskCallback<E> {
        private final ZendeskCallback callback;

        public ZendeskCallbackSuccess(ZendeskCallback zendeskCallback) {
            this.callback = zendeskCallback;
        }

        public void onError(a aVar) {
            ZendeskCallback zendeskCallback = this.callback;
            if (zendeskCallback != null) {
                zendeskCallback.onError(aVar);
            }
        }

        public abstract void onSuccess(E e11);
    }

    public ZendeskHelpCenterProvider(HelpCenterSettingsProvider helpCenterSettingsProvider, HelpCenterBlipsProvider helpCenterBlipsProvider, ZendeskHelpCenterService zendeskHelpCenterService, HelpCenterSessionCache helpCenterSessionCache2, HelpCenterTracker helpCenterTracker2) {
        this.settingsProvider = helpCenterSettingsProvider;
        this.blipsProvider = helpCenterBlipsProvider;
        this.helpCenterService = zendeskHelpCenterService;
        this.helpCenterSessionCache = helpCenterSessionCache2;
        this.helpCenterTracker = helpCenterTracker2;
    }

    /* access modifiers changed from: private */
    public boolean checkSettingsAndVotingEnabled(ZendeskCallback<?> zendeskCallback, HelpCenterSettings helpCenterSettings) {
        if (!sanityCheckHelpCenterSettings(zendeskCallback, helpCenterSettings)) {
            if (helpCenterSettings.isArticleVotingEnabled()) {
                return true;
            }
            Logger.d(LOG_TAG, "Help Center voting is disabled in your app's settings. Can not continue with the call", new Object[0]);
            if (zendeskCallback != null) {
                zendeskCallback.onError(new ErrorResponseAdapter("Help Center voting is disabled in your app's settings. Can not continue with the call"));
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public List<HelpItem> convert(HelpResponse helpResponse) {
        if (helpResponse == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (CategoryItem next : helpResponse.getCategories()) {
            arrayList.add(next);
            for (SectionItem next2 : next.getSections()) {
                arrayList.add(next2);
                arrayList.addAll(next2.getChildren());
            }
        }
        return arrayList;
    }

    @SuppressLint({"UseSparseArrays"})
    public List<FlatArticle> asFlatArticleList(ArticlesResponse articlesResponse) {
        if (articlesResponse == null) {
            return new ArrayList();
        }
        List<Category> categories = articlesResponse.getCategories();
        List<Section> sections = articlesResponse.getSections();
        List<Article> articles = articlesResponse.getArticles();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        List<FlatArticle> arrayList = new ArrayList<>();
        if (mz.a.i(articles)) {
            for (Category next : categories) {
                hashMap.put(next.getId(), next);
            }
            for (Section next2 : sections) {
                hashMap2.put(next2.getId(), next2);
            }
            for (Article next3 : articles) {
                Section section = (Section) hashMap2.get(next3.getSectionId());
                arrayList.add(new FlatArticle((Category) hashMap.get(section.getCategoryId()), section, next3));
            }
        } else {
            Logger.b(LOG_TAG, "There are no articles contained in this account", new Object[0]);
            arrayList = Collections.emptyList();
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    @SuppressLint({"UseSparseArrays"})
    public List<SearchArticle> asSearchArticleList(ArticlesResponse articlesResponse) {
        Section section;
        ArrayList arrayList = new ArrayList();
        if (articlesResponse == null) {
            return arrayList;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        List<TypeT> e11 = mz.a.e(articlesResponse.getArticles());
        List<TypeT> e12 = mz.a.e(articlesResponse.getSections());
        List<TypeT> e13 = mz.a.e(articlesResponse.getCategories());
        List<TypeT> e14 = mz.a.e(articlesResponse.getUsers());
        for (TypeT typet : e12) {
            if (typet.getId() != null) {
                hashMap.put(typet.getId(), typet);
            }
        }
        for (TypeT typet2 : e13) {
            if (typet2.getId() != null) {
                hashMap2.put(typet2.getId(), typet2);
            }
        }
        for (TypeT typet3 : e14) {
            if (typet3.getId() != null) {
                hashMap3.put(typet3.getId(), typet3);
            }
        }
        for (TypeT typet4 : e11) {
            Category category = null;
            if (typet4.getSectionId() != null) {
                section = (Section) hashMap.get(typet4.getSectionId());
            } else {
                Logger.l(LOG_TAG, "Unable to determine section as section id was null.", new Object[0]);
                section = null;
            }
            if (section == null || section.getCategoryId() == null) {
                Logger.l(LOG_TAG, "Unable to determine category as section was null.", new Object[0]);
            } else {
                category = (Category) hashMap2.get(section.getCategoryId());
            }
            if (typet4.getAuthorId() != null) {
                typet4.setAuthor((User) hashMap3.get(typet4.getAuthorId()));
            } else {
                Logger.l(LOG_TAG, "Unable to determine author as author id was null.", new Object[0]);
            }
            arrayList.add(new SearchArticle(typet4, section, category));
        }
        return arrayList;
    }

    public void deleteVote(final Long l11, final ZendeskCallback<Void> zendeskCallback) {
        if (!sanityCheck(zendeskCallback, l11)) {
            this.settingsProvider.getSettings(new ZendeskCallbackSuccess<HelpCenterSettings>(zendeskCallback) {
                public void onSuccess(HelpCenterSettings helpCenterSettings) {
                    if (ZendeskHelpCenterProvider.this.checkSettingsAndVotingEnabled(zendeskCallback, helpCenterSettings)) {
                        ZendeskHelpCenterProvider.this.helpCenterService.deleteVote(l11, new ZendeskCallbackSuccess<Void>(zendeskCallback) {
                            public void onSuccess(Void voidR) {
                                ZendeskCallback zendeskCallback = zendeskCallback;
                                if (zendeskCallback != null) {
                                    zendeskCallback.onSuccess(voidR);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void downvoteArticle(final Long l11, final ZendeskCallback<ArticleVote> zendeskCallback) {
        if (!sanityCheck(zendeskCallback, l11)) {
            this.settingsProvider.getSettings(new ZendeskCallbackSuccess<HelpCenterSettings>(zendeskCallback) {
                public void onSuccess(HelpCenterSettings helpCenterSettings) {
                    if (ZendeskHelpCenterProvider.this.checkSettingsAndVotingEnabled(zendeskCallback, helpCenterSettings)) {
                        ZendeskHelpCenterProvider.this.helpCenterService.downvoteArticle(l11, ZendeskHelpCenterProvider.EMPTY_JSON_BODY, new ZendeskCallbackSuccess<ArticleVoteResponse>(zendeskCallback) {
                            public void onSuccess(ArticleVoteResponse articleVoteResponse) {
                                ZendeskCallback zendeskCallback = zendeskCallback;
                                if (zendeskCallback != null) {
                                    zendeskCallback.onSuccess(articleVoteResponse.getVote());
                                }
                                ZendeskHelpCenterProvider.this.blipsProvider.articleVote(l11, -1);
                            }
                        });
                    }
                }
            });
        }
    }

    public void getArticle(final Long l11, final ZendeskCallback<Article> zendeskCallback) {
        if (!sanityCheck(zendeskCallback, l11)) {
            this.settingsProvider.getSettings(new ZendeskCallbackSuccess<HelpCenterSettings>(zendeskCallback) {
                public void onSuccess(HelpCenterSettings helpCenterSettings) {
                    if (!ZendeskHelpCenterProvider.this.sanityCheckHelpCenterSettings(zendeskCallback, helpCenterSettings)) {
                        ZendeskHelpCenterProvider.this.helpCenterService.getArticle(l11, ZendeskHelpCenterProvider.this.getLocale(helpCenterSettings), "users", new ZendeskCallbackSuccess<Article>(zendeskCallback) {
                            public void onSuccess(Article article) {
                                ZendeskHelpCenterProvider.this.submitRecordArticleView(article, c.c(article.getLocale()), new ZendeskCallback<Void>() {
                                    public void onError(a aVar) {
                                        Logger.d(ZendeskHelpCenterProvider.LOG_TAG, "Error submitting Help Center reporting: [reason] %s [isNetworkError] %s [status] %d", aVar.getReason(), Boolean.valueOf(aVar.a()), Integer.valueOf(aVar.getStatus()));
                                    }

                                    public void onSuccess(Void voidR) {
                                    }
                                });
                                ZendeskCallback zendeskCallback = zendeskCallback;
                                if (zendeskCallback != null) {
                                    zendeskCallback.onSuccess(article);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void getArticles(Long l11, ZendeskCallback<List<Article>> zendeskCallback) {
        getArticles(l11, (String) null, zendeskCallback);
    }

    public void getAttachments(Long l11, AttachmentType attachmentType, ZendeskCallback<List<HelpCenterAttachment>> zendeskCallback) {
        if (!sanityCheck(zendeskCallback, l11, attachmentType)) {
            final ZendeskCallback<List<HelpCenterAttachment>> zendeskCallback2 = zendeskCallback;
            final Long l12 = l11;
            final AttachmentType attachmentType2 = attachmentType;
            this.settingsProvider.getSettings(new ZendeskCallbackSuccess<HelpCenterSettings>(zendeskCallback) {
                public void onSuccess(HelpCenterSettings helpCenterSettings) {
                    if (!ZendeskHelpCenterProvider.this.sanityCheckHelpCenterSettings(zendeskCallback2, helpCenterSettings)) {
                        ZendeskHelpCenterProvider.this.helpCenterService.getAttachments(ZendeskHelpCenterProvider.this.getLocale(helpCenterSettings), l12, attachmentType2, zendeskCallback2);
                    }
                }
            });
        }
    }

    public void getCategories(final ZendeskCallback<List<Category>> zendeskCallback) {
        if (!sanityCheck(zendeskCallback, new Object[0])) {
            this.settingsProvider.getSettings(new ZendeskCallbackSuccess<HelpCenterSettings>(zendeskCallback) {
                public void onSuccess(HelpCenterSettings helpCenterSettings) {
                    if (!ZendeskHelpCenterProvider.this.sanityCheckHelpCenterSettings(zendeskCallback, helpCenterSettings)) {
                        ZendeskHelpCenterProvider.this.helpCenterService.getCategories(ZendeskHelpCenterProvider.this.getLocale(helpCenterSettings), zendeskCallback);
                    }
                }
            });
        }
    }

    public void getCategory(final Long l11, final ZendeskCallback<Category> zendeskCallback) {
        if (!sanityCheck(zendeskCallback, l11)) {
            this.settingsProvider.getSettings(new ZendeskCallbackSuccess<HelpCenterSettings>(zendeskCallback) {
                public void onSuccess(HelpCenterSettings helpCenterSettings) {
                    if (!ZendeskHelpCenterProvider.this.sanityCheckHelpCenterSettings(zendeskCallback, helpCenterSettings)) {
                        ZendeskHelpCenterProvider.this.helpCenterService.getCategoryById(l11, ZendeskHelpCenterProvider.this.getLocale(helpCenterSettings), zendeskCallback);
                    }
                }
            });
        }
    }

    public void getHelp(final HelpRequest helpRequest, final ZendeskCallback<List<HelpItem>> zendeskCallback) {
        this.settingsProvider.getSettings(new ZendeskCallbackSuccess<HelpCenterSettings>(zendeskCallback) {
            public void onSuccess(HelpCenterSettings helpCenterSettings) {
                if (!ZendeskHelpCenterProvider.this.sanityCheckHelpCenterSettings(zendeskCallback, helpCenterSettings)) {
                    ZendeskHelpCenterProvider.this.helpCenterService.getHelp(ZendeskHelpCenterProvider.this.getLocale(helpCenterSettings), helpRequest.getCategoryIds(), helpRequest.getSectionIds(), helpRequest.getIncludes(), helpRequest.getArticlesPerPageLimit(), f.h(helpRequest.getLabelNames()), new ZendeskCallbackSuccess<HelpResponse>(zendeskCallback) {
                        public void onSuccess(HelpResponse helpResponse) {
                            ZendeskHelpCenterProvider.this.helpCenterTracker.helpCenterLoaded();
                            AnonymousClass1 r02 = AnonymousClass1.this;
                            ZendeskCallback zendeskCallback = zendeskCallback;
                            if (zendeskCallback != null) {
                                zendeskCallback.onSuccess(ZendeskHelpCenterProvider.this.convert(helpResponse));
                            }
                        }
                    });
                }
            }
        });
    }

    public Locale getLocale(HelpCenterSettings helpCenterSettings) {
        Guide guide = Guide.INSTANCE;
        if (guide.getHelpCenterLocaleOverride() != null) {
            return guide.getHelpCenterLocaleOverride();
        }
        String locale = helpCenterSettings != null ? helpCenterSettings.getLocale() : "";
        if (f.e(locale)) {
            return Locale.getDefault();
        }
        return c.c(locale);
    }

    public void getSection(final Long l11, final ZendeskCallback<Section> zendeskCallback) {
        if (!sanityCheck(zendeskCallback, l11)) {
            this.settingsProvider.getSettings(new ZendeskCallbackSuccess<HelpCenterSettings>(zendeskCallback) {
                public void onSuccess(HelpCenterSettings helpCenterSettings) {
                    if (!ZendeskHelpCenterProvider.this.sanityCheckHelpCenterSettings(zendeskCallback, helpCenterSettings)) {
                        ZendeskHelpCenterProvider.this.helpCenterService.getSectionById(l11, ZendeskHelpCenterProvider.this.getLocale(helpCenterSettings), zendeskCallback);
                    }
                }
            });
        }
    }

    public void getSections(final Long l11, final ZendeskCallback<List<Section>> zendeskCallback) {
        if (!sanityCheck(zendeskCallback, l11)) {
            this.settingsProvider.getSettings(new ZendeskCallbackSuccess<HelpCenterSettings>(zendeskCallback) {
                public void onSuccess(HelpCenterSettings helpCenterSettings) {
                    if (!ZendeskHelpCenterProvider.this.sanityCheckHelpCenterSettings(zendeskCallback, helpCenterSettings)) {
                        ZendeskHelpCenterProvider.this.helpCenterService.getSectionsForCategory(l11, ZendeskHelpCenterProvider.this.getLocale(helpCenterSettings), zendeskCallback);
                    }
                }
            });
        }
    }

    public void getSuggestedArticles(final SuggestedArticleSearch suggestedArticleSearch, final ZendeskCallback<SuggestedArticleResponse> zendeskCallback) {
        if (!sanityCheck(zendeskCallback, suggestedArticleSearch)) {
            this.settingsProvider.getSettings(new ZendeskCallbackSuccess<HelpCenterSettings>(zendeskCallback) {
                public void onSuccess(HelpCenterSettings helpCenterSettings) {
                    Locale locale;
                    String str;
                    if (!ZendeskHelpCenterProvider.this.sanityCheckHelpCenterSettings(zendeskCallback, helpCenterSettings)) {
                        if (suggestedArticleSearch.getLocale() == null) {
                            locale = ZendeskHelpCenterProvider.this.getLocale(helpCenterSettings);
                        } else {
                            locale = suggestedArticleSearch.getLocale();
                        }
                        Locale locale2 = locale;
                        if (f.e(suggestedArticleSearch.getLabelNames())) {
                            str = null;
                        } else {
                            str = f.h(suggestedArticleSearch.getLabelNames());
                        }
                        ZendeskHelpCenterProvider.this.helpCenterService.getSuggestedArticles(suggestedArticleSearch.getQuery(), locale2, str, suggestedArticleSearch.getCategoryId(), suggestedArticleSearch.getSectionId(), zendeskCallback);
                    }
                }
            });
        }
    }

    public void listArticles(final ListArticleQuery listArticleQuery, final ZendeskCallback<List<SearchArticle>> zendeskCallback) {
        if (!sanityCheck(zendeskCallback, listArticleQuery)) {
            this.settingsProvider.getSettings(new ZendeskCallbackSuccess<HelpCenterSettings>(zendeskCallback) {
                public void onSuccess(HelpCenterSettings helpCenterSettings) {
                    String str;
                    if (!ZendeskHelpCenterProvider.this.sanityCheckHelpCenterSettings(zendeskCallback, helpCenterSettings)) {
                        if (listArticleQuery.getInclude() == null) {
                            str = f.h("categories", "sections", "users");
                        } else {
                            str = listArticleQuery.getInclude();
                        }
                        ZendeskHelpCenterProvider.this.helpCenterService.listArticles(f.h(listArticleQuery.getLabelNames()), listArticleQuery.getLocale() == null ? ZendeskHelpCenterProvider.this.getLocale(helpCenterSettings) : listArticleQuery.getLocale(), str, (listArticleQuery.getSortBy() == null ? SortBy.CREATED_AT : listArticleQuery.getSortBy()).getApiValue(), (listArticleQuery.getSortOrder() == null ? SortOrder.DESCENDING : listArticleQuery.getSortOrder()).getApiValue(), listArticleQuery.getPage(), listArticleQuery.getResultsPerPage(), new ZendeskCallbackSuccess<ArticlesListResponse>(zendeskCallback) {
                            public void onSuccess(ArticlesListResponse articlesListResponse) {
                                List<SearchArticle> asSearchArticleList = ZendeskHelpCenterProvider.this.asSearchArticleList(articlesListResponse);
                                ZendeskCallback zendeskCallback = zendeskCallback;
                                if (zendeskCallback != null) {
                                    zendeskCallback.onSuccess(asSearchArticleList);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void listArticlesFlat(final ListArticleQuery listArticleQuery, final ZendeskCallback<List<FlatArticle>> zendeskCallback) {
        if (!sanityCheck(zendeskCallback, listArticleQuery)) {
            this.settingsProvider.getSettings(new ZendeskCallbackSuccess<HelpCenterSettings>(zendeskCallback) {
                public void onSuccess(HelpCenterSettings helpCenterSettings) {
                    if (!ZendeskHelpCenterProvider.this.sanityCheckHelpCenterSettings(zendeskCallback, helpCenterSettings)) {
                        ZendeskHelpCenterProvider.this.helpCenterService.listArticles(f.h(listArticleQuery.getLabelNames()), listArticleQuery.getLocale() == null ? ZendeskHelpCenterProvider.this.getLocale(helpCenterSettings) : listArticleQuery.getLocale(), "categories,sections", (listArticleQuery.getSortBy() == null ? SortBy.CREATED_AT : listArticleQuery.getSortBy()).getApiValue(), (listArticleQuery.getSortOrder() == null ? SortOrder.DESCENDING : listArticleQuery.getSortOrder()).getApiValue(), listArticleQuery.getPage(), listArticleQuery.getResultsPerPage(), new ZendeskCallbackSuccess<ArticlesListResponse>(zendeskCallback) {
                            public void onSuccess(ArticlesListResponse articlesListResponse) {
                                List<FlatArticle> asFlatArticleList = ZendeskHelpCenterProvider.this.asFlatArticleList(articlesListResponse);
                                ZendeskCallback zendeskCallback = zendeskCallback;
                                if (zendeskCallback != null) {
                                    zendeskCallback.onSuccess(asFlatArticleList);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public boolean sanityCheck(ZendeskCallback<?> zendeskCallback, Object... objArr) {
        if (objArr != null) {
            boolean z11 = true;
            for (Object obj : objArr) {
                if (obj == null) {
                    z11 = false;
                }
            }
            if (!z11) {
                Logger.d(LOG_TAG, "One or more provided parameters are null.", new Object[0]);
                if (zendeskCallback != null) {
                    zendeskCallback.onError(new ErrorResponseAdapter("One or more provided parameters are null."));
                }
                return true;
            }
        }
        return false;
    }

    public boolean sanityCheckHelpCenterSettings(ZendeskCallback<?> zendeskCallback, HelpCenterSettings helpCenterSettings) {
        if (helpCenterSettings == null) {
            Logger.d(LOG_TAG, "Help Center settings are null. Can not continue with the call", new Object[0]);
            if (zendeskCallback != null) {
                zendeskCallback.onError(new ErrorResponseAdapter("Help Center settings are null. Can not continue with the call"));
            }
            return true;
        } else if (helpCenterSettings.isEnabled()) {
            return false;
        } else {
            Logger.d(LOG_TAG, "Help Center is disabled in your app's settings. Can not continue with the call", new Object[0]);
            if (zendeskCallback != null) {
                zendeskCallback.onError(new ErrorResponseAdapter("Help Center is disabled in your app's settings. Can not continue with the call"));
            }
            return true;
        }
    }

    public void searchArticles(final HelpCenterSearch helpCenterSearch, final ZendeskCallback<List<SearchArticle>> zendeskCallback) {
        if (!sanityCheck(zendeskCallback, helpCenterSearch)) {
            this.blipsProvider.helpCenterSearch(helpCenterSearch.getQuery());
            this.settingsProvider.getSettings(new ZendeskCallbackSuccess<HelpCenterSettings>(zendeskCallback) {
                public void onSuccess(HelpCenterSettings helpCenterSettings) {
                    String str;
                    String str2;
                    Locale locale;
                    if (!ZendeskHelpCenterProvider.this.sanityCheckHelpCenterSettings(zendeskCallback, helpCenterSettings)) {
                        if (f.e(helpCenterSearch.getInclude())) {
                            str = f.h("categories", "sections", "users");
                        } else {
                            str = f.h(helpCenterSearch.getInclude());
                        }
                        String str3 = str;
                        if (f.e(helpCenterSearch.getLabelNames())) {
                            str2 = null;
                        } else {
                            str2 = f.h(helpCenterSearch.getLabelNames());
                        }
                        String str4 = str2;
                        if (helpCenterSearch.getLocale() == null) {
                            locale = ZendeskHelpCenterProvider.this.getLocale(helpCenterSettings);
                        } else {
                            locale = helpCenterSearch.getLocale();
                        }
                        ZendeskHelpCenterProvider.this.helpCenterService.searchArticles(helpCenterSearch.getQuery(), locale, str3, str4, helpCenterSearch.getCategoryIds(), helpCenterSearch.getSectionIds(), helpCenterSearch.getPage(), helpCenterSearch.getPerPage(), new ZendeskCallbackSuccess<ArticlesSearchResponse>(zendeskCallback) {
                            public void onSuccess(ArticlesSearchResponse articlesSearchResponse) {
                                ZendeskHelpCenterProvider.this.helpCenterTracker.helpCenterSearched(helpCenterSearch.getQuery());
                                ZendeskHelpCenterProvider.this.helpCenterSessionCache.setLastSearch(helpCenterSearch.getQuery(), (articlesSearchResponse == null || !mz.a.i(articlesSearchResponse.getArticles())) ? 0 : articlesSearchResponse.getArticles().size());
                                List<SearchArticle> asSearchArticleList = ZendeskHelpCenterProvider.this.asSearchArticleList(articlesSearchResponse);
                                ZendeskCallback zendeskCallback = zendeskCallback;
                                if (zendeskCallback != null) {
                                    zendeskCallback.onSuccess(asSearchArticleList);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void submitRecordArticleView(Article article, Locale locale, ZendeskCallback<Void> zendeskCallback) {
        if (!sanityCheck(zendeskCallback, article)) {
            this.helpCenterTracker.helpCenterArticleViewed();
            this.blipsProvider.articleView(article);
            final ZendeskCallback<Void> zendeskCallback2 = zendeskCallback;
            final Article article2 = article;
            final Locale locale2 = locale;
            this.settingsProvider.getSettings(new ZendeskCallbackSuccess<HelpCenterSettings>(zendeskCallback) {
                public void onSuccess(HelpCenterSettings helpCenterSettings) {
                    if (!ZendeskHelpCenterProvider.this.sanityCheckHelpCenterSettings(zendeskCallback2, helpCenterSettings)) {
                        ZendeskHelpCenterProvider.this.helpCenterService.submitRecordArticleView(article2.getId(), locale2, new RecordArticleViewRequest(ZendeskHelpCenterProvider.this.helpCenterSessionCache.getLastSearch(), ZendeskHelpCenterProvider.this.helpCenterSessionCache.isUniqueSearchResultClick()), new ZendeskCallbackSuccess<Void>(zendeskCallback2) {
                            public void onSuccess(Void voidR) {
                                ZendeskHelpCenterProvider.this.helpCenterSessionCache.unsetUniqueSearchResultClick();
                                ZendeskCallback zendeskCallback = zendeskCallback2;
                                if (zendeskCallback != null) {
                                    zendeskCallback.onSuccess(voidR);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void upvoteArticle(final Long l11, final ZendeskCallback<ArticleVote> zendeskCallback) {
        if (!sanityCheck(zendeskCallback, l11)) {
            this.settingsProvider.getSettings(new ZendeskCallbackSuccess<HelpCenterSettings>(zendeskCallback) {
                public void onSuccess(HelpCenterSettings helpCenterSettings) {
                    if (ZendeskHelpCenterProvider.this.checkSettingsAndVotingEnabled(zendeskCallback, helpCenterSettings)) {
                        ZendeskHelpCenterProvider.this.helpCenterService.upvoteArticle(l11, ZendeskHelpCenterProvider.EMPTY_JSON_BODY, new ZendeskCallbackSuccess<ArticleVoteResponse>(zendeskCallback) {
                            public void onSuccess(ArticleVoteResponse articleVoteResponse) {
                                ZendeskCallback zendeskCallback = zendeskCallback;
                                if (zendeskCallback != null) {
                                    zendeskCallback.onSuccess(articleVoteResponse.getVote());
                                }
                                ZendeskHelpCenterProvider.this.blipsProvider.articleVote(l11, 1);
                            }
                        });
                    }
                }
            });
        }
    }

    public void getArticles(Long l11, String str, ZendeskCallback<List<Article>> zendeskCallback) {
        if (!sanityCheck(zendeskCallback, l11)) {
            final ZendeskCallback<List<Article>> zendeskCallback2 = zendeskCallback;
            final Long l12 = l11;
            final String str2 = str;
            this.settingsProvider.getSettings(new ZendeskCallbackSuccess<HelpCenterSettings>(zendeskCallback) {
                public void onSuccess(HelpCenterSettings helpCenterSettings) {
                    if (!ZendeskHelpCenterProvider.this.sanityCheckHelpCenterSettings(zendeskCallback2, helpCenterSettings)) {
                        ZendeskHelpCenterProvider.this.helpCenterService.getArticlesForSection(l12, ZendeskHelpCenterProvider.this.getLocale(helpCenterSettings), "users", str2, zendeskCallback2);
                    }
                }
            });
        }
    }
}
