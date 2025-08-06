package zendesk.classic.messaging.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.o;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;
import zendesk.classic.messaging.MessagingItem;
import zendesk.classic.messaging.R$id;
import zendesk.classic.messaging.R$layout;

public class y extends o<MessagingItem.g, RecyclerView.ViewHolder> {

    /* renamed from: c  reason: collision with root package name */
    public x f62898c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f62899d = true;

    /* renamed from: e  reason: collision with root package name */
    public MessagingItem.g f62900e = null;

    public class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f62902b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ MessagingItem.g f62903c;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                y.this.f62898c.a(b.this.f62903c);
            }
        }

        public b(RecyclerView.ViewHolder viewHolder, MessagingItem.g gVar) {
            this.f62902b = viewHolder;
            this.f62903c = gVar;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (y.this.f62899d) {
                if (y.this.f62898c != null) {
                    this.f62902b.itemView.post(new a());
                }
                boolean unused = y.this.f62899d = false;
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static class c extends DiffUtil.ItemCallback<MessagingItem.g> {
        public c() {
        }

        /* renamed from: d */
        public boolean a(MessagingItem.g gVar, MessagingItem.g gVar2) {
            return gVar.equals(gVar2);
        }

        /* renamed from: e */
        public boolean b(MessagingItem.g gVar, MessagingItem.g gVar2) {
            return gVar.equals(gVar2);
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public y() {
        super(new c((a) null));
    }

    public void e(List<MessagingItem.g> list) {
        super.e(list);
        this.f62899d = true;
        this.f62900e = null;
    }

    public int getItemViewType(int i11) {
        if (((MessagingItem.g) c(i11)) == this.f62900e) {
            return R$layout.zui_response_options_selected_option;
        }
        return R$layout.zui_response_options_option;
    }

    public final void i(MessagingItem.g gVar) {
        for (int i11 = 0; i11 < getItemCount(); i11++) {
            if (((MessagingItem.g) c(i11)).equals(gVar)) {
                notifyItemChanged(i11);
                return;
            }
        }
    }

    public void j(x xVar) {
        this.f62898c = xVar;
    }

    public void k(MessagingItem.g gVar) {
        this.f62900e = gVar;
        i(gVar);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        MessagingItem.g gVar = (MessagingItem.g) c(i11);
        ((TextView) viewHolder.itemView.findViewById(R$id.zui_response_option_text)).setText(gVar.a());
        viewHolder.itemView.setOnClickListener(new b(viewHolder, gVar));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false));
    }
}
