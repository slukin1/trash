package er;

import com.huobi.search.presenter.SearchDataPresenter;
import com.huobi.search.ui.SearchFlutterActivity;
import io.flutter.plugin.common.MethodChannel;
import java.util.concurrent.ConcurrentHashMap;

public final /* synthetic */ class b implements SearchDataPresenter.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f54405a;

    public /* synthetic */ b(MethodChannel.Result result) {
        this.f54405a = result;
    }

    public final void a(ConcurrentHashMap concurrentHashMap) {
        SearchFlutterActivity.Ei(this.f54405a, concurrentHashMap);
    }
}
