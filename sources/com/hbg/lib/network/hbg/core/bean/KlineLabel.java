package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class KlineLabel implements Serializable {
    private static final long serialVersionUID = -4892157050590606813L;
    private List<LabelBean> labelList;

    public static class LabelBean implements Serializable {
        private static final long serialVersionUID = 9064193123365428779L;
        private String label;

        public String getLabel() {
            return this.label;
        }

        public void setLabel(String str) {
            this.label = str;
        }
    }

    public List<LabelBean> getLabelList() {
        return this.labelList;
    }

    public void setLabelList(List<LabelBean> list) {
        this.labelList = list;
    }
}
