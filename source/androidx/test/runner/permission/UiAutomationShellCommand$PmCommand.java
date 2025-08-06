package androidx.test.runner.permission;

enum UiAutomationShellCommand$PmCommand {
    GRANT_PERMISSION("grant");
    
    private final String pmCommand;

    private UiAutomationShellCommand$PmCommand(String str) {
        String valueOf = String.valueOf(str);
        this.pmCommand = valueOf.length() != 0 ? "pm ".concat(valueOf) : new String("pm ");
    }

    public String get() {
        return this.pmCommand;
    }
}
