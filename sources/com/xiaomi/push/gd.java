package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.az;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class gd {
    public static void a(Context context, gf gfVar, List<gk> list) {
        HashMap<String, ArrayList<gk>> a11 = a(context, list);
        if (a11 == null || a11.size() == 0) {
            b.a("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
            return;
        }
        a(context, gfVar, a11);
    }

    private static HashMap<String, ArrayList<gk>> a(Context context, List<gk> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap<String, ArrayList<gk>> hashMap = new HashMap<>();
        for (gk next : list) {
            a(context, next);
            ArrayList arrayList = hashMap.get(next.c());
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(next.c(), arrayList);
            }
            arrayList.add(next);
        }
        return hashMap;
    }

    private static void a(Context context, gk gkVar) {
        if (gkVar.f2917a) {
            gkVar.a("push_sdk_channel");
        }
        if (TextUtils.isEmpty(gkVar.d())) {
            gkVar.f(az.a());
        }
        gkVar.b(System.currentTimeMillis());
        if (TextUtils.isEmpty(gkVar.e())) {
            gkVar.e(context.getPackageName());
        }
        if (TextUtils.isEmpty(gkVar.c())) {
            gkVar.e(gkVar.e());
        }
    }

    private static void a(Context context, gf gfVar, HashMap<String, ArrayList<gk>> hashMap) {
        for (Map.Entry next : hashMap.entrySet()) {
            try {
                ArrayList arrayList = (ArrayList) next.getValue();
                if (arrayList != null) {
                    if (arrayList.size() != 0) {
                        gfVar.a(arrayList, ((gk) arrayList.get(0)).e(), (String) next.getKey());
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
