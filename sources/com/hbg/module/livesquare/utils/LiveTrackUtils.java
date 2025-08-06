package com.hbg.module.livesquare.utils;

import cn.sharesdk.framework.InnerShareParams;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import i6.d;
import java.util.HashMap;
import nc.c;

public class LiveTrackUtils {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, Object> f26664a;

    public static synchronized void a(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        synchronized (LiveTrackUtils.class) {
            if (f26664a == null) {
                f26664a = new HashMap<>();
            }
            f26664a.clear();
            f26664a.put("state", obj);
            f26664a.put("liveid", obj2);
            f26664a.put(InnerShareParams.SITE, obj3);
            f26664a.put("live_num", obj4);
            c.a(str, f26664a);
            d.i("hblivetrack ***** name:" + str + "  value:" + f26664a.toString());
        }
    }

    public static synchronized void b(Object obj) {
        synchronized (LiveTrackUtils.class) {
            if (f26664a == null) {
                f26664a = new HashMap<>();
            }
            f26664a.clear();
            f26664a.put(VineCardUtils.PLAYER_CARD, 2);
            f26664a.put("groupid", obj);
            c.a("APP_LIVE_group_invitation", f26664a);
            d.i("hblivetrack ***** name:APP_LIVE_group_invitation  value:" + f26664a.toString());
        }
    }

    public static synchronized void c(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        synchronized (LiveTrackUtils.class) {
            if (f26664a == null) {
                f26664a = new HashMap<>();
            }
            f26664a.clear();
            f26664a.put("state", obj);
            f26664a.put("liveid", obj2);
            f26664a.put(VineCardUtils.PLAYER_CARD, 2);
            f26664a.put("title", obj3);
            f26664a.put("upid", obj4);
            f26664a.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, obj5);
            c.a(str, f26664a);
            d.i("hblivetrack ***** name:" + str + "  value:" + f26664a.toString());
        }
    }

    public static synchronized void d(Object obj, Object obj2, Object obj3, Object obj4) {
        synchronized (LiveTrackUtils.class) {
            if (f26664a == null) {
                f26664a = new HashMap<>();
            }
            f26664a.clear();
            f26664a.put("state", obj);
            f26664a.put("liveid", obj2);
            f26664a.put(VineCardUtils.PLAYER_CARD, 2);
            f26664a.put("title", obj3);
            f26664a.put("upid", obj4);
            c.a("APP_LIVE_notice_share", f26664a);
            d.i("hblivetrack ***** name:APP_LIVE_group_invitation  value:" + f26664a.toString());
        }
    }

    public static synchronized void e(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        synchronized (LiveTrackUtils.class) {
            if (f26664a == null) {
                f26664a = new HashMap<>();
            }
            f26664a.clear();
            f26664a.put("state", obj);
            f26664a.put("liveid", obj2);
            f26664a.put(VineCardUtils.PLAYER_CARD, 2);
            f26664a.put("title", obj3);
            f26664a.put("upid", obj4);
            f26664a.put("success", obj5);
            c.a(str, f26664a);
            d.i("hblivetrack ***** name:" + str + "  value:" + f26664a.toString());
        }
    }

    public static synchronized void f(String str) {
        synchronized (LiveTrackUtils.class) {
            if (f26664a == null) {
                f26664a = new HashMap<>();
            }
            f26664a.clear();
            f26664a.put("state", (Object) null);
            f26664a.put("liveid", (Object) null);
            f26664a.put(VineCardUtils.PLAYER_CARD, 1);
            f26664a.put("title", (Object) null);
            f26664a.put("upid", (Object) null);
            f26664a.put("success", (Object) null);
            c.a(str, f26664a);
            d.i("hblivetrack ***** name:" + str + "  value:" + f26664a.toString());
        }
    }

    public static synchronized void g(String str, Object obj, Object obj2, Object obj3) {
        synchronized (LiveTrackUtils.class) {
            if (f26664a == null) {
                f26664a = new HashMap<>();
            }
            f26664a.clear();
            f26664a.put("liveid", obj);
            f26664a.put("title", obj2);
            f26664a.put("upid", obj3);
            c.a(str, f26664a);
            d.i("hblivetrack ***** name:" + str + "  value:" + f26664a.toString());
        }
    }

    public static synchronized void h(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        synchronized (LiveTrackUtils.class) {
            if (f26664a == null) {
                f26664a = new HashMap<>();
            }
            f26664a.clear();
            f26664a.put("state", obj);
            f26664a.put("liveid", obj2);
            f26664a.put(VineCardUtils.PLAYER_CARD, 2);
            f26664a.put("title", obj3);
            f26664a.put("upid", obj4);
            c.a(str, f26664a);
            d.i("hblivetrack ***** name:" + str + "  value:" + f26664a.toString());
        }
    }
}
