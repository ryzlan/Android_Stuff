package com.example.da_red_velvet.textformatchecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private  boolean flag = false ;
    private EditText text ;
    private TextView errormsg;
    Button btn;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            errormsg =(TextView) findViewById(R.id.error) ;

            btn= (Button) findViewById(R.id.button);
            btn.setEnabled(false);

            text= (EditText) findViewById(R.id.text);
            text.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    String t = s.toString();
                    if(t.length() > 2 ){
                        if(isValidText(t)){
                            btn.setEnabled(true);
                            flag = true ;
                        }else {
                            text.setError("Invalid Format");
                            errormsg.setText("Please Fix the text Format");

                        }
                    }
                }

                public boolean isValidText(String text){
                    String PATTERN = "/^[A-Z]+[a-z]*$/";
                    //        Pattern pattern = Pattern.compile(PATTERN);
                    //        Matcher matcher = pattern.matcher(text);
                    return text.matches(PATTERN);


                };
            });


        }



        public void fireSomething(View view){

            Toast.makeText(this, "All done ", Toast.LENGTH_SHORT).show();
        }
}
