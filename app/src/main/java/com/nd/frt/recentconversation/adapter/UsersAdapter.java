package com.nd.frt.recentconversation.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.nd.frt.recentconversation.R;
import com.nd.frt.recentconversation.activity.DetailActivity;
import com.nd.frt.recentconversation.model.UserInfo;
import com.nd.frt.recentconversation.service.viewholder.UserViewHolder;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private static final int REQUEST_EDIT_USER_INFO = 0x1001;
    private List<UserInfo> mUserlnfos;

    public UsersAdapter(List<UserInfo>userInfos) {
        mUserlnfos = userInfos;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View itemViem = layoutInflater.inflate(R.layout.item_user, viewGroup, false);
        return new UserViewHolder(itemViem);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, final int position) {
        final UserInfo userInfo =mUserlnfos.get(position);
        Glide.with(userViewHolder.itemView.getContext())
                .load(userInfo.avatarUrl)
                .into(userViewHolder.mIvAvater);
        userViewHolder.mTvUserName.setText(userInfo.userName);
        userViewHolder.mTvEmail.setText(userInfo.userName);
        userViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailActivity.start((Activity) v.getContext(), position, userInfo, REQUEST_EDIT_USER_INFO);
            }
        });
    }

    @Override
    public int getItemCount() {

        return mUserlnfos.size();
    }
    public void add{
        mUserlnfos.add(UserInfo userInfo){
            mUserlnfos.add(UserInfo);
            notifyDataSetChanged();
        }
        mUserlnfos.edit(int index,UserInfo userInfo){
            mUserlnfos.set(index,UserInfo);
            notifyDataSetChanged();
    }
