package choongyul.android.com.study0308;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class AnimationActivity extends AppCompatActivity {
    TextView textView;
    float dY = 0;
    float dX = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        textView = (TextView) findViewById(R.id.textView);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //두번째 파라미터인 "Background" 위치에는 setter객체가 있는놈만 작동한다.
//                ObjectAnimator objectAnimator1 = ObjectAnimator.ofInt(v,"BackgroundColor", 0xff123123,0x987987);
//                objectAnimator1.setDuration(2000);
//                ObjectAnimator objectAnimator2 = ObjectAnimator.ofInt(v,"BackgroundColor", 0xff120000,0x980000);
//                objectAnimator2.setDuration(2000);

//                AnimatorSet set = new AnimatorSet();
//                set.play(objectAnimator1).before(objectAnimator2);
//                set.start();
//
//                AnimatorSet delaySet = new AnimatorSet();
//                delaySet.play(set).after(1000);
//                delaySet.start();


                ///////////////////////
                ValueAnimator va = ValueAnimator.ofObject(new ArgbEvaluator(), 0xff123123,0xff987987 );
                va.setDuration(2000);
                va.start();
                va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        v.setBackgroundColor((int)animation.getAnimatedValue());
                    }
                });
                //////////////////////////////

            }
        });

        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dY = v.getY() - event.getRawY();
                        dX = v.getX() - event.getRawX();
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        v.animate().x(event.getRawX() + dX).setDuration(0).start();
                        v.animate().y(event.getRawY() + dY).setDuration(0).start();
                        v.animate().rotationXBy(0.03f).start();
                        v.animate().rotationYBy(0.05f).start();
                        return true;
                    case MotionEvent.ACTION_UP:
                        return true;
//                    case MotionEvent.ACTION_CANCEL:
//                        return true;
                    default:
                        return false;
                }

            }
        });
    }
}
