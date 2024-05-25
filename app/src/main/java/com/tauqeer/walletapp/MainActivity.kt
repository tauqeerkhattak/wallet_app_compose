package com.tauqeer.walletapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth
import com.tauqeer.walletapp.ui.theme.WalletAppTheme

class MainActivity : ComponentActivity() {

    private fun checkAuth() {
        val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
        Handler(Looper.getMainLooper()).postDelayed(kotlinx.coroutines.Runnable {
            if (firebaseAuth.currentUser == null) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // TODO
            }
        },
            3000
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkAuth()
        enableEdgeToEdge()
        setContent {
            Body()
        }
    }

    @Composable
    fun Body() {
        return WalletAppTheme {
            Scaffold(modifier = Modifier.fillMaxSize()) { p ->
                Column(
                    modifier = Modifier.fillMaxSize().padding(p),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Wallet App",
                        fontSize = 30.sp,
                        modifier = Modifier.paddingFromBaseline(top = 0.dp, bottom = 20.dp),
                    )
                    Loader()
                }
            }
        }
    }

    @Composable
    fun Loader() {
        CircularProgressIndicator()
    }

    @Preview(showBackground = true)
    @Composable
    fun Preview() {
        return Body()
    }
}
