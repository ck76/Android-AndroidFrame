package cn.ck.mvp.business.notes.model.request;

/**
 * Created by ck on 2018/10/6.
 */
public class CreatNoteRequest {
    /**
     * lesson_id : 1
     * minute : 1:25
     * content : 这是一段笔记
     */

    private String lesson_id;
    private String minute;
    private String content;

    public CreatNoteRequest(String lesson_id, String minute, String content) {
        this.lesson_id = lesson_id;
        this.minute = minute;
        this.content = content;
    }

    public String getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(String lesson_id) {
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
}
