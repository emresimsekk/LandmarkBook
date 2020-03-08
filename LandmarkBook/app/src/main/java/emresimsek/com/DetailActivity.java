package emresimsek.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
        ImageView imageView;
        TextView landmarkName;
        TextView countryName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView=findViewById(R.id.imageView);
        landmarkName=findViewById(R.id.landMarkNameText);
        countryName=findViewById(R.id.countryNameText);

        Intent intent=getIntent();
        String landmarkNameGET=intent.getStringExtra("name");
        String countryNameGET=intent.getStringExtra("country");
        landmarkName.setText(landmarkNameGET);
        countryName.setText(countryNameGET);
        Singleton singleton=Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosenImage());

    }
}
