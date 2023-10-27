String cron_string = BRANCH_NAME == "master" ? "@daily" : ""

pipeline {
    agent {
        kubernetes {
            label 'azure-iac'
            containerTemplate {
                name 'maven-chrome'
                image 'markhobson/maven-chrome:jdk-11'
		imagePullPolicy 'Always'
                ttyEnabled true
                command 'cat'
            }
        }
    }
	  //triggers {
     //   	cron('0 0 * * *')
      //   	pollSCM('30 0 * * *')
     	//	}
    stages {
        stage('Run Serenity Tests') {
            steps {
                container('maven-chrome') {
	            //sh "sleep 7200"
                    //sh "mvn clean verify"
		    //sh "mvn clean verify -Dwebdriver.chrome.driver=/path/to/driver"
		    //sh "mvn -B -e -q clean verify"
		    //sh "mvn clean verify -pl regression -DskipCuke=false"
		      sh "mvn clean verify"
                }
            }
        }
      }
    post {
        always {
            container('maven-chrome') {
                  publishHTML (target: [
                      	   reportName : 'My Reports',
			                     reportTitles: 'The Report',
             		           reportDir:   'target/site/serenity',
        		               reportFiles: 'index.html',
        		               keepAll:     true,
        		               alwaysLinkToLastBuild: true,
        		                 allowMissing: false
                    ])
            }
        }
    }
}
