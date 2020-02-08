pipeline {
    agent any

    stages {
        stage('Stage 1') {
            steps {
                echo 'Hello world!' 
		checkout scm	    
		//checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'MyGit', url: 'https://github.com/antman25/PipelineTesting.git']]])
            }
        }
    }
}

