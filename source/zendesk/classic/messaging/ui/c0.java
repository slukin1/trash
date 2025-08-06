package zendesk.classic.messaging.ui;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zendesk.logger.Logger;
import java.util.HashSet;
import java.util.Set;
import zendesk.classic.messaging.MessagingItem;
import zendesk.classic.messaging.R$attr;
import zendesk.classic.messaging.R$color;
import zendesk.classic.messaging.R$dimen;
import zendesk.classic.messaging.R$drawable;
import zendesk.classic.messaging.R$string;
import zendesk.classic.messaging.ui.MessagePopUpHelper;
import zendesk.commonui.UiUtils;

public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public static final int f62764a = R$drawable.zui_background_cell_errored;

    /* renamed from: b  reason: collision with root package name */
    public static final int f62765b = R$drawable.zui_background_cell_file;

    /* renamed from: c  reason: collision with root package name */
    public static final int f62766c = R$drawable.zui_background_end_user_cell;

    /* renamed from: d  reason: collision with root package name */
    public static final int f62767d = R$string.zui_label_tap_retry;

    /* renamed from: e  reason: collision with root package name */
    public static final int f62768e = R$string.zui_message_log_message_file_exceeds_max_size;

    /* renamed from: f  reason: collision with root package name */
    public static final int f62769f = R$string.zui_message_log_message_attachments_not_supported;

    /* renamed from: g  reason: collision with root package name */
    public static final int f62770g = R$string.zui_message_log_message_attachment_type_not_supported;

    /* renamed from: h  reason: collision with root package name */
    public static final int f62771h = R$string.zui_message_log_attachment_sending_failed;

    /* renamed from: i  reason: collision with root package name */
    public static final int f62772i = R$color.zui_error_background_color;

    /* renamed from: j  reason: collision with root package name */
    public static final int f62773j = R$color.zui_color_white_60;

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f62774b;

        public a(i iVar) {
            this.f62774b = iVar;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (this.f62774b.b() != null) {
                this.f62774b.b().a(this.f62774b.a());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f62775b;

        public b(g gVar) {
            this.f62775b = gVar;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (this.f62775b.b() != null) {
                this.f62775b.b().a(this.f62775b.a());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f62776b;

        public c(g gVar) {
            this.f62776b = gVar;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f62776b.e();
            throw null;
        }
    }

    public class d implements View.OnLongClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f62777b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f62778c;

        public d(View view, f fVar) {
            this.f62777b = view;
            this.f62778c = fVar;
        }

        public boolean onLongClick(View view) {
            MessagePopUpHelper.c(this.f62777b, c0.e(this.f62778c.d()), this.f62778c.b(), this.f62778c.a());
            return true;
        }
    }

    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f62779a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f62780b;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        static {
            /*
                zendesk.classic.messaging.MessagingItem$Query$Status[] r0 = zendesk.classic.messaging.MessagingItem.Query.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f62780b = r0
                r1 = 1
                zendesk.classic.messaging.MessagingItem$Query$Status r2 = zendesk.classic.messaging.MessagingItem.Query.Status.PENDING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f62780b     // Catch:{ NoSuchFieldError -> 0x001d }
                zendesk.classic.messaging.MessagingItem$Query$Status r3 = zendesk.classic.messaging.MessagingItem.Query.Status.FAILED_NO_RETRY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f62780b     // Catch:{ NoSuchFieldError -> 0x0028 }
                zendesk.classic.messaging.MessagingItem$Query$Status r4 = zendesk.classic.messaging.MessagingItem.Query.Status.FAILED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f62780b     // Catch:{ NoSuchFieldError -> 0x0033 }
                zendesk.classic.messaging.MessagingItem$Query$Status r4 = zendesk.classic.messaging.MessagingItem.Query.Status.DELIVERED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                zendesk.classic.messaging.MessagingItem$FileQuery$FailureReason[] r3 = zendesk.classic.messaging.MessagingItem.FileQuery.FailureReason.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f62779a = r3
                zendesk.classic.messaging.MessagingItem$FileQuery$FailureReason r4 = zendesk.classic.messaging.MessagingItem.FileQuery.FailureReason.FILE_SIZE_TOO_LARGE     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f62779a     // Catch:{ NoSuchFieldError -> 0x004e }
                zendesk.classic.messaging.MessagingItem$FileQuery$FailureReason r3 = zendesk.classic.messaging.MessagingItem.FileQuery.FailureReason.FILE_SENDING_DISABLED     // Catch:{ NoSuchFieldError -> 0x004e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f62779a     // Catch:{ NoSuchFieldError -> 0x0058 }
                zendesk.classic.messaging.MessagingItem$FileQuery$FailureReason r1 = zendesk.classic.messaging.MessagingItem.FileQuery.FailureReason.UNSUPPORTED_FILE_TYPE     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.classic.messaging.ui.c0.e.<clinit>():void");
        }
    }

    public static String b(g gVar, Context context) {
        if (gVar.d() == MessagingItem.Query.Status.FAILED) {
            return context.getString(f62767d);
        }
        return c(gVar, context);
    }

    public static String c(g gVar, Context context) {
        String string = context.getString(f62771h);
        if (gVar.g() == null) {
            return string;
        }
        int i11 = e.f62779a[gVar.g().ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                return context.getString(f62769f);
            }
            if (i11 != 3) {
                return string;
            }
            return context.getString(f62770g);
        } else if (gVar.f() == null) {
            return string;
        } else {
            return context.getString(f62768e, new Object[]{b0.a(context, gVar.f().a())});
        }
    }

    public static Drawable d(Context context) {
        int c11 = UiUtils.c(R$attr.colorPrimary, context, R$color.zui_color_primary);
        int c12 = UiUtils.c(R$attr.colorPrimaryDark, context, R$color.zui_color_primary_dark);
        float dimension = context.getResources().getDimension(R$dimen.zui_cell_bubble_corner_radius);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{c12, c11, c12});
        gradientDrawable.setCornerRadius(dimension);
        return gradientDrawable;
    }

    public static Set<MessagePopUpHelper.Option> e(MessagingItem.Query.Status status) {
        HashSet hashSet = new HashSet(2);
        if (status == MessagingItem.Query.Status.FAILED) {
            hashSet.add(MessagePopUpHelper.Option.DELETE);
            hashSet.add(MessagePopUpHelper.Option.RETRY);
        } else if (status == MessagingItem.Query.Status.FAILED_NO_RETRY) {
            hashSet.add(MessagePopUpHelper.Option.DELETE);
        }
        return hashSet;
    }

    public static boolean f(f fVar) {
        MessagingItem.Query.Status d11 = fVar.d();
        return d11 == MessagingItem.Query.Status.FAILED || d11 == MessagingItem.Query.Status.FAILED_NO_RETRY;
    }

    public static void g(g gVar, View view) {
        int i11 = e.f62780b[gVar.d().ordinal()];
        if (i11 == 1 || i11 == 2) {
            view.setOnClickListener((View.OnClickListener) null);
        } else if (i11 == 3) {
            view.setOnClickListener(new b(gVar));
        } else if (i11 == 4) {
            view.setOnClickListener(new c(gVar));
        }
    }

    public static void h(f fVar, View view) {
        if (f(fVar)) {
            view.setBackgroundResource(f62764a);
        } else if (fVar instanceof g) {
            view.setBackgroundResource(f62765b);
        } else {
            Drawable drawable = ContextCompat.getDrawable(view.getContext(), f62766c);
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(UiUtils.c(R$attr.colorPrimary, view.getContext(), R$color.zui_color_primary), PorterDuff.Mode.SRC_ATOP));
                view.setBackground(drawable);
                return;
            }
            Logger.l("UtilsEndUserCellView", "Failed to set background, resource R.drawable.zui_background_end_user_cell could not be found", new Object[0]);
        }
    }

    public static void i(f fVar, View view) {
        if (fVar instanceof i) {
            m((i) fVar, view);
        } else if (fVar instanceof g) {
            g((g) fVar, view);
        }
    }

    public static void j(f fVar, ImageView imageView, Context context) {
        if (f(fVar)) {
            imageView.setColorFilter(UiUtils.a(f62772i, context), PorterDuff.Mode.MULTIPLY);
        } else if (fVar.d() == MessagingItem.Query.Status.PENDING) {
            imageView.setColorFilter(UiUtils.a(f62773j, context), PorterDuff.Mode.MULTIPLY);
        } else {
            imageView.clearColorFilter();
        }
    }

    public static void k(f fVar, TextView textView, Context context) {
        if (!f(fVar)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        if (fVar instanceof g) {
            textView.setText(b((g) fVar, context));
        } else {
            textView.setText(context.getString(f62767d));
        }
    }

    public static void l(f fVar, View view) {
        view.setOnLongClickListener(new d(view, fVar));
    }

    public static void m(i iVar, View view) {
        if (iVar.d() == MessagingItem.Query.Status.FAILED || iVar.d() == MessagingItem.Query.Status.FAILED_NO_RETRY) {
            view.setOnClickListener(new a(iVar));
        }
    }
}
