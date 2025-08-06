package com.mob.commons.cc;

import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import com.mob.commons.a.l;
import java.util.ArrayList;

public class n implements t<n> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public m f27138a;

    private ConnectivityManager.NetworkCallback a() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new ConnectivityManager.NetworkCallback() {
                public void onAvailable(Network network) {
                    super.onAvailable(network);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(network);
                    n.this.f27138a.a(l.a("011UelPf?geeeOe;ejJheTggBhg"), arrayList);
                }

                public void onLost(Network network) {
                    super.onLost(network);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(network);
                    n.this.f27138a.a(l.a("0069el0fYgfelgjTj"), arrayList);
                }

                public void onUnavailable() {
                    super.onUnavailable();
                }
            };
        }
        return null;
    }

    public void a(m mVar) {
        this.f27138a = mVar;
    }

    public boolean a(n nVar, Class<n> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if ("setHandler".equals(str) && objArr.length == 1 && objArr[0] != null && (objArr[0] instanceof m)) {
            nVar.a(objArr[0]);
        } else if (!l.a("019!ej4fDejLjZfh%gjMghelekfifeGehh;ggZedLfi").equals(str) || objArr.length != 0) {
            return false;
        } else {
            objArr2[0] = nVar.a();
        }
        return true;
    }
}
