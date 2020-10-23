package br.com.barbaraliboni.celleptechcurso //essa eh sempre a primeira linha de codigo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { //é a primeira função que roda quando a tela é criada, e sempre utilizaremos a função onCreate
        super.onCreate(savedInstanceState) //super esta criando a instancia do objeto
        setContentView(R.layout.activity_splash) //ajustar o conteudo para o arquivo xml

        // Abrir a LoginActivity após esperar 2.5 segundos
        Handler(Looper.getMainLooper()).postDelayed({

            // Criando uma Intent e guardando-a em uma variável.
             val mIntent = Intent(this, LoginActivity:: class.java);//intent é o que pretendemos fazer, é uma classe. o m é de Main. a primeira informaçao é a tela que estamos, e a segunda é a tela que iremos

            // Iniciando a Intent
            startActivity(mIntent); //passo como argument o nome da val criada

            // Finalizando a SplashActivity
            finish(); //depois dos comandos serem executados, a activity é finalizada para nao ser possivel voltar para a tela de carregamento

        }, 2500); //alt+enter abre uma tela para importaçao
                                                        //o tempo é sempre multiplicado por 1000
    }               //o handler vai aguardar 2500 milisegundos e executar o código dentro da chave para trocar de tela
}