package z9;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.R$raw;
import com.hbg.lib.widgets.R$style;

public class h1 extends Dialog {

    /* renamed from: b  reason: collision with root package name */
    public LoadingView f76979b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f76980c;

    public h1(Context context) {
        this(context, R$style.BaseDialogFragmentStyle);
    }

    public void a(String str) {
        this.f76980c.setText(str);
    }

    public void dismiss() {
        LoadingView loadingView = this.f76979b;
        if (loadingView != null) {
            loadingView.d();
        }
        super.dismiss();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.dialog_fragment_old_loading, (ViewGroup) null);
        setContentView(inflate);
        this.f76979b = (LoadingView) inflate.findViewById(R$id.loading_dialog_loading_view);
        this.f76980c = (TextView) inflate.findViewById(R$id.loading_dialog_text);
        this.f76979b.setLottieAnimationRes(R$raw.d_night_bottom);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void onStart() {
        LoadingView loadingView = this.f76979b;
        if (loadingView != null) {
            loadingView.c();
        }
        super.onStart();
    }

    public h1(Context context, int i11) {
        super(context, i11);
    }
}
