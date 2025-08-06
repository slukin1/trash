package ms;

import android.widget.EditText;
import com.huobi.supermargin.ui.SuperLoanActivity;
import com.huobi.view.keyboard.CustomBoardView;

public final /* synthetic */ class f implements CustomBoardView.KeyBoardStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperLoanActivity f58256a;

    public /* synthetic */ f(SuperLoanActivity superLoanActivity) {
        this.f58256a = superLoanActivity;
    }

    public final void KeyBoardStateChange(int i11, EditText editText) {
        this.f58256a.yh(i11, editText);
    }
}
