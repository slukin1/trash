package zendesk.classic.messaging.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import zendesk.classic.messaging.R$drawable;
import zendesk.classic.messaging.R$id;
import zendesk.classic.messaging.R$layout;
import zendesk.classic.messaging.R$string;

public class ArticlesResponseView extends LinearLayout implements a0<c> {

    /* renamed from: b  reason: collision with root package name */
    public AvatarView f62612b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62613c;

    /* renamed from: d  reason: collision with root package name */
    public View f62614d;

    /* renamed from: e  reason: collision with root package name */
    public View f62615e;

    /* renamed from: f  reason: collision with root package name */
    public View f62616f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f62617g;

    /* renamed from: h  reason: collision with root package name */
    public View f62618h;

    /* renamed from: i  reason: collision with root package name */
    public View f62619i;

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f62620b;

        public a(b bVar) {
            this.f62620b = bVar;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f62620b.a().a(ArticlesResponseView.this.getContext());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f62622a;

        /* renamed from: b  reason: collision with root package name */
        public final String f62623b;

        /* renamed from: c  reason: collision with root package name */
        public final v f62624c;

        public b(String str, String str2, v vVar) {
            this.f62622a = str;
            this.f62623b = str2;
            this.f62624c = vVar;
        }

        public v a() {
            return this.f62624c;
        }

        public String b() {
            return this.f62623b;
        }

        public String c() {
            return this.f62622a;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f62625a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f62626b;

        /* renamed from: c  reason: collision with root package name */
        public final r f62627c;

        /* renamed from: d  reason: collision with root package name */
        public final List<b> f62628d;

        /* renamed from: e  reason: collision with root package name */
        public final a f62629e;

        /* renamed from: f  reason: collision with root package name */
        public final c f62630f;

        public c(String str, boolean z11, r rVar, List<b> list, a aVar, c cVar) {
            this.f62625a = str;
            this.f62626b = z11;
            this.f62627c = rVar;
            this.f62628d = list;
            this.f62629e = aVar;
            this.f62630f = cVar;
        }

        public List<b> a() {
            return this.f62628d;
        }

        public a b() {
            return this.f62629e;
        }

        public c c() {
            return this.f62630f;
        }

        public b d() {
            if (this.f62628d.size() >= 1) {
                return this.f62628d.get(0);
            }
            return null;
        }

        public int e() {
            if (this.f62628d.size() == 1) {
                return R$string.zui_cell_text_suggested_article_header;
            }
            return R$string.zui_cell_text_suggested_articles_header;
        }

        public String f() {
            return this.f62625a;
        }

        public r g() {
            return this.f62627c;
        }

        public b h() {
            if (this.f62628d.size() >= 2) {
                return this.f62628d.get(1);
            }
            return null;
        }

        public b i() {
            if (this.f62628d.size() >= 3) {
                return this.f62628d.get(2);
            }
            return null;
        }

        public boolean j() {
            return this.f62626b;
        }
    }

    public ArticlesResponseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    private void setSuggestionBackgrounds(List<b> list) {
        ArrayList<View> arrayList = new ArrayList<>(Arrays.asList(new View[]{this.f62614d, this.f62615e, this.f62616f}));
        for (View view : arrayList) {
            if (arrayList.indexOf(view) == list.size() - 1) {
                view.setBackgroundResource(R$drawable.zui_background_cell_options_footer);
            } else {
                view.setBackgroundResource(R$drawable.zui_background_cell_options_content);
            }
        }
    }

    public final void a(b bVar, View view) {
        view.setVisibility(bVar != null ? 0 : 8);
        if (bVar != null) {
            a aVar = new a(bVar);
            ((TextView) view.findViewById(R$id.zui_article_title)).setText(bVar.c());
            ((TextView) view.findViewById(R$id.zui_article_snippet)).setText(bVar.b());
            view.setOnClickListener(aVar);
        }
    }

    public final void b() {
        setOrientation(0);
        LinearLayout.inflate(getContext(), R$layout.zui_view_articles_response_content, this);
    }

    /* renamed from: c */
    public void update(c cVar) {
        this.f62617g.setText(cVar.f());
        this.f62619i.setVisibility(cVar.j() ? 0 : 8);
        cVar.c().a(cVar.b(), this.f62612b);
        cVar.g().c(this, this.f62618h, this.f62612b);
        this.f62613c.setText(cVar.e());
        a(cVar.d(), this.f62614d);
        a(cVar.h(), this.f62615e);
        a(cVar.i(), this.f62616f);
        setSuggestionBackgrounds(cVar.a());
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f62612b = (AvatarView) findViewById(R$id.zui_agent_message_avatar);
        this.f62613c = (TextView) findViewById(R$id.zui_header_article_suggestions);
        this.f62614d = findViewById(R$id.zui_first_article_suggestion);
        this.f62615e = findViewById(R$id.zui_second_article_suggestion);
        this.f62616f = findViewById(R$id.zui_third_article_suggestion);
        this.f62617g = (TextView) findViewById(R$id.zui_cell_label_text_field);
        this.f62619i = findViewById(R$id.zui_cell_label_supplementary_label);
        this.f62618h = findViewById(R$id.zui_cell_status_view);
    }

    public ArticlesResponseView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b();
    }
}
