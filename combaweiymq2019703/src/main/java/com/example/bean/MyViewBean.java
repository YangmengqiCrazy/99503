package com.example.bean;

import java.util.List;

public class MyViewBean {
    private int code;
    private DataBean data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        private List<NewsBean> news;
        private List<TopnewsBean> topnews;

        public List<NewsBean> getNews() {
            return news;
        }

        public void setNews(List<NewsBean> news) {
            this.news = news;
        }

        public List<TopnewsBean> getTopnews() {
            return topnews;
        }

        public void setTopnews(List<TopnewsBean> topnews) {
            this.topnews = topnews;
        }

        public static class NewsBean {
            private boolean comment;
            private int id;
            private String imageUrl;
            private String publishAt;
            private String title;
            private String type;
            private String url;

            @Override
            public String toString() {
                return "NewsBean{" +
                        "comment=" + comment +
                        ", id=" + id +
                        ", imageUrl='" + imageUrl + '\'' +
                        ", publishAt='" + publishAt + '\'' +
                        ", title='" + title + '\'' +
                        ", type='" + type + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }

            public boolean isComment() {
                return comment;
            }

            public void setComment(boolean comment) {
                this.comment = comment;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getPublishAt() {
                return publishAt;
            }

            public void setPublishAt(String publishAt) {
                this.publishAt = publishAt;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class TopnewsBean {
            private boolean comment;
            private int id;
            private String imageUrl;
            private String publishAt;
            private String title;
            private String type;
            private String url;

            @Override
            public String toString() {
                return "TopnewsBean{" +
                        "comment=" + comment +
                        ", id=" + id +
                        ", imageUrl='" + imageUrl + '\'' +
                        ", publishAt='" + publishAt + '\'' +
                        ", title='" + title + '\'' +
                        ", type='" + type + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }

            public boolean isComment() {
                return comment;
            }

            public void setComment(boolean comment) {
                this.comment = comment;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getPublishAt() {
                return publishAt;
            }

            public void setPublishAt(String publishAt) {
                this.publishAt = publishAt;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
