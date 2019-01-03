package com.jack.sharedlib.stages.build

class BuildStage implements Stage {

    private final stageName

    BuildStage(final stageName) {
        this.stageName = stageName
    }

    @Override
    void execute() {
        // build script goes here
    }

}