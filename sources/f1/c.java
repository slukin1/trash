package f1;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class c extends a {

    /* renamed from: j  reason: collision with root package name */
    public int f15692j;

    /* renamed from: k  reason: collision with root package name */
    public int f15693k;

    /* renamed from: l  reason: collision with root package name */
    public LayoutInflater f15694l;

    @Deprecated
    public c(Context context, int i11, Cursor cursor, boolean z11) {
        super(context, cursor, z11);
        this.f15693k = i11;
        this.f15692j = i11;
        this.f15694l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f15694l.inflate(this.f15693k, viewGroup, false);
    }

    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f15694l.inflate(this.f15692j, viewGroup, false);
    }
}
