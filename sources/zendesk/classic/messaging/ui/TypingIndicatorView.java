package zendesk.classic.messaging.ui;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import zendesk.classic.messaging.R$id;
import zendesk.classic.messaging.R$layout;

public class TypingIndicatorView extends LinearLayout implements a0<b> {

    /* renamed from: b  reason: collision with root package name */
    public AvatarView f62744b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62745c;

    /* renamed from: d  reason: collision with root package name */
    public View f62746d;

    /* renamed from: e  reason: collision with root package name */
    public View f62747e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f62748f;

    /* renamed from: g  reason: collision with root package name */
    public final Animatable2Compat$AnimationCallback f62749g = new a();

    public class a extends Animatable2Compat$AnimationCallback {

        /* renamed from: zendesk.classic.messaging.ui.TypingIndicatorView$a$a  reason: collision with other inner class name */
        public class C0692a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Drawable f62751b;

            public C0692a(Drawable drawable) {
                this.f62751b = drawable;
            }

            public void run() {
                ((Animatable) this.f62751b).start();
            }
        }

        public a() {
        }

        public void onAnimationEnd(Drawable drawable) {
            TypingIndicatorView.this.post(new C0692a(drawable));
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final r f62753a;

        /* renamed from: b  reason: collision with root package name */
        public final String f62754b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f62755c;

        /* renamed from: d  reason: collision with root package name */
        public final a f62756d;

        /* renamed from: e  reason: collision with root package name */
        public final c f62757e;

        public b(r rVar, String str, boolean z11, a aVar, c cVar) {
            this.f62753a = rVar;
            this.f62754b = str;
            this.f62755c = z11;
            this.f62756d = aVar;
            this.f62757e = cVar;
        }

        public a a() {
            return this.f62756d;
        }

        public c b() {
            return this.f62757e;
        }

        public String c() {
            return this.f62754b;
        }

        public r d() {
            return this.f62753a;
        }

        public boolean e() {
            return this.f62755c;
        }
    }

    public TypingIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public final void a() {
        setOrientation(0);
        LinearLayout.inflate(getContext(), R$layout.zui_view_typing_indicator_content, this);
    }

    public final void b() {
        Drawable drawable = this.f62748f.getDrawable();
        androidx.vectordrawable.graphics.drawable.b.d(drawable, this.f62749g);
        ((Animatable) drawable).start();
    }

    /* renamed from: c */
    public void update(b bVar) {
        if (bVar.c() != null) {
            this.f62745c.setText(bVar.c());
        }
        this.f62747e.setVisibility(bVar.e() ? 0 : 8);
        bVar.b().a(bVar.a(), this.f62744b);
        bVar.d().c(this, this.f62746d, this.f62744b);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f62744b = (AvatarView) findViewById(R$id.zui_agent_message_avatar);
        this.f62746d = findViewById(R$id.zui_cell_status_view);
        this.f62745c = (TextView) findViewById(R$id.zui_cell_label_text_field);
        this.f62747e = findViewById(R$id.zui_cell_label_supplementary_label);
        this.f62748f = (ImageView) findViewById(R$id.zui_cell_typing_indicator_image);
        b();
    }

    public TypingIndicatorView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a();
    }
}
