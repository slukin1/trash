package zendesk.support.guide;

import com.zendesk.logger.Logger;
import com.zendesk.service.ZendeskCallback;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lz.a;
import zendesk.classic.messaging.c;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.NetworkAware;
import zendesk.core.NetworkInfoProvider;
import zendesk.core.RetryAction;
import zendesk.support.HelpCenterSettings;
import zendesk.support.SearchArticle;

class HelpCenterPresenter implements HelpCenterMvp$Presenter, NetworkAware {
    private static final Integer NETWORK_AWARE_ID = 31;
    private static final Integer RETRY_ACTION_ID = 8642;
    /* access modifiers changed from: private */
    public ActionHandlerRegistry actionHandlerRegistry;
    /* access modifiers changed from: private */
    public HelpCenterConfiguration config;
    private List<c> engines;
    /* access modifiers changed from: private */
    public HelpCenterSettings helpCenterSettings;
    /* access modifiers changed from: private */
    public Set<RetryAction> internalRetryActions = new HashSet();
    private HelpCenterMvp$Model model;
    private NetworkInfoProvider networkInfoProvider;
    private boolean networkPreviouslyUnavailable;
    /* access modifiers changed from: private */
    public HelpCenterMvp$View view;

    public class ViewSafeRetryZendeskCallback extends ZendeskCallback<List<SearchArticle>> {
        /* access modifiers changed from: private */
        public String query;

        public ViewSafeRetryZendeskCallback(String str) {
            this.query = str;
        }

        public void onError(final a aVar) {
            if (HelpCenterPresenter.this.view != null) {
                HelpCenterPresenter.this.view.hideLoadingState();
                HelpCenterPresenter.this.view.showLoadArticleErrorWithRetry(HelpCenterMvp$ErrorType.ARTICLES_LOAD, new RetryAction() {
                    public void onRetry() {
                        ViewSafeRetryZendeskCallback viewSafeRetryZendeskCallback = ViewSafeRetryZendeskCallback.this;
                        HelpCenterPresenter.this.onSearchSubmit(viewSafeRetryZendeskCallback.query);
                    }
                });
                return;
            }
            HelpCenterPresenter.this.internalRetryActions.add(new RetryAction() {
                public void onRetry() {
                    ViewSafeRetryZendeskCallback.this.onError(aVar);
                }
            });
        }

        public void onSuccess(final List<SearchArticle> list) {
            if (HelpCenterPresenter.this.view != null) {
                HelpCenterPresenter.this.view.hideLoadingState();
                HelpCenterPresenter.this.view.showSearchResults(list, this.query);
                if (HelpCenterPresenter.this.shouldShowContactUsButton()) {
                    HelpCenterPresenter.this.view.showContactUsButton();
                    return;
                }
                return;
            }
            HelpCenterPresenter.this.internalRetryActions.add(new RetryAction() {
                public void onRetry() {
                    ViewSafeRetryZendeskCallback.this.onSuccess((List<SearchArticle>) list);
                }
            });
        }
    }

    public HelpCenterPresenter(HelpCenterMvp$View helpCenterMvp$View, HelpCenterMvp$Model helpCenterMvp$Model, NetworkInfoProvider networkInfoProvider2, ActionHandlerRegistry actionHandlerRegistry2) {
        this.view = helpCenterMvp$View;
        this.model = helpCenterMvp$Model;
        this.networkInfoProvider = networkInfoProvider2;
        this.actionHandlerRegistry = actionHandlerRegistry2;
    }

    private void invokeRetryActions() {
        for (RetryAction onRetry : this.internalRetryActions) {
            onRetry.onRetry();
        }
        this.internalRetryActions.clear();
    }

