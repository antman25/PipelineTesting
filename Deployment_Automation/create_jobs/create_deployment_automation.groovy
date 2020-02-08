#!/usr/bin/env groovy

def project = 'antman25/PipelineTesting'
def branchApi = new URL("https://api.github.com/repos/${project}/branches")
def branches = new groovy.json.JsonSlurper().parse(branchApi.newReader())


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