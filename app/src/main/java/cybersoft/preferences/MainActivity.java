package cybersoft.preferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String MY_SETTING_PREFERENCES= "MySeting";


    Button btnSave;
    Button btnRead;
    EditText editText;
    TextView mess;
    SharedPreferences mySettings;
    String rememberText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnRead = (Button) findViewById(R.id.btnRead);
        btnSave = (Button) findViewById(R.id.btnSave);



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText=(EditText)findViewById(R.id.editText);
                saveText();


            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mess=(TextView)findViewById(R.id.mess);
                readText();
            }
        });
    }


    private void saveText() {
        mySettings = getSharedPreferences(MY_SETTING_PREFERENCES,MODE_PRIVATE);
        SharedPreferences.Editor editor = mySettings.edit();
        editor.putString(rememberText, editText.getText().toString());
        editor.apply();


        Toast.makeText(getApplicationContext(),"Должно быть записано сообщение " +editText.getText().toString(),Toast.LENGTH_SHORT ).show();

    }
    private void readText() {

        if (mySettings.contains(rememberText)) {
            mess.setText(mySettings.getString(rememberText, ""));
        }else {
            Toast.makeText(getApplicationContext(),"Нет записи " +rememberText , Toast.LENGTH_SHORT).show();
        }
    }




}
