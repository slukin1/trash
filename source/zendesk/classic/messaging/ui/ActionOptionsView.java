package zendesk.classic.messaging.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import zendesk.classic.messaging.R$drawable;
import zendesk.classic.messaging.R$id;
import zendesk.classic.messaging.R$layout;

public class ActionOptionsView extends LinearLayout implements a0<b> {

    /* renamed from: b  reason: collision with root package name */
    public AvatarView f62552b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62553c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62554d;

    /* renamed from: e  reason: collision with root package name */
    public View f62555e;

    /* renamed from: f  reason: collision with root package name */
    public View f62556f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f62557g;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f62558a;

        /* renamed from: b  reason: collision with root package name */
        public final View.OnClickListener f62559b;

        public a(String str, View.OnClickListener onClickListener) {
            this.f62558a = str;
            this.f62559b = onClickListener;
        }

        public String a() {
            return this.f62558a;
        }

        public View.OnClickListener b() {
            return this.f62559b;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f62560a;

        /* renamed from: b  reason: collision with root package name */
        public final String f62561b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f62562c;

        /* renamed from: d  reason: collision with root package name */
        public final r f62563d;

        /* renamed from: e  reason: collision with root package name */
        public final List<a> f62564e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f62565f;

        /* renamed from: g  reason: collision with root package name */
        public final a f62566g;

        /* renamed from: h  reason: collision with root package name */
        public final c f62567h;

        public b(String str, String str2, boolean z11, r rVar, List<a> list, boolean z12, a aVar, c cVar) {
            this.f62560a = str;
            this.f62561b = str2;
            this.f62562c = z11;
            this.f62563d = rVar;
            this.f62564e = list;
            this.f62565f = z12;
            this.f62566g = aVar;
            this.f62567h = cVar;
        }

        public List<a> a() {
            return this.f62564e;
        }

        public a b() {
            return this.f62566g;
        }

        public c c() {
            return this.f62567h;
        }

        public String d() {
            return this.f62560a;
        }

        public String e() {
            return this.f62561b;
        }

        public r f() {
            return this.f62563d;
        }

        public boolean g() {
            return this.f62562c;
        }

        public boolean h() {
            return this.f62565f;
        }
    }

    public ActionOptionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public final void a() {
        setOrientation(0);
        LinearLayout.inflate(getContext(), R$layout.zui_view_action_options_content, this);
        this.f62552b = (AvatarView) findViewById(R$id.zui_agent_message_avatar);
        this.f62553c = (TextView) findViewById(R$id.zui_answer_bot_action_options_header);
        this.f62555e = findViewById(R$id.zui_cell_status_view);
        this.f62554d = (TextView) findViewById(R$id.zui_cell_label_text_field);
        this.f62556f = findViewById(R$id.zui_cell_label_supplementary_label);
        this.f62557g = (ViewGroup) findViewById(R$id.zui_cell_action_options_container);
    }

    /* renamed from: b */
    public void update(b bVar) {
        this.f62553c.setText(bVar.d());
        this.f62554d.setText(bVar.e());
        this.f62556f.setVisibility(bVar.g() ? 0 : 8);
        c(bVar.a(), bVar.h());
        bVar.c().a(bVar.b(), this.f62552b);
        bVar.f().c(this, this.f62555e, this.f62552b);
    }

    public final void c(List<a> list, boolean z11) {
        this.f62557g.removeAllViews();
        this.f62557g.addView(this.f62553c);
        LayoutInflater from = LayoutInflater.from(getContext());
        for (a next : list) {
            View inflate = from.inflate(R$layout.zui_view_action_option, this.f62557g, false);
            ((TextView) inflate.findViewById(R$id.zui_action_option_name)).setText(next.a());
            inflate.setOnClickListener(next.b());
            if (list.indexOf(next) == list.size() - 1) {
                inflate.setBackgroundResource(R$drawable.zui_background_cell_options_footer);
            }
            inflate.setEnabled(z11);
            this.f62557g.addView(inflate);
        }
    }

    public ActionOptionsView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a();
    }
}
