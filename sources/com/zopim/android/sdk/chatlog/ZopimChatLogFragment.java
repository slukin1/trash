package com.zopim.android.sdk.chatlog;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import com.zendesk.belvedere.BelvedereCallback;
import com.zendesk.belvedere.BelvedereResult;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.R;
import com.zopim.android.sdk.api.Chat;
import com.zopim.android.sdk.api.ChatSession;
import com.zopim.android.sdk.api.UninitializedChat;
import com.zopim.android.sdk.api.ZopimChat;
import com.zopim.android.sdk.api.ZopimChatApi;
import com.zopim.android.sdk.chatlog.ConnectionFragment;
import com.zopim.android.sdk.chatlog.ConnectionToastFragment;
import com.zopim.android.sdk.data.LivechatChatLogPath;
import com.zopim.android.sdk.data.observers.AccountObserver;
import com.zopim.android.sdk.data.observers.AgentsTypingObserver;
import com.zopim.android.sdk.data.observers.ChatItemsObserver;
import com.zopim.android.sdk.model.Account;
import com.zopim.android.sdk.model.ChatLog;
import com.zopim.android.sdk.model.FileSending;
import com.zopim.android.sdk.model.Profile;
import com.zopim.android.sdk.model.items.AgentAttachment;
import com.zopim.android.sdk.model.items.AgentMessage;
import com.zopim.android.sdk.model.items.AgentOptions;
import com.zopim.android.sdk.model.items.AgentTyping;
import com.zopim.android.sdk.model.items.ChatRating;
import com.zopim.android.sdk.model.items.Disableable;
import com.zopim.android.sdk.model.items.RowItem;
import com.zopim.android.sdk.model.items.VisitorAttachment;
import com.zopim.android.sdk.model.items.VisitorMessage;
import com.zopim.android.sdk.prechat.ChatListener;
import com.zopim.android.sdk.prechat.EmailTranscript;
import com.zopim.android.sdk.util.BelvedereProvider;
import com.zopim.android.sdk.util.Color;
import com.zopim.android.sdk.widget.ChatWidgetService;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import mz.f;
import u0.a;

