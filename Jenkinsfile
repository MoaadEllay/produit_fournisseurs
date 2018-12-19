pipeline {
    agent any
    tools {
        maven 'apache-maven-3.5.4'
        jdk 'jdk1.8.0_161'
    }
    stages {
        stage('perf') {
  steps {
    sh 'python bztx.py ./taurus/scenario.yml'
    perfReport configType: 'PRT', graphType: 'PRT', ignoreFailedBuilds: true, modePerformancePerTestCase: true, modeThroughput: true, sourceDataFiles: 'results.xml'
    dir ("taurus/results") {
      gatlingArchive()
    }
  }
}
        
		
    }
}
