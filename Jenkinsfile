pipeline {
    agent any 
    stages {
        stage('Stage 1') {
            steps {
                echo 'Hello world!' 
		checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'MyGit', url: 'https://github.com/antman25/PipelineTesting.git']]])
		def some_config = readJSON file: "${env.WORKSPACE}\\MyConfig.json"
		print (some_config)
            }
        }
    }
}

