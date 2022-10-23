package br.com.fernandosousa.lmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fernandosousa.lmsapp.databinding.ActivityCadastroDisciplinaBinding

class DisciplinaCadastroActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCadastroDisciplinaBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setTitle("Nova Disciplina")

        binding.salvarDisciplina.setOnClickListener {
            val disciplina = Disciplina()
            disciplina.nome = binding.nomeDisciplina.text.toString()
            disciplina.ementa = binding.ementaDisciplina.text.toString()
            disciplina.professor = binding.professorDisciplina.text.toString()
            disciplina.foto = binding.urlFoto.text.toString()

            taskAtualizar(disciplina)
        }
    }

    private fun taskAtualizar(disciplina: Disciplina) {
        // Thread para salvar a discilpina
        Thread {
            DisciplinaService.save(disciplina)
            runOnUiThread {
                // após cadastrar, voltar para activity anterior
                finish()
            }
        }.start()
    }
}
