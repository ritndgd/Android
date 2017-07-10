package edu.ritwijsn.cs478.project1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondActivity extends AppCompatActivity {

    private EditText editText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText = (EditText) findViewById(R.id.editText);
    }

    public void onSubmitClick(View view){
        if(editText != null && editText.getText() != null){
            String phoneNumber = validatePhoneNumber(editText.getText().toString());
            if(phoneNumber != null && !phoneNumber.trim().equals("")){
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phoneNumber));
                startActivity(intent);
            }
        }
    }

    public String validatePhoneNumber(String phoneNumber){
        if(phoneNumber != null && !phoneNumber.trim().equals("")){
            Pattern phoneNumPattern1 = Pattern.compile("\\(\\d{3}\\)\\s?\\d{3}-\\d{4}");
            Matcher phoneNumPatternMatcher1 = phoneNumPattern1.matcher(phoneNumber);
            if(phoneNumPatternMatcher1.find()){
                return phoneNumPatternMatcher1.group(0);
            }
        }
        return "";
    }
}
