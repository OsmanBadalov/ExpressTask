package com.example.expresstask.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.expresstask.R;


public class CategoriesAdapter extends ArrayAdapter {
   private String[] categoryName;
   private String[] percent;
   private String[] amount;
   private Integer[] imageid;
   private Activity context;

   public CategoriesAdapter(Activity context, String[] categoryName, String[] percent, String[] amount, Integer[] imageid) {
      super(context, R.layout.categories_item, categoryName);
      this.context = context;
      this.categoryName = categoryName;
      this.percent = percent;
      this.amount = amount;
      this.imageid = imageid;

   }

   @Override
   public View getView(int position, View convertView, ViewGroup parent) {
      View row=convertView;
      LayoutInflater inflater = context.getLayoutInflater();
      if(convertView==null)
         row = inflater.inflate(R.layout.categories_item, null, true);
      TextView txtName =  row.findViewById(R.id.txtCatName);
      TextView txtPercent =  row.findViewById(R.id.txtPercent);
      TextView txtAmount =  row.findViewById(R.id.txtAmount);
      ImageView imgCategory =  row.findViewById(R.id.imgCategory);

      txtName.setText(categoryName[position]);
      txtPercent.setText(percent[position] + "%");
      txtAmount.setText(amount[position] + "AZN");
      imgCategory.setImageResource(imageid[position]);
      return  row;
   }
}
