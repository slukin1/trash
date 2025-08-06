package u9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.widgets.R$id;
import i6.r;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public r f76596a;

    /* renamed from: b  reason: collision with root package name */
    public View f76597b;

    public b(Context context, ViewGroup viewGroup, int i11) {
        View inflate = LayoutInflater.from(context).inflate(i11, viewGroup, false);
        this.f76597b = inflate;
        this.f76596a = new r(inflate);
        this.f76597b.setTag(R$id.item_holder, this);
    }

    public static b a(Context context, View view, ViewGroup viewGroup, int i11) {
        if (view == null) {
            return new b(context, viewGroup, i11);
        }
        return (b) view.getTag(R$id.item_holder);
    }

    public View b() {
        return this.f76597b;
    }

    public r c() {
        return this.f76596a;
    }
}
