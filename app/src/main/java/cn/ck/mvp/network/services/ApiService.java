package cn.ck.mvp.network.services;

import java.util.List;


import cn.ck.mvp.business.courses.model.response.CourseInfoRespModel;
import cn.ck.mvp.business.courses.model.response.CourseListResponseModel;
import cn.ck.mvp.business.account.model.request.LoginRequestModel;
import cn.ck.mvp.business.account.model.request.RegisteredRequestModel;
import cn.ck.mvp.business.account.model.request.ResetPwdRequestModel;
import cn.ck.mvp.business.account.model.response.LoginResponseModel;
import cn.ck.mvp.business.account.model.response.RegisteredResponseModel;
import cn.ck.mvp.business.main.model.response.UpdateResponseModel;
import cn.ck.mvp.business.main.model.response.UserInfoRespModel;
import cn.ck.mvp.business.mine.model.response.CoinModel;
import cn.ck.mvp.business.notes.model.request.CreatNoteRequest;
import cn.ck.mvp.business.notes.model.response.CreatNoteResponse;
import cn.ck.mvp.business.notes.model.response.NoteInfoRespModel;
import cn.ck.mvp.network.response.ApiResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author fhyPayaso
 * @since 2018/4/24 on 上午12:18
 * fhyPayaso@qq.com
 */
public interface ApiService {

    //检查更新
    @GET("has/version/new")

    Call<ApiResponse<UpdateResponseModel>> checkUpdate(@Query("cversion") String version, @Query("client") String client);

    //登录注册系统-------------------------------------------------------------------------

    /**
     * 登录
     *
     * @param loginModel
     * @return
     */
    @POST("login")
    Call<ApiResponse<LoginResponseModel>> login(@Body LoginRequestModel loginModel);

    /**
     * 获取用户详细信息
     *
     * @return
     */
    @GET("/user")
    Call<ApiResponse<UserInfoRespModel>> getUserInfo();

    /**
     * 注册
     *
     * @param registeredRequestModel
     * @return
     */
    @POST("register")
    Call<ApiResponse<RegisteredResponseModel>> register(@Body RegisteredRequestModel registeredRequestModel);

    /**
     * 修改密码
     *
     * @param resetPwdRequestModel
     * @return
     */
    @PUT("resetpassword")
    Call<ApiResponse> resetPassword(@Body ResetPwdRequestModel resetPwdRequestModel);


    //课程系统-----------------------------------------------------------------------------

    /**
     * 用于主页全部课程列表。。。
     * <p>
     * 获取全部课程列表
     */
    @GET("classes")
    Call<ApiResponse<List<CourseListResponseModel>>> getCourseList();

    /**
     * 用于我的全部课程列表。。。
     * <p>
     * 获取我的课程列表
     *
     * @return
     */
    @GET("/student/myclasses")
    Call<ApiResponse<List<CourseListResponseModel>>> getMyCourseList();

    /**
     * 用于简介Fragment。。。
     * <p>
     * 获取单个课程信息
     *
     * @param class_id
     * @return
     */
    @GET("/class/{class_id}")
    Call<ApiResponse<CourseListResponseModel>> getCourseItem(@Path("class_id") int class_id);

    /**
     * 获取课时列表
     *
     * @param id
     * @return
     */
    @GET("lessons/{class_id}")
    Call<ApiResponse<List<CourseInfoRespModel>>> getAllCourseInfo(@Path("class_id") int id);

    /**
     * 获取课时详细信息
     *
     * @param id
     * @return
     */
    @GET("lesson/{class_id}")
    Call<ApiResponse<CourseInfoRespModel>> getCourseInfoById(@Path("class_id") int id);

    /**
     * 购买课程
     *
     * @param id
     * @return
     */
    @POST("buylesson/{lesson_id}")
    Call<ApiResponse<String>> buyCourse(@Path("lesson_id") int id);


    //充值扣费---------------------------------------------------------------------------

    /**
     * 充值
     *
     * @param coinModel
     * @return
     */
    @PUT("recharge")
    Call<ApiResponse<CoinModel>> recharge(@Body CoinModel coinModel);

    /**
     * 扣费
     *
     * @param coinModel
     * @return
     */
    @PUT("deductions")
    Call<ApiResponse<CoinModel>> deductions(@Body CoinModel coinModel);


    //笔记系统---------------------------------------------------------------------------

    /**
     * 创建笔记
     *
     * @param creatNoteRequest
     * @return
     */
    @POST("/note")
    Call<ApiResponse<CreatNoteResponse>> creatNote(@Body CreatNoteRequest creatNoteRequest);

    /**
     * 更新笔记
     *
     * @param nodeId
     * @param creatNoteRequest
     * @return
     */
    @PUT("/note/{note_id}")
    Call<ApiResponse> updateNote(@Path("note_id") int nodeId, @Body CreatNoteRequest creatNoteRequest);

    /**
     * 获取某个笔记的详细信息
     *
     * @param noteId
     * @return
     */
    @GET("/note/{note_id}")
    Call<ApiResponse<NoteInfoRespModel>> getNoteInfo(@Path("note_id") int noteId);

    /**
     * 获取某课时的所有笔记
     *
     * @param lessonId
     * @return
     */
    @GET("/notes/{lesson_id}")
    Call<ApiResponse<List<NoteInfoRespModel>>> getNoteListInfo(@Path("lesson_id") int lessonId);

    /**
     * 用于主页Note的Fragment
     *
     * 获取所有笔记列表
     *
     * @return
     */
    @GET("/allnotes")
    Call<ApiResponse<List<NoteInfoRespModel>>> getAllNotes();

    /**
     * 主页四个圈
     */
    @GET("/classes")
    Call<ApiResponse<List<CourseListResponseModel>>> getTypeCourseList();

    /**
     * 根据课程ID获取笔记
     */
    @GET("/notesbyclass/{class_id}")
    Call<ApiResponse<List<NoteInfoRespModel>>> getNoteById(@Path("class_id") int classId);

}