    public void init(HelpCenterConfiguration helpCenterConfiguration, List<c> list) {
        this.config = helpCenterConfiguration;
        this.engines = list;
        this.view.showLoadingState();
        this.model.getSettings(new ZendeskCallback<HelpCenterSettings>() {
            public void onError(a aVar) {
                Logger.d(HelpCenterActivity.LOG_TAG, "Failed to get mobile settings. Cannot determine start screen.", new Object[0]);
                Logger.e(HelpCenterActivity.LOG_TAG, aVar);
                if (HelpCenterPresenter.this.view != null) {
                    HelpCenterPresenter.this.view.hideLoadingState();
                    HelpCenterPresenter.this.view.exitActivity();
                    return;
                }
                HelpCenterPresenter.this.internalRetryActions.add(new RetryAction() {
                    public void onRetry() {
                        HelpCenterPresenter.this.view.hideLoadingState();
                        HelpCenterPresenter.this.view.exitActivity();
                    }
                });
            }

            public void onSuccess(HelpCenterSettings helpCenterSettings) {
                if (HelpCenterPresenter.this.view != null) {
                    HelpCenterPresenter.this.view.hideLoadingState();
                } else {
                    HelpCenterPresenter.this.internalRetryActions.add(new RetryAction() {
                        public void onRetry() {
                            HelpCenterPresenter.this.view.hideLoadingState();
                        }
                    });
                }
                HelpCenterSettings unused = HelpCenterPresenter.this.helpCenterSettings = helpCenterSettings;
                if (helpCenterSettings.isEnabled()) {
                    Logger.b(HelpCenterActivity.LOG_TAG, "Help center is enabled. starting with Help Center", new Object[0]);
                    if (HelpCenterPresenter.this.view != null) {
                        HelpCenterPresenter.this.view.showHelp(HelpCenterPresenter.this.config);
                    } else {
                        HelpCenterPresenter.this.internalRetryActions.add(new RetryAction() {
                            public void onRetry() {
                                HelpCenterPresenter.this.view.showHelp(HelpCenterPresenter.this.config);
                            }
                        });
                    }
                    if (HelpCenterPresenter.this.shouldShowContactUsButton()) {
                        Logger.b(HelpCenterActivity.LOG_TAG, "Saved instance states that we should show the contact FAB", new Object[0]);
                        if (HelpCenterPresenter.this.view != null) {
                            HelpCenterPresenter.this.view.showContactUsButton();
                        } else {
                            HelpCenterPresenter.this.internalRetryActions.add(new RetryAction() {
                                public void onRetry() {
                                    HelpCenterPresenter.this.view.showContactUsButton();
                                }
                            });
                        }
                    }
                } else {
                    Logger.b(HelpCenterActivity.LOG_TAG, "Help center is disabled", new Object[0]);
                    if (HelpCenterPresenter.this.actionHandlerRegistry.handlerByAction("action_conversation_list") != null) {
                        Logger.b(HelpCenterActivity.LOG_TAG, "Starting with conversations", new Object[0]);
                        if (HelpCenterPresenter.this.view != null) {
                            HelpCenterPresenter.this.view.showRequestList();
                            HelpCenterPresenter.this.view.exitActivity();
                            return;
                        }
                        HelpCenterPresenter.this.internalRetryActions.add(new RetryAction() {
                            public void onRetry() {
                                HelpCenterPresenter.this.view.showRequestList();
                                HelpCenterPresenter.this.view.exitActivity();
                            }
                        });
                    } else if (HelpCenterPresenter.this.actionHandlerRegistry.handlerByAction("action_contact_option") != null) {
                        Logger.b(HelpCenterActivity.LOG_TAG, "Starting with contact", new Object[0]);
                        if (HelpCenterPresenter.this.view != null) {
                            HelpCenterPresenter.this.view.showContactZendesk();
                            HelpCenterPresenter.this.view.exitActivity();
                            return;
                        }
                        HelpCenterPresenter.this.internalRetryActions.add(new RetryAction() {
                            public void onRetry() {
                                HelpCenterPresenter.this.view.showContactZendesk();
                                HelpCenterPresenter.this.view.exitActivity();
                            }
                        });
                    } else {
                        Logger.b(HelpCenterActivity.LOG_TAG, "Support SDK is not present, nothing to fall back to. Closing Activity.", new Object[0]);
                        if (HelpCenterPresenter.this.view != null) {
                            HelpCenterPresenter.this.view.exitActivity();
                        } else {
                            HelpCenterPresenter.this.internalRetryActions.add(new RetryAction() {
                                public void onRetry() {
                                    HelpCenterPresenter.this.view.exitActivity();
                                }
                            });
                        }
                    }
                }
            }
        });
    }

    public void onErrorWithRetry(final HelpCenterMvp$ErrorType helpCenterMvp$ErrorType, final RetryAction retryAction) {
        HelpCenterMvp$View helpCenterMvp$View = this.view;
        if (helpCenterMvp$View == null) {
            this.internalRetryActions.add(new RetryAction() {
                public void onRetry() {
                    if (HelpCenterPresenter.this.view != null && HelpCenterPresenter.this.view.isShowingHelp()) {
                        HelpCenterPresenter.this.view.hideLoadingState();
                        HelpCenterPresenter.this.view.showLoadArticleErrorWithRetry(helpCenterMvp$ErrorType, retryAction);
                    }
                }
            });
        } else if (helpCenterMvp$View.isShowingHelp()) {
            this.view.hideLoadingState();
            this.view.showLoadArticleErrorWithRetry(helpCenterMvp$ErrorType, retryAction);
        }
    }

