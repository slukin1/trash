package com.hbg.module.livesquare.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.module.content.R$layout;
import ef.b;
import ef.h;
import java.util.List;

public class f extends RecyclerView.Adapter<h> {

    /* renamed from: a  reason: collision with root package name */
    public List<LiveSpeaker> f26454a;

    /* renamed from: b  reason: collision with root package name */
    public Context f26455b;

    /* renamed from: c  reason: collision with root package name */
    public b.a f26456c;

    /* renamed from: d  reason: collision with root package name */
    public LifecycleOwner f26457d = null;

    public f(Context context) {
        this.f26455b = context;
    }

    /* renamed from: a */
    public void onBindViewHolder(h hVar, int i11) {
        hVar.b(this.f26454a.get(i11), i11, this.f26456c);
    }

    /* renamed from: c */
    public h onCreateViewHolder(ViewGroup viewGroup, int i11) {
        h hVar = new h(LayoutInflater.from(this.f26455b).inflate(R$layout.item_live_hot_talk_v1_item, viewGroup, false));
        hVar.h(this.f26457d);
        return hVar;
    }

    public void d(List<LiveSpeaker> list) {
        this.f26454a = list;
        notifyDataSetChanged();
    }

    public void e(b.a aVar) {
        this.f26456c = aVar;
    }

    public void f(LifecycleOwner lifecycleOwner) {
        this.f26457d = lifecycleOwner;
    }

    public int getItemCount() {
        List<LiveSpeaker> list = this.f26454a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
