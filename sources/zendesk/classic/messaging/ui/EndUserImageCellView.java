package zendesk.classic.messaging.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.badge.BadgeDrawable;
import zendesk.classic.messaging.MessagingItem;
import zendesk.classic.messaging.R$dimen;
import zendesk.classic.messaging.R$id;
import zendesk.classic.messaging.R$layout;

public class EndUserImageCellView extends LinearLayout implements a0<h> {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f62653b;

    /* renamed from: c  reason: collision with root package name */
    public FileUploadProgressView f62654c;

    /* renamed from: d  reason: collision with root package name */
    public MessageStatusView f62655d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62656e;

    /* renamed from: f  reason: collision with root package name */
    public int f62657f;

    public EndUserImageCellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public final void a() {
        setOrientation(1);
        setGravity(BadgeDrawable.BOTTOM_END);
        LinearLayout.inflate(getContext(), R$layout.zui_view_end_user_image_cell_content, this);
        this.f62657f = getResources().getDimensionPixelSize(R$dimen.zui_cell_bubble_corner_radius);
    }

    public final void b(h hVar) {
        c0.d(getContext());
        hVar.e();
        throw null;
    }

    /* renamed from: c */
    public void update(h hVar) {
        b(hVar);
        if (hVar.d() == MessagingItem.Query.Status.PENDING) {
            this.f62654c.setVisibility(0);
        } else {
            this.f62654c.setVisibility(8);
        }
        this.f62655d.setStatus(hVar.d());
        c0.j(hVar, this.f62653b, getContext());
        c0.k(hVar, this.f62656e, getContext());
        c0.i(hVar, this);
        c0.l(hVar, this);
        hVar.c().b(this, this.f62655d);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f62653b = (ImageView) findViewById(R$id.zui_image_cell_image);
        this.f62654c = (FileUploadProgressView) findViewById(R$id.zui_cell_file_upload_progress);
        this.f62655d = (MessageStatusView) findViewById(R$id.zui_cell_status_view);
        this.f62656e = (TextView) findViewById(R$id.zui_cell_label_message);
    }

    public EndUserImageCellView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a();
    }
}
