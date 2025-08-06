package ms;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.huobi.supermargin.ui.SuperRepayActivity;

public final /* synthetic */ class j implements Toolbar.g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperRepayActivity f58260a;

    public /* synthetic */ j(SuperRepayActivity superRepayActivity) {
        this.f58260a = superRepayActivity;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return this.f58260a.vh(menuItem);
    }
}
