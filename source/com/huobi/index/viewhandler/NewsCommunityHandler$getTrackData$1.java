package com.huobi.index.viewhandler;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.x;
import tg.r;

public final class NewsCommunityHandler$getTrackData$1 extends HashMap<String, Object> {
    public NewsCommunityHandler$getTrackData$1(CommunityFeedInfo.ListBean listBean) {
        String J = r.x().J();
        put("uid", (J == null || x.b(J, "")) ? "0" : J);
        put("state", 1);
        String str = null;
        put("title", listBean != null ? listBean.getTitle() : null);
        put("communityId", String.valueOf(listBean != null ? Integer.valueOf(listBean.getId()) : null));
        put("type", String.valueOf(listBean != null ? Integer.valueOf(listBean.getType()) : null));
        put("praiseNum", String.valueOf(listBean != null ? Integer.valueOf(listBean.getPraiseNum()) : null));
        put("commentNum", String.valueOf(listBean != null ? Integer.valueOf(listBean.getCommentNum()) : null));
        put("timestamp", Long.valueOf(System.currentTimeMillis()));
        put("recom_base_info", String.valueOf(listBean != null ? listBean.getRecom_base_info() : str));
    }

    public final /* bridge */ boolean containsKey(Object obj) {
        if (!(obj == null ? true : obj instanceof String)) {
            return false;
        }
        return containsKey((String) obj);
    }

    public final /* bridge */ Set<Map.Entry<String, Object>> entrySet() {
        return getEntries();
    }

    public final /* bridge */ Object get(Object obj) {
        if (!(obj == null ? true : obj instanceof String)) {
            return null;
        }
        return get((String) obj);
    }

    public /* bridge */ Set<Map.Entry<String, Object>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj == null ? true : obj instanceof String) ? obj2 : getOrDefault((String) obj, obj2);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Object> getValues() {
        return super.values();
    }

    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    public final /* bridge */ Object remove(Object obj) {
        if (!(obj == null ? true : obj instanceof String)) {
            return null;
        }
        return remove((String) obj);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public final /* bridge */ Collection<Object> values() {
        return getValues();
    }

    public /* bridge */ boolean containsKey(String str) {
        return super.containsKey(str);
    }

    public /* bridge */ Object get(String str) {
        return super.get(str);
    }

    public /* bridge */ Object getOrDefault(String str, Object obj) {
        return super.getOrDefault(str, obj);
    }

    public /* bridge */ Object remove(String str) {
        return super.remove(str);
    }

    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if (!(obj == null ? true : obj instanceof String)) {
            return false;
        }
        return remove((String) obj, obj2);
    }

    public /* bridge */ boolean remove(String str, Object obj) {
        return super.remove(str, obj);
    }
}
