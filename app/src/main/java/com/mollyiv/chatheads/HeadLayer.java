package com.mollyiv.chatheads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

/*******************************************************************************
 * Creates the head layer view which is displayed directly on window manager.
 * It means that the view is above every application's view on your phone -
 * until another application does the same.
 *****************************************************************************/
public class HeadLayer extends View {
    private LinearLayout ll;
    private SeekBar sb;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private WindowManager mWindowManager;
    public HeadLayer(Context context) {
        super(context);
        mContext = context;
        mFrameLayout = new FrameLayout(mContext);
        addTo_new_WindowManager();
        addToWindowManager();
    }

    private void addTo_new_WindowManager() {
        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                // WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                PixelFormat.TRANSLUCENT);
        mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        ImageButton mButton = new ImageButton(mContext);
        mButton.setImageResource(R.drawable.toggle);
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        wm.addView(mButton, params);
    }


    private void addToWindowManager() {
        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.TYPE_PHONE,
               // WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                PixelFormat.TRANSLUCENT);
        mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        mWindowManager.addView(mFrameLayout, params);

        // Here is the place where you can inject whatever layout you want.
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.head, mFrameLayout);


        /**************************************************************************
         * Overlay Buttons
         **************************************************************************/
        ImageView iv = (ImageView) mFrameLayout.findViewById(R.id.gadge);
        ll = (LinearLayout) mFrameLayout.findViewById(R.id.l1);
        iv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ll.setSelected(!ll.isSelected());
                if (ll.isSelected()) {
                    sb.setVisibility(VISIBLE);
                } else {
                    sb.setVisibility(GONE);
                }
            }
        });
//        ImageView above_head_toggle = (ImageView) mFrameLayout.findViewById(R.id.touch_toggle);
//        above_head_toggle.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, "Works!", Toast.LENGTH_LONG).show();
//            }
//        });

        /**************************************************************************
         * Overlay Touch
         **************************************************************************/
        final LinearLayout l1t = (LinearLayout) mFrameLayout.findViewById(R.id.l1);
        final ImageView opacity_btn = (ImageView) mFrameLayout.findViewById(R.id.gadge);
        final Button toggle_btn = (Button) mFrameLayout.findViewById(R.id.toggle);
        l1t.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                l1t.setSelected(!l1t.isSelected());
                if (l1t.isSelected()) {
                    l1t.setBackgroundColor(Color.TRANSPARENT);
                    opacity_btn.setVisibility(GONE);
                    toggle_btn.setVisibility(GONE);
                } else {
                    l1t.setBackgroundColor(Color.BLACK);
                    opacity_btn.setVisibility(VISIBLE);
                    toggle_btn.setVisibility(VISIBLE);
                }

                return false;
            }
        });
        final LinearLayout l2t = (LinearLayout) mFrameLayout.findViewById(R.id.l2);
        l2t.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                l2t.setSelected(!l2t.isSelected());
                if (l2t.isSelected()) {
                    l2t.setBackgroundColor(Color.TRANSPARENT);
                } else {
                    l2t.setBackgroundColor(Color.BLACK);
                }

                return false;
            }
        });
        final LinearLayout l3t = (LinearLayout) mFrameLayout.findViewById(R.id.l3);
        l3t.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                l3t.setSelected(!l3t.isSelected());
                if (l3t.isSelected()) {
                    l3t.setBackgroundColor(Color.TRANSPARENT);
                } else {
                    l3t.setBackgroundColor(Color.BLACK);
                }

                return false;
            }
        });
        final LinearLayout l4t = (LinearLayout) mFrameLayout.findViewById(R.id.l4);
        l4t.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                l4t.setSelected(!l4t.isSelected());
                if (l4t.isSelected()) {
                    l4t.setBackgroundColor(Color.TRANSPARENT);
                } else {
                    l4t.setBackgroundColor(Color.BLACK);
                }

                return false;
            }
        });
        final LinearLayout l5t = (LinearLayout) mFrameLayout.findViewById(R.id.l5);
        l5t.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                l5t.setSelected(!l5t.isSelected());
                if (l5t.isSelected()) {
                    l5t.setBackgroundColor(Color.TRANSPARENT);
                } else {
                    l5t.setBackgroundColor(Color.BLACK);
                }

                return false;
            }
        });
        final LinearLayout l6t = (LinearLayout) mFrameLayout.findViewById(R.id.l6);
        l6t.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                l6t.setSelected(!l6t.isSelected());
                if (l6t.isSelected()) {
                    l6t.setBackgroundColor(Color.TRANSPARENT);
                } else {
                    l6t.setBackgroundColor(Color.BLACK);
                }

                return false;
            }
        });


        /**************************************************************************
         * Seekbar
         **************************************************************************/
        sb = (SeekBar) mFrameLayout.findViewById(R.id.seekBar2);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                LinearLayout l = (LinearLayout) mFrameLayout.findViewById(R.id.l1);
                LinearLayout l2 = (LinearLayout) mFrameLayout.findViewById(R.id.l2);
                LinearLayout l3 = (LinearLayout) mFrameLayout.findViewById(R.id.l3);
                if (i == 10) {
                    l.setAlpha((float) 0.9);
                    l2.setAlpha((float) 0.9);
                    l3.setAlpha((float) 0.9);
                } else if (i == 20) {
                    l.setAlpha((float) 0.8);
                    l2.setAlpha((float) 0.8);
                    l3.setAlpha((float) 0.8);
                } else if (i == 30) {
                    l.setAlpha((float) 0.7);
                    l2.setAlpha((float) 0.7);
                    l3.setAlpha((float) 0.7);
                } else if (i == 40) {
                    l.setAlpha((float) 0.6);
                    l2.setAlpha((float) 0.6);
                    l3.setAlpha((float) 0.6);
                } else if (i == 50) {
                    l.setAlpha((float) 0.5);
                    l2.setAlpha((float) 0.5);
                    l3.setAlpha((float) 0.5);
                } else if (i == 60) {
                    l.setAlpha((float) 0.4);
                    l2.setAlpha((float) 0.4);
                    l3.setAlpha((float) 0.4);
                } else if (i == 70) {
                    l.setAlpha((float) 0.3);
                    l2.setAlpha((float) 0.3);
                    l3.setAlpha((float) 0.3);
                } else if (i == 80) {
                    l.setAlpha((float) 0.2);
                    l2.setAlpha((float) 0.2);
                    l3.setAlpha((float) 0.2);
                } else if (i == 90) {
                    l.setAlpha((float) 0.1);
                    l2.setAlpha((float) 0.1);
                    l3.setAlpha((float) 0.1);
                } else if (i == 100) {
                    l.setAlpha(1);
                    l2.setAlpha(1);
                    l3.setAlpha(1);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    /**************************************************************************
     * Removes the view from window manager.
     **************************************************************************/
    public void destroy() {
        mWindowManager.removeView(mFrameLayout);
    }

}
