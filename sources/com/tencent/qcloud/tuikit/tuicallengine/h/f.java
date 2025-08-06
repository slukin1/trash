package com.tencent.qcloud.tuikit.tuicallengine.h;

import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.k.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class f implements TUICommonDefine.ValueCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f48466a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f48467b;

    public f(g gVar, b bVar) {
        this.f48467b = gVar;
        this.f48466a = bVar;
    }

    public void onError(int i11, String str) {
        b bVar = this.f48466a;
        bVar.f48536d.post(new b.c(i11, str));
    }

    public void onSuccess(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (String jSONObject : (List) obj) {
            try {
                TUICallDefine.CallRecords a11 = g.a(this.f48467b, new JSONObject(jSONObject));
                if (a11 != null) {
                    arrayList.add(a11);
                }
            } catch (JSONException e11) {
                throw new RuntimeException(e11);
            }
        }
        b bVar = this.f48466a;
        bVar.f48536d.post(new b.C0608b(arrayList));
    }
}
