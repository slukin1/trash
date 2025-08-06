package z9;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.R$raw;
import com.hbg.lib.widgets.R$style;
import i6.d;

public class g1 extends Dialog {

    /* renamed from: b  reason: collision with root package name */
    public LoadingView f76978b;

    public g1(Context context) {
        this(context, R$style.BaseDialogFragmentStyle);
    }

    public void dismiss() {
        try {
            LoadingView loadingView = this.f76978b;
            if (loadingView != null) {
                loadingView.d();
            }
            super.dismiss();
        } catch (Exception e11) {
            d.d("LoadingDialog dismiss" + e11.toString());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.dialog_fragment_loading, (ViewGroup) null);
        setContentView(inflate);
        LoadingView loadingView = (LoadingView) inflate.findViewById(R$id.loading_dialog_loading_view);
        this.f76978b = loadingView;
        loadingView.setLottieAnimationRes(R$raw.nd_middle_bg);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void onStart() {
        LoadingView loadingView = this.f76978b;
        if (loadingView != null) {
            loadingView.c();
        }
        super.onStart();
    }

    public g1(Context context, int i11) {
        super(context, i11);
    }
}
