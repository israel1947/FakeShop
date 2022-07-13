package com.example.fakestore.pages.auth.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import com.example.fakestore.MainActivity
import com.example.fakestore.R
import com.example.fakestore.ValidForm
import com.example.fakestore.pages.auth.login.LoginFormActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        goToLogin();
        registerNow();


    }

    private fun validEmailForm():Boolean{
        val email = findViewById<TextInputLayout>(R.id.RegisterEmail)
        val emailTex = findViewById<TextInputEditText>(R.id.rgisterEmailText).text.toString()

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
        val password = findViewById<TextInputLayout>(R.id.registerPasswordTextField);
        val passwordTex = findViewById<TextInputEditText>(R.id.registerPasswordText).text.toString();

        val repeatPassword = findViewById<TextInputLayout>(R.id.repeatpasswordTextField);
        val repeatPasswordTex = findViewById<TextInputEditText>(R.id.repeatpasswordText).text.toString();

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
        }else if(passwordTex != repeatPasswordTex){
            repeatPassword.error="Passwords must be the same"
            return false;
        } else{
            password.error=null;
        }
        return true;
    }

    private fun checkTermAndCon():Boolean{
        val checkOption:Boolean = findViewById<CheckBox>(R.id.termAndCondition).isChecked
        if (checkOption){
            Toast.makeText(this,"Is checked", Toast.LENGTH_SHORT)
                .show()
            return true
        }else{
            Toast.makeText(this,"Is not checked", Toast.LENGTH_SHORT)
                .show()
            return false
        }

    }


    private fun registerNow(){
        val registerBtn: Button = findViewById(R.id.registerBtn)
        registerBtn.setOnClickListener {
            if(validEmailForm() && validPasswordForm() && checkTermAndCon() ){
                val intent = Intent(this, MainActivity::class.java);
                startActivity(intent);
                sendData()
            }
        }
    }

    fun sendData(){
        val emailTex = findViewById<TextInputEditText>(R.id.rgisterEmailText).text.toString()
        val passwordTex = findViewById<TextInputEditText>(R.id.registerPasswordText).text.toString();
        val repeatPasswordTex = findViewById<TextInputEditText>(R.id.repeatpasswordText).text.toString();
        val dataStr="Email: $emailTex,\n" +
                     "Password: $passwordTex,\n" +
                     "Repeat Password: $repeatPasswordTex,\n " +
                     "Term and Cond: ${checkTermAndCon()}"
        //println("data sent: $dataStr")
        println(dataStr)
    }

    private fun goToLogin(){
        val loginBtn: TextView = findViewById(R.id.goToLoginPage)
        loginBtn.setOnClickListener {
            val intent = Intent(this, LoginFormActivity::class.java);
            startActivity(intent);
        }
    }
}