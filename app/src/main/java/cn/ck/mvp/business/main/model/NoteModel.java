package cn.ck.mvp.business.main.model;

public class NoteModel {

    private String time;
    private String picUrl;
    private String title;
    private int iconRes;
    private int editKind;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIconRes() {
        return iconRes;
    }

    public void setIconRes(int iconRes) {
        this.iconRes = iconRes;
    }

    public int getEditKind() {
        return editKind;
    }

    public void setEditKind(int editKind) {
        this.editKind = editKind;
    }
}
