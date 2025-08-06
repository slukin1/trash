package com.zopim.android.sdk.prechat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.textfield.TextInputLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.R;
import com.zopim.android.sdk.api.Chat;
import com.zopim.android.sdk.api.ZopimChat;
import com.zopim.android.sdk.api.ZopimChatApi;
import com.zopim.android.sdk.chatlog.ConnectionFragment;
import com.zopim.android.sdk.chatlog.ConnectionToastFragment;
import com.zopim.android.sdk.data.observers.FormsObserver;
import com.zopim.android.sdk.embeddable.Contract;
import com.zopim.android.sdk.model.Forms;
import com.zopim.android.sdk.model.VisitorInfo;
import mz.f;

public class ZopimOfflineFragment extends Fragment implements ConnectionFragment.ConnectionListener {
    private static final String LOG_TAG = "ZopimOfflineFragment";
    public static final String STATE_MENU_ITEM_ENABLED = "MENU_ITEM_ENABLED";
    private static final String STATE_PROGRESS_VISIBILITY = "PROGRESS_VISIBILITY";
    /* access modifiers changed from: private */
    public Chat chat;
    /* access modifiers changed from: private */
    public ChatListener chatListener;
    private TextInputLayout emailInput;
    public FormsObserver formsObserver = new FormsObserver() {
        public void update(Forms forms) {
            Forms.OfflineForm offlineForm = forms.getOfflineForm();
            if (offlineForm != null && offlineForm.getFormSubmitted() == null) {
                ZopimOfflineFragment.this.handler.post(new Runnable() {
                    public void run() {
                        ZopimOfflineFragment.this.handler.removeCallbacks(ZopimOfflineFragment.this.showSendTimeoutDialog);
                        ZopimOfflineFragment.this.progressBar.setVisibility(8);
                        Toast.makeText(ZopimOfflineFragment.this.getActivity(), R.string.offline_sent_confirmation_message, 1).show();
                        ZopimOfflineFragment.this.chat.endChat();
                        ZopimOfflineFragment.this.close();
                        if (ZopimOfflineFragment.this.chatListener != null) {
                            ZopimOfflineFragment.this.chatListener.onChatEnded();
                        }
                    }
                });
            }
        }
    };
    /* access modifiers changed from: private */
    public Handler handler = new Handler(Looper.getMainLooper());
    private Menu menu;
    private TextInputLayout messageInput;
    private TextInputLayout nameInput;
    /* access modifiers changed from: private */
    public View progressBar;
    /* access modifiers changed from: private */
    public AlertDialog sendTimeoutDialog;
    public Runnable showSendTimeoutDialog = new Runnable() {
        public void run() {
            ZopimOfflineFragment.this.progressBar.setVisibility(8);
            ZopimOfflineFragment.this.setMenuItemEnabled(R.id.send, true);
            AlertDialog unused = ZopimOfflineFragment.this.sendTimeoutDialog = new AlertDialog.Builder(ZopimOfflineFragment.this.getActivity()).setMessage(R.string.offline_message_send_failed).setPositiveButton(R.string.offline_message_retry_button, new DialogInterface.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(DialogInterface dialogInterface, int i11) {
                    ZopimOfflineFragment.this.sendOfflineMessage();
                    SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
                }
            }).setNegativeButton(R.string.offline_message_cancel_button, new DialogInterface.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(DialogInterface dialogInterface, int i11) {
                    ZopimOfflineFragment.this.chat.endChat();
                    ZopimOfflineFragment.this.close();
                    if (ZopimOfflineFragment.this.chatListener != null) {
                        ZopimOfflineFragment.this.chatListener.onChatEnded();
                    }
                    SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
                }
            }).show();
        }
    };
    private boolean stateMenuItemEnabled = true;
    private VisitorInfo visitorInfo;

    /* access modifiers changed from: private */
    public void close() {
        FragmentTransaction q11 = getFragmentManager().q();
        q11.s(this);
        q11.j();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendOfflineMessage() {
        /*
            r8 = this;
            com.google.android.material.textfield.TextInputLayout r0 = r8.nameInput
            int r0 = r0.getVisibility()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0042
            com.google.android.material.textfield.TextInputLayout r0 = r8.nameInput
            android.widget.EditText r0 = r0.getEditText()
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.trim()
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x0048
            com.google.android.material.textfield.TextInputLayout r3 = r8.nameInput
            android.content.res.Resources r4 = r8.getResources()
            int r5 = com.zopim.android.sdk.R.string.offline_name_error_message
            java.lang.String r4 = r4.getString(r5)
            r3.setError(r4)
            com.google.android.material.textfield.TextInputLayout r3 = r8.nameInput
            android.content.res.Resources r4 = r8.getResources()
            int r5 = com.zopim.android.sdk.R.string.offline_name_error_hint
            java.lang.String r4 = r4.getString(r5)
            r3.setHint((java.lang.CharSequence) r4)
            r3 = r2
            goto L_0x0049
        L_0x0042:
            com.zopim.android.sdk.model.VisitorInfo r0 = r8.visitorInfo
            java.lang.String r0 = r0.getName()
        L_0x0048:
            r3 = r1
        L_0x0049:
            com.google.android.material.textfield.TextInputLayout r4 = r8.emailInput
            int r4 = r4.getVisibility()
            if (r4 != 0) goto L_0x008f
            com.google.android.material.textfield.TextInputLayout r4 = r8.emailInput
            android.widget.EditText r4 = r4.getEditText()
            android.text.Editable r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = r4.trim()
            java.util.regex.Pattern r5 = android.util.Patterns.EMAIL_ADDRESS
            java.util.regex.Matcher r5 = r5.matcher(r4)
            boolean r5 = r5.matches()
            if (r5 != 0) goto L_0x0095
            com.google.android.material.textfield.TextInputLayout r3 = r8.emailInput
            android.content.res.Resources r5 = r8.getResources()
            int r6 = com.zopim.android.sdk.R.string.offline_email_error_message
            java.lang.String r5 = r5.getString(r6)
            r3.setError(r5)
            com.google.android.material.textfield.TextInputLayout r3 = r8.emailInput
            android.content.res.Resources r5 = r8.getResources()
            int r6 = com.zopim.android.sdk.R.string.offline_email_error_hint
            java.lang.String r5 = r5.getString(r6)
            r3.setHint((java.lang.CharSequence) r5)
            r3 = r2
            goto L_0x0095
        L_0x008f:
            com.zopim.android.sdk.model.VisitorInfo r4 = r8.visitorInfo
            java.lang.String r4 = r4.getEmail()
        L_0x0095:
            com.google.android.material.textfield.TextInputLayout r5 = r8.messageInput
            int r5 = r5.getVisibility()
            if (r5 != 0) goto L_0x00d5
            com.google.android.material.textfield.TextInputLayout r5 = r8.messageInput
            android.widget.EditText r5 = r5.getEditText()
            android.text.Editable r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.trim()
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L_0x00d6
            com.google.android.material.textfield.TextInputLayout r3 = r8.messageInput
            android.content.res.Resources r6 = r8.getResources()
            int r7 = com.zopim.android.sdk.R.string.offline_message_error_message
            java.lang.String r6 = r6.getString(r7)
            r3.setError(r6)
            com.google.android.material.textfield.TextInputLayout r3 = r8.messageInput
            android.content.res.Resources r6 = r8.getResources()
            int r7 = com.zopim.android.sdk.R.string.offline_message_error_hint
            java.lang.String r6 = r6.getString(r7)
            r3.setHint((java.lang.CharSequence) r6)
            r3 = r2
            goto L_0x00d6
        L_0x00d5:
            r5 = 0
        L_0x00d6:
            if (r3 == 0) goto L_0x0102
            com.zopim.android.sdk.api.Chat r1 = r8.chat
            boolean r0 = r1.sendOfflineMessage(r0, r4, r5)
            if (r0 != 0) goto L_0x00e8
            android.os.Handler r0 = r8.handler
            java.lang.Runnable r1 = r8.showSendTimeoutDialog
            r0.post(r1)
            goto L_0x010f
        L_0x00e8:
            int r0 = com.zopim.android.sdk.R.id.send
            r8.setMenuItemEnabled(r0, r2)
            android.view.View r0 = r8.progressBar
            r0.setVisibility(r2)
            android.os.Handler r0 = r8.handler
            java.lang.Runnable r1 = r8.showSendTimeoutDialog
            java.lang.Long r2 = com.zopim.android.sdk.api.ZopimChatApi.getInitializationTimeout()
            long r2 = r2.longValue()
            r0.postDelayed(r1, r2)
            goto L_0x010f
        L_0x0102:
            androidx.fragment.app.FragmentActivity r0 = r8.getActivity()
            int r2 = com.zopim.android.sdk.R.string.offline_validation_error_message
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r1)
            r0.show()
        L_0x010f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.prechat.ZopimOfflineFragment.sendOfflineMessage():void");
    }

    /* access modifiers changed from: private */
    public void setMenuItemEnabled(int i11, boolean z11) {
        MenuItem findItem;
        Menu menu2 = this.menu;
        if (menu2 != null && (findItem = menu2.findItem(i11)) != null && findItem.isEnabled() != z11) {
            findItem.setEnabled(z11);
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

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ChatListener) {
            this.chatListener = (ChatListener) activity;
        }
    }

    public void onConnected() {
        setMenuItemEnabled(R.id.send, true);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        Chat resume = ZopimChat.resume(getActivity());
        this.chat = resume;
        this.visitorInfo = resume.getConfig().getVisitorInfo();
        if (bundle == null) {
            ConnectionToastFragment connectionToastFragment = new ConnectionToastFragment();
            ConnectionFragment connectionFragment = new ConnectionFragment();
            FragmentTransaction q11 = getChildFragmentManager().q();
            q11.e(connectionToastFragment, ConnectionToastFragment.class.getName());
            q11.e(connectionFragment, ConnectionFragment.class.getName());
            q11.j();
        }
    }

    public void onCreateOptionsMenu(Menu menu2, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu2, menuInflater);
        menuInflater.inflate(R.menu.chat_offline_message_menu, menu2);
        menu2.findItem(R.id.send).setEnabled(this.stateMenuItemEnabled);
        this.menu = menu2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.zopim_offline_message_fragment, viewGroup, false);
    }

    public void onDisconnected() {
        setMenuItemEnabled(R.id.send, false);
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 == menuItem.getItemId()) {
            close();
        }
        if (R.id.send == menuItem.getItemId()) {
            sendOfflineMessage();
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return onOptionsItemSelected;
    }

    @SensorsDataInstrumented
    public void onPause() {
        if (getActivity().isFinishing()) {
            Logger.g(LOG_TAG, "Ending chat.", new Object[0]);
            this.chat.endChat();
            ChatListener chatListener2 = this.chatListener;
            if (chatListener2 != null) {
                chatListener2.onChatEnded();
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
        bundle.putBoolean(STATE_MENU_ITEM_ENABLED, this.menu.findItem(R.id.send).isEnabled());
        bundle.putInt(STATE_PROGRESS_VISIBILITY, this.progressBar.getVisibility());
    }

    public void onStart() {
        super.onStart();
        ZopimChatApi.getDataSource().addFormsObserver(this.formsObserver);
    }

    public void onStop() {
        super.onStop();
        this.handler.removeCallbacksAndMessages((Object) null);
        ZopimChatApi.getDataSource().deleteFormsObserver(this.formsObserver);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.nameInput = (TextInputLayout) view.findViewById(R.id.name);
        this.emailInput = (TextInputLayout) view.findViewById(R.id.email);
        this.messageInput = (TextInputLayout) view.findViewById(R.id.message);
        this.progressBar = view.findViewById(R.id.progress);
        TextInputLayout textInputLayout = this.nameInput;
        Resources resources = getResources();
        int i11 = R.string.required_field_template;
        textInputLayout.setHint((CharSequence) String.format(resources.getString(i11), new Object[]{this.nameInput.getHint()}));
        this.emailInput.setHint((CharSequence) String.format(getResources().getString(i11), new Object[]{this.emailInput.getHint()}));
        this.messageInput.setHint((CharSequence) String.format(getResources().getString(i11), new Object[]{this.messageInput.getHint()}));
        if (getArguments() != null) {
            String string = getArguments().getString(Contract.EXTRA_NAME);
            String string2 = getArguments().getString(Contract.EXTRA_EMAIL);
            String string3 = getArguments().getString(Contract.EXTRA_MESSAGE);
            if (!f.e(string)) {
                this.nameInput.getEditText().setText(string);
            }
            if (!f.e(string2)) {
                this.emailInput.getEditText().setText(string2);
            }
            if (!f.e(string3)) {
                this.messageInput.getEditText().setText(string3);
            }
        } else {
            VisitorInfo visitorInfo2 = this.visitorInfo;
            if (visitorInfo2 != null) {
                if (f.c(visitorInfo2.getName())) {
                    this.nameInput.getEditText().setText(this.visitorInfo.getName());
                }
                if (f.c(this.visitorInfo.getEmail())) {
                    this.emailInput.getEditText().setText(this.visitorInfo.getEmail());
                }
            }
        }
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            this.stateMenuItemEnabled = bundle.getBoolean(STATE_MENU_ITEM_ENABLED, true);
            setViewVisibility(this.progressBar, bundle.getInt(STATE_PROGRESS_VISIBILITY, 8));
        }
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }
}
