package zendesk.classic.messaging.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.badge.BadgeDrawable;
import zendesk.classic.messaging.MessagingItem;
import zendesk.classic.messaging.R$color;
import zendesk.classic.messaging.R$id;
import zendesk.classic.messaging.R$layout;
import zendesk.commonui.UiUtils;

public class EndUserMessageView extends LinearLayout implements a0<i> {

    /* renamed from: b  reason: collision with root package name */
    public TextView f62658b;

    /* renamed from: c  reason: collision with root package name */
    public MessageStatusView f62659c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62660d;

    /* renamed from: e  reason: collision with root package name */
    public int f62661e;

    /* renamed from: f  reason: collision with root package name */
    public int f62662f;

    public EndUserMessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public final void a() {
        setOrientation(1);
        setGravity(BadgeDrawable.BOTTOM_END);
        LinearLayout.inflate(getContext(), R$layout.zui_view_end_user_message_cell_content, this);
    }

    /* renamed from: b */
    public void update(i iVar) {
        c0.i(iVar, this);
        c0.l(iVar, this);
        c0.k(iVar, this.f62660d, getContext());
        c0.h(iVar, this.f62658b);
        MessagingItem.Query.Status d11 = iVar.d();
        this.f62658b.setTextColor(c0.f(iVar) ? this.f62662f : this.f62661e);
        this.f62658b.setText(iVar.e());
        this.f62658b.setTextIsSelectable(d11 == MessagingItem.Query.Status.DELIVERED);
        this.f62658b.requestLayout();
        this.f62659c.setStatus(d11);
        iVar.c().b(this, this.f62659c);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f62658b = (TextView) findViewById(R$id.zui_end_user_message_cell_text_field);
        this.f62659c = (MessageStatusView) findViewById(R$id.zui_cell_status_view);
        this.f62660d = (TextView) findViewById(R$id.zui_cell_label_message);
        Context context = getContext();
        this.f62662f = UiUtils.a(R$color.zui_text_color_dark_primary, context);
        this.f62661e = UiUtils.a(R$color.zui_text_color_light_primary, context);
    }

    public EndUserMessageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a();
    }
}
