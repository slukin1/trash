package com.zopim.android.sdk.prechat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.core.widget.l;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
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
import com.zopim.android.sdk.chatlog.ZopimChatLogFragment;
import com.zopim.android.sdk.chatlog.view.SnackbarAdapter;
import com.zopim.android.sdk.data.LivechatAccountPath;
import com.zopim.android.sdk.data.LivechatDepartmentsPath;
import com.zopim.android.sdk.embeddable.Contract;
import com.zopim.android.sdk.model.Account;
import com.zopim.android.sdk.model.Department;
import com.zopim.android.sdk.model.VisitorInfo;
import com.zopim.android.sdk.prechat.PreChatForm;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mz.a;
import mz.f;

public class ZopimPreChatFragment extends Fragment implements ConnectionFragment.ConnectionListener {
    private static final String EXTRA_PRE_CHAT_CONFIG = "PRE_CHAT_CONFIG";
    private static final String LOG_TAG = "ZopimPreChatFragment";
    private static final String STATE_MENU_ITEM_ENABLED = "MENU_ITEM_ENABLED";
    private static final String STATE_SHOW_ACCOUNT_OFFLINE_DIALOG = "SHOW_ACCOUNT_OFFLINE_DIALOG";
    private AlertDialog accountOfflineDialog;
    /* access modifiers changed from: private */
    public Chat chat;
    /* access modifiers changed from: private */
    public ChatListener chatListener;
    private Spinner departmentSpinner;
    /* access modifiers changed from: private */
    public TextInputLayout emailInput;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Menu menu;
    /* access modifiers changed from: private */
    public TextInputLayout messageInput;
    /* access modifiers changed from: private */
    public TextInputLayout nameInput;
    private TextInputLayout phoneInput;
    /* access modifiers changed from: private */
    public PreChatForm preChatForm = new PreChatForm.Builder().build();
    private boolean stateMenuItemEnabled = true;

