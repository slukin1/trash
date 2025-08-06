package cn.sharesdk.loopshare.utils;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.loopshare.beans.SceneData;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;
import java.util.Map;

public class d {
    private static String a() {
        return "mo" + "bl" + "in" + "k." + "sd" + "k." + "li" + "nk";
    }

    private static String b(String str) {
        try {
            return Base64.encodeToString(Data.AES128Encode(a(), str), 2);
        } catch (Throwable th2) {
            MobLinkLog.getInstance().d(th2, MobLinkLog.FORMAT, "Encrypt failed");
            return null;
        }
    }

    public static SceneData.Res a(Intent intent) {
        if (intent.getData() == null) {
            return null;
        }
        return a(intent.getData());
    }

    public static SceneData.Res a(Uri uri) {
        String path;
        HashMap fromJson;
        String queryParameter = uri.getQueryParameter("params");
        Hashon hashon = new Hashon();
        if (!TextUtils.isEmpty(queryParameter)) {
            queryParameter = a(queryParameter);
        }
        HashMap fromJson2 = !TextUtils.isEmpty(queryParameter) ? hashon.fromJson(queryParameter) : null;
        if (fromJson2 == null) {
            fromJson2 = new HashMap();
        }
        HashMap hashMap = (HashMap) fromJson2.get("params");
        if (hashMap == null) {
            hashMap = new HashMap();
            fromJson2.put("params", hashMap);
        }
        String queryParameter2 = uri.getQueryParameter("data");
        if (!TextUtils.isEmpty(queryParameter2)) {
            queryParameter2 = new String(Base64.decode(queryParameter2.replace(' ', '+'), 2));
        }
        if (!TextUtils.isEmpty(queryParameter2) && (fromJson = hashon.fromJson(queryParameter2)) != null && fromJson.size() > 0) {
            a(hashMap, fromJson);
        }
        SceneData.Res res = (SceneData.Res) hashon.fromJson(hashon.fromHashMap(fromJson2), SceneData.Res.class);
        if (res != null && ((path = res.getPath()) == null || path.length() < 1)) {
            res.setPath(c.a(uri));
        }
        return res;
    }

    public static String a(SceneData.Res res) {
        return b(new Hashon().fromObject(res));
    }

    private static String a(String str) {
        if (str != null) {
            str = str.replace(' ', '+');
        }
        try {
            return Data.AES128Decode(a(), Base64.decode(str, 2));
        } catch (Throwable th2) {
            MobLinkLog.getInstance().d(th2, MobLinkLog.FORMAT, "Decrypt failed");
            return null;
        }
    }

    private static void a(Map<String, Object> map, Map<String, Object> map2) {
        map.putAll(map2);
    }
}
