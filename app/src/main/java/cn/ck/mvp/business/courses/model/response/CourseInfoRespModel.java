package cn.ck.mvp.business.courses.model.response;

/**
 * Created by ck on 2018/9/30.
 */
public class CourseInfoRespModel {


    /**
     * id : 1   //lessonid
     * name : 课程概述
     * class_id : 1
     * content : 商业游戏制作流程与游戏类型引擎比较
     * movie_id : 3
     * homework_content : 了解相关概念
     * homework_type : 1
     * created_at : 2018-10-05 12:32:54
     * updated_at : 2018-10-05 12:55:21
     * media_name : 第一讲.wmv
     * url : http://mooclass.andyhui.top/第一讲.wmv
     * pre_url : http://mooclass.andyhui.top/1538743499fk7T5VgVBw_第一讲.wmv
     */

    private int id;
    private String name;
    private int class_id;
    private String content;
    private int movie_id;
    private String homework_content;
    private int homework_type;
    private String created_at;
    private String updated_at;
    private String media_name;
    private String url;
    private String pre_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getHomework_content() {
        return homework_content;
    }

    public void setHomework_content(String homework_content) {
        this.homework_content = homework_content;
    }

    public int getHomework_type() {
        return homework_type;
    }

    public void setHomework_type(int homework_type) {
        this.homework_type = homework_type;
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

    public String getMedia_name() {
        return media_name;
    }

    public void setMedia_name(String media_name) {
        this.media_name = media_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPre_url() {
        return pre_url;
    }

    public void setPre_url(String pre_url) {
        this.pre_url = pre_url;
    }
}
