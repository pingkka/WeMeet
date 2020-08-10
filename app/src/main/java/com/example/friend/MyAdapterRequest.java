package com.example.friend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.friend.databinding.ItemRequestBinding;

import java.util.List;

class MyRequestHolder extends RecyclerView.ViewHolder {

    ItemRequestBinding mBinding;

    MyRequestHolder(ItemRequestBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }
}

public class MyAdapterRequest extends RecyclerView.Adapter {

    private List<Profile> mProfiles;
    private Context context;

    MyAdapterRequest(List<Profile> profiles, Context context) {
        mProfiles = profiles;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder holder;

        ItemRequestBinding requestBinding = ItemRequestBinding.inflate(LayoutInflater.from(context), parent, false);
        holder = new MyRequestHolder(requestBinding);

        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        MyRequestHolder mHolder = (MyRequestHolder) holder;
        mHolder.mBinding.image.setBackgroundResource(mProfiles.get(position).getIcon());
        // mHolder.mBinding.image.setImageResource(mProfiles.get(position).getIcon());
        mHolder.mBinding.name.setText(mProfiles.get(position).getName());

        mHolder.mBinding.btnNo.setTag(holder.getAdapterPosition());
        mHolder.mBinding.btnNo.setOnClickListener(new View.OnClickListener() { // 거절 버튼
            @Override
            public void onClick(View v) {
                int pos = (int) v.getTag();
                mProfiles.remove(pos);
                Toast.makeText(context, "거절", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });

        mHolder.mBinding.btnYes.setTag(holder.getAdapterPosition());
        mHolder.mBinding.btnYes.setOnClickListener(new View.OnClickListener() { // 수락 버튼
            // 나의 친구목록에 친구 추가(DB..?)
            // 친구의 친구목록에 나 추가(DB..?)
            @Override
            public void onClick(View v) {
                int pos = (int) v.getTag();
                mProfiles.remove(pos);
                Toast.makeText(context, "수락", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() { return mProfiles.size();}
}