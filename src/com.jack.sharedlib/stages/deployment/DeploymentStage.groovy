package com.jack.sharedlib.stages.deployment

class DeploymentStage implements Stage {

    DeploymentStage(final stageName) {
        this.stageName = stageName
    }

    @Override
    void execute() {
        // deployment script goes here
    }

}