package com.mob.commons.a;

import com.mob.MobSDK;
import com.mob.commons.ab;
import com.mob.commons.b;
import com.mob.commons.l;
import com.mob.commons.v;
import com.mob.tools.MobLog;
import com.mob.tools.utils.DH;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class h extends c {
    public h() {
        super((String) null, (String) null, c.a(l.a("003fii"), (Long) 0L));
    }

    private boolean m() {
        return b.a(l.a("003fii"));
    }

    private boolean n() {
        return b.a(l.a("002%fk,g"));
    }

    private boolean o() {
        return b.a(l.a("0023fiRg"));
    }

    public boolean e() {
        return m() && f();
    }

    public long l() {
        try {
            Calendar instance = Calendar.getInstance();
            long timeInMillis = instance.getTimeInMillis();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            instance.setTime(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            int i11 = 1;
            instance.add(5, 1);
            long timeInMillis2 = (instance.getTimeInMillis() - timeInMillis) + ((long) new SecureRandom().nextInt(240000));
            long j11 = timeInMillis2 / 1000;
            if (timeInMillis2 % 1000 == 0) {
                i11 = 0;
            }
            return j11 + ((long) i11);
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return 0;
        }
    }

    public void a() {
        if (m()) {
            if (!n()) {
                boolean o11 = o();
            }
            long currentTimeMillis = System.currentTimeMillis();
            long longValue = ((Long) a(l.a("004f[hk[lf"), 2592000L)).longValue() * 1000;
            long b11 = ab.a().b(ab.f26989c, 0);
            boolean a11 = v.a(currentTimeMillis, b11);
            Object obj = this.f26917b;
            final boolean z11 = true;
            boolean z12 = obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue();
            if (currentTimeMillis - longValue < b11 && a11) {
                z11 = false;
            }
            if (z11 || z12) {
                DH.requester(MobSDK.getContext()).getIAForce(false, z12).request(new DH.DHResponder() {
                    public void onResponse(DH.DHResponse dHResponse) {
                        ArrayList<HashMap<String, String>> iAForce = dHResponse.getIAForce(new int[0]);
                        if (iAForce != null && !iAForce.isEmpty() && z11) {
                            h.this.a(iAForce);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(ArrayList<HashMap<String, String>> arrayList) {
        a(((Long) a(l.a("004fGfeQih"), 0L)).longValue(), "ALSAMT", (Object) arrayList);
        ab.a().a(ab.f26989c, System.currentTimeMillis());
    }
}
