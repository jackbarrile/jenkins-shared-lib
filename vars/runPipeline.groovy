def call(final steps){
    def node = 'nodename' // replace this with the node name required, with the input method required
    def yamlLocation = '' // replace this with the yaml Map name and location, if required
    def yamlMap = [:] // for complex deployments, a yaml file may be considered

    steps.node("${node}") {
        stage('Checkout') {
            deleteDir()
            checkout scm // does a checkout on the current branch, which is automatically determined if using Multibranch pipeline
        }

        yamlMap = readYaml file: "${yamlLocation}"

        /*
            Some useful functions to grab ahead of time (needs a node, but not a stage):
                def pom = readMavenPom file: 'pom.xml' // for Maven builds
                def pomVersion = pom.version
                def pomGroupId = pom.groupId
                def pomArtifactId = pom.artifactId

                def workspace = pwd()
                def isUnix = isUnix()
         */
    }

    new PipelineRunner(yamlMap, this).runDefaultPipeline()

}