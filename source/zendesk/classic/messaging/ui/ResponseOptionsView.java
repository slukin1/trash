package zendesk.classic.messaging.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.h0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import zendesk.classic.messaging.MessagingItem;
import zendesk.classic.messaging.R$dimen;
import zendesk.classic.messaging.R$id;
import zendesk.classic.messaging.R$layout;

public class ResponseOptionsView extends FrameLayout implements a0<z> {

    /* renamed from: b  reason: collision with root package name */
    public y f62734b;

    public class a implements x {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ z f62735a;

        public a(z zVar) {
            this.f62735a = zVar;
        }

        public void a(MessagingItem.g gVar) {
            ResponseOptionsView.this.f62734b.e(Collections.singletonList(gVar));
            this.f62735a.a().a(gVar);
        }
    }

    public static class b extends RecyclerView.ItemDecoration {

        /* renamed from: a  reason: collision with root package name */
        public int f62737a;

        public b(Context context, int i11) {
            this.f62737a = context.getResources().getDimensionPixelSize(i11);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (childAdapterPosition != -1) {
                boolean z11 = true;
                boolean z12 = childAdapterPosition == 0;
                if (h0.F(recyclerView) != 0) {
                    z11 = false;
                }
                if (z11) {
                    if (!z12) {
                        rect.set(0, 0, this.f62737a, 0);
                    }
                } else if (!z12) {
                    rect.set(this.f62737a, 0, 0, 0);
                }
            }
        }
    }

    public ResponseOptionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public final void b() {
        FrameLayout.inflate(getContext(), R$layout.zui_view_response_options_content, this);
    }

    /* renamed from: c */
    public void update(z zVar) {
        zVar.c().a(this);
        this.f62734b.j(new a(zVar));
        this.f62734b.e(zVar.b());
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        RecyclerView recyclerView = (RecyclerView) findViewById(R$id.zui_response_options_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, true));
        y yVar = new y();
        this.f62734b = yVar;
        recyclerView.setAdapter(yVar);
        recyclerView.addItemDecoration(new b(getContext(), R$dimen.zui_cell_response_options_horizontal_spacing));
    }

    public ResponseOptionsView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b();
    }
}
