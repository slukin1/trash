package com.hbg.component.kline.render;

import com.hbg.component.kline.render.expandLayer.ExpandItemRender;
import java.util.HashMap;
import java.util.Map;

public class RenderRegister {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, Class> f67295a;

    static {
        HashMap hashMap = new HashMap();
        f67295a = hashMap;
        hashMap.put("CandleStickRender", CandleStickRender.class);
        f67295a.put("TimeLineRender", TimeLineRender.class);
        f67295a.put("ExpandItemRender", ExpandItemRender.class);
    }

    public static Class a(String str) {
        if (b(str)) {
            return f67295a.get(str);
        }
        return null;
    }

    public static boolean b(String str) {
        return f67295a.containsKey(str);
    }
}
