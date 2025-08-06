package jp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.otc.core.OTCStatusExtendResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.hbg.module.otc.R$style;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.net.URLDecoder;
import u6.g;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f84327a = new f();

    public class a extends q6.b<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f84328b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(g gVar, b bVar) {
            super(gVar);
            this.f84328b = bVar;
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            HuobiToastUtil.j(R$string.n_check_network);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (aPIStatusErrorException == null || TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                onError2(aPIStatusErrorException);
            } else {
                HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
            }
        }

        public void onRequestFailure(Throwable th2) {
            super.onRequestFailure(th2);
        }

        public void onRequestSuccess(Object obj) {
            super.onRequestSuccess(obj);
            b bVar = this.f84328b;
            if (bVar != null) {
                bVar.onContinue();
            }
        }
    }

    public interface b {
        void onContinue();
    }

    public static f d() {
        return f84327a;
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void f(Dialog dialog, View view) {
        dialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void g(Dialog dialog, Context context, OTCStatusExtendResponse.ExtendBean extendBean, b bVar, View view) {
        dialog.dismiss();
        e(context, extendBean.getLink(), bVar);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void c(Context context, b bVar) {
        s8.a.a().actionAuDvs().d(new a(context instanceof g ? (g) context : null, bVar));
    }

    public void e(Context context, String str, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("http")) {
                if (context instanceof Activity) {
                    OtcModuleConfig.b().f((Activity) context, str);
                }
            } else if (str.startsWith("action")) {
                if (str.contains("api-au-dvs")) {
                    c(context, bVar);
                } else if (str.contains("page-kyc-auth")) {
                    OtcModuleConfig.b().L();
                }
            } else if (str.startsWith("holigeit")) {
                if (URLDecoder.decode(str).contains("/account/kyc")) {
                    OtcModuleConfig.b().L();
                } else {
                    BaseModuleConfig.a().k0(str);
                }
            } else if (str.startsWith("path://")) {
                String substring = str.substring(7);
                if (!TextUtils.isEmpty(substring)) {
                    HBBaseWebActivity.showWebView(context, BaseModuleConfig.a().W() + substring, "", "", false);
                }
            }
        } else if (bVar != null) {
            bVar.onContinue();
        }
    }

    public void h(Context context, OTCStatusExtendResponse.ExtendBean extendBean, b bVar) {
        if (context != null && extendBean != null) {
            AlertDialog.a aVar = new AlertDialog.a(context, R$style.CommonDialogStyle);
            View inflate = LayoutInflater.from(context).inflate(R$layout.dialog_layout_otc_order_withdraw, (ViewGroup) null);
            aVar.setView(inflate);
            TextView textView = (TextView) inflate.findViewById(R$id.dialog_title_tv);
            TextView textView2 = (TextView) inflate.findViewById(R$id.dialog_message_tv);
            Button button = (Button) inflate.findViewById(R$id.dialog_cancel_btn);
            Button button2 = (Button) inflate.findViewById(R$id.dialog_confirm_btn);
            ViewUtil.m(button2, !TextUtils.isEmpty(extendBean.getContinueText()));
            if (!TextUtils.isEmpty(extendBean.getTitle())) {
                textView.setText(extendBean.getTitle());
            }
            if (!TextUtils.isEmpty(extendBean.getContent())) {
                textView2.setText(Html.fromHtml(extendBean.getContent()));
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
            }
            if (!TextUtils.isEmpty(extendBean.getCancelText())) {
                button.setText(extendBean.getCancelText());
            }
            if (!TextUtils.isEmpty(extendBean.getContinueText())) {
                button2.setText(extendBean.getContinueText());
            }
            AlertDialog create = aVar.create();
            button.setOnClickListener(new d(create));
            button2.setOnClickListener(new e(this, create, context, extendBean, bVar));
            create.setCanceledOnTouchOutside(false);
            create.show();
        }
    }
}
