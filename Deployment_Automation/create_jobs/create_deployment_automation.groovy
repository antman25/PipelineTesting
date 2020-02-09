#!/usr/bin/env groovy
import groovy.json.JsonSlurper

//env.WORKSPACE = pwd()


String currentDir = new File(".").getAbsolutePath()
//String cfg_path = "${env.WORKSPACE}/"


println ("Current dir is ${currentDir}")
//println ("Config Path is ${cfg_path}")

//def inputFile = new File('.//MyConfig.json')
//def inputJSON = new JsonSlurper().parse(inputFile)
//def keys = inputJSON.keySet() as List

def project = 'antman25/PipelineTesting'
def branchApi = new URL("https://api.github.com/repos/${project}/branches")
def branches = new groovy.json.JsonSlurper().parse(branchApi.newReader())

jsonParse(readFile('Deployment_Automation/config/MyConfig.json')) 


inputJson.each { k, v ->
  println k
}


folder('Deployment Automation') {
    displayName('Deployment Automation')
    description('Deployment Automation - Desc')
}

branches.each {
    def branchName = it.name
    def jobName = "${branchName}".replaceAll('/','-')
    def jobPath = "Deployment Automation/" + jobName
    job(jobPath) {
        scm {
            git("git://github.com/${project}.git", branchName)
        }
        steps {
            print("test")
        }
    }
}

def jsonParse(text) {
        return new groovy.json.JsonSlurperClassic().parseText(text);
}
