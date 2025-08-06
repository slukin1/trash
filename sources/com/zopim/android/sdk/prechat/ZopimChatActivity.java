package com.zopim.android.sdk.prechat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.R;
import com.zopim.android.sdk.api.Chat;
import com.zopim.android.sdk.api.ZopimChat;
import com.zopim.android.sdk.api.ZopimChatApi;
import com.zopim.android.sdk.chatlog.ZopimChatLogFragment;
import com.zopim.android.sdk.embeddable.ChatActions;
import com.zopim.android.sdk.widget.ChatWidgetService;

public class ZopimChatActivity extends AppCompatActivity implements ChatListener {
    private static final String EXTRA_CHAT_CONFIG = "CHAT_CONFIG";
    private static final String LOG_TAG = "ZopimChatActivity";
    private static final String STATE_CHAT_INITIALIZED = "CHAT_INITIALIZED";
    private Chat mChat;
    private boolean mChatInitialized = false;

    public static void startActivity(Context context, ZopimChat.SessionConfig sessionConfig) {
        Intent intent = new Intent(context, ZopimChatActivity.class);
        intent.putExtra(EXTRA_CHAT_CONFIG, sessionConfig);
        context.startActivity(intent);
    }

    public void onChatEnded() {
        finish();
    }

    public void onChatInitialized() {
        this.mChatInitialized = true;
    }

    public void onChatLoaded(Chat chat) {
        this.mChat = chat;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.zopim_chat_activity);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (ZopimChatApi.getServiceNotificationServiceIntent() == null) {
            Intent intent = new Intent(this, ZopimChatActivity.class);
            if (getIntent() != null && getIntent().hasExtra(EXTRA_CHAT_CONFIG)) {
                intent.putExtra(EXTRA_CHAT_CONFIG, getIntent().getSerializableExtra(EXTRA_CHAT_CONFIG));
            }
            ZopimChatApi.setServiceNotificationContentIntent(intent);
        }
        if (bundle != null) {
            this.mChatInitialized = bundle.getBoolean(STATE_CHAT_INITIALIZED, false);
            this.mChat = ZopimChat.resume(this);
            return;
        }
        if (getIntent() != null && ChatActions.ACTION_RESUME_CHAT.equals(getIntent().getAction())) {
            Logger.j(LOG_TAG, "Resume chat request received", new Object[0]);
        }
        Chat resume = ZopimChat.resume(this);
        this.mChat = resume;
        this.mChatInitialized = !resume.hasEnded();
        if (!this.mChat.hasEnded()) {
            Logger.j(LOG_TAG, "Resuming chat log", new Object[0]);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager.m0(ZopimChatLogFragment.class.getName()) == null) {
                ZopimChatLogFragment zopimChatLogFragment = new ZopimChatLogFragment();
                FragmentTransaction q11 = supportFragmentManager.q();
                q11.c(R.id.chat_fragment_container, zopimChatLogFragment, ZopimChatLogFragment.class.getName());
                q11.j();
                return;
            }
            return;
        }
        Logger.j(LOG_TAG, "Starting new chat", new Object[0]);
        FragmentManager supportFragmentManager2 = getSupportFragmentManager();
        if (supportFragmentManager2.m0(ZopimChatFragment.class.getName()) == null) {
            ZopimChat.SessionConfig sessionConfig = null;
            if (getIntent() != null && getIntent().hasExtra(EXTRA_CHAT_CONFIG)) {
                sessionConfig = (ZopimChat.SessionConfig) getIntent().getSerializableExtra(EXTRA_CHAT_CONFIG);
            }
            ZopimChatFragment newInstance = sessionConfig != null ? ZopimChatFragment.newInstance(sessionConfig) : new ZopimChatFragment();
            FragmentTransaction q12 = supportFragmentManager2.q();
            q12.c(R.id.chat_fragment_container, newInstance, ZopimChatFragment.class.getName());
            q12.j();
        }
    }

    public void onDestroy() {
        Logger.j(LOG_TAG, "Activity destroyed", new Object[0]);
        super.onDestroy();
    }

    @SensorsDataInstrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 == menuItem.getItemId()) {
            finish();
            boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return onOptionsItemSelected;
        }
        SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return false;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(STATE_CHAT_INITIALIZED, this.mChatInitialized);
    }

    public void onStart() {
        super.onStart();
        stopService(new Intent(this, ChatWidgetService.class));
    }
}
