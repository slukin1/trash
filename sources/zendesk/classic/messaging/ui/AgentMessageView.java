package zendesk.classic.messaging.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import zendesk.classic.messaging.R$color;
import zendesk.classic.messaging.R$id;
import zendesk.classic.messaging.R$layout;
import zendesk.commonui.UiUtils;

public class AgentMessageView extends LinearLayout implements a0<a> {

    /* renamed from: b  reason: collision with root package name */
    public AvatarView f62601b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62602c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62603d;

    /* renamed from: e  reason: collision with root package name */
    public View f62604e;

    /* renamed from: f  reason: collision with root package name */
    public View f62605f;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final r f62606a;

        /* renamed from: b  reason: collision with root package name */
        public final String f62607b;

        /* renamed from: c  reason: collision with root package name */
        public final String f62608c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f62609d;

        /* renamed from: e  reason: collision with root package name */
        public final a f62610e;

        /* renamed from: f  reason: collision with root package name */
        public final c f62611f;

        public a(r rVar, String str, String str2, boolean z11, a aVar, c cVar) {
            this.f62606a = rVar;
            this.f62607b = str;
            this.f62608c = str2;
            this.f62609d = z11;
            this.f62610e = aVar;
            this.f62611f = cVar;
        }

        public a a() {
            return this.f62610e;
        }

        public c b() {
            return this.f62611f;
        }

        public String c() {
            return this.f62608c;
        }

        public String d() {
            return this.f62607b;
        }

        public r e() {
            return this.f62606a;
        }

        public boolean f() {
            return this.f62609d;
        }
    }

    public AgentMessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public final void a() {
        setOrientation(0);
        LinearLayout.inflate(getContext(), R$layout.zui_view_text_response_content, this);
        setClickable(false);
    }

    /* renamed from: b */
    public void update(a aVar) {
        this.f62602c.setText(aVar.d());
        this.f62602c.requestLayout();
        this.f62603d.setText(aVar.c());
        this.f62605f.setVisibility(aVar.f() ? 0 : 8);
        aVar.b().a(aVar.a(), this.f62601b);
        aVar.e().c(this, this.f62604e, this.f62601b);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f62601b = (AvatarView) findViewById(R$id.zui_agent_message_avatar);
        this.f62602c = (TextView) findViewById(R$id.zui_agent_message_cell_text_field);
        this.f62604e = findViewById(R$id.zui_cell_status_view);
        this.f62603d = (TextView) findViewById(R$id.zui_cell_label_text_field);
        this.f62605f = findViewById(R$id.zui_cell_label_supplementary_label);
        this.f62603d.setTextColor(UiUtils.a(R$color.zui_text_color_dark_secondary, getContext()));
        this.f62602c.setTextColor(UiUtils.a(R$color.zui_text_color_dark_primary, getContext()));
    }

    public AgentMessageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a();
    }
}
