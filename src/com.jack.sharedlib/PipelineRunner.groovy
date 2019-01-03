package com.jack.sharedlib

class PipelineRunner implements Serializable {

    private final steps
    private final yamlMap
    private List<Stage> stages

    PipelineRunner(final yamlMap, final steps){
        this.steps = steps
        this.yamlMap = yamlMap
    }

    void runDefaultPipeline() {
        buildDefaultPipeline()

        for(Stage it : stages){
            it.execute()
        }
    }

    private void buildDefaultPipeline() {
        stages.add(new BuildStage("Build"))
        stages.add(new DeploymenStage("Deploy"))
    }

}