package g;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$bool;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$styleable;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f15746a;

    public a(Context context) {
        this.f15746a = context;
    }

    public static a b(Context context) {
        return new a(context);
    }

    public boolean a() {
        return this.f15746a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int c() {
        return this.f15746a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration configuration = this.f15746a.getResources().getConfiguration();
        int i11 = configuration.screenWidthDp;
        int i12 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i11 > 600) {
            return 5;
        }
        if (i11 > 960 && i12 > 720) {
            return 5;
        }
        if (i11 > 720 && i12 > 960) {
            return 5;
        }
        if (i11 >= 500) {
            return 4;
        }
        if (i11 > 640 && i12 > 480) {
            return 4;
        }
        if (i11 <= 480 || i12 <= 640) {
            return i11 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public int e() {
        return this.f15746a.getResources().getDimensionPixelSize(R$dimen.abc_action_bar_stacked_tab_max_width);
    }

    public int f() {
        TypedArray obtainStyledAttributes = this.f15746a.obtainStyledAttributes((AttributeSet) null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0);
        Resources resources = this.f15746a.getResources();
        if (!g()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R$dimen.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean g() {
        return this.f15746a.getResources().getBoolean(R$bool.abc_action_bar_embed_tabs);
    }

    public boolean h() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return !ViewConfiguration.get(this.f15746a).hasPermanentMenuKey();
    }
}
