package br.com.barbaraliboni.celleptechcurso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)//sempre começaremos depois dessa linha

        // Capturando as referências para os componentes visuais
        val edtLoginEmail : EditText = findViewById(R.id.edtLoginEmail);//editText eh o tipo de variavel. agora pediremos ao kotlin para localizar os componentes definidos na tela de login
        val edtLoginSenha : EditText = findViewById(R.id.edtLoginSenha); //R vem de resources
        val btnLoginEntrar : Button = findViewById(R.id.btnLoginEntrar); //sempre que quisermos usar um componente, utilizaremos a variavel criada para o id do mesmo
        val btnLoginCadastrar : Button = findViewById(R.id.btnLoginCadastrar);

        // Criando o Listener do Button
        //1º ajustar o botao escolhido, ou seja, referencia-lo para depois que clicado, executar o codigo programado
        btnLoginEntrar.setOnClickListener {  //utilizar a opção que abre chaves, n parenteses

            // Capturando os dados inseridos pelo usuário
            val email = edtLoginEmail.text.toString().trim(); //colocando a referencia do campo email, no caso o email deve ser convertido para string
            val senha = edtLoginSenha.text.toString().trim(); //o trim() da um tratamento na a string para eliminar os espaços no começo e no final

            // Validação dos campos
            if(email.isEmpty()){ //isEmpty() verifica se o email esta vazio
                 edtLoginEmail.error = "Campo obrigatório"//primeiro devemos sinalizar qual o campo de erro e depois a mensagem de erro
                 edtLoginEmail.requestFocus() //focaliza a atençao do usuario para tal componente
            }else if(senha.isEmpty()) {
                edtLoginSenha.error = "Campo obrigatório"
                edtLoginSenha.requestFocus()
            }else{ //campos nao estao vazios

                // Verificação do email e senha corretos
                if (email == "teste@teste.com" && senha == "123"){

                    // Exibindo uma mensagem para o usuário usando Toast (classe android para notificações)
                    Toast.makeText(this, "Usuário logado", Toast.LENGTH_LONG).show() //primeiro chamar a classe do Toast, depois usar a funçao makeText()
                                    //primeiro diremos a tela que estamos, segundo o texto que quero passar, e terceiro o tempo de exibiçao da msg (LENGTH_LONG ou LENGTH_SHORT)

                    // Abrindo a Activity
                    val mIntent = Intent(this, MainActivity::class.java)

                    startActivity(mIntent)
                    finish()
                }else{
                    // Apresentar uma mensagem de erro usando Toast
                    Toast.makeText(this, "Email e/ou Senha incorretos", Toast.LENGTH_LONG).show()
                }
            }
        }
        // Listener do ButtonCadastrar
        btnLoginCadastrar.setOnClickListener {
            val mIntent = Intent(this, CadastroActivity::class.java) //indo para a tela de cadastro
            startActivity(mIntent) //usuario permaneça tentando logar ou cadastrar
        }
    }
}