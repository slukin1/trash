package com.huobi.edgeengine.dataparser;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import sj.b;
import sj.c;
import sj.e;
import sj.f;

public class DataParserManager {

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, e> f43960b = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, e> f43961a = new ConcurrentHashMap();

    public boolean a(String str, List<String> list, c cVar) {
        e eVar;
        if (f43960b.containsKey(str) && (eVar = f43960b.get(str)) != null) {
            try {
                eVar.a().a(list, cVar);
                return true;
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        e eVar2 = this.f43961a.get(str);
        if (eVar2 == null) {
            return false;
        }
        try {
            eVar2.a().a(list, cVar);
            return true;
        } catch (Exception e12) {
            e12.printStackTrace();
            return false;
        }
    }

    public void b(String str, Class<? extends f> cls) {
        this.f43961a.put(str, new b(cls));
    }
}
