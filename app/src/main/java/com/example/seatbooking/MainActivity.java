package com.example.seatbooking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnSeatSelected {
    private static final int COLUMNS = 6;
    private TextView txtSeatSelected,txtSeatCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSeatSelected = findViewById(R.id.txt_seat_selected);

//        List<AbstractItem> items = new ArrayList<>();
//        for (int i = 0; i<5; i++){
//            if (i%COLUMNS==0 || i%COLUMNS==4){
//                items.add(new EdgeItem(String.valueOf(i)));
//            }
//            else if (i%COLUMNS==1 || i%COLUMNS==3){
//                items.add(new CenterItem(String.valueOf(i)));
//            }
//            else if (i%COLUMNS==1 || i%COLUMNS==5){
//                items.add(new CenterItem(String.valueOf(i)));
//            }
//            else{
//                items.add(new EmptyItem(String.valueOf(i)));
//            }
//            for (int j = 0; j < i; j++){
//                items.add(new CenterItem(String.valueOf(i)));
//                items.add(new EdgeItem(String.valueOf(i)));
//            }
//        }


//=======================OLD WORK EXCELLENT=========================
        List<AbstractItem> items = new ArrayList<>();
        for (int i = 0; i<60; i++){
//            count = count + i;
             if (i%COLUMNS==0 || i%COLUMNS==4){
                items.add(new EdgeItem(String.valueOf(i)));
            }
            else if (i%COLUMNS==1 || i%COLUMNS==3){
                 items.add(new CenterItem(String.valueOf(i)));
            }
            else if (i%COLUMNS==1 || i%COLUMNS==5){
                items.add(new CenterItem(String.valueOf(i)));
            }
            else if (i == 5){
                items.add(new CenterItem(String.valueOf(i)));
            }
            else{
                items.add(new EmptyItem(String.valueOf(i)));
            }
        }




        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,COLUMNS);
        RecyclerView recyclerView = findViewById(R.id.lst_items);
        recyclerView.setLayoutManager(gridLayoutManager);
        AirplaneAdapter adapter = new AirplaneAdapter(this, items);
        recyclerView.setAdapter(adapter);



    }

    @Override
    public void onSeatSelected(int count){
        txtSeatSelected.setText("Book"+count+"Seat");


    }
}