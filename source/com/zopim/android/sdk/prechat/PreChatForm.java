package com.zopim.android.sdk.prechat;

import java.io.Serializable;

public class PreChatForm implements Serializable {
    private static final long serialVersionUID = 9006657233172922772L;
    private final Field department;
    private final Field email;
    private final Field message;
    private final Field name;
    private final Field phoneNumber;

    public static class Builder {
        /* access modifiers changed from: private */
        public Field department;
        /* access modifiers changed from: private */
        public Field email;
        /* access modifiers changed from: private */
        public Field message;
        /* access modifiers changed from: private */
        public Field name;
        /* access modifiers changed from: private */
        public Field phoneNumber;

        public Builder() {
            Field field = Field.NOT_REQUIRED;
            this.name = field;
            this.email = field;
            this.phoneNumber = field;
            this.department = field;
            this.message = field;
        }

        public PreChatForm build() {
            return new PreChatForm(this);
        }

        public Builder department(Field field) {
            this.department = field;
            return this;
        }

        public Builder email(Field field) {
            this.email = field;
            return this;
        }

        public Builder message(Field field) {
            this.message = field;
            return this;
        }

        public Builder name(Field field) {
            this.name = field;
            return this;
        }

        public Builder phoneNumber(Field field) {
            this.phoneNumber = field;
            return this;
        }
    }

    public enum Field {
        NOT_REQUIRED,
        OPTIONAL,
        REQUIRED,
        OPTIONAL_EDITABLE,
        REQUIRED_EDITABLE
    }

    public Field getDepartment() {
        Field field = this.department;
        return field != null ? field : Field.NOT_REQUIRED;
    }

    public Field getEmail() {
        Field field = this.email;
        return field != null ? field : Field.NOT_REQUIRED;
    }

    public Field getMessage() {
        Field field = this.message;
        return field != null ? field : Field.NOT_REQUIRED;
    }

    public Field getName() {
        Field field = this.name;
        return field != null ? field : Field.NOT_REQUIRED;
    }

    public Field getPhoneNumber() {
        Field field = this.phoneNumber;
        return field != null ? field : Field.NOT_REQUIRED;
    }

    private PreChatForm() {
        throw new UnsupportedOperationException("This constructor is not supported, use parametrized constructor");
    }

    private PreChatForm(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.department = builder.department;
        this.message = builder.message;
    }
}
