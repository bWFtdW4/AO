package edu.wonderland.one.spielesammlung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setBackgroundColor(Color.LTGRAY);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        //TextView for the header "Games"
        TextView headerLine = new TextView(this);
        headerLine.setTextColor(Color.BLACK);
        headerLine.setTextSize(50.0f);
        headerLine.setText("Games");

        linearLayout.addView(headerLine);

        //string array for games
        String[] games = {"Hells Bells", "Hells Bells 2", "Hells Bells 3", "games4", "games5", "games6", "games7",
                "games8", "games9", "games10", "games2", "games3", "games4", "games5", "games6",
                "games7", "games8", "games9", "games10" };
        //object for a listview
        ListView gamesListView = new ListView(this);

        //Adapterpattern - ArrayAdapter for the listview, simple_list_item_1 is a predefined layout for listviews
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, games);
        //set the adapter to the listview
        gamesListView.setAdapter(adapter);

        //Observerpattern - setOnItemClickListener for the listview - auto generates onItemClick method
        gamesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        System.out.println("Hells Bells Clicked");
                        Log.d("switch", "0");
                        //Intent for the HellsBellsGames class
                        Intent game1Intent = new Intent(getApplicationContext(), HellsBellsGame.class);
                        //start the activity
                        startActivity(game1Intent);
                        break;
                    case 1:
                        System.out.println("Hells Bells 2 Clicked");
                        Log.d("switch", "1");
                        Intent game2Intent = new Intent(getApplicationContext(), HellsBellsGame2.class);
                        startActivity(game2Intent);
                        break;
                    case 2:
                        System.out.println("Hells Bells 3 Clicked");
                        Log.d("switch", "1");
                        Intent game3Intent = new Intent(getApplicationContext(), HellsBellsGame3.class);
                        startActivity(game3Intent);
                        break;
                }
            }
        });


        //add the listview to the linearlayout
        linearLayout.addView(gamesListView);

        //set the linearlayout as the contentview
        setContentView(linearLayout);




    }
}