# Sistema de Ocorrências - Smart City

## 📋 Descrição

O **Sistema de Ocorrências - Smart City** é uma aplicação Java desenvolvida para gerenciar relatos de problemas de infraestrutura urbana. O sistema permite aos cidadãos cadastrar e acompanhar ocorrências relacionadas a buracos nas vias, problemas de iluminação, lixo irregular e semáforos com defeito, contribuindo para a construção de cidades mais inteligentes e sustentáveis.

## 🎯 Objetivos

- Facilitar o cadastro de relatos de problemas de infraestrutura urbana
- Fornecer uma interface gráfica intuitiva para cidadãos e gestores
- Implementar padrões de projeto para demonstrar boas práticas de desenvolvimento
- Contribuir para a melhoria da qualidade de vida urbana através da tecnologia

## 🏗️ Arquitetura do Sistema

### Padrões de Projeto Implementados

O projeto demonstra a implementação de **4 padrões de projeto fundamentais**:

#### 1. **Singleton**
- **Classe:** `RelatoInstance`
- **Propósito:** Garantir uma única instância para contabilizar relatos por tipo
- **Localização:** `src/model/designPatterns/RelatoInstance.java`

#### 2. **Factory (Abstract Factory)**
- **Classes:** `AbstractRelatoFactory`, `Fabrica`, e fábricas específicas
- **Propósito:** Centralizar a criação de objetos de relatos
- **Localização:** `src/model/fabrica/`

#### 3. **Prototype**
- **Implementação:** Método `Clone()` em todas as entidades
- **Propósito:** Criar cópias de objetos existentes para novos relatos
- **Localização:** Todas as classes de entidade em `src/model/entities/`

#### 4. **Observer**
- **Classes:** `VerificaIluminacao`, `Verificalixo`
- **Propósito:** Notificar mudanças automáticas nos relatos
- **Localização:** `src/model/behavior/`

### Estrutura de Diretórios

```
SistemaDeOcorrencias/
├── src/
│   ├── App/
│   │   └── App.java                 # Classe principal com interface gráfica
│   └── model/
│       ├── behavior/                # Implementações do padrão Observer
│       │   ├── VerificaIluminacao.java
│       │   └── Verificalixo.java
│       ├── designPatterns/          # Implementação do Singleton
│       │   └── RelatoInstance.java
│       ├── entities/                # Entidades do sistema
│       │   ├── Relatos.java         # Classe abstrata base
│       │   ├── BuracoVia.java
│       │   ├── IluminacaoRuim.java
│       │   ├── LixoIrregular.java
│       │   └── SemaforoProblema.java
│       ├── fabrica/                 # Implementação do padrão Factory
│       │   ├── AbstractRelatoFactory.java
│       │   ├── Fabrica.java
│       │   └── factories/
│       │       ├── BuracoViaFactory.java
│       │       ├── IluminacaoRuimFactory.java
│       │       ├── LixoIrregularFactory.java
│       │       └── SemaforoProblemaFactory.java
│       └── util/
│           └── exception/
│               └── ExcecoesPersonalizadas.java
├── bin/                             # Arquivos compilados
└── README.md
```

## 🚀 Como Executar

### Pré-requisitos
- Java JDK 8 ou superior
- IDE Java (Eclipse, IntelliJ IDEA, VS Code, etc.)

### Passos para Execução

1. **Clone o repositório:**
   ```bash
   git clone [URL_DO_REPOSITORIO]
   cd SistemaDeOcorrencias
   ```

2. **Compile o projeto:**
   ```bash
   javac -d bin src/**/*.java
   ```

3. **Execute a aplicação:**
   ```bash
   java -cp bin App.App
   ```

### Execução via IDE
1. Abra o projeto na sua IDE preferida
2. Localize a classe `App.java` em `src/App/`
3. Execute a classe `App`

## 💻 Funcionalidades

### Interface Gráfica
- **Aba de Cadastro:** Formulário dinâmico para cadastrar relatos
- **Aba de Listagem:** Tabela com todos os relatos cadastrados
- **Contagem de Relatos:** Estatísticas por tipo de ocorrência

### Tipos de Relatos Suportados
1. **Buraco na Via**
   - Descrição, data, endereço, cidade, nível de preocupação

2. **Iluminação Ruim**
   - Campos básicos + quantidade de lâmpadas queimadas, nível de iluminação

3. **Lixo Irregular**
   - Campos básicos + tipo de lixo, quantidade

4. **Semáforo com Problema**
   - Campos básicos + tipo de problema

### Persistência de Dados
- **Formato:** CSV (Comma-Separated Values)
- **Arquivo:** `relatos.csv`
- **Funcionalidade:** Salvamento automático e carregamento ao iniciar

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 8+
- **Interface Gráfica:** Java Swing
- **Padrões de Projeto:** Singleton, Factory, Prototype, Observer
- **Persistência:** Arquivo CSV
- **IDE Recomendada:** Eclipse, IntelliJ IDEA ou VS Code

## 📊 Características Técnicas

### Validações Implementadas
- Campos obrigatórios com tamanho mínimo
- Níveis de preocupação entre 1 e 10
- Validação de quantidade de lâmpadas e nível de iluminação
- Verificação de tipos de lixo e problemas de semáforo

### Tratamento de Exceções
- Exceções personalizadas para validações
- Tratamento de erros de entrada/saída
- Mensagens de erro amigáveis ao usuário

## 👥 Desenvolvedores

**Equipe de Desenvolvimento - UFG**

- **Carlos Gabriel Braga**
  - Estudante de Ciência da Computação
  - Universidade Federal de Goiás (UFG)

- **Leonardo Amichi**
  - Estudante de Ciência da Computação
  - Universidade Federal de Goiás (UFG)

- **João Frederico Xavier**
  - Estudante de Ciência da Computação
  - Universidade Federal de Goiás (UFG)

## 📝 Licença

Este projeto foi desenvolvido como parte do curso de **Programação Orientada a Objetos** na Universidade Federal de Goiás.

## 🤝 Contribuições

Este é um projeto acadêmico desenvolvido para demonstrar a implementação de padrões de projeto em Java. Contribuições são bem-vindas através de issues e pull requests.

## 📞 Contato

Para dúvidas ou sugestões sobre o projeto, entre em contato através dos canais da UFG ou abra uma issue neste repositório.

---
