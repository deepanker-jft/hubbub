package com.grailsaction



class DailyDigestJob {
    static triggers = {
      simple repeatInterval: 5000l // execute job once in 5 seconds
    }

    def execute() {
        println("Hello ")
    }
}
