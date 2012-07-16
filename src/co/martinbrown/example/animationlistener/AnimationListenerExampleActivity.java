package co.martinbrown.example.animationlistener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

public class AnimationListenerExampleActivity extends Activity {

    Button theText;
    Button button1;
    Button button2;
    LinearLayout layout;
    float y;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        layout = (LinearLayout) findViewById(R.id.LinearLayout1);

        theText = (Button) findViewById(R.id.myView);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        y = theText.getY();

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Animation anim = new TranslateAnimation(0,
                        0,
                        0,
                        300);

                anim.setDuration(1000);

                theText.startAnimation(anim);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Animation anim = new TranslateAnimation(0,
                        0,
                        0,
                        300);

                anim.setDuration(1000);

                anim.setAnimationListener(new AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        theText.setY(300);
                    }
                });

                theText.startAnimation(anim);
            }
        });
    }
}