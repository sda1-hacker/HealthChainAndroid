package cn.edu.seu.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cn.edu.seu.R;

/**
 * 用户信息界面
 */
public class UserPasswordActivity extends AppCompatActivity {

    private EditText editText_currentPassword;
    private EditText editText_newPassword;
    private EditText editText_newPassword2;
    private Button button_save;

    public SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_password);
        initView();
    }

    private void initView(){

        sharedPreferences = UserPasswordActivity.this.getSharedPreferences("test", Context.MODE_PRIVATE);


        //初始化得到这几个组件就可以，不用预先渲染内容
        editText_currentPassword = this.findViewById(R.id.currentPassword);
        editText_newPassword = this.findViewById(R.id.newPassword);
        editText_newPassword2 = this.findViewById(R.id.newPassword2);
        button_save = this.findViewById(R.id.save);
    }
    //处理点击事件
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                String string_currentPassword = editText_currentPassword.getText().toString();
                String string_newPassword = editText_newPassword.getText().toString();
                String string_newPassword2 = editText_newPassword2.getText().toString();
                //首先校验两次密码是否是否输入相同
                if (string_newPassword != string_newPassword2) {
                    //error,页面提示
                    Toast.makeText(this, "密码不一致", Toast.LENGTH_SHORT).show();
                    break;
                }

                //相同进行修改
                SharedPreferences.Editor editor = sharedPreferences.edit();       //获取编辑器
                editor.putString("password", string_newPassword);                 //key-value
                editor.commit();                                                  //提交修改

                //再跳转到用户信息页面
                Intent intent = new Intent(UserPasswordActivity.this, UserActivity.class);
                startActivity(intent);
                break;
            case R.id.back:
                //什么都不做，返回用户信息页面
                Intent intent_back = new Intent(UserPasswordActivity.this, UserActivity.class);
                startActivity(intent_back);
                break;
        }
    }

}
