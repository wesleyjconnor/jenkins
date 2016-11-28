
node {
    
    timestamps {
        // install Maven and add it to the path
        env.PATH = "${tool 'maven-3'}/bin:${env.PATH}"


        stage('Preparation') {
            git credentialsId: 'my-id', url: 'repo.git'
        }

        stage('Build') {
	        configFileProvider([configFile(fileId: 'settings-xml-global', variable: 'MAVEN_SETTINGS')]) {
                sh "mvn -s $MAVEN_SETTINGS clean install -DskipTests"
            }
        }
        stage('test') {
	        configFileProvider([configFile(fileId: 'settings-xml-global', variable: 'MAVEN_SETTINGS')]) {
                sh "mvn -s $MAVEN_SETTINGS clean test"
            }
        }
        def sonarCmd = "sonar:sonar"
        if(env.BRANCH_NAME == "develop"){
            sonarCmd = "sonar:sonar: -branch=develop"
        }
        stage('sonar') {
	        configFileProvider([configFile(fileId: 'settings-xml-global', variable: 'MAVEN_SETTINGS')]) {
                sh "mvn -s $MAVEN_SETTINGS clean ${sonarCmd}"
            }
        }
        if(env.BRANCH_NAME == "develop"){
            stage('deploy') {
                    sh "echo now i would deploy"
            }
        }
    }
}
