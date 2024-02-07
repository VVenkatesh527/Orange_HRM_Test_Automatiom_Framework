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
    
        stage('Regression Automation Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                
                    git 'https://github.com/VVenkatesh527/Orange_HRM_Test_Automatiom_Framework'
                    bat 'mvn install'
                  }
            }
        }



    }
}