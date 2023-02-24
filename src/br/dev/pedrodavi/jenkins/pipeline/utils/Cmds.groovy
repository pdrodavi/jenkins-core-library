package br.dev.pedrodavi.jenkins.pipeline.utils

class Cmds {

    static void runSh(String command) {
        sh command.toString()
    }

    static void runPrint(String text) {
        echo text.toString()
    }

}
