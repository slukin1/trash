package com.tencent.liteav.txcvodplayer.b;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a {

    /* renamed from: com.tencent.liteav.txcvodplayer.b.a$a  reason: collision with other inner class name */
    public static class C0171a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f21877a = new a((byte) 0);
    }

    public interface b {
        void a();

        void a(String str, Map<String, String> map);
    }

    public /* synthetic */ a(byte b11) {
        this();
    }

    public static /* synthetic */ Map a(Map map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                hashMap.put(entry.getKey(), ((List) entry.getValue()).get(0));
            }
        }
        return hashMap;
    }

    private a() {
    }
}
