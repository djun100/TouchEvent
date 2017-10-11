package mio.kon.yyb.touchevent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;

import mio.kon.yyb.touchevent.util.L;

public class MainActivity extends AppCompatActivity {

    private mio.kon.yyb.touchevent.GrandparentView mGrandparentView;
    private mio.kon.yyb.touchevent.ParentView mParentView;
    private mio.kon.yyb.touchevent.ChildView mChildView;

    private View.OnClickListener mOnClickListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        L.d("Activity onTouchEvent " + EventUtil.getEventName(event.getAction()));
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        L.d("Activity dispatchTouchEvent "+ EventUtil.getEventName(ev.getAction()));
        return super.dispatchTouchEvent(ev);
    }

    private void initView() {
        mGrandparentView = (mio.kon.yyb.touchevent.GrandparentView) findViewById(R.id.mGrandparentView);
        mParentView = (mio.kon.yyb.touchevent.ParentView) findViewById(R.id.mParentView);
        mChildView = (mio.kon.yyb.touchevent.ChildView) findViewById(R.id.mChildView);

        mOnClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == mChildView ) {
                    L.d("点击了 mChildView");
                }
            }
        };
        mChildView.setOnClickListener(mOnClickListener);

        mChildView.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    L.d("mChildView按下");
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    L.d("mChildView弹起");
                }
                return false;
            }});
    }
}
