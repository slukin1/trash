package com.tencent.android.tpush.rpc;

import android.content.Intent;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.message.e;
import com.tencent.android.tpush.rpc.a;
import com.tencent.android.tpush.service.b;

public class d extends a.C0750a {
    @JgMethodChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.INTENTSCHEMECHECK, EType.INTENTCHECK})
    public void a(String str, b bVar) {
        try {
            e.a(b.e()).a(Intent.parseUri(str, 0));
            bVar.a();
        } catch (Throwable th2) {
            TLogger.e("ITaskImpl", "Show", th2);
        }
    }

    public void b() {
    }

    public void a() {
        try {
            TLogger.d("ITaskImpl", "start XGService");
            b.a(b.e());
        } catch (Throwable th2) {
            TLogger.e("ITaskImpl", "startService", th2);
        }
    }
}
