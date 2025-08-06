package com.eclipsesource.v8.debug.mirror;

public class SourceLocation {
    private final int column;
    private final int line;
    private final int position;
    private final String scriptName;
    private String sourceText;

    public SourceLocation(String str, int i11, int i12, int i13, String str2) {
        this.scriptName = str;
        this.position = i11;
        this.line = i12;
        this.column = i13;
        this.sourceText = str2;
    }

    public int getColumn() {
        return this.column;
    }

    public int getLine() {
        return this.line;
    }

    public int getPosition() {
        return this.position;
    }

    public String getScriptName() {
        return this.scriptName;
    }

    public String getSourceText() {
        return this.sourceText;
    }

    public String toString() {
        return this.scriptName + " : " + this.position + " : " + this.line + " : " + this.column + " : " + this.sourceText;
    }
}
