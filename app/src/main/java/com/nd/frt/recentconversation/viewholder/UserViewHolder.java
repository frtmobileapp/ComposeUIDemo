package com.nd.frt.recentconversation.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nd.frt.recentconversation.R;

public class UserViewHolder extends RecyclerView.ViewHolder {

    public final ImageView mIvatar;
    public final TextView mtvUserName;
    public final TextView mtvEmail;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        mIvatar = itemView.findViewById(R.id.ivAvatar);
        mtvUserName = itemView.findViewById(R.id.tvUserName);
        mtvEmail = itemView.findViewById(R.id.tvEmail);

    }

}
