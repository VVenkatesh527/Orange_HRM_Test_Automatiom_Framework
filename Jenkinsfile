pipeline
{
    agent any

    tools{
    	maven 'Maven'
        }

    stages
    {

       stage("Deploy to QA"){
            steps{
                echo("deploy to qa")
            }
        }
    stage ('Git Checkout') {
       steps {
         git branch: 'main', url: 'https://github.com/VVenkatesh527/Orange_HRM_Test_Automatiom_Framework'
      }
    }
        stage('Regression Automation Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/VVenkatesh527/Orange_HRM_Test_Automatiom_Framework'
                    sh 'mvn -D clean test'
                }
            }
        }



    }
}