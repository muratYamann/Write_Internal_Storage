package com.yamankod.write_internal_storage;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by murat on 13.12.2016.
 */

public class MainActivity extends Activity {

    Button btnRead,btnWrite;
    EditText etYourData;
    TextView tvResponseData;

    ArrayList<String> liste;

    WriteInternalAppend write;
    InternalReadFile read;

    String[] sendData ;

    String fileName ="NotDefterimInternal.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnRead = (Button)findViewById(R.id.btnRead);
        btnWrite = (Button)findViewById(R.id.btnWrite);
        etYourData = (EditText)findViewById(R.id.etWrite);
        tvResponseData =(TextView)findViewById(R.id.tvread);



        sendData =new String[1];
        liste = new ArrayList();
        write = new WriteInternalAppend();
        read =  new InternalReadFile();


        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendData[0]=etYourData.getText().toString();
                write.WriteFile(fileName,sendData,MainActivity.this);

                Toast.makeText(MainActivity.this, "Veri Dosyaya yazıldı...", Toast.LENGTH_SHORT).show();

                etYourData.setText("");
            }
        });


        //Read From File
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                read.ReadToFile(fileName,getApplicationContext());
                liste =read.liste;

                String datam ="";
                for ( int i = 1; i<liste.size();i++){
                    datam +=liste.get(i)+"\n";
                }
                tvResponseData.setText(datam);

            }
        });

    }




}
