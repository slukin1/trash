package zendesk.support;

final class RequestData {
    private final int commentCount;

    /* renamed from: id  reason: collision with root package name */
    private final String f62953id;
    private int readCommentCount;

    private RequestData(String str, int i11, int i12) {
        this.commentCount = i11;
        this.f62953id = str;
        this.readCommentCount = i12;
    }

    public static RequestData create(Request request) {
        return new RequestData(request.getId(), request.getCommentCount().intValue(), 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RequestData.class != obj.getClass()) {
            return false;
        }
        String str = this.f62953id;
        String str2 = ((RequestData) obj).f62953id;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int getCommentCount() {
        return this.commentCount;
    }

    public String getId() {
        return this.f62953id;
    }

    public int getReadCommentCount() {
        return this.readCommentCount;
    }

    public int hashCode() {
        String str = this.f62953id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "RequestData{commentCount=" + this.commentCount + "readCommentCount=" + this.readCommentCount + ", id='" + this.f62953id + '\'' + '}';
    }

    public int unreadComments() {
        return this.commentCount - this.readCommentCount;
    }

    public static RequestData create(String str, int i11, int i12) {
        return new RequestData(str, i11, i12);
    }
}
