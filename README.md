# 📚 Condado - Sistema de Livraria

Este repositório contém o **Condado**, um sistema de gerenciamento de livraria desenvolvido integralmente em **Java**. O projeto foi desenhado para gerenciar operações comuns do domínio de uma livraria, com uma interface gráfica moderna e interativa construída utilizando **JavaFX**.

## 🛠️ Tecnologias e Arquitetura

O projeto adota um ecossistema Java maduro para garantir organização e facilidade de execução:

*   **Java:** Linguagem principal para a lógica de negócio e estruturação orientada a objetos.
*   **JavaFX & CSS:** Utilizados para a construção e estilização da Interface Gráfica do Usuário (GUI), separando a lógica visual do código backend.
*   **Maven:** Ferramenta de build e gerenciamento de dependências (configurado via `pom.xml`). O uso do *Maven Wrapper* (`mvnw`) garante que qualquer pessoa possa compilar o projeto sem precisar instalar o Maven globalmente.

## ✨ Funcionalidades Principais

Com base nas atualizações recentes do sistema, as operações principais englobam:
*   Gerenciamento completo do acervo da livraria.
*   Controle e cadastro de clientes (incluindo tratamento seguro para exclusão de registros).
*   Aplicação de restrições e validações de regras de negócio diretamente no código, garantindo a integridade dos dados manipulados.

## 🚀 Como Compilar e Executar

Como o projeto utiliza o Maven Wrapper, rodar a aplicação em qualquer ambiente é um processo direto. 

### Pré-requisitos
*   **JDK 11 ou superior** instalado e configurado nas variáveis de ambiente (`JAVA_HOME`).
