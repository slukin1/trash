package zendesk.support.request;

import android.content.Intent;
import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import androidx.core.util.d;
import com.google.android.material.textfield.TextInputLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zendesk.sdk.R$id;
import com.zendesk.sdk.R$integer;
import com.zendesk.sdk.R$string;
import java.util.List;
import mz.a;
import mz.f;
import zendesk.belvedere.KeyboardHelper;
import zendesk.support.request.RequestViewConversationsDisabled;
import zendesk.support.suas.Dispatcher;
import zendesk.support.suas.Listener;
import zendesk.support.suas.State;
import zendesk.support.suas.StateSelector;

class ComponentInputForm implements Listener<InputFormModel>, RequestViewConversationsDisabled.MenuItemsDelegate, KeyboardHelper.c {
    private final ActionFactory actionFactory;
    private final AttachmentHelper attachmentHelper;
    private final Dispatcher dispatcher;
    private final EditText emailField;
    private final TextInputLayout emailLayout;
    private final Validator<String> emailValidator;
    /* access modifiers changed from: private */
    public boolean inlineValidation = false;
    /* access modifiers changed from: private */
    public final View logo;
    private final EditText messageField;
    private final TextInputLayout messageLayout;
    private final EditText nameField;
    private final TextInputLayout nameLayout;
    private MenuItem sendButton;

    public static class EditTextTextWatcher implements TextWatcher {
        private final ComponentInputForm componentInputForm;

        private EditTextTextWatcher(ComponentInputForm componentInputForm2) {
            this.componentInputForm = componentInputForm2;
        }

        public static void install(ComponentInputForm componentInputForm2, EditText... editTextArr) {
            for (EditText addTextChangedListener : editTextArr) {
                addTextChangedListener.addTextChangedListener(new EditTextTextWatcher(componentInputForm2));
            }
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            if (this.componentInputForm.inlineValidation) {
                this.componentInputForm.updateEmailValidation();
            }
            this.componentInputForm.updateSendButton();
        }
    }

    public static class EmailFieldFocusListener implements View.OnFocusChangeListener {
        private final ComponentInputForm componentInputForm;
        private final EditText editText;

        private EmailFieldFocusListener(ComponentInputForm componentInputForm2, EditText editText2) {
            this.componentInputForm = componentInputForm2;
            this.editText = editText2;
        }

        public static void install(ComponentInputForm componentInputForm2, EditText editText2) {
            editText2.setOnFocusChangeListener(new EmailFieldFocusListener(componentInputForm2, editText2));
        }

        public void onFocusChange(View view, boolean z11) {
            if (!z11 && f.c(this.editText.getText().toString())) {
                this.componentInputForm.updateEmailValidation();
                this.componentInputForm.updateSendButton();
            }
        }
    }

    public static class InputFormModel {
        private final boolean hasIdentityEmailAddress;
        private final boolean hasIdentityName;
        private final boolean isLoading;
        private final boolean neverRequestEmail;
        private final String referrerUrl;
        private final boolean showZendeskLogo;

        public InputFormModel(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, String str) {
            this.neverRequestEmail = z11;
            this.hasIdentityEmailAddress = z12;
            this.hasIdentityName = z13;
            this.isLoading = z14;
            this.showZendeskLogo = z15;
            this.referrerUrl = str;
        }

        private boolean isEmailFieldEnabled() {
            return !this.hasIdentityEmailAddress && !this.neverRequestEmail;
        }

        private boolean isNameFieldEnabled() {
            return !this.hasIdentityName;
        }

        public int getEmailFieldVisibility() {
            return isEmailFieldEnabled() ? 0 : 8;
        }

        public int getLogoVisibility() {
            return isLogoEnabled() ? 0 : 8;
        }

        public int getMessageFieldVisibility() {
            return 0;
        }

        public int getNameFieldVisibility() {
            return isNameFieldEnabled() ? 0 : 8;
        }

        public String getReferrerUrl() {
            return this.referrerUrl;
        }

        public boolean isLoading() {
            return this.isLoading;
        }

        public boolean isLogoEnabled() {
            return this.showZendeskLogo;
        }
    }

    public static class InputFormSelector implements StateSelector<InputFormModel> {
        public InputFormModel selectData(State state) {
            StateSettings settings = StateConfig.fromState(state).getSettings();
            return new InputFormModel(settings.isNeverRequestEmailOn(), settings.hasIdentityEmailAddress(), settings.hasIdentityName(), StateProgress.fomState(state).getRunningRequests() > 0, settings.isShowZendeskLogo(), settings.getReferrerUrl());
        }
    }

    public interface Validator<T> {
        boolean isValid(T t11);
    }

    public ComponentInputForm(View view, EditText editText, TextInputLayout textInputLayout, EditText editText2, TextInputLayout textInputLayout2, Validator<String> validator, EditText editText3, TextInputLayout textInputLayout3, Dispatcher dispatcher2, ActionFactory actionFactory2, AttachmentHelper attachmentHelper2) {
        this.logo = view;
        this.nameField = editText;
        this.emailField = editText2;
        this.messageField = editText3;
        this.nameLayout = textInputLayout;
        this.emailLayout = textInputLayout2;
        this.messageLayout = textInputLayout3;
        this.emailValidator = validator;
        this.dispatcher = dispatcher2;
        this.actionFactory = actionFactory2;
        this.attachmentHelper = attachmentHelper2;
        EditTextTextWatcher.install(this, editText, editText2, editText3);
        EmailFieldFocusListener.install(this, editText2);
    }

