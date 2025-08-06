package com.hbg.module.livesquare.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;
import com.hbg.lib.network.hbg.core.bean.RecommendSpeakerList;
import com.hbg.module.content.R$layout;
import com.tencent.live2.V2TXLivePlayer;
import ef.b;
import ef.d;
import ef.g;
import ef.i;
import ef.j;
import ef.l;
import java.util.ArrayList;
import java.util.List;

public class e extends RecyclerView.Adapter<b> {

    /* renamed from: a  reason: collision with root package name */
    public List<LiveSquareBaseData> f26446a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public Context f26447b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f26448c;

    /* renamed from: d  reason: collision with root package name */
    public int f26449d = -1;

    /* renamed from: e  reason: collision with root package name */
    public V2TXLivePlayer f26450e;

    /* renamed from: f  reason: collision with root package name */
    public b.a f26451f;

    /* renamed from: g  reason: collision with root package name */
    public LifecycleOwner f26452g;

    /* renamed from: h  reason: collision with root package name */
    public int f26453h;

    public interface a {
        void a(int i11, V2TXLivePlayer v2TXLivePlayer);
    }

    public e(Context context) {
        this.f26447b = context;
        this.f26448c = LayoutInflater.from(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(int i11, V2TXLivePlayer v2TXLivePlayer) {
        this.f26449d = i11;
        this.f26450e = v2TXLivePlayer;
    }

    public void c(List<LiveSquareBaseData> list) {
        if (!com.hbg.module.libkt.base.ext.b.w(this.f26446a)) {
            this.f26446a.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void d() {
        try {
            if (this.f26446a.size() > 0 && getItemViewType(0) == 1) {
                this.f26446a.remove(0);
                notifyDataSetChanged();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void e() {
        f(true);
    }

    public void f(boolean z11) {
        try {
            if (this.f26446a.size() > 0) {
                if (getItemViewType(0) == 6) {
                    this.f26446a.remove(0);
                } else if (getItemViewType(1) == 6) {
                    this.f26446a.remove(1);
                }
                if (z11) {
                    notifyDataSetChanged();
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void g() {
        h(true);
    }

    public int getItemCount() {
        return this.f26446a.size();
    }

    public int getItemViewType(int i11) {
        if (this.f26446a.size() > 0) {
            return this.f26446a.get(i11).getViewType();
        }
        return super.getItemViewType(i11);
    }

    public void h(boolean z11) {
        try {
            if (this.f26446a.size() > 0) {
                if (getItemViewType(0) == 7) {
                    this.f26446a.remove(0);
                } else if (getItemViewType(1) == 7) {
                    this.f26446a.remove(1);
                } else if (getItemViewType(2) == 7) {
                    this.f26446a.remove(2);
                }
                if (z11) {
                    notifyDataSetChanged();
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public List<LiveSquareBaseData> i() {
        return this.f26446a;
    }

    public void j(LiveSquareBaseData liveSquareBaseData) {
        try {
            if (this.f26446a.size() > 0 && getItemViewType(0) == 1) {
                this.f26446a.remove(0);
            }
            this.f26446a.add(0, liveSquareBaseData);
            notifyDataSetChanged();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void k(LiveSquareBaseData liveSquareBaseData) {
        try {
            e();
            if (getItemViewType(0) == 1) {
                this.f26446a.add(1, liveSquareBaseData);
            } else {
                this.f26446a.add(0, liveSquareBaseData);
            }
            notifyDataSetChanged();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void l(RecommendSpeakerList recommendSpeakerList) {
        try {
            g();
            if (getItemViewType(0) == 1 && getItemViewType(1) == 6) {
                this.f26446a.add(2, recommendSpeakerList);
            } else {
                if (getItemViewType(0) != 1) {
                    if (getItemViewType(0) != 6) {
                        this.f26446a.add(0, recommendSpeakerList);
                    }
                }
                this.f26446a.add(1, recommendSpeakerList);
            }
            notifyDataSetChanged();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* renamed from: n */
    public void onBindViewHolder(b bVar, int i11) {
        LiveSquareBaseData liveSquareBaseData = this.f26446a.get(i11);
        if (liveSquareBaseData != null) {
            bVar.b(liveSquareBaseData, i11, this.f26451f);
        }
    }

    /* renamed from: o */
    public b onCreateViewHolder(ViewGroup viewGroup, int i11) {
        switch (i11) {
            case 1:
                return new ef.a(this.f26448c.inflate(R$layout.item_live_banner, viewGroup, false), this.f26453h, this.f26452g);
            case 2:
                return new l(this.f26448c.inflate(R$layout.item_live_title, viewGroup, false));
            case 3:
                g gVar = new g(this.f26448c.inflate(R$layout.item_live_content_one_cell, viewGroup, false));
                gVar.q(new d(this));
                return gVar;
            case 4:
                return new g(this.f26448c.inflate(R$layout.item_live_content_two_cell, viewGroup, false));
            case 5:
                return new i(this.f26448c.inflate(R$layout.item_live_hot_talk, viewGroup, false), this.f26452g);
            case 6:
                return new d(this.f26448c.inflate(R$layout.item_live_category, viewGroup, false));
            case 7:
                return new j(this.f26448c.inflate(R$layout.item_live_recommend_speaker, viewGroup, false));
            default:
                return null;
        }
    }

    public void p(LiveSquareBaseData liveSquareBaseData) {
        try {
            if (this.f26446a.contains(liveSquareBaseData)) {
                int indexOf = this.f26446a.indexOf(liveSquareBaseData);
                LiveSquareBaseData liveSquareBaseData2 = this.f26446a.get(indexOf);
                liveSquareBaseData.setViewType(liveSquareBaseData2.getViewType());
                liveSquareBaseData.setModuleType(liveSquareBaseData2.getModuleType());
                liveSquareBaseData.setIndex(liveSquareBaseData2.getIndex());
                this.f26446a.set(indexOf, liveSquareBaseData);
                notifyItemChanged(indexOf);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void q(LifecycleOwner lifecycleOwner) {
        this.f26452g = lifecycleOwner;
    }

    public void r(List<LiveSquareBaseData> list) {
        try {
            if (this.f26446a.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < 3; i11++) {
                    int itemViewType = getItemViewType(i11);
                    if (itemViewType == 7 || itemViewType == 6 || itemViewType == 1) {
                        arrayList.add(this.f26446a.get(i11));
                    }
                }
                this.f26446a.clear();
                this.f26446a.addAll(arrayList);
                this.f26446a.addAll(list);
                notifyItemRangeChanged(0, this.f26446a.size());
                return;
            }
            this.f26446a.clear();
            this.f26446a.addAll(list);
            notifyDataSetChanged();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void s(b.a aVar) {
        this.f26451f = aVar;
    }

    public void t(int i11) {
        this.f26453h = i11;
    }
}
