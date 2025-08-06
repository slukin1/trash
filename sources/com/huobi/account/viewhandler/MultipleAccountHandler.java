package com.huobi.account.viewhandler;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hbg.lib.widgets.CommonCheckBox;
import com.hbg.module.content.interfaces.NoDoubleClickListener;
import com.hbg.module.huobi.im.view.AvatarView;
import com.huobi.account.entity.MultipleAccountData;
import com.huobi.view.roundview.RoundTextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;
import s9.c;
import vg.d;

public class MultipleAccountHandler implements c {

    public class a extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MultipleAccountData f41872b;

        public a(MultipleAccountData multipleAccountData) {
            this.f41872b = multipleAccountData;
        }

        public void onViewClick(View view) {
            if (this.f41872b.getOnAccountItemClickListener() != null) {
                this.f41872b.getOnAccountItemClickListener().b(this.f41872b);
            }
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void d(MultipleAccountData multipleAccountData, ConstraintLayout constraintLayout, CommonCheckBox commonCheckBox, int i11, View view) {
        if (multipleAccountData.isEditMode() || multipleAccountData.isCurrentAccount()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        constraintLayout.setSelected(true);
        commonCheckBox.setChecked(true);
        if (multipleAccountData.getOnAccountItemClickListener() != null) {
            multipleAccountData.getOnAccountItemClickListener().a(multipleAccountData, i11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, MultipleAccountData multipleAccountData, ViewGroup viewGroup) {
        MultipleAccountData multipleAccountData2 = multipleAccountData;
        r e11 = cVar.e();
        AvatarView avatarView = (AvatarView) e11.b(R.id.imageHeader);
        TextView textView = (TextView) e11.b(R.id.account_name_tv);
        TextView textView2 = (TextView) e11.b(R.id.account_tag_tv);
        TextView textView3 = (TextView) e11.b(R.id.account_uid_tv);
        ConstraintLayout constraintLayout = (ConstraintLayout) e11.b(R.id.account_content_view);
        CommonCheckBox commonCheckBox = (CommonCheckBox) e11.b(R.id.account_select_cb);
        TextView textView4 = (TextView) e11.b(R.id.statusText);
        int i12 = 0;
        if (!TextUtils.isEmpty(multipleAccountData.getHeadImage())) {
            avatarView.u(multipleAccountData.getHeadImage(), "NFT".equals(multipleAccountData.getHeadImageType()), multipleAccountData.getFrameUrl()).s(0, -1, (String) null, (String) null, (String) null, 0);
            avatarView.A("BIG_V".equals(multipleAccountData.getShowExtBusinessTag()));
        } else {
            avatarView.z((String) null, (String) null).y(R.drawable.account_user_image, 0);
            avatarView.A("BIG_V".equals(multipleAccountData.getShowExtBusinessTag()));
        }
        int status = multipleAccountData.getStatus();
        if (status == 1) {
            textView4.setText(textView4.getContext().getString(R.string.n_login_switch_logging));
            textView4.setTextColor(textView4.getContext().getResources().getColor(R.color.baseColorSecondaryText, (Resources.Theme) null));
        } else if (status != 2) {
            textView4.setText("");
        } else {
            textView4.setText(textView4.getContext().getString(R.string.n_login_switch_retry));
            textView4.setTextColor(textView4.getContext().getResources().getColor(R.color.baseColorMajorTheme100, (Resources.Theme) null));
        }
        commonCheckBox.setChecked(multipleAccountData.isCurrentAccount());
        commonCheckBox.setVisibility(multipleAccountData.isCurrentAccount() ? 0 : 8);
        constraintLayout.setSelected(false);
        RoundTextView roundTextView = (RoundTextView) e11.b(R.id.multipleAccountDelete);
        if (!multipleAccountData.isEditMode()) {
            constraintLayout.setAlpha(1.0f);
            roundTextView.setVisibility(8);
        } else if (multipleAccountData.isCurrentAccount()) {
            constraintLayout.setAlpha(0.5f);
            roundTextView.setVisibility(8);
        } else {
            constraintLayout.setAlpha(1.0f);
            roundTextView.setVisibility(0);
        }
        textView.setText(TextUtils.isEmpty(multipleAccountData.getNickName()) ? multipleAccountData.getAccount() : multipleAccountData.getNickName());
        if (!multipleAccountData.isSubAccount()) {
            i12 = 8;
        }
        textView2.setVisibility(i12);
        textView3.setText("UID:" + multipleAccountData.getUid());
        constraintLayout.setOnClickListener(new d(multipleAccountData2, constraintLayout, commonCheckBox, i11));
        roundTextView.setOnClickListener(new a(multipleAccountData2));
    }

    public int getResId() {
        return R.layout.item_multiple_account;
    }
}
