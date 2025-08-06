package gp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.badge.BadgeDrawable;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$dimen;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.bean.ReminderData;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import jp.v1;
import net.lucode.hackware.magicindicator.buildins.UIUtil;

public class g implements d {

    /* renamed from: h  reason: collision with root package name */
    public static final Object f84149h = new Object();

    /* renamed from: a  reason: collision with root package name */
    public View f84150a;

    /* renamed from: b  reason: collision with root package name */
    public View f84151b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f84152c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f84153d;

    /* renamed from: e  reason: collision with root package name */
    public ga.a f84154e;

    /* renamed from: f  reason: collision with root package name */
    public ReminderData f84155f;

    /* renamed from: g  reason: collision with root package name */
    public List<C0864g> f84156g = new ArrayList();

    public class a implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f84157a;

        public a(View view) {
            this.f84157a = view;
        }

        public void onSuccess() {
            i6.d.b("startShowAnimation");
            g.this.x(this.f84157a);
        }
    }

    public class b extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReminderData f84159a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f84160b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(long j11, long j12, ReminderData reminderData, TextView textView) {
            super(j11, j12);
            this.f84159a = reminderData;
            this.f84160b = textView;
        }

        public void onFinish() {
            g.this.dismiss();
        }

        public void onTick(long j11) {
            i6.d.b(j11 + "");
            this.f84159a.setRemindTime((int) (j11 / 1000));
            this.f84160b.setText(this.f84159a.getReminderTimeStr());
            TextView textView = this.f84160b;
            textView.setTextColor(g.this.r(textView, this.f84159a));
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f84162b;

        public c(View view) {
            this.f84162b = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f84162b.setVisibility(8);
        }
    }

    public class d implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f84164a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f84165b;

        public d(boolean z11, View view) {
            this.f84164a = z11;
            this.f84165b = view;
        }

        public void onSuccess() {
            if (this.f84164a) {
                g.this.w(this.f84165b);
            } else {
                g.this.f84150a.setVisibility(0);
            }
        }
    }

    public class e implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f84167b;

        public e(View view) {
            this.f84167b = view;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            CountDownTimer countDownTimer = (CountDownTimer) ((TextView) this.f84167b.findViewById(R$id.tv_time_counter)).getTag();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            ViewParent parent = this.f84167b.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.f84167b);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public interface f {
        void onSuccess();
    }

    /* renamed from: gp.g$g  reason: collision with other inner class name */
    public interface C0864g {
        void a(ReminderData reminderData);
    }

    public g(ga.a aVar) {
        this.f84154e = aVar;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void s(ReminderData reminderData, View view) {
        v(reminderData, view.getContext());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(View view, f fVar) {
        if (this.f84155f != null) {
            view.setVisibility(0);
            if (fVar != null) {
                fVar.onSuccess();
            }
        }
    }

    public void a(ReminderData reminderData) {
        if (this.f84150a != null) {
            u(reminderData);
            View view = this.f84150a;
            h((BaseCoreActivity) view.getContext());
            this.f84154e.d(this.f84150a);
            boolean z11 = false;
            if (this.f84154e.a() != null) {
                z11 = true;
                FrameLayout a11 = this.f84154e.a();
                View view2 = this.f84150a;
                a11.addView(view2, view2.getLayoutParams());
            }
            p(this.f84150a, reminderData, new d(z11, view));
        }
    }

    public void b() {
        int width = (this.f84150a.getWidth() - this.f84152c.getWidth()) - UIUtil.a(this.f84152c.getContext(), 15.0d);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f84150a, "translationX", new float[]{(float) width, 0.0f});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.start();
    }

    public void c() {
        int width = (this.f84150a.getWidth() - this.f84152c.getWidth()) - UIUtil.a(this.f84152c.getContext(), 15.0d);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f84150a, "translationX", new float[]{0.0f, (float) width});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.start();
    }

    public View d(BaseCoreActivity baseCoreActivity) {
        View h11 = h(baseCoreActivity);
        p(h11, this.f84155f, (f) null);
        return h11;
    }

    public void dismiss() {
        View e11 = this.f84154e.e();
        if (e11 == null || e11.getVisibility() != 0 || this.f84155f == null) {
            u((ReminderData) null);
            if (e11 != null) {
                e11.setVisibility(8);
                return;
            }
            return;
        }
        u((ReminderData) null);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(e11, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(e11, "translationX", new float[]{0.0f, (float) e11.getWidth()});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat2).with(ofFloat);
        animatorSet.setDuration(320);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.addListener(new c(e11));
        animatorSet.start();
    }

    public void e(ReminderData reminderData) {
        View e11 = this.f84154e.e();
        if (reminderData != null && reminderData.getOrderId() != 0) {
            u(reminderData);
            i6.d.b("show:" + reminderData.toString());
            if (e11 != null) {
                p(e11, reminderData, new a(e11));
            }
        } else if (e11 != null) {
            e11.setVisibility(8);
        }
    }

    public void f(C0864g gVar) {
        synchronized (f84149h) {
            this.f84156g.remove(gVar);
        }
    }

    public ReminderData g() {
        return this.f84155f;
    }

    public View h(BaseCoreActivity baseCoreActivity) {
        View inflate = View.inflate(baseCoreActivity, R$layout.layout_otc_reminder, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = baseCoreActivity.getResources().getDimensionPixelSize(R$dimen.dimen_85);
        layoutParams.gravity = BadgeDrawable.BOTTOM_END;
        inflate.setLayoutParams(layoutParams);
        this.f84150a = inflate;
        this.f84153d = (LinearLayout) inflate.findViewById(R$id.ll_text_content);
        this.f84151b = this.f84150a.findViewById(R$id.ll_content_root);
        this.f84152c = (ImageView) this.f84150a.findViewById(R$id.iv_logo);
        this.f84150a.setVisibility(8);
        i6.d.b("test0809 createview gone " + inflate.toString());
        return inflate;
    }

    public void i(C0864g gVar) {
        synchronized (f84149h) {
            this.f84156g.add(gVar);
        }
    }

    public final void p(View view, ReminderData reminderData, f fVar) {
        if (reminderData == null || reminderData.getOrderId() == 0) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(4);
        ImageView imageView = (ImageView) view.findViewById(R$id.iv_logo);
        ((TextView) view.findViewById(R$id.tv_title)).setText(reminderData.getTitle());
        q(reminderData, (TextView) view.findViewById(R$id.tv_time_counter));
        ((TextView) view.findViewById(R$id.tv_desc)).setText(reminderData.getDesc());
        view.setOnClickListener(new e(this, reminderData));
        view.post(new f(this, view, fVar));
    }

    public final void q(ReminderData reminderData, TextView textView) {
        if (reminderData.getRemindTime() == 0 || reminderData.getTradeType() != 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(reminderData.getReminderTimeStr());
        textView.setTextColor(r(textView, reminderData));
        i6.d.b(reminderData.getReminderTimeStr());
        if (textView.getTag() != null) {
            ((CountDownTimer) textView.getTag()).cancel();
        }
        b bVar = new b((long) (reminderData.getRemindTime() * 1000), 1000, reminderData, textView);
        textView.setTag(bVar);
        bVar.start();
    }

    public final int r(TextView textView, ReminderData reminderData) {
        if (reminderData.getRemindTime() > 300) {
            return textView.getResources().getColor(R$color.otc_reminder_time_orange);
        }
        return textView.getResources().getColor(R$color.color_D14B64);
    }

    public final void u(ReminderData reminderData) {
        synchronized (f84149h) {
            this.f84155f = reminderData;
            for (C0864g next : this.f84156g) {
                if (next != null) {
                    next.a(reminderData);
                }
            }
        }
    }

    public final void v(ReminderData reminderData, Context context) {
        if (!reminderData.isBuy() || reminderData.getStatus() != 0) {
            v1.a().g(context, String.valueOf(reminderData.getOrderId()), false);
        } else {
            OtcModuleConfig.a().d0(context, String.valueOf(reminderData.getOrderId()), "", "");
        }
    }

    public final void w(View view) {
        int width = view.getWidth();
        i6.d.b("startReplaceAnimation oldWidth=" + width);
        int width2 = this.f84150a.getWidth();
        i6.d.b("startReplaceAnimation newWidth=" + width2);
        int i11 = width2 - width;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f84150a, "translationX", new float[]{(float) i11, 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f84150a, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        animatorSet.start();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "translationX", new float[]{0.0f, (float) (-i11)});
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f});
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(ofFloat3).with(ofFloat4);
        ofFloat3.setDuration(300);
        ofFloat3.setInterpolator(new DecelerateInterpolator());
        animatorSet2.addListener(new e(view));
        animatorSet2.start();
    }

    public final void x(View view) {
        i6.d.b("#animation#show# x " + view.getWidth() + " " + 0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", new float[]{(float) view.getWidth(), 0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat2).with(ofFloat);
        animatorSet.setDuration(320);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.start();
    }
}
