package com.example.experiments.designpattern.facade

class HomeTheaterFacade(
    private val tuner: Tuner,
    private val projector: Projector,
    private val screen: Screen
) {
    fun startTheaterSystem() {
        tuner.startTuner()
        projector.startProjector()
        screen.startScreen()
    }
}