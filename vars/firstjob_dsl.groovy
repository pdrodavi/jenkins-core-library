import jenkins.model.Jenkins

def call() {
    script_approval = Jenkins.instance.getExtensionList('org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval')[0]
    system_creds = Jenkins.instance.getExtensionList("com.cloudbees.plugins.credentials.SystemCredentialsProvider")[0]

    println 'Generating jobs for ' + 'eu-project' + " project."

    evaluate(tryReadFile('jobs/create_folder.groovy'))

    println "Creating project job-dsl"

//populate project description from GitHub
    job_description = 'test'['description']
    default_generator = null

    jenkinsJobMultibranchPipeline(['.jervis.yml', '.travis.yml'])
}