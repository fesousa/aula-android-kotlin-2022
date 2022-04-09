package br.com.fernandosousa.lmsapp

import android.content.Context

object DisciplinaService {

    fun getDisciplinas (context: Context): List<Disciplina> {
        val disciplinas = mutableListOf<Disciplina>()

        // criar 10 disciplinas
        for (i in 1..10) {
            val d = Disciplina()
            d.nome = "Disciplina $i"
            d.ementa = "Ementa Disciplina $i"
            d.professor = "Professor Disciplina $i"
            d.foto = "https://cdn.pixabay.com/photo/2018/01/18/20/42/pencil-3091204_1280.jpg"
            disciplinas.add(d)
        }

        return disciplinas
    }

}