package zendesk.classic.messaging.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.o;

public class e extends o<o, RecyclerView.ViewHolder> {

    public class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }
    }

    public static class b extends DiffUtil.ItemCallback<o> {
        /* renamed from: d */
        public boolean a(o oVar, o oVar2) {
            return oVar.a(oVar2);
        }

        /* renamed from: e */
        public boolean b(o oVar, o oVar2) {
            if (oVar.c().equals(p.f62821h)) {
                return false;
            }
            return oVar.c().equals(oVar2.c());
        }
    }

    public e() {
        super(new b());
    }

    public int getItemViewType(int i11) {
        return ((o) c(i11)).d();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        o oVar = (o) c(i11);
        View view = viewHolder.itemView;
        if (oVar.e().isInstance(view)) {
            oVar.b(view);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false));
    }
}
