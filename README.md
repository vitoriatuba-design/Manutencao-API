# 🛠️ Manutenção API

Sistema de gerenciamento de ordens de serviço desenvolvido com Spring Boot.

---

## 📁 1. Estrutura do Projeto

O sistema foi implementado utilizando **Spring Boot** e **Maven**, dividindo o código nas seguintes camadas:

* **Controller:** Onde definimos os endpoints da nossa API.
* **Service:** Onde centralizamos a regra de negócio (cálculos de valores e validações).
* **DTO (Data Transfer Object):** Uso de *records* do Java para uma transferência de dados limpa e segura.
* **Model/Entity:** Entidades JPA que representam as tabelas do banco de dados.
* **Repository:** Interfaces para a comunicação automática com o banco de dados.

---

## 🚀 2. Como Rodar o Projeto

Para facilitar a correção, o projeto já está configurado para baixar todas as dependências automaticamente.

1. **Importar:** No IntelliJ, vá em `File > Open` e selecione a pasta `manutencao-api`.
2. **Sincronizar:** O IntelliJ deve reconhecer o arquivo `pom.xml`. Caso necessário, clique no ícone de "Reload" na aba do Maven para baixar as bibliotecas (incluindo o Swagger e o Lombok).
3. **Executar:** Abra a classe `ManutencaoApiApplication.java` e clique no botão de **Run**.

> 💡 **Nota:** O projeto utiliza o banco de dados H2 em memória, dispensando a configuração de um banco externo. Ele já sobe pronto para uso!

---

## 🧪 3. Como Testar (Interface Visual)

Para evitar o uso de terminais ou ferramentas externas, integramos o **Swagger (OpenAPI)**. Assim que o projeto estiver rodando, acesse a interface visual pelo link:

👉 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

Nesta página, você conseguirá:
* Visualizar todos os endpoints organizados por cores.
* Utilizar a opção **"Try it out"** para enviar dados e ver a resposta da API em tempo real.
* Testar a criação, listagem e conclusão de ordens de serviço de forma intuitiva.

### 📝 Passo a Passo dos Testes

#### 1. Criar uma Ordem de Serviço
* Procure pelo bloco azul **POST** `/api/ordens-servico`.
* Clique nele para expandir e depois no botão **Try it out**.
* No campo de texto, edite os dados do JSON (como `clienteNome`, `equipamentoDescricao`, etc.). As propriedades `id` e `data` são preenchidas automaticamente.
* Clique no botão azul **Execute** para ver o resultado formatado logo abaixo.

#### 2. Listar Ordens Criadas
* Procure pelo bloco verde **GET** `/api/ordens-servico`.
* Clique em **Try it out** e depois em **Execute**.
* A API retornará a lista com todas as ordens cadastradas.

#### 3. Concluir uma Ordem
* Procure pelo bloco **PATCH** `/api/ordens-servico/{id}/concluir`.
* Clique em **Try it out**, digite o `id` desejado (ex: `1`) e informe o valor do desconto.
* Clique em **Execute** e verifique a alteração do status para `CONCLUIDA`.
