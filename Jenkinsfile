pipeline {
agent any
    def selectedProperty = input( id: 'userInput', message: 'Choose properties file', parameters: [ [$class: 'ChoiceParameterDefinition', choices: inputParams, description: 'Properties', name: 'prop'] ])

    println "Property: $selectedProperty"

    // Change `job` value to your downstream job name
    // Change `name` value to the name you gave the string parameter in your downstream job
    build job: 'downstream-freestyle', parameters: [[$class: 'StringParameterValue', name: 'prop', value: selectedProperty]]
    parameters {
        string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')

        text(name: 'BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')

        booleanParam(name: 'TOGGLE', defaultValue: true, description: 'Toggle this value')

        choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')

        password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a password')
    }
    stages {
        stage('Stage 1') {
            steps {
                echo 'Hello world!' 
		//checkout scm	    
		//checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'MyGit', url: 'https://github.com/antman25/PipelineTesting.git']]])
            }
        }
    }
}

