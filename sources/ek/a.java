package ek;

import android.content.Context;
import com.huobi.edgeengine.util.HBResType;
import rj.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f47514a = new a();

    public final int a(Context context, HBResType hBResType, String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return context.getResources().getIdentifier(str, hBResType.type, context.getPackageName());
    }

    public final String b(b bVar, String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        return bVar.d().getString(a(bVar.d(), HBResType.String, str));
    }
}
