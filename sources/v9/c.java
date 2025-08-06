package v9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import i6.r;

public class c extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public r f76603a;

    public c(View view) {
        super(view);
        this.f76603a = new r(view);
    }

    public static c a(View view) {
        return new c(view);
    }

    public static c b(ViewGroup viewGroup, int i11) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false));
    }

    public r e() {
        return this.f76603a;
    }
}
