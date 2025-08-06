package zendesk.support.requestlist;

import android.view.View;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zendesk.service.ZendeskCallback;
import java.util.List;
import lz.a;
import lz.d;
import zendesk.support.SupportSdkSettings;
import zendesk.support.request.RequestActivity;
import zendesk.support.requestlist.RequestListView;

class RequestListPresenter {
    private final CancelableCompositeCallback callbacks = new CancelableCompositeCallback();
    /* access modifiers changed from: private */
    public final RequestListModel model;
    /* access modifiers changed from: private */
    public RequestListView view;

    public interface SettingsCallback {
        void onSettings(SupportSdkSettings supportSdkSettings);
    }

    public RequestListPresenter(RequestListModel requestListModel) {
        this.model = requestListModel;
    }

    private void fetchSettingsFromNetwork(final SettingsCallback settingsCallback) {
        d a11 = d.a(new ZendeskCallback<SupportSdkSettings>() {
            public void onError(a aVar) {
                settingsCallback.onSettings((SupportSdkSettings) null);
                if (RequestListPresenter.this.view != null) {
                    RequestListPresenter.this.view.finish("Conversations are disabled in sdk settings, closing the request list screen!");
                }
            }

            public void onSuccess(SupportSdkSettings supportSdkSettings) {
                RequestListPresenter.this.model.cacheSupportSdkSettings(supportSdkSettings);
                settingsCallback.onSettings(supportSdkSettings);
            }
        });
        this.callbacks.add(a11);
        this.view.setLoading(true);
        this.model.loadSettings(a11);
    }

    private void loadSettings(SettingsCallback settingsCallback) {
        SupportSdkSettings cachedSettings = this.model.getCachedSettings();
        if (cachedSettings == null) {
            fetchSettingsFromNetwork(settingsCallback);
        } else {
            settingsCallback.onSettings(cachedSettings);
        }
    }

    private void setupCreateTicketClickListener() {
        this.view.setCreateRequestListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                RequestListPresenter.this.view.startRequestActivity(RequestActivity.builder());
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    private void setupErrorClickListener() {
        this.view.setRetryClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                RequestListPresenter.this.refresh();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    private void setupItemClickListener() {
        this.view.setItemClickListener(new RequestListView.OnItemClick() {
            public void onClick(RequestListItem requestListItem) {
                RequestListPresenter.this.view.startRequestActivity(requestListItem.configure(RequestActivity.builder()));
            }
        });
    }

    /* access modifiers changed from: private */
    public void setupLogoView(final RequestListView requestListView, boolean z11, final String str) {
        requestListView.setLogoClickListener(z11, new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                requestListView.startReferrerPage(str);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    private void setupNavigationClickListener() {
        this.view.setBackClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                RequestListPresenter.this.view.finish();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    private void setupPullToRefreshListener() {
        this.view.setSwipeRefreshListener(new SwipeRefreshLayout.j() {
            public void onRefresh() {
                RequestListPresenter.this.refresh();
            }
        });
    }

    public void loadItems(boolean z11, SupportSdkSettings supportSdkSettings) {
        AnonymousClass3 r02 = new ZendeskCallback<List<RequestListItem>>() {
            public void onError(a aVar) {
                RequestListPresenter.this.showError(aVar);
            }

            public void onSuccess(List<RequestListItem> list) {
                RequestListPresenter.this.showRequestList(list);
            }
        };
        this.callbacks.add(d.a(r02));
        this.view.setLoading(true);
        this.model.loadItems(z11, supportSdkSettings, r02);
    }

    public void onCreate(final boolean z11, RequestListView requestListView) {
        this.view = requestListView;
        setupItemClickListener();
        setupPullToRefreshListener();
        setupNavigationClickListener();
        setupErrorClickListener();
        setupCreateTicketClickListener();
        loadSettings(new SettingsCallback() {
            public void onSettings(SupportSdkSettings supportSdkSettings) {
                if (supportSdkSettings != null && supportSdkSettings.isConversationsEnabled()) {
                    RequestListPresenter requestListPresenter = RequestListPresenter.this;
                    requestListPresenter.setupLogoView(requestListPresenter.view, supportSdkSettings.isShowReferrerLogoEnabled(), supportSdkSettings.getReferrerUrl());
                    RequestListPresenter.this.loadItems(z11, supportSdkSettings);
                    if (z11) {
                        RequestListPresenter.this.model.trackRequestListViewed();
                    }
                } else if (RequestListPresenter.this.view != null) {
                    RequestListPresenter.this.view.finish("Conversations are disabled in sdk settings, closing the request list screen!");
                }
            }
        });
    }

    public void onDestroy(boolean z11) {
        if (!z11) {
            this.model.cleanup();
        }
        this.view = null;
        this.callbacks.cancel();
    }

    public void refresh() {
        loadSettings(new SettingsCallback() {
            public void onSettings(SupportSdkSettings supportSdkSettings) {
                if (supportSdkSettings != null && supportSdkSettings.isConversationsEnabled()) {
                    RequestListPresenter.this.loadItems(true, supportSdkSettings);
                } else if (RequestListPresenter.this.view != null) {
                    RequestListPresenter.this.view.finish("Conversations are disabled in sdk settings, closing the request list screen!");
                }
            }
        });
    }

    public void showError(a aVar) {
        RequestListView requestListView = this.view;
        if (requestListView != null) {
            requestListView.setLoading(false);
            this.view.showErrorMessage();
        }
    }

    public void showRequestList(List<RequestListItem> list) {
        RequestListView requestListView = this.view;
        if (requestListView != null) {
            requestListView.showRequestList(list);
            this.view.setLoading(false);
        }
    }
}
