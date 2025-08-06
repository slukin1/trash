package com.fluttercandies.photo_manager.core.utils;

import com.fluttercandies.photo_manager.constant.AssetType;
import com.fluttercandies.photo_manager.core.entity.FilterCond;
import com.fluttercandies.photo_manager.core.entity.FilterOption;
import com.fluttercandies.photo_manager.core.entity.c;
import com.fluttercandies.photo_manager.core.entity.d;
import com.fluttercandies.photo_manager.core.entity.e;
import com.huobi.vulcan.model.VulcanInfo;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.tencent.android.tpush.common.MessageKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.l;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f65118a = new b();

    public final FilterOption a(Map<?, ?> map) {
        return new FilterOption(map);
    }

    public final List<e> b(List<?> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return CollectionsKt__CollectionsKt.g(new e("_id", false));
        }
        Iterator<?> it2 = list.iterator();
        while (it2.hasNext()) {
            Map map = (Map) it2.next();
            int intValue = ((Integer) map.get("type")).intValue();
            boolean booleanValue = ((Boolean) map.get("asc")).booleanValue();
            String str = intValue != 0 ? intValue != 1 ? null : "date_modified" : "date_added";
            if (str != null) {
                arrayList.add(new e(str, booleanValue));
            }
        }
        return arrayList;
    }

    public final Map<String, Object> c(com.fluttercandies.photo_manager.core.entity.b bVar) {
        HashMap j11 = MapsKt__MapsKt.j(l.a("id", bVar.e()), l.a(IBridgeMediaLoader.COLUMN_DURATION, Long.valueOf(bVar.c() / ((long) 1000))), l.a("type", Integer.valueOf(bVar.m())), l.a("createDt", Long.valueOf(bVar.a())), l.a("width", Integer.valueOf(bVar.o())), l.a("height", Integer.valueOf(bVar.d())), l.a("modifiedDt", Long.valueOf(bVar.i())), l.a(VulcanInfo.LAT, bVar.f()), l.a(VulcanInfo.LNG, bVar.g()), l.a("title", bVar.b()), l.a("relativePath", bVar.l()));
        if (bVar.h() != null) {
            j11.put("mimeType", bVar.h());
        }
        return j11;
    }

    public final Map<String, Object> d(List<com.fluttercandies.photo_manager.core.entity.b> list) {
        ArrayList arrayList = new ArrayList();
        for (com.fluttercandies.photo_manager.core.entity.b next : list) {
            HashMap j11 = MapsKt__MapsKt.j(l.a("id", next.e()), l.a(IBridgeMediaLoader.COLUMN_DURATION, Long.valueOf(next.c() / ((long) 1000))), l.a("type", Integer.valueOf(next.m())), l.a("createDt", Long.valueOf(next.a())), l.a("width", Integer.valueOf(next.o())), l.a("height", Integer.valueOf(next.d())), l.a("orientation", Integer.valueOf(next.j())), l.a("modifiedDt", Long.valueOf(next.i())), l.a(VulcanInfo.LAT, next.f()), l.a(VulcanInfo.LNG, next.g()), l.a("title", next.b()), l.a("relativePath", next.l()));
            if (next.h() != null) {
                j11.put("mimeType", next.h());
            }
            arrayList.add(j11);
        }
        return MapsKt__MapsJVMKt.e(l.a("data", arrayList));
    }

    public final c e(Map<?, ?> map) {
        return new c(Long.parseLong(String.valueOf(map.get(MessageKey.MSG_ACCEPT_TIME_MIN))), Long.parseLong(String.valueOf(map.get("max"))), Boolean.parseBoolean(String.valueOf(map.get("ignore"))));
    }

    public final Map<String, Object> f(List<d> list) {
        ArrayList arrayList = new ArrayList();
        for (d next : list) {
            Map m11 = MapsKt__MapsKt.m(l.a("id", next.a()), l.a("name", next.d()), l.a("length", Integer.valueOf(next.b())), l.a("isAll", Boolean.valueOf(next.e())));
            if (next.c() != null) {
                m11.put("modified", next.c());
            }
            if (next.b() > 0) {
                arrayList.add(m11);
            }
        }
        return MapsKt__MapsJVMKt.e(l.a("data", arrayList));
    }

    public final FilterCond g(Map<?, ?> map) {
        FilterCond filterCond = new FilterCond();
        filterCond.f(((Boolean) map.get("title")).booleanValue());
        Map map2 = (Map) map.get("size");
        FilterCond.SizeConstraint sizeConstraint = new FilterCond.SizeConstraint();
        sizeConstraint.j(((Integer) map2.get("minWidth")).intValue());
        sizeConstraint.h(((Integer) map2.get(ImagePickerCache.MAP_KEY_MAX_WIDTH)).intValue());
        sizeConstraint.i(((Integer) map2.get("minHeight")).intValue());
        sizeConstraint.g(((Integer) map2.get(ImagePickerCache.MAP_KEY_MAX_HEIGHT)).intValue());
        sizeConstraint.f(((Boolean) map2.get("ignoreSize")).booleanValue());
        filterCond.g(sizeConstraint);
        Map map3 = (Map) map.get(IBridgeMediaLoader.COLUMN_DURATION);
        FilterCond.DurationConstraint durationConstraint = new FilterCond.DurationConstraint();
        durationConstraint.f((long) ((Integer) map3.get(MessageKey.MSG_ACCEPT_TIME_MIN)).intValue());
        durationConstraint.e((long) ((Integer) map3.get("max")).intValue());
        durationConstraint.d(((Boolean) map3.get("allowNullable")).booleanValue());
        filterCond.e(durationConstraint);
        return filterCond;
    }

    public final FilterCond h(Map<?, ?> map, AssetType assetType) {
        String lowerCase = assetType.name().toLowerCase(Locale.ROOT);
        if (map.containsKey(lowerCase)) {
            Object obj = map.get(lowerCase);
            if (obj instanceof Map) {
                return g((Map) obj);
            }
        }
        return new FilterCond();
    }
}
