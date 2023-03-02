#!/usr/bin/groovy
import com.cloudbees.groovy.cps.NonCPS
import groovy.json.JsonSlurperClassic

def call(url) {
    // evaluate the body block, and collect configuration into the object
    //def config = [:]
    //body.resolveStrategy = Closure.DELEGATE_FIRST
    //body.delegate = config
    //body()

    if (url == null) {
        error "No URL found"
    }

    retry(3) {
        return getResult(url)
    }
}

@NonCPS
//def getResult(url, authString) {
def getResult(url) {
    echo "${url}"
    HttpURLConnection connection = url.openConnection()
    /*
    if (authString != null && authString.length() > 0) {
        connection.setRequestProperty("Authorization", "Bearer ${authString}")
    }*/
    connection.setRequestMethod("GET")
    connection.setDoInput(true)
    def rs = null
    try {
        connection.connect()
        rs = new JsonSlurperClassic().parse(new InputStreamReader(connection.getInputStream(), "UTF-8"))
    } finally {
        connection.disconnect()
    }
    echo 'returning'
    return rs
}
