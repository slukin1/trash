package com.sumsub.sns.presentation.screen.preview.photo;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sumsub.sns.R;
import d10.p;
import java.util.List;
import kotlin.Unit;

public final class c extends RecyclerView.Adapter<d> {

    /* renamed from: a  reason: collision with root package name */
    public List<b> f39950a = CollectionsKt__CollectionsKt.k();

    /* renamed from: b  reason: collision with root package name */
    public p<? super Integer, ? super b, Unit> f39951b;

    public final List<b> a() {
        return this.f39950a;
    }

    public final p<Integer, b, Unit> b() {
        return this.f39951b;
    }

    public int getItemCount() {
        return this.f39950a.size();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void a(List<b> list) {
        this.f39950a = list;
        notifyDataSetChanged();
    }

    public final void a(p<? super Integer, ? super b, Unit> pVar) {
        this.f39951b = pVar;
    }

    /* renamed from: a */
    public d onCreateViewHolder(ViewGroup viewGroup, int i11) {
        d dVar = new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sns_carousel_photo_item, viewGroup, false));
        dVar.a(this.f39951b);
        return dVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(d dVar, int i11) {
        dVar.a(i11, this.f39950a.get(i11));
    }
}
