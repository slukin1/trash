package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huochat.community.activity.CommunityDynamicDetailActivity;
import com.huochat.community.activity.TopicSearchTemplateActivity;
import com.huochat.community.base.CommunityRouterConfig;
import com.huochat.community.fragment.FragmentCommunityList;
import java.util.Map;

public class ARouter$$Group$$hbc_community implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        Map<String, RouteMeta> map2 = map;
        RouteType routeType = RouteType.ACTIVITY;
        map2.put(CommunityRouterConfig.ACTIVITY_COMMUNITY_DYNAMIC_DETAIL, RouteMeta.build(routeType, CommunityDynamicDetailActivity.class, "/hbc_community/communitydynamicdetailactivity", "hbc_community", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map2.put("/hbc_community/fragmentcommunitylist", RouteMeta.build(RouteType.FRAGMENT, FragmentCommunityList.class, "/hbc_community/fragmentcommunitylist", "hbc_community", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map2.put(CommunityRouterConfig.ACTIVITY_COMMUNITY_TOPIC_SEARCH_TEMPLATE, RouteMeta.build(routeType, TopicSearchTemplateActivity.class, "/hbc_community/topicsearchtemplate", "hbc_community", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
