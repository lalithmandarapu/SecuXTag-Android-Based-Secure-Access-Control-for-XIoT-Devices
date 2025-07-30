package com.example.secuxtag;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputText;
    TextView outputText;
    Button encryptBtn;

    String secretKey = "12345678901234567890123456789012"; // 32-char AES-256 key

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);
        outputText = findViewById(R.id.outputText);
        encryptBtn = findViewById(R.id.encryptBtn);

        encryptBtn.setOnClickListener(v -> {
            try {
                String userInput = inputText.getText().toString().trim();
                if (userInput.isEmpty()) {
                    outputText.setText("Please enter text to encrypt.");
                    return;
                }

                String encrypted = AESUtil.encrypt(userInput, secretKey);
                String decrypted = AESUtil.decrypt(encrypted, secretKey);
                outputText.setText("Encrypted: " + encrypted + "\n\nDecrypted: " + decrypted);
            } catch (Exception e) {
                outputText.setText("Error: " + e.getMessage());
            }
        });
    }
}
