package edu.wonderland.one.buttoninterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SyncStatusObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private TextView feldone, feldtwo, feldsymbol, feldresult;
    private Button myKnopf1, myKnopf2, myKnopf3;
    private Button number1, number2, number3, number4, number5, number6, number7, number8, number9, number0;
    private Button plus, equals, minus;
    private int add1, add2, sum;

    private String operator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        feldone = findViewById(R.id.feldone);
        feldtwo = findViewById(R.id.feldtwo);
        feldsymbol = findViewById(R.id.feldsymbol);
        feldresult = findViewById(R.id.feldresult);

        myKnopf1 = findViewById(R.id.knopf1);
        myKnopf2 = findViewById(R.id.knopf2);
        myKnopf3 = findViewById(R.id.knopf3);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        number3 = findViewById(R.id.number3);
        number4 = findViewById(R.id.number4);
        number5 = findViewById(R.id.number5);
        number6 = findViewById(R.id.number6);
        number7 = findViewById(R.id.number7);
        number8 = findViewById(R.id.number8);
        number9 = findViewById(R.id.number9);
        number0 = findViewById(R.id.number0);

        plus = findViewById(R.id.plus);
        equals = findViewById(R.id.equals);
        minus = findViewById(R.id.minus);

        feldone.setText("one");
        feldtwo.setText("two");
        feldsymbol.setText("symbol");
        feldresult.setText("");


        myKnopf1.setText("Reset");
        myKnopf2.setText("Knopf 2");
        myKnopf3.setText("Knopf 3");

        myKnopf1.setOnClickListener(this);
        myKnopf2.setOnClickListener(this);
        myKnopf3.setOnClickListener(this);

        //array
        number1.setText("1");
        number2.setText("2");
        number3.setText("3");
        number4.setText("4");
        number5.setText("5");
        number6.setText("6");
        number7.setText("7");
        number8.setText("8");
        number9.setText("9");
        number0.setText("0");

        plus.setText("+");

        //array
        number1.setOnClickListener(this);
        number2.setOnClickListener(this);
        number3.setOnClickListener(this);
        number4.setOnClickListener(this);
        number5.setOnClickListener(this);
        number6.setOnClickListener(this);
        number7.setOnClickListener(this);
        number8.setOnClickListener(this);
        number9.setOnClickListener(this);
        number0.setOnClickListener(this);

        plus.setOnClickListener(this);
        equals.setOnClickListener(this);
        minus.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {


        if(v.getId() == R.id.knopf1){
            feldone.setText("knopf 1 pressed !");

            feldone.setText("");
            feldtwo.setText("");
            feldsymbol.setText("");
            feldresult.setText("");
            add1 = 0;
            add2 = 0;

        } else if (v.getId() == R.id.knopf2) {
            feldone.setText("knopf 2 pressed !");
        } else if (v.getId() == R.id.knopf3) {
            feldone.setText("knopf 3 pressed !");
        } else if (v.getId() == R.id.number1) {
            //myFeld.setText("number 1 pressed!");
            displayNumber(1);

        } else if (v.getId() == R.id.number2) {
            //myFeld.setText("number 2 pressed!");
            displayNumber(2);

        } else if (v.getId() == R.id.number3) {
            //myFeld.setText("number 3 pressed!");
            displayNumber(3);

        } else if (v.getId() == R.id.number4) {
            //myFeld.setText("number 4 pressed !");
            displayNumber(4);

        } else if (v.getId() == R.id.number5) {
            //myFeld.setText("number 5 pressed !");
            displayNumber(5);

        } else if (v.getId() == R.id.number6) {
            //myFeld.setText("number 6 pressed !");
            displayNumber(6);

        } else if (v.getId() == R.id.number7) {
            //myFeld.setText("number 7 pressed !");
            displayNumber(7);

        } else if (v.getId() == R.id.number8) {
            //myFeld.setText("number 8 pressed !");
            displayNumber(8);

        } else if (v.getId() == R.id.number9) {
            //myFeld.setText("number 9 pressed !");
            displayNumber(9);

        } else if (v.getId() == R.id.number0) {
            //myFeld.setText("number 0 pressed !");
            displayNumber(0);

        } else if (v.getId() == R.id.plus) {
            //myFeld.setText("+ pressed !")
            feldsymbol.setText("+");
            addition();
        }else if (v.getId() == R.id.equals){
            //System.out.println("========");
            result();

        } else if (v.getId() == R.id.minus) {
            //System.out.println("-------");
            feldsymbol.setText("-");
            subtraction();
        }

    }

