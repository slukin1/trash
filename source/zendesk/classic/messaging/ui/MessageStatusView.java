package zendesk.classic.messaging.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.h;
import zendesk.classic.messaging.MessagingItem;
import zendesk.classic.messaging.R$attr;
import zendesk.classic.messaging.R$color;
import zendesk.classic.messaging.R$drawable;
import zendesk.commonui.UiUtils;

public class MessageStatusView extends AppCompatImageView {

    /* renamed from: b  reason: collision with root package name */
    public int f62703b;

    /* renamed from: c  reason: collision with root package name */
    public int f62704c;

    /* renamed from: d  reason: collision with root package name */
    public int f62705d;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f62706a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                zendesk.classic.messaging.MessagingItem$Query$Status[] r0 = zendesk.classic.messaging.MessagingItem.Query.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f62706a = r0
                zendesk.classic.messaging.MessagingItem$Query$Status r1 = zendesk.classic.messaging.MessagingItem.Query.Status.FAILED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f62706a     // Catch:{ NoSuchFieldError -> 0x001d }
                zendesk.classic.messaging.MessagingItem$Query$Status r1 = zendesk.classic.messaging.MessagingItem.Query.Status.FAILED_NO_RETRY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f62706a     // Catch:{ NoSuchFieldError -> 0x0028 }
                zendesk.classic.messaging.MessagingItem$Query$Status r1 = zendesk.classic.messaging.MessagingItem.Query.Status.DELIVERED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f62706a     // Catch:{ NoSuchFieldError -> 0x0033 }
                zendesk.classic.messaging.MessagingItem$Query$Status r1 = zendesk.classic.messaging.MessagingItem.Query.Status.PENDING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.classic.messaging.ui.MessageStatusView.a.<clinit>():void");
        }
    }

    public MessageStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public final void init() {
        this.f62704c = UiUtils.c(R$attr.colorPrimary, getContext(), R$color.zui_color_primary);
        this.f62703b = UiUtils.a(R$color.zui_error_text_color, getContext());
        this.f62705d = UiUtils.a(R$color.zui_cell_pending_indicator_color, getContext());
    }

    public void setStatus(MessagingItem.Query.Status status) {
        int i11 = a.f62706a[status.ordinal()];
        if (i11 == 1 || i11 == 2) {
            h.c(this, ColorStateList.valueOf(this.f62703b));
            setImageResource(R$drawable.zui_ic_status_fail);
        } else if (i11 == 3) {
            h.c(this, ColorStateList.valueOf(this.f62704c));
            setImageResource(R$drawable.zui_ic_status_sent);
        } else if (i11 != 4) {
            setImageResource(0);
        } else {
            h.c(this, ColorStateList.valueOf(this.f62705d));
            setImageResource(R$drawable.zui_ic_status_pending);
        }
    }

    public MessageStatusView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init();
    }
}
