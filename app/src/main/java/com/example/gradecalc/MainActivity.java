package com.example.gradecalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ExpandedMenuView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerFirstGrade;
    Spinner spinnerSecondGrade;

    TextView textGrade;
    Button btnCalculate;

    String[] grades1= {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F+", "F", "F-", "G"};
    String[] grades2= {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F+", "F", "F-", "G"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerFirstGrade=findViewById(R.id.spinnerFirstGrade);
        //spinnerFirstGrade.setOnItemClickListener(new AdapterView.OnItemClickListener(){
        //    @Override
        //    public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3){
        //        firstGrade = (String)adapter.getItemAtPosition(position);
        //    }
        //});
        spinnerSecondGrade=findViewById(R.id.spinnerSecondGrade);
        //spinnerSecondGrade.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        textGrade=findViewById(R.id.textGrade);
        btnCalculate=findViewById(R.id.btnCalculate);

        ArrayAdapter adapter1=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, grades1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter2=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, grades2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerFirstGrade.setAdapter(adapter1);
        spinnerSecondGrade.setAdapter(adapter2);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                String firstGrade = (String)spinnerFirstGrade.getItemAtPosition(spinnerFirstGrade.getSelectedItemPosition());
                String secondGrade = (String)spinnerSecondGrade.getItemAtPosition(spinnerSecondGrade.getSelectedItemPosition());

                String result=getModuleResult(firstGrade, secondGrade);

                textGrade.setText(result);

            }
        });
    }

    // Method to calculate the Module grade based on assessment grades and weighting
    public String getModuleResult(String firstGrade, String secondGrade) {
        String result = "";
        double tca1 = 0;
        double tca2 = 0;
        double tca1Weight = 0.5;
        double tca2Weight = 0.5;

        switch(firstGrade) {
            case "A+":
                tca1 = (25.0 * tca1Weight);
                break;
            case "A":
                tca1 = (23.0 * tca1Weight);
                break;
            case "A-":
                tca1 = (21.0 * tca1Weight);
                break;
            case "B+":
                tca1 = (20.0 * tca1Weight);
                break;
            case "B":
                tca1 = (19.0 * tca1Weight);
                break;
            case "B-":
                tca1 = (18.0 * tca1Weight);
                break;
            case "C+":
                tca1 = (17.0 * tca1Weight);
                break;
            case "C":
                tca1 = (16.0 * tca1Weight);
                break;
            case "C-":
                tca1 = (15.0 * tca1Weight);
                break;
            case "D+":
                tca1 = (14.0 * tca1Weight);
                break;
            case "D":
                tca1 = (13.0 * tca1Weight);
                break;
            case "D-":
                tca1 = (12.0 * tca1Weight);
                break;
            case "F+":
                tca1 = (11.0 * tca1Weight);
                break;
            case "F":
                tca1 = (8.0 * tca1Weight);
                break;
            case "F-":
                tca1 = (4.0 * tca1Weight);
                break;
            case "G":
                tca1 = 0;
                break;
        }

        switch(secondGrade) {
            case "A+":
                tca2 = (25.0 * tca2Weight);
                break;
            case "A":
                tca2 = (23.0 * tca2Weight);
                break;
            case "A-":
                tca2 = (21.0 * tca2Weight);
                break;
            case "B+":
                tca2 = (20.0 * tca2Weight);
                break;
            case "B":
                tca2 = (19.0 * tca2Weight);
                break;
            case "B-":
                tca2 = (18.0 * tca2Weight);
                break;
            case "C+":
                tca2 = (17.0 * tca2Weight);
                break;
            case "C":
                tca2 = (16.0 * tca2Weight);
                break;
            case "C-":
                tca2 = (15.0 * tca2Weight);
                break;
            case "D+":
                tca2 = (14.0 * tca2Weight);
                break;
            case "D":
                tca2 = (13.0 * tca2Weight);
                break;
            case "D-":
                tca2 = (12.0 * tca2Weight);
                break;
            case "F+":
                tca2 = (11.0 * tca2Weight);
                break;
            case "F":
                tca2 = (8.0 * tca2Weight);
                break;
            case "F-":
                tca2 = (4.0 * tca2Weight);
                break;
            case "G":
                tca2 = 0;
                break;
        }

        double moduleValue = tca1 + tca2;

        if (moduleValue >= 24.0) {
            result = "A+";
        } else if (moduleValue >= 22.0) {
            result = "A";
        } else if (moduleValue >= 20.50) {
            result = "A-";
        }else if (moduleValue >= 19.50) {
            result = "B+";
        }else if (moduleValue >= 18.50) {
            result = "B";
        }else if (moduleValue >= 17.50) {
            result = "B-";
        }else if (moduleValue >= 16.50) {
            result = "C+";
        }else if (moduleValue >= 15.50) {
            result = "C";
        }else if (moduleValue >= 14.50) {
            result = "C-";
        }else if (moduleValue >= 13.50) {
            result = "D+";
        }else if (moduleValue >= 12.50) {
            result = "D";
        }else if (moduleValue >= 11.50) {
            result = "D-";
        }else if (moduleValue >= 9.50) {
            result = "F+";
        }else if (moduleValue >= 6.00) {
            result = "F";
        }else if (moduleValue >= 2.00) {
            result = "F-";
        }else {
            result = "G";
        }
        return result;
    }
}