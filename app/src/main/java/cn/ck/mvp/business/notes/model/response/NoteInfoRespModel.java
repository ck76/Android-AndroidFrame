package cn.ck.mvp.business.notes.model.response;

/**
 * Created by ck on 2018/10/6.
 */
public class NoteInfoRespModel {
    /**
     * id : 1
     * user_id : 4
     * lesson_id : 1
     * minute : 1:25
     * content : 这是一段更新后的笔记
     * note_type : 1
     * created_at : 2018-10-03 12:16:56
     * updated_at : 2018-10-03 12:19:22
     */

    private int id;
    private int user_id;
    private int lesson_id;
    private String minute;
    private String content;
    private String note_type;
    private String created_at;
    private String updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNote_type() {
        return note_type;
    }

    public void setNote_type(String note_type) {
        this.note_type = note_type;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
