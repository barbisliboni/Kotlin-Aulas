package br.com.barbaraliboni.celleptechcurso

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        //SharedPreferences cria um arquivo no programa para salvar dados, mas não é um banco de dados, pois no android studio usamos o SQLite
        //não guardamos conteudo sensivel (email, senha, etc) do usuário no SharedPreferences
        //ele cria um arquivo xml dentro do aparelho do usuário que guarda um conjunto de chave e valor

        // Obtendo as referências para os componentes
        val edtCadastroNome : EditText = findViewById(R.id.edtCadastroNome);
        val edtCadastroSobrenome : EditText = findViewById(R.id.edtCadastroSobrenome);
        val edtCadastroEmail : EditText = findViewById(R.id.edtCadastroEmail);
        val edtCadastroSenha : EditText = findViewById(R.id.edtCadastroSenha);
        val btnCadastroCadastrar : Button = findViewById(R.id.btnCadastroCadastrar);
        val spnCadastroSpinner : Spinner = findViewById(R.id.spnCadastroGenero);

        // Criando uma lista de opções para o Spinner
        val listaGeneros = arrayListOf("Selecione o gênero", "Feminino", "Masculino", "Não-binário")

        // Criando um adaptador para o Spinner
        val generoAdapter = ArrayAdapter(
            this, //falando que é na tela atual de cadastro
            android.R.layout.simple_spinner_dropdown_item, //Layout do spinner
        listaGeneros
        )

        // Plugar a lista Adapter no Spinner
        spnCadastroSpinner.adapter = generoAdapter

        // Listener (Ouvinte) do botão Cadastrar (uso ponto pois estao chamando a função nao atribuindo)
        btnCadastroCadastrar.setOnClickListener {
            // Obtendo os dados inseridos pelo usuário
            val nome = edtCadastroNome.text.toString().trim()
            val sobrenome = edtCadastroSobrenome.text.toString().trim()
            val email = edtCadastroEmail.text.toString().trim()
            val senha = edtCadastroSenha.text.toString().trim()
            val genero = spnCadastroSpinner.selectedItem.toString() //usamos selectedItem para guardar a informaçao selecionada do spinner


            if(nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || senha.isEmpty() || genero == listaGeneros[0]){

                // Exibindo uma mensagem de erro usando o Toast
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            }else{
                //Usaremos o SharedPreferences
                //Chaves sao sempre no formato String

                // Criando um arquivo SharedPreferences caso nao existe e acessando caso exista
                val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE) //primeiro é o nome de arquivo e segundo o modo de abertura/acesso do arquivo

                // Criando uma referencia para o editor do arquivo
                val editPrefs = sharedPrefs.edit() //gera referencia para o editor do arquivo

                // Definindo as alterações do arquivo a serem enviados
                editPrefs.putString("NOME", nome)
                editPrefs.putString("SOBRENOME", sobrenome)
                editPrefs.putString("EMAIL", email)
                editPrefs.putString("SENHA", senha)
                editPrefs.putString("GENERO", genero)

                // Salvando as alterações no arquivo de SharedPreferences
                editPrefs.apply()

                // Abrir a tela MainActivity
                val mIntent = Intent(this, MainActivity::class.java)

                // Passando dados de uma Activity para outra utilizando a Intent
                mIntent.putExtra("INTENT_EMAIL", email) //nao precisa especificar o tipo de dado

                startActivity(mIntent)

                // Encerrando a atividade da tela atual e de todas as anteriores
                finishAffinity()
            }
        }


    }
}