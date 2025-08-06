package p8;

import android.content.Context;
import com.hbg.lib.network.option.retrofit.OptionApiRetrofitImpl;
import com.tencent.qcloud.tuicore.TUIConstants;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f70137a;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f70138a = new a();
    }

    public static b a() {
        return b.f70138a.f70137a;
    }

    public static void b(Context context, c9.b bVar) {
        a().a(TUIConstants.TUIPoll.PLUGIN_POLL_OPTION_CONTENT, context, bVar);
    }

    public a() {
        this.f70137a = new OptionApiRetrofitImpl();
    }
}
