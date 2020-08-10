package com.example.friend;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.friend.databinding.ItemListBinding;
import com.example.friend.databinding.ItemSearchBinding;

import java.util.List;

class MySearchHolder extends RecyclerView.ViewHolder {

    ItemSearchBinding mBinding;

    MySearchHolder(ItemSearchBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    // mBinding.getRoot().setOnClickListener(); 항목선택시
}

public class MyAdapterSearch extends RecyclerView.Adapter {

    private List<Profile> mProfiles;
    private Context context;

    private static final int MY = -1;
    private static final int FRIEND = -2;

    MyAdapterSearch(List<Profile> profiles, Context context) {
        mProfiles = profiles;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder holder;

        if( viewType == MY || viewType == FRIEND ) { // 본인 또는 친구
            ItemListBinding listBinding = ItemListBinding.inflate(LayoutInflater.from(context), parent, false);
            holder = new MyListHolder(listBinding);
        } else { // 친구가 아닐 때
            ItemSearchBinding searchBinding = ItemSearchBinding.inflate(LayoutInflater.from(context), parent, false);
            holder = new MySearchHolder(searchBinding);
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof MyListHolder) { // instanceof는 형변환 가능 여부.
            MyListHolder mHolder = (MyListHolder) holder;
            mHolder.mBinding.image.setBackgroundResource(mProfiles.get(position).getIcon());
            // mHolder.mBinding.image.setImageResource(mProfiles.get(position).getIcon());
            mHolder.mBinding.name.setText(mProfiles.get(position).getName());
        }
        else {
            MySearchHolder mHolder = (MySearchHolder) holder;
            mHolder.mBinding.image.setBackgroundResource(mProfiles.get(position).getIcon());
            // mHolder.mBinding.image.setImageResource(mProfiles.get(position).getIcon());
            mHolder.mBinding.name.setText(mProfiles.get(position).getName());

            mHolder.mBinding.btnRequest.setTag(holder.getAdapterPosition());
            mHolder.mBinding.btnRequest.setOnClickListener(new View.OnClickListener() { // 요청하기 버튼
                @Override
                public void onClick(final View v) {
                    AlertDialog.Builder builder;
                    builder = new AlertDialog.Builder(context);
                    builder.setTitle("요청하기");
                    builder.setIcon(mProfiles.get(position).getIcon());
                    builder.setMessage(Html.fromHtml(mProfiles.get(position).getName() + " 님에게 친구 신청을 보내시겠습니까?"));
                    builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 친구에게 신청알림 보내기
                            // 요청하기 버튼 지우기
                            Toast.makeText(context, "요청", Toast.LENGTH_SHORT).show();
                            int pos = (int) v.getTag();
                            // mProfiles.remove(pos); // 아이템 삭제
                        }
                    });
                    builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 변화 없음.
                            Toast.makeText(context, "취소", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.create().show();

                    notifyDataSetChanged(); // 갱신
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        // 여기서부터 ------------------------------------------------------------------------------
        String[] friends = {"이수연", "이규영", "최지호", "허예원", "박서연", "오아람", "홍승현"};

        if (mProfiles.get(position).getName() == "민경진") { // 본인
            return MY;
        }
        else {
            for(int i=0; i< friends.length; i++) { // 친구
                if(mProfiles.get(position).getName() == friends[i]) // DB에서 친구 목록이랑 비교해서 있을 경우
                    return FRIEND;
            }
        }
        return position;
        // 여기까지 수정----------------------------------------------------------------------------
        // 본인, 친구, 다른 사용자 구분
    }

    @Override
    public int getItemCount() {
        return mProfiles.size();
    }
}