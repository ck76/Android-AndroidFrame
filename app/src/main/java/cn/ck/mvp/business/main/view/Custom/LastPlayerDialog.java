package cn.ck.mvp.business.main.view.Custom;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import cn.ck.mvp.R;
import cn.ck.mvp.utils.CacheUtil;
import cn.ck.mvp.utils.DensityUtil;

/**
 * Created by ck on 2018/10/15.
 */
public class LastPlayerDialog {
    private View view;
    private View viewBottom;
    private Dialog dialog;
    private ImageView imgAvatar;
    private TextView tvCourseName;
    private ImageButton imbtnPlay;
    private ImageButton imbtnExit;
    private Context context;

    @SuppressLint("SetTextI18n")
    public LastPlayerDialog(Context context, int wedth) {
        this.context = context;
        dialog = new Dialog(context, R.style.BottomDialog);
        view = LayoutInflater.from(context).inflate(R.layout.dialog_last_palyed, null, false);
        imgAvatar = view.findViewById(R.id.img_avatar);
        tvCourseName = view.findViewById(R.id.tv_last_played_name);
        imbtnExit = view.findViewById(R.id.imgbtn_exit);
        imbtnPlay = view.findViewById(R.id.imgbtn_play);
        viewBottom = view.findViewById(R.id.view_bottom);
        dialog.setContentView(view);

        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        layoutParams.width = wedth;
        layoutParams.height = DensityUtil.dp2px(context, 47 + 55);
//        layoutParams.bottomMargin = DensityUtil.dp2px(context, 55);

        view.setLayoutParams(layoutParams);
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setGravity(Gravity.BOTTOM);


        Glide.with(context).load(CacheUtil.getSP().getString("course_url", "http://petwwg4u1.bkt.clouddn.com/QQ20181009-183417-HD.mp4")).into(imgAvatar);
        tvCourseName.setText(CacheUtil.getSP().getString("course_name ", " ") + CacheUtil.getSP().getString("lesson_name", " "));

        imbtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        viewBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialog!=null){
                    dialog.dismiss();
                }
            }
        });
    }

    public LastPlayerDialog setPlay(View.OnClickListener onClickListener){
        if (onClickListener!=null){
            imbtnPlay.setOnClickListener(onClickListener);
        }

        return this;
    }

    public void show() {
        dialog.show();
    }

    public void dissmiss(){
        dialog.dismiss();
    }
}
