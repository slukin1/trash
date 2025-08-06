package zr;

import android.content.Context;
import com.hbg.lib.core.util.ConfigPreferences;
import com.huobi.sp.InitLocalCode;
import com.huobi.sp.RemoveBTCE;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public List<a> f85108a;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static e f85109a = new e();
    }

    public static e d() {
        return b.f85109a;
    }

    public static /* synthetic */ Boolean e(int i11, a aVar) {
        return Boolean.valueOf(aVar.a() > i11);
    }

    public static /* synthetic */ void g(Context context, a aVar) {
        aVar.b(context);
        ConfigPreferences.k("user_config", "sp_version", aVar.a());
    }

    public void h(Context context) {
        Observable.from(this.f85108a).filter(new c(ConfigPreferences.g("user_config", "sp_version", 0))).sorted(d.f63114b).subscribe(new b(context));
    }

    public e() {
        ArrayList arrayList = new ArrayList();
        this.f85108a = arrayList;
        arrayList.add(new RemoveBTCE());
        this.f85108a.add(new InitLocalCode());
    }
}
