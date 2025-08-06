package com.zopim.android.sdk.prechat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.R;
import com.zopim.android.sdk.api.Chat;
import com.zopim.android.sdk.api.ChatConfig;
import com.zopim.android.sdk.api.ChatSession;
import com.zopim.android.sdk.api.ZopimChat;
import com.zopim.android.sdk.api.ZopimChatApi;
import com.zopim.android.sdk.chatlog.ZopimChatLogFragment;
import com.zopim.android.sdk.data.observers.ConnectionObserver;
import com.zopim.android.sdk.model.Account;
import com.zopim.android.sdk.model.Connection;
import com.zopim.android.sdk.model.Department;
import com.zopim.android.sdk.model.VisitorInfo;
import com.zopim.android.sdk.prechat.PreChatForm;
import mz.f;
import s1.a;

public class ZopimChatFragment extends Fragment {
    private static final String EXTRA_CHAT_CONFIG = "CHAT_CONFIG";
    private static final String LOG_TAG = "ZopimChatFragment";
    private static final String STATE_CHAT_INITIALIZED = "CHAT_INITIALIZED";
    private static final String STATE_COULD_NOT_CONNECT_ERROR_VISIBILITY = "COULD_NOT_CONNECT_ERROR_VISIBILITY";
    private static final String STATE_NO_AGENTS_VISIBILITY = "NO_AGENTS_VISIBILITY";
    private static final String STATE_NO_CONNECTION_ERROR_VISIBILITY = "NO_CONNECTION_ERROR_VISIBILITY";
    private static final String STATE_PROGRESS_VISIBILITY = "PROGRESS_VISIBILITY";
    /* access modifiers changed from: private */
    public Chat chat;
    public BroadcastReceiver chatInitializationTimeout = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            ZopimChatFragment.this.onChatInitializationFailed();
            ZopimChatFragment.this.showCouldNotConnectError();
        }
    };
    /* access modifiers changed from: private */
    public boolean chatInitialized = false;
    private ChatListener chatListener;
    public ConnectionObserver connectionObserver = new ConnectionObserver() {
        public void update(Connection connection) {
            if (!ZopimChatFragment.this.chat.hasEnded()) {
                int i11 = AnonymousClass9.$SwitchMap$com$zopim$android$sdk$model$Connection$Status[connection.getStatus().ordinal()];
                if (i11 != 1) {
                    if (i11 == 2 && !ZopimChatFragment.this.chatInitialized) {
                        boolean unused = ZopimChatFragment.this.chatInitialized = true;
                        ZopimChatFragment.this.onChatInitialized();
                    }
                } else if (!ZopimChatFragment.this.chatInitialized) {
                    ZopimChatFragment.this.onChatInitializationFailed();
                    ZopimChatFragment.this.showNoConnectionError();
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public View couldNotConnectErrorView;
    private Handler handler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public View noAgentsView;
    /* access modifiers changed from: private */
    public View noConnectionErrorView;
    /* access modifiers changed from: private */
    public View progressBar;

    /* renamed from: com.zopim.android.sdk.prechat.ZopimChatFragment$9  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass9 {
        public static final /* synthetic */ int[] $SwitchMap$com$zopim$android$sdk$model$Connection$Status;
        public static final /* synthetic */ int[] $SwitchMap$com$zopim$android$sdk$prechat$PreChatForm$Field;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        static {
            /*
                com.zopim.android.sdk.model.Connection$Status[] r0 = com.zopim.android.sdk.model.Connection.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$zopim$android$sdk$model$Connection$Status = r0
                r1 = 1
                com.zopim.android.sdk.model.Connection$Status r2 = com.zopim.android.sdk.model.Connection.Status.NO_CONNECTION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$zopim$android$sdk$model$Connection$Status     // Catch:{ NoSuchFieldError -> 0x001d }
                com.zopim.android.sdk.model.Connection$Status r3 = com.zopim.android.sdk.model.Connection.Status.CONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.zopim.android.sdk.prechat.PreChatForm$Field[] r2 = com.zopim.android.sdk.prechat.PreChatForm.Field.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$com$zopim$android$sdk$prechat$PreChatForm$Field = r2
                com.zopim.android.sdk.prechat.PreChatForm$Field r3 = com.zopim.android.sdk.prechat.PreChatForm.Field.OPTIONAL     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = $SwitchMap$com$zopim$android$sdk$prechat$PreChatForm$Field     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.zopim.android.sdk.prechat.PreChatForm$Field r2 = com.zopim.android.sdk.prechat.PreChatForm.Field.REQUIRED     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.prechat.ZopimChatFragment.AnonymousClass9.<clinit>():void");
        }
    }

    private void close() {
        FragmentTransaction q11 = getFragmentManager().q();
        q11.s(this);
        q11.j();
    }

    public static ZopimChatFragment newInstance(ZopimChat.SessionConfig sessionConfig) {
        ZopimChatFragment zopimChatFragment = new ZopimChatFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_CHAT_CONFIG, sessionConfig);
        zopimChatFragment.setArguments(bundle);
        return zopimChatFragment;
    }

    /* access modifiers changed from: private */
    public void onChatInitializationFailed() {
        this.handler.post(new Runnable() {
            public void run() {
                ZopimChatFragment.this.chat.endChat();
            }
        });
    }

    /* access modifiers changed from: private */
    public void onChatInitialized() {
        int i11;
        Logger.j(LOG_TAG, "Chat initialization completed", new Object[0]);
        ChatListener chatListener2 = this.chatListener;
        if (chatListener2 != null) {
            chatListener2.onChatInitialized();
        }
        Account account = ZopimChatApi.getDataSource().getAccount();
        if (account != null && Account.Status.OFFLINE == account.getStatus()) {
            showNoAgents();
        } else if (DepartmentUtil.findDepartment(ZopimChatApi.getDataSource().getDepartments().values(), this.chat.getConfig().getDepartment()).getStatus() == Department.Status.OFFLINE && ((i11 = AnonymousClass9.$SwitchMap$com$zopim$android$sdk$prechat$PreChatForm$Field[this.chat.getConfig().getPreChatForm().getDepartment().ordinal()]) == 1 || i11 == 2)) {
            showNoAgents();
        } else {
            this.handler.post(new Runnable() {
                public void run() {
                    ZopimChatFragment.this.progressBar.setVisibility(8);
                    if (ZopimChatFragment.this.showPreChat()) {
                        ZopimPreChatFragment newInstance = ZopimPreChatFragment.newInstance(ZopimChatFragment.this.chat.getConfig().getPreChatForm());
                        FragmentTransaction q11 = ZopimChatFragment.this.getFragmentManager().q();
                        q11.u(R.id.chat_fragment_container, newInstance, ZopimPreChatFragment.class.getName());
                        q11.s(ZopimChatFragment.this);
                        q11.j();
                        return;
                    }
                    ZopimChatLogFragment zopimChatLogFragment = new ZopimChatLogFragment();
                    FragmentTransaction q12 = ZopimChatFragment.this.getFragmentManager().q();
                    q12.u(R.id.chat_fragment_container, zopimChatLogFragment, ZopimChatLogFragment.class.getName());
                    q12.s(ZopimChatFragment.this);
                    q12.j();
                }
            });
        }
    }

    private void setViewVisibility(View view, int i11) {
        if (view == null) {
            Logger.l(LOG_TAG, "View must not be null. Can not apply visibility change", new Object[0]);
        } else if (i11 == 0) {
            view.setVisibility(0);
        } else if (i11 == 4) {
            view.setVisibility(4);
        } else if (i11 == 8) {
            view.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void showCouldNotConnectError() {
        this.handler.post(new Runnable() {
            public void run() {
                ZopimChatFragment.this.progressBar.setVisibility(8);
                ZopimChatFragment.this.noConnectionErrorView.setVisibility(8);
                ZopimChatFragment.this.noAgentsView.setVisibility(8);
                ZopimChatFragment.this.couldNotConnectErrorView.setVisibility(0);
            }
        });
    }

    private boolean showField(PreChatForm.Field field, String str) {
        if (field.equals(PreChatForm.Field.OPTIONAL_EDITABLE) || field.equals(PreChatForm.Field.REQUIRED_EDITABLE)) {
            return true;
        }
        return !field.equals(PreChatForm.Field.NOT_REQUIRED) && f.e(str);
    }

    private void showNoAgents() {
        this.handler.post(new Runnable() {
            public void run() {
                ZopimChatFragment.this.progressBar.setVisibility(8);
                ZopimChatFragment.this.noConnectionErrorView.setVisibility(8);
                ZopimChatFragment.this.noAgentsView.setVisibility(0);
                ZopimChatFragment.this.couldNotConnectErrorView.setVisibility(8);
            }
        });
    }

    /* access modifiers changed from: private */
    public void showNoConnectionError() {
        this.handler.post(new Runnable() {
            public void run() {
                ZopimChatFragment.this.progressBar.setVisibility(8);
                ZopimChatFragment.this.noConnectionErrorView.setVisibility(0);
                ZopimChatFragment.this.noAgentsView.setVisibility(8);
                ZopimChatFragment.this.couldNotConnectErrorView.setVisibility(8);
            }
        });
    }

    /* access modifiers changed from: private */
    public void showOfflineMessageFragment() {
        ZopimOfflineFragment zopimOfflineFragment = new ZopimOfflineFragment();
        FragmentTransaction q11 = getFragmentManager().q();
        q11.u(R.id.chat_fragment_container, zopimOfflineFragment, ZopimOfflineFragment.class.getName());
        q11.s(this);
        q11.j();
    }

    /* access modifiers changed from: private */
    public boolean showPreChat() {
        ChatConfig config = this.chat.getConfig();
        PreChatForm preChatForm = config.getPreChatForm();
        VisitorInfo visitorInfo = config.getVisitorInfo();
        if (((((showField(preChatForm.getDepartment(), config.getDepartment())) || showField(preChatForm.getMessage(), (String) null)) || showField(preChatForm.getEmail(), visitorInfo.getEmail())) || showField(preChatForm.getName(), visitorInfo.getName())) || showField(preChatForm.getPhoneNumber(), visitorInfo.getPhoneNumber())) {
            return true;
        }
        return false;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
        if (bundle == null) {
            this.progressBar.setVisibility(0);
            if (getArguments() == null || !getArguments().containsKey(EXTRA_CHAT_CONFIG)) {
                this.chat = ZopimChat.start(getActivity());
            } else {
                try {
                    Logger.j(LOG_TAG, "Starting chat with session config", new Object[0]);
                    ZopimChat.SessionConfig sessionConfig = (ZopimChat.SessionConfig) getArguments().getSerializable(EXTRA_CHAT_CONFIG);
                    this.chat = sessionConfig != null ? sessionConfig.build(getActivity()) : ZopimChat.start(getActivity());
                } catch (ClassCastException unused) {
                    Logger.l(LOG_TAG, "Unexpected configuration extras. Will ignore session configuration.", new Object[0]);
                    this.chat = ZopimChat.start(getActivity());
                }
            }
        } else {
            this.chatInitialized = bundle.getBoolean(STATE_CHAT_INITIALIZED, false);
            this.chat = ZopimChat.resume(getActivity());
            Logger.j(LOG_TAG, "Restoring states. chat initialized: " + this.chatInitialized, new Object[0]);
        }
        ChatListener chatListener2 = this.chatListener;
        if (chatListener2 != null) {
            chatListener2.onChatLoaded(this.chat);
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ChatListener) {
            this.chatListener = (ChatListener) activity;
            return;
        }
        Logger.g(LOG_TAG, activity.getClass() + " should implement " + ChatListener.class, new Object[0]);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.zopim_chat_fragment, viewGroup, false);
    }

    public void onDetach() {
        super.onDetach();
        this.chatListener = null;
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 == menuItem.getItemId()) {
            this.chat.endChat();
            close();
            ChatListener chatListener2 = this.chatListener;
            if (chatListener2 != null) {
                chatListener2.onChatEnded();
            }
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return onOptionsItemSelected;
    }

    @TargetApi(11)
    @SensorsDataInstrumented
    public void onPause() {
        if (getActivity() == null) {
            Logger.l(LOG_TAG, "Unexpected null value activity in onPause()", new Object[0]);
            super.onPause();
            FragmentTrackHelper.trackFragmentPause(this);
            return;
        }
        if (!this.chatInitialized) {
            if (Build.VERSION.SDK_INT >= 11 ? !getActivity().isChangingConfigurations() : getActivity().isFinishing()) {
                Logger.g(LOG_TAG, "Chat initialization aborted. Ending chat.", new Object[0]);
                this.chat.endChat();
                ChatListener chatListener2 = this.chatListener;
                if (chatListener2 != null) {
                    chatListener2.onChatEnded();
                }
            }
        } else if (getActivity().isFinishing()) {
            this.chat.endChat();
            ChatListener chatListener3 = this.chatListener;
            if (chatListener3 != null) {
                chatListener3.onChatEnded();
            }
        }
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(STATE_CHAT_INITIALIZED, this.chatInitialized);
        bundle.putInt(STATE_NO_CONNECTION_ERROR_VISIBILITY, this.noConnectionErrorView.getVisibility());
        bundle.putInt(STATE_COULD_NOT_CONNECT_ERROR_VISIBILITY, this.couldNotConnectErrorView.getVisibility());
        bundle.putInt(STATE_NO_AGENTS_VISIBILITY, this.noAgentsView.getVisibility());
        bundle.putInt(STATE_PROGRESS_VISIBILITY, this.progressBar.getVisibility());
        Logger.j(LOG_TAG, "Saving states. chat initialized: " + this.chatInitialized + ", no conn visibility: " + this.noConnectionErrorView.getVisibility() + ", progress visibility: " + this.progressBar.getVisibility(), new Object[0]);
    }

    public void onStart() {
        super.onStart();
        ZopimChatApi.getDataSource().addConnectionObserver(this.connectionObserver);
        a.b(getContext()).c(this.chatInitializationTimeout, new IntentFilter(ChatSession.ACTION_CHAT_INITIALIZATION_TIMEOUT));
    }

    public void onStop() {
        super.onStop();
        this.handler.removeCallbacksAndMessages((Object) null);
        ZopimChatApi.getDataSource().deleteConnectionObserver(this.connectionObserver);
        a.b(getContext()).e(this.chatInitializationTimeout);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setHasOptionsMenu(true);
        this.progressBar = view.findViewById(R.id.progress_container);
        this.noConnectionErrorView = view.findViewById(R.id.no_connection_error);
        this.noAgentsView = view.findViewById(R.id.no_agents);
        this.couldNotConnectErrorView = view.findViewById(R.id.could_not_connect_error);
        ((Button) this.noAgentsView.findViewById(R.id.no_agents_button)).setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ZopimChatFragment.this.showOfflineMessageFragment();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            int i11 = bundle.getInt(STATE_NO_CONNECTION_ERROR_VISIBILITY, 8);
            int i12 = bundle.getInt(STATE_COULD_NOT_CONNECT_ERROR_VISIBILITY, 8);
            int i13 = bundle.getInt(STATE_NO_AGENTS_VISIBILITY, 8);
            int i14 = bundle.getInt(STATE_PROGRESS_VISIBILITY, 8);
            setViewVisibility(this.noConnectionErrorView, i11);
            setViewVisibility(this.couldNotConnectErrorView, i12);
            setViewVisibility(this.noAgentsView, i13);
            setViewVisibility(this.progressBar, i14);
        }
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }
}
