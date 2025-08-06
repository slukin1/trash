package com.huobi.edgeengine.ability;

import android.content.Context;
import android.net.Uri;
import com.alibaba.android.arouter.facade.Postcard;
import com.hbg.module.libkt.provider.BaseJumpPageProvider;
import com.hbg.module.libkt.provider.JumpPageScheme;
import com.huobi.edgeengine.ability.AbilityFunction;
import kotlin.jvm.internal.r;
import rj.b;

public final class RouteAbility implements s {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43898a = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        Context d11;
        if (obj instanceof String) {
            String c11 = c(bVar, (String) obj);
            if (c11 != null) {
                BaseJumpPageProvider baseJumpPageProvider = (BaseJumpPageProvider) b2.a.d().a("/provider/jumpPage").navigation();
                if (!(bVar == null || (d11 = bVar.d()) == null || baseJumpPageProvider == null)) {
                    baseJumpPageProvider.e(d11, c11, "");
                }
            }
            if (aVar != null) {
                aVar.a(true, (Object) null);
            }
        } else if (aVar != null) {
            aVar.a(false, (Object) null);
        }
    }

    public final void b(String str, String str2) {
        Uri parse;
        Postcard a11 = b2.a.d().a(str);
        Uri parse2 = Uri.parse(str2);
        if (parse2 != null) {
            String queryParameter = parse2.getQueryParameter("url");
            if (!(queryParameter == null || (parse = Uri.parse(queryParameter)) == null)) {
                for (String str3 : parse.getQueryParameterNames()) {
                    if (!com.hbg.module.libkt.base.ext.b.x(parse.getQueryParameter(str3))) {
                        a11.withString(str3, parse.getQueryParameter(str3));
                    }
                }
            }
            for (String str4 : parse2.getQueryParameterNames()) {
                if (!str4.equals("url")) {
                    a11.withString(str4, parse2.getQueryParameter(str4));
                }
            }
        }
        a11.navigation();
    }

    public final String c(b bVar, String str) {
        Context d11;
        if (StringsKt__StringsKt.R(str, "m.hbg.com/account/language", false, 2, (Object) null)) {
            return StringsKt__StringsJVMKt.G(str, "m.hbg.com/account/language", "m.hbg.com/app/language", false, 4, (Object) null);
        }
        if (StringsKt__StringsKt.R(str, "m.hbg.com/account/about", false, 2, (Object) null)) {
            return StringsKt__StringsJVMKt.G(str, "m.hbg.com/account/about", "m.hbg.com/app/about", false, 4, (Object) null);
        }
        if (StringsKt__StringsKt.R(str, "m.hbg.com/content/personalCenter", false, 2, (Object) null)) {
            b("/content/PersonalCenter", str);
            return null;
        } else if (!StringsKt__StringsKt.R(str, "m.hbg.com/login/index?jumpType=1", false, 2, (Object) null)) {
            return str;
        } else {
            BaseJumpPageProvider baseJumpPageProvider = (BaseJumpPageProvider) b2.a.d().a("/provider/jumpPage").navigation();
            if (!(bVar == null || (d11 = bVar.d()) == null || baseJumpPageProvider == null)) {
                baseJumpPageProvider.d(d11, JumpPageScheme.LOGIN);
            }
            return null;
        }
    }
}
