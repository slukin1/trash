package com.facebook.share;

public interface Sharer {

    public static class Result {
        public final String postId;

        public Result(String str) {
            this.postId = str;
        }

        public String getPostId() {
            return this.postId;
        }
    }

    boolean getShouldFailOnDataError();

    void setShouldFailOnDataError(boolean z11);
}
