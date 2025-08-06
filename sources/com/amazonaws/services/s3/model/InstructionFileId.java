package com.amazonaws.services.s3.model;

public final class InstructionFileId extends S3ObjectId {
    public static final String DEFAULT_INSTRUCTION_FILE_SUFFIX = "instruction";
    @Deprecated
    public static final String DEFAULT_INSTURCTION_FILE_SUFFIX = "instruction";
    public static final String DOT = ".";

    public InstructionFileId(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public InstructionFileId instructionFileId() {
        throw new UnsupportedOperationException();
    }

    public InstructionFileId instructionFileId(String str) {
        throw new UnsupportedOperationException();
    }
}
