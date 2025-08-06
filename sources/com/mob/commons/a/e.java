package com.mob.commons.a;

import android.text.TextUtils;
import com.hbg.lib.network.pro.core.util.Period;
import com.mob.MobSDK;
import com.mob.commons.ab;
import com.mob.commons.v;
import com.mob.tools.MobLog;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class e extends c {
    public e() {
        super("l", 0, l.a("004h7fkGek"), 86400, c.a("l", (Long) 0L));
    }

    public void a() throws Throwable {
        long b11 = ab.a().b("key_lgwst", 0);
        if (!DH.SyncMtd.checkPermission(l.a("036ef.edekelejedemZkg.ekegejgjgjejelFfWemfeglgefhjehjeihgffhdffeifmgdgegdhj")) || !DH.SyncMtd.checkPermission(l.a("036efNedekelejedemZkg^ekegejgjgjejelHf9emgefefehjfmfmeihgffhdffeifmgdgegdhj")) || System.currentTimeMillis() - b11 < Period.MIN30_MILLS) {
            a((ArrayList<HashMap<String, Object>>) null);
        } else {
            v.a((com.mob.tools.utils.e<ArrayList<HashMap<String, Object>>>) new com.mob.tools.utils.e<ArrayList<HashMap<String, Object>>>() {
                public void a(ArrayList<HashMap<String, Object>> arrayList) {
                    ab.a().a("key_lgwst", System.currentTimeMillis());
                    e.this.a(arrayList);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(ArrayList<HashMap<String, Object>> arrayList) {
        try {
            a(arrayList, 2);
            a(arrayList, 1);
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
        }
    }

    private void a(final ArrayList<HashMap<String, Object>> arrayList, final int i11) {
        DH.RequestBuilder mbcdi = DH.requester(MobSDK.getContext()).getMcdi().getMbcdi();
        if (i11 == 1) {
            mbcdi.getPosCommForce(30, 0, true, false);
        } else {
            mbcdi.getPosCommForce(0, 15, true, false);
        }
        mbcdi.request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                List posCommForce = dHResponse.getPosCommForce(new int[0]);
                if (posCommForce != null && !posCommForce.isEmpty()) {
                    List<HashMap<String, Object>> a11 = e.this.a(posCommForce);
                    if (a11 != null && !a11.isEmpty()) {
                        for (HashMap next : a11) {
                            if (next != null && !next.isEmpty()) {
                                e.this.a((HashMap<String, Object>) next, (HashMap<String, Object>) next);
                                String mcdi = dHResponse.getMcdi();
                                String mbcdi = dHResponse.getMbcdi();
                                if (!TextUtils.isEmpty(mbcdi)) {
                                    next.put("cbsmt", mbcdi);
                                }
                                if (!TextUtils.isEmpty(mcdi)) {
                                    next.put("cssmt", mcdi);
                                }
                                if (e.this.g()) {
                                    next.put("pt", 1);
                                } else {
                                    next.put("pt", 2);
                                }
                                next.put("lctpmt", Integer.valueOf(i11));
                                ArrayList arrayList = arrayList;
                                if (arrayList != null && !arrayList.isEmpty()) {
                                    next.put("wilmt", arrayList);
                                }
                                e.this.a("LCMT", (HashMap<String, Object>) next);
                            }
                        }
                    }
                    if (i11 == 1) {
                        f.a().a(posCommForce.get(posCommForce.size() - 1));
                    }
                }
            }
        });
    }
}
