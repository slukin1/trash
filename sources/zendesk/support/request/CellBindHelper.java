package zendesk.support.request;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import c1.b;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.squareup.picasso.Picasso;
import com.zendesk.sdk.R$color;
import com.zendesk.sdk.R$integer;
import com.zendesk.sdk.R$string;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import zendesk.belvedere.a;
import zendesk.support.request.CellType;
import zendesk.support.suas.Dispatcher;

class CellBindHelper {
    /* access modifiers changed from: private */

    /* renamed from: af  reason: collision with root package name */
    public final ActionFactory f62974af;
    private final CellAttachmentLoadingUtil attachmentUtil;
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public final Dispatcher dispatcher;
    private final String today;
    private final String yesterday;

    public CellBindHelper(Context context2, Picasso picasso, ActionFactory actionFactory, Dispatcher dispatcher2) {
        this.context = context2;
        this.f62974af = actionFactory;
        this.dispatcher = dispatcher2;
        this.attachmentUtil = new CellAttachmentLoadingUtil(picasso, context2);
        this.today = context2.getString(R$string.request_message_date_today);
        this.yesterday = context2.getString(R$string.request_message_date_yesterday);
    }

    private boolean basicCellChecks(CellType.Base base, CellType.Base base2) {
        if (base == base2) {
            return true;
        }
        return base.getPositionType() == base2.getPositionType() && base.getClass().isInstance(base2);
    }

    private int getPixelForDp(int i11) {
        if (i11 != 0) {
            return this.context.getResources().getDimensionPixelOffset(i11);
        }
        return 0;
    }

