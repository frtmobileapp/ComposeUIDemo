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
import com.nd.frt.recentconversation.viewholder.UserViewHoldere;

import java.util.List;

public class Useradapter extends RecyclerView.Adapter<UserViewHoldere> {


    private static final int REQUEST_EDIT_USER_INFO = 0x1001;
    private List<UserInfo> mUserinfos;

    public Useradapter(List<UserInfo>userInfos) {
        mUserinfos = userInfos;
    }

    @NonNull
    @Override
    public UserViewHoldere onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_user, viewGroup, false);
        return new UserViewHoldere(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHoldere userViewHoldere, final int position) {
        final UserInfo userInfo = mUserinfos.get(position);
        Glide.with(userViewHoldere.itemView.getContext())
                .load(userInfo.avatarUrl)
                .into(userViewHoldere.mIvAvatar);
        userViewHoldere.mTvUserName.setText(userInfo.userName);
        userViewHoldere.mTvEmail.setText(userInfo.content);
        userViewHoldere.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DetailActivity.start((Activity) view.getContext(),position,userInfo,REQUEST_EDIT_USER_INFO);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mUserinfos.size();
    }
    public void add(UserInfo userInfo){
        mUserinfos.add(userInfo);
        notifyDataSetChanged();
    }
    public void edit(int index, UserInfo userInfo){
        mUserinfos.set(index,userInfo);
        notifyDataSetChanged();
    }
}