    /* renamed from: com.zopim.android.sdk.prechat.ZopimPreChatFragment$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] $SwitchMap$com$zopim$android$sdk$model$Department$Status;
        public static final /* synthetic */ int[] $SwitchMap$com$zopim$android$sdk$prechat$PreChatForm$Field;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0058 */
        static {
            /*
                com.zopim.android.sdk.model.Department$Status[] r0 = com.zopim.android.sdk.model.Department.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$zopim$android$sdk$model$Department$Status = r0
                r1 = 1
                com.zopim.android.sdk.model.Department$Status r2 = com.zopim.android.sdk.model.Department.Status.ONLINE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$zopim$android$sdk$model$Department$Status     // Catch:{ NoSuchFieldError -> 0x001d }
                com.zopim.android.sdk.model.Department$Status r3 = com.zopim.android.sdk.model.Department.Status.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$zopim$android$sdk$model$Department$Status     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.zopim.android.sdk.model.Department$Status r4 = com.zopim.android.sdk.model.Department.Status.OFFLINE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.zopim.android.sdk.prechat.PreChatForm$Field[] r3 = com.zopim.android.sdk.prechat.PreChatForm.Field.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$zopim$android$sdk$prechat$PreChatForm$Field = r3
                com.zopim.android.sdk.prechat.PreChatForm$Field r4 = com.zopim.android.sdk.prechat.PreChatForm.Field.OPTIONAL_EDITABLE     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = $SwitchMap$com$zopim$android$sdk$prechat$PreChatForm$Field     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.zopim.android.sdk.prechat.PreChatForm$Field r3 = com.zopim.android.sdk.prechat.PreChatForm.Field.OPTIONAL     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$prechat$PreChatForm$Field     // Catch:{ NoSuchFieldError -> 0x004d }
                com.zopim.android.sdk.prechat.PreChatForm$Field r1 = com.zopim.android.sdk.prechat.PreChatForm.Field.REQUIRED_EDITABLE     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$prechat$PreChatForm$Field     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.zopim.android.sdk.prechat.PreChatForm$Field r1 = com.zopim.android.sdk.prechat.PreChatForm.Field.REQUIRED     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$prechat$PreChatForm$Field     // Catch:{ NoSuchFieldError -> 0x0063 }
                com.zopim.android.sdk.prechat.PreChatForm$Field r1 = com.zopim.android.sdk.prechat.PreChatForm.Field.NOT_REQUIRED     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.prechat.ZopimPreChatFragment.AnonymousClass5.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void close() {
        FragmentTransaction q11 = getFragmentManager().q();
        q11.s(this);
        q11.j();
    }

    private HintSpinnerAdapter getDepartmentHintSpinnerAdapter(List<String> list) {
        FragmentActivity activity = getActivity();
        int i11 = R.layout.spinner_list_item;
        ArrayAdapter arrayAdapter = new ArrayAdapter(activity, i11, list);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        return new HintSpinnerAdapter(arrayAdapter, i11, getActivity()) {
            public View getHintView(ViewGroup viewGroup) {
                View inflate = this.layoutInflater.inflate(R.layout.spinner_list_item, viewGroup, false);
                if (inflate instanceof TextView) {
                    String string = ZopimPreChatFragment.this.getResources().getString(R.string.pre_chat_departments_hint);
                    if (PreChatForm.Field.REQUIRED.equals(ZopimPreChatFragment.this.preChatForm.getDepartment()) || PreChatForm.Field.REQUIRED_EDITABLE.equals(ZopimPreChatFragment.this.preChatForm.getDepartment())) {
                        string = String.format(ZopimPreChatFragment.this.getResources().getString(R.string.required_field_template), new Object[]{string});
                    }
                    ((TextView) inflate).setText(string);
                }
                return inflate;
            }
        };
    }

    private void initialiseDepartmentSpinner(Spinner spinner, Department department) {
        int i11 = AnonymousClass5.$SwitchMap$com$zopim$android$sdk$prechat$PreChatForm$Field[this.preChatForm.getDepartment().ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                int i12 = AnonymousClass5.$SwitchMap$com$zopim$android$sdk$model$Department$Status[department.getStatus().ordinal()];
                if (i12 == 1 || i12 == 2) {
                    spinner.setVisibility(8);
                } else if (i12 == 3) {
                    showAccountOfflineDialog();
                }
            } else if (i11 != 3) {
                if (i11 == 4) {
                    int i13 = AnonymousClass5.$SwitchMap$com$zopim$android$sdk$model$Department$Status[department.getStatus().ordinal()];
                    if (i13 == 1 || i13 == 2) {
                        spinner.setVisibility(8);
                    } else if (i13 == 3) {
                        showAccountOfflineDialog();
                    }
                } else if (i11 == 5) {
                    spinner.setVisibility(8);
                }
            } else if (AnonymousClass5.$SwitchMap$com$zopim$android$sdk$model$Department$Status[department.getStatus().ordinal()] == 1) {
                setSpinnerLabel(spinner, department.getName());
            }
        } else if (AnonymousClass5.$SwitchMap$com$zopim$android$sdk$model$Department$Status[department.getStatus().ordinal()] == 1) {
            setSpinnerLabel(spinner, department.getName());
        }
    }

    public static ZopimPreChatFragment newInstance(PreChatForm preChatForm2) {
        if (preChatForm2 == null) {
            Logger.d(LOG_TAG, "Pre chat form must not be null. Will use default pre chat form.", new Object[0]);
            return new ZopimPreChatFragment();
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_PRE_CHAT_CONFIG, preChatForm2);
        ZopimPreChatFragment zopimPreChatFragment = new ZopimPreChatFragment();
        zopimPreChatFragment.setArguments(bundle);
        return zopimPreChatFragment;
    }

    private void setSpinnerLabel(Spinner spinner, String str) {
        for (int i11 = 1; i11 < spinner.getCount(); i11++) {
            if ((spinner.getItemAtPosition(i11) != null ? spinner.getItemAtPosition(i11).toString() : "").equals(str)) {
                spinner.setSelection(i11);
                return;
            }
        }
        Logger.l(LOG_TAG, "Failed to pre-select department (%s) to the departments spinner", str);
    }

    private void setupDepartmentSpinner(Spinner spinner) {
        Collection<Department> values = ZopimChatApi.getDataSource().getDepartments().values();
        if (a.g(values)) {
            spinner.setVisibility(8);
            Logger.g(LOG_TAG, "No departments defined under the account.", new Object[0]);
            return;
        }
        List<String> findAvailableDepartments = DepartmentUtil.findAvailableDepartments(values);
        if (a.g(findAvailableDepartments)) {
            spinner.setVisibility(8);
            Logger.g(LOG_TAG, "No online departments available for selection.", new Object[0]);
            return;
        }
        spinner.setAdapter(getDepartmentHintSpinnerAdapter(findAvailableDepartments));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SensorsDataInstrumented
            public void onItemSelected(AdapterView<?> adapterView, View view, int i11, long j11) {
                if (i11 != 0 && (view instanceof TextView)) {
                    l.s((TextView) view, R.style.pre_chat_form_selected_item);
                }
                SensorsDataAutoTrackHelper.trackListView(adapterView, view, i11);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        initialiseDepartmentSpinner(spinner, DepartmentUtil.findDepartment(values, this.chat.getConfig().getDepartment()));
    }

    private void setupTextInputField(PreChatForm.Field field, TextInputLayout textInputLayout, String str) {
        int i11 = AnonymousClass5.$SwitchMap$com$zopim$android$sdk$prechat$PreChatForm$Field[field.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 == 3) {
                    if (!f.e(str)) {
                        textInputLayout.getEditText().setText(str);
                    }
                    textInputLayout.setHint((CharSequence) String.format(getResources().getString(R.string.required_field_template), new Object[]{textInputLayout.getHint()}));
                } else if (i11 == 4) {
                    if (!f.e(str)) {
                        textInputLayout.setVisibility(8);
                    }
                    textInputLayout.setHint((CharSequence) String.format(getResources().getString(R.string.required_field_template), new Object[]{textInputLayout.getHint()}));
                } else if (i11 != 5) {
                    Logger.l(LOG_TAG, "Unknown pre chat form config type.", new Object[0]);
                } else {
                    textInputLayout.setVisibility(8);
                }
            } else if (!f.e(str)) {
                textInputLayout.setVisibility(8);
            }
        } else if (!f.e(str)) {
            textInputLayout.getEditText().setText(str);
        }
    }

    private void showAccountOfflineDialog() {
        this.accountOfflineDialog = new AlertDialog.Builder(getActivity()).setMessage(R.string.pre_chat_account_offline_dialog_message).setPositiveButton(R.string.pre_chat_account_offline_dialog_confirm_button, new DialogInterface.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(DialogInterface dialogInterface, int i11) {
                ZopimPreChatFragment.this.showOfflineMessageFragment(ZopimPreChatFragment.this.nameInput.getEditText().getText().toString().trim(), ZopimPreChatFragment.this.emailInput.getEditText().getText().toString().trim(), ZopimPreChatFragment.this.messageInput.getEditText().getText().toString().trim());
                SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
            }
        }).setNegativeButton(R.string.pre_chat_account_offline_dialog_cancel_button, new DialogInterface.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(DialogInterface dialogInterface, int i11) {
                dialogInterface.dismiss();
                ZopimPreChatFragment.this.close();
                ZopimPreChatFragment.this.chat.endChat();
                if (ZopimPreChatFragment.this.chatListener != null) {
                    ZopimPreChatFragment.this.chatListener.onChatEnded();
                }
                SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
            }
        }).show();
    }

    /* access modifiers changed from: private */
    public void showOfflineMessageFragment(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        if (f.c(str)) {
            bundle.putString(Contract.EXTRA_NAME, str);
        }
        if (f.c(str2)) {
            bundle.putString(Contract.EXTRA_EMAIL, str2);
        }
        if (f.c(str3)) {
            bundle.putString(Contract.EXTRA_MESSAGE, str3);
        }
        ZopimOfflineFragment zopimOfflineFragment = new ZopimOfflineFragment();
        zopimOfflineFragment.setArguments(bundle);
        FragmentTransaction q11 = getFragmentManager().q();
        q11.u(R.id.chat_fragment_container, zopimOfflineFragment, ZopimOfflineFragment.class.getName());
        q11.s(this);
        q11.j();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ChatListener) {
            this.chatListener = (ChatListener) activity;
        }
    }

