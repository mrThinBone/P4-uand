package vinhtv.android.app.androidlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowJokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);
        TextView tvContent = (TextView) findViewById(R.id.tv_joke_content);
        String content = getIntent().getExtras().getString(Intent.EXTRA_TEXT, "");
        tvContent.setText(content);
    }
}
