pipeline {
  agent none
  stages {
    stage('build'){
        node {
            git 'https://github.com/zzia073/basespringboot.git'
            withEnv(["PATH+MAVEN=${tool 'm3'}/bin"]) {
               sh 'mvn -B -Dmaven.test.failure.ignore=true clean package'
            }
            stash excludes: 'target/', includes:'**', name:'source'
        }
    }
    stage('deploy'){
        node{
            unstash 'source'
            withEnv(["PATH+MAVEN=${tool 'm3'}/bin"]) {
                sh 'mvn cargo:deploy'
            }
        }
    }
  }
}