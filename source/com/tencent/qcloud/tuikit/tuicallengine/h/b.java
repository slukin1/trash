package com.tencent.qcloud.tuikit.tuicallengine.h;

import android.database.Cursor;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import java.util.ArrayList;
import org.json.JSONObject;

public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TUICallDefine.RecentCallsFilter f48455a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TUICommonDefine.ValueCallback f48456b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f48457c;

    public b(d dVar, TUICallDefine.RecentCallsFilter recentCallsFilter, TUICommonDefine.ValueCallback valueCallback) {
        this.f48457c = dVar;
        this.f48455a = recentCallsFilter;
        this.f48456b = valueCallback;
    }

    public void run() {
        Cursor cursor = null;
        try {
            cursor = d.a(this.f48457c, this.f48455a);
            if (cursor == null) {
                this.f48456b.onError(-1, "The query result is empty");
                if (cursor != null) {
                    cursor.close();
                }
                this.f48457c.close();
            } else if (cursor.getCount() < 0) {
                cursor.close();
                this.f48456b.onError(-1, "The query result is empty");
                cursor.close();
                this.f48457c.close();
            } else {
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    int columnCount = cursor.getColumnCount();
                    JSONObject jSONObject = new JSONObject();
                    for (int i11 = 0; i11 < columnCount; i11++) {
                        if (cursor.getColumnName(i11) != null) {
                            if (cursor.getString(i11) != null) {
                                jSONObject.put(cursor.getColumnName(i11), cursor.getString(i11));
                            } else {
                                jSONObject.put(cursor.getColumnName(i11), "");
                            }
                        }
                    }
                    arrayList.add(jSONObject.toString());
                }
                this.f48456b.onSuccess(arrayList);
                cursor.close();
                this.f48457c.close();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            this.f48456b.onError(-1, "The query result is empty");
            if (cursor != null) {
                cursor.close();
            }
            this.f48457c.close();
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            this.f48457c.close();
            throw th2;
        }
    }
}
