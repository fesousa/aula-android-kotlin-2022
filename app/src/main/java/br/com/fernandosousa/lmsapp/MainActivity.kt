package br.com.fernandosousa.lmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import br.com.fernandosousa.lmsapp.databinding.LoginBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        LoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        // encontra objeto pelo id
        binding.campoImagem.setImageResource(R.drawable.imagem_login)
//
//
        binding.textoLogin.text = getString(R.string.mensagem_login)

        // evento no botao de login forma 1
//        botao_login.setOnClickListener {
//            val valorUsuario = campo_usuario.text.toString()
//            val valorSenha = campo_senha.text.toString()
//            Toast.makeText(this, "$valorUsuario : $valorSenha", Toast.LENGTH_LONG).show()
//        }

        // segunda forma: delegar para método
        binding.botaoLogin.setOnClickListener {onClickLogin() }

    }

    fun onClickLogin(){
        val valorUsuario = binding.campoUsuario.text.toString()
        val valorSenha = binding.campoSenha.text.toString()
        Toast.makeText(this, "$valorUsuario : $valorSenha", Toast.LENGTH_LONG).show()
    }
}
