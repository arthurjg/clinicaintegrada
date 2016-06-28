# README #

##################################################################################################################
#                                       Configurando o ambiente de desenvolvimento                               #
##################################################################################################################

**Requisitos:**

- JavaSE 8 (JRE1.8)                         http://www.oracle.com/technetwork/java/javase/downloads/index.html
- Eclipse IDE for Java EE Developer (Luna)  http://www.eclipse.org/downloads/
- Git                                       http://git-scm.com/downloads
- Maven                                     http://maven.apache.org/download.cgi 
- Wildfly 8.2                               http://wildfly.org/downloads/

-----------------------------------------------------------------------------------------------------------------

**Clone e configuração do projeto**

- Baixar/Clonar cada uma das aplicações para seu ambiente de execução com servidor JBoss/Wildfly instalado em 	localhost e porta 8080. 

- Instalar PostgreSql em localhost na porta 5432, usuário "postgres", senha "1234"  e criar base de dados com 	o nome sistema_a.

- Importar projetos para a IDE.

- Adicione as aplicações ao servidor e inicie o mesmo para a criação do esquema no banco.

- Executar script SQL no banco de dados do arquivo populaBanco.sql na pasta raiz do projeto Sistema A
  
--------------------------------------------------------------------------------------------------------------
---

**Configuração do DataSource**

- Copiar a pasta postgres com todo seu conteúdo, que está na pasta config na raiz do projeto Sistema A para 	"{caminhoInstalacaoServidor}\modules\system\layers\base\com"; 


- Incluir o trecho Datasource (tag datasource e seu conteúdo) do arquivo datasource.xml na pasta config na raiz projeto Sistema A dentro da tag datasources no arquivo de configuração do servidor – standalone.xml; 


 - Incluir o trecho Driver(tag driver e seu conteúdo) do arquivo datasouce.xml na pasta config na raiz projeto Sistema A dentro da tag drivers no arquivo de configuração do servidor – standalone.xml; 

