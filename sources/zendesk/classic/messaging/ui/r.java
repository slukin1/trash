package zendesk.classic.messaging.ui;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class r {

    /* renamed from: a  reason: collision with root package name */
    public final int f62852a;

    /* renamed from: b  reason: collision with root package name */
    public final int f62853b;

    /* renamed from: c  reason: collision with root package name */
    public final int f62854c;

    public r(int i11, int i12, int i13) {
        this.f62852a = i11;
        this.f62853b = i12;
        this.f62854c = i13;
    }

    public void a(View view) {
        c(view, (View) null, (View) null);
    }

    public void b(View view, View view2) {
        c(view, view2, (View) null);
    }

    public void c(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(this.f62852a);
        }
        if (view3 != null) {
            view3.setVisibility(this.f62854c);
        }
        ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin = this.f62853b;
        view.requestLayout();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        if (this.f62852a != rVar.f62852a) {
            return false;
        }
        if (this.f62853b == rVar.f62853b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f62852a * 31) + this.f62853b;
    }
}
