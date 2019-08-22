pipeline {
  agent any
  stages {
    stage('build'){
        steps {
            git 'https://github.com/zzia073/basespringboot.git'
            withEnv(["PATH+MAVEN=${tool 'm3'}/bin"]) {
               sh 'cd springboot01 && mvn -B -Dmaven.test.failure.ignore=true clean package'
            }
            stash excludes: 'target/', includes:'**', name:'source'
        }
    }
    stage('deploy'){
        steps {
            unstash 'source'
            sh 'java -jar springboot01/target/springboot01-1.0-SNAPSHOT.jar'
        }
    }
  }
}