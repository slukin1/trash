package ra;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import c6.b;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.network.hbg.core.bean.TeachConfigItem;
import com.hbg.lite.index.bean.ReminderData;
import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import u6.g;
import ya.a;

public interface d {
    ReminderData A();

    void B(b<Boolean> bVar);

    boolean C(Activity activity, Intent intent, Intent intent2);

    String D();

    void E();

    void F();

    void G();

    String c();

    List<Integer> d();

    void e(String str);

    String f(Bitmap bitmap, Bitmap.CompressFormat compressFormat, File file);

    void g(View view, boolean z11);

    String getUid();

    boolean h(Activity activity);

    void i(b bVar);

    void j();

    Observable<String> k();

    void l(String str, Map<String, Object> map);

    TeachConfigItem m(int i11);

    void n(String str, String str2);

    boolean o();

    boolean p();

    void q(Activity activity);

    void r(a aVar);

    Application s();

    void t(b<Boolean> bVar);

    void track(String str, HashMap hashMap);

    boolean u();

    String v(BigDecimal bigDecimal);

    Observable<String> w(Map<String, Object> map);

    Observable<String> x();

    void y(FragmentActivity fragmentActivity, g gVar);

    void z(BaseCoreActivity baseCoreActivity, boolean z11);
}
