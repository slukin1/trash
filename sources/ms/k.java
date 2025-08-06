package ms;

import android.widget.EditText;
import com.huobi.supermargin.ui.SuperRepayActivity;
import com.huobi.view.keyboard.CustomBoardView;

public final /* synthetic */ class k implements CustomBoardView.KeyBoardStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperRepayActivity f58261a;

    public /* synthetic */ k(SuperRepayActivity superRepayActivity) {
        this.f58261a = superRepayActivity;
    }

    public final void KeyBoardStateChange(int i11, EditText editText) {
        this.f58261a.xh(i11, editText);
    }
}
