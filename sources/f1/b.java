package f1;

import android.database.Cursor;
import android.widget.Filter;

public class b extends Filter {

    /* renamed from: a  reason: collision with root package name */
    public a f15691a;

    public interface a {
        void a(Cursor cursor);

        Cursor b();

        CharSequence c(Cursor cursor);

        Cursor d(CharSequence charSequence);
    }

    public b(a aVar) {
        this.f15691a = aVar;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f15691a.c((Cursor) obj);
    }

    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor d11 = this.f15691a.d(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (d11 != null) {
            filterResults.count = d11.getCount();
            filterResults.values = d11;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor b11 = this.f15691a.b();
        Object obj = filterResults.values;
        if (obj != null && obj != b11) {
            this.f15691a.a((Cursor) obj);
        }
    }
}
