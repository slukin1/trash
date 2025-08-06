package zendesk.classic.messaging.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.material.badge.BadgeDrawable;
import zendesk.classic.messaging.R$attr;
import zendesk.classic.messaging.R$color;
import zendesk.classic.messaging.R$drawable;
import zendesk.classic.messaging.R$id;
import zendesk.classic.messaging.R$layout;
import zendesk.commonui.UiUtils;

public class EndUserFileCellView extends LinearLayout implements a0<g> {

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f62645b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62646c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62647d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f62648e;

    /* renamed from: f  reason: collision with root package name */
    public FileUploadProgressView f62649f;

    /* renamed from: g  reason: collision with root package name */
    public MessageStatusView f62650g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f62651h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f62652i;

    public EndUserFileCellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public final void a() {
        setOrientation(1);
        setGravity(BadgeDrawable.BOTTOM_END);
        LinearLayout.inflate(getContext(), R$layout.zui_view_end_user_file_cell_content, this);
    }

    /* renamed from: b */
    public void update(g gVar) {
        c0.h(gVar, this.f62645b);
        c0.k(gVar, this.f62651h, getContext());
        c0.i(gVar, this);
        c0.l(gVar, this);
        this.f62650g.setStatus(gVar.d());
        gVar.e();
        throw null;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f62645b = (LinearLayout) findViewById(R$id.zui_cell_file_container);
        this.f62646c = (TextView) findViewById(R$id.zui_file_cell_name);
        this.f62647d = (TextView) findViewById(R$id.zui_cell_file_description);
        this.f62648e = (ImageView) findViewById(R$id.zui_cell_file_app_icon);
        this.f62649f = (FileUploadProgressView) findViewById(R$id.zui_cell_file_upload_progress);
        this.f62650g = (MessageStatusView) findViewById(R$id.zui_cell_status_view);
        this.f62651h = (TextView) findViewById(R$id.zui_cell_label_message);
        Drawable drawable = ContextCompat.getDrawable(getContext(), R$drawable.zui_ic_insert_drive_file);
        this.f62652i = drawable;
        if (drawable != null) {
            UiUtils.b(UiUtils.c(R$attr.colorPrimary, getContext(), R$color.zui_color_primary), this.f62652i, this.f62648e);
        }
    }

    public EndUserFileCellView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a();
    }
}