    public void onConnected() {
        MenuItem findItem;
        Menu menu2 = this.menu;
        if (menu2 != null && (findItem = menu2.findItem(R.id.start_chat)) != null && !findItem.isEnabled()) {
            findItem.setEnabled(true);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        this.chat = ZopimChat.resume(getActivity());
        if (getArguments() != null) {
            Serializable serializable = getArguments().getSerializable(EXTRA_PRE_CHAT_CONFIG);
            if (serializable instanceof PreChatForm) {
                this.preChatForm = (PreChatForm) serializable;
            }
        }
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
        menuInflater.inflate(R.menu.pre_chat_menu, menu2);
        menu2.findItem(R.id.start_chat).setEnabled(this.stateMenuItemEnabled);
        this.menu = menu2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.zopim_pre_chat_fragment, viewGroup, false);
    }

    public void onDisconnected() {
        MenuItem findItem;
        Menu menu2 = this.menu;
        if (menu2 != null && (findItem = menu2.findItem(R.id.start_chat)) != null && findItem.isEnabled()) {
            findItem.setEnabled(false);
        }
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean z11;
        if (16908332 == menuItem.getItemId()) {
            close();
        }
        if (R.id.start_chat == menuItem.getItemId()) {
            Account data = LivechatAccountPath.getInstance().getData();
            if (data == null || !Account.Status.OFFLINE.equals(data.getStatus())) {
                if (this.departmentSpinner.getVisibility() != 0 || ((!PreChatForm.Field.REQUIRED.equals(this.preChatForm.getDepartment()) && !PreChatForm.Field.REQUIRED_EDITABLE.equals(this.preChatForm.getDepartment())) || this.departmentSpinner.getSelectedItemPosition() != 0)) {
                    z11 = true;
                } else {
                    TextView textView = (TextView) this.departmentSpinner.getSelectedView();
                    textView.setError(getResources().getText(R.string.pre_chat_departments_error_message));
                    textView.setText(R.string.pre_chat_departments_error_hint);
                    z11 = false;
                }
                if (this.emailInput.getVisibility() == 0) {
                    String trim = this.emailInput.getEditText().getText().toString().trim();
                    int i11 = AnonymousClass5.$SwitchMap$com$zopim$android$sdk$prechat$PreChatForm$Field[this.preChatForm.getEmail().ordinal()];
                    if (i11 == 1 || i11 == 2) {
                        if (trim.isEmpty() || Patterns.EMAIL_ADDRESS.matcher(trim).matches()) {
                            this.emailInput.setError((CharSequence) null);
                        } else {
                            this.emailInput.setError(getResources().getString(R.string.pre_chat_email_validation_message));
                        }
                    } else if (i11 == 3 || i11 == 4) {
                        if (Patterns.EMAIL_ADDRESS.matcher(trim).matches()) {
                            this.emailInput.setError((CharSequence) null);
                        } else if (trim.isEmpty()) {
                            this.emailInput.setError(getResources().getString(R.string.pre_chat_email_error_message));
                        } else {
                            this.emailInput.setError(getResources().getString(R.string.pre_chat_email_validation_message));
                        }
                    }
                    z11 = false;
                }
                if (this.nameInput.getVisibility() == 0 && (PreChatForm.Field.REQUIRED.equals(this.preChatForm.getName()) || PreChatForm.Field.REQUIRED_EDITABLE.equals(this.preChatForm.getName()))) {
                    if (this.nameInput.getEditText().getText().toString().trim().isEmpty()) {
                        this.nameInput.setError(getResources().getString(R.string.pre_chat_name_error_message));
                        z11 = false;
                    } else {
                        this.nameInput.setError((CharSequence) null);
                    }
                }
                if (this.phoneInput.getVisibility() == 0) {
                    String trim2 = this.phoneInput.getEditText().getText().toString().trim();
                    int i12 = AnonymousClass5.$SwitchMap$com$zopim$android$sdk$prechat$PreChatForm$Field[this.preChatForm.getPhoneNumber().ordinal()];
                    if (i12 == 1 || i12 == 2) {
                        if (trim2.isEmpty() || Patterns.PHONE.matcher(trim2).matches()) {
                            this.phoneInput.setError((CharSequence) null);
                        } else {
                            this.phoneInput.setError(getResources().getString(R.string.pre_chat_phone_validation_message));
                        }
                    } else if (i12 == 3 || i12 == 4) {
                        if (Patterns.PHONE.matcher(trim2).matches()) {
                            this.phoneInput.setError((CharSequence) null);
                        } else if (trim2.isEmpty()) {
                            this.phoneInput.setError(getResources().getString(R.string.pre_chat_phone_error_message));
                        } else {
                            this.phoneInput.setError(getResources().getString(R.string.pre_chat_phone_validation_message));
                        }
                    }
                    z11 = false;
                }
                if (this.messageInput.getVisibility() == 0 && (PreChatForm.Field.REQUIRED.equals(this.preChatForm.getMessage()) || PreChatForm.Field.REQUIRED_EDITABLE.equals(this.preChatForm.getMessage()))) {
                    if (this.messageInput.getEditText().getText().toString().trim().isEmpty()) {
                        this.messageInput.setError(getResources().getString(R.string.pre_chat_message_error_message));
                        z11 = false;
                    } else {
                        this.messageInput.setError((CharSequence) null);
                    }
                }
                if (z11) {
                    String trim3 = this.nameInput.getEditText().getText().toString().trim();
                    String trim4 = this.emailInput.getEditText().getText().toString().trim();
                    String trim5 = this.phoneInput.getEditText().getText().toString().trim();
                    String str = (String) this.departmentSpinner.getSelectedItem();
                    String trim6 = this.messageInput.getEditText().getText().toString().trim();
                    if (!trim3.isEmpty()) {
                        this.chat.setName(trim3);
                    }
                    if (!trim4.isEmpty()) {
                        this.chat.setEmail(trim4);
                    }
                    if (!trim5.isEmpty()) {
                        this.chat.setPhoneNumber(trim5);
                    }
                    if (str != null && !str.isEmpty()) {
                        Iterator it2 = LivechatDepartmentsPath.getInstance().getData().values().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Department department = (Department) it2.next();
                            if (department != null && str.equals(department.getName())) {
                                if (Department.Status.ONLINE.equals(department.getStatus())) {
                                    this.chat.setDepartment(str);
                                }
                            }
                        }
                    }
                    if (!trim6.isEmpty()) {
                        this.chat.send(trim6);
                    } else {
                        this.chat.send(" ");
                    }
                    ZopimChatLogFragment zopimChatLogFragment = new ZopimChatLogFragment();
                    FragmentTransaction q11 = getFragmentManager().q();
                    q11.u(R.id.chat_fragment_container, zopimChatLogFragment, ZopimChatLogFragment.class.getName());
                    q11.s(this);
                    q11.j();
                } else {
                    SnackbarAdapter.make(getView(), R.string.pre_chat_validation_error_message, 0).show();
                }
                SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
                return true;
            }
            showAccountOfflineDialog();
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return onOptionsItemSelected;
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        if (getActivity().isFinishing()) {
            Logger.g(LOG_TAG, "Chat aborted. Ending chat.", new Object[0]);
            this.chat.endChat();
            ChatListener chatListener2 = this.chatListener;
            if (chatListener2 != null) {
                chatListener2.onChatEnded();
            }
        }
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("MENU_ITEM_ENABLED", this.menu.findItem(R.id.start_chat).isEnabled());
        AlertDialog alertDialog = this.accountOfflineDialog;
        bundle.putBoolean(STATE_SHOW_ACCOUNT_OFFLINE_DIALOG, alertDialog != null ? alertDialog.isShowing() : false);
    }

