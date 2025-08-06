package com.huobi.edgeengine.ability;

import com.blankj.utilcode.util.LogUtils;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.huobi.edgeengine.ability.AbilityFunction;
import i6.m;
import kotlin.jvm.internal.r;
import rj.b;

public final class ConvertAbility implements s {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43884a = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        if (bVar != null) {
            try {
                String h11 = m.h((String) obj, AppLanguageHelper.getInstance().isChineseLanguage());
                if (aVar != null) {
                    aVar.a(true, h11);
                }
            } catch (Throwable th2) {
                LogUtils.j(th2);
                if (aVar != null) {
                    aVar.a(false, "");
                }
            }
        }
    }
}
