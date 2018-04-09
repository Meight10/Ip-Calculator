package com.meight.ipapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
    }

    private void initComponents(){

        //*****instanciando EditText que sirven de entrada*******
        //ip's
        edtxtIPField1 = (EditText)findViewById(R.id.IPField1);
        edtxtIPField2 = (EditText)findViewById(R.id.IPField2);
        edtxtIPField3 = (EditText)findViewById(R.id.IPField3);
        edtxtIPField4 = (EditText)findViewById(R.id.IPField4);


        //Mask
        edtxtMask = (EditText)findViewById(R.id.maskField);



        //*****instanciando TextView que sirven de salida*******
        ipOut = (TextView)findViewById(R.id.netIDOut);
        broadcastOut = (TextView)findViewById(R.id.broadcastOut);
        hostOut = (TextView)findViewById(R.id.hostOut);
        redOut = (TextView)findViewById(R.id.redOut);



        //agregando valores en EditText a variables
        strBinIp = formato(convertToBin(edtxtIPField1.getText().toString())) + formato(convertToBin(edtxtIPField2.getText().toString())) +
                   formato(convertToBin(edtxtIPField3.getText().toString())) + formato(convertToBin(edtxtIPField4.getText().toString()));

        stringMask = edtxtMask.getText().toString();

        //intanciando boton
        calculateButon = findViewById(R.id.calulate);
        calculateButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionPerformedCalculateButton(strBinIp);
            }
        });
    }




    private String convertToBin(String stringInput){

        int integerInput = Integer.parseInt(stringInput);

        String resultado="";

        while(integerInput > 0){
            if(integerInput % 2 == 0){
                resultado = "0" + resultado;
            }else{
                resultado = "1" + resultado;
                integerInput = integerInput/2;
            }
        }
        return resultado;
    }

    private String formato(String binNum){
        int contCero = 8-binNum.length();
        String ceros = "";
        String octeto = "";

        for(int i = 0; i<contCero; i++){
            ceros = ceros + "0";
        }

        octeto = ceros + binNum;

        return octeto;
    }



    private void actionPerformedCalculateButton(String strBinIp){
        ipOut.setText(strBinIp);
    }


    private String strBinIp;
    private String stringMask;

    private EditText edtxtIPField1;
    private EditText edtxtIPField2;
    private EditText edtxtIPField3;
    private EditText edtxtIPField4;
    private EditText edtxtMask;

    private TextView ipOut;
    private TextView broadcastOut;
    private TextView hostOut;
    private TextView redOut;

    private Button calculateButon;
}
