package com.codedbyte.sharedpref;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button save;
    TextView show;
    SharedPreferences storage;
    private static final String STORAGE_NAME = "pref_file";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        save = (Button) findViewById(R.id.button);
        show = (TextView) findViewById(R.id.textView);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storage = getSharedPreferences(STORAGE_NAME, 0);
                SharedPreferences.Editor editor = storage.edit();
                editor.putString("name", editText.getText().toString());
                editor.commit();
            }
        });

        //get back text
        SharedPreferences pref = getSharedPreferences(STORAGE_NAME, 0);
        if (pref.contains("name")){
            show.setText(pref.getString("name", "not found"));
        }

    }
}
