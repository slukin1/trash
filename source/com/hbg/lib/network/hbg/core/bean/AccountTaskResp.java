package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class AccountTaskResp implements Serializable {
    private static final long serialVersionUID = 2192314880229045202L;
    private AccountChallengeTask challengeTask;
    private AccountNewComerTask newTask;
    private String titleName;

    public static class TaskAwardResp implements Serializable {
        private static final long serialVersionUID = 6274232182370474032L;
        private String count;
        private String currency;
        private String icon;

        /* renamed from: id  reason: collision with root package name */
        private long f70217id;
        private String name;
        private int type;

        public String getCount() {
            return this.count;
        }

        public String getCurrency() {
            return this.currency;
        }

        public String getIcon() {
            return this.icon;
        }

        public long getId() {
            return this.f70217id;
        }

        public String getName() {
            return this.name;
        }

        public int getType() {
            return this.type;
        }

        public void setCount(String str) {
            this.count = str;
        }

        public void setCurrency(String str) {
            this.currency = str;
        }

        public void setIcon(String str) {
            this.icon = str;
        }

        public void setId(long j11) {
            this.f70217id = j11;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setType(int i11) {
            this.type = i11;
        }
    }

    public AccountChallengeTask getChallengeTask() {
        return this.challengeTask;
    }

    public AccountNewComerTask getNewTask() {
        return this.newTask;
    }

    public String getTitleName() {
        return this.titleName;
    }

    public void setChallengeTask(AccountChallengeTask accountChallengeTask) {
        this.challengeTask = accountChallengeTask;
    }

    public void setNewTask(AccountNewComerTask accountNewComerTask) {
        this.newTask = accountNewComerTask;
    }

    public void setTitleName(String str) {
        this.titleName = str;
    }
}
