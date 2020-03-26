package cn.edu.seu.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import cn.edu.seu.R;

/**
 * 用户信息界面
 */
public class UserSexActivity extends AppCompatActivity {

    private RadioButton radioButton_man;
    private RadioButton radioButton_women;
    private Button button_save;

    public SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sex);
        initView();
    }

    private void initView(){

        sharedPreferences = UserSexActivity.this.getSharedPreferences("test",Context.MODE_PRIVATE);

        //得到组件： “修改手机号” 页面里的当前手机号内容组件，监听save按钮组件
        radioButton_man = this.findViewById(R.id.man);
        radioButton_women = this.findViewById(R.id.women);
        button_save = this.findViewById(R.id.save);
        //从数据库得到用户性别，设置其选中

    }
    //处理点击事件
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                if (radioButton_man.isChecked()) {

                    // 修改SharedPreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();       //获取编辑器
                    editor.putString("sex", "1");                                     //key-value
                    editor.commit();                                                  //提交修改

                }else if(radioButton_women.isChecked()){

                    // 修改SharedPreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();       //获取编辑器
                    editor.putString("sex", "2");                                     //key-value
                    editor.commit();                                                  //提交修改

                }
                //再跳转到用户信息页面
                Intent intent = new Intent(UserSexActivity.this, UserActivity.class);
                startActivity(intent);
                break;
            case R.id.back:
                //什么都不做，返回用户信息页面
                Intent intent_back = new Intent(UserSexActivity.this, UserActivity.class);
                startActivity(intent_back);
                break;
        }
    }

}
