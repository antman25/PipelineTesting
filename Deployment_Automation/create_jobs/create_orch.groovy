#!/usr/bin/env groovy
import groovy.json.JsonSlurper
import jenkins.*
import jenkins.model.*
import hudson.*
import hudson.model.*
import jenkins.model.Jenkins
import hudson.model.User
import hudson.security.Permission
import hudson.EnvVars

def project = 'antman25/PipelineTesting'
def branchApi = new URL("https://api.github.com/repos/${project}/branches")
def branches = new groovy.json.JsonSlurper().parse(branchApi.newReader())


folder('/DeploymentAutomation') {
    displayName('DeploymentAutomation')
    description('Deployment Automation - Desc')
}


folder('/DeploymentAutomation/OrchJobs') {
    displayName('OrchJobs')
    description('OrchJobs')
}


pipelineJob("/Deployment Automation/OrchJobs/OrchJob1") 
{
	def repo = 'https://github.com/antman25/PipelineTesting.git'
	description("Pipeline for $repo")
	definition 
	{
		cpsScm 
		{
			scm 
			{
				git 
				{
					remote 
					{ 
						url(repo)
						credentials('MyGit')
					}
					branch('master')
					scriptPath('BogusJenkinsFile')
					extensions { }  // required as otherwise it may try to tag the repo, which you may not want
				}
			}
		}
	}
}
					

