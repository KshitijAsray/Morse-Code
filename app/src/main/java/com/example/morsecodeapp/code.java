package com.example.morsecodeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.StringTokenizer;

public class code extends AppCompatActivity {

    private static final String TAG = "MorseCode";
    private Button decode,encode,clear,logout;
    private TextView main_view;
    private FirebaseAuth auth;
    private EditText mEdittext_input,mEdittext_output;
    private final String[] Alphanumeric_text = new String[37];
    private final String[] Alphanumeric_Morse_code = new String[37];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        Initialize_Arrays();
        Initialize_views();
        Bind_views();
    }
    protected void Initialize_views()
    {
        decode = findViewById(R.id.decode_button);
        encode = findViewById(R.id.encode_button);
        clear = findViewById(R.id.clear_button);
        logout = findViewById(R.id.logout_button);
        mEdittext_input = findViewById(R.id.edit_text_input);
        mEdittext_output = findViewById(R.id.edit_text_output);
        auth = FirebaseAuth.getInstance();
    }
    protected void Bind_views()
    {
        decode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Decode button clicked");
                String input_decode = mEdittext_input.getText().toString();
                StringBuilder output_decode = Decode_text(input_decode);
                mEdittext_output.setText(output_decode);
            }
        });
        encode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Encode button clicked");
                String input_encode = mEdittext_input.getText().toString();
                String output_encode = Encode_text(input_encode);
                mEdittext_output.setText(output_encode);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Clear button clicked");
                mEdittext_input.setText("");
                mEdittext_output.setText("");
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Toast.makeText(code.this,"logged out",Toast.LENGTH_SHORT).show();
            }
        });
    }
    protected String Encode_text(String input)
    {
        StringBuilder output_encode = new StringBuilder();
        for(int i = 0;i<input.length();i++)
        {
            String ch = input.substring(i,i+1);
            for(int j = 0;j<37;j++)
            {
                if(ch.equalsIgnoreCase(Alphanumeric_text[j]))
                {
                    output_encode.append(Alphanumeric_Morse_code[j]).append(" ");
                }
            }
        }
        return output_encode.toString();
    }
    protected StringBuilder Decode_text(String input)
    {
        StringBuilder output_decode = new StringBuilder();
        StringTokenizer st = new StringTokenizer(input," ");
        while(st.hasMoreElements()==true)
        {
            String ch = st.nextToken();
            for(int j = 0;j<37;j++)
            {
                if(ch.equalsIgnoreCase(Alphanumeric_Morse_code[j]))
                {
                    output_decode.append(Alphanumeric_text[j]);
                }
            }
        }
        return output_decode;
    }
    protected void Initialize_Arrays()
    {
        Alphanumeric_text[0] = "A";
        Alphanumeric_text[1] = "B";
        Alphanumeric_text[2] = "C";
        Alphanumeric_text[3] = "D";
        Alphanumeric_text[4] = "E";
        Alphanumeric_text[5] = "F";
        Alphanumeric_text[6] = "G";
        Alphanumeric_text[7] = "H";
        Alphanumeric_text[8] = "I";
        Alphanumeric_text[9] = "J";
        Alphanumeric_text[10] = "K";
        Alphanumeric_text[11] = "L";
        Alphanumeric_text[12] = "M";
        Alphanumeric_text[13] = "N";
        Alphanumeric_text[14] = "O";
        Alphanumeric_text[15] = "P";
        Alphanumeric_text[16] = "Q";
        Alphanumeric_text[17] = "R";
        Alphanumeric_text[18] = "S";
        Alphanumeric_text[19] = "T";
        Alphanumeric_text[20] = "U";
        Alphanumeric_text[21] = "V";
        Alphanumeric_text[22] = "W";
        Alphanumeric_text[23] = "X";
        Alphanumeric_text[24] = "Y";
        Alphanumeric_text[25] = "Z";
        Alphanumeric_text[26] = "0";
        Alphanumeric_text[27] = "1";
        Alphanumeric_text[28] = "2";
        Alphanumeric_text[29] = "3";
        Alphanumeric_text[30] = "4";
        Alphanumeric_text[31] = "5";
        Alphanumeric_text[32] = "6";
        Alphanumeric_text[33] = "7";
        Alphanumeric_text[34] = "8";
        Alphanumeric_text[35] = "9";
        Alphanumeric_text[36] = " ";

        Alphanumeric_Morse_code[0] = ".-";
        Alphanumeric_Morse_code[1] = "-...";
        Alphanumeric_Morse_code[2] = "-.-.";
        Alphanumeric_Morse_code[3] = "-..";
        Alphanumeric_Morse_code[4] = ".";
        Alphanumeric_Morse_code[5] = "..-.";
        Alphanumeric_Morse_code[6] = "--.";
        Alphanumeric_Morse_code[7] = "....";
        Alphanumeric_Morse_code[8] = "..";
        Alphanumeric_Morse_code[9] = ".---";
        Alphanumeric_Morse_code[10] = "-.-";
        Alphanumeric_Morse_code[11] = ".-..";
        Alphanumeric_Morse_code[12] = "--";
        Alphanumeric_Morse_code[13] = "-.";
        Alphanumeric_Morse_code[14] = "---";
        Alphanumeric_Morse_code[15] = ".--.";
        Alphanumeric_Morse_code[16] = "--.-";
        Alphanumeric_Morse_code[17] = ".-.";
        Alphanumeric_Morse_code[18] = "...";
        Alphanumeric_Morse_code[19] = "-";
        Alphanumeric_Morse_code[20] = "..-";
        Alphanumeric_Morse_code[21] = "...-";
        Alphanumeric_Morse_code[22] = ".--";
        Alphanumeric_Morse_code[23] = "-..-";
        Alphanumeric_Morse_code[24] = "-.--";
        Alphanumeric_Morse_code[25] = "--..";
        Alphanumeric_Morse_code[26] = "-----";
        Alphanumeric_Morse_code[27] = ".----";
        Alphanumeric_Morse_code[28] = "..---";
        Alphanumeric_Morse_code[29] = "...--";
        Alphanumeric_Morse_code[30] = "....-";
        Alphanumeric_Morse_code[31] = ".....";
        Alphanumeric_Morse_code[32] = "-....";
        Alphanumeric_Morse_code[33] = "--...";
        Alphanumeric_Morse_code[34] = "---..";
        Alphanumeric_Morse_code[35] = "----.";
        Alphanumeric_Morse_code[36] = "/";

    }
}