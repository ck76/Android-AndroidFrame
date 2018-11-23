package cn.ck.mvp.business.courses.view.wedget;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import cn.ck.mvp.App;
import cn.ck.mvp.R;
import cn.ck.mvp.utils.DensityUtil;

/**
 * Created by ck on 2018/10/5.
 */
public class NoteDialog {

    View view;
    Dialog dialog;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;

    public NoteDialog(Context context) {

        dialog = new Dialog(context, R.style.NoteDialog);

        view = LayoutInflater.from(context).inflate(R.layout.dialog_note, null, false);
        imageView1 = view.findViewById(R.id.note_question);
        imageView2 = view.findViewById(R.id.note_point);
        imageView3 = view.findViewById(R.id.note_input);

        dialog.setContentView(view);

        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.width = App.getInstance().getResources().getDisplayMetrics().widthPixels- DensityUtil.dp2px(App.getInstance(),160);
        marginLayoutParams.bottomMargin = DensityUtil.dp2px(App.getInstance(), 40);
        view.setLayoutParams(marginLayoutParams);
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }

    public NoteDialog setOneButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            imageView1.setOnClickListener(onClickListener);
        } else {
            imageView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                }
            });
        }
        return this;
    }

    public NoteDialog setTwoButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            imageView2.setOnClickListener(onClickListener);
        } else {
            imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                }
            });
        }
        return this;
    }

    public NoteDialog setThreeButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            imageView3.setOnClickListener(onClickListener);
        } else {
            imageView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                }
            });
        }
        return this;
    }

    public void show() {
        dialog.show();

    }

    public void dismiss() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
