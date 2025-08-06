package com.huochat.community.base;

import kotlin.jvm.internal.r;

public final class CommunityConstants {
    public static final String BASE_SERVER_URL = "https://api.huotalk.com";
    public static final String BASE_SERVER_URL_DEBUG = "https://api-test.huotalk.com";
    public static final int CIRCLE_IS_TRUE = 1;
    public static final String COMMENT_LEVEL_ONE = "0";
    public static final String COMMENT_PAGE_SIZE = "commentPageSize";
    public static final String COMMUNITY_SDK_CHANNEL = "Huobi";
    public static final String COMMUNITY_SDK_VERSION = "1.0.0";
    public static final int COMMUNITY_SPECIAL = 2;
    public static final String COMMUNITY_SYMBOL = "communitySymbol";
    public static final Companion Companion = new Companion((r) null);
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int DEFAULT_START_INDEX = -1;
    public static final String EXTRA_ARGS_PAGE_THEME = "communityPageTheme";
    public static final String GET_MOMENT_COMMENT_LIST = "/community/comment/getMomentCommentList";
    public static final String GET_MOMENT_DETAIL = "/community/moment/getMomentDetail";
    public static final String GET_MOMENT_LIST_BYCOMMUNITY = "/community/moment/getMomentListByCommunity";
    public static final String GLOBAL_GET_MOMENT_COMMENT_LIST = "/community/global/comment/getMomentCommentList";
    public static final String GLOBAL_GET_MOMENT_DETAIL = "/community/global/moment/getMomentDetail";
    public static final String GLOBAL_GET_MOMENT_LIST_BYCOMMUNITY = "/community/global/moment/getMomentListByCommunity";
    public static final String GLOBAL_GET_MOMENT_LIST_BY_TOPIC = "/community/global/topic/getMomentListByTopic";
    public static final String HUOBICHAT_OFFICIAL_WEBSITE = "https://www.huotalk.com?&from=huobi";
    public static final String HUOBICHAT_OFFICIAL_WEBSITE_DEBUG = "https://www.huotalk.com?&from=huobi";
    public static final String HUOBICHAT_URL_SCHEME = "huobichat://hx:80/splash";
    public static final String IS_OPEN_COMMENT_DIALOG = "IS_OPEN_COMMENT_DIALOG";
    public static final String KEY_CIRCLE_DETAIL = "KEY_CIRCLE_DETAIL";
    public static final String LAST_ID = "lastId";
    public static final String LAST_MID = "lastMid";
    public static final String LAST_POST_TIME = "lastPostTime";
    public static final String PAGE_SIZE = "pageSize";
    public static final String QUERY_SORT_TYPE = "queryType";
    public static final String REQUEST_KEY_LINE = "like";
    public static final String REQUEST_KEY_MID = "mid";
    public static final String SECOND_COMEMT_TYPE = "secondComemtType";
    public static final String START_INDEX = "startIndex";
    public static final String SYMBOL_TYPE = "symbolType";
    public static final String TOPIC_ID = "topicId";
    public static final String TOPIC_NAME = "topicName";
    public static final int VALUE_PRAISE_OPERATOR_LIKE = 1;
    public static final int VALUE_PRAISE_OPERATOR_UNLIKE = 0;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }
}
