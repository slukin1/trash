package qj;

import android.text.TextUtils;
import com.hbg.lib.core.lang.DynamicLang;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.uc.retrofit.bean.DynamicLangData;
import java.util.Iterator;
import java.util.List;
import u6.g;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f47754a = true;

    /* renamed from: qj.a$a  reason: collision with other inner class name */
    public class C0583a extends BaseSubscriber<List<DynamicLangData>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DynamicLang f47755b;

        public C0583a(DynamicLang dynamicLang) {
            this.f47755b = dynamicLang;
        }

        public void onNext(List<DynamicLangData> list) {
            super.onNext(list);
            if (list != null) {
                boolean z11 = false;
                Iterator<DynamicLangData> it2 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        DynamicLangData next = it2.next();
                        if (next != null && next.getStatus() == DynamicLangData.STATUS_ENABLE) {
                            String locale_country = next.getLocale_country();
                            String locale_lang = next.getLocale_lang();
                            if (TextUtils.equals(this.f47755b.getLocale_country(), locale_country) && TextUtils.equals(this.f47755b.getLocale_lang(), locale_lang)) {
                                z11 = true;
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                }
                if (!z11) {
                    n6.a.b();
                }
            }
        }
    }

    public static void a() {
        if (f47754a) {
            f47754a = false;
            DynamicLang c11 = m6.a.c();
            if (c11 != null) {
                b(new C0583a(c11));
            }
        }
    }

    public static void b(BaseSubscriber<List<DynamicLangData>> baseSubscriber) {
        if (!n6.a.a()) {
            baseSubscriber.onNext(null);
            baseSubscriber.onCompleted();
            baseSubscriber.onAfter();
            return;
        }
        o9.a.a().getDynamicLanguage().b().compose(RxJavaHelper.t((g) null)).subscribe(baseSubscriber);
    }
}
