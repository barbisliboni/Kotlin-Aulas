package br.com.barbaraliboni.celleptechcurso

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias para os ids dos componentes
        val txvMainNome: TextView = findViewById(R.id.txvMainNome);
        val txvMainEmail: TextView = findViewById(R.id.txvMainEmail);
        val txvMainGenero: TextView = findViewById(R.id.txvMainGenero);
        val btnMainSair: Button = findViewById(R.id.btnMainSair);
        val btnMainSite: Button = findViewById(R.id.btnMainSite);

        // Recuperando o Email passado por meio da Intent
        val email = intent.getStringExtra("INTENT_EMAIL"); //passar a chave usada para guardar a informaçao lá na tela de cadastro

        // Acessar o arquivo de SharedPreferences
        val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE);

        // Recuperando dados do arquivo de SharedPreferences
        val nome = sharedPrefs.getString("NOME", "Nome não encontrado"); //o segundo é o que o programa vai devolver caso o valor passado nao exista
        val sobrenome = sharedPrefs.getString("SOBRENOME", "");
        val genero = sharedPrefs.getString("GENERO", "Gênero não encontrado");

        // Exibindo os dados no TextView
        txvMainNome.text = "$nome $sobrenome";
        txvMainEmail.text = email;
        txvMainGenero.text = genero;

        //Listener do botão sair
        btnMainSair.setOnClickListener {

            //Criando e definindo o AlertDialog
            val alert = AlertDialog.Builder(this) //colocar qual tela pertence primeiro
                    .setTitle("Atenção") //ajustando o titulo da caixa de dialogo
                    .setMessage("Deseja mesmo sair?") //ajustando a mensagem
                    .setPositiveButton("Sair") {_, _-> //ajustando a opçao positiva da caixa de dialogo, e é PRECISO usar _, _-> após as chaves pois estamos ignorando os argumentos

                        // Abrindo a tela Login
                        val mIntent = Intent(this, LoginActivity::class.java)
                        startActivity(mIntent)
                        // Encerrando todas as telas anteriores
                        finishAffinity()
                    }
                    .setNeutralButton("Voltar"){_, _-> //nao configuro nada nesse codigo pois não é para acontecer nada
                    }
                    .setCancelable(true) //se eu consigo cancelar o alert quando clico fora do mesmo
                    alert.show()
        }
        //Listener do botao SiteCellep
        btnMainSite.setOnClickListener {
            //Abrindo a webactivity de um jeito mais prático
            startActivity(Intent(this, LayoutActivity::class.java))
        }
    }
}