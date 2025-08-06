package zendesk.belvedere;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import zendesk.belvedere.ui.R$anim;
import zendesk.belvedere.ui.R$color;
import zendesk.belvedere.ui.R$drawable;
import zendesk.belvedere.ui.R$id;
import zendesk.belvedere.ui.R$integer;
import zendesk.belvedere.ui.R$layout;
import zendesk.belvedere.ui.R$string;

public class FloatingActionMenu extends LinearLayout implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public FloatingActionButton f62214b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f62215c;

    /* renamed from: d  reason: collision with root package name */
    public final List<androidx.core.util.c<FloatingActionButton, View.OnClickListener>> f62216d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f62217e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f62218f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62219g = true;

    /* renamed from: h  reason: collision with root package name */
    public int f62220h;

    /* renamed from: i  reason: collision with root package name */
    public final c f62221i = new b();

    public class a extends c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ androidx.core.util.c f62222a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(androidx.core.util.c cVar) {
            super((a) null);
            this.f62222a = cVar;
        }

        public void onAnimationEnd(Animation animation) {
            FloatingActionMenu.this.d((View) this.f62222a.f8468a, 4);
        }
    }

    public class b extends c {
        public b() {
            super((a) null);
        }

        public void onAnimationEnd(Animation animation) {
            for (androidx.core.util.c cVar : FloatingActionMenu.this.f62216d) {
                FloatingActionMenu.this.d((View) cVar.f8468a, 8);
            }
        }
    }

    public static abstract class c implements Animation.AnimationListener {
        public c() {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public FloatingActionMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h(context);
    }

    public void c(int i11, int i12, int i13, View.OnClickListener onClickListener) {
        FloatingActionButton floatingActionButton = (FloatingActionButton) this.f62215c.inflate(R$layout.belvedere_floating_action_menu_item, this, false);
        floatingActionButton.setOnClickListener(onClickListener);
        floatingActionButton.setImageDrawable(e(i11, R$color.belvedere_floating_action_menu_item_icon_color));
        floatingActionButton.setId(i12);
        floatingActionButton.setContentDescription(getResources().getString(i13));
        this.f62216d.add(androidx.core.util.c.a(floatingActionButton, onClickListener));
        if (this.f62216d.size() == 1) {
            this.f62214b.setImageDrawable(e(i11, R$color.belvedere_floating_action_menu_icon_color));
            this.f62214b.setContentDescription(getResources().getString(i13));
        } else if (this.f62216d.size() == 2) {
            addView((View) this.f62216d.get(0).f8468a, 0);
            addView(floatingActionButton, 0);
            this.f62214b.setImageDrawable(e(R$drawable.belvedere_fam_icon_add_file, R$color.belvedere_floating_action_menu_icon_color));
            this.f62214b.setContentDescription(getResources().getString(R$string.belvedere_fam_desc_expand_fam));
        } else {
            addView(floatingActionButton, 0);
        }
        if (!this.f62216d.isEmpty()) {
            g();
        }
    }

    public final void d(View view, int i11) {
        if (view != null) {
            view.setVisibility(i11);
        }
    }

    public final Drawable e(int i11, int i12) {
        Context context = getContext();
        Drawable r11 = u0.a.r(ContextCompat.getDrawable(context, i11));
        u0.a.n(r11, ContextCompat.getColor(context, i12));
        return r11;
    }

    public final void f() {
        i(false);
        k(false);
        this.f62214b.setContentDescription(getResources().getString(R$string.belvedere_fam_desc_collapse_fam));
    }

    public void g() {
        if (!this.f62216d.isEmpty()) {
            if (this.f62219g) {
                this.f62214b.setImageResource(R$drawable.belvedere_fam_icon_add_file);
            }
            this.f62219g = false;
        }
    }

    public final void h(Context context) {
        LinearLayout.inflate(context, R$layout.belvedere_floating_action_menu, this);
        if (!isInEditMode()) {
            setOrientation(1);
            setOnClickListener(this);
            FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R$id.floating_action_menu_fab);
            this.f62214b = floatingActionButton;
            floatingActionButton.setOnClickListener(this);
            this.f62215c = LayoutInflater.from(context);
            this.f62220h = getResources().getInteger(R$integer.belvedere_fam_animation_delay_subsequent_item);
            l();
        }
    }

    public final void i(boolean z11) {
        if (z11) {
            this.f62214b.setImageResource(R$drawable.belvedere_fam_icon_close);
        } else {
            this.f62214b.setImageResource(R$drawable.belvedere_fam_icon_add_file);
        }
    }

    public final void j() {
        i(true);
        k(true);
        this.f62214b.setContentDescription(getResources().getString(R$string.belvedere_fam_desc_expand_fam));
    }

    public final void k(boolean z11) {
        if (this.f62216d.isEmpty()) {
            l();
            return;
        }
        long j11 = 0;
        if (z11) {
            for (androidx.core.util.c next : this.f62216d) {
                Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R$anim.belvedere_show_menu_item);
                loadAnimation.setRepeatMode(2);
                loadAnimation.setStartOffset(j11);
                F f11 = next.f8468a;
                if (f11 != null) {
                    d((View) f11, 0);
                    ((FloatingActionButton) next.f8468a).startAnimation(loadAnimation);
                }
                j11 += (long) this.f62220h;
            }
            return;
        }
        Animation animation = null;
        int size = this.f62216d.size() - 1;
        while (size >= 0) {
            androidx.core.util.c cVar = this.f62216d.get(size);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R$anim.belvedere_hide_menu_item);
            loadAnimation2.setRepeatMode(2);
            loadAnimation2.setStartOffset(j11);
            loadAnimation2.setAnimationListener(new a(cVar));
            F f12 = cVar.f8468a;
            if (f12 != null) {
                ((FloatingActionButton) f12).startAnimation(loadAnimation2);
            }
            j11 += (long) this.f62220h;
            size--;
            animation = loadAnimation2;
        }
        if (animation != null) {
            animation.setAnimationListener(this.f62221i);
        }
    }

    public void l() {
        this.f62219g = true;
        if (this.f62218f) {
            f();
        }
        this.f62214b.setImageResource(R$drawable.belvedere_fam_icon_send);
    }

    public final void m() {
        boolean z11 = !this.f62218f;
        this.f62218f = z11;
        if (z11) {
            j();
        } else {
            f();
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        if (this.f62219g && (onClickListener = this.f62217e) != null) {
            onClickListener.onClick(this);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (this.f62216d.isEmpty()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            if (this.f62216d.size() == 1) {
                androidx.core.util.c cVar = this.f62216d.get(0);
                ((View.OnClickListener) cVar.f8469b).onClick((View) cVar.f8468a);
            } else {
                m();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public void setOnSendClickListener(View.OnClickListener onClickListener) {
        this.f62217e = onClickListener;
    }

    public FloatingActionMenu(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        h(context);
    }
}
