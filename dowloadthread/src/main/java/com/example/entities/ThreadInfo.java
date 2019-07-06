package com.example.entities;

public class ThreadInfo {
    private Integer id;
    private String url;
    private Integer start;
    private Integer end;
    private Integer finished;

    public ThreadInfo() {
        super();
    }

    @Override
    public String toString() {
        return "ThreadInfo{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", finished=" + finished +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }

    public ThreadInfo(Integer id, String url, Integer start, Integer end, Integer finished) {

        this.id = id;
        this.url = url;
        this.start = start;
        this.end = end;
        this.finished = finished;
    }
}
