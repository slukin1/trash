package sr;

import android.content.Context;
import com.huobi.sharev2.helper.NewShareHelper;
import java.util.ArrayList;
import rx.functions.Func1;

public final /* synthetic */ class h implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f26149b;

    public /* synthetic */ h(Context context) {
        this.f26149b = context;
    }

    public final Object call(Object obj) {
        return NewShareHelper.q(this.f26149b, (ArrayList) obj);
    }
}
