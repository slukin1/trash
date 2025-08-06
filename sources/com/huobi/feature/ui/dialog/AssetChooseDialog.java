package com.huobi.feature.ui.dialog;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.p;
import com.hbg.lib.network.pro.core.bean.AssetModeBean;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.edgeengine.template.widget.Widget;
import i6.r;
import java.io.Serializable;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;
import pro.huobi.R;
import rd.d;
import rj.b;

public class AssetChooseDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public Widget f45028b;

    /* renamed from: c  reason: collision with root package name */
    public b f45029c;

    /* renamed from: d  reason: collision with root package name */
    public a f45030d;

    public static class AssetChooseEventModel implements Serializable {
        public boolean closeAlert;
        public Boolean isUnion;

        private AssetChooseEventModel() {
        }
    }

    public interface a {
        void a(boolean z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void th(Object obj) {
        a aVar;
        if (obj instanceof String) {
            AssetChooseEventModel assetChooseEventModel = (AssetChooseEventModel) d.f23353a.b((String) obj, AssetChooseEventModel.class);
            if (assetChooseEventModel.closeAlert) {
                doDismiss();
            }
            Boolean bool = assetChooseEventModel.isUnion;
            if (bool != null && (aVar = this.f45030d) != null) {
                aVar.a(bool.booleanValue());
            }
        }
    }

    public void addEvent(r rVar) {
    }

    public void afterInit() {
    }

    @h
    @Keep
    public void changeAssetMode(AssetModeBean assetModeBean) {
        if (assetModeBean.isSuccess.booleanValue()) {
            dismiss();
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isUnion", !assetModeBean.isUnion.booleanValue() ? "1" : "0");
            b bVar = this.f45029c;
            bVar.I("refreshAssetData(`" + jSONObject + "`)");
        } catch (Throwable unused) {
        }
    }

    public void doDismiss() {
        this.f45028b.O();
        this.f45028b = null;
        ek.b.f47515a.e("publicComponents");
        this.f45029c.B();
        EventBus.d().r(this);
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
        EventBus.d().p(this);
        this.f45029c = ek.b.f47515a.b(activity, "publicComponents");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("language", p.a(this.f45029c.d()).toLowerCase());
            jSONObject2.put("h5Url", BaseModuleConfig.a().j());
            b bVar = this.f45029c;
            bVar.I("sendCommonConfig(" + jSONObject2 + ")");
            jSONObject.put("isUnion", SPUtil.j() ? "1" : "0");
            b bVar2 = this.f45029c;
            bVar2.I("refreshAssetData(`" + jSONObject + "`)");
        } catch (Throwable unused) {
        }
        b bVar3 = this.f45029c;
        this.f45028b = bVar3.G("bottomUnionPatternDialog.xml", activity, false, bVar3.m());
        this.f45029c.u("bottomUnionPatternDialog.dialogInfo", new a(this));
        View P = this.f45028b.P(activity);
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

    public void uh(a aVar) {
        this.f45030d = aVar;
    }
}
