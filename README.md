# Calculadora IMC

## Descrição
A **Calculadora IMC** é um aplicativo Android desenvolvido em Java que calcula o Índice de Massa Corporal (IMC) do usuário e fornece um feedback personalizado e motivacional com base na categoria do IMC (Abaixo do Peso, Peso Normal, Sobrepeso, Obesidade Grau 1, 2 e 3).

## Tecnologias Utilizadas
- **Linguagem:** Java
- **Plataforma:** Android
- **IDE:** Android Studio

## Funcionalidades
- Tela principal com logo e botão para acessar a calculadora.
- Tela para inserção dos dados (peso em kg e altura em metros).
- Cálculo do IMC utilizando a fórmula:  
  `IMC = peso / (altura * altura)`
- Redirecionamento para uma Activity de feedback correspondente à categoria:
  - Abaixo do Peso
  - Peso Normal
  - Sobrepeso
  - Obesidade Grau 1
  - Obesidade Grau 2
  - Obesidade Grau 3
- Exibição de informações (peso, altura, IMC e classificação) e mensagem motivacional.
- Layouts com design simples e centralizado, utilizando a seguinte paleta de cores:
  - Verde Escuro: #006341
  - Verde Claro: #00A859
  - Cinza Escuro: #4D4D4D
  - Cinza Claro: #B3B3B3
  - Branco: #FFFFFF

## Instalação e Execução
1. **Clonar o Repositório:**
   ```bash
   git clone https://github.com/guilhermylg/CalculadoraIMC.git
## Estrutura do Projeto
CalculadoraIMC/ ├── app/ │ ├── src/ │ │ └── main/ │ │ ├── java/com/guilhermylg/calculadoraimc/ │ │ │ ├── MainActivity.java │ │ │ ├── CalculoIMCActivity.java │ │ │ ├── AbaixoDoPesoActivity.java │ │ │ ├── PesoNormalActivity.java │ │ │ ├── SobrepesoActivity.java │ │ │ ├── Obesidade1Activity.java │ │ │ ├── Obesidade2Activity.java │ │ │ └── Obesidade3Activity.java │ │ ├── res/ │ │ │ ├── layout/ # Arquivos XML dos layouts │ │ │ ├── values/ # strings.xml, colors.xml, etc. │ │ │ └── drawable/ # Imagens utilizadas │ │ └── AndroidManifest.xml └── README.md
