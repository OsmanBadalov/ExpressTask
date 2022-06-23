package com.example.expresstask.fragments;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.expresstask.R;
import com.example.expresstask.adapters.CategoriesAdapter;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;


public class StatsFragment extends Fragment {

   RelativeLayout rltSelectCard,rltSelectYear,rltSelectMonth;
   TextView txtYear,txtMonth;
   ListView listView;
   PieChart pieChart;
   Spinner spinner;
   String strYear,strMonth;

   private String catName[] = {
           "Train",
           "Clothes",
           "Car",
           "Other"
   };

   private String percent[] = {
           "40",
           "60",
           "33",
           "22"
   };
   private String amount[] = {
           "450",
           "600",
           "334",
           "225"
   };
   private Integer imageid[] = {
           R.drawable.ic_train,
           R.drawable.clothes,
           R.drawable.car,
           R.drawable.other

   };
   private String cardNumber[] = {
           "** 4455",
           "** 8963",
           "** 7514",
           "** 3584"
   };
   public StatsFragment(){}
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

   }
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

      View rootView = inflater.inflate(R.layout.stats_fragment, container, false);
      pieChart = rootView.findViewById(R.id.pieChart);
      listView = rootView.findViewById(R.id.list);

      rltSelectCard = rootView.findViewById(R.id.rltSelectCard);
      rltSelectYear = rootView.findViewById(R.id.rltSelectYear);
      rltSelectMonth = rootView.findViewById(R.id.rltSelectMonth);
      txtYear = rootView.findViewById(R.id.txtYear);
      txtMonth = rootView.findViewById(R.id.txtMonth);
      spinner = rootView.findViewById(R.id.spinner);
      ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
              R.layout.card_name_item, R.id.txtItemCardLast4value, cardNumber);
      spinner.setAdapter(adapter);

      addCatToList();
      rltSelectYear.setOnClickListener(v -> selectYear());
      rltSelectMonth.setOnClickListener(v -> selectMonth());
      return rootView;
   }
   void addPieSlice(){
      pieChart.addPieSlice(
              new PieModel(
                      "Shopping",
                      26,
                      Color.parseColor("#FFA726")));
      pieChart.addPieSlice(
              new PieModel(
                      "Car",
                      26,
                      Color.parseColor("#66BB6A")));
      pieChart.addPieSlice(
              new PieModel(
                      "Other",
                      40,
                      Color.parseColor("#EF5350")));
      pieChart.addPieSlice(
              new PieModel(
                      "Train",
                      15,
                      Color.parseColor("#29B6F6")));
      pieChart.addPieSlice(
              new PieModel(
                      "Hotel",
                      33,
                      Color.parseColor("#29eeF6")));
      pieChart.addPieSlice(
              new PieModel(
                      "Clothes",
                      18,
                      Color.parseColor("#29aaF6")));
      pieChart.setInnerValueString("All statements" + "\n" + "3500 AZN/month");
      pieChart.startAnimation();
   }
   void addCatToList(){
      CategoriesAdapter categoriesAdapter = new CategoriesAdapter(getActivity(), catName, percent,amount, imageid);
      listView.setAdapter(categoriesAdapter);
      addPieSlice();
      listView.setOnItemClickListener((adapterView, view, position, l) -> {
         FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
         FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

         OperationsDetails fragment = new OperationsDetails().newInstance(catName[position],amount[position],strYear,strMonth,imageid[position]);

         fragmentTransaction.setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_top, R.anim.slide_in_top, R.anim.slide_out_bottom);
         fragmentTransaction.add(R.id.container, fragment);
         fragmentTransaction.addToBackStack(null);
         fragmentTransaction.commit();


      });
   }
   void selectYear(){

         final CharSequence[] items = { "2022", "2021", "2020", "2019","2018","2017","2016","2015" };

         AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
         builder.setItems(items, (dialog, item) -> {
            txtYear.setText(items[item]);
            strYear = txtYear.getText().toString();
            dialog.dismiss();

         }).show();
      }
   void selectMonth(){

      final CharSequence[] items = { "January", "February", "March", "April","May","June","Jule","August","September","October","November","December" };

      AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
      builder.setItems(items, (dialog, item) -> {
         txtMonth.setText(items[item]);
         strMonth = txtMonth.getText().toString();
         dialog.dismiss();

      }).show();
   }


}
