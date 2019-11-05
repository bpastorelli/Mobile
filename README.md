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

# Comandos para execução no App Center

Compilar o projeto:
C:\repositorio_local\Mobile>mvn -DskipTests -P prepare-for-upload package

Executar os testes:

C:\repositorio_local\Mobile>appcenter test run appium --app "bpastorelli/appCenter" --devices "bpastorelli/samsunga7" --app-path C:\repositorio_local\Mobile\src\test\resources\apk\ml.apk --test-series "master" --locale "en_US" --build-dir target/upload

# HTML Reporter
Para habilitar o CSS no HTML Reporter, execute o comando abaixo em Manage Jenkins >> Script Console >> Run

System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "")

# Configurando o build no Jenkins

1) Em "Build Enviroment" marque a opção "Delete workspace before build starts";
2) Em "Build" selecione em "Add build step" a opção "Invoke top-level Maven targets" e em "Maven Version" selecione a versão do Maven;
3) No campo "Goals" insira o codigo abaixo:

clean
install
-Dtest=<ClasseTest>

A instrução acima irá: limpar o workpace, baixar o projeto e dependências e por fim chamar a classe de testes.




