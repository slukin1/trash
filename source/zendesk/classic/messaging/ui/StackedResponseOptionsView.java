package zendesk.classic.messaging.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxItemDecoration;
import com.google.android.flexbox.FlexboxLayoutManager;
import zendesk.classic.messaging.MessagingItem;
import zendesk.classic.messaging.R$drawable;
import zendesk.classic.messaging.R$id;
import zendesk.classic.messaging.R$layout;

public class StackedResponseOptionsView extends FrameLayout implements a0<z> {

    /* renamed from: b  reason: collision with root package name */
    public y f62738b;

    public class a implements x {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ z f62739a;

        public a(z zVar) {
            this.f62739a = zVar;
        }

        public void a(MessagingItem.g gVar) {
            StackedResponseOptionsView.this.f62738b.k(gVar);
            this.f62739a.a().a(gVar);
        }
    }

    public StackedResponseOptionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public final void b() {
        FrameLayout.inflate(getContext(), R$layout.zui_view_response_options_content, this);
    }

    /* renamed from: c */
    public void update(z zVar) {
        zVar.c().a(this);
        this.f62738b.j(new a(zVar));
        this.f62738b.e(zVar.b());
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        RecyclerView recyclerView = (RecyclerView) findViewById(R$id.zui_response_options_recycler);
        recyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
        FlexboxItemDecoration flexboxItemDecoration = new FlexboxItemDecoration(getContext());
        flexboxItemDecoration.setOrientation(3);
        Drawable drawable = ContextCompat.getDrawable(getContext(), R$drawable.zui_view_stacked_response_options_divider);
        if (drawable != null) {
            flexboxItemDecoration.setDrawable(drawable);
        }
        recyclerView.setLayoutManager(new FlexboxLayoutManager(getContext(), 1));
        recyclerView.addItemDecoration(flexboxItemDecoration);
        y yVar = new y();
        this.f62738b = yVar;
        recyclerView.setAdapter(yVar);
    }

    public StackedResponseOptionsView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b();
    }
}
