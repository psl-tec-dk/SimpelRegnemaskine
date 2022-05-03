package tec.psl.simpelregnemaskine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_numOne, et_numTwo;
    private TextView txt_res;
    private Button btn_add, btn_sub;
    private LinearLayout parentElem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parentElem = findViewById(R.id.parentElem);

        et_numOne = findViewById(R.id.et_numOne);
        et_numTwo = findViewById(R.id.et_numTwo);
        txt_res = findViewById(R.id.txt_res);
        btn_add = findViewById(R.id.btn_add);
        btn_sub = findViewById(R.id.btn_sub);

        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);

        /*
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float num1 = Float.parseFloat(et_numOne.getText().toString());
                float num2 = Float.parseFloat(et_numTwo.getText().toString());
                float res = num1 + num2;
                txt_res.setText( String.valueOf(res));
            }
        });
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float num1 = Float.parseFloat(et_numOne.getText().toString());
                float num2 = Float.parseFloat(et_numTwo.getText().toString());
                float res = num1 - num2;
                txt_res.setText( String.valueOf(res));
            }
        });

         */

    }

    @Override
    public void onClick(View view) {
        if(et_numOne.getText().toString().equals("") || et_numTwo.getText().toString().equals("")) {
            //Toast.makeText(this, "Begge felter skal udfyldes", Toast.LENGTH_LONG).show();
            Snackbar.make(parentElem, "Begge felter skal udfyldes", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Ok", view1 -> { })
                    .show();
            return;
        }
        float num1 = Float.parseFloat(et_numOne.getText().toString());
        float num2 = Float.parseFloat(et_numTwo.getText().toString());
        float res = 0;
        switch(view.getId()) {
            case R.id.btn_add:
                res = num1 + num2;
                break;
            case R.id.btn_sub:
                res = num1 - num2;
                break;
        }
        txt_res.setText( String.valueOf(res));
    }
}