package cn.edu.seu.views;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import cn.edu.seu.R;

public class UploadDialog extends Dialog implements View.OnClickListener {
    private Context context;
    private String deviceName;

    private TextView distance;
    private TextView heat;
    private TextView sleepQuality;
    private TextView heartRate;
    private Switch share;
    private EditText evaluation;

    public UploadDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_upload);
        initView();
    }

    // 初始化组件
    private void initView(){
        // 设置对话框属性
        setCanceledOnTouchOutside(true);
        android.view.WindowManager.LayoutParams p = getWindow().getAttributes();
        p.width = (int)((context.getResources().getDisplayMetrics()).widthPixels * 0.8);
        p.height = (int)((context.getResources().getDisplayMetrics()).heightPixels * 0.65);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        getWindow().setAttributes(p);

        // 获取控件
        distance = findViewById(R.id.distance);
        heat = findViewById(R.id.heat);
        sleepQuality = findViewById(R.id.sleepQuality);
        heartRate = findViewById(R.id.heartRate);
        share = findViewById(R.id.share);
        evaluation = findViewById(R.id.evaluation);

        findViewById(R.id.close).setOnClickListener(this);
        findViewById(R.id.confirmUpload).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.close:
                UploadDialog.this.dismiss();
                break;
            case R.id.confirmUpload:
                startUpload();
                break;
        }
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    @Override
    public void show() {
        super.show();
        if(getDeviceName() != null){
            loadData();
        }
    }

    @Override
    public void dismiss() {
        super.dismiss();
        setDeviceName(null);
        // 复位
        distance.setText("10000米");
        heat.setText("1000卡路里");
        sleepQuality.setText("非常良好");
        heartRate.setText("75分钟/次");
        share.setChecked(true);
        evaluation.setText("");
    }

    // 从当前设备中读取数据
    private void loadData(){
        // ------通过蓝牙读取指定设备的健康数据-----

        // --------------------------------------
        // 测试集
        distance.setText("10000米");
        heat.setText("1000卡路里");
        sleepQuality.setText("非常良好");
        heartRate.setText("75分钟/次");
    }

    // 上传数据
    private void startUpload(){
        if(evaluation.getText().toString().equals("")){
            Toast.makeText(context, "写个心情呗", Toast.LENGTH_SHORT).show();
        }
        // 获取数据并上传
        // distance.getText().toString()
        // heat.getText().toString()
        // sleepQuality.getText().toString()
        // heartRate.getText().toString()
        // share.isChecked()

    }
}
