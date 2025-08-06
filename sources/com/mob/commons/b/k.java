package com.mob.commons.b;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.mob.commons.b.h;
import com.mob.commons.s;
import com.mob.tools.MobLog;

public class k extends h {
    public k(Context context) {
        super(context);
    }

    private String a(String str, String str2) {
        Bundle b11 = b(str, str2);
        if (a(b11)) {
            return b11.getString(s.a("002*didc"));
        }
        if (b11 != null) {
            return b11.getString(s.a("0075df>f;fifiYdJej0f"));
        }
        return null;
    }

    public h.b b() {
        h.b bVar = new h.b();
        bVar.f27087a = a(s.a("007Tej]fiQghfdeefl"), (String) null);
        return bVar;
    }

    private Bundle b(String str, String str2) {
        try {
            Uri parse = Uri.parse(s.a("036cWdk8eifeikllcePdl0eUdgffdi>d8dldidcSfei9di1i7ec+l9didc%feiZdi>iMec"));
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = this.f27079a.getContentResolver().acquireUnstableContentProviderClient(parse);
                Bundle call = acquireUnstableContentProviderClient.call(str, str2, (Bundle) null);
                if (i11 >= 24) {
                    acquireUnstableContentProviderClient.close();
                    return call;
                }
                acquireUnstableContentProviderClient.release();
                return call;
            } else if (i11 >= 11) {
                return this.f27079a.getContentResolver().call(parse, str, str2, (Bundle) null);
            } else {
                return null;
            }
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    private boolean a(Bundle bundle) {
        return bundle != null && bundle.getInt(s.a("004c;dkdcFf"), -1) == 0;
    }
}
