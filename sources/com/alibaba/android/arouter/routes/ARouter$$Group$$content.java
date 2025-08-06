package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.hbg.module.community.ui.DynamicDetailActivity;
import com.hbg.module.community.ui.FansListActivity;
import com.hbg.module.community.ui.FollowListActivity;
import com.hbg.module.community.ui.PersonalCenterActivity;
import com.hbg.module.community.ui.PostDynamicActivity;
import com.hbg.module.community.ui.TopicDetailActivity;
import com.hbg.module.content.ui.activity.CommentDetailActivity;
import com.hbg.module.content.ui.activity.NewContentActivity;
import java.util.Map;

public class ARouter$$Group$$content implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/content/CommunityPublisher", RouteMeta.build(routeType, PostDynamicActivity.class, "/content/communitypublisher", "content", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/content/DynamicDetail", RouteMeta.build(routeType, DynamicDetailActivity.class, "/content/dynamicdetail", "content", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/content/FansFollowList", RouteMeta.build(routeType, FansListActivity.class, "/content/fansfollowlist", "content", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/content/Index", RouteMeta.build(routeType, NewContentActivity.class, "/content/index", "content", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/content/PersonalCenter", RouteMeta.build(routeType, PersonalCenterActivity.class, "/content/personalcenter", "content", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/content/UserFollowList", RouteMeta.build(routeType, FollowListActivity.class, "/content/userfollowlist", "content", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/content/commentDetail", RouteMeta.build(routeType, CommentDetailActivity.class, "/content/commentdetail", "content", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/content/topicDetail", RouteMeta.build(routeType, TopicDetailActivity.class, "/content/topicdetail", "content", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
