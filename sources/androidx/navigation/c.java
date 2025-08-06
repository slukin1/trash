package androidx.navigation;

import d10.l;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class c {
    public static final List<String> a(Map<String, NavArgument> map, l<? super String, Boolean> lVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            NavArgument navArgument = (NavArgument) next.getValue();
            boolean z11 = false;
            if (navArgument != null && !navArgument.c() && !navArgument.b()) {
                z11 = true;
            }
            if (z11) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        Set keySet = linkedHashMap.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object next2 : keySet) {
            if (lVar.invoke((String) next2).booleanValue()) {
                arrayList.add(next2);
            }
        }
        return arrayList;
    }
}
