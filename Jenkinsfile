pipeline {
  agent any
  stages {
    stage('build'){
        steps {
            git 'https://github.com/zzia073/basespringboot.git'
            sh 'cd springboot01'
            withEnv(["PATH+MAVEN=${tool 'm3'}/bin"]) {
               sh 'mvn -B -Dmaven.test.failure.ignore=true clean package'
            }
            stash excludes: 'target/', includes:'**', name:'source'
        }
    }
    stage('deploy'){
        steps {
            unstash 'source'
            withEnv(["PATH+MAVEN=${tool 'm3'}/bin"]) {
                sh 'mvn cargo:deploy'
            }
        }
    }
  }
}