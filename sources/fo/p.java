package fo;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.huobi.main.ui.HuobiMainActivity;

public class p extends FragmentManager.FragmentLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public HuobiMainActivity f84121a;

    public p(HuobiMainActivity huobiMainActivity) {
        this.f84121a = huobiMainActivity;
    }

    public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentResumed(fragmentManager, fragment);
    }

    public void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentStopped(fragmentManager, fragment);
    }
}
