package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.DialogInterface;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import androidx.cardview.widget.CardView;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    CardView cv_fromUnit, cv_toUnit, cv_convert;
  //  RelativeLayout mCLayout;
    String fromUnit = "Centimeter";
    String toUnit = "Meter";
    TextView tv_fromUnit, tv_toUnit;
    EditText et_fromUnit, et_toUnit;
    final String[] values = new String[]{
            "Centimeter",
            "Meter",
            "Gram",
            "Kilogram",
            "Celcius", "Ferehnite"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cv_fromUnit = findViewById(R.id.fromUnit);
        cv_toUnit = findViewById(R.id.toUnit);
        cv_convert = findViewById(R.id.cv_convert);

       // mCLayout = findViewById(R.id.temp_relativeLayout);

        tv_fromUnit = findViewById(R.id.tv_fromUnit);
        tv_toUnit = findViewById(R.id.tv_toUnit);

        tv_fromUnit.setText(values[0]);
        tv_toUnit.setText(values[0]);

        et_fromUnit = findViewById(R.id.et_fromUnit);
        et_toUnit = findViewById(R.id.et_toUnit);

        cv_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempInput = et_fromUnit.getText().toString();
                if (tempInput.equals("") || tempInput == null) {
                    et_fromUnit.setError("Please enter some value");
                }  else {
                    if (tv_fromUnit.getText().toString().equals(values[0])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(tempInput);
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(centimetertometer(Double.parseDouble(tempInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[1])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(metertocentimeter(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(tempInput);
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[2])) {
                        if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(tempInput);
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(gramtokilogram(Double.parseDouble(tempInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[3])) {
                        if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(kilogramtogram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(tempInput);
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[4])) {
                          if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(tempInput);
                        } else if (tv_toUnit.getText().toString().equals(values[5])) {
                            et_toUnit.setText(celciustofer(Double.parseDouble(tempInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[5])) {
                          if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(fertocel(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[5])) {
                            et_toUnit.setText(tempInput);
                        }
                    }
                }
            }
        });

        cv_toUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("choose Unit");

                final String[] flowers = new String[]{
                        "Centimeter",
                        "Meter",
                        "Gram",
                        "Kilogram",
                        "Celcius", "Ferehnite"
                };

                builder.setSingleChoiceItems(
                        flowers, // Items list
                        -1, // Index of checked item (-1 = no selection)
                        new DialogInterface.OnClickListener() // Item click listener
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
// Get the alert dialog selected item's text
                                String selectedItem = Arrays.asList(flowers).get(i);
                                toUnit = selectedItem;
                                tv_toUnit.setText(toUnit);

                            }
                        });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
// Just dismiss the alert dialog after selection
// Or do something now
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();

// Finally, display the alert dialog
                dialog.show();

            }
        });

        cv_fromUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("choose Unit");

                final String[] flowers = new String[]{
                        "Centimeter",
                        "Meter",
                        "Gram",
                        "Kilogram",
                        "Celcius", "Ferehnite"
                };

                builder.setSingleChoiceItems(
                        flowers, // Items list
                        -1, // Index of checked item (-1 = no selection)
                        new DialogInterface.OnClickListener() // Item click listener
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


// Get the alert dialog selected item's text
                                String selectedItem = Arrays.asList(flowers).get(i);
                                fromUnit = selectedItem;
                                tv_fromUnit.setText(fromUnit);

                            }
                        });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
// Just dismiss the alert dialog after selection
// Or do something now
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();

// Finally, display the alert dialog
                dialog.show();

            }
        });

    }


    //centimeter


    private String centimetertometer(double gram) {
        double Meter = gram/100 ;
        return String.valueOf(Meter);
    }

    //meter


    private String metertocentimeter(double meter) {
        double centimeter = meter*100;
        return String.valueOf(centimeter);
    }

    //Gram
    private String gramtokilogram(double kilo) {
        double Gram = kilo/1000;
        return String.valueOf(Gram);
    }



    //kilogram


    private String kilogramtogram(double gram) {
        double kilo = gram*1000;
        return String.valueOf(kilo);
    }

    //cel
    private String celciustofer(double cel) {
        double delisle = (cel*9/5)+32;
        return String.valueOf(delisle);
    }



    //fertocel


    private String fertocel(double delisle) {
        double newton = (delisle-32)*5/9;
        return String.valueOf(newton);
    }
}
