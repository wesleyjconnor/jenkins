def makeMultiBranchPipeline(def appname, def gitUrl) {

    multibranchPipelineJob(appname) {

        branchSources {
            git {
                remote("gitUrl)
                credentialsId('my-id')
            }
        }
        triggers {
            cron('H/2 * * * *')
        }
    }
}
