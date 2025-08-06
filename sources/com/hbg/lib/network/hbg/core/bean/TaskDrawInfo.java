package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class TaskDrawInfo implements Serializable {
    private static final long serialVersionUID = -1120360136676816335L;
    private Long stageId;
    private long userTaskId;

    public Long getStageId() {
        return this.stageId;
    }

    public long getUserTaskId() {
        return this.userTaskId;
    }

    public void setStageId(long j11) {
        this.stageId = Long.valueOf(j11);
    }

    public void setUserTaskId(Long l11) {
        this.userTaskId = l11.longValue();
    }
}
