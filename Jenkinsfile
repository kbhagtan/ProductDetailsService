pipeline {
    agent any

    stages {
        stage ('Package Stage') {

            steps {
                withMaven(maven : 'Maven6') {
                    sh 'mvn clean package'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'Maven6') {
                    sh 'mvn test'
                }
            }
        }
		}
		}
