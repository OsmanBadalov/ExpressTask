package com.example.expresstask.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.expresstask.R;

public class OperationsDetailsAdapter extends BaseAdapter {
   private String trnName;
   private String trnDate;
   private String amount;
   private Integer imageid;
   private Activity context;

   public OperationsDetailsAdapter(Activity context, String trnName, String trnDate, String amount, Integer imageid) {
      this.context = context;
      this.trnName = trnName;
      this.trnDate = trnDate;
      this.amount = amount;
      this.imageid = imageid;

   }

   @Override
   public int getCount() {
      return 15;
   }

   @Override
   public Object getItem(int position) {
      return null;
   }

   @Override
   public long getItemId(int position) {
      return 0;
   }

   @Override
   public View getView(int position, View convertView, ViewGroup parent) {
      View row=convertView;
      LayoutInflater inflater = context.getLayoutInflater();
      if(convertView==null)
         row = inflater.inflate(R.layout.item_operations, null, true);
      TextView txtName =  row.findViewById(R.id.txtDescription);
      TextView txtDate =  row.findViewById(R.id.txtDate);
      TextView txtAmount =  row.findViewById(R.id.txtAmount);
      ImageView imgCategory =  row.findViewById(R.id.imgCategory);

      txtName.setText(trnName);
      txtDate.setText(trnDate);
      txtAmount.setText(amount);
      imgCategory.setImageResource(imageid);
      return  row;
   }
}
