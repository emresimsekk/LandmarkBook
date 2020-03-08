package emresimsek.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listCity=findViewById(R.id.listCity);

        //Data
        final ArrayList<String> landMarkNames=new ArrayList<>();
        landMarkNames.add("Pisa");
        landMarkNames.add("Eiffel");
        landMarkNames.add("Colleseo");
        landMarkNames.add("London Bridge");

        final ArrayList<String> countryNames=new ArrayList<>();
        countryNames.add("Italy");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("United Kingdom");

        Bitmap pisa= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
        Bitmap colosseum= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.colosseum);
        Bitmap londonBiridge= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.landom);
        Bitmap eiffel= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eiffel);

        final ArrayList<Bitmap> landMarkImages= new ArrayList<>();
        landMarkImages.add(pisa);
        landMarkImages.add(eiffel);
        landMarkImages.add(colosseum);
        landMarkImages.add(londonBiridge);



        //ListView
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,landMarkNames);
        listCity.setAdapter(arrayAdapter);


        listCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("name",landMarkNames.get(position));
                intent.putExtra("country",countryNames.get(position));
                Singleton singleton=Singleton.getInstance();
                singleton.setChosenImage(landMarkImages.get(position));

                startActivity(intent);
            }
        });

    }
}
