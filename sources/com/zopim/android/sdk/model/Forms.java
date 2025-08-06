package com.zopim.android.sdk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forms {
    @SerializedName("offline_form")
    @Expose
    public OfflineForm offlineForm;

    public static class FormSubmitted {
    }

    public static class OfflineForm {
        @SerializedName("form_submitted")
        @Expose
        public FormSubmitted formSubmitted;

        public FormSubmitted getFormSubmitted() {
            return this.formSubmitted;
        }
    }

    public OfflineForm getOfflineForm() {
        return this.offlineForm;
    }
}
