package com.example.archer.fruit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.archer.fruit.R;
import com.example.archer.fruit.fruitcell.Fruit;

import java.util.List;

/**
 * Created by Archer on 2016/10/14.
 * <p>
 * 描述:
 * <p>
 * 作者
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {



    public FruitAdapter(Context context, int resource, List<Fruit> objects) {
        super(context, resource, objects);

    }


    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        Fruit fruit=getItem(position);//获取当前fruit实例
        View view;

        ViewHolder viewHolder;

        if (convertView==null){
            view= View.inflate(getContext(),R.layout.fruit_item,null);
            viewHolder=new ViewHolder();
            viewHolder.imageView= (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.textView= (TextView) view.findViewById(R.id.fruit_name);

            view.setTag(viewHolder);//将viewHolder存储在view中
        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();//重新获取viewHolder


        }


//        View view= LayoutInflater.from(getContext()).inflate(resourceid,null);


        assert fruit != null;
        viewHolder.imageView.setImageResource(fruit.getImageId());
        viewHolder.textView.setText(fruit.getName());
        return  view;

    }

    private class ViewHolder{
        ImageView imageView;
        TextView  textView;
    }
}
