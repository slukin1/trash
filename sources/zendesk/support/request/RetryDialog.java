package zendesk.support.request;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zendesk.sdk.R$id;
import com.zendesk.sdk.R$layout;
import java.util.List;

class RetryDialog extends BottomSheetDialog {
    private BottomSheetBehavior<FrameLayout> bottomSheetBehavior;
    /* access modifiers changed from: private */
    public Listener listener;
    /* access modifiers changed from: private */
    public final List<StateMessage> message;

    public interface Listener {
        void onDeleteMessage(List<StateMessage> list);

        void onRetryMessage(List<StateMessage> list);
    }

    public RetryDialog(Context context, List<StateMessage> list) {
        super(context);
        this.message = list;
        init();
    }

    private void init() {
        setContentView(R$layout.zs_request_dialog_retry);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.bottomSheetBehavior = initBottomSheet();
        initListener();
    }

    private BottomSheetBehavior<FrameLayout> initBottomSheet() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.design_bottom_sheet);
        if (frameLayout == null) {
            return null;
        }
        try {
            return BottomSheetBehavior.from(frameLayout);
        } catch (Exception unused) {
            return null;
        }
    }

    private void initListener() {
        View findViewById = findViewById(R$id.request_dialog_retry_delete);
        View findViewById2 = findViewById(R$id.request_dialog_retry_retry);
        if (findViewById2 != null && findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    if (RetryDialog.this.listener != null) {
                        RetryDialog.this.listener.onDeleteMessage(RetryDialog.this.message);
                    }
                    RetryDialog.this.dismiss();
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            findViewById2.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    if (RetryDialog.this.listener != null) {
                        RetryDialog.this.listener.onRetryMessage(RetryDialog.this.message);
                    }
                    RetryDialog.this.dismiss();
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
        }
    }

    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior2 = this.bottomSheetBehavior;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.setState(3);
        }
    }

    public void setListener(Listener listener2) {
        this.listener = listener2;
    }
}
