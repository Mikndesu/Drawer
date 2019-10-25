//package com.example.makethisdrawgraph;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//import com.google.android.material.textfield.TextInputEditText;
//
//public class TypeExpressionActivity extends AppCompatActivity {
//
//    TextInputEditText expressionfield;
//    Button draw;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_type_expression);
//
//        expressionfield = findViewById(R.id.expressionfield);
//        draw = findViewById(R.id.draw);
//        draw.setOnClickListener((v) -> {
//            Intent intent = new Intent(this, MainActivity.class);
//            intent.putExtra("expression", expressionfield.getHint());
//            startActivity(intent);});
//    }
//
//
//}
