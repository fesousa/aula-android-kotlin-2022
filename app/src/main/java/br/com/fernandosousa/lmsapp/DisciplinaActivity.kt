package br.com.fernandosousa.lmsapp

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView
import br.com.fernandosousa.lmsapp.databinding.ActivityDisciplinaBinding

import com.squareup.picasso.Picasso


class DisciplinaActivity : DebugActivity() {

    private val binding by lazy {
        ActivityDisciplinaBinding.inflate(layoutInflater)
    }

    var disciplina: Disciplina? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // recuperar onjeto de Disciplina da Intent
        disciplina = intent.getSerializableExtra("disciplina") as Disciplina

        // configurar título com nome da Disciplina e botão de voltar da Toobar
        // colocar toolbar
        setSupportActionBar(binding.toolbarInclude.toolbar)

        // alterar título da ActionBar
        supportActionBar?.title = disciplina?.nome

        // up navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // atualizar dados da disciplina
        binding.nomeDisciplina.text = disciplina?.nome
        Picasso.with(this).load(disciplina?.foto).fit().into(binding.imagemDisciplina,
                object: com.squareup.picasso.Callback{
                    override fun onSuccess() {}

                    override fun onError() { }
                })
    }
}
