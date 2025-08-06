package org.greenrobot.greendao.converter;

public interface PropertyConverter<P, D> {
    D convertToDatabaseValue(P p11);

    P convertToEntityProperty(D d11);
}
