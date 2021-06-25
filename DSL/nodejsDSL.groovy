job('Aplicacion Node.js DSL') {
    description('Aplicación Node JS DSL para el curso de Jenkins')
    scm {
        git('https://github.com/aulikes/nodejsapp.git', 'master') { node ->
            node / gitConfigName('macloujulian')
            node / gitConfigEmail('macloujulian@gmail.com')
        }
    }
    triggers {
        scm('H/7 * * * *')
    }
    wrappers {
        nodejs('nodejs16.3_jenkins')
    }
    steps {
        shell("npm install")
    }
    publishers {
	    mailer('aulikes@hotmail.com', false, true)
        }
    }
}
