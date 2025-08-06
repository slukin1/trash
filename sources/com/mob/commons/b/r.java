package com.mob.commons.b;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.mob.commons.C0891r;
import com.mob.commons.b.h;
import com.mob.tools.MobLog;

public class r extends h {
    public r(Context context) {
        super(context);
    }

    private void e() {
        try {
            Intent intent = new Intent();
            intent.setClassName(C0891r.b("012b2cjceckcecbchcbckceehNc"), C0891r.b("033b^cjceckcecbchcbckceeh3c9ckehHe1ciccchNbeWckgbehAcThbDf,dk*e>ciccchFbe"));
            intent.setAction(C0891r.b("032b[cjceckeecf0d=ckceehIcRckKcbh-chcj0dUckeh)hcOci<hJckeh,e>ciccch@be"));
            intent.putExtra(C0891r.b("025b?cjceckeecf%d_ckceeh8cDckCic)ci_c?ceck,i<dgdi%dc;ce+e"), this.f27080b);
            intent.putExtra(C0891r.b("026b*cjceckeecfNdKckceeh8cMck$ic4ci3cEceckcicfDd)ch9d<ehReh"), true);
            this.f27079a.startService(intent);
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
        }
    }

    public Intent a() {
        e();
        Intent intent = new Intent();
        intent.setClassName(C0891r.b("012b;cjceckcecbchcbckceehPc"), C0891r.b("033b0cjceckcecbchcbckceeh2c<ckehZeAciccch8be$ckgbeh7c[ddcbdkWeSciccchJbe"));
        intent.setAction(C0891r.b("033b@cjceckeecfEd_ckceehGc;ck1cbhAchcjOd3ckeechCd!cbZhHcjckeh:eJciccchZbe"));
        intent.putExtra(C0891r.b("025bTcjceckeecf8d8ckceeh-cZckWic*ciEc=ceck2i_dgdi.dc.ce9e"), this.f27080b);
        return intent;
    }

    public h.b a(IBinder iBinder) {
        h.b bVar = new h.b();
        bVar.f27087a = a(C0891r.b("004Jcj1cZchcb"), iBinder, C0891r.b("026b cjceckeecfWd%ckGf4cheeckgbeh;cKddcbdd:dhe>cideYcbe"), 3, new String[0]);
        return bVar;
    }
}
