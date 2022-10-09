package br.com.fernandosousa.lmsapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import br.com.fernandosousa.lmsapp.databinding.LoginBinding

class MainActivity : DebugActivity() {

    private val context: Context get() = this

    private val binding by lazy {
        LoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // encontra objeto pelo id
        binding.campoImagem.setImageResource(R.drawable.imagem_login)

        binding.textoLogin.text = getString(R.string.mensagem_login)

        // evento no botao de login forma 1
//        botao_login.setOnClickListener {
//            val valorUsuario = campo_usuario.text.toString()
//            val valorSenha = campo_senha.text.toString()
//            Toast.makeText(this, "$valorUsuario : $valorSenha", Toast.LENGTH_LONG).show()
//        }

        // segunda forma: delegar para método
        binding.botaoLogin.setOnClickListener { onClickLogin() }

        binding.progressBar.visibility = View.INVISIBLE

        // procurar pelas preferências, se pediu para guardar usuário e senha
        var lembrar = Prefs.getBoolean("lembrar")
        if (lembrar) {
            var lembrarNome = Prefs.getString("lembrarNome")
            var lembrarSenha = Prefs.getString("lembrarSenha")
            binding.textoLogin.setText(lembrarNome)
            binding.textoSenha.setText(lembrarSenha)
            binding.checkBoxLogin.isChecked = lembrar
        }
    }

    fun onClickLogin() {

        val valorUsuario = binding.campoUsuario.text.toString()
        val valorSenha = binding.campoSenha.text.toString()

        // armazenar valor do checkbox
        Prefs.setBoolean("lembrar", binding.checkBoxLogin.isChecked)
        // verificar se é para pembrar nome e senha
        if (binding.checkBoxLogin.isChecked) {
            Prefs.setString("lembrarNome", valorUsuario)
            Prefs.setString("lembrarSenha", valorSenha)
        } else {
            Prefs.setString("lembrarNome", "")
            Prefs.setString("lembrarSenha", "")
        }

        // criar intent
        val intent = Intent(context, TelaInicialActivity::class.java)
        // colocar parâmetros (opcional)
        val params = Bundle()
        params.putString("nome", "Fernando Sousa")
        intent.putExtras(params)

        // enviar parâmetros simplificado
        intent.putExtra("numero", 10)

        // fazer a chamada
        //startActivity(intent)

        // fazer a chamada esperando resultado
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            val result = data?.getStringExtra("result")
            Toast.makeText(context, "$result", Toast.LENGTH_LONG).show()
        }
    }
}
