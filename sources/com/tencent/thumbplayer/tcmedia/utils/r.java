package com.tencent.thumbplayer.tcmedia.utils;

import com.huochat.community.network.domain.DomainTool;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, Integer> f49740a;

    static {
        HashMap hashMap = new HashMap();
        f49740a = hashMap;
        hashMap.put(DomainTool.DOMAIN_PREFIX_HTTP, 0);
        f49740a.put(DomainTool.DOMAIN_PREFIX, 1);
        f49740a.put("rtmp://", 2);
        f49740a.put("webrtc://", 3);
        f49740a.put("file://", 4);
        f49740a.put("/", 4);
    }

    public static int a(String str) {
        if (str == null) {
            return -1;
        }
        String lowerCase = str.toLowerCase();
        for (Map.Entry next : f49740a.entrySet()) {
            if (lowerCase.startsWith((String) next.getKey())) {
                return ((Integer) next.getValue()).intValue();
            }
        }
        try {
            return new File(str).exists() ? 4 : -1;
        } catch (Exception unused) {
        }
    }
}
