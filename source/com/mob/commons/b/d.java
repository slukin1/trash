package com.mob.commons.b;

import android.content.Context;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.ab;
import com.mob.commons.s;
import com.mob.tools.b.c;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.HashMap;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f27048a = s.a("005HdldffiYd3fi");

    public static synchronized HashMap<String, Object> a(Context context) {
        synchronized (d.class) {
            HashMap<String, Object> hashMap = new HashMap<>();
            HashMap<String, Object> a11 = a();
            boolean z11 = a11 != null && a11.size() > 0;
            if (z11) {
                HashMap hashMap2 = new HashMap();
                if (a11.containsKey(s.a("004$dgdcdidc"))) {
                    a11.put(s.a("005d*dgdcdidc"), a11.remove(s.a("004Gdgdcdidc")));
                }
                hashMap2.putAll(a11);
                hashMap.put(s.a("009AefdidcfiedKdchf"), hashMap2);
            }
            String ah2 = c.a(context).d().ah();
            if (!z11 && TextUtils.isEmpty(ah2)) {
                return null;
            }
            hashMap.put(s.a("004Jdk6d@didc"), ah2);
            a(ah2);
            return hashMap;
        }
    }

    public static String b(Context context) {
        return e.b(context);
    }

    private static HashMap<String, Object> a() {
        HashMap<String, Object> hashMap;
        File file = new File(MobSDK.getContext().getFilesDir().getAbsolutePath() + s.a("005lUhcdkff)l"), f27048a);
        if (file.exists()) {
            hashMap = (HashMap) ResHelper.readObjectFromFile(file.getAbsolutePath());
            ab.a().b("all_ds", (Object) hashMap);
            file.delete();
        } else {
            hashMap = null;
        }
        return (hashMap == null || hashMap.isEmpty()) ? (HashMap) ab.a().c("all_ds", (Object) null) : hashMap;
    }

    private static void a(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(s.a("004MdkJd*didc"), str);
        }
        ab.a().b("all_ds", (Object) hashMap);
    }
}
