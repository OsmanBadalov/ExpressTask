package com.example.expresstask.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.expresstask.R;
import com.example.expresstask.adapters.CategoriesAdapter;
import com.example.expresstask.adapters.OperationsDetailsAdapter;


public class OperationsDetails extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";
    private static final String ARG_PARAM5 = "param5";
    String catName, strAmount, strYear, strMonth;
    Integer strImage;
    ListView listView;
    TextView categName,amount,yearAndMonth;
    ImageView categImage;

    public OperationsDetails() {
    }


    public OperationsDetails newInstance(String catName, String strAmount, String strYear, String strMonth, Integer strImage) {
        OperationsDetails fragment = new OperationsDetails();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, catName);
        args.putString(ARG_PARAM2, strAmount);
        args.putString(ARG_PARAM3, strYear);
        args.putString(ARG_PARAM4, strMonth);
        args.putInt(ARG_PARAM5, strImage);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            catName = getArguments().getString(ARG_PARAM1);
            strAmount = getArguments().getString(ARG_PARAM2);
            strYear = getArguments().getString(ARG_PARAM3);
            strMonth = getArguments().getString(ARG_PARAM4);
            strImage = getArguments().getInt(ARG_PARAM5);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.operation_details, container, false);

        listView = rootView.findViewById(R.id.operList);
        categName = rootView.findViewById(R.id.txtCategory);
        yearAndMonth = rootView.findViewById(R.id.txtDetails);
        amount = rootView.findViewById(R.id.txtAmount);
        categImage = rootView.findViewById(R.id.categImage);
        categName.setText(catName);
        yearAndMonth.setText("Expences for " + strMonth + " " + strYear + " AZN");
        categImage.setImageResource(strImage);
        amount.setText(strAmount);
        addCatToList();
        return rootView;
    }

    void addCatToList() {
        OperationsDetailsAdapter operationsDetails = null;
        operationsDetails = new OperationsDetailsAdapter(getActivity(), catName, strMonth + " " + strYear, strAmount, strImage);
        listView.setAdapter(operationsDetails);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

            }
        });
    }

}