    private boolean nullSafeEquals(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    /* access modifiers changed from: private */
    public void openAttachment(Context context2, StateRequestAttachment stateRequestAttachment) {
        Intent f11 = a.c(context2).f(stateRequestAttachment.getParsedLocalUri(), stateRequestAttachment.getMimeType());
        if (context2.getPackageManager().queryIntentActivities(f11, 0).size() > 0) {
            context2.startActivity(f11);
        }
    }

    public void addOnClickListenerForFileAttachment(View view, final StateRequestAttachment stateRequestAttachment) {
        if (stateRequestAttachment.isAvailableLocally()) {
            view.setAlpha(1.0f);
            view.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    CellBindHelper.this.openAttachment(view.getContext(), stateRequestAttachment);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            return;
        }
        view.setAlpha(((float) this.context.getResources().getInteger(R$integer.zs_request_file_attachment_downloading_cell_alpha)) / 100.0f);
        view.setOnClickListener(new View.OnClickListener() {
            private final String toastMessage;

            {
                this.toastMessage = CellBindHelper.this.context.getString(R$string.request_file_attachment_download_in_progress);
            }

            @SensorsDataInstrumented
            public void onClick(View view) {
                Toast.makeText(view.getContext(), this.toastMessage, 0).show();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    public void addOnClickListenerForImageAttachment(View view, final StateRequestAttachment stateRequestAttachment) {
        if (stateRequestAttachment.isAvailableLocally()) {
            view.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    CellBindHelper.this.openAttachment(view.getContext(), stateRequestAttachment);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
        } else {
            view.setOnClickListener((View.OnClickListener) null);
        }
    }

    public boolean areAgentCellContentsTheSame(CellType.Agent agent, CellType.Base base) {
        if (!basicCellChecks(agent, base) || !(base instanceof CellType.Agent)) {
            return false;
        }
        CellType.Agent agent2 = (CellType.Agent) base;
        boolean z11 = agent.getAgent().getId() == agent2.getAgent().getId();
        boolean equals = agent.getAgent().getName().equals(agent2.getAgent().getName());
        boolean z12 = agent.isAgentNameVisible() == agent2.isAgentNameVisible();
        if (!z11 || !equals || !z12) {
            return false;
        }
        return true;
    }

    public boolean areAttachmentCellContentsTheSame(CellType.Attachment attachment, CellType.Base base) {
        if (!basicCellChecks(attachment, base) || !(base instanceof CellType.Attachment)) {
            return false;
        }
        StateRequestAttachment attachment2 = attachment.getAttachment();
        StateRequestAttachment attachment3 = ((CellType.Attachment) base).getAttachment();
        boolean nullSafeEquals = nullSafeEquals(attachment2.getLocalFile(), attachment3.getLocalFile());
        boolean nullSafeEquals2 = nullSafeEquals(attachment2.getLocalUri(), attachment3.getLocalUri());
        boolean nullSafeEquals3 = nullSafeEquals(attachment2.getUrl(), attachment3.getUrl());
        if (!nullSafeEquals || !nullSafeEquals2 || !nullSafeEquals3) {
            return false;
        }
        return true;
    }

    public boolean areMessageContentsTheSame(CellType.Message message, CellType.Base base) {
        if (basicCellChecks(message, base) && (base instanceof CellType.Message)) {
            return message.getMessage().equals(((CellType.Message) base).getMessage());
        }
        return false;
    }

    public boolean areStatefulCellContentsTheSame(CellType.Stateful stateful, CellType.Base base) {
        if (!basicCellChecks(stateful, base) || !(base instanceof CellType.Stateful)) {
            return false;
        }
        CellType.Stateful stateful2 = (CellType.Stateful) base;
        boolean z11 = stateful.isErrorShown() == stateful2.isErrorShown();
        boolean z12 = stateful.isMarkedAsDelivered() == stateful2.isMarkedAsDelivered();
        boolean z13 = stateful.getErrorGroupMessages().size() == stateful2.getErrorGroupMessages().size();
        boolean z14 = stateful.isLastErrorCellOfBlock() == stateful2.isLastErrorCellOfBlock();
        if (!z11 || !z12 || !z13 || !z14) {
            return false;
        }
        return true;
    }

    public void bindAgentName(TextView textView, boolean z11, StateRequestUser stateRequestUser) {
        if (z11) {
            textView.setVisibility(0);
            textView.setText(stateRequestUser.getName());
            return;
        }
        textView.setVisibility(4);
    }

    public void bindAppInfo(ResolveInfo resolveInfo, TextView textView, ImageView imageView) {
        textView.setText(UtilsAttachment.getAppName(this.context, resolveInfo));
        imageView.setImageDrawable(UtilsAttachment.getAppIcon(this.context, resolveInfo));
    }

    public void bindDate(TextView textView, Date date) {
        String str;
        if (UtilsDate.isToday(date)) {
            str = this.today;
        } else if (UtilsDate.isYesterday(date)) {
            str = this.yesterday;
        } else {
            str = new SimpleDateFormat("d MMMM yyyy", Locale.getDefault()).format(date);
        }
        textView.setText(str.toUpperCase(Locale.getDefault()));
    }

    public void bindImage(ImageView imageView, StateRequestAttachment stateRequestAttachment) {
        this.attachmentUtil.bindImage(imageView, stateRequestAttachment);
    }

    public void bindStatusLabel(TextView textView, boolean z11, boolean z12) {
        int i11;
        int i12 = -1;
        int i13 = 0;
        if (z11) {
            i12 = R$color.zs_request_cell_label_color_error;
            i11 = R$string.request_messages_status_error;
        } else if (z12) {
            i12 = R$color.zs_request_cell_label_color;
            i11 = R$string.request_message_status_delivered;
        } else {
            i13 = 4;
            i11 = -1;
        }
        if (i12 > 0) {
            textView.setTextColor(ContextCompat.getColor(this.context, i12));
        }
        if (i11 > 0) {
            textView.setText(i11);
        }
        textView.clearAnimation();
        if (i13 == 0 && i13 != textView.getVisibility()) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(250);
            alphaAnimation.setInterpolator(b.a(0.0f, 0.0f, 0.2f, 1.0f));
            textView.startAnimation(alphaAnimation);
        }
        textView.setVisibility(i13);
    }

    public int colorForError(boolean z11) {
        int i11;
        if (z11) {
            i11 = R$color.zs_request_user_background_color_error;
        } else {
            i11 = R$color.zs_request_user_background_color;
        }
        return ContextCompat.getColor(this.context, i11);
    }

    public int colorForErrorImage(boolean z11) {
        if (z11) {
            return ContextCompat.getColor(this.context, R$color.zs_request_user_background_image_color_error);
        }
        return 0;
    }

    public View.OnClickListener errorClickListener(boolean z11, final List<StateMessage> list) {
        if (z11) {
            return new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    CellBindHelper.this.dispatcher.dispatch(CellBindHelper.this.f62974af.showRetryDialog(list));
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            };
        }
        return null;
    }

    public ResolveInfo getAppInfo(String str) {
        return UtilsAttachment.getAppInfoForFile(this.context, str);
    }

    public Rect getInsets(int i11, int i12, int i13, int i14) {
        return new Rect(getPixelForDp(i11), getPixelForDp(i12), getPixelForDp(i13), getPixelForDp(i14));
    }
}
