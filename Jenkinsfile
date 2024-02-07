pipeline 
{
    agent any
    
    tools{
    	maven 'Maven'
        }

    stages 
    {
        stage('Build') 
        {
            steps
            {
                 echo("Build Deployed")
            }
           
        }
        
          
        stage("Deploy to QA"){
            steps{
                echo("Build deployed to QA")
            }
        }
        
                
        stage('Regression Automation Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/VVenkatesh527/Orange_HRM_Test_Automatiom_Framework'
                    bat "mvn clean test -Dsurefire.suiteXmlFiles=src/main/resources/testng.xml"
                    
                }
            }
        }
        
        
        stage('Publish Extent Report'){
            steps{
                     publishHTML([allowMissing: false,
                                  alwaysLinkToLastBuild: false, 
                                  keepAll: true, 
                                  reportDir: 'Reports', 
                                  reportFiles: 'AutomationExtentReport.html', 
                                  reportName: 'HTML Extent Report', 
                                  reportTitles: ''])
            }
        }
        
        
        
        
    }
}