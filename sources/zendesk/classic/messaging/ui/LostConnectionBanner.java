package zendesk.classic.messaging.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Slide;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.concurrent.atomic.AtomicReference;
import zendesk.classic.messaging.ConnectionState;
import zendesk.classic.messaging.R$id;
import zendesk.classic.messaging.R$string;

public class LostConnectionBanner {

    /* renamed from: a  reason: collision with root package name */
    public final TransitionSet f62676a;

    /* renamed from: b  reason: collision with root package name */
    public final AnimatorSet f62677b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f62678c;

    /* renamed from: d  reason: collision with root package name */
    public final View f62679d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f62680e;

    /* renamed from: f  reason: collision with root package name */
    public final Button f62681f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicReference<ConnectionState> f62682g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f62683h;

    /* renamed from: i  reason: collision with root package name */
    public State f62684i = State.EXITED;

    public enum State {
        ENTERING,
        ENTERED,
        EXITING,
        EXITED
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (LostConnectionBanner.this.f62683h != null) {
                LostConnectionBanner.this.f62683h.onClick(view);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b extends TransitionListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final int f62686b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ RecyclerView f62687c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ View f62688d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InputBox f62689e;

        public b(RecyclerView recyclerView, View view, InputBox inputBox) {
            this.f62687c = recyclerView;
            this.f62688d = view;
            this.f62689e = inputBox;
            this.f62686b = recyclerView.getPaddingTop();
        }

        public void onTransitionEnd(Transition transition) {
            RecyclerView recyclerView = this.f62687c;
            recyclerView.setPadding(recyclerView.getPaddingLeft(), this.f62687c.getPaddingTop() + this.f62688d.getHeight(), this.f62687c.getPaddingRight(), Math.max(this.f62689e.getHeight(), (this.f62687c.getHeight() - this.f62687c.computeVerticalScrollRange()) - this.f62686b));
            State unused = LostConnectionBanner.this.f62684i = State.ENTERED;
        }

        public void onTransitionStart(Transition transition) {
            State unused = LostConnectionBanner.this.f62684i = State.ENTERING;
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final int f62691b;

        /* renamed from: c  reason: collision with root package name */
        public final int f62692c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.MarginLayoutParams f62693d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecyclerView f62694e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f62695f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InputBox f62696g;

        public c(ViewGroup.MarginLayoutParams marginLayoutParams, RecyclerView recyclerView, View view, InputBox inputBox) {
            this.f62693d = marginLayoutParams;
            this.f62694e = recyclerView;
            this.f62695f = view;
            this.f62696g = inputBox;
            this.f62691b = marginLayoutParams.topMargin;
            this.f62692c = recyclerView.getPaddingBottom();
        }

        public void onAnimationEnd(Animator animator) {
            ViewGroup.MarginLayoutParams marginLayoutParams = this.f62693d;
            marginLayoutParams.topMargin = this.f62691b;
            this.f62695f.setLayoutParams(marginLayoutParams);
            this.f62695f.setVisibility(8);
            RecyclerView recyclerView = this.f62694e;
            recyclerView.setPadding(recyclerView.getPaddingLeft(), this.f62694e.getPaddingTop(), this.f62694e.getPaddingRight(), this.f62692c + this.f62696g.getHeight());
            State unused = LostConnectionBanner.this.f62684i = State.EXITED;
        }

        public void onAnimationStart(Animator animator) {
            State unused = LostConnectionBanner.this.f62684i = State.EXITING;
        }
    }

    public class d extends TransitionListenerAdapter {
        public d() {
        }

        public void onTransitionEnd(Transition transition) {
            LostConnectionBanner.this.e();
            LostConnectionBanner.this.f62676a.removeListener(this);
        }
    }

    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f62699a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f62700b;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|(3:27|28|30)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        static {
            /*
                zendesk.classic.messaging.ui.LostConnectionBanner$State[] r0 = zendesk.classic.messaging.ui.LostConnectionBanner.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f62700b = r0
                r1 = 1
                zendesk.classic.messaging.ui.LostConnectionBanner$State r2 = zendesk.classic.messaging.ui.LostConnectionBanner.State.ENTERING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f62700b     // Catch:{ NoSuchFieldError -> 0x001d }
                zendesk.classic.messaging.ui.LostConnectionBanner$State r3 = zendesk.classic.messaging.ui.LostConnectionBanner.State.ENTERED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f62700b     // Catch:{ NoSuchFieldError -> 0x0028 }
                zendesk.classic.messaging.ui.LostConnectionBanner$State r4 = zendesk.classic.messaging.ui.LostConnectionBanner.State.EXITED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f62700b     // Catch:{ NoSuchFieldError -> 0x0033 }
                zendesk.classic.messaging.ui.LostConnectionBanner$State r5 = zendesk.classic.messaging.ui.LostConnectionBanner.State.EXITING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                zendesk.classic.messaging.ConnectionState[] r4 = zendesk.classic.messaging.ConnectionState.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f62699a = r4
                zendesk.classic.messaging.ConnectionState r5 = zendesk.classic.messaging.ConnectionState.RECONNECTING     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f62699a     // Catch:{ NoSuchFieldError -> 0x004e }
                zendesk.classic.messaging.ConnectionState r4 = zendesk.classic.messaging.ConnectionState.UNREACHABLE     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f62699a     // Catch:{ NoSuchFieldError -> 0x0058 }
                zendesk.classic.messaging.ConnectionState r1 = zendesk.classic.messaging.ConnectionState.FAILED     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f62699a     // Catch:{ NoSuchFieldError -> 0x0062 }
                zendesk.classic.messaging.ConnectionState r1 = zendesk.classic.messaging.ConnectionState.CONNECTING     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f62699a     // Catch:{ NoSuchFieldError -> 0x006d }
                zendesk.classic.messaging.ConnectionState r1 = zendesk.classic.messaging.ConnectionState.CONNECTED     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f62699a     // Catch:{ NoSuchFieldError -> 0x0078 }
                zendesk.classic.messaging.ConnectionState r1 = zendesk.classic.messaging.ConnectionState.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.classic.messaging.ui.LostConnectionBanner.e.<clinit>():void");
        }
    }

    public LostConnectionBanner(ViewGroup viewGroup, RecyclerView recyclerView, InputBox inputBox, View view) {
        this.f62678c = viewGroup;
        this.f62679d = view;
        this.f62682g = new AtomicReference<>(ConnectionState.DISCONNECTED);
        this.f62680e = (TextView) view.findViewById(R$id.zui_lost_connection_label);
        int i11 = R$id.zui_lost_connection_button;
        this.f62681f = (Button) view.findViewById(i11);
        view.findViewById(i11).setOnClickListener(new a());
        TransitionSet r11 = new TransitionSet().s(0).g(new Slide(48)).setInterpolator(new DecelerateInterpolator());
        long j11 = MessagingView.f62727e;
        this.f62676a = r11.setDuration(j11).addListener(new b(recyclerView, view, inputBox));
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        AnimatorSet animatorSet = new AnimatorSet();
        this.f62677b = animatorSet;
        int i12 = marginLayoutParams.topMargin;
        animatorSet.playTogether(new Animator[]{d0.b(recyclerView, recyclerView.getPaddingTop(), recyclerView.getPaddingTop() - view.getHeight(), j11), d0.a(view, i12, i12 - view.getHeight(), j11)});
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.addListener(new c(marginLayoutParams, recyclerView, view, inputBox));
    }

    public static LostConnectionBanner d(ViewGroup viewGroup, RecyclerView recyclerView, InputBox inputBox) {
        return new LostConnectionBanner(viewGroup, recyclerView, inputBox, viewGroup.findViewById(R$id.zui_lost_connection_view));
    }

    public void e() {
        int i11 = e.f62700b[this.f62684i.ordinal()];
        if (i11 == 1) {
            this.f62676a.addListener(new d());
        } else if (i11 != 3 && i11 != 4) {
            this.f62677b.start();
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.f62683h = onClickListener;
    }

    public void g() {
        int i11 = e.f62700b[this.f62684i.ordinal()];
        if (i11 != 1 && i11 != 2) {
            TransitionManager.b(this.f62678c, this.f62676a);
            this.f62679d.setVisibility(0);
        }
    }

    public void h(ConnectionState connectionState) {
        if (this.f62682g.getAndSet(connectionState) != connectionState) {
            switch (e.f62699a[connectionState.ordinal()]) {
                case 1:
                    this.f62680e.setText(R$string.zui_label_reconnecting);
                    this.f62681f.setVisibility(8);
                    g();
                    return;
                case 2:
                    this.f62680e.setText(R$string.zui_label_reconnecting_failed);
                    this.f62681f.setVisibility(8);
                    g();
                    return;
                case 3:
                    this.f62680e.setText(R$string.zui_label_reconnecting_failed);
                    this.f62681f.setVisibility(0);
                    g();
                    return;
                case 4:
                case 5:
                case 6:
                    e();
                    return;
                default:
                    return;
            }
        }
    }
}
