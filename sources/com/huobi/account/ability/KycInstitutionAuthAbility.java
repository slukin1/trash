package com.huobi.account.ability;

import android.content.Context;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.s;
import rx.Subscriber;
import u6.g;

public class KycInstitutionAuthAbility implements s {

    public class a implements c6.b {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbilityFunction.a f40925b;

        public a(AbilityFunction.a aVar) {
            this.f40925b = aVar;
        }

        public void onCallback(Object obj) {
            if (obj != null) {
                this.f40925b.a(true, String.valueOf(obj));
            } else {
                this.f40925b.a(false, "");
            }
        }
    }

    public class b extends Subscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c6.b f40927b;

        public b(c6.b bVar) {
            this.f40927b = bVar;
        }

        /* renamed from: a */
        public void onNext(String str) {
            c6.b bVar = this.f40927b;
            if (bVar != null) {
                bVar.onCallback(str);
            }
        }

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
            c6.b bVar = this.f40927b;
            if (bVar != null) {
                bVar.onCallback(null);
            }
        }
    }

    public void a(rj.b bVar, Object obj, AbilityFunction.a aVar) {
        if (aVar != null && obj != null) {
            try {
                b(bVar.d(), obj.toString(), new a(aVar));
            } catch (Exception e11) {
                e11.printStackTrace();
                aVar.a(false, e11.getMessage());
            }
        }
    }

    public void b(Context context, String str, c6.b bVar) {
        OtcModuleConfig.a().Q(context, str).compose(RxJavaHelper.t((g) null)).subscribe(new b(bVar));
    }
}
