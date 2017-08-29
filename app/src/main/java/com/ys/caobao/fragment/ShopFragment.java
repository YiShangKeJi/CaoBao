package com.ys.caobao.fragment;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ys.caobao.R;
import com.ys.caobao.adapter.RecyclerAdapter;
import com.ys.caobao.bean.Goods;
import com.ys.caobao.model.RecyclerHolder;
import com.ys.caobao.util.ViewUtil;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment{
    private View view;
    //
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private List<Goods> list;
    private TextView totilemoney,goshop;
    private CheckBox check;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shop, null);
        init();
        initData();
        return view;
    }

    private void initData() {
        list = new ArrayList<Goods>();
        for(int i=0;i<=4;i++){
            Goods goods = new Goods();
            goods.name="商品"+i+1;
            goods.num=0;
            goods.price=i+5;
            list.add(goods);
        }
        adapter = new RecyclerAdapter<Goods>(getActivity(), list, R.layout.item_shop) {
            @Override
            public void convert(final RecyclerHolder holder, final Goods item) {
                holder.setText(R.id.num, item.num + "");
                holder.setText(R.id.goods_introduce, item.introduce);
                holder.setText(R.id.goods_shopname, item.name);
                holder.setText(R.id.price, item.price + "元");
                holder.setOnClickListener(R.id.add, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        item.num++;
                        holder.setText(R.id.num, item.num + "");
                        calculate();
                    }
                });
                holder.setOnClickListener(R.id.remove, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (item.num > 0) {
                            item.num--;
                            holder.setText(R.id.num, item.num + "");
                            calculate();
                        }
                    }
                });
                holder.setOnCheckedChangeListener(R.id.check, new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            item.check = true;
                            calculate();
                        } else {
                            item.check = false;
                            calculate();
                        }
                    }
            });
            }
        };
        recyclerView = ViewUtil.getVRows(getActivity(), recyclerView, 1);
        recyclerView.setAdapter(adapter);
        //全选
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                for(int i=0;i<list.size();i++){
                    list.get(i).check = true;
                }
            } else {
                for(int i=0;i<list.size();i++){
                    list.get(i).check = false;
                }
            }

            calculate();
        }
        });
        //结账
        goshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"这就去结账！",Toast.LENGTH_SHORT).show();
            }
        });
    }
    //计算总数
    private void  calculate(){
        double count=0;
        int number =0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).check) {
                count += list.get(i).num * list.get(i).price;
                if(list.get(i).num>0) {
                    number++;
                }
            }
        }
        totilemoney.setText(count+"元");
        if(count==0){
            goshop.setEnabled(false);
            goshop.setBackgroundColor(Color.GRAY);
            goshop.setTextColor(Color.BLACK);
            goshop.setText("去结算（0）");
        }else{
            goshop.setEnabled(true);
            goshop.setBackgroundColor(Color.RED);
            goshop.setTextColor(Color.WHITE);
            goshop.setText("去结算（"+number+"）");
        }
    }
    private void init() {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        totilemoney = (TextView)view.findViewById(R.id.money);
        goshop = (TextView)view.findViewById(R.id.goshop);
        goshop.setEnabled(false);
        check = (CheckBox)view.findViewById(R.id.check);
    }

}
