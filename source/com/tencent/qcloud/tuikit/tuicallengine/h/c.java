package com.tencent.qcloud.tuikit.tuicallengine.h;

import android.text.TextUtils;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.k.b;
import java.util.ArrayList;
import java.util.List;

public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f48458a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f48459b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TUICommonDefine.ValueCallback f48460c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ d f48461d;

    public c(d dVar, List list, b bVar, TUICommonDefine.ValueCallback valueCallback) {
        this.f48461d = dVar;
        this.f48458a = list;
        this.f48459b = bVar;
        this.f48460c = valueCallback;
    }

    public void run() {
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : this.f48458a) {
                if (!TextUtils.isEmpty(str)) {
                    if (this.f48461d.getReadableDatabase().delete("callrecord", "call_id = ?", new String[]{str}) > 0) {
                        arrayList.add(str);
                    }
                }
            }
            b bVar = this.f48459b;
            bVar.f48536d.post(new b.C0608b(arrayList));
        } catch (Exception e11) {
            e11.printStackTrace();
            this.f48460c.onError(-1, "The delete list is empty");
        } catch (Throwable th2) {
            this.f48461d.close();
            throw th2;
        }
        this.f48461d.close();
    }
}
