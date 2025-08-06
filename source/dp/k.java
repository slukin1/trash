package dp;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.r;
import com.hbg.module.otc.R$style;

public abstract class k extends r {
    public k(Context context) {
        this(context, R$style.OrderDialog);
    }

    public abstract void j();

    public abstract int k();

    public abstract void l();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(k());
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setGravity(80);
            window.setLayout(-1, -1);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = PixelUtils.g();
            window.setAttributes(attributes);
            window.setWindowAnimations(R$style.bottom_dialog_animation);
        }
        l();
        j();
    }

    public k(Context context, int i11) {
        super(context, i11);
    }
}
