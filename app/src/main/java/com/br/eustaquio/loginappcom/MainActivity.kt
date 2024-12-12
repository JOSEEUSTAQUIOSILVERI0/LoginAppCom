package com.br.eustaquio.loginappok

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.br.eustaquio.loginappcom.HomeScreen
import com.br.eustaquio.loginappcom.LoginScreen
import com.br.eustaquio.loginappcom.RegisterScreen
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)  // Inicializar Firebase
        auth = FirebaseAuth.getInstance()
        setContent {
            var user by remember { mutableStateOf<FirebaseUser?>(auth.currentUser) }
            var showLoginScreen by remember { mutableStateOf(true) }

            if (user == null) {
                if (showLoginScreen) {
                    LoginScreen(
                        onLogin = { email: String, password: String -> login(email, password) },
                        onRegisterClick = { showLoginScreen = false },
                        onLoginSuccess = { user = auth.currentUser }
                    )
                } else {
                    RegisterScreen(
                        onRegister = { email: String, password: String -> register(email, password) },
                        onLoginClick = { showLoginScreen = true }
                    )
                }
            } else {
                HomeScreen(userEmail = user!!.email ?: "") {
                    logout()
                    user = null
                }
            }
        }
    }

    private fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    setContent {
                        HomeScreen(userEmail = auth.currentUser?.email ?: "") {
                            logout()
                        }
                    }
                } else {
                    // Trate o erro de login
                }
            }
    }

    private fun register(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    setContent {
                        HomeScreen(userEmail = auth.currentUser?.email ?: "") {
                            logout()
                        }
                    }
                } else {
                    // Trate o erro de registro
                }
            }
    }

    private fun logout() {
        auth.signOut()
        setContent {
            var showLoginScreen by remember { mutableStateOf(false) }
            LoginScreen(
                onLogin = { email: String, password: String -> login(email, password) },
                onRegisterClick = { showLoginScreen = false },
                onLoginSuccess = { /* atualize o estado conforme necessário */ }
            )


        }
    }
}
