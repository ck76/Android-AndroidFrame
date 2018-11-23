package cn.ck.mvp.business.courses.model.response;

/**
 * Created by ck on 2018/9/26.
 */
public class CourseListResponseModel {


    /**
     * id : 1   //Class的id
     * name : 编译原理精品课
     * content : 从零构建一个PL0语言编译器，词法分析语法分析语义分析，
     * teacher_id : 1
     * class_pic : http://mooclass.andyhui.top/logo%20xs.png
     * fee : 400
     * fee_back_num : 200
     * access_token : null
     * class_secret : null
     * class_num : class15375313999r99kcR0QT
     * created_at : 2018-09-21 12:03:19
     * updated_at : 2018-09-21 13:07:54
     * token_expired_at : null
     */

    private int id;
    private String name;
    private String content;
    private int teacher_id;
    private String class_pic;
    private int fee;
    private int fee_back_num;
    private Object access_token;
    private Object class_secret;
    private String class_num;
    private String created_at;
    private String updated_at;
    private Object token_expired_at;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getClass_pic() {
        return class_pic;
    }

    public void setClass_pic(String class_pic) {
        this.class_pic = class_pic;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getFee_back_num() {
        return fee_back_num;
    }

    public void setFee_back_num(int fee_back_num) {
        this.fee_back_num = fee_back_num;
    }

    public Object getAccess_token() {
        return access_token;
    }

    public void setAccess_token(Object access_token) {
        this.access_token = access_token;
    }

    public Object getClass_secret() {
        return class_secret;
    }

    public void setClass_secret(Object class_secret) {
        this.class_secret = class_secret;
    }

    public String getClass_num() {
        return class_num;
    }

    public void setClass_num(String class_num) {
        this.class_num = class_num;
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

    public Object getToken_expired_at() {
        return token_expired_at;
    }

    public void setToken_expired_at(Object token_expired_at) {
        this.token_expired_at = token_expired_at;
    }
}
