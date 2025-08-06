package org.jmrtd;

import net.sf.scuba.smartcards.CardFileInputStream;
import net.sf.scuba.smartcards.CardService;
import net.sf.scuba.smartcards.CardServiceException;

public abstract class FileSystemCardService extends CardService {
    @Deprecated
    public abstract CardFileInputStream getInputStream(short s11) throws CardServiceException;

    public abstract CardFileInputStream getInputStream(short s11, int i11) throws CardServiceException;
}
