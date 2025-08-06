package com.huobi.edgeengine.ui;

import cn.sharesdk.framework.InnerShareParams;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.fastjson.JSON;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.module.libkt.base.ui.BaseActivity;
import java.util.HashMap;
import lj.o;
import rj.b;
import sd.a;

@Route(path = "/edgeengine/page")
public final class EdgeEnginePageActivity extends BaseActivity<o> {

    /* renamed from: i  reason: collision with root package name */
    public b f44359i;

    public final void Ah() {
        int identifier;
        String stringExtra = getIntent().getStringExtra(InnerShareParams.SCENCE);
        String stringExtra2 = getIntent().getStringExtra("xml");
        String stringExtra3 = getIntent().getStringExtra("start");
        if (!a.c(stringExtra) && !a.c(stringExtra2)) {
            Bh(ek.b.f47515a.b(this, stringExtra));
            if (!a.c(stringExtra3)) {
                HashMap hashMap = new HashMap();
                for (String str : getIntent().getExtras().keySet()) {
                    String stringExtra4 = getIntent().getStringExtra(str);
                    if (stringExtra4 != null && !a.c(stringExtra4) && !stringExtra4.equals(InnerShareParams.SCENCE) && !stringExtra4.equals("xml") && !stringExtra4.equals("start")) {
                        hashMap.put(str, stringExtra4);
                    }
                }
                yh().I(stringExtra3 + "('" + (hashMap.size() != 0 ? JSON.toJSONString(hashMap) : "") + "')");
            }
            if (!StringsKt__StringsJVMKt.v(stringExtra2, ".xml", false, 2, (Object) null)) {
                stringExtra2 = stringExtra2 + ".xml";
            }
            ((o) Yf()).B.addView(yh().D(stringExtra2, this));
        }
        String stringExtra5 = getIntent().getStringExtra("title");
        String stringExtra6 = getIntent().getStringExtra("titleKey");
        if (a.c(stringExtra5) && !a.c(stringExtra6) && (identifier = getResources().getIdentifier(stringExtra6, "string", getPackageName())) != 0) {
            stringExtra5 = getResources().getString(identifier);
        }
        ((o) Yf()).D.setText(stringExtra5);
    }

    public final void Bh(b bVar) {
        this.f44359i = bVar;
    }

    public void oh() {
        super.oh();
        Qg(NightHelper.e().g());
        ((o) Yf()).M(this);
        Ah();
    }

    public final b yh() {
        b bVar = this.f44359i;
        if (bVar != null) {
            return bVar;
        }
        return null;
    }

    /* renamed from: zh */
    public o Og() {
        return o.K(getLayoutInflater());
    }
}
