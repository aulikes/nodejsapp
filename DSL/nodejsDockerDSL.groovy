job('Aplicacion Node.js DSL Docker') {
    description('Aplicación Node JS Docker DSL para el curso de Jenkins')
    scm {
        git('https://github.com/aulikes/nodejsapp.git', 'master') { node ->
            node / gitConfigName('aulikes')
            node / gitConfigEmail('aulikes@hotmail.com')
        }
    }
    triggers {
        scm('H/7 * * * *')
    }
    wrappers {
        nodejs('nodejs16.3_jenkins')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('aulikes/nodejsapp_dsl')
            tag('${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
