package u6;

import h6.a;
import rx.subjects.BehaviorSubject;

public interface g extends a {
    void dismissProgressDialog();

    BehaviorSubject<Integer> getUIChangeSubject();

    boolean isCanBeSeen();

    void showOldProgressDialog(String str);

    void showProgressDialog();

    void showProgressDialog(boolean z11);
}
