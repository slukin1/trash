package zendesk.classic.messaging.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.squareup.picasso.Picasso;
import zendesk.classic.messaging.R$dimen;
import zendesk.classic.messaging.R$drawable;
import zendesk.classic.messaging.R$id;
import zendesk.classic.messaging.R$layout;

public class AgentImageCellView extends LinearLayout implements a0<b> {

    /* renamed from: b  reason: collision with root package name */
    public final Drawable f62585b = ContextCompat.getDrawable(getContext(), R$drawable.zui_background_agent_cell);

    /* renamed from: c  reason: collision with root package name */
    public AvatarView f62586c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f62587d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62588e;

    /* renamed from: f  reason: collision with root package name */
    public View f62589f;

    /* renamed from: g  reason: collision with root package name */
    public View f62590g;

    /* renamed from: h  reason: collision with root package name */
    public int f62591h;

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f62592b;

        public a(b bVar) {
            this.f62592b = bVar;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f62592b.a();
            throw null;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Picasso f62594a;

        /* renamed from: b  reason: collision with root package name */
        public final r f62595b;

        /* renamed from: c  reason: collision with root package name */
        public final String f62596c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f62597d;

        /* renamed from: e  reason: collision with root package name */
        public final g30.a f62598e;

        /* renamed from: f  reason: collision with root package name */
        public final a f62599f;

        /* renamed from: g  reason: collision with root package name */
        public final c f62600g;

        public b(Picasso picasso, r rVar, g30.a aVar, String str, boolean z11, a aVar2, c cVar) {
            this.f62594a = picasso;
            this.f62595b = rVar;
            this.f62596c = str;
            this.f62597d = z11;
            this.f62599f = aVar2;
            this.f62600g = cVar;
        }

        public g30.a a() {
            return this.f62598e;
        }

        public a b() {
            return this.f62599f;
        }

        public c c() {
            return this.f62600g;
        }

        public String d() {
            return this.f62596c;
        }

        public Picasso e() {
            return this.f62594a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (g() != bVar.g()) {
                return false;
            }
            if (e() == null ? bVar.e() != null : !e().equals(bVar.e())) {
                return false;
            }
            if (f() == null ? bVar.f() != null : !f().equals(bVar.f())) {
                return false;
            }
            if (d() == null ? bVar.d() != null : !d().equals(bVar.d())) {
                return false;
            }
            a();
            bVar.a();
            if (b() != null) {
                return b().equals(bVar.b());
            }
            if (bVar.b() == null) {
                return true;
            }
            return false;
        }

        public r f() {
            return this.f62595b;
        }

        public boolean g() {
            return this.f62597d;
        }

        public int hashCode() {
            int i11 = 0;
            int hashCode = (((e() != null ? e().hashCode() : 0) * 31) + (f() != null ? f().hashCode() : 0)) * 31;
            int hashCode2 = d() != null ? d().hashCode() : 0;
            a();
            int i12 = (((((hashCode + hashCode2) * 31) + (g() ? 1 : 0)) * 31) + 0) * 31;
            if (b() != null) {
                i11 = b().hashCode();
            }
            return i12 + i11;
        }
    }

    public AgentImageCellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public final void a() {
        setOrientation(0);
        LinearLayout.inflate(getContext(), R$layout.zui_view_agent_image_cell_content, this);
        this.f62591h = getResources().getDimensionPixelSize(R$dimen.zui_cell_bubble_corner_radius);
    }

    public final void b(b bVar) {
        bVar.e();
        bVar.a();
        throw null;
    }

    /* renamed from: c */
    public void update(b bVar) {
        b(bVar);
        this.f62588e.setText(bVar.d());
        this.f62590g.setVisibility(bVar.g() ? 0 : 8);
        this.f62587d.setOnClickListener(new a(bVar));
        bVar.c().a(bVar.b(), this.f62586c);
        bVar.f().c(this, this.f62589f, this.f62586c);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f62586c = (AvatarView) findViewById(R$id.zui_agent_message_avatar);
        this.f62587d = (ImageView) findViewById(R$id.zui_image_cell_image);
        this.f62589f = findViewById(R$id.zui_cell_status_view);
        this.f62588e = (TextView) findViewById(R$id.zui_cell_label_text_field);
        this.f62590g = findViewById(R$id.zui_cell_label_supplementary_label);
    }

    public AgentImageCellView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a();
    }
}
