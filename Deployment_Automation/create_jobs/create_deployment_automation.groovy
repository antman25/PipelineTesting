#!/usr/bin/env groovy
import groovy.json.JsonSlurper

//env.WORKSPACE = pwd()

println new ProcessBuilder('sh','-c',' git rev-parse --show-toplevel').redirectErrorStream(true).start().text

//def myVar = build.getBuildVariables().get('myVar')
println ("Workspace = ${env.WORKSPACE}")

String currentDir = new File(".").getAbsolutePath()
//String cfg_path = "${env.WORKSPACE}/"


println ("Current dir is ${currentDir}")
//println ("Config Path is ${cfg_path}")

println ("BASE = ${JOB_NAME}")

//def inputFile = new File('.//MyConfig.json')
//def inputJSON = new JsonSlurper().parse(inputFile)
//def keys = inputJSON.keySet() as List

def project = 'antman25/PipelineTesting'
def branchApi = new URL("https://api.github.com/repos/${project}/branches")
def branches = new groovy.json.JsonSlurper().parse(branchApi.newReader())

//jsonParse(readFile('Deployment_Automation/config/MyConfig.json')) 
def cfg_data = readFileFromWorkspace('Deployment_Automation/config/MyConfig.json')
print (cfg_data)

def inputJson = new JsonSlurper().parseText(cfg_data)
def keys = inputJson.keySet() as List

inputJson.each { k, v ->
  println k
}

println (keys)


folder('Deployment Automation') {
    displayName('Deployment Automation')
    description('Deployment Automation - Desc')
}

/*folder('RemoveTestA') {
    displayName('Deployment Automation RemoveTestA')
    description('Deployment Automation - Desc')
}*/

branches.each {
    def branchName = it.name
    def jobName = "${branchName}".replaceAll('/','-')
    def jobPath = "Deployment Automation/" + jobName
    job(jobPath) {
        parameters {
            booleanParam('FLAG', true)
            choiceParam('OPTION', keys)
        }

        scm {
            git("git://github.com/${project}.git", branchName)
        }
        steps {
            println(" why print this test")
        }
    }
}

pipelineJob('DSL_Pipeline') {

  def repo = 'https://github.com/antman25/PipelineTesting.git'

  //triggers {
  //  scm('H/5 * * * *')
  //}
  description("Pipeline for $repo")
  
  environmentVariables {
        script("GIT_ROOT_DIR=`git rev-parse --show-toplevel`")
    }

  definition {
    cpsScm {
      scm {
        git {
          remote { 
              url(repo)
              credentials('MyGit') 
          }
          branch('master')
          scriptPath('Deployment_Automation/HelperJobs/HelperJob1/Jenkinsfile')
          extensions { }  // required as otherwise it may try to tag the repo, which you may not want
        }

      }
    }
  }
}

def jsonParse(text) {
        return new groovy.json.JsonSlurperClassic().parseText(text);
}
