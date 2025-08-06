package zendesk.classic.messaging.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.squareup.picasso.Picasso;
import g30.f;
import java.util.concurrent.TimeUnit;
import zendesk.classic.messaging.R$id;
import zendesk.classic.messaging.R$layout;
import zendesk.classic.messaging.e;
import zendesk.commonui.AlmostRealProgressBar;

public class MessagingView extends CoordinatorLayout {

    /* renamed from: e  reason: collision with root package name */
    public static final long f62727e = TimeUnit.MILLISECONDS.toMillis(300);

    /* renamed from: b  reason: collision with root package name */
    public final AlmostRealProgressBar f62728b;

    /* renamed from: c  reason: collision with root package name */
    public final e f62729c;

    /* renamed from: d  reason: collision with root package name */
    public final LostConnectionBanner f62730d;

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f62731b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f62732c;

        public a(f fVar, e eVar) {
            this.f62731b = fVar;
            this.f62732c = eVar;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f62731b.a(this.f62732c.h());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public MessagingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(MessagingState messagingState, p pVar, Picasso picasso, f fVar, e eVar) {
        if (messagingState != null) {
            this.f62729c.e(pVar.i(messagingState.f62709a, messagingState.f62712d, picasso, messagingState.f62715g));
            if (messagingState.f62710b) {
                this.f62728b.n(AlmostRealProgressBar.f62909h);
            } else {
                this.f62728b.p(300);
            }
            this.f62730d.h(messagingState.f62713e);
            this.f62730d.f(new a(fVar, eVar));
        }
    }

    public MessagingView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        LayoutInflater.from(context).inflate(R$layout.zui_view_messaging, this, true);
        this.f62728b = (AlmostRealProgressBar) findViewById(R$id.zui_progressBar);
        e eVar = new e();
        this.f62729c = eVar;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        RecyclerView recyclerView = (RecyclerView) findViewById(R$id.zui_recycler_view);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(eVar);
        recyclerView.getRecycledViewPool().m(R$layout.zui_cell_response_options_stacked, 0);
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        long j11 = f62727e;
        defaultItemAnimator.setAddDuration(j11);
        defaultItemAnimator.setChangeDuration(j11);
        defaultItemAnimator.setRemoveDuration(j11);
        defaultItemAnimator.setMoveDuration(j11);
        defaultItemAnimator.setSupportsChangeAnimations(false);
        recyclerView.setItemAnimator(defaultItemAnimator);
        InputBox inputBox = (InputBox) findViewById(R$id.zui_input_box);
        this.f62730d = LostConnectionBanner.d(this, recyclerView, inputBox);
        new w(recyclerView, linearLayoutManager, eVar).h(inputBox);
    }
}
