package com.nd.frt.recentconversation.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bumptech.glide.Glide;
import com.nd.frt.recentconversation.R;
import com.nd.frt.recentconversation.activity.DetailActivity;
import com.nd.frt.recentconversation.model.UserInfo;
import com.nd.frt.recentconversation.viewholder.UserViewHolder;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    public static final String TAG = UserAdapter.class.getSimpleName();
    private static final int REQUEST_EDIT_USER_INFO = 0 * 100;

    private List<UserInfo> mUserInfos;
    private View inflate;

    public UserAdapter(List<UserInfo> userInfos) {
        mUserInfos = userInfos;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_user, viewGroup, false);
        Log.d(TAG, "onCreateViewHolder");
        return new UserViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, final int position) {
        Log.d(TAG, "onBindViewHolder");
        final UserInfo userInfo = mUserInfos.get(position);
        Glide.with(userViewHolder.mIvAvatar)
                .load(userInfo.avatarUrl)
                .into(userViewHolder.mIvAvatar);
        userViewHolder.mTvUserName.setText(userInfo.userName);
        userViewHolder.mTvEmail.setText(userInfo.content);
        userViewHolder.mIvAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailActivity.start((Activity) v.getContext(), position, userInfo, REQUEST_EDIT_USER_INFO);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUserInfos.size();
    }

    public void add(UserInfo userInfo) {
        mUserInfos.add(userInfo);
        notifyDataSetChanged();
    }

    public void edit(int index, UserInfo userInfo) {
        mUserInfos.set(index, userInfo);
        notifyDataSetChanged();
    }

}
