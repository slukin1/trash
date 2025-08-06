package zendesk.classic.messaging.ui;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.n;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class w {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f62878a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayoutManager f62879b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> f62880c;

    /* renamed from: d  reason: collision with root package name */
    public int f62881d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f62882e = 0;

    public class a extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LinearLayoutManager f62883a;

        public a(LinearLayoutManager linearLayoutManager) {
            this.f62883a = linearLayoutManager;
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            super.onScrolled(recyclerView, i11, i12);
            w wVar = w.this;
            int unused = wVar.f62882e = wVar.f62881d;
            int unused2 = w.this.f62881d = this.f62883a.findLastCompletelyVisibleItemPosition();
        }
    }

    public class b implements View.OnLayoutChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.Adapter f62885b;

        public b(RecyclerView.Adapter adapter) {
            this.f62885b = adapter;
        }

        public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            if (i14 < i18 && this.f62885b.getItemCount() - 1 == w.this.f62882e) {
                w.this.i(1);
            }
        }
    }

    public class c extends RecyclerView.AdapterDataObserver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecyclerView f62887a;

        public c(RecyclerView recyclerView) {
            this.f62887a = recyclerView;
        }

        public void onItemRangeInserted(int i11, int i12) {
            if (!this.f62887a.canScrollVertically(1)) {
                w.this.i(3);
            }
        }
    }

    public class d implements View.OnLayoutChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ InputBox f62889b;

        public class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f62891b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ int f62892c;

            public a(int i11, int i12) {
                this.f62891b = i11;
                this.f62892c = i12;
            }

            public void run() {
                int paddingLeft = w.this.f62878a.getPaddingLeft();
                int paddingRight = w.this.f62878a.getPaddingRight();
                int paddingTop = w.this.f62878a.getPaddingTop();
                int height = d.this.f62889b.getHeight();
                if (height != w.this.f62878a.getPaddingBottom()) {
                    w.this.f62878a.setPadding(paddingLeft, paddingTop, paddingRight, height);
                    w.this.f62878a.scrollBy(0, this.f62891b - this.f62892c);
                }
            }
        }

        public d(InputBox inputBox) {
            this.f62889b = inputBox;
        }

        public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            w.this.f62878a.post(new a(i16, i12));
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            w.this.i(1);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class f extends n {
        public f(Context context) {
            super(context);
        }

        public int calculateTimeForScrolling(int i11) {
            return 50;
        }
    }

    public class g implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f62896b;

        public g(int i11) {
            this.f62896b = i11;
        }

        public void run() {
            w.this.j(this.f62896b);
        }
    }

    public w(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager, RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        this.f62878a = recyclerView;
        this.f62879b = linearLayoutManager;
        this.f62880c = adapter;
        recyclerView.addOnScrollListener(new a(linearLayoutManager));
        recyclerView.addOnLayoutChangeListener(new b(adapter));
        adapter.registerAdapterDataObserver(new c(recyclerView));
    }

    public void h(InputBox inputBox) {
        inputBox.addOnLayoutChangeListener(new d(inputBox));
        inputBox.i(new e());
    }

    public final void i(int i11) {
        this.f62878a.post(new g(i11));
    }

    public final void j(int i11) {
        int itemCount = this.f62880c.getItemCount() - 1;
        if (itemCount < 0) {
            return;
        }
        if (i11 == 1) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.f62878a.findViewHolderForAdapterPosition(itemCount);
            this.f62879b.scrollToPositionWithOffset(itemCount, (this.f62878a.getPaddingBottom() + (findViewHolderForAdapterPosition != null ? findViewHolderForAdapterPosition.itemView.getHeight() : 0)) * -1);
        } else if (i11 == 3) {
            f fVar = new f(this.f62878a.getContext());
            fVar.setTargetPosition(itemCount);
            this.f62879b.startSmoothScroll(fVar);
        } else if (i11 == 2) {
            n nVar = new n(this.f62878a.getContext());
            nVar.setTargetPosition(itemCount);
            this.f62879b.startSmoothScroll(nVar);
        }
    }
}
