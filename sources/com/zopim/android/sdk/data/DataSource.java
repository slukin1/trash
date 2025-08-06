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

public interface DataSource {
    ObservableTrigger addAccountObserver(AccountObserver accountObserver);

    ObservableTrigger addAgentsObserver(AgentsObserver agentsObserver);

    ObservableTrigger addChatLogObserver(ChatLogObserver chatLogObserver);

    ObservableTrigger addConnectionObserver(ConnectionObserver connectionObserver);

    ObservableTrigger addDepartmentsObserver(DepartmentsObserver departmentsObserver);

    ObservableTrigger addFileSendingObserver(FileSendingObserver fileSendingObserver);

    ObservableTrigger addFormsObserver(FormsObserver formsObserver);

    ObservableTrigger addProfileObserver(ProfileObserver profileObserver);

    void clear();

    void deleteAccountObserver(AccountObserver accountObserver);

    void deleteAgentsObserver(AgentsObserver agentsObserver);

    void deleteChatLogObserver(ChatLogObserver chatLogObserver);

    void deleteConnectionObserver(ConnectionObserver connectionObserver);

    void deleteDepartmentsObserver(DepartmentsObserver departmentsObserver);

    void deleteFileSendingObserver(FileSendingObserver fileSendingObserver);

    void deleteFormsObserver(FormsObserver formsObserver);

    void deleteObservers();

    void deleteProfileObserver(ProfileObserver profileObserver);

    Account getAccount();

    LinkedHashMap<String, Agent> getAgents();

    LinkedHashMap<String, ChatLog> getChatLog();

    Connection getConnection();

    Map<String, Department> getDepartments();

    FileSending getFileSending();

    Forms getForms();

    Profile getProfile();
}
