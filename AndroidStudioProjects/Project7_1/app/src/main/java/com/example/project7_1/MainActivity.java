package com.example.project7_1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setTitle("배경색 바꾸기");
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        btn1 = (Button) findViewById(R.id.btn1);

        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

//        MenuInflater mInflater = getMenuInflater();
//        mInflater.inflate(R.menu.menu1, menu);

        menu.add(0,1,0,"배경색(빨강)");
        menu.add(0,2,0,"배경색(초록)");
        menu.add(0,3,0,"배경색(파랑)");
        
        SubMenu sMenu = menu.addSubMenu("버튼 변경 >>");

        sMenu.add(0,4,0,"버튼 회전");
        sMenu.add(0,5,0,"버튼 확대");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

//    if (item.getItemId() == R.id.itemRed){
        if (item.getItemId() == 1){

            baseLayout.setBackgroundColor(Color.RED);
            return true;
        }
//    else if (item.getItemId() == R.id.itemGreen){
        else if (item.getItemId() == 2){

            baseLayout.setBackgroundColor(Color.GREEN);
            return true;
        }
//    else if (item.getItemId() == R.id.itemBlue){
        else if (item.getItemId() == 3){

            baseLayout.setBackgroundColor(Color.BLUE);
            return true;
        }
//    else if (item.getItemId() == R.id.subRotate){
        else if (item.getItemId() == 4){

            btn1.setRotation(45);
            return true;
        }
//    else if (item.getItemId() == R.id.subSize){
        else if (item.getItemId() == 5){

            btn1.setScaleX(2);
            return true;
        }

        return false;
    }
}