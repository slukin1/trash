package org.jmrtd;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import javax.crypto.SecretKey;
import net.sf.scuba.smartcards.APDUEvent;
import net.sf.scuba.smartcards.APDUListener;
import net.sf.scuba.smartcards.APDUWrapper;
import net.sf.scuba.smartcards.CardFileInputStream;
import net.sf.scuba.smartcards.CardService;
import net.sf.scuba.smartcards.CardServiceException;
import net.sf.scuba.smartcards.CommandAPDU;
import net.sf.scuba.smartcards.ISOFileInfo;
import net.sf.scuba.smartcards.ResponseAPDU;
import org.jmrtd.cert.CVCPrincipal;
import org.jmrtd.cert.CardVerifiableCertificate;
import org.jmrtd.protocol.AAAPDUSender;
import org.jmrtd.protocol.AAProtocol;
import org.jmrtd.protocol.AAResult;
import org.jmrtd.protocol.BACAPDUSender;
import org.jmrtd.protocol.BACProtocol;
import org.jmrtd.protocol.BACResult;
import org.jmrtd.protocol.EACCAAPDUSender;
import org.jmrtd.protocol.EACCAProtocol;
import org.jmrtd.protocol.EACCAResult;
import org.jmrtd.protocol.EACTAAPDUSender;
import org.jmrtd.protocol.EACTAProtocol;
import org.jmrtd.protocol.EACTAResult;
import org.jmrtd.protocol.PACEAPDUSender;
import org.jmrtd.protocol.PACEProtocol;
import org.jmrtd.protocol.PACEResult;
import org.jmrtd.protocol.ReadBinaryAPDUSender;
import org.jmrtd.protocol.SecureMessagingWrapper;

public class PassportService extends AbstractMRTDCardService {
    public static final byte[] APPLET_AID = {ISOFileInfo.A0, 0, 0, 2, 71, 16, 1};
    public static final byte CAN_PACE_KEY_REFERENCE = 2;
    public static final int DEFAULT_MAX_BLOCKSIZE = 223;
    public static final short EF_CARD_ACCESS = 284;
    public static final short EF_CARD_SECURITY = 285;
    public static final short EF_COM = 286;
    public static final short EF_CVCA = 284;
    public static final short EF_DG1 = 257;
    public static final short EF_DG10 = 266;
    public static final short EF_DG11 = 267;
    public static final short EF_DG12 = 268;
    public static final short EF_DG13 = 269;
    public static final short EF_DG14 = 270;
    public static final short EF_DG15 = 271;
    public static final short EF_DG16 = 272;
    public static final short EF_DG2 = 258;
    public static final short EF_DG3 = 259;
    public static final short EF_DG4 = 260;
    public static final short EF_DG5 = 261;
    public static final short EF_DG6 = 262;
    public static final short EF_DG7 = 263;
    public static final short EF_DG8 = 264;
    public static final short EF_DG9 = 265;
    public static final short EF_SOD = 285;
    public static final int EXTENDED_MAX_TRANCEIVE_LENGTH = 65536;
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    public static final byte MRZ_PACE_KEY_REFERENCE = 1;
    public static final int NORMAL_MAX_TRANCEIVE_LENGTH = 256;
    public static final byte NO_PACE_KEY_REFERENCE = 0;
    public static final byte PIN_PACE_KEY_REFERENCE = 3;
    public static final byte PUK_PACE_KEY_REFERENCE = 4;
    public static final byte SFI_CARD_ACCESS = 28;
    public static final byte SFI_CARD_SECURITY = 29;
    public static final byte SFI_COM = 30;
    public static final byte SFI_CVCA = 28;
    public static final byte SFI_DG1 = 1;
    public static final byte SFI_DG10 = 10;
    public static final byte SFI_DG11 = 11;
    public static final byte SFI_DG12 = 12;
    public static final byte SFI_DG13 = 13;
    public static final byte SFI_DG14 = 14;
    public static final byte SFI_DG15 = 15;
    public static final byte SFI_DG16 = 16;
    public static final byte SFI_DG2 = 2;
    public static final byte SFI_DG3 = 3;
    public static final byte SFI_DG4 = 4;
    public static final byte SFI_DG5 = 5;
    public static final byte SFI_DG6 = 6;
    public static final byte SFI_DG7 = 7;
    public static final byte SFI_DG8 = 8;
    public static final byte SFI_DG9 = 9;
    public static final byte SFI_SOD = 29;
    private AAAPDUSender aaSender;
    private DefaultFileSystem appletFileSystem;
    private BACAPDUSender bacSender;
    private EACCAAPDUSender eacCASender;
    private EACTAAPDUSender eacTASender;
    private boolean isAppletSelected;
    private boolean isOpen;
    private int maxBlockSize;
    private int maxTranceiveLengthForPACEProtocol;
    private int maxTranceiveLengthForSecureMessaging;
    private PACEAPDUSender paceSender;
    private ReadBinaryAPDUSender readBinarySender;
    private DefaultFileSystem rootFileSystem;
    private CardService service;
    private boolean shouldCheckMAC;
    private SecureMessagingWrapper wrapper;

