package com.yamankod.write_internal_storage;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WriteInternalAppend {


    private static final String TAG = "_WriteToFileAppend";

    public void WriteFile(String fileName, String[] mesaj, Context context) {

        Log.d(TAG, "WriteFile method");
        Log.d(TAG, "mesaj.lenght : " + mesaj.length);
        Log.d(TAG, "mesaj" + mesaj[0].toString());
        Log.d(TAG, "Context: "+ context.toString());
        try {


            File myFile = new File(context.getFilesDir(), fileName);
            Log.d(TAG,"Directory Internal: "+ myFile.toString());
            if (myFile.exists()) {

                Log.i(TAG, "file exist");

            }else{
                Log.d(TAG,"File doesnt exist. File Created");
                myFile.createNewFile();
            }

            FileOutputStream fOut = new FileOutputStream(myFile, true);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);

            for (int i = 0; i < mesaj.length; i++) {
                myOutWriter.write(mesaj[i] + "\n");
            }

            myOutWriter.flush();
            myOutWriter.close();

            fOut.close();

            Log.d(TAG, "Done writing SD");

        } catch (IOException e) {
            Log.w(TAG, "" + e.toString());
        }
    }
}
