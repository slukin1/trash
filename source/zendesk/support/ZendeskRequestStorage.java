package zendesk.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import mz.a;
import zendesk.core.BaseStorage;
import zendesk.core.MemoryCache;

class ZendeskRequestStorage implements RequestStorage {
    private static final long HOUR_IN_MILLIS = TimeUnit.HOURS.toMillis(1);
    private static final String LOG_TAG = "ZendeskRequestStorage";
    private static final String MEMORY_CACHE_MIGRATED_KEY = "zendesk_request_storage_memory_cache_migrated_flag";
    private static final String REQUESTS_DATA_KEY = "zendesk_request_storage_request_data_list";
    private static final String TIMESTAMP_KEY = "zendesk_request_storage_requests_data_cache_time";
    private final Object lock = new Object();
    private final MemoryCache memoryCache;
    private final RequestMigrator requestMigrator;
    private final BaseStorage storage;

    public ZendeskRequestStorage(BaseStorage baseStorage, RequestMigrator requestMigrator2, MemoryCache memoryCache2) {
        this.storage = baseStorage;
        this.requestMigrator = requestMigrator2;
        this.memoryCache = memoryCache2;
    }

    private void checkForAndMigrateLegacyRequestData() {
        if (!((Boolean) this.memoryCache.getOrDefault(MEMORY_CACHE_MIGRATED_KEY, Boolean.FALSE)).booleanValue()) {
            List<RequestData> legacyRequests = this.requestMigrator.getLegacyRequests();
            if (a.i(legacyRequests)) {
                storeRequestData(legacyRequests);
                this.requestMigrator.clearLegacyRequestStorage();
                this.memoryCache.put(MEMORY_CACHE_MIGRATED_KEY, Boolean.TRUE);
            }
        }
    }

    private static List<RequestData> updateRequests(List<RequestData> list, List<Request> list2) {
        HashMap hashMap = new HashMap(list.size() + list2.size());
        for (RequestData next : list) {
            hashMap.put(next.getId(), next);
        }
        for (Request next2 : list2) {
            if (hashMap.containsKey(next2.getId())) {
                RequestData requestData = (RequestData) hashMap.get(next2.getId());
                hashMap.put(requestData.getId(), RequestData.create(requestData.getId(), next2.getCommentCount().intValue(), requestData.getReadCommentCount()));
            } else {
                hashMap.put(next2.getId(), RequestData.create(next2));
            }
        }
        return new ArrayList(hashMap.values());
    }

    public List<RequestData> getRequestData() {
        RequestDataList requestDataList;
        checkForAndMigrateLegacyRequestData();
        synchronized (this.lock) {
            requestDataList = (RequestDataList) this.storage.get(REQUESTS_DATA_KEY, RequestDataList.class);
        }
        return requestDataList != null ? requestDataList.requestDataList : new ArrayList(0);
    }

    public boolean isRequestDataExpired() {
        String str;
        long j11;
        synchronized (this.lock) {
            str = this.storage.get(TIMESTAMP_KEY);
        }
        if (str == null) {
            j11 = 0;
        } else {
            j11 = Long.parseLong(str);
        }
        return Math.abs(System.currentTimeMillis() - j11) > HOUR_IN_MILLIS;
    }

    public void markRequestAsRead(String str, int i11) {
        synchronized (this.lock) {
            List<RequestData> requestData = getRequestData();
            ArrayList arrayList = new ArrayList(requestData.size());
            for (RequestData next : requestData) {
                if (str.equals(next.getId())) {
                    arrayList.add(RequestData.create(next.getId(), i11, i11));
                } else {
                    arrayList.add(next);
                }
            }
            storeRequestData(arrayList);
        }
    }

    public void markRequestAsUnread(String str) {
        synchronized (this.lock) {
            List<RequestData> requestData = getRequestData();
            ArrayList arrayList = new ArrayList(requestData.size());
            for (RequestData next : requestData) {
                if (str.equals(next.getId())) {
                    arrayList.add(RequestData.create(str, next.getCommentCount() + 1, next.getReadCommentCount()));
                } else {
                    arrayList.add(next);
                }
            }
            storeRequestData(arrayList);
        }
    }

    public void storeRequestData(List<RequestData> list) {
        if (list != null) {
            synchronized (this.lock) {
                this.storage.put(REQUESTS_DATA_KEY, (Object) new RequestDataList(list));
                this.storage.put(TIMESTAMP_KEY, Long.toString(System.currentTimeMillis()));
            }
        }
    }

    public void updateRequestData(List<Request> list) {
        synchronized (this.lock) {
            storeRequestData(updateRequests(getRequestData(), list));
        }
    }
}
