import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.Period

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

enum class GrauFormacao {
    ENSINO_MEDIO_EM_ANDAMENTO,
    ENSINO_MEDIO_COMPLETO,
    ENSINO_MEDIO_INCOMPLETO,
    ENSINO_SUPERIOR_EM_ANDAMENTO,
    ENSINO_SUPERIOR_COMPLETO,
    ENSINO_SUPERIOR_INCOMPLETO
}

enum class Genero { FEMININO, MASCULINO, OUTROS, NAO_INFORMAR }

enum class Carreira {
    BACKEND_DEVELOPER,
    FRONTEND_DEVELOPER,
    MOBILE_DEVELOPER,
    DEVOPS_ENGINEER,
    DATA_ENGINEER,
    GAME_DEVELOPER
}

enum class Experiencia {
    SEM_EXPERIENCIA,
    DE_1_A_3_ANOS,
    DE_3_A_5_ANOS,
    MAIS_DE_5_ANOS
}

class Usuario (
    val nome: String,
    val email: String,
    val grauFormacao: GrauFormacao,
    val genero: Genero,
    val dataNascimento: LocalDate,
    val carreira: Carreira,
    val experiencia: Experiencia
) {
    fun calcularIdade(): Int {
        return Period.between(this.dataNascimento, LocalDate.now()).years
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("✅ Usuário ${usuario.nome} (${usuario.email}), matriculado na formação: $nome")
    }
}

fun main() {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")  
    
    
    
    // Criando formação
    // Podemos criar o conteudo dentro da lista de formacao
    val formacaoKotlin = Formacao(
        nome = "Formação Kotlin Developer",
        nivel = Nivel.INTERMEDIARIO,
        conteudos = listOf(
            ConteudoEducacional("Kotlin Básico"),
    		ConteudoEducacional("Programação Orientada a Objetos", 90),
    		ConteudoEducacional("Projetos práticos", 50)
        )
    )
    
    // Criando usuários
    val usuario1 = Usuario(
        nome = "Aliny",
        email = "aliny@example.com",
        grauFormacao = GrauFormacao.ENSINO_SUPERIOR_COMPLETO,
        genero = Genero.FEMININO,
        dataNascimento = LocalDate.of(1989, 5, 12), // forma direta
        carreira = Carreira.MOBILE_DEVELOPER,
        experiencia = Experiencia.DE_1_A_3_ANOS
    )
    val usuario2 = Usuario(
    	nome = "Rafael",
        email = "rafael@example.com",
        grauFormacao = GrauFormacao.ENSINO_MEDIO_COMPLETO,
        genero = Genero.MASCULINO,
        dataNascimento = LocalDate.parse("20/11/1995", formatter), // usando parse
        carreira = Carreira.GAME_DEVELOPER,
        experiencia = Experiencia.DE_1_A_3_ANOS
    )
    
    // Matriculando usuários
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    
    // Exibindo dados
    println("\n📚 Formação: ${formacaoKotlin.nome} (${formacaoKotlin.nivel})")
    println("Conteúdos: ${formacaoKotlin.conteudos.map { it.nome }}")
    println("👥 Inscritos:")
    formacaoKotlin.inscritos.forEach { aluno ->
        val idade = aluno.calcularIdade()
        val nascimento = aluno.dataNascimento.format(formatter)
        
        println("${aluno.nome} | Nascimento: $nascimento | Idade: $idade anos | Carreira: ${aluno.carreira}")
    }
}
