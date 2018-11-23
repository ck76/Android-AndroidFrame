package cn.ck.mvp.utils;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cn.ck.mvp.R;

/**
 * Created by ck on 2018/10/12.
 */
public class EditDialog {
    private View view;
    private Dialog dialog;
    private TextView tvTitle;
    private Button btOk;
    private Button btCancel;
    private TextView tvMessage;
    private EditText editInput;

    @SuppressLint("InflateParams")
    public EditDialog(Context context) {
        dialog=new Dialog(context, R.style.CommonDialog);

        view= LayoutInflater.from(context).inflate(R.layout.dialog_edit,null,false);

        tvTitle=view.findViewById(R.id.tv_title);
        tvMessage=view.findViewById(R.id.tv_message);
        btOk=view.findViewById(R.id.bt_ok);
        btCancel=view.findViewById(R.id.bt_cancel);
        editInput=view.findViewById(R.id.tv_input);

        tvTitle.setVisibility(View.GONE);
        tvMessage.setVisibility(View.GONE);
        btOk.setVisibility(View.GONE);
        btCancel.setVisibility(View.GONE);
        editInput.setVisibility(View.GONE);


        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(false);

    }

    public EditDialog setTitle(String text) {
        tvTitle.setVisibility(View.VISIBLE);
        tvTitle.setText(text);
        return this;
    }

    public EditDialog setMessage(String text) {
        tvMessage.setVisibility(View.VISIBLE);
        tvMessage.setMovementMethod(ScrollingMovementMethod.getInstance());
        tvMessage.setText(text);
        return this;
    }

    public EditDialog setEditHit(String text){
        editInput.setVisibility(View.VISIBLE);
        editInput.setText(text);
        return this;
    }

    public String getEditText(){
        return editInput.getText().toString();
    }


    public EditDialog setPositiveButton(final String text, View.OnClickListener onClickListener) {
        btOk.setVisibility(View.VISIBLE);
        btOk.setText(text);
        if (onClickListener != null) {
            btOk.setOnClickListener(onClickListener);
        } else {
            btOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                }
            });
        }

        return this;
    }

    public EditDialog setNegativeButton(String text, View.OnClickListener onClickListener) {
        btCancel.setVisibility(View.VISIBLE);
        btCancel.setText(text);
        if (onClickListener != null) {
            btCancel.setOnClickListener(onClickListener);
        } else {
            btCancel.setOnClickListener(new View.OnClickListener() {
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
