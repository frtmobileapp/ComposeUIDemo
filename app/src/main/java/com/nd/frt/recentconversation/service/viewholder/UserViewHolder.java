package com.nd.frt.recentconversation.service.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.nd.frt.recentconversation.R;

public class UserViewHolder extends RecyclerView.ViewHolder {

    public final ImageView mIvAvater;
    public final ImageView mTvUserName;
    public final ImageView mTvEmail;


    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        mIvAvater = itemView.findViewById(R.id.ivAvater);
        mTvUserName = itemView.findViewById(R.id.tvUserName);
        mTvEmail = itemView.findViewById(R.id.tvEmail);
}
}
