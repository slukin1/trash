package com.hbg.module.content.widgets.ad;

import android.content.Context;
import com.hbg.module.libkt.provider.BaseJumpPageProvider;
import kotlin.Unit;

public interface a {

    /* renamed from: com.hbg.module.content.widgets.ad.a$a  reason: collision with other inner class name */
    public static final class C0129a {
        public static String a(a aVar, String str, int i11) {
            if (str.length() <= i11) {
                return str;
            }
            return str.substring(0, i11) + "...";
        }

        public static void b(a aVar, Context context) {
            BaseJumpPageProvider baseJumpPageProvider = (BaseJumpPageProvider) b2.a.d().a("/provider/jumpPage").navigation();
            if (baseJumpPageProvider != null) {
                baseJumpPageProvider.e(context, aVar.c(), "");
            }
        }
    }

    void a(String str);

    void b(Context context, AdItemView adItemView);

    String c();

    void d();

    void e(String str);

    void f(String str);

    void g(String str);

    void h(d10.a<Unit> aVar);
}
