# Aprenda Kotlin Com Exemplos: Desafio de Projeto (Lab)

Desafio de Projeto criado para avaliação do conteúdo técnico explorado no repositório [aprenda-kotlin-com-exemplos](https://github.com/digitalinnovationone/aprenda-kotlin-com-exemplos). **Nesse contexto, iremos abstrair o seguinte domínio de aplicação:**

**A [DIO](https://web.dio.me) possui `Formacoes` incríveis que têm como objetivo oferecer um conjunto de `ConteudosEducacionais` voltados para uma stack tecnológica específica, preparando profissionais de TI para o mercado de trabalho. `Formacoes` possuem algumas características importantes, como `nome`, `nivel` e seus respectivos `conteudosEducacionais`. Além disso, tais experiências educacionais têm um comportamento relevante ao nosso domínio, definido pela capacidade de `matricular` um ou mais `Alunos`.**

---

## 🚀 Minha Resolução - Objetivos

A ideia é **abstrair o domínio de formações educacionais da DIO**, permitindo que **usuários (alunos)** possam se matricular em **formações** compostas por diversos **conteúdos educacionais**.  
Durante o processo de matrícula, são coletadas informações relevantes sobre o aluno, como:

- Nome e E-mail  
- Grau de Formação  
- Gênero  
- Data de Nascimento  
- Tipo de Carreira desejada  
- Tempo de Experiência na área  

---

## 🛠️ Tecnologias Utilizadas

- **Kotlin** → linguagem principal do projeto  
- **Paradigma Orientado a Objetos (POO)** → uso de classes, data classes, enums e métodos  
- **Coleções Kotlin** → `List` e `MutableList`  
- **LocalDate** → manipulação de datas  

---

## 📌 Estrutura do Projeto

### Classes e Enums

- **Usuario** → Representa o aluno com seus dados pessoais e acadêmicos.  
- **Formacao** → Representa uma formação (bootcamp/curso) da DIO.  
- **ConteudoEducacional** → Representa os conteúdos que compõem uma formação.  
- **Nivel** → Enum que define o nível da formação (BÁSICO, INTERMEDIÁRIO, DIFÍCIL).  
- **GrauFormacao** → Enum para escolaridade.  
- **Genero** → Enum para gênero.  
- **Carreira** → Enum para carreira desejada.  
- **Experiencia** → Enum para tempo de experiência.  

---

## 📊 UML Simplificado

📌 Relacionamentos

- `Formacao` tem conteudos: `List<ConteudoEducacional>`.

- `Formacao` tem inscritos: `List<Usuario>`.

- `Usuario` usa os enums `GrauFormacao`, `Genero`, `Carreira` e `Experiencia`.

```plaintext
+----------------------------------+
|            Usuario               |
+----------------------------------+
| - nome: String                   |
| - email: String                  |
| - grauFormacao: GrauFormacao     |
| - genero: Genero                 |
| - dataNascimento: LocalDate      |
| - carreira: Carreira             |
| - experiencia: Experiencia       |
+----------------------------------+
| + calcularIdade(): Int           |
+----------------------------------+

+----------------------------------+
|       ConteudoEducacional        |
+----------------------------------+
| - nome: String                   |
| - duracao: Int                   |
+----------------------------------+

+----------------------------------+
|            Formacao              |
+----------------------------------+
| - nome: String                   |
| - nivel: Nivel                   |
| - conteudos: List<ConteudoEducacional> |
| - inscritos: MutableList<Usuario>|
+----------------------------------+
| + matricular(usuario: Usuario)   |
+----------------------------------+

+-------------------+
|       Nivel       |
+-------------------+
| BASICO            |
| INTERMEDIARIO     |
| DIFICIL           |
+-------------------+

+-------------------+
|   GrauFormacao    |
+-------------------+
| ENSINO_MEDIO_ANDAMENTO   |
| ENSINO_MEDIO_INCOMPLETO  |
| ENSINO_MEDIO_COMPLETO    |
| ENSINO_SUPERIOR_ANDAMENTO|
| ENSINO_SUPERIOR_COMPLETO |
| ENSINO_SUPERIOR_INCOMPLETO|
+-------------------+

+-------------------+
|      Genero       |
+-------------------+
| FEMININO          |
| MASCULINO         |
| OUTROS            |
| NAO_INFORMAR      |
+-------------------+

+-------------------+
|      Carreira     |
+-------------------+
| BACKEND_DEVELOPER |
| FRONTEND_DEVELOPER|
| MOBILE_DEVELOPER  |
| DEVOPS_ENGINEER   |
| DATA_ENGINEER     |
| GAME_DEVELOPER    |
+-------------------+

+-------------------+
|   Experiencia     |
+-------------------+
| SEM_EXPERIENCIA   |
| DE_1_A_3_ANOS     |
| DE_3_A_5_ANOS     |
| MAIS_DE_5_ANOS    |
+-------------------+
```

---

## ▶️ Como Executar

1. Clone o repositório:

`git clone https://github.com/seu-usuario/nome-do-repositorio.git`

2. Abra o projeto no IntelliJ IDEA ou outra IDE com suporte a Kotlin.

3. Compile e execute o arquivo `Main.kt`.

---

## 🧪 Exemplos de Uso

```kotlin
fun main() {
    val usuario = Usuario(
        nome = "Maria Souza",
        email = "maria@email.com",
        grauFormacao = GrauFormacao.ENSINO_SUPERIOR_COMPLETO,
        genero = Genero.FEMININO,
        dataNascimento = LocalDate.of(1995, 5, 12),
        carreira = Carreira.BACKEND_DEVELOPER,
        experiencia = Experiencia.DE_1_A_3_ANOS
    )

    val conteudo1 = ConteudoEducacional("Kotlin Básico", 90)
    val conteudo2 = ConteudoEducacional("POO com Kotlin", 120)

    val formacao = Formacao(
        nome = "Formação Kotlin Developer",
        nivel = Nivel.INTERMEDIARIO,
        conteudos = listOf(conteudo1, conteudo2)
    )

    formacao.matricular(usuario)
}
```

---

## 📄 Licença

Este projeto é de uso educacional, desenvolvido para estudos de Kotlin e POO.
Sinta-se à vontade para clonar, modificar e compartilhar! 🚀
