package ra;

import android.content.Context;
import c6.b;
import com.hbg.lib.network.php.core.bean.ZendeskTopNotice;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lite.index.bean.LiteHomeActivityEntity;
import java.util.List;
import u6.g;

public interface a {
    boolean a(Context context, String str, String str2, String str3, boolean z11);

    void b(RequestCallback1<ZendeskTopNotice> requestCallback1);

    void c(Context context, String str, String str2, String str3);

    void d(Context context, g gVar, b<List<LiteHomeActivityEntity>> bVar);
}
