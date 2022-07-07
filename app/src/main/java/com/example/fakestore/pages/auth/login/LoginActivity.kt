package com.example.fakestore.pages.auth.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.fakestore.MainActivity
import com.example.fakestore.R


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login);
        goLogin()
    }

    private fun goLogin(){
        val loginBtn:Button = findViewById(R.id.goToForms)
        loginBtn.setOnClickListener {
            val intent = Intent(this, LoginFormActivity::class.java);
            startActivity(intent);
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            val alertDialog = AlertDialog.Builder(this);
            alertDialog.setMessage(R.string.alert_message_exit);
            alertDialog.setPositiveButton(R.string.confirm){dialog, wich->
                val intent = Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK;
                startActivity(intent);
            }
                .setNegativeButton(R.string.cancel){dialog, wich->
                    dialog.dismiss();
                }
            alertDialog.show();
        }
        return super.onKeyDown(keyCode, event)
    }
}


