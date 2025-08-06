package com.mob.commons.a;

import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.C0891r;
import com.mob.commons.ab;
import com.mob.commons.m;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class i extends c {
    public i() {
        super(C0891r.b("003Uehdbeh"), 0, C0891r.b("0069ehdbehdiRci"), 2592000, c.a(C0891r.b("003Uehdbeh"), (Long) 0L));
    }

    public void a() {
        DH.requester(MobSDK.getContext()).getSA().request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                boolean z11;
                ArrayList<HashMap<String, String>> sa2 = dHResponse.getSA();
                if (sa2 != null && !sa2.isEmpty()) {
                    long b11 = ab.a().b(ab.f26990d, 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean z12 = currentTimeMillis - (i.this.l() * 1000) >= b11;
                    if (!z12) {
                        ArrayList<HashMap<String, String>> readArrayListFromFile = ResHelper.readArrayListFromFile(m.f27282e, true);
                        Iterator<HashMap<String, String>> it2 = sa2.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            String str = (String) it2.next().get(C0891r.b("003iXdgdi"));
                            if (!TextUtils.isEmpty(str)) {
                                Iterator<HashMap<String, String>> it3 = readArrayListFromFile.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        if (str.equals(it3.next().get(C0891r.b("003i>dgdi")))) {
                                            z11 = true;
                                            break;
                                        }
                                    } else {
                                        z11 = false;
                                        break;
                                    }
                                }
                                if (!z11) {
                                    z12 = true;
                                    break;
                                }
                            }
                        }
                    }
                    if (z12) {
                        i.this.a(0, "SALMT", (Object) sa2);
                        ResHelper.saveArrayListToFile(sa2, m.f27282e, true);
                        ab.a().a(ab.f26990d, currentTimeMillis);
                    }
                }
            }
        });
    }
}
