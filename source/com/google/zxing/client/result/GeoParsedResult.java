package com.google.zxing.client.result;

public final class GeoParsedResult extends ParsedResult {
    private final double altitude;
    private final double latitude;
    private final double longitude;
    private final String query;

    public GeoParsedResult(double d11, double d12, double d13, String str) {
        super(ParsedResultType.GEO);
        this.latitude = d11;
        this.longitude = d12;
        this.altitude = d13;
        this.query = str;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public String getDisplayResult() {
        StringBuilder sb2 = new StringBuilder(20);
        sb2.append(this.latitude);
        sb2.append(", ");
        sb2.append(this.longitude);
        if (this.altitude > 0.0d) {
            sb2.append(", ");
            sb2.append(this.altitude);
            sb2.append('m');
        }
        if (this.query != null) {
            sb2.append(" (");
            sb2.append(this.query);
            sb2.append(')');
        }
        return sb2.toString();
    }

    public String getGeoURI() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("geo:");
        sb2.append(this.latitude);
        sb2.append(',');
        sb2.append(this.longitude);
        if (this.altitude > 0.0d) {
            sb2.append(',');
            sb2.append(this.altitude);
        }
        if (this.query != null) {
            sb2.append('?');
            sb2.append(this.query);
        }
        return sb2.toString();
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getQuery() {
        return this.query;
    }
}
