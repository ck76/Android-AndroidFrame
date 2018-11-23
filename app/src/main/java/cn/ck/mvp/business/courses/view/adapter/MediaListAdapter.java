package cn.ck.mvp.business.courses.view.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import cn.ck.mvp.R;
import cn.ck.mvp.base.adapter.BaseRecyclerViewAdapter;
import cn.ck.mvp.base.adapter.BaseViewHolder;
import cn.ck.mvp.business.courses.model.response.CourseInfoRespModel;

/**
 * Created by ck on 2018/10/4.
 */
public class MediaListAdapter extends BaseRecyclerViewAdapter<CourseInfoRespModel> {
    private MediaListAdapter.OnItemViewClickListener onItemViewClickListener;

    public MediaListAdapter(List<CourseInfoRespModel> listResponseModels, Context context, int itemLayoutId) {
        super(listResponseModels, context, itemLayoutId);
    }

    @Override
    protected void bindView(BaseViewHolder viewHolder, final CourseInfoRespModel item) {
        final int position = viewHolder.getAdapterPosition();
        viewHolder.setText(R.id.tv_course_name, ((position + 1) + ". ") + item.getName());
        if (position == 0) {
            TextView textView = (TextView) viewHolder.getViewById(R.id.tv_course_name);
            textView.setTextColor(mContext.getResources().getColor(R.color.blue));
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemViewClickListener.onItemClick(position);
            }
        });
    }


    public interface OnItemViewClickListener {
        /**
         * item点击事件
         */
        void onItemClick(int position);
    }

    public void setOnItemViewClickListener(MediaListAdapter.OnItemViewClickListener onItemViewClickListener) {
        this.onItemViewClickListener = onItemViewClickListener;
    }
}
