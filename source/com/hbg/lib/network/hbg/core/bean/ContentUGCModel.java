package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class ContentUGCModel implements Serializable {
    private double bonusAmountAll;
    private int finished;
    private List<UGCTaskModel> tasks;

    public static class UGCTaskModel implements Serializable {
        public double bonusAmount;
        public String buttonText;
        public String descriptionText;
        public int finishCount;
        public String icon;
        public String showSubtitle;
        public String showTitle;
        public int status;
        public String taskId;
        public int totalCount;
        public String url;
        public String userTaskId;
    }

    public double getBonusAmountAll() {
        return this.bonusAmountAll;
    }

    public int getFinished() {
        return this.finished;
    }

    public List<UGCTaskModel> getTasks() {
        return this.tasks;
    }

    public void setBonusAmountAll(double d11) {
        this.bonusAmountAll = d11;
    }

    public void setFinished(int i11) {
        this.finished = i11;
    }

    public void setTasks(List<UGCTaskModel> list) {
        this.tasks = list;
    }
}