public class ZopimChatLogFragment extends Fragment implements ConnectionFragment.ConnectionListener, ConnectionToastFragment.ToastListener {
    private static final float FULL_OPACITY = 1.0f;
    private static final String LOG_TAG = "ZopimChatLogFragment";
    private static final String STATE_ATTACH_BUTTON_ENABLED = "ATTACH_BUTTON_ENABLED";
    private static final String STATE_FAILED_VISITOR_UPLOAD_ITEMS = "FAILED_VISITOR_UPLOAD_ITEMS";
    private static final String STATE_INPUT_FIELD_ENABLED = "INPUT_FILED_ENABLED";
    private static final String STATE_INPUT_FIELD_TEXT = "INPUT_FILED_TEXT";
    private static final String STATE_NO_CONNECTION = "NO_CONNECTION";
    private static final String STATE_SEND_BUTTON_ENABLED = "SEND_BUTTON_ENABLED";
    private static final String STATE_SHOW_CHAT_END_CONFIRM_DIALOG = "SHOW_CHAT_END_CONFIRM_DIALOG";
    private static final String STATE_SHOW_EMAIL_TRANSCRIPT_DIALOG = "SHOW_EMAIL_TRANSCRIPT_DIALOG";
    private static final String STATE_SHOW_RECONNECT_TIMEOUT_DIALOG = "SHOW_RECONNECT_TIMEOUT_DIALOG";
    public AccountObserver accountObserver = new AccountObserver() {
        private final long OFFLINE_THRESHOLD = TimeUnit.SECONDS.toMillis(10);
        private Runnable accountOfflineEventUpdater = new Runnable() {
            public void run() {
                if (ZopimChatLogFragment.this.sendButton != null) {
                    ZopimChatLogFragment zopimChatLogFragment = ZopimChatLogFragment.this;
                    zopimChatLogFragment.setDisabledCompat(zopimChatLogFragment.sendButton);
                }
                if (ZopimChatLogFragment.this.attachButton != null) {
                    ZopimChatLogFragment zopimChatLogFragment2 = ZopimChatLogFragment.this;
                    zopimChatLogFragment2.setDisabledCompat(zopimChatLogFragment2.attachButton);
                }
                if (ZopimChatLogFragment.this.inputField != null) {
                    ZopimChatLogFragment.this.inputField.setEnabled(false);
                    ZopimChatLogFragment.this.inputField.setFocusable(false);
                }
            }
        };
        private Runnable accountOnlineEventUpdater = new Runnable() {
            public void run() {
                if (ZopimChatLogFragment.this.sendButton != null && ZopimChatLogFragment.this.inputField.getText().length() > 0) {
                    ZopimChatLogFragment zopimChatLogFragment = ZopimChatLogFragment.this;
                    zopimChatLogFragment.setEnabledCompat(zopimChatLogFragment.sendButton);
                }
                if (ZopimChatLogFragment.this.attachButton != null) {
                    ZopimChatLogFragment zopimChatLogFragment2 = ZopimChatLogFragment.this;
                    zopimChatLogFragment2.setEnabledCompat(zopimChatLogFragment2.attachButton);
                }
                if (ZopimChatLogFragment.this.inputField != null) {
                    ZopimChatLogFragment.this.inputField.setEnabled(true);
                    ZopimChatLogFragment.this.inputField.setFocusable(true);
                    ZopimChatLogFragment.this.inputField.setFocusableInTouchMode(true);
                }
            }
        };
        private Handler handler = new Handler();

        public void update(Account account) {
            Account.Status status;
            if (account != null && (status = account.getStatus()) != null) {
                int i11 = AnonymousClass15.$SwitchMap$com$zopim$android$sdk$model$Account$Status[status.ordinal()];
                if (i11 == 1) {
                    this.handler.postDelayed(this.accountOfflineEventUpdater, this.OFFLINE_THRESHOLD);
                } else if (i11 == 2) {
                    this.handler.removeCallbacks(this.accountOfflineEventUpdater);
                    this.handler.post(this.accountOnlineEventUpdater);
                }
            }
        }
    };
    private AgentTypingObserver agentTypingObserver;
    /* access modifiers changed from: private */
    public ImageButton attachButton;
    /* access modifiers changed from: private */
    public Chat chat;
    private AlertDialog chatEndConfirmDialog;
    /* access modifiers changed from: private */
    public ChatListener chatListener;
    private ChatLogAdapter chatLogAdapter;
    private ChatObserver chatObserver;
    private final ChatTimeoutReceiver chatTimeoutReceiver = new ChatTimeoutReceiver();
    /* access modifiers changed from: private */
    public AlertDialog emailTranscriptDialog;
    public final ArrayList<String> failedVisitorUploadItems = new ArrayList<>();
    private FileSending fileSending;
    /* access modifiers changed from: private */
    public final Handler handler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public EditText inputField;
    private InputMethodManager inputManager;
    /* access modifiers changed from: private */
    public boolean noConnection = false;
    private long reconnectTimeout = ChatSession.DEFAULT_RECONNECT_TIMEOUT;
    /* access modifiers changed from: private */
    public AlertDialog reconnectTimeoutDialog;
    /* access modifiers changed from: private */
    public RecyclerView recyclerView;
    /* access modifiers changed from: private */
    public ImageButton sendButton;
    public Runnable showReconnectFailed = new Runnable() {
        public void run() {
            AlertDialog unused = ZopimChatLogFragment.this.reconnectTimeoutDialog = new AlertDialog.Builder(ZopimChatLogFragment.this.getActivity()).setTitle(R.string.reconnect_timeout_title).setMessage(R.string.reconnect_timeout_message).setPositiveButton(R.string.reconnect_timeout_confirm_button, new DialogInterface.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(DialogInterface dialogInterface, int i11) {
                    dialogInterface.dismiss();
                    SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
                }
            }).setNegativeButton(R.string.reconnect_timeout_cancel_button, new DialogInterface.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(DialogInterface dialogInterface, int i11) {
                    ZopimChatLogFragment.this.chat.endChat();
                    ZopimChatLogFragment.this.close();
                    if (ZopimChatLogFragment.this.chatListener != null) {
                        ZopimChatLogFragment.this.chatListener.onChatEnded();
                    }
                    SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
                }
            }).show();
        }
    };

    /* renamed from: com.zopim.android.sdk.chatlog.ZopimChatLogFragment$15  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass15 {
        public static final /* synthetic */ int[] $SwitchMap$com$zopim$android$sdk$model$Account$Status;
        public static final /* synthetic */ int[] $SwitchMap$com$zopim$android$sdk$prechat$EmailTranscript;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        static {
            /*
                com.zopim.android.sdk.model.Account$Status[] r0 = com.zopim.android.sdk.model.Account.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$zopim$android$sdk$model$Account$Status = r0
                r1 = 1
                com.zopim.android.sdk.model.Account$Status r2 = com.zopim.android.sdk.model.Account.Status.OFFLINE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$zopim$android$sdk$model$Account$Status     // Catch:{ NoSuchFieldError -> 0x001d }
                com.zopim.android.sdk.model.Account$Status r3 = com.zopim.android.sdk.model.Account.Status.ONLINE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.zopim.android.sdk.prechat.EmailTranscript[] r2 = com.zopim.android.sdk.prechat.EmailTranscript.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$com$zopim$android$sdk$prechat$EmailTranscript = r2
                com.zopim.android.sdk.prechat.EmailTranscript r3 = com.zopim.android.sdk.prechat.EmailTranscript.DISABLED     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = $SwitchMap$com$zopim$android$sdk$prechat$EmailTranscript     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.zopim.android.sdk.prechat.EmailTranscript r2 = com.zopim.android.sdk.prechat.EmailTranscript.PROMPT     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.chatlog.ZopimChatLogFragment.AnonymousClass15.<clinit>():void");
        }
    }

    public class AgentTypingObserver extends AgentsTypingObserver {
        public AgentTypingObserver(Context context) {
            super(context);
        }

        /* access modifiers changed from: private */
        public void updateAgentTyping(AgentTyping agentTyping) {
            if (agentTyping == null) {
                Logger.b(ZopimChatLogFragment.LOG_TAG, "Can't update agent typing while typing event is null", new Object[0]);
                return;
            }
            Logger.j(ZopimChatLogFragment.LOG_TAG, "Agent " + agentTyping.getDisplayName() + " typing " + agentTyping.isTyping(), new Object[0]);
            ChatLogAdapter chatLogAdapter = (ChatLogAdapter) ZopimChatLogFragment.this.getListAdapter();
            RowItem item = chatLogAdapter.getItem(chatLogAdapter.getItemCount() + -1);
            if (item instanceof AgentTyping) {
                ((AgentTyping) item).setTyping(agentTyping.isTyping());
            } else {
                chatLogAdapter.add(new AgentTypingItem(agentTyping));
            }
            chatLogAdapter.notifyItemChanged(chatLogAdapter.getItemCount() - 1);
            ZopimChatLogFragment.this.recyclerView.getLayoutManager().scrollToPosition(chatLogAdapter.getItemCount() - 1);
        }

        public void updateTyping(final Map<String, AgentTyping> map) {
            ZopimChatLogFragment.this.handler.post(new Runnable() {
                public void run() {
                    for (AgentTyping access$2100 : map.values()) {
                        AgentTypingObserver.this.updateAgentTyping(access$2100);
                    }
                }
            });
        }
    }

    public class ChatObserver extends ChatItemsObserver {
        public ChatObserver(Context context) {
            super(context);
        }

        public void updateChatItems(final TreeMap<String, RowItem> treeMap) {
            ZopimChatLogFragment.this.handler.post(new Runnable() {
                public void run() {
                    ZopimChatLogFragment.this.updateChatLogAdapter(treeMap);
                }
            });
        }
    }

    public class ChatTimeoutReceiver extends BroadcastReceiver {
        public ChatTimeoutReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (intent == null || !ChatSession.ACTION_CHAT_SESSION_TIMEOUT.equals(intent.getAction())) {
                Logger.l(ZopimChatLogFragment.LOG_TAG, "onReceive: intent was null or getAction() was mismatched", new Object[0]);
                return;
            }
            Logger.j(ZopimChatLogFragment.LOG_TAG, "Received chat timeout. Disabling all input.", new Object[0]);
            ZopimChatLogFragment zopimChatLogFragment = ZopimChatLogFragment.this;
            zopimChatLogFragment.hideKeyboard(zopimChatLogFragment.inputField);
            ZopimChatLogFragment zopimChatLogFragment2 = ZopimChatLogFragment.this;
            zopimChatLogFragment2.setDisabledCompat(zopimChatLogFragment2.sendButton);
            ZopimChatLogFragment zopimChatLogFragment3 = ZopimChatLogFragment.this;
            zopimChatLogFragment3.setDisabledCompat(zopimChatLogFragment3.attachButton);
            ZopimChatLogFragment.this.inputField.setFocusable(false);
            ZopimChatLogFragment.this.inputField.setEnabled(false);
            ZopimChatLogFragment zopimChatLogFragment4 = ZopimChatLogFragment.this;
            zopimChatLogFragment4.setAdapterItemsDisabled(true, (ChatLogAdapter) zopimChatLogFragment4.getListAdapter());
        }
    }

    /* access modifiers changed from: private */
    public boolean canChat() {
        if (!(!this.chat.hasEnded()) || this.noConnection) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void close() {
        FragmentTransaction q11 = getFragmentManager().q();
        q11.s(this);
        q11.j();
    }

    /* access modifiers changed from: private */
    public void finishChat() {
        this.chat.endChat();
        close();
        ChatListener chatListener2 = this.chatListener;
        if (chatListener2 != null) {
            chatListener2.onChatEnded();
        }
    }

    /* access modifiers changed from: private */
    public RecyclerView.Adapter getListAdapter() {
        return this.recyclerView.getAdapter();
    }

    /* access modifiers changed from: private */
    public void hideKeyboard(View view) {
        if (view != null) {
            view.clearFocus();
            this.inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /* access modifiers changed from: private */
    public boolean isFileSendingEnabled() {
        FileSending fileSending2 = this.fileSending;
        boolean z11 = fileSending2 != null && fileSending2.isEnabled();
        boolean isFileSendingEnabled = this.chat.getConfig().isFileSendingEnabled();
        if (!z11 || !isFileSendingEnabled) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void setAdapterItemsDisabled(boolean z11, ChatLogAdapter chatLogAdapter2) {
        for (int i11 = 0; i11 < chatLogAdapter2.getItemCount(); i11++) {
            RowItem item = chatLogAdapter2.getItem(i11);
            if (item instanceof Disableable) {
                ((Disableable) item).setDisabled(z11);
                chatLogAdapter2.notifyItemChanged(i11);
            }
        }
    }

    /* access modifiers changed from: private */
    public void setDisabledCompat(ImageButton imageButton) {
        if (Build.VERSION.SDK_INT < 21) {
            a.o(imageButton.getBackground(), (ColorStateList) null);
        }
        setDisabledOpacityCompat(imageButton);
        imageButton.setEnabled(false);
    }

    private void setDisabledOpacityCompat(View view) {
        setOpacityCompat(view, R.dimen.inactive_icon_alpha);
    }

    /* access modifiers changed from: private */
    public void setEnabledCompat(ImageButton imageButton) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 21) {
            a.n(imageButton.getBackground(), Color.getThemeAccentColor(getActivity()));
        }
        if (i11 < 21) {
            imageButton.setAlpha(1.0f);
        }
        imageButton.setEnabled(true);
    }

    private void setEnabledOpacityCompat(View view) {
        setOpacityCompat(view, R.dimen.active_icon_alpha);
    }

    @TargetApi(11)
    private void setOpacityCompat(View view, int i11) {
        if (view == null) {
            Logger.b(LOG_TAG, "View is null, will not apply opacity", new Object[0]);
        } else if (!isVisible()) {
            Logger.b(LOG_TAG, "Fragment is not visible, will not apply opacity.", new Object[0]);
        } else {
            int i12 = Build.VERSION.SDK_INT;
            if (i12 < 21) {
                try {
                    TypedValue typedValue = new TypedValue();
                    getResources().getValue(i11, typedValue, true);
                    view.setAlpha(typedValue.getFloat());
                } catch (Resources.NotFoundException unused) {
                    Logger.d(LOG_TAG, "Could not find the resource for inactive_icon_alpha. Will not change the alpha value of the view.", new Object[0]);
                }
            } else {
                Logger.b(LOG_TAG, "This method only changes opacity for certain API levels. A non supported one was passed: " + i12, new Object[0]);
            }
        }
    }

    private void showConfirmDialog() {
        this.chatEndConfirmDialog = new AlertDialog.Builder(getActivity()).setTitle(R.string.chat_end_dialog_title).setMessage(R.string.chat_end_dialog_message).setPositiveButton(R.string.chat_end_dialog_confirm_button, new DialogInterface.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(DialogInterface dialogInterface, int i11) {
                EmailTranscript emailTranscript = ZopimChatLogFragment.this.chat.getConfig().getEmailTranscript();
                if (LivechatChatLogPath.getInstance().countMessages(ChatLog.Type.CHAT_MSG_VISITOR, ChatLog.Type.CHAT_MSG_AGENT) == 0) {
                    emailTranscript = EmailTranscript.DISABLED;
                }
                if (ZopimChatLogFragment.this.noConnection) {
                    emailTranscript = EmailTranscript.DISABLED;
                }
                int i12 = AnonymousClass15.$SwitchMap$com$zopim$android$sdk$prechat$EmailTranscript[emailTranscript.ordinal()];
                if (i12 == 1) {
                    ZopimChatLogFragment.this.finishChat();
                } else if (i12 == 2 && !ZopimChatLogFragment.this.noConnection) {
                    ZopimChatLogFragment.this.showEmailTranscriptDialog();
                }
                SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
            }
        }).setNegativeButton(R.string.chat_end_dialog_cancel_button, new DialogInterface.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(DialogInterface dialogInterface, int i11) {
                dialogInterface.dismiss();
                SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
            }
        }).show();
    }

    /* access modifiers changed from: private */
    public void showEmailTranscriptDialog() {
        final Profile profile = ZopimChatApi.getDataSource().getProfile();
        boolean z11 = (profile == null || profile.getEmail() == null || profile.getEmail().isEmpty()) ? false : true;
        final EditText editText = (EditText) getActivity().getLayoutInflater().inflate(R.layout.email_transcript_input_view, (ViewGroup) null);
        AlertDialog.Builder message = new AlertDialog.Builder(getActivity()).setPositiveButton(17039370, (DialogInterface.OnClickListener) null).setTitle(R.string.email_transcript_title).setMessage(R.string.email_transcript_message);
        int i11 = R.string.email_transcript_confirm_button;
        AlertDialog.Builder negativeButton = message.setPositiveButton(i11, new DialogInterface.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(DialogInterface dialogInterface, int i11) {
                SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
            }
        }).setNegativeButton(R.string.email_transcript_cancel_button, new DialogInterface.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(DialogInterface dialogInterface, int i11) {
                dialogInterface.dismiss();
                ZopimChatLogFragment.this.finishChat();
                SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
            }
        });
        if (z11) {
            negativeButton.setPositiveButton(i11, new DialogInterface.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(DialogInterface dialogInterface, int i11) {
                    String email = profile.getEmail();
                    if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        ZopimChatLogFragment.this.chat.emailTranscript(email);
                        ZopimChatLogFragment.this.emailTranscriptDialog.dismiss();
                        ZopimChatLogFragment.this.finishChat();
                    }
                    SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
                }
            });
            this.emailTranscriptDialog = negativeButton.show();
            return;
        }
        AlertDialog show = negativeButton.setView(editText).show();
        this.emailTranscriptDialog = show;
        TextView textView = (TextView) show.findViewById(16908299);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(textView.getLayoutParams());
        layoutParams.leftMargin = textView.getPaddingLeft() - editText.getPaddingLeft();
        layoutParams.rightMargin = textView.getPaddingRight() + editText.getPaddingRight();
        editText.setLayoutParams(layoutParams);
        final Button button = this.emailTranscriptDialog.getButton(-1);
        if (button != null) {
            if (editText.getText().length() > 0) {
                button.setEnabled(true);
            } else {
                button.setEnabled(false);
            }
            button.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    String trim = editText.getText().toString().trim();
                    if (Patterns.EMAIL_ADDRESS.matcher(trim).matches()) {
                        ZopimChatLogFragment.this.chat.setEmail(trim);
                        ZopimChatLogFragment.this.chat.emailTranscript(trim);
                        ZopimChatLogFragment.this.emailTranscriptDialog.dismiss();
                        ZopimChatLogFragment.this.finishChat();
                    } else {
                        editText.setError(ZopimChatLogFragment.this.getResources().getText(R.string.email_transcript_email_message));
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            editText.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                    if (editable.length() <= 0 || ZopimChatLogFragment.this.noConnection) {
                        button.setEnabled(false);
                    } else {
                        button.setEnabled(true);
                    }
                }

                public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                }

                public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                }
            });
        }
    }

    private void showKeyboard(View view) {
        if (view != null && view.isEnabled()) {
            view.requestFocus();
            this.inputManager.showSoftInput(view, 1);
        }
    }

    /* access modifiers changed from: private */
    public void updateChatLogAdapter(TreeMap<String, RowItem> treeMap) {
        if (!(getListAdapter() instanceof ChatLogAdapter)) {
            Logger.l(LOG_TAG, "Aborting update. Adapter must be of type " + ChatLogAdapter.class, new Object[0]);
            return;
        }
        final ChatLogAdapter chatLogAdapter2 = (ChatLogAdapter) getListAdapter();
        if (treeMap.size() == 0) {
            chatLogAdapter2.clear();
            chatLogAdapter2.notifyDataSetChanged();
            return;
        }
        int i11 = 0;
        while (i11 < chatLogAdapter2.getItemCount()) {
            RowItem item = chatLogAdapter2.getItem(i11);
            RowItem wrapItem = wrapItem(f.e(item.getId()) ? null : treeMap.get(item.getId()));
            if (wrapItem == null) {
                Logger.j(LOG_TAG, "Removed row item " + item.getType(), new Object[0]);
                chatLogAdapter2.remove(i11);
                chatLogAdapter2.notifyItemChanged(i11);
            } else {
                if (!item.equals(wrapItem)) {
                    Logger.j(LOG_TAG, "Update " + item.getType(), new Object[0]);
                    item.update(wrapItem);
                    chatLogAdapter2.notifyItemChanged(i11);
                    if ((item instanceof ChatRating) && i11 == chatLogAdapter2.getItemCount() - 1) {
                        new Handler().post(new Runnable() {
                            public void run() {
                                ZopimChatLogFragment.this.recyclerView.getLayoutManager().scrollToPosition(chatLogAdapter2.getItemCount() - 1);
                            }
                        });
                    }
                }
                treeMap.remove(wrapItem.getId());
                i11++;
            }
        }
        for (RowItem next : treeMap.values()) {
            if (next instanceof VisitorAttachment) {
                VisitorAttachment visitorAttachment = (VisitorAttachment) next;
                if (visitorAttachment.getUploadUrl() == null) {
                    if (visitorAttachment.getError() != null && !this.failedVisitorUploadItems.contains(visitorAttachment.getId())) {
                        Toast.makeText(getContext(), visitorAttachment.getError(), 1).show();
                        this.failedVisitorUploadItems.add(visitorAttachment.getId());
                    }
                }
            }
            RowItem wrapItem2 = wrapItem(next);
            chatLogAdapter2.add(wrapItem2);
            Logger.j(LOG_TAG, "Added RowItem " + wrapItem2, new Object[0]);
            chatLogAdapter2.notifyItemChanged(chatLogAdapter2.getItemCount());
            Logger.j(LOG_TAG, "Auto-scroll", new Object[0]);
            this.recyclerView.getLayoutManager().scrollToPosition(getListAdapter().getItemCount() - 1);
        }
    }

    private RowItem wrapItem(RowItem rowItem) {
        RowItem agentMessageItem = rowItem instanceof AgentMessage ? new AgentMessageItem((AgentMessage) rowItem) : rowItem;
        if (rowItem instanceof AgentAttachment) {
            agentMessageItem = new AgentAttachmentItem((AgentAttachment) rowItem);
        }
        if (rowItem instanceof AgentOptions) {
            agentMessageItem = new AgentOptionsItem((AgentOptions) rowItem);
        }
        if (rowItem instanceof VisitorMessage) {
            agentMessageItem = new VisitorMessageItem((VisitorMessage) rowItem);
        }
        return rowItem instanceof VisitorAttachment ? new VisitorAttachmentItem((VisitorAttachment) rowItem) : agentMessageItem;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        BelvedereProvider.INSTANCE.getInstance(getContext()).e(i11, i12, intent, new BelvedereCallback<List<BelvedereResult>>() {
            public void success(List<BelvedereResult> list) {
                if (list == null) {
                    Logger.g(ZopimChatLogFragment.LOG_TAG, "No files selected for upload.", new Object[0]);
                    return;
                }
                Logger.g(ZopimChatLogFragment.LOG_TAG, "Sending " + list.size(), new Object[0]);
                for (BelvedereResult file : list) {
                    File file2 = file.getFile();
                    if (file2 != null) {
                        ZopimChatLogFragment.this.chat.send(file2);
                    } else {
                        Logger.l(ZopimChatLogFragment.LOG_TAG, "Failed to send a file. File was null.", new Object[0]);
                    }
                }
            }
        });
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ChatListener) {
            this.chatListener = (ChatListener) activity;
        }
    }

    public void onConnected() {
        this.noConnection = false;
        this.handler.removeCallbacks(this.showReconnectFailed);
        if (canChat()) {
            ImageButton imageButton = this.sendButton;
            if (imageButton != null && !imageButton.isEnabled() && this.inputField.getText().length() > 0) {
                setEnabledCompat(this.sendButton);
            }
            ImageButton imageButton2 = this.attachButton;
            if (imageButton2 != null && !imageButton2.isEnabled()) {
                setEnabledCompat(this.attachButton);
            }
        }
        getListAdapter().notifyDataSetChanged();
        setAdapterItemsDisabled(false, (ChatLogAdapter) getListAdapter());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        this.reconnectTimeout = ZopimChatApi.getReconnectTimeout().longValue();
        this.fileSending = ZopimChatApi.getDataSource().getFileSending();
        this.inputManager = (InputMethodManager) getActivity().getSystemService("input_method");
        Chat resume = ZopimChat.resume(getActivity());
        this.chat = resume;
        if ((resume instanceof UninitializedChat) && getActivity() != null) {
            getActivity().finish();
        } else if (bundle == null) {
            ConnectionToastFragment connectionToastFragment = new ConnectionToastFragment();
            ConnectionFragment connectionFragment = new ConnectionFragment();
            FragmentTransaction q11 = getChildFragmentManager().q();
            q11.e(connectionToastFragment, ConnectionToastFragment.class.getName());
            q11.e(connectionFragment, ConnectionFragment.class.getName());
            q11.j();
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.chat_log_menu, menu);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.zopim_chat_log_fragment, viewGroup, false);
        this.recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler_view);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        ChatLogAdapter chatLogAdapter2 = new ChatLogAdapter(getActivity(), new ArrayList());
        this.chatLogAdapter = chatLogAdapter2;
        chatLogAdapter2.setChat(this.chat);
        this.recyclerView.setAdapter(this.chatLogAdapter);
        return inflate;
    }

    public void onDisconnected() {
        this.noConnection = true;
        ImageButton imageButton = this.sendButton;
        if (imageButton != null && imageButton.isEnabled()) {
            setDisabledCompat(this.sendButton);
        }
        ImageButton imageButton2 = this.attachButton;
        if (imageButton2 != null && imageButton2.isEnabled()) {
            setDisabledCompat(this.attachButton);
        }
        setAdapterItemsDisabled(true, (ChatLogAdapter) getListAdapter());
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    public void onHideToast() {
        this.handler.removeCallbacks(this.showReconnectFailed);
    }

    @SensorsDataInstrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (16908332 == itemId && this.chat.hasEnded()) {
            close();
            boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return onOptionsItemSelected;
        } else if (R.id.end_chat == itemId) {
            if (this.chat.hasEnded()) {
                close();
                ChatListener chatListener2 = this.chatListener;
                if (chatListener2 != null) {
                    chatListener2.onChatEnded();
                }
            } else {
                showConfirmDialog();
            }
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return true;
        } else {
            boolean onOptionsItemSelected2 = super.onOptionsItemSelected(menuItem);
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return onOptionsItemSelected2;
        }
    }

    @TargetApi(11)
    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        hideKeyboard(this.inputField);
        boolean z11 = true;
        if (!(!this.chat.hasEnded()) || getActivity().isChangingConfigurations()) {
            z11 = false;
        }
        if (z11) {
            ChatWidgetService.startService(getActivity());
        }
        s1.a.b(getContext()).d(new Intent().setAction(ChatSession.ACTION_CHAT_BACKGROUND));
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        ChatWidgetService.stopService(getActivity());
        if (this.chat.hasEnded()) {
            hideKeyboard(this.inputField);
            setDisabledCompat(this.sendButton);
            setDisabledCompat(this.attachButton);
            this.inputField.setFocusable(false);
            this.inputField.setEnabled(false);
            Logger.j(LOG_TAG, "Resuming expired chat. Disable all input elements.", new Object[0]);
        } else {
            this.chat = ZopimChat.resume(getActivity());
        }
        s1.a.b(getContext()).d(new Intent().setAction(ChatSession.ACTION_CHAT_FOREGROUND));
        FragmentTrackHelper.trackFragmentResume(this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(STATE_SEND_BUTTON_ENABLED, this.sendButton.isEnabled());
        bundle.putBoolean(STATE_ATTACH_BUTTON_ENABLED, this.attachButton.isEnabled());
        bundle.putBoolean(STATE_INPUT_FIELD_ENABLED, this.inputField.isEnabled());
        bundle.putString(STATE_INPUT_FIELD_TEXT, this.inputField.getText().toString().trim());
        bundle.putBoolean(STATE_NO_CONNECTION, this.noConnection);
        AlertDialog alertDialog = this.reconnectTimeoutDialog;
        boolean z11 = true;
        bundle.putBoolean(STATE_SHOW_RECONNECT_TIMEOUT_DIALOG, alertDialog != null && alertDialog.isShowing());
        AlertDialog alertDialog2 = this.chatEndConfirmDialog;
        bundle.putBoolean(STATE_SHOW_CHAT_END_CONFIRM_DIALOG, alertDialog2 != null && alertDialog2.isShowing());
        AlertDialog alertDialog3 = this.emailTranscriptDialog;
        if (alertDialog3 == null || !alertDialog3.isShowing()) {
            z11 = false;
        }
        bundle.putBoolean(STATE_SHOW_EMAIL_TRANSCRIPT_DIALOG, z11);
        bundle.putStringArrayList(STATE_FAILED_VISITOR_UPLOAD_ITEMS, this.failedVisitorUploadItems);
    }

    public void onShowToast() {
        this.handler.removeCallbacks(this.showReconnectFailed);
        this.handler.postDelayed(this.showReconnectFailed, this.reconnectTimeout);
    }

    public void onStart() {
        super.onStart();
        this.chatObserver = new ChatObserver(getContext());
        this.agentTypingObserver = new AgentTypingObserver(getContext());
        ZopimChatApi.getDataSource().addChatLogObserver(this.chatObserver).trigger();
        ZopimChatApi.getDataSource().addAgentsObserver(this.agentTypingObserver).trigger();
        ZopimChatApi.getDataSource().addAccountObserver(this.accountObserver).trigger();
        s1.a.b(getContext()).c(this.chatTimeoutReceiver, new IntentFilter(ChatSession.ACTION_CHAT_SESSION_TIMEOUT));
    }

    public void onStop() {
        super.onStop();
        this.handler.removeCallbacksAndMessages((Object) null);
        AlertDialog alertDialog = this.reconnectTimeoutDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.reconnectTimeoutDialog.dismiss();
        }
        AlertDialog alertDialog2 = this.chatEndConfirmDialog;
        if (alertDialog2 != null && alertDialog2.isShowing()) {
            this.chatEndConfirmDialog.dismiss();
        }
        AlertDialog alertDialog3 = this.emailTranscriptDialog;
        if (alertDialog3 != null && alertDialog3.isShowing()) {
            this.emailTranscriptDialog.dismiss();
        }
        ZopimChatApi.getDataSource().deleteChatLogObserver(this.chatObserver);
        ZopimChatApi.getDataSource().deleteAgentsObserver(this.agentTypingObserver);
        ZopimChatApi.getDataSource().deleteAccountObserver(this.accountObserver);
        s1.a.b(getContext()).e(this.chatTimeoutReceiver);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.inputField = (EditText) view.findViewById(R.id.input_field);
        this.attachButton = (ImageButton) view.findViewById(R.id.attach_button);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.send_button);
        this.sendButton = imageButton;
        Drawable r11 = a.r(imageButton.getBackground());
        if (Build.VERSION.SDK_INT >= 16) {
            this.sendButton.setBackground(r11);
        } else {
            this.sendButton.setBackgroundDrawable(r11);
        }
        setDisabledOpacityCompat(view.findViewById(R.id.chat_reply_icon));
        setEnabledOpacityCompat(this.attachButton);
        if (isFileSendingEnabled()) {
            this.attachButton.setVisibility(0);
        } else {
            setDisabledOpacityCompat(this.sendButton);
            setDisabledCompat(this.sendButton);
            this.sendButton.setVisibility(0);
            this.attachButton.setVisibility(8);
        }
        this.inputField.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    ZopimChatLogFragment.this.attachButton.setVisibility(8);
                    ZopimChatLogFragment.this.sendButton.setVisibility(0);
                    if (ZopimChatLogFragment.this.canChat()) {
                        ZopimChatLogFragment zopimChatLogFragment = ZopimChatLogFragment.this;
                        zopimChatLogFragment.setEnabledCompat(zopimChatLogFragment.sendButton);
                        return;
                    }
                    ZopimChatLogFragment zopimChatLogFragment2 = ZopimChatLogFragment.this;
                    zopimChatLogFragment2.setDisabledCompat(zopimChatLogFragment2.sendButton);
                } else if (ZopimChatLogFragment.this.isFileSendingEnabled()) {
                    ZopimChatLogFragment.this.attachButton.setVisibility(0);
                    ZopimChatLogFragment.this.sendButton.setVisibility(8);
                } else {
                    ZopimChatLogFragment.this.sendButton.setVisibility(0);
                    ZopimChatLogFragment.this.attachButton.setVisibility(8);
                    ZopimChatLogFragment zopimChatLogFragment3 = ZopimChatLogFragment.this;
                    zopimChatLogFragment3.setDisabledCompat(zopimChatLogFragment3.sendButton);
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.sendButton.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                String trim = ZopimChatLogFragment.this.inputField.getText().toString().trim();
                if (!trim.isEmpty()) {
                    ZopimChatLogFragment.this.chat.send(trim);
                    ZopimChatLogFragment.this.inputField.setText("");
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.attachButton.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                BelvedereProvider.INSTANCE.getInstance(ZopimChatLogFragment.this.getContext()).f(ZopimChatLogFragment.this.getChildFragmentManager());
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            if (bundle.getBoolean(STATE_SEND_BUTTON_ENABLED, true)) {
                setEnabledCompat(this.sendButton);
            } else {
                setDisabledCompat(this.sendButton);
            }
            if (bundle.getBoolean(STATE_ATTACH_BUTTON_ENABLED, true)) {
                setEnabledCompat(this.attachButton);
            } else {
                setDisabledCompat(this.attachButton);
            }
            boolean z11 = bundle.getBoolean(STATE_INPUT_FIELD_ENABLED, true);
            this.inputField.setEnabled(z11);
            this.inputField.setFocusable(z11);
            this.inputField.setText(bundle.getString(STATE_INPUT_FIELD_TEXT));
            this.noConnection = bundle.getBoolean(STATE_NO_CONNECTION, false);
            boolean z12 = bundle.getBoolean(STATE_SHOW_RECONNECT_TIMEOUT_DIALOG, false);
            boolean z13 = bundle.getBoolean(STATE_SHOW_CHAT_END_CONFIRM_DIALOG, false);
            boolean z14 = bundle.getBoolean(STATE_SHOW_EMAIL_TRANSCRIPT_DIALOG, false);
            if (z12) {
                this.handler.post(this.showReconnectFailed);
            }
            if (z13) {
                showConfirmDialog();
            }
            if (z14) {
                showEmailTranscriptDialog();
            }
            this.failedVisitorUploadItems.addAll(bundle.getStringArrayList(STATE_FAILED_VISITOR_UPLOAD_ITEMS));
        } else {
            setDisabledCompat(this.sendButton);
        }
        if (this.inputField.isEnabled()) {
            showKeyboard(this.inputField);
        }
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }
}