    public PassportService(CardService cardService, int i11, int i12, boolean z11, boolean z12) {
        this(cardService, 256, i11, i12, z11, z12);
    }

    public void addAPDUListener(APDUListener aPDUListener) {
        this.service.addAPDUListener(aPDUListener);
    }

    public void close() {
        try {
            this.service.close();
            this.wrapper = null;
        } finally {
            this.isOpen = false;
        }
    }

    public AAResult doAA(PublicKey publicKey, String str, String str2, byte[] bArr) throws CardServiceException {
        return new AAProtocol(this.aaSender, getWrapper()).doAA(publicKey, str, str2, bArr);
    }

    public synchronized BACResult doBAC(AccessKeySpec accessKeySpec) throws CardServiceException {
        BACResult doBAC;
        if (accessKeySpec instanceof BACKeySpec) {
            doBAC = new BACProtocol(this.bacSender, this.maxTranceiveLengthForSecureMessaging, this.shouldCheckMAC).doBAC(accessKeySpec);
            SecureMessagingWrapper wrapper2 = doBAC.getWrapper();
            this.wrapper = wrapper2;
            this.appletFileSystem.setWrapper(wrapper2);
        } else {
            throw new IllegalArgumentException("Unsupported key type");
        }
        return doBAC;
    }

    public synchronized EACCAResult doEACCA(BigInteger bigInteger, String str, String str2, PublicKey publicKey) throws CardServiceException {
        EACCAResult doCA;
        doCA = new EACCAProtocol(this.eacCASender, getWrapper(), this.maxTranceiveLengthForSecureMessaging, this.shouldCheckMAC).doCA(bigInteger, str, str2, publicKey);
        SecureMessagingWrapper wrapper2 = doCA.getWrapper();
        this.wrapper = wrapper2;
        this.appletFileSystem.setWrapper(wrapper2);
        return doCA;
    }

    public synchronized EACTAResult doEACTA(CVCPrincipal cVCPrincipal, List<CardVerifiableCertificate> list, PrivateKey privateKey, String str, EACCAResult eACCAResult, String str2) throws CardServiceException {
        return new EACTAProtocol(this.eacTASender, getWrapper()).doEACTA(cVCPrincipal, list, privateKey, str, eACCAResult, str2);
    }

    public synchronized PACEResult doPACE(AccessKeySpec accessKeySpec, String str, AlgorithmParameterSpec algorithmParameterSpec, BigInteger bigInteger) throws CardServiceException {
        PACEResult doPACE;
        doPACE = new PACEProtocol(this.paceSender, this.wrapper, this.maxTranceiveLengthForPACEProtocol, this.maxTranceiveLengthForSecureMessaging, this.shouldCheckMAC).doPACE(accessKeySpec, str, algorithmParameterSpec, bigInteger);
        SecureMessagingWrapper wrapper2 = doPACE.getWrapper();
        this.wrapper = wrapper2;
        this.appletFileSystem.setWrapper(wrapper2);
        return doPACE;
    }

    public Collection<APDUListener> getAPDUListeners() {
        return this.service.getAPDUListeners();
    }

    public byte[] getATR() throws CardServiceException {
        return this.service.getATR();
    }

    @Deprecated
    public synchronized CardFileInputStream getInputStream(short s11) throws CardServiceException {
        return getInputStream(s11, this.maxBlockSize);
    }

    public int getMaxReadBinaryLength() {
        DefaultFileSystem defaultFileSystem = this.appletFileSystem;
        if (defaultFileSystem == null) {
            return 256;
        }
        return defaultFileSystem.getMaxReadBinaryLength();
    }

    public int getMaxTranceiveLength() {
        return this.maxTranceiveLengthForSecureMessaging;
    }

