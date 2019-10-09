# Mobile
Projeto de automação mobile.

Plataforma suportada: Android

Para inicir o projeto é preciso paramatrizar os dados da APk no arquivo config.properties em src/test/resources.

A APK deve estar no diretório src/test/resources/apk.

Para Android é necessário baixar o SDK da versão do Android que deseja testar. O download de SDKs é feito pelo Android Studio.

# Instalação do Appium via linha de comando

Digite no Prompt Comando:

npm install -g appium

# Listar os dispositivos conectados

Digite no Prompt Comando:

adb devices -l

# Listar processos em aberto por porta

Digite no Prompt Comando:

netstat -ano | findstr <porta>

# Encerrar processo por PID (ID do processo)

Digite no Prompt Comando:

taskkill  /F  /PID  <PID>


