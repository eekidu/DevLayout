package com.github.eekidu.dev.devlayout.util;

import android.util.Log;

public class FloatTransformer {
    private static final String TAG = "FloatTransformer";

    float minn = 0, maxx = 100, step = 1;
    static final int MIN_INT = 0;
    int range_int = 100;

    public FloatTransformer() {
    }

    public FloatTransformer(float minn, float maxx, float step) {
        this.minn = minn;
        this.maxx = maxx;
        this.step = step;
        range_int = (int) ((maxx - minn) / step);
    }

    public int projectInverse(float input_projected) {
        return (int) ((input_projected - minn) / (maxx - minn) * range_int) + MIN_INT;
    }

    /**
     * @param input_int in[MIN_INT, range_int + MIN_INT]
     * @return output in [minn, maxx]
     */
    public float project(int input_int) {
        return (float) (input_int - MIN_INT) / range_int * (maxx - minn) + minn;
    }

    public float getMin() {
        return minn;
    }

    public void setMin(float minn) {
        this.minn = minn;
        range_int = (int) ((maxx - minn) / step);
    }

    public float getMax() {
        return maxx;
    }

    public void setMax(float maxx) {
        this.maxx = maxx;
        range_int = (int) ((maxx - minn) / step);
    }

    public float getStep() {
        return step;
    }

    public void setStep(float step) {
        this.step = step;
        range_int = (int) ((maxx - minn) / step);
    }

    public int getMinInt() {
        return MIN_INT;
    }

    public int getMaxInt() {
        return range_int + MIN_INT;
    }

}