    public void onStop() {
        super.onStop();
        this.handler.removeCallbacksAndMessages((Object) null);
        AlertDialog alertDialog = this.accountOfflineDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.accountOfflineDialog.dismiss();
        }
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        VisitorInfo visitorInfo = this.chat.getConfig().getVisitorInfo();
        this.departmentSpinner = (Spinner) view.findViewById(R.id.departments);
        this.nameInput = (TextInputLayout) view.findViewById(R.id.name);
        this.emailInput = (TextInputLayout) view.findViewById(R.id.email);
        this.phoneInput = (TextInputLayout) view.findViewById(R.id.phone);
        this.messageInput = (TextInputLayout) view.findViewById(R.id.message);
        setupTextInputField(this.preChatForm.getName(), this.nameInput, visitorInfo.getName());
        setupTextInputField(this.preChatForm.getEmail(), this.emailInput, visitorInfo.getEmail());
        setupTextInputField(this.preChatForm.getPhoneNumber(), this.phoneInput, visitorInfo.getPhoneNumber());
        setupTextInputField(this.preChatForm.getMessage(), this.messageInput, (String) null);
        setupDepartmentSpinner(this.departmentSpinner);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            this.stateMenuItemEnabled = bundle.getBoolean("MENU_ITEM_ENABLED", true);
            if (bundle.getBoolean(STATE_SHOW_ACCOUNT_OFFLINE_DIALOG, false)) {
                showAccountOfflineDialog();
            }
        }
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }
}