    public SecureMessagingWrapper getWrapper() {
        SecureMessagingWrapper secureMessagingWrapper = (SecureMessagingWrapper) this.appletFileSystem.getWrapper();
        if (secureMessagingWrapper != null && secureMessagingWrapper.getSendSequenceCounter() > this.wrapper.getSendSequenceCounter()) {
            this.wrapper = secureMessagingWrapper;
        }
        return this.wrapper;
    }

    public boolean isConnectionLost(Exception exc) {
        return this.service.isConnectionLost(exc);
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void notifyExchangedAPDU(APDUEvent aPDUEvent) {
        Collection<APDUListener> aPDUListeners = getAPDUListeners();
        if (aPDUListeners != null && !aPDUListeners.isEmpty()) {
            for (APDUListener exchangedAPDU : aPDUListeners) {
                exchangedAPDU.exchangedAPDU(aPDUEvent);
            }
        }
    }

    public void open() throws CardServiceException {
        if (!isOpen()) {
            synchronized (this) {
                this.service.open();
                this.isOpen = true;
            }
        }
    }

    public void removeAPDUListener(APDUListener aPDUListener) {
        this.service.removeAPDUListener(aPDUListener);
    }

    public void sendSelectApplet(boolean z11) throws CardServiceException {
        if (this.isAppletSelected) {
            LOGGER.info("Re-selecting ICAO applet");
        }
        if (z11) {
            this.readBinarySender.sendSelectApplet(this.wrapper, APPLET_AID);
        } else {
            this.readBinarySender.sendSelectApplet((APDUWrapper) null, APPLET_AID);
        }
        this.isAppletSelected = true;
    }

    public void sendSelectMF() throws CardServiceException {
        this.readBinarySender.sendSelectMF();
        this.wrapper = null;
    }

    public boolean shouldCheckMAC() {
        return this.shouldCheckMAC;
    }

    public ResponseAPDU transmit(CommandAPDU commandAPDU) throws CardServiceException {
        return this.service.transmit(commandAPDU);
    }

    public PassportService(CardService cardService, int i11, int i12, int i13, boolean z11, boolean z12) {
        this.service = cardService;
        this.bacSender = new BACAPDUSender(cardService);
        this.paceSender = new PACEAPDUSender(cardService);
        this.aaSender = new AAAPDUSender(cardService);
        this.eacCASender = new EACCAAPDUSender(cardService);
        this.eacTASender = new EACTAAPDUSender(cardService);
        this.readBinarySender = new ReadBinaryAPDUSender(cardService);
        this.maxTranceiveLengthForPACEProtocol = i11;
        this.maxTranceiveLengthForSecureMessaging = i12;
        this.maxBlockSize = i13;
        this.shouldCheckMAC = z12;
        this.isAppletSelected = false;
        this.isOpen = false;
        this.rootFileSystem = new DefaultFileSystem(this.readBinarySender, false);
        this.appletFileSystem = new DefaultFileSystem(this.readBinarySender, z11);
    }

    public synchronized EACTAResult doEACTA(CVCPrincipal cVCPrincipal, List<CardVerifiableCertificate> list, PrivateKey privateKey, String str, EACCAResult eACCAResult, PACEResult pACEResult) throws CardServiceException {
        return new EACTAProtocol(this.eacTASender, getWrapper()).doTA(cVCPrincipal, list, privateKey, str, eACCAResult, pACEResult);
    }

    public synchronized CardFileInputStream getInputStream(short s11, int i11) throws CardServiceException {
        CardFileInputStream cardFileInputStream;
        CardFileInputStream cardFileInputStream2;
        if (!this.isAppletSelected) {
            synchronized (this.rootFileSystem) {
                this.rootFileSystem.selectFile(s11);
                cardFileInputStream2 = new CardFileInputStream(i11, this.rootFileSystem);
            }
            return cardFileInputStream2;
        }
        synchronized (this.appletFileSystem) {
            this.appletFileSystem.selectFile(s11);
            cardFileInputStream = new CardFileInputStream(i11, this.appletFileSystem);
        }
        return cardFileInputStream;
    }

    public synchronized BACResult doBAC(SecretKey secretKey, SecretKey secretKey2) throws CardServiceException, GeneralSecurityException {
        BACResult doBAC;
        doBAC = new BACProtocol(this.bacSender, this.maxTranceiveLengthForSecureMessaging, this.shouldCheckMAC).doBAC(secretKey, secretKey2);
        SecureMessagingWrapper wrapper2 = doBAC.getWrapper();
        this.wrapper = wrapper2;
        this.appletFileSystem.setWrapper(wrapper2);
        return doBAC;
    }
}
