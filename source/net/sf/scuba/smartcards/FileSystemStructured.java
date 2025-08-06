package net.sf.scuba.smartcards;

public interface FileSystemStructured {
    FileInfo[] getSelectedPath() throws CardServiceException;

    byte[] readBinary(int i11, int i12) throws CardServiceException;

    void selectFile(short s11) throws CardServiceException;
}
