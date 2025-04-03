package br.com.fiap.projetofiapesg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.projetofiapesg.screens.empresas.CompanyData
import br.com.fiap.projetofiapesg.screens.empresas.SelectCompany
import br.com.fiap.projetofiapesg.screens.firstpage.FirstPageApp
import br.com.fiap.projetofiapesg.screens.loginpage.LoginPageApp
import br.com.fiap.projetofiapesg.screens.feedbacks.writefeedback.WriteFeedback
import br.com.fiap.projetofiapesg.screens.feedbacks.writefeedback.WriteFeedbackViewModel
import br.com.fiap.projetofiapesg.screens.loginpage.LoginPageViewModel
import br.com.fiap.projetofiapesg.screens.singuppages.SignUpPageAppViewModel
import br.com.fiap.projetofiapesg.screens.singuppages.SingUpPageApp
import br.com.fiap.projetofiapesg.ui.theme.ProjetoFiapESGTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetoFiapESGTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "firstpage",
                ){
                    composable(route = "firstpage") { FirstPageApp(navController)  }
                    composable(route = "login") { LoginPageApp(navController, LoginPageViewModel())  }
                    composable(route = "cadastro") { SingUpPageApp(navController, SignUpPageAppViewModel())  }
                    composable(route = "empresas") { SelectCompany(navController) }
                    composable(route = "dadosempresas") { CompanyData() }
                    composable(route = "feedback") { WriteFeedback(WriteFeedbackViewModel())  }
                    composable(route = "confirmfeedback") {  }
                    composable(route = "myfeedbacks") {  }
                }
            }
        }
    }
}
