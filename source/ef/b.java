package ef;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;
import com.hbg.module.content.R$drawable;

public class b extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public Context f28903a;

    public interface a {
        void a(LiveSquareBaseData liveSquareBaseData, int i11, int i12);
    }

    public b(View view) {
        super(view);
        this.f28903a = view.getContext();
    }

    public void a(LiveSquareBaseData liveSquareBaseData) {
    }

    public void b(LiveSquareBaseData liveSquareBaseData, int i11, a aVar) {
    }

    public int e() {
        if (NightHelper.e().g()) {
            return R$drawable.icon_image_default_n;
        }
        return R$drawable.icon_image_default;
    }

    public int f() {
        if (NightHelper.e().g()) {
            return R$drawable.icon_image_default_big_n;
        }
        return R$drawable.icon_image_default_big;
    }

    public int g() {
        if (NightHelper.e().g()) {
            return R$drawable.icon_user_default_n;
        }
        return R$drawable.icon_user_default;
    }
}
