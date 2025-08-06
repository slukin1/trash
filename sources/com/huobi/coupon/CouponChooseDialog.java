package com.huobi.coupon;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.p;
import com.hbg.lib.core.util.w;
import com.hbg.lib.network.uc.core.utils.UcHelper;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.asset.AssetModuleConfig;
import com.huawei.hms.push.AttributionReporter;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.edgeengine.template.widget.Widget;
import com.huochat.community.network.domain.DomainTool;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import ij.j;
import java.io.Serializable;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pro.huobi.R;
import rd.d;

public class CouponChooseDialog extends BaseDialogFragment implements View.OnClickListener, BaseDialogFragment.c {

    /* renamed from: b  reason: collision with root package name */
    public String f43733b;

    /* renamed from: c  reason: collision with root package name */
    public b f43734c;

    /* renamed from: d  reason: collision with root package name */
    public Widget f43735d;

    public static class CouponChooseBean implements Serializable {
        public List<CouponReturn> coupons;
        public String currentId;

        private CouponChooseBean() {
        }
    }

    public interface b {
        void a(CouponReturn couponReturn);
    }

    public static CouponChooseDialog th() {
        return new CouponChooseDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void uh(Object obj) {
        if ((obj instanceof String) && !((String) obj).isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject((String) obj);
                boolean optBoolean = jSONObject.optBoolean("confirm");
                CouponReturn couponReturn = (CouponReturn) d.f23353a.b(jSONObject.optString("currentCoupon"), CouponReturn.class);
                if (optBoolean && couponReturn != null) {
                    b bVar = this.f43734c;
                    if (bVar != null) {
                        bVar.a(couponReturn);
                    }
                    SP.w("couponChoose", "currentId", couponReturn.getId() + "");
                }
                doDismiss();
            } catch (JSONException e11) {
                throw new RuntimeException(e11);
            }
        }
    }

    public void addEvent(r rVar) {
    }

    public void afterInit() {
        setCanDismissOnBackPress(true);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void doDismiss() {
        this.f43735d.O();
        this.f43735d = null;
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
        rj.b b11 = ek.b.f47515a.b(activity, "publicComponents");
        vh(b11);
        CouponChooseBean couponChooseBean = new CouponChooseBean();
        couponChooseBean.currentId = SP.j("couponChoose", "currentId", "");
        couponChooseBean.coupons = j.g().f(this.f43733b, (CouponReturn) null);
        b11.I("refreshCoupons('" + d.f23353a.a(couponChooseBean) + "')");
        this.f43735d = b11.G("couponListDialog.xml", activity, false, b11.m());
        b11.u("couponListDialog.confirmData", new a(this));
        View P = this.f43735d.P(activity);
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(80);
        linearLayout.addView(P);
        SP.o("couponChoose", "hasNewCoupon" + this.f43733b);
        we.b.l("tradeCouponPoint", Object.class).g(0);
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

    public final void vh(rj.b bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("h5Url", BaseModuleConfig.a().j());
            if (!SystemUtils.c()) {
                jSONObject.put("contractH5Url", wi.b.f48056t);
            }
            jSONObject.put("currencyCharacter", LegalCurrencyConfigUtil.y().toUpperCase());
            jSONObject.put("currencyRate", LegalCurrencyConfigUtil.v());
            jSONObject.put("priceColorType", w.l() ? 0 : 1);
            jSONObject.put("colorMode", NightHelper.e().g() ? 1 : 0);
            jSONObject.put("iconURLHost", AssetModuleConfig.a().j().replace(DomainTool.DOMAIN_PREFIX, ""));
            jSONObject.put("iconPlaceholder", "");
            jSONObject.put("OS", 1);
            jSONObject.put("bottomSafeAreaHeight", 0);
            jSONObject.put(AttributionReporter.APP_VERSION, 105400);
            jSONObject.put("language", p.a(bVar.d()).toLowerCase());
            jSONObject.put("webUrl", BaseModuleConfig.a().j());
            jSONObject.put("countryId", sn.a.c().a());
            jSONObject.put("isChild", tg.r.x().X() ? "1" : "0");
            jSONObject.put("vToken", ku.b.e().h(bVar.d()));
            jSONObject.put("oldVToken", UcHelper.b(true));
            bVar.I("sendCommonConfig(" + jSONObject + ")");
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public CouponChooseDialog wh(String str, b bVar) {
        this.f43733b = str;
        this.f43734c = bVar;
        return this;
    }
}
