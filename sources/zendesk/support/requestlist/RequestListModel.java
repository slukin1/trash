package zendesk.support.requestlist;

import com.zendesk.service.ZendeskCallback;
import java.util.List;
import jz.a;
import zendesk.core.MemoryCache;
import zendesk.support.AggregatedCallback;
import zendesk.support.SupportBlipsProvider;
import zendesk.support.SupportSdkSettings;
import zendesk.support.SupportSettingsProvider;

class RequestListModel {
    public static final String REQUEST_LIST_ITEMS_CACHE_KEY = "request_list_items";
    public static final String SETTINGS_CACHE_KEY = "request_list_settings";
    private final SupportBlipsProvider blipsProvider;
    /* access modifiers changed from: private */
    public final MemoryCache cache;
    /* access modifiers changed from: private */
    public final a<RequestInfo, RequestListItem> mapper = new a<RequestInfo, RequestListItem>() {
        public RequestListItem apply(RequestInfo requestInfo) {
            return new RequestListItem(requestInfo);
        }
    };
    private final RequestInfoDataSource requestInfoDataSource;
    private final AggregatedCallback<SupportSdkSettings> settingsAggregatedCallback = new AggregatedCallback<>();
    private final SupportSettingsProvider settingsProvider;

    public RequestListModel(RequestInfoDataSource requestInfoDataSource2, MemoryCache memoryCache, SupportBlipsProvider supportBlipsProvider, SupportSettingsProvider supportSettingsProvider) {
        this.requestInfoDataSource = requestInfoDataSource2;
        this.cache = memoryCache;
        this.blipsProvider = supportBlipsProvider;
        this.settingsProvider = supportSettingsProvider;
    }

    /* access modifiers changed from: private */
    public List<RequestInfo> filterClosedRequests(List<RequestInfo> list, boolean z11) {
        return z11 ? list : mz.a.f(list, new a<RequestInfo, Boolean>() {
            public Boolean apply(RequestInfo requestInfo) {
                return Boolean.valueOf(!requestInfo.isClosed());
            }
        });
    }

    public void cacheSupportSdkSettings(SupportSdkSettings supportSdkSettings) {
        this.cache.put(SETTINGS_CACHE_KEY, supportSdkSettings);
    }

    public void cleanup() {
        this.cache.remove(SETTINGS_CACHE_KEY);
        this.cache.remove(REQUEST_LIST_ITEMS_CACHE_KEY);
    }

    public List<RequestListItem> getCachedRequestInfos() {
        return (List) this.cache.get(REQUEST_LIST_ITEMS_CACHE_KEY);
    }

    public SupportSdkSettings getCachedSettings() {
        return (SupportSdkSettings) this.cache.get(SETTINGS_CACHE_KEY);
    }

    public void loadItems(boolean z11, final SupportSdkSettings supportSdkSettings, final ZendeskCallback<List<RequestListItem>> zendeskCallback) {
        if (z11 || getCachedRequestInfos() == null) {
            this.requestInfoDataSource.load(new ZendeskCallback<List<RequestInfo>>() {
                public void onError(lz.a aVar) {
                    zendeskCallback.onError(aVar);
                }

                public void onSuccess(List<RequestInfo> list) {
                    List k11 = mz.a.k(RequestListModel.this.filterClosedRequests(list, supportSdkSettings.isShowClosedRequests()), RequestListModel.this.mapper);
                    RequestListModel.this.cache.put(RequestListModel.REQUEST_LIST_ITEMS_CACHE_KEY, k11);
                    zendeskCallback.onSuccess(k11);
                }
            });
        } else {
            zendeskCallback.onSuccess(getCachedRequestInfos());
        }
    }

    public void loadSettings(ZendeskCallback<SupportSdkSettings> zendeskCallback) {
        if (this.settingsAggregatedCallback.add(zendeskCallback)) {
            this.settingsProvider.getSettings(this.settingsAggregatedCallback);
        }
    }

    public void trackRequestListViewed() {
        this.blipsProvider.requestListViewed();
    }
}