    public static ComponentInputForm create(View view, Dispatcher dispatcher2, ActionFactory actionFactory2, AttachmentHelper attachmentHelper2) {
        AnonymousClass1 r62 = new Validator<String>() {
            public boolean isValid(String str) {
                return d.f8479j.matcher(str).matches();
            }
        };
        EditText editText = (EditText) view.findViewById(R$id.request_name_field);
        EditText editText2 = (EditText) view.findViewById(R$id.request_email_field);
        EditText editText3 = (EditText) view.findViewById(R$id.request_message_field);
        return new ComponentInputForm(view.findViewById(R$id.request_zendesk_logo), editText, (TextInputLayout) view.findViewById(R$id.request_name_layout), editText2, (TextInputLayout) view.findViewById(R$id.request_email_layout), r62, editText3, (TextInputLayout) view.findViewById(R$id.request_message_layout), dispatcher2, actionFactory2, attachmentHelper2);
    }

    private boolean doFieldsContainText() {
        String obj = this.nameField.getText().toString();
        String obj2 = this.emailField.getText().toString();
        String obj3 = this.messageField.getText().toString();
        boolean z11 = !isNameFieldVisible() || f.c(obj);
        boolean z12 = !isEmailFieldVisible() || f.c(obj2);
        boolean c11 = f.c(obj3);
        if (!z11 || !z12 || !c11) {
            return false;
        }
        return true;
    }

    private boolean isEmailFieldVisible() {
        return this.emailLayout.getVisibility() == 0;
    }

    private boolean isEmailInputValid() {
        return !isEmailFieldVisible() || this.emailValidator.isValid(this.emailField.getText().toString());
    }

    private boolean isNameFieldVisible() {
        return this.nameLayout.getVisibility() == 0;
    }

    private void setSendButtonEnabled(boolean z11) {
        if (this.sendButton != null) {
            int i11 = 255;
            if (!z11) {
                i11 = (this.messageLayout.getContext().getResources().getInteger(R$integer.zs_request_menu_send_btn_alpha_inactive) * 255) / 100;
            }
            this.sendButton.getIcon().setAlpha(i11);
            this.sendButton.setEnabled(z11);
        }
    }

    /* access modifiers changed from: private */
    public void updateEmailValidation() {
        if (isEmailInputValid()) {
            this.emailLayout.setError((CharSequence) null);
            return;
        }
        this.inlineValidation = true;
        this.emailLayout.setError(this.emailField.getContext().getString(R$string.error_msg_invalid_email));
    }

    /* access modifiers changed from: private */
    public void updateSendButton() {
        boolean z11;
        if (this.inlineValidation) {
            z11 = doFieldsContainText() && isEmailInputValid();
        } else {
            z11 = doFieldsContainText();
        }
        setSendButtonEnabled(z11);
    }

    public StateSelector<InputFormModel> getSelector() {
        return new InputFormSelector();
    }

    public boolean hasUnsavedInput() {
        String obj = this.nameField.getText().toString();
        String obj2 = this.emailField.getText().toString();
        String obj3 = this.messageField.getText().toString();
        if (this.nameField.isEnabled() && f.c(obj)) {
            return true;
        }
        if ((!this.emailField.isEnabled() || !f.c(obj2)) && !f.c(obj3) && !a.i(this.attachmentHelper.getSelectedAttachments())) {
            return false;
        }
        return true;
    }

    public void onKeyboardDismissed() {
        if (this.logo.getVisibility() != 8) {
            this.logo.post(new Runnable() {
                public void run() {
                    ComponentInputForm.this.logo.setVisibility(0);
                }
            });
        }
    }

    public void onKeyboardVisible() {
        if (this.logo.getVisibility() != 8) {
            this.logo.setVisibility(4);
        }
    }

    public void onMenuItemsClicked(MenuItem menuItem) {
        if (menuItem.getItemId() == R$id.request_conversations_disabled_menu_ic_send) {
            onSendMessageRequested();
        }
    }

    public void onMenuItemsInflated(MenuItem menuItem, MenuItem menuItem2) {
        this.sendButton = menuItem;
        updateSendButton();
    }

    public void onSendMessageRequested() {
        if (!doFieldsContainText() || !isEmailInputValid()) {
            updateEmailValidation();
            updateSendButton();
            return;
        }
        if (isNameFieldVisible() || isEmailFieldVisible()) {
            this.dispatcher.dispatch(this.actionFactory.updateNameEmailAsync(this.nameField.getText().toString(), this.emailField.getText().toString()));
        }
        String obj = this.messageField.getText().toString();
        List<TypeT> e11 = a.e(this.attachmentHelper.getSelectedAttachments());
        this.dispatcher.dispatch(this.actionFactory.clearMessages());
        this.dispatcher.dispatch(this.actionFactory.createCommentAsync(obj, e11));
    }

    public void update(final InputFormModel inputFormModel) {
        this.logo.setVisibility(inputFormModel.getLogoVisibility());
        this.nameLayout.setVisibility(inputFormModel.getNameFieldVisibility());
        this.emailLayout.setVisibility(inputFormModel.getEmailFieldVisibility());
        this.messageLayout.setVisibility(inputFormModel.getMessageFieldVisibility());
        this.nameLayout.setEnabled(!inputFormModel.isLoading());
        this.emailLayout.setEnabled(!inputFormModel.isLoading());
        this.messageLayout.setEnabled(!inputFormModel.isLoading());
        if (inputFormModel.isLoading()) {
            setSendButtonEnabled(false);
            return;
        }
        AnonymousClass2 r02 = null;
        if (inputFormModel.isLogoEnabled() && f.c(inputFormModel.getReferrerUrl())) {
            r02 = new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(inputFormModel.getReferrerUrl())));
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            };
        }
        this.logo.setOnClickListener(r02);
        updateSendButton();
    }
}
