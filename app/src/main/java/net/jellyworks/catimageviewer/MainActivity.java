package net.jellyworks.catimageviewer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int index=0;
    ImageView imageView;
    TextView textView;
    int[] imageIds ={ R.drawable.cat1, R.drawable.cat2, R.drawable.cat3,
            R.drawable.cat4, R.drawable.cat5, R.drawable.cat6,
            R.drawable.cat7, R.drawable.cat8, R.drawable.cat9 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        drawImage(index);
    }

    public void btnTouched(View btn){
        if(btn.getId()==R.id.btnPrev){
            index--;
            if(index<0) {
                index = 0;
                btn.setEnabled(false);
            } else {
                btn.setEnabled(true);
            }
        } else if(btn.getId()==R.id.btnNext){
            index++;
            if(index>=imageIds.length){
                index = imageIds.length - 1;
                btn.setEnabled(false);
            } else {
                btn.setEnabled(true);
            }
        }
        drawImage(index);
    }

    void drawImage(int idx){
        int imageId = imageIds[idx];
        imageView.setImageResource(imageId);
        textView.setText(index+1 + "/"+ imageIds.length);
    }
}
