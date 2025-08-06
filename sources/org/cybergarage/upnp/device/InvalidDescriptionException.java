package org.cybergarage.upnp.device;

import java.io.File;

public class InvalidDescriptionException extends Exception {
    public InvalidDescriptionException() {
    }

    public InvalidDescriptionException(String str) {
        super(str);
    }

    public InvalidDescriptionException(String str, File file) {
        super(String.valueOf(str) + " (" + file.toString() + ")");
    }

    public InvalidDescriptionException(Exception exc) {
        super(exc.getMessage());
    }
}
