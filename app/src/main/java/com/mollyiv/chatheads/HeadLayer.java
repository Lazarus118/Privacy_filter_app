package com.mollyiv.chatheads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.view.Gravity;
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
    private LinearLayout ll, l2t, l3t, l4t, l5t, l6t;
    private ImageView opacity_btn;
    private SeekBar sb;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private WindowManager mWindowManager;

    // =================================================================== //
    public HeadLayer(Context context) {
        super(context);
        mContext = context;
        mFrameLayout = new FrameLayout(mContext);
        addTo_new_WindowManager();
        addToWindowManager(1);
    }


    // =================================================================== //
    private void addTo_new_WindowManager() {
        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
                PixelFormat.TRANSLUCENT);
        mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        params.gravity = Gravity.END;
        ImageButton mButton = new ImageButton(mContext);
        mButton.setImageResource(R.drawable.on_off);
        mButton.setBackgroundColor(Color.TRANSPARENT);
        mButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Works", Toast.LENGTH_LONG).show();
                addToWindowManager(2);
            }
        });
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        wm.addView(mButton, params);
    }

    // =================================================================== //
    private void addToWindowManager(int id) {
        if (id == 1) {
            WindowManager.LayoutParams params1 = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.TYPE_PHONE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    PixelFormat.TRANSLUCENT);
            mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            mWindowManager.addView(mFrameLayout, params1);
        } else {
            WindowManager.LayoutParams params2 = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.TYPE_PHONE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
                    PixelFormat.TRANSLUCENT);
            mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            mWindowManager.addView(mFrameLayout, params2);
        }
        // =================================================================== //
        // Here is the place where you can inject whatever layout you want.
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.head, mFrameLayout);

        /**************************************************************************
         * Overlay Buttons
         **************************************************************************/
        opacity_btn = (ImageView) mFrameLayout.findViewById(R.id.gadge);
        ll = (LinearLayout) mFrameLayout.findViewById(R.id.l1);
        opacity_btn.setOnClickListener(new OnClickListener() {
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

        /**************************************************************************
         * Overlay Touch
         **************************************************************************/
        final ImageView opacity_btn = (ImageView) mFrameLayout.findViewById(R.id.gadge);
        final Button toggle_btn = (Button) mFrameLayout.findViewById(R.id.toggle);
        ll.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ll.setSelected(!ll.isSelected());
                if (ll.isSelected()) {
                    ll.setBackgroundColor(Color.TRANSPARENT);
                    opacity_btn.setVisibility(GONE);
                    toggle_btn.setVisibility(GONE);
                } else {
                    ll.setBackgroundColor(Color.BLACK);
                    opacity_btn.setVisibility(VISIBLE);
                    toggle_btn.setVisibility(VISIBLE);
                }
                return false;
            }
        });
        l2t = (LinearLayout) mFrameLayout.findViewById(R.id.l2);
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
        l3t = (LinearLayout) mFrameLayout.findViewById(R.id.l3);
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
        l4t = (LinearLayout) mFrameLayout.findViewById(R.id.l4);
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
        l5t = (LinearLayout) mFrameLayout.findViewById(R.id.l5);
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
        l6t = (LinearLayout) mFrameLayout.findViewById(R.id.l6);
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
                if (i == 10) {
                    ll.setAlpha((float) 0.9);
                    l2t.setAlpha((float) 0.9);
                    l3t.setAlpha((float) 0.9);
                    l4t.setAlpha((float) 0.9);
                    l5t.setAlpha((float) 0.9);
                    l6t.setAlpha((float) 0.9);
                } else if (i == 20) {
                    ll.setAlpha((float) 0.8);
                    l2t.setAlpha((float) 0.8);
                    l3t.setAlpha((float) 0.8);
                    l4t.setAlpha((float) 0.8);
                    l5t.setAlpha((float) 0.8);
                    l6t.setAlpha((float) 0.8);
                } else if (i == 30) {
                    ll.setAlpha((float) 0.7);
                    l2t.setAlpha((float) 0.7);
                    l3t.setAlpha((float) 0.7);
                    l4t.setAlpha((float) 0.7);
                    l5t.setAlpha((float) 0.7);
                    l6t.setAlpha((float) 0.7);
                } else if (i == 40) {
                    ll.setAlpha((float) 0.6);
                    l2t.setAlpha((float) 0.6);
                    l3t.setAlpha((float) 0.6);
                    l4t.setAlpha((float) 0.6);
                    l5t.setAlpha((float) 0.6);
                    l6t.setAlpha((float) 0.6);
                } else if (i == 50) {
                    ll.setAlpha((float) 0.5);
                    l2t.setAlpha((float) 0.5);
                    l3t.setAlpha((float) 0.5);
                    l4t.setAlpha((float) 0.5);
                    l5t.setAlpha((float) 0.5);
                    l6t.setAlpha((float) 0.5);
                } else if (i == 60) {
                    ll.setAlpha((float) 0.4);
                    l2t.setAlpha((float) 0.4);
                    l3t.setAlpha((float) 0.4);
                    l4t.setAlpha((float) 0.4);
                    l5t.setAlpha((float) 0.4);
                    l6t.setAlpha((float) 0.4);
                } else if (i == 70) {
                    ll.setAlpha((float) 0.3);
                    l2t.setAlpha((float) 0.3);
                    l3t.setAlpha((float) 0.3);
                    l4t.setAlpha((float) 0.3);
                    l5t.setAlpha((float) 0.3);
                    l6t.setAlpha((float) 0.3);
                } else if (i == 80) {
                    ll.setAlpha((float) 0.2);
                    l2t.setAlpha((float) 0.2);
                    l3t.setAlpha((float) 0.2);
                    l4t.setAlpha((float) 0.2);
                    l5t.setAlpha((float) 0.2);
                    l6t.setAlpha((float) 0.2);
                } else if (i == 90) {
                    ll.setAlpha((float) 0.1);
                    l2t.setAlpha((float) 0.1);
                    l3t.setAlpha((float) 0.1);
                    l4t.setAlpha((float) 0.1);
                    l5t.setAlpha((float) 0.1);
                    l6t.setAlpha((float) 0.1);
                } else if (i == 100) {
                    ll.setAlpha(0);
                    l2t.setAlpha(0);
                    l3t.setAlpha(0);
                    l4t.setAlpha(0);
                    l5t.setAlpha(0);
                    l6t.setAlpha(0);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    /**************************************************************************
     * Removes the view from window manager.
     **************************************************************************/
    public void destroy() {
        mWindowManager.removeView(mFrameLayout);
    }

}