    public void onLoad() {
        if (shouldShowContactUsButton()) {
            HelpCenterMvp$View helpCenterMvp$View = this.view;
            if (helpCenterMvp$View != null) {
                helpCenterMvp$View.showContactUsButton();
            } else {
                this.internalRetryActions.add(new RetryAction() {
                    public void onRetry() {
                        HelpCenterPresenter.this.view.showContactUsButton();
                    }
                });
            }
        }
        HelpCenterMvp$View helpCenterMvp$View2 = this.view;
        if (helpCenterMvp$View2 != null) {
            helpCenterMvp$View2.announceContentLoaded();
        }
    }

    public void onNetworkAvailable() {
        Logger.b(HelpCenterActivity.LOG_TAG, "Network is available.", new Object[0]);
        if (!this.networkPreviouslyUnavailable) {
            Logger.b(HelpCenterActivity.LOG_TAG, "Network was not previously unavailable, no need to dismiss Snackbar", new Object[0]);
            return;
        }
        this.networkPreviouslyUnavailable = false;
        HelpCenterMvp$View helpCenterMvp$View = this.view;
        if (helpCenterMvp$View != null) {
            helpCenterMvp$View.setSearchEnabled(true);
            this.view.dismissError();
            return;
        }
        this.internalRetryActions.add(new RetryAction() {
            public void onRetry() {
                HelpCenterPresenter.this.view.dismissError();
            }
        });
    }

    public void onNetworkUnavailable() {
        Logger.b(HelpCenterActivity.LOG_TAG, "Network is unavailable.", new Object[0]);
        this.networkPreviouslyUnavailable = true;
        HelpCenterMvp$View helpCenterMvp$View = this.view;
        if (helpCenterMvp$View != null) {
            helpCenterMvp$View.setSearchEnabled(false);
            this.view.showNoConnectionError();
            this.view.hideLoadingState();
        }
    }

    public void onPause() {
        this.view = null;
        this.networkInfoProvider.removeNetworkAwareListener(NETWORK_AWARE_ID);
        this.networkInfoProvider.removeRetryAction(RETRY_ACTION_ID);
        this.networkInfoProvider.unregister();
    }

    public void onResume(HelpCenterMvp$View helpCenterMvp$View) {
        this.view = helpCenterMvp$View;
        this.networkInfoProvider.addNetworkAwareListener(NETWORK_AWARE_ID, this);
        this.networkInfoProvider.register();
        if (!this.networkInfoProvider.isNetworkAvailable()) {
            helpCenterMvp$View.showNoConnectionError();
            helpCenterMvp$View.hideLoadingState();
            this.networkPreviouslyUnavailable = true;
        }
        invokeRetryActions();
    }

    public void onSearchSubmit(final String str) {
        if (this.networkInfoProvider.isNetworkAvailable()) {
            this.view.dismissError();
            this.view.showLoadingState();
            this.view.clearSearchResults();
            this.model.search(this.config.getCategoryIds(), this.config.getSectionIds(), str, this.config.getLabelNames(), new ViewSafeRetryZendeskCallback(str));
            return;
        }
        this.networkInfoProvider.addRetryAction(RETRY_ACTION_ID, new RetryAction() {
            public void onRetry() {
                HelpCenterPresenter.this.onSearchSubmit(str);
            }
        });
    }

    public boolean shouldShowContactUsButton() {
        boolean z11 = this.actionHandlerRegistry.handlerByAction("action_contact_option") != null;
        boolean i11 = mz.a.i(this.engines);
        if (!this.config.isContactUsButtonVisible() || (!z11 && !i11)) {
            return false;
        }
        return true;
    }

    public boolean shouldShowConversationsMenuItem() {
        return this.actionHandlerRegistry.handlerByAction("action_conversation_list") != null && this.config.isShowConversationsMenuButton();
    }

    public boolean shouldShowSearchMenuItem() {
        HelpCenterSettings helpCenterSettings2 = this.helpCenterSettings;
        return helpCenterSettings2 != null && helpCenterSettings2.isEnabled();
    }
}
