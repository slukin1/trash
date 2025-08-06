package com.hbg.lib.network.hbg.core.bean;

import com.hbg.lib.network.hbg.core.bean.AccountTaskResp;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class AccountChallengeTask implements Serializable {
    private static final long serialVersionUID = 2192314880229045202L;
    private CheckInBean checkInResp;
    private List<ChallengeChildTask> list;

    public static class ChallengeChildTask implements Serializable {
        private static final long serialVersionUID = -7168994361945995442L;
        private String h5Url;
        private String name;
        private List<TaskStageInfoResp> stageList;
        private long taskId;
        private int taskType;
        private String url;
        private long userTaskId;

        public String getH5Url() {
            return this.h5Url;
        }

        public String getName() {
            return this.name;
        }

        public List<TaskStageInfoResp> getStageList() {
            return this.stageList;
        }

        public long getTaskId() {
            return this.taskId;
        }

        public int getTaskType() {
            return this.taskType;
        }

        public String getUrl() {
            return this.url;
        }

        public long getUserTaskId() {
            return this.userTaskId;
        }

        public void setH5Url(String str) {
            this.h5Url = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setStageList(List<TaskStageInfoResp> list) {
            this.stageList = list;
        }

        public void setTaskId(long j11) {
            this.taskId = j11;
        }

        public void setTaskType(int i11) {
            this.taskType = i11;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setUserTaskId(long j11) {
            this.userTaskId = j11;
        }
    }

    public static class CheckInBean implements Serializable {
        private static final long serialVersionUID = 4863369780937452437L;
        private long activityId;
        private String bubbleTitle;
        private String icon;
        private int signNum;
        private int status;
        private List<AccountTaskResp.TaskAwardResp> taskAwards;
        private long taskId;
        private int totalNum;
        private String url;
        private long userTaskId;

        public long getActivityId() {
            return this.activityId;
        }

        public String getBubbleTitle() {
            return this.bubbleTitle;
        }

        public String getIcon() {
            return this.icon;
        }

        public int getSignNum() {
            return this.signNum;
        }

        public int getStatus() {
            return this.status;
        }

        public List<AccountTaskResp.TaskAwardResp> getTaskAwards() {
            return this.taskAwards;
        }

        public long getTaskId() {
            return this.taskId;
        }

        public int getTotalNum() {
            return this.totalNum;
        }

        public String getUrl() {
            return this.url;
        }

        public long getUserTaskId() {
            return this.userTaskId;
        }

        public void setActivityId(long j11) {
            this.activityId = j11;
        }

        public void setBubbleTitle(String str) {
            this.bubbleTitle = str;
        }

        public void setIcon(String str) {
            this.icon = str;
        }

        public void setSignNum(int i11) {
            this.signNum = i11;
        }

        public void setStatus(int i11) {
            this.status = i11;
        }

        public void setTaskAwards(List<AccountTaskResp.TaskAwardResp> list) {
            this.taskAwards = list;
        }

        public void setTaskId(long j11) {
            this.taskId = j11;
        }

        public void setTotalNum(int i11) {
            this.totalNum = i11;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setUserTaskId(long j11) {
            this.userTaskId = j11;
        }
    }

    public static class SignInResp implements Serializable {
        private static final long serialVersionUID = -6831672454842117353L;
        private int shardsNum;

        public int getShardsNum() {
            return this.shardsNum;
        }

        public void setShardsNum(int i11) {
            this.shardsNum = i11;
        }
    }

    public static class TaskStageInfoResp implements Serializable {
        private static final long serialVersionUID = 4432876888899796293L;
        private String bubbleTitle;
        private BigDecimal endPeriod;
        private BigDecimal finishAmount;
        private int stageId;
        private int stageState;
        private BigDecimal startPeriod;
        private List<AccountTaskResp.TaskAwardResp> taskAwards;
        private String title;

        public String getBubbleTitle() {
            return this.bubbleTitle;
        }

        public BigDecimal getEndPeriod() {
            return this.endPeriod;
        }

        public BigDecimal getFinishAmount() {
            return this.finishAmount;
        }

        public int getStageId() {
            return this.stageId;
        }

        public int getStageState() {
            return this.stageState;
        }

        public BigDecimal getStartPeriod() {
            return this.startPeriod;
        }

        public List<AccountTaskResp.TaskAwardResp> getTaskAwards() {
            return this.taskAwards;
        }

        public String getTitle() {
            return this.title;
        }

        public void setBubbleTitle(String str) {
            this.bubbleTitle = str;
        }

        public void setEndPeriod(BigDecimal bigDecimal) {
            this.endPeriod = bigDecimal;
        }

        public void setFinishAmount(BigDecimal bigDecimal) {
            this.finishAmount = bigDecimal;
        }

        public void setStageId(int i11) {
            this.stageId = i11;
        }

        public void setStageState(int i11) {
            this.stageState = i11;
        }

        public void setStartPeriod(BigDecimal bigDecimal) {
            this.startPeriod = bigDecimal;
        }

        public void setTaskAwards(List<AccountTaskResp.TaskAwardResp> list) {
            this.taskAwards = list;
        }

        public void setTitle(String str) {
            this.title = str;
        }
    }

    public CheckInBean getCheckInResp() {
        return this.checkInResp;
    }

    public List<ChallengeChildTask> getList() {
        return this.list;
    }

    public void setCheckInResp(CheckInBean checkInBean) {
        this.checkInResp = checkInBean;
    }

    public void setList(List<ChallengeChildTask> list2) {
        this.list = list2;
    }
}