/*    public void displayNumber (int number){

       int var = (number * 10  + this.add1;
       System.out.println("this.add1: " + this.add1);
       this.add1 = var;
       System.out.println("var: " + var);

    }
 */

/*    public void displayNumber(int number){
        int var = 0;
        if (this.count == 0){
            this.add1 = number;
            count = 1;
            System.out.println("this.add1 = " + this.add1);
        }else {
            System.out.println(this.add1 =  + this.add1);
            this.add2 = number;
            var = this.add1 * 10 + add2;
            this.add1 = var;
            System.out.println("this.add2 = " + this.add2);
            System.out.println("var = " + var);
        }
    }

 */

/*    public void displayNumber(int number){
        if (this.add1 == 0){
            this.add1 = number;
            System.out.println("this.add1 = " + this.add1);
            this.myFeld.setText(this.sum + "" + this.add1);
        }else {
            System.out.println(this.add1 =  + this.add1);
            this.add2 = number;
            this.add1 = this.add1 * 10 + add2;
            System.out.println("this.add1 = " + this.add1);
            this.myFeld.setText(this.sum + "" + this.add1);
        }
    }

 */

    public void displayNumber(int number){
        if (this.sum == 0){
            if (this.add1 == 0){
                this.add1 = number;
                this.feldone.setText("" + this.add1);
            }else{
                this.add2 = number;
                this.add1 = this.add1 * 10 + add2;
                this.feldone.setText("" + this.add1);
            }
        }else {
            if (this.add1 == 0){
                this.add1 = number;
                this.feldtwo.setText("" + this.add1);
            }else{
                this.add2 = number;
                this.add1 = this.add1 * 10 + add2;
                this.feldtwo.setText("" + this.add1);
            }
        }

    }

/*    public void addition (){
        this.sum = this.add1;
        this.add1 = 0;
        this.myFeld.setText("" + sum + " + ");
        if (this.add1 == 0){
            System.out.println("add1 == 0");
        }else{
            System.out.println("add1 == " + add1);
        }
    }

 */

    public void addition (){
        if (this.add1 != 0) {
            feldone.setText("" + this.add1);
            this.sum = this.add1;
            this.add1 = 0;
            this.operator = "+";
            this.feldtwo.setText("");
            System.out.println("this.operator " + this.operator);
        }
    }

    public void subtraction (){
        if (this.add1 != 0) {
            feldone.setText("" + this.add1);
            this.sum = this.add1;
            this.add1 = 0;
            this.operator = "-";
            this.feldtwo.setText("");
            System.out.println("this.operator " + this.operator);
        }
    }

    public void result(){
        System.out.println("result result: " + add1 +  operator + add2 + " =" + sum);
        if (this.operator.contains("+")){
            System.out.println(" operator " + this.operator);
            this.sum += this.add1;
            feldresult.setText("" + this.sum);
        } else if (this.operator.contains("-")) {
            System.out.println(" operator " + this.operator);
            this.sum -= this.add1;
            feldresult.setText("" + this.sum);
        }
    }



/*    public void result(){

        switch (this.operator){
            case "+" : {
                System.out.println(" operator " + this.operator);
                this.sum += this.add1;
                feldresult.setText("" + this.sum);
            }
            case "-" : {
                System.out.println(" operator " + this.operator);
                this.sum -= this.add1;
                feldresult.setText("" + this.sum);
            }

        }
    }

 */

}