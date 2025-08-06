package com.huochat.community.network;

import com.hbg.lib.common.BaseApplication;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huochat.community.base.CommunityConstants;
import com.huochat.community.enums.SymbolParamType;
import com.huochat.community.model.CommentsResultBean;
import com.huochat.community.model.CommunityItemBean;
import com.huochat.community.model.CommunityResultBean;
import com.huochat.community.model.TopicDetailBean;
import com.huochat.community.network.service.CommunityService;
import d9.a;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.r;

public final class CommunityApiManager {
    public static final Companion Companion = new Companion((r) null);
    /* access modifiers changed from: private */
    public static final CommunityApiManager instance = new CommunityApiManager();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final CommunityApiManager getInstance() {
            return CommunityApiManager.instance;
        }
    }

    private CommunityApiManager() {
        CommunityRetrofit.INSTANCE.init("community", BaseApplication.b(), new CommunityIntercepter());
    }

    public final HashMap<String, Object> createRequestParams() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, UUID.randomUUID().toString() + "_global");
        hashMap.put("transid", UUID.randomUUID().toString() + "_global");
        return hashMap;
    }

    public final a<CommentsResultBean> getCommunityCommentList(String str, int i11, Long l11, int i12) {
        HashMap<String, Object> createRequestParams = createRequestParams();
        createRequestParams.put(CommunityConstants.REQUEST_KEY_MID, str);
        createRequestParams.put("startIndex", Integer.valueOf(i11));
        createRequestParams.put(CommunityConstants.PAGE_SIZE, Integer.valueOf(i12));
        createRequestParams.put(CommunityConstants.SECOND_COMEMT_TYPE, "0");
        createRequestParams.put(CommunityConstants.LAST_POST_TIME, l11);
        CommunityRetrofit communityRetrofit = CommunityRetrofit.INSTANCE;
        return new a<>(((CommunityService) communityRetrofit.request(CommunityService.class)).getCommunityCommentList(createRequestParams).compose(communityRetrofit.responseTransformer()));
    }

    public final a<CommunityItemBean> getCommunityDynamicDetail(String str, SymbolParamType symbolParamType, String str2) {
        HashMap<String, Object> createRequestParams = createRequestParams();
        createRequestParams.put(CommunityConstants.COMMUNITY_SYMBOL, str);
        createRequestParams.put(CommunityConstants.SYMBOL_TYPE, Integer.valueOf(symbolParamType.getType()));
        createRequestParams.put(CommunityConstants.REQUEST_KEY_MID, str2);
        createRequestParams.put(CommunityConstants.COMMENT_PAGE_SIZE, 20);
        createRequestParams.put(CommunityConstants.SECOND_COMEMT_TYPE, "0");
        CommunityRetrofit communityRetrofit = CommunityRetrofit.INSTANCE;
        return new a<>(((CommunityService) communityRetrofit.request(CommunityService.class)).getCommunityDynamicDetail(createRequestParams).compose(communityRetrofit.responseTransformer()));
    }

    public final a<CommunityResultBean> getCommunityListbySymbol(String str, SymbolParamType symbolParamType, int i11, Long l11, int i12) {
        HashMap<String, Object> createRequestParams = createRequestParams();
        createRequestParams.put(CommunityConstants.COMMUNITY_SYMBOL, str);
        createRequestParams.put(CommunityConstants.SYMBOL_TYPE, Integer.valueOf(symbolParamType.getType()));
        createRequestParams.put("startIndex", Integer.valueOf(i11));
        createRequestParams.put(CommunityConstants.PAGE_SIZE, 20);
        createRequestParams.put(CommunityConstants.LAST_POST_TIME, l11);
        createRequestParams.put(CommunityConstants.QUERY_SORT_TYPE, Integer.valueOf(i12));
        CommunityRetrofit communityRetrofit = CommunityRetrofit.INSTANCE;
        return new a<>(((CommunityService) communityRetrofit.request(CommunityService.class)).getCommunityListbySymbol(createRequestParams).compose(communityRetrofit.responseTransformer()));
    }

    public final a<TopicDetailBean> getMomentListByTopic(String str, String str2, int i11, Long l11) {
        HashMap<String, Object> createRequestParams = createRequestParams();
        createRequestParams.put("startIndex", Integer.valueOf(i11));
        createRequestParams.put(CommunityConstants.PAGE_SIZE, 20);
        createRequestParams.put("markTime", l11);
        createRequestParams.put(CommunityConstants.TOPIC_NAME, str);
        createRequestParams.put("topicNameForSearch", str2);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : createRequestParams.entrySet()) {
            if (next.getValue() != null) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        CommunityRetrofit communityRetrofit = CommunityRetrofit.INSTANCE;
        return new a<>(((CommunityService) communityRetrofit.request(CommunityService.class)).getMomentListByTopic(linkedHashMap).compose(communityRetrofit.responseTransformer()));
    }
}
