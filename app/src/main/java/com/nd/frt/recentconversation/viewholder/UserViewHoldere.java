package com.nd.frt.recentconversation.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.nd.frt.recentconversation.R;

public class UserViewHoldere extends RecyclerView.ViewHolder {

    public final ImageView mIvAvatar;
    public final ImageView mTvUserName;
    public final ImageView mTvEmail;

    public UserViewHoldere(@NonNull View itemView) {
        super(itemView);
        mIvAvatar = itemView.findViewById(R.id.ivAvtar);
        mTvUserName = itemView.findViewById(R.id.tvUserName);
        mTvEmail = itemView.findViewById(R.id.tvEmail);
    }
}
