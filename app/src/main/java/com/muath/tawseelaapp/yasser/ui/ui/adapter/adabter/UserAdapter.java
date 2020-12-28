package com.muath.tawseelaapp.yasser.ui.ui.adapter.adabter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.muath.tawseelaapp.R;
import com.muath.tawseelaapp.databinding.UserItemBinding;
import com.muath.tawseelaapp.interfaces_mock_yasser.ChatActivity;
import com.muath.tawseelaapp.yasser.model.User;

import java.util.ArrayList;



public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<User> users;

    public UserAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.user_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = users.get(position);
        holder.userItemBinding.civUserImage.setImageResource(R.drawable.ic_man);
        holder.userItemBinding.tvName.setText(user.getName());
        holder.userItemBinding.clParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ChatActivity.class).putExtra("res_id",user.getId()));

            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        UserItemBinding userItemBinding;
        public MyViewHolder(UserItemBinding userItemBinding) {
            super(userItemBinding.getRoot());
            this.userItemBinding = userItemBinding;
        }
    }
}
