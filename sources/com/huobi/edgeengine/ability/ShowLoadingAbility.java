package com.huobi.edgeengine.ability;

import com.hbg.module.libkt.base.ui.BaseActivity;
import com.huobi.edgeengine.ability.AbilityFunction;
import kotlin.jvm.internal.r;
import rj.b;

public final class ShowLoadingAbility implements s {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43904a = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        boolean z11 = obj instanceof Integer;
        if (!z11) {
            aVar.a(false, (Object) null);
        } else if (bVar.d() instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) bVar.d();
            if (z11 && 1 == ((Number) obj).intValue()) {
                baseActivity.sh();
            } else {
                baseActivity.Df();
            }
            aVar.a(true, (Object) null);
        } else if (bVar.d() instanceof com.hbg.lib.core.ui.BaseActivity) {
            com.hbg.lib.core.ui.BaseActivity baseActivity2 = (com.hbg.lib.core.ui.BaseActivity) bVar.d();
            if (z11 && 1 == ((Number) obj).intValue()) {
                baseActivity2.showProgressDialog();
            } else {
                baseActivity2.dismissProgressDialog();
            }
            aVar.a(true, (Object) null);
        } else {
            aVar.a(false, (Object) null);
        }
    }
}
