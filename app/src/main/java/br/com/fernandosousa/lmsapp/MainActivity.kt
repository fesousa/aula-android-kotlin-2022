package br.com.fernandosousa.lmsapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import br.com.fernandosousa.lmsapp.databinding.LoginBinding


class MainActivity : DebugActivity() {

    private val binding by lazy {
        LoginBinding.inflate(layoutInflater)
    }
    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // encontra objeto pelo id
        binding.campoImagem.setImageResource(R.drawable.imagem_login)

        binding.textoLogin.text = getString(R.string.mensagem_login)

        // evento no botao de login forma 1
//        botaoLogin.setOnClickListener {
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
        //Toast.makeText(context, "$valorUsuario : $valorSenha", Toast.LENGTH_LONG).show()

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
