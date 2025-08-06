package net.sf.scuba.smartcards;

public abstract class AbstractFileSystemStructured implements FileSystemStructured {
    public static final short MF_ID = 16128;
    private ISOFileInfo fileInfo;
    private int length;

    /* renamed from: p2  reason: collision with root package name */
    private int f58527p2;
    private int selectLe;
    private short selectedFID;
    private CardService service;

    public AbstractFileSystemStructured(CardService cardService) {
        this.service = null;
        this.selectedFID = 0;
        this.length = -1;
        this.f58527p2 = 0;
        this.selectLe = 256;
        this.fileInfo = null;
        this.service = cardService;
    }

    private CommandAPDU createSelectFileAPDU(int i11, int i12, byte[] bArr, int i13) {
        if (i13 == 0) {
            return new CommandAPDU(0, -92, i11, i12, bArr);
        }
        return new CommandAPDU(0, -92, i11, i12, bArr, i13);
    }

    private void selectFile(byte[] bArr, int i11) throws CardServiceException {
        ResponseAPDU transmit = this.service.transmit(createSelectFileAPDU(i11, this.f58527p2, bArr, this.selectLe));
        int sw2 = transmit.getSW();
        byte[] data = transmit.getData();
        if (sw2 == -28672) {
            ISOFileInfo iSOFileInfo = new ISOFileInfo(data);
            this.fileInfo = iSOFileInfo;
            short s11 = iSOFileInfo.fid;
            if (s11 != -1) {
                this.selectedFID = s11;
            }
            int i12 = iSOFileInfo.fileLength;
            if (i12 != -1) {
                this.length = i12;
                return;
            }
            return;
        }
        throw new CardServiceException("File could not be selected.", sw2);
    }

    public int getFileLength() throws CardServiceException {
        return this.length;
    }

    public short getSelectedFID() {
        return this.selectedFID;
    }

    public abstract byte[] readBinary(int i11, int i12);

    public void selectAID(byte[] bArr) throws CardServiceException {
        selectFile(bArr, 4);
    }

    public void selectDFRelative(short s11) throws CardServiceException {
        selectFile(s11, 1);
    }

    public void selectEFRelative(short s11) throws CardServiceException {
        selectFile(s11, 2);
    }

    public void selectMF() throws CardServiceException {
        selectFile(0, 0);
    }

    public void selectParent() throws CardServiceException {
        selectFile(0, 3);
    }

    public void selectPath(byte[] bArr) throws CardServiceException {
        selectFile(bArr, 8);
    }

    public void selectPathRelative(byte[] bArr) throws CardServiceException {
        selectFile(bArr, 9);
    }

    public AbstractFileSystemStructured(CardService cardService, boolean z11) {
        this.service = null;
        int i11 = 0;
        this.selectedFID = 0;
        this.length = -1;
        this.f58527p2 = 0;
        this.selectLe = 256;
        this.fileInfo = null;
        this.service = cardService;
        this.f58527p2 = z11 ? 0 : 12;
        this.selectLe = z11 ? 256 : i11;
    }

    private void selectFile(short s11, int i11) throws CardServiceException {
        byte[] bArr;
        if (s11 == 0) {
            bArr = new byte[0];
        } else {
            bArr = new byte[]{(byte) ((s11 >> 8) & 255), (byte) (s11 & 255)};
        }
        selectFile(bArr, i11);
    }

    public void selectFile(short s11) throws CardServiceException {
        selectFile(s11, 0);
    }
}
