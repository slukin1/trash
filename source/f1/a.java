package f1;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import f1.b;

public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f15681b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f15682c;

    /* renamed from: d  reason: collision with root package name */
    public Cursor f15683d;

    /* renamed from: e  reason: collision with root package name */
    public Context f15684e;

    /* renamed from: f  reason: collision with root package name */
    public int f15685f;

    /* renamed from: g  reason: collision with root package name */
    public C0077a f15686g;

    /* renamed from: h  reason: collision with root package name */
    public DataSetObserver f15687h;

    /* renamed from: i  reason: collision with root package name */
    public b f15688i;

    /* renamed from: f1.a$a  reason: collision with other inner class name */
    public class C0077a extends ContentObserver {
        public C0077a() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z11) {
            a.this.i();
        }
    }

    public class b extends DataSetObserver {
        public b() {
        }

        public void onChanged() {
            a aVar = a.this;
            aVar.f15681b = true;
            aVar.notifyDataSetChanged();
        }

        public void onInvalidated() {
            a aVar = a.this;
            aVar.f15681b = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z11) {
        f(context, cursor, z11 ? 1 : 2);
    }

    public void a(Cursor cursor) {
        Cursor j11 = j(cursor);
        if (j11 != null) {
            j11.close();
        }
    }

    public Cursor b() {
        return this.f15683d;
    }

    public abstract CharSequence c(Cursor cursor);

    public abstract void e(View view, Context context, Cursor cursor);

    public void f(Context context, Cursor cursor, int i11) {
        boolean z11 = false;
        if ((i11 & 1) == 1) {
            i11 |= 2;
            this.f15682c = true;
        } else {
            this.f15682c = false;
        }
        if (cursor != null) {
            z11 = true;
        }
        this.f15683d = cursor;
        this.f15681b = z11;
        this.f15684e = context;
        this.f15685f = z11 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i11 & 2) == 2) {
            this.f15686g = new C0077a();
            this.f15687h = new b();
        } else {
            this.f15686g = null;
            this.f15687h = null;
        }
        if (z11) {
            C0077a aVar = this.f15686g;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f15687h;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    public int getCount() {
        Cursor cursor;
        if (!this.f15681b || (cursor = this.f15683d) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public View getDropDownView(int i11, View view, ViewGroup viewGroup) {
        if (!this.f15681b) {
            return null;
        }
        this.f15683d.moveToPosition(i11);
        if (view == null) {
            view = g(this.f15684e, this.f15683d, viewGroup);
        }
        e(view, this.f15684e, this.f15683d);
        return view;
    }

    public Filter getFilter() {
        if (this.f15688i == null) {
            this.f15688i = new b(this);
        }
        return this.f15688i;
    }

    public Object getItem(int i11) {
        Cursor cursor;
        if (!this.f15681b || (cursor = this.f15683d) == null) {
            return null;
        }
        cursor.moveToPosition(i11);
        return this.f15683d;
    }

    public long getItemId(int i11) {
        Cursor cursor;
        if (!this.f15681b || (cursor = this.f15683d) == null || !cursor.moveToPosition(i11)) {
            return 0;
        }
        return this.f15683d.getLong(this.f15685f);
    }

    public View getView(int i11, View view, ViewGroup viewGroup) {
        if (!this.f15681b) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f15683d.moveToPosition(i11)) {
            if (view == null) {
                view = h(this.f15684e, this.f15683d, viewGroup);
            }
            e(view, this.f15684e, this.f15683d);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i11);
        }
    }

    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);

    public void i() {
        Cursor cursor;
        if (this.f15682c && (cursor = this.f15683d) != null && !cursor.isClosed()) {
            this.f15681b = this.f15683d.requery();
        }
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.f15683d;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0077a aVar = this.f15686g;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f15687h;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f15683d = cursor;
        if (cursor != null) {
            C0077a aVar2 = this.f15686g;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.f15687h;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f15685f = cursor.getColumnIndexOrThrow("_id");
            this.f15681b = true;
            notifyDataSetChanged();
        } else {
            this.f15685f = -1;
            this.f15681b = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
