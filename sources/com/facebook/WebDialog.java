package com.facebook;

public class WebDialog {
    private WebDialog() {
    }

    public static int getWebDialogTheme() {
        return com.facebook.internal.WebDialog.getWebDialogTheme();
    }

    public static void setWebDialogTheme(int i11) {
        com.facebook.internal.WebDialog.setWebDialogTheme(i11);
    }
}
