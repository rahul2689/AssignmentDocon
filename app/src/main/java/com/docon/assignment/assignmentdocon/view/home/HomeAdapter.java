package com.docon.assignment.assignmentdocon.view.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.docon.assignment.assignmentdocon.R;
import com.docon.assignment.assignmentdocon.model.home.UsersData;

import java.util.List;

/**
 * Created by rahul on 20/6/17.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private final OnItemClickListener mListener;
    private List<UsersData> mUserDataList;
    private Context mContext;

    public HomeAdapter(Context context, List<UsersData> data, OnItemClickListener listener) {
        mUserDataList = data;
        mListener = listener;
        mContext = context;
    }

    public void updateUserDataList(List<UsersData> dataList){
        mUserDataList = dataList;
        notifyDataSetChanged();
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_home, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new HomeViewHolder(view);
    }


    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        holder.click(mUserDataList.get(position), mListener);
        holder.tvUserName.setText(mUserDataList.get(position).getUserFirstName() + " " + mUserDataList.get(position).getUserLastName());

        String imageUrl = mUserDataList.get(position).getUserImageUrl();

        Glide.with(mContext)
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .skipMemoryCache(true)
                .into(holder.ivUserImage);

    }


    @Override
    public int getItemCount() {
        return mUserDataList.size();
    }


    public interface OnItemClickListener {
        void onClick(UsersData usersData);
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserName;
        ImageView ivUserImage;

        public HomeViewHolder(View itemView) {
            super(itemView);
            tvUserName = (TextView) itemView.findViewById(R.id.userName);
            ivUserImage = (ImageView) itemView.findViewById(R.id.userImage);

        }


        public void click(final UsersData usersData, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(usersData);
                }
            });
        }
    }
}
