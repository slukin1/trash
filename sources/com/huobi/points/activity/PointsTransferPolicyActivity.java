package com.huobi.points.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.hbg.lib.common.utils.SP;
import com.huobi.points.presenter.BasePolicyPresenter;
import fq.q;
import gq.b;
import gq.c;
import i6.i;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;
import s9.a;
import tg.r;

public class PointsTransferPolicyActivity extends BasePolicyActivity {
    public static boolean oh() {
        String J = r.x().J();
        if (TextUtils.isEmpty(J)) {
            return false;
        }
        return SP.l(J + "sp_key_confirm_points_transfer_policy", false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ph() {
        String J = r.x().J();
        SP.y(J + "sp_key_confirm_points_transfer_policy", true);
        setResult(-1);
        finish();
    }

    public static void qh(Activity activity, int i11) {
        if (activity != null) {
            activity.startActivityForResult(new Intent(activity, PointsTransferPolicyActivity.class), i11);
        }
    }

    public void Og() {
        finish();
    }

    public void Pg() {
        ((BasePolicyPresenter) getPresenter()).S("PRO_POINT_TRANSFER");
    }

    public List<a> Yf() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c(getString(R.string.points_transfer_policy_title_1)));
        arrayList.add(new b(getString(R.string.points_transfer_policy_content_1)));
        arrayList.add(new c(getString(R.string.points_transfer_policy_title_2)));
        arrayList.add(new b(getString(R.string.points_transfer_policy_content_2)));
        arrayList.add(new c(getString(R.string.points_transfer_policy_title_3)));
        arrayList.add(new b(getString(R.string.points_transfer_policy_content_3)));
        arrayList.add(new c(getString(R.string.points_transfer_policy_title_4)));
        arrayList.add(new b(getString(R.string.points_transfer_policy_content_4)));
        arrayList.add(new c(getString(R.string.points_transfer_policy_title_5)));
        arrayList.add(new b(getString(R.string.points_transfer_policy_content_5)));
        arrayList.add(new c(getString(R.string.points_transfer_policy_title_6)));
        arrayList.add(new b(getString(R.string.points_transfer_policy_content_6)));
        return arrayList;
    }

    public String Zf() {
        return getString(R.string.points_transfer_policy_checkbox_text);
    }

    public void afterInit() {
        super.afterInit();
        this.f80341f.setChecked(true);
        this.f80342g.setEnabled(this.f80341f.isChecked());
    }

    public String fg() {
        return getString(R.string.points_transfer_policy_title);
    }

    public void q5() {
        i.b().g(new q(this), 10);
    }
}
