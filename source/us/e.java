package us;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.contract.R$style;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import i6.n;

public final class e {

    public class a implements HBDialogFragment.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f84948a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f84949b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f84950c;

        public a(Context context, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
            this.f84948a = context;
            this.f84949b = onClickListener;
            this.f84950c = onClickListener2;
        }

        @SensorsDataInstrumented
        public static /* synthetic */ void f(HBDialogFragment hBDialogFragment, View.OnClickListener onClickListener, View view) {
            hBDialogFragment.dismiss();
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        @SensorsDataInstrumented
        public static /* synthetic */ void g(CheckBox checkBox, HBDialogFragment hBDialogFragment, View.OnClickListener onClickListener, View view) {
            if (!checkBox.isChecked()) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            hBDialogFragment.dismiss();
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        @SensorsDataInstrumented
        public static /* synthetic */ void h(Button button, CompoundButton compoundButton, boolean z11) {
            button.setEnabled(z11);
            SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
        }

        public static /* synthetic */ void i(NestedScrollView nestedScrollView, int i11) {
            ViewGroup.LayoutParams layoutParams = nestedScrollView.getLayoutParams();
            if (nestedScrollView.getHeight() > i11) {
                layoutParams.height = i11;
            }
            nestedScrollView.setLayoutParams(layoutParams);
        }

        public void a(View view, HBDialogFragment hBDialogFragment) {
            Button button = (Button) view.findViewById(R$id.dialog_confirm_btn);
            NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R$id.clause_dialog_content_sv);
            CheckBox checkBox = (CheckBox) view.findViewById(R$id.agreement_cb);
            button.setEnabled(checkBox.isChecked());
            ((Button) view.findViewById(R$id.dialog_cancel_btn)).setOnClickListener(new b(hBDialogFragment, this.f84949b));
            button.setOnClickListener(new a(checkBox, hBDialogFragment, this.f84950c));
            checkBox.setOnCheckedChangeListener(new c(button));
            i.b().g(new d(nestedScrollView, (n.f(this.f84948a) * 2) / 5), 10);
        }
    }

    public static void a(Context context, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        HBDialogFragment uh2 = HBDialogFragment.uh(R$layout.dialog_high_lever, new a(context, onClickListener, onClickListener2));
        uh2.setCanceledOnTouchOutside(false);
        uh2.setCancelable(false);
        uh2.setStyle(0, R$style.CommonDialogStyle);
        uh2.show(((FragmentActivity) oa.a.g().b()).getSupportFragmentManager(), "");
    }
}
