package zendesk.classic.messaging;

import android.app.Dialog;
import android.text.Editable;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.z;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import zendesk.classic.messaging.components.DateProvider;
import zendesk.classic.messaging.d;

public class i implements z<DialogContent> {

    /* renamed from: b  reason: collision with root package name */
    public final AppCompatActivity f62489b;

    /* renamed from: c  reason: collision with root package name */
    public final l f62490c;

    /* renamed from: d  reason: collision with root package name */
    public final DateProvider f62491d;

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f62492b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DialogContent f62493c;

        public a(Dialog dialog, DialogContent dialogContent) {
            this.f62492b = dialog;
            this.f62493c = dialogContent;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f62492b.dismiss();
            i.this.f62490c.a(new d.f.a(i.this.f62491d.a(), this.f62493c.a(), false).a());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DialogContent f62495b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Dialog f62496c;

        public b(DialogContent dialogContent, Dialog dialog) {
            this.f62495b = dialogContent;
            this.f62496c = dialog;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            i.this.f62490c.a(new d.f.a(i.this.f62491d.a(), this.f62495b.a(), true).a());
            this.f62496c.dismiss();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextInputEditText f62498b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DialogContent f62499c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Dialog f62500d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f62501e;

        public c(TextInputEditText textInputEditText, DialogContent dialogContent, Dialog dialog, TextInputLayout textInputLayout) {
            this.f62498b = textInputEditText;
            this.f62499c = dialogContent;
            this.f62500d = dialog;
            this.f62501e = textInputLayout;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            Editable text = this.f62498b.getText();
            if (text == null || !Patterns.EMAIL_ADDRESS.matcher(text.toString()).matches()) {
                this.f62501e.setError(i.this.f62489b.getString(R$string.zui_dialog_email_error));
            } else {
                i.this.f62490c.a(new d.f.a(i.this.f62491d.a(), this.f62499c.a(), true).b(this.f62498b.getText().toString()).c(this.f62499c.d()).a());
                this.f62500d.dismiss();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f62503a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                zendesk.classic.messaging.DialogContent$Config[] r0 = zendesk.classic.messaging.DialogContent.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f62503a = r0
                zendesk.classic.messaging.DialogContent$Config r1 = zendesk.classic.messaging.DialogContent.Config.TRANSCRIPT_PROMPT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f62503a     // Catch:{ NoSuchFieldError -> 0x001d }
                zendesk.classic.messaging.DialogContent$Config r1 = zendesk.classic.messaging.DialogContent.Config.TRANSCRIPT_EMAIL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.classic.messaging.i.d.<clinit>():void");
        }
    }

    public i(AppCompatActivity appCompatActivity, l lVar, DateProvider dateProvider) {
        this.f62489b = appCompatActivity;
        this.f62490c = lVar;
        this.f62491d = dateProvider;
    }

    /* renamed from: d */
    public void onChanged(DialogContent dialogContent) {
        if (dialogContent != null) {
            Dialog dialog = new Dialog(this.f62489b);
            dialog.setContentView(R$layout.zui_messaging_dialog);
            Button button = (Button) dialog.findViewById(R$id.zui_dialog_positive_button);
            Button button2 = (Button) dialog.findViewById(R$id.zui_dialog_negative_button);
            TextInputEditText textInputEditText = (TextInputEditText) dialog.findViewById(R$id.zui_dialog_input);
            TextInputLayout textInputLayout = (TextInputLayout) dialog.findViewById(R$id.zui_dialog_input_layout);
            button2.setOnClickListener(new a(dialog, dialogContent));
            dialog.setTitle(dialogContent.c());
            ((TextView) dialog.findViewById(R$id.zui_dialog_message)).setText(dialogContent.b());
            ((TextView) dialog.findViewById(R$id.zui_dialog_title)).setText(dialogContent.c());
            button2.setText(R$string.zui_button_label_no);
            button.setText(R$string.zui_button_label_yes);
            int i11 = d.f62503a[dialogContent.a().ordinal()];
            if (i11 == 1) {
                button.setOnClickListener(new b(dialogContent, dialog));
            } else if (i11 == 2) {
                textInputLayout.setVisibility(0);
                button2.setText(17039360);
                button.setText(R$string.zui_label_send);
                textInputLayout.setHint((CharSequence) this.f62489b.getString(R$string.zui_dialog_email_hint));
                button.setOnClickListener(new c(textInputEditText, dialogContent, dialog, textInputLayout));
            }
            dialog.show();
        }
    }
}
