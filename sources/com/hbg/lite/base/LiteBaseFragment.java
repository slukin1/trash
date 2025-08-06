package com.hbg.lite.base;

import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.core.ui.BaseFragment;
import rx.subjects.BehaviorSubject;
import u6.g;

public abstract class LiteBaseFragment<P extends BaseFragmentPresenter<V>, V extends g> extends BaseFragment<P, V> {
    public void uh(boolean z11) {
        super.uh(z11);
        BehaviorSubject<Integer> uIChangeSubject = getUIChangeSubject();
        if (uIChangeSubject != null) {
            uIChangeSubject.onNext(Integer.valueOf(z11 ? 16 : 17));
        }
    }
}
