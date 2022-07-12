package com.example.fakestore

import android.util.Patterns

object ValidForm {

    private val  EMAIL_PATTERN: Regex =Regex("^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})\$");
    private val  PASSWORD_MIN:Regex=Regex("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[#?!@\$%^&*-]).{8,15}\$")
    private val  PASSWORD_NUMBER:Regex = Regex("(?=.*?[0-9]).{8,}\$")


    fun emailValid(email:String ): Boolean {
        return EMAIL_PATTERN.matches(email);
    }

    fun passwordValid(password:String ): Boolean {
        return PASSWORD_MIN.matches(password);
    }

    fun passwordValidNumber(password:String ): Boolean {
        return PASSWORD_NUMBER.matches(password);
    }
}

/*

Minimo 8 caracteres
Maximo 15
Al menos una letra mayúscula
Al menos una letra minucula
Al menos un dígito
No espacios en blanco
Al menos 1 caracter especial


*/