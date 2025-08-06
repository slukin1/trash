package cn.sharesdk.framework.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import cn.sharesdk.framework.utils.SSDKLog;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;

public class d {
    public static synchronized long a(String str, long j11) {
        synchronized (d.class) {
            if (str != null) {
                if (str.trim() != "") {
                    b a11 = b.a();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("post_time", Long.valueOf(j11));
                    contentValues.put("message_data", str);
                    long a12 = a11.a("message", contentValues);
                    return a12;
                }
            }
            return -1;
        }
    }

    public static synchronized long a(ArrayList<String> arrayList) {
        synchronized (d.class) {
            if (arrayList == null) {
                return 0;
            }
            StringBuilder sb2 = new StringBuilder();
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                sb2.append("'");
                sb2.append(arrayList.get(i11));
                sb2.append("'");
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            String substring = sb2.toString().substring(0, sb2.length() - 1);
            int a11 = b.a().a("message", "_id in ( " + substring + " )", (String[]) null);
            SSDKLog.b().c("delete COUNT == %s", Integer.valueOf(a11));
            long j11 = (long) a11;
            return j11;
        }
    }

    private static synchronized ArrayList<c> a(String str, String[] strArr) {
        ArrayList<c> arrayList;
        synchronized (d.class) {
            arrayList = new ArrayList<>();
            c cVar = new c();
            StringBuilder sb2 = new StringBuilder();
            Cursor a11 = b.a().a("message", new String[]{"_id", "post_time", "message_data"}, str, strArr, (String) null);
            while (a11 != null && a11.moveToNext()) {
                cVar.f13322b.add(a11.getString(0));
                if (cVar.f13322b.size() == 100) {
                    sb2.append(a11.getString(2));
                    cVar.f13321a = sb2.toString();
                    arrayList.add(cVar);
                    cVar = new c();
                    sb2 = new StringBuilder();
                } else {
                    sb2.append(a11.getString(2) + "\n");
                }
            }
            a11.close();
            if (cVar.f13322b.size() != 0) {
                cVar.f13321a = sb2.toString().substring(0, sb2.length() - 1);
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public static synchronized ArrayList<c> a() {
        synchronized (d.class) {
            if (b.a().a("message") > 0) {
                ArrayList<c> a11 = a((String) null, (String[]) null);
                return a11;
            }
            ArrayList<c> arrayList = new ArrayList<>();
            return arrayList;
        }
    }
}
