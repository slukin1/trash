package com.huobi.feature.ui.dialog;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.edgeengine.template.widget.Widget;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import java.io.Serializable;
import pro.huobi.R;
import rd.d;

public class LimitChooseDialog extends BaseDialogFragment implements View.OnClickListener, BaseDialogFragment.c {

    /* renamed from: b  reason: collision with root package name */
    public b f45045b;

    /* renamed from: c  reason: collision with root package name */
    public Widget f45046c;

    /* renamed from: d  reason: collision with root package name */
    public String f45047d = "";

    public static class LimitChooseBean implements Serializable {
        public boolean closeAlert;
        public Item selectedItem;

        public static class Item implements Serializable {
            public int index;
        }

        private LimitChooseBean() {
        }
    }

    public class a implements vj.a {
        public a() {
        }

        public void onCallback(Object obj) {
            if (obj instanceof String) {
                String str = (String) obj;
                if (!com.hbg.module.libkt.base.ext.b.x(str) && !str.equals(LimitChooseDialog.this.f45047d)) {
                    String unused = LimitChooseDialog.this.f45047d = str;
                    LimitChooseBean limitChooseBean = (LimitChooseBean) d.f23353a.b(str, LimitChooseBean.class);
                    if (LimitChooseDialog.this.f45045b != null && !limitChooseBean.closeAlert) {
                        LimitChooseDialog.this.f45045b.a(limitChooseBean.selectedItem.index);
                    }
                    LimitChooseDialog.this.doDismiss();
                }
            }
        }
    }

    public interface b {
        void a(int i11);
    }

    public static LimitChooseDialog vh() {
        return new LimitChooseDialog();
    }

    public void addEvent(r rVar) {
    }

    public void afterInit() {
        setCanDismissOnBackPress(true);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void doDismiss() {
        this.f45046c.O();
        this.f45046c = null;
        ek.b.f47515a.e("publicComponents");
        super.doDismiss();
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public View getContentView() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        int i11 = getArguments().getInt("selIndex");
        rj.b b11 = ek.b.f47515a.b(activity, "publicComponents");
        Resources resources = activity.getResources();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{\"topTitle\":\"");
        sb2.append(resources.getString(R.string.n_contract_time_of_taking_effect));
        sb2.append("\",\"list\":[{\"title\":\"GTC\",\"subTitle\":\"");
        sb2.append(resources.getString(R.string.n_contract_gtc_time_of_effect));
        sb2.append("\", \"selected\":");
        boolean z11 = true;
        sb2.append(i11 == 0);
        sb2.append("},{\"title\":\"IOC\",\"subTitle\":\"");
        sb2.append(resources.getString(R.string.n_contract_ioc_time_of_effect));
        sb2.append("\", \"selected\":");
        sb2.append(i11 == 1);
        sb2.append("},{\"title\":\"FOK\",\"subTitle\":\"");
        sb2.append(resources.getString(R.string.n_contract_fok_time_of_effect));
        sb2.append("\", \"selected\":");
        if (i11 != 2) {
            z11 = false;
        }
        sb2.append(z11);
        sb2.append("}]}");
        b11.I("refreshBottomData(`" + sb2.toString() + "`)");
        this.f45046c = b11.G("bottomListRadioDialog.xml", activity, false, b11.m());
        b11.u("bottomListRadioDialog.dialogInfo", new a());
        View P = this.f45046c.P(activity);
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(80);
        linearLayout.addView(P);
        return linearLayout;
    }

    public int getContentViewResId() {
        return 0;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
    }

    public boolean isTransparent() {
        return false;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDialogFragmentBackPressed() {
    }

    public void onDialogFragmentPause() {
    }

    public void onDialogFragmentResume() {
    }

    public LimitChooseDialog wh(b bVar) {
        this.f45045b = bVar;
        return this;
    }
}
