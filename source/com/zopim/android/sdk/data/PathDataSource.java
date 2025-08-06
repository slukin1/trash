package com.zopim.android.sdk.data;

import com.zopim.android.sdk.api.ObservableTrigger;
import com.zopim.android.sdk.data.observers.AccountObserver;
import com.zopim.android.sdk.data.observers.AgentsObserver;
import com.zopim.android.sdk.data.observers.ChatLogObserver;
import com.zopim.android.sdk.data.observers.ConnectionObserver;
import com.zopim.android.sdk.data.observers.DepartmentsObserver;
import com.zopim.android.sdk.data.observers.FileSendingObserver;
import com.zopim.android.sdk.data.observers.FormsObserver;
import com.zopim.android.sdk.data.observers.ProfileObserver;
import com.zopim.android.sdk.model.Account;
import com.zopim.android.sdk.model.Agent;
import com.zopim.android.sdk.model.ChatLog;
import com.zopim.android.sdk.model.Connection;
import com.zopim.android.sdk.model.Department;
import com.zopim.android.sdk.model.FileSending;
import com.zopim.android.sdk.model.Forms;
import com.zopim.android.sdk.model.Profile;
import java.util.LinkedHashMap;
import java.util.Map;

public class PathDataSource implements DataSource {
    private LivechatAccountPath accountPath = LivechatAccountPath.getInstance();
    private LivechatAgentsPath agentsPath = LivechatAgentsPath.getInstance();
    private LivechatChatLogPath chatLogPath = LivechatChatLogPath.getInstance();
    private ConnectionPath connectionPath = ConnectionPath.getInstance();
    private LivechatDepartmentsPath departmentsPath = LivechatDepartmentsPath.getInstance();
    private LivechatFileSendingPath fileSendingPath = LivechatFileSendingPath.getInstance();
    private LivechatFormsPath formsPath = LivechatFormsPath.getInstance();
    private LivechatProfilePath profilePath = LivechatProfilePath.getInstance();

    public ObservableTrigger addAccountObserver(AccountObserver accountObserver) {
        this.accountPath.addObserver(accountObserver);
        return this.accountPath;
    }

    public ObservableTrigger addAgentsObserver(AgentsObserver agentsObserver) {
        this.agentsPath.addObserver(agentsObserver);
        return this.agentsPath;
    }

    public ObservableTrigger addChatLogObserver(ChatLogObserver chatLogObserver) {
        this.chatLogPath.addObserver(chatLogObserver);
        return this.chatLogPath;
    }

    public ObservableTrigger addConnectionObserver(ConnectionObserver connectionObserver) {
        this.connectionPath.addObserver(connectionObserver);
        return this.connectionPath;
    }

    public ObservableTrigger addDepartmentsObserver(DepartmentsObserver departmentsObserver) {
        this.departmentsPath.addObserver(departmentsObserver);
        return this.departmentsPath;
    }

    public ObservableTrigger addFileSendingObserver(FileSendingObserver fileSendingObserver) {
        this.fileSendingPath.addObserver(fileSendingObserver);
        return this.fileSendingPath;
    }

    public ObservableTrigger addFormsObserver(FormsObserver formsObserver) {
        this.formsPath.addObserver(formsObserver);
        return this.formsPath;
    }

    public ObservableTrigger addProfileObserver(ProfileObserver profileObserver) {
        this.profilePath.addObserver(profileObserver);
        return this.profilePath;
    }

    public void clear() {
        this.connectionPath.clear();
        this.profilePath.clear();
        this.accountPath.clear();
        this.agentsPath.clear();
        this.departmentsPath.clear();
        this.chatLogPath.clear();
        this.formsPath.clear();
        this.fileSendingPath.clear();
    }

    public void deleteAccountObserver(AccountObserver accountObserver) {
        this.accountPath.deleteObserver(accountObserver);
    }

    public void deleteAgentsObserver(AgentsObserver agentsObserver) {
        this.agentsPath.deleteObserver(agentsObserver);
    }

    public void deleteChatLogObserver(ChatLogObserver chatLogObserver) {
        this.chatLogPath.deleteObserver(chatLogObserver);
    }

    public void deleteConnectionObserver(ConnectionObserver connectionObserver) {
        this.connectionPath.deleteObserver(connectionObserver);
    }

    public void deleteDepartmentsObserver(DepartmentsObserver departmentsObserver) {
        this.departmentsPath.deleteObserver(departmentsObserver);
    }

    public void deleteFileSendingObserver(FileSendingObserver fileSendingObserver) {
        this.fileSendingPath.deleteObserver(fileSendingObserver);
    }

    public void deleteFormsObserver(FormsObserver formsObserver) {
        this.formsPath.deleteObserver(formsObserver);
    }

    public void deleteObservers() {
        this.connectionPath.deleteObservers();
        this.profilePath.deleteObservers();
        this.accountPath.deleteObservers();
        this.agentsPath.deleteObservers();
        this.departmentsPath.deleteObservers();
        this.chatLogPath.deleteObservers();
        this.formsPath.deleteObservers();
        this.fileSendingPath.deleteObservers();
    }

    public void deleteProfileObserver(ProfileObserver profileObserver) {
        this.profilePath.deleteObserver(profileObserver);
    }

    public Account getAccount() {
        return this.accountPath.getData();
    }

    public LinkedHashMap<String, Agent> getAgents() {
        return this.agentsPath.getData();
    }

    public LinkedHashMap<String, ChatLog> getChatLog() {
        return this.chatLogPath.getData();
    }

    public Connection getConnection() {
        return this.connectionPath.getData();
    }

    public Map<String, Department> getDepartments() {
        return this.departmentsPath.getData();
    }

    public FileSending getFileSending() {
        return this.fileSendingPath.getData();
    }

    public Forms getForms() {
        return this.formsPath.getData();
    }

    public Profile getProfile() {
        return this.profilePath.getData();
    }
}
