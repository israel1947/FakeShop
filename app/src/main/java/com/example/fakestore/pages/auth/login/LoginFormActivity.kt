package com.example.fakestore.pages.auth.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.fakestore.LoadingDialog
import com.example.fakestore.MainActivity
import com.example.fakestore.R
import com.example.fakestore.ValidForm
import com.example.fakestore.pages.auth.register.RegisterActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_form)
        login();
        goToRegister();
    }

    //private var validForm:Boolean = validEmailForm() && validPasswordForm();


    private fun validEmailForm():Boolean{
        val email = findViewById<TextInputLayout>(R.id.email)
        val emailTex = findViewById<TextInputEditText>(R.id.emailText).text.toString()

        if(emailTex.isEmpty()){
            email.error="Email address is required";
            return false;
        }
        else if(!ValidForm.emailValid(emailTex)) {
            email.error="Email address is not correct";
            return false;
        }else{
            email.error=null;
        }
        return true;
    }

    private fun validPasswordForm():Boolean{
        val password = findViewById<TextInputLayout>(R.id.passwordTextField);
        val passwordTex = findViewById<TextInputEditText>(R.id.passwordText).text.toString();

        if (passwordTex.isEmpty()){
            password.error="Password is required";
            return false;
        }else if(passwordTex.length < 8){
            password.error="The password must be greater than 8 and less than 15"
            return false;
        }else if(!ValidForm.passwordValid(passwordTex)){
            password.error="Capital letter and a special character are required"
            return false;
        }else if(!ValidForm.passwordValidNumber(passwordTex)){
            password.error="At least one number is required";
            return false;
        }else{
            password.error=null;
        }
        return true;
    }

    private fun alertDialogCustom(){
        val alertDialogBuilder = AlertDialog.Builder(this,R.style.CustomAlertDialog);
        alertDialogBuilder.setTitle(R.string.alert_error_login_alert)
        alertDialogBuilder.setMessage(R.string.header_error_login_message)
        alertDialogBuilder.setPositiveButton(R.string.confirm){ _, _ -> }
        alertDialogBuilder.show();
    }

    private fun login(){
        val logBtn: Button = findViewById(R.id.loginBtn)
        logBtn.setOnClickListener {
            if(validEmailForm() && validPasswordForm()){

                val loading = LoadingDialog(this);
                loading.startLoading("Signing In");
                Handler(Looper.getMainLooper()).postDelayed({ loading.isDismiss(); },2000)

                val intent = Intent(this, MainActivity::class.java);
                startActivity(intent);
            }else{
                alertDialogCustom();
            }
        }
    }

    private fun goToRegister(){
        val registerBtn: TextView = findViewById(R.id.goToRegisterPage)
        registerBtn.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java);
                startActivity(intent);
        }
    }
}