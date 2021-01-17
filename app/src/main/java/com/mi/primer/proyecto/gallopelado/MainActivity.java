package com.mi.primer.proyecto.gallopelado;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultado;
    private EditText num1;
    private EditText num2;
    private Button btn_sumar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultado = findViewById(R.id.lblresultado);
        num1 = findViewById(R.id.txtnum1);
        num2 = findViewById(R.id.txtnum2);
        btn_sumar = findViewById(R.id.btn_sumar);
    }

    public void sumar(View view) {
        String numero1 = num1.getText().toString().trim();
        String numero2 = num2.getText().toString().trim();
        if(!this.validarCampos()) {
           return;
        }
        Integer res = Integer.parseInt(numero1) + Integer.parseInt(numero2);
        resultado.setText(res.toString());
    }
    public void restar(View view) {
        String numero1 = num1.getText().toString().trim();
        String numero2 = num2.getText().toString().trim();
        if(!this.validarCampos()) {
            return;
        }
        Integer res = Integer.parseInt(numero1) - Integer.parseInt(numero2);
        resultado.setText(res.toString());
    }

    public void producto(View view) {
        String numero1 = num1.getText().toString().trim();
        String numero2 = num2.getText().toString().trim();
        if(!this.validarCampos()) {
            return;
        }
        Integer res = Integer.parseInt(numero1) * Integer.parseInt(numero2);
        resultado.setText(res.toString());
    }

    public void dividir(View view) {
        String numero1 = num1.getText().toString().trim();
        String numero2 = num2.getText().toString().trim();
        if(!this.validarCampos()) {
            return;
        }
        if(Integer.parseInt(numero2) == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Cuidado!")
                    .setMessage("El segundo campo no debe ser 0")
                    .setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            num1.requestFocus();
                        }
                    });
            builder.show();
            return;
        }
        Integer res = Integer.parseInt(numero1) / Integer.parseInt(numero2);
        resultado.setText(res.toString());
    }

    private Boolean validarCampos() {
        String numero1 = num1.getText().toString().trim();
        String numero2 = num2.getText().toString().trim();
        if(numero1.isEmpty() || numero1 == "") {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Cuidado!")
                    .setMessage("El primer campo está vacío")
                    .setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            num1.requestFocus();
                        }
                    });
            builder.show();
            return false;
        }
        if(numero2.isEmpty() || numero2 == "") {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Cuidado!")
                    .setMessage("El segundo campo está vacío")
                    .setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            num2.requestFocus();
                        }
                    });
            builder.show();
            return false;
        }
        return true;
    }
}