package com.example.ex_btn;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView text_name, text_mail;
    Button btn1;
    EditText dlg_name, dlg_mail;
    TextView toasttext;
    View dialogview, toastview;

    @Override


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        text_name = (TextView) findViewById(R.id.text_name);
        text_mail = (TextView) findViewById(R.id.text_mail);

        btn1 = (Button) findViewById(R.id.btn1);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogview = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);

                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_menu_allfriends);

                dlg.setView(dialogview);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dlg_name = (EditText) dialogview.findViewById(R.id.dlg_name);
                        dlg_mail = (EditText) dialogview.findViewById(R.id.dlg_mail);

                        text_name.setText(dlg_name.getText().toString());
                        text_mail.setText(dlg_mail.getText().toString());

                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast toast = new Toast(MainActivity.this);

                        toastview = (View) View.inflate(MainActivity.this, R.layout.toast1, null);

                        toasttext = (TextView) toastview.findViewById(R.id.toast1_text);
                        toasttext.setText("취소했습니다");
                        toast.setView(toastview);

                        toast.show();
                    }
                });

                dlg.show();
            }
        });


    }
}