# 💸 HexaPay

API desenvolvida em **Spring Boot** utilizando **Arquitetura Hexagonal (Ports & Adapters)**, com o objetivo de calcular o **valor atualizado de boletos bancários vencidos** aplicando **juros proporcionais** conforme dias de atraso.  

O projeto integra-se a uma **API de Boletos externa** para obter as informações originais e armazena todos os cálculos realizados em um **banco de dados MySQL**, garantindo rastreabilidade e histórico.

---

## 📘 Descrição do Problema

**ENQUANTO** usuário da API  
**QUERO** digitar o código de um boleto vencido  
**PARA** receber o valor atualizado com juros proporcionais ao tempo de atraso.

---

## ✅ Requisitos Funcionais

- A aplicação deve expor uma **API REST** para cálculo de juros.
- O usuário deve informar um **código de boleto válido** e uma **data de pagamento**.
- O cálculo só é permitido para **boletos do tipo XPTO**.
- Caso o boleto esteja **vencido**, o sistema deverá calcular o **valor final** com juros.
- As informações do boleto serão obtidas via **API de Boletos** (consumida com Feign Client).
- Em caso de erro, a API deve retornar o **motivo do erro** (ex: boleto não encontrado, tipo inválido, não vencido, etc).
- Todos os cálculos realizados devem ser **persistidos em banco de dados**.

---

## 🧮 Regra de Cálculo dos Juros

A definição dos juros ocorre considerando os **dias de atraso**, de forma **proporcional**.

- Taxa de juros: **1% ao mês**
- Equivalente diário: **1 / 30 = 0,033% ao dia**
- Fórmula: valor_final = valor_original + (valor_original * (0,001 / 30) * dias_atraso)

### 🧾 Exemplo de Cálculo

| Campo | Valor |
|-------|-------|
| Valor original | R$ 100,00 |
| Vencimento | 2025-10-01 |
| Pagamento | 2025-10-11 |
| Dias de atraso | 10 |
| Juros diário | 0,033% |
| **Valor final** | R$ 100,33 |

---

## 📤 Estrutura da Requisição

### Request
```json
POST /api/v1/juros
{
"codigo": "12345678900",
"data_pagamento": "2025-10-11 10:00:00"
}
```

### Response
```json
{
  "codigo": "12345678900",
  "data_vencimento": "2025-10-01",
  "valor": 100.33,
  "tipo": "XPTO"
}
```

🧱 Arquitetura Hexagonal (Ports & Adapters)

A aplicação segue os princípios da Arquitetura Hexagonal, garantindo baixo acoplamento, testabilidade e facilidade de manutenção.

┌──────────────────────────────────────────────┐
│                  HexaPay                     │
│──────────────────────────────────────────────│
│                                              │
│   🔸 Domain Layer                            │
│     - Entidades (Boleto, Juros, etc.)        │
│     - Casos de uso (CalcularJurosService)    │
│                                              │
│   🔸 Application Layer                       │
│     - Ports (interfaces)                     │
│     - DTOs / Mapeamentos (MapStruct)         │
│                                              │
│   🔸 Adapters                                │
│     - Inbound (Controllers REST)             │
│     - Outbound (Feign Client API Boletos)    │
│     - Outbound (JPA Repository / MySQL)      │
│                                              │
└──────────────────────────────────────────────┘

⚙️ Stack Técnica
Ferramenta	Função
Java 17+	Linguagem principal
Spring Boot	Framework principal
Spring Data JPA	Persistência
Feign Client	Comunicação com API de Boletos
MapStruct	Mapeamento de DTOs
MySQL	Banco de dados relacional
Swagger / OpenAPI	Documentação da API
Docker / Docker Compose	Containerização e orquestração
IntelliJ IDEA	IDE de desenvolvimento

🐳 Executando com Docker
Pré-requisitos
Docker
Docker Compose

Passos
# 1️⃣ Clonar o repositório
git clone https://github.com/felipematheus1337/HexaPay.git
cd HexaPay

# 2️⃣ Subir containers
docker-compose up --build

# 3️⃣ Acessar aplicação
http://localhost:8080/swagger-ui.html

🧩 Estrutura de Pastas (sugerida)
src/
 └── main/
      ├── java/com/hexapay/
      │     ├── domain/              # Entidades e lógica de negócio
      │     ├── application/         # Ports (interfaces) e DTOs
      │     ├── infrastructure/      # Adapters externos (JPA, Feign)
      │     └── api/                 # Controllers REST (adapters inbound)
      └── resources/
            ├── application.yml
            └── db/migration/        # Scripts Flyway (opcional)

🔍 Exemplo de Fluxo

### O cliente realiza um POST com o código do boleto e a data de pagamento.

### O controller (adapter inbound) recebe a requisição e aciona o caso de uso de cálculo de juros.

### O serviço de domínio consulta a API de Boletos (adapter outbound) via Feign Client.

### Caso o boleto seja do tipo XPTO e esteja vencido, é feito o cálculo proporcional.

### O resultado é persistido no banco de dados via JPA Repository.

### A API retorna o valor atualizado ao cliente.

🧠 Conceitos Envolvidos

Arquitetura Hexagonal (Ports & Adapters)

DDD (Domain-Driven Design)

Isolamento da lógica de negócio

Integração externa desacoplada

Testes de unidade e integração independentes

🧑‍💻 Autor

Nome: Felipe Matheus
GitHub: @felipematheus1337

📄 Licença

Este projeto está sob a licença MIT — veja o arquivo LICENSE
 para mais detalhes.
