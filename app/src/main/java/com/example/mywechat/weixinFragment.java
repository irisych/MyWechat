package com.example.mywechat;


import android.content.Context;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class weixinFragment extends Fragment {
    private View view;
    public RecyclerView recyclerView;
    private List<String> list;
    private Adapter adapter;

    public weixinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.tab01,container,false);
        initRecyclerView();
        initData();

        return view;
    }

    private void initData(){
        for (int i=0;i<8;i++){
            list.add("这是第"+i+"个例子！");
        }
    }
    private void initRecyclerView(){

        //获取 RecyclerView
        recyclerView =(RecyclerView)view.findViewById(R.id.recycleview);

        //创建adapter
        adapter = new Adapter(list);

        //给RecyclerView设置adapter
        recyclerView.setAdapter(adapter);

        //设置layoutManager,可以设置显示效果，是线性布局、grid布局，还是瀑布流布局
        //参数是：上下文、列表方向（横向还是纵向）、是否倒叙
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                RecyclerView.VERTICAL, false));

        }

}
