package com.example.server_socket;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView1, textView2;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = (EditText) findViewById(R.id.editText);
        textView1 = (TextView) findViewById(R.id.textview1);
        textView2 = (TextView) findViewById(R.id.textview2);

        Button btn_send = findViewById(R.id.btn_send);
        Button btn_server = findViewById(R.id.btn_server);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String data = editText.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        send(data);
                    }
                }).start();
            }
        });

        btn_server.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        startServer();
                    }
                }).start();
            }
        });



    }


    public void printClientLog(final String data){
        Log.d("MainActivity", data);

        handler.post(new Runnable() {
            @Override
            public void run() {
                textView1.append(data + "\n");
            }
        });
    }

    public void printServerLog(final String data){
        Log.d("MainActivity", data);

        handler.post(new Runnable() {
            @Override
            public void run() {
                textView2.append(data + "\n");
            }
        });
    }

    public void send(String data){

        try {
            int portnum = 5001;
            Socket sock = new Socket("localhost", portnum);
            printClientLog("소켓 연결함.");

            ObjectOutputStream outstream = new ObjectOutputStream(sock.getOutputStream());
            outstream.writeObject(data);
            outstream.flush();
            printClientLog("데이터 전송함");

            ObjectInputStream instream = new ObjectInputStream(sock.getInputStream());
            printClientLog("서버로 부터 받음 : " + instream.readObject());
            sock.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void startServer(){

        try {
            int portnum = 5001;

            ServerSocket sever = new ServerSocket(portnum);
            printServerLog("서버 시작함" + portnum);

            while (true){
                Socket sock = sever.accept();
                InetAddress clientHost = sock.getLocalAddress();
                int clientPort = sock.getPort();
                printServerLog("클라이언트 연결됨" + clientHost + " : " + clientPort);


                ObjectInputStream instream = new ObjectInputStream(sock.getInputStream());
                Object obj = instream.readObject();
                printServerLog("데이터 받음 : " + obj);

                ObjectOutputStream outstream = new ObjectOutputStream(sock.getOutputStream());
                outstream.writeObject(obj + " from server.");
                outstream.flush();
                printServerLog("데이터 보냄");

                sock.close();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

}