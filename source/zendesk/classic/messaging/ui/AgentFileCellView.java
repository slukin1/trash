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
import zendesk.classic.messaging.R$attr;
import zendesk.classic.messaging.R$color;
import zendesk.classic.messaging.R$drawable;
import zendesk.classic.messaging.R$id;
import zendesk.classic.messaging.R$layout;
import zendesk.commonui.UiUtils;

public class AgentFileCellView extends LinearLayout implements a0<b> {

    /* renamed from: b  reason: collision with root package name */
    public AvatarView f62568b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f62569c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62570d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62571e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f62572f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f62573g;

    /* renamed from: h  reason: collision with root package name */
    public View f62574h;

    /* renamed from: i  reason: collision with root package name */
    public View f62575i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f62576j;

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f62577b;

        public a(b bVar) {
            this.f62577b = bVar;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f62577b.a();
            throw null;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final g30.a f62579a;

        /* renamed from: b  reason: collision with root package name */
        public final r f62580b;

        /* renamed from: c  reason: collision with root package name */
        public final String f62581c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f62582d;

        /* renamed from: e  reason: collision with root package name */
        public final a f62583e;

        /* renamed from: f  reason: collision with root package name */
        public final c f62584f;

        public b(g30.a aVar, r rVar, String str, boolean z11, a aVar2, c cVar) {
            this.f62580b = rVar;
            this.f62581c = str;
            this.f62582d = z11;
            this.f62583e = aVar2;
            this.f62584f = cVar;
        }

        public g30.a a() {
            return this.f62579a;
        }

        public String b() {
            return this.f62581c;
        }

        public r c() {
            return this.f62580b;
        }

        public boolean d() {
            return this.f62582d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (d() != bVar.d()) {
                return false;
            }
            a();
            bVar.a();
            if (c() == null ? bVar.c() != null : !c().equals(bVar.c())) {
                return false;
            }
            if (b() == null ? bVar.b() != null : !b().equals(bVar.b())) {
                return false;
            }
            a aVar = this.f62583e;
            a aVar2 = bVar.f62583e;
            if (aVar != null) {
                return aVar.equals(aVar2);
            }
            if (aVar2 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            a();
            int i11 = 0;
            int hashCode = ((((((0 * 31) + (c() != null ? c().hashCode() : 0)) * 31) + (b() != null ? b().hashCode() : 0)) * 31) + (d() ? 1 : 0)) * 31;
            a aVar = this.f62583e;
            if (aVar != null) {
                i11 = aVar.hashCode();
            }
            return hashCode + i11;
        }
    }

    public AgentFileCellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void setBubbleClickListeners(b bVar) {
        this.f62569c.setOnClickListener(new a(bVar));
    }

    public final void a() {
        setOrientation(0);
        LinearLayout.inflate(getContext(), R$layout.zui_view_agent_file_cell_content, this);
    }

    /* renamed from: b */
    public void update(b bVar) {
        bVar.a();
        throw null;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f62568b = (AvatarView) findViewById(R$id.zui_agent_message_avatar);
        this.f62569c = (LinearLayout) findViewById(R$id.zui_cell_file_container);
        this.f62570d = (TextView) findViewById(R$id.zui_file_cell_name);
        this.f62571e = (TextView) findViewById(R$id.zui_cell_file_description);
        this.f62572f = (ImageView) findViewById(R$id.zui_cell_file_app_icon);
        this.f62574h = findViewById(R$id.zui_cell_status_view);
        this.f62573g = (TextView) findViewById(R$id.zui_cell_label_text_field);
        this.f62575i = findViewById(R$id.zui_cell_label_supplementary_label);
        this.f62576j = ContextCompat.getDrawable(getContext(), R$drawable.zui_ic_insert_drive_file);
        UiUtils.b(UiUtils.c(R$attr.colorPrimary, getContext(), R$color.zui_color_primary), this.f62576j, this.f62572f);
    }

    public AgentFileCellView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a();
    }
}
