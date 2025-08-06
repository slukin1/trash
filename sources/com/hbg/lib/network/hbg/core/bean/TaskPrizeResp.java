package com.hbg.lib.network.hbg.core.bean;

import com.hbg.lib.network.hbg.core.bean.AccountTaskResp;
import java.io.Serializable;
import java.util.List;

public class TaskPrizeResp implements Serializable {
    private static final long serialVersionUID = -6411713637217549250L;
    private List<AccountTaskResp.TaskAwardResp> taskAwards;

    public List<AccountTaskResp.TaskAwardResp> getTaskAwards() {
        return this.taskAwards;
    }

    public void setTaskAwards(List<AccountTaskResp.TaskAwardResp> list) {
        this.taskAwards = list;
    }
}
