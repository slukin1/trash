package com.tencent.ugc.videoprocessor.transitions.data;

import java.util.ArrayList;
import java.util.List;

public class TransitionConfig {
    private final List<TransitionBean> mTransitions = new ArrayList();

    public static class TransitionBean {
        public long endTimeMs = -1;
        public long startTimeMs = -1;
        public int type;

        public TransitionBean(int i11) {
            this.type = i11;
        }
    }

    public void addTransition(TransitionBean transitionBean) {
        this.mTransitions.add(transitionBean);
    }

    public void clear() {
        this.mTransitions.clear();
    }

    public void deleteLastTransitionEffect() {
        if (this.mTransitions.size() != 0) {
            List<TransitionBean> list = this.mTransitions;
            list.remove(list.size() - 1);
        }
    }

    public List<TransitionBean> getTransitionList() {
        return this.mTransitions;
    }
}
