# LoginAppCom

## Visão Geral

LoginAppCom é um aplicativo Android de exemplo que implementa autenticação de usuário usando Firebase Authentication e Jetpack Compose. O aplicativo permite que os usuários se registrem, façam login e logout de suas contas.

## Funcionalidades

- Registro de Usuário
- Login de Usuário
- Logout de Usuário
- Interface de Usuário Moderna usando Jetpack Compose

## Tecnologias Utilizadas

- [Firebase Authentication](https://firebase.google.com/docs/auth)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Kotlin](https://kotlinlang.org/)
- [Android Studio](https://developer.android.com/studio)

## Pré-requisitos

- [Android Studio](https://developer.android.com/studio) 4.2 ou superior
- Conta no [Firebase Console](https://console.firebase.google.com/)

## Configuração Inicial

1. Clone este repositório:
    ```bash
    git clone https://github.com/JOSEEUSTAQUIOSILVERI0/LoginAppCom.git
    ```

2. Abra o projeto no Android Studio.

3. Configure o Firebase no seu projeto:
    - Vá para o [Firebase Console](https://console.firebase.google.com/).
    - Crie um novo projeto ou selecione um projeto existente.
    - Adicione um novo aplicativo Android ao projeto Firebase.
    - Baixe o arquivo `google-services.json` e coloque-o na pasta `app` do seu projeto.

4. Adicione as dependências do Firebase no seu arquivo `build.gradle (Project Level)`:
    ```gradle
    buildscript {
        repositories {
            // Outras dependências
            google()
        }
        dependencies {
            // Outras dependências
            classpath 'com.google.gms:google-services:4.3.10'
        }
    }
    ```

5. Adicione o plugin do Google Services no arquivo `build.gradle (Module Level)`:
    ```gradle
    plugins {
        id 'com.android.application'
        id 'org.jetbrains.kotlin.android'
        id 'com.google.gms.google-services'
    }

    android {
        // Configurações do Android
    }

    dependencies {
        // Dependências do projeto
        implementation platform('com.google.firebase:firebase-bom:28.4.0')
        implementation 'com.google.firebase:firebase-auth-ktx'
    }
    ```

6. Sincronize o projeto com os arquivos Gradle.

## Estrutura do Projeto

- `MainActivity.kt` - A atividade principal que gerencia a navegação e a autenticação do usuário.
- `LoginScreen.kt` - Tela de login para os usuários existentes.
- `RegisterScreen.kt` - Tela de registro para novos usuários.
- `HomeScreen.kt` - Tela inicial exibida após um login bem-sucedido.

## Executando o Projeto

1. Conecte um dispositivo Android ou inicie um emulador.
2. Clique em **Run** no Android Studio para compilar e executar o aplicativo.

## Problemas Conhecidos

- Certifique-se de que as dependências do Firebase estão corretamente configuradas no arquivo `build.gradle`.
- Verifique se o arquivo `google-services.json` está no local correto (`app`).

## Contribuição

Sinta-se à vontade para contribuir com este projeto. Você pode abrir issues e pull requests no repositório do GitHub.

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.
